/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse (or a modified version of Eclipse or an Eclipse plugin or 
 * an Eclipse library), containing parts covered by the terms of the 
 * Eclipse Public License (EPL), the licensors of this Program grant you 
 * additional permission to convey the resulting work.  Corresponding Source 
 * for a non-source form of such a combination shall include the source code 
 * for the parts of Eclipse libraries used as well as that of the  covered work.
 * 
 */
package turnus.analysis.partitioning.tabusearch.tuning;

import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.TABU_P;
import static turnus.common.TurnusOptions.TABU_SEED;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.analysis.partitioning.tabusearch.generators.TabuSearchMovesGenerator;
import turnus.analysis.partitioning.tabusearch.generators.TabuSearchMovesGenerator.GenericMove;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class TabuSearchPTuningPortioned extends Analysis<Double> {
	
	private TraceProject project;
	private SimEngine simulation;
	
	private TabuSearchMovesGenerator movesGenerator;
	
	Random uniform, random;
	
	public static final int DEFAULT_SEED = (int)System.currentTimeMillis();
	public static final int DEFAULT_ANALYSIS_TIME = 20;
	public static final double DEFAULT_P = 0.5;
	public static final int DEFAULT_REINSERT_NUMBER = 1; // number of moves inserted into one solution
	
	private int units;
	private int seed;
	
	private long analysisTime;
	private long startTime;
	
	NetworkPartitioning sCurrent = null; // current solution
	NetworkPartitioning sCand = null; // candidate neighbor solution
	NetworkPartitioning sNeighbor = null; // best candidate neighbor solution
	NetworkPartitioning sStar = null; // best ever visited solution with value fStar
	double fStar; // the best ever value of objective function
	double p; // percentage of the explored neighborhood (parameter in interval [0.1])
	
	private ActorStatisticsCollector analysisCollector;
	private ActorStatisticsCollector backupCollector;
	
	int iteration, emptyIteration;
	
	public TabuSearchPTuningPortioned(TraceProject tProject, TraceWeighter tWeighter, BufferSize bufferSize) {
		super(tProject);
		this.project = tProject;
		
		simulation = new SimEngine();
		simulation.setTraceProject(tProject);
		simulation.setTraceWeighter(tWeighter);
		simulation.setBufferSize(bufferSize);
	}
	
	public void loadPartitioning(NetworkPartitioning partitioning) {
		sCurrent = partitioning;
	}
	
	public void setGenerator(TabuSearchMovesGenerator generator) {
		movesGenerator = generator;
	}

	@Override
	public Double run() throws TurnusException {
		if (units == 1 || units == project.getNetwork().getActors().size())
			return null;
		
		seed = configuration.getValue(TABU_SEED, DEFAULT_SEED);
		uniform = new Random(seed);
		random = new Random(seed);
		
		analysisCollector = new ActorStatisticsCollector(project.getNetwork(), sCurrent);
		backupCollector = new ActorStatisticsCollector(project.getNetwork(), sCurrent);
		simulation.addDataCollector(analysisCollector);
		simulation.setNetworkPartitioning(sCurrent);
		
		fStar = simulation.run().getTime();	// save the initial configuration as the best so far
		sStar = sCurrent;
			
		movesGenerator.setConfiguration(configuration);
		movesGenerator.setActorStatisticsCollector(analysisCollector);
		movesGenerator.setupTabu(sCurrent);
		movesGenerator.init();
			
		p = configuration.getValue(TABU_P, DEFAULT_P);
		fStar = Double.MAX_VALUE;
		analysisTime = configuration.getValue(ANALYSIS_TIME, DEFAULT_ANALYSIS_TIME);
		startTime = System.currentTimeMillis(); // start time initialization
			
		iteration = 1;
		emptyIteration = 0;
		boolean iterationOk = true;
		// continue until the time limit is reached
		while (iterationOk) { 	
			iterationOk = ts(iteration++); // continue with the iteration as long as time limit is not reached
		}
			
		// run the final simulation (output)
		simulation.setNetworkPartitioning(sStar);
		simulation.addDataCollector(new ActorStatisticsCollector(project.getNetwork(), sStar));
		double executionTime = simulation.run().getTime(); 
			
		Logger.info("Iterations: " + iteration + ", empty iterations: " + emptyIteration);
		
		return executionTime;
	}
	
	private boolean ts(int iteration) {
		int ties = 1; // number of equivalent options
		boolean ccontinue = true; // if next solution should be generated
		double bestf = Double.MAX_VALUE; // best value of objective function among the solutions
		double fsCand;
		List<GenericMove> performedMoves = new ArrayList<GenericMove>();
		
		int movesApplied = DEFAULT_REINSERT_NUMBER; // number of moves applied in order to obtain one solution
		
		movesGenerator.generateMoves(sCurrent, iteration); // generate a list of non-tabu moves 
		
		Iterator<GenericMove> iterator = movesGenerator.getPossibleMovesIterator();
		
		if ((System.currentTimeMillis() - startTime) / 1000 / 60 >= analysisTime) {
			return false;  // break the algorithm if the time limit is violated
		} else if (!iterator.hasNext()) {  // check if there is at least 1 admissible solution
			emptyIteration++;						 // if not, perform an "empty" iteration
			return true;				  
		} else {
			while (ccontinue) {
				if (random() <= p) {
					List<GenericMove> moves = new ArrayList<GenericMove>();
					int i = 0;
					while (iterator.hasNext() && i < movesApplied) {
						moves.add(iterator.next());
						i++;
					}
					sCand = generateSolution(sCurrent, moves);
					fsCand = f(sCand);
					if (fsCand == bestf) {
						ties++;
						if (random() <= 1/ties) {
							sNeighbor = sCand;
							backupCollector = analysisCollector.clone();
							updatePerformedMoves(performedMoves, moves);
						}
					}
					if (fsCand < bestf) {
						sNeighbor = sCand;
						backupCollector = analysisCollector.clone();
						updatePerformedMoves(performedMoves, moves);
						bestf = fsCand;
						ties = 1;
					}
				}
				if ((System.currentTimeMillis() - startTime) / 1000 / 60 >= analysisTime) {
					if (bestf < fStar) {
						fStar = bestf;
						sStar = sNeighbor;
					}
					return false; 	// break the algorithm if the time rule is violated
				} else if (!iterator.hasNext()) { 
					ccontinue = false; // terminate the iteration if no more admissible solutions can be generated
				}	
			}
			
			if (bestf < fStar) {
				fStar = bestf;
				sStar = sNeighbor;
			}
			sCurrent = sNeighbor;
			analysisCollector = backupCollector;
			
			updateTabuStatus(performedMoves, iteration);
			
			return true;
		}
	}
	
	public NetworkPartitioning generateSolution(NetworkPartitioning startPartitioning, List<GenericMove> moves) {
		NetworkPartitioning newPartitioning = startPartitioning.clone();	
		for (GenericMove move : moves) {
			move.modifySolution(newPartitioning);
		}
		
		return newPartitioning;
	}
	
	public void updatePerformedMoves(List<GenericMove> performedMoves, List<GenericMove> moves) {
		performedMoves.clear();
		for (GenericMove move : moves)
			performedMoves.add(move);
	}
	
	private double random() {
		return random.nextDouble();
	}
	
	private double f(NetworkPartitioning solution) {
		simulation.setNetworkPartitioning(solution);
		try {
			return simulation.run().getTime();
		} catch (TurnusException e) {
			e.printStackTrace();
		}
		
		return Double.MAX_VALUE;
	}
	
	private void updateTabuStatus(List<GenericMove> performedMoves, int iteration) {
		for (GenericMove move : performedMoves) {
			int tab = uniform.nextInt(11) + 5; // integer number between 5 and 15
			movesGenerator.updateTabuList(move, iteration, tab);
		}
	}
	
	public NetworkPartitioning getSStar() {
		return sStar;
	}
	
}

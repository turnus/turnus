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
package turnus.analysis.partitioning.tabusearch.gpu;

import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.INITIAL_ALGORITHM;
import static turnus.common.TurnusOptions.TABU_P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.partitioning.tabusearch.TabuSearchAbstract;
import turnus.analysis.partitioning.tabusearch.gpu.generators.BalancingMovesGenerator;
import turnus.analysis.partitioning.tabusearch.gpu.generators.CommFreqMovesGenerator;
import turnus.analysis.partitioning.tabusearch.gpu.generators.IdleMovesGenerator;
import turnus.analysis.partitioning.tabusearch.gpu.generators.RandomMovesGenerator;
import turnus.analysis.partitioning.tabusearch.gpu.generators.TabuSearchMovesGenerator;
import turnus.analysis.partitioning.tabusearch.gpu.generators.TabuSearchMovesGenerator.GenericMove;
import turnus.analysis.partitioning.util.PartitioningGenerator;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

public class TabuSearchGPUPROB extends TabuSearchAbstract {
	
	private TraceProject project;
	private TraceWeighter weighter;
	private SimEngine simulation;
	
	private List<TabuSearchMovesGenerator> movesGenerators;
	private Map<TabuSearchMovesGenerator, Integer> counterImproved;
	private Map<TabuSearchMovesGenerator, Integer> counterTotal;
	
	public static final int DEFAULT_UNITS = 2;
	public static final int DEFAULT_ANALYSIS_TIME = 20;
	public static final double DEFAULT_P = 0.4;
	public static final int DEFAULT_REINSERT_NUMBER = 1; // number of moves inserted into one solution
	
	private long seed = System.currentTimeMillis();
	private Random uniform = new Random(seed);
	private Random random = new Random(seed);
	
	private int units;
	private int analysisTime;
	private long startTime;
	private long lastImprovementTime;
	
	private NetworkPartitioning sCurrent = null; // current solution
	private NetworkPartitioning sCand = null; // candidate neighbor solution
	private NetworkPartitioning sNeighbor = null; // best candidate neighbor solution
	private NetworkPartitioning sStar = null; // best ever visited solution with value fStar
	private double fStar = Double.MAX_VALUE; // the best every value of objective function
	private double p; // percentage of the explored neighborhood (parameter in interval [0.1])
	
	private ActorStatisticsCollector analysisCollector;
	private ActorStatisticsCollector backupCollector;
	
	private int iteration, emptyIteration;
	
	private Set<Actor> CPUOnly;
	
	public TabuSearchGPUPROB(TraceProject tProject, TraceWeighter tWeighter, String simulator) {
		super(tProject);
		this.project = tProject;
		this.weighter = tWeighter;
		this.CPUOnly = new HashSet<Actor>();

		movesGenerators = new ArrayList<TabuSearchMovesGenerator>();
		counterImproved = new HashMap<TabuSearchMovesGenerator, Integer>();
		counterTotal = new HashMap<TabuSearchMovesGenerator, Integer>();
		
		// initial values 1 and 4 provide equal probability (25%) to all if no history of search is available yet
		int generatorNb = 2;
		if (!simulator.equals("MEASURED")) {
			generatorNb = 4;

			IdleMovesGenerator idleGenerator = new IdleMovesGenerator(project, CPUOnly);
			//IdleMovesGenerator idleGenerator = new IdleMovesGenerator(project, 0.9);
			movesGenerators.add(idleGenerator);
			counterImproved.put(idleGenerator, 1);
			counterTotal.put(idleGenerator, generatorNb);

			BalancingMovesGenerator bGenerator = new BalancingMovesGenerator(project, CPUOnly);
			//BalancingMovesGenerator bGenerator = new BalancingMovesGenerator(project, 0.08);
			movesGenerators.add(bGenerator);
			counterImproved.put(bGenerator, 1);
			counterTotal.put(bGenerator, generatorNb);
		} 

		RandomMovesGenerator randomGenerator = new RandomMovesGenerator(project, CPUOnly);
		//RandomMovesGenerator randomGenerator = new RandomMovesGenerator(project, 0.16);
		movesGenerators.add(randomGenerator);
		counterImproved.put(randomGenerator, 1);
		counterTotal.put(randomGenerator, generatorNb);

		CommFreqMovesGenerator cfGenerator = new CommFreqMovesGenerator(project, CPUOnly);
		//CommFreqMovesGenerator cfGenerator = new CommFreqMovesGenerator(project, 0.48);
		movesGenerators.add(cfGenerator);
		counterImproved.put(cfGenerator, 1);
		counterTotal.put(cfGenerator, generatorNb);
	}

	public void setSimulation(SimEngine simulation) {
		this.simulation = simulation;
	}

	public NetworkPartitioning getFinalPartition() {
		return sStar;
	}

	public void generateInitialPartitioning(String scheduling) {
		PartitioningGenerator partitioningGenerator = new PartitioningGenerator(project, weighter);
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		if (!configuration.hasValue(INITIAL_ALGORITHM)) {
			sCurrent = partitioningGenerator.generateRandomSolution(configuration);
			Logger.warning("No initial partitioning algorithm specified, random configuration is generated.");
		} else {
			String algorithm = configuration.getValue(INITIAL_ALGORITHM);
			sCurrent = partitioningGenerator.generateSolution(configuration, algorithm);
		}
		
		sCurrent.setSchedulerToAll(scheduling);
		generateCPUOnly();
	}
	
	public void loadPartitioning(NetworkPartitioning partitioning) {
		sCurrent = partitioning;
		generateCPUOnly();
	}
	
	private void generateCPUOnly() {
		Network network = project.getNetwork();

		Map<String, List<String>> pActors = sCurrent.asPartitionActorsMap();
		if (pActors.containsKey("PG")) {
			Set<String> GPUNames = new HashSet<String>(pActors.get("PG"));
			for (Actor actor : network.getActors()) {
				if (! GPUNames.contains(actor.getName())) {
					CPUOnly.add(actor);
				}
			}
		}
	}

	@Override
	public ActorStatisticsReport run() throws TurnusException {
		if (units == 1 || units == project.getNetwork().getActors().size())
			return null;
		
		analysisCollector = new ActorStatisticsCollector(project.getNetwork(), sCurrent);
		backupCollector = new ActorStatisticsCollector(project.getNetwork(), sCurrent);
		simulation.addDataCollector(analysisCollector);
		simulation.setNetworkPartitioning(sCurrent);
		
		fStar = simulation.run().getTime();	// save the initial configuration as the best so far
		sStar = sCurrent;
	
		p = configuration.getValue(TABU_P, DEFAULT_P);
		analysisTime = configuration.getValue(ANALYSIS_TIME, DEFAULT_ANALYSIS_TIME);
		startTime = System.currentTimeMillis(); // start time initialization
		for (TabuSearchMovesGenerator generator : movesGenerators) {
			generator.setConfiguration(configuration);
			generator.setActorStatisticsCollector(analysisCollector);
			generator.setupTabu(sCurrent);
			generator.init();
		}
		
		iteration = 1;
		emptyIteration = 0;
		improvedOverall = false;
		
		boolean iterationOk = true;
		while (iterationOk) { 	// continue until the time limit is reached
			iterationOk = ts(iteration++); // a single tabu search iteration
		}
		
		// run the final simulation (output)
		simulation.setNetworkPartitioning(sStar);
		simulation.getDataCollector().clear();
		simulation.addDataCollector(new ActorStatisticsCollector(project.getNetwork(), sStar));
		PostProcessingReport endReport = simulation.run(); 
		
		Logger.info("Tabu search - total number of iterations: " + iteration + ", empty iterations: " + emptyIteration);
		if (!improvedOverall) {
			Logger.info("No improvement found, initial configuration returned");
		}
		else {
			Logger.info("Last improvement made after " + (lastImprovementTime - startTime) / 1000 / 60 + " minutes");
		}
		
		return endReport.getReport(ActorStatisticsReport.class);
	}
	
	private boolean ts(int iteration) {
		int ties = 1; // number of equivalent options
		boolean ccontinue = true; // if next solution should be generated
		double bestf = Double.MAX_VALUE; // best value of objective function among the solutions
		double fsCand;
		List<GenericMove> performedMoves = new ArrayList<GenericMove>();

		int movesApplied = DEFAULT_REINSERT_NUMBER; // number of moves applied in order to obtain one solution
		
		TabuSearchMovesGenerator chosenGenerator = chooseGenerator();
		chosenGenerator.generateMoves(sCurrent, iteration);
		
		Iterator<GenericMove> iterator = chosenGenerator.getPossibleMovesIterator();
		
		boolean improvedInIteration = false;
		
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
						improvedOverall = true;
						improvedInIteration = true;
						lastImprovementTime = System.currentTimeMillis();
					}
					return false; 	// break the algorithm if the time rule is violated
				} else if (!iterator.hasNext()) { 
					ccontinue = false; // terminate the iteration if no more admissible solutions can be generated
				}	
			}
			
			if (bestf < fStar) {
				fStar = bestf;
				sStar = sNeighbor;
				improvedOverall = true;
				improvedInIteration = true;
				lastImprovementTime = System.currentTimeMillis();
			}
			sCurrent = sNeighbor;
			analysisCollector = backupCollector;
			
			updateTabuStatus(performedMoves, iteration);
			
			counterTotal.put(chosenGenerator, counterTotal.get(chosenGenerator) + 1); // increase the total counter of a chosen generator
			if (improvedInIteration) {
				counterImproved.put(chosenGenerator, counterImproved.get(chosenGenerator) + 1); // increase the counter of improvements of a chosen generator
			}
			
			return true;
		}
	}
	
	private TabuSearchMovesGenerator chooseGenerator() {
		double sum = 0;
		for (TabuSearchMovesGenerator generator : movesGenerators) {
			sum += (double)counterImproved.get(generator) / (double)counterTotal.get(generator);
		}
		
		Random random = new Random(System.currentTimeMillis());
		double value = random.nextDouble() * sum;
		double tmp = 0;
		for (TabuSearchMovesGenerator generator : movesGenerators) {
			tmp += (double)counterImproved.get(generator) / (double)counterTotal.get(generator);
			if (value < tmp)
				return generator;
		}
		
		return movesGenerators.get(0);
	}
	
	private NetworkPartitioning generateSolution(NetworkPartitioning startPartitioning, List<GenericMove> moves) {
		NetworkPartitioning newPartitioning = startPartitioning.clone();	
		for (GenericMove move : moves) {
			move.modifySolution(newPartitioning);
		}
		
		return newPartitioning;
	}
	
	private void updatePerformedMoves(List<GenericMove> performedMoves, List<GenericMove> moves) {
		performedMoves.clear();
		for (GenericMove move : moves)
			performedMoves.add(move);
	}
	
	private double random() {
		return random.nextDouble();
	}
	
	private double f(NetworkPartitioning solution) {
		analysisCollector = new ActorStatisticsCollector(project.getNetwork(), solution);
		for (TabuSearchMovesGenerator generator : movesGenerators) {
			generator.setActorStatisticsCollector(analysisCollector);
		}
		simulation.getDataCollector().clear();
		simulation.addDataCollector(analysisCollector);
		simulation.setNetworkPartitioning(solution);
		try {
			return simulation.run().getTime();
		} catch (TurnusException e) {
			e.printStackTrace();
		}
		
		return Double.MAX_VALUE;
	}
	
	private void updateTabuStatus(List<GenericMove> performedMoves, int iteration) {
		for (TabuSearchMovesGenerator generator : movesGenerators) {
			for (GenericMove move : performedMoves) {
				int tab = uniform.nextInt(11) + 5; // integer number between 5 and 15
				generator.updateTabuList(move, iteration, tab);
			}
		}
	}
	
}

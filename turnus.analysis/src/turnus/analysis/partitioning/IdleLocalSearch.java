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
package turnus.analysis.partitioning;

import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.INITIAL_ALGORITHM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.analysis.partitioning.util.PartitioningGenerator;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class IdleLocalSearch extends Analysis<ActorStatisticsReport> {

	private TraceWeighter weighter;
	
	private NetworkPartitioning currentPartitioning;
	private NetworkPartitioning bestPartitioning;
	private double executionTime;
	private double bestExecutionTime;
	
	private SimEngine simulation;
	private ActorStatisticsCollector actorStatsCollector = null;
	
	public static final int DEFAULT_ANALYSIS_TIME = 20;
	private int analysisTime;
	private long startTime;
	private long lastImprovementTime;
	private boolean improvedOverall;

	public IdleLocalSearch(TraceProject tProject, TraceWeighter tWeighter, CommunicationWeight commWeight, SchedulingWeight schedWeight, BufferSize bufferSize, boolean release) {
		super(tProject);
		
		this.weighter = tWeighter;

		simulation = new SimEngine();
		simulation.setTraceProject(tProject);
		simulation.setTraceWeighter(tWeighter);
		simulation.setBufferSize(bufferSize);
		simulation.setCommunicationWeight(commWeight);
		simulation.setSchedulingWeight(schedWeight);
		if (release)
			simulation.setReleaseAfterProcessing();
		
		bestExecutionTime = Double.MAX_VALUE;
	}
	
	public void generateInitialPartitioning(String scheduling) {
		PartitioningGenerator partitioningGenerator = new PartitioningGenerator(project, weighter);
		if (!configuration.hasValue(INITIAL_ALGORITHM)) {
			currentPartitioning = partitioningGenerator.generateRandomSolution(configuration); // random solution if not specified
		} else {
			String algorithm = configuration.getValue(INITIAL_ALGORITHM);
			currentPartitioning = partitioningGenerator.generateSolution(configuration, algorithm);
		}
		
		currentPartitioning.setSchedulerToAll(scheduling);
	}
	
	public void regenerateInitialPartitioning(Map<String, String> scheduling) {
		PartitioningGenerator partitioningGenerator = new PartitioningGenerator(project, weighter);
		currentPartitioning = partitioningGenerator.generateRandomSolution(configuration); // random solution
		
		Iterator<String> schedulingStrategies = scheduling.values().iterator();
		for (String partition : currentPartitioning.asPartitionActorsMap().keySet()) {
			currentPartitioning.setScheduler(partition, schedulingStrategies.next());
		}
	}
	
	public void loadPartitioning(NetworkPartitioning partitioning) {
		this.currentPartitioning = partitioning;
	}

	@Override
	public ActorStatisticsReport run() throws TurnusException {
		int unitsNumber = currentPartitioning.asPartitionActorsMap().keySet().size();
		int actorsNumber = currentPartitioning.asActorPartitionMap().keySet().size();
		
		analysisTime = configuration.getValue(ANALYSIS_TIME, DEFAULT_ANALYSIS_TIME);

		if (unitsNumber == 1 || unitsNumber == actorsNumber)
			return null;
		
		actorStatsCollector = new ActorStatisticsCollector(project.getNetwork(), currentPartitioning);
		simulation.addDataCollector(actorStatsCollector);

		startTime = System.currentTimeMillis();
		bestPartitioning = currentPartitioning.clone();
		do {
			simulation.setNetworkPartitioning(currentPartitioning);
			localSearch();
			if (executionTime < bestExecutionTime) {
				bestExecutionTime = executionTime;
				bestPartitioning = currentPartitioning.clone();
				lastImprovementTime = System.currentTimeMillis();
				improvedOverall = true;
			}
			regenerateInitialPartitioning(currentPartitioning.asPartitionSchedulerMap());
		}
		while ((System.currentTimeMillis() - startTime) / 1000 / 60 < analysisTime);
		
		// run the final simulation and save the best solution
		simulation.setNetworkPartitioning(bestPartitioning);
		PostProcessingReport report = simulation.run(); 
		
		if (!improvedOverall) {
			Logger.info("No improvement found, initial configuration returned");
		}
		else {
			Logger.info("Last improvement made after " + (lastImprovementTime - startTime) / 1000 / 60 + " minutes");
		}
		
		return report.getReport(ActorStatisticsReport.class);
	}
	
	private void localSearch() throws TurnusException {
		// array to store  forbidden moves
		Map<String, List<String>> tabuList = new HashMap<String, List<String>>(); 
		for (String actor : currentPartitioning.asActorPartitionMap().keySet())
			tabuList.put(actor, new ArrayList<String>());
	
		// run simulation with PostProcessing (ActorData) Collector
		executionTime = simulation.run().getTime(); 
	
		// retrieve partitions idle times
		Map<String, Double> partitionIdleTimes = actorStatsCollector.getPartitionIdleTimes(executionTime); 
		boolean correctMoveFound = false;
		Map<String, Double> idleTimes = actorStatsCollector.getIdleTimes();
		// sort actors by idle time (descending)
		List<String> actorsSortedByIdleTime = sortDescendingByIdleTime(idleTimes); 
		for (String actor : actorsSortedByIdleTime) {
			if ((System.currentTimeMillis() - startTime) / 1000 / 60 >= analysisTime)
				break;
			if (idleTimes.get(actor) != 0) {
				String mostIdlePartition = null;
				double idleTime = 0;
				for (Entry<String, Double> partition : partitionIdleTimes.entrySet()) {
					// partition different than the current one and the most idle partition
					if (!partition.getKey().equals(currentPartitioning.getPartition(actor)) 
						&& partition.getValue() > idleTime && !tabuList.get(actor).contains(partition.getKey())) {  // not a tabu actor-partition pair
							idleTime = partition.getValue();
							mostIdlePartition = partition.getKey();
					}
				}
				if (mostIdlePartition != null) {
					// move the actor to the new partition
					String sourcePartition = currentPartitioning.getPartition(actor); 
					currentPartitioning.setPartition(actor, mostIdlePartition);

					Logger.debug("Chosen move: " + actor + " from " + sourcePartition + " to " + mostIdlePartition + ".");
					// run the simulation on the updated partitioning
					double newExecutionTime = simulation.run().getTime();
					if (newExecutionTime < executionTime) {
						Logger.debug("Move correct: " + actor + " from " + sourcePartition + " to " + mostIdlePartition + ".");
						correctMoveFound = true;	
						executionTime = newExecutionTime;
						// release all moves were sourcePartition was the target
						for (List<String> tabuForActor : tabuList.values()) { 
							tabuForActor.remove(sourcePartition);
						}
						// prevent reversing the move
						tabuList.get(actor).add(sourcePartition); 
							break;
					} else {
						Logger.debug("Move incorrect: " + actor + " from " + sourcePartition + " to " + mostIdlePartition + ".");
						// undo the move
						currentPartitioning.setPartition(actor, sourcePartition);
						// store unsuccessful move
						tabuList.get(actor).add(mostIdlePartition); 
					}
				}
			}
		}
						
		if (!correctMoveFound) {
			return;
		}
	}

	private List<String> sortDescendingByIdleTime(Map<String, Double> idleTimes) {
		final Map<String, Double> unsortedIdleTimes = idleTimes;
		List<String> sortedActors = new ArrayList<String>(unsortedIdleTimes.keySet());
		Collections.sort(sortedActors, new Comparator<String>() {
			@Override
			public int compare(String a1, String a2) {
				return unsortedIdleTimes.get(a2).compareTo(unsortedIdleTimes.get(a1));
			}
		});
		return sortedActors;
	}
}

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
import static turnus.common.TurnusOptions.USE_SIMULATION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.analysis.partitioning.util.PartitioningGenerator;
import turnus.analysis.profiling.IntraActionCommunicationAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class CommFreqLocalSearch extends Analysis<ActorStatisticsReport> {

	private NetworkPartitioning bestPartitioning;
	private NetworkPartitioning currentPartitioning;	
	private double objectiveFunctionBest; // useSimulation -> execution time, otherwise -> interPartitionFrequency
	private double objectiveFunctionLocal;
	
	private Network network;
	private TraceWeighter weighter;
	
	private IntraActionCommunicationAnalysis communicationAnalysis;
	private SimEngine simulation;
	private ActorStatisticsCollector actorStatsCollector; 
	
	public static final int DEFAULT_ANALYSIS_TIME = 20;
	public static final int DEFAULT_UNITS = 2;
	
	private int analysisTime;
	private long startTime;
	private boolean useEstimation;
	private long lastImprovementTime;
	private boolean improvedOverall;
	
	private Map<Actor, Map<String, Long>> possibleMoves;
	private Map<Actor, Map<Actor, Long>> communicationFrequency;
	private Map<Actor, Map<String, Long>> partitionCommunicationFrequency;
	private Map<Actor, Double> actorWorkloads;
	
	public CommFreqLocalSearch(TraceProject tProject, TraceWeighter tWeighter, CommunicationWeight commWeight, SchedulingWeight schedWeight, BufferSize bufferSize, boolean release) {
		super(tProject);
		this.network = tProject.getNetwork();
		this.weighter = tWeighter;
	
		simulation = new SimEngine();
		simulation.setTraceProject(tProject);
		simulation.setTraceWeighter(tWeighter);
		simulation.setBufferSize(bufferSize);
		simulation.setCommunicationWeight(commWeight);
		simulation.setSchedulingWeight(schedWeight);
		if (release)
			simulation.setReleaseAfterProcessing();
		
		this.communicationAnalysis = new IntraActionCommunicationAnalysis(tProject);
		
		communicationFrequency = new HashMap<Actor, Map<Actor, Long>>();
		partitionCommunicationFrequency = new HashMap<Actor, Map<String, Long>>();
		
		for (Actor actor1 : network.getActors()) {
			communicationFrequency.put(actor1, new HashMap<Actor, Long>());
			for (Actor actor2 : network.getActors()) {
				communicationFrequency.get(actor1).put(actor2, (long) 0);
			}
		}
		
		objectiveFunctionBest = Double.MAX_VALUE;
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
		useEstimation = configuration.getValue(USE_SIMULATION);
		
		if (unitsNumber == 1 || unitsNumber == actorsNumber)
			return null;
		
		this.actorStatsCollector = new ActorStatisticsCollector(network, currentPartitioning);
		simulation.addDataCollector(actorStatsCollector);

		// launch the communication profiling analysis
		communicationAnalysis.setConfiguration(configuration);
		IntraActionCommunicationReport report = communicationAnalysis.run();
		
		// process the values so that the communication frequency is stored for both: producer and consumer
		for (IntraActorCommunicationData data : report.getActorsData()) {
			Actor actor1 = data.getActor();
			for (Actor actor2 : data.getTokensProducersMap().keySet()) {
				// preserving the oldV might be needed only if there's a feedback loop between the actors
				long oldV = communicationFrequency.get(actor1).get(actor2); 
				long newV = data.getTokensProducersMap().get(actor2).getSamples();
				communicationFrequency.get(actor1).put(actor2, oldV + newV);
				
				oldV = communicationFrequency.get(actor2).get(actor1); 
				communicationFrequency.get(actor2).put(actor1, oldV + newV);
			}
		}

		// calculate actor workloads
		actorWorkloads = calculateActorWorkloads();
		
		// initialize the values of objective function
		if (useEstimation) {
			calculateFrequencies();
			simulation.setNetworkPartitioning(currentPartitioning);
			objectiveFunctionLocal = simulation.run().getTime();
			objectiveFunctionBest = objectiveFunctionLocal;
		}
		else {
			calculateFrequencies();
			objectiveFunctionLocal = getInterPartitionFrequency(null, null);
			objectiveFunctionBest = objectiveFunctionLocal;
		}
		
		startTime = System.currentTimeMillis();
		bestPartitioning = currentPartitioning.clone(); // the very first configuration taken as best
		do {
			boolean movePerformed = localSearch();
			if (movePerformed && objectiveFunctionLocal < objectiveFunctionBest) {
				objectiveFunctionBest = objectiveFunctionLocal; // save the new solution if better than the overall best
				bestPartitioning = currentPartitioning.clone(); 
				lastImprovementTime = System.currentTimeMillis();
				improvedOverall = true;
			}
			else {
				Logger.info("Search restart (new random configuration generated");
				regenerateInitialPartitioning(currentPartitioning.asPartitionSchedulerMap());
				
				// initialize the values of objective function
				if (useEstimation) {
					simulation.setNetworkPartitioning(currentPartitioning);
					objectiveFunctionLocal = simulation.run().getTime();
				}
				else {
					calculateFrequencies();
					objectiveFunctionLocal = getInterPartitionFrequency(null, null);
				}
			}
		}
		while ((System.currentTimeMillis() - startTime) / 1000 / 60 < analysisTime);
		
		// run the final simulation
		simulation.setNetworkPartitioning(bestPartitioning);
		PostProcessingReport endReport = simulation.run();
		
		if (!improvedOverall) {
			Logger.info("No improvement found, initial configuration returned");
		}
		else {
			Logger.info("Last improvement made after " + (lastImprovementTime - startTime) / 1000 / 60 + " minutes");
		}
		
		return endReport.getReport(ActorStatisticsReport.class);
	}
	
	private Map<Actor, Double> calculateActorWorkloads() {
		Map<Actor, Double> workloads = new HashMap<Actor, Double>();
		
		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				sum += weighter.getWeight(next);
			}
			workloads.put(actor, sum);
		}
		
		return workloads;
	}
	
	private boolean localSearch() throws TurnusException {
		if (useEstimation) { // evaluate each possible move using the SimEngine
			for (Actor actor : possibleMoves.keySet()) {
				for (String component : possibleMoves.get(actor).keySet()) {
					if ((System.currentTimeMillis() - startTime) / 1000 / 60 >= analysisTime)
						break;
					// move the actor to the new partition
					String sourcePartition = currentPartitioning.getPartition(actor); 
					currentPartitioning.setPartition(actor, component);
					Logger.info("Chosen move: " + actor + " from " + sourcePartition + " to " + component + ".");
					 // run the simulation on the updated partitioning
					double newExecutionTime = simulation.run().getTime();
					if (newExecutionTime < objectiveFunctionLocal) {
						Logger.info("Move correct: " + actor + " from " + sourcePartition + " to " + component + ".");
						objectiveFunctionLocal = newExecutionTime;
						return true;
					} else {
						Logger.info("Move incorrect: " + actor + " from " + sourcePartition + " to " + component + ".");
						 // undo the move
						currentPartitioning.setPartition(actor, sourcePartition);
					}
				}
			}
		}
		else { // evaluate the possible moves using the average-to-deviation ratio
			// among the available moves choose the one with biggest avg/dev ratio
			double balance = 0; // avgOverDev(null, null); - originally it was: the one that improves avg/dev ratio
			Actor chosenActor = null;
			String chosenActorSource = null;
			String chosenComponent = null;
			for (Actor actor : possibleMoves.keySet()) {
				for (String component : possibleMoves.get(actor).keySet()) {
					if ((System.currentTimeMillis() - startTime) / 1000 / 60 >= analysisTime)
						break;
					if (getInterPartitionFrequency(actor, component) < objectiveFunctionLocal) {
						double newBalance = avgOverDev(actor, component);
						if (newBalance > balance) {
							balance = newBalance;
							chosenActor = actor;
							chosenActorSource = currentPartitioning.getPartition(actor);
							chosenComponent = component;
						}
					}
				}
			}
			
			// apply the move if an improving one has been found
			if (chosenActor != null) {
				Logger.info("Chosen move: " + chosenActor + " from " + chosenActorSource + " to " + chosenComponent + ". Balance: " + balance);
				currentPartitioning.setPartition(chosenActor, chosenComponent);
				bestPartitioning = currentPartitioning;
				return true;
			}
		}
		
		return false;
	}
	
	private void calculateFrequencies() {
		// create the actor-partition communication frequency map
		partitionCommunicationFrequency.clear();
		for (Actor actor1 : network.getActors()) {
			partitionCommunicationFrequency.put(actor1, new HashMap<String, Long>()); 
			for (String component : currentPartitioning.asPartitionActorsMap().keySet()) {
				partitionCommunicationFrequency.get(actor1).put(component, (long) 0);
			}
			for (Actor actor2 : network.getActors()) {
				if (!actor1.equals(actor2)) {
					String targetComponent = currentPartitioning.getPartition(actor2);
					long oldV = partitionCommunicationFrequency.get(actor1).get(targetComponent);
					partitionCommunicationFrequency.get(actor1).put(targetComponent, oldV + communicationFrequency.get(actor1).get(actor2));
				}
			}
		}
				
		// create a map of possible moves (if communication frequency with a certain partition is bigger than the current internal one)
		possibleMoves = new HashMap<Actor, Map<String, Long>>();
		for (Actor actor : partitionCommunicationFrequency.keySet()) {
			String currentActorComponent = currentPartitioning.getPartition(actor);
			if (currentPartitioning.asPartitionActorsMap().get(currentActorComponent).size() > 1) {
				possibleMoves.put(actor, new HashMap<String, Long>());
				long internFreq = partitionCommunicationFrequency.get(actor).get(currentActorComponent);
				for (String component : partitionCommunicationFrequency.get(actor).keySet()) {
					if (!component.equals(currentPartitioning.getPartition(actor))) {
						long externFreq = partitionCommunicationFrequency.get(actor).get(component);
						if (externFreq > internFreq)
							possibleMoves.get(actor).put(component, externFreq - internFreq);
					}
				}
			}
		}
	}
	
	private long getInterPartitionFrequency(Actor actor, String component) {
		String actorSourceComponent = null;
		if (actor != null) {
			actorSourceComponent = currentPartitioning.getPartition(actor);
			currentPartitioning.setPartition(actor, component);
		}
		
		long value = 0;
		for (Actor a : partitionCommunicationFrequency.keySet()) {
			for (Entry<String, Long> entry : partitionCommunicationFrequency.get(a).entrySet()) {
				if (!currentPartitioning.getPartition(a).equals(entry.getKey())) {
					value += entry.getValue();
				}
			}
		}
		
		if (actor != null) {
			currentPartitioning.setPartition(actor, actorSourceComponent);
		}
		
		value /= 2; // because counted twice for source and target
		
		return value;
	}
	
	private double avgOverDev(Actor actor, String component) {
		String actorSourceComponent = null;
		if (actor != null) {
			actorSourceComponent = currentPartitioning.getPartition(actor);
			currentPartitioning.setPartition(actor, component);
		}
		
		double avg = 0;
		List<Double> occupancies = new ArrayList<Double>();
		for (Entry<String, List<String>> entry : currentPartitioning.asPartitionActorsMap().entrySet()) {
			double workload = 0;
			for (String actorName : entry.getValue()) {
				workload += actorWorkloads.get(network.getActor(actorName));
			}
			avg += workload;
			occupancies.add(workload);
		}
		avg /= currentPartitioning.asPartitionActorsMap().size();
		
		double sumsquared = 0;
		for (Double occupancy : occupancies) {
			sumsquared += Math.pow(occupancy - avg, 2);
		}
		
		if (actor != null) {
			currentPartitioning.setPartition(actor, actorSourceComponent);
		}
		
		double stddev = Math.sqrt(sumsquared/currentPartitioning.asPartitionActorsMap().size());
		
		return avg/stddev;
	}
}

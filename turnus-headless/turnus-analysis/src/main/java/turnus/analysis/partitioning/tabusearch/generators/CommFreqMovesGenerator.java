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
package turnus.analysis.partitioning.tabusearch.generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;

import turnus.analysis.profiling.IntraActionCommunicationAnalysis;
import turnus.common.TurnusException;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.dataflow.Actor;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class CommFreqMovesGenerator extends TabuSearchMovesGenerator {
	
	private IntraActionCommunicationAnalysis communicationAnalysis;
	private Map<Actor, Map<Actor, Long>> communicationFrequency;
	private Map<Actor, Map<String, Long>> partitionCommunicationFrequency;
	private HashMultiset<Actor> totalCommunicationFrequency;

	public CommFreqMovesGenerator(TraceProject tProject) {
		super(tProject);
	}
	
	public CommFreqMovesGenerator(TraceProject tProject, double admissionRate) {
		super(tProject, admissionRate);
	}
	
	/**
	 * Launch the intra-action communication analysis to create a map for each actor (they remain unchanged).
	 */
	@Override
	public void init() {
		communicationAnalysis = new IntraActionCommunicationAnalysis(tProject);
		
		communicationFrequency = new HashMap<Actor, Map<Actor, Long>>();
		partitionCommunicationFrequency = new HashMap<Actor, Map<String, Long>>();
		totalCommunicationFrequency = HashMultiset.create();
		
		for (Actor actor1 : network.getActors()) {
			communicationFrequency.put(actor1, new HashMap<Actor, Long>());
			for (Actor actor2 : network.getActors()) {
				communicationFrequency.get(actor1).put(actor2, (long) 0);
			}
		}
		
		communicationAnalysis.setConfiguration(configuration);
		 // launch the communication profiling analysis
		IntraActionCommunicationReport report = null;
		try {
			report = communicationAnalysis.run();
		} catch (TurnusException e) {
			e.printStackTrace();
		}
		
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
	}
	
	@Override
	public void generateMoves(NetworkPartitioning startPartitioning, int iteration) {
		possibleMovesList = new ArrayList<GenericMove>();
		possibleMovesList.addAll(getAllSingleMoves(startPartitioning, iteration));
		
		//no shuffling, because the moves are ordered by priority
		admitMoves();
		
		possibleMovesIterator = possibleMovesList.iterator();
	}
	
	private List<SingleMove> getAllSingleMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<SingleMove> moves = new ArrayList<SingleMove>();
		partitionCommunicationFrequency.clear();
		totalCommunicationFrequency.clear();
		// create the actor-partition communication frequency map for a given partitioning configuration
		for (Actor actor1 : network.getActors()) {
			partitionCommunicationFrequency.put(actor1, new HashMap<String, Long>()); 
			for (String partition : startPartitioning.asPartitionActorsMap().keySet()) {
				partitionCommunicationFrequency.get(actor1).put(partition, (long) 0);
			}
			for (Actor actor2 : network.getActors()) {
				if (!actor1.equals(actor2)) {
					String targetPartition = startPartitioning.getPartition(actor2);
					long oldV = partitionCommunicationFrequency.get(actor1).get(targetPartition);
					partitionCommunicationFrequency.get(actor1).put(targetPartition, oldV + communicationFrequency.get(actor1).get(actor2));
					totalCommunicationFrequency.add(actor1, (Integer)communicationFrequency.get(actor1).get(actor2).intValue());
				}
			}
		}
		
		List<Actor> sortedActors = sortDescendingByCommFreq(totalCommunicationFrequency);
		for (Actor actor : sortedActors) {
			String currentActorComponent = startPartitioning.getPartition(actor);
			if (startPartitioning.asPartitionActorsMap().get(currentActorComponent).size() > 1) {
				long internFreq = partitionCommunicationFrequency.get(actor).get(currentActorComponent);
				for (String partition : partitionCommunicationFrequency.get(actor).keySet()) {
					if (!partition.equals(startPartitioning.getPartition(actor))) {
						long externFreq = partitionCommunicationFrequency.get(actor).get(partition);
						if (externFreq > internFreq // one specific partition with a higher communication frequency than with the current one
								&& tabu[actorTabuTableId.get(actor)][partitionTabuTableId.get(partition)] < iteration) { // not a tabu move
							moves.add(new SingleMove(actor, startPartitioning.getPartition(actor), partition));
						//	System.out.println("Single: " + actor + ", from " + startPartitioning.getPartition(actor) + " to " + partition);
						}
					}
				}
			}
		}
		
		return moves;
	}
	
	private List<Actor> sortDescendingByCommFreq(HashMultiset<Actor> commFreq) {
		final HashMultiset<Actor> unsortedCommFreq = commFreq;
		List<Actor> sortedActors = new ArrayList<Actor>(unsortedCommFreq.elementSet());
		Collections.sort(sortedActors, new Comparator<Actor>() {
	
			@Override
			public int compare(Actor a1, Actor a2) {
				if (unsortedCommFreq.count(a1) < unsortedCommFreq.count(a2)) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		return sortedActors;

	}
	
	/* TODO:
	 * consider the situation when swapping will not help, because the most communicative actors
	 * will be swapped 
	 */
	/*private List<MultipleMove> getAllSwapMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<MultipleMove> swapMoves = new ArrayList<MultipleMove>();
		List<SingleMove> singleMoves = getSingleMovesForSwap(startPartitioning, iteration);
		for (SingleMove singleM : singleMoves) {
			for (SingleMove reverseM : singleMoves) {
				if (singleM.getSourcePartition().equals(reverseM.getTargetPartition())
						&& singleM.getTargetPartition().equals(reverseM.getSourcePartition())) {
					if (!containsSwapMove(swapMoves, singleM, reverseM)) {
						MultipleMove mm = new MultipleMove();
						mm.addComponentMove(singleM);
						mm.addComponentMove(reverseM);
						swapMoves.add(mm);
						//System.out.println("Swap: " + singleM.getActor() + " from " + singleM.getSourcePartition() + " to " + singleM.getTargetPartition() + ", "
							//	+ reverseM.getActor() + " from " + reverseM.getSourcePartition() + " to " + reverseM.getTargetPartition());
					}
				}
			}
		}
		
		return swapMoves;
	}
	
	private List<SingleMove> getSingleMovesForSwap(NetworkPartitioning startPartitioning, int iteration) {
		List<SingleMove> moves = new ArrayList<SingleMove>();
		partitionCommunicationFrequency.clear();
		// create the actor-partition communication frequency map for a given partitioning configuration
		for (Actor actor1 : network.getActors()) {
			partitionCommunicationFrequency.put(actor1, new HashMap<String, Long>()); 
			for (String partition : startPartitioning.asPartitionActorsMap().keySet()) {
				partitionCommunicationFrequency.get(actor1).put(partition, (long) 0);
			}
			for (Actor actor2 : network.getActors()) {
				if (!actor1.equals(actor2)) {
					String targetPartition = startPartitioning.getPartition(actor2);
					long oldV = partitionCommunicationFrequency.get(actor1).get(targetPartition);
					partitionCommunicationFrequency.get(actor1).put(targetPartition, oldV + communicationFrequency.get(actor1).get(actor2));
				}
			}
		}
		
		for (Actor actor : partitionCommunicationFrequency.keySet()) {
			String currentActorComponent = startPartitioning.getPartition(actor);
			long internFreq = partitionCommunicationFrequency.get(actor).get(currentActorComponent);
			for (String partition : partitionCommunicationFrequency.get(actor).keySet()) {
				if (!partition.equals(startPartitioning.getPartition(actor))) {
					long externFreq = partitionCommunicationFrequency.get(actor).get(partition);
					if (externFreq > internFreq // one specific partition with a higher communication frequency than with the current one
							&& tabu[actorTabuTableId.get(actor)][partitionTabuTableId.get(partition)] < iteration) { // not a tabu move
						moves.add(new SingleMove(actor, startPartitioning.getPartition(actor), partition));
					//	System.out.println("Single: " + actor + ", from " + startPartitioning.getPartition(actor) + " to " + partition);
					}
				}
			}
		}
		
		return moves;
	}
	
	private boolean containsSwapMove(List<MultipleMove> swapMoves, SingleMove move1, SingleMove move2) {
		for (MultipleMove swapMove : swapMoves) {
			if (swapMove.containsMove(move1) && swapMove.containsMove(move2)) {
				return true;
			}
		}
		
		return false;
	}*/
}

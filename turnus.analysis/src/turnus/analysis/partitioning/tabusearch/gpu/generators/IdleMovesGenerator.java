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
package turnus.analysis.partitioning.tabusearch.gpu.generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class IdleMovesGenerator extends TabuSearchMovesGenerator {
	
	private double lastExecutionTime;
	
	public IdleMovesGenerator(TraceProject project) {
		super(project);
	}
	
	public IdleMovesGenerator(TraceProject project, double admissionRate) {
		super(project, admissionRate);
	}
	
	@Override
	public void init() {
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
		Map<String, Double> partitionIdleTimes = actorStatsCollector.getPartitionIdleTimes(lastExecutionTime); 
		Map<String, Double> idleTimes = actorStatsCollector.getIdleTimes();
		Map<String, Double> processingTimes = actorStatsCollector.getProcessingTimes();
		
		// sort actors by idle time (descending)
		List<String> actorsSortedByIdleTime = sortDescendingByIdleTime(idleTimes); 
		for (String actor : actorsSortedByIdleTime) {
			if (startPartitioning.asPartitionActorsMap().get(startPartitioning.getPartition(actor)).size() > 1) {
				if (idleTimes.get(actor) > processingTimes.get(actor)) {
					String mostIdlePartition = null;
					double idleTime = 0;
					for (Entry<String, Double> partition : partitionIdleTimes.entrySet()) {
						if (!partition.getKey().equals(startPartitioning.getPartition(actor)) // not the current partition of this actor
							&& partition.getValue() > idleTime  // the most idle one
								&& tabu[actorTabuTableId.get(network.getActor(actor))][partitionTabuTableId.get(partition.getKey())] < iteration) { // not a tabu move
							idleTime = partition.getValue();
							mostIdlePartition = partition.getKey();
						}
					}
					if (mostIdlePartition != null) {
						moves.add(new SingleMove(network.getActor(actor), startPartitioning.getPartition(actor), mostIdlePartition));
					}
				}
			}
		}
		
		return moves;
	}
	
	private List<String> sortDescendingByIdleTime(Map<String, Double> idleTimes) {
		final Map<String, Double> unsortedIdleTimes = idleTimes;
		List<String> sortedActors = new ArrayList<String>(unsortedIdleTimes.keySet());
		Collections.sort(sortedActors, new Comparator<String>() {
	
			@Override
			public int compare(String a1, String a2) {
				if (unsortedIdleTimes.get(a1) < unsortedIdleTimes.get(a2)) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		return sortedActors;

	}

	
	/*private List<MultipleMove> getAllSwapMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<MultipleMove> swapMoves = new ArrayList<MultipleMove>();
		List<SingleMove> singleMoves = getSingleMovesForSwapping(startPartitioning, iteration);
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
	
	private List<SingleMove> getSingleMovesForSwapping(NetworkPartitioning startPartitioning, int iteration) {
		List<SingleMove> moves = new ArrayList<SingleMove>();
		Map<String, Double> partitionIdleTimes = actorStatsCollector.getPartitionIdleTimes(lastExecutionTime); 
		Map<String, Double> idleTimes = actorStatsCollector.getIdleTimes();
		Map<String, Double> processingTimes = actorStatsCollector.getProcessingTimes();
		
		String leastIdlePartition = null;
		double idleTime = Double.MAX_VALUE;
		for (Entry<String, Double> partition : partitionIdleTimes.entrySet()) {
			if (partition.getValue() < idleTime) { // find the least idle (= most occupied) partition
				idleTime = partition.getValue();
				leastIdlePartition = partition.getKey();
			}
		}
			
		for (String actor : idleTimes.keySet()) {
			if (idleTimes.get(actor) > processingTimes.get(actor)) {
				for (Entry<String, Double> partition : partitionIdleTimes.entrySet()) { // not the current partition of this actor
					if (!partition.getKey().equals(startPartitioning.getPartition(actor)) && !partition.getKey().equals(leastIdlePartition) // not the least idle partition
							&& tabu[actorTabuTableId.get(network.getActor(actor))][partitionTabuTableId.get(partition.getKey())] < iteration) { // not a tabu move
						moves.add(new SingleMove(network.getActor(actor), startPartitioning.getPartition(actor), partition.getKey()));
						// System.out.println("Single: " + actor + ", from " + startPartitioning.getPartition(actor) + " to " + partition.getKey());
					}
				}
			}
		}
		
		return moves;
	}
	
	public boolean containsSwapMove(List<MultipleMove> swapMoves, SingleMove move1, SingleMove move2) {
		for (MultipleMove swapMove : swapMoves) {
			if (swapMove.containsMove(move1) && swapMove.containsMove(move2)) {
				return true;
			}
		}
		
		return false;
	}*/
	
}

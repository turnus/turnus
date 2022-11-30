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
import java.util.List;
import java.util.Map;

import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class BalancingMovesGenerator extends TabuSearchMovesGenerator {
	
	private double lastExecutionTime;

	public BalancingMovesGenerator(TraceProject project) {
		super(project);
	}
	
	public BalancingMovesGenerator(TraceProject project, double admissionRate) {
		super(project, admissionRate);
	}
	
	@Override
	public void init() {
	}
	
	@Override
	public void generateMoves(NetworkPartitioning startPartitioning, int iteration) {
		possibleMovesList = new ArrayList<GenericMove>();
		possibleMovesList.addAll(getAllSwapMoves(startPartitioning, iteration));
		
		Collections.shuffle(possibleMovesList); // randomize the order
		admitMoves();
		
		possibleMovesIterator = possibleMovesList.iterator();
	}
	
	/*private List<SingleMove> getAllSingleMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<SingleMove> moves = new ArrayList<SingleMove>();
		Map<String, Double> partitionIdleTimes = actorStatsCollector.getPartitionIdleTimes(lastExecutionTime); 
		String partitionMin = null, partitionMax = null;
		double occupancyMin = Double.MAX_VALUE, occupancyMax = 0;
		
		for (Entry<String, Double> partition : partitionIdleTimes.entrySet()) {
			if (partition.getValue() < occupancyMin) {
				occupancyMin = partition.getValue();
				partitionMin = partition.getKey();
			}
			if (partition.getValue() > occupancyMax) {
				occupancyMax = partition.getValue();
				partitionMax = partition.getKey();
			}
		}
		
		if (partitionMax != null) {
			for (String actor : startPartitioning.asPartitionActorsMap().get(partitionMax)) {
				if (startPartitioning.asPartitionActorsMap().get(partitionMax).size() > 1
						&& tabu[actorTabuTableId.get(network.getActor(actor))][partitionTabuTableId.get(partitionMin)] < iteration) { // not a tabu move
					moves.add(new SingleMove(network.getActor(actor), startPartitioning.getPartition(actor), partitionMin));
				}
			}
		}
		
		return moves;
	}*/
	
	private List<MultipleMove> getAllSwapMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<MultipleMove> swapMoves = new ArrayList<MultipleMove>();
		
		Map<String, Double> partitionIdleTimes = actorStatsCollector.getPartitionIdleTimes(lastExecutionTime); 
		Map<String, Double> processingTimes = actorStatsCollector.getProcessingTimes();
		
		for (String actor1 : processingTimes.keySet()) {
			for (String actor2 : processingTimes.keySet()) {
				if (!startPartitioning.getPartition(actor1).equals(startPartitioning.getPartition(actor2))) { // actors in different partitions
					if (processingTimes.get(actor1) < processingTimes.get(actor2)) {
						double idleTime1 = partitionIdleTimes.get(startPartitioning.getPartition(actor1));
						double idleTime2 = partitionIdleTimes.get(startPartitioning.getPartition(actor2));
						if (idleTime1 > idleTime2) {
							SingleMove sm1 = new SingleMove(network.getActor(actor1), startPartitioning.getPartition(actor1), startPartitioning.getPartition(actor2));
							SingleMove sm2 = new SingleMove(network.getActor(actor2), startPartitioning.getPartition(actor2), startPartitioning.getPartition(actor1));
							MultipleMove mm = new MultipleMove();
							mm.addComponentMove(sm1);
							mm.addComponentMove(sm2);
							swapMoves.add(mm);
							//System.out.println("Swap: " + sm1.getActor() + " from " + sm1.getSourcePartition() + " to " + sm1.getTargetPartition() + ", "
								//	+ sm2.getActor() + " from " + sm2.getSourcePartition() + " to " + sm2.getTargetPartition());
						}
					}
				}
			}
		}
		
		return swapMoves;
	}
}

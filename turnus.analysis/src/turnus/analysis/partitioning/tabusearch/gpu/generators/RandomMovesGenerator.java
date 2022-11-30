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
import java.util.Set;

import turnus.model.dataflow.Actor;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class RandomMovesGenerator extends TabuSearchMovesGenerator {
	
	Set<Actor> CPUOnly;
	
	public RandomMovesGenerator(TraceProject project, Set<Actor> CPUOnly) {
		super(project);
		this.CPUOnly = CPUOnly;
	}

	public RandomMovesGenerator(TraceProject project, double admissionRate, Set<Actor> CPUOnly) {
		super(project, admissionRate);
		this.CPUOnly = CPUOnly;
	}

	@Override
	public void init() {
		
	}

	/**
	 * Each actor can be moved to each partition (different than its current one).
	 * 
	 * @param startPartitioning - the configuration the moves are generated for
	 * @param iteration - the current iteration
	 */

	@Override
	public void generateMoves(NetworkPartitioning startPartitioning, int iteration) {
		possibleMovesList = new ArrayList<GenericMove>();
		possibleMovesList.addAll(getAllSingleMoves(startPartitioning, iteration));
		
		Collections.shuffle(possibleMovesList); // randomize the order
		admitMoves();
		
		possibleMovesIterator = possibleMovesList.iterator();
	}
	
	private List<SingleMove> getAllSingleMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<SingleMove> moves = new ArrayList<SingleMove>();
		for (Actor actor : network.getActors()) {
//			if (startPartitioning.asPartitionActorsMap().get(startPartitioning.getPartition(actor)).size() > 1) { // for at least one actor per partition
				for (String partition : startPartitioning.getAllPartitions()) {
					String sourcePartition = startPartitioning.getPartition(actor);
					if (!partition.equals(sourcePartition) && // component different than the current one
							tabu[actorTabuTableId.get(actor)][partitionTabuTableId.get(partition)] < iteration && // not tabu move 
							(!CPUOnly.contains(actor) || !partition.equals("PG"))) { // not moving CPU only actor to a GPU partition
						moves.add(new SingleMove(actor, startPartitioning.getPartition(actor), partition));
						//System.out.println("Single: " + actor + ", from " + startPartitioning.getPartition(actor) + " to" + partition);
					}
				}
//			}
		}
		
		return moves;
	}
	
	/*private List<MultipleMove> getAllSwapMoves(NetworkPartitioning startPartitioning, int iteration) {
		List<MultipleMove> swapMoves = new ArrayList<MultipleMove>();
		List<SingleMove> singleMoves = getAllSingleMoves(startPartitioning, iteration);
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
						//		+ reverseM.getActor() + " from " + reverseM.getSourcePartition() + " to " + reverseM.getTargetPartition());
					}
				}
			}
		}
		
		return swapMoves;
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

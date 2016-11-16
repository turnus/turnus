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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.common.configuration.Configuration;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public abstract class TabuSearchMovesGenerator {
	
	public abstract class GenericMove {
		public abstract NetworkPartitioning modifySolution(NetworkPartitioning np);
	}
	
	public class SingleMove extends GenericMove {
		Actor actor;
		String sourcePartition;
		String targetPartition;
		
		public SingleMove(Actor a, String sc, String tc) {
			this.actor = a;
			this.sourcePartition = sc;
			this.targetPartition = tc;
		}
		
		public Actor getActor() {
			return actor;
		}
		
		public String getSourcePartition() {
			return sourcePartition;
		}

		public String getTargetPartition() {
			return targetPartition;
		}

		@Override
		public NetworkPartitioning modifySolution(NetworkPartitioning np) {
			np.setPartition(actor, targetPartition);
			return np;
		}
	}
	
	public class MultipleMove extends GenericMove {
		List<SingleMove> singleMoves;
		
		public MultipleMove() {
			singleMoves = new ArrayList<SingleMove>();
		}
		
		public List<SingleMove> getComponentMoves() {
			return singleMoves;
		}
		
		public void addComponentMove(SingleMove sm) {
			singleMoves.add(sm);
		}
		
		public boolean containsMove(SingleMove sm) {
			return singleMoves.contains(sm);
		}

		@Override
		public NetworkPartitioning modifySolution(NetworkPartitioning np) {
			for (SingleMove move : singleMoves) {
				np.setPartition(move.getActor(), move.getTargetPartition());
			}
			return np;
		}
	}
	
	protected TraceProject tProject;
	protected Network network;
	protected double admissionRate;
	
	protected List<GenericMove> possibleMovesList;
	protected Iterator<GenericMove> possibleMovesIterator;
	
//	protected List<SingleMove> reinsertMovesList;
//	protected Iterator<SingleMove> resinsertMovesIterator;
	
//	protected List<ArrayList<SingleMove>> swapMovesList;
//	protected Iterator<ArrayList<SingleMove>> swapMovesIterator;
		
	protected int[][] tabu;
	protected Map<Actor, Integer> actorTabuTableId;
	protected Map<String, Integer> partitionTabuTableId;
	
	protected Configuration configuration;
	
	protected ActorStatisticsCollector actorStatsCollector;
	
	public TabuSearchMovesGenerator(TraceProject project) {
		this.tProject = project;
		this.network = tProject.getNetwork();
		this.admissionRate = 1.0;
	}
	
	public TabuSearchMovesGenerator(TraceProject project, double admissionRate) {
		this.tProject = project;
		this.network = tProject.getNetwork();
		this.admissionRate = admissionRate;
	}
	
	public void setActorStatisticsCollector(ActorStatisticsCollector collector) {
		this.actorStatsCollector = collector;
	}
	
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	public abstract void init();
	
	public void setupTabu(NetworkPartitioning initialPartitioning) {
		Network network = tProject.getNetwork();
		tabu = new int[network.getActors().size()][initialPartitioning.getPartitions().size()];
		actorTabuTableId = new HashMap<Actor, Integer>();
		partitionTabuTableId = new HashMap<String, Integer>();
		
		int i = 0;
		int j = 0;
		for (Actor actor : network.getActors()) {
			actorTabuTableId.put(actor, i);
			j = 0;
			for (String component : initialPartitioning.getPartitions()) {
				partitionTabuTableId.put(component, j);
				tabu[i][j] = 0;
				j++;
			}
			i++;
		}
	}
	
	public abstract void generateMoves(NetworkPartitioning startPartitioning, int iteration);
	
	protected void admitMoves() {
		if (admissionRate < 1) {
			int solutionsAllowed = (int)Math.round(admissionRate * possibleMovesList.size());
			if (solutionsAllowed == 0)
				solutionsAllowed = 1;
			if (solutionsAllowed < possibleMovesList.size()) {
				List<GenericMove> toBeRemoved = new ArrayList<GenericMove>();
				for (int i = solutionsAllowed; i < possibleMovesList.size(); i++) {
					toBeRemoved.add(possibleMovesList.get(i));
				}
				possibleMovesList.removeAll(toBeRemoved);
			}
		}
	}
	
	public List<GenericMove> getPossibleMovesList() {
		return possibleMovesList;
	}

	public Iterator<GenericMove> getPossibleMovesIterator() {
		return possibleMovesIterator;
	}

	public void updateTabuList(GenericMove performedMove, int iteration, int tab) {
		if (performedMove instanceof SingleMove) {
			SingleMove sm = (SingleMove)performedMove;
			tabu[actorTabuTableId.get(sm.getActor())][partitionTabuTableId.get(sm.getSourcePartition())] = iteration + tab;
		}
		else {
			MultipleMove mm = (MultipleMove)performedMove;
			for (SingleMove sm : mm.getComponentMoves()) {
				tabu[actorTabuTableId.get(sm.getActor())][partitionTabuTableId.get(sm.getSourcePartition())] = iteration + tab;
			}
		}
	}
	
}

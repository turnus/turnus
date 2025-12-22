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

import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import turnus.analysis.Analysis;
import turnus.common.io.Logger;
import turnus.model.analysis.partitioning.BalancedPipelinePartition;
import turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class BalancedPipelinePartitioning extends Analysis<BalancedPipelinePartitioningReport> {

	private class Partition {
		
		private List<Actor> actors;
		
		public Partition() {
			actors = new ArrayList<Actor>();
		}
		
		public List<Actor> getActors() {
			return actors;
		}
		
		public void setActors(List<Actor> newActors) {
			actors = newActors;
		}
		
		public void addActor(Actor actor) {
			actors.add(actor);
		}
		
		public void sortElementsDesc() {
			Collections.sort(actors, new Comparator<Actor>() {
				public int compare(Actor a1, Actor a2) {
					return Double.compare(workloads.get(a2), workloads.get(a1));
				}
			});
		}
	}
	
	public static final int DEFAULT_UNITS = 2;
	private TraceWeighter traceWeighter;
	private int units;
	
	private Map<Actor, Double> workloads;
	private Map<Actor, Double> preWorkloads;
	private Map<Actor, HashSet<Actor>> allPredecessors;
	private Map<Actor, Map<Actor, Integer>> commonPredecessorsNumbers;
	
	private List<Partition> generatedPartitions;

	public BalancedPipelinePartitioning(TraceProject tProject, TraceWeighter tWeighter) {
		super(tProject);
		this.traceWeighter = tWeighter;
	}

	public BalancedPipelinePartitioningReport run() {
		// initially create n units (n = number of actors)
		int unitsInitial = project.getNetwork().getActors().size();
		int unitsCurrent = unitsInitial;
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		generatedPartitions = new ArrayList<Partition>(unitsCurrent);
		for (Actor a : project.getNetwork().getActors()) {
			Partition p = new Partition();
			p.addActor(a);
			generatedPartitions.add(p);
		}
		// calculate workload, preWorkload and commonPredecessors
		calculateActorsProperties();
		// run algorithm (see old version: BM)
		while (unitsCurrent > units) {
			if (unitsCurrent > unitsInitial/3)
				firstPhase();
			else	
				secondPhase();
			Logger.info("Units number reduced to: %s", --unitsCurrent);
		}
		
		return generateReport(generatedPartitions);
	}
	
	private void calculateActorsProperties() {
		// workloads
		workloads = new HashMap<Actor, Double>();
		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				sum += traceWeighter.getWeight(next);
			}
			workloads.put(actor, sum);
		}
		
		// pre-workloads and all predecessors
		preWorkloads = new HashMap<Actor, Double>();
		allPredecessors = new HashMap<Actor, HashSet<Actor>>();
		for (Actor actor : project.getNetwork().getActors()) {
			allPredecessors.put(actor, new HashSet<Actor>()); // create a list for every actor
			allPredecessors.get(actor).add(actor); // add actor as a predecessor of itself
		}
		for (Actor actor : project.getNetwork().getActors()) {
			double preWorkload = maxValue(getPreWorkload(actor, actor)); // save the biggest pre-workload among network branches
			preWorkloads.put(actor, preWorkload);
		}
		
		// common predecessors
		commonPredecessorsNumbers = new HashMap<Actor, Map<Actor, Integer>>();
		for (Actor actor : project.getNetwork().getActors()) {
			commonPredecessorsNumbers.put(actor, new HashMap<Actor, Integer>());
			for (Actor secondActor : project.getNetwork().getActors()) {
				if (!actor.equals(secondActor)) {
					List<Actor> common = new ArrayList<Actor>(allPredecessors.get(actor));
					common.retainAll(allPredecessors.get(secondActor));
					commonPredecessorsNumbers.get(actor).put(secondActor, common.size());
				}
			}
		}
	}
	
	/**
	 * Help method to find the max value in the array.
	 * 
	 * @param values
	 * @return
	 */
	private double maxValue(double [] values) {
		double max = 0;
		for (Double d : values)
			if (d > max)
				max = d;
		
		return max;
	}
	
	/**
	 * Returns an array with preceding workload in each branch (if more branches available).
	 * 
	 * @param a
	 		referring {@link Actor}
	 * @param rootActor (the actor the recursive function started from)
	 		referring {@link Actor}
	 * @return
	 */
	private double [] getPreWorkload(Actor a, Actor rootActor) {
		List<Actor> predecessors = new ArrayList<Actor>();
		for (Buffer b : a.getIncomingBuffers())
			predecessors.add(b.getSource().getOwner());
		
		double [] preWorkloadValue = new double[predecessors.size()];
		if (predecessors.size() > 0) {
			for (int i = 0; i < predecessors.size(); i++) {
				boolean uncyclic = allPredecessors.get(rootActor).add(predecessors.get(i));
				if (uncyclic)
					preWorkloadValue[i] = workloads.get(a) + maxValue(getPreWorkload(predecessors.get(i), rootActor));
			}
		}
		
		return preWorkloadValue;
	}
	
	/**
	 * First phase of an algorithm, when number of units
	 * is being reduced by joining two units together.
	 */
	private void firstPhase() {
		sortPreWorkloadsAsc();
		reduceUnits(); 
	}
	
	/**
	 * Sort partitions ascending by the sum of preceding workloads.
	 */
	private void sortPreWorkloadsAsc() {
		final Map<Partition, Double> partitionPreWorkloads = new HashMap<Partition, Double>();
		for (Partition p : generatedPartitions) {
			double partitionPreWorkload = 0;
			for (Actor a : p.getActors()) {
				partitionPreWorkload += preWorkloads.get(a);
			}
			partitionPreWorkloads.put(p, partitionPreWorkload);
		}
		
		Collections.sort(generatedPartitions, new Comparator<Partition>() {
			public int compare(Partition p1, Partition p2) {
				return Double.compare(partitionPreWorkloads.get(p1), partitionPreWorkloads.get(p2));
			}
		});
	}
	
	/**
	 * Take unit with smallest preceding workload and stick to unit 
	 * with the highest average of common predecessors. 
	 * One of the units is removed afterwards.
	 */
	private void reduceUnits() {
		Partition joining1 = generatedPartitions.get(0);
		Partition joining2 = findUnitToStick(joining1);
		
		joining1.setActors(joinPartitions(joining1, joining2));
		generatedPartitions.remove(joining2);
	}
	
	/**
	 * Search for unit where average number of common 
	 * predecessors will be the highest
	 * (consider units with high preceding workload).
	 */
	private Partition findUnitToStick(Partition toBeSticked) {
		double maxAverageCommonPred = 0;
		Partition foundUnit = null;
		int offset = generatedPartitions.size() / 2; 	// search among units in the second half == units with "higher" sum of preceding workload
		
		for (int i = offset; i < generatedPartitions.size() - 1; i++) {
			double commonPreds = 0;
			double amount = 0;
			for (Actor first : toBeSticked.getActors()) { // calculate average number of common predecessors for each cross-combination
				for (Actor second : generatedPartitions.get(i).getActors()) {
					commonPreds += commonPredecessorsNumbers.get(first).get(second);
					amount++;
				}
			}
			
			if (commonPreds / amount > maxAverageCommonPred) {
				maxAverageCommonPred = commonPreds / amount;
				foundUnit = generatedPartitions.get(i); // find unit with the maximal value
			}
		}

		return foundUnit != null ? foundUnit : generatedPartitions.get(offset) ;
	}
	
	/**
	 * Creates a joined list of actors from 2 different units.
	 */
	private List<Actor> joinPartitions(Partition joining1, Partition joining2) {
		List<Actor> elements = new ArrayList<Actor>();
		for (Actor a : joining1.getActors())
			elements.add(a);
		for (Actor a : joining2.getActors())
			elements.add(a);

		return elements;
	}
		
	/**
	 * Second phase of an algorithm, when members of the least occupied
	 * unit are being spread among other units.
	 * 
	 * @return
	 */
	private void secondPhase() {		
		sortWorkloadsAsc();
		Partition toBeReduced = generatedPartitions.get(0); // the least occupied unit will be reduced
		toBeReduced.sortElementsDesc(); // the most occupied actors will be assigned first
		for (Actor a : toBeReduced.getActors()) {
			Partition newPartition = findMostCommonUnit(a); // assign the actor to the unit with which the average number of common predecessors is the highest
			if(newPartition != toBeReduced)
				newPartition.getActors().add(a);
		}
		generatedPartitions.remove(toBeReduced); 
	}
	
	/**
	 * Sort partitions ascending by the sum of workloads.
	 */
	private void sortWorkloadsAsc() {
		final Map<Partition, Double> partitionWorkloads = new HashMap<Partition, Double>();
		for (Partition p : generatedPartitions) {
			double partitionWorkload = 0;
			for (Actor a : p.getActors()) {
				partitionWorkload += workloads.get(a);
			}
			partitionWorkloads.put(p, partitionWorkload);
		}
		
		Collections.sort(generatedPartitions, new Comparator<Partition>() {
			public int compare(Partition p1, Partition p2) {
				return Double.compare(partitionWorkloads.get(p1), partitionWorkloads.get(p2));
			}
		});
	}
	
	/**
	 * Finds unit where average number of common predecessors 
	 * with the given actor is the highest.
	 */
	private Partition findMostCommonUnit(Actor actor) {
		double maxAverageCommonPred = 0;
		Partition foundUnit = null;
		int offset = generatedPartitions.size() / 2; // search among units in the second half == units with "higher" sum of preceding workload
		
		for (int i = offset; i < generatedPartitions.size() - 1; i++) {
			double commonPreds = 0;
			double amount = 0;
			for (Actor member : generatedPartitions.get(i).getActors()) {
				commonPreds += commonPredecessorsNumbers.get(actor).get(member);
				amount++;
			}
			
			if (commonPreds / amount > maxAverageCommonPred) {
				maxAverageCommonPred = commonPreds / amount;
				foundUnit = generatedPartitions.get(i); // find unit with the maximal value
			}
		}
		
		return foundUnit != null ? foundUnit : generatedPartitions.get(0) ;
	}

	private BalancedPipelinePartitioningReport generateReport(List<Partition> partitions) {
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		BalancedPipelinePartitioningReport report = f.createBalancedPipelinePartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Balanced Pipeline partitioner");

		for (Partition partition : partitions) {
			BalancedPipelinePartition data = f.createBalancedPipelinePartition();
			data.getActors().addAll(partition.getActors());
			double workload = 0;
			for (Actor actor : partition.getActors())
				workload += workloads.get(actor);
			data.setWorkload(workload);
			
			double preWorkload = 0;
			for (Actor actor : partition.getActors())
				preWorkload += preWorkloads.get(actor);
			data.setPreWorkload(preWorkload);
			
			double commonPredsAvg = 0;
			double amount = 0;
			for (Actor first : partition.getActors()) { 
				for (Actor second : partition.getActors()) {
					if (!first.equals(second)) {
						commonPredsAvg += commonPredecessorsNumbers.get(first).get(second);
						amount++;
					}
				}
			}
			commonPredsAvg /= amount;
			commonPredsAvg = commonPredsAvg * 100;
			commonPredsAvg = Math.round(commonPredsAvg);
			commonPredsAvg =commonPredsAvg / 100;
			
			data.setCommonPredAvg(commonPredsAvg);

			report.getPartitions().add(data);
		}

		return report;
	}
}

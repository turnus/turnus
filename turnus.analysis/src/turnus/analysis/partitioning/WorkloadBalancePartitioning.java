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
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import turnus.analysis.Analysis;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.analysis.partitioning.WorkloadBalancePartition;
import turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Actor;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class WorkloadBalancePartitioning extends Analysis<WorkloadBalancePartitioningReport> {

	private class WbPartition {

		private List<Actor> actors;
		private double workload;

		public WbPartition() {
			actors = new ArrayList<Actor>();
			workload = 0;
		}

		public List<Actor> getActors() {
			return actors;
		}

		public void addActor(Actor actor) {
			actors.add(actor);
		}

		public double getWorkload() {
			return workload;
		}

		public void addWorkload(double increment) {
			workload += increment;
		}

	}

	public static final int DEFAULT_UNITS = 2;
	public static final String DEFAULT_SCHEDULING_POLICY = "ROUND_ROBIN";
	private TraceWeighter traceWeighter;
	private int units;
	private EScheduler schedulingPolicy;

	public WorkloadBalancePartitioning(TraceProject tProject, TraceWeighter tWeighter) {
		super(tProject);
		this.traceWeighter = tWeighter;
	}

	@Override
	public WorkloadBalancePartitioningReport run() {
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		schedulingPolicy = EScheduler.get(configuration.getValue(SCHEDULING_POLICY, DEFAULT_SCHEDULING_POLICY));
		List<WbPartition> generatedPartitions = balanceWorkload(units);

		return generateReport(generatedPartitions);
	}

	private List<WbPartition> balanceWorkload(int units) {
		List<WbPartition> partitions = new ArrayList<WbPartition>(units);
		for (int i = 0; i < units; i++) {
			partitions.add(new WbPartition());
		}

		Map<Actor, Double> actorWorkload = calculateActorWorkloads();
		List<Actor> sortedActors = sortDescendingByWorkload(actorWorkload);
		for (Actor actor : sortedActors) {
			WbPartition targetPartition = getMin(partitions);
			targetPartition.addActor(actor);
			targetPartition.addWorkload(actorWorkload.get(actor));
		}

		return partitions;
	}

	private Map<Actor, Double> calculateActorWorkloads() {
		Map<Actor, Double> workloads = new HashMap<Actor, Double>();

		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				sum += traceWeighter.getWeight(next);
			}
			workloads.put(actor, sum);
		}

		return workloads;
	}

	private List<Actor> sortDescendingByWorkload(Map<Actor, Double> workloads) {
		final Map<Actor, Double> unsortedWorkloads = workloads;
		List<Actor> sortedActors = new ArrayList<Actor>(workloads.keySet());
		Collections.sort(sortedActors, new Comparator<Actor>() {
			@Override
			public int compare(Actor a1, Actor a2) {
				if (unsortedWorkloads.get(a1) < unsortedWorkloads.get(a2)) {
					return 1;
				} else if (unsortedWorkloads.get(a1) > unsortedWorkloads.get(a2)) {
					return -1;
				}else {
					return 0;
				}
				
			}
		});

		return sortedActors;
	}

	private WbPartition getMin(List<WbPartition> partitions) {
		double min = Double.MAX_VALUE;
		WbPartition targetPartition = null;
		for (WbPartition partition : partitions) {
			if (partition.getWorkload() < min) {
				min = partition.getWorkload();
				targetPartition = partition;
			}
		}
		return targetPartition;
	}

	private WorkloadBalancePartitioningReport generateReport(List<WbPartition> partitions) {
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		WorkloadBalancePartitioningReport report = f.createWorkloadBalancePartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Workload Balance partitioner");
		report.setSchedulinPolicy(schedulingPolicy);

		for (WbPartition partition : partitions) {
			WorkloadBalancePartition data = f.createWorkloadBalancePartition();
			data.getActors().addAll(partition.getActors());

			data.setWorkload(partition.getWorkload());

			report.getPartitions().add(data);
		}

		return report;
	}

}

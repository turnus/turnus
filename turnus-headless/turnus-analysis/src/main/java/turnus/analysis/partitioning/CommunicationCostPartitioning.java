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

import static turnus.common.TurnusExtensions.PROFILING_DYNAMIC;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_COMM_BIT_ACCURATE;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.util.FileUtils.changeExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.util.concurrent.AtomicLongMap;

import turnus.analysis.Analysis;
import turnus.analysis.partitioning.util.KernighanLinPartitioner;
import turnus.analysis.partitioning.util.KernighanLinPartitioner.KlPartition;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.partitioning.ComCostPartition;
import turnus.model.analysis.partitioning.ComCostPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class CommunicationCostPartitioning extends Analysis<ComCostPartitioningReport> {

	public static final boolean DEFAULT_BIT_ACCURATE = true;
	public static final int DEFAULT_UNITS = 2;
	private boolean bitAccurate;
	private Map<Buffer, Long> bufferCostMap;
	private int units;

	public CommunicationCostPartitioning(TraceProject project) {
		super(project);
	}

	private Map<Buffer, Long> generateCostMap(boolean bitAccurate) throws TurnusException {
		Map<Buffer, Long> map = new HashMap<>();

		// try load the dynamic profiling network
		DynamicProfilingReport dprof = null;
		try {
			File dProfFile = changeExtension(project.getTraceFile(), PROFILING_DYNAMIC);
			dprof = EcoreUtils.loadEObject(project.getResourceSet(), dProfFile);
			if (dprof == null) {
				throw new NullPointerException("the dynamic profiling report cannot be loaded");
			}
		} catch (Exception e) {
			Logger.error("The dynamic profiling file cannot be loaded");
			dprof = null;
		}

		// dprof = null;

		if (dprof != null) {
			for (BufferDynamicData data : dprof.getBuffersData()) {
				Buffer buffer = data.getBuffer();
				long cost = Double.valueOf(data.getWrites().getSum()).longValue();
				if (bitAccurate) {
					cost *= buffer.getType().getBits();
				}
				map.put(buffer, cost);
			}
		} else {
			Logger.info("Evaluating the buffer utilization from the trace");
			if (!project.isTraceLoaded()) {
				project.loadTrace(new SplittedTraceLoader(), configuration);
			}

			Trace trace = project.getTrace();
			long steps = trace.getSizeS();
			ProgressPrinter printer = null;
			if (steps > 0) {
				printer = new ProgressPrinter("Buffer utilization analysis", steps);
			} else {
				printer = new NullProgressPrinter("Buffer utilization analysis");
			}

			AtomicLongMap<Buffer> tokens = AtomicLongMap.create();

			TraceDecorator decorator = project.getTraceDecorator();
			for (Step step : trace.getSteps(Order.INCREASING_ID)) {
				for (Entry<Buffer, Integer> e : decorator.getWriteTokens(step).entrySet()) {
					Buffer buffer = e.getKey();
					int value = e.getValue();
					tokens.addAndGet(buffer, value);
				}
				printer.increment();
			}

			for (Entry<Buffer, Long> e : tokens.asMap().entrySet()) {
				Buffer buffer = e.getKey();
				long cost = e.getValue();
				if (bitAccurate) {
					cost *= buffer.getType().getBits();
				}
				map.put(buffer, cost);
			}

			printer.finish();
		}

		return map;
	}

	private ComCostPartitioningReport generateReport(List<KlPartition> partitions) {
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		ComCostPartitioningReport report = f.createComCostPartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setBitAccurate(bitAccurate);
		report.setAlgorithm("KL communication cost partitioner");

		for (KlPartition partition : partitions) {
			ComCostPartition data = f.createComCostPartition();
			data.getActors().addAll(partition.getActors());

			for (Entry<Actor, Long> e : partition.getInternalCostMap().entrySet()) {
				Actor actor = e.getKey();
				long value = e.getValue();
				data.getInternalCostMap().put(actor, value);
			}

			for (Entry<Actor, Long> e : partition.getExternalCostMap().entrySet()) {
				Actor actor = e.getKey();
				long value = e.getValue();
				data.getExternalCostMap().put(actor, value);
			}

			report.getPartitions().add(data);
		}

		return report;
	}

	public ComCostPartitioningReport run() throws TurnusException {
		bitAccurate = configuration.getValue(ANALYSIS_PARTITIONING_COMM_BIT_ACCURATE, DEFAULT_BIT_ACCURATE);
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		bufferCostMap = generateCostMap(bitAccurate);

		Network network = project.getNetwork();

		List<Actor> actors = new ArrayList<>(network.getActors());
		List<KlPartition> partitions = new ArrayList<>();

		if (units >= actors.size()) {
			Logger.info("The number of units is bigger or equal to the number of actors. "
					+ "A 1:1 partitioning solution is provided.");
			for (Actor actor : actors) {
				List<Actor> oneActorSet = new ArrayList<>();
				oneActorSet.add(actor);

				List<KlPartition> p11 = new KernighanLinPartitioner(oneActorSet, bufferCostMap).compute();
				partitions.add(p11.get(0));
			}
		} else {
			// compute first partition
			KernighanLinPartitioner p = new KernighanLinPartitioner(actors, bufferCostMap);
			for (KlPartition partition : p.compute()) {
				partitions.add(partition);
			}

			while (partitions.size() != units) {
				// search the partition with smallest internal cost and at least
				// 2 actors
				Collections.sort(partitions, new Comparator<KlPartition>() {
					@Override
					public int compare(KlPartition p0, KlPartition p1) {
						int s0 = p0.getActors().size();
						int s1 = p1.getActors().size();
						if (s0 == 1 && s1 != 1) {
							return 1;
						} else if (s1 == 1 && s0 != 1) {
							return -1;
						}

						long i0 = p0.getInternalCost();
						long i1 = p1.getInternalCost();
						if (i0 != i1) {
							return Long.compare(i0, i1);
						}
						return -Integer.compare(s0, s1);
					}
				});

				KlPartition oldPartition = partitions.remove(0);

				p = new KernighanLinPartitioner(oldPartition.getActors(), bufferCostMap);
				for (KlPartition partition : p.compute()) {
					partitions.add(partition);
				}
			}

		}

		return generateReport(partitions);
	}

}

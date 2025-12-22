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
package turnus.analysis.buffer;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_BIT_ACCURATE;
import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_POW2;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.MAX_ITERATIONS;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;
import static turnus.common.util.StringUtils.format;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.adevs.logging.DataCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.analysis.bottlenecks.ScheduledPartialCriticalPathAnalysis;
import turnus.analysis.bottlenecks.util.CriticalPathCollector;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersFactory;
import turnus.model.analysis.buffers.OptimalBufferData;
import turnus.model.analysis.buffers.OptimalBuffersReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Malgorzata Michalska
 */
public class OptimalBufferSizeAnalysisTopDown extends Analysis<OptimalBuffersReport> {

	/**
	 * Top - down approach.
	 */

	public static final boolean DEFAULT_BIT_ACCURATE = false;
	public static final boolean DEFAULT_POW2 = false;
	public static final int DEFAULT_MAX_ITERATIONS = 20;

	private TraceWeighter weighter;
	private CommunicationWeight communication;
	private SchedulingWeight scheduling;
	private NetworkPartitioning partitioning;
	private boolean pow2 = false;
	private boolean bitAccurate = false;
	private Network network;

	public OptimalBufferSizeAnalysisTopDown(TraceProject project) {
		super(project);
		network = project.getNetwork();
	}

	@Override
	public OptimalBuffersReport run() throws TurnusException {
		if (weighter == null) {
			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
				weighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("Weights file is not valid", e);
			}
		}

		if (partitioning == null) {
			try {
				File mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("Mapping file is not valid", e);
			}
		}

		if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
			File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
			XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(project.getNetwork());
			communication = reader.load(communicationWeightsFile);

			if (configuration.hasValue(WRITE_HIT_CONSTANT)) {
				communication.setWriteHitConstant(configuration.getValue(WRITE_HIT_CONSTANT));
			}
			if (configuration.hasValue(WRITE_MISS_CONSTANT)) {
				communication.setWriteMissConstant(configuration.getValue(WRITE_MISS_CONSTANT));
			}
		}

		if (configuration.hasValue(SCHEDULING_WEIGHTS)) {
			File schWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
			scheduling = new XmlSchedulingWeightReader().load(schWeightsFile);
		}

		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		BufferSize maxBufferConfiguration = null;
		BuffersFactory f = BuffersFactory.eINSTANCE;
		OptimalBuffersReport report = f.createOptimalBuffersReport();

		SimEngine simulation = new SimEngine();
		simulation.setTraceProject(project);
		simulation.setTraceWeighter(weighter);
		simulation.setCommunicationWeight(communication);
		simulation.setSchedulingWeight(scheduling);
		simulation.setNetworkPartitioning(partitioning);
		if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING))
			simulation.setReleaseAfterProcessing();

		if (configuration.hasValue(BUFFER_SIZE_FILE)) {
			// load initial buffer configuration
			File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
			XmlBufferSizeReader reader = new XmlBufferSizeReader();
			maxBufferConfiguration = reader.load(bufferFile);
		} else {
			List<DataCollector> registeredCollectors = new ArrayList<>();
			CriticalPathCollector cpCollector = new CriticalPathCollector(project.getNetwork(), partitioning);
			registeredCollectors.add(cpCollector);
			for (DataCollector collector : registeredCollectors) {
				simulation.addDataCollector(collector);
			}
			// run TP with unbounded buffer to get the buffer sizes
			maxBufferConfiguration = new BufferSize(network);
			maxBufferConfiguration.setDefaultSize(Integer.MAX_VALUE);
			simulation.setBufferSize(maxBufferConfiguration);
			
			PostProcessingReport ppReport = simulation.run();
			double time = ppReport.getTime(); // evaluate the new time
			
			maxBufferConfiguration = simulation.getMaxBufferSizeRecorded();

			// used to store the maximal configuration in a file (in case we want to load
			// from file next time)
			BoundedBuffersReport newData = getNewBufferData(maxBufferConfiguration);
			OptimalBufferData data = f.createOptimalBufferData();
			data.setBufferData(newData);
			BottlenecksWithSchedulingReport pcpData = ppReport
					.getReport(BottlenecksWithSchedulingReport.class);
			pcpData.setDeadlock(simulation.isDeadlocked());
			pcpData.setExecutionTime(time);
			data.setBottlenecksData(pcpData);
			report.getBuffersData().add(data);
		}

		BoundedBuffersReport minimalBufferData = null;
		BufferSize minBufferConfiguration = null;
		// evaluate the minimal non-blocking buffer size
		Logger.info("Evaluate the minimal buffer size configuration");
		BoundedBufferAnalysis boundedBufferAnalysis = new BoundedBufferAnalysis(project);
		boundedBufferAnalysis.setConfiguration(configuration);
		minimalBufferData = boundedBufferAnalysis.run();
		minBufferConfiguration = minimalBufferData.asBufferSize();

		// replace max conf with min conf, if min conf > max conf
		// it guarantees deadlock free execution in next iterations
		for (Buffer buffer : network.getBuffers()) {
			if (maxBufferConfiguration.getSize(buffer) < minBufferConfiguration.getSize(buffer)) {
				maxBufferConfiguration.setSize(buffer, minBufferConfiguration.getSize(buffer));
			}
		}

		// store the initial configuration in a report
		BoundedBuffersReport initialBufferData = f.createBoundedBuffersReport();
		initialBufferData.setAlgorithm("Optimal buffer size evaluation");
		initialBufferData.setBitAccurate(bitAccurate);
		initialBufferData.setPow2(pow2);
		initialBufferData.setDate(new Date());
		initialBufferData.setNetwork(network);

		for (Buffer buffer : network.getBuffers()) {
			BoundedBufferData data = f.createBoundedBufferData();
			data.setBuffer(buffer);
			data.setTokenSize(maxBufferConfiguration.getSize(buffer));
			initialBufferData.getBuffersData().add(data);
		}

		// setup the bottlenecks analysis
		Logger.info("Evaluate the initial bottlenecks");
		ScheduledPartialCriticalPathAnalysis pcpAnalysis = new ScheduledPartialCriticalPathAnalysis(project);
		pcpAnalysis.setBufferSize(maxBufferConfiguration);
		pcpAnalysis.setPartitioning(partitioning);
		pcpAnalysis.setWeighter(weighter);
		pcpAnalysis.setCommunicationWeight(communication);
		pcpAnalysis.setConfiguration(configuration);

		// evaluate the initial bottlenecks
		BottlenecksWithSchedulingReport initialPcpData = pcpAnalysis.run();
		double initialExecutionTime = initialPcpData.getExecutionTime();

		int iteration = 0;
		int maxIterations = configuration.getValue(MAX_ITERATIONS, DEFAULT_MAX_ITERATIONS);
		Logger.info("Launching the optimal buffer size analysis. Max iterations: %d", maxIterations);
		pow2 = configuration.getValue(ANALYSIS_BUFFER_POW2, DEFAULT_POW2);
		bitAccurate = configuration.getValue(ANALYSIS_BUFFER_BIT_ACCURATE, DEFAULT_BIT_ACCURATE);

		report.setAlgorithm("Optimal buffer size evaluation through citical path analysis");
		report.setBitAccurate(bitAccurate);
		report.setPow2(pow2);
		report.setNetwork(network);
		report.setInitialBottlenecks(initialPcpData);
		report.setInitialBufferConfiguration(initialBufferData);

		// extract the critical buffers
		List<Buffer> criticalBuffers = new ArrayList<Buffer>();
		Map<Buffer, Double> criticalBuffersWeights = new HashMap<Buffer, Double>();
		for (ActionBottlenecksWithSchedulingData data : initialPcpData.getActionsData()) {
			if (data.getCpWeight() > 0) {
				Action criticalAction = data.getAction();
				for (Buffer buffer : network.getBuffers()) {
					if (criticalAction.getOutputPorts().contains(buffer.getSource())) {
						double value = criticalBuffersWeights.containsKey(buffer) ? criticalBuffersWeights.get(buffer)
								: 0;
						criticalBuffersWeights.put(buffer, data.getCpWeight() + value);
						if (!criticalBuffers.contains(buffer))
							criticalBuffers.add(buffer);
					}
				}
			}
		}

		Collections.sort(criticalBuffers, getBuffersByCpWeight(criticalBuffersWeights)); // smallest cp weight
																							// difference first

		System.out.println("Critical buffers:");
		for (Buffer b : criticalBuffers) {
			System.out.println(b + ", min: " + minBufferConfiguration.getSize(b) + ", max: "
					+ maxBufferConfiguration.getSize(b) + ", cp weight: " + criticalBuffersWeights.get(b));
		}

		// extract the non-critical buffers
		List<Buffer> nonCriticalBuffers = new ArrayList<Buffer>();
		for (Buffer b : network.getBuffers()) {
			nonCriticalBuffers.add(b);
		}
		nonCriticalBuffers.removeAll(criticalBuffers);

		Collections.sort(nonCriticalBuffers, getBuffersBySizeDiff(maxBufferConfiguration, minBufferConfiguration)); // biggest
																													// max
																													// -
																													// min
																													// difference
																													// first

		System.out.println("Non-critical buffers:");
		for (Buffer b : nonCriticalBuffers) {
			System.out.println(
					b + ", min: " + minBufferConfiguration.getSize(b) + ", max: " + maxBufferConfiguration.getSize(b));
		}

		BufferSize newBufferConfiguration = maxBufferConfiguration.clone();
		double finalExecutionTime = initialExecutionTime;

		// STEP 1: try to divide the size of non-critical buffers by 2
		Logger.info("Step 1: non-critical buffers reduced.");
		for (Buffer buffer : nonCriticalBuffers) {

			if (iteration < maxIterations) {
				List<DataCollector> registeredCollectors = new ArrayList<>();
				while (newBufferConfiguration.getSize(buffer) >= 2 * minBufferConfiguration.getSize(buffer)) {
					if (iteration >= maxIterations) {
						Logger.info("Maximum number of iterations reached");
						break;
					}
					CriticalPathCollector cpCollector = new CriticalPathCollector(project.getNetwork(), partitioning);
					registeredCollectors.add(cpCollector);
					for (DataCollector collector : registeredCollectors) {
						simulation.addDataCollector(collector);
					}
					newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) / 2);
					simulation.setBufferSize(newBufferConfiguration);
					PostProcessingReport ppReport = simulation.run();
					double newExecutionTime = ppReport.getTime(); // evaluate the new time
					iteration++;
					if (newExecutionTime > initialExecutionTime || simulation.isDeadlocked()) { // revert the move
						Logger.info("Optimal buffer size iteration %d", iteration);
						Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
								+ newBufferConfiguration.getSize(buffer) + ", REVERTED");
						newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) * 2);
						break;
					} else {
						finalExecutionTime = newExecutionTime;
						// store the partial results
						BoundedBuffersReport newData = getNewBufferData(newBufferConfiguration);
						OptimalBufferData data = f.createOptimalBufferData();
						data.setBufferData(newData);
						// store execution time only (no critical path analysis)
						// BottlenecksWithSchedulingReport pcpData =
						// BottlenecksFactory.eINSTANCE.createBottlenecksWithSchedulingReport();

						BottlenecksWithSchedulingReport pcpData = ppReport
								.getReport(BottlenecksWithSchedulingReport.class);
						pcpData.setDeadlock(simulation.isDeadlocked());

						// pcpData.setExecutionTime(finalExecutionTime);

						data.setBottlenecksData(pcpData);
						report.getBuffersData().add(data);

						double reduction = (1 - ((double) initialBufferData.getTokenSize()) / newData.getTokenSize())
								* 100.0;
						Logger.info("Optimal buffer size iteration %d, Buffer size reduction (tokens): %s ", iteration,
								format(reduction) + "%");
						Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
								+ newBufferConfiguration.getSize(buffer));
					}
				}
			}
		}

		// STEP 2: try to divide the size of critical buffers by 2
		if (iteration < maxIterations) {
			Logger.info("Step 2: critical buffers reduced.");
			List<DataCollector> registeredCollectors = new ArrayList<>();
			for (Buffer buffer : criticalBuffers) {
				if (iteration < maxIterations) {
					while (newBufferConfiguration.getSize(buffer) >= 2 * minBufferConfiguration.getSize(buffer)) {
						if (iteration >= maxIterations) {
							Logger.info("Maximum number of iterations reached");
							break;
						}
						CriticalPathCollector cpCollector = new CriticalPathCollector(project.getNetwork(),
								partitioning);
						registeredCollectors.add(cpCollector);
						for (DataCollector collector : registeredCollectors) {
							simulation.addDataCollector(collector);
						}
						newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) / 2);
						simulation.setBufferSize(newBufferConfiguration);
						PostProcessingReport ppReport = simulation.run();
						double newExecutionTime = ppReport.getTime(); // evaluate the new time iteration++;
						if (newExecutionTime > initialExecutionTime || simulation.isDeadlocked()) { // revert the move
							Logger.info("Optimal buffer size iteration %d", iteration);
							Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
									+ newBufferConfiguration.getSize(buffer) + ", REVERTED");
							newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) * 2);
							break;
						} else {
							finalExecutionTime = newExecutionTime;
							// store the partial results
							BoundedBuffersReport newData = getNewBufferData(newBufferConfiguration);
							OptimalBufferData data = f.createOptimalBufferData();
							data.setBufferData(newData);
							// store execution time only (no critical path analysis)
							BottlenecksWithSchedulingReport pcpData = ppReport
									.getReport(BottlenecksWithSchedulingReport.class);
							pcpData.setDeadlock(simulation.isDeadlocked());

							// BottlenecksWithSchedulingReport pcpData =
							// BottlenecksFactory.eINSTANCE.createBottlenecksWithSchedulingReport();
							// pcpData.setExecutionTime(finalExecutionTime);

							data.setBottlenecksData(pcpData);
							report.getBuffersData().add(data);

							double reduction = (1
									- ((double) initialBufferData.getTokenSize()) / newData.getTokenSize()) * 100.0;
							Logger.info("Optimal buffer size iteration %d, Buffer size reduction (tokens): %s ",
									iteration, format(reduction) + "%");
							Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
									+ newBufferConfiguration.getSize(buffer));
						}
					}
				}
			}
		}

		// STEP 3: allow reduction (ALL buffers) if reduction % is bigger than time
		// increase %
		if (iteration < maxIterations) {
			Logger.info("Step 3: all buffers reduced, if % size reduction > % performance drop.");
			List<DataCollector> registeredCollectors = new ArrayList<>();
			for (Buffer buffer : network.getBuffers()) {
				if (iteration < maxIterations) {
					while (newBufferConfiguration.getSize(buffer) >= 2 * minBufferConfiguration.getSize(buffer)) {
						if (iteration >= maxIterations) {
							Logger.info("Maximum number of iterations reached");
							break;
						}
						BoundedBuffersReport oldData = getNewBufferData(newBufferConfiguration);
						CriticalPathCollector cpCollector = new CriticalPathCollector(project.getNetwork(),
								partitioning);
						registeredCollectors.add(cpCollector);
						for (DataCollector collector : registeredCollectors) {
							simulation.addDataCollector(collector);
						}
						newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) / 2);
						simulation.setBufferSize(newBufferConfiguration);
						PostProcessingReport ppReport = simulation.run();

						double newExecutionTime = ppReport.getTime(); // evaluate the new time

						BoundedBuffersReport newData = getNewBufferData(newBufferConfiguration);
						double reductionIt = (1 - ((double) oldData.getTokenSize()) / newData.getTokenSize()) * 100.0;
						double timeIncreaseIt = ((double) newExecutionTime / finalExecutionTime - 1) * 100.0;

						iteration++;
						if (timeIncreaseIt > reductionIt * (-1) || simulation.isDeadlocked()) { // revert the move
							Logger.info("Optimal buffer size iteration %d", iteration);
							Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
									+ newBufferConfiguration.getSize(buffer) + ", REVERTED");
							newBufferConfiguration.setSize(buffer, newBufferConfiguration.getSize(buffer) * 2);
							break;
						} else {
							finalExecutionTime = newExecutionTime;
							// store the partial results
							OptimalBufferData data = f.createOptimalBufferData();
							data.setBufferData(newData);
							// store execution time only (no critical path analysis)

							BottlenecksWithSchedulingReport pcpData = ppReport
									.getReport(BottlenecksWithSchedulingReport.class);
							pcpData.setDeadlock(simulation.isDeadlocked());
							// BottlenecksWithSchedulingReport pcpData =
							// BottlenecksFactory.eINSTANCE.createBottlenecksWithSchedulingReport();
							// pcpData.setExecutionTime(finalExecutionTime);

							data.setBottlenecksData(pcpData);
							report.getBuffersData().add(data);

							double reductionTotal = (1
									- ((double) initialBufferData.getTokenSize()) / newData.getTokenSize()) * 100.0;
							Logger.info("Optimal buffer size iteration %d, Buffer size reduction (tokens): %s ",
									iteration, format(reductionTotal) + "%");
							Logger.info("Reduced buffer:\n" + buffer + " , new size :: "
									+ newBufferConfiguration.getSize(buffer));
						}
					}
				}
			}
		}

		if (iteration < maxIterations)
			Logger.info("All possible reductions applied.");

		return report;
	}

	public Comparator<Buffer> getBuffersBySizeDiff(BufferSize max, BufferSize min) {
		Comparator<Buffer> comp = new Comparator<Buffer>() {
			@Override
			public int compare(Buffer b1, Buffer b2) {
				int sizeDiff1 = max.getSize(b1) - min.getSize(b1);
				int sizeDiff2 = max.getSize(b2) - min.getSize(b2);

				if (sizeDiff1 > sizeDiff2)
					return -1;
				else if (sizeDiff1 == sizeDiff2)
					return 0;
				else
					return 1; // from biggest to smallest
			}
		};
		return comp;
	}

	public Comparator<Buffer> getBuffersByCpWeight(Map<Buffer, Double> buffers) {
		Comparator<Buffer> comp = new Comparator<Buffer>() {
			@Override
			public int compare(Buffer b1, Buffer b2) {
				double value1 = buffers.get(b1);
				double value2 = buffers.get(b2);

				if (value1 > value2)
					return 1;
				else if (value1 == value2)
					return 0;
				else
					return -1; // from smallest to biggest
			}
		};
		return comp;
	}

	private BoundedBuffersReport getNewBufferData(BufferSize bufferConfiguration) {
		BuffersFactory f = BuffersFactory.eINSTANCE;
		BoundedBuffersReport report = f.createBoundedBuffersReport();
		report.setAlgorithm("Optimal buffer size evaluation");
		report.setBitAccurate(bitAccurate);
		report.setPow2(pow2);
		report.setDate(new Date());
		report.setNetwork(network);

		for (Buffer buffer : network.getBuffers()) {
			BoundedBufferData data = f.createBoundedBufferData();
			data.setBuffer(buffer);
			data.setTokenSize(bufferConfiguration.getSize(buffer));
			report.getBuffersData().add(data);
		}

		return report;
	}
}

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
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.MAX_ITERATIONS;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;
import static turnus.common.util.MathUtils.nearestPowTwo;
import static turnus.common.util.StringUtils.format;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import turnus.analysis.Analysis;
import turnus.analysis.bottlenecks.ScheduledPartialCriticalPathAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersFactory;
import turnus.model.analysis.buffers.OptimalBufferData;
import turnus.model.analysis.buffers.OptimalBuffersReport;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Simone Casale-Brunet
 */
public class OptimalBufferSizeAnalysisFullParallel extends Analysis<OptimalBuffersReport> {

	public static final boolean DEFAULT_BIT_ACCURATE = false;
	public static final boolean DEFAULT_POW2 = false;
	public static final int DEFAULT_MAX_ITERATIONS = 20;

	private TraceWeighter weighter;
	private CommunicationWeight communication;
	private NetworkPartitioning partitioning;
	private boolean pow2 = false;
	private boolean bitAccurate = false;
	private Network network;

	public OptimalBufferSizeAnalysisFullParallel(TraceProject project) {
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

		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}
		
		BoundedBuffersReport initialBufferData = null;
		BufferSize bufferConfiguration = null;
		
		if (configuration.hasValue(BUFFER_SIZE_FILE)) {
			// load initial buffer configuration
			File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
			XmlBufferSizeReader reader = new XmlBufferSizeReader();
			bufferConfiguration = reader.load(bufferFile);
			
			// store the initial configuration in a report
			BuffersFactory f = BuffersFactory.eINSTANCE;
			initialBufferData = f.createBoundedBuffersReport();
			initialBufferData.setAlgorithm("Optimal buffer size evaluation");
			initialBufferData.setBitAccurate(bitAccurate);
			initialBufferData.setPow2(pow2);
			initialBufferData.setDate(new Date());
			initialBufferData.setNetwork(network);

			for (Buffer buffer : network.getBuffers()) {
				BoundedBufferData data = f.createBoundedBufferData();
				data.setBuffer(buffer);
				data.setTokenSize(bufferConfiguration.getSize(buffer));
				initialBufferData.getBuffersData().add(data);
			}
			
		}
		else {
			// evaluate the minimal buffer size
			Logger.info("Evaluate the initial buffer size configuration");
			BoundedBufferAnalysis boundedBufferAnalysis = new BoundedBufferAnalysis(project);
			boundedBufferAnalysis.setConfiguration(configuration);
			initialBufferData = boundedBufferAnalysis.run();
			bufferConfiguration = initialBufferData.asBufferSize();
		}

		// evaluate the initial bottlenecks
		Logger.info("Evaluate the initial bottlenecks");
		ScheduledPartialCriticalPathAnalysis pcpAnalysis = new ScheduledPartialCriticalPathAnalysis(project);
		pcpAnalysis.setBufferSize(bufferConfiguration);
		pcpAnalysis.setPartitioning(partitioning);
		pcpAnalysis.setWeighter(weighter);
		pcpAnalysis.setCommunicationWeight(communication);
		pcpAnalysis.setConfiguration(configuration);
		BottlenecksWithSchedulingReport initialPcpData = pcpAnalysis.run();

		int maxIterations = configuration.getValue(MAX_ITERATIONS, DEFAULT_MAX_ITERATIONS);
		Logger.info("Launching the optimal buffer size analysis. Max iterations: %d", maxIterations);
		pow2 = configuration.getValue(ANALYSIS_BUFFER_POW2, DEFAULT_POW2);
		bitAccurate = configuration.getValue(ANALYSIS_BUFFER_BIT_ACCURATE, DEFAULT_BIT_ACCURATE);

		BuffersFactory f = BuffersFactory.eINSTANCE;
		OptimalBuffersReport report = f.createOptimalBuffersReport();
		report.setAlgorithm("Optimal buffer size evaluation through citical path analysis");
		report.setBitAccurate(bitAccurate);
		report.setPow2(pow2);
		report.setNetwork(network);
		report.setInitialBottlenecks(initialPcpData);
		report.setInitialBufferConfiguration(initialBufferData);

		// evaluate the buffers to be increased
		Map<Buffer, Integer> newBuffersSizeMap = getNextMove(initialPcpData, bufferConfiguration);
		
		int iteration = 0;
		double newExecutionTime = 0, executionTimeReduction = 0, tsIncrease = 0, etDecrease = 0;
		double executionTime = initialPcpData.getExecutionTime();
		for (;;) {
			if (newBuffersSizeMap.isEmpty()) {
				Logger.info("No critical non-tabu buffer found");
				break;
			} else if (iteration == maxIterations) {
				Logger.info("Maximum number of iterations reached");
				break;
			}

			iteration++;
			Logger.info("Iteration %d of %d", iteration, maxIterations);
			
			// compute the new buffer data
			BoundedBuffersReport bufferData = computeNewConfiguration(bufferConfiguration, newBuffersSizeMap);
			bufferConfiguration = bufferData.asBufferSize();

			// compute the new critical path data
			pcpAnalysis = new ScheduledPartialCriticalPathAnalysis(project);
			pcpAnalysis.setBufferSize(bufferConfiguration);
			pcpAnalysis.setPartitioning(partitioning);
			pcpAnalysis.setWeighter(weighter);
			pcpAnalysis.setCommunicationWeight(communication);
			pcpAnalysis.setConfiguration(configuration);
			BottlenecksWithSchedulingReport pcpData = pcpAnalysis.run();
			
			newExecutionTime = pcpData.getExecutionTime();
			
			// vs best 
			executionTimeReduction = ((executionTime - newExecutionTime) / executionTime) * 100.0;
			
			// vs initial
			tsIncrease = (((double) bufferData.getTokenSize()) / initialBufferData.getTokenSize() - 1) * 100.0;
		    etDecrease = ((initialPcpData.getExecutionTime() - newExecutionTime) / initialPcpData.getExecutionTime()) * 100.0;
			
			if (executionTimeReduction > 0) {
				Logger.info("Optimal buffer size iteration %d >> Execution time reduction: %s, Buffer size increase (tokens): %s ", iteration, format(etDecrease) + "%", format(tsIncrease) + "%");

				// store the partial results
				OptimalBufferData data = f.createOptimalBufferData();
				data.setBottlenecksData(pcpData);
				data.setBufferData(bufferData);
				report.getBuffersData().add(data);
				
				executionTime = newExecutionTime;
			}
			else {
				Logger.info("Optimal buffer size iteration %d - no execution time improvement, configuration will not be stored ", iteration);
			}
			
			newBuffersSizeMap = getNextMove(pcpData, bufferConfiguration);

		}

		return report;
	}

	private BoundedBuffersReport computeNewConfiguration(BufferSize oldConfiguration,
			Map<Buffer, Integer> buffersToIncrease) {
		BuffersFactory f = BuffersFactory.eINSTANCE;
		BoundedBuffersReport report = f.createBoundedBuffersReport();
		report.setAlgorithm("Optimal buffer size evaluation");
		report.setBitAccurate(bitAccurate);
		report.setPow2(pow2);
		report.setDate(new Date());
		report.setNetwork(network);

		for (Buffer buffer : network.getBuffers()) {
			int size = buffersToIncrease.containsKey(buffer) ? buffersToIncrease.get(buffer)
					: oldConfiguration.getSize(buffer);
			if (pow2) {
				size = nearestPowTwo(size);
			}
			BoundedBufferData data = f.createBoundedBufferData();
			data.setBuffer(buffer);
			data.setTokenSize(size);
			report.getBuffersData().add(data);
		}

		return report;
	}

	private Map<Buffer, Integer> getNextMove(BottlenecksWithSchedulingReport pcpReport, BufferSize bufferConfiguration) {
		Map<Buffer, Integer> result = new HashMap<>();

		double maxCp = 0.0;
		Map<Buffer, Integer> blockedTokens = new HashMap<>();

		// create the two maps
		for (ActionBottlenecksWithSchedulingData data : pcpReport.getActionsData()) {
			double cp = data.getCpWeight();
			Map<Buffer, Integer> bb = data.getMaxBlockedOutputTokens();
			if (cp > maxCp && !bb.isEmpty()) {
				cp = maxCp;
				blockedTokens = new HashMap<>(bb);
			}
		}

		if (blockedTokens.isEmpty()) {
			return result;
		}

		Buffer minimalBuffer = null;
		int minimalValue = Integer.MAX_VALUE;
		for (Entry<Buffer, Integer> e : blockedTokens.entrySet()) {
			Buffer buffer = e.getKey();
			int value = bufferConfiguration.getSize(buffer) + e.getValue();
			if (bitAccurate) {
				value *= buffer.getType().getBits();
			}
			if (value < minimalValue) {
				minimalValue = value;
				minimalBuffer = buffer;
			}
		}

		if (minimalBuffer != null) { // update the new size
			int size = bufferConfiguration.getSize(minimalBuffer) + blockedTokens.get(minimalBuffer);
			if (pow2) {
				size = nearestPowTwo(size);
			}
			result.put(minimalBuffer, size);
		}

		return result;
	}

}

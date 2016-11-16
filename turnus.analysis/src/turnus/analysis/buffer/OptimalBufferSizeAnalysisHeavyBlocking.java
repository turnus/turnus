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
import java.util.Map.Entry;

import turnus.adevs.logging.impl.BufferBlockingCollector;
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
import turnus.model.analysis.postprocessing.BufferBlockingReport;
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
public class OptimalBufferSizeAnalysisHeavyBlocking extends Analysis<OptimalBuffersReport> {
	
	/**
	 * Rank buffers by blocked tokens * time blocked.
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

	public OptimalBufferSizeAnalysisHeavyBlocking(TraceProject project) {
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

		// setup the bottlenecks analysis
		Logger.info("Evaluate the initial bottlenecks");
		ScheduledPartialCriticalPathAnalysis pcpAnalysis = new ScheduledPartialCriticalPathAnalysis(project);
		pcpAnalysis.setBufferSize(bufferConfiguration);
		pcpAnalysis.setPartitioning(partitioning);
		pcpAnalysis.setWeighter(weighter);
		pcpAnalysis.setCommunicationWeight(communication);
		pcpAnalysis.setSchedulingWeight(scheduling);
		pcpAnalysis.setConfiguration(configuration);
		
		// create a collector for all blockings (also non-critical)
		BufferBlockingCollector bbCollector = new BufferBlockingCollector(project.getNetwork());
		pcpAnalysis.registerCollector(bbCollector);
		
		// evaluate the initial bottlenecks and blockings
		BottlenecksWithSchedulingReport initialPcpData = pcpAnalysis.run();
		BufferBlockingReport initialBbData = pcpAnalysis.getPostProcessingReport().getReport(BufferBlockingReport.class);

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
		
		BottlenecksWithSchedulingReport pcpData = initialPcpData;
		BufferBlockingReport bbData = initialBbData;
		
		int iteration = 0;
		double newExecutionTime = 0, tsIncrease = 0, etDecrease = 0;
		double bestExecutionTime = initialPcpData.getExecutionTime();
		boolean movePerformed = true;
		
		for (;;) {
			if (iteration > maxIterations) {
				Logger.info("Maximum number of iterations reached");
				break;
			} else if (!movePerformed) {
				Logger.info("No successful move!");
				break;
			}
			
			movePerformed = false;
			
			Map<Buffer, Double> criticalBlockings = getCriticalBlockings(pcpData);			  // for holding the values
			List<Buffer> criticalBuffers = new ArrayList<Buffer>(criticalBlockings.keySet()); // for sorting
			Collections.sort(criticalBuffers, getBuffersByBlockings(criticalBlockings));      // biggest ratio first
			
			System.out.println("Critical blockings:");
			for (Buffer b : criticalBuffers) {
				System.out.println(b + ", tokens * time: " + criticalBlockings.get(b));
			}
			
			Map<Buffer, Double> otherBlockings = getOtherBlockings(bbData, criticalBlockings);// could be int, but then another Comparator would be needed
			List<Buffer> otherBuffers = new ArrayList<Buffer>(otherBlockings.keySet());
			Collections.sort(otherBuffers, getBuffersByBlockings(otherBlockings));            // biggest number of blockings first
			
			System.out.println("Other blockings:");
			for (Buffer b : otherBuffers) {
				System.out.println(b + ", tokens * time: " + otherBlockings.get(b));
			}

			// STEP 1: iterate over buffers with critical blockings
			for (Buffer buffer : criticalBuffers) {
				if (iteration > maxIterations) {
					Logger.info("Maximum number of iterations reached");
					break;
				}
				bufferConfiguration.setSize(buffer, bufferConfiguration.getSize(buffer) * 2);
				pcpAnalysis.setBufferSize(bufferConfiguration);
				pcpData = pcpAnalysis.run();
				bbData = pcpAnalysis.getPostProcessingReport().getReport(BufferBlockingReport.class);
				iteration++;
				newExecutionTime = pcpData.getExecutionTime();
				if (newExecutionTime < bestExecutionTime) {
					// store the partial results
					BoundedBuffersReport newData = getNewBufferData(bufferConfiguration);
					OptimalBufferData data = f.createOptimalBufferData();
					data.setBufferData(newData);
					data.setBottlenecksData(pcpData);
					report.getBuffersData().add(data);
					
					// vs initial
					tsIncrease = (((double) newData.getTokenSize()) / initialBufferData.getTokenSize() - 1) * 100.0;
					etDecrease = ((initialPcpData.getExecutionTime() - newExecutionTime) / initialPcpData.getExecutionTime()) * 100.0;
					
					Logger.info("Optimal buffer size iteration %d >> Execution time reduction: %s, Buffer size increase (tokens): %s ", iteration, format(etDecrease) + "%", format(tsIncrease) + "%");
					Logger.info("Increased buffer:\n" + buffer + " , new size :: " + bufferConfiguration.getSize(buffer));
					
					bestExecutionTime = newExecutionTime;
					movePerformed = true;
					break;
				} else {
					Logger.info("Optimal buffer size iteration %d", iteration);
					Logger.info("Increased buffer:\n" + buffer + " , new size :: " + bufferConfiguration.getSize(buffer) + ", REVERTED");
					bufferConfiguration.setSize(buffer, bufferConfiguration.getSize(buffer) / 2);
				}
			}
			
			// STEP 2: if no success in the previous stage, iterate over other buffers
			if (!movePerformed) {
				for (Buffer buffer : otherBuffers) {
					if (iteration > maxIterations) {
						Logger.info("Maximum number of iterations reached");
						break;
					}
					bufferConfiguration.setSize(buffer, bufferConfiguration.getSize(buffer) * 2);
					pcpAnalysis.setBufferSize(bufferConfiguration);
					pcpData = pcpAnalysis.run();
					bbData = pcpAnalysis.getPostProcessingReport().getReport(BufferBlockingReport.class);
					iteration++;
					newExecutionTime = pcpData.getExecutionTime();
					if (newExecutionTime < bestExecutionTime) {
						// store the partial results
						BoundedBuffersReport newData = getNewBufferData(bufferConfiguration);
						OptimalBufferData data = f.createOptimalBufferData();
						data.setBufferData(newData);
						data.setBottlenecksData(pcpData);
						report.getBuffersData().add(data);
						
						// vs initial
						tsIncrease = (((double) newData.getTokenSize()) / initialBufferData.getTokenSize() - 1) * 100.0;
						etDecrease = ((initialPcpData.getExecutionTime() - newExecutionTime) / initialPcpData.getExecutionTime()) * 100.0;
						
						Logger.info("Optimal buffer size iteration %d >> Execution time reduction: %s, Buffer size increase (tokens): %s ", iteration, format(etDecrease) + "%", format(tsIncrease) + "%");
						Logger.info("Increased buffer:\n" + buffer + " , new size :: " + bufferConfiguration.getSize(buffer));
						
						bestExecutionTime = newExecutionTime;
						movePerformed = true;
						break;
					} else {
						Logger.info("Optimal buffer size iteration %d", iteration);
						Logger.info("Increased buffer:\n" + buffer + " , new size :: " + bufferConfiguration.getSize(buffer) + ", REVERTED");
						bufferConfiguration.setSize(buffer, bufferConfiguration.getSize(buffer) / 2);
					}
				}
			}
		}	

		return report;
	}
	
	private Map<Buffer, Double> getCriticalBlockings(BottlenecksWithSchedulingReport pcpReport) {
		Map<Buffer, Double> result = new HashMap<>();
		
		for (ActionBottlenecksWithSchedulingData data : pcpReport.getActionsData()) {
			Map<Buffer, Double> bb = data.getMaxBlockedMultiplication();
			for (Entry<Buffer, Double> b : bb.entrySet()) {
				if (!result.containsKey(b.getKey())) {
					result.put(b.getKey(), b.getValue());
				} else if (b.getValue() > result.get(b.getKey())) {
					result.put(b.getKey(), b.getValue());
				}
			}
		}
		
		return result;
	}
	
	private Map<Buffer, Double> getOtherBlockings(BufferBlockingReport bbReport, Map<Buffer, Double> criticalBlockings) {
		List<Buffer> nonCriticalBuffers = new ArrayList<Buffer>();
		for (Buffer b : network.getBuffers()) {
			nonCriticalBuffers.add(b);
		}
		nonCriticalBuffers.removeAll(criticalBlockings.keySet());
		
		Map<Buffer, Double> result = new HashMap<>();
		for (Buffer b : nonCriticalBuffers) {
			if (bbReport.getMaxBlockedMultiplication().keySet().contains(b))
				result.put(b, (double)bbReport.getMaxBlockedMultiplication().get(b));
		}
		
		return result;
	}
	
	public Comparator<Buffer> getBuffersByBlockings(Map<Buffer, Double> buffers)
	{   
	 Comparator<Buffer> comp = new Comparator<Buffer>(){
	     @Override
	     public int compare(Buffer b1, Buffer b2)
	     {
	    	 double value1 = buffers.get(b1);
	    	 double value2 = buffers.get(b2);
	    	
	    	 if (value1 > value2)
	    		 return -1;
	    	 else if (value1 == value2)
	    		 return 0;
	    	 else
	    		 return 1; // from biggest to smallest
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

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
package turnus.analysis.bottlenecks;

import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import turnus.adevs.logging.DataCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.analysis.bottlenecks.util.CriticalPathCollector;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
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
 * @author Simone Casale-Brunet
 *
 */
public class ScheduledPartialCriticalPathAnalysis extends Analysis<BottlenecksWithSchedulingReport> {

	public ScheduledPartialCriticalPathAnalysis(TraceProject project) {
		super(project);
		this.registeredCollectors = new ArrayList<DataCollector>();
	}

	private String analysisName = "Scheduled critical path evaluation";

	private List<DataCollector> registeredCollectors;
	private PostProcessingReport report;

	private TraceWeighter weighter;
	private NetworkPartitioning partitioning;
	private BufferSize bufferSize;
	private CommunicationWeight communication;
	private SchedulingWeight scheduling;

	public void setWeighter(TraceWeighter weighter) {
		this.weighter = weighter;
	}

	public void setPartitioning(NetworkPartitioning partitioning) {
		this.partitioning = partitioning;
	}

	public void setBufferSize(BufferSize bufferSize) {
		this.bufferSize = bufferSize;
	}

	public void setCommunicationWeight(CommunicationWeight communication) {
		this.communication = communication;
	}

	public void setSchedulingWeight(SchedulingWeight scheduling) {
		this.scheduling = scheduling;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public void setAnalysisName(String analysisName) {
		this.analysisName = analysisName;
	}

	public void registerCollector(DataCollector collector) {
		this.registeredCollectors.add(collector);
	}

	public PostProcessingReport getPostProcessingReport() {
		return report;
	}

	@Override
	public BottlenecksWithSchedulingReport run() throws TurnusException {
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

		if (bufferSize == null) {
			if (configuration.hasValue(BUFFER_SIZE_FILE)) {
				File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
				XmlBufferSizeReader reader = new XmlBufferSizeReader();
				bufferSize = reader.load(bufferFile);
			} else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) { // if both parameters are specified, then the
																		// default one is ignored
				int defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
				bufferSize = new BufferSize(project.getNetwork());
				bufferSize.setDefaultSize(defaultBufferSize);
			} else {
				throw new TurnusException("Buffer sizes are not specified.");
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

		Logger.info("%s [STARTED]", analysisName);
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		SimEngine simulation = new SimEngine();
		simulation.setTraceProject(project);
		simulation.setTraceWeighter(weighter);
		simulation.setNetworkPartitioning(partitioning);
		simulation.setBufferSize(bufferSize);
		simulation.setSchedulingWeight(scheduling);
		simulation.setCommunicationWeight(communication);

		if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING, true)) {
			simulation.setReleaseAfterProcessing();
		}

		CriticalPathCollector cpCollector = new CriticalPathCollector(project.getNetwork(), partitioning);
		registeredCollectors.add(cpCollector);
		for (DataCollector collector : registeredCollectors) {
			simulation.addDataCollector(collector);
		}

		report = simulation.run();

		if (simulation.isDeadlocked()) {
			Logger.warning("The simulation deadlocked");
		}

		Logger.info("%s [ENDED]", analysisName);

		BottlenecksWithSchedulingReport bottlenecksWithSchedulingReport = report
				.getReport(BottlenecksWithSchedulingReport.class);
		bottlenecksWithSchedulingReport.setDeadlock(simulation.isDeadlocked());

		return bottlenecksWithSchedulingReport;
	}

}

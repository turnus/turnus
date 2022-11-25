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
package turnus.adevs.simulation.Heter;

import static turnus.common.TurnusOptions.*;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlBufferSizeWriter;
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
 * @author Malgorzata Michalska
 * @author Aurelien Bloch
 *
 */
public class SimEngineGPUStaticCli implements IApplication {

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		SimEngineGPUStaticCli cliApp = null;

		try {
			cliApp = new SimEngineGPUStaticCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error("Application error: %s", e.getMessage());
		}
	}

	private Configuration configuration;
	private SimEngine simulation;

	private IProgressMonitor monitor = new NullProgressMonitor();
	
	public enum FifoType {CPU, GPU, HOSTFIFO};

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser().setOption(TRACE_FILE, true)//
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(MAPPING_FILE, true)//
				.setOption(TRACE_WEIGHTER, false)//
				.setOption(COMMUNICATION_WEIGHTS, false) //
				.setOption(SCHEDULING_WEIGHTS, false) //
				.setOption(WRITE_HIT_CONSTANT, false) //
				.setOption(WRITE_MISS_CONSTANT, false) //
				.setOption(BUFFER_SIZE_DEFAULT, false)//
				.setOption(BUFFER_SIZE_FILE, false)//
				.setOption(RECORD_BUFFERS, false)//
				.setOption(RELEASE_BUFFERS_AFTER_PROCESSING, false)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}
	
	
	
	private PostProcessingReport run() throws TurnusException {
		monitor.beginTask("Post processing simulation", IProgressMonitor.UNKNOWN);

		TraceProject tProject = null;
		TraceWeighter tWeighter = null;
		SchedulingWeight schWeight = null;
		SchedulingWeight schWeightCPU = null;
		SchedulingWeight schWeightGPU = null;
		NetworkPartitioning partitioning = null;
		CommunicationWeight communication = null;
		CommunicationWeight communicationCPU = null;
		CommunicationWeight communicationGPU = null;
		CommunicationWeight communicationCPUHostFifo = null;
		CommunicationWeight communicationGPUHostFifo = null;
		HeterComWeight heterComWeight = null;
		BufferSize bufferSize = null;
		int defaultBufferSize = 0;
		NetworkWeight weights = null;
		NetworkWeight weightsCPU = null;
		NetworkWeight weightsGPU = null;
		Network network = null;
		PostProcessingReport report = null;
		
		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				tProject = TraceProject.open(traceFile);
				tProject.loadTrace(new SplittedTraceLoader(), configuration);
				network = tProject.getNetwork();
			} catch (Exception e) {
				throw new TurnusException("Trace file is not valid", e);
			}

			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				File weightsFileCPU = new File(weightsFile.getPath() + "/weights-CPU.exdf");
				File weightsFileGPU = new File(weightsFile.getPath() + "/weights-GPU.exdf");
				weightsCPU = new XmlNetworkWeightReader().load(weightsFileCPU);
				weightsGPU = new XmlNetworkWeightReader().load(weightsFileGPU);
			} catch (Exception e) {
				throw new TurnusException("Weights file is not valid", e);
			}

			try {
				File mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("Mapping file is not valid", e);
			}
			
			if (configuration.getValue(RECORD_BUFFERS)) {
				bufferSize = new BufferSize(tProject.getNetwork());
				bufferSize.setDefaultSize(Integer.MAX_VALUE);
				Logger.info("Record buffers occupancy option chosen. Simulation will be run with all buffer sizes equal to Integer.MAX_VALUE.");
			}
			else if (configuration.hasValue(BUFFER_SIZE_FILE)) {
				File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
				XmlBufferSizeReader reader = new XmlBufferSizeReader();
				bufferSize = reader.load(bufferFile);
			} 
			else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) { // if both parameters are specified, then the default one is ignored
				defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
				bufferSize = new BufferSize(tProject.getNetwork());
				bufferSize.setDefaultSize(defaultBufferSize);
			} 
			else {
				throw new TurnusException("Buffer sizes are not specified.");
			}
			
			if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
				File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
				File communicationWeightsFileCPU = new File(communicationWeightsFile.getPath() + "/weights-CPU.cxdf");
				File communicationWeightsFileGPU = new File(communicationWeightsFile.getPath() + "/weights-GPU.cxdf");
				File communicationWeightsFileCPUHostFifo = new File(communicationWeightsFile.getPath() + "/weights-CPU-HostFifo.cxdf");
				File communicationWeightsFileGPUHostFifo = new File(communicationWeightsFile.getPath() + "/weights-GPU-HostFifo.cxdf");
				communicationCPU = new XmlCommunicationWeightReader(network).load(communicationWeightsFileCPU);
				communicationGPU = new XmlCommunicationWeightReader(network).load(communicationWeightsFileGPU);
				communicationCPUHostFifo = new XmlCommunicationWeightReader(network).load(communicationWeightsFileCPUHostFifo);
				communicationGPUHostFifo = new XmlCommunicationWeightReader(network).load(communicationWeightsFileGPUHostFifo);
				heterComWeight = new HeterComWeight(network, partitioning, communicationCPU, communicationGPU, communicationCPUHostFifo, communicationGPUHostFifo);
			} 
			
			if (configuration.hasValue(SCHEDULING_WEIGHTS)) {
				File schWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
				File schWeightsFileCPU = new File(schWeightsFile.getPath() + "/weights-CPU.sxdf");
				File schWeightsFileGPU = new File(schWeightsFile.getPath() + "/weights-GPU.sxdf");
				schWeightCPU = new XmlSchedulingWeightReader().load(schWeightsFileCPU);
				schWeightGPU = new XmlSchedulingWeightReader().load(schWeightsFileGPU);
			} 
		}
		
		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the simulation");
			try {
				ActorStatisticsCollector actorStatsCollector = new ActorStatisticsCollector(network, partitioning);
				//ActionStatisticsCollector actionStatsCollector = new ActionStatisticsCollector(network);
				//SchedulerChecksCollector schedulingCheckCollector = new SchedulerChecksCollector(network, partitioning);
				//BufferBlockingCollector bufferCollector = new BufferBlockingCollector(network);

				simulation = new SimEngineGPUStatic(configuration, weightsCPU, weightsGPU, schWeightCPU, schWeightGPU, heterComWeight);
				simulation.setTraceProject(tProject);
				simulation.setNetworkPartitioning(partitioning);
				simulation.setBufferSize(bufferSize);
				if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING))
					simulation.setReleaseAfterProcessing();
				
				simulation.addDataCollector(actorStatsCollector);
				//simulation.addDataCollector(actionStatsCollector);
				//simulation.addDataCollector(schedulingCheckCollector);
				//simulation.addDataCollector(bufferCollector);

				report = simulation.run();
			
			} catch (Exception e) {
				throw new TurnusException("The simulation cannot be completed", e);
			}
		}

		{ // STEP 3 : Store the results
			monitor.subTask("Storing the results");
			try {
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("post-processing", configuration);
				}
				
				Logger.infoRaw(report.toString());
				
				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.POST_PROCESSING_REPORT);
				EcoreUtils.storeEObject(report, tProject.getResourceSet(), reportFile);
				Logger.info("Post processing report stored in \"%s\"", reportFile);
				
				// store the actor report
				ActorStatisticsReport actorReport = report.getReport(ActorStatisticsReport.class);
				reportFile = changeExtension(reportFile, TurnusExtensions.POST_PROCESSING_ACTOR_REPORT);
				EcoreUtils.storeEObject(actorReport, tProject.getResourceSet(), reportFile);
				Logger.info("Actor statistics report stored in \"%s\"", reportFile);
			
				/*
				// store the action report
				ActionStatisticsReport actionReport = report.getReport(ActionStatisticsReport.class);
				reportFile = changeExtension(reportFile, TurnusExtensions.POST_PROCESSING_ACTION_REPORT);
				EcoreUtils.storeEObject(actionReport, tProject.getResourceSet(), reportFile);
				Logger.info("Action statistics report stored in \"%s\"", reportFile);
				
				// store the scheduler checks report
				SchedulerChecksReport schedulerReport = report.getReport(SchedulerChecksReport.class);	
				reportFile = changeExtension(reportFile, TurnusExtensions.SCHEDULER_CHECKS_REPORT);
				EcoreUtils.storeEObject(schedulerReport, tProject.getResourceSet(), reportFile);
				Logger.info("Scheduler checks report stored in \"%s\"", reportFile);
				
				// store the buffer blocking report
				BufferBlockingReport bufferReport = report.getReport(BufferBlockingReport.class);	
				reportFile = changeExtension(reportFile, TurnusExtensions.BUFFER_BLOCKING_REPORT);
				EcoreUtils.storeEObject(bufferReport, tProject.getResourceSet(), reportFile);
				Logger.info("Buffer blocking report stored in \"%s\"", reportFile);
				*/
				
				if (configuration.hasValue(RECORD_BUFFERS) && configuration.getValue(RECORD_BUFFERS)) {
					File bxdfFile = changeExtension(reportFile, TurnusExtensions.BUFFER_SIZE);
					new XmlBufferSizeWriter().write(simulation.getMaxBufferSizeRecorded(), bxdfFile);
					Logger.info("Recorded max buffer configuration stored in \"%s\"", bxdfFile);
				}
				
			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}
		monitor.done();

		return report;
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		try {
			parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS));
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
			return IApplication.EXIT_RELAUNCH;
		}

		try {
			run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
			return IApplication.EXIT_RELAUNCH;
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}
}

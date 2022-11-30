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
package turnus.analysis.partitioning.tabusearch.gpu;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.INITIAL_ALGORITHM;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.TABU_GENERATOR;
import static turnus.common.TurnusOptions.TABU_SIM;
import static turnus.common.TurnusOptions.TABU_CMD;
import static turnus.common.TurnusOptions.TABU_WDIR;
import static turnus.common.TurnusOptions.TABU_P;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.TRACE_WEIGHTER;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.simulation.SimEngine;
import turnus.adevs.simulation.Heter.HeterComWeight;
import turnus.adevs.simulation.Heter.SimEngineGPUDynamic;
import turnus.adevs.simulation.Heter.SimEngineGPUMeasured;
import turnus.adevs.simulation.Heter.SimEngineGPUStatic;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.common.EScheduler;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;

public class TabuSearchGPUCli implements IApplication {
	
	private Configuration configuration;
	private TabuSearchGPU tabuSearch;
	private IProgressMonitor monitor = new NullProgressMonitor();
	
	public static void main(String[] args) {
		ModelsRegister.init();

		TabuSearchGPUCli cliApp = null;

		try {
			cliApp = new TabuSearchGPUCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}
	
	private void run() throws TurnusException {
		monitor.beginTask("Tabu search partitioning analysis", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		TraceWeighter weighter = null;
		NetworkPartitioning partitioning = null;
		String scheduling = null;
		BufferSize bufferSize = null;
		int defaultBufferSize = 0;
		String generator = null;
		String simulator = null;
		String cmd = null;
		String wDir = null;
		SimEngine simulation = null;
		ActorStatisticsReport report = null;

		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			// trace and weights - mandatory
			if (configuration.hasValue(TRACE_FILE)) {
				try {
					File traceFile = configuration.getValue(TRACE_FILE);
					project = TraceProject.open(traceFile);
					project.loadTrace(new SplittedTraceLoader(), configuration);
				} catch (Exception e) {
					throw new TurnusException("The trace project cannot be loaded", e);
				}
			}

			// either the mapping configuration or the scheduling policy must be specified, if both, only the mapping is taken
			if (configuration.hasValue(MAPPING_FILE)) {
				File mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);	
			} 
			else if (configuration.hasValue(SCHEDULING_POLICY)) {
				scheduling = configuration.getValue(SCHEDULING_POLICY);
				if (!schedulingRecognized(scheduling)) {
					scheduling = "UNDEFINED";
					Logger.warning("Scheduling policy not recognized. Full parallel will be assumed by default.");
				}
			} 
			else {
				throw new TurnusException("The mapping configuration or the scheduling policy must be specified.");
			}
			// either the buffer configuration file of default buffer must be specified, if both, only the file is taken
			if (configuration.hasValue(BUFFER_SIZE_FILE)) {
				File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
				XmlBufferSizeReader reader = new XmlBufferSizeReader();
				bufferSize = reader.load(bufferFile);
			} 
			else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) { 
				defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
				bufferSize = new BufferSize(project.getNetwork());
				bufferSize.setDefaultSize(defaultBufferSize);
			}
			
			if (configuration.hasValue(TABU_GENERATOR)) { 
				generator = configuration.getValue(TABU_GENERATOR);
			} 
			
			if (configuration.hasValue(TABU_SIM)) { 
				simulator = configuration.getValue(TABU_SIM);
			} 
			
			if (configuration.hasValue(TABU_CMD)) { 
				cmd = configuration.getValue(TABU_CMD);
			} 
			
			if (configuration.hasValue(TABU_WDIR)) { 
				wDir = configuration.getValue(TABU_WDIR);
			} 
			
			// Create Simulator
			boolean gpuStatic = false;
			if (simulator == null) {
				gpuStatic = true;
				Logger.warning("No neighborhood generator specified, random generator will be used.");
			} else {
				if (simulator.equals("STATIC")) {
					gpuStatic = true;
				} else if (simulator.equals("DYNAMIC")) {
					File weightsFile = configuration.getValue(ACTION_WEIGHTS);
					NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
					
					File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
					XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(project.getNetwork());
					CommunicationWeight communication = reader.load(communicationWeightsFile);
					
					File schWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
					SchedulingWeight schWeight = new XmlSchedulingWeightReader().load(schWeightsFile); 
					
					simulation = new SimEngineGPUDynamic(configuration, weights, schWeight, communication, cmd, wDir);
				} else if (simulator.equals("MEASURED")) {
					simulation = new SimEngineGPUMeasured(cmd, project);
				} else {
					gpuStatic = true;
					Logger.warning("Simulator %s not recognized, default engine will be used.", simulator);
				}
			}
			
			if (gpuStatic) {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				File weightsFileCPU = new File(weightsFile.getPath() + "/weights-CPU.exdf");
				File weightsFileGPU = new File(weightsFile.getPath() + "/weights-GPU.exdf");
				NetworkWeight weightsCPU = new XmlNetworkWeightReader().load(weightsFileCPU);
				NetworkWeight weightsGPU = new XmlNetworkWeightReader().load(weightsFileGPU);
				
				File schWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
				File schWeightsFileCPU = new File(schWeightsFile.getPath() + "/weights-CPU.sxdf");
				File schWeightsFileGPU = new File(schWeightsFile.getPath() + "/weights-GPU.sxdf");
				SchedulingWeight schWeightCPU = new XmlSchedulingWeightReader().load(schWeightsFileCPU);
				SchedulingWeight schWeightGPU = new XmlSchedulingWeightReader().load(schWeightsFileGPU);
				
				File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
				File communicationWeightsFileCPU = new File(communicationWeightsFile.getPath() + "/weights-CPU.cxdf");
				File communicationWeightsFileGPU = new File(communicationWeightsFile.getPath() + "/weights-GPU.cxdf");
				File communicationWeightsFileCPUHostFifo = new File(communicationWeightsFile.getPath() + "/weights-CPU-HostFifo.cxdf");
				File communicationWeightsFileGPUHostFifo = new File(communicationWeightsFile.getPath() + "/weights-GPU-HostFifo.cxdf");
				CommunicationWeight communicationCPU = new XmlCommunicationWeightReader(project.getNetwork()).load(communicationWeightsFileCPU);
				CommunicationWeight communicationGPU = new XmlCommunicationWeightReader(project.getNetwork()).load(communicationWeightsFileGPU);
				CommunicationWeight communicationCPUHostFifo = new XmlCommunicationWeightReader(project.getNetwork()).load(communicationWeightsFileCPUHostFifo);
				CommunicationWeight communicationGPUHostFifo = new XmlCommunicationWeightReader(project.getNetwork()).load(communicationWeightsFileGPUHostFifo);
				HeterComWeight heterComWeight = new HeterComWeight(project.getNetwork(), partitioning, communicationCPU, communicationGPU, communicationCPUHostFifo, communicationGPUHostFifo);
				
				simulation = new SimEngineGPUStatic(configuration, weightsCPU, weightsGPU, schWeightCPU, schWeightGPU, heterComWeight);
			}
			
			simulation.setTraceProject(project);
			simulation.setBufferSize(bufferSize);
			if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING)) {
				simulation.setReleaseAfterProcessing();
			}
			
		}

		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				tabuSearch = new TabuSearchGPU(project, weighter);
				tabuSearch.setConfiguration(configuration);
				tabuSearch.setGenerator(generator);
				tabuSearch.setSimulation(simulation);
				if (partitioning == null) {
					tabuSearch.generateInitialPartitioning(scheduling);
				}
				else {
					tabuSearch.loadPartitioning(partitioning);
				}
				report = tabuSearch.run();
//				Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e);
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
					outputPath = createOutputDirectory("partitioning", configuration);
				}

				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.POST_PROCESSING_ACTOR_REPORT);
				EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
				Logger.info("Tabu search partitioning report stored in \"%s\"", reportFile);

				File xcfFile = changeExtension(reportFile, TurnusExtensions.NETWORK_PARTITIONING);
				new XmlNetworkPartitioningWriter().write(tabuSearch.getFinalPartition(), xcfFile);
				Logger.info("Network partitioning configuration stored in \"%s\"", xcfFile);

			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}
		monitor.done();
	}
	
	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()
				.setOption(TRACE_FILE, true)//
				.setOption(ACTION_WEIGHTS, false)//
				.setOption(TRACE_WEIGHTER, false)//
				.setOption(COMMUNICATION_WEIGHTS, false)//
				.setOption(SCHEDULING_WEIGHTS, false)//
				.setOption(MAPPING_FILE, false)//
				.setOption(SCHEDULING_POLICY, false)//
				.setOption(INITIAL_ALGORITHM, false)//
				.setOption(TABU_GENERATOR, false)//
				.setOption(TABU_SIM, false)//
				.setOption(TABU_CMD, false)//
				.setOption(TABU_WDIR, false)//
				.setOption(ANALYSIS_PARTITIONING_UNITS, false)//
				.setOption(BUFFER_SIZE_DEFAULT, false)//
				.setOption(BUFFER_SIZE_FILE, false)//
				.setOption(TABU_P, false)//
				.setOption(ANALYSIS_TIME, false)//
				.setOption(RELEASE_BUFFERS_AFTER_PROCESSING, false)//
				.setOption(OUTPUT_DIRECTORY, false);

		configuration = cliParser.parse(args);
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
		if (tabuSearch != null) {
			tabuSearch.cancel();
		}
	}

	public void start(Configuration configuration, IProgressMonitor monitor) throws TurnusException {
		this.configuration = configuration;
		this.monitor = monitor;
		run();
	}
	
	private boolean schedulingRecognized(String scheduling) {
		for (EScheduler scheduler : EScheduler.VALUES) {
			if (scheduler.getLiteral().equals(scheduling))
				return true;
		}
		
		return false;
	}
}

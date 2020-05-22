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
package turnus.analysis.partitioning.test;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.INITIAL_ALGORITHM;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;
import static turnus.common.TurnusOptions.TABU_P;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.TRACE_WEIGHTER;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.partitioning.WorkloadBalancePartitioning;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.configuration.Option;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.common.EScheduler;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlBufferSizeWriter;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class AlgorithmTestsCli implements IApplication {
	
	private Configuration configuration;
	private IProgressMonitor monitor = new NullProgressMonitor();
	private static int units = 1;
	
	public static final Option<File> MAPPING_FILES_LIST = Option.create().//
			setName("testList").//
			setDescription("List of mapping configurations to test. ").//
			setLongName("turnus.analysis.partitioning.mapping.FilesList").//
			setType(File.class).build();
	
	public static void main(String[] args) {
		
		ModelsRegister.init();

		AlgorithmTestsCli cliApp = null;

		try {
			cliApp = new AlgorithmTestsCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}
		
		// check mapping configurations one by one
		/*try {
			File mappingFile = cliApp.configuration.getValue(MAPPING_FILES_LIST);
			FileInputStream input = new FileInputStream(mappingFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line = null;
			int counter = 0;
			while ((line = br.readLine()) != null) {
				cliApp.configuration.setValue(MAPPING_FILE, new File(line));
				cliApp.run(units);
				Logger.info("%d file processed.", ++counter);
			}
			br.close();
		} catch (Exception e) {
			try {
				throw new TurnusException("The list of mapping configurations cannot be loaded.", e);
			} catch (TurnusException e1) {
				e1.printStackTrace();
			}
		}*/

		// or launch analysis with different number of units
		try {
			while (units < 9) {
				cliApp.configuration.setValue(ANALYSIS_PARTITIONING_UNITS, units);
				cliApp.run(units);
				units++;
			}
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}
	
	private void run(int i) throws TurnusException {
		monitor.beginTask("Algorithm test", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		TraceWeighter weighter = null;
		String scheduling = null;
		NetworkPartitioning partitioning = null;
		BufferSize bufferSize = null;
		int defaultBufferSize = 0;
		
		SimEngine simulation = null;
		ActorStatisticsReport report = null;

		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			// trace and weights - mandatory
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
				project.loadTrace(new SplittedTraceLoader(), configuration);
			} catch (Exception e) {
				throw new TurnusException("The trace project cannot be loaded", e);
			}
			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
				weighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("The weights file cannot be loaded", e);
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
			else {
				throw new TurnusException("Buffer sizes are not specified.");
			}
		}

		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				// tabu search
				/*TabuSearch tabuSearch = new TabuSearch(project, weighter, bufferSize);
				tabuSearch.setConfiguration(configuration);
				if (partitioning == null) {
					tabuSearch.generateInitialPartitioning(scheduling);
				}
				else {
					tabuSearch.loadPartitioning(partitioning);
				}
				report = tabuSearch.run();*/
				
				// idle local search
				/*IdleLocalSearch idleSearch = new IdleLocalSearch(project, weighter, partitioning, bufferSize);
				idleSearch.setConfiguration(configuration);
				report = idleSearch.run();*/
				
				// comm frequency local search
				/*CommFreqLocalSearch commFreqSearch = new CommFreqLocalSearch(project, weighter, partitioning, bufferSize);
				commFreqSearch.setConfiguration(configuration);
				report = commFreqSearch.run();*/
				
				// Kerninghan Lin
				/*CommunicationCostPartitioning ccp = new CommunicationCostPartitioning(project);
				ccp.setConfiguration(configuration);
				try {
					partitioning = ccp.run().asNetworkPartitioning();
				} catch (TurnusException e) {
					e.printStackTrace();
				}
				if (scheduling != null)
					partitioning.setSchedulerToAll(scheduling);
				*/
				
				// Workload Balance
				WorkloadBalancePartitioning wbp = new WorkloadBalancePartitioning(project, weighter);
				wbp.setConfiguration(configuration);
				partitioning = wbp.run().asNetworkPartitioning();
				if (scheduling != null)
					partitioning.setSchedulerToAll(scheduling);
				
				
				// Balanced Pipeline
				/*BalancedPipelinePartitioning bpp = new BalancedPipelinePartitioning(project, weighter);
				bpp.setConfiguration(configuration);
				partitioning = bpp.run().asNetworkPartitioning();
				if (scheduling != null)
					partitioning.setSchedulerToAll(scheduling);
				*/
				
				// Random
				/*PartitioningGenerator pg = new PartitioningGenerator(project, weighter);
				partitioning = pg.generateRandomSolution(configuration);
				if (scheduling != null)
					partitioning.setSchedulerToAll(scheduling);
				*/
				
				ActorStatisticsCollector actorStatsCollector = new ActorStatisticsCollector(project.getNetwork(), partitioning);
				simulation = new SimEngine();
				
				simulation.setTraceProject(project);
				simulation.setTraceWeighter(weighter);
				simulation.setNetworkPartitioning(partitioning);
				simulation.setBufferSize(bufferSize); //FIXME: communication adn scheduling are missing
				simulation.addDataCollector(actorStatsCollector);
				simulation.setReleaseAfterProcessing(); //FIXME: should be optional
			

				report = (ActorStatisticsReport)simulation.run().getReports().get(0);
				
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
				Logger.info("Report stored in \"%s\"", reportFile);

				File xcfFile = changeExtension(reportFile, TurnusExtensions.NETWORK_PARTITIONING);
				new XmlNetworkPartitioningWriter().write(report.asNetworkPartitioning(), xcfFile);
				Logger.info("Network partitioning configuration stored in \"%s\"", xcfFile);
				
			
				File bxdfFile = changeExtension(reportFile, TurnusExtensions.BUFFER_SIZE);
				new XmlBufferSizeWriter().write(simulation.getMaxBufferSizeRecorded(), bxdfFile);
				Logger.info("Recorded max buffer configuration stored in \"%s\"", bxdfFile);
				

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
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(TRACE_WEIGHTER, false)//
				.setOption(MAPPING_FILE, false)//
				.setOption(SCHEDULING_POLICY, false)//
				.setOption(INITIAL_ALGORITHM, false)//
				.setOption(ANALYSIS_PARTITIONING_UNITS, false)//
				.setOption(BUFFER_SIZE_DEFAULT, false)//
				.setOption(BUFFER_SIZE_FILE, false)//
				.setOption(TABU_P, false)//
				.setOption(ANALYSIS_TIME, false)//
				.setOption(OUTPUT_DIRECTORY, false)//
				.setOption(MAPPING_FILES_LIST, false);

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
			run(units);
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
			return IApplication.EXIT_RELAUNCH;
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}

	public void start(Configuration configuration, IProgressMonitor monitor) throws TurnusException {
		this.configuration = configuration;
		this.monitor = monitor;
		run(units);
	}
	
	private boolean schedulingRecognized(String scheduling) {
		for (EScheduler scheduler : EScheduler.VALUES) {
			if (scheduler.getLiteral().equals(scheduling))
				return true;
		}
		
		return false;
	}
}

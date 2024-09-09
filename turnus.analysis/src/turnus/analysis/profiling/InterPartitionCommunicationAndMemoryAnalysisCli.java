/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 Endri Bezati
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
package turnus.analysis.profiling;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTGOING_BUFFER_IS_OWNED_BY_SRC_PARTITION;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
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
 * Inter-partitioning communication and memory estimation analysis
 * 
 * @author Endri Bezati
 */
public class InterPartitionCommunicationAndMemoryAnalysisCli implements IApplication {

	private Configuration configuration;

	private IProgressMonitor monitor = new NullProgressMonitor();

	private InterPartitionCommunicationAndMemoryAnalysis analysis;

	public static void main(String[] args) {
		ModelsRegister.init();

		InterPartitionCommunicationAndMemoryAnalysisCli cliApp = null;
		try {
			cliApp = new InterPartitionCommunicationAndMemoryAnalysisCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			Logger.error("Application error: %s", e.getMessage());
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}

	}

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()//
				.setOption(TRACE_FILE, true)//
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(MAPPING_FILE, true)//
				.setOption(BUFFER_SIZE_FILE, true)//
				.setOption(COMMUNICATION_WEIGHTS, false)//
				.setOption(OUTGOING_BUFFER_IS_OWNED_BY_SRC_PARTITION, false)//
				.setOption(OUTPUT_DIRECTORY, false);

		configuration = cliParser.parse(args);
	}

	private void run() throws TurnusException {
		monitor.beginTask("Inter partition communication and memory analysis", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		TraceWeighter weighter = null;
		NetworkPartitioning partitioning = null;
		CommunicationWeight communication = null;
		BufferSize bufferSize = null;
		boolean outgoingBufferOwnedBySource = false;
		InterPartitionCommunicationAndMemoryReport report = null;
		File mappingFile = null;
		File bufferFile = null;

		{
			// -- Step 1 : parse the configuration
			monitor.subTask("Parse the configuration");

			// -- Trace
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
				project.loadTrace(new SplittedTraceLoader(), configuration);
			} catch (Exception e) {
				throw new TurnusException("The trace project cannot be loaded.", e);
			}

			// -- Weights
			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
				weighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("The weights file cannot be loaded.", e);
			}

			// -- Mapping configuration
			try {
				mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("The mapping configuration file cannot be loaded.", e);
			}
			// -- Buffer configuration
			try {
				bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
				XmlBufferSizeReader reader = new XmlBufferSizeReader();
				bufferSize = reader.load(bufferFile);
			} catch (Exception e) {
				throw new TurnusException("The buffer configuration file cannot be loaded.", e);
			}
			if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
				File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
				XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(project.getNetwork());
				communication = reader.load(communicationWeightsFile);

			}
			// -- Outgoing buffer owned by source partition
			if (configuration.getValue(OUTGOING_BUFFER_IS_OWNED_BY_SRC_PARTITION)) {
				outgoingBufferOwnedBySource = true;
			}

		}

		{
			// -- STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				analysis = new InterPartitionCommunicationAndMemoryAnalysis(project, weighter, bufferSize, partitioning,
						communication, outgoingBufferOwnedBySource);
				analysis.setConfiguration(configuration);
				report = analysis.run();
				Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e);
			}
		}
		{
			// -- STEP 3 : Store the results
			monitor.subTask("Storing the results");
			try {
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("profiling", configuration);
				}
				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.INTER_PARTITION_COMM_MEM_REPORT);

				// -- Set path of the partition file
				report.setMappingFile(mappingFile.getName());
				// -- Set path of the buffer file
				report.setBufferFile(bufferFile.getName());

				// -- Store the report
				EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
				Logger.info("Inter-partition communication and memory report stored in \"%s\"", reportFile);

			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}

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
		if (analysis != null) {
			analysis.cancel();
		}
	}

	public void start(Configuration configuration, IProgressMonitor monitor) throws Exception {
		this.configuration = configuration;
		this.monitor = monitor;
		run();
	}

}

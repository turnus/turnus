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
package turnus.analysis.timeline;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_NAME;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_AS_ANALYSIS_NAME;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.RECORD_BUFFERS;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.TRACE_WEIGHTER;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createFile;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.simulation.SimEngine;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.TimelineReport;
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
 * @author Endri Bezati
 *
 */
public class TimelineCli implements IApplication {

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		TimelineCli cliApp = null;

		try {
			cliApp = new TimelineCli();
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

	private Configuration configuration;
	private SimEngine simulation;

	private IProgressMonitor monitor = new NullProgressMonitor();

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
				.setOption(ANALYSIS_NAME, false)//
				.setOption(MAPPING_AS_ANALYSIS_NAME, false)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}

	private PostProcessingReport run() throws TurnusException {
		monitor.beginTask("Post processing simulation", IProgressMonitor.UNKNOWN);
		TraceProject tProject = null;
		TraceWeighter tWeighter = null;
		SchedulingWeight schWeight = null;
		NetworkPartitioning partitioning = null;
		CommunicationWeight communication = null;
		BufferSize bufferSize = null;
		int defaultBufferSize = 0;
		NetworkWeight weights = null;
		Network network = null;
		PostProcessingReport report = null;
		String analysisName = "";
		File mappingFile = null;

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
				weights = new XmlNetworkWeightReader().load(weightsFile);
				tWeighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("Weights file is not valid", e);
			}

			try {
				mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("Mapping file is not valid", e);
			}

			if (configuration.hasValue(BUFFER_SIZE_FILE)) {
				File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
				XmlBufferSizeReader reader = new XmlBufferSizeReader();
				bufferSize = reader.load(bufferFile);
			} else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) { // if both parameters are specified, then the //
																		// default one is ignored
				defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
				bufferSize = new BufferSize(tProject.getNetwork());
				bufferSize.setDefaultSize(defaultBufferSize);
			} else if (configuration.hasValue(RECORD_BUFFERS)) {
				if (configuration.getValue(RECORD_BUFFERS)) {
					bufferSize = new BufferSize(tProject.getNetwork());
					bufferSize.setDefaultSize(Integer.MAX_VALUE);
					Logger.info(
							"Record buffers occupancy option chosen. Simulation will be run with all buffer sizes equal to Integer.MAX_VALUE.");
				}
			} else {
				throw new TurnusException("Buffer sizes are not specified.");
			}

			if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
				File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
				XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(network);
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
				schWeight = new XmlSchedulingWeightReader().load(schWeightsFile);
			}

			// -- Name of the analysis
			try {

				if (configuration.hasValue(MAPPING_AS_ANALYSIS_NAME)) {
					analysisName = mappingFile.getName();
					analysisName = analysisName.substring(0, analysisName.lastIndexOf('.'));
				}

				// -- analysis name has priority over the MAPPING_AS_ANALYSIS_NAME
				if (configuration.hasValue(ANALYSIS_NAME)) {
					analysisName = configuration.getValue(ANALYSIS_NAME);
				}

			} catch (Exception e) {
				throw new TurnusException("The given name has an issue", e);
			}
		}

		TimelineCollector timelineCollector = new TimelineCollector(network, partitioning);
		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the simulation");
			try {

				simulation = new SimEngine();
				simulation.setTraceProject(tProject);
				simulation.setTraceWeighter(tWeighter);
				simulation.setNetworkPartitioning(partitioning);
				simulation.setBufferSize(bufferSize);
				simulation.setCommunicationWeight(communication);
				simulation.setSchedulingWeight(schWeight);
				if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING))
					simulation.setReleaseAfterProcessing();

				simulation.addDataCollector(timelineCollector);

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

				// Logger.infoRaw(report.toString());

				// store the scheduler checks report

				File reportFileTimeline;

				if (analysisName.isEmpty()) {
					reportFileTimeline = createFileWithTimeStamp(outputPath, TurnusExtensions.TIMELINE_REPORT);
				} else {
					reportFileTimeline = createFile(outputPath, analysisName, TurnusExtensions.TIMELINE_REPORT);
				}

				TimelineReport timelineReport = report.getReport(TimelineReport.class);
				EcoreUtils.storeEObject(timelineReport, tProject.getResourceSet(), reportFileTimeline);
				Logger.info("Timeline report stored in \"%s\"", reportFileTimeline);

				File jsonFile = changeExtension(reportFileTimeline, TurnusExtensions.JSON);
				// JsonObject trace =
				// simulation.getJsonObject(jsonFile.getName());//timelineCollector.getJsonObject(jsonFile.getName());
				JsonObject trace = timelineCollector.getJsonObject(jsonFile.getName());

				try (FileWriter jsonTraceFile = new FileWriter(jsonFile)) {
					JsonWriterFactory writerFactory = Json.createWriterFactory(null);
					JsonWriter jsonWriter = writerFactory.createWriter(jsonTraceFile);

					jsonWriter.write(trace);

					jsonWriter.close();
				} catch (IOException e) {
					throw new TurnusException("The simulation cannot be completed", e);
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

	public void start(Configuration configuration, IProgressMonitor monitor) throws Exception {
		this.configuration = configuration;
		this.monitor = monitor;
		run();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}
}

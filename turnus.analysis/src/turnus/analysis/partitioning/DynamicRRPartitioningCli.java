package turnus.analysis.partitioning;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_NAME;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
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
import static turnus.common.util.FileUtils.createFile;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.dot.PartitionedNetworkToDot;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

public class DynamicRRPartitioningCli implements IApplication {

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		DynamicRRPartitioningCli cliApp = null;

		try {
			cliApp = new DynamicRRPartitioningCli();
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
				.setOption(ANALYSIS_PARTITIONING_UNITS, true).setOption(TRACE_WEIGHTER, false)//
				.setOption(COMMUNICATION_WEIGHTS, false) //
				.setOption(SCHEDULING_WEIGHTS, false) //
				.setOption(WRITE_HIT_CONSTANT, false) //
				.setOption(WRITE_MISS_CONSTANT, false) //
				.setOption(BUFFER_SIZE_DEFAULT, false)//
				.setOption(BUFFER_SIZE_FILE, false)//
				.setOption(RELEASE_BUFFERS_AFTER_PROCESSING, false)//
				.setOption(ANALYSIS_NAME, false)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}

	public class AllocationCollector implements ActorDataCollector {

		private Map<Actor, String> allocation;
		Network network;
		int nPE;

		public AllocationCollector(Network network, int nPE) {
			this.network = network;
			this.nPE = nPE;
		}

		@Override
		public void init() {
			allocation = new HashMap<>();
		}

		@Override
		public void logEndSimulation(double time) {
		}

		@Override
		public PostProcessingData generateReport() {

			return null;
		}

		public NetworkPartitioning getPartitioning() {
			NetworkPartitioning partitioning = new NetworkPartitioning(network);
			for (Actor actor : network.getActors()) {
				partitioning.setPartition(actor, allocation.get(actor));
			}

			// -- PE to 1 and round robin scheduling
			for (int i = 0; i < nPE; i++) {
				partitioning.setProcessingElements("p" + i, 1);
				partitioning.setScheduler("p" + i, "ROUND_ROBIN");
			}
			return partitioning;
		}

		@Override
		public void logIsSchedulable(Action action, long stepId, double time) {

		}

		@Override
		public void logIsEnabled(Action action, long stepId, double time) {

		}

		@Override
		public void logStartProcessing(Action action, long stepId, double time) {
		}

		@Override
		public void logEndProcessing(Action action, long stepId, double time) {

		}

		@Override
		public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
			Actor actor = action.getOwner();
			allocation.put(actor, "p" + core);

		}

		@Override
		public void logStartProducing(Action action, long stepId, double time) {
		}

		@Override
		public void logEndFiring(Action action, long stepId, double time) {
		}

		@Override
		public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		}

		@Override
		public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		}

		@Override
		public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		}

		@Override
		public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		}

		@Override
		public void logEndProduceTokens(Action action, long stepId, Buffer buffer, double time) {
			// TODO Auto-generated method stub

		}

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
		int numberOfPEs = 2;
		String analysisName = "";

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

			if (configuration.hasValue(ANALYSIS_PARTITIONING_UNITS)) {
				numberOfPEs = configuration.getValue(ANALYSIS_PARTITIONING_UNITS);
			}

			// -- Create a single partition
			partitioning = new NetworkPartitioning(network);
			for (Actor actor : network.getActors()) {
				partitioning.setPartition(actor, "p1");
			}

			// -- Define the Scheduling policy and the number of the processing elements
			partitioning.setScheduler("p1", "ROUND_ROBIN");
			partitioning.setProcessingElements("p1", numberOfPEs);

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

				// -- analysis name has priority over the MAPPING_AS_ANALYSIS_NAME
				if (configuration.hasValue(ANALYSIS_NAME)) {
					analysisName = configuration.getValue(ANALYSIS_NAME);
				}

			} catch (Exception e) {
				throw new TurnusException("The given name has an issue", e);
			}
		}

		AllocationCollector allocationCollector = new AllocationCollector(network, numberOfPEs);
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

				simulation.addDataCollector(allocationCollector);

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
					outputPath = createOutputDirectory("partitioning", configuration);
				}

				File xcfFile;
				
				if (analysisName.isEmpty()) {
					xcfFile = createFileWithTimeStamp(outputPath, TurnusExtensions.MAPPING);
				} else {
					xcfFile = createFile(outputPath, analysisName, TurnusExtensions.MAPPING);
				}
				
				
				partitioning = allocationCollector.getPartitioning();
				new XmlNetworkPartitioningWriter().write(partitioning, xcfFile);
				File dotFile = changeExtension(xcfFile, TurnusExtensions.DOT);
				new PartitionedNetworkToDot(tProject.getNetwork(), partitioning)
						.emit(FileSystems.getDefault().getPath(dotFile.getAbsolutePath()));
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

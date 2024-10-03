package turnus.analysis.communication;

import static turnus.common.TurnusOptions.ANALYSIS_NAME;
import static turnus.common.TurnusOptions.BANDWIDTH;
import static turnus.common.TurnusOptions.FIXED_OVERHEAD_LATENCY;
import static turnus.common.TurnusOptions.MAPPING_AS_ANALYSIS_NAME;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFile;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Type;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.data.MemoryAccess;
import turnus.model.mapping.io.XmlCommunicationWeightWriter;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

public class LinearCommunicationWeightCli implements IApplication {

	private Configuration configuration;
	private IProgressMonitor monitor = new NullProgressMonitor();

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		LinearCommunicationWeightCli cliApp = null;

		try {
			cliApp = new LinearCommunicationWeightCli();
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

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()//
				.setOption(TRACE_FILE, true)//
				.setOption(MAPPING_FILE, true)//
				.setOption(BANDWIDTH, true) //
				.setOption(FIXED_OVERHEAD_LATENCY, false) //
				.setOption(ANALYSIS_NAME, false)//
				.setOption(MAPPING_AS_ANALYSIS_NAME, false)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}

	private void run() throws TurnusException {
		monitor.beginTask("Inter partition communication and memory analysis", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		NetworkPartitioning partitioning = null;
		File mappingFile = null;
		String analysisName = "";

		double bandwidthGBytes = 25.0;
		double fixedOverheadLatency = 0.0;

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

			// -- Mapping configuration
			try {
				mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("The mapping configuration file cannot be loaded.", e);
			}

			// -- Fixed overhead latency
			try {
				if (configuration.hasValue(FIXED_OVERHEAD_LATENCY)) {
					fixedOverheadLatency = configuration.getValue(FIXED_OVERHEAD_LATENCY);
				}
			} catch (Exception e) {
				throw new TurnusException("The given bandwidth is not correct.", e);
			}
			// -- Bandwidth
			try {
				bandwidthGBytes = configuration.getValue(BANDWIDTH);
			} catch (Exception e) {
				throw new TurnusException("The given bandwidth is not correct.", e);
			}

			// -- Name of the analysis
			try {

				if (configuration.hasValue(MAPPING_AS_ANALYSIS_NAME)) {
					if (configuration.getValue(MAPPING_AS_ANALYSIS_NAME)) {
						analysisName = mappingFile.getName();
						analysisName = analysisName.substring(0, analysisName.lastIndexOf('.'));
					}
				}

				// -- analysis name has priority over the MAPPING_AS_ANALYSIS_NAME
				if (configuration.hasValue(ANALYSIS_NAME)) {
					analysisName = configuration.getValue(ANALYSIS_NAME);
				}

			} catch (Exception e) {
				throw new TurnusException("The given name has an issue", e);
			}

			// -- Get buffers crossing partitions
			Network network = project.getNetwork();

			var readWeights = new HashMap<Buffer, List<MemoryAccess>>();
			var writeWeights = new HashMap<Buffer, List<MemoryAccess>>();

			Map<String, List<String>> pMap = partitioning.asPartitionActorsMap();
			for (String partId : pMap.keySet()) {

				List<String> actorNames = pMap.get(partId);

				List<Actor> actorsInPartition = actorNames.stream().map(network::getActor).collect(Collectors.toList());

				List<Buffer> crossBuffers = new ArrayList<>();

				crossBuffers.addAll(MemoryAndBuffers.getIncomingBuffersOfPartition(actorsInPartition));
				crossBuffers.addAll(MemoryAndBuffers.getOutgoingBuffersOfPartition(actorsInPartition));

				for (Buffer buffer : crossBuffers) {
					Type bufferType = buffer.getType();
					long bits = bufferType.getBits();
					// -- TODO: support other time units apart from ns
					double cost_ns = fixedOverheadLatency + bits / (bandwidthGBytes * 1024 * 1024 * 1024 * 8) * 1e9;
					MemoryAccess readAccess = new MemoryAccess("PCIe", "read", "hit", 1.0, cost_ns);
					MemoryAccess writeAccess = new MemoryAccess("PCIe", "write", "hit", 1.0, cost_ns);

					readWeights.put(buffer, List.of(readAccess));
					writeWeights.put(buffer, List.of(writeAccess));

				}
			}

			// -- Save the communication weights
			CommunicationWeight communicationWeight = new CommunicationWeight();
			communicationWeight.setNetworkName(network.getName());
			communicationWeight.setReadWeights(readWeights);
			//communicationWeight.setWriteWeights(writeWeights);

			{ // STEP 3 : Store the results
				monitor.subTask("Storing the results");
				try {
					File outputPath = null;
					if (configuration.hasValue(OUTPUT_DIRECTORY)) {
						outputPath = configuration.getValue(OUTPUT_DIRECTORY);
						createDirectory(outputPath);
					} else {
						outputPath = createOutputDirectory("communication", configuration);
					}

					File cxdfFile;

					if (analysisName.isEmpty()) {
						cxdfFile = createFileWithTimeStamp(outputPath, TurnusExtensions.COMMUNICATION_WEIGHT);
					} else {
						cxdfFile = createFile(outputPath, analysisName, TurnusExtensions.COMMUNICATION_WEIGHT);
					}
					new XmlCommunicationWeightWriter().write(communicationWeight, network, cxdfFile);

					Logger.info("Network communication weight stored in \"%s\"", cxdfFile);

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
	}

}

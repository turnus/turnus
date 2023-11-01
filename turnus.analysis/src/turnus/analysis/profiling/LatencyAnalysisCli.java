package turnus.analysis.profiling;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.LATENCY_SOURCE;
import static turnus.common.TurnusOptions.LATENCY_TARGETS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import turnus.common.util.Pair;
import turnus.model.ModelsRegister;
import turnus.model.analysis.profiling.LatencyReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * @author Endri Bezati
 */
public class LatencyAnalysisCli implements IApplication {

	private Configuration configuration;

	private IProgressMonitor monitor = new NullProgressMonitor();

	private LatencyAnalysis analysis;

	private Pair<String, String> srcLatency;

	private List<Pair<String, String>> tgtLatencies;

	public static void main(String[] args) {
		ModelsRegister.init();

		LatencyAnalysisCli cliApp = null;

		try {
			cliApp = new LatencyAnalysisCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
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
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(MAPPING_FILE, true)//
				.setOption(BUFFER_SIZE_FILE, true)//
				.setOption(LATENCY_SOURCE, true)//
				.setOption(LATENCY_TARGETS, true)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}

	private void run() throws Exception {
		monitor.beginTask("Latency Analysis", IProgressMonitor.UNKNOWN);
		TraceProject project = null;
		TraceWeighter weighter = null;
		NetworkPartitioning partitioning = null;
		BufferSize bufferSize = null;
		File mappingFile = null;
		File bufferFile = null;
		LatencyReport report = null;
		tgtLatencies = new ArrayList<>();

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

			// -- Source latency actor:action
			try {
				String srcLatencyPair = configuration.getValue(LATENCY_SOURCE);
				String[] actorAction = srcLatencyPair.split(":");

				Network network = project.getNetwork();

				Actor srcActor = network.getActor(actorAction[0]);
				if (srcActor == null) {
					throw new TurnusException("Source actor \"" + actorAction[0] + "\" does not exist.");
				}

				Action srcAction = srcActor.getAction(actorAction[1]);
				if (srcAction == null) {
					throw new TurnusException("Source action \"" + actorAction[1] + "\" does not exist.");
				}
				srcLatency = Pair.create(actorAction[0], actorAction[1]);

			} catch (Exception e) {
				throw new TurnusException("Source latency parse error, " + e.getMessage(), e);
			}

			// -- Target latencies actor:action
			try {
				List<String> targetLatenciesList = configuration.getValue(LATENCY_TARGETS);
				for (String tgtLatency : targetLatenciesList) {
					String[] actorAction = tgtLatency.split(":");

					Network network = project.getNetwork();

					Actor actor = network.getActor(actorAction[0]);
					if (actor == null) {
						throw new TurnusException("target actor \"" + actorAction[0] + "\" does not exist.");
					}

					Action srcAction = actor.getAction(actorAction[1]);
					if (srcAction == null) {
						throw new TurnusException("target action \"" + actorAction[1] + "\" does not exist.");
					}
					Pair<String, String> tgtLatencyPair = Pair.create(actorAction[0], actorAction[1]);
					tgtLatencies.add(tgtLatencyPair);
				}
			} catch (Exception e) {
				throw new TurnusException("Target latency parse error, " + e.getMessage(), e);
			}

		}

		{
			// -- STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				analysis = new LatencyAnalysis(project, weighter, bufferSize, partitioning, srcLatency, tgtLatencies);
				analysis.setConfiguration(configuration);
				report = analysis.run();
				// -- Set path of the partition file
				report.setMappingFile(mappingFile.getName());
				// -- Set path of the buffer file
				report.setBufferFile(bufferFile.getName());
				Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed :" + e.getMessage(), e);
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

				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.LATENCY_REPORT);
				// -- Store the report
				EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
				Logger.info("Latency report stored in \"%s\"", reportFile);

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

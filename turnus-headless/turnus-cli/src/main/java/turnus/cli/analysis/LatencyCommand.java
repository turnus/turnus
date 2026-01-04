package turnus.cli.analysis;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.MAPPING_FILE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.profiling.LatencyAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.common.util.Pair;
import turnus.model.analysis.profiling.LatencyReport;
import turnus.model.analysis.profiling.io.Lprof2HtmlExporter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

@Command(
	name = "latency",
	description = "Run latency analysis (source/target action end-firing timestamps)",
	mixinStandardHelpOptions = true
)
public class LatencyCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "-w", "--weights" }, description = "Action weights file (.exdf)", required = true)
	private File weightsFile;

	@Option(names = { "-m", "--mapping" }, description = "Network partitioning/mapping file (.xml/.xcf)", required = true)
	private File mappingFile;

	@Option(names = { "-b", "--buffer-size" }, description = "Buffer size file (.xml)")
	private File bufferSizeFile;

	@Option(names = { "--buffer-default" }, description = "Default buffer size (tokens) if --buffer-size is not provided")
	private Integer bufferDefault;

	@Option(names = { "--source" }, required = true, description = "Source actor/action pair in form actor:action")
	private String source;

	@Option(names = { "--target" }, required = true, description = "Target actor/action pair in form actor:action. Can be repeated")
	private List<String> targets = new ArrayList<>();

	@Override
	public Integer call() {
		Logger.info("Starting Latency Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			if (bufferSizeFile == null && (bufferDefault == null || bufferDefault <= 0)) {
				Logger.error("You must provide either --buffer-size or --buffer-default");
				return 1;
			}

			Pair<String, String> srcPair = parseActorAction(source);
			List<Pair<String, String>> tgtPairs = new ArrayList<>();
			for (String t : targets) {
				tgtPairs.add(parseActorAction(t));
			}

			Configuration config = new Configuration();
			config.setValue(ACTION_WEIGHTS, weightsFile);
			config.setValue(MAPPING_FILE, mappingFile);

			if (bufferSizeFile != null) {
				config.setValue(BUFFER_SIZE_FILE, bufferSizeFile);
			} else {
				config.setValue(BUFFER_SIZE_DEFAULT, bufferDefault);
			}

			NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
			TraceWeighter weighter = WeighterUtils.getTraceWeighter(config, weights);

			NetworkPartitioning partitioning = new XmlNetworkPartitioningReader().load(mappingFile);

			BufferSize bufferSize;
			if (bufferSizeFile != null) {
				bufferSize = new XmlBufferSizeReader().load(bufferSizeFile);
			} else {
				bufferSize = new BufferSize(project.getNetwork());
				bufferSize.setDefaultSize(bufferDefault);
			}

			LatencyAnalysis analysis = new LatencyAnalysis(project, weighter, bufferSize, partitioning, srcPair, tgtPairs);
			analysis.setConfiguration(config);
			LatencyReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "lprof").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Lprof2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}

	private static Pair<String, String> parseActorAction(String spec) throws TurnusException {
		if (spec == null) {
			throw new TurnusException("Actor/action spec is null");
		}
		String[] parts = spec.split(":", 2);
		if (parts.length != 2 || parts[0].isBlank() || parts[1].isBlank()) {
			throw new TurnusException("Invalid actor/action spec: \"" + spec + "\". Expected actor:action");
		}
		return Pair.create(parts[0].trim(), parts[1].trim());
	}
}

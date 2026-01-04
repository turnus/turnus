package turnus.cli.analysis;

import static turnus.common.TurnusConstants.DEFAULT_MAX_THREADS;
import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.pipelining.PipeliningAlgorithmicImpactAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.pipelining.ImpactAnalysisReport;
import turnus.model.analysis.pipelining.io.Pimpact2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "pimpact",
	description = "Run pipelining algorithmic impact analysis",
	mixinStandardHelpOptions = true
)
public class PimpactCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "-w", "--weights" }, description = "Action weights file (.exdf)", required = true)
	private File weightsFile;

	@Option(names = { "--max-actions" }, description = "Maximum actions to analyze")
	private Integer maxActions;

	@Option(names = { "--max-threads" }, description = "Maximum threads to use (default: ${DEFAULT-VALUE})")
	private int maxThreads = DEFAULT_MAX_THREADS;

	@Option(names = { "--minimize-memory" }, description = "Reduce memory usage (default: ${DEFAULT-VALUE})")
	private boolean minimizeMemoryUsage = DEFAULT_MINIMIZE_MEMORY_USAGE;

	@Override
	public Integer call() {
		Logger.info("Starting Pipelining Impact Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			config.setValue(ACTION_WEIGHTS, weightsFile);
			config.setValue(CONFIG_MAX_THREADS, maxThreads);
			config.setValue(CONFIG_MINIMIZE_MEMORY_USAGE, minimizeMemoryUsage);
			if (maxActions != null && maxActions > 0) {
				config.setValue(ANALYSIS_IMPACT_MAX_ACTIONS, maxActions);
			}

			PipeliningAlgorithmicImpactAnalysis analysis = new PipeliningAlgorithmicImpactAnalysis(project);
			analysis.setConfiguration(config);
			ImpactAnalysisReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "pimpact").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Pimpact2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

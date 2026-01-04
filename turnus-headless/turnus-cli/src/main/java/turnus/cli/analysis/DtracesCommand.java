package turnus.cli.analysis;

import static turnus.common.TurnusConstants.DEFAULT_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.TRACE_FILES_SET;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.trace.comparator.TraceComparatorAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.trace.TraceComparatorReport;
import turnus.model.analysis.trace.io.Dtraces2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "dtraces",
	description = "Compare traces against a reference trace (compressed-trace based)",
	mixinStandardHelpOptions = true
)
public class DtracesCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "Reference trace file (.trace or .tracez)")
	private File referenceTrace;

	@Parameters(index = "1..*", description = "Trace files to compare with the reference")
	private List<File> traces = new ArrayList<>();

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "--max-threads" }, description = "Maximum threads to use (default: ${DEFAULT-VALUE})")
	private int maxThreads = DEFAULT_MAX_THREADS;

	@Override
	public Integer call() {
		Logger.info("Starting Trace Comparator Analysis...");

		try {
			if (traces.isEmpty()) {
				Logger.error("You must provide at least one trace to compare");
				return 1;
			}

			TraceProject project = TraceProject.open(referenceTrace);
			Logger.info("Loaded reference trace: %s", referenceTrace);

			Configuration config = new Configuration();
			config.setValue(CONFIG_MAX_THREADS, maxThreads);

			List<String> tracePaths = new ArrayList<>();
			for (File t : traces) {
				tracePaths.add(t.getAbsolutePath());
			}
			config.setValue(TRACE_FILES_SET, tracePaths);

			TraceComparatorAnalysis analysis = new TraceComparatorAnalysis(project);
			analysis.setConfiguration(config);
			TraceComparatorReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : referenceTrace.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(referenceTrace, "dtraces").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Dtraces2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

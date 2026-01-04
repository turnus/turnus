package turnus.cli.analysis;

import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.pipelining.InternalVariablePipeliningAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;
import turnus.model.analysis.pipelining.io.Varpipe2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "varpipe",
	description = "Run internal variable pipelining analysis",
	mixinStandardHelpOptions = true
)
public class VarpipeCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "--max-threads" }, description = "Maximum threads to use")
	private Integer maxThreads;

	@Override
	public Integer call() {
		Logger.info("Starting Variable Pipelining Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			if (maxThreads != null && maxThreads > 0) {
				config.setValue(CONFIG_MAX_THREADS, maxThreads);
			}

			InternalVariablePipeliningAnalysis analysis = new InternalVariablePipeliningAnalysis(project);
			analysis.setConfiguration(config);
			ActionsVariablePipeliningReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "varpipe").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Varpipe2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

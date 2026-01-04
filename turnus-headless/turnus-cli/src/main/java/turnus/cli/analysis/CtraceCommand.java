package turnus.cli.analysis;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.trace.compressor.CompressedTraceAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.io.Ctrace2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "ctrace",
	description = "Run compressed trace analysis",
	mixinStandardHelpOptions = true
)
public class CtraceCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Override
	public Integer call() {
		Logger.info("Starting Compressed Trace Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			CompressedTraceAnalysis analysis = new CompressedTraceAnalysis(project);
			analysis.setConfiguration(config);
			CompressedTraceReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "ctrace").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Ctrace2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

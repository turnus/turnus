package turnus.cli.analysis;

import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_POW2;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.buffer.MaximalBufferSizeAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.io.Boundbuffer2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "max-buffer",
	description = "Run maximal buffer size analysis (worst-case tokens occupancy)",
	mixinStandardHelpOptions = true
)
public class MaxBufferCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "--pow2" }, description = "Round buffer sizes to power of 2")
	private boolean pow2;

	@Override
	public Integer call() {
		Logger.info("Starting Maximal Buffer Size Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			config.setValue(ANALYSIS_BUFFER_POW2, pow2);

			MaximalBufferSizeAnalysis analysis = new MaximalBufferSizeAnalysis(project);
			analysis.setConfiguration(config);
			BoundedBuffersReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "buffers-max").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Boundbuffer2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

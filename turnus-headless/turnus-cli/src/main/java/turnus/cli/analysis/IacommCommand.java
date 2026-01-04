package turnus.cli.analysis;

import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.profiling.IntraActionCommunicationAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.io.Iacomm2HtmlExporter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.trace.TraceProject;

@Command(
	name = "iacomm",
	description = "Run intra-action communication analysis",
	mixinStandardHelpOptions = true
)
public class IacommCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "-b", "--buffer-size" }, description = "Buffer size file (.xml). Used only when --minimize-memory=true")
	private File bufferSizeFile;

	@Option(names = { "--minimize-memory" }, description = "Reduce memory usage (default: ${DEFAULT-VALUE})")
	private boolean minimizeMemoryUsage = DEFAULT_MINIMIZE_MEMORY_USAGE;

	@Override
	public Integer call() {
		Logger.info("Starting Intra-Action Communication Analysis...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			config.setValue(CONFIG_MINIMIZE_MEMORY_USAGE, minimizeMemoryUsage);

			IntraActionCommunicationAnalysis analysis = new IntraActionCommunicationAnalysis(project);
			analysis.setConfiguration(config);
			if (bufferSizeFile != null) {
				BufferSize bufferSize = new XmlBufferSizeReader().load(bufferSizeFile);
				analysis.setBufferSize(bufferSize);
			}

			IntraActionCommunicationReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "iacomm").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Iacomm2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

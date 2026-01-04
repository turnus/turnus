package turnus.cli.analysis;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_BIT_ACCURATE;
import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_POW2;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.MAX_ITERATIONS;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.buffer.OptimalBufferSizeAnalysisTopDown;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.buffers.OptimalBuffersReport;
import turnus.model.analysis.buffers.io.Optimalbuffer2HtmlExporter;
import turnus.model.trace.TraceProject;

@Command(
	name = "optimal-buffer-topdown",
	description = "Run optimal buffer size analysis (top-down approach)",
	mixinStandardHelpOptions = true
)
public class OptimalBufferTopDownCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The trace file (.trace or .tracez)")
	private File traceFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Option(names = { "-w", "--weights" }, description = "Action weights file (.exdf)", required = true)
	private File weightsFile;

	@Option(names = { "-m", "--mapping" }, description = "Network partitioning/mapping file (.xml/.xcf)", required = true)
	private File mappingFile;

	@Option(names = { "-b", "--buffer-size" }, description = "Initial buffer size file (.xml)")
	private File bufferSizeFile;

	@Option(names = { "-c", "--comm-weight" }, description = "Communication weights file (.cxdf)")
	private File communicationWeightsFile;

	@Option(names = { "--write-hit" }, description = "Write hit constant (latency)")
	private Integer writeHitConstant;

	@Option(names = { "--write-miss" }, description = "Write miss constant (latency)")
	private Integer writeMissConstant;

	@Option(names = { "-s", "--sched-weight" }, description = "Scheduling weights file (.sxdf)")
	private File schedulingWeightsFile;

	@Option(names = { "--release-after-processing" }, description = "Release buffers after processing (default: true)")
	private boolean releaseAfterProcessing = true;

	@Option(names = { "--max-iterations" }, description = "Maximum iterations")
	private Integer maxIterations;

	@Option(names = { "--bit-accurate" }, description = "Use bit-accurate token sizes")
	private boolean bitAccurate;

	@Option(names = { "--pow2" }, description = "Round buffer sizes to power of 2")
	private boolean pow2;

	@Override
	public Integer call() {
		Logger.info("Starting Optimal Buffer Size Analysis (TopDown)...");

		try {
			TraceProject project = TraceProject.open(traceFile);
			Logger.info("Loaded trace: %s", traceFile);

			Configuration config = new Configuration();
			config.setValue(ACTION_WEIGHTS, weightsFile);
			config.setValue(MAPPING_FILE, mappingFile);
			config.setValue(RELEASE_BUFFERS_AFTER_PROCESSING, releaseAfterProcessing);
			config.setValue(ANALYSIS_BUFFER_BIT_ACCURATE, bitAccurate);
			config.setValue(ANALYSIS_BUFFER_POW2, pow2);
			if (maxIterations != null && maxIterations > 0) {
				config.setValue(MAX_ITERATIONS, maxIterations);
			}

			if (bufferSizeFile != null) {
				config.setValue(BUFFER_SIZE_FILE, bufferSizeFile);
			}

			if (communicationWeightsFile != null) {
				config.setValue(COMMUNICATION_WEIGHTS, communicationWeightsFile);
				if (writeHitConstant != null) {
					config.setValue(WRITE_HIT_CONSTANT, writeHitConstant);
				}
				if (writeMissConstant != null) {
					config.setValue(WRITE_MISS_CONSTANT, writeMissConstant);
				}
			} else if (writeHitConstant != null || writeMissConstant != null) {
				Logger.error("--write-hit/--write-miss require --comm-weight");
				return 1;
			}

			if (schedulingWeightsFile != null) {
				config.setValue(SCHEDULING_WEIGHTS, schedulingWeightsFile);
			}

			OptimalBufferSizeAnalysisTopDown analysis = new OptimalBufferSizeAnalysisTopDown(project);
			analysis.setConfiguration(config);
			OptimalBuffersReport report = analysis.run();

			File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
			FileUtils.createDirectory(outDir);

			File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "optimalbuffers-topdown").getName());
			EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
			Logger.info("Report saved to: %s", reportFile);

			File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
			new Optimalbuffer2HtmlExporter().export(report, htmlFile);
			Logger.info("HTML report saved to: %s", htmlFile);

			return 0;
		} catch (TurnusException e) {
			Logger.error("Analysis failed: %s", e.getMessage());
			return 1;
		}
	}
}

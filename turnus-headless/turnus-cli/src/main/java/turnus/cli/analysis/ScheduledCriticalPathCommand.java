package turnus.cli.analysis;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.bottlenecks.ScheduledPartialCriticalPathAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.bottlenecks.io.BottlenecksWithScheduling2HtmlExporter;
import turnus.model.trace.TraceProject;

import static turnus.common.TurnusOptions.*;

@Command(
    name = "scheduled-critical-path",
    description = "Run scheduled critical path analysis on a trace",
    mixinStandardHelpOptions = true
)
public class ScheduledCriticalPathCommand implements Callable<Integer> {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-w", "--weights"}, description = "Action weights file (.exdf)", required = true)
    private File weightsFile;

    @Option(names = {"-m", "--mapping"}, description = "Network partitioning/mapping file (.xml/.xcf)", required = true)
    private File mappingFile;

    @Option(names = {"-b", "--buffer-size"}, description = "Buffer size file (.xml)")
    private File bufferSizeFile;

    @Option(names = {"--buffer-default"}, description = "Default buffer size (tokens) if --buffer-size is not provided")
    private Integer bufferDefault;

    @Option(names = {"-c", "--comm-weight"}, description = "Communication weights file (.cxdf)")
    private File communicationWeightsFile;

    @Option(names = {"--write-hit"}, description = "Write hit constant (latency)")
    private Integer writeHitConstant;

    @Option(names = {"--write-miss"}, description = "Write miss constant (latency)")
    private Integer writeMissConstant;

    @Option(names = {"-s", "--sched-weight"}, description = "Scheduling weights file (.sxdf)")
    private File schedulingWeightsFile;

    @Option(names = {"--release-after-processing"}, description = "Release buffers after processing (default: true)")
    private boolean releaseAfterProcessing = true;

    @Override
    public Integer call() {
        Logger.info("Starting Scheduled Critical Path Analysis...");

        try {
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);

            if (bufferSizeFile == null && (bufferDefault == null || bufferDefault <= 0)) {
                Logger.error("You must provide either --buffer-size or --buffer-default");
                return 1;
            }

            Configuration config = new Configuration();
            config.setValue(ACTION_WEIGHTS, weightsFile);
            config.setValue(MAPPING_FILE, mappingFile);
            config.setValue(RELEASE_BUFFERS_AFTER_PROCESSING, releaseAfterProcessing);

            if (bufferSizeFile != null) {
                config.setValue(BUFFER_SIZE_FILE, bufferSizeFile);
            } else {
                config.setValue(BUFFER_SIZE_DEFAULT, bufferDefault);
            }

            if (communicationWeightsFile != null) {
                config.setValue(COMMUNICATION_WEIGHTS, communicationWeightsFile);
                if (writeHitConstant != null) {
                    config.setValue(WRITE_HIT_CONSTANT, writeHitConstant);
                }
                if (writeMissConstant != null) {
                    config.setValue(WRITE_MISS_CONSTANT, writeMissConstant);
                }
            }

            if (schedulingWeightsFile != null) {
                config.setValue(SCHEDULING_WEIGHTS, schedulingWeightsFile);
            }

            ScheduledPartialCriticalPathAnalysis analysis = new ScheduledPartialCriticalPathAnalysis(project);
            analysis.setConfiguration(config);
            BottlenecksWithSchedulingReport report = analysis.run();

            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);

            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "bottlenecks-sched").getName());
            EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
            Logger.info("Report saved to: %s", reportFile);

            File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
            new BottlenecksWithScheduling2HtmlExporter().export(report, htmlFile);
            Logger.info("HTML report saved to: %s", htmlFile);

            return 0;
        } catch (TurnusException e) {
            Logger.error("Analysis failed: %s", e.getMessage());
            return 1;
        }
    }
}

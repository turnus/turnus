package turnus.cli.analysis;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.profiling.InterPartitionCommunicationAndMemoryAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.io.Ipcomm2HtmlExporter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

import static turnus.common.TurnusOptions.*;

@Command(
    name = "ipcomm",
    description = "Run inter-partition communication and memory analysis",
    mixinStandardHelpOptions = true
)
public class IpcommCommand implements Callable<Integer> {

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

    @Option(names = {"--outgoing-owned-by-source"}, description = "Owner of outgoing buffers is the source partition")
    private boolean outgoingOwnedBySource;

    @Override
    public Integer call() {
        Logger.info("Starting Inter-Partition Communication & Memory Analysis...");

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
            config.setValue(OUTGOING_BUFFER_IS_OWNED_BY_SRC_PARTITION, outgoingOwnedBySource);

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

            CommunicationWeight communicationWeight = null;
            if (communicationWeightsFile != null) {
                communicationWeight = new XmlCommunicationWeightReader(project.getNetwork()).load(communicationWeightsFile);
                if (writeHitConstant != null) {
                    communicationWeight.setWriteHitConstant(writeHitConstant);
                }
                if (writeMissConstant != null) {
                    communicationWeight.setWriteMissConstant(writeMissConstant);
                }
            }

            InterPartitionCommunicationAndMemoryAnalysis analysis = new InterPartitionCommunicationAndMemoryAnalysis(
                project,
                weighter,
                bufferSize,
                partitioning,
                communicationWeight,
                outgoingOwnedBySource
            );
            analysis.setConfiguration(config);

            InterPartitionCommunicationAndMemoryReport report = analysis.run();

            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);

            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "ipcomm").getName());
            EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
            Logger.info("Report saved to: %s", reportFile);

            File htmlFile = new File(reportFile.getParentFile(), reportFile.getName() + ".html");
            new Ipcomm2HtmlExporter().export(report, htmlFile);
            Logger.info("HTML report saved to: %s", htmlFile);

            return 0;
        } catch (TurnusException e) {
            Logger.error("Analysis failed: %s", e.getMessage());
            return 1;
        }
    }
}

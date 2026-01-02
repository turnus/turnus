/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 */
package turnus.cli.analysis.partitioning;

import java.io.File;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import turnus.analysis.partitioning.CommunicationCostPartitioning;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.partitioning.ComCostPartitioningReport;
import turnus.model.trace.TraceProject;

import static turnus.common.TurnusOptions.*;

/**
 * CLI command for Communication Cost Partitioning.
 */
@Command(
    name = "comm-cost",
    description = "Run communication cost partitioning (KL algorithm)",
    mixinStandardHelpOptions = true
)
public class CommunicationCostPartitioningCli implements PartitioningAlgorithmCli {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-u", "--units"}, description = "Number of processing units", required = true)
    private int units;

    @Override
    public Integer call() {
        Logger.info("Starting Communication Cost Partitioning...");
        
        try {
            // Open trace project
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);
            
            // Configure analysis
            Configuration config = new Configuration();
            config.setValue(ANALYSIS_PARTITIONING_UNITS, String.valueOf(units));
            
            // Run analysis
            CommunicationCostPartitioning analysis = new CommunicationCostPartitioning(project);
            analysis.setConfiguration(config);
            ComCostPartitioningReport report = analysis.run();
            
            // Determine output directory
            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);
            
            // Save report
            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "partitioning").getName());
            EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
            Logger.info("Report saved to: %s", reportFile);
            
            return 0;
            
        } catch (TurnusException e) {
            Logger.error("Analysis failed: %s", e.getMessage());
            return 1;
        }
    }
}

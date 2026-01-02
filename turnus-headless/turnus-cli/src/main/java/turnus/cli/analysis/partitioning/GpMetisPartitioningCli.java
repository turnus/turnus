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

import turnus.analysis.partitioning.GpMetisPartitioning;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.partitioning.MetisPartitioningReport;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.impl.AverageTraceWeighter;

import static turnus.common.TurnusOptions.*;

/**
 * CLI command for GpMetis Partitioning.
 */
@Command(
    name = "gpmetis",
    description = "Run GpMetis partitioning",
    mixinStandardHelpOptions = true
)
public class GpMetisPartitioningCli implements PartitioningAlgorithmCli {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-u", "--units"}, description = "Number of processing units", required = true)
    private int units;

    @Option(names = {"-w", "--trace-weights"}, description = "Trace weights file (.exdf)")
    private File traceWeightsFile;

    @Option(names = {"--policy"}, description = "Scheduling policy (ROUND_ROBIN, etc.)", defaultValue = "ROUND_ROBIN")
    private String schedulingPolicy;

    @Override
    public Integer call() {
        Logger.info("Starting GpMetis Partitioning...");
        
        try {
            // Open trace project
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);
            
            // Configure Trace Weighter
            TraceWeighter weighter;
            if (traceWeightsFile != null && traceWeightsFile.exists()) {
                Logger.info("Loading trace weights: " + traceWeightsFile.getName());
                NetworkWeight weights = new XmlNetworkWeightReader().load(traceWeightsFile);
                weighter = new AverageTraceWeighter(weights);
            } else {
                Logger.info("Using unit trace weights (default)");
                weighter = new UnitTraceWeighter();
            }

            // Configure analysis
            Configuration config = new Configuration();
            config.setValue(ANALYSIS_PARTITIONING_UNITS, String.valueOf(units));
            config.setValue(SCHEDULING_POLICY, schedulingPolicy);
            
            // Run analysis
            GpMetisPartitioning analysis = new GpMetisPartitioning(project, weighter);
            analysis.setConfiguration(config);
            MetisPartitioningReport report = analysis.run();
            
            // Determine output directory
            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);
            
            // Save report
            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "gpmetis_partitioning").getName());
            EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
            Logger.info("Report saved to: %s", reportFile);
            
            return 0;
            
        } catch (TurnusException e) {
            Logger.error("Analysis failed: %s", e.getMessage());
            return 1;
        }
    }

    /**
     * Simple trace weighter that returns 1.0 for all weights and 0.0 for variance.
     */
    private static class UnitTraceWeighter implements TraceWeighter {
        @Override
        public TraceWeighter clone() {
            return new UnitTraceWeighter();
        }

        @Override
        public double getVariance(Dependency dependency) {
            return 0.0;
        }

        @Override
        public double getVariance(Step step) {
            return 0.0;
        }

        @Override
        public double getWeight(Dependency dependency) {
            return 1.0;
        }

        @Override
        public double getWeight(Step step) {
            return 1.0;
        }

        @Override
        public void setRatio(String actor, String action, double scale) {
            // No-op
        }
    }
}

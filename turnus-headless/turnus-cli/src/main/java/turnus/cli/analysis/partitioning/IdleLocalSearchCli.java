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

import turnus.analysis.partitioning.IdleLocalSearch;
import turnus.common.configuration.Configuration;
import turnus.common.TurnusException;
import turnus.common.util.FileUtils;
import turnus.common.io.Logger;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.NetworkWeight;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.impl.AverageTraceWeighter;

import static turnus.common.TurnusOptions.*;

/**
 * CLI command for Idle Local Search Partitioning.
 */
@Command(
    name = "idle-ls",
    description = "Run idle local search partitioning",
    mixinStandardHelpOptions = true
)
public class IdleLocalSearchCli implements PartitioningAlgorithmCli {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-u", "--units"}, description = "Number of processing units", required = true)
    private int units;
    
    @Option(names = {"-w", "--weights"}, description = "Weights file (XML)", required = false)
    private File weightsFile;

    @Override
    public Integer call() {
        Logger.info("Starting Idle Local Search Partitioning...");
        
        try {
            // Open trace project
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);
            
            // Configure Trace Weighter
            TraceWeighter weighter;
            if (weightsFile != null && weightsFile.exists()) {
                NetworkWeight nw = new XmlNetworkWeightReader().load(weightsFile);
                weighter = new AverageTraceWeighter(nw);
            } else {
                weighter = new UnitTraceWeighter();
            }

            // Configure options
            Configuration config = new Configuration();
            config.setValue(ANALYSIS_PARTITIONING_UNITS, String.valueOf(units));
            
            // Run Idle Local Search
            IdleLocalSearch algorithm = new IdleLocalSearch(project, weighter, null, null, null, false);
            algorithm.setConfiguration(config);
            
            // Generate initial partitioning
            algorithm.generateInitialPartitioning("ROUND_ROBIN");
            
            algorithm.run();
            
            NetworkPartitioning partitioning = algorithm.getBestPartitioning();
            
            if (partitioning == null) {
                Logger.error("No partitioning found.");
                return 1;
            }

            // Determine output directory
            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);
            
            // Save report
            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "idle_ls_partitioning").getName());
            new XmlNetworkPartitioningWriter().write(partitioning, reportFile);
            Logger.info("Partitioning saved to: %s", reportFile);
            
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
        public double getVariance(turnus.model.trace.Dependency dependency) {
            return 0.0;
        }

        @Override
        public double getVariance(turnus.model.trace.Step step) {
            return 0.0;
        }

        @Override
        public double getWeight(turnus.model.trace.Dependency dependency) {
            return 1.0;
        }

        @Override
        public double getWeight(turnus.model.trace.Step step) {
            return 1.0;
        }

        @Override
        public void setRatio(String actor, String action, double scale) {
            // No-op
        }
    }
}
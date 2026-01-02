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
import java.util.HashMap;
import java.util.Map;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.trace.weighter.impl.AverageTraceWeighter;

import static turnus.common.TurnusOptions.*;

/**
 * CLI command for Dynamic Round Robin Partitioning.
 */
@Command(
    name = "dynamic-rr",
    description = "Run dynamic round robin partitioning",
    mixinStandardHelpOptions = true
)
public class DynamicRRPartitioningCli implements PartitioningAlgorithmCli {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-u", "--units"}, description = "Number of processing units", required = true)
    private int units;

    @Override
    public Integer call() {
        Logger.info("Starting Dynamic Round Robin Partitioning...");
        
        try {
            // Open trace project
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);
            
            // Configure Trace Weighter (Unit weights for Dynamic RR usually sufficient or default)
            TraceWeighter weighter = new UnitTraceWeighter();

            // Configure Simulation
            SimEngine simulation = new SimEngine();
            simulation.setTraceProject(project);
            simulation.setTraceWeighter(weighter);
            
            // Configure options
            Configuration config = new Configuration();
            config.setValue(ANALYSIS_PARTITIONING_UNITS, String.valueOf(units));
            
            // The Eclipse code used an AllocationCollector.
            AllocationCollector collector = new AllocationCollector(project.getNetwork(), units);
            simulation.addDataCollector(collector);
            
            // Let's try to run it.
            simulation.run();
            
            NetworkPartitioning partitioning = collector.getPartitioning();
            
            // Determine output directory
            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);
            
            // Save report
            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "dynamic_rr_partitioning").getName());
            new XmlNetworkPartitioningWriter().write(partitioning, reportFile);
            Logger.info("Partitioning saved to: %s", reportFile);
            
            return 0;
            
        } catch (TurnusException e) {
            Logger.error("Analysis failed: %s", e.getMessage());
            return 1;
        }
    }

    public class AllocationCollector implements ActorDataCollector {

        private Map<Actor, String> allocation;
        Network network;
        int nPE;

        public AllocationCollector(Network network, int nPE) {
            this.network = network;
            this.nPE = nPE;
        }

        @Override
        public void init() {
            allocation = new HashMap<>();
        }

        @Override
        public void logEndSimulation(double time) {
        }

        @Override
        public PostProcessingData generateReport() {
            return null;
        }

        public NetworkPartitioning getPartitioning() {
            NetworkPartitioning partitioning = new NetworkPartitioning(network);
            for (Actor actor : network.getActors()) {
                String pe = allocation.get(actor);
                if (pe == null) {
                    // If actor wasn't executed, assign to p0 (or handle error)
                    pe = "p0";
                }
                partitioning.setPartition(actor, pe);
            }

            // -- PE to 1 and round robin scheduling
            for (int i = 0; i < nPE; i++) {
                partitioning.setProcessingElements("p" + i, 1);
                partitioning.setScheduler("p" + i, "ROUND_ROBIN");
            }
            return partitioning;
        }

        @Override
        public void logIsSchedulable(Action action, long stepId, double time) {}

        @Override
        public void logIsEnabled(Action action, long stepId, double time) {}

        @Override
        public void logStartProcessing(Action action, long stepId, double time) {}

        @Override
        public void logStartProcessingWithCore(Action action, long stepId, int core, double time) {
             Actor actor = action.getOwner();
             allocation.put(actor, "p" + core);
        }

        @Override
        public void logEndProcessing(Action action, long stepId, double time) {}

        @Override
        public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
            Actor actor = action.getOwner();
            allocation.put(actor, "p" + core);
        }

        @Override
        public void logStartProducing(Action action, long stepId, double time) {}

        @Override
        public void logEndFiring(Action action, long stepId, double time) {}

        @Override
        public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {}

        @Override
        public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {}

        @Override
        public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {}

        @Override
        public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {}

        @Override
        public void logEndProduceTokens(Action action, long stepId, Buffer buffer, double time) {}
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

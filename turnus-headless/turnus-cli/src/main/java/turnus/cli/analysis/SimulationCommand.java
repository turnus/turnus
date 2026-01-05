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
package turnus.cli.analysis;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.Callable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import turnus.adevs.logging.impl.ActionStatisticsCollector;
import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.adevs.logging.impl.BufferBlockingCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.common.io.Logger;
import turnus.model.dataflow.Actor;
import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.impl.AverageTraceWeighter;
import turnus.model.analysis.postprocessing.io.ActionStatistics2HtmlExporter;
import turnus.model.analysis.postprocessing.io.ActionStatistics2MdExporter;
import turnus.model.analysis.postprocessing.io.ActorStatistics2HtmlExporter;
import turnus.model.analysis.postprocessing.io.ActorStatistics2MdExporter;
import turnus.model.analysis.postprocessing.io.BufferBlocking2HtmlExporter;
import turnus.model.analysis.postprocessing.io.BufferBlocking2MdExporter;

/**
 * CLI command for ADEVS Simulation.
 */
@Command(
    name = "simulate",
    description = "Run ADEVS simulation on a trace",
    mixinStandardHelpOptions = true
)
public class SimulationCommand implements Callable<Integer> {

    @Parameters(index = "0", description = "The trace project file (.tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"-p", "--partitioning"}, description = "Network partitioning file (.xml)")
    private File partitioningFile;

    @Option(names = {"-b", "--buffer-size"}, description = "Buffer size file (.xml)")
    private File bufferSizeFile;

    @Option(names = {"-c", "--comm-weight"}, description = "Communication weight file (.xml)")
    private File commWeightFile;

    @Option(names = {"-s", "--sched-weight"}, description = "Scheduling weight file (.xml)")
    private File schedWeightFile;

    @Option(names = {"-w", "--trace-weights"}, description = "Trace weights file (.exdf)")
    private File traceWeightsFile;

    @Option(names = {"--stats"}, description = "Enable statistics collection (Action/Actor stats)")
    private boolean enableStats;

    @Option(names = {"--blocking"}, description = "Enable buffer blocking collection")
    private boolean enableBlocking;

    @Override
    public Integer call() throws Exception {
        if (!traceFile.exists()) {
            Logger.error("Trace file not found: " + traceFile.getAbsolutePath());
            return 1;
        }

        if (outputDir == null) {
            outputDir = new File(".");
        }
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        try {
            Logger.info("Loading trace project: " + traceFile.getName());
            TraceProject project = TraceProject.open(traceFile);

            SimEngine engine = new SimEngine("CLI Simulation");
            engine.setTraceProject(project);

            // Configure Trace Weighter
            if (traceWeightsFile != null && traceWeightsFile.exists()) {
                Logger.info("Loading trace weights: " + traceWeightsFile.getName());
                NetworkWeight weights = new XmlNetworkWeightReader().load(traceWeightsFile);
                engine.setTraceWeighter(new AverageTraceWeighter(weights));
            } else {
                Logger.info("Using unit trace weights (default)");
                engine.setTraceWeighter(new UnitTraceWeighter());
            }

            // Configure Partitioning
            NetworkPartitioning partitioning;
            if (partitioningFile != null && partitioningFile.exists()) {
                Logger.info("Loading partitioning: " + partitioningFile.getName());
                partitioning = new XmlNetworkPartitioningReader().load(partitioningFile);
            } else {
                Logger.info("Using default single-partition mapping");
                partitioning = new NetworkPartitioning(project.getNetwork());
                for (Actor actor : project.getNetwork().getActors()) {
                    partitioning.setPartition(actor, "DefaultPartition");
                }
            }
            engine.setNetworkPartitioning(partitioning);

            if (bufferSizeFile != null && bufferSizeFile.exists()) {
                Logger.info("Loading buffer sizes: " + bufferSizeFile.getName());
                BufferSize bufferSize = new XmlBufferSizeReader().load(bufferSizeFile);
                engine.setBufferSize(bufferSize);
            }

            if (commWeightFile != null && commWeightFile.exists()) {
                Logger.info("Loading communication weights: " + commWeightFile.getName());
                CommunicationWeight commWeight = new XmlCommunicationWeightReader(project.getNetwork()).load(commWeightFile);
                engine.setCommunicationWeight(commWeight);
            }

            if (schedWeightFile != null && schedWeightFile.exists()) {
                Logger.info("Loading scheduling weights: " + schedWeightFile.getName());
                SchedulingWeight schedWeight = new XmlSchedulingWeightReader().load(schedWeightFile);
                engine.setSchedulingWeight(schedWeight);
            }

            // Add collectors
            ActionStatisticsCollector actionStats = null;
            ActorStatisticsCollector actorStats = null;
            BufferBlockingCollector bufferStats = null;

            if (enableStats) {
                actionStats = new ActionStatisticsCollector(project.getNetwork());
                engine.addDataCollector(actionStats);

                actorStats = new ActorStatisticsCollector(project.getNetwork(), partitioning);
                engine.addDataCollector(actorStats);
            }

            if (enableBlocking) {
                bufferStats = new BufferBlockingCollector(project.getNetwork());
                engine.addDataCollector(bufferStats);
            }

            Logger.info("Starting simulation...");
            engine.run();
            Logger.info("Simulation completed.");

            // Save reports
            if (enableStats) {
                if (actionStats != null) {
                    File reportFile = new File(outputDir, "action_stats.xmi");
                    ActionStatisticsReport report = actionStats.generateReport();
                    saveReport(report, reportFile);

					File mdFile = new File(outputDir, "action_stats.md");
					File htmlFile = new File(outputDir, "action_stats.html");
					new ActionStatistics2MdExporter().export(report, mdFile);
					new ActionStatistics2HtmlExporter().export(report, htmlFile);
                    Logger.info("Action statistics saved to " + reportFile.getName());
                }
                if (actorStats != null) {
                    File reportFile = new File(outputDir, "actor_stats.xmi");
                    ActorStatisticsReport report = actorStats.generateReport();
                    saveReport(report, reportFile);

					File mdFile = new File(outputDir, "actor_stats.md");
					File htmlFile = new File(outputDir, "actor_stats.html");
					new ActorStatistics2MdExporter().export(report, mdFile);
					new ActorStatistics2HtmlExporter().export(report, htmlFile);
                    Logger.info("Actor statistics saved to " + reportFile.getName());
                }
            }

            if (enableBlocking && bufferStats != null) {
                File reportFile = new File(outputDir, "buffer_blocking.xmi");
                BufferBlockingReport report = (BufferBlockingReport) bufferStats.generateReport();
                saveReport(report, reportFile);

				File mdFile = new File(outputDir, "buffer_blocking.md");
				File htmlFile = new File(outputDir, "buffer_blocking.html");
				new BufferBlocking2MdExporter().export(report, mdFile);
				new BufferBlocking2HtmlExporter().export(report, htmlFile);
                Logger.info("Buffer blocking statistics saved to " + reportFile.getName());
            }

            return 0;

        } catch (Exception e) {
            Logger.error("Simulation failed: " + e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }

    private void saveReport(EObject report, File file) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        
        Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
        resource.getContents().add(report);
        try {
            resource.save(Collections.emptyMap());
        } catch (IOException e) {
            Logger.error("Failed to save report to " + file.getAbsolutePath());
            e.printStackTrace();
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

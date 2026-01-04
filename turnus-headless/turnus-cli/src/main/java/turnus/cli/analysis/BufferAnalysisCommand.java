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
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.io.Boundbuffer2HtmlExporter;
import turnus.model.trace.TraceProject;

import static turnus.common.TurnusOptions.*;

/**
 * CLI command for Buffer Analysis.
 */
@Command(
    name = "buffer",
    description = "Run bounded buffer analysis on a trace",
    mixinStandardHelpOptions = true
)
public class BufferAnalysisCommand implements Callable<Integer> {

    @Parameters(index = "0", description = "The trace file (.trace or .tracez)")
    private File traceFile;

    @Option(names = {"-o", "--output"}, description = "Output directory")
    private File outputDir;

    @Option(names = {"--bit-accurate"}, description = "Use bit-accurate token sizes")
    private boolean bitAccurate = false;

    @Option(names = {"--pow2"}, description = "Round buffer sizes to power of 2")
    private boolean pow2 = false;

    @Override
    public Integer call() {
        Logger.info("Starting Buffer Analysis...");
        
        try {
            // Open trace project
            TraceProject project = TraceProject.open(traceFile);
            Logger.info("Loaded trace: %s", traceFile);
            
            // Configure analysis
            Configuration config = new Configuration();
            config.setValue(ANALYSIS_BUFFER_BIT_ACCURATE, bitAccurate);
            config.setValue(ANALYSIS_BUFFER_POW2, pow2);
            
            // Run analysis
            BoundedBufferAnalysis analysis = new BoundedBufferAnalysis(project);
            analysis.setConfiguration(config);
            BoundedBuffersReport report = analysis.run();
            
            // Determine output directory
            File outDir = outputDir != null ? outputDir : traceFile.getParentFile();
            FileUtils.createDirectory(outDir);
            
            // Save report
            File reportFile = new File(outDir, FileUtils.changeExtension(traceFile, "buffers").getName());
            EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
            Logger.info("Report saved to: %s", reportFile);

			// Save HTML report
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

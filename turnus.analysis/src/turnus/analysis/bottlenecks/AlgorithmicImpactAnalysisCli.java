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
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse (or a modified version of Eclipse or an Eclipse plugin or 
 * an Eclipse library), containing parts covered by the terms of the 
 * Eclipse Public License (EPL), the licensors of this Program grant you 
 * additional permission to convey the resulting work.  Corresponding Source 
 * for a non-source form of such a combination shall include the source code 
 * for the parts of Eclipse libraries used as well as that of the  covered work.
 * 
 */
package turnus.analysis.bottlenecks;

import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_CLASS_LEVEL;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_POINTS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.TRACE_WEIGHTER;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class AlgorithmicImpactAnalysisCli implements IApplication {

	private Configuration configuration;

	private IProgressMonitor monitor = new NullProgressMonitor();

	private AlgorithmicImpactAnalysis analysis;

	public static void main(String[] args) {
		ModelsRegister.init();

		AlgorithmicImpactAnalysisCli cliApp = null;

		try {
			cliApp = new AlgorithmicImpactAnalysisCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}

	private void run() throws Exception {
		monitor.beginTask("Algorithmic Impact analysis", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		ImpactAnalysisReport report = null;

		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
			} catch (Exception e) {
				throw new TurnusException("Trace file is not valid", e);
			}
		}

		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				analysis = new AlgorithmicImpactAnalysis(project);
				analysis.setConfiguration(configuration);
				report = analysis.run();
				Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e);
			}
		}

		{ // STEP 3 : Store the results
			monitor.subTask("Storing the results");
			try {
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("bottlenecks", configuration);
				}

				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.IMPACT_ANALYSIS_REPORT);
				EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
				Logger.info("Impact analysis report stored in \"%s\"", reportFile);

				File cpFile = changeExtension(reportFile, TurnusExtensions.BOTTLENECKS_REPORT);
				EcoreUtils.storeEObject(report.getInitialBottlenecks(), project.getResourceSet(), cpFile);
				Logger.info("Initial bottleneck analysis report stored in \"%s\"", cpFile);

			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}

		monitor.done();

	}

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()//
				.setOption(TRACE_FILE, true)//
				.setOption(OUTPUT_DIRECTORY, false)//
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(TRACE_WEIGHTER, false)//
				.setOption(ANALYSIS_IMPACT_CLASS_LEVEL, false)//
				.setOption(ANALYSIS_IMPACT_MAX_ACTIONS, false)//
				.setOption(CONFIG_MINIMIZE_MEMORY_USAGE, false)//
				.setOption(ANALYSIS_IMPACT_MAX_POINTS, false);
		configuration = cliParser.parse(args);
	}

	public void start(Configuration configuration, IProgressMonitor monitor) throws Exception {
		this.configuration = configuration;
		this.monitor = monitor;
		run();
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		try {
			parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS));
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
			return IApplication.EXIT_RELAUNCH;
		}

		try {
			run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
			return IApplication.EXIT_RELAUNCH;
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		if (analysis != null) {
			analysis.cancel();
		}
	}

}

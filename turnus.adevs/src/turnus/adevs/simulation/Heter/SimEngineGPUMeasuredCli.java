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
package turnus.adevs.simulation.Heter;

import static turnus.common.TurnusOptions.*;
import java.io.File;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.adevs.simulation.SimEngine;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

public class SimEngineGPUMeasuredCli implements IApplication {

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		SimEngineGPUMeasuredCli cliApp = null;

		try {
			cliApp = new SimEngineGPUMeasuredCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error("Application error: %s", e.getMessage());
		}
	}

	private Configuration configuration;
	private SimEngine simulation;

	private IProgressMonitor monitor = new NullProgressMonitor();
	
	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()//
				.setOption(TRACE_FILE, true)//
				.setOption(MAPPING_FILE, true)//
				.setOption(TABU_CMD, false)//
				.setOption(OUTPUT_DIRECTORY, false);
		configuration = cliParser.parse(args);
	}

	private PostProcessingReport run() throws TurnusException {
		monitor.beginTask("Post processing simulation", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		NetworkPartitioning partitioning = null;
		PostProcessingReport report = null;
		String cmd = null;
		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			if (configuration.hasValue(TRACE_FILE)) {	
				try {
					File traceFile = configuration.getValue(TRACE_FILE);
					project = TraceProject.open(traceFile);
					project.loadTrace(new SplittedTraceLoader(), configuration);
				} catch (Exception e) {
					throw new TurnusException("The trace project cannot be loaded", e);
				}
			}
			try {
				File mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);
			} catch (Exception e) {
				throw new TurnusException("Mapping file is not valid", e);
			}
			
			if (configuration.hasValue(TABU_CMD)) { 
				cmd = configuration.getValue(TABU_CMD);
			} 
		}
		
		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the simulation");
			try {
				simulation = new SimEngineGPUMeasured(cmd, project);
				simulation.setNetworkPartitioning(partitioning);

				report = simulation.run();
			
			} catch (Exception e) {
				throw new TurnusException("The simulation cannot be completed", e);
			}
		}

		{ // STEP 3 : Store the results
			monitor.subTask("Storing the results");
			Logger.infoRaw("Total time " + report.getTime());
		}
		monitor.done();

		return report;
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
		// TODO Auto-generated method stub
	}
}

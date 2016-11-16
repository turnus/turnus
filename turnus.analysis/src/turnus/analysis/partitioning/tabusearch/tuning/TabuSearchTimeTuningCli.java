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
package turnus.analysis.partitioning.tabusearch.tuning;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_TIME;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.TABU_P;
import static turnus.common.TurnusOptions.TABU_SEED;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.TRACE_WEIGHTER;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.analysis.partitioning.tabusearch.generators.BalancingMovesGenerator;
import turnus.analysis.partitioning.tabusearch.generators.TabuSearchMovesGenerator;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.configuration.Option;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class TabuSearchTimeTuningCli implements IApplication {
	
	private Configuration configuration;
	private IProgressMonitor monitor = new NullProgressMonitor();
	
	public static final Option<File> MAPPING_FILES_LIST = Option.create().//
			setName("testList").//
			setDescription("List of mapping configurations to test. ").//
			setLongName("turnus.analysis.partitioning.mapping.FilesList").//
			setType(File.class).build();
	
	public static final int [] seeds = {4122015, 91189, 181014};
	
	private static int seed;
	private static String mapping;
	private static String outputFileName = null;
	
	private static List<String> entries = new ArrayList<String>();
	
	public static void main(String[] args) {	
		ModelsRegister.init();

		TabuSearchTimeTuningCli cliApp = null;

		try {
			cliApp = new TabuSearchTimeTuningCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}
		
		/*
		 * For each seed and each mapping configuration tune the time T.
		 */
		File mappingFile = null;
		for (int s : seeds) {
			cliApp.configuration.setValue(TABU_SEED, s); 
			try {
				mappingFile = cliApp.configuration.getValue(MAPPING_FILES_LIST);
				FileInputStream input = new FileInputStream(mappingFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				String line = null;
				while ((line = br.readLine()) != null) { // check mapping configurations one by one
					File file = new File(line);
					cliApp.configuration.setValue(MAPPING_FILE, file);
					
					mapping = line;
					seed = s;
					
					cliApp.run(mapping, seed);
					
					File output = new File(mappingFile.getParent() + "/" + System.currentTimeMillis() + ".txt");
					PrintWriter out;
					try {
						out = new PrintWriter(new FileWriter(output));
						out.print("Done for mapping: " + mapping + ", seed: " + seed + ", " + outputFileName);
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				br.close();
			} catch (Exception e) {
				try {
					throw new TurnusException("The list of mapping configurations cannot be loaded.", e);
				} catch (TurnusException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		File output = new File(mappingFile.getParent() + "/" + outputFileName + "_" + System.currentTimeMillis() + ".txt");
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(output));
			for (String entry : entries) {
				out.print(entry);
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void run(String file, int seed) throws TurnusException {
		monitor.beginTask("Tabu Search parameters tuning", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		TraceWeighter weighter = null;
		NetworkPartitioning partitioning = null;
		BufferSize bufferSize = null;
		int defaultBufferSize = 0;

		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
				project.loadTrace(new SplittedTraceLoader(), configuration);
			} catch (Exception e) {
				throw new TurnusException("The trace project cannot be loaded", e);
			}
			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
				weighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("The weights file cannot be loaded", e);
			}
			try {
				File mappingFile = configuration.getValue(MAPPING_FILE);
				XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
				partitioning = reader.load(mappingFile);	
			} catch (Exception e) {
				throw new TurnusException("The mapping configuration cannot be loaded", e);
			}
			try {
				defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
				bufferSize = new BufferSize(project.getNetwork());
				bufferSize.setDefaultSize(defaultBufferSize);
			} catch (Exception e) {
				throw new TurnusException("The default buffer size cannot be loaded", e);
			}
		}

		{ // STEP 2 : Run the analysis
			monitor.subTask("Tuning of time");
			try {
				// tabu search
				TabuSearchTimeTuningPortioned tabuSearch = new TabuSearchTimeTuningPortioned(project, weighter, bufferSize);
				tabuSearch.setConfiguration(configuration);
				tabuSearch.loadPartitioning(partitioning);
				
				/*TabuSearchMovesGenerator generator = new RandomMovesGenerator(project);
				tabuSearch.setGenerator(generator);
				if (outputFileName == null)
					outputFileName = "time_random";
				*/
				
				/*TabuSearchMovesGenerator generator = new IdleMovesGenerator(project);
				tabuSearch.setGenerator(generator);
				if (outputFileName == null)
					outputFileName = "time_idle";
				*/
				
				/*TabuSearchMovesGenerator generator = new CommFreqMovesGenerator(project);
				tabuSearch.setGenerator(generator);
				if (outputFileName == null)
					outputFileName = "time_commfreq";
				*/
				
				TabuSearchMovesGenerator generator = new BalancingMovesGenerator(project);
				tabuSearch.setGenerator(generator);
				if (outputFileName == null)
					outputFileName = "time_balancing";
				
				
				int timeLimit = tabuSearch.run();
				String newEntry = mapping + ", seed: " + seed + ", time: " + timeLimit + "\n";
				entries.add(newEntry);
				Logger.info(newEntry);
				
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e);
			}
		}
		
		monitor.done();
	}
	
	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()
				.setOption(TRACE_FILE, true)//
				.setOption(ACTION_WEIGHTS, true)//
				.setOption(TRACE_WEIGHTER, false)//
				.setOption(MAPPING_FILE, false)//
				.setOption(BUFFER_SIZE_DEFAULT, true)//
				.setOption(TABU_P, false)//
				.setOption(TABU_SEED, false)//
				.setOption(ANALYSIS_TIME, false)//
				.setOption(MAPPING_FILES_LIST, true);

		configuration = cliParser.parse(args);
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
			run(mapping, seed);
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
			return IApplication.EXIT_RELAUNCH;
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}

	public void start(Configuration configuration, IProgressMonitor monitor) throws TurnusException {
		this.configuration = configuration;
		this.monitor = monitor;
		run(mapping, seed);
	}
}

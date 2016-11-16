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
package turnus.analysis.profiling;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.analysis.profiling.ProfilingStatsActorData;
import turnus.model.analysis.profiling.ProfilingStatsReport;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.mapping.data.ProfilingStatsActor;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfilingStatsReporterCli implements IApplication {
	
	private IProgressMonitor monitor = new NullProgressMonitor();
	private Configuration configuration;

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
	
	private ProfilingStatsReport run() throws TurnusException {
		monitor.beginTask("Post processing simulation", IProgressMonitor.UNKNOWN);

		NetworkWeight actionWeights = null;
		SchedulingWeight schedulerWeights = null;
		//CommunicationWeight commWeights = null;

		ProfilingStatsReport finalReport = null;
		Map<String, ProfilingStatsActor> reportMap = new HashMap<String, ProfilingStatsActor>();
		
		{ // STEP 1 : parsing the weights files
			monitor.subTask("parsing the weights files:");
			if (configuration.hasValue(ACTION_WEIGHTS)) {
				monitor.subTask("parsing the action computational weights ...");
				try {
					File actionWeightsFile = configuration.getValue(ACTION_WEIGHTS);
					actionWeights = new XmlNetworkWeightReader(true, true).load(actionWeightsFile);
				} catch (Exception e) {
					throw new TurnusException("Computational Weights file is not valid", e);
				}
			}
		
			if (configuration.hasValue(SCHEDULING_WEIGHTS)) {
				monitor.subTask("parsing the scheduling weights ...");				
				try {
					File schedulerWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
					schedulerWeights = new XmlSchedulingWeightReader(true, true).load(schedulerWeightsFile);
				} catch (Exception e) {
					throw new TurnusException("Communication Weights file is not valid", e);
				}
			} 

			if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
				/*monitor.subTask("parsing the communications weights ...");
				try {
					File commWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
					XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(network);
					commWeights = reader.load(commWeightsFile);
				} catch (Exception e) {
					throw new TurnusException("Communication Weights file is not valid", e);
				}
				
				if (configuration.hasValue(WRITE_HIT_CONSTANT)) {
					commWeights.setWriteHitConstant(configuration.getValue(WRITE_HIT_CONSTANT));
				}
				if (configuration.hasValue(WRITE_MISS_CONSTANT)) {
					commWeights.setWriteMissConstant(configuration.getValue(WRITE_MISS_CONSTANT));
				}*/
			} 
		}

		{ // STEP 2 : Calculating stats
			monitor.subTask("Calculating stats:");
			try {
				String actor;
				double meanWeights;
				int numFirings;
				Table<String, String, ClockCycles> actionsWeightsTable = actionWeights.asTable();
				for (Cell<String, String, ClockCycles> cell : actionsWeightsTable.cellSet()) {
					actor = cell.getRowKey();
					meanWeights = cell.getValue().getMeanClockCycles();
					numFirings = cell.getValue().getNumFirings();
				
					if(reportMap.containsKey(actor)) {
						reportMap.get(actor).setActionsWeight((meanWeights*numFirings) + reportMap.get(actor).getActionsWeight());
					}
					else {
						reportMap.put(actor, new ProfilingStatsActor((meanWeights*numFirings), 0.0));
					}
				}
				
				Table<String, String, Map<String, ClockCycles>> actionSelectionTable = schedulerWeights.asTable();
				for (Cell<String, String, Map<String, ClockCycles>> cell : actionSelectionTable.cellSet()) {
					actor = cell.getRowKey();
					for (Entry<String, ClockCycles> trans : cell.getValue().entrySet()) {
						meanWeights = trans.getValue().getMeanClockCycles();
						numFirings = trans.getValue().getNumFirings();
						
						if(reportMap.containsKey(actor)) {
							reportMap.get(actor).setSchedulerWeight((meanWeights*numFirings) + reportMap.get(actor).getSchedulerWeight());
						}
						else {
							// This can only happen if actor does not have any actions.
							reportMap.put(actor, new ProfilingStatsActor(0.0, (meanWeights*numFirings)));
						}
					}
				}
				
			} catch (Exception e) {
				throw new TurnusException("The calculation of stats cannot be completed", e);
			}
		}

		{ // STEP 3 : Generating the report.
			monitor.subTask("Generating the report ...");
			try {
				ProfilingFactory f = ProfilingFactory.eINSTANCE;
				finalReport = f.createProfilingStatsReport();
				finalReport.setAlgorithm("Profilings-Stats-Reporter");
				finalReport.setDate(new Date());
				finalReport.setNetworkName(actionWeights.getNetwork());
				
				for (Entry<String, ProfilingStatsActor> entry : reportMap.entrySet()) {
					ProfilingStatsActorData actorReport = f.createProfilingStatsActorData();
					actorReport.setActorName(entry.getKey());
					double actionsWeight = entry.getValue().getActionsWeight();
					double schedulerWeight = entry.getValue().getSchedulerWeight();
					actorReport.setActionsWeight(actionsWeight);
					actorReport.setSchedulerWeight(schedulerWeight);
					actorReport.setActionsWeightPercent((actionsWeight * 100)/(actionsWeight+schedulerWeight));
					actorReport.setSchedulerWeightPercent((schedulerWeight * 100)/(actionsWeight+schedulerWeight));					
					finalReport.getActorsStatsData().add(actorReport);
				}
				
				Logger.infoRaw(finalReport.toString());
				
			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}
		
		{ // STEP 4 : Storing the the report.
			monitor.subTask("Storing the report ...");
			try {
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("Profilings-Stats-Reporter", configuration);
				}
				
				Logger.infoRaw(finalReport.toString());
				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.PROFILING_STATS_REPORT);
				EcoreUtils.storeEObject(finalReport, new ResourceSetImpl(), reportFile);
				Logger.info("Profling stats report is stored in \"%s\"", reportFile);
				
			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
		}
		monitor.done();

		return finalReport;
	}	

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()
				.setOption(OUTPUT_DIRECTORY, true)
				.setOption(ACTION_WEIGHTS, true)
				.setOption(SCHEDULING_WEIGHTS, true) 
				/*.setOption(COMMUNICATION_WEIGHTS, true) 
				.setOption(WRITE_HIT_CONSTANT, false) 
				.setOption(WRITE_MISS_CONSTANT, false) */
				;
		configuration = cliParser.parse(args);
	}	

	public static void main(String[] args) throws TurnusException {
		ModelsRegister.init();

		ProfilingStatsReporterCli cliApp = null;

		try {
			cliApp = new ProfilingStatsReporterCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}
	
}

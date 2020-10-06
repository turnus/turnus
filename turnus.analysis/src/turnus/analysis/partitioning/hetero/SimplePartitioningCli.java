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

package turnus.analysis.partitioning.hetero;


import turnus.common.TurnusException;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

/**
 *
 * @author Mahyar Emami
 */

public class SimplePartitioningCli implements IApplication {
	
	
	private Configuration configuration;
	private SimplePartitioning algorithm;
	private IProgressMonitor monitor = new NullProgressMonitor();
	
	public static void main(String[] args) {
		ModelsRegister.init();
		
		SimplePartitioningCli cliApp = null;
		try {
			cliApp = new SimplePartitioningCli();
			cliApp.parseOptions(args);
		} catch (TurnusException e) {
			Logger.error("Could not parse options");
		
		}
		
		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}
	
	private void run() throws TurnusException {
	
		monitor.beginTask("Simple partitioning algorithm", IProgressMonitor.UNKNOWN);
		
		TraceProject project = null;
		NetworkWeight swWeights = null;
		Double swClock  = Double.valueOf(0);
		NetworkWeight hwWeights = null;
		Double hwClock = Double.valueOf(0);
		Integer numCores = Integer.valueOf(0);
		NetworkPartitioning initialPartition = null;
		
		ActorStatisticsReport report = null;
		
		/** Parse the configuration */
		{
			monitor.subTask("Parsing configuration");
			try {
				File traceFile = configuration.getValue(turnus.common.TurnusOptions.TRACE_FILE);
				project = TraceProject.open(traceFile);
				project.loadTrace(new SplittedTraceLoader(),  configuration);
				
			} catch (Exception e) {
				throw new TurnusException("Could not load the trace project", e);
			}
			
			try {
				File swWeightsFile = configuration.getValue(turnus.common.TurnusOptions.ACTION_WEIGHTS_SW);
				swWeights = new XmlNetworkWeightReader().load(swWeightsFile);
				
			} catch (Exception e) {
				throw new TurnusException("Could not load software weights", e);
			}
			
			try {
				swClock = Double.valueOf(1.0) / configuration.getValue(turnus.common.TurnusOptions.FREQ_SW);
				
			} catch (Exception e) {
				throw new TurnusException("Could not read the software clock", e);
			}
			
			try {
				File hwWeightsFile = configuration.getValue(turnus.common.TurnusOptions.ACTION_WEIGHTS_HW);
				hwWeights = new XmlNetworkWeightReader().load(hwWeightsFile);
				
			} catch (Exception e) {
				throw new TurnusException("Could not read the hardware weights", e);
				
			}
			
			try {
				hwClock = Double.valueOf(1.0) / configuration.getValue(turnus.common.TurnusOptions.FREQ_HW);
				
			} catch (Exception e) {
				throw new TurnusException("Could not read the hardware clock");
			}
			
			try {
				numCores = configuration.getValue(turnus.common.TurnusOptions.NUM_CORES);
			} catch (Exception e) {
				throw new TurnusException("Could not get the number of software cores for partitioning", e);
			}
			
			try {
				File partitionFile = configuration.getValue(turnus.common.TurnusOptions.PARTITION_CONSTRAINT);
				initialPartition = new XmlNetworkPartitioningReader().load(partitionFile);
				
			} catch (Exception e) {
				throw new TurnusException("Could not read the partitiong constraint file", e);
			}
		}
		
		/** Run the algorithm */
		
		{
			monitor.subTask("Starting the algorithm");
			try {
				
				algorithm = new SimplePartitioning(project, hwWeights, hwClock, swWeights, swClock, numCores, initialPartition);
				
				algorithm.run();
			} catch (Exception e) {
				e.printStackTrace();
				throw new TurnusException("Could not complete the algorithm", e);
			}
		}
	}
	
	@Override 
	public Object start(IApplicationContext context) throws Exception {
		
		throw new TurnusException("Start method not implemented");
		
//		return IApplication.EXIT_OK;
		
	}
	
	@Override 
	public void stop() {
//		throw new TurnusException("Stop method not implemented");
	}
	
	
	private void parseOptions(String[] args) throws TurnusException {
		
		Configuration.CliParser cliParser = new Configuration.CliParser()
				.setOption(turnus.common.TurnusOptions.TRACE_FILE, true)
				.setOption(turnus.common.TurnusOptions.FREQ_SW, true)
				.setOption(turnus.common.TurnusOptions.ACTION_WEIGHTS_SW, true)
				.setOption(turnus.common.TurnusOptions.ACTION_WEIGHTS_HW, true)
				.setOption(turnus.common.TurnusOptions.FREQ_HW, true)
				.setOption(turnus.common.TurnusOptions.NUM_CORES, true)
				.setOption(turnus.common.TurnusOptions.PARTITION_CONSTRAINT, true);
		configuration = cliParser.parse(args);
	}
	
	
}
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
package turnus.model;

import static turnus.common.TurnusExtensions.*;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import turnus.common.io.Logger;
import turnus.model.analysis.AnalysisPackage;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;
import turnus.model.analysis.buffers.BuffersPackage;
import turnus.model.analysis.communication.CommunicationPackage;
import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.partitioning.PartitioningPackage;
import turnus.model.analysis.pipelining.PipeliningPackage;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.profiler.ProfilerPackage;
import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.architecture.ArchitecturePackage;
import turnus.model.common.CommonPackage;
import turnus.model.dataflow.DataflowPackage;

/**
 * This class contains the utilities method used to register the TURNUS models
 * for stand-alone applications
 * 
 * @author Simone Casale Brunet
 *
 */
public class ModelsRegister {

	/**
	 * Private constructor
	 */
	private ModelsRegister() {

	}

	/**
	 * Initialize all the EMF models and resources
	 */
	public static void init() {
		Logger.debug("Initializing model resources register...");
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put(ARCHITECTURE, new XMIResourceFactoryImpl());
		m.put(NETWORK, new XMIResourceFactoryImpl());
		m.put(PROFILING_CODE, new XMIResourceFactoryImpl());
		m.put(PROFILING_DYNAMIC, new XMIResourceFactoryImpl());
		m.put(TRACE_SIZE, new XMIResourceFactoryImpl());
		m.put(BOTTLENECKS_REPORT, new XMIResourceFactoryImpl());
		m.put(IMPACT_ANALYSIS_REPORT, new XMIResourceFactoryImpl());
		m.put(BOUNDED_BUFFER_REPORT, new XMIResourceFactoryImpl());
		m.put(COMM_COST_PARTITIONING_REPORT, new XMIResourceFactoryImpl());
		m.put(ACTION_VARIABLE_PIPELINING_REPORT, new XMIResourceFactoryImpl());
		m.put(TRACE_COMPRESS_ANALYSIS, new XMIResourceFactoryImpl());
		m.put(TRACE_COMPARATOR_ANALYSIS, new XMIResourceFactoryImpl());
		m.put(PROFILING_MEMORY, new XMIResourceFactoryImpl());
		m.put(TRACE_ACTIONS_MARKOV_ANALYSIS, new XMIResourceFactoryImpl());
		m.put(PIPELINING_IMPACT_ANALYSIS_REPORT, new XMIResourceFactoryImpl());
		m.put(WORKLOAD_BALANCE_PARTITIONING_REPORT, new XMIResourceFactoryImpl());
		m.put(BALANCED_PIPELINE_PARTITIONING_REPORT, new XMIResourceFactoryImpl());
		m.put(METIS_PARTITIONING_REPORT, new XMIResourceFactoryImpl());
		m.put(POST_PROCESSING_ACTOR_REPORT, new XMIResourceFactoryImpl());
		m.put(POST_PROCESSING_ACTION_REPORT, new XMIResourceFactoryImpl());
		m.put(SCHEDULED_BOTTLENECKS_REPORT, new XMIResourceFactoryImpl());
		m.put(BUFFER_BLOCKING_REPORT, new XMIResourceFactoryImpl());
		m.put(POST_PROCESSING_REPORT, new XMIResourceFactoryImpl());
		m.put(INTRA_ACTION_COMM_REPORT, new XMIResourceFactoryImpl());
		m.put(INTER_PARTITION_COMM_MEM_REPORT, new XMIResourceFactoryImpl());
		m.put(LATENCY_REPORT, new XMIResourceFactoryImpl());
		m.put(OPTIMAL_BUFFER_REPORT, new XMIResourceFactoryImpl());
		m.put(SCHEDULER_CHECKS_REPORT, new XMIResourceFactoryImpl());
		m.put(SCHEDULED_IMPACT_ANALYSIS_REPORT, new XMIResourceFactoryImpl());
		m.put(PROFILING_STATS_REPORT, new XMIResourceFactoryImpl());
		m.put(MARKOV_SCHEDULER, new XMIResourceFactoryImpl());
		m.put(COMM_WEIGHT_REPORT, new XMIResourceFactoryImpl());

		CommonPackage.eINSTANCE.eClass();
		DataflowPackage.eINSTANCE.eClass();
		ArchitecturePackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();
		CommunicationPackage.eINSTANCE.eClass();
		AnalysisPackage.eINSTANCE.eClass();
		MapPackage.eINSTANCE.eClass();
		ProfilerPackage.eINSTANCE.eClass();
		BottlenecksPackage.eINSTANCE.eClass();
		BuffersPackage.eINSTANCE.eClass();
		PartitioningPackage.eINSTANCE.eClass();
		PipeliningPackage.eINSTANCE.eClass();
		PostprocessingPackage.eINSTANCE.eClass();
		ProfilingPackage.eINSTANCE.eClass();
		SchedulingPackage.eINSTANCE.eClass();
	}

}

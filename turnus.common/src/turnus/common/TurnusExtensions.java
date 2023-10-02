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
package turnus.common;

/**
 * This class contains the file extensions used by TURNUS
 * 
 * @author Simone Casale Brunet
 *
 */
public class TurnusExtensions {

	/** The architecture file model */
	public static final String ARCHITECTURE = "xaf";

	/** The bottleneck report file */
	public static final String BOTTLENECKS_REPORT = "bottlenecks";
	
	/** The scheduled bottleneck report file */
	public static final String SCHEDULED_BOTTLENECKS_REPORT = "sbottlenecks";

	/** The bounded buffers report file */
	public static final String BOUNDED_BUFFER_REPORT = "boundbuffer";
	
	/** The optimal buffers report file */
	public static final String OPTIMAL_BUFFER_REPORT = "optimalbuffer";

	/** The communication cost partitioning report file */
	public static final String COMM_COST_PARTITIONING_REPORT = "pcomm";
	
	/** The workload balance partitioning report file */
	public static final String WORKLOAD_BALANCE_PARTITIONING_REPORT = "pwbal";
	
	/** The balanced pipeline partitioning report file */
	public static final String BALANCED_PIPELINE_PARTITIONING_REPORT = "pbpipe";
	
	/** The post processing  report file */
	public static final String POST_PROCESSING_REPORT = "ppreport";
	
	/** The post processing (actor) report file */
	public static final String POST_PROCESSING_ACTOR_REPORT = "pproar";
	
	/** The post processing (action) report file */
	public static final String POST_PROCESSING_ACTION_REPORT = "pproan";
	
	/** The post processing (action) report file */
	public static final String SCHEDULER_CHECKS_REPORT = "screport";
	
	/** The post processing (blocking buffers) report file */
	public static final String BUFFER_BLOCKING_REPORT = "bbreport";

	/** The action variable pipelining analysis report file */
	public static final String ACTION_VARIABLE_PIPELINING_REPORT = "varpipe";

	/** The pipelining impact-analysis report file */
	public static final String PIPELINING_IMPACT_ANALYSIS_REPORT = "pimpact";

	/** The buffer site configuration XML file */
	public static final String BUFFER_SIZE = "bxdf";
	
	/** The profiling stats report file */
	public static final String PROFILING_STATS_REPORT = "profstat";

	/** The CAL file */
	public static final String CAL = "cal";

	/** The impact-analysis report file */
	public static final String IMPACT_ANALYSIS_REPORT = "impact";
	
	/** The scheduled impact-analysis report file */
	public static final String SCHEDULED_IMPACT_ANALYSIS_REPORT = "simpact";

	/** The mapping file **/
	public static final String MAPPING = "xcf";

	/** The network file model */
	public static final String NETWORK = "net";

	/** The network weights XML file */
	public static final String NETWORK_WEIGHT = "exdf";
	
	/** The network scheduling weights XML file */
	public static final String SCHEDULE_WEIGHT = "sxdf";

	/** The NL CAL file */
	public static final String NL = "nl";

	/** The operators costs XML file */
	public static final String OPERATORS_COSTS = "ops";

	/** The static code profiling report file */
	public static final String PROFILING_CODE = "cprof";

	/** The static dynamic profiling report file */
	public static final String PROFILING_DYNAMIC = "dprof";

	/** The MD report file */
	public static final String REPORT = "report";

	/** The execution trace graph file */
	public static final String TRACE = "trace";

	/** The compressed trace analysis report file */
	public static final String TRACE_COMPRESS_ANALYSIS = "ctrace";

	/** The actions markov trace analysis report file */
	public static final String TRACE_ACTIONS_MARKOV_ANALYSIS = "amtrace";

	/** The trace comparator analysis report file */
	public static final String TRACE_COMPARATOR_ANALYSIS = "dtraces";

	/** The execution trace graph file size */
	public static final String TRACE_SIZE = "tsize";

	/** The compressed execution trace graph file */
	public static final String TRACEZ = "tracez";

	/** The compressed execution trace data file */
	public static final String ETRACEZ = "etracez";

	/** The execution trace data information file */
	public static final String ETRACE_INFO = "info";

	/** The XDF CAL file */
	public static final String XDF = "xdf";

	/** The network partitioning mapping file */
	public static final String NETWORK_PARTITIONING = "xcf";
	
	
	/** Graphviz Dot file */
	public static final String DOT = "dot";

	/** the configuration file */
	public static final String CONFIGURATION = "conf";

	/** The memory profiling file */
	public static final String PROFILING_MEMORY = "mprof";
	
	/** The communication weights file */
	public static final String COMMUNICATION_WEIGHT = "cxdf";
	
	/** The Intra-Action communication analysis report file */
	public static final String INTRA_ACTION_COMM_REPORT = "iacomm";
	
	/** The Inter-Partition communication and memory analysis report file */
	public static final String INTER_PARTITION_COMM_MEM_REPORT = "ipcomm";

	/** The actor selection schedule*/
	public static final String ACTOR_SELECTION_SCHEDULE = "assched";
	/** Markov scheduler report file */
	public static final String MARKOV_SCHEDULER = "mvsched";
}

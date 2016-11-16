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

import java.io.File;
import java.util.List;
import java.util.Map;

import turnus.common.configuration.Option;
import turnus.common.configuration.Option.Description;

/**
 * This class contains the options used by TURNUS
 * 
 * @author Simone Casale Brunet
 *
 */
@SuppressWarnings("rawtypes")
public class TurnusOptions {

	@Description("Make the communication partitioning bit accurate")
	public static final Option<Boolean> ANALYSIS_PARTITIONING_COMM_BIT_ACCURATE;

	@Description("Defines the number of units available for partitioning the actors")
	public static final Option<Integer> ANALYSIS_PARTITIONING_UNITS;

	@Description("Make the buffer size analysis bit accurate. The size is defined in terms of bit and not tokens")
	public static final Option<Boolean> ANALYSIS_BUFFER_BIT_ACCURATE;

	@Description("Buffer size is evaluated only considering size with power of 2 values (e.g. 2, 8, ..., 1024, ...)")
	public static final Option<Boolean> ANALYSIS_BUFFER_POW2;

	@Description("Perform the impact analysis at a actor-class level. Actions of the same actor-class are considered as the same when evaluating the ciritical path partecipation factor")
	public static final Option<Boolean> ANALYSIS_IMPACT_CLASS_LEVEL;

	@Description("Select the maximum number of most-critical actions that should be analysed during the impact analysis")
	public static final Option<Integer> ANALYSIS_IMPACT_MAX_ACTIONS;

	@Description("Select the gridding value for the impact analysis. As an example, a value 10 means that the analysis is perfomed for 10 different weigh reduction (i.e. 10%, 20%, ..., 100%)")
	public static final Option<Integer> ANALYSIS_IMPACT_MAX_POINTS;

	@Description("The default buffer size used for the analysis when a specific size is not provided")
	public static final Option<Integer> BUFFER_SIZE_DEFAULT;
	
	@Description("The file with buffer sizes")
	public static final Option<File> BUFFER_SIZE_FILE;

	@Description("The CAL project to be analysed")
	public static final Option<String> CAL_PROJECT;

	@Description("The input file used as input stimulus of the design under test")
	public static final Option<File> CAL_STIMULUS_FILE;
	
	@Description("The output file from the design under test")
	public static final Option<File> SIMULATION_OUTPUT_FILE;

	@Description("The top XDF file of the design under test")
	public static final Option<String> CAL_XDF;

	@Description("Compress the generated trace file. A .tracez file created")
	public static final Option<Boolean> COMPRESS_TRACE;

	@Description("Export the gantt chart file of a network execution")
	public static final Option<Boolean> EXPORT_GANTT_CHART;

	@Description("Export the execution trace file of a network execution")
	public static final Option<Boolean> EXPORT_TRACE;

	@Description("The mapping configuration map")
	public static final Option<Map> MAPPING;
	
	@Description("The mapping configuration file. Supported file extensions is .xcf")
	public static final Option<File> MAPPING_FILE;

	@Description("Merge all the FSM dependencies when loading the execution trace graph")
	public static final Option<Boolean> MERGE_FSM;

	@Description("Merge all the guard dependencies when loading the execution trace graph")
	public static final Option<Boolean> MERGE_GUARD;

	@Description("Merge all the port dependencies when loading the execution trace graph")
	public static final Option<Boolean> MERGE_PORT;

	@Description("Merge all the tokens dependencies when loading the execution trace graph")
	public static final Option<Boolean> MERGE_TOKENS;

	@Description("Merge all the variable dependencies when loading the execution trace graph")
	public static final Option<Boolean> MERGE_VARIABLE;

	@Description("The root output directory for the generated files")
	public static final Option<File> OUTPUT_DIRECTORY;

	@Description("Enable the shared variable support. Variables that are shared can be considered")
	public static final Option<Boolean> SHARED_VARIABLES;

	@Description("Include the depdendencies when splitting the trace with splitted trace-loader")
	public static final Option<Boolean> SPLIT_TRACE_DEPENDENCIES;

	@Description("Regenerate all the temporary files when loading the trace")
	public static final Option<Boolean> CONFIG_REMOVE_TEMP_TRACE_FILES;

	@Description("Enable the stack protection when generating or interpreting CAL files")
	public static final Option<Boolean> STACK_PROTECTION;

	@Description("The trace file. Supported file extensions are: .trace and .tracez")
	public static final Option<File> TRACE_FILE;

	@Description("A set of trace files. Supported file extensions are: .trace and .tracez")
	public static final Option<List<String>> TRACE_FILES_SET;

	@Description("The trace-loader used to load the trace file")
	public static final Option<String> TRACE_LOADER;

	@Description("Print all the debug information")
	public static final Option<Boolean> CONFIG_VERBOSE;
	
	@Description("Minimize the memory usage required by the analysies (the cost will be that some analysies could be slower)")
	public static final Option<Boolean> CONFIG_MINIMIZE_MEMORY_USAGE;

	@Description("The versioner name used to versioning the project files")
	public static final Option<String> VERSIONER;

	@Description("The actions weights file. Supported file extensions is .exdf")
	public static final Option<File> ACTION_WEIGHTS;
	
	@Description("The buffers weights file. Supported file extensions is .cxdf")
	public static final Option<File> COMMUNICATION_WEIGHTS;
	
	@Description("The buffers weights file. Supported file extensions is .sxdf")
	public static final Option<File> SCHEDULING_WEIGHTS;
	
	@Description("The trace weighter used to weight the trace")
	public static final Option<String> TRACE_WEIGHTER;

	@Description("The maximum number of threads used for performing an analysis")
	public static final Option<Integer> CONFIG_MAX_THREADS;
	
	@Description("The size of the shared queues used by parallel processes/threads used when performing the anylsis")
	public static final Option<Integer> CONFIG_QUEUES_SIZE;
	
	@Description("The size of the input/output streams used when reading/writing a file during the anylsis process")
	public static final Option<Integer> CONFIG_STREAM_BUFFERS_SIZE;
	
	@Description("The architecture name selected among the registered architecture models")
	public static final Option<String> ARCHITECTURE_NAME;
	
	@Description("The time allowed for an analysis (used by local search methods). Expressed in minutes.")
	public static final Option<Integer> ANALYSIS_TIME;
	
	@Description("The maximal number of iterations of an analysis")
	public static final Option<Integer> MAX_ITERATIONS;
	
	@Description("Use post-processor simulation to evaluate moves in the partitioning algorithm. ")
	public static final Option<Boolean> USE_SIMULATION;
	
	@Description("Scheduling policy that will be used for the post-processor simulation. ")
	public static final Option<String> SCHEDULING_POLICY;
	
	@Description("Percentage of neighborhood that will be checked by the tabu search [0-1.0]. ")
	public static final Option<Double> TABU_P;
	
	@Description("Number that will be used to initialize the random generators inside the tabu search. ")
	public static final Option<Integer> TABU_SEED;
	
	@Description("Neighborhood generator to be used fir the tabu search. ")
	public static final Option<String> TABU_GENERATOR;
	
	@Description("Partitioning algorithm to specify the initial configuration for the local/tabu search methods. ")
	public static final Option<String> INITIAL_ALGORITHM;
	
	@Description("A constant to be assigned as latency for write hit. ")
	public static final Option<Integer> WRITE_HIT_CONSTANT;
	
	@Description("A constant to be assigned as latency for write miss. ")
	public static final Option<Integer> WRITE_MISS_CONSTANT;
	
	@Description("Store the recorded occupancy of each buffer.")
	public static final Option<Boolean> RECORD_BUFFERS;
	
	@Description("Release the buffers after processing, not after the reading of data.")
	public static final Option<Boolean> RELEASE_BUFFERS_AFTER_PROCESSING;

	// options are initialized here in order to make this file more readable
	static {
		
		MAX_ITERATIONS = Option.create().//
				setName("maxIterations").//
				setDescription("Defines the maximal number of iterations of the analysis")//
				.setLongName("turnus.analysis.maxIterations").//
				setType(Integer.class).build();
		
		CONFIG_MINIMIZE_MEMORY_USAGE = Option.create().//
				setName("cminMemoryUsage").//
				setDescription("Minimize the memory usage required by the analysies (the cost will be that some analysies could be slower)")//
				.setLongName("turnus.config.minimizeMemoryUsage").//
				setType(Boolean.class).build();
		
		ARCHITECTURE_NAME = Option.create().//
				setName("architecture").//
				setDescription("The architecture name selected among the registered architecture models")//
				.setLongName("turnus.mapping.architecture").//
				setType(String.class).build();
		
		CONFIG_STREAM_BUFFERS_SIZE = Option.create().//
				setName("cmaxStreamBufferSize").//
				setDescription("The size of the input/output streams used when reading/writing a file during the anylsis process")//
				.setLongName("turnus.config.maxStreamBufferSize").//
				setType(Integer.class).build();
		
		CONFIG_QUEUES_SIZE = Option.create().//
				setName("cmaxQueueSize").//
				setDescription("The size of the shared queues used by parallel processes/threads used when performing the anylsis")//
				.setLongName("turnus.config.maxQueueSize").//
				setType(Integer.class).build();

		TRACE_FILES_SET = Option.create().//
				setName("traceset").//
				setDescription("A set of trace files. Supported file extensions are: .trace and .tracez").//
				setLongName("turnus.traceset").//
				setType(List.class).build();

		CAL_PROJECT = Option.create().//
				setName("calProject").//
				setDescription("The CAL project to be analysed").//
				setLongName("turnus.cal.project").//
				setType(String.class).build();

		CAL_XDF = Option.create().//
				setName("xdf").//
				setDescription("The top XDF file of the design under test").//
				setLongName("turnus.cal.xdf").//
				setType(String.class).build();

		CAL_STIMULUS_FILE = Option.create().//
				setName("stimulus").//
				setDescription("The input file used as input stimulus of the design under test").//
				setLongName("turnus.cal.stimulus").//
				setType(File.class).build();
		
		SIMULATION_OUTPUT_FILE = Option.create().//
				setName("output").//
				setDescription("The output file of the design under test").//
				setLongName("turnus.cal.output").//
				setType(File.class).build();

		MAPPING = Option.create().//
				setName("mapping").//
				setDescription("The mapping configuration map").//
				setLongName("turnus.mapping.map").//
				setType(Map.class).build();
		
		MAPPING_FILE = Option.create().//
				setName("xcf").//
				setDescription("The mapping configuration file. Supported file extensions is .xcf").//
				setLongName("turnus.mapping.file").//
				setType(File.class).build();

		OUTPUT_DIRECTORY = Option.create().//
				setName("out").//
				setDescription("The root output directory for the generated files").//
				setLongName("turnus.out").//
				setType(File.class).build();

		TRACE_FILE = Option.create().//
				setName("trace").//
				setDescription("The trace file. Supported file extensions are: .trace and .tracez").//
				setLongName("turnus.trace").//
				setType(File.class).build();

		ACTION_WEIGHTS = Option.create().//
				setName("weight").//
				setDescription("The action weights file. Supported file extensions is .exdf").//
				setLongName("turnus.weight").//
				setType(File.class).build();
		
		COMMUNICATION_WEIGHTS = Option.create().//
				setName("communicationWeight").//
				setDescription("The communication weights file. Supported file extensions is .cxdf").//
				setLongName("turnus.weight.communication").//
				setType(File.class).build();
		
		SCHEDULING_WEIGHTS = Option.create().//
				setName("schedulingWeight").//
				setDescription("The scheduling weights file. Supported file extensions is .sxdf").//
				setLongName("turnus.weight.scheduling").//
				setType(File.class).build();

		TRACE_LOADER = Option.create().//
				setName("traceLoader").//
				setDescription("The trace-loader used to load the trace file").//
				setLongName("turnus.traceLoader").//
				setType(String.class).build();
		
		TRACE_WEIGHTER = Option.create().//
				setName("traceWeighter").//
				setDescription("The trace weighter used to weight the trace").//
				setLongName("turnus.traceWeighter").//
				setType(String.class).build();

		CONFIG_VERBOSE = Option.create().//
				setName("x").//
				setDescription("Print all the debug information").//
				setLongName("turnus.debug").//
				setType(Boolean.class).build();

		VERSIONER = Option.create().//
				setName("versioner").//
				setDescription("The versioner name used to versioning the project files").//
				setLongName("turnus.versioner").//
				setType(String.class).build();

		BUFFER_SIZE_DEFAULT = Option.create().//
				setName("defaultBuffer").//
				setDescription("The default buffer size used for the analysis when a specific size is not provided").//
				setLongName("turnus.defaultBufferSize").//
				setType(Integer.class).build();
		
		BUFFER_SIZE_FILE = Option.create().//
				setName("bufferFile").//
				setDescription("The file with buffer sizes used for the analysis").//
				setLongName("turnus.bufferFile").//
				setType(File.class).build();

		SHARED_VARIABLES = Option.create().//
				setName("sharedVariables").//
				setDescription("Enable the shared variable support. Variables that are shared can be considered").//
				setLongName("turnus.profiler.sharedVariables").//
				setType(Boolean.class).build();

		STACK_PROTECTION = Option.create().//
				setName("stackProtection").//
				setDescription("Enable the stack protection when generating or interpreting CAL files").//
				setLongName("turnus.profiler.stackProtection").//
				setType(Boolean.class).build();

		COMPRESS_TRACE = Option.create().//
				setName("traceCompress").//
				setDescription("Compress the generated trace file. A .tracez file created").//
				setLongName("turnus.profiler.traceCompress").//
				setType(Boolean.class).build();	 

		SPLIT_TRACE_DEPENDENCIES = Option.create().//
				setName("splitLoaderDependencies").//
				setDescription("Include the depdendencies when splitting the trace with splitted trace-loader")//
				.setLongName("turnus.traceLoader.split.dependencies").//
				setType(Boolean.class).build();

		CONFIG_REMOVE_TEMP_TRACE_FILES = Option.create().//
				setName("ctraceRemoveTemps").//
				setDescription("Regenerate all the temporary files when loading the trace")//
				.setLongName("turnus.config.trace.removeTempFiles").//
				setType(Boolean.class).build();

		EXPORT_GANTT_CHART = Option.create().//
				setName("exportGantt").//
				setDescription("Export the gantt chart of a network execution")//
				.setLongName("turnus.gantt.export").//
				setType(Boolean.class).build();

		EXPORT_TRACE = Option.create().//
				setName("exportTrace").//
				setDescription("Export the execution trace file of a network execution")//
				.setLongName("turnus.trace.export").//
				setType(Boolean.class).build();

		MERGE_FSM = Option.create().//
				setName("mergeFsm").//
				setDescription("Merge all the FSM dependencies when loading the execution trace graph")//
				.setLongName("turnus.trace.merge.fsm").//
				setType(Boolean.class).build();

		MERGE_GUARD = Option.create().//
				setName("mergeGuard").//
				setDescription("Merge all the guard dependencies when loading the execution trace graph")//
				.setLongName("turnus.trace.merge.guard").//
				setType(Boolean.class).build();

		MERGE_PORT = Option.create().//
				setName("mergePort").//
				setDescription("Merge all the port dependencies when loading the execution trace graph")//
				.setLongName("turnus.trace.merge.port").//
				setType(Boolean.class).build();

		MERGE_TOKENS = Option.create().//
				setName("mergeTokens").//
				setDescription("Merge all the tokens dependencies when loading the execution trace graph")//
				.setLongName("turnus.trace.merge.tokens").//
				setType(Boolean.class).build();

		MERGE_VARIABLE = Option.create().//
				setName("mergeVariable").//
				setDescription("Merge all the variable dependencies when loading the execution trace graph")//
				.setLongName("turnus.trace.merge.variable").//
				setType(Boolean.class).build();

		ANALYSIS_BUFFER_BIT_ACCURATE = Option.create().//
				setName("bufferBitSize").//
				setDescription(
						"Make the buffer size analysis bit accurate. The size is defined in terms of bit and not tokens")//
				.setLongName("turnus.analysis.buffer.bitSize").//
				setType(Boolean.class).build();

		ANALYSIS_BUFFER_POW2 = Option.create().//
				setName("bufferPow2Size").//
				setDescription(
						"Buffer size is evaluated only considering size with power of 2 values (e.g. 2, 8, ..., 1024, ...)")//
				.setLongName("turnus.analysis.buffer.pow2size").//
				setType(Boolean.class).build();

		ANALYSIS_IMPACT_MAX_ACTIONS = Option.create().//
				setName("impactActions").//
				setDescription(
						"Select the maximum number of most-critical actions that should be analysed during the impact analysis")//
				.setLongName("turnus.analysis.bottlenecks.impact.actions").//
				setType(Integer.class).build();

		ANALYSIS_IMPACT_MAX_POINTS = Option.create().//
				setName("impactGridding").//
				setDescription(
						"Select the gridding value for the impact analysis. As an example, a value 10 means that the analysis is perfomed for 10 different weigh reduction (i.e. 10%, 20%, ..., 100%)")//
				.setLongName("turnus.analysis.bottlenecks.impact.gridding").//
				setType(Integer.class).build();

		ANALYSIS_IMPACT_CLASS_LEVEL = Option.create().//
				setName("impactClassLevel").//
				setDescription(
						"Perform the impact analysis at a actor-class level. Actions of the same actor-class are considered as the same when evaluating the ciritical path partecipation factor")//
				.setLongName("turnus.analysis.bottlenecks.impact.classLevel").//
				setType(Boolean.class).build();

		ANALYSIS_PARTITIONING_COMM_BIT_ACCURATE = Option.create().//
				setName("commBitAccurate").//
				setDescription("Make the communication partitioning bit accurate")//
				.setLongName("turnus.analysis.partitioning.comms.bitAccurate").//
				setType(Boolean.class).build();

		ANALYSIS_PARTITIONING_UNITS = Option.create().//
				setName("units").//
				setDescription("Defines the number of units available for partitioning the actors")//
				.setLongName("turnus.analysis.partitioning.units").//
				setType(Integer.class).build();

		CONFIG_MAX_THREADS = Option.create().//
				setName("maxThreads").//
				setDescription("The maximum number of threads used for performing an analysis")//
				.setLongName("turnus.config.maxThreads").//
				setType(Integer.class).build();
		
		ANALYSIS_TIME = Option.create().//
				setName("time").//
				setDescription("Defines the amount of time (in minutes) allowed for an analysis")//
				.setLongName("turnus.analysis.partitioning.time").//
				setType(Integer.class).build();
		
		USE_SIMULATION = Option.create().//
				setName("simulation").//
				setDescription("Specifies if the post-processor simulation should be used to evaluate the move in the partitioning algorithm")//
				.setLongName("turnus.analysis.partitioning.simulation").//
				setType(Boolean.class).build();
		
		SCHEDULING_POLICY = Option.create().//
				setName("scheduling").//
				setDescription("Specifies the scheduling policy that will be used by the post-processor simulation")//
				.setLongName("turnus.analysis.partitioning.scheduling").//
				setType(String.class).build();
		
		TABU_P = Option.create().//
				setName("tabuP").//
				setDescription("Specifies the percentage of neighboring solutions that will be checked by the tabu search. ")//
				.setLongName("turnus.analysis.partitioning.tabu.p").//
				setType(Double.class).build();
		
		TABU_SEED = Option.create().//
				setName("tabuSeed").//
				setDescription("Specifies the number that will be used to initialize random generators in the tabu search. ")//
				.setLongName("turnus.analysis.partitioning.tabu.seed").//
				setType(Integer.class).build();
		
		INITIAL_ALGORITHM = Option.create().//
				setName("initialAlgorithm").//
				setDescription("Specifies the partitioning heuristic that will provide an initial partitioning configuration: KL (Kerninghan-Lin), WB (Workload Balance), BP (Balanced Pipeline). ")//
				.setLongName("turnus.analysis.partitioning.initial.algorithm").//
				setType(String.class).build();
		
		TABU_GENERATOR = Option.create().//
				setName("tabuGenerator").//
				setDescription("Specifies the neighborhood generator to be used by tabu search: RANDOM, IDLE, COMM_FREQ, BALANCING, PROB, JOINT. ")//
				.setLongName("turnus.analysis.partitioning.tabu.generator").//
				setType(String.class).build();
		
		WRITE_HIT_CONSTANT = Option.create().//
				setName("writeHit").//
				setDescription("Defines a constant to be assigned as latency for write hit.")//
				.setLongName("turnus.analysis.write.hit.latency").//
				setType(Integer.class).build();
		
		WRITE_MISS_CONSTANT = Option.create().//
				setName("writeMiss").//
				setDescription("Defines a constant to be assigned as latency for write miss.")//
				.setLongName("turnus.analysis.write.miss.latency").//
				setType(Integer.class).build();
		
		RECORD_BUFFERS = Option.create().//
				setName("recordBuffers").//
				setDescription("Store the recorded occupancy of each buffer. A .bxdf file is created.").//
				setLongName("turnus.analysis.record.buffers").//
				setType(Boolean.class).build();	 
		
		RELEASE_BUFFERS_AFTER_PROCESSING = Option.create().//
				setName("releaseAfterProcessing").//
				setDescription("Release the space in fifos after processing, not after reading.").//
				setLongName("turnus.analysis.release.after.processing").//
				setType(Boolean.class).build();	 
	}

	/**
	 * Private constructor
	 */
	private TurnusOptions() {
	}

}

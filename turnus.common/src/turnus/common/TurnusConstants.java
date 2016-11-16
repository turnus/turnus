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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import turnus.common.configuration.Configuration.LaunchConfigurationParser;

/**
 * This class contains the string constants used by TURNUS.
 * 
 * @author Simone Casale Brunet
 *
 */
public class TurnusConstants {

	/**
	 * a launch configuration widget without associate option-id prefix. This
	 * constant is used inside {@link LaunchConfigurationParser} to remove
	 * mapped launch configuration options that are not associated to any TURNUS
	 * option
	 */
	public static final String CONFIGURATION_UNDEFINED_OPTION = "undefined.option.";

	/** the path used to contains the database of a loaded trace */
	public static final String DB_PATH_NAME = "__trace_db";

	/**
	 * The default number of maximal threads used when performing an analysis
	 * that can be splitted in more threads
	 */
	public static int DEFAULT_MAX_THREADS = 8;

	/**
	 * The default size for blocking queues used by threads/processes that
	 * communicate through shared queues
	 */
	public static int DEFAULT_QUEUE_SIZE = 200000;
	
	/**
	 * The default value for the minimizing memory usage of the analyzes
	 */
	public static boolean DEFAULT_MINIMIZE_MEMORY_USAGE = true;

	/**
	 * The default size for buffered streams (e.g {@link BufferedInputStream} or
	 * {@link BufferedOutputStream})
	 */
	public static int DEFAULT_STREAM_BUFFER_SIZE = 65536;

	/** the path used to contains execution profiling data */
	public static final String EXECUTION_PROFILING_DATA = "__execution_data";

	/** the path used to contains the splitted version of a loaded trace */
	public static final String SPLIT_TRACE_PATH_NAME = "__trace_split";
	
	/** Before loading a trace remove all the previously generated temporary file */
	public static boolean DEFAULT_REMOVE_TEMP_TRACE_FILES = false;

	/**
	 * the file name used to stored the trace data information of a loaded
	 * trace. Used by a splitted or database trace.
	 */
	public static final String TRACE_PROPERTIES_FILE = "traceData.tdata";
	
	/**
	 * The default versioner name
	 */
	public static final String DEFAULT_VERSIONER = "Git";
	
	/**
	 * private constructor
	 */
	private TurnusConstants(){
		
	}

}

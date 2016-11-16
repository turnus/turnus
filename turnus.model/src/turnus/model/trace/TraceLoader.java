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
package turnus.model.trace;

import java.io.File;

import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;

/**
 * This class defines a trace loader. Each trace loader should be registered
 * suing the {@code turnus.model.traceLoader} extension point.
 * 
 * @author Simone Casale Brunet
 *
 */
public interface TraceLoader {

	/**
	 * Load the execution trace graph from the given file. This latter should be
	 * a valid .trace or .tracez file
	 * 
	 * @param traceFile
	 *            the trace file
	 * @param configuration
	 *            the loading configuration
	 * @return the trace
	 * @throws TurnusException
	 *             thrown if the trace cannot be loaded correctly
	 */
	Trace load(File traceFile, Configuration configuration) throws TurnusException;

}

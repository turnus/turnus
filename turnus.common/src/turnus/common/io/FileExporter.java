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
package turnus.common.io;

import java.io.File;

import turnus.common.TurnusException;

/**
 * This interface defines a file exporter. Its implementation should be
 * registered in the {@code turnus.common.io.fileExporter} extension point where
 * the supported input and output file extensions are defined. Each registered
 * FileExporter is then made available through the {@link FileExporterFactory}.
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 * @param <T> the object type supported by the exporter
 */
public interface FileExporter<T, U> {

	/**
	 * Export the given input file to the given output file
	 * 
	 * @param input  the input file
	 * @param output the output file
	 * @throws TurnusException raised when an error occurred and the input file
	 *                         cannot be exported
	 */
	void export(File input, File output) throws TurnusException;

	/**
	 * Export the given object to the output file
	 * 
	 * @param object the object to be exported
	 * @param output the output file
	 * @throws TurnusException raised when an error occurred and the object cannot
	 *                         be exported
	 */
	void export(T object, File output) throws TurnusException;

	U content(T object);

}

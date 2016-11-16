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
package turnus.analysis.profiler.code.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;

import turnus.common.io.Logger;
import turnus.common.util.FileUtils;

/**
 * This class contains some methods used for analyzing the raw source code files
 * 
 * @author Simone Casale-Brunet
 *
 */
public class SourceCodeUtil {

	/**
	 * Compute the number of source code lines of the given file
	 * 
	 * @param file
	 * @return
	 */
	public static int numberOfLines(IFile file) {
		File f = null;
		try {
			f = FileUtils.getFile(file);
		} catch (Exception e) {
			Logger.warning("Number of lines cannot be evaluated: the file is not valid");
			return 0;
		}
		try {
			return numberOfLines(f);
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * Compute the number of source code lines of the given file
	 * 
	 * @param file
	 * @return
	 */
	public static int numberOfLines(File file) {
		int lines = 0;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			String str = "";

			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (!(str.isEmpty() || str.startsWith("/*")
						|| str.startsWith("*") || str.startsWith("//"))) {
					lines++;
				}
			}

			try {
				br.close();
			} catch (Exception e) {
			}

		} catch (Exception e) {
			Logger.warning("Number of lines cannot be evaluated: %s");
			lines = 0;
		}

		return lines;
	}

}

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
package adevs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang3.SystemUtils;

import java.nio.file.Files;

import turnus.common.TurnusRuntimeException;

/**
 * This class contains the method to dynamically load the ADEVS libraries at
 * runtime
 * 
 * @author Endri Bezati
 * @author Simone Casale-Brunet
 *
 */
public class LibraryLoader {

	/**
	 * Load the ADEVS libraries
	 */
	public static void loadAdevsLibrary() {
		try {

			if (SystemUtils.IS_OS_LINUX) {
				loadFile("libjava_adevs.so");
			} else if (SystemUtils.IS_OS_MAC_OSX) {
				loadFile("libadevs.dylib");
			}else {
				throw new TurnusRuntimeException("ADEVS is not supported on this OS.");
			}
			
//			System.loadLibrary("java_adevs"); this shouldn't be needed ?
		} catch (Exception e) {
			throw new TurnusRuntimeException("ADEVS libraries cannot be loaded");
		}
	}

	/**
	 * Adds the specified path to the java library path
	 * 
	 * Code copied from
	 * {@link http://fahdshariff.blogspot.ch/2011/08/changing-java-library-path-at-runtime.html}
	 *
	 * @param pathToAdd the path to add
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void addLibraryPath(String pathToAdd) throws Exception {
		final Field usrPathsField = ClassLoader.class.getDeclaredField("usr_paths");
		usrPathsField.setAccessible(true);

		// get array of paths
		final String[] paths = (String[]) usrPathsField.get(null);

		// check if the path to add is already present
		for (String path : paths) {
			if (path.equals(pathToAdd)) {
				return;
			}
		}

		// add the new path
		final String[] newPaths = Arrays.copyOf(paths, paths.length + 1);
		newPaths[newPaths.length - 1] = pathToAdd;
		usrPathsField.set(null, newPaths);
	}

	/**
	 * Load a library file on a temporary path
	 * 
	 * @param fileName
	 * @param extension
	 * @throws Exception
	 */
	private static void loadFile(String fileName) throws Exception {
		InputStream is = LibraryLoader.class.getResourceAsStream(fileName);
		File path = Files.createTempDirectory("tmp").toFile();
		path.deleteOnExit();
//		addLibraryPath(path.getAbsolutePath()); this shouldn't be needed ?

		File file = new File(path, fileName);

		OutputStream os = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) != -1) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
		System.load(file.getAbsolutePath());
	}

}

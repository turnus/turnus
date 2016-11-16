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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.common.Activator;

/**
 * This class is used to get access to all the registered {@link FileExporter}
 * in the the {@code turnus.common.io.fileExporter} extension point.
 * 
 * @author Simone Casale Brunet
 *
 */
public class FileExporterFactory {

	/** the factory instance */
	public static final FileExporterFactory INSTANCE = new FileExporterFactory();

	/** (input extension, output extension, exporter) table */
	private Table<String, String, FileExporter<?>> exporters;

	/**
	 * Private builder for the factory
	 */
	private FileExporterFactory() {
		exporters = HashBasedTable.create();
		try {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] elements = registry
					.getConfigurationElementsFor(Activator.PLUGIN_ID + ".fileExporter");
			for (IConfigurationElement element : elements) {
				try {
					String in = element.getAttribute("input");
					if (in.startsWith(".")) {
						in.replaceFirst(".", "");
					}
					String out = element.getAttribute("output");
					if (out.startsWith(".")) {
						out.replaceFirst(".", "");
					}
					FileExporter<?> exporter = (FileExporter<?>) element.createExecutableExtension("class");
					exporters.put(in, out, exporter);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			Logger.debug("File exporter factory error: %s", e.toString());
		}
	}

	/**
	 * Get the set of supported output file extension for a given input file
	 * extension
	 * 
	 * @param input
	 *            the input file extension (with or without {@code "."})
	 * @return the set of supported output file extensions (without {@code "."})
	 */
	public Set<String> getSupportedOutputs(String input) {
		Set<String> outs = new HashSet<>();

		// check not null
		if (input == null) {
			return outs;
		} else if (input.startsWith(".")) { // clean the format
			input = input.replaceFirst(".", "");
		}

		for (String out : exporters.row(input).keySet()) {
			outs.add(out);
		}
		return outs;
	}

	/**
	 * Get the set of supported input file extension for a given output file
	 * extension
	 * 
	 * @param output
	 *            the output file extension (with or without {@code "."})
	 * @return the set of supported input file extensions (without {@code "."})
	 */
	public Set<String> getSupportedInputs(String output) {
		Set<String> inputs = new HashSet<>();

		// check not null
		if (output == null) {
			return inputs;
		} else if (output.startsWith(".")) { // clean the format
			output = output.replaceFirst(".", "");
		}

		for (Cell<String, String, FileExporter<?>> e : exporters.cellSet()) {
			if (e.getColumnKey().equals(output))
				inputs.add(e.getRowKey());
		}
		return inputs;
	}

	/**
	 * Get the {@link FileExporter} for a given couple of input and output file
	 * extensions
	 * 
	 * @param input
	 *            the input file extension (with or without {@code "."})
	 * @param output
	 *            the output file extension (with or without {@code "."})
	 * @return the file exporter if any, null otherwise
	 */
	public FileExporter<?> getExporter(String input, String output) {
		if (input == null || output == null) {
			return null;
		}

		if (input.startsWith(".")) {
			input = input.replaceFirst(".", "");
		}

		if (output.startsWith(".")) {
			output = output.replaceFirst(".", "");
		}

		return exporters.get(input, output);
	}

	/**
	 * Check if there is any registered {@link FileExporter} for a given couple
	 * of input and output file extensions
	 * 
	 * @param input
	 *            the input file extension (with or without {@code "."})
	 * @param output
	 *            the output file extension (with or without {@code "."})
	 * @return true if a file exporter exists, false otherwise
	 */
	public boolean hasExporter(String input, String output) {
		if (input == null || output == null) {
			return false;
		}

		if (input.startsWith(".")) {
			input = input.replaceFirst(".", "");
		}

		if (output.startsWith(".")) {
			output = output.replaceFirst(".", "");
		}

		return exporters.contains(input, output);
	}

}

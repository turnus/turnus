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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import turnus.common.io.Logger;
import turnus.model.trace.impl.inmemory.InMemoryTraceLoader;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

/**
 * This class defines the {@link TraceLoader} factory. Loaders can be accessed 
 * by their name using the {@link #getLoader(String)} method.
 * 
 * <p>In the headless (non-Eclipse) version, loaders are registered directly
 * rather than through Eclipse extension points.</p>
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceLoaderFactory {

	/** the static instance */
	public static final TraceLoaderFactory INSTANCE = new TraceLoaderFactory();

	/** Loader name constants */
	public static final String LOADER_IN_MEMORY = "In memory trace loader";
	public static final String LOADER_SPLITTED = "Splitted trace loader";

	/**
	 * Map of loader names to their factory suppliers
	 */
	private Map<String, Supplier<TraceLoader>> loaders;

	/**
	 * Private constructor - registers built-in loaders
	 */
	private TraceLoaderFactory() {
		loaders = new LinkedHashMap<>();
		
		// Register built-in trace loaders
		registerLoader(LOADER_IN_MEMORY, InMemoryTraceLoader::new);
		registerLoader(LOADER_SPLITTED, SplittedTraceLoader::new);
		
		Logger.debug("Trace loader factory initialized with %d loaders", loaders.size());
	}

	/**
	 * Register a trace loader
	 * 
	 * @param name the loader name
	 * @param supplier a supplier that creates new loader instances
	 */
	public void registerLoader(String name, Supplier<TraceLoader> supplier) {
		if (name == null) {
			Logger.error("Cannot register trace loader without name");
			return;
		}
		if (loaders.containsKey(name)) {
			Logger.warning("Overwriting existing trace loader named \"%s\"", name);
		}
		loaders.put(name, supplier);
		Logger.debug("Trace loader \"%s\" has been registered", name);
	}

	/**
	 * Get the loader with the given name
	 * 
	 * @param name
	 *            the loader name
	 * @return the loader, <code>null</code> if the loader cannot be found
	 */
	public TraceLoader getLoader(String name) {
		Supplier<TraceLoader> supplier = loaders.get(name);
		if (supplier != null) {
			try {
				return supplier.get();
			} catch (Exception e) {
				Logger.error("Error creating trace loader \"%s\": %s", name, e.getMessage());
			}
		}
		Logger.warning("No trace loader found with name \"%s\"", name);
		return null;
	}

	/**
	 * Get the registered loader names
	 * 
	 * @return the registered loader names
	 */
	public String[] getRegisteredLoaders() {
		return loaders.keySet().toArray(new String[0]);
	}

}

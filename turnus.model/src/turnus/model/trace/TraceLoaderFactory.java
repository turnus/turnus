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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import turnus.common.io.Logger;
import turnus.model.Activator;

/**
 * This class defines the {@link TraceLoader} factory. Loaders registered in the
 * {@code turnus.model.traceLoader} extension point can be accessed by their
 * name using the {@link #getLoader(String)} method
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceLoaderFactory {

	/** the static instance */
	public static final TraceLoaderFactory INSTANCE = new TraceLoaderFactory();

	/**
	 * the private list of loaders. This is a list in order to make the sorting
	 * according to the insertion index
	 */
	private List<String> loaders;

	/**
	 * Private constructor
	 */
	private TraceLoaderFactory() {
		loaders = new ArrayList<>();
		try {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] elements = registry
					.getConfigurationElementsFor(Activator.PLUGIN_ID + ".traceLoader");
			for (IConfigurationElement element : elements) {
				try {
					String name = element.getAttribute("name");
					if (name == null) {
						Logger.error("There is a trace loader without name. It cannot be registered");
					} else if (loaders.contains(name)) {
						Logger.error("There is already a trace loader named \"%s\"", name);
					} else {
						loaders.add(name);
						Logger.debug("Trace loader \"%s\" has been registered", name);
					}
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			Logger.error("Error while initializing the trace loader factory. No loaders can be registered");
		}
	}

	/**
	 * Get the loader with the given name
	 * 
	 * @param name
	 *            the loader name
	 * @return the loader, <code>null</code> if the loader cannot be found
	 */
	public TraceLoader getLoader(String name) {
		try {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] elements = registry
					.getConfigurationElementsFor(Activator.PLUGIN_ID + ".traceLoader");
			for (IConfigurationElement element : elements) {
				try {
					if (name.equals(element.getAttribute("name"))) {
						TraceLoader loader = (TraceLoader) element.createExecutableExtension("class");
						return loader;
					}
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * Get the registered loader names
	 * 
	 * @return the registered loader names
	 */
	public String[] getRegisteredLoaders() {
		return loaders.toArray(new String[0]);
	}

}

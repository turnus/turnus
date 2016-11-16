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
package turnus.ui;

import static turnus.common.TurnusConstants.DEFAULT_MAX_THREADS;
import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusConstants.DEFAULT_QUEUE_SIZE;
import static turnus.common.TurnusConstants.DEFAULT_REMOVE_TEMP_TRACE_FILES;
import static turnus.common.TurnusConstants.DEFAULT_STREAM_BUFFER_SIZE;
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.CONFIG_QUEUES_SIZE;
import static turnus.common.TurnusOptions.CONFIG_REMOVE_TEMP_TRACE_FILES;
import static turnus.common.TurnusOptions.CONFIG_STREAM_BUFFERS_SIZE;
import static turnus.common.TurnusOptions.CONFIG_VERBOSE;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import turnus.common.io.Logger;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The shared instance
	private static Activator plugin;

	// The plug-in ID
	public static final String PLUGIN_ID = "turnus.ui"; //$NON-NLS-1$

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Get the Activator image descriptor
	 * 
	 * @param name
	 *            the image name
	 * @return the image descriptor (i.e. an object that knows how to create an
	 *         SWT image)
	 */
	public static ImageDescriptor getImageDescriptor(String name) {
		return imageDescriptorFromPlugin(PLUGIN_ID, name);
	}

	/**
	 * The constructor
	 */
	public Activator() {
	}

	private void loadRegisteredPreferences() {
		IPreferenceStore store = getDefault().getPreferenceStore();

		if (store.contains(CONFIG_VERBOSE.longName())) {
			boolean verbode = store.getBoolean(CONFIG_VERBOSE.longName());
			Logger.setVerbose(verbode);
		}

		if (store.contains(CONFIG_MAX_THREADS.longName())) {
			DEFAULT_MAX_THREADS = store.getInt(CONFIG_MAX_THREADS.longName());
		}

		if (store.contains(CONFIG_QUEUES_SIZE.longName())) {
			DEFAULT_QUEUE_SIZE = store.getInt(CONFIG_QUEUES_SIZE.longName());
		}

		if (store.contains(CONFIG_STREAM_BUFFERS_SIZE.longName())) {
			DEFAULT_STREAM_BUFFER_SIZE = store.getInt(CONFIG_STREAM_BUFFERS_SIZE.longName());
		}

		if (store.contains(CONFIG_REMOVE_TEMP_TRACE_FILES.longName())) {
			DEFAULT_REMOVE_TEMP_TRACE_FILES = store.getBoolean(CONFIG_REMOVE_TEMP_TRACE_FILES.longName());
		}

	}

	private void registerPropertyChangeListeners() {
		final IPreferenceStore store = getDefault().getPreferenceStore();

		getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {

				String property = event.getProperty();

				if (property.equals(CONFIG_VERBOSE.longName())) {
					Logger.setVerbose(store.getBoolean(property));
				} else if (property.equals(CONFIG_MAX_THREADS.longName())) {
					DEFAULT_MAX_THREADS = store.getInt(property);
				} else if (property.equals(CONFIG_QUEUES_SIZE.longName())) {
					DEFAULT_QUEUE_SIZE = store.getInt(property);
				} else if (property.equals(CONFIG_STREAM_BUFFERS_SIZE.longName())) {
					DEFAULT_STREAM_BUFFER_SIZE = store.getInt(property);
				} else if (property.equals(CONFIG_REMOVE_TEMP_TRACE_FILES.longName())) {
					DEFAULT_REMOVE_TEMP_TRACE_FILES = store.getBoolean(property);
				} else if (property.equals(CONFIG_MINIMIZE_MEMORY_USAGE.longName())) {
					DEFAULT_MINIMIZE_MEMORY_USAGE = store.getBoolean(property);
				}
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		registerPropertyChangeListeners();
		loadRegisteredPreferences();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}

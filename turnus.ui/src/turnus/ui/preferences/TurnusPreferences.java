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
package turnus.ui.preferences;

import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.CONFIG_QUEUES_SIZE;
import static turnus.common.TurnusOptions.CONFIG_REMOVE_TEMP_TRACE_FILES;
import static turnus.common.TurnusOptions.CONFIG_STREAM_BUFFERS_SIZE;
import static turnus.common.TurnusOptions.CONFIG_VERBOSE;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import turnus.ui.Activator;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class TurnusPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public TurnusPreferences() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("The TURNUS advanced options that are used by all the analysies");
	}

	@Override
	protected void createFieldEditors() {

		Composite composite = getFieldEditorParent();

		// set the maximum number of threads
		IntegerFieldEditor maxThreads = new IntegerFieldEditor(CONFIG_MAX_THREADS.longName(),
				"Maximum number of threads", composite);
		maxThreads.setValidRange(1, 10 * Runtime.getRuntime().availableProcessors());
		addField(maxThreads);

		IntegerFieldEditor maxStreamBufferSize = new IntegerFieldEditor(CONFIG_STREAM_BUFFERS_SIZE.longName(),
				"Input/output stream buffer size", composite);
		maxStreamBufferSize.setValidRange(100, Integer.MAX_VALUE);
		addField(maxStreamBufferSize);

		IntegerFieldEditor maxQueueSize = new IntegerFieldEditor(CONFIG_QUEUES_SIZE.longName(),
				"The queue size used by parallel threads or processes", composite);
		maxQueueSize.setValidRange(100, Integer.MAX_VALUE);
		addField(maxQueueSize);

		addField(new BooleanFieldEditor(CONFIG_MINIMIZE_MEMORY_USAGE.longName(),
				"Minimize the memory usage required by the analysies (some analysies could be slower)", composite));

		addField(new BooleanFieldEditor(CONFIG_REMOVE_TEMP_TRACE_FILES.longName(),
				"Remove all the temporary trace file before loading again the same trace", composite));

		addField(new BooleanFieldEditor(CONFIG_VERBOSE.longName(), "Debug mode", composite));

	}

}

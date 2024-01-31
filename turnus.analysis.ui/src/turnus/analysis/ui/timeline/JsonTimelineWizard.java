/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2024 Endri Bezati
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
package turnus.analysis.ui.timeline;

import static turnus.common.TurnusExtensions.BUFFER_SIZE;
import static turnus.common.TurnusExtensions.NETWORK_PARTITIONING;
import static turnus.common.TurnusExtensions.NETWORK_WEIGHT;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.TRACE_FILE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import turnus.analysis.timeline.TimelineCli;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCheckBox;
import turnus.ui.widget.WidgetSelectFileCombo;
import turnus.ui.wizard.AbstractWizardPage;

/**
 * Json Timeline menu UI Wizard
 * 
 * @author Endri Bezati
 *
 */
public class JsonTimelineWizard extends Wizard implements IWorkbenchWizard {

	
	
	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author Endri Bezati
	 *
	 */
	private class OptionsPage extends AbstractWizardPage {

		private WidgetSelectFileCombo wTraceFile;
		private WidgetSelectFileCombo wWeightsFile;
		private WidgetSelectFileCombo wMappingFile;
		private WidgetSelectFileCombo wBufferSizeFile;
		private WidgetCheckBox wRealeaseAfterProcessing;

		private OptionsPage() {
			super("Inter-Partition communciation and memory analysis");
			setTitle("Inter-Partition communciation and memory analysis");
			setDescription("Select the options and run the analysis");
		}

		@Override
		protected void createWidgets(Composite container) {
			IProject project = EclipseUtils.getCurrentProject();

			// -- Trace File
			String[] traceExtensions = { TRACE, TRACEZ };
			List<String> initialTraceFiles = new ArrayList<>();
			if (project != null && project.isOpen()) {
				initialTraceFiles = EclipseUtils.getPathsFromContainer(project, traceExtensions);
			}

			wTraceFile = new WidgetSelectFileCombo("Trace", "Trace file", traceExtensions, null, container);
			if (!initialTraceFiles.isEmpty())
				wTraceFile.setChoices(initialTraceFiles.toArray(new String[0]));
			addWidget(wTraceFile);

			// -- Network weight file
			String[] weightsExtension = { NETWORK_WEIGHT };
			List<String> initialExdfFiles = new ArrayList<>();
			if (project != null && project.isOpen()) {
				initialExdfFiles = EclipseUtils.getPathsFromContainer(project, weightsExtension);
			}
			wWeightsFile = new WidgetSelectFileCombo("Weights", "The network weight file", weightsExtension, null,
					container);
			if (!initialExdfFiles.isEmpty())
				wWeightsFile.setChoices(initialExdfFiles.toArray(new String[0]));
			addWidget(wWeightsFile);

			// -- Network partition file
			String[] mappingExtension = { NETWORK_PARTITIONING };
			List<String> initialXcffFiles = new ArrayList<>();
			if (project != null && project.isOpen()) {
				initialXcffFiles = EclipseUtils.getPathsFromContainer(project, mappingExtension);
			}

			wMappingFile = new WidgetSelectFileCombo("Mapping configuration", "Mapping configuration file",
					mappingExtension, null, container);
			if (!initialXcffFiles.isEmpty())
				wMappingFile.setChoices(initialXcffFiles.toArray(new String[0]));
			addWidget(wMappingFile);

			// -- Buffer File
			String[] bufferExtension = { BUFFER_SIZE };
			List<String> initialBxdffFiles = new ArrayList<>();
			if (project != null && project.isOpen()) {
				initialBxdffFiles = EclipseUtils.getPathsFromContainer(project, bufferExtension);
			}
			wBufferSizeFile = new WidgetSelectFileCombo("Buffer-size configuration", "Buffer-size configuration file",
					bufferExtension, null, container);
			if (!initialBxdffFiles.isEmpty())
				wBufferSizeFile.setChoices(initialBxdffFiles.toArray(new String[0]));
			addWidget(wBufferSizeFile);

			
			wRealeaseAfterProcessing = new WidgetCheckBox("Release buffers after processing",
					"Release buffers after processing", true, container);
			addWidget(wRealeaseAfterProcessing);
		}

		public File getMappingFile() {
			return wMappingFile.getValue();
		}

		public File getTraceFile() {
			return wTraceFile.getValue();
		}

		public File getWeightsFile() {
			return wWeightsFile.getValue();
		}

		public File getBufferSizeFile() {
			return wBufferSizeFile.getValue();
		}
		
		public boolean getRealeaseAfterProcessing() {
			return wRealeaseAfterProcessing.getValue();
		}

		

	}

	private OptionsPage optionsPage;
	
	public JsonTimelineWizard() {
		super();
		optionsPage = new OptionsPage();
		setNeedsProgressMonitor(true);
		EclipseUtils.openDefaultConsole();
	}
	
	
	@Override
	public void addPages() {
		addPage(optionsPage);
	}
	
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		final Configuration configuration = new Configuration();
		configuration.setValue(TRACE_FILE, optionsPage.getTraceFile());
		configuration.setValue(ACTION_WEIGHTS, optionsPage.getWeightsFile());
		configuration.setValue(MAPPING_FILE, optionsPage.getMappingFile());
		configuration.setValue(BUFFER_SIZE_FILE, optionsPage.getBufferSizeFile());
		configuration.setValue(RELEASE_BUFFERS_AFTER_PROCESSING, optionsPage.getRealeaseAfterProcessing());

		final Job job = new Job("Inter partition communication and memory analysis") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new TimelineCli().start(configuration, monitor);
					EclipseUtils.refreshWorkspace(monitor);
				}catch (Exception e) {
					Logger.error(e.getMessage());
				}
				return Status.OK_STATUS;
			}
		};
		
		
		job.setUser(true);
		job.schedule();

		return true;
	}

}

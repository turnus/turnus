package turnus.analysis.ui.communication;

import static turnus.common.TurnusExtensions.NETWORK_PARTITIONING;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusOptions.BANDWIDTH;
import static turnus.common.TurnusOptions.FIXED_OVERHEAD_LATENCY;
import static turnus.common.TurnusOptions.MAPPING_AS_ANALYSIS_NAME;
import static turnus.common.TurnusOptions.MAPPING_FILE;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import it.unimi.dsi.fastutil.doubles.DoubleSemiIndirectHeaps;
import turnus.analysis.communication.LinearCommunicationWeightCli;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCheckBox;
import turnus.ui.widget.WidgetSelectFileCombo;
import turnus.ui.widget.WidgetText;
import turnus.ui.wizard.AbstractWizardPage;

public class LinearCommunicationWeightWizard extends Wizard implements IWorkbenchWizard {

	private class ToggleListener implements ModifyListener {
		final private WidgetText text;
		final private Composite parent;

		public ToggleListener(WidgetText widget, Composite parent) {
			this.text = widget;
			this.parent = parent;
			disable();
		}

		public void enable() {
			this.text.setEnabled(true);
			this.text.setVisible(true);
			parent.layout(); // recompute the layout
		}

		public void disable() {
			this.text.setEnabled(false);
			this.text.setVisible(false);
			parent.layout(); // recompute the layout
		}

		void toggle() {
			if (text.isEnabled()) {
				disable();
			} else {
				enable();
			}
		}

		@Override
		public void modifyText(ModifyEvent e) {
			toggle();
		}

	}

	private class OptionsPage extends AbstractWizardPage {

		private WidgetSelectFileCombo wTraceFile;
		private WidgetSelectFileCombo wMappingFile;
		private WidgetCheckBox wSetLatency;
		private WidgetText wLatency;
		private WidgetText wBandwidth;
		private WidgetCheckBox wSameNameAsMapping;

		protected OptionsPage() {
			super("Dynamic Round Robin Partitioning");
			setTitle("Dynamic Round Robin Partitioning");
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


			// -- Latency
			wSetLatency = new WidgetCheckBox("Set fixed overhead latency", "Set fixed overhead latency", false,
					container);
			addWidget(wSetLatency);
			wLatency = new WidgetText("Latency", "Fixed overhead latency", "", container);
			wSetLatency.addModifyListener(new ToggleListener(wLatency, container));
			addWidget(wLatency);

			// -- Bandwidth
			wBandwidth = new WidgetText("Bandwidth", "Bandwidth", "", container);
			addWidget(wBandwidth);

			wSameNameAsMapping = new WidgetCheckBox("Use the same name for the report as the mapping file",
					"Use the same name for the report as the mapping file", false, container);
			addWidget(wSameNameAsMapping);

		}

		public File getMappingFile() {
			return wMappingFile.getValue();
		}

		public File getTraceFile() {
			return wTraceFile.getValue();
		}

		public String getLatency() {
			if (!wSetLatency.getValue())
				return "0.0";
			return wLatency.getValue();
		}

		public String getBandwidth() {
			return wBandwidth.getValue();
		}

		public boolean getSameNameAsMapping() {
			return wSameNameAsMapping.getValue();
		}

	}

	private OptionsPage optionsPage;

	public LinearCommunicationWeightWizard() {
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
		configuration.setValue(MAPPING_FILE, optionsPage.getMappingFile());
		configuration.setValue(MAPPING_AS_ANALYSIS_NAME, optionsPage.getSameNameAsMapping());
		configuration.setValue(BANDWIDTH, Double.valueOf(optionsPage.getBandwidth()));
		configuration.setValue(FIXED_OVERHEAD_LATENCY, Double.valueOf(optionsPage.getLatency()));
		
		final Job job = new Job("Inter partition communication and memory analysis") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new LinearCommunicationWeightCli().start(configuration, monitor);
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

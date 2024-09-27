package turnus.analysis.ui.partitioning;

import static turnus.common.TurnusExtensions.BUFFER_SIZE;
import static turnus.common.TurnusExtensions.NETWORK_WEIGHT;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_NAME;
import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
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

import turnus.analysis.partitioning.DynamicRRPartitioningCli;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCheckBox;
import turnus.ui.widget.WidgetSelectFileCombo;
import turnus.ui.widget.WidgetSpinnerInteger;
import turnus.ui.widget.WidgetText;
import turnus.ui.wizard.AbstractWizardPage;

/**
 * UI Wizard for the Dynamic Round Robin Partitioning
 * 
 * @author Endri Bezati
 */
public class DynamicRoundRobinPartitioningWizard extends Wizard implements IWorkbenchWizard {

	private class ToggleListener implements ModifyListener {
		final private WidgetText text;

		public ToggleListener(WidgetText widget) {
			this.text = widget;
			disable();
		}

		public void enable() {
			this.text.setEnabled(true);
			this.text.setVisible(true);
		}

		public void disable() {
			this.text.setEnabled(false);
			this.text.setVisible(false);
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
		private WidgetSelectFileCombo wWeightsFile;
		private WidgetSelectFileCombo wBufferSizeFile;
		private WidgetSpinnerInteger wUnits;
		private WidgetCheckBox wUseName;
		private WidgetText wName;

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

			// -- Units
			wUnits = new WidgetSpinnerInteger("Units", "Select the number of available units", 1, Integer.MAX_VALUE, 1,
					2, container);
			addWidget(wUnits);

			// -- Name
			wUseName = new WidgetCheckBox("Specify a name for this analysis", "Specify a name", false, container);
			addWidget(wUseName);
			wName = new WidgetText("Name", "Specify a name for this analysis", "", container);

			wUseName.addModifyListener(new ToggleListener(wName));

			addWidget(wName);

		}

		public File getWeightsFile() {
			return wWeightsFile.getValue();
		}

		public File getBufferSizeFile() {
			return wBufferSizeFile.getValue();
		}

		public File getTraceFile() {
			return wTraceFile.getValue();
		}

		public int getUnits() {
			return wUnits.getValue().intValue();
		}

		public String getName() {
			if (!wUseName.getValue())
				return "";
			return wName.getValue();
		}

	}

	private OptionsPage optionsPage;

	public DynamicRoundRobinPartitioningWizard() {
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
		configuration.setValue(BUFFER_SIZE_FILE, optionsPage.getBufferSizeFile());
		configuration.setValue(ANALYSIS_PARTITIONING_UNITS, optionsPage.getUnits());
		configuration.setValue(ANALYSIS_NAME, optionsPage.getName());

		final Job job = new Job("Dynamic Round Robin Partitioning") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new DynamicRRPartitioningCli().start(configuration, monitor);
					EclipseUtils.refreshWorkspace(monitor);
				} catch (Exception e) {
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

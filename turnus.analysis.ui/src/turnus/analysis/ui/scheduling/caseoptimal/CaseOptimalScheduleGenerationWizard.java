package turnus.analysis.ui.scheduling.caseoptimal;

import static turnus.common.TurnusExtensions.ACTOR_SELECTION_SCHEDULE;
import static turnus.common.TurnusExtensions.MAPPING;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.SCHEDULE_OPTIMISATION_PIPELINE_STRING;
import static turnus.common.TurnusOptions.TRACE_FILE;

import java.io.File;

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

import turnus.analysis.scheduling.caseoptimal.CaseOptimalActorSelectionAnalysisCli;

import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCheckBox;
import turnus.ui.widget.WidgetSelectFile;
import turnus.ui.widget.WidgetSelectPath;
import turnus.ui.widget.WidgetText;
import turnus.ui.wizard.AbstractWizardPage;

public class CaseOptimalScheduleGenerationWizard extends Wizard implements IWorkbenchWizard  {

	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class OptionsPage extends AbstractWizardPage {

		private WidgetSelectFile wTraceFile;
		private WidgetSelectPath wOutPath;
		private WidgetSelectFile wMapFile;
		private WidgetText wPipeline;
		private WidgetCheckBox wUseMapping;

		private OptionsPage() {
			super("Case optimal schedule generation");
			setTitle("Case optimal schedule generation");
			setDescription("Select the options and run the analysis");
		}
		private class ToggleListener implements ModifyListener{
			final private WidgetSelectFile fileSelector;
			public ToggleListener(WidgetSelectFile mapFile) {
				this.fileSelector=mapFile;
				disable();
			}
			public void enable(){
				this.fileSelector.setEnabled(true);
				this.fileSelector.setVisible(true);
			}

			public void disable(){
				this.fileSelector.setEnabled(false);
				this.fileSelector.setVisible(false);
			}
			void toggle(){
				if(fileSelector.isEnabled()){
					disable();
				}else{
					enable();
				}
			}
			@Override
			public void modifyText(ModifyEvent e) {
				toggle();
			}
			
		}
		@Override
		protected void createWidgets(Composite container) {

			String[] allowedExtensions= { TRACE, TRACEZ,ACTOR_SELECTION_SCHEDULE };
			File HACK_defaultfile_DEBUG=new File("/home/nada/Dokumente/turnus/orc-apps/HelloWorld/turnus/profiling_dynamic_analysis/Example/20170411112253/Example.tracez");
			wTraceFile = new WidgetSelectFile("Trace/Schedule", "Trace or Schedule file", allowedExtensions, HACK_defaultfile_DEBUG, container);
			addWidget(wTraceFile);
			
			
			wPipeline = new WidgetText(SCHEDULE_OPTIMISATION_PIPELINE_STRING, "RLE,KTAIL", container);
			addWidget(wPipeline);
			String[] mapExtensions={MAPPING};
			
			wMapFile = new WidgetSelectFile("Mapping", "Mapping file", mapExtensions,null,container);
			
			wUseMapping=new WidgetCheckBox("Use partioning","", false, container);
			addWidget(wUseMapping);
			wUseMapping.addModifyListener(new ToggleListener(wMapFile));
			
			addWidget(wMapFile);
			
			// final Boolean forceEmpty=false;
			// File defaultPath = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
			// wOutPath= new WidgetSelectPath("test","tooltop",forceEmpty,defaultPath,container);
			// FIXME see how to set outputconfiguration addWidget(wOutPath);
		}

		public File getTraceFile() {
			return wTraceFile.getValue();
		}
		public String getPipeline(){
			String pipelineString=wPipeline.getValue();
		
			return pipelineString;
		}

		public Object getMappingFile() {
			return wMapFile.getValue();
		}

	}

	private OptionsPage optionsPage;

	public CaseOptimalScheduleGenerationWizard() {
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
		configuration.setValue(MAPPING_FILE,optionsPage.getMappingFile());
		String pipelineString = optionsPage.getPipeline();
		configuration.setValue(SCHEDULE_OPTIMISATION_PIPELINE_STRING, pipelineString);

		final Job job = new Job("Case optimal schedule generation") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new CaseOptimalActorSelectionAnalysisCli().start(configuration, monitor);
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

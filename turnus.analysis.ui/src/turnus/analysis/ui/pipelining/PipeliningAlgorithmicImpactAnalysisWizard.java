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
package turnus.analysis.ui.pipelining;

import static turnus.common.TurnusExtensions.NETWORK_WEIGHT;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import turnus.analysis.pipelining.PipeliningAlgorithmicImpactAnalysisCli;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetSelectFile;
import turnus.ui.widget.WidgetSpinnerInteger;
import turnus.ui.wizard.AbstractWizardPage;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class PipeliningAlgorithmicImpactAnalysisWizard extends Wizard implements IWorkbenchWizard {

	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class OptionsPage extends AbstractWizardPage {

		private WidgetSelectFile wTraceFile;
		private WidgetSelectFile wWeightsFile;
		private WidgetSpinnerInteger wActions;

		private OptionsPage() {
			super("Pipelining algorithmic impact analysis");
			setTitle("Pipelining algorithmic impact analysis");
			setDescription("Select the options and run the analysis");
		}

		@Override
		protected void createWidgets(Composite container) {

			String[] traceExtensions = { TRACE, TRACEZ };
			wTraceFile = new WidgetSelectFile("Trace", "Trace file", traceExtensions, null, container);
			addWidget(wTraceFile);

			String[] weightsExtension = { NETWORK_WEIGHT };
			wWeightsFile = new WidgetSelectFile("Weights", "The network weight file", weightsExtension, null,
					container);
			addWidget(wWeightsFile);

			wActions = new WidgetSpinnerInteger("Critical actions",
					"The maximal number of pipelinable and critical actions to be analysed", 1, 400, 1, 4, container);
			addWidget(wActions);

		}

		public File getTraceFile() {
			return wTraceFile.getValue();
		}

		public File getWeightsFile() {
			return wWeightsFile.getValue();
		}

		public int getActions() {
			return wActions.getValue().intValue();
		}

	}

	private OptionsPage optionsPage;

	public PipeliningAlgorithmicImpactAnalysisWizard() {
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
		configuration.setValue(ANALYSIS_IMPACT_MAX_ACTIONS, optionsPage.getActions());

		final Job job = new Job("Pipelining algorithmic impact analysis") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new PipeliningAlgorithmicImpactAnalysisCli().start(configuration, monitor);
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
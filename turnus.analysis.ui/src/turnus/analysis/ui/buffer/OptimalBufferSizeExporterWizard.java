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
package turnus.analysis.ui.buffer;

import static turnus.common.TurnusExtensions.BUFFER_SIZE;
import static turnus.common.TurnusExtensions.OPTIMAL_BUFFER_REPORT;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.buffers.OptimalBuffersReport;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.io.XmlBufferSizeWriter;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetComboBox;
import turnus.ui.widget.WidgetCreateFile;
import turnus.ui.widget.WidgetSelectFile;
import turnus.ui.wizard.AbstractWizardPage;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class OptimalBufferSizeExporterWizard extends Wizard implements IWorkbenchWizard {

	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class FilesPage extends AbstractWizardPage {

		private WidgetSelectFile wInputFile;
		private WidgetCreateFile wOutputFile;
		private WidgetComboBox wConfiguration;

		private FilesPage() {
			super("Optimal Buffer size configurations exporter");
			setTitle("Optimal Buffer size configurations exporter");
			setDescription("Export a buffer size configuration");
		}

		@Override
		protected void createWidgets(Composite container) {

			String[] inputs = { OPTIMAL_BUFFER_REPORT };
			wInputFile = new WidgetSelectFile("File", "Input file to be exported", inputs, inputFile, container);
			addWidget(wInputFile);

			String[] output = { BUFFER_SIZE };
			wOutputFile = new WidgetCreateFile("Output", "Output file", output, null, container);
			addWidget(wOutputFile);

			String[] choices = getChoices(inputFile);
			wConfiguration = new WidgetComboBox("Configuration", "select the configuration", choices, choices[0],
					container);
			addWidget(wConfiguration);

			wInputFile.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent e) {
					String[] choices = getChoices(wInputFile.getValue());
					wConfiguration.setChoices(choices);
				}
			});

		}

		private String[] getChoices(File input) {
			try {
				OptimalBuffersReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), inputFile);
				int size = report.getBuffersData().size();
				String[] array = new String[size + 1];
				array[0] = "Nominal";
				for (int i = 1; i <= size; i++) {
					array[i] = "Configuration " + i;
				}
				return array;
			} catch (Exception e) {
				String[] array = { "" };
				return array;
			}
		}

		/**
		 * Get the input file
		 * 
		 * @return
		 */
		public File getInput() {
			return wInputFile.getValue();
		}

		/**
		 * Get the output file
		 * 
		 * @return
		 */
		public File getOutput() {
			return wOutputFile.getValue();
		}

		public String getConfigurationName() {
			return wConfiguration.getValue();
		}

	}

	private FilesPage filesPage;
	private File inputFile;

	public OptimalBufferSizeExporterWizard() {
		super();

		filesPage = new FilesPage();
		setNeedsProgressMonitor(true);
		EclipseUtils.openDefaultConsole();
	}

	@Override
	public void addPages() {
		addPage(filesPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IFile) {
			try {
				configure(FileUtils.getFile((IFile) selection.getFirstElement()));
			} catch (Exception e) {
			}
		}
	}

	@Override
	public boolean performFinish() {
		try {
			File inputFile = filesPage.getInput();
			File outputFile = filesPage.getOutput();

			String configuration = filesPage.getConfigurationName();
			int idx = -1;
			if (configuration != null) {
				if (configuration.equals("Nominal")) {
					idx = 0;
				} else {
					idx = Integer.parseInt(configuration.replaceFirst("Configuration ", ""));
				}

				if (idx == -1) {
					throw new TurnusException("Configuration name is not valid");
				}
			}

			OptimalBuffersReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), inputFile);
			BufferSize bufferSize = null;
			if (idx == 0) {
				bufferSize = report.getInitialBufferConfiguration().asBufferSize();
			} else {
				bufferSize = report.getBuffersData().get(idx - 1).getBufferData().asBufferSize();
			}

			new XmlBufferSizeWriter().write(bufferSize, outputFile);
			Logger.info("Buffer size \"%s\" exported to %s", configuration, outputFile);

			return true;
		} catch (Exception e) {
			Logger.error("Buffer size configuration cannot be exported. Error: \"%s\"", e.getMessage());
		}

		return false;
	}

	public void configure(File inputFile) {
		this.inputFile = null;
		try {
			String extension = FileUtils.getExtension(inputFile);
			if (OPTIMAL_BUFFER_REPORT.equals(extension)) {
				this.inputFile = inputFile;
			}
		} catch (Exception e) {
		}

	}

}

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
package turnus.ui.wizard;

import java.io.File;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.FileExporterFactory;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCreateFile;
import turnus.ui.widget.WidgetSelectFile;

/**
 * This class defines an abstract File exporter wizard. The superclass should
 * provide the output file extension. Input file extensions are handled by the
 * {@link FileExporterFactory}
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class AbstractFileExporterWizard extends Wizard implements IWorkbenchWizard {

	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class FilesPage extends AbstractWizardPage {

		private WidgetSelectFile wInputFile;
		private WidgetCreateFile wOutputFile;

		private FilesPage() {
			super("File exporter");
			setTitle("\"" + outputExtension.toUpperCase() + "\" file exporter");
			setDescription("Export a TURNUS report file in an \"" + outputExtension + "\" file");
		}

		@Override
		protected void createWidgets(Composite container) {
			String[] inputs = inputExtensions.toArray(new String[0]);
			String[] output = { outputExtension };

			wInputFile = new WidgetSelectFile("File", "Input file to be exported", inputs, inputFile, container);
			addWidget(wInputFile);

			wOutputFile = new WidgetCreateFile("Output", "Output file", output, null, container);
			addWidget(wOutputFile);

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

	}

	/** the file output extension */
	private String outputExtension;
	/**
	 * the file input extensions (provided by the {@link FileExporterFactory})
	 */
	private Set<String> inputExtensions;

	/**
	 * Create a new abstract file exporter wizard
	 * 
	 * @param outputExtension
	 *            the output file extension
	 */
	public AbstractFileExporterWizard(String outputExtension) {
		super();

		this.outputExtension = outputExtension;
		this.inputExtensions = FileExporterFactory.INSTANCE.getSupportedInputs(outputExtension);

		filesPage = new FilesPage();

		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IFile) {
			try {
				configure(FileUtils.getFile((IFile) selection.getFirstElement()));
			} catch (TurnusException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean performFinish() {
		try {
			EclipseUtils.openDefaultConsole();

			File inputFile = filesPage.getInput();
			File outputFile = filesPage.getOutput();

			String inputExt = FileUtils.getExtension(inputFile);
			String outExt = FileUtils.getExtension(outputFile);
			FileExporter<?> exporter = FileExporterFactory.INSTANCE.getExporter(inputExt, outExt);
			exporter.export(inputFile, outputFile);

			Logger.info("File exported in \"%s\"", outputFile);
			EclipseUtils.refreshWorkspace(new NullProgressMonitor());
			return true;
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}

		return true;
	}

	private final FilesPage filesPage;
	private File inputFile;

	@Override
	public void addPages() {
		addPage(filesPage);
	}

	public void configure(File inputFile) {
		this.inputFile = null;
		try {
			String extension = FileUtils.getExtension(inputFile);
			if (inputExtensions.contains(extension)) {
				this.inputFile = inputFile;
			}
		} catch (Exception e) {
		}

	}

}

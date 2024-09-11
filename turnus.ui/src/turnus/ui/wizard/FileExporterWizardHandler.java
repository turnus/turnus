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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import turnus.common.TurnusException;
import turnus.common.util.FileUtils;
import turnus.ui.TurnusUiConstants;
import turnus.ui.wizard.impl.GraphmlFileExporterWizard;
import turnus.ui.wizard.impl.HtmlFileExporterWizard;
import turnus.ui.wizard.impl.XlsFileExporterWizard;

/**
 * This class implements an {@link IHandler2} for selecting the file exporter
 * wizard according to the selected output file format. This handler is used by
 * the command {@code turnus.ui.command.fileExporter} which is an extension
 * point of an {@code org.eclipse.ui.command}. The command parameter is a
 * "turnus.ui.command.fileExporter.outExtension" which contains the file
 * extension of the output file. Supported output file wizard are:
 * <li>XLS: implemented by the {@link XlsFileExporterWizard}</li>
 * 
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class FileExporterWizardHandler extends AbstractHandler {

	/**
	 * Create a new FileExporterWizardHandler
	 */
	public FileExporterWizardHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set structured selection
		IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();

		File inputFile = null;
		// check if it is an IFile

		try {
			if (selection.getFirstElement() instanceof IFile) {
				inputFile = FileUtils.getFile((IFile) selection.getFirstElement());
			}
		} catch (TurnusException | NullPointerException e) {
			e.printStackTrace();
		}

		// get only the required extension
		String outExtension = event.getParameter(TurnusUiConstants.COMMAND_OUT_EXTENSION);

		AbstractFileExporterWizard wizard = null;

		switch (outExtension) {
		// according to the output file extension, select the right wizard
		case "xlsx":
			wizard = new XlsFileExporterWizard();
			break;
		case "graphml":
			wizard = new GraphmlFileExporterWizard();
			break;
		case "html":
			wizard = new HtmlFileExporterWizard();
			break;

		default:
			break;
		}

		if (wizard != null) {
			wizard.configure(inputFile);
			new WizardDialog(window.getShell(), wizard).open();
		}
		return null;
	}

}

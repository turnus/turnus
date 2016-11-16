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
package turnus.ui.editor.architecture;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import turnus.common.TurnusExtensions;
import turnus.model.ModelsUtils;
import turnus.model.architecture.Architecture;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureBuilderWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;

	private final boolean openWhenFinished;

	private Architecture architecture;

	public ArchitectureBuilderWizard() {
		this(true);
	}

	public ArchitectureBuilderWizard(boolean openWhenFinished) {
		super();
		setWindowTitle("New XAF Architecture");

		this.openWhenFinished = openWhenFinished;
		architecture = null;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		this.workbench = workbench;

		final WizardNewFileCreationPage page = new WizardNewFileCreationPage("filenameSelection", selection) {
			@Override
			protected boolean validatePage() {
				if (!super.validatePage()) {
					return false;
				}

				final IPath path = this.getContainerFullPath();
				final IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
				if (member instanceof IProject) {
					setMessage("The architecture can't be created directly " + "in a project. Please select a folder.",
							DialogPage.ERROR);
					return false;
				}

				return true;
			}

			// We don't want "Advanced" section to be displayed.
			@Override
			protected void createAdvancedControls(Composite parent) {
				// Does nothing, DO NOT REMOVE. Overwrites link related stuff
			}

			@Override
			protected IStatus validateLinkedResource() {
				// Does nothing, DO NOT REMOVE. Overwrites link related stuff
				return Status.OK_STATUS;
			}

			@Override
			protected void createLinkTarget() {
				// Does nothing, DO NOT REMOVE. Overwrites link related stuff
			}
		};
		page.setFileExtension(TurnusExtensions.ARCHITECTURE);
		page.setDescription("Select a parent folder and a name for the new architecture.");
		page.setAllowExistingResources(false);

		// Fill the page with a filename, if user selected one
		if (!selection.isEmpty()) {
			final Object firstSel = selection.getFirstElement();
			if (firstSel instanceof IFile) {
				final IFile selectedFile = (IFile) firstSel;
				final String fileName = selectedFile.getName();
				final String ext = selectedFile.getFileExtension();
				if (ext == null || ext.isEmpty()) {
					page.setFileName(fileName);
				} else {
					int idx = fileName.indexOf(ext);
					if (idx > 0) {
						page.setFileName(fileName.substring(0, idx - 1));
					}
				}
			}
		}

		addPage(page);
	}

	@Override
	public boolean performFinish() {
		final WizardNewFileCreationPage page = (WizardNewFileCreationPage) getPage("filenameSelection");

		final IFile file = page.createNewFile();
		if (file == null) {
			return false;
		}

		final URI xafUri = URI.createPlatformResourceURI(file.getFullPath()
				.toString(), true);

		try {
			architecture = ModelsUtils.createArchitectureResource(xafUri);
		} catch (IOException e) {
			return false;
		}

		// Open editor on new file.
		if (openWhenFinished) {
			final IWorkbenchWindow dw = workbench.getActiveWorkbenchWindow();
			try {
				if (dw != null) {
					BasicNewResourceWizard.selectAndReveal(file, dw);
					final IWorkbenchPage activePage = dw.getActivePage();
					if (activePage != null) {
						IDE.openEditor(activePage, file, true);
					}
				}
			} catch (PartInitException e) {
				MessageDialog.openError(dw.getShell(),
						"Problem opening editor", e.getMessage());
				return false;
			}
		}
		return true;
	}

	public Architecture getCreatedArchitecture() {
		return architecture;
	}

}

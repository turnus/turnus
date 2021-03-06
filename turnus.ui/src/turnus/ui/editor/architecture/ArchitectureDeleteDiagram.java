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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import turnus.common.TurnusExtensions;
import turnus.ui.editor.architecture.util.ArchitectureUtils;
import turnus.ui.util.EclipseUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureDeleteDiagram extends AbstractHandler {

	public ArchitectureDeleteDiagram() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set structured selection
		IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();

		// check if it is an IFile
		if (selection.getFirstElement() instanceof IFile) {
			try {
				IFile file = (IFile) selection.getFirstElement();
				if (TurnusExtensions.ARCHITECTURE.equals(file.getFileExtension())) {
					IFile diagFile = ArchitectureUtils.getDiagramFile(file);
					if (diagFile.exists()) {
						diagFile.delete(true, new NullProgressMonitor());
						EclipseUtils.refreshWorkspace(new NullProgressMonitor());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}

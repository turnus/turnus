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
package turnus.ui.editor.architecture.behavior;

import static turnus.ui.editor.architecture.util.ArchitectureUtils.getArchitectureFile;
import static turnus.ui.editor.architecture.util.ArchitectureUtils.getDiagramFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;

import turnus.common.TurnusExtensions;
import turnus.ui.TurnusUiConstants;
import turnus.ui.editor.architecture.ArchitectureDiagramEditor;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class UpdateBehavior extends DefaultUpdateBehavior {

	public UpdateBehavior(ArchitectureDiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}

	protected boolean handleDirtyConflict() {
		return true;
	}

	public boolean isResourceDeleted() {

		DiagramEditorInput diagramEditorInput = ((ArchitectureDiagramEditor) diagramBehavior.getDiagramContainer())
				.getDiagramEditorInput();
		IFile file = (IFile) diagramEditorInput.getAdapter(IFile.class);
		if (file == null) {
			return true;
		} else if (!file.exists()) {
			return true;
		} else if (TurnusUiConstants.ARCHITECTURE_DIAGRAM_SUFFIX.equals(file.getFileExtension())) {
			IFile archFile = getArchitectureFile(file);
			if (archFile == null || !archFile.exists()) {
				return true;
			}
		} else if (TurnusExtensions.ARCHITECTURE.equals(file.getFileExtension())) {
			IFile diagFile = getDiagramFile(file);
			if (diagFile == null || !diagFile.exists()) {
				return true;
			}
		}

		return super.isResourceDeleted();
	}

}

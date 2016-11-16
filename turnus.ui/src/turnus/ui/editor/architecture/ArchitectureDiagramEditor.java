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

import static turnus.ui.editor.architecture.util.ArchitectureUtils.getDiagramUri;

import java.io.IOException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;

import turnus.common.TurnusExtensions;
import turnus.common.io.Logger;
import turnus.ui.Icon;
import turnus.ui.TurnusUiConstants;
import turnus.ui.editor.architecture.behavior.ArchitectureDiagramBehavior;
import turnus.ui.util.EclipseUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureDiagramEditor extends DiagramEditor {

	private final ArchitectureDiagramBehavior diagramBehavior;

	public ArchitectureDiagramEditor() {
		super();
		diagramBehavior = new ArchitectureDiagramBehavior(this);
	}

	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return diagramBehavior;
	}

	@Override
	protected DiagramEditorInput convertToDiagramEditorInput(IEditorInput input) throws PartInitException {
		final DiagramEditorInput origEditorInput = super.convertToDiagramEditorInput(input);
		return new ArchitectureEditorInput(origEditorInput.getUri(), origEditorInput.getProviderId());
	}
	
	public DiagramEditorInput getDiagramEditorInput(){
		return (DiagramEditorInput) super.getDiagramEditorInput();
	}

	@Override
	protected void setInput(IEditorInput input) {

		if (input instanceof DiagramEditorInput) {
			final DiagramEditorInput diagramEditorInput = (DiagramEditorInput) input;

			// The input is an architecture file resource
			if (TurnusExtensions.ARCHITECTURE.equals(diagramEditorInput.getUri().fileExtension())) {
				final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

				final URI xafUri = diagramEditorInput.getUri();
				final URI diagramUri = getDiagramUri(xafUri);

				final IPath diagramPath = new Path(diagramUri.toPlatformString(true));

				// The diagram associated with the Xdf doesn't exists
				if (!workspaceRoot.exists(diagramPath)) {
					try {
						// Create it (empty). Its content will be updated in
						// UpdateDiagramFeature
						EclipseUtils.createDiagramResource(TurnusUiConstants.ARCHITECTURE_DIAGRAM_TYPE, diagramUri);
					} catch (IOException e) {
						Logger.error("Unable to create a diagram resource from the architecture file.");
					}
				}

				diagramEditorInput.updateUri(diagramUri);
				super.setInput(diagramEditorInput);
				return;
			}
		}

		super.setInput(input);
	}

	@Override
	public Image getTitleImage() {
		return Icon.getImage(Icon.PROCESSOR);
	}
}

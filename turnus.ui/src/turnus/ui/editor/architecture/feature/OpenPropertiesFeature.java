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
package turnus.ui.editor.architecture.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import turnus.common.io.Logger;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class OpenPropertiesFeature extends AbstractCustomFeature {

	public OpenPropertiesFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Show properties";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// Properties tab can always be opened. There is always something
		// selected when user trigger context menu
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		final IViewPart propertiesPart;
		try {
			// Get and show the "Properties" tab
			propertiesPart = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.showView("org.eclipse.ui.views.PropertySheet");
		} catch (PartInitException e) {
			e.printStackTrace();
			return;
		}

		final DiagramEditor diagramEditor = (DiagramEditor) getDiagramBehavior()
				.getDiagramContainer();

		if (propertiesPart instanceof PropertySheet) {
			// Get the TabbedPropertyPage
			TabbedPropertySheetPage page = (TabbedPropertySheetPage) propertiesPart
					.getAdapter(TabbedPropertySheetPage.class);

			// If the adapter didn't find a TabbedPage, the Properties tab
			// displays the default table content, we have to initialize it
			if (page == null) {
				// Initialize the tab with the current Diagram Editor
				((PropertySheet) propertiesPart).partActivated(diagramEditor);
				page = (TabbedPropertySheetPage) propertiesPart
						.getAdapter(TabbedPropertySheetPage.class);
			}

			if (page != null) {
				// Immediately displays content related to the current
				// selection
				final ISelection currentSelection = new StructuredSelection(
						context.getPictogramElements());
				page.selectionChanged(diagramEditor, currentSelection);
			} else {
				Logger.warning("Unable to refresh Property tab...");
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		// This feature does not modify anything in the diagram
		return false;
	}

}

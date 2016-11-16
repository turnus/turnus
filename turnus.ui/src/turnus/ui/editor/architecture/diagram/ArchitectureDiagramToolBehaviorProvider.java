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
package turnus.ui.editor.architecture.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import turnus.ui.editor.architecture.feature.AutoLayoutFeauture;
import turnus.ui.editor.architecture.feature.OpenPropertiesFeature;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureDiagramToolBehaviorProvider extends DefaultToolBehaviorProvider {

	public ArchitectureDiagramToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	/**
	 * Customize context menu. CustomFeatures are created and arranged here.
	 */
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		final List<IContextMenuEntry> contextMenuEntries = new ArrayList<IContextMenuEntry>();

		// layout
		ContextMenuEntry entry = new ContextMenuEntry(new AutoLayoutFeauture(getFeatureProvider()), context);
		contextMenuEntries.add(entry);

		// open properties
		entry = new ContextMenuEntry(new OpenPropertiesFeature(getFeatureProvider()), context);
		contextMenuEntries.add(entry);

		return contextMenuEntries.toArray(NO_CONTEXT_MENU_ENTRIES);
	}

}

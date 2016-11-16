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
package turnus.ui.editor.architecture.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.services.Graphiti;

import turnus.common.TurnusExtensions;
import turnus.model.architecture.Architecture;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;
import turnus.ui.TurnusUiConstants;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureUtils {

	public static URI getDiagramUri(URI architectureUri) {
		return architectureUri.trimFileExtension().appendFileExtension(TurnusUiConstants.ARCHITECTURE_DIAGRAM_SUFFIX);
	}

	public static URI getArchitectureUri(URI diagramUri) {
		return diagramUri.trimFileExtension().appendFileExtension(TurnusExtensions.ARCHITECTURE);
	}

	public static IFile getDiagramFile(IFile architectureFile) {
		if (TurnusExtensions.ARCHITECTURE.equals(architectureFile.getFileExtension())) {
			IFolder folder = (IFolder) architectureFile.getParent();
			String name = architectureFile.getName().replaceAll("." + TurnusExtensions.ARCHITECTURE,
					"." + TurnusUiConstants.ARCHITECTURE_DIAGRAM_SUFFIX);
			return folder.getFile(name);
		}

		return null;

	}

	public static IFile getArchitectureFile(IFile diagramFile) {
		if (TurnusUiConstants.ARCHITECTURE_DIAGRAM_SUFFIX.equals(diagramFile.getFileExtension())) {
			IFolder folder = (IFolder) diagramFile.getParent();
			String name = diagramFile.getName().replaceAll("." + TurnusUiConstants.ARCHITECTURE_DIAGRAM_SUFFIX,
					"." + TurnusExtensions.ARCHITECTURE);
			return folder.getFile(name);
		}

		return null;

	}

	/**
	 * Check if the given architecture contains a processing unit with the given
	 * base name. If yes, return a new unique name formed from the given base
	 * and a numeric suffix. If not, returns the given base.
	 * 
	 * @param architecture
	 *            The architecture to check for existing vertex with the given
	 *            name
	 * @param base
	 *            The base name to assign to a new processing unit
	 * @return A unique name to assign to a new processing unit in the given
	 *         architecture
	 */
	public static String uniqueProcessingUnitName(final Architecture architecture, final String base) {
		final Set<String> existingNames = new HashSet<String>();
		for (ProcessingUnit pu : architecture.getProcessingUnits()) {
			existingNames.add(pu.getName());
		}

		if (!existingNames.contains(base)) {
			return base;
		} else {
			int index = 0;
			while (existingNames.contains(base + '_' + index)) {
				++index;
			}
			return base + '_' + index;
		}
	}

	public static String uniqueMediumName(final Architecture architecture, final String base) {
		final Set<String> existingNames = new HashSet<String>();
		for (Medium medium : architecture.getMedia()) {
			existingNames.add(medium.getName());
		}

		if (!existingNames.contains(base)) {
			return base;
		} else {
			int index = 0;
			while (existingNames.contains(base + '_' + index)) {
				++index;
			}
			return base + '_' + index;
		}
	}

	public static boolean deleteLinks(IFeatureProvider fp, AnchorContainer ac) {
		boolean deleted = true;
		List<Connection> connections = Graphiti.getPeService().getAllConnections(ac);
		for (Connection connection : connections) {
			deleted &= deleteLink(fp, connection);
		}
		return deleted;

	}

	public static boolean deleteLink(IFeatureProvider fp, Connection connection) {
		// Initialize the delete context
		final DeleteContext delCtxt = new DeleteContext(connection);
		delCtxt.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));

		// Silently execute deletion (user will not be asked before deletion)
		final IDeleteFeature delFeature = fp.getDeleteFeature(delCtxt);
		if (delFeature.canDelete(delCtxt)) {
			delFeature.delete(delCtxt);
			return true;
		}
		return false;

	}

}

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

import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class PropertiesUtils {

	private static final String IDENTIFIER_KEY = "XAF_ID";

	/**
	 * Search for a PictogramElement with given id as identifier. This method
	 * check the given pe and its corresponding GraphicsAlgorithm. If the given
	 * pe is a ContainerShape, children shapes are also checked.
	 * 
	 * @param pe
	 *            A PictogramElement
	 * @param id
	 *            Identifier to found
	 * @return A PropertyContainer or null if it can't be found
	 */
	public static PropertyContainer findPcFromIdentifier(final PictogramElement pe, final String id) {

		if (isExpectedPc(pe, id)) {
			return pe;
		}

		final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		if (ga != null) {
			final PropertyContainer pc = findPcFromIdentifier(ga, id);
			if (pc != null) {
				return pc;
			}
		}

		if (pe instanceof ContainerShape) {
			for (final Shape child : ((ContainerShape) pe).getChildren()) {
				final PropertyContainer foundPropertyContainer = findPcFromIdentifier(child, id);
				if (foundPropertyContainer != null) {
					return foundPropertyContainer;
				}
			}
		}

		return null;
	}

	/**
	 * Search in the given GraphicsAlgorithm and its children for an object with
	 * the given identifier.
	 * 
	 * @param ga
	 * @param id
	 * @return
	 */
	public static PropertyContainer findPcFromIdentifier(final GraphicsAlgorithm ga, final String id) {

		if (isExpectedPc(ga, id)) {
			return ga;
		}

		for (final GraphicsAlgorithm child : ga.getGraphicsAlgorithmChildren()) {
			final PropertyContainer foundPropertyContainer = findPcFromIdentifier(child, id);
			if (foundPropertyContainer != null) {
				return foundPropertyContainer;
			}
		}

		return null;
	}

	/**
	 * Set the given id as identifier to the given pe
	 * 
	 * @param pc
	 *            The PictogramElement
	 * @param id
	 *            The value of the identifier to set on given pe
	 */
	public static void setPeIdentifier(PropertyContainer pc, final String id) {
		Graphiti.getPeService().setPropertyValue(pc, IDENTIFIER_KEY, id);
	}

	public static void setPeIdentifier(PropertyContainer pc, Class<?> objectClass) {
		setPeIdentifier(pc, objectClass.getName());
	}

	public static boolean isExpectedPc(final PropertyContainer pc, Class<?> objectClass) {
		return isExpectedPc(pc, objectClass.getName());
	}

	/**
	 * Check if the given pe identifier has the given id set as identifier
	 * 
	 * @param pe
	 *            The PictogramElement
	 * @param id
	 *            The identifier to check
	 * @return true if the given pe identifier is equals to the given id value
	 */
	public static boolean isExpectedPc(final PropertyContainer pc, final String id) {
		return id.equals(getIdentifier(pc));
	}

	/**
	 * Get the identifier set on the given PictogramElement
	 * 
	 * @param pe
	 * @return The identifier, or null if the given pe has no identifier set
	 */
	public static String getIdentifier(final PropertyContainer pc) {
		return Graphiti.getPeService().getPropertyValue(pc, IDENTIFIER_KEY);
	}

}

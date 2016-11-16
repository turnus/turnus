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

import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;

import turnus.model.architecture.CPU;
import turnus.model.architecture.DSP;
import turnus.model.architecture.FPGA;
import turnus.model.architecture.Medium;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class StyleUtils {

	// Minimal and default width for an instance shape
	public static final int SHAPE_WIDTH = 120;
	// Minimal and default height for an instance shape
	public static final int SHAPE_HEIGHT = 80;
	// Height of instance label (displaying instance name)
	public static final int LABEL_HEIGHT = 40;
	// Width of the line shape used as separator
	public static final int SHAPE_SEPARATOR = 1;

	/**
	 * Return the style used for all elements with no specific style.
	 * 
	 * @param diagram
	 * @return
	 */
	public static Style commonStyle(final Diagram diagram) {
		final String styleId = "COMMON_GENERIC";
		final IGaService gaService = Graphiti.getGaService();

		// Is style already persisted?
		Style style = gaService.findStyle(diagram, styleId);

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(diagram, styleId);
			style.setLineStyle(LineStyle.SOLID);
			style.setLineVisible(true);
			style.setLineWidth(1);
			style.setTransparency(0.0);
		}
		return style;
	}

	private static Style commonTextStyle(final Diagram diagram) {
		final String styleId = "COMMON_TEXT";
		final IGaService gaService = Graphiti.getGaService();

		// Is style already persisted?
		Style style = gaService.findStyle(diagram, styleId);

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(diagram, styleId);
			style.setFilled(false);
			style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setVerticalAlignment(Orientation.ALIGNMENT_MIDDLE);
			style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
			style.setFont(gaService.manageDefaultFont(diagram, false, false));
		}
		return style;
	}

	/**
	 * Return the style used for connections.
	 * 
	 * @param diagram
	 * @return
	 */
	public static Style linkShape(final Diagram diagram) {
		final String styleId = "LINK";
		final IGaService gaService = Graphiti.getGaService();

		// this is a child style of the common-values-style
		final Style parentStyle = commonStyle(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setLineVisible(true);
			style.setLineWidth(10);
			style.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
			style.setBackground(gaService.manageColor(diagram, IColorConstant.BLACK));
		}
		return style;
	}

	/**
	 * Return the style used for Instance shapes.
	 * 
	 * @param diagram
	 * @return
	 */
	public static Style mediumShape(final Diagram diagram) {
		final String styleId = Medium.class.getName();
		final IGaService gaService = Graphiti.getGaService();

		// this is a child style of the common-values-style
		final Style parentStyle = commonStyle(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setFilled(true);
			// gaService.setRenderingStyle(style,
			// PredefinedColoredAreas.getLightYellowAdaptions());
			style.setBackground(gaService.manageColor(diagram, IColorConstant.CYAN));

		}

		return style;
	}

	public static Style mediumText(final Diagram diagram) {
		final String styleId = "MEDIUM_TEXT";
		final IGaService gaService = Graphiti.getGaService();

		final Style parentStyle = commonTextStyle(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);

		if (style == null) {
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setFilled(false);
			style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setVerticalAlignment(Orientation.ALIGNMENT_MIDDLE);
			style.setFont(gaService.manageFont(diagram, "Arial", 9, false, true));
		}
		return style;
	}

	public static Style processingUnitShape(final Diagram diagram, Class<?> type) {
		final String styleId = type.getName();
		final IGaService gaService = Graphiti.getGaService();

		// this is a child style of the common-values-style
		final Style parentStyle = commonStyle(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);

		if (style == null) { // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setFilled(true);
			IColorConstant color = IColorConstant.LIGHT_GRAY;
			if (type == CPU.class) {
				color = IColorConstant.LIGHT_GREEN;
			} else if (type == DSP.class) {
				color = IColorConstant.LIGHT_ORANGE;
			} else if (type == FPGA.class) {
				color = IColorConstant.LIGHT_BLUE;
			}
			// gaService.setRenderingStyle(style,
			// PredefinedColoredAreas.getCopperWhiteGlossAdaptions());
			style.setBackground(gaService.manageColor(diagram, color));

		}

		return style;
	}

	/**
	 * Return the style used for the text displaying name of an Instance.
	 * 
	 * @param diagram
	 * @return
	 */
	public static Style processingUnitText(final Diagram diagram) {
		final String styleId = "PU_TEXT";
		final IGaService gaService = Graphiti.getGaService();

		final Style parentStyle = commonTextStyle(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);

		if (style == null) {
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setFilled(false);
			style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setVerticalAlignment(Orientation.ALIGNMENT_MIDDLE);
			style.setFont(gaService.manageFont(diagram, "Arial", 9, false, true));
		}
		return style;
	}

}

/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2024 Endri Bezati
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

package turnus.ui.wizard.impl;

import turnus.common.io.FileExporterFactory;
import turnus.ui.wizard.AbstractFileExporterWizard;

/**
 * This class defines a HTML file exporter wizard. Available input file
 * extensions are handled by the {@link FileExporterFactory}.
 * 
 * @author Endri Bezati
 */
public class HtmlFileExporterWizard extends AbstractFileExporterWizard {

	public HtmlFileExporterWizard() {
		super("html");
	}

}

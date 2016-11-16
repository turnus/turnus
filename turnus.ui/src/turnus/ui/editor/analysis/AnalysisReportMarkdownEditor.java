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
package turnus.ui.editor.analysis;

import java.io.File;

import org.eclipse.core.resources.IFile;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.FileExporterFactory;
import turnus.common.util.FileUtils;
import turnus.ui.editor.AbstractBrowserEditor;
import turnus.ui.util.HtmlUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class AnalysisReportMarkdownEditor extends AbstractBrowserEditor {

	public AnalysisReportMarkdownEditor() {
		super();
		addStyle("basic.css");
	}

	@Override
	protected String toHtml(IFile iFile) throws TurnusException {
		try {
			File output = FileUtils.createTempFile(iFile.getName(), ".md", true);
			FileExporter<?> exporter = FileExporterFactory.INSTANCE.getExporter(iFile.getFileExtension(), "md");
			exporter.export(FileUtils.getFile(iFile), output);
			String md = FileUtils.toString(output);
			try {
				// try delete now the file
				output.delete();
			} catch (Exception e) {
			}
			return HtmlUtils.markdown2Html(md);
		} catch (Exception e) {
			throw new TurnusException("File cannot be converted to an md file", e);
		}
	}

}

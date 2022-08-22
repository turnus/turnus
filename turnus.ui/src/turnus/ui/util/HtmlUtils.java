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
package turnus.ui.util;

import java.io.InputStream;
import java.util.Arrays;

import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.emoji.EmojiImageType;
import com.vladsch.flexmark.ext.emoji.EmojiShortcutType;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import turnus.common.io.Logger;
import turnus.common.util.FileUtils;

/**
 * This class contains some utilities functions for the HTML writers
 * 
 * @author Simone Casale Brunet
 *
 */
public class HtmlUtils {

	/**
	 * Append the given java-script
	 * 
	 * @param htmlContent the current html string
	 * @param js          the list of java-script files name (with extension) inside
	 *                    the html project path
	 * @return
	 */
	public static String appendJs(String htmlContent, String... js) {
		StringBuffer b = new StringBuffer();
		b.append("<script language=\"javascript\" type=\"text/javascript\">");
		for (String j : js) {
			try {
				InputStream is = new HtmlUtils().getClass().getClassLoader().getResource("/html/" + j).openStream();
				b.append(FileUtils.toString(is));
				is.close();
			} catch (Exception e) {
				Logger.debug("Java-Script \"%s\" not added. Error: %s", j, e.getMessage());
			}
		}
		b.append("</script>");
		b.append(htmlContent);
		return b.toString();
	}

	/**
	 * Append the given css styles
	 * 
	 * @param htmlContent the current html string
	 * @param css         the list of css files name (with extension) inside the
	 *                    html project path
	 * @return
	 */
	public static String appendStyle(String htmlContent, String... css) {
		StringBuffer b = new StringBuffer();
		b.append("<style>");
		for (String c : css) {
			try {
				InputStream is = new HtmlUtils().getClass().getClassLoader().getResource("/html/" + c).openStream();
				b.append(FileUtils.toString(is));
				is.close();
			} catch (Exception e) {
				Logger.debug("Style \"%s\" not added. Error: %s", c, e.getMessage());
			}
		}
		b.append("</style>");
		b.append(htmlContent);
		return b.toString();
	}

	/**
	 * Parse the Markdown string and return an HTML string
	 * 
	 * <pre>
	 * see: {@link https://rawgit.com/fletcher/human-markdown-reference/master/index.html}
	 * </pre>
	 * 
	 * @param mdString
	 * @return
	 */
	public static String markdown2Html(String mdString) {
		// int SETTINGS = HARDWRAPS | AUTOLINKS | TABLES | FENCED_CODE_BLOCKS;
		// return new PegDownProcessor(SETTINGS).markdownToHtml(mdString);
		MutableDataSet options = new MutableDataSet()
				.set(Parser.EXTENSIONS,
						Arrays.asList(AutolinkExtension.create(), StrikethroughExtension.create(),
								TaskListExtension.create(), TablesExtension.create()))

				.set(TablesExtension.WITH_CAPTION, false)
				.set(TablesExtension.COLUMN_SPANS, false)
				.set(TablesExtension.MIN_HEADER_ROWS, 1)
				.set(TablesExtension.MAX_HEADER_ROWS, 1)
				.set(TablesExtension.APPEND_MISSING_COLUMNS, true)
				.set(TablesExtension.DISCARD_EXTRA_COLUMNS, true)
				.set(TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH, true)

		// other options
		;

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		Node document = parser.parse(mdString);
		return renderer.render(document);

	}

}

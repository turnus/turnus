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
package turnus.common.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * This class contains some utilities methods for the {@code org.apache.poi}
 * library.
 * 
 * @author Simone Casale Brunet
 *
 */
public class PoiUtils {

	/**
	 * Set a bold font for the given cell. The default size is 10pt.
	 * 
	 * @param wb
	 *            the workbook that contains the cell
	 * @param cell
	 *            the cell where the text is contained
	 */
	public static void setBold(Workbook wb, HSSFCell cell) {
		setBold(wb, cell, (short) 10);
	}

	/**
	 * Set a bold font for the given cell with a given font size (in pt).
	 * 
	 * @param wb
	 *            the workbook that contains the cell
	 * @param cell
	 *            the cell where the text is contained
	 * @param size
	 *            the size in pt of the text
	 */
	public static void setBold(Workbook wb, HSSFCell cell, short size) {
		Font font = wb.createFont();
		font.setFontHeightInPoints((short) size);
		font.setFontName("Arial");
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setBold(true);
		font.setItalic(false);

		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		cell.setCellStyle(style);
	}

	/**
	 * See the comment for the given cell
	 * 
	 * @param cell
	 *            the cell
	 * @param message
	 *            the comment message
	 */
	public static void setComment(HSSFCell cell, String message) {
		Drawing drawing = cell.getSheet().createDrawingPatriarch();
		CreationHelper factory = cell.getSheet().getWorkbook().getCreationHelper();

		// When the comment box is visible, have it show in a 1x3 space
		ClientAnchor anchor = factory.createClientAnchor();
		anchor.setCol1(cell.getColumnIndex());
		anchor.setCol2(cell.getColumnIndex() + 1);
		anchor.setRow1(cell.getRowIndex());
		anchor.setRow2(cell.getRowIndex() + 1);
		anchor.setDx1(100);
		anchor.setDx2(1000);
		anchor.setDy1(100);
		anchor.setDy2(1000);

		// Create the comment and set the text+author
		Comment comment = drawing.createCellComment(anchor);
		RichTextString str = factory.createRichTextString(message);
		comment.setString(str);
		comment.setAuthor("TURNUS");
		// Assign the comment to the cell
		cell.setCellComment(comment);
	}

	/**
	 * Set a link to a cell. The link type should one of {@link Hyperlink}
	 * 
	 * @param wb
	 *            the workbook which contains the cell
	 * @param cell
	 *            the cell where the link is stored
	 * @param address
	 *            the cell destination address
	 * @param linkType
	 *            the type selected among {@link Hyperlink}
	 */
	public static void setLink(Workbook wb, HSSFCell cell, String address, int linkType) {
		CreationHelper helper = wb.getCreationHelper();
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setUnderline(Font.U_SINGLE);
		font.setColor(IndexedColors.BLUE.getIndex());
		style.setFont(font);

		Hyperlink link = helper.createHyperlink(linkType);
		link.setAddress(address);
		cell.setHyperlink(link);
		cell.setCellStyle(style);
	}

}

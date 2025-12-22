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
package turnus.model.analysis.buffers.io;

import static turnus.common.util.PoiUtils.setBold;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;

/**
 * 
 * The {@link BoundedBuffersReport} XLS file exporter
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class Boundbuffer2XlsEporter implements FileExporter<BoundedBuffersReport, XSSFWorkbook> {

	@Override
	public XSSFWorkbook content(BoundedBuffersReport report) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		write(workbook, report);
		return workbook;
	}

	@Override
	public void export(File input, File output) throws TurnusException {
		BoundedBuffersReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid BOUNDEDBUFFER file");
		}
		export(data, output);

	}

	@Override
	public void export(BoundedBuffersReport report, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		XSSFWorkbook workbook = content(report);

		try {
			workbook.write(fileOut);
		} catch (Exception e) {
			throw new TurnusException("Error while writing the \"" + output + "\" output file");
		}
		try {
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly closed");
		}

	}

	private void write(XSSFWorkbook workbook, BoundedBuffersReport report) {
		XSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Bounded buffer size analysis report");
		setBold(workbook, cell, (short) 14);

		// row 1: Network | name
		cRow = 1;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Network");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(report.getNetwork().getName());

		// row 2: Algorithm | name
		cRow = 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Algorithm");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(report.getAlgorithm());

		// row 3: Bit accurate | value
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Bit accurate");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(Boolean.toString(report.isBitAccurate()));

		// row 4: Pow2 | value
		cRow = 4;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Power of 2");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(Boolean.toString(report.isPow2()));

		{ // buffers data
			// the cell index
			int src_actor = 0;
			int src_port = 1;
			int tgt_actor = 2;
			int tgt_port = 3;
			int type = 4;
			int tokens = 5;
			int bits = 6;

			// row 6;
			cRow = 6;
			row = worksheet.createRow(cRow);
			cell = row.createCell(src_actor);
			cell.setCellValue("Source");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 0, 1));
			cell = row.createCell(tgt_actor);
			cell.setCellValue("Target");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 2, 3));
			cell = row.createCell(type);
			cell.setCellValue("Type");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 4, 4));
			cell = row.createCell(tokens);
			cell.setCellValue("tokens");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 5, 5));
			cell = row.createCell(bits);
			cell.setCellValue("Bits");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 6, 6));

			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(src_actor);
			cell.setCellValue("actor");
			setBold(workbook, cell);
			cell = row.createCell(src_port);
			cell.setCellValue("port");
			setBold(workbook, cell);
			cell = row.createCell(tgt_actor);
			cell.setCellValue("actor");
			setBold(workbook, cell);
			cell = row.createCell(tgt_port);
			cell.setCellValue("port");
			setBold(workbook, cell);

			cRow++;
			int firstRow = cRow + 1;
			int lastRow = firstRow;
			for (BoundedBufferData bd : report.getBuffersData()) {
				row = worksheet.createRow(cRow);
				cell = row.createCell(src_actor);
				cell.setCellValue(bd.getBuffer().getSource().getOwner().getName());
				cell = row.createCell(src_port);
				cell.setCellValue(bd.getBuffer().getSource().getName());
				cell = row.createCell(tgt_actor);
				cell.setCellValue(bd.getBuffer().getTarget().getOwner().getName());
				cell = row.createCell(tgt_port);
				cell.setCellValue(bd.getBuffer().getTarget().getName());
				cell = row.createCell(tokens);
				int count = bd.getTokenSize();
				cell.setCellValue(count);
				cell = row.createCell(type);
				cell.setCellValue(bd.getBuffer().getType().toString());
				cell = row.createCell(bits);
				cell.setCellValue(bd.getBuffer().getType().getBits() * count);

				cRow++;
				lastRow = cRow;
			}

			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(type);
			cell.setCellValue("sum");
			setBold(workbook, cell);
			cell = row.createCell(tokens);
			cell.setCellFormula("SUM(F" + firstRow + ":F" + lastRow + ")");
			cell = row.createCell(bits);
			cell.setCellFormula("SUM(G" + firstRow + ":G" + lastRow + ")");
		}
	}

}

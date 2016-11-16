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
package turnus.model.analysis.pipelining.io;

import static turnus.common.util.PoiUtils.setBold;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class Varpipe2XlsExporter implements FileExporter<ActionsVariablePipeliningReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		ActionsVariablePipeliningReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

	@Override
	public void export(ActionsVariablePipeliningReport report, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		writeSummary(workbook, report);

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

	private void writeSummary(HSSFWorkbook workbook, ActionsVariablePipeliningReport report) {
		List<ActionVariablePipeliningData> actionsData = new ArrayList<>(report.getActionsData());

		Collections.sort(actionsData, new Comparator<ActionVariablePipeliningData>() {
			@Override
			public int compare(ActionVariablePipeliningData o1, ActionVariablePipeliningData o2) {
				boolean p1 = o1.isPipelinable();
				boolean p2 = o2.isPipelinable();
				if (p1 != p2) {
					return -Boolean.compare(p1, p2);
				}

				double d1 = o1.getPipelinableFirings().getMin();
				double d2 = o2.getPipelinableFirings().getMin();
				int result = -Double.compare(d1, d2);
				if (result != 0) {
					return result;
				}

				d1 = o1.getPipelinableFirings().getMean();
				d2 = o2.getPipelinableFirings().getMean();
				result = -Double.compare(d1, d2);
				if (result != 0) {
					return result;
				}

				d1 = o1.getPipelinableFirings().getMax();
				d2 = o2.getPipelinableFirings().getMax();
				result = -Double.compare(d1, d2);
				if (result != 0) {
					return result;
				}

				String v1 = o1.getAction().getOwner().getName();
				String v2 = o1.getAction().getOwner().getName();
				if (v1.equals(v2)) {
					v1 = o1.getAction().getName();
					v2 = o2.getAction().getName();
				}
				return v1.compareTo(v2);
			}
		});

		HSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		HSSFRow row = worksheet.createRow(cRow);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Pipelining with variable utilization analysis report");
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

		int pipelinables = 0;
		for (ActionVariablePipeliningData d : actionsData) {
			if (d.isPipelinable()) {
				pipelinables++;
			}
		}

		// row 3: Pipelinables | number
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Pipelinables");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(pipelinables);

		// row 5: Table template
		cRow = 5;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Actor");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 0, 0));
		cell = row.createCell(1);
		cell.setCellValue("Action");
		setBold(workbook, cell);
		cell = row.createCell(2);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 1, 1));
		cell.setCellValue("Pipelinable");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 2, 2));
		cell = row.createCell(3);
		cell.setCellValue("Consecutive firings");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 3, 5));
		cell = row.createCell(6);
		cell.setCellValue("Pipelinable firings");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 6, 8));

		cRow = 6;
		row = worksheet.createRow(cRow);
		cell = row.createCell(3);
		cell.setCellValue("Average");
		setBold(workbook, cell);
		cell = row.createCell(4);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(5);
		cell.setCellValue("Max");
		setBold(workbook, cell);
		cell = row.createCell(6);
		cell.setCellValue("Average");
		setBold(workbook, cell);
		cell = row.createCell(7);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(8);
		cell.setCellValue("Max");
		setBold(workbook, cell);

		for (ActionVariablePipeliningData d : actionsData) {
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue(d.getAction().getOwner().getName());
			row.createCell(1).setCellValue(d.getAction().getName());
			row.createCell(2).setCellValue(d.isPipelinable());
			row.createCell(3).setCellValue(d.getConsecutiveFirings().getMean());
			row.createCell(4).setCellValue(d.getConsecutiveFirings().getMin());
			row.createCell(5).setCellValue(d.getConsecutiveFirings().getMax());
			row.createCell(6).setCellValue(d.getPipelinableFirings().getMean());
			row.createCell(7).setCellValue(d.getPipelinableFirings().getMin());
			row.createCell(8).setCellValue(d.getPipelinableFirings().getMax());
		}
	}

}

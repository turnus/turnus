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
package turnus.model.analysis.bottlenecks.io;

import static turnus.common.util.PoiUtils.setBold;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.apache.poi.ss.util.CellRangeAddress;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksReport;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class Bottlenecks2XlsExporter implements FileExporter<BottlenecksReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		BottlenecksReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid BOTTLENECKS file");
		}
		export(data, output);

	}

	@Override
	public void export(BottlenecksReport report, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		XSSFWorkbook workbook = new XSSFWorkbook();
		writeSummary(workbook, report);
		writeActionsData(workbook, report);

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

	private void writeSummary(XSSFWorkbook workbook, BottlenecksReport report) {
		XSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Bottlenecks analysis report");
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

		// row 4-6: Total weight, Cp weight
		cRow = 4;
		row = worksheet.createRow(cRow);
		row.createCell(1).setCellValue("Average");
		row.createCell(2).setCellValue("Variance");
		cRow = 5;
		row = worksheet.createRow(cRow);
		row.createCell(0).setCellValue("Total workload");
		row.createCell(1).setCellValue(report.getTotalWeight());
		row.createCell(2).setCellValue(report.getTotalVariance());
		cRow = 6;
		row = worksheet.createRow(cRow);
		row.createCell(0).setCellValue("Critical path workload");
		row.createCell(1).setCellValue(report.getCpWeight());
		row.createCell(2).setCellValue(report.getCpVariance());

		// ratios
		cRow = 8;
		row = worksheet.createRow(cRow);
		double hr = report.getCpWeight() / report.getTotalWeight();
		row.createCell(0).setCellValue("Critical weight ratio");
		row.createCell(1).setCellValue(hr);
		cRow = 9;
		row = worksheet.createRow(cRow);
		double fr = (double) report.getCpFirings() / report.getTotalFirings();
		row.createCell(0).setCellValue("Firings ratio");
		row.createCell(1).setCellValue(fr);

		// speedup
		int actors = report.getNetwork().getActors().size();
		cRow = 11;
		row = worksheet.createRow(cRow);
		row.createCell(0).setCellValue("Processing elements");
		for (int i = 1; i <= actors; i++) {
			row.createCell(i).setCellValue(i);
		}
		cRow = 12;
		row = worksheet.createRow(cRow);
		row.createCell(0).setCellValue("S");
		double cp = report.getCpWeight();
		double w = report.getTotalWeight();
		for (int i = 1; i <= actors; i++) {
			double cpn = w - (w - cp) / (actors - 1) * (i - 1);
			row.createCell(i).setCellValue(w / cpn);
		}
		
		cRow = 14;
		row = worksheet.createRow(cRow);
		row.createCell(0).setCellValue("Parallelism");
		row.createCell(1).setCellValue(report.getTotalWeight() / report.getCpWeight());
	}

	private void writeActionsData(XSSFWorkbook workbook, BottlenecksReport report) {
		XSSFSheet worksheet = workbook.createSheet("Actions data");

		List<ActionBottlenecksData> actionsData = new ArrayList<>(report.getActionsData());
		Collections.sort(actionsData, new Comparator<ActionBottlenecksData>() {

			@Override
			public int compare(ActionBottlenecksData o1, ActionBottlenecksData o2) {
				double v1 = o1.getCpWeight();
				double v2 = o2.getCpWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalWeight();
				v2 = o2.getTotalWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalFirings();
				v2 = o2.getTotalFirings();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				return o1.getAction().toString().compareTo(o2.getAction().toString());
			}
		});

		int cRow = 0;
		{ // actions data
			// the cell index
			int actor = 0;
			int aclass = 1;
			int action = 2;
			int firings = 3;
			int weight = 4;
			int cpFirings = 5;
			int cpWeight = 6;
			int cpPc = 7;
			int cpFraction = 8;
			XSSFRow row = worksheet.createRow(cRow);
			XSSFCell cell = row.createCell(actor);
			cell.setCellValue("Actor");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 0, 0));
			cell = row.createCell(aclass);
			cell.setCellValue("Actor-Class");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 1, 1));
			cell = row.createCell(action);
			cell.setCellValue("Action");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow + 1, 2, 2));
			cell = row.createCell(firings);
			cell.setCellValue("Overall");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 3, 4));
			cell = row.createCell(cpFirings);
			cell.setCellValue("Critical Path");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 5, 6));
			cell.setCellValue("Statistics");
			setBold(workbook, cell);
			worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 7, 8));

			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(firings);
			cell.setCellValue("Firings");
			setBold(workbook, cell);
			cell = row.createCell(weight);
			cell.setCellValue("Weight");
			setBold(workbook, cell);
			cell = row.createCell(cpFirings);
			cell.setCellValue("Firings");
			setBold(workbook, cell);
			cell = row.createCell(cpWeight);
			cell.setCellValue("Weight");
			setBold(workbook, cell);
			cell = row.createCell(cpPc);
			cell.setCellValue("CP %");
			setBold(workbook, cell);
			cell = row.createCell(cpFraction);
			cell.setCellValue("CP fraction");
			setBold(workbook, cell);

			for (ActionBottlenecksData data : actionsData) {
				cRow++;
				row = worksheet.createRow(cRow);
				row.createCell(actor).setCellValue(data.getAction().getOwner().getName());
				row.createCell(aclass).setCellValue(data.getAction().getOwner().getActorClass().getName());
				row.createCell(action).setCellValue(data.getAction().getName());
				row.createCell(firings).setCellValue(data.getTotalFirings());
				row.createCell(weight).setCellValue(data.getTotalWeight());
				row.createCell(cpFirings).setCellValue(data.getCpFirings());
				row.createCell(cpWeight).setCellValue(data.getCpWeight());
				row.createCell(cpPc).setCellValue(data.getCpWeight() * 100 / report.getCpWeight());
				row.createCell(cpFraction).setCellValue(data.getCpWeight() * 100 / data.getTotalWeight());
			}

		}

	}

}

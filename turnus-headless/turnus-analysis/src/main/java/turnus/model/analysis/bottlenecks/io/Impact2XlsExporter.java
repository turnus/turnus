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
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.bottlenecks.ImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.dataflow.Action;

/**
 * 
 * @author Simone Casale Brunet
 * @authro Endri Bezati
 *
 */
public class Impact2XlsExporter implements FileExporter<ImpactAnalysisReport, XSSFWorkbook> {

	@Override
	public XSSFWorkbook content(ImpactAnalysisReport report) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		write(workbook, report);
		return workbook;
	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ImpactAnalysisReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid IMPACT file");
		}
		export(data, output);

	}

	@Override
	public void export(ImpactAnalysisReport report, File output) throws TurnusException {
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

	private void write(XSSFWorkbook workbook, ImpactAnalysisReport report) {
		XSSFSheet worksheet = workbook.createSheet("Summary");
		boolean classLevel = report.isClassLevel();

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Impact analysis report");
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

		// row 3: Actor class level | value
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Actor class level");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(Boolean.toString(classLevel));

		cRow = 5;
		for (ImpactAnalysisData data : report.getImpactData()) {
			cRow += 2;
			if (classLevel) {
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue("Actor class");
				setBold(workbook, cell);
				cell = row.createCell(1);
				cell.setCellValue(data.getActorClass().getName());
				cRow++;
			}
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell);
			int cellNumber = 1;
			for (Action action : data.getActions()) {
				cell = row.createCell(cellNumber);
				String name = "(" + action.getOwner().getName() + "," + action.getName() + ")";
				cell.setCellValue(name);
				cellNumber++;
			}
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Weight reduction");
			cell = row.createCell(1);
			cell.setCellValue("CP length reduction");

			Map<Double, Double> map = data.getCpReductionMap();
			List<Double> ratios = new ArrayList<>(map.keySet());
			Collections.sort(ratios);

			for (Double ratio : ratios) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(ratio);
				cell = row.createCell(1);
				cell.setCellValue(map.get(ratio));
			}
		}

	}

}

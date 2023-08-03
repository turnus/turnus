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
package turnus.model.analysis.trace.io;

import static turnus.common.util.PoiUtils.setBold;
import static turnus.common.util.PoiUtils.setLink;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.Pair;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.analysis.trace.util.TraceSizeAnalysis;
import turnus.model.analysis.trace.util.TraceSizeAnalysis.ActionTraceSize;
import turnus.model.analysis.trace.util.TraceSizeAnalysis.ActorTraceSize;
import turnus.model.trace.Dependency.Kind;

/**
 * The {@link TraceSizeReport} XLS file exporter
 * 
 * @author Simone Casale Brunet
 *
 */
public class Tsize2XlsExporter implements FileExporter<TraceSizeReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		TraceSizeReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid TSIZE file");
		}
		export(data, output);

	}

	@Override
	public void export(TraceSizeReport data, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}

		TraceSizeAnalysis size = new TraceSizeAnalysis(data);
		XSSFWorkbook workbook = new XSSFWorkbook();
		writeSummary(workbook, size);
		writeDetails(workbook, size);

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

	private void writeDetails(XSSFWorkbook workbook, TraceSizeAnalysis data) {
		XSSFSheet worksheet = null;
		List<ActorTraceSize> actorsData = data.getActorsData();

		for (ActorTraceSize actorData : actorsData) {
			worksheet = workbook.createSheet("Actor(" + actorsData.indexOf(actorData) + ")");

			// row 0: actor name
			int cRow = 0;
			XSSFRow row = worksheet.createRow(cRow);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(actorData.getActor().getName());
			setBold(workbook, cell, (short) 14);

			cRow += 2;
			List<ActionTraceSize> actionsData = actorData.getActionsData();
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell);
			cell = row.createCell(1);
			cell.setCellValue("Firings");
			setBold(workbook, cell);
			cell = row.createCell(2);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			cell = row.createCell(3);
			cell.setCellValue("Incomings");
			setBold(workbook, cell);
			cell = row.createCell(4);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			cell = row.createCell(5);
			cell.setCellValue("Outgoings");
			setBold(workbook, cell);
			cell = row.createCell(6);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			for (ActionTraceSize actionData : actionsData) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(actionData.getAction().getName());
				cell = row.createCell(1);
				cell.setCellValue(actionData.getFirings().v1);
				cell = row.createCell(2);
				cell.setCellValue(actionData.getFirings().v2);
				cell = row.createCell(3);
				cell.setCellValue(actionData.getIncomings().v1);
				cell = row.createCell(4);
				cell.setCellValue(actionData.getIncomings().v2);
				cell = row.createCell(5);
				cell.setCellValue(actionData.getOutgoings().v1);
				cell = row.createCell(6);
				cell.setCellValue(actionData.getOutgoings().v2);
			}
		}

	}

	private void writeSummary(XSSFWorkbook workbook, TraceSizeAnalysis data) {
		XSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Trace size");
		setBold(workbook, cell, (short) 14);

		// row 1: network | name
		cRow = 1;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Network");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(data.getNetwork().getName());

		// row 2: firings | value
		cRow = 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Firings");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(data.getFirings());

		// row 3: dependencies | value
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Dependencies");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(data.getDependencies());

		// row 5: dependencies kinds
		cRow = 5;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Dependencies kinds");
		setBold(workbook, cell);

		{// dependencies kinds
			// row 7: kind | count | percentage
			cRow = 7;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Kinds");
			setBold(workbook, cell);
			cell = row.createCell(1);
			cell.setCellValue("Count");
			setBold(workbook, cell);
			cell = row.createCell(2);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			for (Entry<Kind, Pair<Long, Double>> e : data.getDependenciesKind().entrySet()) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(e.getKey().literal());
				cell = row.createCell(1);
				cell.setCellValue(e.getValue().v1);
				cell = row.createCell(2);
				cell.setCellValue(e.getValue().v2);
			}
		}

		cRow += 2;

		{// actors details
			cRow++;
			List<ActorTraceSize> actorsData = data.getActorsData();
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Actor");
			setBold(workbook, cell);
			cell = row.createCell(1);
			cell.setCellValue("Firings");
			setBold(workbook, cell);
			cell = row.createCell(2);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			cell = row.createCell(3);
			cell.setCellValue("Incomings");
			setBold(workbook, cell);
			cell = row.createCell(4);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			cell = row.createCell(5);
			cell.setCellValue("Outgoings");
			setBold(workbook, cell);
			cell = row.createCell(6);
			cell.setCellValue("Percentage");
			setBold(workbook, cell);
			for (ActorTraceSize actorSize : actorsData) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(actorSize.getActor().getName());
				setLink(workbook, cell, "'Actor(" + actorsData.indexOf(actorSize) + ")'!A1", HyperlinkType.DOCUMENT);
				cell = row.createCell(1);
				cell.setCellValue(actorSize.getFirings().v1);
				cell = row.createCell(2);
				cell.setCellValue(actorSize.getFirings().v2);
				cell = row.createCell(3);
				cell.setCellValue(actorSize.getIncomings().v1);
				cell = row.createCell(4);
				cell.setCellValue(actorSize.getIncomings().v2);
				cell = row.createCell(5);
				cell.setCellValue(actorSize.getOutgoings().v1);
				cell = row.createCell(6);
				cell.setCellValue(actorSize.getOutgoings().v2);
			}
		}

	}

}

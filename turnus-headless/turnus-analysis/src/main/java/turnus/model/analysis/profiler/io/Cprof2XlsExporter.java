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
package turnus.model.analysis.profiler.io;

import static turnus.common.util.PoiUtils.setBold;
import static turnus.common.util.PoiUtils.setComment;
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
import turnus.model.analysis.profiler.CodeProfilingReport;
import turnus.model.analysis.profiler.util.HalsteadCodeAnalysis;
import turnus.model.analysis.profiler.util.HalsteadCodeAnalysis.HalsteadAnalysis;
import turnus.model.dataflow.Network;

/**
 * The {@link CodeProfilingReport} XLS file exporter
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class Cprof2XlsExporter implements FileExporter<CodeProfilingReport, XSSFWorkbook> {

	@Override
	public void export(CodeProfilingReport data, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		XSSFWorkbook workbook = content(data);

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

	@Override
	public void export(File input, File output) throws TurnusException {
		CodeProfilingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid CPROF file");
		}
		export(data, output);
	}

	/**
	 * Write a sheet for each sinle actor class
	 * 
	 * @param workbook
	 * @param report
	 */
	private void writeDetails(XSSFWorkbook workbook, HalsteadCodeAnalysis report) {
		XSSFSheet worksheet = null;

		List<HalsteadAnalysis> classesData = report.getActorClassesAnalysis();

		for (HalsteadAnalysis classData : classesData) {
			worksheet = workbook.createSheet("Class(" + classesData.indexOf(classData) + ")");

			// row 0: class name
			int cRow = 0;
			XSSFRow row = worksheet.createRow(cRow);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(classData.blockName());
			setBold(workbook, cell, (short) 14);

			// row 2: operator | count
			cRow = 2;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Operator");
			setBold(workbook, cell);
			cell = row.createCell(1);
			cell.setCellValue("Count");
			setBold(workbook, cell);

			for (Entry<String, Integer> e : classData.operatorsMap().entrySet()) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(e.getKey());
				cell = row.createCell(1);
				cell.setCellValue(e.getValue());
			}

			// row + 2
			cRow += 2;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Operand");
			setBold(workbook, cell);
			cell = row.createCell(1);
			cell.setCellValue("Count");
			setBold(workbook, cell);

			for (Entry<String, Integer> e : classData.operandsMap().entrySet()) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(0);
				cell.setCellValue(e.getKey());
				cell = row.createCell(1);
				cell.setCellValue(e.getValue());
			}
		}

	}

	/**
	 * Write the report summary page
	 * 
	 * @param workbook
	 * @param network
	 * @param report
	 */
	private void writeSummary(XSSFWorkbook workbook, Network network, HalsteadCodeAnalysis report) {
		XSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("Static code profiling report");
		setBold(workbook, cell, (short) 14);

		// row 1: project | name
		cRow = 1;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("CAL project");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(network.getProject());

		// row 2: source file | name
		cRow = 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Source file");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(network.getSourceFile());

		{ // network data
			// row 4;
			cRow = 4;
			// the cell index
			int iNOL = 0;
			int in = 1;
			int in1 = 2;
			int in2 = 3;
			int iN = 4;
			int iN1 = 5;
			int iN2 = 6;
			int iD = 7;
			int iV = 8;
			int iB = 9;
			int iT = 10;

			row = worksheet.createRow(cRow);
			cell = row.createCell(iNOL);
			cell.setCellValue("NoL");
			setBold(workbook, cell);
			setComment(cell, "number of lines");
			cell = row.createCell(in);
			cell.setCellValue("n");
			setBold(workbook, cell);
			setComment(cell, "program vocabulary");
			cell = row.createCell(in1);
			cell.setCellValue("n1");
			setBold(workbook, cell);
			setComment(cell, "number of distinct operators");
			cell = row.createCell(in2);
			cell.setCellValue("n2");
			setBold(workbook, cell);
			setComment(cell, "number of distinct operands");
			cell = row.createCell(iN);
			cell.setCellValue("N");
			setBold(workbook, cell);
			setComment(cell, "program length");
			cell = row.createCell(iN1);
			cell.setCellValue("N1");
			setBold(workbook, cell);
			setComment(cell, "total number of operators");
			cell = row.createCell(iN2);
			cell.setCellValue("N2");
			setBold(workbook, cell);
			setComment(cell, "total number of operands");
			cell = row.createCell(iD);
			cell.setCellValue("D");
			setBold(workbook, cell);
			setComment(cell, "difficulty");
			cell = row.createCell(iV);
			cell.setCellValue("V");
			setBold(workbook, cell);
			setComment(cell, "Volume");
			cell = row.createCell(iB);
			cell.setCellValue("B");
			setBold(workbook, cell);
			setComment(cell, "Delivered bugs");
			cell = row.createCell(iT);
			cell.setCellValue("T");
			setBold(workbook, cell);
			setComment(cell, "Time to program (sec)");

			// row 5: the values
			HalsteadAnalysis netData = report.getNetworkAnalysis();
			cRow = 5;
			row = worksheet.createRow(cRow);
			row.createCell(iNOL).setCellValue(netData.NoL());
			row.createCell(in).setCellValue(netData.n());
			row.createCell(in1).setCellValue(netData.n1());
			row.createCell(in2).setCellValue(netData.n2());
			row.createCell(iN).setCellValue(netData.N());
			row.createCell(iN1).setCellValue(netData.N1());
			row.createCell(iN2).setCellValue(netData.N2());
			row.createCell(iD).setCellValue(netData.D());
			row.createCell(iV).setCellValue(netData.V());
			row.createCell(iB).setCellValue(netData.B());
			row.createCell(iT).setCellValue(netData.T());
		}

		{// actor classes data
			// row 7: actor classes
			cRow = 7;
			// indexes
			int iClass = 0;
			int iNOL = 1;
			int in = 2;
			int in1 = 3;
			int in2 = 4;
			int iN = 5;
			int iN1 = 6;
			int iN2 = 7;
			int iD = 8;
			int iV = 9;
			int iB = 10;
			int iT = 11;

			row = worksheet.createRow(cRow);
			cell = row.createCell(iClass);
			cell.setCellValue("Actor-Class");
			setBold(workbook, cell);
			row = worksheet.createRow(cRow);
			cell = row.createCell(iNOL);
			cell.setCellValue("NoL");
			setBold(workbook, cell);
			setComment(cell, "number of lines");
			cell = row.createCell(in);
			cell.setCellValue("n");
			setBold(workbook, cell);
			setComment(cell, "program vocabulary");
			cell = row.createCell(in1);
			cell.setCellValue("n1");
			setBold(workbook, cell);
			setComment(cell, "number of distinct operators");
			cell = row.createCell(in2);
			cell.setCellValue("n2");
			setBold(workbook, cell);
			setComment(cell, "number of distinct operands");
			cell = row.createCell(iN);
			cell.setCellValue("N");
			setBold(workbook, cell);
			setComment(cell, "program length");
			cell = row.createCell(iN1);
			cell.setCellValue("N1");
			setBold(workbook, cell);
			setComment(cell, "total number of operators");
			cell = row.createCell(iN2);
			cell.setCellValue("N2");
			setBold(workbook, cell);
			setComment(cell, "total number of operands");
			cell = row.createCell(iD);
			cell.setCellValue("D");
			setBold(workbook, cell);
			setComment(cell, "difficulty");
			cell = row.createCell(iV);
			cell.setCellValue("V");
			setBold(workbook, cell);
			setComment(cell, "Volume");
			cell = row.createCell(iB);
			cell.setCellValue("B");
			setBold(workbook, cell);
			setComment(cell, "Delivered bugs");
			cell = row.createCell(iT);
			cell.setCellValue("T");
			setBold(workbook, cell);
			setComment(cell, "Time to program (sec)");

			List<HalsteadAnalysis> classesData = report.getActorClassesAnalysis();
			for (HalsteadAnalysis classData : classesData) {
				cRow++;
				row = worksheet.createRow(cRow);
				cell = row.createCell(iClass);
				cell.setCellValue(classData.blockName());
				setLink(workbook, cell, "'Class(" + classesData.indexOf(classData) + ")'!A1", HyperlinkType.DOCUMENT);
				row.createCell(iNOL).setCellValue(classData.NoL());
				row.createCell(in).setCellValue(classData.n());
				row.createCell(in1).setCellValue(classData.n1());
				row.createCell(in2).setCellValue(classData.n2());
				row.createCell(iN).setCellValue(classData.N());
				row.createCell(iN1).setCellValue(classData.N1());
				row.createCell(iN2).setCellValue(classData.N2());
				row.createCell(iD).setCellValue(classData.D());
				row.createCell(iV).setCellValue(classData.V());
				row.createCell(iB).setCellValue(classData.B());
				row.createCell(iT).setCellValue(classData.T());
			}
		}

	}

	@Override
	public XSSFWorkbook content(CodeProfilingReport data) {
		HalsteadCodeAnalysis report = new HalsteadCodeAnalysis(data);
		XSSFWorkbook workbook = new XSSFWorkbook();
		writeSummary(workbook, data.getNetwork(), report);
		writeDetails(workbook, report);
		return workbook;
	}

}

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
package turnus.model.analysis.partitioning.io;

import static turnus.common.util.PoiUtils.setBold;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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
import turnus.model.analysis.partitioning.ComCostPartition;
import turnus.model.analysis.partitioning.ComCostPartitioningReport;
import turnus.model.dataflow.Actor;

/**
 * 
 * @author @author Simone Casale Brunet
 *
 */
public class Pcomm2XlsExporter implements FileExporter<ComCostPartitioningReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		ComCostPartitioningReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(ComCostPartitioningReport report, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		XSSFWorkbook workbook = new XSSFWorkbook();
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

	private void writeSummary(XSSFWorkbook workbook, ComCostPartitioningReport report) {
		XSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		XSSFRow row = worksheet.createRow(cRow);
		XSSFCell cell = row.createCell(0);
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

		// row 3: Units | number
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Units");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue(report.getPartitions().size());

		// first table with costs
		cRow = 4;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Partition");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue("Internal cost");
		setBold(workbook, cell);
		cell = row.createCell(2);
		cell.setCellValue("External cost");
		setBold(workbook, cell);

		List<ComCostPartition> partitions = report.getPartitions();
		for (ComCostPartition partition : partitions) {
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue(partitions.indexOf(partition) + 1);
			cell = row.createCell(0);
			cell.setCellValue(partition.getInternalCost());
			cell.setCellValue(partition.getExternalCost());
		}

		// second table with actors
		cRow += 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Partition");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue("Actor");
		setBold(workbook, cell);
		cell = row.createCell(2);
		cell.setCellValue("Internal cost");
		setBold(workbook, cell);
		cell = row.createCell(2);
		cell.setCellValue("Exteral cost");
		setBold(workbook, cell);

		cRow++;
		for (ComCostPartition partition : partitions) {
			int startRow = cRow;
			for (Actor actor : partition.getActors()) {
				row = worksheet.createRow(cRow);
				if (cRow == startRow) {
					row.createCell(0).setCellValue(partitions.indexOf(partition) + 1);
				}
				row.createCell(1).setCellValue(actor.getName());
				row.createCell(2).setCellValue(partition.getInternalCostMap().get(actor));
				row.createCell(3).setCellValue(partition.getExternalCostMap().get(actor));
				cRow++;
			}
			worksheet.addMergedRegion(new CellRangeAddress(startRow, cRow - 1, 0, 0));
		}

	}

}

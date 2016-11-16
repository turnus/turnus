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

import static turnus.model.common.StatisticalData.Util.sum;
import static turnus.common.util.PoiUtils.setBold;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;
import turnus.model.dataflow.Buffer;

/**
 * This class defines an XLS exporter for the {@link DynamicProfilingReport}
 * 
 * @author Simone Casale Brunet
 *
 */
public class Dprof2XlsExporter implements FileExporter<DynamicProfilingReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		DynamicProfilingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid DPROF file");
		}
		export(data, output);

	}

	@Override
	public void export(DynamicProfilingReport data, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		writeActorsSummary(workbook, data.getActorsData());
		writeBuffersSummary(workbook, data.getBuffersData());

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

	private void writeBuffersSummary(HSSFWorkbook workbook, List<BufferDynamicData> buffersData) {
		HSSFSheet worksheet = workbook.createSheet("Buffers summary");

		// row 0: title
		int cRow = 0;
		HSSFRow row = worksheet.createRow(cRow);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Buffer utilisation");
		setBold(workbook, cell, (short) 14);

		// row 1: source | target | reads | writes | occupancy
		cRow = 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Source");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 0, 1));
		cell = row.createCell(2);
		cell.setCellValue("Target");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 2, 3));
		cell = row.createCell(4);
		cell.setCellValue("Reads");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 4, 7));
		cell = row.createCell(8);
		cell.setCellValue("Writes");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 8, 11));
		cell = row.createCell(12);
		cell.setCellValue("Occupancy");
		setBold(workbook, cell);
		worksheet.addMergedRegion(new CellRangeAddress(cRow, cRow, 12, 15));

		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Actor");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue("Port");
		setBold(workbook, cell);
		cell = row.createCell(2);
		cell.setCellValue("Actor");
		setBold(workbook, cell);
		cell = row.createCell(3);
		cell.setCellValue("Port");
		setBold(workbook, cell);
		cell = row.createCell(4);
		cell.setCellValue("Mean");
		setBold(workbook, cell);
		cell = row.createCell(5);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(6);
		cell.setCellValue("Max");
		setBold(workbook, cell);
		cell = row.createCell(7);
		cell.setCellValue("Sum");
		setBold(workbook, cell);
		cell = row.createCell(8);
		cell.setCellValue("Mean");
		setBold(workbook, cell);
		cell = row.createCell(9);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(10);
		cell.setCellValue("Max");
		setBold(workbook, cell);
		cell = row.createCell(11);
		cell.setCellValue("Sum");
		setBold(workbook, cell);
		cell = row.createCell(12);
		cell.setCellValue("Mean");
		setBold(workbook, cell);
		cell = row.createCell(13);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(14);
		cell.setCellValue("Max");
		setBold(workbook, cell);
		cell = row.createCell(15);
		cell.setCellValue("Sum");
		setBold(workbook, cell);

		for (BufferDynamicData bData : buffersData) {
			Buffer b = bData.getBuffer();
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue(b.getSource().getOwner().getName());
			row.createCell(1).setCellValue(b.getSource().getName());
			row.createCell(2).setCellValue(b.getTarget().getOwner().getName());
			row.createCell(3).setCellValue(b.getTarget().getName());

			// reads
			StatisticalData s = bData.getReads();
			row.createCell(4).setCellValue(s.getMean());
			row.createCell(5).setCellValue(s.getMin());
			row.createCell(6).setCellValue(s.getMax());
			row.createCell(7).setCellValue(s.getSum());

			// writes
			s = bData.getWrites();
			row.createCell(8).setCellValue(s.getMean());
			row.createCell(9).setCellValue(s.getMin());
			row.createCell(10).setCellValue(s.getMax());
			row.createCell(11).setCellValue(s.getSum());

			// occupancy
			s = bData.getOccupancy();
			row.createCell(12).setCellValue(s.getMean());
			row.createCell(13).setCellValue(s.getMin());
			row.createCell(14).setCellValue(s.getMax());
			row.createCell(15).setCellValue(s.getSum());
		}

	}

	private void writeActorsSummary(HSSFWorkbook workbook, List<ActorDynamicData> actorsData) {
		HSSFSheet worksheet = workbook.createSheet("Actors Summary");

		// row 0: title
		int cRow = 0;
		HSSFRow row = worksheet.createRow(cRow);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Actors and actions operator calls");
		setBold(workbook, cell, (short) 14);

		cRow++;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Actor");
		setBold(workbook, cell);
		cell = row.createCell(1);
		cell.setCellValue("Operator");
		setBold(workbook, cell);
		cell = row.createCell(2);
		cell.setCellValue("Mean");
		setBold(workbook, cell);
		cell = row.createCell(3);
		cell.setCellValue("Min");
		setBold(workbook, cell);
		cell = row.createCell(4);
		cell.setCellValue("Max");
		setBold(workbook, cell);
		cell = row.createCell(5);
		cell.setCellValue("Sum");
		setBold(workbook, cell);
		// row 1: actor | operator | values

		for (ActorDynamicData aData : actorsData) {
			cRow++;
			row = worksheet.createRow(cRow);

			int initialRow = cRow;
			Map<EOperator, StatisticalData> opsMap = aData.getOperandsCalls();
			StatisticalData s = sum(opsMap.values());
			row.createCell(0).setCellValue(aData.getActor().getName());
			row.createCell(2).setCellValue(s.getMean());
			row.createCell(3).setCellValue(s.getMin());
			row.createCell(4).setCellValue(s.getMax());
			row.createCell(5).setCellValue(s.getSum());

			// operands details
			for (Entry<EOperator, StatisticalData> e : opsMap.entrySet()) {
				s = e.getValue();

				cRow++;
				row = worksheet.createRow(cRow);
				row.createCell(1).setCellValue(e.getKey().getLiteral());
				row.createCell(2).setCellValue(s.getMean());
				row.createCell(3).setCellValue(s.getMin());
				row.createCell(4).setCellValue(s.getMax());
				row.createCell(5).setCellValue(s.getSum());
			}
			worksheet.groupRow(initialRow + 1, cRow);
			worksheet.setRowGroupCollapsed(initialRow + 1, true);
		}

	}

}

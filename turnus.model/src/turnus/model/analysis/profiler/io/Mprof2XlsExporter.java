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

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.DateUtil;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiler.AccessData;
import turnus.model.analysis.profiler.ActionMemoryProfilingData;
import turnus.model.analysis.profiler.BufferAccessData;
import turnus.model.analysis.profiler.LocalVariableAccessData;
import turnus.model.analysis.profiler.MemoryAccessData;
import turnus.model.analysis.profiler.MemoryProfilingReport;
import turnus.model.analysis.profiler.SharedVariableAccessData;
import turnus.model.analysis.profiler.StateVariableAccessData;

public class Mprof2XlsExporter implements FileExporter<MemoryProfilingReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		MemoryProfilingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid MPROF file");
		}
		export(data, output);

	}

	@Override
	public void export(MemoryProfilingReport report, File output) throws TurnusException {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(output);
		} catch (Exception e) {
			throw new TurnusException("The output file \"" + output + "\" cannot be generated");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();

		List<ActionMemoryProfilingData> actionsData = new ArrayList<>(report.getActionsData());
		Collections.sort(actionsData, new Comparator<ActionMemoryProfilingData>() {
			@Override
			public int compare(ActionMemoryProfilingData o1, ActionMemoryProfilingData o2) {
				String s1 = o1.getActor();
				String s2 = o1.getActor();
				int result = s1.compareTo(s2);
				if (result != 0) {
					return result;
				}
				s1 = o1.getAction();
				s2 = o2.getAction();
				return s1.compareTo(s2);
			}
		});
		writeSummary(workbook, report.getAlgorithm(), report.getNetworkName(), report.getDate(), actionsData);
		writeSharedVariables(workbook, actionsData);
		writeStateVariables(workbook, actionsData);
		writeLocalVariables(workbook, actionsData);
		writeBuffers(workbook, actionsData);
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

	private void writeBuffers(HSSFWorkbook workbook, List<ActionMemoryProfilingData> actionsData) {
		HSSFSheet worksheet = workbook.createSheet("Buffers");
		int cRow = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		for (ActionMemoryProfilingData data : actionsData) {
			// row 0: title
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell, (short) 12);
			row.createCell(1).setCellValue(data.getActor());
			row.createCell(2).setCellValue(data.getAction());
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Source Port");
			row.createCell(1).setCellValue("Source Actor");
			row.createCell(2).setCellValue("Target Port");
			row.createCell(3).setCellValue("Target Actor");
			row.createCell(4).setCellValue("Direction");
			row.createCell(5).setCellValue("Memory");
			row.createCell(6).setCellValue("Accesses");
			row.createCell(7).setCellValue("Total");
			row.createCell(8).setCellValue("Average");
			row.createCell(9).setCellValue("Min");
			row.createCell(10).setCellValue("Max");
			for (MemoryAccessData d : data.getReads()) {
				if (d instanceof BufferAccessData) {
					BufferAccessData bd = (BufferAccessData) d;
					for (Entry<String, AccessData> e : bd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(bd.getSourceActor());
						row.createCell(1).setCellValue(bd.getSourcePort());
						row.createCell(2).setCellValue(bd.getTargetActor());
						row.createCell(3).setCellValue(bd.getTargetPort());
						row.createCell(4).setCellValue("READ");
						row.createCell(5).setCellValue(e.getKey());
						row.createCell(6).setCellValue(e.getValue().getAccesses());
						row.createCell(7).setCellValue(e.getValue().getTotal());
						row.createCell(8).setCellValue(e.getValue().getAverage());
						row.createCell(9).setCellValue(e.getValue().getMin());
						row.createCell(10).setCellValue(e.getValue().getMax());
					}
				}
			}
			for (MemoryAccessData d : data.getWrites()) {
				if (d instanceof BufferAccessData) {
					BufferAccessData bd = (BufferAccessData) d;
					for (Entry<String, AccessData> e : bd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(bd.getSourceActor());
						row.createCell(1).setCellValue(bd.getSourcePort());
						row.createCell(2).setCellValue(bd.getTargetActor());
						row.createCell(3).setCellValue(bd.getTargetPort());
						row.createCell(4).setCellValue("WRITE");
						row.createCell(5).setCellValue(e.getKey());
						row.createCell(6).setCellValue(e.getValue().getAccesses());
						row.createCell(7).setCellValue(e.getValue().getTotal());
						row.createCell(8).setCellValue(e.getValue().getAverage());
						row.createCell(9).setCellValue(e.getValue().getMin());
						row.createCell(10).setCellValue(e.getValue().getMax());
					}
				}
			}
		}

	}

	private void writeLocalVariables(HSSFWorkbook workbook, List<ActionMemoryProfilingData> actionsData) {
		HSSFSheet worksheet = workbook.createSheet("Local Variables");
		int cRow = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		for (ActionMemoryProfilingData data : actionsData) {
			// row 0: title
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell, (short) 12);
			row.createCell(1).setCellValue(data.getActor());
			row.createCell(2).setCellValue(data.getAction());
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Variable");
			row.createCell(1).setCellValue("Direction");
			row.createCell(2).setCellValue("Memory");
			row.createCell(3).setCellValue("Accesses");
			row.createCell(4).setCellValue("Total");
			row.createCell(5).setCellValue("Average");
			row.createCell(6).setCellValue("Min");
			row.createCell(7).setCellValue("Max");
			for (MemoryAccessData d : data.getReads()) {
				if (d instanceof LocalVariableAccessData) {
					LocalVariableAccessData vd = (LocalVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("READ");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
			for (MemoryAccessData d : data.getWrites()) {
				if (d instanceof LocalVariableAccessData) {
					LocalVariableAccessData vd = (LocalVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("WRITE");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
		}

	}

	private void writeStateVariables(HSSFWorkbook workbook, List<ActionMemoryProfilingData> actionsData) {
		HSSFSheet worksheet = workbook.createSheet("State Variables");
		int cRow = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		for (ActionMemoryProfilingData data : actionsData) {
			// row 0: title
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell, (short) 12);
			row.createCell(1).setCellValue(data.getActor());
			row.createCell(2).setCellValue(data.getAction());
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Variable");
			row.createCell(1).setCellValue("Direction");
			row.createCell(2).setCellValue("Memory");
			row.createCell(3).setCellValue("Accesses");
			row.createCell(4).setCellValue("Total");
			row.createCell(5).setCellValue("Average");
			row.createCell(6).setCellValue("Min");
			row.createCell(7).setCellValue("Max");
			for (MemoryAccessData d : data.getReads()) {
				if (d instanceof StateVariableAccessData) {
					StateVariableAccessData vd = (StateVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("READ");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
			for (MemoryAccessData d : data.getWrites()) {
				if (d instanceof StateVariableAccessData) {
					StateVariableAccessData vd = (StateVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("WRITE");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
		}

	}

	private void writeSharedVariables(HSSFWorkbook workbook, List<ActionMemoryProfilingData> actionsData) {
		HSSFSheet worksheet = workbook.createSheet("Shared Variables");
		int cRow = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		for (ActionMemoryProfilingData data : actionsData) {
			// row 0: title
			cRow++;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell, (short) 12);
			row.createCell(1).setCellValue(data.getActor());
			row.createCell(2).setCellValue(data.getAction());
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Variable");
			row.createCell(1).setCellValue("Direction");
			row.createCell(2).setCellValue("Memory");
			row.createCell(3).setCellValue("Accesses");
			row.createCell(4).setCellValue("Total");
			row.createCell(5).setCellValue("Average");
			row.createCell(6).setCellValue("Min");
			row.createCell(7).setCellValue("Max");
			for (MemoryAccessData d : data.getReads()) {
				if (d instanceof SharedVariableAccessData) {
					SharedVariableAccessData vd = (SharedVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("READ");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
			for (MemoryAccessData d : data.getWrites()) {
				if (d instanceof SharedVariableAccessData) {
					SharedVariableAccessData vd = (SharedVariableAccessData) d;
					for (Entry<String, AccessData> e : vd.getAccessesData().entrySet()) {
						cRow++;
						row = worksheet.createRow(cRow);
						row.createCell(0).setCellValue(vd.getName());
						row.createCell(1).setCellValue("WRITE");
						row.createCell(2).setCellValue(e.getKey());
						row.createCell(3).setCellValue(e.getValue().getAccesses());
						row.createCell(4).setCellValue(e.getValue().getTotal());
						row.createCell(5).setCellValue(e.getValue().getAverage());
						row.createCell(6).setCellValue(e.getValue().getMin());
						row.createCell(7).setCellValue(e.getValue().getMax());
					}
				}
			}
		}

	}

	private void writeSummary(HSSFWorkbook workbook, String algo, String network, Date date,
			List<ActionMemoryProfilingData> actionsData) {
		HSSFSheet worksheet = workbook.createSheet("Summary");

		// row 0: title
		int cRow = 0;
		HSSFRow row = worksheet.createRow(cRow);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Memory Profiling report");
		setBold(workbook, cell, (short) 14);

		// row 1: Network
		cRow = 1;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Network");
		setBold(workbook, cell, (short) 12);
		row.createCell(1).setCellValue(network);

		// row 2: Algorithm
		cRow = 2;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Algorithm");
		setBold(workbook, cell, (short) 12);
		row.createCell(1).setCellValue(algo);

		// row 3: date
		cRow = 3;
		row = worksheet.createRow(cRow);
		cell = row.createCell(0);
		cell.setCellValue("Date");
		setBold(workbook, cell, (short) 12);
		row.createCell(1).setCellValue(DateUtil.asString(date));

		// for each action sum the read and write access
		for (ActionMemoryProfilingData data : actionsData) {
			double readAccesses = 0;
			double readTotal = 0;
			double readMin = Double.MAX_VALUE;
			double readMax = 0;
			double writeAccesses = 0;
			double writeTotal = 0;
			double writeMin = Double.MAX_VALUE;
			double writeMax = 0;
			for (MemoryAccessData d : data.getReads()) {
				for (AccessData accesses : d.getAccessesData().values()) {
					readAccesses += accesses.getAccesses();
					readTotal += accesses.getTotal();
					readMin = Math.min(readMin, accesses.getMin());
					readMax = Math.max(readMax, accesses.getMax());
				}
			}

			if (readAccesses == 0) {
				readMin = 0;
			}

			for (MemoryAccessData d : data.getWrites()) {
				for (AccessData accesses : d.getAccessesData().values()) {
					writeAccesses += accesses.getAccesses();
					writeTotal += accesses.getTotal();
					writeMin = Math.min(writeMin, accesses.getMin());
					writeMax = Math.max(writeMax, accesses.getMax());
				}
			}

			if (writeAccesses == 0) {
				writeMin = 0;
			}

			cRow += 2;
			row = worksheet.createRow(cRow);
			cell = row.createCell(0);
			cell.setCellValue("Action");
			setBold(workbook, cell, (short) 12);
			row.createCell(1).setCellValue(data.getActor());
			row.createCell(2).setCellValue(data.getAction());
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(1).setCellValue("Accesses");
			row.createCell(2).setCellValue("Total");
			row.createCell(3).setCellValue("Average");
			row.createCell(4).setCellValue("Min");
			row.createCell(5).setCellValue("Max");
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Read");
			row.createCell(1).setCellValue(readAccesses);
			row.createCell(2).setCellValue(readTotal);
			row.createCell(3).setCellValue(readAccesses != 0 ? readTotal / readAccesses : 0);
			row.createCell(4).setCellValue(readMin);
			row.createCell(5).setCellValue(readMax);
			cRow++;
			row = worksheet.createRow(cRow);
			row.createCell(0).setCellValue("Write");
			row.createCell(1).setCellValue(writeAccesses);
			row.createCell(2).setCellValue(writeTotal);
			row.createCell(3).setCellValue(writeAccesses != 0 ? writeTotal / writeAccesses : 0);
			row.createCell(4).setCellValue(writeMin);
			row.createCell(5).setCellValue(writeMax);
		}

	}

}

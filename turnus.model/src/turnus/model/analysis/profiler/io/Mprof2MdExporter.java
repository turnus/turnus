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

import static turnus.common.util.StringUtils.format;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiler.AccessData;
import turnus.model.analysis.profiler.ActionMemoryProfilingData;
import turnus.model.analysis.profiler.BufferAccessData;
import turnus.model.analysis.profiler.LocalVariableAccessData;
import turnus.model.analysis.profiler.MemoryAccessData;
import turnus.model.analysis.profiler.MemoryProfilingReport;
import turnus.model.analysis.profiler.SharedVariableAccessData;
import turnus.model.analysis.profiler.StateVariableAccessData;

public class Mprof2MdExporter implements FileExporter<MemoryProfilingReport> {

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
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Memory profiling analysis report\n");
			b.append(String.format("* **Network**: %s\n", report.getNetworkName()));
			b.append(String.format("* **Algorithm**: %s\n", report.getAlgorithm()));

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

			for (ActionMemoryProfilingData data : actionsData) {
				b.append(String.format("## %s : %s \n", data.getActor(), data.getAction()));

				List<SharedVariableAccessData> shvars = new ArrayList<>();
				List<LocalVariableAccessData> lvars = new ArrayList<>();
				List<StateVariableAccessData> svars = new ArrayList<>();
				List<BufferAccessData> buffs = new ArrayList<>();

				// get the reads
				for (MemoryAccessData memoryData : data.getReads()) {
					if (memoryData instanceof SharedVariableAccessData) {
						shvars.add((SharedVariableAccessData) memoryData);
					} else if (memoryData instanceof LocalVariableAccessData) {
						lvars.add((LocalVariableAccessData) memoryData);
					} else if (memoryData instanceof StateVariableAccessData) {
						svars.add((StateVariableAccessData) memoryData);
					} else if (memoryData instanceof BufferAccessData) {
						buffs.add((BufferAccessData) memoryData);
					} else {
						Logger.debug("Memory data %s not recognized", memoryData);
					}
				}

				// print the reads
				b.append("### Reads \n");
				b.append(printTables(shvars, lvars, svars, buffs));

				// get the writes
				shvars.clear();
				lvars.clear();
				svars.clear();
				buffs.clear();
				for (MemoryAccessData memoryData : data.getWrites()) {
					if (memoryData instanceof SharedVariableAccessData) {
						shvars.add((SharedVariableAccessData) memoryData);
					} else if (memoryData instanceof LocalVariableAccessData) {
						lvars.add((LocalVariableAccessData) memoryData);
					} else if (memoryData instanceof StateVariableAccessData) {
						svars.add((StateVariableAccessData) memoryData);
					} else if (memoryData instanceof BufferAccessData) {
						buffs.add((BufferAccessData) memoryData);
					} else {
						Logger.debug("Memory data %s not recognized", memoryData);
					}
				}

				// print the writes
				b.append("### Writes \n");
				b.append(printTables(shvars, lvars, svars, buffs));
			}

			b.append("\n");

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	private String printTables(List<SharedVariableAccessData> shvars, List<LocalVariableAccessData> lvars,
			List<StateVariableAccessData> svars, List<BufferAccessData> buffs) {
		StringBuffer b = new StringBuffer();
		b.append("#### Shared Variables \n");
		if (shvars.isEmpty()) {
			b.append(" \n");
		} else {
			b.append("| Variable | Memory | Accesses | Total | Mean | Min | Max\n");
			b.append("|:---------|:-------|:---------|:------|:-----|:----|:---\n");
			for (SharedVariableAccessData d : shvars) {
				// used to print only the first time the variable name
				boolean first = true;
				for (Entry<String, AccessData> e : d.getAccessesData().entrySet()) {
					String var = first ? d.getName() : " ";
					first = false;
					String acceses = format(e.getValue().getAccesses());
					String memory = e.getKey();
					String mean = format(e.getValue().getAverage());
					String min = format(e.getValue().getMin());
					String max = format(e.getValue().getMax());
					String total = format(e.getValue().getTotal());
					b.append(String.format("| %s | %s | %s | %s | %s | %s | %s\n", var, memory, acceses, total, mean, min,
							max));
				}
			}
			b.append("\n");
		}

		b.append("#### State Variables \n");
		if (svars.isEmpty()) {
			b.append(" \n");
		} else {
			b.append("| Variable | Memory | Accesses | Total | Mean | Min | Max\n");
			b.append("|:---------|:-------|:---------|:------|:-----|:----|:---\n");
			for (StateVariableAccessData d : svars) {
				// used to print only the first time the variable name
				boolean first = true;
				for (Entry<String, AccessData> e : d.getAccessesData().entrySet()) {
					String var = first ? d.getName() : " ";
					first = false;
					String acceses = format(e.getValue().getAccesses());
					String memory = e.getKey();
					String mean = format(e.getValue().getAverage());
					String min = format(e.getValue().getMin());
					String max = format(e.getValue().getMax());
					String total = format(e.getValue().getTotal());
					b.append(String.format("| %s | %s | %s | %s | %s | %s | %s\n", var, memory, acceses, total, mean, min,
							max));
				}
			}
			b.append("\n");
		}

		b.append("#### Local Variables \n");
		if (lvars.isEmpty()) {
			b.append(" \n");
		} else {
			b.append("| Variable | Memory | Accesses | Total | Mean | Min | Max\n");
			b.append("|:---------|:-------|:---------|:------|:-----|:----|:---\n");
			for (LocalVariableAccessData d : lvars) {
				// used to print only the first time the variable name
				boolean first = true;
				for (Entry<String, AccessData> e : d.getAccessesData().entrySet()) {
					String var = first ? d.getName() : " ";
					first = false;
					String acceses = format(e.getValue().getAccesses());
					String memory = e.getKey();
					String mean = format(e.getValue().getAverage());
					String min = format(e.getValue().getMin());
					String max = format(e.getValue().getMax());
					String total = format(e.getValue().getTotal());
					b.append(String.format("| %s | %s | %s | %s | %s | %s | %s\n", var, memory, acceses, total, mean, min,
							max));
				}
			}
			b.append("\n");
		}

		b.append("#### Buffers \n");
		if (buffs.isEmpty()) {
			b.append(" \n");
		} else {
			b.append(
					"| Source Actor | Source Port | Target Actor | Target Port | Memory | Accesses | Total | Mean | Min | Max\n");
			b.append("|:---|:---|:---|:---|:---|:---|:---|:---|:---|:---\n");
			for (BufferAccessData d : buffs) {
				// used to print only the first time the variable name
				boolean first = true;
				for (Entry<String, AccessData> e : d.getAccessesData().entrySet()) {
					String sActor = first ? d.getSourceActor() : " ";
					String sPort = first ? d.getSourcePort() : " ";
					String tActor = first ? d.getTargetActor() : " ";
					String tPort = first ? d.getTargetPort() : " ";
					first = false;
					String acceses = format(e.getValue().getAccesses());
					String memory = e.getKey();
					String mean = format(e.getValue().getAverage());
					String min = format(e.getValue().getMin());
					String max = format(e.getValue().getMax());
					String total = format(e.getValue().getTotal());
					b.append(String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s | %s\n", sActor, sPort, tActor,
							tPort, memory, acceses, total, mean, min, max));
				}
			}
			b.append("\n");
		}

		b.append("\n");
		return b.toString();
	}

}

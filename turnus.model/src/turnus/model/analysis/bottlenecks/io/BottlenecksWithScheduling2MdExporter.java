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

import static turnus.common.util.StringUtils.format;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class BottlenecksWithScheduling2MdExporter implements FileExporter<BottlenecksWithSchedulingReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		BottlenecksWithSchedulingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(BottlenecksWithSchedulingReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Scheduled Bottlenecks analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
			b.append("\n");

			double time = data.getExecutionTime();
			double netcpWeights = data.getCpWeight();
			double netWeight = data.getTotalWeight();
			long netCpFirings = data.getCpFirings();
			long netFirings = data.getTotalFirings();
			double blocking = data.getCpBlockingTime();
			double cpFiringsPerc = ((double) netCpFirings) / netFirings * 100.0;
			double cpWeightPerc = ((double) netcpWeights) / netWeight * 100.0;

			b.append("\n| Overall ||| Critical Path |||||| ");
			b.append("\n| Execution | Workload | Firings | Workload || Blocking | Firings||");
			b.append("\n|---|---|---|---|---|---|---");
			b.append(String.format("\n| %s | %s | %d | %s | %s | %s | %d | %s", format(time), format(netWeight), netFirings, format(netcpWeights), format(cpWeightPerc) + "%",format(blocking),netCpFirings,
					format((cpFiringsPerc)) + "%"));
			b.append("\n[Summary]");
			b.append("\n");
			
			b.append("\n| Partition id | CP blocking ||");
			b.append("\n|---|---|");
			for (String s : data.getCpPartitionsBlockingTime().keySet()) {
				//if (data.getCpPartitionsBlockingTime().get(s) != 0)
					b.append(String.format("\n| %s | %s |", s, format(data.getCpPartitionsBlockingTime().get(s))));
			}
			b.append("\n[Partitions blocking time]");
			b.append("\n");

			List<ActionBottlenecksWithSchedulingData> actionsData = new ArrayList<>(data.getActionsData());
			Collections.sort(actionsData, new Comparator<ActionBottlenecksWithSchedulingData>() {

				@Override
				public int compare(ActionBottlenecksWithSchedulingData o1, ActionBottlenecksWithSchedulingData o2) {
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

			b.append("\n|   || Overall |||| Critical Path ||||| ");
			b.append("\n| Actor | Action | Firings || Weight || Firings || Weight ||");
			b.append("\n|---|---|---|---|---|---|---|---|---|---");

			for (ActionBottlenecksWithSchedulingData adata : actionsData) {
				double cpWeights = adata.getCpWeight();
				double totalWeight = adata.getTotalWeight();
				long cpFirings = adata.getCpFirings();
				long totalFirings = adata.getTotalFirings();
				double totalFiringsPerc = ((double) totalFirings) / netFirings * 100.0;
				double totalWeightPerc = ((double) totalWeight) / netWeight * 100.0;
				cpFiringsPerc = ((double) cpFirings) / netCpFirings * 100.0;
				cpWeightPerc = ((double) cpWeights) / netcpWeights * 100.0;

				String actor = adata.getAction().getOwner().getName();
				String action = adata.getAction().getName();

				b.append(String.format("\n|%s | %s | %d | %s | %s | %s | %d | %s | %s | %s ", actor, action,
						totalFirings, format(totalFiringsPerc) + "%", format(totalWeight),
						format(totalWeightPerc) + "%", cpFirings, format((cpFirings)), format(cpWeights),
						format(cpWeightPerc) + "%"));

			}
			b.append("\n[Actions detail]");
			b.append("\n");

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

}

/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 Endri Bezati
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.partitioning.WorkloadBalancePartition;
import turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport;
import turnus.model.analysis.profiling.util.MemoryUsage;
import turnus.model.dataflow.Actor;

/**
 * The {@link WorkloadBalancePartitioningReport} MD file exporter
 * 
 * @author Endri Bezati
 *
 */
public class WorkloadBalancePartition2MdExporter implements FileExporter<WorkloadBalancePartitioningReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		WorkloadBalancePartitioningReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(WorkloadBalancePartitioningReport data, File output) throws TurnusException {

		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Workload Balance partitioning analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Scheduling Policy**: %s\n", data.getSchedulinPolicy().getName()));
			b.append(String.format("* **Units**: %d\n", data.getPartitions().size()));
			b.append("\n");

			int pNumber = 1;

			b.append(String.format("## Overview\n"));
			b.append("| **Partition**  | **Actors** | **Workload** | **Persistent Memory** |\n");
			b.append("|:--             |  --:       | --:          | --:                   | \n");
			for (WorkloadBalancePartition pdata : data.getPartitions()) {
				long persistenMemory = MemoryUsage.getActorsPesistenMemory(pdata.getActors());
				b.append(String.format("| %d |   %d |         %.2f | %s                    \n", pNumber,
						pdata.getActors().size(), pdata.getWorkload(), StringUtils.formatBytes(persistenMemory, true)));
				pNumber++;
			}

			b.append("\n");
			pNumber = 1;
			for (WorkloadBalancePartition pdata : data.getPartitions()) {
				b.append(String.format("## Partition - %d\n", pNumber++));
				b.append(String.format("* **Workload**: %.2f\n", pdata.getWorkload()));
				b.append("\n");
				b.append("| **Actors** | \n");
				b.append("|:--         | \n");
				for (Actor actor : pdata.getActors()) {
					b.append(String.format("| %s | \n", actor.getName()));
				}
			}

			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

}

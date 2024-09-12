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

import java.io.File;
import java.io.FileWriter;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.partitioning.ComCostPartition;
import turnus.model.analysis.partitioning.ComCostPartitioningReport;
import turnus.model.dataflow.Actor;

/**
 * The {@link ComCostPartitioningReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class Pcomm2MdExporter implements FileExporter<ComCostPartitioningReport, StringBuffer> {

	
	@Override
	public StringBuffer content(ComCostPartitioningReport data) {
		StringBuffer b = new StringBuffer();
		b.append("# Communication cost partitioning analysis report\n");
		b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
		b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
		b.append(String.format("* **Bit accurate**: %s\n", data.isBitAccurate()));
		b.append(String.format("* **Units**: %d\n", data.getPartitions().size()));

		b.append("\n");
		b.append("| partition || internal cost | external cost\n");
		b.append("|:----|:----|:----|:----\n");
		int partition = 1;
		for (ComCostPartition pdata : data.getPartitions()) {
			String component = "p" + (partition++);
			long totI = pdata.getInternalCost();
			long totE = pdata.getExternalCost();
			b.append(String.format("|  **%s**  | **actors** | %d | %d\n", component, totI, totE));
			for (Actor actor : pdata.getActors()) {
				double ip = ((double) pdata.getInternalCostMap().get(actor) / totI) * 100;
				String ips = StringUtils.format(ip) + "%";
				double ep = ((double) pdata.getExternalCostMap().get(actor) / totE) * 100;
				String eps = StringUtils.format(ep) + "%";
				b.append(String.format("| | %s | %s | %s\n", actor.getName(), ips, eps));
			}
		}
		// b.append("[Partitioning configuration]\n");
		b.append("\n");
		return b;
	}
	
	@Override
	public void export(ComCostPartitioningReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = content(data);
			
			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ComCostPartitioningReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

}

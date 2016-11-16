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
package turnus.model.analysis.pipelining.io;

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
import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;

/**
 * The {@link ActionsVariablePipeliningReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 *
 */
public class Varpipe2MdExporter implements FileExporter<ActionsVariablePipeliningReport> {

	@Override
	public void export(ActionsVariablePipeliningReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Pipelining with variable utilization analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithm**: %s\n", data.getAlgorithm()));

			b.append("\n");
			b.append("|       |        |             | consecutive firings ||| pipelinable firings |||\n");
			b.append("| Actor | Action | pipelinable | average | min | max   | average | min | max \n");
			b.append("|:----|:----|:----|:----|:----|:----|:----|:----|:----\n");

			List<ActionVariablePipeliningData> actionsData = new ArrayList<>(data.getActionsData());

			Collections.sort(actionsData, new Comparator<ActionVariablePipeliningData>() {
				@Override
				public int compare(ActionVariablePipeliningData o1, ActionVariablePipeliningData o2) {
					boolean p1 = o1.isPipelinable();
					boolean p2 = o2.isPipelinable();
					if (p1 != p2) {
						return -Boolean.compare(p1, p2);
					}

					double d1 = o1.getPipelinableFirings().getMin();
					double d2 = o2.getPipelinableFirings().getMin();
					int result = -Double.compare(d1, d2);
					if (result != 0) {
						return result;
					}

					d1 = o1.getPipelinableFirings().getMean();
					d2 = o2.getPipelinableFirings().getMean();
					result = -Double.compare(d1, d2);
					if (result != 0) {
						return result;
					}

					d1 = o1.getPipelinableFirings().getMax();
					d2 = o2.getPipelinableFirings().getMax();
					result = -Double.compare(d1, d2);
					if (result != 0) {
						return result;
					}

					String v1 = o1.getAction().getOwner().getName();
					String v2 = o1.getAction().getOwner().getName();
					if (v1.equals(v2)) {
						v1 = o1.getAction().getName();
						v2 = o2.getAction().getName();
					}
					return v1.compareTo(v2);
				}
			});

			for (ActionVariablePipeliningData adata : actionsData) {
				String actor = adata.getAction().getOwner().getName();
				String action = adata.getAction().getName();
				String pipelinable = Boolean.toString(adata.isPipelinable());
				String fMean = format(adata.getConsecutiveFirings().getMean());
				String fMin = format(adata.getConsecutiveFirings().getMin());
				String fMax = format(adata.getConsecutiveFirings().getMax());
				String pMean = format(adata.getPipelinableFirings().getMean());
				String pMin = format(adata.getPipelinableFirings().getMin());
				String pMax = format(adata.getPipelinableFirings().getMax());
				b.append(String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s\n", actor, action, pipelinable,
						fMean, fMin, fMax, pMean, pMin, pMax));

			}
			// b.append("[Results]\n");
			b.append("\n");

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ActionsVariablePipeliningReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

}

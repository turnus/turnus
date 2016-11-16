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

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.dataflow.Action;

/**
 * The {@link ImpactAnalysisReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 *
 */
public class Impact2MdExporter implements FileExporter<ImpactAnalysisReport> {

	@Override
	public void export(ImpactAnalysisReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			boolean classLevel = data.isClassLevel();

			b.append("# Impact analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Class-level**: %s\n", classLevel));
			b.append("\n");

			List<ImpactAnalysisData> idata = new ArrayList<>(data.getImpactData());
			Collections.sort(idata, new Comparator<ImpactAnalysisData>() {
				@Override
				public int compare(ImpactAnalysisData o1, ImpactAnalysisData o2) {
					double v1 = 0;
					double v2 = 0;

					for (Double e : o1.getCpReductionMap().values()) {
						v1 = Math.max(v1, e);
					}

					for (Double e : o2.getCpReductionMap().values()) {
						v2 = Math.max(v2, e);
					}

					return -Double.compare(v1, v2);
				}
			});

			for (ImpactAnalysisData i : idata) {
				b.append("\n## Impact analysis number ").append(idata.indexOf(i) + 1);
				if (classLevel) {
					b.append("\n* **Actor class:** ").append(i.getActorClass().getName());
					b.append("\n* **Actions:** ");
					for (Action action : i.getActions()) {
						b.append(" (").append(action.getOwner().getName()).append(",");
						b.append(action.getName()).append(")");
					}
				} else {
					Action action = i.getActions().get(0);
					b.append("\n**Action:** ");
					b.append(" (").append(action.getOwner().getName()).append(",");
					b.append(action.getName()).append(")");
				}

				b.append("\n\n| Weight-reduction | CriticalPath-reduction \n");
				b.append("|:----|:----\n");

				Map<Double, Double> map = i.getCpReductionMap();
				List<Double> ratios = new ArrayList<>(map.keySet());
				Collections.sort(ratios);
				for (double ratio : ratios) {
					String reductionStr = StringUtils.format(map.get(ratio));
					String ratioStr = StringUtils.format(ratio);
					b.append(String.format("| %s | %s |\n", ratioStr, reductionStr));
				}
				b.append("[the weight reduction and the corresponding critical path length reduction]\n");
			}

			
			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ImpactAnalysisReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

}

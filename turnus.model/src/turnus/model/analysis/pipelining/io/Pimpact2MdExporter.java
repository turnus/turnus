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

import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.common.collect.Sets;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;
import turnus.model.analysis.pipelining.ImpactAnalysisData;
import turnus.model.analysis.pipelining.ImpactAnalysisReport;
import turnus.model.dataflow.Action;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class Pimpact2MdExporter implements FileExporter<ImpactAnalysisReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		ImpactAnalysisReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(ImpactAnalysisReport report, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Pipelining algorithmic impact analysis analysis report\n");
			b.append(String.format("* **Network**: %s\n", report.getNetwork().getName()));
			b.append(String.format("* **Algorithm**: %s\n", report.getAlgorithm()));

			Set<Action> pipelinables = new HashSet<>();
			{
				ActionsVariablePipeliningReport data = report.getPiplenablesActions();
				if (data != null) {
					for (ActionVariablePipeliningData d : data.getActionsData()) {
						if (d.isPipelinable()) {
							pipelinables.add(d.getAction());
						}
					}
				}
			}
			b.append(String.format("* **Pipelinable actions**: %d\n", pipelinables.size()));

			Set<Action> criticalActions = new HashSet<>();
			{
				BottlenecksReport data = report.getInitialBottlenecks();
				if (data != null) {
					for (ActionBottlenecksData d : data.getActionsData()) {
						if (d.getCpWeight() > 0) {
							criticalActions.add(d.getAction());
						}
					}
				}
			}
			b.append(String.format("* **Critical actions**: %d\n", criticalActions.size()));

			Set<Action> pipelinableAndCriticals = Sets.intersection(pipelinables, criticalActions);
			b.append(String.format("* **Pipelinable and Critical actions**: %d\n", pipelinableAndCriticals.size()));

			// and the table
			b.append("\n## Pipelinable and critical actions\n");
			b.append("|Actor | Action|\n");
			b.append("|:---|:---\n");
			for (Action action : pipelinableAndCriticals) {
				b.append(String.format("| %s | %s\n", action.getOwner().getName(), action.getName()));
			}

			b.append("\n");

			if (!pipelinableAndCriticals.isEmpty()) {
				b.append("\n## Crirical path lenght reduction estimation\n");

				b.append("|Actor | Action | Reduction\n");
				b.append("|:---|:---|:---\n");
				for (ImpactAnalysisData data : report.getImpactData()) {
					Action action = data.getActions().get(0);
					b.append(String.format("| %s | %s | %s\n", action.getOwner().getName(), action.getName(),
							StringUtils.format(data.getCpReduction()) + "%"));
				}
				b.append("\n");
			}

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

}

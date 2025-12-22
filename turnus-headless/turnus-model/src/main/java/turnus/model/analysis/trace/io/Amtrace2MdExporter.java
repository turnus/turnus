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
package turnus.model.analysis.trace.io;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

public class Amtrace2MdExporter implements FileExporter<MarkowModelTraceReport, StringBuffer> {

	@Override
	public void export(File input, File output) throws TurnusException {
		MarkowModelTraceReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		export(report, output);

	}

	@Override
	public void export(MarkowModelTraceReport report, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = content(report);

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			throw new TurnusException("Export fails", e);
		}

	}

	@Override
	public StringBuffer content(MarkowModelTraceReport report) {
		Network network = report.getNetwork();
		StringBuffer b = new StringBuffer();
		b.append("# Actions Markov model trace transformation\n");
		b.append("* **Network**: ").append(network.getName()).append("\n\n");

		// print actors static report
		b.append("## Actors model\n");
		b.append("| Actor | static | \n");
		b.append("|-------|--------\n");
		for (Actor actor : network.getActors()) {
			List<MarkovModelActionData> data = report.getData(actor);
			String isStatic = "yes";
			for (MarkovModelActionData d : data) {
				if (d.getSuccessorsMap().isEmpty()) {
					isStatic = "undefined";
					break;
				} else if (d.getSuccessorsMap().size() != 1) {
					isStatic = "no";
					break;
				}
			}
			b.append(String.format("| %s | %s |\n", actor.getName(), isStatic));
		}
		b.append("\n");

		b.append("## Actions data\n");
		for (Actor actor : network.getActors()) {
			List<MarkovModelActionData> data = report.getData(actor);
			b.append(String.format("### Actor \"%s\" \n", actor.getName()));
			for (MarkovModelActionData e : data) {
				String fisrt = e.isFirst() ? "(first to fire)" : "";
				b.append(String.format("#### Action \"%s\" %s\n", e.getAction().getName(), fisrt));
				long successors = e.getSuccessors();
				if (successors > 0) {
					b.append("| Successor | Probability |\n");
					b.append("|-----------|--------------\n");
					for (Entry<Action, Long> succ : e.getSuccessorsMap().entrySet()) {
						double p = ((double) succ.getValue()) / successors;
						b.append(String.format("| %s | %s |\n", succ.getKey().getName(), StringUtils.format(p)));
					}
					b.append("\n");
				} else {
					b.append("No successors\n");
				}

			}
			b.append("\n");
		}
		return b;
	}

}

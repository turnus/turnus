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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.trace.CompressedDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

public class Ctrace2MdExporter implements FileExporter<CompressedTraceReport, StringBuffer> {

	@Override
	public void export(File input, File output) throws TurnusException {
		CompressedTraceReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		export(report, output);

	}

	@Override
	public void export(CompressedTraceReport report, File output) throws TurnusException {
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
	public StringBuffer content(CompressedTraceReport report) {
		StringBuffer b = new StringBuffer();
		b.append("# Compressed execution trace graph analysis report\n");
		b.append("* **Network**: ").append(report.getNetwork().getName()).append("\n");

		b.append("## Adjacency matrix\n");

		List<Action> actions = new ArrayList<>();
		for (Actor actor : report.getNetwork().getActors()) {
			actions.addAll(actor.getActions());
		}
		// sort the actions by their name
		Collections.sort(actions, new Comparator<Action>() {
			@Override
			public int compare(Action o1, Action o2) {
				Actor a1 = o1.getOwner();
				Actor a2 = o2.getOwner();
				if (a1 != a2) {
					return a1.getName().compareTo(a2.getName());
				} else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});

		// create the table definition
		b.append("| ");
		for (Action action : actions) {
			String name = action.getOwner().getName() + "," + action.getName();
			b.append(" | ").append(name);
		}
		b.append("\n");
		for (int i = 0; i < actions.size(); i++) {
			b.append("|:---");
		}
		b.append("\n");

		// populate the matrix
		for (Action action1 : actions) {
			CompressedStep step1 = report.getSteps(action1);

			String name = action1.getOwner().getName() + "," + action1.getName();
			b.append("| **").append(name).append("**");

			for (Action action2 : actions) {
				CompressedStep step2 = report.getSteps(action2);

				// evaluate outgoings step1->step2
				long outgoings = 0;
				for (CompressedDependency out : step1.getOutgoings()) {
					if (out.getTarget() == step2) {
						outgoings += out.getCount();
					}
				}

				b.append(String.format(" | %d", outgoings));

			}
			b.append("| \n");
		}
		b.append("[Edge w->v in the graph is represented as a[w][n]=n, where n is the edge weight]\n");
		b.append("\n");
		return b;
	}

}

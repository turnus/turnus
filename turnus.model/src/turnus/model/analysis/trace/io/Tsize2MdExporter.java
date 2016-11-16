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
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

public class Tsize2MdExporter implements FileExporter<TraceSizeReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		TraceSizeReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		export(report, output);
	}

	@Override
	public void export(TraceSizeReport report, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Execution trace graph size\n");

			b.append("* **Network**: ").append(report.getNetwork().getName()).append("\n");
			b.append("* **Firings**: ").append(report.getFirings()).append("\n");
			b.append("* **Dependencies**: ").append(report.getDependencies()).append("\n");
			b.append("\n");

			b.append("## Dependencies\n");

			b.append("| Kind | Count|| \n");
			b.append("|:---- |:----  |:----\n");
			for (Entry<String, Long> e : report.getDependenciesKinds().entrySet()) {
				double p = ((double) e.getValue()) / report.getDependencies() * 100;
				b.append(String.format("| %s | %d | %s%s\n", e.getKey(), e.getValue(), StringUtils.format(p), "%"));
			}
			b.append("\n");

			b.append("## Actors data\n");
			List<Actor> actors = new ArrayList<>(report.getNetwork().getActors());
			Collections.sort(actors, new Comparator<Actor>() {
				@Override
				public int compare(Actor o1, Actor o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});

			b.append("| Actor | Firings|| Incomings|| Outgoings||\n");
			b.append("|:---- |:----  |:---- |:---- |:---- |:---- |:----\n");
			for (Actor actor : actors) {
				String firings = "0";
				String pFirings = "0%";
				if (report.getActorsFirings().containsKey(actor)) {
					long value = report.getActorsFirings().get(actor);
					firings = Long.toString(value);
					pFirings = StringUtils.format(((double) value) / report.getFirings() * 100.0);

				}
				String incomings = "0";
				String pIncomings = "0%";
				if (report.getActorsIncoming().containsKey(actor)) {
					long value = report.getActorsIncoming().get(actor);
					incomings = Long.toString(value);
					pIncomings = StringUtils.format(((double) value) / report.getDependencies() * 100.0);
				}

				String outgoings = "0";
				String pOutgoings = "0%";
				if (report.getActorsOutgoings().containsKey(actor)) {
					long value = report.getActorsOutgoings().get(actor);
					outgoings = Long.toString(value);
					pOutgoings = StringUtils.format(((double) value) / report.getDependencies() * 100.0);
				}

				b.append(String.format("| %s | %s | %s%s | %s | %s%s | %s | %s%s |\n", actor.getName(), firings, pFirings,
						"%", incomings, pIncomings, "%", outgoings, pOutgoings, "%"));
			}

			b.append("## Actions data\n");
			List<Action> actions = new ArrayList<>();
			for (Actor actor : actors) {
				actions.addAll(actor.getActions());
			}
			Collections.sort(actions, new Comparator<Action>() {

				@Override
				public int compare(Action o1, Action o2) {
					int rc = o1.getOwner().getName().compareTo(o2.getOwner().getName());
					if (rc == 0) {
						rc = o1.getName().compareTo(o2.getName());
					}
					return rc;
				}
			});
			b.append("| Actor | Action | Firings|| Incomings|| Outgoings||\n");
			b.append("|:---- |:----  |:---- |:---- |:---- |:---- |:---- |:----\n");

			for (Action action : actions) {
				String firings = "0";
				String pFirings = "0%";
				if (report.getActionsFirings().containsKey(action)) {
					long value = report.getActionsFirings().get(action);
					firings = Long.toString(value);
					pFirings = StringUtils.format(((double) value) / report.getFirings() * 100.0) +"%";

				}
				String incomings = "0";
				String pIncomings = "0%";
				if (report.getActionsIncomings().containsKey(action)) {
					long value = report.getActionsIncomings().get(action);
					incomings = Long.toString(value);
					pIncomings = StringUtils.format(((double) value) / report.getDependencies() * 100.0) +"%";
				}

				String outgoings = "0";
				String pOutgoings = "0%";
				if (report.getActionsOutgoings().containsKey(action)) {
					long value = report.getActionsOutgoings().get(action);
					outgoings = Long.toString(value);
					pOutgoings = StringUtils.format(((double) value) / report.getDependencies() * 100.0) +"%";
				}

				b.append(String.format("| %s | %s | %s | %s | %s | %s | %s | %s |\n", action.getOwner().getName(),
						action.getName(), firings, pFirings, incomings, pIncomings, outgoings, pOutgoings));
			}

			writer.write(b.toString());

			writer.close();
		} catch (Exception e) {
			throw new TurnusException("Export fails", e);
		}

	}

}

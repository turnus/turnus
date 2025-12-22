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
import turnus.model.analysis.trace.ComparedAction;
import turnus.model.analysis.trace.ComparedTrace;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.TraceComparatorReport;

public class Dtraces2MdExporter implements FileExporter<TraceComparatorReport, StringBuffer> {

	@Override
	public void export(File input, File output) throws TurnusException {
		TraceComparatorReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		export(report, output);

	}

	@Override
	public void export(TraceComparatorReport report, File output) throws TurnusException {
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
	public StringBuffer content(TraceComparatorReport report) {
		StringBuffer b = new StringBuffer();
		b.append("# Trace comparator report\n");

		CompressedTraceReport ref = report.getReference();
		List<ComparedTrace> traces = new ArrayList<>(report.getTraces());

		b.append("## Traces\n");
		b.append("| ID | Trace file | Equal | Network name \n");
		b.append("|:---|:---|:---\n");
		b.append(String.format("| Reference | %s | | %s\n", ref.getTraceFile(), ref.getNetwork().getName()));

		for (ComparedTrace trace : traces) {
			int id = traces.indexOf(trace);
			CompressedTraceReport cTrace = trace.getCompressedTrace();
			b.append(String.format("| %d | %s | %b | %s\n", id, cTrace.getTraceFile(), trace.isEqual(),
					cTrace.getNetwork().getName()));
		}
		b.append("\n");

		b.append("## Differences\n");
		b.append("| ID |  dSteps | dDependencies \n");
		b.append("|:---|:---|:---\n");
		for (ComparedTrace trace : traces) {
			int id = traces.indexOf(trace);
			b.append(String.format("| %d | %d | %d\n", id, trace.getDSteps(), trace.getDDependencies()));
		}
		b.append("\n");

		for (ComparedTrace trace : traces) {
			b.append("### Trace ").append(traces.indexOf(trace)).append("\n");
			b.append("**file**: ").append(trace.getCompressedTrace().getTraceFile()).append("\n");
			b.append("\n");

			List<ComparedAction> actions = new ArrayList<>(trace.getActions());
			Collections.sort(actions, new Comparator<ComparedAction>() {
				@Override
				public int compare(ComparedAction o1, ComparedAction o2) {
					if (o1.isFound() != o2.isFound()) {
						return Boolean.compare(o1.isFound(), o2.isFound());
					} else if (o1.getDSteps() != o2.getDSteps()) {
						return -Long.compare(o1.getDSteps(), o2.getDSteps());
					} else if (o1.getDIncomings() != o2.getDIncomings()) {
						return -Long.compare(o1.getDIncomings(), o2.getDIncomings());
					} else {
						return -Long.compare(o1.getDOutgoings(), o2.getDOutgoings());
					}
				}
			});

			b.append("| Actor |  Action | Found | dSteps | dIncomings | dOutgoings \n");
			b.append("|:---|:---|:---|:---|:---|:---\n");
			for (ComparedAction action : actions) {
				String actorName = action.getAction().getOwner().getName();
				String actionName = action.getAction().getName();
				b.append(String.format("| %s | %s | %b | %d | %d | %d\n", actorName, actionName, action.isFound(),
						action.getDSteps(), action.getDIncomings(), action.getDOutgoings()));
			}
			b.append("\n");
		}
		return b;
	}

}

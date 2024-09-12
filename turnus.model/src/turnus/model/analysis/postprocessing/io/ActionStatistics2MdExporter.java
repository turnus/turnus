/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) Endri Bezati
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
package turnus.model.analysis.postprocessing.io;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

/**
 * {@link ActionStatisticsReport} MD file exporter
 * 
 * @author Endri Bezati
 *
 */
public class ActionStatistics2MdExporter implements FileExporter<ActionStatisticsReport, StringBuffer> {

	
	
	
	@Override
	public StringBuffer content(ActionStatisticsReport data) {
		StringBuffer b = new StringBuffer();

		b.append(report(data, true));
		return b;
	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ActionStatisticsReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(ActionStatisticsReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();

			b.append(report(data, true));

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}

	
	/**
	 * Return the {@link ActionStatisticsReport} as a {@link StringBuffer}
	 * 
	 * @param data
	 * @param isParent
	 * @return
	 */
	public static StringBuffer report(ActionStatisticsReport data, boolean isParent) {
		StringBuffer b = new StringBuffer();

		if (isParent) {
			// -- Title
			b.append("# Post Processing - Action Statistics report");
			b.append("\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append("\n");

			// -- Overview
			b.append("## Overview \n");
		} else {
			b.append("## Action Statistics \n");
		}

		List<Actor> actors = data.getActors();
		b.append("| Actor | Action | Counts | Processing | Schedulable | Blocked Reading | Blocked Writing  \n");
		b.append("| :--   | :--    | --:    | --:        | --:         | --:             | --:              \n");
		for (Actor actor : actors) {
			for (Action action : actor.getActions()) {
				if (data.getIdleTimes().containsKey(action)) {
					long counts = data.getExecutionCounts().get(action);
					double time = data.getProcessingTimes().get(action);
					double idle = data.getIdleTimes().get(action);
					double bread = data.getBlockedReadingTimes().get(action);
					double bwrite = data.getBlockedWritingTimes().get(action);

					b.append(String.format("| %s | %s | %d | %.2f | %.2f | %.2f | %.2f \n", actor.getName(),
							action.getName(), counts, time, idle, bread, bwrite));
				}

			}
		}

		if (isParent) {
			// -- Schedulable time
			b.append("## Schedulable Time \n");
			b.append("| Actor | Action | Mean | Min | Max | \n");
			b.append("|:--    |:--     | --:  | --: | --: \n");
			for (Actor actor : actors) {
				for (Action action : actor.getActions()) {
					if (data.getIdleTimes().containsKey(action)) {
						double mean_cycles = data.getIdleTimes().get(action);
						double min_cycles = data.getIdleMinTimes().get(action);
						double max_cycles = data.getIdleMaxTimes().get(action);
						b.append(String.format("| %s | %s | %.2f | %.2f | %.2f \n", actor.getName(), action.getName(),
								mean_cycles, min_cycles, max_cycles));
					}

				}
			}

			// -- block reading
			b.append("## Blocked reading \n");
			b.append("| Actor | Action | Mean | Min | Max | \n");
			b.append("|:--    |:--     | --:  | --: | --: \n");
			for (Actor actor : actors) {
				for (Action action : actor.getActions()) {
					if (data.getIdleTimes().containsKey(action)) {
						double mean_cycles = data.getBlockedReadingTimes().get(action);
						double min_cycles = data.getBlockedReadingMinTimes().get(action);
						double max_cycles = data.getBlockedReadingMaxTimes().get(action);
						b.append(String.format("| %s | %s | %.2f | %.2f | %.2f \n", actor.getName(), action.getName(),
								mean_cycles, min_cycles, max_cycles));
					}

				}
			}

			// -- block writing
			b.append("## Blocked writing \n");
			b.append("| Actor | Action | Mean | Min | Max \n");
			b.append("|:--    |:--     | --:  | --: | --: \n");
			for (Actor actor : actors) {
				for (Action action : actor.getActions()) {
					if (data.getIdleTimes().containsKey(action)) {
						double mean_cycles = data.getBlockedWritingTimes().get(action);
						double min_cycles = data.getBlockedWritingMinTimes().get(action);
						double max_cycles = data.getBlockedWritingMaxTimes().get(action);
						b.append(String.format("| %s | %s | %.2f | %.2f | %.2f \n", actor.getName(), action.getName(),
								mean_cycles, min_cycles, max_cycles));
					}

				}
			}
		}

		return b;
	}

}

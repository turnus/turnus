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
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Type;
import turnus.model.dataflow.Variable;

/**
 * {@link ActorStatisticsReport} MD file exporter
 * 
 * @author Endri Bezati
 *
 */
public class ActorStatistics2MdExporter implements FileExporter<ActorStatisticsReport, StringBuffer> {

	@Override
	public StringBuffer content(ActorStatisticsReport data) {
		StringBuffer b = new StringBuffer();

		b.append(report(data, true));
		return b;
	}

	@Override
	public void export(File input, File output) throws TurnusException {
		ActorStatisticsReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(ActorStatisticsReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = content(data);

			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	/**
	 * Return the {@link ActorStatisticsReport} as a {@link StringBuffer}
	 * 
	 * @param data
	 * @param isParent
	 * @return
	 */
	public static StringBuffer report(ActorStatisticsReport data, boolean isParent) {

		StringBuffer b = new StringBuffer();
		// -- Title
		if (isParent) {
			b.append("# Post Processing - Actor Statistics report");
			b.append("\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
		} else {
			b.append("## Actor Statistics");
			b.append("\n");
		}
		b.append(String.format("* **Number of partitions**: %s\n", data.getPartitions().size()));

		if (isParent) {
			b.append(String.format("* **Execution Time**: %.2f\n", data.getExecutionTime()));
		}
		b.append(String.format("* **Average occupancy**: %.2f", data.getAverageOccupancy()) + "%\n");
		b.append(String.format("* **Standard deviation of occupancy**: %.2f", data.getOccupancyDeviation()) + "%\n");
		b.append("\n");

		for (String id : data.getPartitions().keySet()) {
			StatisticalActorPartition partition = data.getPartitions().get(id);
			if (isParent) {
				b.append(String.format("## Partition - %s\n", id));
			} else {
				b.append(String.format("### Partition - %s\n", id));
			}
			b.append("\n");
			b.append(String.format("* **Occupancy**: %.2f", partition.getOccupancy()) + "%\n");

			long partitionPersitentMemory = 0;
			for (String actorName : partition.getActors()) {
				Actor actor = data.getNetwork().getActor(actorName);
				for (Variable variable : actor.getVariables()) {
					if (variable.isPersistent()) {
						Type type = variable.getType();
						long bits = type.getBits();
						partitionPersitentMemory += bits;
					}
				}
			}
			b.append(String.format("* **Persistent Memory**: %s\n",
					StringUtils.formatBytes(partitionPersitentMemory, true)));
			b.append(String.format("* **Scheduling Policy**: %s\n", partition.getSchedulingPolicy()));

			b.append("\n");
			b.append("| Actor | Processing | Schedulable | Blocked Reading | Blocked Writing \n");
			b.append("|:--    | --:        | --:         | --:             | --:             \n");
			for (String actorName : partition.getActors()) {
				double time = data.getProcessingTimes().get(actorName);
				double idle = data.getIdleTimes().get(actorName);
				double bwrite = data.getBlockedReadingTimes().get(actorName);
				double bread = data.getBlockedWritingTimes().get(actorName);
				b.append(String.format("| %s | %.2f | %.2f | %.2f | %.2f \n", actorName, time, idle, bwrite, bread));
			}
		}

		return b;
	}

}

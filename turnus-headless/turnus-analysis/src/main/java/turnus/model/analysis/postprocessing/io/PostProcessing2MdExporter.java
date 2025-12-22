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
import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.SchedulerChecksReport;

/**
 * {@link PostProcessingReport} MD file exporter
 * 
 * @author Endri Bezati
 *
 */
public class PostProcessing2MdExporter implements FileExporter<PostProcessingReport, StringBuffer> {

	@Override
	public StringBuffer content(PostProcessingReport data) {
		StringBuffer b = new StringBuffer();

		// -- Title
		b.append("# Post Processing report");
		b.append("\n");
		b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
		b.append(String.format("* **Execution Time**: %.2f\n", data.getTime()));
		b.append(String.format("* **Deadlock**: %s\n", data.isDeadlock()));

		// -- Actor Statistics report
		b.append(ActorStatistics2MdExporter.report(data.getReport(ActorStatisticsReport.class), false));
		b.append("\n");

		// -- Action Statistics report
		b.append(ActionStatistics2MdExporter.report(data.getReport(ActionStatisticsReport.class), false));
		b.append("\n");

		// -- Scheduling Checks report
		b.append(SchedulerChecks2MdExporter.report(data.getReport(SchedulerChecksReport.class), false));
		b.append("\n");

		// -- Buffer Blocking report
		// -- Action Statistics report
		b.append(BufferBlocking2MdExporter.report(data.getReport(BufferBlockingReport.class), false));
		b.append("\n");
		return b;
	}

	@Override
	public void export(File input, File output) throws TurnusException {
		PostProcessingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(PostProcessingReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = content(data);

			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}

}

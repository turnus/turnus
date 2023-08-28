/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 Endri Bezati
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
package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiling.IntraActionCommunicationData;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

/**
 * The {@link IntraActionCommunicationReport} MD File exporter
 * 
 * @author Endri Bezati
 */
public class Iacomm2MdExporter implements FileExporter<IntraActionCommunicationReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		IntraActionCommunicationReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(IntraActionCommunicationReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = new StringBuffer();
			b.append("# Intra actor communication report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithm**: %s\n", data.getAlgorithm()));
			b.append("\n");

			for (IntraActorCommunicationData idata : data.getActorsData()) {
				b.append(String.format("## Actor : %s\n", idata.getActor().getName()));
				b.append(
						"| **Kind**  | **Mean** | **Min** | **Max** | **Sum** | **Samples** | **Sum of Squares** |**Geometric Mean** |\n");
				b.append(
						"|:--        |  --:     | --:     | --:     | --:     | --:         | --:                | --:               |\n");
				double mean = idata.getConsumedTokens().getMean();
				double min = idata.getConsumedTokens().getMin();
				double max = idata.getConsumedTokens().getMax();
				double sum = idata.getConsumedTokens().getSum();
				double sample = idata.getConsumedTokens().getSamples();
				double sumOfSquares = idata.getConsumedTokens().getSumOfSquares();
				double geometricMean = idata.getConsumedTokens().getGeometricMean();
				b.append(String.format("Consumed | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n", mean, min, max, sum,
						sample, sumOfSquares, geometricMean));
				mean = idata.getProducedTokens().getMean();
				min = idata.getProducedTokens().getMin();
				max = idata.getProducedTokens().getMax();
				sum = idata.getProducedTokens().getSum();
				sample = idata.getProducedTokens().getSamples();
				sumOfSquares = idata.getProducedTokens().getSumOfSquares();
				geometricMean = idata.getProducedTokens().getGeometricMean();
				b.append(String.format("Produced | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n", mean, min, max, sum,
						sample, sumOfSquares, geometricMean));

				if (!idata.getTokensProducersMap().values().isEmpty()) {
					b.append("\n");

					b.append(
							"| **Actor**  | **Mean** | **Min** | **Max** | **Sum** | **Samples** | **Sum of Squares** |**Geometric Mean** |\n");
					b.append(
							"|:--        |  --:     | --:     | --:     | --:     | --:         | --:                | --:               |\n");
					for (Actor actor : idata.getTokensProducersMap().keySet()) {
						mean = idata.getTokensProducersMap().get(actor).getMean();
						min = idata.getTokensProducersMap().get(actor).getMin();
						max = idata.getTokensProducersMap().get(actor).getMax();
						sum = idata.getTokensProducersMap().get(actor).getSum();
						sample = idata.getTokensProducersMap().get(actor).getSamples();
						sumOfSquares = idata.getTokensProducersMap().get(actor).getSumOfSquares();
						geometricMean = idata.getTokensProducersMap().get(actor).getGeometricMean();
						b.append(String.format("%s | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n", actor.getName(),
								mean, min, max, sum, sample, sumOfSquares, geometricMean));
					}

					b.append("[Producers overview]\n");
				}

				b.append("\n");

				for (IntraActionCommunicationData iact : idata.getActionsData()) {
					b.append(String.format("### Action : %s\n", iact.getAction().getName()));

					b.append(
							"| **Kind**  | **Mean** | **Min** | **Max** | **Sum** | **Samples** | **Sum of Squares** |**Geometric Mean** |\n");
					b.append(
							"|:--        |  --:     | --:     | --:     | --:     | --:         | --:                | --:               |\n");
					mean = iact.getConsumedTokens().getMean();
					min = iact.getConsumedTokens().getMin();
					max = iact.getConsumedTokens().getMax();
					sum = iact.getConsumedTokens().getSum();
					sample = iact.getConsumedTokens().getSamples();
					sumOfSquares = iact.getConsumedTokens().getSumOfSquares();
					geometricMean = iact.getConsumedTokens().getGeometricMean();
					b.append(String.format("Consumed | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n", mean, min, max,
							sum, sample, sumOfSquares, geometricMean));
					mean = iact.getProducedTokens().getMean();
					min = iact.getProducedTokens().getMin();
					max = iact.getProducedTokens().getMax();
					sum = iact.getProducedTokens().getSum();
					sample = iact.getProducedTokens().getSamples();
					sumOfSquares = iact.getProducedTokens().getSumOfSquares();
					geometricMean = iact.getProducedTokens().getGeometricMean();
					b.append(String.format("Produced | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n", mean, min, max,
							sum, sample, sumOfSquares, geometricMean));

					if (!iact.getTokensProducersMap().values().isEmpty()) {
						b.append("\n");

						b.append(
								"| **Actor**  | **Actor** | **Mean** | **Min** | **Max** | **Sum** | **Samples** | **Sum of Squares** |**Geometric Mean** |\n");
						b.append(
								"|:--         |  :--      |  --:      | --:     | --:     | --:     | --:         | --:                | --:               |\n");
						for (Action action : iact.getTokensProducersMap().keySet()) {
							mean = iact.getTokensProducersMap().get(action).getMean();
							min = iact.getTokensProducersMap().get(action).getMin();
							max = iact.getTokensProducersMap().get(action).getMax();
							sum = iact.getTokensProducersMap().get(action).getSum();
							sample = iact.getTokensProducersMap().get(action).getSamples();
							sumOfSquares = iact.getTokensProducersMap().get(action).getSumOfSquares();
							geometricMean = iact.getTokensProducersMap().get(action).getGeometricMean();
							b.append(String.format("%s | %s | %.1f | %.1f |%.1f |%.1f |%.1f |%.1f |%.1f \n",
									action.getOwner().getName(), action.getName(), mean, min, max, sum, sample,
									sumOfSquares, geometricMean));
						}

						b.append("[Producers]\n");
					}
				}
			}

			b.append("\n");
			writer.write(b.toString());
			writer.close();

		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}

}

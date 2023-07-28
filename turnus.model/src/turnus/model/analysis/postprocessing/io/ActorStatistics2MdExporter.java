package turnus.model.analysis.postprocessing.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;

/**
 * {@link ActorStatisticsReport} MD file exporter
 * 
 * @author Endri Bezati
 *
 */
public class ActorStatistics2MdExporter implements FileExporter<ActorStatisticsReport> {

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
			StringBuffer b = new StringBuffer();

			// -- Title
			b.append("# Post Processing - Actor Statistics report");
			// b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append("\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Number of partitions**: %s\n", data.getPartitions().size()));
			b.append(String.format("* **Execution Time**: %f\n", data.getExecutionTime()));
			b.append(String.format("* **Average occupancy**: %.2f", data.getAverageOccupancy())+"%\n");
			b.append(String.format("* **Standard deviation of occupancy**: %.2f", data.getOccupancyDeviation())+"%\n");
			b.append("\n");
			
			int pNumber = 1;
			for (StatisticalActorPartition partition : data.getPartitions()) {
				b.append(String.format("\n Partition (%d):\n", pNumber++));
				b.append(String.format("\t occupancy: %.2f", partition.getOccupancy()));
				b.append("%\n Actors:\n");
				for (String actorName : partition.getActors()) {
					b.append("\t " + actorName + ": \n");
					b.append("\t\t processing time: " + data.getProcessingTimes().get(actorName) + "\n");
					b.append("\t\t schedulable time: " + data.getIdleTimes().get(actorName) + "\n");
					b.append("\t\t blocked reading time: " + data.getBlockedReadingTimes().get(actorName) + "\n");
					b.append("\t\t blocked writing time: " + data.getBlockedWritingTimes().get(actorName) + "\n");
				}
			}
			
			
			
			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}


		
	}

}

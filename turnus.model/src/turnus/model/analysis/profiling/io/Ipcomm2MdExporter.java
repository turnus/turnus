package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

/**
 * The {@link InterPartitionCommunicationAndMemoryReport} MD File exporter
 * 
 * @author Endri Bezati
 */
public class Ipcomm2MdExporter implements FileExporter<InterPartitionCommunicationAndMemoryReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		InterPartitionCommunicationAndMemoryReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(InterPartitionCommunicationAndMemoryReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = new StringBuffer();
			b.append("# Inter-Partition communication and memory report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithm**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Outgoing buffer are stored by source partition**: %s\n",
					data.isOutgoingBufferOwnedBySource()));
			b.append("\n");

			b.append("# Overview\n");

			// b.append("\n| || Overall ||||| Critical Path ||||| ");
			b.append("\n|                      ||| <center>Memory</center>  ||| <center>Interface</center>  |||");
			b.append("\n| Partition | Workload | # Actors | *Actors*| *Channels* | Total | Incoming | Outgoing |");
			b.append("\n|---        |--:       |--:       |--:    |--:      |--:    |--:       |--:       |");
			for (InterPartitionData datum : data.getPartitionData()) {
				b.append(String.format("\n|%s     | %.2f     | %d       | %s    | %s      | %s    |  %s      | %s     ", //
						datum.getPartitionId(), //
						datum.getWorkload(), //
						datum.getActors().size(), //
						StringUtils.formatBytes(datum.getPersistentMemory(), true), //
						StringUtils.formatBytes(datum.getPersistentBuffers(), true), //
						StringUtils.formatBytes(datum.getPersistentMemory() + datum.getPersistentBuffers(), true), //
						"-", //
						"-"//
				));
			}

			b.append("\n# Partitions\n");
			for (InterPartitionData datum : data.getPartitionData()) {
				b.append(String.format("## Partition: %s\n", datum.getPartitionId()));

				b.append("| Actor | Memory |\n");
				b.append("|:--    | --:    |\n");
				for (Actor actor : datum.getActors()) {
					b.append(String.format("| %s | %s \n", actor.getName(),
							StringUtils.formatBytes(MemoryAndBuffers.getActorPersistentMemmory(actor))));
				}

				b.append("[Actors]\n");

				if (datum.getInternalBuffers().size() > 0) {
					b.append("\n| source | source-port | target | target-port | type | depth | bytes\n");
					b.append("|----|----|----|----|----|----:|----:\n");

					for (Buffer buffer : datum.getInternalBuffers()) {
						int depth = data.getBufferDepthMap().get(buffer);
						long bizSize = depth * buffer.getType().getBits();
						
						b.append(String.format("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
								buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
								buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
								buffer.getType().toString(), depth, StringUtils.formatBytes(bizSize, true)));
					}
					b.append("[Internal Buffers]\n");
				}

				if (datum.getExternalBuffers().size() > 0) {
					if(data.isOutgoingBufferOwnedBySource()) {
						b.append("\n| to  | source | source-port | target | target-port | type | depth | bytes\n");
					}else {
						b.append("\n| from| source | source-port | target | target-port | type | depth | bytes\n");
					}
					b.append("|:----|----|----|----|----|----|---:|---:\n");

					for (Buffer buffer : datum.getExternalBuffers()) {
						int depth = data.getBufferDepthMap().get(buffer);
						long bizSize = depth * buffer.getType().getBits();
						String partition = "";
						if(data.isOutgoingBufferOwnedBySource()) {
							partition = data.getActorPartitionMap().get(buffer.getTarget().getOwner());
						} else {
							partition = data.getActorPartitionMap().get(buffer.getSource().getOwner());
						}
						b.append(String.format("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
								partition, buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
								buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
								buffer.getType().toString(), depth, StringUtils.formatBytes(bizSize, true)));
					}
					if (data.isOutgoingBufferOwnedBySource()) {
						b.append("[Outgoing Buffers]\n");
					} else {
						b.append("[Incoming Buffers]\n");
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

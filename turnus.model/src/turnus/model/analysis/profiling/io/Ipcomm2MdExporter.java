package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	private Boolean isNumber(String n1, String n2) {
		try {
			Integer.parseInt(n1);
			Integer.parseInt(n2);
			return true;
		} catch (Exception x) {
			return false;
		}
	}

	
	protected StringBuffer content(InterPartitionCommunicationAndMemoryReport data) {
		StringBuffer b = new StringBuffer();
		b.append("# Inter-Partition communication and memory report\n");
		b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
		b.append(String.format("* **Algorithm**: %s\n", data.getAlgorithm()));
		b.append(String.format("* **Outgoing buffer are stored by source partition**: %s\n",
				data.isOutgoingBufferOwnedBySource()));
		b.append(String.format("* **# Partitions**: %d\n", data.getPartitionData().size()));
		b.append(String.format("* **Critical path weight**: %.2f\n", data.getCpWeight()));
		b.append(String.format("* **Scheduled critical path weight**: %.2f\n", data.getCpWeightScheduled()));
		b.append(String.format("* **Simulation time**: %.2f\n", data.getTime()));
		b.append(String.format("* **Simulation deadlock**: %s\n", data.isDeadlock()));
		b.append(String.format("* **Mapping configuration file**: %s\n", data.getMappingFile()));
		b.append(String.format("* **Buffer  configuration file**: %s\n", data.getBufferFile()));
		b.append("\n");

		b.append("# Summary\n");

		List<InterPartitionData> sortedList = new ArrayList<>(data.getPartitionData());

		Collections.sort(sortedList, new Comparator<InterPartitionData>() {

			@Override
			public int compare(InterPartitionData o1, InterPartitionData o2) {

				String s1 = o1.getPartitionId();
				String s2 = o2.getPartitionId();

				String[] pt1 = s1.split("((?<=[a-z])(?=[0-9]))|((?<=[0-9])(?=[a-z]))");
				String[] pt2 = s2.split("((?<=[a-z])(?=[0-9]))|((?<=[0-9])(?=[a-z]))");
				// pt1 and pt2 arrays will have the string split in alphabets and numbers

				int i = 0;
				if (Arrays.equals(pt1, pt2))
					return 0;
				else {
					for (i = 0; i < Math.min(pt1.length, pt2.length); i++)
						if (!pt1[i].equals(pt2[i])) {
							if (!isNumber(pt1[i], pt2[i])) {
								if (pt1[i].compareTo(pt2[i]) > 0)
									return 1;
								else
									return -1;
							} else {
								int nu1 = Integer.parseInt(pt1[i]);
								int nu2 = Integer.parseInt(pt2[i]);
								if (nu1 > nu2)
									return 1;
								else
									return -1;
							}
						}
				}

				if (pt1.length > i)
					return 1;
				else
					return -1;
			}
		});

		// b.append("\n| || Overall ||||| Critical Path ||||| ");
		b.append("\n|                      |||| <center>Memory</center>  ||| <center>Interface</center>  ||||");
		b.append(
				"\n| Partition | # Actors |  Workload | Occupancy % | *Actors*| *Channels* | Total | #Incoming | Max Incoming Data | #Outgoing | Max Outgoing Data |");
		b.append(
				"\n|---        |--:        |--:       |--:       |--:    |--:      |--:    |--:       |--:       |--:       |--: |");
		for (InterPartitionData datum : sortedList) {
			b.append(String.format(
					"\n|%s     | %d      | %.2f      | %.2f       | %s    | %s      | %s    |  %s      | %s      |  %s      | %s     ", //
					datum.getPartitionId(), //
					datum.getActors().size(), //
					datum.getWorkload(), //
					datum.getOccupancy(), //
					StringUtils.formatBytes(datum.getPersistentMemory(), true), //
					StringUtils.formatBytes(datum.getPersistentBuffers(), true), //
					StringUtils.formatBytes(datum.getPersistentMemory() + datum.getPersistentBuffers(), true), //
					datum.getIncomingBuffers().size(), //
					StringUtils.formatBytes(datum.getMaxIncomingBitsPerFiring(), true), //
					datum.getOutgoingBuffers().size(), //
					StringUtils.formatBytes(datum.getMaxOutgoingBitsPerFiring(), true)//
			));
		}

		b.append("\n# Partitions\n");
		for (InterPartitionData datum : sortedList) {
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
					long bitSize = depth * buffer.getType().getBits();

					b.append(String.format("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
							buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
							buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
							buffer.getType().toString(), depth, StringUtils.formatBytes(bitSize, true)));
				}
				b.append("[Internal Buffers]\n");
			}
			
			

			// -- Outgoing buffer
			if (datum.getOutgoingBuffers().size() > 0) {
				b.append("\n| to  | source | source-port | target | target-port | type | depth | bytes\n");
				b.append("|:----|----|----|----|----|----|---:|---:\n");

				for (Buffer buffer : datum.getOutgoingBuffers()) {
					int depth = data.getBufferDepthMap().get(buffer);
					long bizSize = depth * buffer.getType().getBits();
					String partition = data.getActorPartitionMap().get(buffer.getTarget().getOwner());

					b.append(String.format("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
							partition, buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
							buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
							buffer.getType().toString(), depth, StringUtils.formatBytes(bizSize, true)));
				}
				b.append("[Outgoing Buffers]\n");
			}
			
			// -- Incoming buffer
			if (datum.getIncomingBuffers().size() > 0) {
				b.append("\n| from| source | source-port | target | target-port | type | depth | bytes\n");
				b.append("|:----|----|----|----|----|----|---:|---:\n");
				for (Buffer buffer : datum.getIncomingBuffers()) {
					int depth = data.getBufferDepthMap().get(buffer);
					long bizSize = depth * buffer.getType().getBits();
					String partition = data.getActorPartitionMap().get(buffer.getSource().getOwner());
					b.append(String.format("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
							partition, buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
							buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
							buffer.getType().toString(), depth, StringUtils.formatBytes(bizSize, true)));
				}
				b.append("[Incoming Buffers]\n");
			}

		}

		b.append("\n");
		
		return b;
	}
	
	@Override
	public void export(InterPartitionCommunicationAndMemoryReport data, File output) throws TurnusException {
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

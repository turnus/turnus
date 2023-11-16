package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiling.LatencyData;
import turnus.model.analysis.profiling.LatencyReport;

public class Lprof2MdExporter implements FileExporter<LatencyReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		LatencyReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

	@Override
	public void export(LatencyReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = new StringBuffer();
			
			b.append("# Latency and Throughput report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithm**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Mapping configuration file**: %s\n", data.getMappingFile()));
			b.append(String.format("* **Buffer  configuration file**: %s\n", data.getBufferFile()));
			b.append(String.format("* **Simulation time**: %.2f\n", data.getTime()));
			//b.append(String.format("* **Simulation deadlock**: %s\n", data.isDeadlock()));
			b.append("\n");

			b.append("# Summary\n");
			
			LatencyData srcLatency = data.getSource();
			DescriptiveStatistics srcStats = new DescriptiveStatistics();
			
			// -- Source
			for(Double value : srcLatency.getLatency()) {
				srcStats.addValue(value);
			}
			
			double srcP90 = srcStats.getPercentile(90);
			double srcP95 = srcStats.getPercentile(95);
			double srcP99 = srcStats.getPercentile(99);
			
			// -- Targets
			List<String> tgtsActor = new ArrayList<>();
			List<String> tgtsAction = new ArrayList<>();
			List<String> tgtsP90 = new ArrayList<>();
			List<String> tgtsP95 = new ArrayList<>();
			List<String> tgtsP99 = new ArrayList<>();
			List<String> tgtsThtoughput = new ArrayList<>();
			
			for(LatencyData tgt : data.getTargets()) {
				tgtsActor.add(tgt.getActor().getName());
				tgtsAction.add(tgt.getAction().getName());
				
				DescriptiveStatistics tgtStats = new DescriptiveStatistics();
				for(Double value : tgt.getLatency()) {
					tgtStats.addValue(value);
				}
				
				tgtsP90.add(String.format("%.2f", tgtStats.getPercentile(90)));
				tgtsP95.add(String.format("%.2f", tgtStats.getPercentile(95)));
				tgtsP99.add(String.format("%.2f", tgtStats.getPercentile(99)));
				
				tgtsThtoughput.add(String.format("%.2f", tgt.getThroughput()));
				
			}
			
			StringBuilder columns = new StringBuilder();
			StringBuilder ordering = new StringBuilder();
	        for (int i = 0; i < data.getTargets().size(); i++) {
	        	columns.append("|");
	        	ordering.append("--: |");
	        }
	        
			
			b.append(String.format("\n|         | <center>Source</center> %s <center>Targets</center> %s", columns, columns));
			b.append(String.format("\n| :--     | --: | %s", ordering));
			b.append(String.format("\n| **Actor**         | %s   | %s", srcLatency.getActor().getName(), String.join("|", tgtsActor)));
			b.append(String.format("\n| **Action**        | %s   | %s", srcLatency.getAction().getName(), String.join("|", tgtsAction)));
			b.append(String.format("\n| **P90**           | %.2f | %s", srcP90, String.join("|", tgtsP90)));
			b.append(String.format("\n| **P95**           | %.2f | %s", srcP95, String.join("|", tgtsP95)));
			b.append(String.format("\n| **P99**           | %.2f | %s", srcP99, String.join("|", tgtsP99)));
			b.append(String.format("\n| **Throughput**    | %.2f | %s", srcLatency.getThroughput(), String.join("|", tgtsThtoughput)));
			
			
			b.append("\n");

			// -- Source 
			b.append("# Source\n");
			
			b.append(String.format("* **Actor**: %s\n", srcLatency.getActor().getName()));
			b.append(String.format("* **Action**: %s\n", srcLatency.getAction().getName()));
			b.append(String.format("* **Percentile 90**: %.2f\n", srcP90));
			b.append(String.format("* **Percentile 95**: %.2f\n", srcP95));
			b.append(String.format("* **Percentile 99**: %.2f\n", srcP99));
			b.append(String.format("* **Throughput** : %.2f\n", srcLatency.getThroughput()));
			
			b.append("\n| Sample | Latency|");
			b.append("\n| :--     | --: |");
			for(int i = 0; i < srcLatency.getLatency().size(); i++) {
				b.append(String.format("\n| %d | %.2f |", i, srcLatency.getLatency().get(i)));
			}
			
			b.append("\n");
			
			// -- Targets 
			b.append("# Targets\n");
			for(LatencyData tgt : data.getTargets()) {
				b.append(String.format("* **Actor**: %s\n", tgt.getActor().getName()));
				b.append(String.format("* **Action**: %s\n", tgt.getAction().getName()));
				b.append(String.format("* **Percentile 90**: %s\n", tgtsP90.get(data.getTargets().indexOf(tgt))));
				b.append(String.format("* **Percentile 95**: %s\n", tgtsP95.get(data.getTargets().indexOf(tgt))));
				b.append(String.format("* **Percentile 99**: %s\n", tgtsP99.get(data.getTargets().indexOf(tgt))));
				b.append(String.format("* **Throughput** : %s\n", tgtsThtoughput.get(data.getTargets().indexOf(tgt))));
				
				
				b.append("\n| Sample | Latency|");
				b.append("\n| :--     | --: |");
				for(int i = 0; i < tgt.getLatency().size(); i++) {
					b.append(String.format("\n| %d | %.2f |", i, tgt.getLatency().get(i)));
				}
				
				b.append("\n");
				
			}
			
			b.append("\n");
			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}
}

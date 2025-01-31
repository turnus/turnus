package turnus.analysis.dot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.mapping.NetworkPartitioning;

public class BottleneckNetworkToDot extends NetworkToDot {

	private Map<String, Integer> actorHeatMap;
	
	private boolean drawSchedulingConnections;
	
	private NetworkPartitioning partitioning;

	final String[] colors = { "#cdb665", "#d0ac55", "#d4a147", "#d8963a", "#dc8a2f", "#e07c27", "#e56d22", "#e95c22",
			"#ed4725", "#f02a2a" };

	public BottleneckNetworkToDot(Network network, BottlenecksReport report) {
		super(network);
		drawSchedulingConnections = false;
		
		// -- Critical actions
		List<ActionBottlenecksData> actionsData = new ArrayList<>(report.getActionsData());
		Collections.sort(actionsData, new Comparator<ActionBottlenecksData>() {
			@Override
			public int compare(ActionBottlenecksData o1, ActionBottlenecksData o2) {
				double v1 = o1.getCpWeight();
				double v2 = o2.getCpWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalWeight();
				v2 = o2.getTotalWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalFirings();
				v2 = o2.getTotalFirings();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				return o1.getAction().toString().compareTo(o2.getAction().toString());
			}
		});

		Map<String, Double> actorCpWeight = new HashMap<>();

		double netcpWeights = report.getCpWeight();
		double maxCpWeight = -1;
		for (ActionBottlenecksData adata : actionsData) {
			String actor = adata.getAction().getOwner().getName();
			double cpWeights = adata.getCpWeight();
			long cpFirings = adata.getCpFirings();
			double cpWeightPerc = ((double) cpWeights) / netcpWeights * 100.0;
			if (cpWeightPerc > maxCpWeight) {
				maxCpWeight = cpWeightPerc;
			}

			if (cpFirings >= 1) {
				actorCpWeight.put(actor, cpWeightPerc);
			}
		}

		// -- Convert CpWeight to Color
		actorHeatMap = new HashMap<>();
		for (String actor : actorCpWeight.keySet()) {
			double heat = (actorCpWeight.get(actor) * 100) / maxCpWeight;
			int intHeat = (int) heat;
			actorHeatMap.put(actor, mapPercentageToValue(intHeat));
		}

	}
	
	public BottleneckNetworkToDot(Network network, BottlenecksWithSchedulingReport report, NetworkPartitioning partitioning) {
		super(network);
		
		drawSchedulingConnections = true;
		this.partitioning = partitioning;
		
		// -- Critical actions
		List<ActionBottlenecksWithSchedulingData> actionsData = new ArrayList<>(report.getActionsData());
		Collections.sort(actionsData, new Comparator<ActionBottlenecksWithSchedulingData>() {
			@Override
			public int compare(ActionBottlenecksWithSchedulingData o1, ActionBottlenecksWithSchedulingData o2) {
				double v1 = o1.getCpWeight();
				double v2 = o2.getCpWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalWeight();
				v2 = o2.getTotalWeight();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				v1 = o1.getTotalFirings();
				v2 = o2.getTotalFirings();
				if (v1 != v2) {
					return -Double.compare(v1, v2);
				}

				return o1.getAction().toString().compareTo(o2.getAction().toString());
			}
		});

		Map<String, Double> actorCpWeight = new HashMap<>();

		double netcpWeights = report.getCpWeight();
		double maxCpWeight = -1;
		for (ActionBottlenecksWithSchedulingData adata : actionsData) {
			String actor = adata.getAction().getOwner().getName();
			double cpWeights = adata.getCpWeight();
			long cpFirings = adata.getCpFirings();
			double cpWeightPerc = ((double) cpWeights) / netcpWeights * 100.0;
			if (cpWeightPerc > maxCpWeight) {
				maxCpWeight = cpWeightPerc;
			}

			if (cpFirings >= 1) {
				actorCpWeight.put(actor, cpWeightPerc);
			}
		}

		// -- Convert CpWeight to Color
		actorHeatMap = new HashMap<>();
		for (String actor : actorCpWeight.keySet()) {
			double heat = (actorCpWeight.get(actor) * 100) / maxCpWeight;
			int intHeat = (int) heat;
			actorHeatMap.put(actor, mapPercentageToValue(intHeat));
		}

	}

	@Override
	protected void schedulingConnection() {
		if (drawSchedulingConnections) {
			for(String srcActor : actorHeatMap.keySet()) {
				String srcPartition = partitioning.getPartition(srcActor);
				Actor sourceActor = network.getActor(srcActor);
				
				for(String tgtActor : actorHeatMap.keySet()) {
					if (!srcActor.equals(tgtActor)) {
						String tgtPartition = partitioning.getPartition(tgtActor);
						
					
						if (srcPartition.equals(tgtPartition)) {
							Actor targetActor = network.getActor(tgtActor);
							boolean connectInput = false;
							boolean connectOutput = false;
							// -- Input
							
							for (Port input : sourceActor.getInputPorts()) {
								Actor inputOwner = input.getInput().getSource().getOwner();
								if (partitioning.getPartition(inputOwner.getName()).equals(srcPartition)) {
									if (!input.getInput().getSource().getOwner().equals(targetActor)) {
										connectInput = true;
										break;
									}
								}
								
							}
							
							if (connectInput) {
								emitter.emit("\"%s\" -> \"%s\" [color=\"red\", penwidth=3, style=\"dashed\", dir=\"none\"];", srcActor, tgtActor);
								break;
							}
							// -- Output
							
							if (!connectOutput) {
								for (Port output : sourceActor.getOutputPorts()){
									for (Buffer buffer : output.getOutputs()){
										Actor outputOwner = buffer.getTarget().getOwner();
										if (partitioning.getPartition(outputOwner.getName()).equals(srcPartition)) {
											if (!buffer.getTarget().getOwner().equals(targetActor)) {
												connectOutput = true;
												break;
											}
										}
									}
								}	
							}
							
							if (connectOutput) {
								emitter.emit("\"%s\" -> \"%s\" [color=\"red\", penwidth=3, style=\"dashed\", dir=\"none\"];", srcActor, tgtActor);
								break;
							}
							
						}
					}
				}
				
			}
		}
	}
	
	private int mapPercentageToValue(int percentage) {
		if (percentage < 0) {
			return 0;
		} else if (percentage > 100) {
			return 9;
		} else {
			return (int) Math.round(percentage / 11.1111); // 100 / 9 = 11.1111
		}
	}

	@Override
	protected void instanceColor(String actorName) {
		if (actorHeatMap.containsKey(actorName)) {
			emitter.emit("<tr><td bgcolor=\"%s\"><font point-size=\"30\" color=\"#ffffff\"> %s </font></td></tr>",
					colors[actorHeatMap.get(actorName)], actorName);
		} else {
			emitter.emit("<tr><td bgcolor=\"gray\"><font point-size=\"30\" color=\"#ffffff\"> %s </font></td></tr>",
					actorName);
		}
	}

	@Override
	protected void connectionColor(Color color, String source, String srcPort, String target, String srcTgt, int delay) {
		if (actorHeatMap.containsKey(source) && actorHeatMap.containsKey(target)) {
			if (delay > 0) {
				emitter.emit("\"%s\":%s:e -> \"%s\":%s:w [color=\"red\", penwidth=3, label =\"(%s)\"];", source, srcPort, target, srcTgt, delay);
			} else {
				emitter.emit("\"%s\":%s:e -> \"%s\":%s:w [color=\"red\", penwidth=3];", source, srcPort, target, srcTgt);
			}
			
		} else {
			if (delay > 0) {
				emitter.emit("\"%s\":%s:e -> \"%s\":%s:w [color=\"gray\", label =\"(%s)\"];", source, srcPort, target, srcTgt, delay);
			} else {
				emitter.emit("\"%s\":%s:e -> \"%s\":%s:w [color=\"gray\"];", source, srcPort, target, srcTgt);
			}

		}
	}

}

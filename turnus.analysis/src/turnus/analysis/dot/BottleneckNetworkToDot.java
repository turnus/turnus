package turnus.analysis.dot;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.dataflow.Network;

public class BottleneckNetworkToDot extends NetworkToDot {

	Map<String, Color> actorHeatMap;

	public BottleneckNetworkToDot(Network network, BottlenecksReport report) {
		super(network);

		// -- Color Palette
		Map<Integer, Color> pallete = new HashMap<>();

		int numColors = 100;
		for (int i = 0; i < numColors; i++) {
			float hue = i / (float) (numColors - 1) * 120; // Adjust hue for the transition from red to green
			Color color = Color.getHSBColor(hue / 360.0f, 1.0f, 1.0f);
			pallete.put(i, color);
		}

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
			actorHeatMap.put(actor, pallete.get(intHeat));
		}

	}

	@Override
	protected void instanceColor(String actorName) {
		if (actorHeatMap.containsKey(actorName)) {
			emitter.emit("<tr><td bgcolor=\"%s\"><font point-size=\"30\" color=\"#ffffff\"> %s </font></td></tr>",
					encodeColor(actorHeatMap.get(actorName)), actorName);
		} else {
			emitter.emit("<tr><td bgcolor=\"black\"><font point-size=\"30\" color=\"#ffffff\"> %s </font></td></tr>",
					actorName);
		}

	}

	@Override
	protected void connectionColor(Color color, String source, String target) {
		if (actorHeatMap.containsKey(source) && actorHeatMap.containsKey(target)) {
			emitter.emit("%s:e -> %s:w [color=\"red\"];", source, target);
		} else {
			emitter.emit("%s:e -> %s:w [color=\"black\"];", source, target);
		}

	}

}

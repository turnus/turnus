/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
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
package turnus.analysis.profiler.dynamic.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import turnus.model.analysis.profiler.ActionDynamicData;
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;
import turnus.model.dataflow.Action;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.data.ClockCycles;

/**
 * This class contains the {@link NetworkWeight} builder for generating the
 * abstract weight from a {@link DynamicProfilingReport}
 * 
 * @author Simone Casale-Brunet
 *
 */
public class NetworkAbstractWeightBuilder {

	private Map<EOperator, Double> opWeights;
	private NetworkWeight networkWeights;

	/**
	 * Constructor. In this case all the {@link EOperator} have weight
	 * <code>1.0</code>.
	 * 
	 * @param report
	 */
	public NetworkAbstractWeightBuilder(DynamicProfilingReport report) {
		this(report, null);
	}

	/**
	 * Constructor. In this case all the {@link EOperator} that are not
	 * specified in the weights map have weight <code>1.0</code>.
	 * 
	 * @param report
	 * @param weights
	 *            the weights map
	 */
	public NetworkAbstractWeightBuilder(DynamicProfilingReport report, Map<EOperator, Double> weights) {
		if (weights == null) {
			opWeights = new HashMap<>();
		} else {
			opWeights = new HashMap<>(weights);
		}

		for (EOperator op : EOperator.values()) {
			if (!opWeights.containsKey(op)) {
				opWeights.put(op, 1.0);
			}
		}

		networkWeights = new NetworkWeight(report.getNetwork());
		for (ActorDynamicData actorData : report.getActorsData()) {
			for (ActionDynamicData actionData : actorData.getActionsData()) {
				Action action = actionData.getAction();
				double mean = 0;
				double min = 0;
				double max = 0;
				for (Entry<EOperator, StatisticalData> e : actionData.getOperandsCalls().entrySet()) {
					double cost = opWeights.get(e.getKey());
					StatisticalData data = e.getValue();
					mean += cost * data.getMean();
					min += cost * data.getMin();
					max += cost * data.getMax();
				}
				ClockCycles w = networkWeights.getWeight(action);
				w.setMinClockCycles(min);
				w.setMeanClockCycles(mean);
				w.setMaxClockCycles(max);
			}
		}
	}

	/**
	 * Get the abstract {@link NetworkWeight}
	 * 
	 * @return
	 */
	public NetworkWeight getWeights() {
		return networkWeights;
	}

}

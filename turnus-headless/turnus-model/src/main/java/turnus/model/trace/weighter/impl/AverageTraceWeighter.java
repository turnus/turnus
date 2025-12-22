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
package turnus.model.trace.weighter.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.common.io.Logger;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * Trace weighter taking the average value as the weight of each action in {@link NetworkWeight}.
 * The variance is calculated according to the min and max values.
 * 
 * @author Malgorzata Michalska
 *
 */
public class AverageTraceWeighter implements TraceWeighter, Cloneable {

	/** the network weights */
	private final NetworkWeight networkWeights;
	/** the weights table */
	private Table<String, String, Double> weightTable;
	/** the variance table */
	private Table<String, String, Double> varianceTable;

	/**
	 * Create a weighter (average values) given the network weights
	 * 
	 * @param networkWeights
	 */
	public AverageTraceWeighter(NetworkWeight networkWeights) {
		this.networkWeights = networkWeights;

		weightTable = HashBasedTable.create();
		varianceTable = HashBasedTable.create();
		for (Cell<String, String, ClockCycles> cell : networkWeights.asTable().cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			ClockCycles w = cell.getValue();

			double avg = w.getMeanClockCycles();
			double min = Math.min(w.getMinClockCycles(), avg);
			double max = Math.max(avg, w.getMaxClockCycles());
			double variance = Math.pow(((max - min) / 6.0), 2);
	
			weightTable.put(actor, action, avg);
			varianceTable.put(actor, action, variance);
		}
	}

	/**
	 * Private constructor used to clone the object
	 * 
	 * @param o
	 *            the original object
	 */
	private AverageTraceWeighter(AverageTraceWeighter o) {
		this.networkWeights = o.networkWeights;

		weightTable = HashBasedTable.create();
		varianceTable = HashBasedTable.create();

		for (Cell<String, String, Double> cell : o.weightTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			double value = cell.getValue();
			weightTable.put(actor, action, value);
		}

		for (Cell<String, String, Double> cell : o.varianceTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			double value = cell.getValue();
			varianceTable.put(actor, action, value);
		}

	}

	@Override
	public AverageTraceWeighter clone() {
		return new AverageTraceWeighter(this);
	}

	@Override
	public double getVariance(Dependency dependency) {
		return 0;
	}

	@Override
	public double getVariance(Step step) {
		String actor = step.getActor();
		String action = step.getAction();
		if (varianceTable.contains(actor, action)) {
			return varianceTable.get(actor, action);
		} else {
			Logger.debug("There is no weight for the step %d. 0 is set for (%s,%s)", step.getId(), actor, action);
			weightTable.put(actor, action, 0.0);
			varianceTable.put(actor, action, 0.0);
			return 0;
		}
	}

	@Override
	public double getWeight(Dependency dependency) {
		return 0;
	}

	@Override
	public double getWeight(Step step) {
		String actor = step.getActor();
		String action = step.getAction();
		if (weightTable.contains(actor, action)) {
			return weightTable.get(actor, action);
		} else {
			Logger.debug("There is no weight for the step %d. 0 is set for (%s,%s)", step.getId(), actor, action);
			weightTable.put(actor, action, 0.0);
			varianceTable.put(actor, action, 0.0);
			return 0;
		}
	}

	@Override
	public void setRatio(String actor, String action, double scale) {
		if (scale < 0) {
			Logger.error("The scale factor should be greater than 0");
			return;
		}

		ClockCycles w = networkWeights.getWeight(actor, action);
		double avg = scale * w.getMeanClockCycles();
		double min = Math.min(scale * w.getMinClockCycles(), avg);
		double max = Math.max(avg, scale * w.getMaxClockCycles());
		double variance = Math.pow(((max - min) / 6.0), 2);

		weightTable.put(actor, action, avg);
		varianceTable.put(actor, action, variance);
	}

}

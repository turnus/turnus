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

import turnus.model.trace.weighter.TraceWeighter;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import java.util.List;
import java.util.Map;

import com.google.common.collect.HashBasedTable;

import turnus.common.io.Logger;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * A trace partitioned trace weighter
 * @author Mahyar Emami
 */

public class CombinedTraceWeighter implements TraceWeighter, Cloneable {
	
	/** network weights table */
	private final Table<String, String, Double> weightTable;
	private final Table<String, String, Double> varTable;
	
	/**
	 * Create a combined weighter from hardware and software weighter
	 * for a specific partition
	 * @param hardwareWeighter
	 * @param softwareWeighter
	 * @param partitioning
	 */
	public CombinedTraceWeighter(Map<String, NetworkWeight> weights, Map<String, Double> clocks, 
			NetworkPartitioning partitioning) {
		
		this.weightTable = HashBasedTable.create();
		this.varTable = HashBasedTable.create();
		
		Map<String, List<String>> partitions = partitioning.asPartitionActorsMap();
		
		for (String part : partitions.keySet()) {
			
			Table<String, String, ClockCycles> wTable = weights.get(part).asTable();
			List<String> actorsInPartition = partitions.get(part);
			for (Cell<String, String, ClockCycles> cell : wTable.cellSet()) {
				
				String actor  = cell.getRowKey();
				String action = cell.getColumnKey();
				ClockCycles w = cell.getValue();
				
				if (actorsInPartition.contains(actor)) {
					/** Scale the weights to a clock given in nano seconds */
					ClockCycles weight = new ClockCycles();
					Double clock = clocks.get(part);
					weight.setMaxClockCycles(w.getMaxClockCycles() * clock);
					weight.setMinClockCycles(w.getMinClockCycles() * clock);
					weight.setMeanClockCycles(w.getMeanClockCycles() * clock);
					
					
					this.weightTable.put(actor,  action,  weight.getMeanClockCycles());
					this.varTable.put(actor,  action,  Double.valueOf(0));
				}
			}
	
			
		}	
	}
	
	/**
	 * Copy constructor
	 * @param obj
	 */
	private CombinedTraceWeighter(CombinedTraceWeighter obj) {
		this.weightTable = HashBasedTable.create();
		this.varTable = HashBasedTable.create();
		for (Cell<String, String, Double> cell : obj.weightTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			double value = cell.getValue();
			this.weightTable.put(actor,  action,  value);
		}
		
		for (Cell<String, String, Double> cell : obj.varTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			double value = cell.getValue();
			this.varTable.put(actor,  action,  value);
		}
		
	}
	
	@Override
	public CombinedTraceWeighter clone() {
		return new CombinedTraceWeighter(this);
	}
	
	@Override
	public double getVariance(Dependency dep) {
		return 0;
	}
	
	@Override
	public double getVariance(Step step) {
		return 0;
	}
	
	@Override 
	public double getWeight(Dependency dep) {
		return 0;
	}
	
	@Override 
	public double getWeight(Step step) {
		String actor = step.getActor();
		String action = step.getAction();
		if (this.weightTable.contains(action,  actor)) {
			return this.weightTable.get(actor,  action);
		} else {
			Logger.debug("There is no weight for the step %d. 0 is set for (%s,%s)", step.getId(), actor, action);
			weightTable.put(actor, action, 0.0);
			varTable.put(actor, action, 0.0);
			return 0;
		}
	}
	
	@Override
	public void setRatio(String actor, String action, double scale) {
		Logger.debug("Set ratio not supported for combined weights");
	}
	
}
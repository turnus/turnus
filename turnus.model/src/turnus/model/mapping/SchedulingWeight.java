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
package turnus.model.mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.model.dataflow.Network;
import turnus.model.mapping.data.ClockCycles;

public class SchedulingWeight {

	private String networkName;
	/**
	 * Table of [actor, action, source, weight]. When source is empty means that
	 * the action is scheduled by entering the first time in the actor FSM
	 */
	private Table<String, String, Map<String, ClockCycles>> actionSelectionTable = HashBasedTable.create();

	public SchedulingWeight(Network network) {
		this.networkName = network.getName();
	}

	public SchedulingWeight(String networkName) {
		this.networkName = networkName;
	}

	public ClockCycles getWeight(String actor, String action) {
		ClockCycles cycles = actionSelectionTable.contains(actor, action)
				? actionSelectionTable.get(actor, action).get("") : null;
		if (cycles != null) {
			return cycles;
		} else {
			// evaluate the minimal cost
			cycles = new ClockCycles();

			double minValue = Double.MAX_VALUE;
			if (actionSelectionTable.contains(actor, action)) {
				for (Entry<String, ClockCycles> e : actionSelectionTable.get(actor, action).entrySet()) {
					double value = e.getValue().getMinClockCycles();
					if (value < minValue) {
						minValue = value;
						cycles.setMaxClockCycles(minValue);
						cycles.setMinClockCycles(minValue);
						cycles.setMeanClockCycles(minValue);
					}
				}
			}

			Map<String, ClockCycles> map = actionSelectionTable.get(actor, action);
			if (map == null) {
				map = new HashMap<>();
				actionSelectionTable.put(actor, action, map);
			}
			map.put("", cycles);

			return cycles;

		}
	}
	
	public String getSrcAction(String actor, String action) {
		if (actionSelectionTable.contains(actor, action)) {
			Map<String, ClockCycles> map = actionSelectionTable.get(actor, action);
			return map.keySet().toString();
		}
		
		return null;
	}

	public ClockCycles getWeight(String actor, String lastAction, String action) {
		if (lastAction == null || lastAction.isEmpty()) {
			return getWeight(actor, action);
		}

		Map<String, ClockCycles> map = actionSelectionTable.get(actor, action);
		if (map == null) {
			map = new HashMap<>();
			actionSelectionTable.put(actor, action, map);
		}

		ClockCycles cycles = map.get(lastAction);
		if (cycles == null) {
			cycles = new ClockCycles();
			map.put(lastAction, cycles);
		}

		return cycles;

	}

	public void setWeight(String actor, String lastAction, String action, ClockCycles cl) {
		Map<String, ClockCycles> map = actionSelectionTable.get(actor, action);

		if (map == null) {
			map = new HashMap<>();
			actionSelectionTable.put(actor, action, map);
		}

		map.put(lastAction, cl);
	}

	public boolean contains(String actor, String action) {
		return (actionSelectionTable.contains(actor, action) ? 
					actionSelectionTable.get(actor, action).containsKey("") : false) ? 
							true : false;
	}	

	public boolean contains(String actor, String lastAction, String action) {
		if (lastAction == null || lastAction.isEmpty()) {
			return contains(actor, action);
		}

		if (actionSelectionTable.contains(actor, action) && 
			actionSelectionTable.get(actor, action).containsKey(lastAction))
			return true;
		else 
			return false;
	}
	
	public Table<String, String, Map<String, ClockCycles>> asTable() {
		Table<String, String, Map<String, ClockCycles>> table = HashBasedTable.create();
		for (Cell<String, String, Map<String, ClockCycles>> cell : actionSelectionTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			Map<String, ClockCycles> map = new HashMap<>();
			table.put(actor, action, map);
			for (Entry<String, ClockCycles> emap : cell.getValue().entrySet()) {
				map.put(emap.getKey(), emap.getValue().clone());
			}
		}
		return table;
	}

	public String getNetwork() {
		return networkName;
	}
	
	// TODO : implement me
	public boolean isValid(Network network) {
		return true;
	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("SchedulingWeights of \"").append(networkName).append("\"\n");
		for (Cell<String, String, Map<String, ClockCycles>> cell : actionSelectionTable.cellSet()) {
			b.append(cell.getRowKey()).append(", ").append(cell.getColumnKey());
			b.append("\n");
			for (Entry<String, ClockCycles> m : cell.getValue().entrySet()) {
				b.append(" to ").append(m.getKey());
				b.append(" == ").append(m.getValue().toString());
				b.append("\n");
			}
		}
		return b.toString();
	}

}

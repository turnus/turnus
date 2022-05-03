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

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.common.util.Pair;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.data.ClockCycles;

public class NetworkWeight {

	private String networkName;
	private Table<String, String, ClockCycles> weightsTable = HashBasedTable.create();

	public NetworkWeight(Network network) {
		this.networkName = network.getName();
	}

	public NetworkWeight(String networkName) {
		this.networkName = networkName;
	}

	public void clean(Network network) {
		networkName = network.getName();

		List<Pair<String, String>> toBeRemoved = new ArrayList<>();
		// check if there are no unvalid mapping
		for (Cell<String, String, ClockCycles> cell : weightsTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			Action obj = null;
			try {
				obj = network.getActor(actor).getAction(action);
			} catch (Exception e) {
				obj = null;
			}
			if (obj == null) {
				toBeRemoved.add(Pair.create(actor, action));
			}
		}

		for (Pair<String, String> c : toBeRemoved) {
			weightsTable.remove(c.v1, c.v2);
		}

		// check if all actions are mapped
		for (Actor actor : network.getActors()) {
			for (Action action : actor.getActions()) {
				if (!contains(action)) {
					weightsTable.put(action.getOwner().getName(), action.getName(), new ClockCycles());
				}
			}
		}

	}

	public ClockCycles getWeight(Action action) {
		return getWeight(action.getOwner().getName(), action.getName());
	}

	public void setWeight(Action action, ClockCycles cl) {
		setWeight(action.getOwner().getName(), action.getName(), cl);
	}

	public ClockCycles getWeight(String actor, String action) {
		ClockCycles weight = weightsTable.get(actor, action);
		if (weight == null) {
			weight = new ClockCycles();
			weightsTable.put(actor, action, weight);
		}
		return weight;
	}

	public void setWeight(String actor, String action, ClockCycles cl) {
		weightsTable.put(actor, action, cl);
	}

	public boolean contains(Action action) {
		return contains(action.getOwner().getName(), action.getName());
	}

	public boolean contains(String actor, String action) {
		return weightsTable.contains(actor, action);
	}

	public boolean isValid(Network network) {
		if (networkName.equals(network.getName())) {
			return false;
		}

		// check if all actions are mapped
		for (Actor actor : network.getActors()) {
			for (Action action : actor.getActions()) {
				if (!contains(action)) {
					return false;
				}
			}
		}

		// check if there are no unvalid mapping
		for (Cell<String, String, ClockCycles> cell : weightsTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			Action obj = null;
			try {
				obj = network.getActor(actor).getAction(action);
			} catch (Exception e) {
				obj = null;
			}
			if (obj == null) {
				return false;
			}

		}

		return true;
	}

	public Table<String, String, ClockCycles> asTable() {
		Table<String, String, ClockCycles> table = HashBasedTable.create();
		for (Cell<String, String, ClockCycles> cell : weightsTable.cellSet()) {
			String actor = cell.getRowKey();
			String action = cell.getColumnKey();
			table.put(actor, action, cell.getValue().clone());
		}
		return table;
	}

	public String getNetwork() {
		return networkName;
	}

}

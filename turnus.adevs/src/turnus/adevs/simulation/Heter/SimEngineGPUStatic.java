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
package turnus.adevs.simulation.Heter;

import java.util.Map;
import java.util.Map.Entry;

import turnus.common.configuration.Configuration;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Port;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.trace.weighter.WeighterUtils;

public class SimEngineGPUStatic extends SimEngineGPU {

	private Configuration configuration;
	private NetworkWeight weightsCPU;
	private NetworkWeight weightsGPU;
	private SchedulingWeight schWeightCPU;
	private SchedulingWeight schWeightGPU;
	private HeterComWeight heterComWeight;

	public SimEngineGPUStatic(
			Configuration configuration, 
			NetworkWeight weightsCPU, NetworkWeight weightsGPU, 
			SchedulingWeight schWeightCPU, SchedulingWeight schWeightGPU, 
			HeterComWeight heterComWeight) {
		this.configuration = configuration;
		this.weightsCPU = weightsCPU;
		this.weightsGPU = weightsGPU;
		this.schWeightCPU = schWeightCPU;
		this.schWeightGPU = schWeightGPU;
		this.heterComWeight = heterComWeight;
	}
	
	@Override
	public void setNetworkPartitioning(NetworkPartitioning partitioning) {
		super.setNetworkPartitioning(partitioning);
		updateWeight();
	}
	
	private void updateWeight() {
		
		SchedulingWeight schWeight = new SchedulingWeight(getNetwork());
		NetworkWeight weights = new NetworkWeight(getNetwork());
		
		for (Actor actor : getNetwork().getActors()) {
			String actorName = actor.getName();
			if (getNetworkPartitioning().getPartition(actorName).equals("PG")) {
				for (Action action: actor.getActions()) {
					weights.setWeight(action, weightsGPU.getWeight(action));
				}
				for (Entry<String, Map<String, ClockCycles>> map : schWeightGPU.asTable().row(actorName).entrySet()) {
					for ( Entry<String, ClockCycles> entry : map.getValue().entrySet()) {
						schWeight.setWeight(actorName, entry.getKey(), map.getKey(), entry.getValue());
					}
				}
			} else {
				for (Action action: actor.getActions()) {
					weights.setWeight(action, weightsCPU.getWeight(action));
				}
				for (Entry<String, Map<String, ClockCycles>> map : schWeightCPU.asTable().row(actorName).entrySet()) {
					for ( Entry<String, ClockCycles> entry : map.getValue().entrySet()) {
						schWeight.setWeight(actorName, entry.getKey(), map.getKey(), entry.getValue());
					}
				}
			}
		}

		// add communication weight in action
		for (Actor actor : getNetwork().getActors()) {
			String actorName = actor.getName();
			for (Action action: actor.getActions()) {
				String actionName = action.getName();
				for(Port port : action.getInputPorts()) {
					double latency = heterComWeight.getReadLatency(actor, port);
					ClockCycles cl = weights.getWeight(actorName, actionName);
					cl.setMeanClockCycles(latency + cl.getMeanClockCycles());
					cl.setMinClockCycles(latency + cl.getMinClockCycles());
					cl.setMaxClockCycles(latency + cl.getMaxClockCycles());
				}
				for(Port port : action.getOutputPorts()) {
					double latency = heterComWeight.getWriteLatency(actor, port);
					ClockCycles cl = weights.getWeight(actorName, actionName);
					cl.setMeanClockCycles(latency + cl.getMeanClockCycles());
					cl.setMinClockCycles(latency + cl.getMinClockCycles());
					cl.setMaxClockCycles(latency + cl.getMaxClockCycles());
				}
			}
		}

		setTraceWeighter(WeighterUtils.getTraceWeighter(configuration, weights));
		setSchedulingWeight(schWeight);
		// remove communication eights as they are integrated in the action weight itself
		setCommunicationWeight(null); 
	}

}

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

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import adevs.Simulator;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.adevs.logging.DataCollector;
import turnus.adevs.model.AdevsModel;
import turnus.adevs.model.AdevsModelBuilder;
import turnus.adevs.model.AtomicActor;
import turnus.adevs.model.AtomicActor.Status;
import turnus.adevs.model.AtomicActorPartition;
import turnus.adevs.model.AtomicBuffer;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.MathUtils;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Port;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class SimEngineGPUDynamic extends SimEngineGPU {

	private Configuration configuration;
	private NetworkWeight weights;
	private CommunicationWeight communication;

	public SimEngineGPUDynamic(Configuration configuration, NetworkWeight weights, SchedulingWeight schWeight, CommunicationWeight communication) {
		this.configuration = configuration;
		this.weights = weights;
		setSchedulingWeight(schWeight);
		this.communication = communication;
	}
	
	private void updateWeight() {
		Set<Buffer> buffers = communication.getBuffers();
		for (Actor actor : getNetwork().getActors()) {
			String actorName = actor.getName();
			for (Action action: actor.getActions()) {
				String actionName = action.getName();
				for(Port port : action.getInputPorts()) {
					Buffer buffer = buffers.stream()
							.filter(b -> b.getTarget() == port)
							.findFirst()
							.orElseGet(() -> null);
					if (buffer != null) {
						double latency = communication.getReadWeights(buffer).get(0).getLatency();
						ClockCycles cl = weights.getWeight(actorName, actionName);
						cl.setMeanClockCycles(latency + cl.getMeanClockCycles());
						cl.setMinClockCycles(latency + cl.getMinClockCycles());
						cl.setMaxClockCycles(latency + cl.getMaxClockCycles());
					}
				}
				for(Port port : action.getOutputPorts()) {
					Buffer buffer = buffers.stream()
							.filter(b -> b.getSource() == port)
							.findFirst().orElseGet(() -> null);
					if (buffer != null) {
						double latency = communication.getWriteWeights(buffer).get(0).getLatency();
						ClockCycles cl = weights.getWeight(actorName, actionName);
						cl.setMeanClockCycles(latency + cl.getMeanClockCycles());
						cl.setMinClockCycles(latency + cl.getMinClockCycles());
						cl.setMaxClockCycles(latency + cl.getMaxClockCycles());
					}
				}
			}
		}
		setTraceWeighter(WeighterUtils.getTraceWeighter(configuration, weights));
		// remove communication eights as they are integrated in the action weight itself
		setCommunicationWeight(null); 
	}
	
	@Override
	public void setNetworkPartitioning(NetworkPartitioning partitioning) {
		super.setNetworkPartitioning(partitioning);
		updateWeight();
	}
}

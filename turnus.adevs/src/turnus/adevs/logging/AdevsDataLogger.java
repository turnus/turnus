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
package turnus.adevs.logging;

import java.util.Collection;
import java.util.HashSet;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class AdevsDataLogger {

	private Collection<DataCollector> collectors = new HashSet<>();
	private Collection<ActorDataCollector> actorDataCollectors = new HashSet<ActorDataCollector>();
	private Collection<ActorPartitionDataCollector> actorPartitionDataCollectors = new HashSet<ActorPartitionDataCollector>();

	public AdevsDataLogger() {
	}

	public void addDataCollector(DataCollector collector) {
		collectors.add(collector);

		if (collector instanceof ActorDataCollector) {
			actorDataCollectors.add((ActorDataCollector) collector);
		}

		if (collector instanceof ActorPartitionDataCollector) {
			actorPartitionDataCollectors.add((ActorPartitionDataCollector) collector);
		}
	}

	public void init() {
		for (DataCollector collector : collectors) {
			collector.init();
		}
	}

	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logBlockedReading(action, stepId, time, emptyBuffer);
		}
	}

	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logBlockedWriting(action, stepId, time, fullBuffer, tokens);
		}
	}

	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logConsumeTokens(action, stepId, buffer, tokens, time);
		}
	}

	public void logEndFiring(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logEndFiring(action, stepId, time);
		}
	}

	public void logIsEnabled(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logIsEnabled(action, stepId, time);
		}
	}

	public void logIsSchedulable(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logIsSchedulable(action, stepId, time);
		}
	}

	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logProduceTokens(action, stepId, buffer, tokens, time);
		}
	}

	public void logScheduleActor(String partitionId, Actor actor, double time) {
		for (ActorPartitionDataCollector collector : actorPartitionDataCollectors) {
			collector.logScheduleActor(partitionId, actor, time);
		}
	}
	
	public void logCheckActor(String partitionId, Actor actor, double time) {
		for (ActorPartitionDataCollector collector : actorPartitionDataCollectors) {
			collector.logCheckActor(partitionId, actor, time);
		}
	}
	
	public void logCheckedConditions(Action action, long stepId, int conditionsChecked, boolean isInput, double time) {
		for (ActorPartitionDataCollector collector : actorPartitionDataCollectors) {
			collector.logCheckedConditions(action.getOwner(), conditionsChecked, isInput, time);
		}
	}
	
	public void logFailedConditions(Action action, long stepId, int conditionsFailed, boolean isInput, double time) {
		for (ActorPartitionDataCollector collector : actorPartitionDataCollectors) {
			collector.logFailedConditions(action.getOwner(), conditionsFailed, isInput, time);
		}
	}
	
	public void logActorTerminated(String partitionId, Actor actor, double time) {
		for (ActorPartitionDataCollector collector : actorPartitionDataCollectors) {
			collector.logActorTerminated(partitionId, actor, time);
		}
	}

	public void logStartProcessing(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logStartProcessing(action, stepId, time);
		}
	}
	
	public void logEndProcessing(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logEndProcessing(action, stepId, time);
		}
	}

	public void logStartProducing(Action action, long stepId, double time) {
		for (ActorDataCollector collector : actorDataCollectors) {
			collector.logStartProducing(action, stepId, time);
		}
	}
	
	public void logEndSimulation(double endSimulationTime){
		for (DataCollector collector : collectors) {
			collector.logEndSimulation(endSimulationTime);
		}
	}
}

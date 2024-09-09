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
package turnus.adevs.logging.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.logging.impl.data.StatisticalPostData;
import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class ActionStatisticsCollector implements ActorDataCollector {

	private Map<Action, StatisticalPostData> data;
	private Network network;
	
	public ActionStatisticsCollector(Network network) {
		this.network = network;
		init();
	}
	
	@Override
	public void init() {
		data = new HashMap<Action, StatisticalPostData>();
		for (Actor actor : network.getActors()) {
			for (Action action : actor.getActions()) {
				data.put(action, new StatisticalPostData());
			}
		}
	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		StatisticalPostData targetData = data.get(action);
		if (!targetData.isSchedulable()) {
			targetData.setSchedulable(true);
			targetData.setSchedulableStart(time);
	
			double currentBReadingTime;
			if (targetData.isBReading()) {
				targetData.setBReading(false);
				currentBReadingTime = time - targetData.getbReadingStart();
				targetData.setbReadingTime(targetData.getbReadingTime() + currentBReadingTime);
			}
			else {
				currentBReadingTime = 0;
			}
			if (currentBReadingTime < targetData.getbReadingMin()) {
				targetData.setbReadingMin(currentBReadingTime);
			}
			if (currentBReadingTime > targetData.getbReadingMax()) {
				targetData.setbReadingMax(currentBReadingTime);
			}
			
			double currentBWritingTime;
			if (targetData.isBWriting()) {
				targetData.setBWriting(false);
				currentBWritingTime = time - targetData.getbWritingStart();
				targetData.setbWritingTime(targetData.getbWritingTime() + currentBWritingTime);
			}
			else {
				currentBWritingTime = 0;
			}
			if (currentBWritingTime < targetData.getbWritingMin()) {
				targetData.setbWritingMin(currentBWritingTime);
			}
			if (currentBWritingTime > targetData.getbWritingMax()) {
				targetData.setbWritingMax(currentBWritingTime);
			}
		}
	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		StatisticalPostData targetData = data.get(action);
		if (!targetData.isProcessing()) {
			targetData.setProcessing(true);
			targetData.setProcessingStart(time);
			
			if (targetData.isSchedulable()) {
				targetData.setSchedulable(false);
				double currentSchedulableTime = time - targetData.getSchedulableStart();
				targetData.setSchedulableTime(targetData.getSchedulableTime() + currentSchedulableTime);
				if (currentSchedulableTime < targetData.getSchedulableMin()) {
					targetData.setSchedulableMin(currentSchedulableTime);
				}
				if (currentSchedulableTime > targetData.getSchedulableMax()) {
					targetData.setSchedulableMax(currentSchedulableTime);
				}
			}
		}
		targetData.increaseExecutionCount();
	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		StatisticalPostData targetData = data.get(action);
		if (targetData.isProcessing()) {
			targetData.setProcessing(false);
			targetData.setProcessingTime(targetData.getProcessingTime() + (time - targetData.getProcessingStart()));
		}
	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		StatisticalPostData targetData = data.get(action);
		if (!targetData.isBReading()) {
			targetData.setBReading(true);
			targetData.setbReadingStart(time);
		}
	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		StatisticalPostData targetData = data.get(action);
		if (!targetData.isBWriting()) {
			targetData.setBWriting(true);
			targetData.setbWritingStart(time);
		}
	}

	@Override
	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		// TODO Auto-generated method stub
	}

	public ActionStatisticsReport generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		ActionStatisticsReport report = f.createActionStatisticsReport();
		
		report.setNetwork(network);
		
		report.getActors().addAll(network.getActors());
		
		for (Entry<Action, Double> entry : getIdleTimes().entrySet()) {
			report.getIdleTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getIdleMin().entrySet()) {
			double minValue = (entry.getValue() == Double.MAX_VALUE) ? 0.0 : entry.getValue();
			report.getIdleMinTimes().put(entry.getKey(), minValue);
		}
		for (Entry<Action, Double> entry : getIdleMax().entrySet()) {
			report.getIdleMaxTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getBlockedReadingTimes().entrySet()) {
			report.getBlockedReadingTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getBlockedReadingMin().entrySet()) {
			double minValue = (entry.getValue() == Double.MAX_VALUE) ? 0.0 : entry.getValue();
			report.getBlockedReadingMinTimes().put(entry.getKey(), minValue);
		}
		for (Entry<Action, Double> entry : getBlockedReadingMax().entrySet()) {
			report.getBlockedReadingMaxTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getBlockedWritingTimes().entrySet()) {
			report.getBlockedWritingTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getBlockedWritingMin().entrySet()) {
			double minValue = (entry.getValue() == Double.MAX_VALUE) ? 0.0 : entry.getValue();
			report.getBlockedWritingMinTimes().put(entry.getKey(), minValue);
		}
		for (Entry<Action, Double> entry : getBlockedWritingMax().entrySet()) {
			report.getBlockedWritingMaxTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Double> entry : getProcessingTimes().entrySet()) {
			report.getProcessingTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<Action, Long> entry : getExecutionCounts().entrySet()) {
			report.getExecutionCounts().put(entry.getKey(), entry.getValue());
		}
		
		return report;
	}
	
	private Map<Action, Double> getBlockedReadingTimes() {
		Map<Action, Double> blockedReadingTimes = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedReadingTimes.put(action, data.get(action).getbReadingTime());
		}
		
		return blockedReadingTimes;
	}
	
	private Map<Action, Double> getBlockedReadingMin() {
		Map<Action, Double> blockedReadingMin = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedReadingMin.put(action, data.get(action).getbReadingMin());
		}
		
		return blockedReadingMin;
	}
	
	private Map<Action, Double> getBlockedReadingMax() {
		Map<Action, Double> blockedReadingMax = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedReadingMax.put(action, data.get(action).getbReadingMax());
		}
		
		return blockedReadingMax;
	}
	
	private Map<Action, Double> getBlockedWritingTimes() {
		Map<Action, Double> blockedWritingTimes = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedWritingTimes.put(action, data.get(action).getbWritingTime());
		}
		
		return blockedWritingTimes;
	}
	
	private Map<Action, Double> getBlockedWritingMin() {
		Map<Action, Double> blockedWritingMin = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedWritingMin.put(action, data.get(action).getbWritingMin());
		}
		
		return blockedWritingMin;
	}
	
	private Map<Action, Double> getBlockedWritingMax() {
		Map<Action, Double> blockedWritingMax = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			blockedWritingMax.put(action, data.get(action).getbWritingMax());
		}
		
		return blockedWritingMax;
	}
	
	private Map<Action, Double> getIdleTimes() {
		Map<Action, Double> idleTimes = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			idleTimes.put(action, data.get(action).getSchedulableTime());
		}
		
		return idleTimes;
	}
	
	private Map<Action, Double> getIdleMin() {
		Map<Action, Double> idleMin = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			idleMin.put(action, data.get(action).getSchedulableMin());
		}
		
		return idleMin;
	}
	
	private Map<Action, Double> getIdleMax() {
		Map<Action, Double> idleMax = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			idleMax.put(action, data.get(action).getSchedulableMax());
		}
		
		return idleMax;
	}
	
	private Map<Action, Double> getProcessingTimes() {
		Map<Action, Double> processingTimes = new HashMap<Action, Double>();
		for (Action action : data.keySet()) {
			processingTimes.put(action, data.get(action).getProcessingTime());
		}
		
		return processingTimes;
	}
	
	private Map<Action, Long> getExecutionCounts() {
		Map<Action, Long> executionCounts = new HashMap<Action, Long>();
		for (Action action : data.keySet()) {
			executionCounts.put(action, data.get(action).getExecutionCount());
		}
		
		return executionCounts;
	}

	@Override
	public void logEndSimulation(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logEndProduceTokens(Action action, long stepId, Buffer buffer, double time) {
		// TODO Auto-generated method stub
		
	}
}

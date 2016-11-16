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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.logging.impl.data.StatisticalPostData;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class ActorStatisticsCollector implements ActorDataCollector, Cloneable {
	
	public class PartitionIdleCollector implements Cloneable {
		
		public class PartitionIdleData {
			public int workingNumber;
			public boolean idle = true;
			public double idleStart;
			public double idleTime;
		}

		NetworkPartitioning partitioning;
		Map<String, PartitionIdleData> partitionData = new HashMap<String, PartitionIdleData>(); 
		
		public PartitionIdleCollector(NetworkPartitioning partitioning) {
			this.partitioning = partitioning;
			for (String component : partitioning.asPartitionActorsMap().keySet()) {
				partitionData.put(component, new PartitionIdleData());
			}
		}

		public void logIsEnabled(Action action, long stepId, double time) {
			PartitionIdleData data = partitionData.get(partitioning.getPartition(action.getOwner()));
			data.workingNumber++;
			if (data.idle) {
				data.idleTime += (time - data.idleStart);
				data.idle = false;
			}
		}

		public void logEndFiring(Action action, long stepId, double time) {
			PartitionIdleData data = partitionData.get(partitioning.getPartition(action.getOwner()));
			data.workingNumber--;
			if (!data.idle && data.workingNumber == 0) {
				data.idle = true;
				data.idleStart = time;
			}
		}

		public Map<String, Double> getPartitionIdleData(double executionTime) {
			Map<String, Double> data = new HashMap<String, Double>();
			for (String component : partitionData.keySet()) {
				if (partitionData.get(component).idle) {
					partitionData.get(component).idleTime += (executionTime - partitionData.get(component).idleStart);
					partitionData.get(component).idle = false;
				}
				data.put(component, partitionData.get(component).idleTime);
			}
			
			return data;
		}
		
		@Override
		public PartitionIdleCollector clone() {
			PartitionIdleCollector collector = new PartitionIdleCollector(partitioning);
			collector.partitionData = new HashMap<String, PartitionIdleData>(partitionData);
			
			return partitionIdleCollector;
			
		}
	}
	
	private Network network;
	private NetworkPartitioning partitioning;
	private PartitionIdleCollector partitionIdleCollector;
	private Map<String, StatisticalPostData> data;
	private double simulationTime;
	
	public ActorStatisticsCollector(Network network, NetworkPartitioning partitioning) {
		this.network = network;
		this.partitioning = partitioning;
		init();
	}
	
	@Override
	public void init() {
		simulationTime = 0;
		data = new HashMap<String, StatisticalPostData>();
		for (Actor actor : network.getActors()) {
			data.put(actor.getName(), new StatisticalPostData());
		}
		partitionIdleCollector = new PartitionIdleCollector(partitioning);
	}
	
	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		String actor = action.getOwner().getName();
		StatisticalPostData targetData = data.get(actor);
		if (!targetData.isSchedulable()) {
			targetData.setSchedulable(true);
			targetData.setSchedulableStart(time);
			
			if (targetData.isBReading()) {
				targetData.setBReading(false);
				targetData.setbReadingTime(targetData.getbReadingTime() + (time - targetData.getbReadingStart()));
			}
			else if (targetData.isBWriting()) {
				targetData.setBWriting(false);
				targetData.setbWritingTime(targetData.getbWritingTime() + (time - targetData.getbWritingStart()));
			}
		}
	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		String actor = action.getOwner().getName();
		StatisticalPostData targetData = data.get(actor);
		if (!targetData.isProcessing()) {
			targetData.setProcessing(true);
			targetData.setProcessingStart(time);
			
			if (targetData.isSchedulable()) {
				targetData.setSchedulable(false);
				targetData.setSchedulableTime(targetData.getSchedulableTime() + (time - targetData.getSchedulableStart()));
			}
		}
		targetData.increaseExecutionCount();
		
		partitionIdleCollector.logIsEnabled(action, stepId, time);
	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {
	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		String actor = action.getOwner().getName();
		StatisticalPostData targetData = data.get(actor);
		if (targetData.isProcessing()) {
			targetData.setProcessing(false);
			targetData.setProcessingTime(targetData.getProcessingTime() + (time - targetData.getProcessingStart()));
		}
		
		partitionIdleCollector.logEndFiring(action, stepId, time);
	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		String actor = action.getOwner().getName();
		StatisticalPostData targetData = data.get(actor);
		if (!targetData.isBReading()) {
			targetData.setBReading(true);
			targetData.setbReadingStart(time);
		}
	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		String actor = action.getOwner().getName();
		StatisticalPostData targetData = data.get(actor);
		if (!targetData.isBWriting()) {
			targetData.setBWriting(true);
			targetData.setbWritingStart(time);
		}
	}

	@Override
	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
	}
	
	@Override
	public ActorStatisticsReport generateReport() {
		Map<String, Double> partitionIdleData = partitionIdleCollector.getPartitionIdleData(simulationTime);
		
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		ActorStatisticsReport report = f.createActorStatisticsReport();
		report.setNetwork(network);
		report.setExecutionTime(simulationTime);
		
		for (Entry<String, Double> entry : getIdleTimes().entrySet()) {
			report.getIdleTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<String, Double> entry : getBlockedReadingTimes().entrySet()) {
			report.getBlockedReadingTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<String, Double> entry : getBlockedWritingTimes().entrySet()) {
			report.getBlockedWritingTimes().put(entry.getKey(), entry.getValue());
		}
		for (Entry<String, Double> entry : getProcessingTimes().entrySet()) {
			report.getProcessingTimes().put(entry.getKey(), entry.getValue());
		}
		
		double avg = 0;
		for (Entry<String, List<String>> entry : partitioning.asPartitionActorsMap().entrySet()) {
			StatisticalActorPartition partition = f.createStatisticalActorPartition();
			partition.getActors().addAll(entry.getValue());
			partition.setSchedulingPolicy(partitioning.getScheduler(entry.getKey()));
			
			double workloadPc = simulationTime - partitionIdleData.get(entry.getKey());
			workloadPc /= simulationTime;
			workloadPc *= 100;
			avg += workloadPc;
			
			partition.setOccupancy(workloadPc);
			
			report.getPartitions().add(partition);
		}
		avg /= partitioning.asPartitionActorsMap().size();
		
		report.setAverageOccupancy(avg);
		report.setOccupancyDeviation(stddev(report, avg));
	
		return report;
	}
	
	private Map<String, Double> getBlockedReadingTimes() {
		Map<String, Double> blockedReadingTimes = new HashMap<String, Double>();
		for (String targetName : data.keySet()) {
			blockedReadingTimes.put(targetName, data.get(targetName).getbReadingTime());
		}
		
		return blockedReadingTimes;
	}
	
	private Map<String, Double> getBlockedWritingTimes() {
		Map<String, Double> blockedWritingTimes = new HashMap<String, Double>();
		for (String targetName : data.keySet()) {
			blockedWritingTimes.put(targetName, data.get(targetName).getbWritingTime());
		}
		
		return blockedWritingTimes;
	}
	
	public Map<String, Double> getIdleTimes() {
		Map<String, Double> idleTimes = new HashMap<String, Double>();
		for (String targetName : data.keySet()) {
			idleTimes.put(targetName, data.get(targetName).getSchedulableTime());
		}
		
		return idleTimes;
	}
	
	public Map<String, Double> getProcessingTimes() {
		Map<String, Double> processingTimes = new HashMap<String, Double>();
		for (String targetName : data.keySet()) {
			processingTimes.put(targetName, data.get(targetName).getProcessingTime());
		}
		
		return processingTimes;
	}
	
	private double stddev(ActorStatisticsReport report, double average) {
		double sumsquared = 0;
		for (StatisticalActorPartition p : report.getPartitions()) {
			sumsquared += Math.pow(p.getOccupancy() - average, 2);
		}
		
		return Math.sqrt(sumsquared/report.getPartitions().size());
	}
	
	public Map<String, Double> getPartitionIdleTimes(double time) {
		return partitionIdleCollector.getPartitionIdleData(time);
	}

	@Override
	public void logEndSimulation(double simulationTime) {
		this.simulationTime = simulationTime;
	}
	
	@Override
	public ActorStatisticsCollector clone() {
		ActorStatisticsCollector copy = new ActorStatisticsCollector(network, partitioning);
		copy.partitionIdleCollector = partitionIdleCollector.clone();
		copy.data = new HashMap<String, StatisticalPostData>(data);
		copy.simulationTime = simulationTime;
		
		return copy;
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
		
	}
}

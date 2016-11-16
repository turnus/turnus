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
package turnus.analysis.bottlenecks.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.util.concurrent.AtomicLongMap;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.logging.ActorPartitionDataCollector;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksFactory;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class CriticalPathCollector implements ActorDataCollector, ActorPartitionDataCollector {

	private class ActionData {
		long totalFirings = 0;
		double totalWeight = 0;

		// double isSchedulable;
		double isEnabled;
		// double endFiring;

		void addFiring(double weight) {
			totalFirings++;
			totalWeight += weight;
		}

		ActionData() {
			reset();
		}

		void reset() {
			isEnabled = Double.MAX_VALUE;
			// isSchedulable = Double.MAX_VALUE;
			// endFiring = Double.MAX_VALUE;
		}
	}

	private class FullParallelPartitionData extends PartitionData {

		Map<Actor, Pcp> lastPcpMap = new HashMap<>();
		Pcp highestPcp;

		FullParallelPartitionData(String partition, List<Actor> actors) {
			super(partition);
			
			highestPcp = new Pcp(partition);
			for (Actor actor : actors) {
				lastPcpMap.put(actor, new Pcp(partition));
			}
		}

		@Override
		Pcp getHighestPcp() {
			return highestPcp;
		}

		@Override
		Pcp getLastPcp(Action action) {
			return lastPcpMap.get(action.getOwner());
		}

		@Override
		void setLastPcp(Action action, Pcp data) {
			if (lastPcpMap.containsKey(action.getOwner())) {
				Pcp lastPcp = lastPcpMap.get(action.getOwner());
				if (data.compareTo(lastPcp) < 0) {
					lastPcpMap.put(action.getOwner(), data);
				}

				if (data.compareTo(highestPcp) < 0) {
					highestPcp = data;
				}
			} else {
				// TODO add exception
				Logger.error("Action %s is executing in the wrong partition!", action.toString());
			}
		}

	}

	private class GenericPartitionData extends PartitionData {

		Pcp lastPcp;
		
		GenericPartitionData(String partition) {
			super(partition);
			lastPcp = new Pcp(partition);
		}

		@Override
		Pcp getHighestPcp() {
			return lastPcp;
		}

		@Override
		Pcp getLastPcp(Action action) {
			return lastPcp;
		}

		@Override
		void setLastPcp(Action action, Pcp data) {
			if (data.compareTo(lastPcp) < 0) {
				lastPcp = data;
			}
		}
	}

	private abstract class PartitionData {
		
		final String partition;

		double lastEndOfFiring = 0;
		double lastNewEnable = 0;

		abstract Pcp getHighestPcp();

		abstract Pcp getLastPcp(Action action);

		abstract void setLastPcp(Action action, Pcp data);
		
		PartitionData(String partition){
			this.partition = partition;
		}
		
		double blockingTime(){
			return lastNewEnable - lastEndOfFiring;
		}

	}

	private class Pcp implements Comparable<Pcp>, Cloneable {
		
		final String partition;

		// the time when this pcp object has been released by the action
		double finishTime;

		AtomicLongMap<Action> pcpFirings;
		Map<Action, Double> sumPcpWeightMap;
		Map<Action, Map<Buffer, Integer>> maxBlockedTokens;
		Map<Action, Map<Buffer, Double>> maxBlockedMultiplication;
		Map<Action, Map<Buffer, Integer>> blockingInstances;
		Map<String, Double> partitionsBlockingMap;

		Pcp(String partition) {
			this.partition = partition;
			finishTime = 0;
			pcpFirings = AtomicLongMap.create();
			sumPcpWeightMap = new HashMap<>();
			maxBlockedTokens = new HashMap<>();
			maxBlockedMultiplication = new HashMap<>();
			blockingInstances = new HashMap<>();
			partitionsBlockingMap = new HashMap<>();
		}

		Pcp(Pcp o) {
			partition = o.partition;
			finishTime = o.finishTime;
			pcpFirings = AtomicLongMap.create(o.pcpFirings.asMap());
			sumPcpWeightMap = new HashMap<>(o.sumPcpWeightMap);
			maxBlockedTokens = new HashMap<>(o.maxBlockedTokens);
			maxBlockedMultiplication = new HashMap<>(o.maxBlockedMultiplication);
			blockingInstances = new HashMap<>(o.blockingInstances);
			partitionsBlockingMap = new HashMap<>(o.partitionsBlockingMap);
		}

		public Pcp clone() {
			return new Pcp(this);
		}

		@Override
		public int compareTo(Pcp o) {
			int value = Double.compare(o.finishTime, finishTime);
			if (value == 0)
				return Double.compare(o.getPcpTotalWeight(), getPcpTotalWeight());
			
			return value;
		}

		void setBlockedBuffer(Action action, Map<Buffer, Integer> blockedBuffer) {
			if (!blockedBuffer.isEmpty()) {
				Map<Buffer, Integer> blockedTokens = maxBlockedTokens.get(action);
				if (blockedTokens == null) {
					blockedTokens = new HashMap<>(blockedBuffer);
					maxBlockedTokens.put(action, blockedTokens);
				} else {
					for (Entry<Buffer, Integer> e : blockedBuffer.entrySet()) {
						Buffer b = e.getKey();
						int value = e.getValue();
						
						if (blockedTokens.containsKey(b)) {
							value = Math.max(value, blockedTokens.get(b));
						}
						blockedTokens.put(b, value);
					}
				}
			}
		}
		
		void setBlockingInstances(Action action, Map<Buffer, Integer> blockedBuffer) {
			if (!blockedBuffer.isEmpty()) {
				Map<Buffer, Integer> blocking = blockingInstances.get(action);
				if (blocking == null) {
					blocking = new HashMap<>(blockedBuffer);
					blockingInstances.put(action, blocking);
				} else {
					for (Entry<Buffer, Integer> e : blockedBuffer.entrySet()) {
						Buffer b = e.getKey();
						int value = e.getValue();
						if (blocking.containsKey(b)) {
							value = value + blocking.get(b);
						}
						blocking.put(b, value);
					}
				}
			}
		}
		
		void setBlockedMultiplication(Action action, Map<Buffer, Double> blockedMultiplication) {
			if (!blockedMultiplication.isEmpty()) {
				Map<Buffer, Double> blocking = maxBlockedMultiplication.get(action);
				if (blocking == null) {
					blocking = new HashMap<>(blockedMultiplication);
					maxBlockedMultiplication.put(action, blocking);
				} else {
					for (Entry<Buffer, Double> e : blockedMultiplication.entrySet()) {
						Buffer b = e.getKey();
						double value = e.getValue();
						if (blocking.containsKey(b)) {
							value = Math.max(value, blocking.get(b));
						}
						blocking.put(b, value);
					}
				}
			}
		}

		void evaluate(Pcp lastIncomingPcp, double partitionBlockingTime) {
			for (Entry<Action, Double> e : lastIncomingPcp.sumPcpWeightMap.entrySet()) {
				double sumWeigth = e.getValue();
				Action action = e.getKey();
				if (sumPcpWeightMap.containsKey(action)) {
					sumWeigth += sumPcpWeightMap.getOrDefault(action, 0.0);
				}
				sumPcpWeightMap.put(action, sumWeigth);
			}

			for (Entry<Action, Long> entry : lastIncomingPcp.pcpFirings.asMap().entrySet()) {
				pcpFirings.addAndGet(entry.getKey(), entry.getValue());
			}

			for (Entry<String, Double> e : lastIncomingPcp.partitionsBlockingMap.entrySet()) {
				String pId = e.getKey();
				double sumWeigth = e.getValue();
				if (partitionsBlockingMap.containsKey(pId)) {
					sumWeigth += partitionsBlockingMap.get(pId);
				}
				partitionsBlockingMap.put(pId, sumWeigth);
			}

			for (Entry<Action, Map<Buffer, Integer>> entry : lastIncomingPcp.maxBlockedTokens.entrySet()) {
				Action action = entry.getKey();
				Map<Buffer, Integer> actionBlockedTokens = maxBlockedTokens.get(action);
				if (actionBlockedTokens == null) {
					actionBlockedTokens = new HashMap<>();
					maxBlockedTokens.put(action, actionBlockedTokens);
				}

				for (Entry<Buffer, Integer> e : entry.getValue().entrySet()) {
					Buffer buffer = e.getKey();
					int tokens = e.getValue();
					if (actionBlockedTokens.containsKey(buffer)) {
						tokens = Math.max(tokens, actionBlockedTokens.get(buffer));
					}
					actionBlockedTokens.put(buffer, tokens);
				}
			}
			
			for (Entry<Action, Map<Buffer, Integer>> entry : lastIncomingPcp.blockingInstances.entrySet()) {
				Action action = entry.getKey();
				Map<Buffer, Integer> actionBlockingInstances = blockingInstances.get(action);
				if (actionBlockingInstances == null) {
					actionBlockingInstances = new HashMap<>();
					blockingInstances.put(action, actionBlockingInstances);
				}

				for (Entry<Buffer, Integer> e : entry.getValue().entrySet()) {
					Buffer buffer = e.getKey();
					int blocking = e.getValue();
					if (actionBlockingInstances.containsKey(buffer)) {
						blocking = blocking + actionBlockingInstances.get(buffer);
					}
					actionBlockingInstances.put(buffer, blocking);
				}
			}
			
			for (Entry<Action, Map<Buffer, Double>> entry : lastIncomingPcp.maxBlockedMultiplication.entrySet()) {
				Action action = entry.getKey();
				Map<Buffer, Double> actionBlockedMultiplication = maxBlockedMultiplication.get(action);
				if (actionBlockedMultiplication == null) {
					actionBlockedMultiplication = new HashMap<>();
					maxBlockedMultiplication.put(action, actionBlockedMultiplication);
				}

				for (Entry<Buffer, Double> e : entry.getValue().entrySet()) {
					Buffer buffer = e.getKey();
					double multiplication = e.getValue();
					if (actionBlockedMultiplication.containsKey(buffer)) {
						multiplication = Math.max(multiplication, actionBlockedMultiplication.get(buffer));
					}
					actionBlockedMultiplication.put(buffer, multiplication);
				}
			}
			
			// the blocking time is logged only if the highest pcp comes from the same partition
			if(partition.equals(lastIncomingPcp.partition)){
				if(partitionsBlockingMap.containsKey(partition)){
					partitionBlockingTime += partitionsBlockingMap.get(partition);
				}
				partitionsBlockingMap.put(partition, partitionBlockingTime);
			}
		}

		void setExecutionWeight(Action action, double weight) {
			pcpFirings.incrementAndGet(action);
			sumPcpWeightMap.put(action,
					weight + (sumPcpWeightMap.containsKey(action) ? sumPcpWeightMap.get(action) : 0));
		}
		
		double getPcpTotalWeight() {
			double sum = 0;
			
			for (Action a : sumPcpWeightMap.keySet()) {
				sum += sumPcpWeightMap.get(a);
			}
			
			return sum;
		}

	}

	private class ActionBlockedOutBuffers {
		final Map<Buffer, Integer> maxTokens = new HashMap<>();
		final Map<Buffer, Double> maxMultiplication = new HashMap<>();
		final Map<Buffer, Integer> bTokens = new HashMap<>();
		final Map<Buffer, Double> bTime = new HashMap<>();
		final Map<Buffer, Integer> bInstances = new HashMap<>();

		void logBlocked(Buffer buffer, int tokens, double time) {
			if (!bTokens.containsKey(buffer)) {
				bTokens.put(buffer, tokens);
				bTime.put(buffer, time);
				bInstances.put(buffer, 1);
				maxTokens.put(buffer, tokens);
			}
		}
		
		void logReleased(Buffer buffer, double time) {
			if (bTokens.containsKey(buffer)) {
				double criterion = bTokens.get(buffer) * (time - bTime.get(buffer));
				if (maxMultiplication.containsKey(buffer)) {
					criterion = Math.max(criterion, maxMultiplication.get(buffer));
				}
				maxMultiplication.put(buffer, criterion);
			}
		}
	}

	private final Network network;
	private final NetworkPartitioning partitioning;
	private Map<Actor, PartitionData> actorsPartitionMap;
	private BiMap<String, PartitionData> partitionsData;
	private Map<Buffer, ArrayDeque<Pcp>> pcpTokens;
	private Map<Action, Pcp> actionsPcp;
	private Map<Action, ActionBlockedOutBuffers> blockedTokensMap;
	private Map<Action, ActionData> actionsData;
	private double executionTime;

	public CriticalPathCollector(Network network, NetworkPartitioning partitioning) {
		this.network = network;
		this.partitioning = partitioning;
	}

	@Override
	public BottlenecksWithSchedulingReport generateReport() {

		BottlenecksFactory f = BottlenecksFactory.eINSTANCE;
		BottlenecksWithSchedulingReport report = f.createBottlenecksWithSchedulingReport();
		report.setNetwork(network);
		report.setDate(new Date());
		report.setAlgorithm("Bottleneck with scheduling through ETG post-processing");
		report.setExecutionTime(executionTime);

		List<Pcp> pcps = new ArrayList<>();
		for (Entry<String, PartitionData> e : partitionsData.entrySet()) {
			pcps.add(e.getValue().getHighestPcp());
		}
		Collections.sort(pcps);

		Pcp cp = pcps.get(0);
		
		for(Entry<String, Double> e : cp.partitionsBlockingMap.entrySet()){
			report.getCpPartitionsBlockingTime().put(e.getKey(), e.getValue());
		}

		for (Actor actor : network.getActors()) {
			for (Action action : actor.getActions()) {
				ActionBottlenecksWithSchedulingData data = f.createActionBottlenecksWithSchedulingData();
				data.setAction(action);

				// copy overall execution data
				ActionData aData = actionsData.get(action);
				data.setTotalFirings(aData.totalFirings);
				data.setTotalWeight(aData.totalWeight);

				// copy cp data if any
				if (cp.pcpFirings.containsKey(action)) {
					data.setCpFirings(cp.pcpFirings.get(action));
					data.setCpWeight(cp.sumPcpWeightMap.get(action));
				}

				if (cp.maxBlockedTokens.containsKey(action)) {
					Map<Buffer, Integer> maxBlockedTokensMap = cp.maxBlockedTokens.get(action);
					Map<Buffer, Integer> blockingInstancesMap = cp.blockingInstances.get(action);
					Map<Buffer, Double> maxBlockedMultiplicationMap = cp.maxBlockedMultiplication.get(action);
					for (Entry<Buffer, Integer> e : maxBlockedTokensMap.entrySet()) {
						Buffer buffer = e.getKey();
						int tokens = e.getValue();
						int instances = blockingInstancesMap.get(buffer);
						double multiplication = maxBlockedMultiplicationMap.get(e.getKey());
						data.getMaxBlockedOutputTokens().put(buffer, tokens);
						data.getBlockingInstances().put(buffer, instances);
						data.getMaxBlockedMultiplication().put(buffer, multiplication);
					}
				}

				report.getActionsData().add(data);
			}
		}
		return report;
	}

	@Override
	public void init() {
		actorsPartitionMap = new HashMap<>();
		partitionsData = HashBiMap.create();
		blockedTokensMap = new HashMap<>();
		actionsPcp = new HashMap<>();
		actionsData = new HashMap<>();

		// init the partitions
		actorsPartitionMap = new HashMap<>();
		Map<String, List<String>> partitionMap = partitioning.asPartitionActorsMap();
		for (Entry<String, List<String>> e : partitionMap.entrySet()) {
			String id = e.getKey();
			List<Actor> actors = new ArrayList<>();
			for (String actor : e.getValue()) {
				actors.add(network.getActor(actor));
			}

			boolean fullParallel = partitioning.getScheduler(id).equals(EScheduler.FULL_PARALLEL.getLiteral());
			PartitionData p = fullParallel ? new FullParallelPartitionData(id, actors) : new GenericPartitionData(id);
			partitionsData.put(id, p);

			for (Actor actor : actors) {
				actorsPartitionMap.put(actor, p);
				for (Action action : actor.getActions()) {
					actionsData.put(action, new ActionData());
				}
			}
		}

		pcpTokens = new HashMap<>();
		for (Buffer buffer : network.getBuffers()) {
			pcpTokens.put(buffer, new ArrayDeque<>());
		}
	}

	@Override
	public void logActorTerminated(String partitionId, Actor actor, double time) {

	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {

	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer buffer, int tokens) {
		ActionBlockedOutBuffers data = blockedTokensMap.get(action);
		if (data == null) {
			data = new ActionBlockedOutBuffers();
			blockedTokensMap.put(action, data);
		}
		data.logBlocked(buffer, tokens, time);
	}

	@Override
	public void logCheckActor(String partitionId, Actor actor, double time) {

	}

	@Override
	public void logCheckedConditions(Actor actor, int conditionsChecked, boolean isInput, double time) {

	}

	@Override
	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		PartitionData pData = actorsPartitionMap.get(action.getOwner());
		for (int i = 0; i < tokens; i++) {		
			pData.setLastPcp(action, pcpTokens.get(buffer).removeFirst());					
		}
	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		ActionData aData = actionsData.get(action);
		double weight = time - aData.isEnabled;
		aData.addFiring(weight);

		Pcp pcp = actionsPcp.remove(action);
		pcp.finishTime = time;
		pcp.setExecutionWeight(action, weight);
		
		PartitionData pData = actorsPartitionMap.get(action.getOwner());
		pData.lastEndOfFiring = time;
		pData.setLastPcp(action, pcp);
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		Pcp pcp = actionsPcp.get(action);
		PartitionData pData = partitionsData.get(pcp.partition);
		pcp.evaluate(actorsPartitionMap.get(action.getOwner()).getLastPcp(action), pData.blockingTime());
	}

	@Override
	public void logEndSimulation(double time) {
		executionTime = time;		
	}

	@Override
	public void logFailedConditions(Actor actor, int conditionsFailed, boolean isInput, double time) {

	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		// start consuming tokens
		PartitionData pData = actorsPartitionMap.get(action.getOwner());
		pData.lastNewEnable = time;
		
		ActionData actionTimingData = actionsData.get(action);
		actionTimingData.reset();
		actionTimingData.isEnabled = time;

		// is schedulable
		Pcp pcp = new Pcp(pData.partition);
		actionsPcp.put(action, pcp);
		
		// set and reset blocked buffers
		ActionBlockedOutBuffers bData = blockedTokensMap.remove(action);
		if (bData != null) {
			pcp.setBlockedBuffer(action, bData.maxTokens);
			pcp.setBlockingInstances(action, bData.bInstances);
			pcp.setBlockedMultiplication(action, bData.maxMultiplication);
		}
	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		// actionsData.get(action).isSchedulable = time;
		ActionBlockedOutBuffers data = blockedTokensMap.get(action);
		if (data != null) {
			for (Buffer buffer : data.bTokens.keySet()) {
				data.logReleased(buffer, time);
			}
		}
	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		double isEnabledTime = actionsData.get(action).isEnabled;
		double weight = time - isEnabledTime;

		Pcp pcp = actionsPcp.get(action).clone();
		pcp.finishTime = time;
		pcp.setExecutionWeight(action, weight);

		for (int i = 0; i < tokens; i++) {
			pcpTokens.get(buffer).addLast(pcp);
		}
	}

	@Override
	public void logScheduleActor(String partitionId, Actor actor, double time) {

	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {

	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {

	}
}

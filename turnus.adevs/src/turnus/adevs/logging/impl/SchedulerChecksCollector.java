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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import com.google.common.collect.HashMultiset;

import turnus.adevs.logging.ActorPartitionDataCollector;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.analysis.postprocessing.SchedulerChecksPartition;
import turnus.model.analysis.postprocessing.SchedulerChecksReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;

import static turnus.model.common.StatisticalData.Util.asStatisticalData;
import static turnus.model.common.StatisticalData.Util.asAggregatedStatisticalData;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class SchedulerChecksCollector implements ActorPartitionDataCollector {
	
	Network network;
	NetworkPartitioning partitioning;
	
	// to store the current number of conditions for every actor
	Map<Actor, Integer> checkedInLookUpMap;
	Map<Actor, Integer> checkedOutLookUpMap;
	Map<Actor, Integer> failedInLookUpMap;
	Map<Actor, Integer> failedOutLookUpMap;
	
	// to count the number of conditions inside every partition 
	HashMultiset<String> checkedPartitionCounters;
	HashMultiset<String> failedPartitionCounters;
	
	// to store the statistical results
	Map<Actor, SummaryStatistics> checkedConditionsStatistics;
	Map<Actor, SummaryStatistics> failedConditionsStatistics;
	
	public SchedulerChecksCollector (Network network, NetworkPartitioning partitioning) {
		this.network = network;
		this.partitioning = partitioning;
	}

	@Override
	public void init() {
		checkedInLookUpMap = new HashMap<Actor, Integer>(); 
		checkedOutLookUpMap = new HashMap<Actor, Integer>();
		failedInLookUpMap = new HashMap<Actor, Integer>();  
		failedOutLookUpMap = new HashMap<Actor, Integer>();
		
		checkedPartitionCounters = HashMultiset.create();
		failedPartitionCounters = HashMultiset.create();
		
		checkedConditionsStatistics = new HashMap<Actor, SummaryStatistics>();
		failedConditionsStatistics = new HashMap<Actor, SummaryStatistics>();
		
		for (Actor actor : network.getActors()) {
			checkedInLookUpMap.put(actor, 0);
			checkedOutLookUpMap.put(actor, 0);
			failedInLookUpMap.put(actor, 0);
			failedOutLookUpMap.put(actor, 0);
			
			checkedConditionsStatistics.put(actor, new SummaryStatistics());
			failedConditionsStatistics.put(actor, new SummaryStatistics());
		}
	}

	@Override
	public void logScheduleActor(String partitionId, Actor actor, double time) {
		int conditions = checkedPartitionCounters.count(partitionId);
		checkedConditionsStatistics.get(actor).addValue(conditions);
		checkedPartitionCounters.remove(partitionId, conditions);
		
		conditions = failedPartitionCounters.count(partitionId);
		failedConditionsStatistics.get(actor).addValue(conditions);
		failedPartitionCounters.remove(partitionId, conditions);
	}

	@Override
	public void logCheckActor(String partitionId, Actor actor, double time) {
		checkedPartitionCounters.add(partitionId, checkedInLookUpMap.get(actor));
		checkedPartitionCounters.add(partitionId, checkedOutLookUpMap.get(actor));
		
		failedPartitionCounters.add(partitionId, failedInLookUpMap.get(actor));
		failedPartitionCounters.add(partitionId, failedOutLookUpMap.get(actor));
		
	}

	@Override
	public void logCheckedConditions(Actor actor, int conditionsChecked, boolean isInput, double time) {
		if (isInput) {
			checkedInLookUpMap.put(actor, conditionsChecked);
		} else {
			checkedOutLookUpMap.put(actor, conditionsChecked);
		}
	}

	@Override
	public void logFailedConditions(Actor actor, int conditionsFailed, boolean isInput, double time) {
		if (isInput) {
			failedInLookUpMap.put(actor, conditionsFailed);
		} else {
			failedOutLookUpMap.put(actor, conditionsFailed);
		}
	}
	
	@Override
	public void logActorTerminated(String partitionId, Actor actor, double time) {
		checkedInLookUpMap.put(actor, 0);
		failedInLookUpMap.put(actor, 0);
		checkedOutLookUpMap.put(actor, 0);
		failedOutLookUpMap.put(actor, 0);
	}

	@Override
	public void logEndSimulation(double time) {
	}

	@Override
	public PostProcessingData generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		SchedulerChecksReport report = f.createSchedulerChecksReport();
		
		List<SummaryStatistics> checkedStats = new ArrayList<SummaryStatistics>();
		List<SummaryStatistics> failedStats = new ArrayList<SummaryStatistics>();
		
		for (String partition : partitioning.getPartitions()) {
			SchedulerChecksPartition scp = f.createSchedulerChecksPartition();
			for (Actor actor : network.getActors()) {
				if (partitioning.getPartition(actor).equals(partition)) {
					scp.getCheckedConditionsMap().put(actor, asStatisticalData(checkedConditionsStatistics.get(actor)));
					scp.getFailedConditionsMap().put(actor, asStatisticalData(failedConditionsStatistics.get(actor)));
					
					checkedStats.add(checkedConditionsStatistics.get(actor));
					failedStats.add(failedConditionsStatistics.get(actor));
					
				}
			}
			StatisticalSummary checked = AggregateSummaryStatistics.aggregate(checkedStats);
			scp.setAggregatedCheckedData(asAggregatedStatisticalData(checked));
			
			StatisticalSummary failed = AggregateSummaryStatistics.aggregate(failedStats);
			scp.setAggregatedFailedData(asAggregatedStatisticalData(failed));
			
			report.getPartitions().add(scp);
		}
		
		return report;
	}
}

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
package turnus.analysis.scheduling;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.COMMUNICATION_WEIGHTS;
import static turnus.common.TurnusOptions.MAPPING_FILE;
import static turnus.common.TurnusOptions.RELEASE_BUFFERS_AFTER_PROCESSING;
import static turnus.common.TurnusOptions.SCHEDULING_WEIGHTS;
import static turnus.common.TurnusOptions.WRITE_HIT_CONSTANT;
import static turnus.common.TurnusOptions.WRITE_MISS_CONSTANT;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.util.concurrent.AtomicLongMap;

import turnus.adevs.logging.ActorPartitionDataCollector;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.scheduling.MarkovPartitionScheduler;
import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;
import turnus.model.analysis.scheduling.SchedulingFactory;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.util.ActorsSorter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlCommunicationWeightReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlSchedulingWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class MarkovSimpleScheduler extends Analysis<MarkovSimpleSchedulerReport> {

	private class PartitionMarkowData {
		Actor lastFiredActor;
		Actor firstFiredActor;
		List<Actor> actors;
		Map<Actor, AtomicLongMap<Actor>> successorsMap;
		AtomicLongMap<Actor> firings;

		PartitionMarkowData(List<Actor> actors) {
			this.actors = ActorsSorter.topologicalOrder(actors);
			successorsMap = new HashMap<>();
			for (Actor actor : actors) {
				successorsMap.put(actor, AtomicLongMap.create());
			}
			firings = AtomicLongMap.create();
			lastFiredActor = null;
			firstFiredActor = null;
		}

		void fireActor(Actor actor) {
			if (firstFiredActor == null) {
				firstFiredActor = actor;
			}
			if (lastFiredActor != null) {
				successorsMap.get(lastFiredActor).getAndIncrement(actor);
			}
			firings.getAndIncrement(actor);
			lastFiredActor = actor;
		}
	}

	private class MarkowDataCollector implements ActorPartitionDataCollector {

		final Network network;
		final NetworkPartitioning partitioning;
		Map<String, PartitionMarkowData> markowDataMap;

		MarkowDataCollector(Network network, NetworkPartitioning partitioning) {
			this.network = network;
			this.partitioning = partitioning;
			markowDataMap = new HashMap<>();
		}

		@Override
		public void init() {
			markowDataMap.clear();
			Map<String, List<String>> partitonsMap = partitioning.asPartitionActorsMap();
			for (Entry<String, List<String>> e : partitonsMap.entrySet()) {
				String id = e.getKey();
				List<Actor> actors = new ArrayList<>();
				for (String actor : e.getValue()) {
					actors.add(network.getActor(actor));
				}
				markowDataMap.put(id, new PartitionMarkowData(actors));
			}

		}

		@Override
		public void logEndSimulation(double time) {

		}

		@Override
		public MarkovSimpleSchedulerReport generateReport() {
			SchedulingFactory f = SchedulingFactory.eINSTANCE;
			MarkovSimpleSchedulerReport report = f.createMarkovSimpleSchedulerReport();
			report.setDate(new Date());
			report.setNetwork(network);
			report.setAlgorithm("Markov simple scheduler");

			for (Entry<String, PartitionMarkowData> e : markowDataMap.entrySet()) {
			
				PartitionMarkowData partitionData = e.getValue();
				List<Actor> actors = partitionData.actors;
				String partitionName = e.getKey();

				MarkovPartitionScheduler partitionScheduler = f.createMarkovPartitionScheduler();
				partitionScheduler.setPartitionId(partitionName);
				partitionScheduler.getActors().addAll(actors);
				report.getPartitions().add(partitionScheduler);

				// for each actor create a state
				Map<Actor, MarkovSchedulingState> statesMap = new HashMap<>();
				for (Actor actor : partitionData.actors) {
					String state_name = "s_" + actors.indexOf(actor);
					MarkovSchedulingState state = f.createMarkovSchedulingState();
					state.setActor(actor);
					state.setName(state_name);
					statesMap.put(actor, state);
					partitionScheduler.getStates().add(state);
				}

				for (Entry<Actor, AtomicLongMap<Actor>> eactor : partitionData.successorsMap.entrySet()) {
					Actor actor = eactor.getKey();
					MarkovSchedulingState state = statesMap.get(actor);
					long firings = partitionData.firings.get(actor);
					state.setFirings(firings);

					Map<Actor, Long> targetActorsMap = eactor.getValue().asMap();
					List<Actor> targets = new ArrayList<>(targetActorsMap.keySet());
					Collections.sort(targets, new Comparator<Actor>() {

						@Override
						public int compare(Actor o1, Actor o2) {
							long v1 = targetActorsMap.get(o1);
							long v2 = targetActorsMap.get(o2);
							return Long.compare(v2, v1);
						}
					});

					for (Actor nextActor : targets) {

						MarkovSchedulingTransition transition = f.createMarkovSchedulingTransition();

						long value = targetActorsMap.get(nextActor);
						transition.setFirings(value);

						transition.setSource(state);

						MarkovSchedulingState target = statesMap.get(nextActor);
						transition.setTarget(target);

						partitionScheduler.getTransitions().add(transition);
					}
				}
			}

			return report;
		}

		@Override
		public void logActorTerminated(String partitionId, Actor actor, double time) {

		}

		@Override
		public void logScheduleActor(String partitionId, Actor actor, double time) {
			markowDataMap.get(partitionId).fireActor(actor);
		}

		@Override
		public void logCheckActor(String partitionId, Actor actor, double time) {

		}

		@Override
		public void logCheckedConditions(Actor actor, int conditionsChecked, boolean isInput, double time) {

		}

		@Override
		public void logFailedConditions(Actor actor, int conditionsFailed, boolean isInput, double time) {

		}
	}

	private TraceWeighter weighter;
	private NetworkPartitioning partitioning;
	private BufferSize bufferSize;
	private SchedulingWeight schedulingWeight = null;
	private CommunicationWeight communicationWeight = null;
	private SimEngine simulation;

	public MarkovSimpleScheduler(TraceProject project) {
		super(project);
	}

	@Override
	public MarkovSimpleSchedulerReport run() throws TurnusException {
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		try {
			File weightsFile = configuration.getValue(ACTION_WEIGHTS);
			NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
			weighter = WeighterUtils.getTraceWeighter(configuration, weights);
		} catch (Exception e) {
			throw new TurnusException("Weights file is not valid", e);
		}

		try {
			File mappingFile = configuration.getValue(MAPPING_FILE);
			XmlNetworkPartitioningReader reader = new XmlNetworkPartitioningReader();
			partitioning = reader.load(mappingFile);
		} catch (Exception e) {
			throw new TurnusException("Mapping file is not valid", e);
		}

		if (configuration.hasValue(BUFFER_SIZE_FILE)) {
			File bufferFile = configuration.getValue(BUFFER_SIZE_FILE);
			XmlBufferSizeReader reader = new XmlBufferSizeReader();
			bufferSize = reader.load(bufferFile);
		} else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) {
			int defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
			bufferSize = new BufferSize(project.getNetwork());
			bufferSize.setDefaultSize(defaultBufferSize);
		} else {
			Logger.warning(
					"Defualt buffer size or buffer size configuration not defined. 512 size used as default for every buffer...");
			bufferSize = new BufferSize(project.getNetwork());
			bufferSize.setDefaultSize(512);
		}

		if (configuration.hasValue(COMMUNICATION_WEIGHTS)) {
			File communicationWeightsFile = configuration.getValue(COMMUNICATION_WEIGHTS);
			XmlCommunicationWeightReader reader = new XmlCommunicationWeightReader(project.getNetwork());
			communicationWeight = reader.load(communicationWeightsFile);

			if (configuration.hasValue(WRITE_HIT_CONSTANT)) {
				communicationWeight.setWriteHitConstant(configuration.getValue(WRITE_HIT_CONSTANT));
			}
			if (configuration.hasValue(WRITE_MISS_CONSTANT)) {
				communicationWeight.setWriteMissConstant(configuration.getValue(WRITE_MISS_CONSTANT));
			}
		}

		if (configuration.hasValue(SCHEDULING_WEIGHTS)) {
			File schedulingWeightsFile = configuration.getValue(SCHEDULING_WEIGHTS);
			schedulingWeight = new XmlSchedulingWeightReader().load(schedulingWeightsFile);
		}

		MarkowDataCollector dataCollector = new MarkowDataCollector(project.getNetwork(), partitioning);

		simulation = new SimEngine();
		simulation.setTraceProject(project);
		simulation.setTraceWeighter(weighter);
		simulation.setNetworkPartitioning(partitioning);
		simulation.setBufferSize(bufferSize);
		simulation.setCommunicationWeight(communicationWeight);
		simulation.setSchedulingWeight(schedulingWeight);

		if (configuration.getValue(RELEASE_BUFFERS_AFTER_PROCESSING))
			simulation.setReleaseAfterProcessing();

		simulation.addDataCollector(dataCollector);

		Logger.info("Launching simulation....");
		PostProcessingReport report = simulation.run();

		Logger.info("Simulation done, generating results");
		Logger.debug(report.toString());

		return dataCollector.generateReport();
	}

}

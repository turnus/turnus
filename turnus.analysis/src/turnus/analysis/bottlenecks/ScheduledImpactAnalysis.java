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
package turnus.analysis.bottlenecks;

import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_CLASS_LEVEL;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_POINTS;
import static turnus.common.TurnusOptions.BUFFER_SIZE_DEFAULT;
import static turnus.common.TurnusOptions.BUFFER_SIZE_FILE;
import static turnus.common.TurnusOptions.MAPPING_FILE;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.MathUtils;
import turnus.common.util.Pair;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksFactory;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ScheduledImpactAnalysis extends Analysis<ScheduledImpactAnalysisReport> {

	private class ScheduledImpactData {
		final List<Action> actions = new ArrayList<>();
		final double[] ratios;
		final Map<Double, Double> cpWeightReductionMap = new HashMap<>();
		final Map<Double, Double> executionTimeReductionMap = new HashMap<>();
		final Map<Double, BottlenecksWithSchedulingReport> reportMap = new HashMap<>();
		final double startingCp;
		final double startingTime;

		ScheduledImpactData(double startingCp, double startingTime, double[] ratios) {
			this.ratios = ratios.clone();
			this.startingCp = startingCp;
			this.startingTime = startingTime;
		}

		public ScheduledImpactAnalysisData getData() {
			ScheduledImpactAnalysisData data = BottlenecksFactory.eINSTANCE.createScheduledImpactAnalysisData();

			for (Action action : actions) {
				data.getActions().add(action);
			}

			for (Entry<Double, Double> entry : cpWeightReductionMap.entrySet()) {
				data.getCpReductionMap().put(entry.getKey(), entry.getValue());
			}
			
			for (Entry<Double, Double> entry : executionTimeReductionMap.entrySet()) {
				data.getTimeReductionMap().put(entry.getKey(), entry.getValue());
			}

			for (Entry<Double, BottlenecksWithSchedulingReport> entry : reportMap.entrySet()) {
				data.getReportsMap().put(entry.getKey(), entry.getValue());
			}

			return data;
		}

		public void setCpValue(BottlenecksWithSchedulingReport report, double ratio) {
			double cpLength = report.getCpWeight();
			double cpWeduction = (startingCp - cpLength) / startingCp * 100;
			double execTime = report.getExecutionTime();
			double execTimeReduction = (startingTime - execTime) / startingTime * 100;
			double wReduction = (1.0 - ratio) * 100;
			cpWeightReductionMap.put(wReduction, cpWeduction);
			executionTimeReductionMap.put(wReduction, execTimeReduction);
			reportMap.put(wReduction, report);
		}

	}

	private class ScheduledImpactThread implements Runnable {

		final TraceWeighter originalWeighter;
		final ScheduledImpactData point;
		final BufferSize bufferSize;
		final NetworkPartitioning partitioning;

		ScheduledImpactThread(TraceWeighter weighter, BufferSize bufferSize, NetworkPartitioning partitioning, ScheduledImpactData point) {
			this.originalWeighter = weighter.clone();
			this.point = point;
			this.bufferSize = bufferSize;
			this.partitioning = partitioning;
		}

		@Override
		public void run() {
			int step = 1;
			int steps = point.ratios.length;
			for (double scale : point.ratios) {
				String actions = "";
				TraceWeighter weighter = originalWeighter.clone();
				for (Action action : point.actions) {
					weighter.setRatio(action.getOwner().getName(), action.getName(), scale);
					actions = actions + " (" + action.getOwner().getName() + "," + action.getName() + ")";
				}
				actions = actions.trim();

				String analysisName = String.format("Scheduled Impact Analysis %d of %d for %s", step, steps, actions);

				ScheduledPartialCriticalPathAnalysis analyser = null;
				try {
					analyser = new ScheduledPartialCriticalPathAnalysis(project);
					analyser.setAnalysisName(analysisName);
					analyser.setConfiguration(configuration);
					analyser.setWeighter(weighter);
					analyser.setPartitioning(partitioning);
					analyser.setBufferSize(bufferSize);

					BottlenecksWithSchedulingReport report = analyser.run();
					point.setCpValue(report, scale);
				} catch (Exception e) {
					Logger.warning("The critical path cannot be evaluated for ratio %s", StringUtils.format(scale));
				}

				step++;
			}

		}

	}

	private static final boolean DEFAULT_CLASS_LEVEL = false;
	private static final int DEFAULT_GRIDDING = 10;
	private static final int DEFAULT_MAX_ACTIONS = 4;

	private boolean classLevel;
	private int griddingPoints;
	private int maxActions;
	private TraceWeighter weighter;
	private NetworkPartitioning partitioning;
	private BufferSize bufferSize;

	public ScheduledImpactAnalysis(TraceProject project) {
		super(project);
	}

	@Override
	public ScheduledImpactAnalysisReport run() throws TurnusException {
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
		} 
		else if (configuration.hasValue(BUFFER_SIZE_DEFAULT)) { // if both parameters are specified, then the default one is ignored
			int defaultBufferSize = configuration.getValue(BUFFER_SIZE_DEFAULT);
			bufferSize = new BufferSize(project.getNetwork());
			bufferSize.setDefaultSize(defaultBufferSize);
		} 
		else {
			throw new TurnusException("Buffer sizes are not specified.");
		}

		classLevel = configuration.getValue(ANALYSIS_IMPACT_CLASS_LEVEL, DEFAULT_CLASS_LEVEL);
		griddingPoints = configuration.getValue(ANALYSIS_IMPACT_MAX_POINTS, DEFAULT_GRIDDING);
		maxActions = configuration.getValue(ANALYSIS_IMPACT_MAX_ACTIONS, DEFAULT_MAX_ACTIONS);

		Logger.info("Initial scheduled critical path evaluation");
		ScheduledPartialCriticalPathAnalysis initialCpAnalysis = new ScheduledPartialCriticalPathAnalysis(project);
		initialCpAnalysis.setConfiguration(configuration);
		initialCpAnalysis.setWeighter(weighter.clone());
		initialCpAnalysis.setPartitioning(partitioning);
		initialCpAnalysis.setBufferSize(bufferSize);
		
		BottlenecksWithSchedulingReport initialCp = initialCpAnalysis.run();

		double cpLength = initialCp.getCpWeight();
		double executionTime = initialCp.getExecutionTime();

		Logger.debug("Initial cp length: %s", StringUtils.format(cpLength));
		Logger.info("Initial scheduled critical path evaluation done");

		// evaluate the ratios
		double[] ratios = new double[griddingPoints];
		double[] griddings = MathUtils.linspace(0, 100, griddingPoints + 1);
		for (int i = 0; i < griddingPoints; i++) {
			ratios[i] = (100.0 - griddings[i + 1]) / 100.0;
		}

		List<ScheduledImpactData> points = new ArrayList<>();
		// evaluate the most critical actions
		if (!classLevel) {
			Logger.info("Evaluating the most critical actions at actor level");
			final Map<Action, Double> cpMap = new HashMap<>();
			for (ActionBottlenecksWithSchedulingData data : initialCp.getActionsData()) {
				Action action = data.getAction();
				double cpValue = data.getCpWeight();
				if (cpValue > 0) {
					cpMap.put(action, cpValue);
				}
			}

			List<Action> sortedList = new ArrayList<>(cpMap.keySet());
			Collections.sort(sortedList, new Comparator<Action>() {

				@Override
				public int compare(Action o1, Action o2) {
					double v1 = cpMap.get(o1);
					double v2 = cpMap.get(o2);
					return -Double.compare(v1, v2);
				}
			});

			// trim it
			int size = Math.min(maxActions, sortedList.size());
			sortedList = sortedList.subList(0, size);

			for (Action action : sortedList) {
				ScheduledImpactData point = new ScheduledImpactData(cpLength, executionTime, ratios);
				point.actions.add(action);
				points.add(point);
			}

		} else {
			Logger.info("Evaluating the most critical actions at actor-class level");
			final Map<Pair<String, String>, Double> cpMap = new HashMap<>();
			for (ActionBottlenecksWithSchedulingData data : initialCp.getActionsData()) {
				String action = data.getAction().getName();
				String clazz = data.getAction().getOwner().getActorClass().getName();
				Pair<String, String> actionPair = Pair.create(clazz, action);
				double cpValue = data.getCpWeight();
				if (cpValue > 0) {
					if (cpMap.containsKey(actionPair)) {
						cpValue += cpMap.get(actionPair);
					}
					cpMap.put(actionPair, cpValue);
				}
			}

			List<Pair<String, String>> sortedList = new ArrayList<>(cpMap.keySet());
			Collections.sort(sortedList, new Comparator<Pair<String, String>>() {
				@Override
				public int compare(Pair<String, String> o1, Pair<String, String> o2) {
					double v1 = cpMap.get(o1);
					double v2 = cpMap.get(o2);
					return -Double.compare(v1, v2);
				}
			});

			// trim it
			int size = Math.min(maxActions, sortedList.size());
			sortedList = sortedList.subList(0, size);

			Network network = project.getNetwork();
			for (Pair<String, String> pair : sortedList) {
				ScheduledImpactData point = new ScheduledImpactData(cpLength, executionTime, ratios);
				points.add(point);

				ActorClass actorClass = network.getActorClass(pair.v1);
				for (Actor actor : actorClass.getActors()) {
					Action action = actor.getAction(pair.v2);
					point.actions.add(action);
				}
			}
		}

		List<Thread> threads = new ArrayList<>();
		for (ScheduledImpactData point : points) {
			Thread thread = new Thread(new ScheduledImpactThread(weighter, bufferSize, partitioning, point));
			threads.add(thread);
			thread.start();
			
			//This enforces a serial execution!
			//FIXME: use the CONFIG_MAX_THREADS option and handle assigning the analysis tasks to the threads
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		/*Logger.debug("Number of threads: %d", threads.size());

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {

			}
		}*/

		// generate the report
		ScheduledImpactAnalysisReport report = BottlenecksFactory.eINSTANCE.createScheduledImpactAnalysisReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Scheduled impact analysis with partial critical path propagation");
		report.setClassLevel(classLevel);
		report.setInitialBottlenecksWithScheduling(initialCp);
		for (ScheduledImpactData point : points) {
			ScheduledImpactAnalysisData data = point.getData();
			report.getScheduledImpactData().add(data);
		}

		return report;
	}

}

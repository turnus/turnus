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

import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_CLASS_LEVEL;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_POINTS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.analysis.Analysis;
import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.MathUtils;
import turnus.common.util.Pair;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksFactory;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.ImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkWeight;
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
public class AlgorithmicImpactAnalysis extends Analysis<ImpactAnalysisReport> {

	private class ImpactData {
		final List<Action> actions = new ArrayList<>();
		final double[] ratios;
		final Map<Double, Double> reductionMap = new HashMap<>();
		final Map<Double, BottlenecksReport> reportMap = new HashMap<>();
		final double startingCp;

		ImpactData(double startingCp, double[] ratios) {
			this.ratios = ratios.clone();
			this.startingCp = startingCp;
		}

		public ImpactAnalysisData getData() {
			ImpactAnalysisData data = BottlenecksFactory.eINSTANCE.createImpactAnalysisData();

			for (Action action : actions) {
				data.getActions().add(action);
			}

			for (Entry<Double, Double> entry : reductionMap.entrySet()) {
				data.getCpReductionMap().put(entry.getKey(), entry.getValue());
			}

			for (Entry<Double, BottlenecksReport> entry : reportMap.entrySet()) {
				data.getReportsMap().put(entry.getKey(), entry.getValue());
			}

			return data;
		}

		public void setCpValue(BottlenecksReport report, double ratio) {
			double cpLength = report.getCpWeight();
			double cpWeduction = (startingCp - cpLength) / startingCp * 100;
			double wReduction = (1.0 - ratio) * 100;
			reductionMap.put(wReduction, cpWeduction);
			reportMap.put(wReduction, report);
		}

	}

	private class ImpactThread implements Runnable {

		final TraceWeighter originalWeighter;
		final ImpactData point;
		final BufferSize bufferSize;

		ImpactThread(TraceWeighter weighter, BufferSize bufferSize, ImpactData point) {
			this.originalWeighter = weighter.clone();
			this.point = point;
			this.bufferSize = bufferSize;
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

				String analysisName = String.format("Impact analysis %d of %d for %s", step, steps, actions);

				AlgorithmicPartialCriticalPathAnalysis analyser = null;
				try {
					analyser = new AlgorithmicPartialCriticalPathAnalysis(project);
					analyser.setAnalysisName(analysisName);
					analyser.setConfiguration(configuration);
					analyser.setWeighter(weighter);

					if (bufferSize != null) {
						analyser.setBufferSize(bufferSize);
					}

					BottlenecksReport report = analyser.run();
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

	public AlgorithmicImpactAnalysis(TraceProject project) {
		super(project);
	}

	@Override
	public ImpactAnalysisReport run() throws TurnusException {
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

		classLevel = configuration.getValue(ANALYSIS_IMPACT_CLASS_LEVEL, DEFAULT_CLASS_LEVEL);
		griddingPoints = configuration.getValue(ANALYSIS_IMPACT_MAX_POINTS, DEFAULT_GRIDDING);
		maxActions = configuration.getValue(ANALYSIS_IMPACT_MAX_ACTIONS, DEFAULT_MAX_ACTIONS);

		BufferSize bufferSize = null;
		if (configuration.getValue(CONFIG_MINIMIZE_MEMORY_USAGE, DEFAULT_MINIMIZE_MEMORY_USAGE)) {
			Logger.debug("Memory usage reduction activated");
			Logger.info("Evaluate a feasible buffer size configuration in order to reduce the analysis memory usage");
			BoundedBufferAnalysis bb = new BoundedBufferAnalysis(project);
			bb.setConfiguration(configuration);
			bufferSize = bb.run().asBufferSize();
		}

		Logger.info("Initial algorithmic critical path evaluation");
		AlgorithmicPartialCriticalPathAnalysis initialCpAnalysis = new AlgorithmicPartialCriticalPathAnalysis(project);
		initialCpAnalysis.setConfiguration(configuration);
		initialCpAnalysis.setWeighter(weighter.clone());
		if (bufferSize != null) {
			initialCpAnalysis.setBufferSize(bufferSize);
		}
		BottlenecksReport initialCp = initialCpAnalysis.run();

		double cpLength = initialCp.getCpWeight();

		Logger.debug("Initial cp length: %s", StringUtils.format(cpLength));
		Logger.info("Initial algorithmic critical path evaluation done");

		// evaluate the ratios
		double[] ratios = new double[griddingPoints];
		double[] griddings = MathUtils.linspace(0, 100, griddingPoints + 1);
		for (int i = 0; i < griddingPoints; i++) {
			ratios[i] = (100.0 - griddings[i + 1]) / 100.0;
		}

		List<ImpactData> points = new ArrayList<>();
		// evaluate the most critical actions
		if (!classLevel) {
			Logger.info("Evaluating the most critical actions at actor level");
			final Map<Action, Double> cpMap = new HashMap<>();
			for (ActionBottlenecksData data : initialCp.getActionsData()) {
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
				ImpactData point = new ImpactData(cpLength, ratios);
				point.actions.add(action);
				points.add(point);
			}

		} else {
			Logger.info("Evaluating the most critical actions at actor-class level");
			final Map<Pair<String, String>, Double> cpMap = new HashMap<>();
			for (ActionBottlenecksData data : initialCp.getActionsData()) {
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
				ImpactData point = new ImpactData(cpLength, ratios);
				points.add(point);

				ActorClass actorClass = network.getActorClass(pair.v1);
				for (Actor actor : actorClass.getActors()) {
					Action action = actor.getAction(pair.v2);
					point.actions.add(action);
				}
			}
		}

		List<Thread> threads = new ArrayList<>();
		for (ImpactData point : points) {
			Thread thread = new Thread(new ImpactThread(weighter, bufferSize, point));
			threads.add(thread);
			thread.start();
		}
		Logger.debug("Number of threads: %d", threads.size());

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {

			}
		}

		// generate the report
		ImpactAnalysisReport report = BottlenecksFactory.eINSTANCE.createImpactAnalysisReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Algorithmic impact analysis with partial critical path propagation");
		report.setClassLevel(classLevel);
		report.setInitialBottlenecks(initialCp);
		for (ImpactData point : points) {
			ImpactAnalysisData data = point.getData();
			report.getImpactData().add(data);
		}

		return report;
	}

}

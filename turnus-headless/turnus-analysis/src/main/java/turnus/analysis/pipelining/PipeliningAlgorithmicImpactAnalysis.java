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
package turnus.analysis.pipelining;

import static turnus.common.TurnusConstants.DEFAULT_MAX_THREADS;
import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.ANALYSIS_IMPACT_MAX_ACTIONS;
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import turnus.analysis.Analysis;
import turnus.analysis.bottlenecks.AlgorithmicPartialCriticalPathAnalysis;
import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.CollectionUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;
import turnus.model.analysis.pipelining.ImpactAnalysisData;
import turnus.model.analysis.pipelining.ImpactAnalysisReport;
import turnus.model.analysis.pipelining.PipeliningFactory;
import turnus.model.dataflow.Action;
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
public class PipeliningAlgorithmicImpactAnalysis extends Analysis<ImpactAnalysisReport> {

	private class ImpactThread implements Runnable {

		final List<AnalysedActions> analysies;

		ImpactThread(List<AnalysedActions> analysies) {
			this.analysies = analysies;
		}

		@Override
		public void run() {
			for (AnalysedActions analysis : analysies) {
				try {
					analysis.run();
				} catch (TurnusException e) {
					Logger.warning(e.toString());
				}
			}

		}

	}

	private class AnalysedActions {
		final List<Action> actions;
		final double initialCpLenght;
		BottlenecksReport cpReport;

		@SuppressWarnings("unused") // TODO will be used by class level
		AnalysedActions(List<Action> actions, double initialCpLenght) {
			this.actions = new ArrayList<>(actions);
			this.initialCpLenght = initialCpLenght;
		}

		AnalysedActions(Action action, double initialCpLenght) {
			this.actions = new ArrayList<>();
			this.actions.add(action);

			this.initialCpLenght = initialCpLenght;
		}

		void run() throws TurnusException {
			TraceWeighter partialWeighter = weighter.clone();
			for (Action action : actions) {
				partialWeighter.setRatio(action.getOwner().getName(), action.getName(), 0.0);
			}

			AlgorithmicPartialCriticalPathAnalysis cpAnalysis = new AlgorithmicPartialCriticalPathAnalysis(project);
			cpAnalysis.setConfiguration(configuration);
			cpAnalysis.setWeighter(partialWeighter);
			if (bufferSize != null) {
				cpAnalysis.setBufferSize(bufferSize);
			}
			cpReport = cpAnalysis.run();

			double cpValue = cpReport.getCpWeight();
			double reduction = (1.0 - cpValue / initialCpLenght) * 100;
			Logger.info("Critical path reduction %s", StringUtils.format(reduction) + "%");
		}

		ImpactAnalysisData getData() {
			ImpactAnalysisData data = PipeliningFactory.eINSTANCE.createImpactAnalysisData();
			data.getActions().addAll(actions);
			data.setEstimatedBottlenecks(cpReport);
			data.setCpReduction((1.0 - cpReport.getCpWeight() / initialCpLenght) * 100);
			return data;
		}
	}

	private static final int DEFAULT_MAX_ACTIONS = 100;

	private int maxActions;
	private TraceWeighter weighter;
	private BufferSize bufferSize;

	public PipeliningAlgorithmicImpactAnalysis(TraceProject project) {
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

		maxActions = configuration.getValue(ANALYSIS_IMPACT_MAX_ACTIONS, DEFAULT_MAX_ACTIONS);

		Logger.info("Evaluate the pipelinables actions");
		InternalVariablePipeliningAnalysis pipeliningAnalysis = new InternalVariablePipeliningAnalysis(project);
		pipeliningAnalysis.setConfiguration(configuration);
		ActionsVariablePipeliningReport pipelinableReport = pipeliningAnalysis.run();

		// check if there are some pipelinable actions
		Set<Action> pipelinables = new HashSet<>();
		for (ActionVariablePipeliningData actionData : pipelinableReport.getActionsData()) {
			if (actionData.isPipelinable()) {
				pipelinables.add(actionData.getAction());
			}
		}

		// start creating the report that will be generated
		PipeliningFactory f = PipeliningFactory.eINSTANCE;
		ImpactAnalysisReport report = f.createImpactAnalysisReport();
		report.setAlgorithm("Pipelining impact analysis with algorithmic critical path reduction estimation");
		report.setNetwork(project.getNetwork());

		// store the pipelining report
		report.setPiplenablesActions(pipelinableReport);

		if (!pipelinables.isEmpty()) {
			Logger.info("Pipelinable actions %d", pipelinables.size());

			bufferSize = null;
			if (configuration.getValue(CONFIG_MINIMIZE_MEMORY_USAGE, DEFAULT_MINIMIZE_MEMORY_USAGE)) {
				Logger.debug("Memory usage reduction activated");
				Logger.info(
						"Evaluate a feasible buffer size configuration in order to reduce the analysis memory usage");
				BoundedBufferAnalysis bb = new BoundedBufferAnalysis(project);
				bb.setConfiguration(configuration);
				bufferSize = bb.run().asBufferSize();
			}

			Logger.info("Evaluate the initial algorithmic critical path");
			AlgorithmicPartialCriticalPathAnalysis algoCpAnalysis = new AlgorithmicPartialCriticalPathAnalysis(project);
			algoCpAnalysis.setConfiguration(configuration);
			if (bufferSize != null) {
				algoCpAnalysis.setBufferSize(bufferSize);
			}
			BottlenecksReport initialCpReport = algoCpAnalysis.run();

			// store the initial bottlenecks report
			report.setInitialBottlenecks(initialCpReport);

			final Map<Action, Double> actionsCpPartecipation = new HashMap<>();
			for (ActionBottlenecksData actionData : initialCpReport.getActionsData()) {
				if (actionData.getCpWeight() > 0) {
					actionsCpPartecipation.put(actionData.getAction(), actionData.getCpWeight());
				}
			}

			List<Action> actionsToAnalyse = new ArrayList<>(
					Sets.intersection(pipelinables, actionsCpPartecipation.keySet()));

			if (!actionsToAnalyse.isEmpty()) {
				Logger.info("There are %d pipelinable actions along the critical path", actionsToAnalyse.size());
				Collections.sort(actionsToAnalyse, new Comparator<Action>() {
					@Override
					public int compare(Action o1, Action o2) {
						double v1 = actionsCpPartecipation.get(o1);
						double v2 = actionsCpPartecipation.get(o2);
						return -Double.compare(v1, v2);
					}
				});

				if (actionsToAnalyse.size() > maxActions) {
					Logger.info("Only the first %d critical actions will be analysed", maxActions);
					actionsToAnalyse = actionsToAnalyse.subList(0, maxActions);
				}

				double initialCpValue = initialCpReport.getCpWeight();

				// create the analysies
				List<AnalysedActions> analysiesList = new ArrayList<>();
				for (Action action : actionsToAnalyse) {
					analysiesList.add(new AnalysedActions(action, initialCpValue));
				}

				// evaluate a partition of actors among the thread
				int maxThreads = configuration.getValue(CONFIG_MAX_THREADS, DEFAULT_MAX_THREADS);
				int nthreads = Math.min(maxThreads, actionsToAnalyse.size());

				// create the threads
				List<Thread> threads = new ArrayList<>();
				for (List<AnalysedActions> analysies : CollectionUtils.partition(analysiesList, nthreads)) {
					ImpactThread analyser = new ImpactThread(analysies);
					Thread t = new Thread(analyser, "pipelining analysis t=" + threads.size());
					threads.add(t);
					t.start();
				}

				for (Thread t : threads) {
					try {
						t.join();
					} catch (InterruptedException e) {
						Logger.warning("Interrupt exception error %s", e.toString());
					}
				}

				for (AnalysedActions data : analysiesList) {
					report.getImpactData().add(data.getData());
				}

			} else {
				Logger.warning("There are no pipelinable actions along the critical path that could be analysed");
			}
		} else {
			Logger.warning("There are no pipelinable actions");
		}

		return report;
	}

}

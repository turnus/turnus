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
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.analysis.Analysis;
import turnus.analysis.pipelining.data.ActorInternalVariableData;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.CollectionUtils;
import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;
import turnus.model.analysis.pipelining.PipeliningFactory;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class InternalVariablePipeliningAnalysis extends Analysis<ActionsVariablePipeliningReport> {

	private class ActorsAnalyser implements Runnable {

		final Map<Actor, ActorInternalVariableData> dataMap = new HashMap<>();

		ActorsAnalyser(Collection<Actor> actors) {
			for (Actor actor : actors) {
				dataMap.put(actor, new ActorInternalVariableData(actor));
			}

		}

		@Override
		public void run() {
			Trace trace = project.getTrace();
			for (Entry<Actor, ActorInternalVariableData> entry : dataMap.entrySet()) {
				Actor actor = entry.getKey();
				ActorInternalVariableData data = entry.getValue();
				for (Step step : trace.getSteps(Order.INCREASING_ID, actor.getName())) {
					data.addStep(step);
					progress.increment();
				}
				data.end();
			}
		}
	}

	private ProgressPrinter progress;

	public InternalVariablePipeliningAnalysis(TraceProject project) {
		super(project);
	}

	@Override
	public ActionsVariablePipeliningReport run() throws TurnusException {
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		long firings = project.getTrace().getSizeS();
		if (firings > 0) {
			progress = new ProgressPrinter("Pipelining analysis", firings);
		} else {
			progress = new NullProgressPrinter("Pipelining analysis");
		}

		Network network = project.getNetwork();
		List<Actor> actors = network.getActors();

		// evaluate a partition of actors among the thread
		int maxThreads = configuration.getValue(CONFIG_MAX_THREADS, DEFAULT_MAX_THREADS);
		int nthreads = Math.min(maxThreads, actors.size());
		List<List<Actor>> actorsSubsets = CollectionUtils.partition(actors, nthreads);

		int j = 0;
		List<Thread> threads = new ArrayList<>();
		List<ActorsAnalyser> analysers = new ArrayList<>();
		for (List<Actor> actorsSubset : actorsSubsets) {
			ActorsAnalyser analyser = new ActorsAnalyser(actorsSubset);
			analysers.add(analyser);

			Thread t = new Thread(analyser, "pipelining analysis t=" + j++);
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

		progress.finish();

		// now collect the results
		List<ActionVariablePipeliningData> actionsData = new ArrayList<>();
		for (ActorsAnalyser analyser : analysers) {
			for (ActorInternalVariableData actorData : analyser.dataMap.values()) {
				actionsData.addAll(actorData.getActionsData());
			}
		}

		// and generate the report
		ActionsVariablePipeliningReport report = PipeliningFactory.eINSTANCE.createActionsVariablePipeliningReport();
		report.setNetwork(network);
		report.setAlgorithm("Pipelining analysis by action variable utilization");
		report.getActionsData().addAll(actionsData);

		return report;
	}

}

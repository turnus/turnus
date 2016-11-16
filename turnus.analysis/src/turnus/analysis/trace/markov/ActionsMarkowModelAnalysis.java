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
package turnus.analysis.trace.markov;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.util.concurrent.AtomicLongMap;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.analysis.trace.TraceFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ActionsMarkowModelAnalysis extends Analysis<MarkowModelTraceReport> {
	private static final String analysisName = "Markov model trace representation";

	private class ActionData {
		long successors;
		boolean first = false;

		AtomicLongMap<Action> successorsMap = AtomicLongMap.create();

		public ActionData() {
		}
	}

	private TraceDecorator decorator;

	public ActionsMarkowModelAnalysis(TraceProject project) {
		super(project);
	}

	public void cancel() {
	}

	@Override
	public MarkowModelTraceReport run() throws TurnusException {
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		decorator = project.getTraceDecorator();

		List<Actor> actors = new ArrayList<>(project.getNetwork().getActors());
		Map<Action, ActionData> actionsMap = new HashMap<>();
		for (Actor actor : actors) {
			for (Action action : actor.getActions()) {
				actionsMap.put(action, new ActionData());
			}
		}

		Trace trace = project.getTrace();

		ProgressPrinter progress;

		long steps = trace.getSizeS();
		if (steps > 0) {
			progress = new ProgressPrinter(analysisName, steps);
		} else {
			progress = new NullProgressPrinter(analysisName);
		}

		Map<Actor, Action> predecessorMap = new HashMap<>();
		for (Actor actor : actors) {
			for (Step step : trace.getSteps(Order.INCREASING_ID, actor.getName())) {
				Action action = decorator.getAction(step);
				ActionData data = actionsMap.get(action);

				Action predecessor = predecessorMap.get(actor);
				if (predecessor == null) {
					data.first = true;
				} else {
					ActionData predData = actionsMap.get(predecessor);
					predData.successorsMap.incrementAndGet(action);
					predData.successors++;
				}

				predecessorMap.put(actor, action);
				progress.increment();
			}
		}
		
		progress.finish();

		// create the report
		TraceFactory f = TraceFactory.eINSTANCE;
		MarkowModelTraceReport report = f.createMarkowModelTraceReport();
		report.setDate(new Date());
		report.setAlgorithm(analysisName);
		report.setNetwork(project.getNetwork());

		for (Actor actor : actors) {
			for (Action action : actor.getActions()) {
				MarkovModelActionData mData = f.createMarkovModelActionData();
				mData.setAction(action);
				report.getActionsData().add(mData);

				ActionData data = actionsMap.get(action);
				mData.setFirst(data.first);
				mData.setSuccessors(data.successors);

				for (Entry<Action, Long> e : data.successorsMap.asMap().entrySet()) {
					Action successor = e.getKey();
					long value = e.getValue();
					mData.getSuccessorsMap().put(successor, value);
				}
			}
		}

		return report;
	}

}

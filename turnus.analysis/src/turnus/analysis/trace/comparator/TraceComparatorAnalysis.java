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
package turnus.analysis.trace.comparator;

import static turnus.common.TurnusConstants.DEFAULT_MAX_THREADS;
import static turnus.common.TurnusOptions.CONFIG_MAX_THREADS;
import static turnus.common.TurnusOptions.TRACE_FILES_SET;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import turnus.analysis.Analysis;
import turnus.analysis.trace.compressor.CompressedTraceAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.CollectionUtils;
import turnus.model.analysis.trace.ComparedAction;
import turnus.model.analysis.trace.ComparedTrace;
import turnus.model.analysis.trace.CompressedDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.TraceComparatorReport;
import turnus.model.analysis.trace.TraceFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class TraceComparatorAnalysis extends Analysis<TraceComparatorReport> {

	private class TracesAnalyser implements Runnable {

		final List<TraceProject> projects;
		final List<ComparedTrace> results = new ArrayList<>();
		final CompressedTraceReport rTrace;

		TracesAnalyser(List<TraceProject> projects, CompressedTraceReport rTrace) {
			this.projects = projects;
			this.rTrace = rTrace;
		}

		private boolean equals(Action a1, Action a2) {
			if (!a1.getOwner().getName().equals(a2.getOwner().getName())) {
				return false;
			} else {
				return a1.getName().equals(a2.getName());
			}
		}

		private Action getReferenceEquivalent(Collection<Action> referenceActions, Action a) {
			for (Action action : referenceActions) {
				if (equals(action, a)) {
					return action;
				}
			}
			return null;
		}

		@Override
		public void run() {
			// create an internal list of reference actions
			List<Action> refActions = new ArrayList<>();
			for (Actor actor : rTrace.getNetwork().getActors()) {
				refActions.addAll(actor.getActions());
			}

			for (TraceProject project : projects) {
				try {
					Logger.info("Compressed trace analysis for trace %s started", project.getTraceFile());
					// create a compressed trace
					CompressedTraceReport cTrace = new CompressedTraceAnalysis(project).run();

					// now make the analysis and generate directly the report
					TraceFactory f = TraceFactory.eINSTANCE;
					ComparedTrace compTrace = f.createComparedTrace();
					compTrace.setCompressedTrace(cTrace);

					for (Actor cActor : cTrace.getNetwork().getActors()) {
						for (Action cAction : cActor.getActions()) {
							ComparedAction compAction = f.createComparedAction();
							compAction.setAction(cAction);
							compTrace.getActions().add(compAction);

							// check of the reference trace has an equivalent
							// action
							Action refEquivalent = getReferenceEquivalent(refActions, cAction);
							boolean hasEquivalent = refEquivalent != null;
							compAction.setFound(hasEquivalent);
							if (hasEquivalent) {
								compTrace.getContainedReferenceActions().add(refEquivalent);
							}

							// compute the action number of steps, incomings and
							// outgoings for the given action
							CompressedStep step = cTrace.getSteps(cAction);
							long steps = step.getCount();
							long incomings = 0;
							for (CompressedDependency in : step.getIncomings()) {
								incomings += in.getCount();
							}
							long outoings = 0;
							for (CompressedDependency out : step.getOutgoings()) {
								outoings += out.getCount();
							}

							// compute the action number of steps, incomings and
							// outgoings for the reference action (if there is
							// an equivalence)
							long refSteps = 0;
							long refIncomings = 0;
							long refOutgoings = 0;
							if (hasEquivalent) {
								CompressedStep rstep = rTrace.getSteps(refEquivalent);
								refSteps = rstep.getCount();
								for (CompressedDependency in : rstep.getIncomings()) {
									refIncomings += in.getCount();
								}
								for (CompressedDependency out : rstep.getOutgoings()) {
									refOutgoings += out.getCount();
								}
							}

							compAction.setDSteps(steps - refSteps);
							compAction.setDIncomings(incomings - refIncomings);
							compAction.setDOutgoings(outoings - refOutgoings);
						}
					}
					results.add(compTrace);
					Logger.info("Compressed trace analysis for trace %s done", project.getTraceFile());
				} catch (TurnusException e) {
					Logger.error("Error while evaluating the compressed trace of %s: %s", project.getTraceFile(),
							e.getMessage());
				}
			}
		}

	}

	public TraceComparatorAnalysis(TraceProject project) {
		super(project);
	}

	@Override
	public TraceComparatorReport run() throws TurnusException {

		// parse the trace path and try to load the project
		List<String> tracePaths = configuration.getValue(TRACE_FILES_SET);
		Logger.info("Loading the %d trace projects", tracePaths.size());

		List<TraceProject> projects = new ArrayList<>();
		for (String path : tracePaths) {
			try {
				File trace = new File(path);
				TraceProject pojo = TraceProject.open(trace);
				projects.add(pojo);
			} catch (Exception e) {
				Logger.error("The trace in %s cannot be loaded", path);
			}
		}
		Logger.info("%d of %d traces have been loaded", tracePaths.size(), projects.size());

		// evaluate a partition of trace projects among the thread
		int maxThreads = configuration.getValue(CONFIG_MAX_THREADS, DEFAULT_MAX_THREADS);
		int nthreads = Math.min(maxThreads, projects.size());
		List<List<TraceProject>> projectPartitions = CollectionUtils.partition(projects, nthreads);

		// evaluate the initial trace compressed value
		Logger.info("Evalute a compressed version of the reference trace %s", project.getTraceFile());
		CompressedTraceReport ref = new CompressedTraceAnalysis(project).run();

		// run the treads
		int j = 0;
		List<Thread> threads = new ArrayList<>();
		List<TracesAnalyser> analysers = new ArrayList<>();
		for (List<TraceProject> subProjects : projectPartitions) {
			TracesAnalyser analyser = new TracesAnalyser(subProjects, ref);
			analysers.add(analyser);

			Thread t = new Thread(analyser, "trace compressed analysis t=" + j++);
			threads.add(t);

			t.start();
		}

		Logger.info("Waiting that all the %d traces are analysed", projects.size());
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				Logger.warning("Interrupt exception error %s", e.toString());
			}
		}

		// now collect the results and generating the report
		Logger.info("Collecting the results");
		TraceComparatorReport report = TraceFactory.eINSTANCE.createTraceComparatorReport();
		report.setAlgorithm("Trace comparator analysis");
		report.setReference(ref);
		report.setDate(new Date());

		for (TracesAnalyser analyser : analysers) {
			report.getTraces().addAll(analyser.results);
		}

		return report;
	}

}

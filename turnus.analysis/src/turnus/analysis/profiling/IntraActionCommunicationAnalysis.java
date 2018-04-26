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
package turnus.analysis.profiling;

import static turnus.common.TurnusConstants.DEFAULT_MINIMIZE_MEMORY_USAGE;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;
import static turnus.model.common.StatisticalData.Util.asStatisticalData;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import turnus.analysis.Analysis;
import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.model.analysis.profiling.IntraActionCommunicationData;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
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
public class IntraActionCommunicationAnalysis extends Analysis<IntraActionCommunicationReport> {

	private class CommunicationData<T> {
		final Map<T, SummaryStatistics> incomingTokens = new HashMap<>();
		final SummaryStatistics consumedTokens = new SummaryStatistics();
		final SummaryStatistics producedTokens = new SummaryStatistics();

	}

	private class ActorScheduler {
		final Actor actor;
		Step currentStep;
		final Iterator<Step> steps;

		ActorScheduler(Actor actor) {
			this.actor = actor;
			steps = trace.getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			loadNextStep();
		}

		boolean hasFinished() {
			return currentStep == null;
		}

		void loadNextStep() {
			if (steps.hasNext()) {
				currentStep = steps.next();
			} else {
				currentStep = null;
			}
		}

		boolean schedule() {
			if (hasFinished()) {
				return false;
			}

			Map<Buffer, Integer> inputTokens = decorator.getReadTokens(currentStep);
			for (Entry<Buffer, Integer> e : inputTokens.entrySet()) {
				Buffer buffer = e.getKey();
				int count = e.getValue();
				if (!buffersMap.get(buffer).hasTokens(count)) {
					return false;
				}
			}

			Map<Buffer, Integer> outputTokens = decorator.getWriteTokens(currentStep);
			if (minimizeMemoryUsage) {
				for (Entry<Buffer, Integer> e : outputTokens.entrySet()) {
					Buffer buffer = e.getKey();
					int count = e.getValue();
					if (!buffersMap.get(buffer).hasSpace(count)) {
						return false;
					}
				}
			}

			Action action = decorator.getAction(currentStep);

			// consume tokens
			int consumedTokens = 0;
			Multiset<Action> predActions = HashMultiset.create();
			Multiset<Actor> predActors = HashMultiset.create();
			for (Entry<Buffer, Integer> e : inputTokens.entrySet()) {
				Buffer buffer = e.getKey();
				int count = e.getValue();
				consumedTokens += count;
				for (int i = 0; i < count; i++) {
					Action producer = buffersMap.get(buffer).read();
					predActions.add(producer);
					predActors.add(producer.getOwner());
				}
			}

			int producedTokens = 0;
			for (Entry<Buffer, Integer> e : outputTokens.entrySet()) {
				Buffer buffer = e.getKey();
				int count = e.getValue();
				producedTokens += count;
				for (int i = 0; i < count; i++) {
					buffersMap.get(buffer).write(action);
				}
			}

			// log communication data
			CommunicationData<Actor> actorData = actorsDataMap.get(action.getOwner());
			CommunicationData<Action> actionData = actionsDataMap.get(action);
			// -- log total consumed tokens
			actorData.consumedTokens.addValue(consumedTokens);
			actionData.consumedTokens.addValue(consumedTokens);
			// -- log total produced tokens
			actorData.producedTokens.addValue(producedTokens);
			actionData.producedTokens.addValue(producedTokens);
			// -- log actor incoming
			for (Multiset.Entry<Actor> e : predActors.entrySet()) {
				Actor pred = e.getElement();
				SummaryStatistics statData = actorData.incomingTokens.get(pred);
				if (statData == null) {
					statData = new SummaryStatistics();
					actorData.incomingTokens.put(pred, statData);
				}
				statData.addValue(e.getCount());
			}

			for (Multiset.Entry<Action> e : predActions.entrySet()) {
				Action pred = e.getElement();
				SummaryStatistics statData = actionData.incomingTokens.get(pred);
				if (statData == null) {
					statData = new SummaryStatistics();
					actionData.incomingTokens.put(pred, statData);
				}
				statData.addValue(e.getCount());
			}

			loadNextStep();

			return true;
		}

	}

	private class BufferQueue {
		int size;
		final ArrayDeque<Action> queue = new ArrayDeque<>();

		void setSize(int size) {
			this.size = size;
		}

		boolean hasTokens(int tokens) {
			return queue.size() >= tokens;
		}

		Action read() {
			return queue.removeFirst();
		}

		void write(Action token) {
			queue.addLast(token);
		}

		boolean hasSpace(int tokens) {
			return queue.size() + tokens <= size;
		}
	}

	private BufferSize bufferSize;
	private Map<Buffer, BufferQueue> buffersMap;
	private Trace trace;
	private Network network;
	private TraceDecorator decorator;
	private boolean minimizeMemoryUsage;
	private Collection<ActorScheduler> actorsSchedulers;
	private Map<Actor, CommunicationData<Actor>> actorsDataMap;
	private Map<Action, CommunicationData<Action>> actionsDataMap;

	public IntraActionCommunicationAnalysis(TraceProject project) {
		super(project);
	}

	public void setBufferSize(BufferSize bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	public IntraActionCommunicationReport run() throws TurnusException {
		Logger.info("Intra-Action Communication Analysis [STARTED]");
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		minimizeMemoryUsage = configuration.getValue(CONFIG_MINIMIZE_MEMORY_USAGE, DEFAULT_MINIMIZE_MEMORY_USAGE);
		Logger.debug("Memory usage reduction: %b", minimizeMemoryUsage);
		if (bufferSize == null && minimizeMemoryUsage) {
			Logger.info("Evaluate a feasible buffer size configuration in order to reduce the analysis memory usage");
			BoundedBufferAnalysis bb = new BoundedBufferAnalysis(project);
			bb.setConfiguration(configuration);
			bufferSize = bb.run().asBufferSize();
		}

		network = project.getNetwork();
		trace = project.getTrace();
		decorator = project.getTraceDecorator();

		ProgressPrinter progress;

		long steps = trace.getSizeS();
		if (steps > 0) {
			progress = new ProgressPrinter("Itra-Action Communication Analysis", steps);
		} else {
			progress = new NullProgressPrinter("Itra-Action Communication Analysis");
		}

		// build the network
		// -- buffers
		buffersMap = new HashMap<>();
		for (Buffer buffer : network.getBuffers()) {
			BufferQueue queue = new BufferQueue();
			if (minimizeMemoryUsage) {
				queue.setSize(bufferSize.getSize(buffer));
			}
			buffersMap.put(buffer, queue);
		}
		// -- actors
		actorsSchedulers = new HashSet<>();
		for (Actor actor : network.getActors()) {
			actorsSchedulers.add(new ActorScheduler(actor));
		}

		// build the data collectors
		actorsDataMap = new HashMap<>();
		actionsDataMap = new HashMap<>();
		for (Actor actor : network.getActors()) {
			actorsDataMap.put(actor, new CommunicationData<Actor>());
			for (Action action : actor.getActions()) {
				actionsDataMap.put(action, new CommunicationData<Action>());
			}
		}

		boolean scheduled = false;
		do {
			scheduled = false;

			for (ActorScheduler actor : actorsSchedulers) {
				if (actor.schedule()) {
					scheduled = true;
					progress.increment();
				}
			}

		} while (scheduled);

		progress.finish();

		// check for deadlock
		boolean deadlocked = false;
		for (ActorScheduler scheduler : actorsSchedulers) {
			if (!scheduler.hasFinished()) {
				Logger.error("The actor \"%s\" is in deadlock", scheduler.actor.getName());
				deadlocked = true;
			}
		}

		if (deadlocked) {
			Logger.error("The %s cannot be terminated: at least one actor deadlocked."
					+ " This is caused by an unfeasible buffer size configuration that is not deadlock-free for this design");
			throw new TurnusRuntimeException("Actor deadlock: unfeasible buffer size configuration");
		}

		Logger.info("Intra-Action Communication Analysis [END]");

		return generateReport();
	}

	private IntraActionCommunicationReport generateReport() {
		ProfilingFactory f = ProfilingFactory.eINSTANCE;
		IntraActionCommunicationReport report = f.createIntraActionCommunicationReport();
		report.setNetwork(network);
		report.setDate(new Date());
		report.setAlgorithm("Intra-Action Communication Analysis");

		// store actor data
		for (Actor actor : network.getActors()) {
			CommunicationData<Actor> actorData = actorsDataMap.get(actor);
			IntraActorCommunicationData actorReport = f.createIntraActorCommunicationData();
			actorReport.setActor(actor);
			actorReport.setConsumedTokens(asStatisticalData(actorData.consumedTokens));
			actorReport.setProducedTokens(asStatisticalData(actorData.producedTokens));
			for (Entry<Actor, SummaryStatistics> e : actorData.incomingTokens.entrySet()) {
				actorReport.getTokensProducersMap().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// add to the report
			report.getActorsData().add(actorReport);

			// store actions data
			for (Action action : actor.getActions()) {
				CommunicationData<Action> actionData = actionsDataMap.get(action);
				IntraActionCommunicationData actionReport = f.createIntraActionCommunicationData();
				actionReport.setAction(action);
				actionReport.setConsumedTokens(asStatisticalData(actionData.consumedTokens));
				actionReport.setProducedTokens(asStatisticalData(actionData.producedTokens));
				for (Entry<Action, SummaryStatistics> e : actionData.incomingTokens.entrySet()) {
					actionReport.getTokensProducersMap().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// add to the actor report
				actorReport.getActionsData().add(actionReport);
			}

		}

		return report;
	}

}

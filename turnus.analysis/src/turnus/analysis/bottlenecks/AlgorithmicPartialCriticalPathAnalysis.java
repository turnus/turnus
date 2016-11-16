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
import static turnus.common.TurnusOptions.ACTION_WEIGHTS;
import static turnus.common.TurnusOptions.CONFIG_MINIMIZE_MEMORY_USAGE;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.util.concurrent.AtomicLongMap;

import turnus.analysis.Analysis;
import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksFactory;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.WeighterUtils;

/**
 * The Algorithmic PartialCritical PathAnalysis is used to highlight the actions
 * that are along the critical path of a design. With algorithmic it means that
 * only the execution time of each action are considered.
 * 
 * @author Simone Casale Brunet
 *
 */
public class AlgorithmicPartialCriticalPathAnalysis extends Analysis<BottlenecksReport> {

	private class ActorScheduler {
		final Actor actor;
		Pcp actorPcp;
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
			double weight = weighter.getWeight(currentStep);
			double variance = weighter.getVariance(currentStep);

			networkWl.addFiring(action, weight, variance);
			Pcp pcp = new Pcp(action, weight, variance);

			List<Pcp> pcps = new ArrayList<>();
			if (actorPcp != null) {
				pcps.add(actorPcp);
			}

			for (Entry<Buffer, Integer> e : inputTokens.entrySet()) {
				Buffer buffer = e.getKey();
				int count = e.getValue();
				for (int i = 0; i < count; i++) {
					Pcp pcpt = buffersMap.get(buffer).read();
					if (!pcps.contains(pcpt)) {
						pcps.add(pcpt);
					}
				}
			}

			pcp.evaluate(pcps);

			for (Entry<Buffer, Integer> e : outputTokens.entrySet()) {
				Buffer buffer = e.getKey();
				int count = e.getValue();
				for (int i = 0; i < count; i++) {
					buffersMap.get(buffer).write(pcp);
				}
			}

			actorPcp = pcp.clone();
			loadNextStep();

			return true;
		}

	}

	private class BufferQueue {
		int size;
		final ArrayDeque<Pcp> queue = new ArrayDeque<>();

		void setSize(int size) {
			this.size = size;
		}

		boolean hasTokens(int tokens) {
			return queue.size() >= tokens;
		}

		Pcp read() {
			return queue.removeFirst();
		}

		void write(Pcp token) {
			queue.addLast(token);
		}

		boolean hasSpace(int tokens) {
			return queue.size() + tokens <= size;
		}
	}

	private class NetworkWorkLoad {
		private AtomicLongMap<Action> actionFiringsMap = AtomicLongMap.create();
		private Map<Action, Double> actionVariancesMap = new HashMap<>();
		private Map<Action, Double> actionWeightMap = new HashMap<>();

		public void addFiring(Action action, double weight, double variance) {
			actionFiringsMap.incrementAndGet(action);
			double sumWeight = weight;
			double sumVariance = variance;
			if (actionWeightMap.containsKey(action)) {
				sumWeight += actionWeightMap.get(action);
				sumVariance += actionVariancesMap.get(action);
			}
			actionWeightMap.put(action, sumWeight);
			actionVariancesMap.put(action, sumVariance);
		}

	}

	private class Pcp implements Comparable<Pcp>, Cloneable {

		final AtomicLongMap<Action> pcpFirings;
		double pcpVariance = 0;
		double pcpWeight = 0;
		final Map<Action, Double> sumPcpVarianceMap;
		final Map<Action, Double> sumPcpWeightMap;

		private Pcp(Action action, double weight, double variance) {
			pcpWeight = weight;
			pcpVariance = variance;

			pcpFirings = AtomicLongMap.create();
			pcpFirings.incrementAndGet(action);

			sumPcpWeightMap = new HashMap<>();
			sumPcpWeightMap.put(action, weight);

			sumPcpVarianceMap = new HashMap<>();
			sumPcpVarianceMap.put(action, variance);
		}

		private Pcp(Pcp o) {
			pcpWeight = o.pcpWeight;
			pcpVariance = o.pcpVariance;

			pcpFirings = AtomicLongMap.create(o.pcpFirings.asMap());
			sumPcpWeightMap = new HashMap<>(o.sumPcpWeightMap);
			sumPcpVarianceMap = new HashMap<>(o.sumPcpVarianceMap);
		}

		@Override
		public Pcp clone() {
			return new Pcp(this);
		}

		@Override
		public int compareTo(Pcp o) {
			if (pcpWeight != o.pcpWeight)
				return -Double.compare(pcpWeight, o.pcpWeight);
			else
				return -Double.compare(pcpVariance, o.pcpVariance);
		}

		public void evaluate(List<Pcp> pcps) {
			if (!pcps.isEmpty()) {
				Collections.sort(pcps);
				Pcp bigger = pcps.get(0);

				pcpWeight += bigger.pcpWeight;
				pcpVariance += bigger.pcpVariance;

				for (Action action : bigger.sumPcpWeightMap.keySet()) {
					double sumWeigth = bigger.sumPcpWeightMap.get(action);
					double sumVariance = bigger.sumPcpVarianceMap.get(action);
					if (sumPcpWeightMap.containsKey(action)) {
						sumWeigth += sumPcpWeightMap.get(action);
						sumVariance += sumPcpVarianceMap.get(action);
					}
					sumPcpWeightMap.put(action, sumWeigth);
					sumPcpVarianceMap.put(action, sumVariance);
				}

				for (Entry<Action, Long> entry : bigger.pcpFirings.asMap().entrySet()) {
					pcpFirings.addAndGet(entry.getKey(), entry.getValue());
				}
			}
		}

		public String toString() {
			StringBuffer b = new StringBuffer();
			b.append("[pcp] ");
			b.append("value=").append(pcpWeight);
			b.append(" partial={");
			for (Entry<Action, Double> e : sumPcpWeightMap.entrySet()) {
				String action = e.getKey().getName();
				String actor = e.getKey().getOwner().getName();
				String value = StringUtils.format(e.getValue());
				b.append(" (").append(actor).append(",").append(action).append(",").append(value).append(")");
			}
			b.append(" }");
			return b.toString();
		}
	}

	private Collection<ActorScheduler> actorsSchedulers;
	private String analysisName = "Algorithmic critical path evaluation";
	private Map<Buffer, BufferQueue> buffersMap;
	private TraceDecorator decorator;

	private NetworkWorkLoad networkWl;
	private Trace trace;
	private TraceWeighter weighter;
	private BufferSize bufferSize;
	private boolean minimizeMemoryUsage;

	public AlgorithmicPartialCriticalPathAnalysis(TraceProject project) {
		super(project);
	}

	private BottlenecksReport createReport(Pcp cp) {
		BottlenecksFactory f = BottlenecksFactory.eINSTANCE;
		Network network = project.getNetwork();

		BottlenecksReport report = f.createBottlenecksReport();
		report.setAlgorithm("Algorithmic critical path analysis with partial critical path propagation");
		report.setNetwork(network);

		for (Actor actor : network.getActors()) {
			for (Action action : actor.getActions()) {
				ActionBottlenecksData data = f.createActionBottlenecksData();
				data.setAction(action);
				report.getActionsData().add(data);

				if (networkWl.actionFiringsMap.containsKey(action)) {
					double totalWeight = networkWl.actionWeightMap.get(action);
					double totalVariance = networkWl.actionVariancesMap.get(action);
					data.setTotalWeight(totalWeight);
					data.setTotalVariance(totalVariance);

					long actionTotalFirings = networkWl.actionFiringsMap.get(action);
					data.setTotalFirings(actionTotalFirings);

					if (cp.pcpFirings.containsKey(action)) {
						double actionCpWeight = cp.sumPcpWeightMap.get(action);
						double actionCpVariance = cp.sumPcpVarianceMap.get(action);
						data.setCpWeight(actionCpWeight);
						data.setCpVariance(actionCpVariance);

						long actionCpFirings = cp.pcpFirings.get(action);
						data.setCpFirings(actionCpFirings);
					}
				} else {
					data.setTotalWeight(0);
					data.setTotalVariance(0);
					data.setTotalFirings(0);
				}
			}

		}

		return report;
	}

	@Override
	public BottlenecksReport run() throws TurnusException {
		Logger.info("%s [STARTED]", analysisName);
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		if (weighter == null) {
			try {
				File weightsFile = configuration.getValue(ACTION_WEIGHTS);
				NetworkWeight weights = new XmlNetworkWeightReader().load(weightsFile);
				weighter = WeighterUtils.getTraceWeighter(configuration, weights);
			} catch (Exception e) {
				throw new TurnusException("Weights file is not valid", e);
			}
		}

		minimizeMemoryUsage = configuration.getValue(CONFIG_MINIMIZE_MEMORY_USAGE, DEFAULT_MINIMIZE_MEMORY_USAGE);
		Logger.debug("Memory usage reduction: %b", minimizeMemoryUsage);
		if (bufferSize == null && minimizeMemoryUsage) {
			Logger.info("Evaluate a feasible buffer size configuration in order to reduce the analysis memory usage");
			BoundedBufferAnalysis bb = new BoundedBufferAnalysis(project);
			bb.setConfiguration(configuration);
			bufferSize = bb.run().asBufferSize();
		}

		decorator = project.getTraceDecorator();
		trace = project.getTrace();
		ProgressPrinter progress;

		long steps = trace.getSizeS();
		if (steps > 0) {
			progress = new ProgressPrinter(analysisName, steps);
		} else {
			progress = new NullProgressPrinter(analysisName);
		}

		// build the newtork elements
		Network network = project.getNetwork();
		actorsSchedulers = new HashSet<>();
		for (Actor actor : network.getActors()) {
			actorsSchedulers.add(new ActorScheduler(actor));
		}

		buffersMap = new HashMap<>();
		for (Buffer buffer : network.getBuffers()) {
			BufferQueue queue = new BufferQueue();
			if (minimizeMemoryUsage) {
				queue.setSize(bufferSize.getSize(buffer));
			}
			buffersMap.put(buffer, queue);
		}

		networkWl = new NetworkWorkLoad();

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

		List<Pcp> pcps = new ArrayList<>();
		for (ActorScheduler actor : actorsSchedulers) {
			// if the value is null means that the actor has no successors
			if (actor.actorPcp != null) {
				pcps.add(actor.actorPcp);
			}
		}

		Collections.sort(pcps);
		Pcp cp = pcps.get(0);

		BottlenecksReport report = createReport(cp);

		Logger.info("%s [ENDED]", analysisName);
		return report;

	}

	public void setAnalysisName(String analysisName) {
		this.analysisName = analysisName;
	}

	public void setWeighter(TraceWeighter weighter) {
		this.weighter = weighter;
	}
	
	public void setBufferSize(BufferSize bufferSize) {
		this.bufferSize = bufferSize;
	}

}

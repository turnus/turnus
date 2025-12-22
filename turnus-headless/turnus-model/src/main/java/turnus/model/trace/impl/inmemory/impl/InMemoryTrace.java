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
package turnus.model.trace.impl.inmemory.impl;

import static turnus.common.TurnusOptions.MERGE_FSM;
import static turnus.common.TurnusOptions.MERGE_GUARD;
import static turnus.common.TurnusOptions.MERGE_PORT;
import static turnus.common.TurnusOptions.MERGE_TOKENS;
import static turnus.common.TurnusOptions.MERGE_VARIABLE;
import static turnus.common.util.StringUtils.createRandomKey;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterables;

import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import turnus.common.AbstractAttributable;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.io.ProgressPrinter;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.util.StepsIterable;
import turnus.model.trace.util.TraceProperties;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class InMemoryTrace extends AbstractAttributable implements Trace {

	private static final long DEFAULT_INITIAL_SIZE = 10000;
	private final File traceFile;

	private ObjectBigArrayBigList<Step> stepsList;
	private LongBigArrayBigList orderedSteps;

	private TraceProperties tData = new TraceProperties();

	public InMemoryTrace(File traceFile) {
		this.traceFile = traceFile;
		stepsList = new ObjectBigArrayBigList<Step>();
		stepsList.size(DEFAULT_INITIAL_SIZE);
	}

	public void addDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, Kind kind, Direction direction, String guard, String variable, String port,
			String sourcePort, String targetPort, int count, Map<String, Object> attributes) {

		StepImpl source = (StepImpl) stepsList.get(sourceId);
		StepImpl target = (StepImpl) stepsList.get(targetId);

		DependencyImpl d = null;

		if (!areDependenciesMerged(kind)) {
			switch (kind) {
			case FSM: {
				d = new DependencyFsm(source, target);
				break;
			}
			case VARIABLE: {
				d = new DependencyVariable(source, target, variable, direction);
				break;
			}
			case GUARD: {
				d = new DependencyGuard(source, target, guard, direction);
				break;
			}
			case TOKENS: {
				d = new DependencyTokens(source, target, sourcePort, targetPort, count);
				break;
			}
			case PORT: {
				d = new DependencyPort(source, target, port, direction);
				break;
			}
			default:
				Logger.warning("Dependency from \"%d\" to \"%d\" of kind \"%s\" has not been added", source.getId(),
						target.getId(), kind);
				return;
			}
		} else {
			// check if the source and target are already connected by a
			// merged dependency
			for (Dependency out : source.getOutgoings()) {
				if (out.getKind() == Kind.MERGED && out.getTarget() == target) {
					return;
				}
			}

			d = new DependencyMerged(source, target);
		}

		source.addOutgoing(d);
		target.addIncoming(d);
		d.setAttributes(attributes);

		tData.addDependency();
	}

	public void setConfiguration(Configuration configuration) {
		tData.setMergeFsm(configuration.getValue(MERGE_FSM, false));
		tData.setMergeGuard(configuration.getValue(MERGE_GUARD, false));
		tData.setMergePort(configuration.getValue(MERGE_PORT, false));
		tData.setMergeTokens(configuration.getValue(MERGE_TOKENS, false));
		tData.setMergeVariable(configuration.getValue(MERGE_VARIABLE, false));
	}

	@Override
	public boolean isSorted() {
		return tData.isSorted();
	}

	@Override
	public void sort() {
		if (tData.isSorted()) {
			Logger.info("The trace is already sorted");
			return;
		} else if (orderedSteps == null) {
			orderedSteps = new LongBigArrayBigList();
			orderedSteps.size(tData.getSteps());
		}

		// L = Empty list that will contain the sorted elements
		// S = Set of all nodes with no incoming edges
		//
		// while S is non-empty do
		// .. remove a node n from S
		// .. add n to tail of L
		// .. for each node m with an edge e from n to m do
		// .... remove edge e from the graph
		// .... if m has no other incoming edges then
		// ........ insert m into S
		// if graph has edges then
		// .. return error (graph has at least one cycle)
		// else
		// .. return L (a topologically sorted order)

		// search nodes without incoming edges
		final long steps = tData.getSteps();
		if (stepsList.size64() > steps) {
			stepsList.size(steps);
		}

		ObjectBigArrayBigList<Step> S = new ObjectBigArrayBigList<Step>();
		for (Step s : stepsList) {
			if (Iterables.isEmpty(s.getIncomings())) {
				S.push(s);
			}
		}

		Set<Step> sucessors = new HashSet<>();
		String REMOVED_EDGES = createRandomKey(this.getClass().getName(), "sort");

		long orderId = 0;
		ProgressPrinter progress = new ProgressPrinter("Trace topological sorting", steps);
		while (!S.isEmpty()) {
			Step s = S.pop();
			orderedSteps.set(orderId++, s.getId());
			progress.increment();

			sucessors.clear();
			for (Dependency outgoing : s.getOutgoings()) {
				outgoing.setAttribute(REMOVED_EDGES, true);
				sucessors.add(outgoing.getTarget());
			}

			// check if all edges of the sucessors are sorted
			for (Step sucessor : sucessors) {
				boolean insertInS = true;
				for (Dependency in : sucessor.getIncomings()) {
					if (!in.hasAttribute(REMOVED_EDGES)) {
						insertInS = false;
						break;
					}
				}
				if (insertInS) {
					S.push(sucessor);
				}
			}
		}

		tData.setSorted();
		progress.finish();

		progress = new ProgressPrinter("Checking for cycles", steps);
		for (Step s : stepsList) {
			for (Dependency out : s.getOutgoings()) {
				if (!out.hasAttribute(REMOVED_EDGES)) {
					// there is at least one cycle
					Logger.error("The trace has at least one cycle");
					progress.finish();
					return;
				}
			}
			progress.increment();
		}

		progress.finish();

	}

	@Override
	public Dependency addSchedulerDependency(Step source, Step target) {

		// check if the source and the target have already a scheduler
		// dependency
		for (Dependency out : source.getOutgoings()) {
			if (out.getKind() == Kind.SCHEDULER && out.getTarget() == target) {
				return out;
			}
		}

		Dependency d = new DependencyScheduler(source, target);
		((StepImpl) source).addOutgoing(d);
		((StepImpl) target).addIncoming(d);

		tData.addDependency();

		return d;
	}

	@Override
	public boolean close() {
		return true;
	}

	@Override
	public long getSizeD() {
		return tData.getDependencies();
	}

	@Override
	public long getSizeS() {
		return tData.getSteps();
	}

	@Override
	public Step getStep(long id) {
		return stepsList.get(id);
	}

	@Override
	public Iterable<Step> getSteps(Order order) {
		if ((order == Order.INCREASING_TO || order == Order.DECREASING_TO) && !isSorted()) {
			sort();
		}

		final long steps = tData.getSteps();
		Iterator<Step> iterator = null;

		switch (order) {
		case INCREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = 0;

				@Override
				public boolean hasNext() {
					return currentStep < steps;
				}

				@Override
				public Step next() {
					Long id = orderedSteps.get(currentStep++);
					return stepsList.get(id);
				}

				@Override
				public void remove() {
				}
			};

			break;

		case DECREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = steps;

				@Override
				public boolean hasNext() {
					return currentStep > 0;
				}

				@Override
				public Step next() {
					Long id = orderedSteps.get(--currentStep);
					return stepsList.get(id);
				}

				@Override
				public void remove() {
				}
			};

			break;

		case INCREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = 0;

				@Override
				public boolean hasNext() {
					return currentStep < steps;
				}

				@Override
				public Step next() {
					return stepsList.get(currentStep++);
				}

				@Override
				public void remove() {
				}
			};

			break;
		case DECREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = steps;

				@Override
				public boolean hasNext() {
					return currentStep > 0;
				}

				@Override
				public Step next() {
					return stepsList.get(--currentStep);
				}

				@Override
				public void remove() {
				}
			};
			break;
		}

		return new StepsIterable(iterator);
	}

	@Override
	public Iterable<Step> getSteps(Order order, final String actor, final String action) {
		if ((order == Order.INCREASING_TO || order == Order.DECREASING_TO) && !isSorted()) {
			sort();
		}

		final long steps = tData.getSteps();
		final long actionSteps = tData.getSteps(actor, action);

		Iterator<Step> iterator = null;

		switch (order) {
		case INCREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = 0;

				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actionSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Long id = orderedSteps.get(currentStep++);
						Step step = stepsList.get(id);
						if (step.getActor().equals(actor) && step.getAction().equals(action)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;

		case DECREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = steps;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actionSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Long id = orderedSteps.get(--currentStep);
						Step step = stepsList.get(id);
						if (step.getActor().equals(actor) && step.getAction().equals(action)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;

		case INCREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = 0;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actionSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Step step = stepsList.get(currentStep++);
						if (step.getActor().equals(actor) && step.getAction().equals(action)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;
		case DECREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = steps;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actionSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Step step = stepsList.get(--currentStep);
						if (step.getActor().equals(actor) && step.getAction().equals(action)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};
			break;
		}

		return new StepsIterable(iterator);
	}

	@Override
	public Iterable<Step> getSteps(Order order, final String actor) {
		if ((order == Order.INCREASING_TO || order == Order.DECREASING_TO) && !isSorted()) {
			sort();
		}

		final long steps = tData.getSteps();
		final long actorSteps = tData.getSteps(actor);

		Iterator<Step> iterator = null;

		switch (order) {
		case INCREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = 0;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actorSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Long id = orderedSteps.get(currentStep++);
						Step step = stepsList.get(id);
						if (step.getActor().equals(actor)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;

		case DECREASING_TO:
			iterator = new Iterator<Step>() {

				long currentStep = steps;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actorSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Long id = orderedSteps.get(--currentStep);
						Step step = stepsList.get(id);
						if (step.getActor().equals(actor)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;

		case INCREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = 0;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actorSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Step step = stepsList.get(currentStep++);
						if (step.getActor().equals(actor)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};

			break;
		case DECREASING_ID:
			iterator = new Iterator<Step>() {

				long currentStep = steps;
				long foundSteps = 0;

				@Override
				public boolean hasNext() {
					return foundSteps < actorSteps;
				}

				@Override
				public Step next() {
					for (;;) {
						Step step = stepsList.get(--currentStep);
						if (step.getActor().equals(actor)) {
							foundSteps++;
							return step;
						}
					}
				}

				@Override
				public void remove() {
				}
			};
			break;
		}

		return new StepsIterable(iterator);
	}

	@Override
	public boolean areDependenciesMerged(Kind kind) {
		return tData.isMerged(kind);
	}

	@Override
	public void removeSchedulerDependencies() {
		ProgressPrinter printer = new ProgressPrinter("Removing scheduler dependencies", stepsList.size64());

		Set<Dependency> toBeRemoved = new HashSet<>();
		for (Step step : stepsList) {
			toBeRemoved.clear();
			for (Dependency out : step.getOutgoings()) {
				if (out.getKind() == Kind.SCHEDULER) {
					toBeRemoved.add(out);
					tData.removeDependency();
				}
			}

			for (Dependency dep : toBeRemoved) {
				((StepImpl) step).outgoings.removeAll(toBeRemoved);
				((StepImpl) dep.getTarget()).incomings.removeAll(toBeRemoved);
			}

			printer.increment();

		}

		printer.finish();

	}

	public void addStep(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
			Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables,
			Map<String, Object> attributes) {

		StepImpl step = new StepImpl(id, actor, action, actorClass, readTokens, writeTokens, readVariables,
				writeVariables);
		step.setAttributes(attributes);

		// check tData
		if (stepsList.size64() < (id + 1)) {
			stepsList.size(id + DEFAULT_INITIAL_SIZE);
		}

		stepsList.set(id, step);
		tData.addStep(actor, action);
	}

	public void setExpectedSize(long expectedS, long expectedD) {
		if (expectedS <= 0) {
			Logger.debug("The expected tData of the trace is smaller then 1: the given value will be ignored");
			return;
		} else if (stepsList.size64() >= expectedS) {
			Logger.debug(
					"The expected tData of the trace is smaller or equal of the actual tData: the given value will be ignored");
			return;
		}

		stepsList.size(expectedS);

	}

	private class DependencyMerged extends DependencyImpl {

		protected DependencyMerged(Step source, Step target) {
			super(source, target);
		}

		@Override
		public Kind getKind() {
			return Kind.MERGED;
		}

		@Override
		public void setAttributes(Map<String, Object> attributes) {

		}

	}

	private class DependencyFsm extends DependencyImpl {

		protected DependencyFsm(Step source, Step target) {
			super(source, target);
		}

		@Override
		public Kind getKind() {
			return Kind.FSM;
		}

	}

	private class DependencyScheduler extends DependencyImpl {

		protected DependencyScheduler(Step source, Step target) {
			super(source, target);
		}

		@Override
		public Kind getKind() {
			return Kind.SCHEDULER;
		}

	}

	private class DependencyVariable extends DependencyImpl {
		private final String variable;
		private final Direction direction;

		protected DependencyVariable(Step source, Step target, String variable, Direction direction) {
			super(source, target);
			this.variable = variable;
			this.direction = direction;
		}

		@Override
		public Kind getKind() {
			return Kind.VARIABLE;
		}

		@Override
		public Direction getDirection() {
			return direction;
		}

		@Override
		public String getVariable() {
			return variable;
		}

	}

	private class DependencyGuard extends DependencyImpl {
		private final String guard;
		private final Direction direction;

		protected DependencyGuard(Step source, Step target, String guard, Direction direction) {
			super(source, target);
			this.guard = guard;
			this.direction = direction;
		}

		@Override
		public Kind getKind() {
			return Kind.GUARD;
		}

		@Override
		public Direction getDirection() {
			return direction;
		}

		@Override
		public String getGuard() {
			return guard;
		}

	}

	private class DependencyTokens extends DependencyImpl {
		private final String sourcePort;
		private final String targetPort;
		private final int count;

		protected DependencyTokens(Step source, Step target, String sourcePort, String targetPort, int count) {
			super(source, target);
			this.sourcePort = sourcePort;
			this.targetPort = targetPort;
			this.count = count;
		}

		@Override
		public Kind getKind() {
			return Kind.TOKENS;
		}

		@Override
		public String getSourcePort() {
			return sourcePort;
		}

		@Override
		public String getTargetPort() {
			return targetPort;
		}

		@Override
		public int getCount() {
			return count;
		}

	}

	private class DependencyPort extends DependencyImpl {
		private final String port;
		private final Direction direction;

		protected DependencyPort(Step source, Step target, String port, Direction direction) {
			super(source, target);
			this.port = port;
			this.direction = direction;
		}

		@Override
		public Kind getKind() {
			return Kind.PORT;
		}

		@Override
		public Direction getDirection() {
			return direction;
		}

		@Override
		public String getPort() {
			return port;
		}

	}

	private abstract class DependencyImpl extends AbstractAttributable implements Dependency {

		private final Step source;
		private final Step target;

		protected DependencyImpl(Step source, Step target) {
			this.source = source;
			this.target = target;
		}

		@Override
		public Step getSource() {
			return source;
		}

		@Override
		public Step getTarget() {
			return target;
		}

		@Override
		public String getVariable() {
			return null;
		}

		@Override
		public int getCount() {
			return 0;
		}

		@Override
		public String getGuard() {
			return null;
		}

		@Override
		public String getPort() {
			return null;
		}

		@Override
		public String getSourcePort() {
			return null;
		}

		@Override
		public String getTargetPort() {
			return null;
		}

		@Override
		public Kind getKind() {
			return Kind.UNKNOWN;
		}

		@Override
		public Direction getDirection() {
			return Direction.UNKNOWN;
		}

		@Override
		public long getSourceId() {
			return source.getId();
		}

		@Override
		public long getTargetId() {
			return target.getId();
		}

		@Override
		public String getSourceActor() {
			return source.getActor();
		}

		@Override
		public String getTargetActor() {
			return target.getActor();
		}

		@Override
		public String getSourceAction() {
			return source.getAction();
		}

		@Override
		public String getTargetAction() {
			return target.getAction();
		}

		public void setAttributes(Map<String, Object> attributes) {
			this.attributes = attributes;
		}

	}

	private class StepImpl extends AbstractAttributable implements Step {

		private final long id;
		private final String actor;
		private final String action;
		private final String actorClass;
		private final Map<String, Integer> readTokens;
		private final Map<String, Integer> writeTokens;
		private final List<String> readVariables;
		private final List<String> writeVariables;

		private ObjectList<Dependency> incomings;
		private ObjectList<Dependency> outgoings;

		private StepImpl(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
				Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables) {
			this.id = id;
			this.actor = actor;
			this.action = action;
			this.actorClass = actorClass;

			if (readTokens.isEmpty()) {
				this.readTokens = null;
			} else {
				this.readTokens = new HashMap<>(readTokens);
			}

			if (writeTokens.isEmpty()) {
				this.writeTokens = null;
			} else {
				this.writeTokens = new HashMap<>(writeTokens);
			}

			if (readVariables.isEmpty()) {
				this.readVariables = null;
			} else {
				this.readVariables = new ArrayList<>(readVariables);
			}

			if (writeVariables.isEmpty()) {
				this.writeVariables = null;
			} else {
				this.writeVariables = new ArrayList<>(writeVariables);
			}

		}

		@Override
		public long getId() {
			return id;
		}

		@Override
		public String getActor() {
			return actor;
		}

		@Override
		public String getActorClass() {
			return actorClass;
		}

		@Override
		public String getAction() {
			return action;
		}

		private void addIncoming(Dependency dep) {
			if (incomings == null) {
				incomings = new ObjectArrayList<>();
			}
			incomings.add(dep);
		}

		private void addOutgoing(Dependency dep) {
			if (outgoings == null) {
				outgoings = new ObjectArrayList<>();
			}
			outgoings.add(dep);
		}

		@Override
		public Iterable<Dependency> getIncomings() {
			if (incomings != null) {
				return incomings;
			}

			return Collections.emptyList();
		}

		@Override
		public Iterable<Dependency> getOutgoings() {
			if (outgoings != null) {
				return outgoings;
			}
			return Collections.emptyList();
		}

		private void setAttributes(Map<String, Object> attributes) {
			this.attributes = attributes;
		}

		@Override
		public String toString() {
			StringBuffer b = new StringBuffer();
			b.append("[step] ");
			b.append(id);
			b.append(", actor=").append(actor);
			b.append(", action=").append(action);
			b.append(", class=").append(actorClass);
			return b.toString();
		}

		@Override
		public Map<String, Integer> getReadTokens() {
			return readTokens != null ? readTokens : new HashMap<String, Integer>();
		}

		@Override
		public Map<String, Integer> getWriteTokens() {
			return writeTokens != null ? writeTokens : new HashMap<String, Integer>();
		}

		@Override
		public List<String> getReadVariables() {
			return readVariables != null ? readVariables : new ArrayList<String>();
		}

		@Override
		public List<String> getWriteVariables() {
			return writeVariables != null ? writeVariables : new ArrayList<String>();
		}

	}

	@Override
	public File getFile() {
		return traceFile;
	}

}

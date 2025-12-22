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
package turnus.analysis.profiler.dynamic.trace;

import static turnus.model.trace.Dependency.Direction.READ;
import static turnus.model.trace.Dependency.Direction.READ_READ;
import static turnus.model.trace.Dependency.Direction.READ_WRITE;
import static turnus.model.trace.Dependency.Direction.WRITE;
import static turnus.model.trace.Dependency.Direction.WRITE_READ;
import static turnus.model.trace.Dependency.Direction.WRITE_WRITE;
import static turnus.model.trace.Dependency.Kind.FSM;
import static turnus.model.trace.Dependency.Kind.PORT;
import static turnus.model.trace.Dependency.Kind.TOKENS;
import static turnus.model.trace.Dependency.Kind.VARIABLE;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Table;

import turnus.analysis.profiler.dynamic.data.StepDataBox;
import turnus.common.TurnusException;
import turnus.common.io.AsyncFileWriter;
import turnus.common.io.Logger;
import turnus.model.analysis.trace.TraceFactory;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.SharedVariable;
import turnus.model.dataflow.Variable;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Step;
import turnus.model.trace.io.XmlTraceStreamWriter;

/**
 * This class defines the Execution Trace Graph Builder. It collect all the
 * information required for generating the dependencies among successors. It write
 * the ETG using a stream XML writer.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class TraceEvaluator {

	/**
	 * This class defines the trace writer. It is implemented as a thread.
	 * 
	 * @author scb
	 *
	 */
	private class TraceWriter extends AsyncFileWriter {

		private XmlTraceStreamWriter traceWriter;

		private TraceWriter(File traceFile) throws TurnusException {
			super("Dynamic Profiler trace writer");
			traceWriter = new XmlTraceStreamWriter(traceFile);
		}

		@Override
		protected void init() throws TurnusException {
			traceWriter.open();
		}

		@Override
		@SuppressWarnings("unchecked")
		protected void export(Object value) throws TurnusException {
			if (value instanceof Step) {
				traceWriter.write((Step) value);
			} else if (value instanceof Collection) {
				traceWriter.write((Collection<Dependency>) value);
			}
		}

		@Override
		protected void close() throws TurnusException {
			traceWriter.close();
		}

	}

	private TraceWriter writer;
	private Network network;

	private HashMultiset<Action> actionsFirings;
	private HashMultiset<Action> actionsIncomings;
	private HashMultiset<Action> actionsOutgoings;
	private HashMultiset<Kind> dependenciesKind;
	private Table<Actor, Port, ProfiledStep> lastPortRead;
	private Table<Actor, Port, ProfiledStep> lastPortWrite;
	private Map<Actor, ProfiledStep> lastScheduledFsm;
	private Map<String, ProfiledStep> lastSharedVarLoad;

	private Map<String, ProfiledStep> lastSharedVarStore;
	private Table<Actor, Variable, ProfiledStep> lastVarLoad;
	private Table<Actor, Variable, ProfiledStep> lastVarStore;

	/**
	 * Constructor. Create a new trace builder.
	 * 
	 * @param traceFile
	 * @throws TurnusException
	 */
	public TraceEvaluator(Network network, File traceFile) throws TurnusException {
		try {
			writer = new TraceWriter(traceFile);
			writer.start();
		} catch (TurnusException e) {
			throw e;
		}

		this.network = network;

		lastSharedVarStore = new HashMap<>();
		lastSharedVarLoad = new HashMap<>();
		lastScheduledFsm = new HashMap<>();
		lastVarStore = HashBasedTable.create();
		lastVarLoad = HashBasedTable.create();
		lastPortWrite = HashBasedTable.create();
		lastPortRead = HashBasedTable.create();
		actionsFirings = HashMultiset.create();
		actionsIncomings = HashMultiset.create();
		actionsOutgoings = HashMultiset.create();
		dependenciesKind = HashMultiset.create();

	}

	/**
	 * Build the dependencies and update the builder status
	 * 
	 * @param data
	 */
	public void build(StepDataBox data) {
		ProfiledStep step = data.getStep();
		Action action = step.getAdapter(Action.class);
		Actor actor = step.getAdapter(Actor.class);
		Collection<Dependency> dependencies = new ArrayList<>();

		if (data.isScheduledByFsm()) {
			ProfiledStep pred = lastScheduledFsm.get(actor);
			if (pred != null) {
				ProfiledDepedency dep = new ProfiledDepedency(pred, step, FSM);
				dependencies.add(dep);
			}
		}

		for (Variable v : data.getLoads().elementSet()) {
			if (v.isShared()) {
				SharedVariable sv = (SharedVariable) v;
				String tag = sv.getTag();

				ProfiledStep pred = lastSharedVarLoad.get(tag);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(READ_READ);
					dependencies.add(dep);
				}

				pred = lastSharedVarStore.get(tag);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(WRITE_READ);
					dependencies.add(dep);
				}

			} else {
				ProfiledStep pred = lastVarLoad.get(actor, v);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(READ_READ);
					dependencies.add(dep);
				}

				pred = lastVarStore.get(actor, v);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(WRITE_READ);
					dependencies.add(dep);
				}
			}
		}

		for (Variable v : data.getStores().elementSet()) {
			if (v.isShared()) {
				SharedVariable sv = (SharedVariable) v;
				String tag = sv.getTag();

				ProfiledStep pred = lastSharedVarLoad.get(tag);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(READ_WRITE);
					dependencies.add(dep);
				}

				pred = lastSharedVarStore.get(tag);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(WRITE_WRITE);
					dependencies.add(dep);
				}
			} else {
				ProfiledStep pred = lastVarLoad.get(actor, v);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(READ_WRITE);
					dependencies.add(dep);
				}

				pred = lastVarStore.get(actor, v);
				if (pred != null) {
					ProfiledDepedency dep = new ProfiledDepedency(pred, step, VARIABLE);
					dep.setVariable(v);
					dep.setDirection(WRITE_WRITE);
					dependencies.add(dep);
				}
			}
		}

		for (Port p : data.getReadPorts()) {
			ProfiledStep pred = lastPortRead.get(actor, p);
			if (pred != null) {
				ProfiledDepedency dep = new ProfiledDepedency(pred, step, PORT);
				dep.setDirection(READ);
				dep.setPort(p);
				dependencies.add(dep);

			}
		}

		for (Port p : data.getWrittenPorts()) {
			ProfiledStep pred = lastPortWrite.get(actor, p);
			if (pred != null) {
				ProfiledDepedency dep = new ProfiledDepedency(pred, step, PORT);
				dep.setDirection(WRITE);
				dep.setPort(p);
				dependencies.add(dep);
			}
		}

		for (Map.Entry<ProfiledStep, HashMultiset<Buffer>> me : data.getTokensProducers().entrySet()) {
			ProfiledStep pred = me.getKey();
			for (Multiset.Entry<Buffer> e : me.getValue().entrySet()) {
				ProfiledDepedency dep = new ProfiledDepedency(pred, step, TOKENS);
				dep.setBuffer(e.getElement());
				dep.setCount(e.getCount());
				dependencies.add(dep);
			}
		}

		// add consumed tokens
		for (Entry<Buffer> e : data.getConsumedTokens().entrySet()) {
			Buffer buffer = e.getElement();
			int count = e.getCount();
			step.addReadTokens(buffer, count);
		}

		// add produced tokens
		for (Entry<Buffer> e : data.getProducedTokens().entrySet()) {
			Buffer buffer = e.getElement();
			int count = e.getCount();
			step.addWriteTokens(buffer, count);
		}

		// add load variables
		for (Variable variable : data.getLoadedVariables()) {
			step.addReadVariable(variable);
		}

		// add stored variables
		for (Variable variable : data.getStoredVariables()) {
			step.addWriteVariable(variable);
		}

		// update the trace size
		actionsFirings.add(action);
		for (Dependency d : dependencies) {
			ProfiledDepedency pd = (ProfiledDepedency) d;
			Action source = pd.getSource().getAdapter(Action.class);
			actionsIncomings.add(action);
			actionsOutgoings.add(source);
			dependenciesKind.add(pd.getKind());
		}

		try {
			// write the step
			writer.write(step);

			// and the dependencies
			if (!dependencies.isEmpty()) {
				writer.write(dependencies);
			}
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}

		update(data);

	}

	/**
	 * Close the builder and the file writer
	 */
	public TraceSizeReport close() {
		try {
			writer.stop();
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}

		return getReport();
	}

	/**
	 * Create the trace size report
	 * 
	 * @return
	 */
	private TraceSizeReport getReport() {
		// build the trace size information
		TraceSizeReport traceSize = TraceFactory.eINSTANCE.createTraceSizeReport();
		traceSize.setNetwork(network);

		// collect action successors and create actor successors
		long firings = 0;
		HashMultiset<Actor> actorsFirings = HashMultiset.create();
		for (Entry<Action> e : actionsFirings.entrySet()) {
			Action action = e.getElement();
			int count = e.getCount();
			firings += count;
			traceSize.getActionsFirings().put(action, (long) count);
			actorsFirings.add(action.getOwner(), count);
		}

		// collect network successors
		traceSize.setFirings(firings);

		// collect actor successors
		for (Entry<Actor> e : actorsFirings.entrySet()) {
			Actor actor = e.getElement();
			int count = e.getCount();
			traceSize.getActorsFirings().put(actor, (long) count);
		}

		// collect dependencies kinds and total number
		long dependencies = 0;
		for (Entry<Kind> e : dependenciesKind.entrySet()) {
			String kind = e.getElement().literal();
			int count = e.getCount();
			dependencies += count;
			traceSize.getDependenciesKinds().put(kind, (long) count);
		}

		// collect network dependencies
		traceSize.setDependencies(dependencies);

		// collect action incoming and create actor incoming
		HashMultiset<Actor> actorsIncomings = HashMultiset.create();
		for (Entry<Action> e : actionsIncomings.entrySet()) {
			Action action = e.getElement();
			int count = e.getCount();
			traceSize.getActionsIncomings().put(action, (long) count);
			actorsIncomings.add(action.getOwner(), count);
		}

		// collect actor incoming
		for (Entry<Actor> e : actorsIncomings.entrySet()) {
			Actor actor = e.getElement();
			int count = e.getCount();
			traceSize.getActorsIncoming().put(actor, (long) count);
		}

		// collect action outgoing and create actor outgoing
		HashMultiset<Actor> actorsOutgoings = HashMultiset.create();
		for (Entry<Action> e : actionsOutgoings.entrySet()) {
			Action action = e.getElement();
			int count = e.getCount();
			traceSize.getActionsOutgoings().put(action, (long) count);
			actorsOutgoings.add(action.getOwner(), count);
		}

		// collect actor outgoing
		for (Entry<Actor> e : actorsOutgoings.entrySet()) {
			Actor actor = e.getElement();
			int count = e.getCount();
			traceSize.getActorsOutgoings().put(actor, (long) count);
		}

		return traceSize;
	}

	/**
	 * Update resource utilization used to build the dependencies of the next
	 * fired step
	 * 
	 * @param data
	 */
	private void update(StepDataBox data) {
		ProfiledStep step = data.getStep();
		Actor actor = step.getAdapter(Actor.class);

		if (data.isScheduledByFsm()) {
			lastScheduledFsm.put(actor, step);
		}

		for (Variable v : data.getLoads()) {
			if (v.isShared()) {
				SharedVariable sv = (SharedVariable) v;
				String tag = sv.getTag();
				lastSharedVarLoad.put(tag, step);
			} else {
				lastVarLoad.put(actor, v, step);
			}
		}

		for (Variable v : data.getStores()) {
			if (v.isShared()) {
				SharedVariable sv = (SharedVariable) v;
				String tag = sv.getTag();
				lastSharedVarStore.put(tag, step);
			} else {
				lastVarStore.put(actor, v, step);
			}
		}

		for (Port p : data.getReadPorts()) {
			lastPortRead.put(actor, p, step);
		}

		for (Port p : data.getWrittenPorts()) {
			lastPortWrite.put(actor, p, step);
		}

	}

}

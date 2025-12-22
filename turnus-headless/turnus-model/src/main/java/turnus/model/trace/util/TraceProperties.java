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
package turnus.model.trace.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import turnus.common.AbstractAttributable;
import turnus.common.TurnusException;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Trace;

/**
 * This class can be used by trace implementation for quick storing
 * {@link Trace} attributes (e.g. the number of steps of a given actor or
 * action). Furthermore is easily serializable and deserializable.
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceProperties extends AbstractAttributable implements Serializable {

	/**
	 * The serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Load a {@link TraceProperties} from the given file
	 * 
	 * @param file
	 *            the input file
	 * @return the deserialized Trace Properties file
	 * @throws TurnusException
	 *             if the file cannot be opened or is corrupted
	 */
	public static TraceProperties load(File file) throws TurnusException {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			TraceProperties obj = (TraceProperties) in.readObject();
			in.close();
			return obj;
		} catch (Exception e) {
			throw new TurnusException("The trace parameters file cannot be loaded from \"" + file + "\"", e);
		}
	}

	/** a map of (actor, action, number of steps) */
	private Map<String, Map<String, Long>> actionsSteps;
	/** a map of (actor, number of steps) */
	private Map<String, Long> actorsSteps;
	/** the overall number of dependencies */
	private long dependencies = 0;
	/** if FSMs dependencies are merged */
	private boolean mergeFsm = false;
	/** if guards dependencies are merged */
	private boolean mergeGuard = false;
	/** if ports dependencies are merged */
	private boolean mergePort = false;
	/** if tokens dependencies are merged */
	private boolean mergeTokens = false;
	/** if variable dependencies are merged */
	private boolean mergeVariable = false;
	/** if sorted, the sink node id */
	private long sinkNode = -1;
	/** true if the trace has been sorted in a topological order */
	private boolean sorted = false;
	/** if sorted, the source node id */
	private long sourceNode = -1;
	/** the overall number of steps */
	private long steps = 0;

	/**
	 * Add a dependency. The {@link #isSorted()} is automatically set to
	 * <code>false</code>
	 */
	public void addDependency() {
		dependencies++;
		sorted = false;
	}

	/**
	 * Add a step of the given actor and action. The {@link #isSorted()} is
	 * automatically set to <code>false</code>
	 * 
	 * @param actor
	 *            actor name
	 * @param action
	 *            action name
	 */
	public void addStep(String actor, String action) {
		steps++;

		if (actorsSteps == null) {
			actorsSteps = new HashMap<>();
		}

		long value = actorsSteps.containsKey(actor) ? actorsSteps.get(actor) : 0;
		actorsSteps.put(actor, value + 1);

		if (actionsSteps == null) {
			actionsSteps = new HashMap<>();
		}

		Map<String, Long> actionStep = actionsSteps.get(actor);
		if (actionStep == null) {
			actionStep = new HashMap<>();
			actionsSteps.put(actor, actionStep);
		}
		value = actionStep.containsKey(action) ? actionStep.get(action) : 0;
		actionStep.put(actor, value + 1);

		sorted = false;
	}

	/**
	 * Get dependencies set size
	 * 
	 * @return
	 */
	public long getDependencies() {
		return dependencies;
	}

	/**
	 * Get the sink node id (valid if the trace is sorted)
	 * 
	 * @return
	 */
	public long getSinkNode() {
		return sinkNode;
	}

	/**
	 * Get the source node id (valid if the trace is sorted)
	 * 
	 * @return
	 */
	public long getSourceNode() {
		return sourceNode;
	}

	/**
	 * Get steps set size
	 * 
	 * @return
	 */
	public long getSteps() {
		return steps;
	}

	/**
	 * Get the steps set of an actor size
	 * 
	 * @param actor
	 *            the actor name
	 * @return
	 */
	public long getSteps(String actor) {
		if (actorsSteps != null && actorsSteps.containsKey(actor)) {
			return actorsSteps.get(actor);
		}
		return 0;
	}

	/**
	 * Get the steps set of an actor, action size
	 * 
	 * @param actor
	 *            the actor name
	 * @param action
	 *            the action name
	 * @return
	 */
	public long getSteps(String actor, String action) {
		if (actionsSteps != null && actionsSteps.containsKey(actor)) {
			Map<String, Long> actionSteps = actionsSteps.get(action);
			return actionSteps.containsKey(action) ? actionSteps.get(action) : 0;
		}
		return 0;
	}

	/**
	 * Return <code>true</code> if the dependencies of the given dependency
	 * {@link Kind} are merged
	 * 
	 * @param kind
	 *            the dependency kind
	 * @return
	 */
	public boolean isMerged(Kind kind) {
		switch (kind) {
		case FSM:
			return mergeFsm;
		case GUARD:
			return mergeGuard;
		case PORT:
			return mergePort;
		case VARIABLE:
			return mergeVariable;
		case TOKENS:
			return mergeTokens;
		default:
			return true;
		}
	}

	/**
	 * Return <code>true</code> if the FSM dependencies are merged
	 * 
	 * @return
	 */
	public boolean isMergeFsm() {
		return mergeFsm;
	}

	/**
	 * Return <code>true</code> if the guard dependencies are merged
	 * 
	 * @return
	 */
	public boolean isMergeGuard() {
		return mergeGuard;
	}

	/**
	 * Return <code>true</code> if the port dependencies are merged
	 * 
	 * @return
	 */
	public boolean isMergePort() {
		return mergePort;
	}

	/**
	 * Return <code>true</code> if the tokens dependencies are merged
	 * 
	 * @return
	 */
	public boolean isMergeTokens() {
		return mergeTokens;
	}

	/**
	 * Return <code>true</code> if the variable dependencies are merged
	 * 
	 * @return
	 */
	public boolean isMergeVariable() {
		return mergeVariable;
	}

	/**
	 * Return <code>true</code> if the trace is sorted
	 * 
	 * @return
	 */
	public boolean isSorted() {
		return sorted;
	}

	/**
	 * Remove a dependency from the set. The {@link #isSorted()} is
	 * automatically set to <code>false</code>
	 */
	public void removeDependency() {
		dependencies--;
		sorted = false;
	}

	/**
	 * Set the merge FSM dependencies status
	 * 
	 * @param mergeFsm
	 */
	public void setMergeFsm(boolean mergeFsm) {
		this.mergeFsm = mergeFsm;
	}

	/**
	 * Set the merge guard dependencies status
	 * 
	 * @param mergeGuard
	 */
	public void setMergeGuard(boolean mergeGuard) {
		this.mergeGuard = mergeGuard;
	}

	/**
	 * Set the merge port dependencies status
	 * 
	 * @param mergePort
	 */
	public void setMergePort(boolean mergePort) {
		this.mergePort = mergePort;
	}

	/**
	 * Set the merge tokens dependencies status
	 * 
	 * @param mergeTokens
	 */
	public void setMergeTokens(boolean mergeTokens) {
		this.mergeTokens = mergeTokens;
	}

	/**
	 * Set the merge variables dependencies status
	 * 
	 * @param mergeVariable
	 */
	public void setMergeVariable(boolean mergeVariable) {
		this.mergeVariable = mergeVariable;
	}

	/**
	 * Set the sink node
	 * 
	 * @param sinkNode
	 */
	public void setSinkNode(long sinkNode) {
		this.sinkNode = sinkNode;
	}

	/**
	 * Set <code>true</code> the sorted status of the trace
	 */
	public void setSorted() {
		this.sorted = true;
	}

	/**
	 * Set the source node id
	 * 
	 * @param sourceNode
	 */
	public void setSourceNode(long sourceNode) {
		this.sourceNode = sourceNode;
	}

	/**
	 * Store the trace properties in the given file
	 * 
	 * @param file
	 *            the file
	 * @throws TurnusException
	 *             if this object cannot be serialized
	 */
	public void store(File file) throws TurnusException {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			throw new TurnusException("The trace parameters file cannot be stored in \"" + file + "\"", e);
		}

	}

}

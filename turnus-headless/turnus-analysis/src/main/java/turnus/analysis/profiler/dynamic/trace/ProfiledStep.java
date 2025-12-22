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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.common.AbstractAttributable;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Variable;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;

/**
 * This class defines a profiled step.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfiledStep extends AbstractAttributable implements Step {

	private final long id;
	private final Action action;
	private Map<String, Integer> readTokens;
	private Map<String, Integer> writeTokens;
	private List<String> readVariables;
	private List<String> writeVariables;

	/**
	 * Create a new profiled step
	 * 
	 * @param action
	 *            the action producer
	 * @param id
	 *            the step identifier
	 */
	public ProfiledStep(Action action, long id) {
		this.action = action;
		this.id = id;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getActor() {
		return action.getOwner().getName();
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> clazz) {
		if (clazz.isAssignableFrom(Action.class)) {
			return (T) action;
		} else if (clazz.isAssignableFrom(Actor.class)) {
			return (T) action.getOwner();
		} else if (clazz.isAssignableFrom(ActorClass.class)) {
			return (T) action.getOwner().getActorClass();
		} else
			return null;
	}

	@Override
	public String getActorClass() {
		return action.getOwner().getActorClass().getName();
	}

	@Override
	public String getAction() {
		return action.getName();
	}

	/**
	 * For memory saving, this method is not supported. If called, it will throw
	 * an {@link UnsupportedOperationException}
	 */
	@Override
	public Iterable<Dependency> getIncomings() {
		throw new UnsupportedOperationException("Get incomings of a profiled step is not supported");
	}

	/**
	 * For memory saving, this method is not supported. If called, it will throw
	 * an {@link UnsupportedOperationException}
	 */
	@Override
	public Iterable<Dependency> getOutgoings() {
		throw new UnsupportedOperationException("Get outgoings of a profiled step is not supported");
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

	public void addReadTokens(Buffer buffer, int count) {
		if (readTokens == null) {
			readTokens = new HashMap<>();
		}
		readTokens.put(buffer.getTarget().getName(), count);
	}

	public void addWriteTokens(Buffer buffer, int count) {
		if (writeTokens == null) {
			writeTokens = new HashMap<>();
		}
		// TODO check fanout consistency
		writeTokens.put(buffer.getSource().getName(), count);
	}

	public void addReadVariable(Variable variable) {
		if (readVariables == null) {
			readVariables = new ArrayList<>();
		}

		String varName = variable.getName();
		if (!readVariables.contains(varName)) {
			readVariables.add(varName);
		}
	}

	public void addWriteVariable(Variable variable) {
		if (writeVariables == null) {
			writeVariables = new ArrayList<>();
		}

		String varName = variable.getName();
		if (!writeVariables.contains(varName)) {
			writeVariables.add(varName);
		}
	}

}

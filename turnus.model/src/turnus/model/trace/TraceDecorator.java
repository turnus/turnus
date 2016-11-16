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
package turnus.model.trace;

import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;

/**
 * This interface defines a {@link Trace} decorator. It fills the gap between
 * the string representation of the trace and the dataflow network model
 * 
 * @author Simone Casale Brunet
 *
 */
public interface TraceDecorator {

	/**
	 * Get the action of the given step
	 * 
	 * @param step
	 * @return
	 */
	public Action getAction(Step step);

	/**
	 * Get the actor of the given step
	 * 
	 * @param step
	 * @return
	 */
	public Actor getActor(Step step);

	/**
	 * Get the actor class of the given step
	 * 
	 * @param step
	 * @return
	 */
	public ActorClass getActorClass(Step step);

	/**
	 * Get the buffer of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Buffer getBuffer(Dependency dependency);

	/**
	 * Get the guard of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Guard getGuard(Dependency dependency);

	/**
	 * Get the network of the dataflow program of the trace
	 * 
	 * @return
	 */
	public Network getNetwork();

	/**
	 * Get the port of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Port getPort(Dependency dependency);

	/**
	 * Get the map of read tokens of the given step
	 * 
	 * @param step
	 * @return
	 */
	public Map<Buffer, Integer> getReadTokens(Step step);

	/**
	 * Get the {@link HashMultiset} of read tokens of the given step
	 * @param step 
	 * @return
	 */
	public HashMultiset<Buffer> getReadTokensAsSet(Step step);

	/**
	 * Get the map of read variables of the given step
	 * 
	 * @param step
	 * @return
	 */
	public List<Variable> getReadVariables(Step step);

	/**
	 * Get the source action of a dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Action getSourceAction(Dependency dependency);

	/**
	 * Get the source actor of a dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Actor getSourceActor(Dependency dependency);

	/**
	 * Get the source port of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Port getSourcePort(Dependency dependency);

	/**
	 * Get the target action of a dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Action getTargetAction(Dependency dependency);

	/**
	 * Get the target actor of a dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Actor getTargetActor(Dependency dependency);

	/**
	 * Get the target port of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Port getTargetPort(Dependency dependency);

	/**
	 * Get the buffer of the given dependency
	 * 
	 * @param dependency
	 * @return
	 */
	public Variable getVariable(Dependency dependency);
	
	
	/**
	 * Get the map of write tokens of the given step
	 * 
	 * @param step
	 * @return
	 */
	public Map<Buffer, Integer> getWriteTokens(Step step);
	
	/**
	 * Get the {@link HashMultiset} of write tokens of the given step
	 * @param step 
	 * @return
	 */
	public HashMultiset<Buffer> getWriteTokensAsSet(Step step);

	/**
	 * Get the map of write variables of the given step
	 * 
	 * @param step
	 * @return
	 */
	public List<Variable> getWriteVariables(Step step);

}

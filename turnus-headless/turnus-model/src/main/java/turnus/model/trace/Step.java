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

import org.eclipse.jgit.errors.NotSupportedException;

import turnus.common.Attributable;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;

/**
 * A step of the ETG. A step is a node which represents a <b>single action
 * firing</b>. The information that is always available, independently from the
 * trace implementation, is:
 * <ul>
 * <li>Id</li>
 * <li>Actor name</li>
 * <li>Action name</li>
 * <li>Read tokens</li>
 * <li>Write tokens</li>
 * <li>Read variables</li>
 * <li>Write variables</li>
 * </ul>
 * 
 * Incoming and outgoings may depends on the trace implementation
 * 
 * @author Simone Casale Brunet
 *
 */
public interface Step extends Attributable {

	/**
	 * Get the action name associated at this step
	 * 
	 * @see Action#getName()
	 * @return the action name
	 */
	String getAction();

	/**
	 * Get the actor name associated at this step
	 * 
	 * @see Actor#getName()
	 * @return the actor name
	 */
	String getActor();

	/**
	 * Get the actor class name associated at this step
	 * 
	 * @see ActorClass#getName()
	 * @return the actor class name
	 */
	String getActorClass();

	/**
	 * Get the step identifier
	 * 
	 * @return the step identifier
	 */
	long getId();

	/**
	 * Get the incoming of this step. Not all the trace implementations
	 * implements this method: only trace that support the graph based
	 * representation return a value, otherwise <code>null</code> or
	 * {@link NotSupportedException}.
	 * 
	 * @return the incoming
	 */
	Iterable<Dependency> getIncomings();

	/**
	 * Get the outgoings of this step. Not all the trace implementations
	 * implements this method: only trace that support the graph based
	 * representation return a value, otherwise <code>null</code> or
	 * {@link NotSupportedException}.
	 * 
	 * @return the outgoings
	 */
	Iterable<Dependency> getOutgoings();

	/**
	 * Get the map of read tokens (i.e. port-name // count)
	 * 
	 * @return the map of read tokens
	 */
	Map<String, Integer> getReadTokens();

	/**
	 * Get the list of read variables
	 * 
	 * @return the list of read variables
	 */
	List<String> getReadVariables();

	/**
	 * Get the map of write tokens (i.e. port-name // count)
	 * 
	 * @return the map of write tokens
	 */
	Map<String, Integer> getWriteTokens();

	/**
	 * Get the list of write variables
	 * 
	 * @return the list of write variables
	 */
	List<String> getWriteVariables();

}

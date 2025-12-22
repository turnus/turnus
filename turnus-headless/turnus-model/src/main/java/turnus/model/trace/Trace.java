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

import java.io.File;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.trace.Dependency.Kind;

/**
 * A trace (or execution trace graph, ETG) is a directed graph G(S,D) where the
 * set of nodes contains the collection of {@link Step} and the set of directed
 * arcs contains the collection of {@link Dependency}.
 * 
 * @author Simone Casale Brunet
 *
 */
public interface Trace {

	/**
	 * The ordering direction of the steps
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public enum Order {
		/** decreasing step identifier */
		DECREASING_ID, //
		/** decreasing step topological order */
		DECREASING_TO, //
		/** increasing step identifier */
		INCREASING_ID, //
		/** increasing step topological order */
		INCREASING_TO
	}

	/**
	 * Add scheduling dependency among a source and a target step
	 * 
	 * @param source
	 *            the source step
	 * @param target
	 *            the target step
	 * @return the scheduling dependency
	 */
	Dependency addSchedulerDependency(Step source, Step target);

	/**
	 * Return true if the given dependency kind are merged in a
	 * {@link Kind#MERGED} single dependency
	 * 
	 * @param kind
	 *            the dependency kind
	 * @return <code>true</code> if the dependency of the kind are merged
	 */
	boolean areDependenciesMerged(Kind kind);

	/**
	 * Close the trace (used if the trace is sorted in a file or database)
	 * 
	 * @return
	 */
	boolean close();

	/**
	 * Return the file of this execution trace graph. It could be a .trace or
	 * .tracez file
	 * 
	 * @return the trace file
	 */
	File getFile();

	/**
	 * Get the number of dependencies contained in this trace
	 * 
	 * @return the number of dependencies
	 */
	long getSizeD();

	/**
	 * Get the number of steps contained in this trace
	 * 
	 * @return the number of steps
	 */
	long getSizeS();

	/**
	 * Get the step with the given identifier. <code>null</code> if the step
	 * does not exist
	 * 
	 * @param id
	 *            the step identifier (see {@link Step#getId()})
	 * @return the step if it exist, <code>null</code> otherwise
	 */
	Step getStep(long id);

	/**
	 * Get the steps with the given {@link Order}. If the topological order is
	 * given and the trace is not sorted, some implementations make an automatic
	 * call to the {@link #sort()} method before returning the list
	 * 
	 * @param order
	 *            the order in which the steps are required
	 * @return the list of ordered steps
	 */
	Iterable<Step> getSteps(Order order);

	/**
	 * Get the steps of the given actor with the given {@link Order}. If the
	 * topological order is given and the trace is not sorted, some
	 * implementations make an automatic call to the {@link #sort()} method
	 * before returning the list
	 * 
	 * @param order
	 *            the order in which the steps are required
	 * @param actor
	 *            the actor name (see {@link Actor#getName()})
	 * @return the list of ordered steps
	 */
	Iterable<Step> getSteps(Order order, String actor);

	/**
	 * Get the steps of the given actor and action with the given {@link Order}.
	 * If the topological order is given and the trace is not sorted, some
	 * implementations make an automatic call to the {@link #sort()} method
	 * before returning the list
	 * 
	 * @param order
	 *            the order in which the steps are required
	 * @param actor
	 *            the actor name (see {@link Actor#getName()})
	 * @param action
	 *            the actor name (see {@link Action#getName()})
	 * @return
	 */
	Iterable<Step> getSteps(Order order, String actor, String action);

	/**
	 * Return <code>true</code> if this trace is sorted in a topological order.
	 * Each time a step or dependency is added/removed this value is
	 * <code>false</code>. Only after the method {@link #sort()} is called this
	 * value returns <code>true</code>
	 * 
	 * @return true if the trace is sorted
	 */
	boolean isSorted();

	/**
	 * Remove all the scheduling dependencies introduced in the trace
	 */
	void removeSchedulerDependencies();

	/**
	 * Sort the execution trace graph. The topological order of the trace is
	 * re-evaluated
	 */
	void sort();

}

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

import turnus.common.configuration.Configuration;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;

/**
 * This interface defines a trace builder. It is used by a trace file reader to
 * build an implementation of the trace (graph based or not)
 * 
 * @author Simone Casale Brunet
 *
 */
public interface TraceBuilder {

	/**
	 * Add the trace attributes
	 * 
	 * @param attributes
	 *            the trace attributes map
	 */
	void addAttributes(Map<String, Object> attributes);

	/**
	 * Add an {@link Kind#FSM} dependency
	 * 
	 * @param sourceId
	 * @param sourceActor
	 * @param sourceAction
	 * @param targetId
	 * @param targetActor
	 * @param targetAction
	 * @param attributes
	 */
	void addFsmDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, Map<String, Object> attributes);

	/**
	 * Add an {@link Kind#GUARD} dependency
	 * 
	 * @param sourceId
	 * @param sourceActor
	 * @param sourceAction
	 * @param targetId
	 * @param targetActor
	 * @param targetAction
	 * @param guard
	 * @param direction
	 * @param attributes
	 */
	void addGuardDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, String guard, Direction direction, Map<String, Object> attributes);

	/**
	 * Add an {@link Kind#PORT} dependency
	 * 
	 * @param sourceId
	 * @param sourceActor
	 * @param sourceAction
	 * @param targetId
	 * @param targetActor
	 * @param targetAction
	 * @param port
	 * @param direction
	 * @param attributes
	 */
	void addPortDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, String port, Direction direction, Map<String, Object> attributes);

	/**
	 * Add a step
	 * 
	 * @param id
	 * @param actor
	 * @param action
	 * @param actorClass
	 * @param readTokens
	 * @param writeTokens
	 * @param readVariables
	 * @param writeVariables
	 * @param attributes
	 */
	void addStep(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
			Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables,
			Map<String, Object> attributes);

	/**
	 * Add an {@link Kind#TOKENS} dependency
	 * 
	 * @param sourceId
	 * @param sourceActor
	 * @param sourceAction
	 * @param targetId
	 * @param targetActor
	 * @param targetAction
	 * @param sourcePort
	 * @param targetPort
	 * @param tokens
	 * @param attributes
	 */
	void addTokensDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, String sourcePort, String targetPort, int tokens, Map<String, Object> attributes);

	/**
	 * Add an {@link Kind#VARIABLE} dependency
	 * 
	 * @param sourceId
	 * @param sourceActor
	 * @param sourceAction
	 * @param targetId
	 * @param targetActor
	 * @param targetAction
	 * @param variable
	 * @param direction
	 * @param attributes
	 */
	void addVariableDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String variable, Direction direction,
			Map<String, Object> attributes);

	/**
	 * Build the trace
	 * 
	 * @return the trace
	 */
	Trace build();

	/**
	 * Set the configuration (it can contain tailored options for the builder)
	 * 
	 * @param configuration
	 *            the configuration
	 */
	void setConfiguration(Configuration configuration);

	/**
	 * Set the expected size (used to inform the implementation of the number of
	 * steps and dependencies that will be loaded)
	 * 
	 * @param steps
	 *            the number of expected steps
	 * @param dependencies
	 *            the number of expected dependencies
	 */
	void setExpectedSize(long steps, long dependencies);

}

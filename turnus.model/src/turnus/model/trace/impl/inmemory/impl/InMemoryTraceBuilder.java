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

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.common.configuration.Configuration;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Trace;
import turnus.model.trace.TraceBuilder;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class InMemoryTraceBuilder implements TraceBuilder {

	private final InMemoryTrace trace;

	public InMemoryTraceBuilder(File traceFile) {
		trace = new InMemoryTrace(traceFile);
	}

	@Override
	public Trace build() {
		return trace;
	}

	@Override
	public void setConfiguration(Configuration configuration) {
		trace.setConfiguration(configuration);
	}

	@Override
	public void addAttributes(Map<String, Object> attributes) {
		if (attributes != null) {
			for (Entry<String, Object> e : attributes.entrySet()) {
				trace.setAttribute(e.getKey(), e.getValue());
			}
		}
	}

	@Override
	public void addFsmDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, Map<String, Object> attributes) {
		trace.addDependency(sourceId, sourceActor, sourceAction, targetId, targetActor, targetAction, Kind.FSM, null,
				null, null, null, null, null, 0, attributes);
	}

	@Override
	public void addGuardDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String guard, Direction direction,
			Map<String, Object> attributes) {
		trace.addDependency(sourceId, sourceActor, sourceAction, targetId, targetActor, targetAction, Kind.GUARD,
				direction, guard, null, null, null, null, 0, attributes);

	}

	@Override
	public void addPortDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String port, Direction direction, Map<String, Object> attributes) {
		trace.addDependency(sourceId, sourceActor, sourceAction, targetId, targetActor, targetAction, Kind.PORT,
				direction, null, null, port, null, null, 0, attributes);
	}

	@Override
	public void addStep(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
			Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables,
			Map<String, Object> attributes) {
		
		trace.addStep(id, actor, action, actorClass, readTokens, writeTokens, readVariables, writeVariables,
				attributes);
	}

	@Override
	public void addTokensDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String sourcePort, String targetPort, int tokens,
			Map<String, Object> attributes) {
		trace.addDependency(sourceId, sourceActor, sourceAction, targetId, targetActor, targetAction, Kind.TOKENS, null,
				null, null, null, sourcePort, targetPort, tokens, attributes);

	}

	@Override
	public void addVariableDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String variable, Direction direction,
			Map<String, Object> attributes) {
		trace.addDependency(sourceId, sourceActor, sourceAction, targetId, targetActor, targetAction, Kind.VARIABLE,
				direction, null, variable, null, null, null, 0, null);

	}

	@Override
	public void setExpectedSize(long expectedS, long expectedD) {
		trace.setExpectedSize(expectedS, expectedD);

	}

}

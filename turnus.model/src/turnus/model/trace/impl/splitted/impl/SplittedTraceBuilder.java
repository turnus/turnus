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
package turnus.model.trace.impl.splitted.impl;

import static turnus.common.TurnusConstants.SPLIT_TRACE_PATH_NAME;
import static turnus.common.TurnusConstants.TRACE_PROPERTIES_FILE;
import static turnus.common.TurnusOptions.SPLIT_TRACE_DEPENDENCIES;

import java.io.File;
import java.util.List;
import java.util.Map;

import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.impl.splitted.io.XmlSplittedTraceWriter;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.TraceBuilder;
import turnus.model.trace.util.TraceProperties;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class SplittedTraceBuilder implements TraceBuilder {

	private boolean exportDependencies;

	private File traceFile;

	private File storePath;

	private TraceProperties tData = new TraceProperties();

	private XmlSplittedTraceWriter writer;

	public SplittedTraceBuilder(File traceFile) {
		this.traceFile = traceFile;
		storePath = new File(traceFile.getParentFile(), SPLIT_TRACE_PATH_NAME);
		writer = new XmlSplittedTraceWriter(storePath);
	}

	@Override
	public void addAttributes(Map<String, Object> attributes) {

	}

	@Override
	public void addFsmDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, Map<String, Object> attributes) {
		if (exportDependencies) {
			Dependency d = new SplittedDependency(sourceId, sourceActor, sourceAction, targetId, targetActor,
					targetAction, Kind.FSM, null, null, null, null, null, null, 0, attributes);
			writer.write(d);
			tData.addDependency();
		}
	}

	@Override
	public void addGuardDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String guard, Direction direction,
			Map<String, Object> attributes) {
		if (exportDependencies) {
			Dependency d = new SplittedDependency(sourceId, sourceActor, sourceAction, targetId, targetActor,
					targetAction, Kind.GUARD, direction, guard, null, null, null, null, 0, attributes);
			writer.write(d);
			tData.addDependency();
		}
	}

	@Override
	public void addPortDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String port, Direction direction, Map<String, Object> attributes) {
		if (exportDependencies) {
			Dependency d = new SplittedDependency(sourceId, sourceActor, sourceAction, targetId, targetActor,
					targetAction, Kind.PORT, direction, null, null, port, null, null, 0, attributes);
			writer.write(d);
			tData.addDependency();
		}

	}

	@Override
	public void addStep(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
			Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables,
			Map<String, Object> attributes) {
		Step step = new SplittedStep(id, actor, action, actorClass, readTokens, writeTokens, readVariables,
				writeVariables, attributes);
		writer.write(step);
		tData.addStep(actor, action);
	}

	@Override
	public void addTokensDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String sourcePort, String targetPort, int count,
			Map<String, Object> attributes) {
		if (exportDependencies) {
			Dependency d = new SplittedDependency(sourceId, sourceActor, sourceAction, targetId, targetActor,
					targetAction, Kind.TOKENS, null, null, null, null, sourcePort, targetPort, count, attributes);
			writer.write(d);
			tData.addDependency();
		}
	}

	@Override
	public void addVariableDependency(long sourceId, String sourceActor, String sourceAction, long targetId,
			String targetActor, String targetAction, String variable, Direction direction,
			Map<String, Object> attributes) {
		if (exportDependencies) {
			Dependency d = new SplittedDependency(sourceId, sourceActor, sourceAction, targetId, targetActor,
					targetAction, Kind.VARIABLE, direction, null, variable, null, null, null, 0, attributes);
			writer.write(d);
			tData.addDependency();
		}
	}

	@Override
	public Trace build() {
		writer.close();

		File dataFile = new File(storePath, TRACE_PROPERTIES_FILE);
		try {
			tData.store(dataFile);
		} catch (Exception e) {
			Logger.warning("The trace property file cannot be stored in %s", dataFile);
		}
		return new SplittedTrace(traceFile);
	}

	@Override
	public void setConfiguration(Configuration configuration) {
		exportDependencies = configuration.getValue(SPLIT_TRACE_DEPENDENCIES, false);
	}

	@Override
	public void setExpectedSize(long expectedS, long expectedD) {

	}

}

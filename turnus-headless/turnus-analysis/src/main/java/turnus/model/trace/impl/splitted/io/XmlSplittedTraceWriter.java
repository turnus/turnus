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
package turnus.model.trace.impl.splitted.io;

import static turnus.common.TurnusExtensions.TRACEZ;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;
import turnus.model.trace.io.XmlTraceStreamWriter;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlSplittedTraceWriter {

	final private File path;

	private Map<String, ActorTraceWriter> actorWriters = new HashMap<>();

	private class ActorTraceWriter extends XmlTraceStreamWriter {

		public ActorTraceWriter(File file) throws TurnusException {
			super(file);
		}
	}

	public XmlSplittedTraceWriter(File path) {
		this.path = path;
	}

	public void write(Step step) {
		try {
			getWriter(step.getActor()).write(step);
		} catch (Exception e) {
			Logger.error("Step \"%s\" cannot be written", step);
		}
	}

	public void write(Dependency dependency) {
		try {
			getWriter(dependency.getSourceActor()).write(dependency);
		} catch (Exception e) {
			Logger.error("Dependency \"%s\" cannot be written", dependency);
		}
	}

	private ActorTraceWriter getWriter(String actor) {
		ActorTraceWriter writer = actorWriters.get(actor);
		if (writer == null) {
			try {
				File traceFile = FileUtils.createFile(path, actor, TRACEZ);
				writer = new ActorTraceWriter(traceFile);
				writer.open();
				actorWriters.put(actor, writer);
			} catch (TurnusException e) {
				throw new TurnusRuntimeException("Writer building error for actor " + actor, e);
			}
		}
		return writer;
	}

	public void close() {
		for (Entry<String, ActorTraceWriter> entry : actorWriters.entrySet()) {
			try {
				entry.getValue().close();
			} catch (Exception e) {
				Logger.warning("The trace writer for actor \"%s\" has not been correctly closed", entry.getKey());
			}
		}
	}

}

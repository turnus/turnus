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
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;

import turnus.common.AbstractAttributable;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.impl.splitted.io.XmlSplittedTraceReader;
import turnus.model.trace.util.StepsIterable;
import turnus.model.trace.util.TraceProperties;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class SplittedTrace extends AbstractAttributable implements Trace {

	private final File traceFile;
	private TraceProperties tData;

	public SplittedTrace(File traceFile) {
		this.traceFile = traceFile;

		File path = new File(traceFile.getParentFile(), SPLIT_TRACE_PATH_NAME);
		Logger.debug("Loaded splitted trace from directory %s", path);
		File dataFile = new File(path, TRACE_PROPERTIES_FILE);
		try {
			tData = TraceProperties.load(dataFile);
		} catch (Exception e) {
			tData = null;
			Logger.warning("Trace size information cannot be loaded");
		}
	}

	@Override
	public Dependency addSchedulerDependency(Step source, Step target) {
		throw new TurnusRuntimeException("Method not supported: depedendencies cannot be added");
	}

	@Override
	public boolean areDependenciesMerged(Kind kind) {
		return false;
	}

	@Override
	public boolean close() {
		return false;
	}

	@Override
	public long getSizeD() {
		if (tData != null) {
			return tData.getDependencies();
		}
		return -1;
	}

	@Override
	public long getSizeS() {
		if (tData != null) {
			return tData.getSteps();
		}
		return -1;
	}

	@Override
	public Step getStep(long id) {
		throw new TurnusRuntimeException(
				"Method not supported: only all the steps or for a given actor or action name can be retrieved");
	}

	@Override
	public Iterable<Step> getSteps(Order order) {
		if (order != Order.INCREASING_ID) {
			throw new TurnusRuntimeException("Method not supported: only steps by increasing ID can be retrieved");
		}

		try {
			Iterator<Step> iterator = new Iterator<Step>() {

				XmlSplittedTraceReader reader = new XmlSplittedTraceReader(traceFile, true, false);

				@Override
				public boolean hasNext() {
					return reader.hasNext();
				}

				@Override
				public Step next() {
					return (Step) reader.next();
				}

				@Override
				public void remove() {
				}
			};

			return new StepsIterable(iterator);
		} catch (Exception e) {
			Logger.error("The trace file cannot be loaded from " + traceFile);
		}
		return Collections.emptyList();

	}

	@Override
	public Iterable<Step> getSteps(Order order, final String actor) {
		if (order != Order.INCREASING_ID) {
			throw new TurnusRuntimeException("Method not supported: only steps by increasing ID can be retrieved");
		}

		String filePath = null;
		File path = new File(traceFile.getParentFile(), SPLIT_TRACE_PATH_NAME);
		try {
			File tmp = FileUtils.createFile(path, actor, TRACEZ);
			if (!tmp.exists()) {
				tmp = FileUtils.createFile(path, actor, TRACE);
				if (!tmp.exists()) {
					// FIXME should we return a warning? problem arise when actors have no executed steps
					Logger.debug("The trace file for the actor \"%s\" cannot be located in %s", actor, path);
					return Collections.emptyList();
				}
			}
			filePath = tmp.getAbsolutePath();
		} catch (Exception e) {
			throw new TurnusRuntimeException(
					"The trace file for the actor \"" + actor + "\" cannot be loaded in" + path);
		}

		final File file = new File(filePath);

		try {
			Iterator<Step> iterator = new Iterator<Step>() {

				XmlSplittedTraceReader reader = new XmlSplittedTraceReader(file, true, false);

				@Override
				public boolean hasNext() {
					return reader.hasNext();
				}

				@Override
				public Step next() {
					return (Step) reader.next();
				}

				@Override
				public void remove() {
				}
			};

			return new StepsIterable(iterator);
		} catch (Exception e) {
			Logger.error("The trace file for the actor \"" + actor + "\" cannot be loaded from " + file);
		}
		return Collections.emptyList();
	}

	@Override
	public Iterable<Step> getSteps(Order order, final String actor, final String action) {
		if (order != Order.INCREASING_ID) {
			throw new TurnusRuntimeException("Method not supported: only steps by increasing ID can be retrieved");
		}

		String filePath = null;
		File path = new File(traceFile.getParentFile(), SPLIT_TRACE_PATH_NAME);
		try {
			File tmp = FileUtils.createFile(path, actor, TRACEZ);
			if (!tmp.exists()) {
				tmp = FileUtils.createFile(path, actor, TRACE);
				if (!tmp.exists()) {
					// FIXME should we return a warning? problem arise when actors have no executed steps
					Logger.debug("The trace file for the actor \"%s\" cannot be located in %s", actor, path);
					return Collections.emptyList();
				}
			}
			filePath = tmp.getAbsolutePath();
		} catch (Exception e) {
			throw new TurnusRuntimeException(
					"The trace file for the actor \"" + actor + "\" cannot be found in " + path);
		}

		final File file = new File(filePath);

		try {
			Iterator<Step> iterator = new Iterator<Step>() {
				Step nextStep = null;
				XmlSplittedTraceReader reader = new XmlSplittedTraceReader(file, true, false);

				{
					nextStep = loadNext();
				}

				@Override
				public boolean hasNext() {
					return nextStep != null;
				}

				private Step loadNext() {
					while (reader.hasNext()) {
						Step step = (Step) reader.next();
						if (step.getAction().equals(action)) {
							return step;
						}
					}
					return null;
				}

				@Override
				public Step next() {
					Step old = nextStep;
					nextStep = loadNext();
					return old;
				}

				@Override
				public void remove() {
				}
			};

			return new StepsIterable(iterator);
		} catch (Exception e) {
			Logger.error("The trace file for the actor \"" + actor + "\" cannot be loaded from" + file);
		}
		return Collections.emptyList();
	}

	@Override
	public boolean isSorted() {
		return true;
	}

	@Override
	public void removeSchedulerDependencies() {

	}

	@Override
	public void sort() {
	}

	@Override
	public File getFile() {
		return traceFile;
	}

}

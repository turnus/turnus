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
package turnus.analysis.profiler.dynamic;

import static turnus.common.TurnusOptions.EXPORT_GANTT_CHART;
import static turnus.common.TurnusOptions.EXPORT_TRACE;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.COMPRESS_TRACE;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.analysis.profiler.dynamic.data.ProfiledActor;
import turnus.analysis.profiler.dynamic.data.ProfiledBuffer;
import turnus.analysis.profiler.dynamic.data.StepDataBox;
import turnus.analysis.profiler.dynamic.trace.ProfiledStep;
import turnus.analysis.profiler.dynamic.trace.TraceEvaluator;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.TurnusOptions;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.analysis.profiler.ProfilerFactory;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.common.EOperator;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;
import turnus.model.trace.Step;

/**
 * This class defines the dynamic CAL profiler. It is a serial profiler for
 * evaluating the CAL program execution complexity. It provide the capability
 * for the generation of the Execution Trace Graph (ETG). In this implementation
 * only one step at a time can be profiled (i.e. it does not support a parallel
 * execution/interpretation).
 * 
 * @author Simone Casale-Brunet
 *
 */
public class DynamicProfiler {

	/** <code>true</code> if the Gantt chart should be exported */
	private boolean exportGantt;
	/** <code>true</code> if the ETG should be exported */
	private boolean exportTrace;
	/** the number of successors. Used to generate the {@link Step#getId()} */
	private long firing;
	/** the network under profiling */
	protected Network network;
	/** the output directory */
	private File outPath;
	/** the profiled actors */
	private Map<Actor, ProfiledActor> profiledActors;
	/** the profiled buffers */
	private Map<Buffer, ProfiledBuffer> profiledBuffers;
	/** the current firing data box */
	private StepDataBox stepData;
	/** the trace evaluator */
	private TraceEvaluator traceEvaluator;
	/** the configuration */
	private Configuration configuration;

	/**
	 * Constructor. Create a new dynamic profiler.
	 * 
	 * @param network the network under test
	 */
	public DynamicProfiler(Network network) {
		this.network = network;

		// create the actor data box
		profiledActors = new HashMap<>();
		for (Actor actor : network.getActors()) {
			profiledActors.put(actor, new ProfiledActor(actor));
		}

		// create the buffer data box
		profiledBuffers = new HashMap<>();
		for (Buffer buffer : network.getBuffers()) {
			profiledBuffers.put(buffer, new ProfiledBuffer(buffer));
		}

		// initialize successors
		firing = 0;

		// use the garbage collector: the startFiring method should be called to
		// start collecting profiling information
		stepData = StepDataBox.GARBAGE;
	}

	/**
	 * End the current step firing
	 */
	public void endFiring() {
		if (exportTrace) {
			traceEvaluator.build(stepData);
		}

		// update actor utilization
		Actor actor = stepData.getStep().getAdapter(Actor.class);
		profiledActors.get(actor).update(stepData);

		// update buffers utilization
		for (Buffer buffer : stepData.getUsedBuffers()) {
			profiledBuffers.get(buffer).update(stepData);
		}

		// increment the firing
		firing++;

		// wait for the next startForing before collecting new information
		stepData = StepDataBox.GARBAGE;
	}

	/**
	 * Return the network under profiling
	 * 
	 * @return
	 */
	public Network getNetwork() {
		return network;
	}

	/**
	 * Generate the dynamic profiling report
	 * 
	 * @return
	 */
	private DynamicProfilingReport getReport() {
		DynamicProfilingReport report = ProfilerFactory.eINSTANCE.createDynamicProfilingReport();
		report.setNetwork(network);

		// get actors data
		for (ProfiledActor a : profiledActors.values()) {
			report.getActorsData().add(a.getData());
		}

		// get buffers data
		for (ProfiledBuffer b : profiledBuffers.values()) {
			report.getBuffersData().add(b.getData());
		}

		return report;
	}

	/**
	 * Log an procedure call
	 * 
	 * @param procedure
	 */
	public void logEnter(Procedure procedure) {
		stepData.logEnter(procedure);
	}

	/**
	 * Log an operator call
	 * 
	 * @param operator
	 */
	public void logExecute(EOperator operator) {
		logExecute(operator, 1);
	}

	/**
	 * Log an operator call
	 * 
	 * @param operator
	 * @param count
	 */
	public void logExecute(EOperator operator, int count) {
		stepData.logExecute(operator, count);
	}

	/**
	 * Log the exit from a procedure
	 * 
	 * @param procedure
	 */
	public void logExit(Procedure procedure) {
		stepData.logExit(procedure);
	}

	/**
	 * Log a peek
	 * 
	 * @param buffer
	 * @param action
	 */
	public void logPeek(Buffer buffer, Action action) {
		profiledBuffers.get(buffer).logPeek(action);
	}

	/**
	 * Log a single token consumption
	 * 
	 * @param buffer
	 * @param value
	 */
	public void logRead(Buffer buffer, Object value) {
		Optional<ProfiledStep> producer = profiledBuffers.get(buffer).consumeToken();
		if (!producer.isEmpty()) {
			stepData.logRead(buffer, producer.get());
		} else {
			stepData.logRead(buffer);
		}
	}

	/**
	 * Log a single token consumption
	 * 
	 * @param buffer
	 * @param value
	 */
	public void logRead(Buffer buffer, int count, Object... values) {
		for (int i = 0; i < count; i++) {
			Optional<ProfiledStep> producer = profiledBuffers.get(buffer).consumeToken();
			if (!producer.isEmpty()) {
				stepData.logRead(buffer, producer.get());
			} else {
				stepData.logRead(buffer);
			}
		}
	}

	/**
	 * Log a variable read (i.e. load)
	 * 
	 * @param variable
	 * @param value
	 */
	public void logRead(Variable variable, Object value) {
		logRead(variable, 1, value);
	}

	/**
	 * Log a variable read (i.e. load)
	 * 
	 * @param variable
	 * @param count
	 * @param values
	 */
	public void logRead(Variable variable, int count, Object... values) {
		stepData.logRead(variable, count);
	}

	/**
	 * Log a buffer read miss
	 * 
	 * @param buffer
	 * @param action
	 */
	public void logReadMiss(Buffer buffer, Action action) {
		profiledBuffers.get(buffer).logReadMiss(action);
	}

	/**
	 * Log the production of a single token
	 * 
	 * @param buffer
	 * @param value
	 */
	public void logWrite(Buffer buffer, Object value) {
		profiledBuffers.get(buffer).produceToken(stepData.getStep());
		stepData.logWrite(buffer, 1);
	}

	/**
	 * Log the production of a single token
	 * 
	 * @param buffer
	 * @param count
	 * @param value
	 */
	public void logWrite(Buffer buffer, int count, Object value) {
		ProfiledStep step = stepData.getStep();
		for (int i = 0; i < count; i++) {
			profiledBuffers.get(buffer).produceToken(step);
		}
		stepData.logWrite(buffer, count);

	}

	/**
	 * Log the writing of a variable (i.e. store)
	 * 
	 * @param variable
	 * @parm count
	 * @param value
	 */
	public void logWrite(Variable variable, int count, Object... values) {
		stepData.logWrite(variable, count);
	}

	/**
	 * Log the writing of a variable (i.e. store)
	 * 
	 * @param variable
	 * @param value
	 */
	public void logWrite(Variable variable, Object value) {
		logWrite(variable, 1, value);
	}

	/**
	 * Log the write miss on a buffer
	 * 
	 * @param buffer
	 * @param action
	 */
	public void logWriteMiss(Buffer buffer, Action action) {
		profiledBuffers.get(buffer).logWriteMiss(action);
	}

	/**
	 * Set the configuration.
	 * 
	 * @see TurnusOptions#OUTPUT_DIRECTORY
	 * @see TurnusOptions#EXPORT_TRACE
	 * @see TurnusOptions#COMPRESS_TRACE
	 * @see TurnusOptions#EXPORT_GANTT_CHART
	 * 
	 * @param configuration
	 * @throws TurnusException
	 */
	public void setConfiguration(Configuration configuration) throws TurnusException {
		this.configuration = configuration;

		outPath = configuration.getValue(OUTPUT_DIRECTORY);
		if (outPath == null) {
			Logger.info("No output directoy specified, results will not be stored");
			exportTrace = false;
			exportGantt = false;
			return;
		}

		// check if the trace should be exported
		exportTrace = configuration.getValue(EXPORT_TRACE, false);
		try {
			if (exportTrace) {
				boolean tracez = configuration.getValue(COMPRESS_TRACE, true);
				String ext = tracez ? TurnusExtensions.TRACEZ : TurnusExtensions.TRACE;
				File traceFile = FileUtils.createFile(outPath, network.getName(), ext);
				traceEvaluator = new TraceEvaluator(network, traceFile);
			}
		} catch (Exception e) {
			Logger.error("The execution trace graph will not be generated. Error: \"%s\"", e.getMessage());
			exportTrace = false;
			traceEvaluator = null;
		}

		// check if the Gantt chart should be exported
		exportGantt = configuration.getValue(EXPORT_GANTT_CHART, false);
	}

	/**
	 * Start the firing of a new step
	 * 
	 * @param action
	 * @param scheduledByFsm
	 * @return
	 */
	public long startFiring(Action action, boolean scheduledByFsm) {
		ProfiledStep step = new ProfiledStep(action, firing);
		stepData = new StepDataBox(step, scheduledByFsm);
		return firing;
	}

	/**
	 * Stop the profiler and write profiling data if necessary
	 * 
	 * @throws TurnusException
	 */
	public void stop() throws TurnusException {
		firing = 0;
		stepData = StepDataBox.GARBAGE;

		// print warning if there are some unconsumed tokens
		for (ProfiledBuffer buffer : profiledBuffers.values()) {
			int uncosumed = buffer.getUnconsumedTokens();
			if (uncosumed > 0) {
				Logger.warning("There are %s unconsumed tokens in buffer %s", uncosumed, buffer);
			}
		}

		if (outPath == null) {
			return;
		}

		// store network definition and profiling data
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		File file = FileUtils.createFile(outPath, network.getName(), TurnusExtensions.NETWORK);
		EcoreUtils.storeEObject(network, resourceSet, file);
		file = FileUtils.changeExtension(file, TurnusExtensions.PROFILING_DYNAMIC);
		EcoreUtils.storeEObject(getReport(), resourceSet, file);

		if (exportTrace) {
			file = FileUtils.changeExtension(file, TurnusExtensions.TRACE_SIZE);
			TraceSizeReport traceSize = traceEvaluator.close();
			EcoreUtils.storeEObject(traceSize, resourceSet, file);
		}

		if (exportGantt) {

		}

		// store the configuration file
		file = FileUtils.changeExtension(file, TurnusExtensions.CONFIGURATION);
		configuration.store(file);
	}

}

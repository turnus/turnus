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
package turnus.analysis.profiler.code;

import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.analysis.profiler.code.util.HalsteadCounter;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.TurnusRuntimeException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.CodeProfilingReport;
import turnus.model.analysis.profiler.ComplexCodeData;
import turnus.model.analysis.profiler.ProfilerFactory;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Network;

/**
 * This class defines the static CAL profiler. It is a serial profiler for
 * evaluating the CAL code complexity.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class StaticProfiler {

	/**
	 * The static data complexity of an actor (i.e. {@link ActorClass})
	 * 
	 * @author scb
	 *
	 */
	private class ActorStaticData {
		/** actions complexity data */
		private Map<String, HalsteadCounter> actionsData;
		/** actor complexity data */
		private HalsteadCounter actorData;
		/** number of lines */
		private int nol;
		/** procedures complexity data */
		private Map<String, HalsteadCounter> proceduresData;

		/**
		 * Create a new actor static data
		 * 
		 * @param actor
		 *            the actor name
		 */
		private ActorStaticData(String actor) {
			actorData = new HalsteadCounter(actor);
			actionsData = new HashMap<>();
			proceduresData = new HashMap<>();
		}

		/**
		 * Return a {@link ComplexCodeData} of the profiled values
		 * 
		 * @return
		 */
		private ComplexCodeData getData() {
			ComplexCodeData data = actorData.asCodeData(ComplexCodeData.class);

			for (HalsteadCounter hc : actionsData.values()) {
				CodeData aData = hc.asCodeData(CodeData.class);
				data.getActionsData().add(aData);
			}

			for (HalsteadCounter hc : proceduresData.values()) {
				CodeData pData = hc.asCodeData(CodeData.class);
				data.getProceduresData().add(pData);
			}

			data.setNol(nol);

			return data;
		}
	}

	/** actors complexity data */
	private Map<String, ActorStaticData> actorsData;
	/** the current action */
	private String currentAction;
	/** the current actor */
	private String currentActor;
	/** the current procedure */
	private String currentProcedure;
	/** the network */
	private final Network network;
	/** the output directory */
	private File outPath;

	/**
	 * Create a new static profiler
	 * 
	 * @param network
	 */
	public StaticProfiler(Network network) {
		this.network = network;
		actorsData = new HashMap<>();
	}

	/**
	 * Add an operator
	 * 
	 * @param operand
	 *            the operand
	 */
	public void addOperand(String operand) {
		if (currentActor == null) {
			throw new TurnusRuntimeException("addOperand failed: no actor specified");
		}

		if (operand == null) {
			operand = "$undefined";
			Logger.debug("There is an operand without name in actor \"%s\"", currentActor);
		}

		ActorStaticData data = actorsData.get(currentActor);
		data.actorData.addOperand(operand);
		if (currentAction != null) {
			data.actionsData.get(currentAction).addOperand(operand);
		} else if (currentProcedure != null) {
			data.proceduresData.get(currentProcedure).addOperand(operand);
		}
	}

	/**
	 * Add an operator
	 * 
	 * @param operator
	 *            the operator
	 */
	public void addOperator(String operator) {
		if (currentActor == null) {
			throw new TurnusRuntimeException("addOperator failed: no actor specified");
		}

		if (operator == null) {
			operator = "$undefined";
			Logger.debug("There is an operator without name in actor \"%s\"", currentActor);
		}

		ActorStaticData data = actorsData.get(currentActor);
		data.actorData.addOperator(operator);
		if (currentAction != null) {
			data.actionsData.get(currentAction).addOperator(operator);
		} else if (currentProcedure != null) {
			data.proceduresData.get(currentProcedure).addOperator(operator);
		}

	}

	/**
	 * Enter in an action
	 * 
	 * @param action
	 *            the action name
	 */
	public void enterAction(String action) {
		if (currentAction != null) {
			throw new TurnusRuntimeException(
					"enterAction failed: profiler already in \"" + currentAction + "\" current action");
		}

		currentAction = action;
		actorsData.get(currentActor).actionsData.put(action, new HalsteadCounter(action));

	}

	/**
	 * Enter in an actor
	 * 
	 * @param actor
	 *            the actor name
	 * @param nol
	 *            the actor number of lines
	 */
	public void enterActor(String actor, int nol) {
		// check if actor, action and procedure are out
		if (currentActor != null) {
			throw new TurnusRuntimeException(
					"enterActor failed: profiler already in \"" + currentActor + "\" current actor");
		}

		if (currentAction != null) {
			throw new TurnusRuntimeException(
					"enterActor failed: profiler already in \"" + currentAction + "\" current action");
		}

		if (currentProcedure != null) {
			throw new TurnusRuntimeException(
					"enterActor failed: profiler already in \"" + currentProcedure + "\" current procedure");
		}

		currentActor = actor;

		ActorStaticData data = new ActorStaticData(actor);
		data.nol = nol;
		actorsData.put(actor, data);
	}

	/**
	 * Enter in a procedure
	 * 
	 * @param procedure
	 *            the procedure name
	 */
	public void enterProcedure(String procedure) {
		if (currentProcedure != null) {
			throw new TurnusRuntimeException(
					"enterProcedure failed: profiler already in \"" + currentProcedure + "\" current procedure");
		}

		if (procedure == null) {
			procedure = "$undefined";
			Logger.debug("There is a procedure without name in actor \"%s\"", currentActor);
		}

		currentProcedure = procedure;
		actorsData.get(currentActor).proceduresData.put(procedure, new HalsteadCounter(procedure));
	}

	/**
	 * Exit from an action
	 */
	public void exitAction() {
		if (currentAction == null) {
			throw new TurnusRuntimeException("exitAction failed: profiler already outside an action");
		}

		currentAction = null;
	}

	/**
	 * Exit from an actor
	 */
	public void exitActor() {
		if (currentActor == null) {
			throw new TurnusRuntimeException("exitActor failed: profiler already outside an actor");
		}

		currentActor = null;
	}

	/**
	 * Exit from a procedure
	 */
	public void exitProcedure() {
		if (currentProcedure == null) {
			throw new TurnusRuntimeException("exitProcedure failed: profiler already outside a procedure");
		}

		currentProcedure = null;
	}

	/**
	 * Get the profiling {@link CodeProfilingReport}
	 * 
	 * @return
	 */
	private CodeProfilingReport getReport() {
		CodeProfilingReport report = ProfilerFactory.eINSTANCE.createCodeProfilingReport();
		report.setNetwork(network);
		for (ActorStaticData data : actorsData.values()) {
			report.getActorClassesData().add(data.getData());
		}
		return report;
	}

	public void stop() throws TurnusException {
		if (outPath == null) {
			Logger.info("No output directoy specified, results will not be stored");
			return;
		}

		File netFile = FileUtils.createFile(outPath, network.getName(), TurnusExtensions.NETWORK);
		File reportFile = FileUtils.createFile(outPath, network.getName(), TurnusExtensions.PROFILING_CODE);
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		EcoreUtils.storeEObject(network, resourceSet, netFile);
		EcoreUtils.storeEObject(getReport(), resourceSet, reportFile);

	}

	public void setConfiguration(Configuration configuration) {
		outPath = configuration.getValue(OUTPUT_DIRECTORY);
	}

}

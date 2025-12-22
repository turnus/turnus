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
package turnus.analysis.profiler.dynamic.data;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.google.common.collect.HashMultiset;

import turnus.analysis.profiler.dynamic.trace.ProfiledStep;
import turnus.common.TurnusRuntimeException;
import turnus.model.common.EOperator;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class StepDataBox {

	private static class Garbage extends StepDataBox {

		private Garbage() {
			super(null, false);
		}

		@Override
		public void logEnter(Procedure procedure) {
		}

		@Override
		public void logExecute(EOperator operator, int count) {
		}

		@Override
		public void logExit(Procedure procedure) {
		}

		@Override
		public void logRead(Buffer buffer, ProfiledStep producer) {
		}
		
	
		@Override
		public void logRead(Variable variable, int count) {

		}

		@Override
		public void logWrite(Buffer buffer, int count) {
		}

		@Override
		public void logWrite(Variable variable, int count) {
		}
	}

	public static StepDataBox GARBAGE = new Garbage();

	/** the number of consumed tokens on each buffer */
	private HashMultiset<Buffer> consumedTokens;
	/** the number of loads on each variable */
	private HashMultiset<Variable> loads;
	/** the number of calls of each operand */
	private HashMultiset<EOperator> operators;
	/** the number of calls of each procedure */
	private HashMultiset<Procedure> procedures;
	/** the stack of active procedures (where the step is currently on) */
	private Deque<Procedure> proceduresStack;
	/** the number of loads on each variable for each procedure */
	private Map<Procedure, HashMultiset<Variable>> procLoads;
	/** the number of calls of each operand for each procedure */
	private Map<Procedure, HashMultiset<EOperator>> procOperators;
	/** the number of calls of each procedure for each procedure */
	private Map<Procedure, HashMultiset<Procedure>> procProcedures;
	/** the number of stores on each variable for each procedure */
	private Map<Procedure, HashMultiset<Variable>> procStores;;
	/** the number of produced tokens on each buffer */
	private HashMultiset<Buffer> producedTokens;
	/** <code>true</code> if it has been scheduled by the actor internal FSM */
	private final boolean scheduledByFsm;
	/** the step under profiling **/
	private final ProfiledStep step;
	/** the number of stores on each variable */
	private HashMultiset<Variable> stores;
	/** the tokens producers of each consumed token */
	private Map<ProfiledStep, HashMultiset<Buffer>> tokensProducers;

	public StepDataBox(ProfiledStep step, boolean scheduledByFsm) {
		this.step = step;
		this.scheduledByFsm = scheduledByFsm;

		operators = HashMultiset.create();
		procedures = HashMultiset.create();
		stores = HashMultiset.create();
		loads = HashMultiset.create();
		producedTokens = HashMultiset.create();
		consumedTokens = HashMultiset.create();
		tokensProducers = new HashMap<>();
		procOperators = new HashMap<>();
		procProcedures = new HashMap<>();
		procStores = new HashMap<>();
		procLoads = new HashMap<>();
		proceduresStack = new ArrayDeque<Procedure>();
	}

	/**
	 * Get the collection of variables that have been loaded
	 * 
	 * @return
	 */
	public Collection<Variable> getLoadedVariables() {
		return loads.elementSet();
	}

	/**
	 * Get the number of variables loads (i.e. read)
	 * 
	 * @return
	 */
	public HashMultiset<Variable> getLoads() {
		return loads;
	}

	/**
	 * Get the number of called operators
	 * 
	 * @return
	 */
	public HashMultiset<EOperator> getOperators() {
		return operators;
	}

	/**
	 * Get the number of called procedures
	 * 
	 * @return
	 */
	public HashMultiset<Procedure> getProcedures() {
		return procedures;
	}

	/**
	 * Get the number of variables loads (i.e. read) for each called procedure
	 * 
	 * @return
	 */
	public Map<Procedure, HashMultiset<Variable>> getProcLoads() {
		return procLoads;
	}

	/**
	 * Get the number of called operators for each called procedure
	 * 
	 * @return
	 */
	public Map<Procedure, HashMultiset<EOperator>> getProcOperators() {
		return procOperators;
	}

	/**
	 * Get the number of called procedures for each called procedure
	 * 
	 * @return
	 */
	public Map<Procedure, HashMultiset<Procedure>> getProcProcedures() {
		return procProcedures;
	}

	/**
	 * Get the number of variables stores (i.e. write) for each called procedure
	 * 
	 * @return
	 */
	public Map<Procedure, HashMultiset<Variable>> getProcStores() {
		return procStores;
	}

	/**
	 * Get the number of produced tokens for each buffer that has been used
	 * 
	 * @return
	 */
	public HashMultiset<Buffer> getProducedTokens() {
		return producedTokens;
	}

	/**
	 * Get the collection of ports that have been used for consuming at least
	 * one token
	 * 
	 * @return
	 */
	public Collection<Port> getReadPorts() {
		HashSet<Port> readPorts = new HashSet<Port>();
		for (Buffer buffer : consumedTokens.elementSet()) {
			readPorts.add(buffer.getTarget());
		}
		return readPorts;
	}

	/**
	 * Get the number of consumed tokens for each buffer that has been used
	 * 
	 * @return
	 */
	public HashMultiset<Buffer> getConsumedTokens() {
		return consumedTokens;
	}

	/**
	 * Return the collection of used buffers (where tokens have been consumed or
	 * produced)
	 * 
	 * @return
	 */
	public Collection<Buffer> getUsedBuffers() {
		Collection<Buffer> buffers = new HashSet<>();
		buffers.addAll(consumedTokens.elementSet());
		buffers.addAll(producedTokens.elementSet());
		return buffers;
	}

	/**
	 * Get the step under profiling
	 * 
	 * @return
	 */
	public ProfiledStep getStep() {
		return step;
	}

	/**
	 * Get the collection of variables that have been stored
	 * 
	 * @return
	 */
	public Collection<Variable> getStoredVariables() {
		return stores.elementSet();
	}

	/**
	 * Get the number of variables stores (i.e. write)
	 * 
	 * @return
	 */
	public HashMultiset<Variable> getStores() {
		return stores;
	}

	/**
	 * Get the list of steps that produced a tokens consumed by the profiled one
	 * with the corresponding number of consumed tokens and buffer
	 * 
	 * @return
	 */
	public Map<ProfiledStep, HashMultiset<Buffer>> getTokensProducers() {
		return tokensProducers;
	}

	/**
	 * Get the collection of ports that have been used for producing at least
	 * one token
	 * 
	 * @return
	 */
	public Collection<Port> getWrittenPorts() {
		HashSet<Port> writePorts = new HashSet<Port>();
		for (Buffer buffer : producedTokens.elementSet()) {
			writePorts.add(buffer.getSource());
		}
		return writePorts;
	}

	/**
	 * Return <code>true</code> if the step was scheduled by the fsm
	 * 
	 * @return
	 */
	public boolean isScheduledByFsm() {
		return scheduledByFsm;
	}

	/**
	 * Enter in a procedure
	 * 
	 * @param procedure
	 */
	public void logEnter(Procedure procedure) {
		// check if the procedure has been already called
		if (!procedures.contains(procedure)) {
			HashMultiset<Variable> readVars = HashMultiset.create();
			procLoads.put(procedure, readVars);
			HashMultiset<Variable> writeVars = HashMultiset.create();
			procStores.put(procedure, writeVars);
			HashMultiset<EOperator> opCalls = HashMultiset.create();
			procOperators.put(procedure, opCalls);
			HashMultiset<Procedure> procCalls = HashMultiset.create();
			procProcedures.put(procedure, procCalls);
		}
		procedures.add(procedure);

		if (!proceduresStack.isEmpty()) {
			procProcedures.get(proceduresStack.getLast()).add(procedure);
		}
		proceduresStack.addLast(procedure);
	}

	/**
	 * Execute an operator
	 * 
	 * @param operator
	 */
	public void logExecute(EOperator operator, int count) {
		operators.add(operator, count);
		if (!proceduresStack.isEmpty()) {
			procOperators.get(proceduresStack.getLast()).add(operator, count);
		}
	}

	/**
	 * Exit from a procedure
	 * 
	 * @param procedure
	 */
	public void logExit(Procedure procedure) {
		if (procedure != proceduresStack.removeLast()) {
			throw new TurnusRuntimeException("Invalid procedure exit");
		}
	}

	/**
	 * Read a token produced by the given producer
	 * 
	 * @param buffer
	 *            the buffer where the token has been read
	 * @param producer
	 *            the token producer
	 */
	public void logRead(Buffer buffer, ProfiledStep producer) {
		// get the set of tokens already produced by the given producer
		HashMultiset<Buffer> producedTokens = tokensProducers.get(producer);
		if (producedTokens == null) {
			producedTokens = HashMultiset.create();
			tokensProducers.put(producer, producedTokens);
		}
		producedTokens.add(buffer);

		// log the read
		consumedTokens.add(buffer);
	}

	/**
	 * Read a token produced by initialTokens
	 * 
	 * @param buffer
	 *            the buffer where the token has been read
	 */
	public void logRead(Buffer buffer) {
		// log the read
		consumedTokens.add(buffer);
	}
	
	/**
	 * Read a state variable
	 * 
	 * @param variable
	 */
	public void logRead(Variable variable, int count) {
		loads.add(variable, count);
		if (!proceduresStack.isEmpty()) {
			procLoads.get(proceduresStack.getLast()).add(variable, count);
		}
	}

	/**
	 * Write a single token in a buffer
	 * 
	 * @param buffer
	 */
	public void logWrite(Buffer buffer, int count) {
		producedTokens.add(buffer, count);
	}

	/**
	 * Write a state variable
	 * 
	 * @param variable
	 */
	public void logWrite(Variable variable, int count) {
		stores.add(variable, count);
		if (!proceduresStack.isEmpty()) {
			procStores.get(proceduresStack.getLast()).add(variable, count);
		}
	}

}

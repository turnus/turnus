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

import static turnus.model.common.StatisticalData.Util.asStatisticalData;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import turnus.model.analysis.profiler.ActionDynamicData;
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.ProfilerFactory;
import turnus.model.common.EOperator;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

/**
 * This class contains the profiling information for each actor and its
 * contained actions and procedures.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfiledActor {
	private final Actor actor;
	private ProfilingData actorData;
	private Map<Action, ProfilingData> actionsData;

	/**
	 * The profiling data for an actor or an action or a procedure
	 * 
	 * @author scb
	 *
	 */
	private class ProfilingData {
		/** the read tokens for each buffer */
		private Map<Buffer, SummaryStatistics> readTokens;
		/** the write tokens for each buffer */
		private Map<Buffer, SummaryStatistics> writeTokens;
		/** the executed operand calls */
		private Map<EOperator, SummaryStatistics> opCalls;
		/** the stored (i.e. write) variables */
		private Map<Variable, SummaryStatistics> storesSvars;
		/** the loaded (i.e. read) variables */
		private Map<Variable, SummaryStatistics> loadsSvars;
		/** the called procedures */
		private Map<Procedure, SummaryStatistics> procCalls;
		/** the executed operand calls of each called procedure */
		private Table<Procedure, EOperator, SummaryStatistics> procOpCalls;
		/** the stored (i.e. write) variables of each called procedure */
		private Table<Procedure, Variable, SummaryStatistics> procStoresVars;
		/** the loaded (i.e. read) variables of each called procedure */
		private Table<Procedure, Variable, SummaryStatistics> procLoadsVars;
		/** the called procedures of each called procedure */
		private Table<Procedure, Procedure, SummaryStatistics> procProcCalls;

		private ProfilingData(Actor actor) {
			readTokens = new HashMap<>();
			writeTokens = new HashMap<>();
			opCalls = new HashMap<>();
			storesSvars = new HashMap<>();
			loadsSvars = new HashMap<>();
			procCalls = new HashMap<>();
			procOpCalls = HashBasedTable.create();
			procStoresVars = HashBasedTable.create();
			procLoadsVars = HashBasedTable.create();
			procProcCalls = HashBasedTable.create();

			for (Buffer buffer : actor.getIncomingBuffers()) {
				readTokens.put(buffer, new SummaryStatistics());
			}

			for (Buffer buffer : actor.getOutgoingBuffers()) {
				writeTokens.put(buffer, new SummaryStatistics());
			}

			for (EOperator op : EOperator.values()) {
				opCalls.put(op, new SummaryStatistics());
			}

			for (Variable var : actor.getVariables()) {
				storesSvars.put(var, new SummaryStatistics());
				loadsSvars.put(var, new SummaryStatistics());
			}

			for (Procedure proc : actor.getProcedures()) {
				procCalls.put(proc, new SummaryStatistics());

				for (EOperator op : EOperator.values()) {
					procOpCalls.put(proc, op, new SummaryStatistics());
				}

				for (Variable var : actor.getVariables()) {
					procStoresVars.put(proc, var, new SummaryStatistics());
					procLoadsVars.put(proc, var, new SummaryStatistics());
				}

				for (Procedure sproc : actor.getProcedures()) {
					procProcCalls.put(proc, sproc, new SummaryStatistics());
				}
			}
		}

		private void update(StepDataBox data) {
			for (Multiset.Entry<EOperator> e : data.getOperators().entrySet()) {
				opCalls.get(e.getElement()).addValue(e.getCount());
			}

			for (Multiset.Entry<Variable> e : data.getLoads().entrySet()) {
				loadsSvars.get(e.getElement()).addValue(e.getCount());
			}

			for (Multiset.Entry<Variable> e : data.getStores().entrySet()) {
				storesSvars.get(e.getElement()).addValue(e.getCount());
			}

			for (Multiset.Entry<Procedure> e : data.getProcedures().entrySet()) {
				procCalls.get(e.getElement()).addValue(e.getCount());
			}

			for (Map.Entry<Procedure, HashMultiset<EOperator>> me : data.getProcOperators().entrySet()) {
				for (Multiset.Entry<EOperator> e : me.getValue().entrySet()) {
					procOpCalls.get(me.getKey(), e.getElement()).addValue(e.getCount());
				}
			}

			for (Map.Entry<Procedure, HashMultiset<Variable>> me : data.getProcLoads().entrySet()) {
				for (Multiset.Entry<Variable> e : me.getValue().entrySet()) {
					procLoadsVars.get(me.getKey(), e.getElement()).addValue(e.getCount());
				}
			}

			for (Map.Entry<Procedure, HashMultiset<Variable>> me : data.getProcStores().entrySet()) {
				for (Multiset.Entry<Variable> e : me.getValue().entrySet()) {
					procStoresVars.get(me.getKey(), e.getElement()).addValue(e.getCount());
				}
			}

			for (Map.Entry<Procedure, HashMultiset<Procedure>> me : data.getProcProcedures().entrySet()) {
				for (Multiset.Entry<Procedure> e : me.getValue().entrySet()) {
					procProcCalls.get(me.getKey(), e.getElement()).addValue(e.getCount());
				}
			}
		}
	}

	public ProfiledActor(Actor actor) {
		this.actor = actor;

		actorData = new ProfilingData(actor);

		actionsData = new HashMap<>();
		for (Action action : actor.getActions()) {
			actionsData.put(action, new ProfilingData(actor));
		}
	}

	/**
	 * Update the profiling information
	 * 
	 * @param data
	 */
	public void update(StepDataBox data) {
		actorData.update(data);
		actionsData.get(data.getStep().getAdapter(Action.class)).update(data);
	}

	public ActorDynamicData getData() {
		ProfilerFactory f = ProfilerFactory.eINSTANCE;

		ActorDynamicData data = f.createActorDynamicData();
		data.setActor(actor);

		// copy actor data
		{
			// operands
			for (Entry<EOperator, SummaryStatistics> e : actorData.opCalls.entrySet()) {
				data.getOperandsCalls().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// variable loads
			for (Entry<Variable, SummaryStatistics> e : actorData.loadsSvars.entrySet()) {
				data.getVariablesLoads().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// variable stores
			for (Entry<Variable, SummaryStatistics> e : actorData.storesSvars.entrySet()) {
				data.getVariablesStores().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// procedures calls
			for (Entry<Procedure, SummaryStatistics> e : actorData.procCalls.entrySet()) {
				data.getProceduresCalls().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// buffer reads
			for (Entry<Buffer, SummaryStatistics> e : actorData.readTokens.entrySet()) {
				data.getReadTokens().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// buffer writes
			for (Entry<Buffer, SummaryStatistics> e : actorData.writeTokens.entrySet()) {
				data.getWriteTokens().put(e.getKey(), asStatisticalData(e.getValue()));
			}

			// for each procedure create a complex dynamic data set
			for (Procedure p : actor.getProcedures()) {
				data.getProceduresData().put(p, f.createComplexDynamicData());
			}

			// procedures operands calls
			for (Cell<Procedure, EOperator, SummaryStatistics> c : actorData.procOpCalls.cellSet()) {
				data.getProceduresData().get(c.getRowKey()).getOperandsCalls().put(c.getColumnKey(),
						asStatisticalData(c.getValue()));
			}

			// procedures variables loads
			for (Cell<Procedure, Variable, SummaryStatistics> c : actorData.procLoadsVars.cellSet()) {
				data.getProceduresData().get(c.getRowKey()).getVariablesLoads().put(c.getColumnKey(),
						asStatisticalData(c.getValue()));
			}

			// procedures variables stores
			for (Cell<Procedure, Variable, SummaryStatistics> c : actorData.procStoresVars.cellSet()) {
				data.getProceduresData().get(c.getRowKey()).getVariablesStores().put(c.getColumnKey(),
						asStatisticalData(c.getValue()));
			}

			// procedure procedures calls
			for (Cell<Procedure, Procedure, SummaryStatistics> c : actorData.procProcCalls.cellSet()) {
				data.getProceduresData().get(c.getRowKey()).getProceduresCalls().put(c.getColumnKey(),
						asStatisticalData(c.getValue()));
			}
		}

		// copy action data
		{
			for (Entry<Action, ProfilingData> actionEntry : actionsData.entrySet()) {
				ProfilingData profData = actionEntry.getValue();

				ActionDynamicData adata = f.createActionDynamicData();
				adata.setAction(actionEntry.getKey());
				data.getActionsData().add(adata);

				// operands
				for (Entry<EOperator, SummaryStatistics> e : profData.opCalls.entrySet()) {
					adata.getOperandsCalls().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// variable loads
				for (Entry<Variable, SummaryStatistics> e : profData.loadsSvars.entrySet()) {
					adata.getVariablesLoads().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// variable stores
				for (Entry<Variable, SummaryStatistics> e : profData.storesSvars.entrySet()) {
					adata.getVariablesStores().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// procedures calls
				for (Entry<Procedure, SummaryStatistics> e : profData.procCalls.entrySet()) {
					adata.getProceduresCalls().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// buffer reads
				for (Entry<Buffer, SummaryStatistics> e : profData.readTokens.entrySet()) {
					adata.getReadTokens().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// buffer writes
				for (Entry<Buffer, SummaryStatistics> e : profData.writeTokens.entrySet()) {
					adata.getWriteTokens().put(e.getKey(), asStatisticalData(e.getValue()));
				}

				// for each procedure create a complex dynamic data set
				for (Procedure p : actor.getProcedures()) {
					adata.getProceduresData().put(p, f.createComplexDynamicData());
				}

				// procedures operands calls
				for (Cell<Procedure, EOperator, SummaryStatistics> c : profData.procOpCalls.cellSet()) {
					adata.getProceduresData().get(c.getRowKey()).getOperandsCalls().put(c.getColumnKey(),
							asStatisticalData(c.getValue()));
				}

				// procedures variables loads
				for (Cell<Procedure, Variable, SummaryStatistics> c : profData.procLoadsVars.cellSet()) {
					adata.getProceduresData().get(c.getRowKey()).getVariablesLoads().put(c.getColumnKey(),
							asStatisticalData(c.getValue()));
				}

				// procedures variables stores
				for (Cell<Procedure, Variable, SummaryStatistics> c : profData.procStoresVars.cellSet()) {
					adata.getProceduresData().get(c.getRowKey()).getVariablesStores().put(c.getColumnKey(),
							asStatisticalData(c.getValue()));
				}

				// procedure procedures calls
				for (Cell<Procedure, Procedure, SummaryStatistics> c : profData.procProcCalls.cellSet()) {
					adata.getProceduresData().get(c.getRowKey()).getProceduresCalls().put(c.getColumnKey(),
							asStatisticalData(c.getValue()));
				}
			}
		}

		return data;
	}

}

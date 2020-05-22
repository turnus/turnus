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
package turnus.analysis.trace.compressor;

import static turnus.model.common.StatisticalData.Util.asStatisticalData;
import static turnus.model.trace.Dependency.Direction.DISABLE;
import static turnus.model.trace.Dependency.Direction.ENABLE;
import static turnus.model.trace.Dependency.Direction.READ;
import static turnus.model.trace.Dependency.Direction.READ_READ;
import static turnus.model.trace.Dependency.Direction.READ_WRITE;
import static turnus.model.trace.Dependency.Direction.WRITE;
import static turnus.model.trace.Dependency.Direction.WRITE_READ;
import static turnus.model.trace.Dependency.Direction.WRITE_WRITE;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import turnus.analysis.Analysis;
import turnus.common.Attributable;
import turnus.common.TurnusException;
import turnus.model.analysis.trace.CompressedFsmDependency;
import turnus.model.analysis.trace.CompressedGuardDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.CompressedTokensDependency;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.CompressedVariableDependency;
import turnus.model.analysis.trace.TraceFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Step;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.util.TraceFileIterator;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class CompressedTraceAnalysis extends Analysis<CompressedTraceReport> {

	private class ActionNode {

		Action action;
		long count;
		Map<ActionNode, FsmDependency> fsmIncomings = new HashMap<>();
		Map<ActionNode, GuardDependency> guardIncomings = new HashMap<>();
		Map<ActionNode, PortDependency> portIncomings = new HashMap<>();
		Map<ActionNode, TokensDependency> tokensIncomings = new HashMap<>();
		Map<ActionNode, VariableDependency> varIncomings = new HashMap<>();

		ActionNode(Action action) {
			this.action = action;
		}

	}

	private class FsmDependency {

		private long count = 0;

	}

	private class GuardDependency {
		HashMultiset<Guard> disable = HashMultiset.create();
		HashMultiset<Guard> enable = HashMultiset.create();

	}

	private class PortDependency {
		HashMultiset<Port> read = HashMultiset.create();
		HashMultiset<Port> write = HashMultiset.create();

	}

	private class TokensDependency {
		// number of tokens dependencies (not the number of tokens!)
		HashMultiset<Buffer> count = HashMultiset.create();
		// the number of tokens is inside the summary statistics
		// (see method SummaryStatistics#getSum())
		Map<Buffer, SummaryStatistics> tokens = new HashMap<>();

	}

	private class VariableDependency {
		HashMultiset<Variable> readRead = HashMultiset.create();
		HashMultiset<Variable> readWrite = HashMultiset.create();
		HashMultiset<Variable> writeRead = HashMultiset.create();
		HashMultiset<Variable> writeWrite = HashMultiset.create();

	}

	private TraceDecorator decorator;

	private Map<Action, ActionNode> nodesMap = new HashMap<>();

	public CompressedTraceAnalysis(TraceProject project) {
		super(project);
	}

	private void add(Dependency dependency) {
		ActionNode src = nodesMap.get(decorator.getSourceAction(dependency));
		ActionNode tgt = nodesMap.get(decorator.getTargetAction(dependency));

		switch (dependency.getKind()) {
		case FSM: {
			// update the dependency
			FsmDependency in = tgt.fsmIncomings.get(src);
			if (in == null) {
				// create only once
				in = new FsmDependency();
				tgt.fsmIncomings.put(src, in);
			}
			in.count++;

			break;
		}
		case GUARD: {
			Guard guard = decorator.getGuard(dependency);
			Direction dir = dependency.getDirection();

			// update the dependency
			GuardDependency in = tgt.guardIncomings.get(src);
			if (in == null) {
				// create only once
				in = new GuardDependency();
				tgt.guardIncomings.put(src, in);
			}
			if (dir == ENABLE) {
				in.enable.add(guard);
			} else if (dir == DISABLE) {
				in.disable.add(guard);
			} else {
				// FIXME error
			}

			break;
		}
		case VARIABLE: {
			Variable variable = decorator.getVariable(dependency);
			Direction dir = dependency.getDirection();

			// update the dependency
			VariableDependency in = tgt.varIncomings.get(src);
			if (in == null) {
				// create only once
				in = new VariableDependency();
				tgt.varIncomings.put(src, in);
			}
			if (dir == READ_READ) {
				in.readRead.add(variable);
			} else if (dir == READ_WRITE) {
				in.readWrite.add(variable);
			} else if (dir == WRITE_READ) {
				in.writeRead.add(variable);
			} else if (dir == WRITE_WRITE) {
				in.writeWrite.add(variable);
			} else {
				// FIXME error
			}
			break;
		}
		case PORT: {
			Port port = decorator.getPort(dependency);
			Direction dir = dependency.getDirection();

			// update the dependency
			PortDependency in = tgt.portIncomings.get(src);
			if (in == null) {
				// create only once
				in = new PortDependency();
				tgt.portIncomings.put(src, in);
			}
			if (dir == READ) {
				in.read.add(port);
			} else if (dir == WRITE) {
				in.write.add(port);
			} else {
				// FIXME error
			}

			break;
		}
		case TOKENS: {
			Buffer buffer = decorator.getBuffer(dependency);
			int count = dependency.getCount();

			// update the dependency
			TokensDependency in = tgt.tokensIncomings.get(src);
			if (in == null) {
				// create only once
				in = new TokensDependency();
				tgt.tokensIncomings.put(src, in);
			}

			in.count.add(buffer);

			SummaryStatistics stat = in.tokens.get(buffer);
			if (stat == null) {
				stat = new SummaryStatistics();
				in.tokens.put(buffer, stat);
			}
			stat.addValue(count);

			break;
		}
		default:
			break;
		}
	}

	private void add(Step step) {
		Action action = decorator.getAction(step);

		ActionNode node = nodesMap.get(action);
		node.count++;
	}

	private CompressedTraceReport getReport() {
		TraceFactory f = TraceFactory.eINSTANCE;
		CompressedTraceReport report = f.createCompressedTraceReport();
		report.setAlgorithm("Compressed execution trace graph analysis");
		report.setDate(new Date());
		report.setNetwork(project.getNetwork());
		report.setTraceFile(project.getTraceFile().getAbsolutePath());

		// copy the nodes
		Map<ActionNode, CompressedStep> stepsMap = new HashMap<>();
		for (ActionNode node : nodesMap.values()) {
			CompressedStep step = f.createCompressedStep();
			step.setAction(node.action);
			step.setCount(node.count);

			report.getSteps().add(step);
			stepsMap.put(node, step);
		}

		// copy the incomings of all the steps
		for (ActionNode node : nodesMap.values()) {
			CompressedStep src = stepsMap.get(node);

			// FSM
			for (Entry<ActionNode, FsmDependency> e : node.fsmIncomings.entrySet()) {
				CompressedStep tgt = stepsMap.get(e.getKey());
				FsmDependency in = e.getValue();

				CompressedFsmDependency d = f.createCompressedFsmDependency();
				report.getDependencies().add(d);

				d.setSource(src);
				d.setTarget(tgt);

				d.setCount(in.count);
			}

			// GUARD
			for (Entry<ActionNode, GuardDependency> e : node.guardIncomings.entrySet()) {
				CompressedStep tgt = stepsMap.get(e.getKey());
				GuardDependency in = e.getValue();

				CompressedGuardDependency d = f.createCompressedGuardDependency();
				report.getDependencies().add(d);

				d.setSource(src);
				d.setTarget(tgt);

				// disable
				for (Multiset.Entry<Guard> ge : in.disable.entrySet()) {
					Guard guard = ge.getElement();
					long count = ge.getCount();
					d.getDisableMap().put(guard, count);
				}

				// enable
				for (Multiset.Entry<Guard> ge : in.enable.entrySet()) {
					Guard guard = ge.getElement();
					long count = ge.getCount();
					d.getEnableMap().put(guard, count);
				}
			}

			// VARIABLES
			for (Entry<ActionNode, VariableDependency> e : node.varIncomings.entrySet()) {
				CompressedStep tgt = stepsMap.get(e.getKey());
				VariableDependency in = e.getValue();

				CompressedVariableDependency d = f.createCompressedVariableDependency();
				report.getDependencies().add(d);

				d.setSource(src);
				d.setTarget(tgt);

				// read/read
				for (Multiset.Entry<Variable> ge : in.readRead.entrySet()) {
					Variable variable = ge.getElement();
					long count = ge.getCount();
					d.getReadReadMap().put(variable, count);
				}

				// read/write
				for (Multiset.Entry<Variable> ge : in.readWrite.entrySet()) {
					Variable variable = ge.getElement();
					long count = ge.getCount();
					d.getReadWriteMap().put(variable, count);
				}

				// write/read
				for (Multiset.Entry<Variable> ge : in.writeRead.entrySet()) {
					Variable variable = ge.getElement();
					long count = ge.getCount();
					d.getWriteReadMap().put(variable, count);
				}

				// write/write
				for (Multiset.Entry<Variable> ge : in.writeWrite.entrySet()) {
					Variable variable = ge.getElement();
					long count = ge.getCount();
					d.getWriteWriteMap().put(variable, count);
				}
			}

			// TOKENS
			for (Entry<ActionNode, TokensDependency> e : node.tokensIncomings.entrySet()) {
				CompressedStep tgt = stepsMap.get(e.getKey());
				TokensDependency in = e.getValue();

				CompressedTokensDependency d = f.createCompressedTokensDependency();
				report.getDependencies().add(d);

				d.setSource(src);
				d.setTarget(tgt);

				// count
				for (Multiset.Entry<Buffer> ge : in.count.entrySet()) {
					Buffer buffer = ge.getElement();
					long count = ge.getCount();
					d.getCountMap().put(buffer, count);
				}

				// statistical data
				for (Entry<Buffer, SummaryStatistics> ge : in.tokens.entrySet()) {
					Buffer buffer = ge.getKey();
					SummaryStatistics count = ge.getValue();
					d.getTokensMap().put(buffer, asStatisticalData(count));
				}
			}
		}

		return report;
	}

	public CompressedTraceReport run() throws TurnusException {

		decorator = project.getTraceDecorator();
		File traceFile = project.getTraceFile();

		// create the actions nodes
		nodesMap.clear();
		for (Actor actor : project.getNetwork().getActors()) {
			for (Action action : actor.getActions()) {
				nodesMap.put(action, new ActionNode(action));
			}
		}

		TraceFileIterator iterator = new TraceFileIterator(traceFile);
		while (iterator.hasNext()) {
			Attributable attributable = iterator.next();
			if (attributable instanceof Step) {
				add((Step) attributable);
			} else if (attributable instanceof Dependency) {
				add((Dependency) attributable);
			}
		}

		return getReport();

	}

}

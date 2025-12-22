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

import static turnus.common.TurnusExtensions.NETWORK;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;

import java.io.File;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.common.collect.HashMultiset;

import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;
import turnus.model.trace.impl.inmemory.InMemoryTraceLoader;

/**
 * This class defines a {@link Trace} project
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceProject {

	/**
	 * The {@link TraceDecorator} implementation
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class TraceDecoratorImpl implements TraceDecorator {

		private final Map<String, Actor> actorsMap = new HashMap<>();
		private final Map<String, ActorClass> classesMap = new HashMap<>();
		private final Map<String, Map<String, Variable>> variablesMap = new HashMap<>();
		private final Map<String, Map<String, Action>> actionsMap = new HashMap<>();
		private final Map<String, Map<String, Port>> inputPortsMap = new HashMap<>();
		private final Map<String, Map<String, Port>> outputPortsMap = new HashMap<>();

		private TraceDecoratorImpl() {

			for (Actor actor : network.getActors()) {
				String actorName = actor.getName();
				actorsMap.put(actorName, actor);

				Map<String, Action> actions = new HashMap<>();
				actionsMap.put(actorName, actions);

				Map<String, Port> inputs = new HashMap<>();
				inputPortsMap.put(actorName, inputs);
				Map<String, Port> outputs = new HashMap<>();
				outputPortsMap.put(actorName, outputs);

				Map<String, Variable> variables = new HashMap<>();
				variablesMap.put(actorName, variables);

				for (Action action : actor.getActions()) {
					actions.put(action.getName(), action);
				}

				for (Variable var : actor.getVariables()) {
					variables.put(var.getName(), var);
				}

				for (Port port : actor.getOutputPorts()) {
					outputs.put(port.getName(), port);
				}

				for (Port port : actor.getInputPorts()) {
					inputs.put(port.getName(), port);
				}
			}

			for (ActorClass clazz : network.getActorClasses()) {
				classesMap.put(clazz.getName(), clazz);
			}

		}

		@Override
		public Action getAction(Step step) {
			try {
				return actionsMap.get(step.getActor()).get(step.getAction());
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public Actor getActor(Step step) {
			return actorsMap.get(step.getActor());
		}

		@Override
		public ActorClass getActorClass(Step step) {
			return classesMap.get(step.getActorClass());
		}

		@Override
		public Buffer getBuffer(Dependency dep) {
			String tgtActor = dep.getTargetActor();
			String tgtPort = dep.getTargetPort();
			try {
				return inputPortsMap.get(tgtActor).get(tgtPort).getInput();
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public Guard getGuard(Dependency dep) {
			String actor = dep.getSourceActor();
			String action = dep.getSourceAction();
			String guard = dep.getGuard();
			try {
				return actionsMap.get(actor).get(action).getGuard(guard);
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public Network getNetwork() {
			return network;
		}

		@Override
		public Port getPort(Dependency dep) {
			String actor = dep.getSourceActor();
			String port = dep.getPort();

			try {
				switch (dep.getDirection()) {
				case READ:
					return inputPortsMap.get(actor).get(port);
				case WRITE:
					return outputPortsMap.get(actor).get(port);
				default:
					break;
				}
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public Map<Buffer, Integer> getReadTokens(Step step) {
			Map<Buffer, Integer> tokens = new HashMap<>();
			String actor = step.getActor();
			for (Map.Entry<String, Integer> pe : step.getReadTokens().entrySet()) {
				String inport = pe.getKey();
				Buffer buffer = inputPortsMap.get(actor).get(inport).getInput();
				tokens.put(buffer, pe.getValue());
			}

			return tokens;
		}

		@Override
		public List<Variable> getReadVariables(Step step) {
			List<Variable> variables = new ArrayList<>();
			List<String> list = step.getReadVariables();
			if (!list.isEmpty()) {
				String actor = step.getActor();
				for (String var : list) {
					variables.add(variablesMap.get(actor).get(var));
				}
			}

			return variables;
		}

		@Override
		public Action getSourceAction(Dependency dep) {
			String actor = dep.getSourceActor();
			String action = dep.getSourceAction();
			return actionsMap.get(actor).get(action);
		}

		@Override
		public Actor getSourceActor(Dependency dep) {
			return actorsMap.get(dep.getSourceActor());
		}

		@Override
		public Port getSourcePort(Dependency dep) {
			String actor = dep.getSourceActor();
			String port = dep.getSourcePort();
			return inputPortsMap.get(actor).get(port);
		}

		@Override
		public Action getTargetAction(Dependency dep) {
			String actor = dep.getTargetActor();
			String action = dep.getTargetAction();
			return actionsMap.get(actor).get(action);
		}

		@Override
		public Actor getTargetActor(Dependency dep) {
			return actorsMap.get(dep.getTargetActor());
		}

		@Override
		public Port getTargetPort(Dependency dep) {
			String actor = dep.getTargetActor();
			String port = dep.getTargetPort();
			return outputPortsMap.get(actor).get(port);
		}

		@Override
		public Variable getVariable(Dependency dep) {
			String actor = dep.getTargetActor();
			String var = dep.getVariable();
			return variablesMap.get(actor).get(var);
		}

		@Override
		public Map<Buffer, Integer> getWriteTokens(Step step) {
			Map<Buffer, Integer> tokens = new HashMap<>();
			String actor = step.getActor();
			for (Map.Entry<String, Integer> pe : step.getWriteTokens().entrySet()) {
				String outport = pe.getKey();
				for (Buffer buffer : outputPortsMap.get(actor).get(outport).getOutputs()) {
					tokens.put(buffer, pe.getValue());
				}
			}
			return tokens;
		}

		@Override
		public List<Variable> getWriteVariables(Step step) {
			List<Variable> variables = new ArrayList<>();
			List<String> list = step.getWriteVariables();
			if (!list.isEmpty()) {
				String actor = step.getActor();
				for (String var : list) {
					variables.add(variablesMap.get(actor).get(var));
				}
			}

			return variables;
		}

		@Override
		public HashMultiset<Buffer> getWriteTokensAsSet(Step step) {
			HashMultiset<Buffer> tokens = HashMultiset.create();
			String actor = step.getActor();
			for (Map.Entry<String, Integer> pe : step.getWriteTokens().entrySet()) {
				String outport = pe.getKey();
				for (Buffer buffer : outputPortsMap.get(actor).get(outport).getOutputs()) {
					tokens.setCount(buffer, pe.getValue());
				}
			}
			return tokens;
		}

		@Override
		public HashMultiset<Buffer> getReadTokensAsSet(Step step) {
			HashMultiset<Buffer> tokens = HashMultiset.create();
			String actor = step.getActor();
			for (Map.Entry<String, Integer> pe : step.getReadTokens().entrySet()) {
				String inport = pe.getKey();
				Buffer buffer = inputPortsMap.get(actor).get(inport).getInput();
				tokens.setCount(buffer, pe.getValue());
			}
			return tokens;
		}
	}

	/**
	 * Create a new trace project starting from the trace file (i.e. a .trace or
	 * .tracez file)
	 * 
	 * @param traceFile
	 *            the trace file
	 * @return the trace project
	 */
	public static TraceProject open(File traceFile) {
		String extension = "";
		try {
			extension = FileUtils.getExtension(traceFile);
			if (!extension.equals(TRACE) && !extension.equals(TRACEZ)) {
				throw new FileSystemException("Trace file error: unsupported extension");
			}
			return new TraceProject(traceFile);
		} catch (Exception e) {
			throw new TurnusRuntimeException("The trace project " + traceFile + " cannot be opened: " + e.getMessage());
		}
	}

	private final TraceDecorator decorator;
	private final Network network;
	private final ResourceSet resourceSet = new ResourceSetImpl();
	private Trace trace;

	private final File traceFile;

	/**
	 * A private constructor
	 * 
	 * @param traceFile
	 * @throws Exception
	 */
	private TraceProject(File traceFile) throws Exception {
		this.traceFile = traceFile;

		File file = FileUtils.changeExtension(traceFile, NETWORK);
		network = EcoreUtils.loadEObject(resourceSet, file);
		if (network == null) {
			throw new NullPointerException("Network file loading error");
		}
		
		decorator = new TraceDecoratorImpl();

	}

	/**
	 * Return the network of this project
	 * 
	 * @return
	 */
	public Network getNetwork() {
		return network;
	}

	/**
	 * Return the resource set used to load the network
	 * 
	 * @return
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Get the trace if loaded, <code>null</code> otherwise
	 * 
	 * @return the trace
	 */
	public Trace getTrace() {
		return trace;
	}

	/**
	 * Get the trace decorator
	 * 
	 * @return the decorator
	 */
	public TraceDecorator getTraceDecorator() {
		return decorator;
	}

	/**
	 * Get the trace file (i.e. with a .trace or .tracez extension)
	 * 
	 * @return the trace file
	 */
	public File getTraceFile() {
		return traceFile;
	}

	/**
	 * Return <code>true</code> if the trace is loaded, <code>false</code>
	 * otherwise
	 * 
	 * @return <code>true</code> if the trace is loaded, <code>false</code>
	 *         otherwise
	 */
	public boolean isTraceLoaded() {
		return trace != null;
	}

	/**
	 * Load a trace given a trace loader. If the loader cannot be find, the
	 * {@link InMemoryTraceLoader} will be used
	 * 
	 * @param loader
	 *            the loader
	 * @param configuration
	 *            the configuration that will be passed to the loader
	 * @return the trace
	 */
	public Trace loadTrace(TraceLoader loader, Configuration configuration) {
		try {
			trace = loader.load(traceFile, configuration);
		} catch (Exception e) {
			Logger.error("The trace file cannot be loaded with the trace loader %s. The in-memory loader will be used.",
					loader);
			try {
				trace = new InMemoryTraceLoader().load(traceFile, configuration);
			} catch (TurnusException e1) {
				throw new TurnusRuntimeException(
						"The trace file " + traceFile + " cannot be loaded: " + e.getMessage());
			}
		}

		return trace;
	}

}

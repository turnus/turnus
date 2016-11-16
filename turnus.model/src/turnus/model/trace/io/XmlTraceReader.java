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
package turnus.model.trace.io;

import static turnus.common.TurnusConstants.DEFAULT_STREAM_BUFFER_SIZE;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusExtensions.TRACE_SIZE;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_BOOLEAN;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_FLOAT;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_INTEGER;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_LONG;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_OBJECT;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_STRING;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_NAME;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_VALUE;
import static turnus.model.trace.io.XmlTraceMarkup.COUNT;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_KIND;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_SOURCE_ACTION;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_SOURCE_ACTOR;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_SOURCE_ID;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_TARGET_ACTION;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_TARGET_ACTOR;
import static turnus.model.trace.io.XmlTraceMarkup.DEPENDENCY_TARGET_ID;
import static turnus.model.trace.io.XmlTraceMarkup.DIRECTION;
import static turnus.model.trace.io.XmlTraceMarkup.GUARD;
import static turnus.model.trace.io.XmlTraceMarkup.PORT;
import static turnus.model.trace.io.XmlTraceMarkup.SOURCE_PORT;
import static turnus.model.trace.io.XmlTraceMarkup.STEP;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_ACTION;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_ACTOR;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_ACTOR_CLASS;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_DIRECTION;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_DIRECTION_READ;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_FIRING;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS_COUNT;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS_PORT;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_VARIABLE;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_VARIABLE_NAME;
import static turnus.model.trace.io.XmlTraceMarkup.TARGET_PORT;
import static turnus.model.trace.io.XmlTraceMarkup.VARIABLE;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.common.util.ObjectUtils;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Trace;
import turnus.model.trace.TraceBuilder;

/**
 * This class contains the XML {@link Trace} reader. Supported file extensions
 * are:
 * <ul>
 * <li>trace: a plain xml file</li>
 * <li>tracez: a GZIP compressed xml file</li>
 * </ul>
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlTraceReader {

	/**
	 * The step information data structure used when parsing a dependency
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class XmlDependency {
		Map<String, Object> attributes = new HashMap<>();

		long sourceId;
		long targetId;

		String sourceActor;
		String sourceAction;
		String targetActor;
		String targetAction;
		Kind kind;
		Direction direction;
		String port;
		String sourcePort;
		String targetPort;
		String guard;
		String variable;
		int count;
	}
	/**
	 * The step information data structure used when parsing a step
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class XmlStep {
		Map<String, Object> attributes = new HashMap<>();
		Map<String, Integer> readTokens = new HashMap<>();
		Map<String, Integer> writeTokens = new HashMap<>();
		List<String> readVariables = new ArrayList<>();
		List<String> writeVariables = new ArrayList<>();

		long id;
		String actor;
		String action;
		String actorClass;
	}
	/** the trace builder */
	private final TraceBuilder builder;
	/** the xml reader */
	private final XMLStreamReader reader;
	/** the progress printer */
	private ProgressPrinter progress;
	/** the trace attributes */
	private final Map<String, Object> traceAttributes = new HashMap<>();
	/**
	 * the attributes of the current attributable object (i.e. trace, or step,
	 * or dependency)
	 */
	private Map<String, Object> attributes = traceAttributes;

	/** the current step */
	private XmlStep currentStep;

	/** the current dependency */
	private XmlDependency currentDependency;

	/**
	 * Create a new XML trace reader
	 * 
	 * @param builder
	 *            the builder that is used for building the {@link Trace}
	 * @param file
	 *            the xml (i.e. trace or tracez) trace file
	 */
	public XmlTraceReader(TraceBuilder builder, File file) {
		try {
			this.builder = builder;

			String extension = FileUtils.getExtension(file);
			if (!extension.equals(TRACE) && !extension.equals(TRACEZ)) {
				throw new TurnusRuntimeException("Trace file reader: unsupported extension");
			}

			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			if (extension.equals(TRACEZ)) {
				stream = new GZIPInputStream(stream, DEFAULT_STREAM_BUFFER_SIZE);
			}

			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);

			// see if the trace size can be located
			try {
				File traceSizeFile = FileUtils.changeExtension(file, TRACE_SIZE);
				if (traceSizeFile.exists()) {
					TraceSizeReport size = EcoreUtils.loadEObject(new ResourceSetImpl(), traceSizeFile);
					long firings = size.getFirings();
					long dependencies = size.getDependencies();
					builder.setExpectedSize(firings, dependencies);
					progress = new ProgressPrinter("Trace loading", firings);
				}
			} catch (Exception e) {
				Logger.warning("The trace size cannot be determined");
			}

			if (progress == null) {
				progress = new NullProgressPrinter("Trace loading");
			}

		} catch (Exception e) {
			throw new TurnusRuntimeException("Error initializing the trace reader", e.getCause());
		}
	}

	/**
	 * Load the trace. The trace file is fully parsed
	 * 
	 * @throws TurnusException
	 *             if the trace cannot be loaded
	 */
	public void load() throws TurnusException {
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					switch (reader.getName().toString()) {
					case STEP: {
						currentStep = new XmlStep();
						attributes = currentStep.attributes;

						currentStep.id = Long.parseLong(reader.getAttributeValue("", STEP_FIRING));
						currentStep.actor = reader.getAttributeValue("", STEP_ACTOR);
						currentStep.action = reader.getAttributeValue("", STEP_ACTION);
						currentStep.actorClass = reader.getAttributeValue("", STEP_ACTOR_CLASS);
						break;
					}
					case STEP_TOKENS: {
						int count = Integer.parseInt(reader.getAttributeValue("", STEP_TOKENS_COUNT));
						String port = reader.getAttributeValue("", STEP_TOKENS_PORT);
						String direction = reader.getAttributeValue("", STEP_DIRECTION);
						if (direction.equals(STEP_DIRECTION_READ)) {
							currentStep.readTokens.put(port, count);
						} else {
							currentStep.writeTokens.put(port, count);
						}
						break;
					}
					case STEP_VARIABLE: {
						String variable = reader.getAttributeValue("", STEP_VARIABLE_NAME);
						String direction = reader.getAttributeValue("", STEP_DIRECTION);
						if (direction.equals(STEP_DIRECTION_READ)) {
							currentStep.readVariables.add(variable);
						} else {
							currentStep.writeVariables.add(variable);
						}
						break;
					}
					case DEPENDENCY: {
						currentDependency = new XmlDependency();
						attributes = currentDependency.attributes;

						currentDependency.sourceId = Long.parseLong(reader.getAttributeValue("", DEPENDENCY_SOURCE_ID));
						currentDependency.sourceActor = reader.getAttributeValue("", DEPENDENCY_SOURCE_ACTOR);
						currentDependency.sourceAction = reader.getAttributeValue("", DEPENDENCY_SOURCE_ACTION);
						currentDependency.targetId = Long.parseLong(reader.getAttributeValue("", DEPENDENCY_TARGET_ID));
						currentDependency.targetActor = reader.getAttributeValue("", DEPENDENCY_TARGET_ACTOR);
						currentDependency.targetAction = reader.getAttributeValue("", DEPENDENCY_TARGET_ACTION);
						currentDependency.kind = Kind.getKind(reader.getAttributeValue("", DEPENDENCY_KIND));

						switch (currentDependency.kind) {
						case GUARD: {
							currentDependency.guard = reader.getAttributeValue("", GUARD);
							currentDependency.direction = Direction
									.getDirection(reader.getAttributeValue("", DIRECTION));
							break;
						}
						case VARIABLE: {
							currentDependency.variable = reader.getAttributeValue("", VARIABLE);
							currentDependency.direction = Direction
									.getDirection(reader.getAttributeValue("", DIRECTION));
							break;
						}
						case PORT: {
							currentDependency.port = reader.getAttributeValue("", PORT);
							currentDependency.direction = Direction
									.getDirection(reader.getAttributeValue("", DIRECTION));
							break;
						}
						case TOKENS: {
							currentDependency.sourcePort = reader.getAttributeValue("", SOURCE_PORT);
							currentDependency.targetPort = reader.getAttributeValue("", TARGET_PORT);
							currentDependency.count = Integer.parseInt(reader.getAttributeValue("", COUNT));
							break;
						}
						case FSM: {
							break;
						}
						default:
							break;
						}

						break;
					}
					case ATTRIBUTE:
						String name = reader.getAttributeValue("", ATTRIBUTE_NAME);
						String kind = reader.getAttributeValue("", ATTRIBUTE_KIND);
						String value = reader.getAttributeValue("", ATTRIBUTE_VALUE);
						Object obj = null;

						try {
							switch (kind) {
							case ATTRIBUTE_KIND_BOOLEAN:
								obj = Boolean.parseBoolean(value);
								break;
							case ATTRIBUTE_KIND_FLOAT:
								obj = Double.parseDouble(value);
								break;
							case ATTRIBUTE_KIND_INTEGER:
								obj = Integer.parseInt(value);
								break;
							case ATTRIBUTE_KIND_LONG:
								obj = Long.parseLong(value);
								break;
							case ATTRIBUTE_KIND_OBJECT:
								obj = ObjectUtils.deserialize(value);
								break;
							case ATTRIBUTE_KIND_STRING:
								obj = value;
								break;
							default:
								break;
							}
						} catch (Exception e) {
							Logger.debug("Error parsing the attribute at line " + reader.getLocation().getLineNumber()
									+ ". Error: " + e.getMessage());
							obj = null;
						}

						if (obj != null)
							attributes.put(name, obj);
						else
							Logger.warning("Attribute \"%s\" cannot be parsed at line %d", name,
									reader.getLocation().getLineNumber());
						break;
					default:
						break;
					}
					break;
				}
				case XMLEvent.END_ELEMENT: {
					switch (reader.getName().toString()) {
					case STEP: {
						builder.addStep(currentStep.id, currentStep.actor, currentStep.action, currentStep.actorClass,
								currentStep.readTokens, currentStep.writeTokens, currentStep.readVariables,
								currentStep.writeVariables, currentStep.attributes);
						progress.increment();

						currentStep = null;
						attributes = traceAttributes;
						break;
					}
					case DEPENDENCY: {
						switch (currentDependency.kind) {
						case FSM:
							builder.addFsmDependency(currentDependency.sourceId, currentDependency.sourceActor,
									currentDependency.sourceAction, currentDependency.targetId,
									currentDependency.targetActor, currentDependency.targetAction,
									currentDependency.attributes);
							break;
						case GUARD:
							builder.addGuardDependency(currentDependency.sourceId, currentDependency.sourceActor,
									currentDependency.sourceAction, currentDependency.targetId,
									currentDependency.targetActor, currentDependency.targetAction,
									currentDependency.guard, currentDependency.direction, currentDependency.attributes);
							break;
						case PORT:
							builder.addPortDependency(currentDependency.sourceId, currentDependency.sourceActor,
									currentDependency.sourceAction, currentDependency.targetId,
									currentDependency.targetActor, currentDependency.targetAction,
									currentDependency.port, currentDependency.direction, currentDependency.attributes);
							break;
						case VARIABLE:
							builder.addVariableDependency(currentDependency.sourceId, currentDependency.sourceActor,
									currentDependency.sourceAction, currentDependency.targetId,
									currentDependency.targetActor, currentDependency.targetAction,
									currentDependency.variable, currentDependency.direction,
									currentDependency.attributes);
							break;
						case TOKENS:
							builder.addTokensDependency(currentDependency.sourceId, currentDependency.sourceActor,
									currentDependency.sourceAction, currentDependency.targetId,
									currentDependency.targetActor, currentDependency.targetAction,
									currentDependency.sourcePort, currentDependency.targetPort, currentDependency.count,
									currentDependency.attributes);
							break;
						default:
							break;
						}

						currentDependency = null;
						attributes = traceAttributes;

						break;
					}
					case TRACE: {
						builder.addAttributes(traceAttributes);
						break;
					}
					default:
						break;
					}
					break;
				}
				default:
					break;
				}
			}

			progress.finish();
			
		} catch (Exception e) {
			progress.finish();
			Logger.error("Error loading the execution trace graph");
			throw new TurnusException("Error loading the execution trace graph", e);
		}
	}

}

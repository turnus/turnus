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

import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import turnus.common.Attributable;
import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.common.util.ObjectUtils;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.impl.splitted.impl.SplittedDependency;
import turnus.model.trace.impl.splitted.impl.SplittedStep;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlSplittedTraceReader implements Iterator<Attributable> {

	private final boolean readSteps;
	private final boolean readReadDeps;

	private final XMLStreamReader reader;

	private  Attributable loadedAttributable;

	private SplittedStep currentStep;
	private SplittedDependency currentDep;
	
	private final Map<String, Object> TMP_ATTRIBUTES = new HashMap<>();

	private Map<String, Object> currentAttributes = TMP_ATTRIBUTES;
	
	

	public XmlSplittedTraceReader(File file, boolean readSteps, boolean readReadDeps) throws TurnusException {

		this.readSteps = readSteps;
		this.readReadDeps = readReadDeps;

		try {
			String extension = FileUtils.getExtension(file);
			if (!extension.equals(TRACE) && !extension.equals(TRACEZ)) {
				throw new TurnusRuntimeException("Trace file reader: unsupported extension");
			}

			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			if (extension.equals(TRACEZ)) {
				stream = new GZIPInputStream(stream);
			}

			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
			loadedAttributable = loadNext();

		} catch (Exception e) {
			throw new TurnusException("Error initializing the trace reader", e.getCause());
		}
	}

	@Override
	public boolean hasNext() {
		return loadedAttributable != null;
	}

	@Override
	public Attributable next() {
		Attributable old = loadedAttributable;
		loadedAttributable = loadNext();
		return old;
	}

	private Attributable loadNext() {
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					switch (reader.getName().toString()) {
					case STEP: {
						if (readSteps) {
							currentStep = new SplittedStep();
							currentAttributes = new HashMap<>();

							currentStep.setId(Long.parseLong(reader.getAttributeValue("", STEP_FIRING)));
							currentStep.setActor(reader.getAttributeValue("", STEP_ACTOR));
							currentStep.setAction(reader.getAttributeValue("", STEP_ACTION));
							currentStep.setActorClass(reader.getAttributeValue("", STEP_ACTOR_CLASS));
						}
						break;
					}
					case STEP_TOKENS: {
						int count = Integer.parseInt(reader.getAttributeValue("", STEP_TOKENS_COUNT));
						String port = reader.getAttributeValue("", STEP_TOKENS_PORT);
						String direction = reader.getAttributeValue("", STEP_DIRECTION);
						if (direction.equals(STEP_DIRECTION_READ)) {
							currentStep.addReadTokens(port, count);
						} else {
							currentStep.addWriteTokens(port, count);
						}
						break;
					}
					case STEP_VARIABLE: {
						String variable = reader.getAttributeValue("", STEP_VARIABLE_NAME);
						String direction = reader.getAttributeValue("", STEP_DIRECTION);
						if (direction.equals(STEP_DIRECTION_READ)) {
							currentStep.addReadVariable(variable);
						} else {
							currentStep.addWriteVariable(variable);
						}
						break;
					}
					
					case DEPENDENCY: {
						if (readReadDeps) {
							currentDep = new SplittedDependency();
							currentAttributes = new HashMap<>();

							currentDep.setSourceId(Long.parseLong(reader.getAttributeValue("", DEPENDENCY_SOURCE_ID)));
							currentDep.setSourceActor(reader.getAttributeValue("", DEPENDENCY_SOURCE_ACTOR));
							currentDep.setSourceAction(reader.getAttributeValue("", DEPENDENCY_SOURCE_ACTION));
							currentDep.setTargetId(Long.parseLong(reader.getAttributeValue("", DEPENDENCY_TARGET_ID)));
							currentDep.setTargetActor(reader.getAttributeValue("", DEPENDENCY_TARGET_ACTOR));
							currentDep.setTargetAction(reader.getAttributeValue("", DEPENDENCY_TARGET_ACTION));
							currentDep.setKind(Kind.getKind(reader.getAttributeValue("", DEPENDENCY_KIND)));

							switch (currentDep.getKind()) {
							case GUARD: {
								currentDep.setGuard(reader.getAttributeValue("", GUARD));
								currentDep.setDirection(Direction.getDirection(reader.getAttributeValue("", DIRECTION)));
								break;
							}
							case VARIABLE: {
								currentDep.setVariable(reader.getAttributeValue("", VARIABLE));
								currentDep.setDirection(Direction.getDirection(reader.getAttributeValue("", DIRECTION)));
								break;
							}
							case PORT: {
								currentDep.setPort(reader.getAttributeValue("", PORT));
								currentDep.setDirection(Direction.getDirection(reader.getAttributeValue("", DIRECTION)));
								break;
							}
							case TOKENS: {
								currentDep.setSourcePort(reader.getAttributeValue("", SOURCE_PORT));
								currentDep.setTargetPort(reader.getAttributeValue("", TARGET_PORT));
								currentDep.setCount(Integer.parseInt(reader.getAttributeValue("", COUNT)));
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
							currentAttributes.put(name, obj);
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
						if (readSteps) {
							currentStep.setAttributes(currentAttributes);
							currentAttributes = TMP_ATTRIBUTES;
							return currentStep;
						}
						break;
					}
					case DEPENDENCY: {
						if (readReadDeps) {
							currentDep.setAttributes(currentAttributes);
							currentAttributes = TMP_ATTRIBUTES;
							return currentDep;
						}
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

		} catch (Exception e) {
			Logger.error("Error loading the execution trace graph: " + e.getMessage());
		}

		return null;

	}

	@Override
	public void remove() {
	}

}

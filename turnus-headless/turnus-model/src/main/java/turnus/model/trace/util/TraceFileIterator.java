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
package turnus.model.trace.util;

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.Attributable;
import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.common.util.ObjectUtils;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Direction;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Step;

/**
 * This class defines a trace file iterator The trace file (i.e. .trace or
 * .tracez) is serially read from the first to the last {@link Attributable}
 * element: each {@link Attributable} could be or a {@link Step} or a
 * {@link Dependency}. Steps does not implement the {@link Step#getIncomings()}
 * and {@link Step#getOutgoings()} methods. Similarly, dependencies does not
 * implement the {@link Dependency#getSource()} or
 * {@link Dependency#getTarget()} methods.
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceFileIterator implements Iterator<Attributable> {

	private class XmlDependency implements Dependency {
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

		@SuppressWarnings("unchecked")
		@Override
		public <T> T getAttribute(String name) {
			return (T) attributes.get(name);
		}

		@Override
		public <T> T getAttribute(String name, T defaultValue) {
			T value = getAttribute(name);
			return value != null ? value : defaultValue;
		}

		@Override
		public Iterable<String> getAttributeNames() {
			return attributes.keySet();
		}

		@Override
		public Map<String, Object> getAttributes() {
			return new HashMap<>(attributes);
		}

		@Override
		public int getCount() {
			return count;
		}

		@Override
		public Direction getDirection() {
			return direction;
		}

		@Override
		public String getGuard() {
			return guard;
		}

		@Override
		public Kind getKind() {
			return kind;
		}

		@Override
		public String getPort() {
			return port;
		}

		@Override
		public Step getSource() {
			throw new TurnusRuntimeException("get source is not supported");
		}

		@Override
		public String getSourceAction() {
			return sourceAction;
		}

		@Override
		public String getSourceActor() {
			return sourceActor;
		}

		@Override
		public long getSourceId() {
			return sourceId;
		}

		@Override
		public String getSourcePort() {
			return sourcePort;
		}

		@Override
		public Step getTarget() {
			throw new TurnusRuntimeException("get target is not supported");
		}

		@Override
		public String getTargetAction() {
			return targetAction;
		}

		@Override
		public String getTargetActor() {
			return targetActor;
		}

		@Override
		public long getTargetId() {
			return targetId;
		}

		@Override
		public String getTargetPort() {
			return targetPort;
		}

		@Override
		public String getVariable() {
			return variable;
		}

		@Override
		public boolean hasAttribute(String name) {
			return attributes.containsKey(name);
		}

		@Override
		public boolean hasAttributes() {
			return !attributes.isEmpty();
		}

		@Override
		public boolean removeAttribute(String name) {
			return attributes.remove(name) != null;
		}

		@Override
		public void removeAttributes() {
			attributes.clear();
		}

		@Override
		public void setAttribute(String name, Object value) {
			attributes.put(name, value);
		}
	}

	private class XmlReader {

		private XMLStreamReader xmlReader;
		private ProgressPrinter progress;

		private XmlStep step;
		private XmlDependency dep;
		private final Map<String, Object> traceAttributes = new HashMap<>();
		private Map<String, Object> attributes = traceAttributes;

		XmlReader(File traceFile) throws Exception {
			String extension = FileUtils.getExtension(traceFile);
			if (!extension.equals(TRACE) && !extension.equals(TRACEZ)) {
				throw new TurnusRuntimeException("Trace file reader: unsupported extension");
			}

			InputStream stream = new BufferedInputStream(new FileInputStream(traceFile));
			if (extension.equals(TRACEZ)) {
				stream = new GZIPInputStream(stream);
			}

			xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
			// see if the trace size can be located
			try {
				File traceSizeFile = FileUtils.changeExtension(traceFile, TRACE_SIZE);
				if (traceSizeFile.exists()) {
					TraceSizeReport size = EcoreUtils.loadEObject(new ResourceSetImpl(), traceSizeFile);
					long firings = size.getFirings();
					long dependencies = size.getDependencies();
					progress = new ProgressPrinter("Trace reading", firings + dependencies);
				}
			} catch (Exception e) {
				Logger.warning("The trace size cannot be determined");
			}

			if (progress == null) {
				progress = new NullProgressPrinter("Trace reading");
			}
		}

		Attributable loadNext() {
			try {
				while (xmlReader.hasNext()) {
					xmlReader.next();
					switch (xmlReader.getEventType()) {
					case XMLEvent.START_ELEMENT: {
						switch (xmlReader.getName().toString()) {
						case STEP: {
							step = new XmlStep();
							attributes = step.attributes;

							step.id = Long.parseLong(xmlReader.getAttributeValue("", STEP_FIRING));
							step.actor = xmlReader.getAttributeValue("", STEP_ACTOR);
							step.action = xmlReader.getAttributeValue("", STEP_ACTION);
							step.actorClass = xmlReader.getAttributeValue("", STEP_ACTOR_CLASS);
							break;
						}
						case STEP_TOKENS: {
							int count = Integer.parseInt(xmlReader.getAttributeValue("", STEP_TOKENS_COUNT));
							String port = xmlReader.getAttributeValue("", STEP_TOKENS_PORT);
							String direction = xmlReader.getAttributeValue("", STEP_DIRECTION);
							if (direction.equals(STEP_DIRECTION_READ)) {
								step.readTokens.put(port, count);
							} else {
								step.writeTokens.put(port, count);
							}
							break;
						}
						case STEP_VARIABLE: {
							String variable = xmlReader.getAttributeValue("", STEP_VARIABLE_NAME);
							String direction = xmlReader.getAttributeValue("", STEP_DIRECTION);
							if (direction.equals(STEP_DIRECTION_READ)) {
								step.readVariables.add(variable);
							} else {
								step.writeVariables.add(variable);
							}
							break;
						}
						case DEPENDENCY: {
							dep = new XmlDependency();
							attributes = dep.attributes;

							dep.sourceId = Long.parseLong(xmlReader.getAttributeValue("", DEPENDENCY_SOURCE_ID));
							dep.sourceActor = xmlReader.getAttributeValue("", DEPENDENCY_SOURCE_ACTOR);
							dep.sourceAction = xmlReader.getAttributeValue("", DEPENDENCY_SOURCE_ACTION);
							dep.targetId = Long.parseLong(xmlReader.getAttributeValue("", DEPENDENCY_TARGET_ID));
							dep.targetActor = xmlReader.getAttributeValue("", DEPENDENCY_TARGET_ACTOR);
							dep.targetAction = xmlReader.getAttributeValue("", DEPENDENCY_TARGET_ACTION);
							dep.kind = Kind.getKind(xmlReader.getAttributeValue("", DEPENDENCY_KIND));

							switch (dep.kind) {
							case GUARD: {
								dep.guard = xmlReader.getAttributeValue("", GUARD);
								dep.direction = Direction.getDirection(xmlReader.getAttributeValue("", DIRECTION));
								break;
							}
							case VARIABLE: {
								dep.variable = xmlReader.getAttributeValue("", VARIABLE);
								dep.direction = Direction.getDirection(xmlReader.getAttributeValue("", DIRECTION));
								break;
							}
							case PORT: {
								dep.port = xmlReader.getAttributeValue("", PORT);
								dep.direction = Direction.getDirection(xmlReader.getAttributeValue("", DIRECTION));
								break;
							}
							case TOKENS: {
								dep.sourcePort = xmlReader.getAttributeValue("", SOURCE_PORT);
								dep.targetPort = xmlReader.getAttributeValue("", TARGET_PORT);
								dep.count = Integer.parseInt(xmlReader.getAttributeValue("", COUNT));
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
							String name = xmlReader.getAttributeValue("", ATTRIBUTE_NAME);
							String kind = xmlReader.getAttributeValue("", ATTRIBUTE_KIND);
							String value = xmlReader.getAttributeValue("", ATTRIBUTE_VALUE);
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
								Logger.debug("Error parsing the attribute at line "
										+ xmlReader.getLocation().getLineNumber() + ". Error: " + e.getMessage());
								obj = null;
							}

							if (obj != null)
								attributes.put(name, obj);
							else
								Logger.warning("Attribute \"%s\" cannot be parsed at line %d", name,
										xmlReader.getLocation().getLineNumber());
							break;
						default:
							break;
						}
						break;
					}
					case XMLEvent.END_ELEMENT: {
						switch (xmlReader.getName().toString()) {
						case STEP: {
							Attributable attributable = step;
							progress.increment();
							step = null;
							attributes = traceAttributes;
							return attributable;
						}
						case DEPENDENCY: {
							Attributable attributable = dep;
							progress.increment();
							dep = null;
							attributes = traceAttributes;
							return attributable;
						}
						case TRACE: {
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

			try {
				xmlReader.close();
			} catch (XMLStreamException e) {
			}

			progress.finish();
			return null;
		}

	}

	private class XmlStep implements Step {
		Map<String, Object> attributes = new HashMap<>();
		Map<String, Integer> readTokens = new HashMap<>();
		Map<String, Integer> writeTokens = new HashMap<>();
		List<String> readVariables = new ArrayList<>();
		List<String> writeVariables = new ArrayList<>();

		long id;
		String actor;
		String action;
		String actorClass;

		@Override
		public String getAction() {
			return action;
		}

		@Override
		public String getActor() {
			return actor;
		}

		@Override
		public String getActorClass() {
			return actorClass;
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T> T getAttribute(String name) {
			return (T) attributes.get(name);
		}

		@Override
		public <T> T getAttribute(String name, T defaultValue) {
			T value = getAttribute(name);
			return value != null ? value : defaultValue;
		}

		@Override
		public Iterable<String> getAttributeNames() {
			return attributes.keySet();
		}

		@Override
		public Map<String, Object> getAttributes() {
			return new HashMap<>(attributes);
		}

		@Override
		public long getId() {
			return id;
		}

		@Override
		public Iterable<Dependency> getIncomings() {
			throw new TurnusRuntimeException("get incomings is not supported");
		}

		@Override
		public Iterable<Dependency> getOutgoings() {
			throw new TurnusRuntimeException("get outgoings is not supported");
		}

		@Override
		public Map<String, Integer> getReadTokens() {
			return new HashMap<>(readTokens);
		}

		@Override
		public List<String> getReadVariables() {
			return new ArrayList<>(readVariables);
		}

		@Override
		public Map<String, Integer> getWriteTokens() {
			return new HashMap<>(writeTokens);
		}

		@Override
		public List<String> getWriteVariables() {
			return new ArrayList<>(writeVariables);
		}

		@Override
		public boolean hasAttribute(String name) {
			return attributes.containsKey(name);
		}

		@Override
		public boolean hasAttributes() {
			return !attributes.isEmpty();
		}

		@Override
		public boolean removeAttribute(String name) {
			return attributes.remove(name) != null;
		}

		@Override
		public void removeAttributes() {
			attributes.clear();
		}

		@Override
		public void setAttribute(String name, Object value) {
			attributes.put(name, value);
		}

	}

	/** the internal XML reader */
	private XmlReader reader;
	/** the next attributable */
	private Attributable nextAttributable;

	/**
	 * Create a new trace file iterator
	 * 
	 * @param traceFile
	 *            the trace file
	 * @throws TurnusException
	 *             if the given file is not a valid .trace or .tracez file
	 */
	public TraceFileIterator(File traceFile) throws TurnusException {
		try {
			reader = new XmlReader(traceFile);
			nextAttributable = reader.loadNext();
		} catch (Exception e) {
			throw new TurnusException("Impossible to load the trace file " + traceFile, e);
		}
	}

	@Override
	public boolean hasNext() {
		return nextAttributable != null;
	}

	@Override
	public Attributable next() {
		Attributable currentAttributable = nextAttributable;
		nextAttributable = reader.loadNext();
		return currentAttributable;
	}

	@Override
	public void remove() {
	}

}

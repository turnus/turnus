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
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_BOOLEAN;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_FLOAT;
import static turnus.model.trace.io.XmlTraceMarkup.ATTRIBUTE_KIND_INTEGER;
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
import static turnus.model.trace.io.XmlTraceMarkup.STEP_DIRECTION_WRITE;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_FIRING;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS_COUNT;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_TOKENS_PORT;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_VARIABLE;
import static turnus.model.trace.io.XmlTraceMarkup.STEP_VARIABLE_NAME;
import static turnus.model.trace.io.XmlTraceMarkup.TARGET_PORT;
import static turnus.model.trace.io.XmlTraceMarkup.VARIABLE;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.compress.compressors.CompressorStreamFactory;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.Attributable;
import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.DateUtil;
import turnus.common.util.FileUtils;
import turnus.common.util.ObjectUtils;
import turnus.model.trace.Dependency;
import turnus.model.trace.Dependency.Kind;
import turnus.model.trace.Step;

/**
 * This class defines an execution trace graph XML stream writer. Steps and
 * dependencies can be streamed to the writer.
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlTraceStreamWriter {

	/** the xml writer */
	private XMLStreamWriter writer;
	/** the output stream. GZIP if the trace should be compressed */
	private OutputStream stream;
	/** <code>true</code> if the trace should be compressed */
	private boolean compressedXml;

	public XmlTraceStreamWriter(File file) throws TurnusException {
		try {
			String extension = FileUtils.getExtension(file);
			compressedXml = false;
			if (extension.equals(TRACEZ)) {
				compressedXml = true;
			} else if (!extension.equals(TRACE)) {
				throw new IOException("Trace file writer: unsupported file extension");
			}

			stream = new FileOutputStream(file);
			if (compressedXml) {
				stream = new CompressorStreamFactory().createCompressorOutputStream(CompressorStreamFactory.GZIP,
						stream);
			}
			stream = new BufferedOutputStream(stream, DEFAULT_STREAM_BUFFER_SIZE);

		} catch (Exception e) {
			throw new TurnusException("Trace file writer cannot be create", e);
		}
	}

	/**
	 * Close the writer
	 * 
	 * @throws TurnusException
	 */
	public void close() throws TurnusException {
		try {
			writeEndDocument();
			writer.flush();
			writer.close();
			stream.close();
		} catch (Exception e) {
			throw new TurnusException("Trace file writer cannot be properly cloded", e);
		}
	}

	/**
	 * Open the writer
	 * 
	 * @throws TurnusException
	 */
	public void open() throws TurnusException {
		try {
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			writer = factory.createXMLStreamWriter(stream);
			if (!compressedXml) {
				writer = new IndentingXMLStreamWriter(writer);
			}
			writeStartDocument();
		} catch (Exception e) {
			throw new TurnusException("Error opening the trace stream writer", e.getCause());
		}
	}

	/**
	 * Write a collection of dependencies
	 * 
	 * @param dependencies
	 * @throws TurnusException
	 */
	public void write(Collection<Dependency> dependencies) throws TurnusException {
		for (Dependency d : dependencies) {
			write(d);
		}
	}

	/**
	 * Write a single dependency
	 * 
	 * @param dependency
	 * @throws TurnusException
	 */
	public void write(Dependency dependency) throws TurnusException {
		try {

			boolean hasAttributes = dependency.hasAttributes();

			if (hasAttributes) {
				writer.writeStartElement(DEPENDENCY);
			} else {
				writer.writeEmptyElement(DEPENDENCY);
			}

			writer.writeAttribute(DEPENDENCY_SOURCE_ID, Long.toString(dependency.getSourceId()));
			writer.writeAttribute(DEPENDENCY_SOURCE_ACTOR, dependency.getSourceActor());
			writer.writeAttribute(DEPENDENCY_SOURCE_ACTION, dependency.getSourceAction());
			writer.writeAttribute(DEPENDENCY_TARGET_ID, Long.toString(dependency.getTargetId()));
			writer.writeAttribute(DEPENDENCY_TARGET_ACTOR, dependency.getTargetActor());
			writer.writeAttribute(DEPENDENCY_TARGET_ACTION, dependency.getTargetAction());

			Kind kind = dependency.getKind();
			writer.writeAttribute(DEPENDENCY_KIND, dependency.getKind().literal());
			switch (kind) {
			case FSM: {
				break;
			}
			case TOKENS: {
				writer.writeAttribute(SOURCE_PORT, dependency.getSourcePort());
				writer.writeAttribute(TARGET_PORT, dependency.getTargetPort());
				writer.writeAttribute(COUNT, Integer.toString(dependency.getCount()));
				break;
			}
			case VARIABLE: {
				writer.writeAttribute(VARIABLE, dependency.getVariable());
				writer.writeAttribute(DIRECTION, dependency.getDirection().literal());
				break;
			}
			case PORT: {
				writer.writeAttribute(PORT, dependency.getPort());
				writer.writeAttribute(DIRECTION, dependency.getDirection().literal());
				break;
			}
			case GUARD: {
				writer.writeAttribute(GUARD, dependency.getGuard());
				writer.writeAttribute(DIRECTION, dependency.getDirection().literal());
				break;
			}
			default:
				throw new TurnusRuntimeException("Unsupported Dependence kind " + dependency);
			}

			if (hasAttributes) {
				writeAttributes(dependency);
				writer.writeEndElement();
			}

		} catch (XMLStreamException e) {
			throw new TurnusException("Dependency " + dependency + " cannot be properly written", e);
		}

	}

	/**
	 * Write a single step (without its incoming dependencies)
	 * 
	 * @param step
	 *            the step
	 * @throws TurnusException
	 */
	public void write(Step step) throws TurnusException {
		try {
			// <step>
			boolean isEmpty = step.hasAttributes() && step.getReadTokens().isEmpty() && step.getWriteTokens().isEmpty()
					&& step.getReadVariables().isEmpty() && step.getWriteVariables().isEmpty();

			if (isEmpty) {
				writer.writeEmptyElement(STEP);

			} else {
				writer.writeStartElement(STEP);
			}

			writer.writeAttribute(STEP_FIRING, Long.toString(step.getId()));
			writer.writeAttribute(STEP_ACTOR, step.getActor());
			writer.writeAttribute(STEP_ACTION, step.getAction());
			writer.writeAttribute(STEP_ACTOR_CLASS, step.getActorClass());

			for (Entry<String, Integer> e : step.getReadTokens().entrySet()) {
				writer.writeEmptyElement(STEP_TOKENS);
				writer.writeAttribute(STEP_DIRECTION, STEP_DIRECTION_READ);
				writer.writeAttribute(STEP_TOKENS_PORT, e.getKey());
				writer.writeAttribute(STEP_TOKENS_COUNT, Integer.toString(e.getValue()));
			}

			for (Entry<String, Integer> e : step.getWriteTokens().entrySet()) {
				writer.writeEmptyElement(STEP_TOKENS);
				writer.writeAttribute(STEP_DIRECTION, STEP_DIRECTION_WRITE);
				writer.writeAttribute(STEP_TOKENS_PORT, e.getKey());
				writer.writeAttribute(STEP_TOKENS_COUNT, Integer.toString(e.getValue()));
			}

			for (String variable : step.getReadVariables()) {
				writer.writeEmptyElement(STEP_VARIABLE);
				writer.writeAttribute(STEP_DIRECTION, STEP_DIRECTION_READ);
				writer.writeAttribute(STEP_VARIABLE_NAME, variable);
			}

			for (String variable : step.getWriteVariables()) {
				writer.writeEmptyElement(STEP_VARIABLE);
				writer.writeAttribute(STEP_DIRECTION, STEP_DIRECTION_WRITE);
				writer.writeAttribute(STEP_VARIABLE_NAME, variable);
			}

			if (step.hasAttributes()) {
				writeAttributes(step);
			}

			if (!isEmpty) {
				writer.writeEndElement();
			}
			// </step>
		} catch (Exception e) {
			throw new TurnusException("Step " + step + " cannot be properly written", e);
		}
	}

	private void writeAttributes(Attributable attributable) {
		for (Entry<String, Object> e : attributable.getAttributes().entrySet()) {
			try {
				String name = e.getKey();
				Object value = e.getValue();
				String kind = null;
				String str = null;
				try {
					if (value instanceof String) {
						str = (String) value;
						kind = ATTRIBUTE_KIND_STRING;
					} else if (value instanceof Boolean) {
						str = Boolean.toString((Boolean) value);
						kind = ATTRIBUTE_KIND_BOOLEAN;
					} else if (value instanceof Integer) {
						str = Integer.toString((Integer) value);
						kind = ATTRIBUTE_KIND_INTEGER;
					} else if (value instanceof Double) {
						str = Double.toString((Double) value);
						kind = ATTRIBUTE_KIND_FLOAT;
					} else {
						str = ObjectUtils.serialize(value);
						kind = ATTRIBUTE_KIND_OBJECT;
					}
				} catch (Exception exc) {
					Logger.debug("Attribute \"%s\" parsing error: %s", name, exc.getMessage());
					str = null;
				}

				if (str == null) {
					Logger.warning("Attribute \"%s\" of \"%s\" cannot be writtern", name, attributable);
					return;
				}

				writer.writeEmptyElement(ATTRIBUTE);
				writer.writeAttribute(ATTRIBUTE_NAME, name);
				writer.writeAttribute(ATTRIBUTE_KIND, kind);
				writer.writeAttribute(ATTRIBUTE_VALUE, str);
			} catch (Exception exc) {
				Logger.debug("Trace write attribute exception: %s", e.toString());
			}

		}
	}

	private void writeEndDocument() throws Exception {
		// </trace>
		writer.writeEndElement();
		// close the document
		writer.writeEndDocument();
	}

	private void writeStartDocument() throws Exception {
		writer.writeStartDocument();
		writer.writeComment("Trace exported the " + DateUtil.now());
		writer.writeStartElement(TRACE);
	}

}

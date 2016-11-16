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
package turnus.model.analysis.trace.io;

import static turnus.common.TurnusConstants.DEFAULT_STREAM_BUFFER_SIZE;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.dataflow.Action;

public class Amtrace2GraphmlExporter implements FileExporter<MarkowModelTraceReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		MarkowModelTraceReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		export(report, output);

	}

	@Override
	public void export(MarkowModelTraceReport report, File output) throws TurnusException {
		try {
			OutputStream stream = new FileOutputStream(output);
			stream = new BufferedOutputStream(stream, DEFAULT_STREAM_BUFFER_SIZE);
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
			writer = new IndentingXMLStreamWriter(writer);
			writer.writeStartDocument();
			writer.writeStartElement("graphml");
			writer.writeAttribute("xmlns", "http://graphml.graphdrawing.org/xmlns");
			writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			writer.writeAttribute("xsi:schemaLocation",
					"http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd");

			writer.writeEmptyElement("key");
			writer.writeAttribute("id", "n0");
			writer.writeAttribute("for", "node");
			writer.writeAttribute("attr.name", "actor");
			writer.writeAttribute("attr.type", "string");

			writer.writeEmptyElement("key");
			writer.writeAttribute("id", "n1");
			writer.writeAttribute("for", "node");
			writer.writeAttribute("attr.name", "action");
			writer.writeAttribute("attr.type", "string");

			writer.writeStartElement("key");
			writer.writeAttribute("id", "n2");
			writer.writeAttribute("for", "node");
			writer.writeAttribute("attr.name", "start");
			writer.writeAttribute("attr.type", "boolean");
			writer.writeStartElement("default");
			writer.writeCharacters("false");
			writer.writeEndElement();
			writer.writeEndElement();

			writer.writeEmptyElement("key");
			writer.writeAttribute("id", "e0");
			writer.writeAttribute("for", "edge");
			writer.writeAttribute("attr.name", "probability");
			writer.writeAttribute("attr.type", "double");

			writer.writeStartElement("graph");
			writer.writeAttribute("id", "G");
			writer.writeAttribute("edgedefault", "directed");

			Map<Action, Long> actionsIdMap = new HashMap<>();
			Map<Action, Long> starters = new HashMap<>();
			
			long id = 0;
			for (MarkovModelActionData data : report.getActionsData()) {
				Action action = data.getAction();
				boolean isFirst = data.isFirst();

				writeNode(writer, id, action.getOwner().getName(), action.getName(), isFirst);
				actionsIdMap.put(action, id);
				id++;

				if (isFirst) {
					writeNode(writer, id, "$starter$", "", false);
					starters.put(action, id);
					id++;
				}
			}

			long edges = 0;
			for (MarkovModelActionData data : report.getActionsData()) {
				Action action = data.getAction();
				long sourceId = actionsIdMap.get(action);
				long successors = data.getSuccessors();
				if (successors > 0) {
					for (Entry<Action, Long> e : data.getSuccessorsMap().entrySet()) {
						double p = ((double) e.getValue()) / successors;
						long targetId = actionsIdMap.get(e.getKey());
						writeEdge(writer, edges, sourceId, targetId, p);
						edges++;
					}
				}

				if (data.isFirst()) {
					long starterId = starters.get(action);
					writeEdge(writer, edges, starterId, sourceId, 1.0);
					edges++;
				}
			}

			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();

			writer.flush();
			writer.close();
			stream.close();
		} catch (Exception e) {
			throw new TurnusException("Export fails", e);
		}
	}

	private void writeEdge(XMLStreamWriter writer, long id, long source, long target, double p) throws Exception {

		writer.writeStartElement("edge");
		writer.writeAttribute("id", "e" + id);
		writer.writeAttribute("source", "n" + source);
		writer.writeAttribute("target", "n" + target);

		writer.writeStartElement("data");
		writer.writeAttribute("key", "e0");
		writer.writeCharacters(Double.toString(p));
		writer.writeEndElement();

		writer.writeEndElement();
	}

	private void writeNode(XMLStreamWriter writer, long id, String actor, String action, boolean first)
			throws Exception {

		writer.writeStartElement("node");
		writer.writeAttribute("id", "n" + id);

		writer.writeStartElement("data");
		writer.writeAttribute("key", "n0");
		writer.writeCharacters(actor);
		writer.writeEndElement();

		writer.writeStartElement("data");
		writer.writeAttribute("key", "n1");
		writer.writeCharacters(action);
		writer.writeEndElement();

		if (first) {
			writer.writeStartElement("data");
			writer.writeAttribute("key", "n2");
			writer.writeCharacters("true");
			writer.writeEndElement();
		}

		writer.writeEndElement();
	}

}

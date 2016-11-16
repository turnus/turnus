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
package turnus.model.mapping.io;

import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.BUFFER;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.COMMUNICATION;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.LATENCY;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.LEVEL;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.MEMORY;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.NETWORK;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.PERCENTAGE;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.READ;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.SOURCE_ACTOR;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.SOURCE_PORT;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.TARGET_ACTOR;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.TARGET_PORT;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.TYPE;
import static turnus.model.mapping.io.XmlCommunicationWeightMarkup.WRITE;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.data.MemoryAccess;
import turnus.model.mapping.io.util.BufferIdentifier;

/**
 * 
 * @author Malgorzata Michalska
 *
 */
public class XmlCommunicationWeightWriter {
	
	public void write(Map<BufferIdentifier, List<MemoryAccess>> data, String network, String numaMode, File output) throws TurnusException {
		XMLStreamWriter writer = null;
		try {
			OutputStream stream = new BufferedOutputStream(new FileOutputStream(output));
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			writer = factory.createXMLStreamWriter(stream);
			writer = new IndentingXMLStreamWriter(writer);
		} catch (Exception e) {
			throw new TurnusException("File \"" + output.getAbsolutePath() + "\" cannot be create");
		}

		try {
			writer.writeStartDocument();
			writer.writeStartElement(COMMUNICATION);
			writer.writeAttribute(NETWORK, network);
			
			for (Entry<BufferIdentifier, List<MemoryAccess>> entry : data.entrySet()) {
				BufferIdentifier bufferIdentifier = entry.getKey();
				writer.writeStartElement(BUFFER);
				
				writer.writeAttribute(SOURCE_ACTOR, bufferIdentifier.getSourceActor());
				writer.writeAttribute(SOURCE_PORT, bufferIdentifier.getSourcePort());
				writer.writeAttribute(TARGET_ACTOR, bufferIdentifier.getTargetActor());
				writer.writeAttribute(TARGET_PORT, bufferIdentifier.getTargetPort());
				
			    Set<String> tmp = new HashSet<String>();
				for (MemoryAccess ma : entry.getValue()) {
					if (tmp.add(ma.getLevel())) {
						writer.writeStartElement(MEMORY);
						writer.writeAttribute(LEVEL, ma.getLevel());
						if (numaMode.equals("read"))
							writer.writeEmptyElement(READ);
						else
							writer.writeEmptyElement(WRITE);
						writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
						writer.writeAttribute(LATENCY, "" + ma.getLatency());
						writer.writeAttribute(TYPE, ma.getType().toLowerCase());								
					} else {
						if (numaMode.equals("read"))
							writer.writeEmptyElement(READ);
						else
							writer.writeEmptyElement(WRITE);
						writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
						writer.writeAttribute(LATENCY, "" + ma.getLatency());
						writer.writeAttribute(TYPE, ma.getType().toLowerCase());
						writer.writeEndElement();
					}
				}
				
				writer.writeEndElement();
			}

			writer.writeEndElement();
			writer.writeEndDocument();

		} catch (Exception e) {
			throw new TurnusException("Error while writing file \"" + output.getAbsolutePath() + "\"", e);
		}

		try {
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new TurnusException("File \"" + output.getAbsolutePath() + "\" has not been properly closed");
		}
	}
	
	public void write(CommunicationWeight weight, Network network, File output) throws TurnusException {
		XMLStreamWriter writer = null;
		try {
			OutputStream stream = new BufferedOutputStream(new FileOutputStream(output));
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			writer = factory.createXMLStreamWriter(stream);
			writer = new IndentingXMLStreamWriter(writer);
		} catch (Exception e) {
			throw new TurnusException("File \"" + output.getAbsolutePath() + "\" cannot be create");
		}

		try {
			writer.writeStartDocument();
			writer.writeStartElement(COMMUNICATION);
			writer.writeAttribute(NETWORK, network.getName());
			
			for (Buffer buffer : weight.getBuffers()) {
				writer.writeStartElement(BUFFER);
				writer.writeAttribute(SOURCE_ACTOR, buffer.getSource().getOwner().getName());
				writer.writeAttribute(SOURCE_PORT, buffer.getSource().getName());
				writer.writeAttribute(TARGET_ACTOR, buffer.getTarget().getOwner().getName());
				writer.writeAttribute(TARGET_PORT, buffer.getTarget().getName());
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "L1");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "L1")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "L1")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "LFB");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "LFB")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "LFB")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "L2");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "L2")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "L2")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "L3");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "L3")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "L3")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "Local RAM");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "Local RAM")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "Local RAM")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
				
				writer.writeStartElement(MEMORY);
				writer.writeAttribute(LEVEL, "Uncached memory");
				for (MemoryAccess ma : weight.getReadAccessByLevel(buffer, "Uncached memory")) {
					writer.writeEmptyElement(READ);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				for (MemoryAccess ma : weight.getWriteAccessByLevel(buffer, "Uncached memory")) {
					writer.writeEmptyElement(WRITE);
					writer.writeAttribute(PERCENTAGE, "" + ma.getPercentage());
					writer.writeAttribute(LATENCY, "" + ma.getLatency());
					writer.writeAttribute(TYPE, ma.getType().toLowerCase());		
				}
				writer.writeEndElement();
			   
				writer.writeEndElement();
			}

			writer.writeEndElement();
			writer.writeEndDocument();

		} catch (Exception e) {
			throw new TurnusException("Error while writing file \"" + output.getAbsolutePath() + "\"", e);
		}

		try {
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new TurnusException("File \"" + output.getAbsolutePath() + "\" has not been properly closed");
		}

	}
}

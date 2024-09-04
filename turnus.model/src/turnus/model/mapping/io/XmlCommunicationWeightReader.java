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
import static turnus.model.mapping.io.XmlNetworkWeightMarkup.FREQUENCY;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.data.MemoryAccess;

/**
 * 
 * @author Malgorzata Michalska
 *
 */
public class XmlCommunicationWeightReader {
	
	private Network network;
	private Map<Buffer, List<MemoryAccess>> readWeights;
	private Map<Buffer, List<MemoryAccess>> writeWeights;
	
	public XmlCommunicationWeightReader(Network network) {
		this.network = network;
		this.readWeights = new HashMap<Buffer, List<MemoryAccess>>();
		this.writeWeights = new HashMap<Buffer, List<MemoryAccess>>();
	}
	
	public CommunicationWeight load(File file) throws TurnusException {
		XMLStreamReader reader = null;
		try {
			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be opened");
		}

		CommunicationWeight	communicationWeight = new CommunicationWeight();
		
		Buffer buffer = null;
		String networkName = null;
		String sourceActor = null, sourcePort = null, targetActor = null, targetPort = null;
		String level = null, type = null ;
		double frequency = 1.0;
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					String xmlElement = reader.getName().toString();
					if (xmlElement.equals(COMMUNICATION)) {
						networkName = reader.getAttributeValue("", NETWORK);
						if (networkName == null) {
							throw new TurnusException(
									"Parsing error in \"" + file.getAbsolutePath() + "\": network name not specified");
						}
					} else if (xmlElement.equals(BUFFER)) {
						sourceActor = reader.getAttributeValue("", SOURCE_ACTOR);
						if (sourceActor == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": source actor not specified. Line " + reader.getLocation().getLineNumber());
						}
						sourcePort = reader.getAttributeValue("", SOURCE_PORT);
						if (sourcePort == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": source port not specified. Line " + reader.getLocation().getLineNumber());
						}
						targetActor = reader.getAttributeValue("", TARGET_ACTOR);
						if (targetActor == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": target actor not specified. Line " + reader.getLocation().getLineNumber());
						}
						targetPort = reader.getAttributeValue("", TARGET_PORT);
						if (targetPort == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": targetPort not specified. Line " + reader.getLocation().getLineNumber());
						}
						buffer = getBuffer(sourceActor, sourcePort, targetActor, targetPort);
						if (buffer == null)
							throw new TurnusException("Buffer " + sourceActor + ": " + sourcePort + " - " + targetActor + ": " + targetPort + "not found in the network.");
						if (!readWeights.keySet().contains(buffer)) {
							readWeights.put(buffer, new ArrayList<MemoryAccess>());
						}
						if (!writeWeights.keySet().contains(buffer)) {
							writeWeights.put(buffer, new ArrayList<MemoryAccess>());
						}
						
					} else if (xmlElement.equals(MEMORY)) {
						level = reader.getAttributeValue("", LEVEL);
						if (level == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": memory level not specified. Line " + reader.getLocation().getLineNumber());
						}
					} else if (xmlElement.equals(READ)) {
						type = reader.getAttributeValue("", TYPE);
						if (type == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": type not specified. Line " + reader.getLocation().getLineNumber());
						} 
						String percentageStr = reader.getAttributeValue("", PERCENTAGE);
						if (percentageStr == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": percentage not specified. Line " + reader.getLocation().getLineNumber());
						}
						String latencyStr = reader.getAttributeValue("", LATENCY);
						if (latencyStr == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": latency not specified. Line " + reader.getLocation().getLineNumber());
						}

						//frequency = Double.parseDouble(reader.getAttributeValue("", FREQUENCY))*1000;

						double percentageVal = Double.parseDouble(percentageStr);
						double latencyVal = Double.parseDouble(latencyStr) ;/// frequency;
						
						readWeights.get(buffer).add(new MemoryAccess(level, "read", type, percentageVal, latencyVal));
					} else if (xmlElement.equals(WRITE)) {
						type = reader.getAttributeValue("", TYPE);
						if (type == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": type not specified. Line " + reader.getLocation().getLineNumber());
						} 
						String percentageStr = reader.getAttributeValue("", PERCENTAGE);
						if (percentageStr == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": percentage not specified. Line " + reader.getLocation().getLineNumber());
						}
						String latencyStr = reader.getAttributeValue("", LATENCY);
						if (latencyStr == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": latency not specified. Line " + reader.getLocation().getLineNumber());
						}

						//frequency = Double.parseDouble(reader.getAttributeValue("", FREQUENCY))*1000;

						double percentageVal = Double.parseDouble(percentageStr);
						double latencyVal = Double.parseDouble(latencyStr);// / frequency;
						
						writeWeights.get(buffer).add(new MemoryAccess(level, "write", type, percentageVal, latencyVal));
					}
				}
				default: {
					break;
				}
				}
			}
			try {
				reader.close();
			} catch (Exception e) {
				Logger.warning("File \"%s\" has not been properly closed", file);
			}
		} catch (TurnusException e) {
			throw e;

		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be parsed");
		}
		
	/*	if (network != null) {
			supplyMissingBuffers(); // add zero weights for all buffers in the network that don't appear in the profiling result
		}*/
		
		communicationWeight.setNetworkName(networkName);
		communicationWeight.setReadWeights(readWeights);
		communicationWeight.setWriteWeights(writeWeights);
		
		return communicationWeight;
	}
	
	private Buffer getBuffer(String sourceActor, String sourcePort, String targetActor, String targetPort) {
		for (Buffer b : network.getBuffers()) {
			if (b.getSource().getOwner().getName().equals(sourceActor) && b.getSource().getName().equals(sourcePort)
					&& b.getTarget().getOwner().getName().equals(targetActor) && b.getTarget().getName().equals(targetPort))
				return b;
		}
		
		return null;
	}
	
/*	public void supplyMissingBuffers() {
		for (Buffer b : network.getBuffers()) {
			if (!readWeights.keySet().contains(b)) {
				readWeights.put(b, createEmptyMemoryAccesses());
				Logger.warning("No (read) profiling information specified for " + b + ". Communication weight will be assigned to 0 by default.");
			}
			if (!writeWeights.keySet().contains(b)) {
				writeWeights.put(b, createEmptyMemoryAccesses());
				Logger.warning("No (write) profiling information specified for " + b + ". Communication weight will be assigned to 0 by default.");
			}
		}
	}
	
	private List<MemoryAccess> createEmptyMemoryAccesses() {
		List<MemoryAccess> newList = new ArrayList<MemoryAccess>();
		newList.add(new MemoryAccess("L1", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L1", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("L1", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L1", "write", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("LFB", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("LFB", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("LFB", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("LFB", "write", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("L2", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L2", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("L2", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L2", "write", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("L3", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L3", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("L3", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("L3", "write", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("Local RAM", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("Local RAM", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("Local RAM", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("Local RAM", "write", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("Uncached memory", "read", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("Uncached memory", "read", "miss", 0.0, 0.0));
		newList.add(new MemoryAccess("Uncached memory", "write", "hit", 0.0, 0.0));
		newList.add(new MemoryAccess("Uncached memory", "write", "miss", 0.0, 0.0));
		
		return newList;
	}*/
}

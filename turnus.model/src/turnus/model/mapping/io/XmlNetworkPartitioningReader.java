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

import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.ACTOR;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.ACTOR_ID;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.CONFIGURATION;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.CONFIGURATION_NETWORK;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.PARTITION;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.PARTITION_ID;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.SCHEDULING_POLICY;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import com.google.common.collect.ImmutableList;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.common.EScheduler;
import turnus.model.mapping.NetworkPartitioning;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlNetworkPartitioningReader {

	public NetworkPartitioning load(File file) throws TurnusException {
		XMLStreamReader reader = null;
		try {
			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be opened");
		}

		NetworkPartitioning partitioning = null;
		String component = null;
		String scheduling = null;
		String actor = null;
		
		final ArrayList<String> actorsOrder = new ArrayList<>();
		
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					String xmlElement = reader.getLocalName();
					if (xmlElement.equals(CONFIGURATION)) {
						String network = reader.getAttributeValue("", CONFIGURATION_NETWORK);
						if (network == null) {
							throw new TurnusException(
									"Parsing error in \"" + file.getAbsolutePath() + "\": network name not specified");
						}
						partitioning = new NetworkPartitioning(network);
					} else if (xmlElement.equals(PARTITION)) {
						component = reader.getAttributeValue("", PARTITION_ID);
						if (component == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": component name specified. Line " + reader.getLocation().getLineNumber());
						}
						scheduling = reader.getAttributeValue("", SCHEDULING_POLICY);
						if (!schedulingRecognized(scheduling)) {
							Logger.warning(
									"Scheduling policy \"%s\" not recognized. Full-Parallel will be assumed as default.",
									scheduling);
							scheduling = EScheduler.FULL_PARALLEL.getLiteral();
						}
						partitioning.setScheduler(component, scheduling);
					} else if (xmlElement.equals(ACTOR)) {
						actor = reader.getAttributeValue("", ACTOR_ID);
						if (actor == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": actor name not specified. Line " + reader.getLocation().getLineNumber());
						}

						partitioning.setPartition(actor, component);
						actorsOrder.add(actor);
					}
					break;
				}
				case XMLEvent.END_ELEMENT: {
					String xmlElement = reader.getLocalName();
					if (xmlElement.equals(PARTITION)) {
						component = null;
					} else if (xmlElement.equals(ACTOR)) {
						actor = null;
					}
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
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be parsed", e);
		}

		// create the actors sorter
		Comparator<String> actorsSorter = new Comparator<String>() {
			
			private final List<String> actors = ImmutableList.copyOf(actorsOrder);
			
			@Override
			public int compare(String o1, String o2) {
				int v1 = actors.indexOf(o1);
				int v2 = actors.indexOf(o2);
				if(v1 == v2){
					return o1.compareTo(o2);
				}else{
					return Integer.compare(v1, v2);
				}
			}
		};
		
	 partitioning.setActorsSorter(actorsSorter);
		
		return partitioning;

	}

	private boolean schedulingRecognized(String scheduling) {
		if (scheduling != null) {
			for (EScheduler scheduler : EScheduler.VALUES) {
				if (scheduler.getLiteral().equalsIgnoreCase(scheduling)) {
					return true;
				}
			}
		}

		return false;
	}

}

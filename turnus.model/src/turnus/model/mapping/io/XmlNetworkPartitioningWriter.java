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
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.PARTITIONING;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.PARTITION_ID;
import static turnus.model.mapping.io.XmlNetworkPartitioningMarkup.SCHEDULING_POLICY;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.model.mapping.NetworkPartitioning;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlNetworkPartitioningWriter {

	public void write(NetworkPartitioning data, File output) throws TurnusException {
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
			writer.writeStartElement(CONFIGURATION);
			writer.writeAttribute(CONFIGURATION_NETWORK, data.getNetwork());
			writer.writeStartElement(PARTITIONING);

			Map<String, List<String>> partitionsMap = data.asPartitionActorsMap();
			for (Entry<String, List<String>> entry : partitionsMap.entrySet()) {
				String component = entry.getKey();
				writer.writeStartElement(PARTITION);
				writer.writeAttribute(PARTITION_ID, component);
				String schedulingPolicy = data.getScheduler(component);
				writer.writeAttribute(SCHEDULING_POLICY, schedulingPolicy);
				for (String actor : entry.getValue()) {
					writer.writeEmptyElement(ACTOR);
					writer.writeAttribute(ACTOR_ID, actor);
				}
				writer.writeEndElement();
			}

			writer.writeEndElement();
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

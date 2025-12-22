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

import static turnus.model.mapping.io.XmlNetworkWeightMarkup.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.collect.Table;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.data.ClockCycles;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlNetworkWeightWriter {

	boolean parseVarianceAttr = false;
	boolean parseFiringAttr = false;
	
	public XmlNetworkWeightWriter() {
		this.parseVarianceAttr = false;
		this.parseFiringAttr = false;
	}
	
	public XmlNetworkWeightWriter(Boolean parseVarianceAttr, Boolean parseFiringAttr) {
		this.parseVarianceAttr = parseVarianceAttr;
		this.parseFiringAttr = parseFiringAttr;
	}	

	public void write(NetworkWeight data, File output) throws TurnusException {
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
			writer.writeStartElement(NETWORK);
			writer.writeAttribute(NETWORK_NAME, data.getNetwork());

			Table<String, String, ClockCycles> table = data.asTable();
			for (Entry<String, Map<String, ClockCycles>> actorEntry : table.rowMap().entrySet()) {
				String actor = actorEntry.getKey();
				writer.writeStartElement(ACTOR);
				writer.writeAttribute(ACTOR_ID, actor);
				for (Entry<String, ClockCycles> actionEntry : actorEntry.getValue().entrySet()) {
					String action = actionEntry.getKey();
					ClockCycles w = actionEntry.getValue();
					writer.writeEmptyElement(ACTION);
					writer.writeAttribute(ACTION_ID, action);
					writer.writeAttribute(CLOCK_MEAN, Double.toString(w.getMeanClockCycles()));
					writer.writeAttribute(CLOCK_MIN, Double.toString(w.getMinClockCycles()));
					writer.writeAttribute(CLOCK_MAX, Double.toString(w.getMaxClockCycles()));

					if(parseFiringAttr) {
						writer.writeAttribute(CLOCK_VAR, Double.toString(w.getVarClockCycles()));
					}

					if(parseFiringAttr) {
						writer.writeAttribute(FIRINGS, Double.toString(w.getNumFirings()));
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

}

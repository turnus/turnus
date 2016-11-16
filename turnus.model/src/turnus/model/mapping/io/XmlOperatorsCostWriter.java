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

import static turnus.model.mapping.io.XmlOperatorsCostMarkup.OPERATOR;
import static turnus.model.mapping.io.XmlOperatorsCostMarkup.OPERATORS;
import static turnus.model.mapping.io.XmlOperatorsCostMarkup.OPERATOR_NAME;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.model.common.EOperator;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlOperatorsCostWriter {

	public void write(Map<EOperator, Double> map, File output) throws TurnusException {
		XMLStreamWriter writer = null;
		try {
			OutputStream stream = new BufferedOutputStream(new FileOutputStream(output));
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			writer = factory.createXMLStreamWriter(stream);
			writer = new IndentingXMLStreamWriter(writer);
		} catch (Exception e) {
			throw new TurnusException("File \"" + output.getAbsolutePath() + "\" cannot be created");
		}

		try {
			writer.writeStartDocument();
			writer.writeStartElement(OPERATORS);

			for (Entry<EOperator, Double> e : map.entrySet()) {
				String operator = e.getKey().getLiteral();
				String value = Double.toString(e.getValue());

				writer.writeStartElement(OPERATOR);
				writer.writeAttribute(OPERATOR_NAME, operator);
				writer.writeCharacters(value);
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

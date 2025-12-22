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
import static turnus.model.mapping.io.XmlOperatorsCostMarkup.OPERATOR_NAME;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.common.EOperator;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlOperatorsCostReader {

	public Map<EOperator, Double> load(File file) throws TurnusException {
		XMLStreamReader reader = null;
		try {
			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be opened");
		}

		Map<EOperator, Double> map = new HashMap<>();
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					String xmlElement = reader.getName().toString();
					if (xmlElement.equals(OPERATOR)) {
						String name = reader.getAttributeValue("", OPERATOR_NAME);
						if (name == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath() + "\":"
									+ " operator name not specified. See line: "
									+ reader.getLocation().getLineNumber());
						}

						EOperator op = EOperator.get(name);
						if (op == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath() + "\":"
									+ " operator does not exists. See line: " + reader.getLocation().getLineNumber());
						}

						try {
							Double value = Double.parseDouble(reader.getElementText());
							map.put(op, value);
						} catch (Exception e) {
							Logger.warning("Error reading the cost value of \"%s\"", name);
						}
					}
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

		return map;

	}

}

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

import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER_SIZE;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER_SRC_ACTOR;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER_SRC_PORT;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER_TGT_ACTOR;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BUFFER_TGT_PORT;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BXDF;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BXDF_DEFAULT_SIZE;
import static turnus.model.mapping.io.XmlBufferSizeMarkup.BXDF_NETWORK;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.mapping.BufferSize;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlBufferSizeReader {

	public BufferSize load(File file) throws TurnusException {
		XMLStreamReader reader = null;
		try {
			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be opened");
		}

		BufferSize bufferSize = null;
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					String xmlElement = reader.getName().toString();
					if (xmlElement.equals(BXDF)) {
						String network = reader.getAttributeValue("", BXDF_NETWORK);
						if (network == null) {
							throw new TurnusException(
									"Parsing error in \"" + file.getAbsolutePath() + "\": network name not specified");
						}
						bufferSize = new BufferSize(network);

						try {
							int size = Integer.parseInt(reader.getAttributeValue("", BXDF_DEFAULT_SIZE));
							bufferSize.setDefaultSize(size);
						} catch (Exception e) {
							Logger.warning("The default buffer size is incorrectly formatted in file %s", file);
						}

					} else if (xmlElement.equals(BUFFER)) {
						String srcActor = reader.getAttributeValue("", BUFFER_SRC_ACTOR);
						if (srcActor == null) {
							Logger.warning("Source actor not specified at line %d of file %s",
									reader.getLocation().getLineNumber(), file);
							break;
						}
						String srcPort = reader.getAttributeValue("", BUFFER_SRC_PORT);
						if (srcPort == null) {
							Logger.warning("Source port not specified at line %d of file %s",
									reader.getLocation().getLineNumber(), file);
							break;
						}

						String tgtActor = reader.getAttributeValue("", BUFFER_TGT_ACTOR);
						if (tgtActor == null) {
							Logger.warning("Target actor not specified at line %d of file %s",
									reader.getLocation().getLineNumber(), file);
							break;
						}

						String tgtPort = reader.getAttributeValue("", BUFFER_TGT_PORT);
						if (tgtPort == null) {
							Logger.warning("Target port not specified at line %d of file %s",
									reader.getLocation().getLineNumber(), file);
							break;
						}

						try {
							int size = Integer.parseInt(reader.getAttributeValue("", BUFFER_SIZE));
							bufferSize.setSize(srcActor, srcPort, tgtActor, tgtPort, size);
						} catch (Exception e) {
							Logger.warning("Buffer size not defined or incorrectly defined at line %d of file %s",
									reader.getLocation().getLineNumber(), file);
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

		return bufferSize;

	}

}

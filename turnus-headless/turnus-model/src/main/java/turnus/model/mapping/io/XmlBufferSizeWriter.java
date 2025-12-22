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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

import javanet.staxutils.IndentingXMLStreamWriter;
import turnus.common.TurnusException;
import turnus.common.util.Pair;
import turnus.model.mapping.BufferSize;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlBufferSizeWriter {

	public void write(BufferSize data, File output) throws TurnusException {
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
			writer.writeStartElement(BXDF);
			writer.writeAttribute(BXDF_NETWORK, data.getNetwork());
			writer.writeAttribute(BXDF_DEFAULT_SIZE, Integer.toString(data.getDefaultSize()));

			Table<Pair<String, String>, Pair<String, String>, Integer> table = data.asTable();
			for (Cell<Pair<String, String>, Pair<String, String>, Integer> cell : table.cellSet()) {
				Pair<String, String> src = cell.getRowKey();
				Pair<String, String> tgt = cell.getColumnKey();
				writer.writeEmptyElement(BUFFER);
				writer.writeAttribute(BUFFER_SRC_ACTOR, src.v1);
				writer.writeAttribute(BUFFER_SRC_PORT, src.v2);
				writer.writeAttribute(BUFFER_TGT_ACTOR, tgt.v1);
				writer.writeAttribute(BUFFER_TGT_PORT, tgt.v2);
				writer.writeAttribute(BUFFER_SIZE, Integer.toString(cell.getValue()));
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

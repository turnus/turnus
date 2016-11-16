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
package turnus.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.bind.DatatypeConverter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;

/**
 * This class contains serialization and de-serialization quick methods for
 * generic java objects
 * 
 * @author Simone Casale Brunet
 *
 */
public class ObjectUtils {

	/**
	 * Serialize a generic object to a String. The string contains a lexical
	 * representation of xsd:base64Binary
	 * 
	 * @param o
	 *            the object
	 * @return the string representation of the object
	 * @throws TurnusException
	 *             if the object cannot be serialized
	 */
	public static String serialize(Object object) throws TurnusException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.close();
		} catch (Exception e) {
			throw new TurnusException("Object serialization error", e);
		}
		return DatatypeConverter.printBase64Binary(baos.toByteArray());
	}

	/**
	 * Deserialize a generic object that has been serialized with the
	 * {@link #serialize(Object)} method
	 * 
	 * @param string
	 * @return the deserialized object
	 * @throws @throws
	 *             TurnusException if the string cannot be deserialized to an
	 *             object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String string) throws TurnusException {
		Object o = null;
		byte[] data = DatatypeConverter.parseBase64Binary(string);
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
			o = ois.readObject();
			try {
				ois.close();
			} catch (Exception e) {
				Logger.debug(
						"Error when closing the inout stream where the object " + o.toString() + " was serialized");
			}
		} catch (Exception e) {
			throw new TurnusException("Object deserialization error", e);
		}

		return (T) o;
	}

}

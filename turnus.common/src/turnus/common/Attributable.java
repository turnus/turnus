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
package turnus.common;

import java.util.Map;

/**
 * This interface defines an attributable object which may contains attributes.
 * 
 * @author Simone Casale Brunet
 *
 */
public interface Attributable {

	/**
	 * Get the attribute associated to the given name
	 * 
	 * @param name
	 *            the attribute name
	 * @return the attribute value, null if the attribute is not mapped
	 */
	<T> T getAttribute(String name);

	/**
	 * Get the attribute associated to the given name. If the attribute does not
	 * exists, the given default value is returned
	 * 
	 * @param name
	 *            the attribute name
	 * @param defaultValue
	 *            the default value returned if the attribute is not mapped
	 * @return
	 */
	<T> T getAttribute(String name, T defaultValue);

	/**
	 * Get the list of all the attribute names that are mapped
	 * 
	 * @return
	 */
	Iterable<String> getAttributeNames();

	/**
	 * Get a {@code Map<String, Object>} map of :
	 * 
	 * <pre>
	 * attribute-name // value
	 * </pre>
	 * 
	 * @return
	 */
	Map<String, Object> getAttributes();

	/**
	 * Return true if the attribute with the given name has an associated value
	 * 
	 * @param name
	 *            the attribute name
	 * @return true if the attribute with the given name is mapped
	 */
	boolean hasAttribute(String name);

	/**
	 * Return true if at least one attribute is mapped
	 * 
	 * @return
	 */
	boolean hasAttributes();

	/**
	 * Remove the attribute associated to the given name. Return true if the
	 * attribute has been removed, false otherwise (e.g. the attribute does not
	 * exist)
	 * 
	 * @param name
	 *            the attribute name
	 * @return true if the attribute has been removed, false otherwise
	 */
	boolean removeAttribute(String name);

	/**
	 * Remove all the mapped attributes
	 */
	void removeAttributes();

	/**
	 * Set the attribute value. The old value, if any, is replaced
	 * 
	 * @param name
	 *            the attribute name
	 * @param value
	 *            the attribute value to be mapped
	 */
	void setAttribute(String name, Object value);

}

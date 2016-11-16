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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines an abstract {@link Attributable}. Attributes are stored in
 * a {@code Map<String, Object>} map that is created only when the first
 * attribute value is stored. When all attributes are removed the map is
 * destroyed.
 * 
 * @author Simone Casale Brunet
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractAttributable implements Attributable {

	/** the attributes map **/
	protected Map<String, Object> attributes;

	@Override
	public <T> T getAttribute(String name) {
		if (attributes == null) {
			return null;
		}
		return (T) attributes.get(name);
	}

	@Override
	public <T> T getAttribute(String name, T defaultValue) {
		T obj = getAttribute(name);
		return obj != null ? obj : defaultValue;
	}

	@Override
	public Iterable<String> getAttributeNames() {
		if (attributes == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableSet(attributes.keySet());
	}

	@Override
	public Map<String, Object> getAttributes() {
		if (attributes == null) {
			return new HashMap<>();
		} else {
			return new HashMap<>(attributes);
		}
	}

	@Override
	public boolean hasAttribute(String name) {
		return attributes != null ? attributes.containsKey(name) : false;
	}

	@Override
	public boolean hasAttributes() {
		if (attributes == null) {
			return false;
		} else {
			return !attributes.isEmpty();
		}
	}

	@Override
	public boolean removeAttribute(String name) {
		if (attributes == null) {
			return false;
		}
		return attributes.remove(name) != null;
	}

	@Override
	public void removeAttributes() {
		attributes = null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		if (attributes == null) {
			attributes = new HashMap<>();
		}
		attributes.put(name, value);
	}

}

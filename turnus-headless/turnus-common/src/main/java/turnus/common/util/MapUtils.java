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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Maps;

/**
 * This class contains some utility methods for maps.
 * 
 * @author Simone Casale Brunet
 *
 */
public class MapUtils {

	/**
	 * Returns an immutable map whose keys are the distinct elements of keys and
	 * whose value the count of each key of the given multiset
	 * 
	 * @param multiset
	 *            the multiset
	 * @return the map view
	 */
	public static <T> Map<T, Integer> asMap(final HashMultiset<T> multiset) {
		return Maps.toMap(multiset, new Function<T, Integer>() {
			
			@Override
			public Integer apply(T elem) {
				return multiset.count(elem);
			}
		});
	}

	/**
	 * Extract the <code>Map(String,String)</code> representation from a given
	 * string (i.e. see {@link #asString(Map)})
	 * 
	 * @param string
	 *            the map string representation
	 *            <code>key1:value1;key2:value2;...;keyN:valueN</code>
	 * @return the map
	 */
	public static Map<String, String> asMap(String string) {
		if (string.isEmpty()) {
			return new HashMap<String, String>();
		}
		return Splitter.on(";").withKeyValueSeparator(":").split(string);
	}

	/**
	 * Convert a <code>Map(String,String)</code> to a string representation.
	 * <code>key1:value1;key2:value2;...;keyN:valueN</code>
	 * 
	 * @param map
	 *            the map
	 * @return the string representation
	 */
	public static String asString(Map<String, String> map) {
		if (map.isEmpty()) {
			return "";
		}
		return Joiner.on(";").withKeyValueSeparator(":").join(map);
	}

	/**
	 * Create a new Hash Map with a given maximal size. When the maximal entry
	 * size is reached, the eldest element is removed.
	 * 
	 * @param size
	 * @return
	 */
	public static <K, V> Map<K, V> createCacheMap(final int size) {
		return createCacheMap(null, size);
	}

	/**
	 * Create a new Hash Map with a given maximal size. When the maximal entry
	 * size is reached, the eldest element is removed.
	 * 
	 * @param initialMap
	 * @param maxSize
	 * @return
	 */
	public static <K, V> Map<K, V> createCacheMap(Map<K, V> initialMap, final int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("Size should be bigger than 0");
		} else if (initialMap == null) {
			initialMap = new HashMap<>(maxSize);
		} else if (initialMap.size() > maxSize) {
			throw new IllegalArgumentException("The initial map has size bigger then the maximal size");
		}

		return new LinkedHashMap<K, V>(initialMap) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private final int MAX_ENTRIES = maxSize;

			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > MAX_ENTRIES;
			}

		};
	}

}

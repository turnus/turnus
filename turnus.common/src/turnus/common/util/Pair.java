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

/**
 * This class defines a pair of objects. It contains two values: <code>v1</code>
 * and <code>v2</code> of kind <code>T</code> and <code>V</code>, respectively.
 * 
 * @author Simone Casale Brunet
 *
 * @param <T>
 *            kind of <code>v1</code>
 * @param <V>
 *            kind of <code>v2</code>
 */
public class Pair<T, V> {

	/**
	 * Create a new pair of objectes
	 * 
	 * @param v1
	 *            object 1 (not <code>null</code>)
	 * @param v2
	 *            object 2 (not <code>null</code>)
	 * @return
	 */
	public static <T, V> Pair<T, V> create(T v1, V v2) {
		if (v1 == null) {
			throw new IllegalArgumentException("Value v1 cannot be null");
		} else if (v2 == null) {
			throw new IllegalArgumentException("Value v2 cannot be null");
		}
		return new Pair<T, V>(v1, v2);
	}

	/**
	 * First value
	 */
	public final T v1;
	/**
	 * Second value
	 */
	public final V v2;

	/**
	 * Constructor
	 * 
	 * @param v1
	 * @param v2
	 */
	private Pair(T v1, V v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null) {
			return false;
		} else if (o instanceof Pair) {
			Pair<?, ?> po = (Pair<?, ?>) o;
			return (po.v1.equals(v1)) && (po.v2.equals(v2));
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}

}

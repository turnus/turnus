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

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Multiset;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class MathUtils {

	/**
	 * Return the nearest power of two number of the given number
	 * 
	 * @param num
	 * @return
	 */
	public static int nearestPowTwo(int num) {
		Integer n = num > 0 ? num - 1 : 0;

		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;

		return n;
	}

	/**
	 * Generate linearly spaced vector
	 * 
	 * @param min
	 * @param max
	 * @param points
	 * @return
	 */
	public static double[] linspace(double min, double max, int points) {
		double[] d = new double[points];
		for (int i = 0; i < points; i++) {
			d[i] = min + i * (max - min) / (points - 1);
		}
		return d;
	}

	/**
	 * Sum the values of a {@link Double} collection
	 * 
	 * @param data
	 * @return
	 */
	public static Double sumDouble(Collection<Double> data) {
		double result = 0;
		for (double v : data) {
			result += v;
		}
		return result;
	}

	/**
	 * Sum the values of a {@link Double} map
	 * 
	 * @param data
	 * @return
	 */
	public static Double sumDouble(Map<?, Double> data) {
		return sumDouble(data.values());
	}

	/**
	 * Return the overall count of the given {@link Multiset}
	 * 
	 * @param set
	 *            the set. If <code>null</code> then <code>0</code> is returned
	 * @return the overall count
	 */
	public static long sumMultiset(Multiset<?> set) {
		long count = 0;
		if (set != null)
			for (Multiset.Entry<?> entry : set.entrySet()) {
				count += entry.getCount();
			}
		return count;
	}

	/**
	 * Sum the values of an {@link Integer} collection
	 * 
	 * @param data
	 * @return
	 */
	public static Long sumInteger(Collection<Integer> data) {
		long result = 0;
		for (long v : data) {
			result += v;
		}
		return result;
	}

	/**
	 * Sum the values of an {@link Integer} map
	 * 
	 * @param data
	 * @return
	 */
	public static Long sumInteger(Map<?, Integer> data) {
		return sumInteger(data.values());
	}

	/**
	 * Sum the values of a {@link Long} collection
	 * 
	 * @param data
	 * @return
	 */
	public static Long sumLong(Collection<Long> data) {
		long result = 0;
		for (long v : data) {
			result += v;
		}
		return result;
	}

	/**
	 * Sum the values of a {@link Long} map
	 * 
	 * @param data
	 * @return
	 */
	public static Long sumLong(Map<?, Long> data) {
		return sumLong(data.values());
	}
	
	/**
	 * Safe parsing of a {@link String} to an {@link Integer} 
	 * 
	 * @param data
	 * @param defaultVal
	 * @return
	 */	
	public static int safeParseInt(String data, int defaultVal) {
		int val = defaultVal;
		try {
			val = Integer.parseInt(data);
		} 
		catch (NumberFormatException nfe) 
		{}
		
		return val;
	}

}

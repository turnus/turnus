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

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import turnus.common.TurnusException;

/**
 * This class contains some utility methods for collections.
 * 
 * @author Simone Casale Brunet
 *
 */
public class CollectionUtils {

	/**
	 * Extract the <code>List(String)</code> representation from a given string
	 * (i.e. see {@link #asString(List)})
	 * 
	 * @param string
	 *            the string value
	 * @return the list
	 */
	public static List<String> asList(String string) {
		return Lists.newArrayList(Splitter.on(";").split(string));
	}

	/**
	 * Convert a <code>List(String)</code> to a string representation.
	 * <code>value1;value2;...;valueN</code>
	 * 
	 * @param list
	 *            the list
	 * @return the string representation of the list
	 */
	public static String asString(List<String> list) {
		return Joiner.on(";").join(list);
	}

	/**
	 * Partition a list over n partitions. As an example a list as
	 * <code>[1,2,3,4,5,6]</code> partitioned with <code>n=2</code> returns two
	 * lists such as <code>[1,3,5]</code> and <code>[2,4,6]</code>. When
	 * <code>n</code> is bigger then the initial list size, empty list are
	 * returned. As an example the same list of before partitioned with
	 * <code>n=8</code> returns the following 8 lists:
	 * <code>[1],[2],[3],[4],[5],[6],[ ],[ ]</code>
	 * 
	 * @param list
	 *            the initial list
	 * @param partitions
	 *            the number of partitions
	 * @return a list of <code>partitions</code> lists
	 * @throws TurnusException
	 *             raised if <code>partitions</code> is smaller then 1
	 */
	public static <T> List<List<T>> partition(List<T> list, int partitions) throws TurnusException {
		if (partitions < 1) {
			throw new TurnusException("Negative value defined as partition number");
		}

		List<List<T>> listOfPartitions = new ArrayList<>();
		for (int i = 0; i < partitions; i++) {
			listOfPartitions.add(new ArrayList<T>());
		}

		// split the actors
		for (int i = 0, j = 0; i < list.size(); i++, j++) {
			if (j == partitions) {
				j = 0;
			}
			listOfPartitions.get(j).add(list.get(i));
		}

		return listOfPartitions;
	}

}

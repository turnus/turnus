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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import turnus.common.TurnusException;

/**
 * This class contains some utility methods for {@link Date}. The aim of this
 * class is to provide an unified handling of date format.
 * 
 * @author Simone Casale Brunet
 *
 */
public class DateUtil {

	/** The default {@link Date} formatter */
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * Parse the date from a string that is formatted using
	 * {@link DateUtil#dateFormat}
	 * 
	 * @param value
	 *            the string value
	 * @return the parsed string value
	 * @throws TurnusException
	 *             is raised if the string cannot be parsed
	 */
	public static Date asDate(String value) throws TurnusException {
		try {
			return dateFormat.parse(value);
		} catch (ParseException e) {
			throw new TurnusException("Date-string \"" + value + "\" cannot be parsed. See DateUtil.dateFormat.", e);
		}
	}

	/**
	 * Get the {@link String} representation of the date
	 * 
	 * @param date
	 * @return
	 */
	public static String asString(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * Get the {@link String} representation of now :)
	 * 
	 * @return
	 */
	public static String now() {
		return asString(new Date());
	}

}

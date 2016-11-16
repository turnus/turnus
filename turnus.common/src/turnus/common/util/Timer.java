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
 * This class defines a simple timer with a reset method.
 * 
 * @author Simone Casale Brunet
 *
 */
public class Timer {

	/** the log elapsed time */
	private long elapsedTime;
	/** the log global time */
	private long globalTime;

	/**
	 * Create a new timer
	 */
	public Timer() {
		globalTime = System.currentTimeMillis();
		elapsedTime = globalTime;
	}

	/**
	 * Get the elapsed time in ms since the timer has been created or reseted
	 * (i.e. see {@link #reset()})
	 * 
	 * @return time in ms
	 */
	public long getElapsedMs() {
		return System.currentTimeMillis() - elapsedTime;
	}

	/**
	 * Get the global time in ms since the timer has been created
	 * 
	 * @return time in ms
	 */
	public long getTotalMs() {
		return System.currentTimeMillis() - globalTime;
	}

	/**
	 * Get the global time in s since the timer has been created
	 * 
	 * @return time in s
	 */
	public long getTotalS() {
		return getTotalMs() / 1000;
	}

	/**
	 * Get the elapsed time in s since the timer has been created or reseted
	 * (i.e. see {@link #reset()})
	 * 
	 * @return time in s
	 */
	public long getElapsedS() {
		return getElapsedMs() / 1000;
	}

	/**
	 * Reset the timer
	 */
	public void reset() {
		elapsedTime = System.currentTimeMillis();
	}
}

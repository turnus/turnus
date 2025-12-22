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
package turnus.common.io;

import turnus.common.util.Timer;

/**
 * This class defines a progress printer with percentage. The granularity can be
 * defined.
 * 
 * @author Simone Casale Brunet
 *
 */
public class ProgressPrinter {

	/** the granularity (<code>true</code>: 10%, <code>false</code>: 1%) */
	private static final boolean GRANULARITY_10 = true;

	private final String message;
	private final boolean printEach10;
	private long step;
	private final double steps;
	private int currentValue = 0;
	private boolean finished = false;
	private Timer timer = new Timer();

	/**
	 * Create a new progress printer
	 * 
	 * @param message
	 *            the print message
	 * @param steps
	 *            the number of total steps that are performed
	 */
	public ProgressPrinter(String message, long steps) {
		this(message, steps, GRANULARITY_10);
	}

	/**
	 * Create a new progress printer with a given granularity
	 * 
	 * @param message
	 *            the print message
	 * @param steps
	 *            the number of total steps that are performed
	 * @param printEach10
	 *            the granularity (<code>true</code>: 10%, <code>false</code>:
	 *            1%)
	 */
	public ProgressPrinter(String message, long steps, boolean printEach10) {
		this.message = message != null ? message : "";
		this.steps = steps;
		this.printEach10 = printEach10;
		step = 0;
	}

	/**
	 * Finish
	 */
	public void finish() {
		if (!finished) {
			finished = true;
			Logger.info("%s: done in %d%s", message, timer.getElapsedS(), "s");
		}
	}

	/**
	 * Increment the step
	 */
	public synchronized void increment() {
		step++;
		update();
	}

	private void update() {
		if (!finished) {
			if (step == 1) {
				Logger.info("%s: started", message);
				timer.reset();
			} else {
				int val = (int) (step / steps * 100.0);
				if (currentValue != val) {
					if (!printEach10 || (printEach10 && val % 10 == 0)) {
						Logger.info("%s: %d%s", message, val, "%");
					} else {
						Logger.debug("%s: %d%s", message, val, "%");
					}

					currentValue = val;
				}

				if (step >= steps) {
					finish();
				}
			}
		}
	}

	/**
	 * Increment with a given number of steps
	 * 
	 * @param steps
	 *            the incremented number of steps
	 */
	public void increment(long steps) {
		this.step += steps;
		update();
	}

}

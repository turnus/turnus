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
package turnus.model.mapping.data;

public class ClockCycles implements Cloneable {
	private double maxClockCycles = 0.0;
	private double meanClockCycles = 0.0;
	private double minClockCycles = 0.0;
	private double varClockCycles = 0.0;
	private int numFirings = 0;

	public ClockCycles() {

	}

	public double getMaxClockCycles() {
		return maxClockCycles;
	}

	public double getMeanClockCycles() {
		return meanClockCycles;
	}

	public double getMinClockCycles() {
		return minClockCycles;
	}

	public double getVarClockCycles() {
		return varClockCycles;
	}

	public int getNumFirings() {
		return numFirings;
	}
	
	public void setMaxClockCycles(double maxClockCycles) {
		this.maxClockCycles = maxClockCycles;
	}

	public void setMeanClockCycles(double meanClockCycles) {
		this.meanClockCycles = meanClockCycles;
	}

	public void setMinClockCycles(double minClockCycles) {
		this.minClockCycles = minClockCycles;
	}

	public void setVarClockCycles(double varClockCycles) {
		this.varClockCycles = varClockCycles;
	}

	public void setNumFirings(int numFirings) {
		this.numFirings = numFirings;
	}

	public ClockCycles clone() {
		ClockCycles copy = new ClockCycles();
		copy.maxClockCycles = maxClockCycles;
		copy.meanClockCycles = meanClockCycles;
		copy.minClockCycles = minClockCycles;
		copy.varClockCycles = varClockCycles;
		copy.numFirings = numFirings;
		return copy;
	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("mean=").append(meanClockCycles);
		b.append(", min=").append(minClockCycles);
		b.append(", max=").append(maxClockCycles);
		if(varClockCycles != 0.0)
			b.append(", var=").append(varClockCycles);
		if(numFirings != 0)
			b.append(", firings=").append(numFirings);
		return b.toString();
	}

}

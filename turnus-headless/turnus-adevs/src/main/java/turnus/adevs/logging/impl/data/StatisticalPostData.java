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
package turnus.adevs.logging.impl.data;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class StatisticalPostData {
	private double bReadingStart;
	private double bReadingTime;
	private double bReadingMin;
	private double bReadingMax;
	private boolean isBReading;
	
	private double bWritingStart;
	private double bWritingTime;
	private double bWritingMin;
	private double bWritingMax;
	private boolean isBWriting;
	
	private double schedulableStart;
	private double schedulableTime;
	private double schedulableMin;
	private double schedulableMax;
	private boolean isSchedulable;
	
	private double processingStart;
	private double processingTime;
	private boolean isProcessing;
	
	private long executionCount;
	
	public StatisticalPostData() {
		bReadingStart = 0;
		bReadingTime = 0;
		bReadingMin = Double.MAX_VALUE;
		bReadingMax = 0;
		isBReading = false;
		
		bWritingStart = 0;
		bWritingTime = 0;
		bWritingMin = Double.MAX_VALUE;
		bWritingMax = 0;
		isBWriting = false;
		
		schedulableStart = 0;
		schedulableTime = 0;
		schedulableMin = Double.MAX_VALUE;
		schedulableMax = 0;
		isSchedulable = false;
		
		processingStart = 0;
		processingTime = 0;
		isProcessing = false;
		
		executionCount = 0;
	}
	
	public double getbReadingStart() {
		return bReadingStart;
	}

	public void setbReadingStart(double bReadingStart) {
		this.bReadingStart = bReadingStart;
	}

	public double getbReadingTime() {
		return bReadingTime;
	}

	public void setbReadingTime(double bReadingTime) {
		this.bReadingTime = bReadingTime;
	}

	public double getbReadingMin() {
		return bReadingMin;
	}

	public void setbReadingMin(double bReadingMin) {
		this.bReadingMin = bReadingMin;
	}

	public double getbReadingMax() {
		return bReadingMax;
	}

	public void setbReadingMax(double bReadingMax) {
		this.bReadingMax = bReadingMax;
	}

	public boolean isBReading() {
		return isBReading;
	}

	public void setBReading(boolean isBReading) {
		this.isBReading = isBReading;
	}

	public double getbWritingStart() {
		return bWritingStart;
	}

	public void setbWritingStart(double bWritingStart) {
		this.bWritingStart = bWritingStart;
	}

	public double getbWritingTime() {
		return bWritingTime;
	}

	public void setbWritingTime(double bWritingTime) {
		this.bWritingTime = bWritingTime;
	}

	public double getbWritingMin() {
		return bWritingMin;
	}

	public void setbWritingMin(double bWritingMin) {
		this.bWritingMin = bWritingMin;
	}

	public double getbWritingMax() {
		return bWritingMax;
	}

	public void setbWritingMax(double bWritingMax) {
		this.bWritingMax = bWritingMax;
	}

	public boolean isBWriting() {
		return isBWriting;
	}

	public void setBWriting(boolean isBWriting) {
		this.isBWriting = isBWriting;
	}

	public double getSchedulableStart() {
		return schedulableStart;
	}

	public void setSchedulableStart(double schedulableStart) {
		this.schedulableStart = schedulableStart;
	}

	public double getSchedulableTime() {
		return schedulableTime;
	}

	public void setSchedulableTime(double schedulableTime) {
		this.schedulableTime = schedulableTime;
	}

	public double getSchedulableMin() {
		return schedulableMin;
	}

	public void setSchedulableMin(double schedulableMin) {
		this.schedulableMin = schedulableMin;
	}

	public double getSchedulableMax() {
		return schedulableMax;
	}

	public void setSchedulableMax(double schedulableMax) {
		this.schedulableMax = schedulableMax;
	}

	public boolean isSchedulable() {
		return isSchedulable;
	}

	public void setSchedulable(boolean isSchedulable) {
		this.isSchedulable = isSchedulable;
	}

	public double getProcessingStart() {
		return processingStart;
	}

	public void setProcessingStart(double processingStart) {
		this.processingStart = processingStart;
	}

	public double getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(double processingTime) {
		this.processingTime = processingTime;
	}

	public boolean isProcessing() {
		return isProcessing;
	}

	public void setProcessing(boolean isProcessing) {
		this.isProcessing = isProcessing;
	}

	public long getExecutionCount() {
		return executionCount;
	}

	public void increaseExecutionCount() {
		this.executionCount++;
	}
}

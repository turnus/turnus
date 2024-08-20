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
package turnus.adevs.logging.impl;

import turnus.adevs.logging.ActorDataCollector;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class ActionExecutionDebugger implements ActorDataCollector{

	@Override
	public void init() { 
		
	}

	@Override
	public void logEndSimulation(double time) {
	}

	@Override
	public PostProcessingData generateReport() {
		return null;
	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> isSchedulable");	
	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> isEnabled");	
		
	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> startProcessing");	
		
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> endProcessing");	
		
	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> startProducing");	
		
	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> endFiring");	
		
	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
		System.out.println(time + " : ["+action.getOwner().getName()+"] "+action.getName() +" ("+stepId+") -> endProcessing in core" + core);	
		
	}

}

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.adevs.logging.ActorDataCollector;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class BufferBlockingCollector implements ActorDataCollector, Cloneable {
	
	private Network network;
	private Map<Buffer, Integer> bInstances;
	private Map<Buffer, Integer> bTokens;
	private Map<Buffer, Double> bTime;
	private Map<Buffer, Integer> maxTokens;
	private Map<Buffer, Double> maxMultiplication;
	private Map<Action, List<Buffer>> isBlocked;
	
	public BufferBlockingCollector(Network network) {
		this.network = network;
		init();
	}

	@Override
	public void init() {
		bInstances = new HashMap<Buffer, Integer>();
		bTokens = new HashMap<Buffer, Integer>();
		bTime = new HashMap<Buffer, Double>();
		maxTokens = new HashMap<Buffer, Integer>();
		maxMultiplication = new HashMap<Buffer, Double>();
		isBlocked = new HashMap<Action, List<Buffer>>();
	}

	@Override
	public void logEndSimulation(double time) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		if (isBlocked.containsKey(action) && !isBlocked.get(action).isEmpty()) {
			for (Buffer buffer : isBlocked.get(action)) {
				double criterion = bTokens.get(buffer) * (time - bTime.get(buffer));
				if (maxMultiplication.containsKey(buffer)) {
					criterion = Math.max(criterion, maxMultiplication.get(buffer));
				}
				maxMultiplication.put(buffer, criterion);
			}
			isBlocked.get(action).clear();
		}
	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		if (!isBlocked.containsKey(action) || !isBlocked.get(action).contains(fullBuffer)) {
			int instances = bInstances.containsKey(fullBuffer) ? bInstances.get(fullBuffer) : 0;
			bInstances.put(fullBuffer, instances + 1);
			bTime.put(fullBuffer, time);
			bTokens.put(fullBuffer, tokens);
			
			int mTokens = maxTokens.containsKey(fullBuffer) ? maxTokens.get(fullBuffer) : 0;
			maxTokens.put(fullBuffer, Math.max(mTokens, tokens));
			
			if (isBlocked.containsKey(action)) {
				isBlocked.get(action).add(fullBuffer);
			}
			else {
				ArrayList<Buffer> blockedBuffers = new ArrayList<Buffer>();
				blockedBuffers.add(fullBuffer);
				isBlocked.put(action, blockedBuffers);
			}
		}
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
	public PostProcessingData generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		BufferBlockingReport report = f.createBufferBlockingReport();
		report.setNetwork(network);
		
		for (Buffer buffer : maxTokens.keySet()) {
			report.getBlockingInstances().put(buffer, bInstances.get(buffer));
			report.getMaxBlockedOutputTokens().put(buffer, maxTokens.get(buffer));
			report.getMaxBlockedMultiplication().put(buffer, maxMultiplication.get(buffer));
		}
		
		return report;
	}

	@Override
	public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
		// TODO Auto-generated method stub
		
	}

}

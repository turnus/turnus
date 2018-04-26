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
package turnus.analysis.profiler.dynamic.data;

import static turnus.model.common.StatisticalData.Util.asStatisticalData;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import turnus.analysis.profiler.dynamic.trace.ProfiledStep;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.ProfilerFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * This class contains the profiling information for a buffer.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfiledBuffer {

	private class ProfilingData {
		/** the statistics of read tokens of each action */
		private Map<Action, SummaryStatistics> actionReads;
		/** the statistics of read tokens of each action */
		private Map<Action, SummaryStatistics> actionWrites;
		/** the statistics of buffer occupancy */
		private SummaryStatistics occupancy;
		/** the peeks performed by each action */
		private HashMultiset<Action> peeks;
		/** the read misses of each action */
		private HashMultiset<Action> readMisses;
		/** the write misses of each action */
		private HashMultiset<Action> writeMisses;
		/** the reads */
		private SummaryStatistics reads;
		/** the writes */
		private SummaryStatistics writes;

		private ProfilingData() {
			actionReads = new HashMap<>();
			actionWrites = new HashMap<>();
			occupancy = new SummaryStatistics();
			peeks = HashMultiset.create();
			readMisses = HashMultiset.create();
			writeMisses = HashMultiset.create();
			reads = new SummaryStatistics();
			writes = new SummaryStatistics();
		}

		private void update(StepDataBox data) {
			Action action = data.getStep().getAdapter(Action.class);
			int read = data.getConsumedTokens().count(buffer);
			int write = data.getProducedTokens().count(buffer);

			if (read > 0) {
				reads.addValue(read);

				// lazy creation of the readers map
				SummaryStatistics stat = actionReads.get(action);
				if (stat == null) {
					stat = new SummaryStatistics();
					actionReads.put(action, stat);
				}
				stat.addValue(read);
			}

			if (write > 0) {
				writes.addValue(write);

				// lazy creation of the writers map
				SummaryStatistics stat = actionWrites.get(action);
				if (stat == null) {
					stat = new SummaryStatistics();
					actionWrites.put(action, stat);
				}
				stat.addValue(write);
			}

			if (read != 0 || write != 0) {
				occupancy.addValue(tokens.size());
			}
		}
	}

	/** the buffer under profiling */
	private Buffer buffer;
	private ProfilingData bufferData;
	private ArrayDeque<ProfiledStep> tokens;

	public ProfiledBuffer(Buffer buffer) {
		this.buffer = buffer;
		tokens = new ArrayDeque<>(512);
		bufferData = new ProfilingData();
	}

	public void logPeek(Action action) {
		bufferData.peeks.add(action);
	}

	public void logReadMiss(Action action) {
		bufferData.readMisses.add(action);
	}

	public void logWriteMiss(Action action) {
		bufferData.writeMisses.add(action);
	}

	public void update(StepDataBox data) {
		bufferData.update(data);
	}

	public void produceToken(ProfiledStep producer) {
		tokens.addLast(producer);
	}

	public ProfiledStep consumeToken() {
		return tokens.removeFirst();
	}

	public int getUnconsumedTokens() {
		return tokens.size();
	}

	public BufferDynamicData getData() {
		ProfilerFactory f = ProfilerFactory.eINSTANCE;

		BufferDynamicData data = f.createBufferDynamicData();
		data.setBuffer(buffer);

		// action reads
		for (Map.Entry<Action, SummaryStatistics> e : bufferData.actionReads.entrySet()) {
			data.getActionReads().put(e.getKey(), asStatisticalData(e.getValue()));
		}

		// action writes
		for (Map.Entry<Action, SummaryStatistics> e : bufferData.actionWrites.entrySet()) {
			data.getActionWrites().put(e.getKey(), asStatisticalData(e.getValue()));
		}

		// occupancy
		data.setOccupancy(asStatisticalData(bufferData.occupancy));

		// peeks
		for (Multiset.Entry<Action> e : bufferData.peeks.entrySet()) {
			data.getActionPeeks().put(e.getElement(), (long) e.getCount());
		}

		// read misses
		for (Multiset.Entry<Action> e : bufferData.readMisses.entrySet()) {
			data.getActionReadMisses().put(e.getElement(), (long) e.getCount());
		}

		// write misses
		for (Multiset.Entry<Action> e : bufferData.writeMisses.entrySet()) {
			data.getActionWriteMisses().put(e.getElement(), (long) e.getCount());
		}

		// reads
		data.setReads(asStatisticalData(bufferData.reads));

		// writes
		data.setWrites(asStatisticalData(bufferData.writes));

		// unconsumed tokens
		data.setUnconsumedTokens(getUnconsumedTokens());

		return data;

	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(buffer.getSource().getOwner().getName());
		b.append("[").append(buffer.getSource().getName()).append("]");
		b.append("->");
		b.append(buffer.getTarget().getOwner().getName());
		b.append("[").append(buffer.getTarget().getName()).append("]");
		return b.toString();
	}

}

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
package turnus.analysis.buffer;

import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_BIT_ACCURATE;
import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_POW2;
import static turnus.common.util.MathUtils.nearestPowTwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import turnus.analysis.Analysis;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.StringUtils;
import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersFactory;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class BoundedBufferAnalysis extends Analysis<BoundedBuffersReport> {

	private class ActorScheduler {
		private Step currentStep;
		private Iterator<Step> steps;

		private ActorScheduler(Actor actor) {
			steps = trace.getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			loadNextStep();
		}

		private Step getCurrentStep() {
			return currentStep;
		}

		private boolean hasFinished() {
			return currentStep == null;
		}

		private void loadNextStep() {
			if (steps.hasNext()) {
				currentStep = steps.next();
			} else {
				currentStep = null;
			}
		}

	}

	public static final boolean DEFAULT_BIT_ACCURATE = false;
	public static final boolean DEFAULT_POW2 = false;
	private Collection<ActorScheduler> actorsSchedulers;
	private boolean bitAccurate = false;
	private List<Buffer> buffers;
	private TraceDecorator decorator;
	private final String MAX_TOKENS = StringUtils.createRandomKey("maxBuffers", this);
	private final String OCCUPANCY = StringUtils.createRandomKey("occupancy", this);
	private boolean pow2 = false;
	private final String SATISFIED = StringUtils.createRandomKey("satisfied", this);
	private Trace trace;

	public BoundedBufferAnalysis(TraceProject project) {
		super(project);
	}

	private BoundedBuffersReport generateReport() {
		BuffersFactory f = BuffersFactory.eINSTANCE;
		Network newtork = project.getNetwork();

		BoundedBuffersReport report = f.createBoundedBuffersReport();
		report.setNetwork(newtork);
		report.setAlgorithm("Bounded buffer analysis with Park's and DDF algorithm");
		report.setBitAccurate(bitAccurate);
		report.setPow2(pow2);

		for (Buffer buffer : buffers) {
			BoundedBufferData data = f.createBoundedBufferData();
			data.setBuffer(buffer);
			report.getBuffersData().add(data);

			int size = buffer.getAttribute(MAX_TOKENS);
			if (pow2) {
				size = nearestPowTwo(size);
			}
			data.setTokenSize(size);
		}

		return report;
	}

	private Collection<Step> getSchedulables() {
		Collection<Step> schedulables = new HashSet<>();
		for (ActorScheduler a : actorsSchedulers) {
			if (!a.hasFinished()) {
				// check input tokens
				Step step = a.getCurrentStep();
				boolean schedulable = true;
				for (Entry<Buffer, Integer> entry : decorator.getReadTokens(step).entrySet()) {
					int tokens = entry.getValue();
					int available = entry.getKey().getAttribute(OCCUPANCY);
					if (available < tokens) {
						schedulable = false;
						break;
					}
				}

				if (schedulable)
					schedulables.add(a.getCurrentStep());
			}
		}

		if (schedulables.isEmpty()) {
			return Collections.emptyList();
		}

		// check actors that can be fired: there are enough output tokens
		Collection<Step> fireables = new HashSet<>();
		for (Step step : schedulables) {
			boolean fireable = true;
			for (Entry<Buffer, Integer> entry : decorator.getWriteTokens(step).entrySet()) {
				Buffer buffer = entry.getKey();
				int request = entry.getValue();
				int occupancy = buffer.getAttribute(OCCUPANCY);
				int maxTokens = buffer.getAttribute(MAX_TOKENS);
				if (occupancy + request > maxTokens) {
					fireable = false;
					break;
				}
			}
			if (fireable) {
				fireables.add(step);
			}
		}

		if (!fireables.isEmpty()) {
			return fireables;
		}

		// check not deferrable steps (there is at least one full output buffer)
		// the c_j is the maximum of the buffer sizes for that actor’s output
		// channels that have satisfied demands

		// first step evaluate the consumers that have satisfied value
		Set<Buffer> unsatisfied = new HashSet<>();
		for (Step step : schedulables) {
			for (Entry<Buffer, Integer> entry : decorator.getReadTokens(step).entrySet()) {
				Buffer buffer = entry.getKey();
				int tokens = entry.getValue();
				int available = buffer.getAttribute(OCCUPANCY);
				if (available < tokens) {
					unsatisfied.add(buffer);
				}
			}
		}
		for (Buffer buffer : buffers) {
			boolean satisfied = !unsatisfied.contains(buffer);
			buffer.setAttribute(SATISFIED, satisfied);
		}

		Map<Step, Integer> cMap = new HashMap<>();
		Map<Step, Integer> dMap = new HashMap<>();
		for (Step step : schedulables) {
			int cMax = Integer.MIN_VALUE;
			int dMin = Integer.MAX_VALUE;
			for (Entry<Buffer, Integer> entry : decorator.getWriteTokens(step).entrySet()) {
				Buffer buffer = entry.getKey();
				boolean satisfied = buffer.getAttribute(SATISFIED);
				if (satisfied) {
					int size = buffer.getAttribute(MAX_TOKENS);
					if (bitAccurate) {
						size *= buffer.getType().getBits();
					}
					
					// the rounding is made on the generate report method...
					//if (pow2) {
					//	size = nearestPowTwo(size);
					//}
					
					cMax = Math.max(cMax, size);
					cMap.put(step, cMax);
				} else {
					int tokens = entry.getValue();
					int available = buffer.getAttribute(OCCUPANCY);
					int maxOccupancy = buffer.getAttribute(MAX_TOKENS);
					int dValue = (available + tokens) - maxOccupancy;
					if (bitAccurate) {
						dValue *= buffer.getType().getBits();
					}
					//if (pow2) {
					//	dValue = nearestPowTwo(dValue);
					//}
					dMin = Math.min(dValue, dMin);
					dMap.put(step, dMin);
				}
			}
		}

		final Map<Step, Integer> selectMap = !cMap.isEmpty() ? cMap : dMap;
		List<Step> steps = new ArrayList<>(selectMap.keySet());
		Collections.sort(steps, new Comparator<Step>() {

			@Override
			public int compare(Step s1, Step s2) {
				int v1 = selectMap.get(s1);
				int v2 = selectMap.get(s2);
				if (v1 != v2) {
					return Integer.compare(v1, v2);
				}
				// NOTE: in this case compare by ID to make the result
				// deterministic (always the same for different runs)
				return Long.compare(s1.getId(), s2.getId());
			}
		});

		fireables.add(steps.get(0));
		return fireables;
	}

	public BoundedBuffersReport run() {
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		}

		pow2 = configuration.getValue(ANALYSIS_BUFFER_POW2, DEFAULT_POW2);
		bitAccurate = configuration.getValue(ANALYSIS_BUFFER_BIT_ACCURATE, DEFAULT_BIT_ACCURATE);

		trace = project.getTrace();
		decorator = project.getTraceDecorator();

		Network network = decorator.getNetwork();
		buffers = network.getBuffers();

		ProgressPrinter progress;

		long steps = trace.getSizeS();
		if (steps > 0) {
			progress = new ProgressPrinter("Bounded buffer evaluation", steps);
		} else {
			progress = new NullProgressPrinter("Bounded buffer evaluation");
		}

		// create the actors schedulers
		actorsSchedulers = new HashSet<>();
		for (Actor actor : network.getActors()) {
			actorsSchedulers.add(new ActorScheduler(actor));
		}

		// initialize the buffers
		for (Buffer buffer : buffers) {
			buffer.setAttribute(MAX_TOKENS, 0);
			buffer.setAttribute(OCCUPANCY, 0);
			buffer.setAttribute(SATISFIED, false);
		}

		for (;;) {
			if (isCanceled()) {
				Logger.info("Analysis stopped by the user");
				break;
			}

			Collection<Step> schedulables = getSchedulables();
			if (schedulables.isEmpty()) {
				break;
			}

			for (Step step : schedulables) {
				progress.increment();

				// consume tokens
				for (Map.Entry<Buffer, Integer> ce : decorator.getReadTokens(step).entrySet()) {
					Buffer b = ce.getKey();
					int tokens = ce.getValue();

					int occupancy = (int) b.getAttribute(OCCUPANCY) - tokens;
					if (occupancy < 0) {
						Logger.error("reading not tokens");
					}
					b.setAttribute(OCCUPANCY, occupancy);
				}

				// produce tokens
				for (Map.Entry<Buffer, Integer> ce : decorator.getWriteTokens(step).entrySet()) {
					Buffer b = ce.getKey();
					int tokens = ce.getValue();

					int occupancy = (int) b.getAttribute(OCCUPANCY) + tokens;
				//	if (pow2) {
				//		occupancy = nearestPowTwo(occupancy);
				//	}

					b.setAttribute(OCCUPANCY, occupancy);
					int max = Math.max((int) b.getAttribute(MAX_TOKENS), occupancy);

					b.setAttribute(MAX_TOKENS, max);

				}

			}

			for (ActorScheduler a : actorsSchedulers) {
				if (!a.hasFinished() && schedulables.contains(a.getCurrentStep())) {
					a.loadNextStep();
				}
			}
		}

		progress.finish();

		BoundedBuffersReport report = generateReport();

		// clean network attributes
		for (Buffer buffer : network.getBuffers()) {
			buffer.removeAttribute(MAX_TOKENS);
			buffer.removeAttribute(OCCUPANCY);
			buffer.removeAttribute(SATISFIED);
		}

		return report;

	}

}

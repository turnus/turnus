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

import static turnus.common.TurnusOptions.ANALYSIS_BUFFER_POW2;
import static turnus.common.util.MathUtils.nearestPowTwo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
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
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class MaximalBufferSizeAnalysis extends Analysis<BoundedBuffersReport> {

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

	public MaximalBufferSizeAnalysis(TraceProject project) {
		super(project);
	}

	public static final boolean DEFAULT_POW2 = false;
	private Collection<ActorScheduler> actorsSchedulers;
	private List<Buffer> buffers;
	private TraceDecorator decorator;
	private final String MAX_TOKENS = StringUtils.createRandomKey("maxTokens", this);
	private boolean pow2 = false;
	private Trace trace;

	@Override
	public BoundedBuffersReport run() throws TurnusException {
		if (!project.isTraceLoaded()) {
			project.loadTrace(new SplittedTraceLoader(), configuration);
		} 

		pow2 = configuration.getValue(ANALYSIS_BUFFER_POW2, DEFAULT_POW2);

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
		}

		boolean scheduled = false;
		do {
			if (isCanceled()) {
				Logger.info("Analysis stopped by the user");
				break;
			}

			scheduled = false;
			for (ActorScheduler scheduler : actorsSchedulers) {
				if (!scheduler.hasFinished()) {
					Map<Buffer, Integer> writeTokens = decorator.getWriteTokens(scheduler.getCurrentStep());
					for (Entry<Buffer, Integer> e : writeTokens.entrySet()) {
						Buffer b = e.getKey();
						int value = e.getValue() + (int) b.getAttribute(MAX_TOKENS);
						b.setAttribute(MAX_TOKENS, value);
					}
					
					scheduler.loadNextStep();
					progress.increment();
					scheduled = true;
				}
			}

		} while (scheduled);
		
		if(pow2){
			
		}

		progress.finish();

		BoundedBuffersReport report = generateReport();

		// clean network attributes
		for (Buffer buffer : network.getBuffers()) {
			buffer.removeAttribute(MAX_TOKENS);
		}
		return report;
	}

	private BoundedBuffersReport generateReport() {
		BuffersFactory f = BuffersFactory.eINSTANCE;
		Network newtork = project.getNetwork();

		BoundedBuffersReport report = f.createBoundedBuffersReport();
		report.setNetwork(newtork);
		report.setAlgorithm("Bounded buffer analysis: worst case tokens occupancy (maximal buffer size)");
		report.setBitAccurate(false);
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

}

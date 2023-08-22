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
package turnus.adevs.simulation;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import adevs.Simulator;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.adevs.logging.DataCollector;
import turnus.adevs.model.AdevsModel;
import turnus.adevs.model.AdevsModelBuilder;
import turnus.adevs.model.AtomicActor;
import turnus.adevs.model.AtomicActor.Status;
import turnus.adevs.model.AtomicActorPartition;
import turnus.adevs.model.AtomicBuffer;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.MathUtils;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * Adevs execution trace graph simulation engine
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 * @author Endri Bezati
 *
 */
public class SimEngine {

	private TraceProject tProject = null;
	private TraceWeighter tWeighter = null;
	private AdevsModel model = null;
	private NetworkPartitioning partitioning = null;
	private BufferSize bufferSize = null;
	private CommunicationWeight communicationWeight = null;
	private SchedulingWeight schedulingWeight = null;
	private boolean releaseAfterProcessing = false;
	private boolean printActorStatus = false;

	private double timer = 0;
	private boolean deadlock = false;
	private String simulationName = "Post-scheduling simulation";

	private Collection<DataCollector> dataCollectors = new HashSet<DataCollector>();

	public SimEngine() {
	}

	public SimEngine(String simulationName) {
		this.simulationName = simulationName;
	}

	public void addDataCollector(DataCollector collector) {
		dataCollectors.add(collector);
	}

	private void printActorStatus(double timer) {
		for (AtomicActor actor : model.getActors()) {
			Logger.debug(timer + ": " + actor.getActor().getName() + ": " + actor.getCurrentStatus());
		}
	}

	private boolean checkDeadlock(double timer) {
		for (AtomicActor actor : model.getActors()) {
			if (actor.getCurrentStatus() != Status.TERMINATED) {
				Logger.warning("DEADLOCK at time: %f", timer);
				return true;
			}
		}
		return false;
	}

	private boolean checkDeadlock(double timer, boolean withlog) {
		for (AtomicActor actor : model.getActors()) {
			if (actor.getCurrentStatus() != Status.TERMINATED) {
				if (withlog)
					Logger.warning("DEADLOCK at time: %f", timer);
				return true;
			}
		}
		return false;
	}

	private PostProcessingReport generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		PostProcessingReport finalReport = f.createPostProcessingReport();
		finalReport.setAlgorithm(simulationName);
		finalReport.setDate(new Date());
		finalReport.setNetwork(tProject.getNetwork());
		finalReport.setTime(timer);
		finalReport.setDeadlock(deadlock);

		for (DataCollector collector : dataCollectors) {
			PostProcessingData data = collector.generateReport();
			if (data != null) {
				finalReport.getReports().add(data);
			}
		}

		return finalReport;
	}

	public NetworkPartitioning getNetworkPartitioning() {
		return partitioning;
	}

	public boolean isDeadlocked() {
		return deadlock;
	}

	private void printStatus() {
		Logger.info("%s: estimated time: %.2f", simulationName, timer);
		Logger.info("%s: deadlock: %s", simulationName, checkDeadlock(timer, false));

		Logger.debug("--- [%s] post-processing information ---", simulationName);
		for (AtomicActor actor : model.getActors()) {
			Logger.debug(" %s : %s, steps fired: %d", actor.getActor().getName(), actor.getCurrentStatus().toString(),
					actor.getFiredStepsNumber());
		}
		Logger.debug("----------");
	}

	public PostProcessingReport run() throws TurnusException {
		if (tProject == null || tWeighter == null || partitioning == null) {
			throw new TurnusException("SimEngine not configured properly.");
		}

		this.model = new AdevsModelBuilder(tProject, tWeighter, partitioning, bufferSize, communicationWeight,
				schedulingWeight, releaseAfterProcessing).build();
		Simulator simulator = new Simulator(model);
		double nextUpdateTime = simulator.nextEventTime();
		timer = 0;

		// create the progress printer
		ProgressPrinter progress = new ProgressPrinter(simulationName, tProject.getTrace().getSizeS());

		// create the data logger
		AdevsDataLogger logger = new AdevsDataLogger();
		// add data collectors
		for (DataCollector collector : dataCollectors) {
			collector.init();
			logger.addDataCollector(collector);
		}

		// set the progress printer and the logger for each atomic actor
		for (AtomicActor actor : model.getActors()) {
			actor.setProgressPrinter(progress);
			actor.setDataLogger(logger);
		}

		// set the logger for each partition
		for (AtomicActorPartition partition : model.getActorPartitions()) {
			partition.setDataLogger(logger);
		}

		// main simulation loop
		while (nextUpdateTime < Double.MAX_VALUE) {
			timer = nextUpdateTime;
			if (printActorStatus)
				printActorStatus(timer);
			simulator.execNextEvent();
			nextUpdateTime = simulator.nextEventTime();
		}

		printStatus();
		deadlock = checkDeadlock(timer);
		logger.logEndSimulation(timer);

		return generateReport();
	}

	public BufferSize getMaxBufferSizeRecorded() {
		BufferSize recordedMaxBuffers = new BufferSize(tProject.getNetwork());
		for (AtomicBuffer buffer : model.getBuffers()) { // By default the sizes are rounded to pow 2
			recordedMaxBuffers.setSize(buffer.getBuffer(), buffer.getMaxTokensInFifo());
		}

		return recordedMaxBuffers;
	}

	public AdevsModel getAdevsModel() {
		return model;
	}

	public void setNetworkPartitioning(NetworkPartitioning partitioning) {
		this.partitioning = partitioning;
	}

	public void setSimulationName(String simulationName) {
		this.simulationName = simulationName;
	}

	public void setTraceProject(TraceProject tProject) {
		this.tProject = tProject;
	}

	public void setTraceWeighter(TraceWeighter tWeighter) {
		this.tWeighter = tWeighter;
	}

	public void setBufferSize(BufferSize bufferSize) {
		this.bufferSize = bufferSize;
	}

	public void setReleaseAfterProcessing() {
		this.releaseAfterProcessing = true;
	}

	public void setPrintActorStatus(boolean value) {
		this.printActorStatus = value;
	}

	public void setCommunicationWeight(CommunicationWeight communicationWeight) {
		this.communicationWeight = communicationWeight;
	}

	public void setSchedulingWeight(SchedulingWeight schedulingWeight) {
		this.schedulingWeight = schedulingWeight;
	}
}

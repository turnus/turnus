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
package turnus.adevs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset.Entry;

import adevs.Atomic;
import adevs.Digraph.PortValue;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.Pair;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.Step;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * This is the implementation of an {@link Atomic} {@link Actor}.
 * 
 * @author Simone Casale-Brunet
 * @author Malgorzata Michalska
 *
 */
public class AtomicActor extends Atomic<PortValue> {

	// ----- THE OVERALL PORT ID MAP
	private Map<Integer, Buffer> BUFFERS_PORTS_ID_MAP;

	// ----- THE OUTPUT INTERFACE PORTS IDS
	private Map<Buffer, Integer> PORT_OUT_SEND_HAS_SPACE;
	private Map<Buffer, Integer> PORT_OUT_RECEIVE_HAS_SPACE;
	private Map<Buffer, Integer> PORT_OUT_SEND_TOKENS;
	private Map<Buffer, Integer> PORT_OUT_RECEIVE_TOKENS_RECEIVED;

	// ---- THE INPUT INTERFACE PORTS IDS
	private Map<Buffer, Integer> PORT_IN_SEND_HAS_TOKENS;
	private Map<Buffer, Integer> PORT_IN_RECEIVE_HAS_TOKENS;
	private Map<Buffer, Integer> PORT_IN_SEND_ASK_TOKENS;
	private Map<Buffer, Integer> PORT_IN_RECEIVE_TOKENS;
	private Map<Buffer, Integer> PORT_IN_RELEASE_BUFFER;

	// --- THE PARTITIONER SCHEDULER PORT
	/** the number of reserved ports (used by the scheduler) */
	public static final int RESERVED_PARTITION_PORTS = 10;
	public static final int PORT_PARTITION_RECEIVE_ASK_SCHEDULABILITY = 0;
	public static final int PORT_PARTITION_SEND_SCHEDULABILITY = 1;
	public static final int PORT_PARTITION_RECEIVE_ENABLE = 2;
	public static final int PORT_PARTITION_SEND_END_OF_FIRING = 3;
	public static final int PORT_PARTITION_SEND_END_OF_READING = 4;
	public static final int PORT_PARTITION_RECEIVE_CORE = 5;

	public enum Status {
		DISABLED, SEND_HAS_TOKENS, AWAIT_HAS_TOKENS, BLOCKED_READING, SEND_HAS_SPACE, AWAIT_HAS_SPACE, BLOCKED_WRITING,
		SEND_SCHEDULABLE, SCHEDULABLE, SCHEDULE_ACTION, READING, AWAIT_TOKENS, RELEASE_BUFFERS, PROCESSING, WRITING,
		AWAIT_END_CONFIRMATION, END_FIRING, TERMINATED;
	}

	/** the actor local time */
	private double localTime = 0;

	private ProgressPrinter progressPrinter;
	private AdevsDataLogger dataLogger;

	private final Actor actor;

	private Iterator<Step> steps;

	private SchedulingWeight schedulingWeight;
	private TraceWeighter traceWeighter;
	private TraceDecorator traceDecorator;

	private Step currentStep;
	private Action currentAction;

	private Action lastExecutedAction;
	private Action lastActionFromPartition;

	private long firedSteps;

	private Map<Buffer, Boolean> in_hasTokens;
	private Map<Buffer, Integer> out_missingSpace;
	private HashMultiset<Buffer> in_tokensToRead;
	private HashMultiset<Buffer> out_tokensToWrite;
	private Set<Buffer> buffersToRelease;

	private int incomingBuffersNumber;
	private int outgoingBuffersNumber;

	private int writtenBuffers;

	private Status status;
	private boolean sendEndReading; // if the option below is false, this one
									// should remain always false
	private boolean releaseAfterProcessing = false;

	// table used to store unprofiled transitions
	private Set<Action> unprofiledDirectTransitions;
	private Map<Action, Set<Action>> unprofiledJumpTransitions;

	private int attributedCore;

	public AtomicActor(Actor actor, Iterator<Step> steps, TraceWeighter traceWeighter,
			SchedulingWeight schedulingWeight, TraceDecorator traceDecorator) {
		this.actor = actor;
		this.steps = steps;
		this.traceWeighter = traceWeighter;
		this.schedulingWeight = schedulingWeight;
		this.traceDecorator = traceDecorator;

		init();
	}

	public AtomicActor(Actor actor, Iterator<Step> steps, TraceWeighter traceWeighter, TraceDecorator traceDecorator) {
		this.actor = actor;
		this.steps = steps;
		this.traceWeighter = traceWeighter;
		this.traceDecorator = traceDecorator;

		init();
	}

	private void init() {
		in_hasTokens = new HashMap<>();
		out_missingSpace = new HashMap<>();
		buffersToRelease = new HashSet<Buffer>();

		// init the unprofiled transitions maps
		unprofiledDirectTransitions = new HashSet<>();
		unprofiledJumpTransitions = new HashMap<>();
		for (Action action : actor.getActions()) {
			unprofiledJumpTransitions.put(action, new HashSet<>());
		}

		incomingBuffersNumber = 0;
		outgoingBuffersNumber = 0;

		writtenBuffers = 0;

		status = Status.DISABLED;
		sendEndReading = false;
		firedSteps = 0;
		loadNextStep();
	}

	public void configure(PortsIdentifier portIds) {
		BUFFERS_PORTS_ID_MAP = portIds.BUFFERS_PORTS_ID_MAP;
		PORT_OUT_SEND_HAS_SPACE = portIds.PORT_OUT_SEND_HAS_SPACE;
		PORT_OUT_RECEIVE_HAS_SPACE = portIds.PORT_OUT_RECEIVE_HAS_SPACE;
		PORT_OUT_SEND_TOKENS = portIds.PORT_OUT_SEND_TOKENS;
		PORT_OUT_RECEIVE_TOKENS_RECEIVED = portIds.PORT_OUT_RECEIVE_TOKENS_RECEIVED;
		PORT_IN_SEND_HAS_TOKENS = portIds.PORT_IN_SEND_HAS_TOKENS;
		PORT_IN_RECEIVE_HAS_TOKENS = portIds.PORT_IN_RECEIVE_HAS_TOKENS;
		PORT_IN_SEND_ASK_TOKENS = portIds.PORT_IN_SEND_ASK_TOKENS;
		PORT_IN_RECEIVE_TOKENS = portIds.PORT_IN_RECEIVE_TOKENS;
		PORT_IN_RELEASE_BUFFER = portIds.PORT_IN_RELEASE_BUFFER;
	}

	@Override
	public void delta_conf(Collection<PortValue> xb) {
		// Logger.debug("delta_conf at %f : actor=%s", localTime,
		// actor.toString());
		delta_int();
		delta_ext(0.0, xb);
	}

	@Override
	public void delta_int() {
		// Logger.debug("delta_int at %f : actor=%s", localTime,
		// actor.toString());

		switch (status) {
		case SCHEDULE_ACTION: {
			localTime += ta();
			status = Status.READING;

			break;
		}

		case READING: {
			localTime += ta();
			if (in_tokensToRead.isEmpty()) { // a firing requires no input = no
												// reading, no buffer release,
												// go directly to processing
				dataLogger.logStartProcessing(currentAction, currentStep.getId(), localTime);
				status = Status.PROCESSING;
			}

			break;
		}

		case PROCESSING: {
			localTime += ta();
			dataLogger.logEndProcessing(currentAction, currentStep.getId(), localTime);
			dataLogger.logEndProcessingWithCore(currentAction, currentStep.getId(), attributedCore, localTime);
			if (releaseAfterProcessing && !buffersToRelease.isEmpty()) {
				status = Status.RELEASE_BUFFERS;
			} else if (out_tokensToWrite.isEmpty()) { // no writing required
				dataLogger.logEndFiring(currentAction, currentStep.getId(), localTime);
				status = Status.END_FIRING;
			} else { // writing must be done
				outgoingBuffersNumber = out_tokensToWrite.elementSet().size();
				dataLogger.logStartProducing(currentAction, currentStep.getId(), localTime);
				status = Status.WRITING;
			}
			break;
		}

		case RELEASE_BUFFERS: {
			localTime += ta();
			if (!releaseAfterProcessing) {
				dataLogger.logStartProcessing(currentAction, currentStep.getId(), localTime);
				status = Status.PROCESSING;
			}

			break;
		}

		default:
			break;
		}
	}

	/**
	 * Load the next step. currentStep is updated
	 */
	private void loadNextStep() {
		lastExecutedAction = currentAction;
		if (steps.hasNext()) {
			currentStep = steps.next();

			// update also the current actions and tokens maps
			currentAction = traceDecorator.getAction(currentStep);
			in_tokensToRead = traceDecorator.getReadTokensAsSet(currentStep);
			out_tokensToWrite = traceDecorator.getWriteTokensAsSet(currentStep);
		} else {
			currentStep = null;
			currentAction = null;
			in_tokensToRead = null;
			out_tokensToWrite = null;
		}
	}

	/**
	 * Returns true if there are no more steps to be scheduled
	 * 
	 * @return
	 */
	private boolean hasFinished() {
		return currentStep == null;
	}

	@Override
	public void delta_ext(double e, Collection<PortValue> xb) {
		// Logger.debug("delta_ext at %f : actor=%s", localTime,
		// actor.toString());
		localTime += e;

		for (PortValue inPortValue : xb) {
			int port = inPortValue.getPort();
			if (port == PORT_PARTITION_RECEIVE_ENABLE && status == Status.SCHEDULABLE) {
				dataLogger.logIsEnabled(currentAction, currentStep.getId(), localTime);
				@SuppressWarnings("unchecked")
				Pair<Optional<Action>, Integer> actionCore = (Pair<Optional<Action>, Integer>) inPortValue.getValue();
				Optional<Action> action = actionCore.v1;
				if(action.isEmpty()) {
					lastActionFromPartition = null;
				}else {					
					lastActionFromPartition = actionCore.v1.get();
				}
				attributedCore = actionCore.v2;
				status = Status.SCHEDULE_ACTION;
			} else if (port == PORT_PARTITION_RECEIVE_ASK_SCHEDULABILITY) {
				if (status == Status.DISABLED) {
					if (in_tokensToRead.isEmpty()) {
						if (!out_tokensToWrite.isEmpty()) {
							outgoingBuffersNumber = out_tokensToWrite.elementSet().size();
							status = Status.SEND_HAS_SPACE;
						} else {
							dataLogger.logIsSchedulable(currentAction, currentStep.getId(), localTime);
							status = Status.SEND_SCHEDULABLE;
						}
					} else {
						incomingBuffersNumber = in_tokensToRead.elementSet().size();
						status = Status.SEND_HAS_TOKENS;
					}
				}
			} else {
				Buffer buffer = BUFFERS_PORTS_ID_MAP.get(port);
				if (port == PORT_IN_RECEIVE_HAS_TOKENS.get(buffer)) {
					if (status == Status.AWAIT_HAS_TOKENS) {
						boolean hasTokens = (boolean) inPortValue.getValue();
						in_hasTokens.put(buffer, hasTokens);
						if (in_hasTokens.size() == incomingBuffersNumber) {
							dataLogger.logCheckedConditions(currentAction, currentStep.getId(), incomingBuffersNumber,
									true, localTime);
							if (!in_hasTokens.containsValue(false)) {
								dataLogger.logFailedConditions(currentAction, currentStep.getId(), 0, true, localTime);
								if (!out_tokensToWrite.isEmpty()) {
									outgoingBuffersNumber = out_tokensToWrite.elementSet().size();
									status = Status.SEND_HAS_SPACE;
								} else {
									dataLogger.logIsSchedulable(currentAction, currentStep.getId(), localTime);
									status = Status.SEND_SCHEDULABLE;
								}
							} else {
								status = Status.BLOCKED_READING;
							}
						}
					}
				} else if (port == PORT_IN_RECEIVE_TOKENS.get(buffer)) {
					if (status == Status.AWAIT_TOKENS) {
						int tokens = (int) inPortValue.getValue();
						dataLogger.logConsumeTokens(currentAction, currentStep.getId(), buffer, tokens, localTime);
						in_tokensToRead.remove(buffer, tokens);
						buffersToRelease.add(buffer);
						if (in_tokensToRead.isEmpty()) {
							if (releaseAfterProcessing) {
								dataLogger.logStartProcessing(currentAction, currentStep.getId(), localTime);
								status = Status.PROCESSING;
							} else { // TODO: it should react every time a
										// reading from fifo is finished (now
										// only when ALL)
								sendEndReading = true;
								status = Status.RELEASE_BUFFERS;
							}
						}
					}
				} else if (port == PORT_OUT_RECEIVE_HAS_SPACE.get(buffer)) {
					if (status == Status.AWAIT_HAS_SPACE) {
						out_missingSpace.put(buffer, (int) inPortValue.getValue());
						if (out_missingSpace.size() == outgoingBuffersNumber) {
							dataLogger.logCheckedConditions(currentAction, currentStep.getId(), outgoingBuffersNumber,
									false, localTime);
							boolean hasSpace = true;
							for (int tokens : out_missingSpace.values()) {
								if (tokens > 0) {
									hasSpace = false;
									break;
								}
							}
							if (hasSpace) {
								dataLogger.logIsSchedulable(currentAction, currentStep.getId(), localTime);
								dataLogger.logFailedConditions(currentAction, currentStep.getId(), 0, false, localTime);
								status = Status.SEND_SCHEDULABLE;
							} else {
								status = Status.BLOCKED_WRITING;
							}
						}
					}
				} else if (port == PORT_OUT_RECEIVE_TOKENS_RECEIVED.get(buffer)) {
					if (status == Status.AWAIT_END_CONFIRMATION) {
						writtenBuffers++;
						if (writtenBuffers == out_tokensToWrite.elementSet().size()) {
							dataLogger.logEndFiring(currentAction, currentStep.getId(), localTime);
							status = Status.END_FIRING;
						}
					}
				}
			}
		}
	}

	@Override
	public void output_func(Collection<PortValue> yb) {
		// Logger.debug("output_func at %f : actor=%s", localTime,
		// actor.toString());

		switch (status) {
		case SEND_HAS_TOKENS: {
			for (Entry<Buffer> tokensToRead : in_tokensToRead.entrySet()) {
				int port = PORT_IN_SEND_HAS_TOKENS.get(tokensToRead.getElement());
				int tokens = tokensToRead.getCount();
				yb.add(new PortValue(port, tokens));
			}
			in_hasTokens.clear();
			status = Status.AWAIT_HAS_TOKENS;
			break;
		}

		case BLOCKED_READING: {
			int conditionsFailed = 0;
			for (Map.Entry<Buffer, Boolean> eb : in_hasTokens.entrySet()) {
				if (!eb.getValue()) {
					conditionsFailed++;
					dataLogger.logBlockedReading(currentAction, currentStep.getId(), localTime, eb.getKey());
				}
			}
			dataLogger.logFailedConditions(currentAction, currentStep.getId(), conditionsFailed, true, localTime);
			yb.add(new PortValue(PORT_PARTITION_SEND_SCHEDULABILITY, 1));
			status = Status.DISABLED;
			break;
		}

		case SEND_HAS_SPACE: {
			for (Entry<Buffer> tokensToSend : out_tokensToWrite.entrySet()) {
				int port = PORT_OUT_SEND_HAS_SPACE.get(tokensToSend.getElement());
				int tokens = tokensToSend.getCount();
				yb.add(new PortValue(port, tokens));
			}
			out_missingSpace.clear();
			status = Status.AWAIT_HAS_SPACE;
			break;
		}

		case BLOCKED_WRITING: {
			int conditionsFailed = 0;
			for (Map.Entry<Buffer, Integer> eb : out_missingSpace.entrySet()) {
				int missingSpace = eb.getValue();
				if (missingSpace > 0) {
					Buffer buffer = eb.getKey();
					conditionsFailed++;
					dataLogger.logBlockedWriting(currentAction, currentStep.getId(), localTime, buffer, missingSpace);
				}
			}
			dataLogger.logFailedConditions(currentAction, currentStep.getId(), conditionsFailed, false, localTime);
			yb.add(new PortValue(PORT_PARTITION_SEND_SCHEDULABILITY, 2));
			status = Status.DISABLED;
			break;
		}

		case READING: {
			for (Entry<Buffer> tokensToRead : in_tokensToRead.entrySet()) {
				int port = PORT_IN_SEND_ASK_TOKENS.get(tokensToRead.getElement());
				int tokens = tokensToRead.getCount();
				yb.add(new PortValue(port, tokens));
			}
			if (!in_tokensToRead.isEmpty()) {
				status = Status.AWAIT_TOKENS;
			}
			break;
		}

		case RELEASE_BUFFERS: {
			if (sendEndReading) { // notify partition that reading is done (only
									// in the default mode)
				yb.add(new PortValue(PORT_PARTITION_SEND_END_OF_READING, true));
			}

			for (Buffer buffer : buffersToRelease) {
				int port = PORT_IN_RELEASE_BUFFER.get(buffer);
				yb.add(new PortValue(port, true));
			}
			buffersToRelease.clear();

			if (releaseAfterProcessing) {
				if (out_tokensToWrite.isEmpty()) { // no writing required
					dataLogger.logEndFiring(currentAction, currentStep.getId(), localTime);
					status = Status.END_FIRING;
				} else { // writing must be done
					outgoingBuffersNumber = out_tokensToWrite.elementSet().size();
					dataLogger.logStartProducing(currentAction, currentStep.getId(), localTime);
					status = Status.WRITING;
				}
			}

			break;
		}

		case WRITING: {
			Map<Buffer, Integer> outputTokens = traceDecorator.getWriteTokens(currentStep);
			if (outputTokens.isEmpty()) {
				dataLogger.logEndFiring(currentAction, currentStep.getId(), localTime);
				status = Status.END_FIRING;
			} else {
				for (Map.Entry<Buffer, Integer> eb : outputTokens.entrySet()) {
					Buffer buffer = eb.getKey();
					int count = eb.getValue();
					int port = PORT_OUT_SEND_TOKENS.get(buffer);
					yb.add(new PortValue(port, count));
					dataLogger.logProduceTokens(currentAction, currentStep.getId(), buffer, count, localTime);
				}
				writtenBuffers = 0;
				status = Status.AWAIT_END_CONFIRMATION;
			}
			break;
		}

		case END_FIRING: {
			firedSteps++;
			loadNextStep();
			// data to send to partition: last executed action and true/false if
			// the actor has finished
			Object[] endData = new Object[2];
			endData[0] = lastExecutedAction;
			if (hasFinished()) {
				endData[1] = false;
				yb.add(new PortValue(PORT_PARTITION_SEND_END_OF_FIRING, endData));
				status = Status.TERMINATED;
			} else {
				// send positive end of firing if the actor hasn't terminated
				endData[1] = true;
				yb.add(new PortValue(PORT_PARTITION_SEND_END_OF_FIRING, endData));
				status = Status.DISABLED;
			}
			progressPrinter.increment();
			break;
		}

		case SEND_SCHEDULABLE: {
			yb.add(new PortValue(PORT_PARTITION_SEND_SCHEDULABILITY, 0));
			status = Status.SCHEDULABLE;
			break;
		}

		default:
			break;
		}
	}

	@Override
	public double ta() {
		switch (status) {
		case SEND_HAS_TOKENS:
			return 0;
		case AWAIT_HAS_TOKENS:
			return Double.MAX_VALUE;
		case BLOCKED_READING:
			return 0;
		case SEND_HAS_SPACE:
			return 0;
		case AWAIT_HAS_SPACE:
			return Double.MAX_VALUE;
		case BLOCKED_WRITING:
			return 0;
		case SEND_SCHEDULABLE:
			return 0;
		case SCHEDULABLE:
			return Double.MAX_VALUE;
		case SCHEDULE_ACTION:
			return getSchedulingCost();
		case READING:
			return 0;
		case AWAIT_TOKENS:
			return Double.MAX_VALUE;
		case RELEASE_BUFFERS:
			return 0;
		case PROCESSING:
			double weight = traceWeighter.getWeight(currentStep);
			if (weight < 0)
				try {
					throw new TurnusException("Negative weight of a step: " + currentStep);
				} catch (TurnusException e) {
					e.printStackTrace();
				}
			return traceWeighter.getWeight(currentStep);
		case WRITING:
			return 0;
		case AWAIT_END_CONFIRMATION:
			return Double.MAX_VALUE;
		case END_FIRING:
			return 0;
		case TERMINATED:
			return Double.MAX_VALUE;
		default:
			break;
		}

		return Double.MAX_VALUE;
	}

	private double getSchedulingCost() {
		if (schedulingWeight == null) {
			return 0;
		} else if (lastActionFromPartition == null || lastActionFromPartition.getOwner() != actor) {
			if (schedulingWeight.contains(actor.getName(), currentAction.getName())) {
				return schedulingWeight.getWeight(actor.getName(), currentAction.getName()).getMeanClockCycles();
			} else if (!unprofiledDirectTransitions.contains(currentAction)) {
				unprofiledDirectTransitions.add(currentAction);
				Logger.warning(
						"No transition found for actor " + actor.getName() + ", action " + currentAction.getName());
			}

			return 0;
		} else {
			if (schedulingWeight.contains(actor.getName(), lastActionFromPartition.getName(),
					currentAction.getName())) {
				return schedulingWeight
						.getWeight(actor.getName(), lastActionFromPartition.getName(), currentAction.getName())
						.getMeanClockCycles();
			} else if (!unprofiledJumpTransitions.get(lastActionFromPartition).contains(currentAction)) {
				unprofiledJumpTransitions.get(lastActionFromPartition).add(currentAction);
				Logger.warning("No transition found for actor " + actor.getName() + ", action "
						+ currentAction.getName() + ", source action " + lastActionFromPartition.getName());
			}

			return 0;
		}
	}

	public Actor getActor() {
		return actor;
	}

	public Action getCurrentAction() {
		return currentAction;
	}

	public Status getCurrentStatus() {
		return status;
	}

	public Action getLastExecutedAction() {
		return lastExecutedAction;
	}

	public long getFiredStepsNumber() {
		return firedSteps;
	}

	public void setReleaseAfterProcessinng() {
		this.releaseAfterProcessing = true;
	}

	public void setProgressPrinter(ProgressPrinter progressPrinter) {
		this.progressPrinter = progressPrinter;
	}

	public void setDataLogger(AdevsDataLogger dataLogger) {
		this.dataLogger = dataLogger;
	}
}

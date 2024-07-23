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
package turnus.adevs.schedulers;

import java.util.*;

import turnus.adevs.model.AtomicActorPartition;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.trace.Step;
import turnus.model.trace.TraceProject;
import turnus.model.trace.Trace.Order;
import turnus.model.dataflow.util.ActorsSorter;

/**
 * 
 * @author Raphael S. Steiner
 * @author Endri Bezati
 *
 */
public class DiscrepancyMaxLocalChildren extends AtomicActorPartition {

	public class DiscrepancyPriorityQuadruple implements Comparable<DiscrepancyPriorityQuadruple> {
		private final Actor first;
		private final Long second;
		private final Long third;
		private final Long fourth;

		public DiscrepancyPriorityQuadruple(Actor first, Long second, Long third, Long fourth) {
			this.first = first;
			this.second = second;
			this.third = third;
			this.fourth = fourth;
		}

		public Actor getFirst() {
			return first;
		}

		public Long getSecond() {
			return second;
		}

		public Long getThird() {
			return third;
		}
		
		public Long getFourth() {
			return fourth;
		}

		@Override
		public int compareTo(DiscrepancyPriorityQuadruple other) {
			int cmp = Long.compare(second, other.second);
			if (cmp == 0) {
				cmp = Long.compare(third, other.third);
				if (cmp == 0) {
					cmp = Long.compare(fourth, other.fourth);
				}
			}
			return cmp;
		}
	}

	private List<Actor> actorsToExecute = new ArrayList<>();

	private Map<Actor, Long> current_discrepancy;
	private Map<Actor, Long> discrepancy_increments;
	private Long discrepancy_increment_sum;
	
	private List<Actor> top_order_all_actors;

	public DiscrepancyMaxLocalChildren(List<Actor> actors, String partitionId, int processingElements, TraceProject traceProject) {
		super(actors, partitionId, processingElements);
		top_order_all_actors = new ArrayList<Actor>();
		for (Actor actor : ActorsSorter.topologicalOrder(traceProject.getNetwork().getActors())) {
				top_order_all_actors.add(actor);
		}
		discrepancy_increments = new HashMap<Actor, Long>();
		for (Actor actor : actors) {
			Iterator<Step> steps = traceProject.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();

			long c = 0;
			while (steps.hasNext()) {
				steps.next();
				c++;
			}
			discrepancy_increments.put(actor, c);
		}

		current_discrepancy = new HashMap<Actor, Long>();
		for (Actor actor : actors) {
			current_discrepancy.put(actor, 0L);
		}

		discrepancy_increment_sum = 0L;
		for (Long incr : discrepancy_increments.values()) {
			discrepancy_increment_sum += incr;
		}
	}

	@Override
	public List<Actor> getSchedulables() {

		Map<Actor, Long> maxChildCurrentDiscrepancy = new HashMap<Actor, Long>();
		ListIterator<Actor> rev_top_order_iter = top_order_all_actors.listIterator(top_order_all_actors.size());
		while (rev_top_order_iter.hasPrevious()) {
			Actor actor = rev_top_order_iter.previous();
			
			maxChildCurrentDiscrepancy.put(actor, current_discrepancy.get(actor));
			for (Buffer out_buffer : actor.getOutgoingBuffers()) {
				Actor chld = out_buffer.getTarget().getOwner();
				if (maxChildCurrentDiscrepancy.get(actor) == null) {
					maxChildCurrentDiscrepancy.put(actor, maxChildCurrentDiscrepancy.get(chld));
				} else if (maxChildCurrentDiscrepancy.get(chld) != null) {
					maxChildCurrentDiscrepancy.put(actor,
							Math.max(maxChildCurrentDiscrepancy.get(actor), maxChildCurrentDiscrepancy.get(chld)));
				}
			}
		}
		
		actorsToExecute.clear();
		List<DiscrepancyPriorityQuadruple> schedulableActorsPriority = new ArrayList<DiscrepancyPriorityQuadruple>();
		if (!schedulableActors.isEmpty()) {
			for (Actor act : schedulableActors) {
				DiscrepancyPriorityQuadruple quad = new DiscrepancyPriorityQuadruple(
						act,
						maxChildCurrentDiscrepancy.get(act),
						current_discrepancy.get(act),
						discrepancy_increments.get(act)
						);
				schedulableActorsPriority.add(quad);
			}
			Actor next = Collections.max(schedulableActorsPriority).getFirst();
			for (Actor actor : discrepancy_increments.keySet()) {
				current_discrepancy.put(actor, current_discrepancy.get(actor) + discrepancy_increments.get(actor));
				if (actor == next) {
					current_discrepancy.put(actor, current_discrepancy.get(actor) - discrepancy_increment_sum);
				}
			}
			actorsToExecute.add(next);
		}
		return actorsToExecute;
	}

	@Override
	public boolean canExecute() {
		return runningActors.isEmpty();
	}

}

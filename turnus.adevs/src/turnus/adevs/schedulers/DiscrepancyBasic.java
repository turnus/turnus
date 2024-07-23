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
import turnus.model.trace.Step;
import turnus.model.trace.TraceProject;
import turnus.model.trace.Trace.Order;

/**
 * 
 * @author Raphael S. Steiner
 * @author Endri Bezati
 *
 */
public class DiscrepancyBasic extends AtomicActorPartition {

	public class DiscrepancyPriorityTriple implements Comparable<DiscrepancyPriorityTriple> {
		private final Actor first;
		private final Long second;
		private final Long third;

		public DiscrepancyPriorityTriple(Actor first, Long second, Long third) {
			this.first = first;
			this.second = second;
			this.third = third;
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

		@Override
		public int compareTo(DiscrepancyPriorityTriple other) {
			int cmp = Long.compare(second, other.second);
			if (cmp == 0) {
				return Long.compare(third, other.third);
			} else {
				return cmp;
			}
		}
	}

	private List<Actor> actorsToExecute = new ArrayList<>();

	private Map<Actor, Long> current_discrepancy;
	private Map<Actor, Long> discrepancy_increments;
	private Long discrepancy_increment_sum;

	public DiscrepancyBasic(List<Actor> actors, String partitionId, int processingElements, TraceProject traceProject) {
		super(actors, partitionId, processingElements);
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

		actorsToExecute.clear();
		List<DiscrepancyPriorityTriple> schedulableActorsPriority = new ArrayList<DiscrepancyPriorityTriple>();
		if (!schedulableActors.isEmpty()) {
			for (Actor act : schedulableActors) {
				DiscrepancyPriorityTriple triple = new DiscrepancyPriorityTriple(act,
						current_discrepancy.get(act), discrepancy_increments.get(act));
				schedulableActorsPriority.add(triple);
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

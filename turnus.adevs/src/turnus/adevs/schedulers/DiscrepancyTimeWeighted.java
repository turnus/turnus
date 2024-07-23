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
import java.math.BigDecimal;
import java.math.BigInteger;

import turnus.adevs.model.AtomicActorPartition;
import turnus.model.dataflow.Actor;
import turnus.model.trace.Step;
import turnus.model.trace.TraceProject;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Raphael S. Steiner
 * @author Endri Bezati
 *
 */
public class DiscrepancyTimeWeighted extends AtomicActorPartition {

	public class DiscrepancyPriorityTriple implements Comparable<DiscrepancyPriorityTriple> {
		private final Actor first;
		private final BigInteger second;
		private final BigInteger third;

		public DiscrepancyPriorityTriple(Actor first, BigInteger second, BigInteger third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}

		public Actor getFirst() {
			return first;
		}

		public BigInteger getSecond() {
			return second;
		}

		public BigInteger getThird() {
			return third;
		}

		@Override
		public int compareTo(DiscrepancyPriorityTriple other) {
			int cmp = second.compareTo(other.second);
			if (cmp == 0) {
				return third.compareTo(other.third);
			} else {
				return cmp;
			}
		}
	}

	private List<Actor> actorsToExecute = new ArrayList<>();

	private Map<Actor, BigInteger> actor_avg_weight;
	private Map<Actor, BigInteger> actor_frequency;
	private Map<Actor, BigInteger> current_discrepancy;
	private BigInteger discrepancy_increment_sum;


	public DiscrepancyTimeWeighted(List<Actor> actors, String partitionId, int processingElements, TraceProject traceProject, TraceWeighter traceWeighter) {
		super(actors, partitionId, processingElements);
		actor_avg_weight = new HashMap<Actor, BigInteger>();
		actor_frequency = new HashMap<Actor, BigInteger>();
		for (Actor actor : actors) {
			Iterator<Step> steps = traceProject.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double weight = 0.0d;
			long c = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				weight += traceWeighter.getWeight(next);
				c++;
			}
			BigInteger integral_weight = BigDecimal.valueOf(Math.ceil(weight/c)).toBigInteger(); 
			actor_avg_weight.put(actor, integral_weight);
			actor_frequency.put(actor, BigInteger.valueOf(c));
		}

		current_discrepancy = new HashMap<Actor, BigInteger>();
		for (Actor actor : actors) {
			current_discrepancy.put(actor, BigInteger.ZERO);
		}

		discrepancy_increment_sum = BigInteger.ZERO;
		for (Actor actor : actors) {
			discrepancy_increment_sum = discrepancy_increment_sum.add( actor_frequency.get(actor).multiply(actor_avg_weight.get(actor))  );
		}
	}

	@Override
	public List<Actor> getSchedulables() {

		actorsToExecute.clear();
		List<DiscrepancyPriorityTriple> schedulableActorsPriority = new ArrayList<DiscrepancyPriorityTriple>();
		if (!schedulableActors.isEmpty()) {
			for (Actor actor : schedulableActors) {
				DiscrepancyPriorityTriple triple = new DiscrepancyPriorityTriple(actor,
						current_discrepancy.get(actor), actor_frequency.get(actor).multiply(actor_avg_weight.get(actor)));
				schedulableActorsPriority.add(triple);
			}
			Actor next = Collections.max(schedulableActorsPriority).getFirst();
			for (Actor actor : actor_frequency.keySet()) {
				current_discrepancy.put(actor, current_discrepancy.get(actor).add( actor_avg_weight.get(next).multiply( actor_frequency.get(actor).multiply( actor_avg_weight.get(actor))) ));
				if (actor == next) {
					current_discrepancy.put(actor, current_discrepancy.get(actor).subtract(actor_avg_weight.get(actor).multiply(discrepancy_increment_sum)));
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

	@Override
	public int processingElements() {
		return 1;
	}

}

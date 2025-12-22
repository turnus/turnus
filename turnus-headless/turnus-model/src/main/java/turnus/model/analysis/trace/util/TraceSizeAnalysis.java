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
package turnus.model.analysis.trace.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import turnus.common.util.Pair;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.trace.Dependency.Kind;

/**
 * This class defines the {@link TraceSizeReport} analysis. For each actor and
 * action contains the number of firings and dependencies contained in the
 * execution trace graph. It sorts the values according to the number of firings
 * 
 * @author Simone Casale Brunet
 *
 */
public class TraceSizeAnalysis {

	/**
	 * The trace size information for each actor
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public class ActorTraceSize extends Size<Actor> {

		private List<ActionTraceSize> actionsData = new ArrayList<>();

		private final Actor actor;

		public ActorTraceSize(Actor actor, long firings, long incomings, long outgoings) {
			super(firings, incomings, outgoings);
			this.actor = actor;
		}

		public List<ActionTraceSize> getActionsData() {
			return actionsData;
		}

		public Actor getActor() {
			return actor;
		}

	}

	/**
	 * The trace size information for each action
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public class ActionTraceSize extends Size<Action> {
		private final Action action;

		public ActionTraceSize(Action action, long firings, long incomings, long outgoings) {
			super(firings, incomings, outgoings);
			this.action = action;
		}

		public Action getAction() {
			return action;
		}

	}

	public class Size<T> implements Comparable<Size<T>> {

		/** firings: count // percentage */
		private Pair<Long, Double> pfirings;
		/** incomings: count // percentage */
		private Pair<Long, Double> pincomings;
		/** ougoings: count // percentage */
		private Pair<Long, Double> poutgoings;

		private Size(long firings, long incomings, long outgoings) {
			double p = ((double) firings / totalFirings) * 100;
			pfirings = Pair.create(firings, p);

			p = ((double) incomings / totalDependencies) * 100;
			pincomings = Pair.create(incomings, p);

			p = ((double) outgoings / totalDependencies) * 100;
			poutgoings = Pair.create(outgoings, p);
		}

		/**
		 * Get the number of firings: count // percentage (on the overall)
		 * 
		 * @return
		 */
		public Pair<Long, Double> getFirings() {
			return pfirings;
		}

		/**
		 * Get the number of incomings: count // percentage (on the overall)
		 * 
		 * @return
		 */
		public Pair<Long, Double> getIncomings() {
			return pincomings;
		}

		/**
		 * Get the number of outgoings: count // percentage (on the overall)
		 * 
		 * @return
		 */
		public Pair<Long, Double> getOutgoings() {
			return poutgoings;
		}

		@Override
		public int compareTo(Size<T> o) {
			return o.pfirings.v1.compareTo(pfirings.v1);
		}

	}

	private class DepKindComparator implements Comparator<Kind> {

		Map<Kind, Pair<Long, Double>> base;

		public DepKindComparator(Map<Kind, Pair<Long, Double>> base) {
			this.base = base;
		}

		public int compare(Kind a, Kind b) {
			return -base.get(a).v1.compareTo(base.get(b).v1);
		}
	}

	private final Network network;
	private final long totalFirings;
	private final long totalDependencies;
	private Map<Kind, Pair<Long, Double>> dependenciesKind;
	private List<ActorTraceSize> actorsData = new ArrayList<>();

	public TraceSizeAnalysis(TraceSizeReport data) {
		network = data.getNetwork();
		totalFirings = data.getFirings();
		totalDependencies = data.getDependencies();

		Map<String, Long> kindDeps = data.getDependenciesKinds();
		Map<Kind, Pair<Long, Double>> tempDependenciesKind = new HashMap<>();
		for (Kind k : Kind.values()) {
			long deps = kindDeps.containsKey(k.literal()) ? kindDeps.get(k.literal()) : 0;
			double p = ((double) deps / totalDependencies) * 100;
			tempDependenciesKind.put(k, Pair.create(deps, p));
		}

		dependenciesKind = new TreeMap<>(new DepKindComparator(tempDependenciesKind));
		dependenciesKind.putAll(tempDependenciesKind);

		Map<Actor, Long> actorsFirs = data.getActorsFirings();
		Map<Actor, Long> actorsIncs = data.getActorsIncoming();
		Map<Actor, Long> actorsOuts = data.getActorsOutgoings();

		Map<Action, Long> actionsFirs = data.getActionsFirings();
		Map<Action, Long> actionsIncs = data.getActionsIncomings();
		Map<Action, Long> actionsOuts = data.getActionsOutgoings();

		for (Actor actor : network.getActors()) {

			long actorFirs = actorsFirs.containsKey(actor) ? actorsFirs.get(actor) : 0;
			long actorIncs = actorsIncs.containsKey(actor) ? actorsIncs.get(actor) : 0;
			long actorOuts = actorsOuts.containsKey(actor) ? actorsOuts.get(actor) : 0;

			ActorTraceSize actorSize = new ActorTraceSize(actor, actorFirs, actorIncs, actorOuts);
			actorsData.add(actorSize);

			for (Action action : actor.getActions()) {

				long actionFirs = actionsFirs.containsKey(action) ? actionsFirs.get(action) : 0;
				long actionIncs = actionsIncs.containsKey(action) ? actionsIncs.get(action) : 0;
				long actionOuts = actionsOuts.containsKey(action) ? actionsOuts.get(action) : 0;

				ActionTraceSize actionSize = new ActionTraceSize(action, actionFirs, actionIncs, actionOuts);
				actorSize.actionsData.add(actionSize);
			}

			Collections.sort(actorSize.actionsData);

		}

		Collections.sort(actorsData);

	}

	public Network getNetwork() {
		return network;
	}

	public long getFirings() {
		return totalFirings;
	}

	public long getDependencies() {
		return totalDependencies;
	}

	public Map<Kind, Pair<Long, Double>> getDependenciesKind() {
		return dependenciesKind;
	}

	public List<ActorTraceSize> getActorsData() {
		return actorsData;
	}

}

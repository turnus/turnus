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
package turnus.analysis.partitioning.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.MathUtils;
import turnus.common.util.Pair;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class KernighanLinPartitioner {

	public class KlPartition {

		private final Collection<Actor> actors = new HashSet<>();
		private final Map<Actor, Long> internalCostMap = new HashMap<>();
		private final Map<Actor, Long> externalCostMap = new HashMap<>();

		private KlPartition(Collection<Actor> A) {
			actors.addAll(A);

			// evaluate costs
			for (Actor a : actors) {
				long totInternal = 0;
				long totExternal = 0;

				for (Buffer buffer : a.getIncomingBuffers()) {
					Actor source = buffer.getSource().getOwner();
					if (A.contains(source)) {
						totInternal += getCost(buffer);
					} else {
						totExternal += getCost(buffer);
					}
				}

				for (Buffer buffer : a.getOutgoingBuffers()) {
					Actor target = buffer.getTarget().getOwner();
					if (A.contains(target)) {
						totInternal += getCost(buffer);
					} else {
						totExternal += getCost(buffer);
					}
				}

				internalCostMap.put(a, totInternal);
				externalCostMap.put(a, totExternal);
			}
		}

		public Collection<Actor> getActors() {
			return actors;
		}

		public Map<Actor, Long> getInternalCostMap() {
			return internalCostMap;
		}

		public Map<Actor, Long> getExternalCostMap() {
			return externalCostMap;
		}

		public long getInternalCost() {
			return MathUtils.sumLong(internalCostMap);
		}

		public long getExternalCost() {
			return MathUtils.sumLong(externalCostMap);
		} 

	}

	private class Swapper {

		long g = 0;
		List<Pair<Actor, Actor>> swaps = new ArrayList<>();

		Map<Actor, Long> internalCost = new HashMap<>();
		Map<Actor, Long> externalCost = new HashMap<>();
		Map<Actor, Long> dCost = new HashMap<>();

		Swapper(Collection<Actor> A, Collection<Actor> B) {

			Collection<Actor> sA = new ArrayList<>(A);
			Collection<Actor> sB = new ArrayList<>(B);

			Collection<Actor> unswappedA = new ArrayList<>(A);
			Collection<Actor> unswappedB = new ArrayList<>(B);

			// compute initial costs
			for (Actor a : A) {
				computeCost(a, A, B);
			}
			for (Actor b : B) {
				computeCost(b, B, A);
			}

			Map<Pair<Actor, Actor>, Long> swapsCost = new HashMap<>();
			List<Pair<Actor, Actor>> swaps = new ArrayList<>();

			while (!unswappedA.isEmpty() && !unswappedB.isEmpty()) {
				long gMax = Long.MIN_VALUE;
				Pair<Actor, Actor> bestSwap = null;
				for (Actor a : unswappedA) {
					for (Actor b : unswappedB) {
						long dA = dCost.get(a);
						long dB = dCost.get(b);
						long cab = computeCa(a, b);
						long g = dA + dB - 2 * cab;
						if (g > gMax) {
							gMax = g;
							bestSwap = Pair.create(a, b);
						}
					}
				}

				swapsCost.put(bestSwap, gMax);
				swaps.add(bestSwap);

				Actor bsa = bestSwap.v1;
				Actor bsb = bestSwap.v2;

				unswappedA.remove(bsa);
				unswappedB.remove(bsb);

				sA.remove(bsa);
				sB.remove(bsb);
				sA.add(bsb);
				sB.add(bsa);

				// recompute costs
				for (Actor a : unswappedA) {
					computeCost(a, sA, sB);
				}
				for (Actor b : unswappedB) {
					computeCost(b, sB, sA);
				}
			}

			int k = -1;
			long gMax = Long.MIN_VALUE;
			for (int i = 0; i < swapsCost.size(); i++) {
				Pair<Actor, Actor> swap = swaps.get(i);
				long g = swapsCost.get(swap);
				if (g > gMax) {
					g = gMax;
					k = i;
				} else {
					break;
				}
			}

			if (k >= 0) {
				for (int i = 0; i <= k; i++) {
					Pair<Actor, Actor> swap = swaps.get(i);
					this.swaps.add(swap);
					this.g = swapsCost.get(swap);
				}
			}
		}

		long computeCa(Actor a, Actor b) {
			long cost = 0;
			for (Buffer buffer : a.getIncomingBuffers()) {
				Actor source = buffer.getSource().getOwner();
				if (source == b) {
					cost += getCost(buffer);
				}
			}
			for (Buffer buffer : b.getIncomingBuffers()) {
				Actor source = buffer.getSource().getOwner();
				if (source == a) {
					cost += getCost(buffer);
				}
			}
			return cost;
		}

		void computeCost(Actor a, Collection<Actor> A, Collection<Actor> B) {
			if (!A.contains(a)) {
				throw new TurnusRuntimeException("Actor " + a + " not contained in " + A);
			}

			long totInternal = 0;
			long totExternal = 0;

			for (Buffer buffer : a.getIncomingBuffers()) {
				Actor source = buffer.getSource().getOwner();
				if (A.contains(source)) {
					totInternal += getCost(buffer);
				} else if (B.contains(source)) {
					totExternal += getCost(buffer);
				}
			}

			for (Buffer buffer : a.getOutgoingBuffers()) {
				Actor target = buffer.getTarget().getOwner();
				if (A.contains(target)) {
					totInternal += getCost(buffer);
				} else if (B.contains(target)) {
					totExternal += getCost(buffer);
				}
			}

			long d = totExternal - totInternal;
			internalCost.put(a, totInternal);
			externalCost.put(a, totExternal);
			dCost.put(a, d);
		}

	}

	private final Map<Buffer, Long> buffersCost;
	private final Collection<Actor> actors;

	public KernighanLinPartitioner(Collection<Actor> actors, Map<Buffer, Long> buffersCost) {
		this.buffersCost = buffersCost;
		this.actors = actors;
	}

	public List<KlPartition> compute() {
		List<KlPartition> partitions = new ArrayList<>();
		if (actors.isEmpty()) {
			Logger.debug("Empty partition");
			return partitions;
		} else if (actors.size() == 1) {
			Logger.debug("1:1 partition");
			partitions.add(new KlPartition(actors));
			return partitions;
		}

		// compute initial set
		List<Actor> setA = new ArrayList<>();
		List<Actor> setB = new ArrayList<>();

		for (Actor actor : actors) {
			if (setA.size() <= setB.size()) {
				setA.add(actor);
			} else {
				setB.add(actor);
			}
		}

		long g = Long.MIN_VALUE;
		Swapper swapper = new Swapper(setA, setB);
		while (swapper.g > g) {
			g = swapper.g;
			for (Pair<Actor, Actor> swap : swapper.swaps) {
				Actor a = swap.v1;
				Actor b = swap.v2;

				setA.remove(a);
				setB.remove(b);

				setA.add(b);
				setB.add(a);
			}

			swapper = new Swapper(setA, setB);
		}

		partitions.add(new KlPartition(setA));
		partitions.add(new KlPartition(setB));
		return partitions;
	}

	private long getCost(Buffer buffer) {
		return buffersCost.containsKey(buffer) ? buffersCost.get(buffer) : 0;
	}

}

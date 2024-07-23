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
package turnus.model.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import turnus.common.util.Triplet;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

public class NetworkPartitioning implements Cloneable {

	private Comparator<String> actorsSorter;
	private Map<String, String> partitionMap;
	private Map<String, Integer> processingElementsMap;
	private Map<String, String> schedulingMap;

	private String networkName;

	public NetworkPartitioning(Network network) {
		this(network.getName());
		
	}

	public NetworkPartitioning(String network) {
		partitionMap = new HashMap<>();
		processingElementsMap = new HashMap<>();
		schedulingMap = new HashMap<>();
		networkName = network;

		// by default use an alphabetical sorter
		actorsSorter = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
	}

	public Map<String, String> asActorPartitionMap() {
		return new HashMap<>(partitionMap);
	}

	public Map<String, List<String>> asPartitionActorsMap() {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> components = new HashSet<>(partitionMap.values());

		for (String component : components) {
			map.put(component, new ArrayList<String>());
		}

		for (Entry<String, String> e : partitionMap.entrySet()) {
			String actor = e.getKey();
			String component = e.getValue();
			map.get(component).add(actor);
		}

		for (String component : components) {
			map.get(component).sort(actorsSorter);
		}

		return map;

	}

	public Map<String, String> asPartitionSchedulerMap() {
		// check if all partitions are alive
		Collection<String> alivePartitions = new HashSet<>(partitionMap.values());
		Collection<String> partitions = schedulingMap.keySet();
		for (String p : partitions) {
			if (!alivePartitions.contains(p)) {
				schedulingMap.remove(p);
			}
		}

		return new HashMap<>(schedulingMap);
	}
	
	public List<Triplet<String, String, Integer>> asPartitionSchedulerPeList(){
		List<Triplet<String, String, Integer>> list = new ArrayList<>();
		Collection<String> alivePartitions = new HashSet<>(partitionMap.values());
		Collection<String> partitions = schedulingMap.keySet();
		for (String p : partitions) {
			if (alivePartitions.contains(p)) {
				Triplet<String, String, Integer> triplet = Triplet.create(p, getScheduler(p), getProcessingElements(p));
				list.add(triplet);
			}
		}
		return list;
	}

	@Override
	public NetworkPartitioning clone() {
		NetworkPartitioning copy = new NetworkPartitioning(networkName);
		copy.partitionMap = new HashMap<String, String>(partitionMap);
		copy.schedulingMap = new HashMap<String, String>(schedulingMap);
		return copy;
	}

	public String getNetwork() {
		return networkName;
	}

	public String getPartition(Actor actor) {
		return partitionMap.get(actor.getName());
	}

	public String getPartition(String actor) {
		return partitionMap.get(actor);
	}

	public Integer getProcessingElements(String partition) {
		if (processingElementsMap.containsKey(partition))
			return processingElementsMap.get(partition);
		else
			return 1;
	}

	public Set<String> getPartitions() {
		Set<String> components = new HashSet<>(partitionMap.values());
		for (String component : partitionMap.values()) {
			components.add(component);
		}
		return components;
	}

	public String getScheduler(String component) {
		return schedulingMap.get(component);
	}

	public boolean isMapped(Actor actor) {
		return isMapped(actor.getName());
	}

	public boolean isMapped(String actor) {
		return partitionMap.containsKey(actor);
	}

	public void setActorsSorter(Comparator<String> actorsSorter) {
		this.actorsSorter = actorsSorter;
	}

	public void setActorsSorter(final List<String> orderedActors) {

		actorsSorter = new Comparator<String>() {

			private final List<String> list = new ArrayList<>(orderedActors);

			@Override
			public int compare(String o1, String o2) {
				int v1 = list.indexOf(o1);
				int v2 = list.indexOf(o2);
				if (v1 == v2) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(v1, v2);
				}
			}
		};

	}

	public void setPartition(Actor actor, String partition) {
		setPartition(actor.getName(), partition);
	}

	public void setPartition(String actor, String partition) {
		partitionMap.put(actor, partition);

		// check if the partition has already a scheduler
		if (!schedulingMap.containsKey(partition)) {
			schedulingMap.put(partition, EScheduler.FULL_PARALLEL.getLiteral());
		}
	}

	public void setProcessingElements(String partition, Integer processingElements) {
		processingElementsMap.put(partition, processingElements);
	}

	public void setScheduler(String component, String schedulingPolicy) {
		schedulingMap.put(component, schedulingPolicy);
	}

	public void setSchedulerToAll(String schedulingPolicy) {
		for (String component : partitionMap.values()) {
			schedulingMap.put(component, schedulingPolicy);
		}
	}

}

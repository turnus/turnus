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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import adevs.Devs;
import adevs.Digraph;
import turnus.model.dataflow.*;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class AdevsModel extends Digraph {

	private BiMap<Actor, AtomicActor> actorsMap;
	private BiMap<Buffer, AtomicBuffer> buffersMap;
	private BiMap<String, AtomicActorPartition> actorPartitionsMap;
	
	private Collection<AtomicBufferPartition> bufferPartitions;

	public AdevsModel() {
		super();

		actorsMap = HashBiMap.create();
		buffersMap = HashBiMap.create();
		actorPartitionsMap = HashBiMap.create();
		
		bufferPartitions = new ArrayList<AtomicBufferPartition>();
	}

	public void add(Devs model) {
		super.add(model);

		if (model instanceof AtomicActor) {
			AtomicActor atomicActor = (AtomicActor) model;
			actorsMap.put(atomicActor.getActor(), atomicActor);
		} else if (model instanceof AtomicBuffer) {
			AtomicBuffer atomicBuffer = (AtomicBuffer) model;
			buffersMap.put(atomicBuffer.getBuffer(), atomicBuffer);
		} else if (model instanceof AtomicActorPartition) {
			AtomicActorPartition atomicActorPartition = (AtomicActorPartition) model;
			actorPartitionsMap.put(atomicActorPartition.getId(), atomicActorPartition);
		} else if (model instanceof AtomicBufferPartition) {
			AtomicBufferPartition atomicBufferPartition = (AtomicBufferPartition) model;
			bufferPartitions.add(atomicBufferPartition);
		}
	}

	public AtomicActor getActor(Actor actor) {
		return actorsMap.get(actor);
	}

	public AtomicBuffer getBuffer(Buffer buffer) {
		return buffersMap.get(buffer);
	}
	
	public AtomicActorPartition getAtomicActorPartition(String id) {
		return actorPartitionsMap.get(id);
	}
	
	public Collection<AtomicActor> getActors() {
		return Collections.unmodifiableCollection(actorsMap.values());
	}

	public Collection<AtomicBuffer> getBuffers() {
		return Collections.unmodifiableCollection(buffersMap.values());
	}

	public Collection<AtomicActorPartition> getActorPartitions() {
		return Collections.unmodifiableCollection(actorPartitionsMap.values());
	}

	public Collection<AtomicBufferPartition> getBufferPartitions() {
		return Collections.unmodifiableCollection(bufferPartitions);
	}

}

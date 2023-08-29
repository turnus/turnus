/*
 * TURNUS - www.turnus.co
 *
 * Copyright (C) 2023 Endri Bezati
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
package turnus.model.analysis.profiling.util;

import java.util.ArrayList;
import java.util.List;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Type;
import turnus.model.dataflow.Variable;

/**
 * This class offers static methods for retrieving general information about the
 * memory use.
 */
public class MemoryAndBuffers {

	/**
	 * Get persistent memory in bits of an actor
	 *
	 * @param actor
	 * @return
	 */
	public static long getActorPersistentMemmory(Actor actor) {
		long mem = 0;
		for (Variable variable : actor.getVariables()) {
			if (variable.isPersistent()) {
				Type type = variable.getType();
				long bits = type.getBits();
				mem += bits;
			}
		}
		return mem;
	}

	/**
	 * Get transient memory in bits of an actor
	 *
	 * @param actor
	 * @return
	 */
	public static long getActorTransientMemory(Actor actor) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * Get the sum of persistent memory in bits of a list of actors
	 * 
	 * @param actors
	 * @return
	 */
	public static long getActorsPesistenMemory(List<Actor> actors) {
		long mem = 0;
		for (Actor actor : actors) {
			mem += getActorPersistentMemmory(actor);
		}

		return mem;
	}

	/**
	 * Get the incoming buffers of a partition.
	 * 
	 * @param actors
	 * @return
	 */
	public static List<Buffer> getIncomingBuffersOfPartition(List<Actor> actors) {
		List<Buffer> buffers = new ArrayList<>();

		for (Actor actor : actors) {
			for (Buffer buffer : actor.getIncomingBuffers()) {
				Actor srcActor = buffer.getSource().getOwner();
				if (!actors.contains(srcActor)) {
					buffers.add(buffer);
				}
			}
		}

		return buffers;
	}

	/**
	 * 
	 */
	public static List<Buffer> getInternalBuffersOfPartition(List<Actor> actors){
		List<Buffer> buffers = new ArrayList<>();

		for (Actor actor : actors) {
			for (Buffer buffer : actor.getOutgoingBuffers()) {
				Actor tgtActor = buffer.getTarget().getOwner();
				if (actors.contains(tgtActor)) {
					buffers.add(buffer);
				}
			}
		}

		return buffers;
	}
	
	
	/**
	 * Get the outgoing buffers of a partition.
	 * 
	 * @param actors
	 * @return
	 */
	public static List<Buffer> getOutgoingBuffersOfPartition(List<Actor> actors) {
		List<Buffer> buffers = new ArrayList<>();

		for (Actor actor : actors) {
			for (Buffer buffer : actor.getOutgoingBuffers()) {
				Actor tgtActor = buffer.getTarget().getOwner();
				if (!actors.contains(tgtActor)) {
					buffers.add(buffer);
				}
			}
		}

		return buffers;
	}

	public static long maxOutgoingBitsInPartition(List<Buffer> buffers) {
		for (Buffer buffer : buffers) {
			Actor srcActor = buffer.getSource().getOwner();
			Port srcPort = buffer.getSource();
			for (Action action : srcActor.getActions()) {
				//action.ge
			}
		}

		return 0;
	}

}

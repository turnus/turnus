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

import static java.util.Collections.unmodifiableMap;

import java.util.HashMap;
import java.util.Map;

import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class PortsIdentifier {
	// ----- THE OVERALL BUFFERS PORT ID MAP
	public final Map<Integer, Buffer> BUFFERS_PORTS_ID_MAP;

	// ---- THE OUTPUT INTERFACE PORTS IDS
	public final Map<Buffer, Integer> PORT_OUT_SEND_HAS_SPACE;
	public final Map<Buffer, Integer> PORT_OUT_RECEIVE_HAS_SPACE;
	public final Map<Buffer, Integer> PORT_OUT_SEND_TOKENS;
	public final Map<Buffer, Integer> PORT_OUT_RECEIVE_TOKENS_RECEIVED;

	// ---- THE INPUT INTERFACE PORTS IDS
	public final Map<Buffer, Integer> PORT_IN_SEND_HAS_TOKENS;
	public final Map<Buffer, Integer> PORT_IN_RECEIVE_HAS_TOKENS;
	public final Map<Buffer, Integer> PORT_IN_SEND_ASK_TOKENS;
	public final Map<Buffer, Integer> PORT_IN_RECEIVE_TOKENS;
	public final Map<Buffer, Integer> PORT_IN_RELEASE_BUFFER;


	// --- THE BUFFERS PARTITIONER SCHEDULER PORTS
	public final Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_RX;
	public final Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_TX;

	// ----- THE OVERALL ACTORS PORT ID MAP
	public final Map<Integer, Actor> ACTORS_PORTS_ID_MAP;

	// --- THE ACTORS PARTITIONER SCHEDULER PORTS
	public final Map<Actor, Integer> PORT_PARTITION_SEND_ASK_SCHEDULABILITY;
	public final Map<Actor, Integer> PORT_PARTITION_RECEIVE_SCHEDULABILITY;
	public final Map<Actor, Integer> PORT_PARTITION_SEND_ENABLE;
	public final Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_FIRING;
	public final Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_READING;

	public PortsIdentifier(Network network) {
		int portId = AtomicActor.RESERVED_PARTITION_PORTS + 1;

		Map<Integer, Buffer> BUFFERS_PORTS_ID_MAP = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_SEND_HAS_SPACE = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_RECEIVE_HAS_SPACE = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_SEND_TOKENS = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_RECEIVE_TOKENS_RECEIVED = new HashMap<>();
		Map<Buffer, Integer> PORT_IN_SEND_HAS_TOKENS = new HashMap<>();
		Map<Buffer, Integer> PORT_IN_RECEIVE_HAS_TOKENS = new HashMap<>();
		Map<Buffer, Integer> PORT_IN_SEND_ASK_TOKENS = new HashMap<>();
		Map<Buffer, Integer> PORT_IN_RECEIVE_TOKENS = new HashMap<>();
		Map<Buffer, Integer> PORT_IN_RELEASE_BUFFER = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_RX = new HashMap<>();
		Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_TX = new HashMap<>();
		
		for (Buffer buffer : network.getBuffers()) {
			PORT_OUT_SEND_HAS_SPACE.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_OUT_RECEIVE_HAS_SPACE.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_OUT_SEND_TOKENS.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_OUT_RECEIVE_TOKENS_RECEIVED.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_IN_SEND_HAS_TOKENS.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_IN_RECEIVE_HAS_TOKENS.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_IN_SEND_ASK_TOKENS.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_IN_RECEIVE_TOKENS.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;
			
			PORT_IN_RELEASE_BUFFER.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_OUT_SEND_ENABLE_RX.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;

			PORT_OUT_SEND_ENABLE_TX.put(buffer, portId);
			BUFFERS_PORTS_ID_MAP.put(portId, buffer);
			portId++;
		}

		Map<Integer, Actor> ACTORS_PORTS_ID_MAP = new HashMap<>();
		Map<Actor, Integer> PORT_PARTITION_SEND_ASK_SCHEDULABILITY = new HashMap<>();
		Map<Actor, Integer> PORT_PARTITION_RECEIVE_SCHEDULABILITY = new HashMap<>();
		Map<Actor, Integer> PORT_PARTITION_SEND_ENABLE = new HashMap<>();
		Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_FIRING = new HashMap<>();
		Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_READING = new HashMap<>();
		for (Actor actor : network.getActors()) {
			PORT_PARTITION_SEND_ASK_SCHEDULABILITY.put(actor, portId);
			ACTORS_PORTS_ID_MAP.put(portId, actor);
			portId++;

			PORT_PARTITION_RECEIVE_SCHEDULABILITY.put(actor, portId);
			ACTORS_PORTS_ID_MAP.put(portId, actor);
			portId++;

			PORT_PARTITION_SEND_ENABLE.put(actor, portId);
			ACTORS_PORTS_ID_MAP.put(portId, actor);
			portId++;

			PORT_PARTITION_RECEIVE_END_OF_FIRING.put(actor, portId);
			ACTORS_PORTS_ID_MAP.put(portId, actor);
			portId++;
			
			PORT_PARTITION_RECEIVE_END_OF_READING.put(actor, portId);
			ACTORS_PORTS_ID_MAP.put(portId, actor);
			portId++;
		}

		// make all the maps as unmodifiable
		this.PORT_OUT_SEND_HAS_SPACE = unmodifiableMap(PORT_OUT_SEND_HAS_SPACE);
		this.PORT_OUT_RECEIVE_HAS_SPACE = unmodifiableMap(PORT_OUT_RECEIVE_HAS_SPACE);
		this.PORT_OUT_SEND_TOKENS = unmodifiableMap(PORT_OUT_SEND_TOKENS);
		this.PORT_OUT_RECEIVE_TOKENS_RECEIVED = unmodifiableMap(PORT_OUT_RECEIVE_TOKENS_RECEIVED);
		this.PORT_IN_SEND_HAS_TOKENS = unmodifiableMap(PORT_IN_SEND_HAS_TOKENS);
		this.BUFFERS_PORTS_ID_MAP = unmodifiableMap(BUFFERS_PORTS_ID_MAP);
		this.PORT_IN_RECEIVE_HAS_TOKENS = unmodifiableMap(PORT_IN_RECEIVE_HAS_TOKENS);
		this.PORT_IN_SEND_ASK_TOKENS = unmodifiableMap(PORT_IN_SEND_ASK_TOKENS);
		this.PORT_IN_RECEIVE_TOKENS = unmodifiableMap(PORT_IN_RECEIVE_TOKENS);
		this.PORT_IN_RELEASE_BUFFER = unmodifiableMap(PORT_IN_RELEASE_BUFFER);
		this.PORT_OUT_SEND_ENABLE_RX = unmodifiableMap(PORT_OUT_SEND_ENABLE_RX);
		this.PORT_OUT_SEND_ENABLE_TX = unmodifiableMap(PORT_OUT_SEND_ENABLE_TX);

		this.ACTORS_PORTS_ID_MAP = unmodifiableMap(ACTORS_PORTS_ID_MAP);
		this.PORT_PARTITION_SEND_ASK_SCHEDULABILITY = unmodifiableMap(PORT_PARTITION_SEND_ASK_SCHEDULABILITY);
		this.PORT_PARTITION_RECEIVE_SCHEDULABILITY = unmodifiableMap(PORT_PARTITION_RECEIVE_SCHEDULABILITY);
		this.PORT_PARTITION_SEND_ENABLE = unmodifiableMap(PORT_PARTITION_SEND_ENABLE);
		this.PORT_PARTITION_RECEIVE_END_OF_FIRING = unmodifiableMap(PORT_PARTITION_RECEIVE_END_OF_FIRING);
		this.PORT_PARTITION_RECEIVE_END_OF_READING = unmodifiableMap(PORT_PARTITION_RECEIVE_END_OF_READING);
	}

}

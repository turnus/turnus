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
import java.util.Map;

import adevs.Atomic;
import adevs.Digraph.PortValue;
import turnus.model.dataflow.Buffer;

/**
 * This is an initial implementation of an Atomic Buffer Partition.
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
@SuppressWarnings("unused")
public class AtomicBufferPartition extends Atomic<PortValue> {

	// ----- THE OVERALL BUFFERS PORT ID MAP
	private Map<Integer, Buffer> BUFFERS_PORTS_ID_MAP;

	// --- THE BUFFERS PARTITIONER SCHEDULER PORTS
	private Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_RX;
	private Map<Buffer, Integer> PORT_OUT_SEND_ENABLE_TX;

	public enum RxStatus {
		IDLE, SEND_ENABLE;
	}

	public enum TxStatus {
		IDLE, SEND_ENABLE;
	}

	private RxStatus rxStatus;
	private TxStatus txStatus;

	private double localTime = 0;

	private Collection<Buffer> buffers;

	public AtomicBufferPartition(Collection<Buffer> buffers) {
		this.buffers = buffers;
		rxStatus = RxStatus.IDLE;
		txStatus = TxStatus.IDLE;
	}

	public void configure(PortsIdentifier portIds) {
		BUFFERS_PORTS_ID_MAP = portIds.BUFFERS_PORTS_ID_MAP;
		PORT_OUT_SEND_ENABLE_RX = portIds.PORT_OUT_SEND_ENABLE_RX;
		PORT_OUT_SEND_ENABLE_TX = portIds.PORT_OUT_SEND_ENABLE_TX;
	}

	@Override
	public void delta_conf(Collection<PortValue> xb) {
		delta_int();
		delta_ext(0.0, xb);
	}

	@Override
	public void delta_int() {

	}

	@Override
	public void delta_ext(double e, Collection<PortValue> xb) {
		localTime += e;
	}

	@Override
	public void output_func(Collection<PortValue> yb) {

	}

	@Override
	public double ta() {
		return Double.MAX_VALUE;
	}

}

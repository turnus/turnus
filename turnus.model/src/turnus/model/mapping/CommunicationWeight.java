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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import turnus.model.dataflow.Buffer;
import turnus.model.mapping.data.MemoryAccess;

public class CommunicationWeight {
	
	private String networkName;
	private Set<Buffer> buffers;
	private Map<Buffer, List<MemoryAccess>> readWeights;
	private Map<Buffer, List<MemoryAccess>> writeWeights;
	private int writeHitConstant = 0;
	private int writeMissConstant = 0;
	
	public CommunicationWeight() {
		this.buffers = new HashSet<Buffer>();
		this.readWeights = new HashMap<Buffer, List<MemoryAccess>>();
		this.writeWeights = new HashMap<Buffer, List<MemoryAccess>>();
	}
	
	public String getNetwork() {
		return networkName;
	}
	
	public Set<Buffer> getBuffers() {
		return buffers;
	}
	
	public Map<Buffer, List<MemoryAccess>> getReadWeights() {
		return readWeights;
	}
	
	public Map<Buffer, List<MemoryAccess>> getWriteWeights() {
		return writeWeights;
	}
	
	public void setNetworkName(String network) {
		this.networkName = network;
	}
	
	public void setReadWeights(Map<Buffer, List<MemoryAccess>> weights) {
		this.readWeights = weights;
		this.buffers.addAll(weights.keySet());
	}
	
	public void setWriteWeights(Map<Buffer, List<MemoryAccess>> weights) {
		this.writeWeights = weights;
		this.buffers.addAll(weights.keySet());
	}
	
	public List<MemoryAccess> getReadWeights(Buffer buffer) {
		return readWeights.get(buffer);
	}
	
	public List<MemoryAccess> getWriteWeights(Buffer buffer) {
		return writeWeights.get(buffer);
	}
	
	public List<MemoryAccess> getReadAccessByLevel(Buffer buffer, String level) {
		List<MemoryAccess> accesses = new ArrayList<MemoryAccess>();
		if (readWeights.containsKey(buffer)) {
			for (MemoryAccess ma : readWeights.get(buffer)) {
				if (ma.getLevel().equals(level))
					accesses.add(ma);
			}
		}
		
		return accesses;
	}
	
	public List<MemoryAccess> getWriteAccessByLevel(Buffer buffer, String level) {
		List<MemoryAccess> accesses = new ArrayList<MemoryAccess>();
		if (writeWeights.containsKey(buffer)) {
			for (MemoryAccess ma : writeWeights.get(buffer)) {
				if (ma.getLevel().equals(level))
					accesses.add(ma);
			}
		}
		
		return accesses;
	}

	public int getWriteHitConstant() {
		return writeHitConstant;
	}

	public void setWriteHitConstant(int writeHitConstant) {
		this.writeHitConstant = writeHitConstant;
	}

	public int getWriteMissConstant() {
		return writeMissConstant;
	}

	public void setWriteMissConstant(int writeMissConstant) {
		this.writeMissConstant = writeMissConstant;
	}

}

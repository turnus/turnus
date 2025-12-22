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

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import turnus.common.util.Pair;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

public class BufferSize implements Cloneable{

	private int defaultSize = 512;
	private String networkName;

	private Table<Pair<String, String>, Pair<String, String>, Integer> sizeTable = HashBasedTable.create();

	public BufferSize(Network network) {
		this.networkName = network.getName();
	}

	public BufferSize(String networkName) {
		this.networkName = networkName;
	}
	
	private BufferSize(BufferSize o){
		this.defaultSize = o.defaultSize;
		this.networkName = o.networkName;
		this.sizeTable = HashBasedTable.create(o.sizeTable);
	}

	public Table<Pair<String, String>, Pair<String, String>, Integer> asTable() {
		return HashBasedTable.create(sizeTable);
	}

	public int getDefaultSize() {
		return defaultSize;
	}

	public String getNetwork() {
		return networkName;
	}

	public int getSize(Buffer buffer) {
		return getSize(buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
				buffer.getTarget().getOwner().getName(), buffer.getTarget().getName());
	}

	public int getSize(String sourceActor, String sourcePort, String targetActor, String targetPort) {
		Pair<String, String> source = Pair.create(sourceActor, sourcePort);
		Pair<String, String> target = Pair.create(targetActor, targetPort);
		if (sizeTable.contains(source, target)) {
			return sizeTable.get(source, target);
		} else {
			return defaultSize;
		}
	}

	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}

	public void setSize(Buffer buffer, int size) {
		setSize(buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
				buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(), size);
	}

	public void setSize(String sourceActor, String sourcePort, String targetActor, String targetPort, int size) {
		Pair<String, String> source = Pair.create(sourceActor, sourcePort);
		Pair<String, String> target = Pair.create(targetActor, targetPort);
		sizeTable.put(source, target, size);
	}
	
	@Override
	public BufferSize clone(){
		return new BufferSize(this);
	}

}

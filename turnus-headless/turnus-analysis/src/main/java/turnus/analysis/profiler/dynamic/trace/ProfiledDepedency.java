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
package turnus.analysis.profiler.dynamic.trace;

import turnus.common.AbstractAttributable;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;
import turnus.model.trace.Dependency;

/**
 * This class defines a profiled dependency.
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfiledDepedency extends AbstractAttributable implements Dependency {

	private final ProfiledStep source;
	private final ProfiledStep target;
	private String variable;
	private String guard;
	private final Kind kind;
	private Direction direction = Direction.UNKNOWN;
	private int count = 0;
	private String port;
	private String sourcePort;
	private String targetPort;

	public void setVariable(Variable variable) {
		this.variable = variable.getName();
	}

	public void setGuard(Guard guard) {
		this.guard = guard.getTag();
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPort(Port port) {
		this.port = port.getName();
	}

	public void setBuffer(Buffer buffer) {
		this.sourcePort = buffer.getSource().getName();
		this.targetPort = buffer.getTarget().getName();
	}

	/**
	 * Constructor. Create a new profiled dependency.
	 * 
	 * @param source
	 * @param target
	 * @param kind
	 */
	public ProfiledDepedency(ProfiledStep source, ProfiledStep target, Kind kind) {
		this.source = source;
		this.target = target;
		this.kind = kind;
	}

	@Override
	public String getVariable() {
		return variable;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public String getGuard() {
		return guard;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public String getSourcePort() {
		return sourcePort;
	}

	@Override
	public String getTargetPort() {
		return targetPort;
	}

	@Override
	public Kind getKind() {
		return kind;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public long getSourceId() {
		return source.getId();
	}

	@Override
	public long getTargetId() {
		return target.getId();
	}

	@Override
	public ProfiledStep getSource() {
		return source;
	}

	@Override
	public ProfiledStep getTarget() {
		return target;
	}

	@Override
	public String getSourceActor() {
		return source.getActor();
	}

	@Override
	public String getTargetActor() {
		return target.getActor();
	}

	@Override
	public String getSourceAction() {
		return source.getAction();
	}

	@Override
	public String getTargetAction() {
		return target.getAction();
	}

}

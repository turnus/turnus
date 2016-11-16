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
package turnus.model.trace.impl.splitted.impl;

import java.util.HashMap;
import java.util.Map;

import turnus.common.AbstractAttributable;
import turnus.common.TurnusRuntimeException;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class SplittedDependency extends AbstractAttributable implements Dependency {

	private int count;
	private Direction direction;
	private String guard;
	private Kind kind;
	private String port;
	private String sourceAction;
	private String sourceActor;
	private long sourceId;
	private String sourcePort;
	private String targetAction;
	private String targetActor;
	private long targetId;
	private String targetPort;
	private String variable;

	public SplittedDependency() {
	}

	public SplittedDependency(long sourceId, String sourceActor, String sourceAction, long targetId, String targetActor,
			String targetAction, Kind kind, Direction direction, String guard, String variable, String port,
			String sourcePort, String targetPort, int count, Map<String, Object> attributes) {
		this.sourceId = sourceId;
		this.targetId = targetId;
		this.sourceAction = sourceAction;
		this.sourceActor = sourceActor;
		this.targetAction = targetAction;
		this.targetActor = targetActor;
		this.direction = direction;
		this.kind = kind;
		this.variable = variable;
		this.guard = guard;
		this.port = port;
		this.sourcePort = sourcePort;
		this.targetPort = targetPort;
		this.count = count;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public String getGuard() {
		return guard;
	}

	@Override
	public Kind getKind() {
		return kind;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public Step getSource() {
		throw new TurnusRuntimeException("get source step is not supported by the splitted deoendency");
	}

	@Override
	public String getSourceAction() {
		return sourceAction;
	}

	@Override
	public String getSourceActor() {
		return sourceActor;
	}

	@Override
	public long getSourceId() {
		return sourceId;
	}

	@Override
	public String getSourcePort() {
		return sourcePort;
	}

	@Override
	public Step getTarget() {
		throw new TurnusRuntimeException("get target step is not supported by the splitted deoendency");
	}

	@Override
	public String getTargetAction() {
		return targetAction;
	}

	@Override
	public String getTargetActor() {
		return targetActor;
	}

	@Override
	public long getTargetId() {
		return targetId;
	}

	@Override
	public String getTargetPort() {
		return targetPort;
	}

	@Override
	public String getVariable() {
		return variable;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = new HashMap<>(attributes);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setGuard(String guard) {
		this.guard = guard;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setSourceAction(String sourceAction) {
		this.sourceAction = sourceAction;
	}

	public void setSourceActor(String sourceActor) {
		this.sourceActor = sourceActor;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}

	public void setTargetAction(String targetAction) {
		this.targetAction = targetAction;
	}

	public void setTargetActor(String targetActor) {
		this.targetActor = targetActor;
	}

	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}
	
	public String toString(){
		StringBuffer b = new StringBuffer();
		b.append("[dep] ");
		b.append(sourceId).append("->").append(targetId);
		b.append(" source-actor=").append(sourceActor);
		b.append(" source-action=").append(sourceAction);
		b.append(" target-actor").append(targetActor);
		b.append(" target-action").append(targetAction);
		b.append(" kind=").append(kind);
		return b.toString();
	}

}

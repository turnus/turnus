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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class SplittedStep extends AbstractAttributable implements Step {

	private String action;
	private String actor;
	private String actorClass;
	private long id;
	private Map<String, Integer> readTokens;
	private Map<String, Integer> writeTokens;
	private List<String> readVariables;
	private List<String> writeVariables;

	public SplittedStep() {
		readTokens = new HashMap<>();
		writeTokens = new HashMap<>();
		readVariables = new ArrayList<>();
		writeVariables = new ArrayList<>();
	}

	public SplittedStep(long id, String actor, String action, String actorClass, Map<String, Integer> readTokens,
			Map<String, Integer> writeTokens, List<String> readVariables, List<String> writeVariables,
			Map<String, Object> attributes) {
		this.id = id;
		this.actor = actor;
		this.action = action;
		this.actorClass = actorClass;
		this.attributes = attributes;
		this.readTokens = new HashMap<>(readTokens);
		this.writeTokens = new HashMap<>(writeTokens);
		this.readVariables = new ArrayList<>(readVariables);
		this.writeVariables = new ArrayList<>(writeVariables);
	}

	@Override
	public String getAction() {
		return action;
	}

	@Override
	public String getActor() {
		return actor;
	}

	@Override
	public String getActorClass() {
		return actorClass;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public Iterable<Dependency> getIncomings() {
		throw new TurnusRuntimeException("get incomings is not supported by the splitted step");
	}

	@Override
	public Iterable<Dependency> getOutgoings() {
		throw new TurnusRuntimeException("get outgoings is not supported by the splitted step");
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setActorClass(String actorClass) {
		this.actorClass = actorClass;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = new HashMap<>(attributes);
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[step] ");
		b.append(id);
		b.append(", actor=").append(actor);
		b.append(", action=").append(action);
		b.append(", class=").append(actorClass);
		return b.toString();
	}

	public void addReadTokens(String port, int count) {
		readTokens.put(port, count);
	}

	public void addWriteTokens(String port, int count) {
		writeTokens.put(port, count);
	}

	public void addReadVariable(String variable) {
		if (!readVariables.contains(variable)) {
			readVariables.add(variable);
		}
	}

	public void addWriteVariable(String variable) {
		if (!writeVariables.contains(variable)) {
			writeVariables.add(variable);
		}
	}

	@Override
	public Map<String, Integer> getReadTokens() {
		return readTokens;
	}

	@Override
	public Map<String, Integer> getWriteTokens() {
		return writeTokens;
	}

	@Override
	public List<String> getReadVariables() {
		return readVariables;
	}

	@Override
	public List<String> getWriteVariables() {
		return writeVariables;
	}

}

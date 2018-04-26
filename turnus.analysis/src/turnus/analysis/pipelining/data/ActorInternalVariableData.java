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
package turnus.analysis.pipelining.data;

import static turnus.model.common.StatisticalData.Util.asStatisticalData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;

import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.PipeliningFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.trace.Step;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ActorInternalVariableData {

	private class ActionData {
		/** consecutive successors */
		final SummaryStatistics consecutiveFirings = new SummaryStatistics();
		/** consecutive successors without reading any variables */
		final SummaryStatistics pipelinableFirings = new SummaryStatistics();

		void log(int consecutives, int pipelinables) {
			consecutiveFirings.addValue(consecutives);
			pipelinableFirings.addValue(pipelinables);
		}
	}

	private final Actor actor;

	private Action currentAction;
	private int consecutiveFirings;
	private int pipelinableFirings;

	private Map<Action, ActionData> actionDataMap = new HashMap<>();

	public ActorInternalVariableData(Actor actor) {
		this.actor = actor;

		for (Action action : actor.getActions()) {
			actionDataMap.put(action, new ActionData());
		}
	}

	public void addStep(Step step) {
		Action action = actor.getAction(step.getAction());

		// if there is a new action, then stop the consecutive successors log
		if (action != currentAction) {
			// if this not the first action then store the results
			if (currentAction != null) {
				ActionData data = actionDataMap.get(action);
				data.log(consecutiveFirings, pipelinableFirings);
			}

			pipelinableFirings = 0;
			consecutiveFirings = 0;
			currentAction = action;

		} else {
			consecutiveFirings++;
		}

		// now check if the action has no read variables
		List<String> readVars = step.getReadVariables();
		if (readVars != null && !readVars.isEmpty()) {
			pipelinableFirings = 0;
		} else {
			pipelinableFirings++;
		}
	}

	public void end() {
		if (currentAction != null) {
			ActionData data = actionDataMap.get(currentAction);
			data.log(consecutiveFirings, pipelinableFirings);
		}
		pipelinableFirings = 0;
		consecutiveFirings = 0;
		currentAction = null;
	}

	public List<ActionVariablePipeliningData> getActionsData() {
		List<ActionVariablePipeliningData> data = new ArrayList<>();
		PipeliningFactory f = PipeliningFactory.eINSTANCE;
		for (Entry<Action, ActionData> entry : actionDataMap.entrySet()) {
			Action action = entry.getKey();
			ActionData actionData = entry.getValue();

			ActionVariablePipeliningData result = f.createActionVariablePipeliningData();
			result.setAction(action);
			result.setConsecutiveFirings(asStatisticalData(actionData.consecutiveFirings));
			result.setPipelinableFirings(asStatisticalData(actionData.pipelinableFirings));
			data.add(result);
		}

		return data;

	}

}

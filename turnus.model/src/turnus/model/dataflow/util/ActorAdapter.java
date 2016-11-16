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
package turnus.model.dataflow.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

import com.google.common.collect.BiMap;

/**
 * This class defines a {@link EContentAdapter} for an {@link Actor}
 * 
 * @author Simone Casale Brunet
 *
 */
public class ActorAdapter extends EContentAdapter {

	/**
	 * The map of actions and names
	 * 
	 * @see Actor#getAction(String)
	 */
	private BiMap<String, Action> actionsMap;

	/**
	 * The map of variables and names
	 * 
	 * @see Actor#getVariable(String)
	 */
	private BiMap<String, Variable> variablesMap;

	/**
	 * The map of procedures and names
	 * 
	 * @see Actor#getProcedure(String)
	 */
	private BiMap<String, Procedure> proceduresMap;

	/**
	 * Create an actor adapter
	 * 
	 * @param actionsMap
	 *            the actions-names map
	 * @param variablesMap
	 *            the variables-names map
	 * @param proceduresMap
	 *            the procedures-name map
	 */
	public ActorAdapter(BiMap<String, Action> actionsMap,
			BiMap<String, Variable> variablesMap,
			BiMap<String, Procedure> proceduresMap) {
		this.actionsMap = actionsMap;
		this.variablesMap = variablesMap;
		this.proceduresMap = proceduresMap;
	}

	private void add(Object object) {
		if (object instanceof Action) {
			Action action = (Action) object;
			String name = action.getName();
			if (name != null && !name.isEmpty()) {
				actionsMap.put(name, action);
			}
		} else if (object instanceof Procedure) {
			Procedure proc = (Procedure) object;
			String name = proc.getName();
			if (name != null && !name.isEmpty()) {
				proceduresMap.put(name, proc);
			}
		} else if (object instanceof Variable) {
			Variable variable = (Variable) object;
			String name = variable.getName();
			if (name != null && !name.isEmpty()) {
				variablesMap.put(name, variable);
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == Actor.class;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof Actor) {
			switch (notification.getEventType()) {
			case Notification.ADD: {
				add(notification.getNewValue());
				break;
			}
			case Notification.ADD_MANY: {
				List<?> list = (List<?>) notification.getNewValue();
				for (Object object : list) {
					add(object);
				}
				break;
			}
			case Notification.MOVE: {
				remove(notification.getOldValue());
				add(notification.getNewValue());
				break;
			}
			case Notification.REMOVE: {
				remove(notification.getOldValue());
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> list = (List<?>) notification.getOldValue();
				for (Object object : list) {
					remove(object);
				}
				break;
			}
			default:
				break;
			}
		} else if (notifier instanceof Action) {
			switch (notification.getFeatureID(Action.class)) {
			case DataflowPackage.ACTION__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		} else if (notifier instanceof Procedure) {
			switch (notification.getFeatureID(Procedure.class)) {
			case DataflowPackage.PROCEDURE__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		} else if (notifier instanceof Variable) {
			switch (notification.getFeatureID(Variable.class)) {
			case DataflowPackage.VARIABLE__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		}
	}

	private void remove(Object object) {
		if (object instanceof Action) {
			Action action = (Action) object;
			if (actionsMap.containsValue(action)) {
				String oldKey = actionsMap.inverse().get(action);
				actionsMap.remove(oldKey);
			}
		} else if (object instanceof Procedure) {
			Procedure proc = (Procedure) object;
			if (proceduresMap.containsValue(proc)) {
				String oldKey = proceduresMap.inverse().get(proc);
				proceduresMap.remove(oldKey);
			}
		} else if (object instanceof Variable) {
			Variable variable = (Variable) object;
			if (variablesMap.containsValue(variable)) {
				String oldKey = variablesMap.inverse().get(variable);
				variablesMap.remove(oldKey);
			}
		}
	}

}

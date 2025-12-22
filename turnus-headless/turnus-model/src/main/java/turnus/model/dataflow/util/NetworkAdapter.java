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

import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Network;

import com.google.common.collect.BiMap;

/**
 * This class defines a {@link EContentAdapter} for a {@link Network}
 * 
 * @author Simone Casale Brunet
 *
 */
public class NetworkAdapter extends EContentAdapter {

	/**
	 * The map of actors and names
	 * 
	 * @see Network#getActor(String)
	 */
	private BiMap<String, Actor> actorsMap;

	/**
	 * The map of actor-classes and names
	 * 
	 * @see Network#getActorClass(String)
	 */
	private BiMap<String, ActorClass> actorClassesMap;

	/**
	 * Create a network adapter
	 * 
	 * @param actorsMap
	 *            the actors-names map
	 * @param actorClassesMap
	 *            the actor classes-names map
	 */
	public NetworkAdapter(BiMap<String, Actor> actorsMap,
			BiMap<String, ActorClass> actorClassesMap) {
		this.actorsMap = actorsMap;
		this.actorClassesMap = actorClassesMap;
	}

	private void add(Object object) {
		if (object instanceof Actor) {
			Actor actor = (Actor) object;
			String name = actor.getName();
			if (name != null && !name.isEmpty()) {
				actorsMap.put(name, actor);
			}
		} else if (object instanceof ActorClass) {
			ActorClass actorClass = (ActorClass) object;
			String name = actorClass.getName();
			if (name != null && !name.isEmpty()) {
				actorClassesMap.put(name, actorClass);
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == Network.class;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof Network) {
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
		} else if (notifier instanceof Actor) {
			switch (notification.getFeatureID(Actor.class)) {
			case DataflowPackage.ACTOR__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		} else if (notifier instanceof ActorClass) {
			switch (notification.getFeatureID(ActorClass.class)) {
			case DataflowPackage.ACTOR_CLASS__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		}
	}

	private void remove(Object object) {
		if (object instanceof Actor) {
			Actor actor = (Actor) object;
			if (actorsMap.containsValue(actor)) {
				String oldKey = actorsMap.inverse().get(actor);
				actorsMap.remove(oldKey);
			}
		} else if (object instanceof ActorClass) {
			ActorClass actorClass = (ActorClass) object;
			if (actorClassesMap.containsValue(actorClass)) {
				String oldKey = actorClassesMap.inverse().get(actorClass);
				actorClassesMap.remove(oldKey);
			}
		}
	}

}

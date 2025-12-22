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
package turnus.model.architecture.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import turnus.model.architecture.Architecture;
import turnus.model.architecture.ArchitecturePackage;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;

import com.google.common.collect.BiMap;

/**
 * This class defines a {@link EContentAdapter} for an {@link Architecture}
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureAdapter extends EContentAdapter {

	/**
	 * The map of processing-units and names
	 * 
	 * @see Architecture#getProcessingUnit(String)
	 */
	private BiMap<String, ProcessingUnit> pusMap;

	/**
	 * The map of media and names
	 * 
	 * @see Architecture#getMedia()
	 */
	private BiMap<String, Medium> mediumsMap;

	/**
	 * Create an architecture adapter
	 * 
	 * @param pusMap
	 *            the processing-units and names map
	 * @param mediumsMap
	 *            the media and names map
	 */
	public ArchitectureAdapter(BiMap<String, ProcessingUnit> pusMap,
			BiMap<String, Medium> mediumsMap) {
		this.pusMap = pusMap;
		this.mediumsMap = mediumsMap;
	}

	private void add(Object object) {
		if (object instanceof ProcessingUnit) {
			ProcessingUnit pu = (ProcessingUnit) object;
			String name = pu.getName();
			if (name != null && !name.isEmpty()) {
				pusMap.put(name, pu);
			}
		} else if (object instanceof Medium) {
			Medium medium = (Medium) object;
			String name = medium.getName();
			if (name != null && !name.isEmpty()) {
				mediumsMap.put(name, medium);
			}
		}
	}

	private void remove(Object object) {
		if (object instanceof ProcessingUnit) {
			ProcessingUnit pu = (ProcessingUnit) object;
			if (pusMap.containsValue(pu)) {
				String oldKey = pusMap.inverse().get(pu);
				pusMap.remove(oldKey);
			}
		} else if (object instanceof Medium) {
			Medium medium = (Medium) object;
			if (mediumsMap.containsValue(medium)) {
				String oldKey = mediumsMap.inverse().get(medium);
				mediumsMap.remove(oldKey);
			}
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof Architecture) {
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
		} else if (notifier instanceof ProcessingUnit) {
			switch (notification.getFeatureID(ProcessingUnit.class)) {
			case ArchitecturePackage.PROCESSING_UNIT__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		} else if (notifier instanceof Medium) {
			switch (notification.getFeatureID(Medium.class)) {
			case ArchitecturePackage.MEDIUM__NAME:
				remove(notifier);
				add(notifier);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == Architecture.class;
	}

}

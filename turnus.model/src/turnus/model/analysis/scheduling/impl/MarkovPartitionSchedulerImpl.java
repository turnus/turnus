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
package turnus.model.analysis.scheduling.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.scheduling.MarkovPartitionScheduler;
import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.SchedulingPackage;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Markov Partition Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl#getPartitionId <em>Partition Id</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl#getStates <em>States</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkovPartitionSchedulerImpl extends MinimalEObjectImpl.Container implements MarkovPartitionScheduler {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The default value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTITION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected String partitionId = PARTITION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<MarkovSchedulingState> states;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<MarkovSchedulingTransition> transitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkovPartitionSchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.MARKOV_PARTITION_SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, SchedulingPackage.MARKOV_PARTITION_SCHEDULER__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartitionId() {
		return partitionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionId(String newPartitionId) {
		String oldPartitionId = partitionId;
		partitionId = newPartitionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_PARTITION_SCHEDULER__PARTITION_ID, oldPartitionId, partitionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<MarkovSchedulingState> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<MarkovSchedulingState>(MarkovSchedulingState.class, this, SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<MarkovSchedulingTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<MarkovSchedulingTransition>(MarkovSchedulingTransition.class, this, SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__ACTORS:
				return getActors();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__PARTITION_ID:
				return getPartitionId();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES:
				return getStates();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS:
				return getTransitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__PARTITION_ID:
				setPartitionId((String)newValue);
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends MarkovSchedulingState>)newValue);
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends MarkovSchedulingTransition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__ACTORS:
				getActors().clear();
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__PARTITION_ID:
				setPartitionId(PARTITION_ID_EDEFAULT);
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES:
				getStates().clear();
				return;
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS:
				getTransitions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__ACTORS:
				return actors != null && !actors.isEmpty();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__PARTITION_ID:
				return PARTITION_ID_EDEFAULT == null ? partitionId != null : !PARTITION_ID_EDEFAULT.equals(partitionId);
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__STATES:
				return states != null && !states.isEmpty();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (partitionId: ");
		result.append(partitionId);
		result.append(')');
		return result.toString();
	}

} //MarkovPartitionSchedulerImpl

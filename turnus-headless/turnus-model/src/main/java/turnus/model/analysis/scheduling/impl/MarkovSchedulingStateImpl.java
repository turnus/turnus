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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.SchedulingPackage;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Markov Scheduling State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkovSchedulingStateImpl extends MinimalEObjectImpl.Container implements MarkovSchedulingState {
	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected Actor actor;

	/**
	 * The default value of the '{@link #getFirings() <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long FIRINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFirings() <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirings()
	 * @generated
	 * @ordered
	 */
	protected long firings = FIRINGS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<MarkovSchedulingTransition> outgoings;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<MarkovSchedulingTransition> incomings;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkovSchedulingStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.MARKOV_SCHEDULING_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Actor getActor() {
		if (actor != null && actor.eIsProxy()) {
			InternalEObject oldActor = (InternalEObject)actor;
			actor = (Actor)eResolveProxy(oldActor);
			if (actor != oldActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR, oldActor, actor));
			}
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActor(Actor newActor) {
		Actor oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getFirings() {
		return firings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirings(long newFirings) {
		long oldFirings = firings;
		firings = newFirings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_STATE__FIRINGS, oldFirings, firings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MarkovSchedulingTransition> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<MarkovSchedulingTransition>(MarkovSchedulingTransition.class, this, SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MarkovSchedulingTransition> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<MarkovSchedulingTransition>(MarkovSchedulingTransition.class, this, SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
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
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__FIRINGS:
				return getFirings();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				return getOutgoings();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				return getIncomings();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__NAME:
				return getName();
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
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR:
				setActor((Actor)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__FIRINGS:
				setFirings((Long)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends MarkovSchedulingTransition>)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends MarkovSchedulingTransition>)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__NAME:
				setName((String)newValue);
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
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR:
				setActor((Actor)null);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__FIRINGS:
				setFirings(FIRINGS_EDEFAULT);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				getOutgoings().clear();
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				getIncomings().clear();
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__NAME:
				setName(NAME_EDEFAULT);
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
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__ACTOR:
				return actor != null;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__FIRINGS:
				return firings != FIRINGS_EDEFAULT;
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (firings: ");
		result.append(firings);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MarkovSchedulingStateImpl

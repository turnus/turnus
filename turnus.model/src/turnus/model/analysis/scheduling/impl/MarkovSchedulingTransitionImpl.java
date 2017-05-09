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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Markov Scheduling Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkovSchedulingTransitionImpl extends MinimalEObjectImpl.Container implements MarkovSchedulingTransition {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected MarkovSchedulingState source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected MarkovSchedulingState target;

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
	protected MarkovSchedulingTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.MARKOV_SCHEDULING_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingState getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (MarkovSchedulingState)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingState basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(MarkovSchedulingState newSource, NotificationChain msgs) {
		MarkovSchedulingState oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(MarkovSchedulingState newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS, MarkovSchedulingState.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS, MarkovSchedulingState.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingState getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (MarkovSchedulingState)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingState basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(MarkovSchedulingState newTarget, NotificationChain msgs) {
		MarkovSchedulingState oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(MarkovSchedulingState newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS, MarkovSchedulingState.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS, MarkovSchedulingState.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFirings() {
		return firings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirings(long newFirings) {
		long oldFirings = firings;
		firings = newFirings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__FIRINGS, oldFirings, firings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__OUTGOINGS, MarkovSchedulingState.class, msgs);
				return basicSetSource((MarkovSchedulingState)otherEnd, msgs);
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, SchedulingPackage.MARKOV_SCHEDULING_STATE__INCOMINGS, MarkovSchedulingState.class, msgs);
				return basicSetTarget((MarkovSchedulingState)otherEnd, msgs);
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
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				return basicSetSource(null, msgs);
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				return basicSetTarget(null, msgs);
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
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__FIRINGS:
				return getFirings();
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				setSource((MarkovSchedulingState)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				setTarget((MarkovSchedulingState)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__FIRINGS:
				setFirings((Long)newValue);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__NAME:
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
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				setSource((MarkovSchedulingState)null);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				setTarget((MarkovSchedulingState)null);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__FIRINGS:
				setFirings(FIRINGS_EDEFAULT);
				return;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__NAME:
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
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__SOURCE:
				return source != null;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__TARGET:
				return target != null;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__FIRINGS:
				return firings != FIRINGS_EDEFAULT;
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION__NAME:
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (firings: ");
		result.append(firings);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MarkovSchedulingTransitionImpl

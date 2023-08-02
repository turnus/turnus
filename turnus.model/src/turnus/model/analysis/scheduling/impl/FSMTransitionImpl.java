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
import turnus.model.analysis.scheduling.FSMCondition;
import turnus.model.analysis.scheduling.FSMTransition;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.analysis.scheduling.Sequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl#getCond <em>Cond</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl#getTargetStateEnumName <em>Target State Enum Name</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl#getSourceStateEnumName <em>Source State Enum Name</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl#getTransitionSchedule <em>Transition Schedule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMTransitionImpl extends MinimalEObjectImpl.Container implements FSMTransition {
	/**
	 * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCond()
	 * @generated
	 * @ordered
	 */
	protected FSMCondition cond;
	/**
	 * The default value of the '{@link #getTargetStateEnumName() <em>Target State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetStateEnumName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_STATE_ENUM_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTargetStateEnumName() <em>Target State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetStateEnumName()
	 * @generated
	 * @ordered
	 */
	protected String targetStateEnumName = TARGET_STATE_ENUM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceStateEnumName() <em>Source State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceStateEnumName()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_STATE_ENUM_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSourceStateEnumName() <em>Source State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceStateEnumName()
	 * @generated
	 * @ordered
	 */
	protected String sourceStateEnumName = SOURCE_STATE_ENUM_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getTransitionSchedule() <em>Transition Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionSchedule()
	 * @generated
	 * @ordered
	 */
	protected Sequence transitionSchedule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.FSM_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FSMCondition getCond() {
		return cond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCond(FSMCondition newCond, NotificationChain msgs) {
		FSMCondition oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__COND, oldCond, newCond);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCond(FSMCondition newCond) {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_TRANSITION__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_TRANSITION__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__COND, newCond, newCond));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetStateEnumName() {
		return targetStateEnumName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetStateEnumName(String newTargetStateEnumName) {
		String oldTargetStateEnumName = targetStateEnumName;
		targetStateEnumName = newTargetStateEnumName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__TARGET_STATE_ENUM_NAME, oldTargetStateEnumName, targetStateEnumName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceStateEnumName() {
		return sourceStateEnumName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceStateEnumName(String newSourceStateEnumName) {
		String oldSourceStateEnumName = sourceStateEnumName;
		sourceStateEnumName = newSourceStateEnumName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__SOURCE_STATE_ENUM_NAME, oldSourceStateEnumName, sourceStateEnumName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sequence getTransitionSchedule() {
		return transitionSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransitionSchedule(Sequence newTransitionSchedule, NotificationChain msgs) {
		Sequence oldTransitionSchedule = transitionSchedule;
		transitionSchedule = newTransitionSchedule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE, oldTransitionSchedule, newTransitionSchedule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransitionSchedule(Sequence newTransitionSchedule) {
		if (newTransitionSchedule != transitionSchedule) {
			NotificationChain msgs = null;
			if (transitionSchedule != null)
				msgs = ((InternalEObject)transitionSchedule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE, null, msgs);
			if (newTransitionSchedule != null)
				msgs = ((InternalEObject)newTransitionSchedule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE, null, msgs);
			msgs = basicSetTransitionSchedule(newTransitionSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE, newTransitionSchedule, newTransitionSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.FSM_TRANSITION__COND:
				return basicSetCond(null, msgs);
			case SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE:
				return basicSetTransitionSchedule(null, msgs);
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
			case SchedulingPackage.FSM_TRANSITION__COND:
				return getCond();
			case SchedulingPackage.FSM_TRANSITION__TARGET_STATE_ENUM_NAME:
				return getTargetStateEnumName();
			case SchedulingPackage.FSM_TRANSITION__SOURCE_STATE_ENUM_NAME:
				return getSourceStateEnumName();
			case SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE:
				return getTransitionSchedule();
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
			case SchedulingPackage.FSM_TRANSITION__COND:
				setCond((FSMCondition)newValue);
				return;
			case SchedulingPackage.FSM_TRANSITION__TARGET_STATE_ENUM_NAME:
				setTargetStateEnumName((String)newValue);
				return;
			case SchedulingPackage.FSM_TRANSITION__SOURCE_STATE_ENUM_NAME:
				setSourceStateEnumName((String)newValue);
				return;
			case SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE:
				setTransitionSchedule((Sequence)newValue);
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
			case SchedulingPackage.FSM_TRANSITION__COND:
				setCond((FSMCondition)null);
				return;
			case SchedulingPackage.FSM_TRANSITION__TARGET_STATE_ENUM_NAME:
				setTargetStateEnumName(TARGET_STATE_ENUM_NAME_EDEFAULT);
				return;
			case SchedulingPackage.FSM_TRANSITION__SOURCE_STATE_ENUM_NAME:
				setSourceStateEnumName(SOURCE_STATE_ENUM_NAME_EDEFAULT);
				return;
			case SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE:
				setTransitionSchedule((Sequence)null);
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
			case SchedulingPackage.FSM_TRANSITION__COND:
				return cond != null;
			case SchedulingPackage.FSM_TRANSITION__TARGET_STATE_ENUM_NAME:
				return TARGET_STATE_ENUM_NAME_EDEFAULT == null ? targetStateEnumName != null : !TARGET_STATE_ENUM_NAME_EDEFAULT.equals(targetStateEnumName);
			case SchedulingPackage.FSM_TRANSITION__SOURCE_STATE_ENUM_NAME:
				return SOURCE_STATE_ENUM_NAME_EDEFAULT == null ? sourceStateEnumName != null : !SOURCE_STATE_ENUM_NAME_EDEFAULT.equals(sourceStateEnumName);
			case SchedulingPackage.FSM_TRANSITION__TRANSITION_SCHEDULE:
				return transitionSchedule != null;
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
		result.append(" (targetStateEnumName: ");
		result.append(targetStateEnumName);
		result.append(", sourceStateEnumName: ");
		result.append(sourceStateEnumName);
		result.append(')');
		return result.toString();
	}

} //FSMTransitionImpl

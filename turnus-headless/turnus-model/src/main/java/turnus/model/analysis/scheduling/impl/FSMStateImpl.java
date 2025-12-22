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
import org.eclipse.emf.ecore.util.InternalEList;
import turnus.model.analysis.scheduling.FSMState;
import turnus.model.analysis.scheduling.FSMTransition;
import turnus.model.analysis.scheduling.FSMVarUpdate;
import turnus.model.analysis.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMStateImpl#getEnumName <em>Enum Name</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMStateImpl#getVarUpdates <em>Var Updates</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMStateImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMStateImpl extends MinimalEObjectImpl.Container implements FSMState {
	/**
	 * The default value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENUM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnumName() <em>Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumName()
	 * @generated
	 * @ordered
	 */
	protected String enumName = ENUM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVarUpdates() <em>Var Updates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarUpdates()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMVarUpdate> varUpdates;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMTransition> transitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMStateImpl() {
		super();
	}
	
	@Override
	public int hashCode(){
		return enumName.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		//TODO FIXME by definition, we have unique states and enumnames, so use that for hash and enum for now
		return (o instanceof FSMStateImpl && ((FSMStateImpl) o).enumName.equals(enumName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.FSM_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEnumName() {
		return enumName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnumName(String newEnumName) {
		String oldEnumName = enumName;
		enumName = newEnumName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_STATE__ENUM_NAME, oldEnumName, enumName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<FSMVarUpdate> getVarUpdates() {
		if (varUpdates == null) {
			varUpdates = new EObjectContainmentEList<FSMVarUpdate>(FSMVarUpdate.class, this, SchedulingPackage.FSM_STATE__VAR_UPDATES);
		}
		return varUpdates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<FSMTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<FSMTransition>(FSMTransition.class, this, SchedulingPackage.FSM_STATE__TRANSITIONS);
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
			case SchedulingPackage.FSM_STATE__VAR_UPDATES:
				return ((InternalEList<?>)getVarUpdates()).basicRemove(otherEnd, msgs);
			case SchedulingPackage.FSM_STATE__TRANSITIONS:
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
			case SchedulingPackage.FSM_STATE__ENUM_NAME:
				return getEnumName();
			case SchedulingPackage.FSM_STATE__VAR_UPDATES:
				return getVarUpdates();
			case SchedulingPackage.FSM_STATE__TRANSITIONS:
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
			case SchedulingPackage.FSM_STATE__ENUM_NAME:
				setEnumName((String)newValue);
				return;
			case SchedulingPackage.FSM_STATE__VAR_UPDATES:
				getVarUpdates().clear();
				getVarUpdates().addAll((Collection<? extends FSMVarUpdate>)newValue);
				return;
			case SchedulingPackage.FSM_STATE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends FSMTransition>)newValue);
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
			case SchedulingPackage.FSM_STATE__ENUM_NAME:
				setEnumName(ENUM_NAME_EDEFAULT);
				return;
			case SchedulingPackage.FSM_STATE__VAR_UPDATES:
				getVarUpdates().clear();
				return;
			case SchedulingPackage.FSM_STATE__TRANSITIONS:
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
			case SchedulingPackage.FSM_STATE__ENUM_NAME:
				return ENUM_NAME_EDEFAULT == null ? enumName != null : !ENUM_NAME_EDEFAULT.equals(enumName);
			case SchedulingPackage.FSM_STATE__VAR_UPDATES:
				return varUpdates != null && !varUpdates.isEmpty();
			case SchedulingPackage.FSM_STATE__TRANSITIONS:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enumName: ");
		result.append(enumName);
		result.append(')');
		return result.toString();
	}

} //FSMStateImpl

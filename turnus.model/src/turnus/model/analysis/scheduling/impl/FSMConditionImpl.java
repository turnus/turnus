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

import turnus.model.analysis.scheduling.FSMCombination;
import turnus.model.analysis.scheduling.FSMComparator;
import turnus.model.analysis.scheduling.FSMCondition;
import turnus.model.analysis.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl#getComp <em>Comp</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl#getCompval <em>Compval</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl#getCombinedCond <em>Combined Cond</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl#getValName <em>Val Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMConditionImpl extends MinimalEObjectImpl.Container implements FSMCondition {
	/**
	 * The default value of the '{@link #getComp() <em>Comp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComp()
	 * @generated
	 * @ordered
	 */
	protected static final FSMComparator COMP_EDEFAULT = FSMComparator.EQ;

	/**
	 * The cached value of the '{@link #getComp() <em>Comp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComp()
	 * @generated
	 * @ordered
	 */
	protected FSMComparator comp = COMP_EDEFAULT;

	/**
	 * This is true if the Comp attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean compESet;

	/**
	 * The default value of the '{@link #getCompval() <em>Compval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompval()
	 * @generated
	 * @ordered
	 */
	protected static final Integer COMPVAL_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getCompval() <em>Compval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompval()
	 * @generated
	 * @ordered
	 */
	protected Integer compval = COMPVAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCombinedCond() <em>Combined Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinedCond()
	 * @generated
	 * @ordered
	 */
	protected FSMCombination combinedCond;

	/**
	 * The default value of the '{@link #getValName() <em>Val Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValName()
	 * @generated
	 * @ordered
	 */
	protected static final String VAL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValName() <em>Val Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValName()
	 * @generated
	 * @ordered
	 */
	protected String valName = VAL_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.FSM_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMComparator getComp() {
		return comp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComp(FSMComparator newComp) {
		FSMComparator oldComp = comp;
		comp = newComp == null ? COMP_EDEFAULT : newComp;
		boolean oldCompESet = compESet;
		compESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_CONDITION__COMP, oldComp, comp, !oldCompESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetComp() {
		FSMComparator oldComp = comp;
		boolean oldCompESet = compESet;
		comp = COMP_EDEFAULT;
		compESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SchedulingPackage.FSM_CONDITION__COMP, oldComp, COMP_EDEFAULT, oldCompESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetComp() {
		return compESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getCompval() {
		return compval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompval(Integer newCompval) {
		Integer oldCompval = compval;
		compval = newCompval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_CONDITION__COMPVAL, oldCompval, compval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMCombination getCombinedCond() {
		return combinedCond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCombinedCond(FSMCombination newCombinedCond, NotificationChain msgs) {
		FSMCombination oldCombinedCond = combinedCond;
		combinedCond = newCombinedCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_CONDITION__COMBINED_COND, oldCombinedCond, newCombinedCond);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombinedCond(FSMCombination newCombinedCond) {
		if (newCombinedCond != combinedCond) {
			NotificationChain msgs = null;
			if (combinedCond != null)
				msgs = ((InternalEObject)combinedCond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_CONDITION__COMBINED_COND, null, msgs);
			if (newCombinedCond != null)
				msgs = ((InternalEObject)newCombinedCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulingPackage.FSM_CONDITION__COMBINED_COND, null, msgs);
			msgs = basicSetCombinedCond(newCombinedCond, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_CONDITION__COMBINED_COND, newCombinedCond, newCombinedCond));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValName() {
		return valName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValName(String newValName) {
		String oldValName = valName;
		valName = newValName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM_CONDITION__VAL_NAME, oldValName, valName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.FSM_CONDITION__COMBINED_COND:
				return basicSetCombinedCond(null, msgs);
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
			case SchedulingPackage.FSM_CONDITION__COMP:
				return getComp();
			case SchedulingPackage.FSM_CONDITION__COMPVAL:
				return getCompval();
			case SchedulingPackage.FSM_CONDITION__COMBINED_COND:
				return getCombinedCond();
			case SchedulingPackage.FSM_CONDITION__VAL_NAME:
				return getValName();
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
			case SchedulingPackage.FSM_CONDITION__COMP:
				setComp((FSMComparator)newValue);
				return;
			case SchedulingPackage.FSM_CONDITION__COMPVAL:
				setCompval((Integer)newValue);
				return;
			case SchedulingPackage.FSM_CONDITION__COMBINED_COND:
				setCombinedCond((FSMCombination)newValue);
				return;
			case SchedulingPackage.FSM_CONDITION__VAL_NAME:
				setValName((String)newValue);
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
			case SchedulingPackage.FSM_CONDITION__COMP:
				unsetComp();
				return;
			case SchedulingPackage.FSM_CONDITION__COMPVAL:
				setCompval(COMPVAL_EDEFAULT);
				return;
			case SchedulingPackage.FSM_CONDITION__COMBINED_COND:
				setCombinedCond((FSMCombination)null);
				return;
			case SchedulingPackage.FSM_CONDITION__VAL_NAME:
				setValName(VAL_NAME_EDEFAULT);
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
			case SchedulingPackage.FSM_CONDITION__COMP:
				return isSetComp();
			case SchedulingPackage.FSM_CONDITION__COMPVAL:
				return COMPVAL_EDEFAULT == null ? compval != null : !COMPVAL_EDEFAULT.equals(compval);
			case SchedulingPackage.FSM_CONDITION__COMBINED_COND:
				return combinedCond != null;
			case SchedulingPackage.FSM_CONDITION__VAL_NAME:
				return VAL_NAME_EDEFAULT == null ? valName != null : !VAL_NAME_EDEFAULT.equals(valName);
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
		result.append(" (comp: ");
		if (compESet) result.append(comp); else result.append("<unset>");
		result.append(", compval: ");
		result.append(compval);
		result.append(", valName: ");
		result.append(valName);
		result.append(')');
		return result.toString();
	}

} //FSMConditionImpl

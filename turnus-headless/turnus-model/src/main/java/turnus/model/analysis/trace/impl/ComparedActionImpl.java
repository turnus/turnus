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
package turnus.model.analysis.trace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.trace.ComparedAction;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compared Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedActionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedActionImpl#isFound <em>Found</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedActionImpl#getDSteps <em>DSteps</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedActionImpl#getDIncomings <em>DIncomings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedActionImpl#getDOutgoings <em>DOutgoings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComparedActionImpl extends MinimalEObjectImpl.Container implements ComparedAction {
	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The default value of the '{@link #isFound() <em>Found</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFound()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOUND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFound() <em>Found</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFound()
	 * @generated
	 * @ordered
	 */
	protected boolean found = FOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getDSteps() <em>DSteps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSteps()
	 * @generated
	 * @ordered
	 */
	protected static final long DSTEPS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDSteps() <em>DSteps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSteps()
	 * @generated
	 * @ordered
	 */
	protected long dSteps = DSTEPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDIncomings() <em>DIncomings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDIncomings()
	 * @generated
	 * @ordered
	 */
	protected static final long DINCOMINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDIncomings() <em>DIncomings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDIncomings()
	 * @generated
	 * @ordered
	 */
	protected long dIncomings = DINCOMINGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDOutgoings() <em>DOutgoings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDOutgoings()
	 * @generated
	 * @ordered
	 */
	protected static final long DOUTGOINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDOutgoings() <em>DOutgoings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDOutgoings()
	 * @generated
	 * @ordered
	 */
	protected long dOutgoings = DOUTGOINGS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComparedActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPARED_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.COMPARED_ACTION__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_ACTION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFound() {
		return found;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFound(boolean newFound) {
		boolean oldFound = found;
		found = newFound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_ACTION__FOUND, oldFound, found));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDSteps() {
		return dSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDSteps(long newDSteps) {
		long oldDSteps = dSteps;
		dSteps = newDSteps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_ACTION__DSTEPS, oldDSteps, dSteps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDIncomings() {
		return dIncomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDIncomings(long newDIncomings) {
		long oldDIncomings = dIncomings;
		dIncomings = newDIncomings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_ACTION__DINCOMINGS, oldDIncomings, dIncomings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDOutgoings() {
		return dOutgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDOutgoings(long newDOutgoings) {
		long oldDOutgoings = dOutgoings;
		dOutgoings = newDOutgoings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_ACTION__DOUTGOINGS, oldDOutgoings, dOutgoings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.COMPARED_ACTION__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case TracePackage.COMPARED_ACTION__FOUND:
				return isFound();
			case TracePackage.COMPARED_ACTION__DSTEPS:
				return getDSteps();
			case TracePackage.COMPARED_ACTION__DINCOMINGS:
				return getDIncomings();
			case TracePackage.COMPARED_ACTION__DOUTGOINGS:
				return getDOutgoings();
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
			case TracePackage.COMPARED_ACTION__ACTION:
				setAction((Action)newValue);
				return;
			case TracePackage.COMPARED_ACTION__FOUND:
				setFound((Boolean)newValue);
				return;
			case TracePackage.COMPARED_ACTION__DSTEPS:
				setDSteps((Long)newValue);
				return;
			case TracePackage.COMPARED_ACTION__DINCOMINGS:
				setDIncomings((Long)newValue);
				return;
			case TracePackage.COMPARED_ACTION__DOUTGOINGS:
				setDOutgoings((Long)newValue);
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
			case TracePackage.COMPARED_ACTION__ACTION:
				setAction((Action)null);
				return;
			case TracePackage.COMPARED_ACTION__FOUND:
				setFound(FOUND_EDEFAULT);
				return;
			case TracePackage.COMPARED_ACTION__DSTEPS:
				setDSteps(DSTEPS_EDEFAULT);
				return;
			case TracePackage.COMPARED_ACTION__DINCOMINGS:
				setDIncomings(DINCOMINGS_EDEFAULT);
				return;
			case TracePackage.COMPARED_ACTION__DOUTGOINGS:
				setDOutgoings(DOUTGOINGS_EDEFAULT);
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
			case TracePackage.COMPARED_ACTION__ACTION:
				return action != null;
			case TracePackage.COMPARED_ACTION__FOUND:
				return found != FOUND_EDEFAULT;
			case TracePackage.COMPARED_ACTION__DSTEPS:
				return dSteps != DSTEPS_EDEFAULT;
			case TracePackage.COMPARED_ACTION__DINCOMINGS:
				return dIncomings != DINCOMINGS_EDEFAULT;
			case TracePackage.COMPARED_ACTION__DOUTGOINGS:
				return dOutgoings != DOUTGOINGS_EDEFAULT;
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
		result.append(" (found: ");
		result.append(found);
		result.append(", dSteps: ");
		result.append(dSteps);
		result.append(", dIncomings: ");
		result.append(dIncomings);
		result.append(", dOutgoings: ");
		result.append(dOutgoings);
		result.append(')');
		return result.toString();
	}

} //ComparedActionImpl

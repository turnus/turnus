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
package turnus.model.analysis.pipelining.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.PipeliningPackage;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action Variable Pipelining Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl#getConsecutiveFirings <em>Consecutive Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl#getPipelinableFirings <em>Pipelinable Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl#isPipelinable <em>Pipelinable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionVariablePipeliningDataImpl extends MinimalEObjectImpl.Container
		implements ActionVariablePipeliningData {
	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The cached value of the '{@link #getConsecutiveFirings() <em>Consecutive Firings</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getConsecutiveFirings()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData consecutiveFirings;

	/**
	 * The cached value of the '{@link #getPipelinableFirings() <em>Pipelinable Firings</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPipelinableFirings()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData pipelinableFirings;

	/**
	 * The default value of the '{@link #isPipelinable() <em>Pipelinable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPipelinable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PIPELINABLE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionVariablePipeliningDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PipeliningPackage.Literals.ACTION_VARIABLE_PIPELINING_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalData getConsecutiveFirings() {
		return consecutiveFirings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsecutiveFirings(StatisticalData newConsecutiveFirings, NotificationChain msgs) {
		StatisticalData oldConsecutiveFirings = consecutiveFirings;
		consecutiveFirings = newConsecutiveFirings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS, oldConsecutiveFirings, newConsecutiveFirings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsecutiveFirings(StatisticalData newConsecutiveFirings) {
		if (newConsecutiveFirings != consecutiveFirings) {
			NotificationChain msgs = null;
			if (consecutiveFirings != null)
				msgs = ((InternalEObject)consecutiveFirings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS, null, msgs);
			if (newConsecutiveFirings != null)
				msgs = ((InternalEObject)newConsecutiveFirings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS, null, msgs);
			msgs = basicSetConsecutiveFirings(newConsecutiveFirings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS, newConsecutiveFirings, newConsecutiveFirings));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalData getPipelinableFirings() {
		return pipelinableFirings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPipelinableFirings(StatisticalData newPipelinableFirings, NotificationChain msgs) {
		StatisticalData oldPipelinableFirings = pipelinableFirings;
		pipelinableFirings = newPipelinableFirings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS, oldPipelinableFirings, newPipelinableFirings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPipelinableFirings(StatisticalData newPipelinableFirings) {
		if (newPipelinableFirings != pipelinableFirings) {
			NotificationChain msgs = null;
			if (pipelinableFirings != null)
				msgs = ((InternalEObject)pipelinableFirings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS, null, msgs);
			if (newPipelinableFirings != null)
				msgs = ((InternalEObject)newPipelinableFirings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS, null, msgs);
			msgs = basicSetPipelinableFirings(newPipelinableFirings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS, newPipelinableFirings, newPipelinableFirings));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isPipelinable() {
		StatisticalData pipelining = getPipelinableFirings();
		return pipelining.getSamples() > 0 && pipelining.getMin() > 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS:
				return basicSetConsecutiveFirings(null, msgs);
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS:
				return basicSetPipelinableFirings(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS:
				return getConsecutiveFirings();
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS:
				return getPipelinableFirings();
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE:
				return isPipelinable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION:
				setAction((Action)newValue);
				return;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS:
				setConsecutiveFirings((StatisticalData)newValue);
				return;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS:
				setPipelinableFirings((StatisticalData)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION:
				setAction((Action)null);
				return;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS:
				setConsecutiveFirings((StatisticalData)null);
				return;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS:
				setPipelinableFirings((StatisticalData)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__ACTION:
				return action != null;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS:
				return consecutiveFirings != null;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS:
				return pipelinableFirings != null;
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE:
				return isPipelinable() != PIPELINABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // ActionVariablePipeliningDataImpl

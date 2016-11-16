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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.ActionToLongMapImpl;

import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Markov Model Action Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl#isFirst <em>First</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl#getSuccessorsMap <em>Successors Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl#getSuccessors <em>Successors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkovModelActionDataImpl extends MinimalEObjectImpl.Container implements MarkovModelActionData {
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
	 * The default value of the '{@link #isFirst() <em>First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFirst()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FIRST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFirst() <em>First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFirst()
	 * @generated
	 * @ordered
	 */
	protected boolean first = FIRST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuccessorsMap() <em>Successors Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessorsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> successorsMap;

	/**
	 * The default value of the '{@link #getSuccessors() <em>Successors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected static final long SUCCESSORS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected long successors = SUCCESSORS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkovModelActionDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.MARKOV_MODEL_ACTION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION, oldAction, action));
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
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirst(boolean newFirst) {
		boolean oldFirst = first;
		first = newFirst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOV_MODEL_ACTION_DATA__FIRST, oldFirst, first));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getSuccessorsMap() {
		if (successorsMap == null) {
			successorsMap = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP);
		}
		return successorsMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSuccessors() {
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessors(long newSuccessors) {
		long oldSuccessors = successors;
		successors = newSuccessors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS, oldSuccessors, successors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getSuccessorsMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case TracePackage.MARKOV_MODEL_ACTION_DATA__FIRST:
				return isFirst();
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getSuccessorsMap()).eMap();
				else return getSuccessorsMap();
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS:
				return getSuccessors();
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
			case TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION:
				setAction((Action)newValue);
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__FIRST:
				setFirst((Boolean)newValue);
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getSuccessorsMap()).eMap()).set(newValue);
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS:
				setSuccessors((Long)newValue);
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
			case TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION:
				setAction((Action)null);
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__FIRST:
				setFirst(FIRST_EDEFAULT);
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP:
				getSuccessorsMap().clear();
				return;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS:
				setSuccessors(SUCCESSORS_EDEFAULT);
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
			case TracePackage.MARKOV_MODEL_ACTION_DATA__ACTION:
				return action != null;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__FIRST:
				return first != FIRST_EDEFAULT;
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP:
				return successorsMap != null && !successorsMap.isEmpty();
			case TracePackage.MARKOV_MODEL_ACTION_DATA__SUCCESSORS:
				return successors != SUCCESSORS_EDEFAULT;
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
		result.append(" (first: ");
		result.append(first);
		result.append(", successors: ");
		result.append(successors);
		result.append(')');
		return result.toString();
	}

} //MarkovModelActionDataImpl

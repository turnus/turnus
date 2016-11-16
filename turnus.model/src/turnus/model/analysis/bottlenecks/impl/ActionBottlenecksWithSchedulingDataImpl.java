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
package turnus.model.analysis.bottlenecks.impl;

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
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;

import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.BufferToDoubleMapImpl;
import turnus.model.analysis.map.impl.BufferToIntegerMapImpl;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Bottlenecks With Scheduling Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getTotalFirings <em>Total Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl#getBlockingInstances <em>Blocking Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionBottlenecksWithSchedulingDataImpl extends MinimalEObjectImpl.Container implements ActionBottlenecksWithSchedulingData {
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
	 * The default value of the '{@link #getCpWeight() <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCpWeight() <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpWeight()
	 * @generated
	 * @ordered
	 */
	protected double cpWeight = CP_WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalWeight() <em>Total Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalWeight() <em>Total Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalWeight()
	 * @generated
	 * @ordered
	 */
	protected double totalWeight = TOTAL_WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpFirings() <em>Cp Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long CP_FIRINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCpFirings() <em>Cp Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpFirings()
	 * @generated
	 * @ordered
	 */
	protected long cpFirings = CP_FIRINGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalFirings() <em>Total Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_FIRINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalFirings() <em>Total Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalFirings()
	 * @generated
	 * @ordered
	 */
	protected long totalFirings = TOTAL_FIRINGS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaxBlockedOutputTokens() <em>Max Blocked Output Tokens</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBlockedOutputTokens()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Integer> maxBlockedOutputTokens;

	/**
	 * The cached value of the '{@link #getMaxBlockedMultiplication() <em>Max Blocked Multiplication</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBlockedMultiplication()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Double> maxBlockedMultiplication;

	/**
	 * The cached value of the '{@link #getBlockingInstances() <em>Blocking Instances</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockingInstances()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Integer> blockingInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionBottlenecksWithSchedulingDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BottlenecksPackage.Literals.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION, oldAction, action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCpWeight() {
		return cpWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpWeight(double newCpWeight) {
		double oldCpWeight = cpWeight;
		cpWeight = newCpWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT, oldCpWeight, cpWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalWeight() {
		return totalWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalWeight(double newTotalWeight) {
		double oldTotalWeight = totalWeight;
		totalWeight = newTotalWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT, oldTotalWeight, totalWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCpFirings() {
		return cpFirings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpFirings(long newCpFirings) {
		long oldCpFirings = cpFirings;
		cpFirings = newCpFirings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS, oldCpFirings, cpFirings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalFirings() {
		return totalFirings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFirings(long newTotalFirings) {
		long oldTotalFirings = totalFirings;
		totalFirings = newTotalFirings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS, oldTotalFirings, totalFirings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Buffer, Integer> getMaxBlockedOutputTokens() {
		if (maxBlockedOutputTokens == null) {
			maxBlockedOutputTokens = new EcoreEMap<Buffer,Integer>(MapPackage.Literals.BUFFER_TO_INTEGER_MAP, BufferToIntegerMapImpl.class, this, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS);
		}
		return maxBlockedOutputTokens.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Buffer, Double> getMaxBlockedMultiplication() {
		if (maxBlockedMultiplication == null) {
			maxBlockedMultiplication = new EcoreEMap<Buffer,Double>(MapPackage.Literals.BUFFER_TO_DOUBLE_MAP, BufferToDoubleMapImpl.class, this, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION);
		}
		return maxBlockedMultiplication.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Buffer, Integer> getBlockingInstances() {
		if (blockingInstances == null) {
			blockingInstances = new EcoreEMap<Buffer,Integer>(MapPackage.Literals.BUFFER_TO_INTEGER_MAP, BufferToIntegerMapImpl.class, this, BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES);
		}
		return blockingInstances.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap()).basicRemove(otherEnd, msgs);
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT:
				return getCpWeight();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT:
				return getTotalWeight();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS:
				return getCpFirings();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS:
				return getTotalFirings();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS:
				if (coreType) return ((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap();
				else return getMaxBlockedOutputTokens();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION:
				if (coreType) return ((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap();
				else return getMaxBlockedMultiplication();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES:
				if (coreType) return ((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap();
				else return getBlockingInstances();
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION:
				setAction((Action)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT:
				setCpWeight((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT:
				setTotalWeight((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS:
				setCpFirings((Long)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS:
				setTotalFirings((Long)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap()).set(newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap()).set(newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap()).set(newValue);
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION:
				setAction((Action)null);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT:
				setCpWeight(CP_WEIGHT_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT:
				setTotalWeight(TOTAL_WEIGHT_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS:
				setCpFirings(CP_FIRINGS_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS:
				setTotalFirings(TOTAL_FIRINGS_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS:
				getMaxBlockedOutputTokens().clear();
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION:
				getMaxBlockedMultiplication().clear();
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES:
				getBlockingInstances().clear();
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION:
				return action != null;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT:
				return cpWeight != CP_WEIGHT_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT:
				return totalWeight != TOTAL_WEIGHT_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS:
				return cpFirings != CP_FIRINGS_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS:
				return totalFirings != TOTAL_FIRINGS_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS:
				return maxBlockedOutputTokens != null && !maxBlockedOutputTokens.isEmpty();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION:
				return maxBlockedMultiplication != null && !maxBlockedMultiplication.isEmpty();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES:
				return blockingInstances != null && !blockingInstances.isEmpty();
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
		result.append(" (cpWeight: ");
		result.append(cpWeight);
		result.append(", totalWeight: ");
		result.append(totalWeight);
		result.append(", cpFirings: ");
		result.append(cpFirings);
		result.append(", totalFirings: ");
		result.append(totalFirings);
		result.append(')');
		return result.toString();
	}

} //ActionBottlenecksWithSchedulingDataImpl

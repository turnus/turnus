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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Bottlenecks Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getSlackMin <em>Slack Min</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getSlackMax <em>Slack Max</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getCpVariance <em>Cp Variance</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getTotalVariance <em>Total Variance</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl#getTotalFirings <em>Total Firings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionBottlenecksDataImpl extends MinimalEObjectImpl.Container implements ActionBottlenecksData {
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
	 * The default value of the '{@link #getSlackMin() <em>Slack Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlackMin()
	 * @generated
	 * @ordered
	 */
	protected static final double SLACK_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSlackMin() <em>Slack Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlackMin()
	 * @generated
	 * @ordered
	 */
	protected double slackMin = SLACK_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSlackMax() <em>Slack Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlackMax()
	 * @generated
	 * @ordered
	 */
	protected static final double SLACK_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSlackMax() <em>Slack Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlackMax()
	 * @generated
	 * @ordered
	 */
	protected double slackMax = SLACK_MAX_EDEFAULT;

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
	 * The default value of the '{@link #getCpVariance() <em>Cp Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpVariance()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_VARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCpVariance() <em>Cp Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpVariance()
	 * @generated
	 * @ordered
	 */
	protected double cpVariance = CP_VARIANCE_EDEFAULT;

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
	 * The default value of the '{@link #getTotalVariance() <em>Total Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVariance()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_VARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalVariance() <em>Total Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVariance()
	 * @generated
	 * @ordered
	 */
	protected double totalVariance = TOTAL_VARIANCE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionBottlenecksDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BottlenecksPackage.Literals.ACTION_BOTTLENECKS_DATA;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION, oldAction, action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION, oldAction, action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_WEIGHT, oldCpWeight, cpWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCpVariance() {
		return cpVariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpVariance(double newCpVariance) {
		double oldCpVariance = cpVariance;
		cpVariance = newCpVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_VARIANCE, oldCpVariance, cpVariance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT, oldTotalWeight, totalWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalVariance() {
		return totalVariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalVariance(double newTotalVariance) {
		double oldTotalVariance = totalVariance;
		totalVariance = newTotalVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE, oldTotalVariance, totalVariance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_FIRINGS, oldCpFirings, cpFirings));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS, oldTotalFirings, totalFirings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSlackMin() {
		return slackMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlackMin(double newSlackMin) {
		double oldSlackMin = slackMin;
		slackMin = newSlackMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MIN, oldSlackMin, slackMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSlackMax() {
		return slackMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlackMax(double newSlackMax) {
		double oldSlackMax = slackMax;
		slackMax = newSlackMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MAX, oldSlackMax, slackMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MIN:
				return getSlackMin();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MAX:
				return getSlackMax();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_WEIGHT:
				return getCpWeight();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_VARIANCE:
				return getCpVariance();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT:
				return getTotalWeight();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE:
				return getTotalVariance();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_FIRINGS:
				return getCpFirings();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS:
				return getTotalFirings();
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION:
				setAction((Action)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MIN:
				setSlackMin((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MAX:
				setSlackMax((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_WEIGHT:
				setCpWeight((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_VARIANCE:
				setCpVariance((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT:
				setTotalWeight((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE:
				setTotalVariance((Double)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_FIRINGS:
				setCpFirings((Long)newValue);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS:
				setTotalFirings((Long)newValue);
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION:
				setAction((Action)null);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MIN:
				setSlackMin(SLACK_MIN_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MAX:
				setSlackMax(SLACK_MAX_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_WEIGHT:
				setCpWeight(CP_WEIGHT_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_VARIANCE:
				setCpVariance(CP_VARIANCE_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT:
				setTotalWeight(TOTAL_WEIGHT_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE:
				setTotalVariance(TOTAL_VARIANCE_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_FIRINGS:
				setCpFirings(CP_FIRINGS_EDEFAULT);
				return;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS:
				setTotalFirings(TOTAL_FIRINGS_EDEFAULT);
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
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__ACTION:
				return action != null;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MIN:
				return slackMin != SLACK_MIN_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__SLACK_MAX:
				return slackMax != SLACK_MAX_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_WEIGHT:
				return cpWeight != CP_WEIGHT_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_VARIANCE:
				return cpVariance != CP_VARIANCE_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT:
				return totalWeight != TOTAL_WEIGHT_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE:
				return totalVariance != TOTAL_VARIANCE_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__CP_FIRINGS:
				return cpFirings != CP_FIRINGS_EDEFAULT;
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS:
				return totalFirings != TOTAL_FIRINGS_EDEFAULT;
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
		result.append(" (slackMin: ");
		result.append(slackMin);
		result.append(", slackMax: ");
		result.append(slackMax);
		result.append(", cpWeight: ");
		result.append(cpWeight);
		result.append(", cpVariance: ");
		result.append(cpVariance);
		result.append(", totalWeight: ");
		result.append(totalWeight);
		result.append(", totalVariance: ");
		result.append(totalVariance);
		result.append(", cpFirings: ");
		result.append(cpFirings);
		result.append(", totalFirings: ");
		result.append(totalFirings);
		result.append(')');
		return result.toString();
	}

} //ActionBottlenecksDataImpl

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

import java.util.Collection;
import java.util.Date;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;

import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.StringToDoubleMapImpl;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>With Scheduling Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getActionsData <em>Actions Data</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getTotalFirings <em>Total Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getCpBlockingTime <em>Cp Blocking Time</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl#getCpPartitionsBlockingTime <em>Cp Partitions Blocking Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BottlenecksWithSchedulingReportImpl extends MinimalEObjectImpl.Container
		implements BottlenecksWithSchedulingReport {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The cached value of the '{@link #getActionsData() <em>Actions Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionsData()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionBottlenecksWithSchedulingData> actionsData;

	/**
	 * The default value of the '{@link #getCpWeight() <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCpWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getTotalWeight() <em>Total Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getCpFirings() <em>Cp Firings</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCpFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long CP_FIRINGS_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getTotalFirings() <em>Total Firings</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTotalFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_FIRINGS_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final double EXECUTION_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected double executionTime = EXECUTION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpBlockingTime() <em>Cp Blocking Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpBlockingTime()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_BLOCKING_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCpPartitionsBlockingTime() <em>Cp Partitions Blocking Time</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpPartitionsBlockingTime()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Double> cpPartitionsBlockingTime;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BottlenecksWithSchedulingReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BottlenecksPackage.Literals.BOTTLENECKS_WITH_SCHEDULING_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ActionBottlenecksWithSchedulingData> getActionsData() {
		if (actionsData == null) {
			actionsData = new EObjectContainmentEList<ActionBottlenecksWithSchedulingData>(ActionBottlenecksWithSchedulingData.class, this, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA);
		}
		return actionsData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getCpWeight() {
		double sum = 0;
		for (ActionBottlenecksWithSchedulingData data : getActionsData()) {
			sum += data.getCpWeight();
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getTotalWeight() {
		double sum = 0;
		for (ActionBottlenecksWithSchedulingData data : getActionsData()) {
			sum += data.getTotalWeight();
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getCpFirings() {
		long sum = 0;
		for (ActionBottlenecksWithSchedulingData data : getActionsData()) {
			sum += data.getCpFirings();
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getTotalFirings() {
		long sum = 0;
		for (ActionBottlenecksWithSchedulingData data : getActionsData()) {
			sum += data.getTotalFirings();
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getExecutionTime() {
		return executionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutionTime(double newExecutionTime) {
		double oldExecutionTime = executionTime;
		executionTime = newExecutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME, oldExecutionTime, executionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getCpBlockingTime() {
		return getExecutionTime() - getCpWeight();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Double> getCpPartitionsBlockingTime() {
		if (cpPartitionsBlockingTime == null) {
			cpPartitionsBlockingTime = new EcoreEMap<String,Double>(MapPackage.Literals.STRING_TO_DOUBLE_MAP, StringToDoubleMapImpl.class, this, BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME);
		}
		return cpPartitionsBlockingTime.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA:
				return ((InternalEList<?>)getActionsData()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Double>)getCpPartitionsBlockingTime()).eMap()).basicRemove(otherEnd, msgs);
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
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM:
				return getAlgorithm();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE:
				return getDate();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA:
				return getActionsData();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_WEIGHT:
				return getCpWeight();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_WEIGHT:
				return getTotalWeight();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_FIRINGS:
				return getCpFirings();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_FIRINGS:
				return getTotalFirings();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME:
				return getExecutionTime();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_BLOCKING_TIME:
				return getCpBlockingTime();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME:
				if (coreType) return ((EMap.InternalMapView<String, Double>)getCpPartitionsBlockingTime()).eMap();
				else return getCpPartitionsBlockingTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA:
				getActionsData().clear();
				getActionsData().addAll((Collection<? extends ActionBottlenecksWithSchedulingData>)newValue);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME:
				setExecutionTime((Double)newValue);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Double>)getCpPartitionsBlockingTime()).eMap()).set(newValue);
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
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA:
				getActionsData().clear();
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME:
				setExecutionTime(EXECUTION_TIME_EDEFAULT);
				return;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME:
				getCpPartitionsBlockingTime().clear();
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
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK:
				return network != null;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA:
				return actionsData != null && !actionsData.isEmpty();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_WEIGHT:
				return getCpWeight() != CP_WEIGHT_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_WEIGHT:
				return getTotalWeight() != TOTAL_WEIGHT_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_FIRINGS:
				return getCpFirings() != CP_FIRINGS_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_FIRINGS:
				return getTotalFirings() != TOTAL_FIRINGS_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME:
				return executionTime != EXECUTION_TIME_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_BLOCKING_TIME:
				return getCpBlockingTime() != CP_BLOCKING_TIME_EDEFAULT;
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME:
				return cpPartitionsBlockingTime != null && !cpPartitionsBlockingTime.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {

		StringBuffer b = new StringBuffer();
		b.append("\n[SCHEDULED BOTTLENECK ANALYSIS REPORT]");
		b.append(String.format("\n Network..........: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithms.......: %s", getAlgorithm()));
		double w = getTotalWeight();
		long firings = getTotalFirings();
		double cp = getCpWeight();
		long cpFirings = getCpFirings();
		b.append(String.format("\n Execution time...: %f", executionTime));
		b.append(String.format("\n Total workload...: %f", w));
		b.append(String.format("\n CP workload......: %f (%s", cp, StringUtils.format(cp / w * 100)) + "%)");
		b.append(String.format("\n CP Blocking time.: %f", getCpBlockingTime()));
		b.append(String.format("\n Total firings....: %d", firings));
		b.append(String.format("\n CP firings.......: %d (%s", cpFirings, StringUtils.format(((double) cpFirings / firings) * 100)) + "%)");
		b.append("\n\n");
		return b.toString();
	}

} // BottlenecksWithSchedulingReportImpl

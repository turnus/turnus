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
package turnus.model.analysis.profiler.impl;

import java.util.Collection;
import java.util.Date;
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

import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.analysis.profiler.ProfilerPackage;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dynamic Profiling Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl#getActorsData <em>Actors Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl#getBuffersData <em>Buffers Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DynamicProfilingReportImpl extends MinimalEObjectImpl.Container implements DynamicProfilingReport {
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
	 * The cached value of the '{@link #getActorsData() <em>Actors Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActorsData()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorDynamicData> actorsData;

	/**
	 * The cached value of the '{@link #getBuffersData() <em>Buffers Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBuffersData()
	 * @generated
	 * @ordered
	 */
	protected EList<BufferDynamicData> buffersData;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicProfilingReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.DYNAMIC_PROFILING_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.DYNAMIC_PROFILING_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.DYNAMIC_PROFILING_REPORT__DATE, oldDate, date));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ActorDynamicData> getActorsData() {
		if (actorsData == null) {
			actorsData = new EObjectContainmentEList<ActorDynamicData>(ActorDynamicData.class, this, ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA);
		}
		return actorsData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<BufferDynamicData> getBuffersData() {
		if (buffersData == null) {
			buffersData = new EObjectContainmentEList<BufferDynamicData>(BufferDynamicData.class, this, ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA);
		}
		return buffersData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA:
				return ((InternalEList<?>)getActorsData()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA:
				return ((InternalEList<?>)getBuffersData()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ALGORITHM:
				return getAlgorithm();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__DATE:
				return getDate();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA:
				return getActorsData();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA:
				return getBuffersData();
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
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA:
				getActorsData().clear();
				getActorsData().addAll((Collection<? extends ActorDynamicData>)newValue);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
				getBuffersData().addAll((Collection<? extends BufferDynamicData>)newValue);
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
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA:
				getActorsData().clear();
				return;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
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
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__NETWORK:
				return network != null;
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__ACTORS_DATA:
				return actorsData != null && !actorsData.isEmpty();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT__BUFFERS_DATA:
				return buffersData != null && !buffersData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} // DynamicProfilingReportImpl

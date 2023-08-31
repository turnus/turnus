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
package turnus.model.analysis.profiling.impl;

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
import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.ActorToStringMapImpl;
import turnus.model.analysis.map.impl.BufferToIntegerMapImpl;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inter Partition Communication And Memory Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getPartitionData <em>Partition Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#isOutgoingBufferOwnedBySource <em>Outgoing Buffer Owned By Source</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getBufferDepthMap <em>Buffer Depth Map</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getActorPartitionMap <em>Actor Partition Map</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getTime <em>Time</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#isDeadlock <em>Deadlock</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getCpWeightScheduled <em>Cp Weight Scheduled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterPartitionCommunicationAndMemoryReportImpl extends MinimalEObjectImpl.Container implements InterPartitionCommunicationAndMemoryReport {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPartitionData() <em>Partition Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionData()
	 * @generated
	 * @ordered
	 */
	protected EList<InterPartitionData> partitionData;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The default value of the '{@link #isOutgoingBufferOwnedBySource() <em>Outgoing Buffer Owned By Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutgoingBufferOwnedBySource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUTGOING_BUFFER_OWNED_BY_SOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOutgoingBufferOwnedBySource() <em>Outgoing Buffer Owned By Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutgoingBufferOwnedBySource()
	 * @generated
	 * @ordered
	 */
	protected boolean outgoingBufferOwnedBySource = OUTGOING_BUFFER_OWNED_BY_SOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBufferDepthMap() <em>Buffer Depth Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferDepthMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Integer> bufferDepthMap;

	/**
	 * The cached value of the '{@link #getActorPartitionMap() <em>Actor Partition Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorPartitionMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, String> actorPartitionMap;

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
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected double time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeadlock() <em>Deadlock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeadlock()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEADLOCK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeadlock() <em>Deadlock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeadlock()
	 * @generated
	 * @ordered
	 */
	protected boolean deadlock = DEADLOCK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpWeightScheduled() <em>Cp Weight Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpWeightScheduled()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_WEIGHT_SCHEDULED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCpWeightScheduled() <em>Cp Weight Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpWeightScheduled()
	 * @generated
	 * @ordered
	 */
	protected double cpWeightScheduled = CP_WEIGHT_SCHEDULED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterPartitionCommunicationAndMemoryReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<InterPartitionData> getPartitionData() {
		if (partitionData == null) {
			partitionData = new EObjectContainmentEList<InterPartitionData>(InterPartitionData.class, this, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA);
		}
		return partitionData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOutgoingBufferOwnedBySource() {
		return outgoingBufferOwnedBySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutgoingBufferOwnedBySource(boolean newOutgoingBufferOwnedBySource) {
		boolean oldOutgoingBufferOwnedBySource = outgoingBufferOwnedBySource;
		outgoingBufferOwnedBySource = newOutgoingBufferOwnedBySource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE, oldOutgoingBufferOwnedBySource, outgoingBufferOwnedBySource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, Integer> getBufferDepthMap() {
		if (bufferDepthMap == null) {
			bufferDepthMap = new EcoreEMap<Buffer,Integer>(MapPackage.Literals.BUFFER_TO_INTEGER_MAP, BufferToIntegerMapImpl.class, this, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP);
		}
		return bufferDepthMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Actor, String> getActorPartitionMap() {
		if (actorPartitionMap == null) {
			actorPartitionMap = new EcoreEMap<Actor,String>(MapPackage.Literals.ACTOR_TO_STRING_MAP, ActorToStringMapImpl.class, this, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP);
		}
		return actorPartitionMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCpWeight() {
		return cpWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCpWeight(double newCpWeight) {
		double oldCpWeight = cpWeight;
		cpWeight = newCpWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT, oldCpWeight, cpWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTime(double newTime) {
		double oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDeadlock() {
		return deadlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeadlock(boolean newDeadlock) {
		boolean oldDeadlock = deadlock;
		deadlock = newDeadlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK, oldDeadlock, deadlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCpWeightScheduled() {
		return cpWeightScheduled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCpWeightScheduled(double newCpWeightScheduled) {
		double oldCpWeightScheduled = cpWeightScheduled;
		cpWeightScheduled = newCpWeightScheduled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED, oldCpWeightScheduled, cpWeightScheduled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return ((InternalEList<?>)getPartitionData()).basicRemove(otherEnd, msgs);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Integer>)getBufferDepthMap()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, String>)getActorPartitionMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				return getAlgorithm();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				return getDate();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return getPartitionData();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE:
				return isOutgoingBufferOwnedBySource();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP:
				if (coreType) return ((EMap.InternalMapView<Buffer, Integer>)getBufferDepthMap()).eMap();
				else return getBufferDepthMap();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, String>)getActorPartitionMap()).eMap();
				else return getActorPartitionMap();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT:
				return getCpWeight();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME:
				return getTime();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK:
				return isDeadlock();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED:
				return getCpWeightScheduled();
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				getPartitionData().clear();
				getPartitionData().addAll((Collection<? extends InterPartitionData>)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE:
				setOutgoingBufferOwnedBySource((Boolean)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Integer>)getBufferDepthMap()).eMap()).set(newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, String>)getActorPartitionMap()).eMap()).set(newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT:
				setCpWeight((Double)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME:
				setTime((Double)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK:
				setDeadlock((Boolean)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED:
				setCpWeightScheduled((Double)newValue);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				getPartitionData().clear();
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE:
				setOutgoingBufferOwnedBySource(OUTGOING_BUFFER_OWNED_BY_SOURCE_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP:
				getBufferDepthMap().clear();
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP:
				getActorPartitionMap().clear();
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT:
				setCpWeight(CP_WEIGHT_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK:
				setDeadlock(DEADLOCK_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED:
				setCpWeightScheduled(CP_WEIGHT_SCHEDULED_EDEFAULT);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return partitionData != null && !partitionData.isEmpty();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK:
				return network != null;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE:
				return outgoingBufferOwnedBySource != OUTGOING_BUFFER_OWNED_BY_SOURCE_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP:
				return bufferDepthMap != null && !bufferDepthMap.isEmpty();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP:
				return actorPartitionMap != null && !actorPartitionMap.isEmpty();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT:
				return cpWeight != CP_WEIGHT_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME:
				return time != TIME_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK:
				return deadlock != DEADLOCK_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED:
				return cpWeightScheduled != CP_WEIGHT_SCHEDULED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder b = new StringBuilder(super.toString());
		b.append("\n[INTER PARTITION COMMUNICATION AND MEMORY REPORT]");
		b.append(String.format("\n Network.....: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithm..: %s", getAlgorithm()));
		
		b.append("\n");
		return b.toString();
	}

} //InterPartitionCommunicationAndMemoryReportImpl

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
package turnus.model.analysis.postprocessing.impl;

import java.util.Collection;
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.StringToDoubleMapImpl;

import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Statistics Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getIdleTimes <em>Idle Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getBlockedReadingTimes <em>Blocked Reading Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getBlockedWritingTimes <em>Blocked Writing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getProcessingTimes <em>Processing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getAverageOccupancy <em>Average Occupancy</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl#getOccupancyDeviation <em>Occupancy Deviation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorStatisticsReportImpl extends PostProcessingDataImpl implements ActorStatisticsReport {
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
	 * The cached value of the '{@link #getPartitions() <em>Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<StatisticalActorPartition> partitions;

	/**
	 * The cached value of the '{@link #getIdleTimes() <em>Idle Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdleTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Double> idleTimes;

	/**
	 * The cached value of the '{@link #getBlockedReadingTimes() <em>Blocked Reading Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedReadingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Double> blockedReadingTimes;

	/**
	 * The cached value of the '{@link #getBlockedWritingTimes() <em>Blocked Writing Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedWritingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Double> blockedWritingTimes;

	/**
	 * The cached value of the '{@link #getProcessingTimes() <em>Processing Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Double> processingTimes;

	/**
	 * The default value of the '{@link #getAverageOccupancy() <em>Average Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageOccupancy()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_OCCUPANCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageOccupancy() <em>Average Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageOccupancy()
	 * @generated
	 * @ordered
	 */
	protected double averageOccupancy = AVERAGE_OCCUPANCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOccupancyDeviation() <em>Occupancy Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupancyDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final double OCCUPANCY_DEVIATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOccupancyDeviation() <em>Occupancy Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupancyDeviation()
	 * @generated
	 * @ordered
	 */
	protected double occupancyDeviation = OCCUPANCY_DEVIATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorStatisticsReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.ACTOR_STATISTICS_REPORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.ACTOR_STATISTICS_REPORT__EXECUTION_TIME, oldExecutionTime, executionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<StatisticalActorPartition> getPartitions() {
		if (partitions == null) {
			partitions = new EObjectContainmentEList<StatisticalActorPartition>(StatisticalActorPartition.class, this, PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS);
		}
		return partitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Double> getIdleTimes() {
		if (idleTimes == null) {
			idleTimes = new EcoreEMap<String,Double>(MapPackage.Literals.STRING_TO_DOUBLE_MAP, StringToDoubleMapImpl.class, this, PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES);
		}
		return idleTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Double> getBlockedReadingTimes() {
		if (blockedReadingTimes == null) {
			blockedReadingTimes = new EcoreEMap<String,Double>(MapPackage.Literals.STRING_TO_DOUBLE_MAP, StringToDoubleMapImpl.class, this, PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES);
		}
		return blockedReadingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Double> getBlockedWritingTimes() {
		if (blockedWritingTimes == null) {
			blockedWritingTimes = new EcoreEMap<String,Double>(MapPackage.Literals.STRING_TO_DOUBLE_MAP, StringToDoubleMapImpl.class, this, PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES);
		}
		return blockedWritingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Double> getProcessingTimes() {
		if (processingTimes == null) {
			processingTimes = new EcoreEMap<String,Double>(MapPackage.Literals.STRING_TO_DOUBLE_MAP, StringToDoubleMapImpl.class, this, PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES);
		}
		return processingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getAverageOccupancy() {
		return averageOccupancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAverageOccupancy(double newAverageOccupancy) {
		double oldAverageOccupancy = averageOccupancy;
		averageOccupancy = newAverageOccupancy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY, oldAverageOccupancy, averageOccupancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOccupancyDeviation() {
		return occupancyDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOccupancyDeviation(double newOccupancyDeviation) {
		double oldOccupancyDeviation = occupancyDeviation;
		occupancyDeviation = newOccupancyDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION, oldOccupancyDeviation, occupancyDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS:
				return ((InternalEList<?>)getPartitions()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Double>)getIdleTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Double>)getBlockedReadingTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Double>)getBlockedWritingTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Double>)getProcessingTimes()).eMap()).basicRemove(otherEnd, msgs);
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
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__EXECUTION_TIME:
				return getExecutionTime();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS:
				return getPartitions();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES:
				if (coreType) return ((EMap.InternalMapView<String, Double>)getIdleTimes()).eMap();
				else return getIdleTimes();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				if (coreType) return ((EMap.InternalMapView<String, Double>)getBlockedReadingTimes()).eMap();
				else return getBlockedReadingTimes();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				if (coreType) return ((EMap.InternalMapView<String, Double>)getBlockedWritingTimes()).eMap();
				else return getBlockedWritingTimes();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES:
				if (coreType) return ((EMap.InternalMapView<String, Double>)getProcessingTimes()).eMap();
				else return getProcessingTimes();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY:
				return getAverageOccupancy();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION:
				return getOccupancyDeviation();
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
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__EXECUTION_TIME:
				setExecutionTime((Double)newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS:
				getPartitions().clear();
				getPartitions().addAll((Collection<? extends StatisticalActorPartition>)newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Double>)getIdleTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Double>)getBlockedReadingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Double>)getBlockedWritingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Double>)getProcessingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY:
				setAverageOccupancy((Double)newValue);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION:
				setOccupancyDeviation((Double)newValue);
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
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__EXECUTION_TIME:
				setExecutionTime(EXECUTION_TIME_EDEFAULT);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS:
				getPartitions().clear();
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES:
				getIdleTimes().clear();
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				getBlockedReadingTimes().clear();
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				getBlockedWritingTimes().clear();
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES:
				getProcessingTimes().clear();
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY:
				setAverageOccupancy(AVERAGE_OCCUPANCY_EDEFAULT);
				return;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION:
				setOccupancyDeviation(OCCUPANCY_DEVIATION_EDEFAULT);
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
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__NETWORK:
				return network != null;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__EXECUTION_TIME:
				return executionTime != EXECUTION_TIME_EDEFAULT;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PARTITIONS:
				return partitions != null && !partitions.isEmpty();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__IDLE_TIMES:
				return idleTimes != null && !idleTimes.isEmpty();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				return blockedReadingTimes != null && !blockedReadingTimes.isEmpty();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				return blockedWritingTimes != null && !blockedWritingTimes.isEmpty();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__PROCESSING_TIMES:
				return processingTimes != null && !processingTimes.isEmpty();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY:
				return averageOccupancy != AVERAGE_OCCUPANCY_EDEFAULT;
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION:
				return occupancyDeviation != OCCUPANCY_DEVIATION_EDEFAULT;
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
		b.append("\n[POST PROCESSING REPORT (ACTOR LEVEL)]");
		b.append(String.format("\n Number of partitions..............: %s", getPartitions().size()));
		b.append(String.format("\n Execution time....................: %s", getExecutionTime()));
		b.append(String.format("\n Average occupancy.................: %.2f", getAverageOccupancy()) + "%");
		b.append(String.format("\n Standard deviation of occupancy...: %.2f", getOccupancyDeviation()) + "%");
		b.append("\n");
		
		int pNumber = 1;
		for (StatisticalActorPartition partition : getPartitions()) {
			b.append(String.format("\n Partition (%d):\n", pNumber++));
			b.append(String.format("\t occupancy: %.2f", partition.getOccupancy()));
			b.append("%\n Actors:\n");
			for (String actorName : partition.getActors()) {
				b.append("\t " + actorName + ": \n");
				b.append("\t\t processing time: " + getProcessingTimes().get(actorName) + "\n");
				b.append("\t\t schedulable time: " + getIdleTimes().get(actorName) + "\n");
				b.append("\t\t blocked reading time: " + getBlockedReadingTimes().get(actorName) + "\n");
				b.append("\t\t blocked writing time: " + getBlockedWritingTimes().get(actorName) + "\n");
			}
		}
	
		b.append("\n\n");

		return b.toString();
	}
	
	@Override
	public NetworkPartitioning asNetworkPartitioning() {
		NetworkPartitioning partitioning = new NetworkPartitioning(getNetwork());
		int partition = 1;
		for (StatisticalActorPartition data : getPartitions()) {
			String component = "p" + (partition++);
			for (String actorName : data.getActors()) {
				partitioning.setPartition(actorName, component);
			}
			partitioning.setScheduler(component, data.getSchedulingPolicy());
		}
		return partitioning;
	}

} //ActorStatisticsReportImpl

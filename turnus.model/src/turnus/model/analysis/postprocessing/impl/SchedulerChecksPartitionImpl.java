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
import turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.SchedulerChecksPartition;
import turnus.model.common.StatisticalData;
import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Checks Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl#getAggregatedCheckedData <em>Aggregated Checked Data</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl#getAggregatedFailedData <em>Aggregated Failed Data</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl#getCheckedConditionsMap <em>Checked Conditions Map</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl#getFailedConditionsMap <em>Failed Conditions Map</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl#getPartitionId <em>Partition Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulerChecksPartitionImpl extends MinimalEObjectImpl.Container implements SchedulerChecksPartition {
	/**
	 * The cached value of the '{@link #getAggregatedCheckedData() <em>Aggregated Checked Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedCheckedData()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData aggregatedCheckedData;

	/**
	 * The cached value of the '{@link #getAggregatedFailedData() <em>Aggregated Failed Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedFailedData()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData aggregatedFailedData;

	/**
	 * The cached value of the '{@link #getCheckedConditionsMap() <em>Checked Conditions Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedConditionsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, StatisticalData> checkedConditionsMap;

	/**
	 * The cached value of the '{@link #getFailedConditionsMap() <em>Failed Conditions Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailedConditionsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, StatisticalData> failedConditionsMap;

	/**
	 * The default value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTITION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected String partitionId = PARTITION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerChecksPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.SCHEDULER_CHECKS_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticalData getAggregatedCheckedData() {
		return aggregatedCheckedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedCheckedData(StatisticalData newAggregatedCheckedData, NotificationChain msgs) {
		StatisticalData oldAggregatedCheckedData = aggregatedCheckedData;
		aggregatedCheckedData = newAggregatedCheckedData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA, oldAggregatedCheckedData, newAggregatedCheckedData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAggregatedCheckedData(StatisticalData newAggregatedCheckedData) {
		if (newAggregatedCheckedData != aggregatedCheckedData) {
			NotificationChain msgs = null;
			if (aggregatedCheckedData != null)
				msgs = ((InternalEObject)aggregatedCheckedData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA, null, msgs);
			if (newAggregatedCheckedData != null)
				msgs = ((InternalEObject)newAggregatedCheckedData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA, null, msgs);
			msgs = basicSetAggregatedCheckedData(newAggregatedCheckedData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA, newAggregatedCheckedData, newAggregatedCheckedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticalData getAggregatedFailedData() {
		return aggregatedFailedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedFailedData(StatisticalData newAggregatedFailedData, NotificationChain msgs) {
		StatisticalData oldAggregatedFailedData = aggregatedFailedData;
		aggregatedFailedData = newAggregatedFailedData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA, oldAggregatedFailedData, newAggregatedFailedData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAggregatedFailedData(StatisticalData newAggregatedFailedData) {
		if (newAggregatedFailedData != aggregatedFailedData) {
			NotificationChain msgs = null;
			if (aggregatedFailedData != null)
				msgs = ((InternalEObject)aggregatedFailedData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA, null, msgs);
			if (newAggregatedFailedData != null)
				msgs = ((InternalEObject)newAggregatedFailedData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA, null, msgs);
			msgs = basicSetAggregatedFailedData(newAggregatedFailedData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA, newAggregatedFailedData, newAggregatedFailedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Actor, StatisticalData> getCheckedConditionsMap() {
		if (checkedConditionsMap == null) {
			checkedConditionsMap = new EcoreEMap<Actor,StatisticalData>(MapPackage.Literals.ACTOR_TO_STATISTICAL_DATA_MAP, ActorToStatisticalDataMapImpl.class, this, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP);
		}
		return checkedConditionsMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Actor, StatisticalData> getFailedConditionsMap() {
		if (failedConditionsMap == null) {
			failedConditionsMap = new EcoreEMap<Actor,StatisticalData>(MapPackage.Literals.ACTOR_TO_STATISTICAL_DATA_MAP, ActorToStatisticalDataMapImpl.class, this, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP);
		}
		return failedConditionsMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPartitionId() {
		return partitionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitionId(String newPartitionId) {
		String oldPartitionId = partitionId;
		partitionId = newPartitionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__PARTITION_ID, oldPartitionId, partitionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA:
				return basicSetAggregatedCheckedData(null, msgs);
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA:
				return basicSetAggregatedFailedData(null, msgs);
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, StatisticalData>)getCheckedConditionsMap()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, StatisticalData>)getFailedConditionsMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA:
				return getAggregatedCheckedData();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA:
				return getAggregatedFailedData();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, StatisticalData>)getCheckedConditionsMap()).eMap();
				else return getCheckedConditionsMap();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, StatisticalData>)getFailedConditionsMap()).eMap();
				else return getFailedConditionsMap();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__PARTITION_ID:
				return getPartitionId();
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
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA:
				setAggregatedCheckedData((StatisticalData)newValue);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA:
				setAggregatedFailedData((StatisticalData)newValue);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, StatisticalData>)getCheckedConditionsMap()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, StatisticalData>)getFailedConditionsMap()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__PARTITION_ID:
				setPartitionId((String)newValue);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA:
				setAggregatedCheckedData((StatisticalData)null);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA:
				setAggregatedFailedData((StatisticalData)null);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP:
				getCheckedConditionsMap().clear();
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP:
				getFailedConditionsMap().clear();
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__PARTITION_ID:
				setPartitionId(PARTITION_ID_EDEFAULT);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA:
				return aggregatedCheckedData != null;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA:
				return aggregatedFailedData != null;
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP:
				return checkedConditionsMap != null && !checkedConditionsMap.isEmpty();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP:
				return failedConditionsMap != null && !failedConditionsMap.isEmpty();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION__PARTITION_ID:
				return PARTITION_ID_EDEFAULT == null ? partitionId != null : !PARTITION_ID_EDEFAULT.equals(partitionId);
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
		result.append(" (partitionId: ");
		result.append(partitionId);
		result.append(')');
		return result.toString();
	}

} //SchedulerChecksPartitionImpl

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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statistical Actor Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl#getOccupancy <em>Occupancy</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl#getPartitionId <em>Partition Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatisticalActorPartitionImpl extends MinimalEObjectImpl.Container implements StatisticalActorPartition {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> actors;

	/**
	 * The default value of the '{@link #getOccupancy() <em>Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupancy()
	 * @generated
	 * @ordered
	 */
	protected static final double OCCUPANCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOccupancy() <em>Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupancy()
	 * @generated
	 * @ordered
	 */
	protected double occupancy = OCCUPANCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULING_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected String schedulingPolicy = SCHEDULING_POLICY_EDEFAULT;

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
	protected StatisticalActorPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.STATISTICAL_ACTOR_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<String> getActors() {
		if (actors == null) {
			actors = new EDataTypeUniqueEList<String>(String.class, this, PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOccupancy() {
		return occupancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOccupancy(double newOccupancy) {
		double oldOccupancy = occupancy;
		occupancy = newOccupancy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__OCCUPANCY, oldOccupancy, occupancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSchedulingPolicy() {
		return schedulingPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchedulingPolicy(String newSchedulingPolicy) {
		String oldSchedulingPolicy = schedulingPolicy;
		schedulingPolicy = newSchedulingPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY, oldSchedulingPolicy, schedulingPolicy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__PARTITION_ID, oldPartitionId, partitionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__ACTORS:
				return getActors();
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__OCCUPANCY:
				return getOccupancy();
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY:
				return getSchedulingPolicy();
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__PARTITION_ID:
				return getPartitionId();
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
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends String>)newValue);
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__OCCUPANCY:
				setOccupancy((Double)newValue);
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY:
				setSchedulingPolicy((String)newValue);
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__PARTITION_ID:
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
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__ACTORS:
				getActors().clear();
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__OCCUPANCY:
				setOccupancy(OCCUPANCY_EDEFAULT);
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY:
				setSchedulingPolicy(SCHEDULING_POLICY_EDEFAULT);
				return;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__PARTITION_ID:
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
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__ACTORS:
				return actors != null && !actors.isEmpty();
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__OCCUPANCY:
				return occupancy != OCCUPANCY_EDEFAULT;
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY:
				return SCHEDULING_POLICY_EDEFAULT == null ? schedulingPolicy != null : !SCHEDULING_POLICY_EDEFAULT.equals(schedulingPolicy);
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION__PARTITION_ID:
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
		result.append(" (actors: ");
		result.append(actors);
		result.append(", occupancy: ");
		result.append(occupancy);
		result.append(", schedulingPolicy: ");
		result.append(schedulingPolicy);
		result.append(", partitionId: ");
		result.append(partitionId);
		result.append(')');
		return result.toString();
	}

} //StatisticalActorPartitionImpl

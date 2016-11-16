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
package turnus.model.analysis.partitioning.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import turnus.model.analysis.partitioning.BalancedPipelinePartition;
import turnus.model.analysis.partitioning.PartitioningPackage;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Balanced Pipeline Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl#getWorkload <em>Workload</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl#getPreWorkload <em>Pre Workload</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl#getCommonPredAvg <em>Common Pred Avg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BalancedPipelinePartitionImpl extends MinimalEObjectImpl.Container implements BalancedPipelinePartition {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The default value of the '{@link #getWorkload() <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload()
	 * @generated
	 * @ordered
	 */
	protected static final double WORKLOAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWorkload() <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload()
	 * @generated
	 * @ordered
	 */
	protected double workload = WORKLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreWorkload() <em>Pre Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreWorkload()
	 * @generated
	 * @ordered
	 */
	protected static final double PRE_WORKLOAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPreWorkload() <em>Pre Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreWorkload()
	 * @generated
	 * @ordered
	 */
	protected double preWorkload = PRE_WORKLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommonPredAvg() <em>Common Pred Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonPredAvg()
	 * @generated
	 * @ordered
	 */
	protected static final double COMMON_PRED_AVG_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCommonPredAvg() <em>Common Pred Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonPredAvg()
	 * @generated
	 * @ordered
	 */
	protected double commonPredAvg = COMMON_PRED_AVG_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BalancedPipelinePartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.BALANCED_PIPELINE_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, PartitioningPackage.BALANCED_PIPELINE_PARTITION__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWorkload() {
		return workload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkload(double newWorkload) {
		double oldWorkload = workload;
		workload = newWorkload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.BALANCED_PIPELINE_PARTITION__WORKLOAD, oldWorkload, workload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPreWorkload() {
		return preWorkload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreWorkload(double newPreWorkload) {
		double oldPreWorkload = preWorkload;
		preWorkload = newPreWorkload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD, oldPreWorkload, preWorkload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCommonPredAvg() {
		return commonPredAvg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommonPredAvg(double newCommonPredAvg) {
		double oldCommonPredAvg = commonPredAvg;
		commonPredAvg = newCommonPredAvg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG, oldCommonPredAvg, commonPredAvg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__ACTORS:
				return getActors();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__WORKLOAD:
				return getWorkload();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD:
				return getPreWorkload();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG:
				return getCommonPredAvg();
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
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__WORKLOAD:
				setWorkload((Double)newValue);
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD:
				setPreWorkload((Double)newValue);
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG:
				setCommonPredAvg((Double)newValue);
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
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__ACTORS:
				getActors().clear();
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__WORKLOAD:
				setWorkload(WORKLOAD_EDEFAULT);
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD:
				setPreWorkload(PRE_WORKLOAD_EDEFAULT);
				return;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG:
				setCommonPredAvg(COMMON_PRED_AVG_EDEFAULT);
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
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__ACTORS:
				return actors != null && !actors.isEmpty();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__WORKLOAD:
				return workload != WORKLOAD_EDEFAULT;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD:
				return preWorkload != PRE_WORKLOAD_EDEFAULT;
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG:
				return commonPredAvg != COMMON_PRED_AVG_EDEFAULT;
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
		result.append(" (workload: ");
		result.append(workload);
		result.append(", preWorkload: ");
		result.append(preWorkload);
		result.append(", commonPredAvg: ");
		result.append(commonPredAvg);
		result.append(')');
		return result.toString();
	}

} //BalancedPipelinePartitionImpl

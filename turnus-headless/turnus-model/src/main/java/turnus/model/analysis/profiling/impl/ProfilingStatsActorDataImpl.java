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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.analysis.profiling.ProfilingStatsActorData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stats Actor Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl#getActorName <em>Actor Name</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl#getActionsWeight <em>Actions Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl#getSchedulerWeight <em>Scheduler Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl#getActionsWeightPercent <em>Actions Weight Percent</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl#getSchedulerWeightPercent <em>Scheduler Weight Percent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProfilingStatsActorDataImpl extends MinimalEObjectImpl.Container implements ProfilingStatsActorData {
	/**
	 * The default value of the '{@link #getActorName() <em>Actor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorName()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActorName() <em>Actor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorName()
	 * @generated
	 * @ordered
	 */
	protected String actorName = ACTOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionsWeight() <em>Actions Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double ACTIONS_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getActionsWeight() <em>Actions Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsWeight()
	 * @generated
	 * @ordered
	 */
	protected double actionsWeight = ACTIONS_WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulerWeight() <em>Scheduler Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double SCHEDULER_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSchedulerWeight() <em>Scheduler Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerWeight()
	 * @generated
	 * @ordered
	 */
	protected double schedulerWeight = SCHEDULER_WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getActionsWeightPercent() <em>Actions Weight Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsWeightPercent()
	 * @generated
	 * @ordered
	 */
	protected static final double ACTIONS_WEIGHT_PERCENT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getActionsWeightPercent() <em>Actions Weight Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsWeightPercent()
	 * @generated
	 * @ordered
	 */
	protected double actionsWeightPercent = ACTIONS_WEIGHT_PERCENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulerWeightPercent() <em>Scheduler Weight Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerWeightPercent()
	 * @generated
	 * @ordered
	 */
	protected static final double SCHEDULER_WEIGHT_PERCENT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSchedulerWeightPercent() <em>Scheduler Weight Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerWeightPercent()
	 * @generated
	 * @ordered
	 */
	protected double schedulerWeightPercent = SCHEDULER_WEIGHT_PERCENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfilingStatsActorDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.PROFILING_STATS_ACTOR_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActorName() {
		return actorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActorName(String newActorName) {
		String oldActorName = actorName;
		actorName = newActorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTOR_NAME, oldActorName, actorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getActionsWeight() {
		return actionsWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActionsWeight(double newActionsWeight) {
		double oldActionsWeight = actionsWeight;
		actionsWeight = newActionsWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT, oldActionsWeight, actionsWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSchedulerWeight() {
		return schedulerWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchedulerWeight(double newSchedulerWeight) {
		double oldSchedulerWeight = schedulerWeight;
		schedulerWeight = newSchedulerWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT, oldSchedulerWeight, schedulerWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getActionsWeightPercent() {
		return actionsWeightPercent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActionsWeightPercent(double newActionsWeightPercent) {
		double oldActionsWeightPercent = actionsWeightPercent;
		actionsWeightPercent = newActionsWeightPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT, oldActionsWeightPercent, actionsWeightPercent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSchedulerWeightPercent() {
		return schedulerWeightPercent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchedulerWeightPercent(double newSchedulerWeightPercent) {
		double oldSchedulerWeightPercent = schedulerWeightPercent;
		schedulerWeightPercent = newSchedulerWeightPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT, oldSchedulerWeightPercent, schedulerWeightPercent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTOR_NAME:
				return getActorName();
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT:
				return getActionsWeight();
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT:
				return getSchedulerWeight();
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT:
				return getActionsWeightPercent();
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT:
				return getSchedulerWeightPercent();
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
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTOR_NAME:
				setActorName((String)newValue);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT:
				setActionsWeight((Double)newValue);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT:
				setSchedulerWeight((Double)newValue);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT:
				setActionsWeightPercent((Double)newValue);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT:
				setSchedulerWeightPercent((Double)newValue);
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
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTOR_NAME:
				setActorName(ACTOR_NAME_EDEFAULT);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT:
				setActionsWeight(ACTIONS_WEIGHT_EDEFAULT);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT:
				setSchedulerWeight(SCHEDULER_WEIGHT_EDEFAULT);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT:
				setActionsWeightPercent(ACTIONS_WEIGHT_PERCENT_EDEFAULT);
				return;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT:
				setSchedulerWeightPercent(SCHEDULER_WEIGHT_PERCENT_EDEFAULT);
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
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTOR_NAME:
				return ACTOR_NAME_EDEFAULT == null ? actorName != null : !ACTOR_NAME_EDEFAULT.equals(actorName);
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT:
				return actionsWeight != ACTIONS_WEIGHT_EDEFAULT;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT:
				return schedulerWeight != SCHEDULER_WEIGHT_EDEFAULT;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT:
				return actionsWeightPercent != ACTIONS_WEIGHT_PERCENT_EDEFAULT;
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT:
				return schedulerWeightPercent != SCHEDULER_WEIGHT_PERCENT_EDEFAULT;
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
		result.append(" (actorName: ");
		result.append(actorName);
		result.append(", actionsWeight: ");
		result.append(actionsWeight);
		result.append(", schedulerWeight: ");
		result.append(schedulerWeight);
		result.append(", actionsWeightPercent: ");
		result.append(actionsWeightPercent);
		result.append(", schedulerWeightPercent: ");
		result.append(schedulerWeightPercent);
		result.append(')');
		return result.toString();
	}

} //ProfilingStatsActorDataImpl

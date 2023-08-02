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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.bottlenecks.BottlenecksPackage;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.DoubleToDoubleMapImpl;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduled Impact Analysis Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl#getCpReductionMap <em>Cp Reduction Map</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl#getTimeReductionMap <em>Time Reduction Map</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl#getReportsMap <em>Reports Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScheduledImpactAnalysisDataImpl extends MinimalEObjectImpl.Container implements ScheduledImpactAnalysisData {
	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getCpReductionMap() <em>Cp Reduction Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpReductionMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Double, Double> cpReductionMap;

	/**
	 * The cached value of the '{@link #getTimeReductionMap() <em>Time Reduction Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeReductionMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Double, Double> timeReductionMap;

	/**
	 * The cached value of the '{@link #getReportsMap() <em>Reports Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Double, BottlenecksWithSchedulingReport> reportsMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduledImpactAnalysisDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BottlenecksPackage.Literals.SCHEDULED_IMPACT_ANALYSIS_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ActorClass getActorClass() {
		return !getActions().isEmpty() ? getActions().get(0).getOwner().getActorClass() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Double, Double> getCpReductionMap() {
		if (cpReductionMap == null) {
			cpReductionMap = new EcoreEMap<Double,Double>(MapPackage.Literals.DOUBLE_TO_DOUBLE_MAP, DoubleToDoubleMapImpl.class, this, BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP);
		}
		return cpReductionMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Double, Double> getTimeReductionMap() {
		if (timeReductionMap == null) {
			timeReductionMap = new EcoreEMap<Double,Double>(MapPackage.Literals.DOUBLE_TO_DOUBLE_MAP, DoubleToDoubleMapImpl.class, this, BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP);
		}
		return timeReductionMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Double, BottlenecksWithSchedulingReport> getReportsMap() {
		if (reportsMap == null) {
			reportsMap = new EcoreEMap<Double,BottlenecksWithSchedulingReport>(BottlenecksPackage.Literals.DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP, DoubleToBottlenecksWithSchedulingReportMapImpl.class, this, BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP);
		}
		return reportsMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Double, Double>)getCpReductionMap()).eMap()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Double, Double>)getTimeReductionMap()).eMap()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Double, BottlenecksWithSchedulingReport>)getReportsMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS:
				return getActions();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTOR_CLASS:
				return getActorClass();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP:
				if (coreType) return ((EMap.InternalMapView<Double, Double>)getCpReductionMap()).eMap();
				else return getCpReductionMap();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP:
				if (coreType) return ((EMap.InternalMapView<Double, Double>)getTimeReductionMap()).eMap();
				else return getTimeReductionMap();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP:
				if (coreType) return ((EMap.InternalMapView<Double, BottlenecksWithSchedulingReport>)getReportsMap()).eMap();
				else return getReportsMap();
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
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Double, Double>)getCpReductionMap()).eMap()).set(newValue);
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Double, Double>)getTimeReductionMap()).eMap()).set(newValue);
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Double, BottlenecksWithSchedulingReport>)getReportsMap()).eMap()).set(newValue);
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
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS:
				getActions().clear();
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP:
				getCpReductionMap().clear();
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP:
				getTimeReductionMap().clear();
				return;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP:
				getReportsMap().clear();
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
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS:
				return actions != null && !actions.isEmpty();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__ACTOR_CLASS:
				return getActorClass() != null;
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP:
				return cpReductionMap != null && !cpReductionMap.isEmpty();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP:
				return timeReductionMap != null && !timeReductionMap.isEmpty();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP:
				return reportsMap != null && !reportsMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScheduledImpactAnalysisDataImpl

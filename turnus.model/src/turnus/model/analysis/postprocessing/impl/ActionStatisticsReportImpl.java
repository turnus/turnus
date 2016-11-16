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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.ActionToDoubleMapImpl;
import turnus.model.analysis.map.impl.ActionToLongMapImpl;

import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.analysis.postprocessing.PostprocessingPackage;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Statistics Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getIdleTimes <em>Idle Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getIdleMinTimes <em>Idle Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getIdleMaxTimes <em>Idle Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedReadingTimes <em>Blocked Reading Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedReadingMinTimes <em>Blocked Reading Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedReadingMaxTimes <em>Blocked Reading Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedWritingTimes <em>Blocked Writing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedWritingMinTimes <em>Blocked Writing Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getBlockedWritingMaxTimes <em>Blocked Writing Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getProcessingTimes <em>Processing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl#getExecutionCounts <em>Execution Counts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionStatisticsReportImpl extends PostProcessingDataImpl implements ActionStatisticsReport {
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
	 * The cached value of the '{@link #getIdleTimes() <em>Idle Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdleTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> idleTimes;

	/**
	 * The cached value of the '{@link #getIdleMinTimes() <em>Idle Min Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdleMinTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> idleMinTimes;

	/**
	 * The cached value of the '{@link #getIdleMaxTimes() <em>Idle Max Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdleMaxTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> idleMaxTimes;

	/**
	 * The cached value of the '{@link #getBlockedReadingTimes() <em>Blocked Reading Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedReadingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedReadingTimes;

	/**
	 * The cached value of the '{@link #getBlockedReadingMinTimes() <em>Blocked Reading Min Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedReadingMinTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedReadingMinTimes;

	/**
	 * The cached value of the '{@link #getBlockedReadingMaxTimes() <em>Blocked Reading Max Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedReadingMaxTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedReadingMaxTimes;

	/**
	 * The cached value of the '{@link #getBlockedWritingTimes() <em>Blocked Writing Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedWritingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedWritingTimes;

	/**
	 * The cached value of the '{@link #getBlockedWritingMinTimes() <em>Blocked Writing Min Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedWritingMinTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedWritingMinTimes;

	/**
	 * The cached value of the '{@link #getBlockedWritingMaxTimes() <em>Blocked Writing Max Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedWritingMaxTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> blockedWritingMaxTimes;

	/**
	 * The cached value of the '{@link #getProcessingTimes() <em>Processing Times</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingTimes()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Double> processingTimes;

	/**
	 * The cached value of the '{@link #getExecutionCounts() <em>Execution Counts</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionCounts()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> executionCounts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionStatisticsReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.ACTION_STATISTICS_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getIdleTimes() {
		if (idleTimes == null) {
			idleTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES);
		}
		return idleTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getIdleMinTimes() {
		if (idleMinTimes == null) {
			idleMinTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES);
		}
		return idleMinTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getIdleMaxTimes() {
		if (idleMaxTimes == null) {
			idleMaxTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES);
		}
		return idleMaxTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedReadingTimes() {
		if (blockedReadingTimes == null) {
			blockedReadingTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES);
		}
		return blockedReadingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedReadingMinTimes() {
		if (blockedReadingMinTimes == null) {
			blockedReadingMinTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES);
		}
		return blockedReadingMinTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedReadingMaxTimes() {
		if (blockedReadingMaxTimes == null) {
			blockedReadingMaxTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES);
		}
		return blockedReadingMaxTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedWritingTimes() {
		if (blockedWritingTimes == null) {
			blockedWritingTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES);
		}
		return blockedWritingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedWritingMinTimes() {
		if (blockedWritingMinTimes == null) {
			blockedWritingMinTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES);
		}
		return blockedWritingMinTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getBlockedWritingMaxTimes() {
		if (blockedWritingMaxTimes == null) {
			blockedWritingMaxTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES);
		}
		return blockedWritingMaxTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Double> getProcessingTimes() {
		if (processingTimes == null) {
			processingTimes = new EcoreEMap<Action,Double>(MapPackage.Literals.ACTION_TO_DOUBLE_MAP, ActionToDoubleMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES);
		}
		return processingTimes.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getExecutionCounts() {
		if (executionCounts == null) {
			executionCounts = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS);
		}
		return executionCounts.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getIdleTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getIdleMinTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getIdleMaxTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedReadingTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedReadingMinTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedReadingMaxTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedWritingTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedWritingMinTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getBlockedWritingMaxTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Double>)getProcessingTimes()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getExecutionCounts()).eMap()).basicRemove(otherEnd, msgs);
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
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__ACTORS:
				return getActors();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getIdleTimes()).eMap();
				else return getIdleTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getIdleMinTimes()).eMap();
				else return getIdleMinTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getIdleMaxTimes()).eMap();
				else return getIdleMaxTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedReadingTimes()).eMap();
				else return getBlockedReadingTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedReadingMinTimes()).eMap();
				else return getBlockedReadingMinTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedReadingMaxTimes()).eMap();
				else return getBlockedReadingMaxTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedWritingTimes()).eMap();
				else return getBlockedWritingTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedWritingMinTimes()).eMap();
				else return getBlockedWritingMinTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getBlockedWritingMaxTimes()).eMap();
				else return getBlockedWritingMaxTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES:
				if (coreType) return ((EMap.InternalMapView<Action, Double>)getProcessingTimes()).eMap();
				else return getProcessingTimes();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getExecutionCounts()).eMap();
				else return getExecutionCounts();
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
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getIdleTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getIdleMinTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getIdleMaxTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedReadingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedReadingMinTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedReadingMaxTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedWritingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedWritingMinTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getBlockedWritingMaxTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Double>)getProcessingTimes()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getExecutionCounts()).eMap()).set(newValue);
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
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__ACTORS:
				getActors().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES:
				getIdleTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES:
				getIdleMinTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES:
				getIdleMaxTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				getBlockedReadingTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES:
				getBlockedReadingMinTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES:
				getBlockedReadingMaxTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				getBlockedWritingTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES:
				getBlockedWritingMinTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES:
				getBlockedWritingMaxTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES:
				getProcessingTimes().clear();
				return;
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS:
				getExecutionCounts().clear();
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
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__ACTORS:
				return actors != null && !actors.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_TIMES:
				return idleTimes != null && !idleTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES:
				return idleMinTimes != null && !idleMinTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES:
				return idleMaxTimes != null && !idleMaxTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES:
				return blockedReadingTimes != null && !blockedReadingTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES:
				return blockedReadingMinTimes != null && !blockedReadingMinTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES:
				return blockedReadingMaxTimes != null && !blockedReadingMaxTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES:
				return blockedWritingTimes != null && !blockedWritingTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES:
				return blockedWritingMinTimes != null && !blockedWritingMinTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES:
				return blockedWritingMaxTimes != null && !blockedWritingMaxTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__PROCESSING_TIMES:
				return processingTimes != null && !processingTimes.isEmpty();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT__EXECUTION_COUNTS:
				return executionCounts != null && !executionCounts.isEmpty();
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
		b.append("\n[POST PROCESSING REPORT (ACTION LEVEL)]");
		b.append("\n Actors:\n");	
		for (Actor actor : getActors()) {
			b.append("\t " + actor.getName() + ": \n");
			for (Action action : actor.getActions()) {
				b.append("\t\t " + action.getName() + ": \n");
				b.append("\t\t\t number of executions: " + getExecutionCounts().get(action) + "\n");
				b.append("\t\t\t overall processing time: " + getProcessingTimes().get(action) + "\n");
				b.append("\t\t\t schedulable time: \n");
				b.append("\t\t\t\t overall: " + getIdleTimes().get(action) + "\n");
				double average = (getExecutionCounts().get(action) != 0) ? getIdleTimes().get(action) / getExecutionCounts().get(action) : 0.0;
				b.append("\t\t\t\t average: " + average + "\n");
				b.append("\t\t\t\t min: " + getIdleMinTimes().get(action) + "\n");
				b.append("\t\t\t\t max: " + getIdleMaxTimes().get(action) + "\n");
				
				b.append("\t\t\t blocked reading time: \n");
				b.append("\t\t\t\t overall: " + getBlockedReadingTimes().get(action) + "\n");
				average = (getExecutionCounts().get(action) != 0) ? getBlockedReadingTimes().get(action) / getExecutionCounts().get(action) : 0.0;
				b.append("\t\t\t\t average: " + average + "\n");
				b.append("\t\t\t\t min: " + getBlockedReadingMinTimes().get(action) + "\n");
				b.append("\t\t\t\t max: " + getBlockedReadingMaxTimes().get(action) + "\n");
				
				b.append("\t\t\t blocked writing time: \n");
				b.append("\t\t\t\t overall: " + getBlockedWritingTimes().get(action) + "\n");
				average = (getExecutionCounts().get(action) != 0) ? getBlockedWritingTimes().get(action) / getExecutionCounts().get(action) : 0.0;
				b.append("\t\t\t\t average: " + average + "\n");
				b.append("\t\t\t\t min: " + getBlockedWritingMinTimes().get(action) + "\n");
				b.append("\t\t\t\t max: " + getBlockedWritingMaxTimes().get(action) + "\n");
			}
		}
	
		b.append("\n\n");

		return b.toString();
	}

} //ActionStatisticsReportImpl

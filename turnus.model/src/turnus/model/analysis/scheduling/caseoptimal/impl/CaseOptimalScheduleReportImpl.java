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
package turnus.model.analysis.scheduling.caseoptimal.impl;

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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.PartitionToActorSelectionScheduleMapImpl;

import turnus.model.analysis.scheduling.ActorSelectionSchedule;

import turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport;
import turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage;
import turnus.model.analysis.scheduling.caseoptimal.Optimizer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Optimal Schedule Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getPartitionSchedules <em>Partition Schedules</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getTraceFile <em>Trace File</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getPipeline <em>Pipeline</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl#getPartitionFilePath <em>Partition File Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CaseOptimalScheduleReportImpl extends MinimalEObjectImpl.Container implements CaseOptimalScheduleReport {
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
	 * The cached value of the '{@link #getPartitionSchedules() <em>Partition Schedules</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionSchedules()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, ActorSelectionSchedule> partitionSchedules;

	/**
	 * The default value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected String traceFile = TRACE_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPipeline() <em>Pipeline</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipeline()
	 * @generated
	 * @ordered
	 */
	protected EList<Optimizer> pipeline;

	/**
	 * The default value of the '{@link #getPartitionFilePath() <em>Partition File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTITION_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartitionFilePath() <em>Partition File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionFilePath()
	 * @generated
	 * @ordered
	 */
	protected String partitionFilePath = PARTITION_FILE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaseOptimalScheduleReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaseoptimalPackage.Literals.CASE_OPTIMAL_SCHEDULE_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, ActorSelectionSchedule> getPartitionSchedules() {
		if (partitionSchedules == null) {
			partitionSchedules = new EcoreEMap<String,ActorSelectionSchedule>(MapPackage.Literals.PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP, PartitionToActorSelectionScheduleMapImpl.class, this, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES);
		}
		return partitionSchedules.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceFile() {
		return traceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceFile(String newTraceFile) {
		String oldTraceFile = traceFile;
		traceFile = newTraceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE, oldTraceFile, traceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Optimizer> getPipeline() {
		if (pipeline == null) {
			pipeline = new EDataTypeUniqueEList<Optimizer>(Optimizer.class, this, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE);
		}
		return pipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartitionFilePath() {
		return partitionFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionFilePath(String newPartitionFilePath) {
		String oldPartitionFilePath = partitionFilePath;
		partitionFilePath = newPartitionFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH, oldPartitionFilePath, partitionFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES:
				return ((InternalEList<?>)((EMap.InternalMapView<String, ActorSelectionSchedule>)getPartitionSchedules()).eMap()).basicRemove(otherEnd, msgs);
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
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM:
				return getAlgorithm();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__DATE:
				return getDate();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES:
				if (coreType) return ((EMap.InternalMapView<String, ActorSelectionSchedule>)getPartitionSchedules()).eMap();
				else return getPartitionSchedules();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE:
				return getTraceFile();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE:
				return getPipeline();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH:
				return getPartitionFilePath();
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
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, ActorSelectionSchedule>)getPartitionSchedules()).eMap()).set(newValue);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE:
				setTraceFile((String)newValue);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE:
				getPipeline().clear();
				getPipeline().addAll((Collection<? extends Optimizer>)newValue);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH:
				setPartitionFilePath((String)newValue);
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
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES:
				getPartitionSchedules().clear();
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE:
				setTraceFile(TRACE_FILE_EDEFAULT);
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE:
				getPipeline().clear();
				return;
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH:
				setPartitionFilePath(PARTITION_FILE_PATH_EDEFAULT);
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
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES:
				return partitionSchedules != null && !partitionSchedules.isEmpty();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE:
				return TRACE_FILE_EDEFAULT == null ? traceFile != null : !TRACE_FILE_EDEFAULT.equals(traceFile);
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE:
				return pipeline != null && !pipeline.isEmpty();
			case CaseoptimalPackage.CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH:
				return PARTITION_FILE_PATH_EDEFAULT == null ? partitionFilePath != null : !PARTITION_FILE_PATH_EDEFAULT.equals(partitionFilePath);
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
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", date: ");
		result.append(date);
		result.append(", traceFile: ");
		result.append(traceFile);
		result.append(", pipeline: ");
		result.append(pipeline);
		result.append(", partitionFilePath: ");
		result.append(partitionFilePath);
		result.append(')');
		return result.toString();
	}

} //CaseOptimalScheduleReportImpl

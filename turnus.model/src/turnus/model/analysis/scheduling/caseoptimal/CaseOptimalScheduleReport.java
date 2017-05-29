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
package turnus.model.analysis.scheduling.caseoptimal;

import java.util.List;
import java.util.Map;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.scheduling.ActorSelectionSchedule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Optimal Schedule Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionSchedules <em>Partition Schedules</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getTraceFile <em>Trace File</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPipeline <em>Pipeline</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionFilePath <em>Partition File Path</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage#getCaseOptimalScheduleReport()
 * @model
 * @generated
 */
public interface CaseOptimalScheduleReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Partition Schedules</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link turnus.model.analysis.scheduling.ActorSelectionSchedule},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partition Schedules</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Schedules</em>' map.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage#getCaseOptimalScheduleReport_PartitionSchedules()
	 * @model mapType="turnus.model.analysis.map.PartitionToActorSelectionScheduleMap<org.eclipse.emf.ecore.EString, turnus.model.analysis.scheduling.ActorSelectionSchedule>"
	 * @generated
	 */
	Map<String, ActorSelectionSchedule> getPartitionSchedules();

	/**
	 * Returns the value of the '<em><b>Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace File</em>' attribute.
	 * @see #setTraceFile(String)
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage#getCaseOptimalScheduleReport_TraceFile()
	 * @model
	 * @generated
	 */
	String getTraceFile();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getTraceFile <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace File</em>' attribute.
	 * @see #getTraceFile()
	 * @generated
	 */
	void setTraceFile(String value);

	/**
	 * Returns the value of the '<em><b>Pipeline</b></em>' attribute list.
	 * The list contents are of type {@link turnus.model.analysis.scheduling.caseoptimal.Optimizer}.
	 * The literals are from the enumeration {@link turnus.model.analysis.scheduling.caseoptimal.Optimizer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipeline</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipeline</em>' attribute list.
	 * @see turnus.model.analysis.scheduling.caseoptimal.Optimizer
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage#getCaseOptimalScheduleReport_Pipeline()
	 * @model
	 * @generated
	 */
	List<Optimizer> getPipeline();

	/**
	 * Returns the value of the '<em><b>Partition File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partition File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition File Path</em>' attribute.
	 * @see #setPartitionFilePath(String)
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage#getCaseOptimalScheduleReport_PartitionFilePath()
	 * @model
	 * @generated
	 */
	String getPartitionFilePath();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionFilePath <em>Partition File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition File Path</em>' attribute.
	 * @see #getPartitionFilePath()
	 * @generated
	 */
	void setPartitionFilePath(String value);

} // CaseOptimalScheduleReport

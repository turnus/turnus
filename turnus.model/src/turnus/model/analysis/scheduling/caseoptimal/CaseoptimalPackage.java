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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import turnus.model.analysis.AnalysisPackage;
import turnus.model.analysis.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.scheduling.caseoptimal.CaseoptimalFactory
 * @model kind="package"
 * @generated
 */
public interface CaseoptimalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "caseoptimal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2017/analysis/scheduling/caseoptimal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.scheduling.caseoptimal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CaseoptimalPackage eINSTANCE = turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl <em>Case Optimal Schedule Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl
	 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getCaseOptimalScheduleReport()
	 * @generated
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Partition Schedules</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pipeline</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partition File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Case Optimal Schedule Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Case Optimal Schedule Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_SCHEDULE_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalActorSelectionScheduleImpl <em>Case Optimal Actor Selection Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalActorSelectionScheduleImpl
	 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getCaseOptimalActorSelectionSchedule()
	 * @generated
	 */
	int CASE_OPTIMAL_ACTOR_SELECTION_SCHEDULE = 1;

	/**
	 * The number of structural features of the '<em>Case Optimal Actor Selection Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT = SchedulingPackage.ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Case Optimal Actor Selection Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPTIMAL_ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT = SchedulingPackage.ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.caseoptimal.Optimizer <em>Optimizer</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.caseoptimal.Optimizer
	 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getOptimizer()
	 * @generated
	 */
	int OPTIMIZER = 2;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport <em>Case Optimal Schedule Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Optimal Schedule Report</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport
	 * @generated
	 */
	EClass getCaseOptimalScheduleReport();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionSchedules <em>Partition Schedules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Partition Schedules</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionSchedules()
	 * @see #getCaseOptimalScheduleReport()
	 * @generated
	 */
	EReference getCaseOptimalScheduleReport_PartitionSchedules();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getTraceFile <em>Trace File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace File</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getTraceFile()
	 * @see #getCaseOptimalScheduleReport()
	 * @generated
	 */
	EAttribute getCaseOptimalScheduleReport_TraceFile();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pipeline</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPipeline()
	 * @see #getCaseOptimalScheduleReport()
	 * @generated
	 */
	EAttribute getCaseOptimalScheduleReport_Pipeline();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionFilePath <em>Partition File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition File Path</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport#getPartitionFilePath()
	 * @see #getCaseOptimalScheduleReport()
	 * @generated
	 */
	EAttribute getCaseOptimalScheduleReport_PartitionFilePath();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.caseoptimal.CaseOptimalActorSelectionSchedule <em>Case Optimal Actor Selection Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Optimal Actor Selection Schedule</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.CaseOptimalActorSelectionSchedule
	 * @generated
	 */
	EClass getCaseOptimalActorSelectionSchedule();

	/**
	 * Returns the meta object for enum '{@link turnus.model.analysis.scheduling.caseoptimal.Optimizer <em>Optimizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Optimizer</em>'.
	 * @see turnus.model.analysis.scheduling.caseoptimal.Optimizer
	 * @generated
	 */
	EEnum getOptimizer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CaseoptimalFactory getCaseoptimalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl <em>Case Optimal Schedule Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalScheduleReportImpl
		 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getCaseOptimalScheduleReport()
		 * @generated
		 */
		EClass CASE_OPTIMAL_SCHEDULE_REPORT = eINSTANCE.getCaseOptimalScheduleReport();

		/**
		 * The meta object literal for the '<em><b>Partition Schedules</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_SCHEDULES = eINSTANCE.getCaseOptimalScheduleReport_PartitionSchedules();

		/**
		 * The meta object literal for the '<em><b>Trace File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_OPTIMAL_SCHEDULE_REPORT__TRACE_FILE = eINSTANCE.getCaseOptimalScheduleReport_TraceFile();

		/**
		 * The meta object literal for the '<em><b>Pipeline</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_OPTIMAL_SCHEDULE_REPORT__PIPELINE = eINSTANCE.getCaseOptimalScheduleReport_Pipeline();

		/**
		 * The meta object literal for the '<em><b>Partition File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_OPTIMAL_SCHEDULE_REPORT__PARTITION_FILE_PATH = eINSTANCE.getCaseOptimalScheduleReport_PartitionFilePath();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalActorSelectionScheduleImpl <em>Case Optimal Actor Selection Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseOptimalActorSelectionScheduleImpl
		 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getCaseOptimalActorSelectionSchedule()
		 * @generated
		 */
		EClass CASE_OPTIMAL_ACTOR_SELECTION_SCHEDULE = eINSTANCE.getCaseOptimalActorSelectionSchedule();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.caseoptimal.Optimizer <em>Optimizer</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.caseoptimal.Optimizer
		 * @see turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl#getOptimizer()
		 * @generated
		 */
		EEnum OPTIMIZER = eINSTANCE.getOptimizer();

	}

} //CaseoptimalPackage

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
package turnus.model.analysis.postprocessing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import turnus.model.analysis.AnalysisPackage;

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
 * @see turnus.model.analysis.postprocessing.PostprocessingFactory
 * @model kind="package"
 * @generated
 */
public interface PostprocessingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "postprocessing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/postprocessing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.postprocessing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PostprocessingPackage eINSTANCE = turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.PostProcessingReportImpl <em>Post Processing Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.PostProcessingReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getPostProcessingReport()
	 * @generated
	 */
	int POST_PROCESSING_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__TIME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deadlock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__DEADLOCK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT__REPORTS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Post Processing Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Post Processing Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.PostProcessingDataImpl <em>Post Processing Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.PostProcessingDataImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getPostProcessingData()
	 * @generated
	 */
	int POST_PROCESSING_DATA = 1;

	/**
	 * The number of structural features of the '<em>Post Processing Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_DATA_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Post Processing Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_PROCESSING_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl <em>Actor Statistics Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getActorStatisticsReport()
	 * @generated
	 */
	int ACTOR_STATISTICS_REPORT = 2;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__NETWORK = POST_PROCESSING_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__EXECUTION_TIME = POST_PROCESSING_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__PARTITIONS = POST_PROCESSING_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Idle Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__IDLE_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Blocked Reading Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Blocked Writing Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Processing Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__PROCESSING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Average Occupancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY = POST_PROCESSING_DATA_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Occupancy Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION = POST_PROCESSING_DATA_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Actor Statistics Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT_FEATURE_COUNT = POST_PROCESSING_DATA_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Actor Statistics Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_STATISTICS_REPORT_OPERATION_COUNT = POST_PROCESSING_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl <em>Statistical Actor Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getStatisticalActorPartition()
	 * @generated
	 */
	int STATISTICAL_ACTOR_PARTITION = 3;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Occupancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION__OCCUPANCY = 1;

	/**
	 * The feature id for the '<em><b>Scheduling Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY = 2;

	/**
	 * The feature id for the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION__PARTITION_ID = 3;

	/**
	 * The number of structural features of the '<em>Statistical Actor Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Statistical Actor Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_ACTOR_PARTITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl <em>Action Statistics Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getActionStatisticsReport()
	 * @generated
	 */
	int ACTION_STATISTICS_REPORT = 4;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__ACTORS = POST_PROCESSING_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Idle Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__IDLE_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Idle Min Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Idle Max Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Blocked Reading Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Blocked Reading Min Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Blocked Reading Max Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Blocked Writing Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Blocked Writing Min Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Blocked Writing Max Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Processing Times</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__PROCESSING_TIMES = POST_PROCESSING_DATA_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Execution Counts</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__EXECUTION_COUNTS = POST_PROCESSING_DATA_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT__NETWORK = POST_PROCESSING_DATA_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Action Statistics Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT_FEATURE_COUNT = POST_PROCESSING_DATA_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Action Statistics Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_STATISTICS_REPORT_OPERATION_COUNT = POST_PROCESSING_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl <em>Scheduler Checks Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getSchedulerChecksReport()
	 * @generated
	 */
	int SCHEDULER_CHECKS_REPORT = 5;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_REPORT__PARTITIONS = POST_PROCESSING_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_REPORT__NETWORK = POST_PROCESSING_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scheduler Checks Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_REPORT_FEATURE_COUNT = POST_PROCESSING_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Scheduler Checks Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_REPORT_OPERATION_COUNT = POST_PROCESSING_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl <em>Scheduler Checks Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getSchedulerChecksPartition()
	 * @generated
	 */
	int SCHEDULER_CHECKS_PARTITION = 6;

	/**
	 * The feature id for the '<em><b>Aggregated Checked Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA = 0;

	/**
	 * The feature id for the '<em><b>Aggregated Failed Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA = 1;

	/**
	 * The feature id for the '<em><b>Checked Conditions Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP = 2;

	/**
	 * The feature id for the '<em><b>Failed Conditions Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP = 3;

	/**
	 * The feature id for the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION__PARTITION_ID = 4;

	/**
	 * The number of structural features of the '<em>Scheduler Checks Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Scheduler Checks Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CHECKS_PARTITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl <em>Buffer Blocking Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getBufferBlockingReport()
	 * @generated
	 */
	int BUFFER_BLOCKING_REPORT = 7;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT__NETWORK = POST_PROCESSING_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Blocked Output Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS = POST_PROCESSING_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Blocked Multiplication</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION = POST_PROCESSING_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Blocking Instances</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES = POST_PROCESSING_DATA_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer Blocking Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT_FEATURE_COUNT = POST_PROCESSING_DATA_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer Blocking Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BLOCKING_REPORT_OPERATION_COUNT = POST_PROCESSING_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.postprocessing.impl.TimelineReportImpl <em>Timeline Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.postprocessing.impl.TimelineReportImpl
	 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getTimelineReport()
	 * @generated
	 */
	int TIMELINE_REPORT = 8;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMELINE_REPORT__NETWORK = POST_PROCESSING_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMELINE_REPORT__FILE_NAME = POST_PROCESSING_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timeline Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMELINE_REPORT_FEATURE_COUNT = POST_PROCESSING_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Timeline Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMELINE_REPORT_OPERATION_COUNT = POST_PROCESSING_DATA_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.PostProcessingReport <em>Post Processing Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Processing Report</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport
	 * @generated
	 */
	EClass getPostProcessingReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.PostProcessingReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport#getNetwork()
	 * @see #getPostProcessingReport()
	 * @generated
	 */
	EReference getPostProcessingReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.PostProcessingReport#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport#getTime()
	 * @see #getPostProcessingReport()
	 * @generated
	 */
	EAttribute getPostProcessingReport_Time();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.PostProcessingReport#isDeadlock <em>Deadlock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadlock</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport#isDeadlock()
	 * @see #getPostProcessingReport()
	 * @generated
	 */
	EAttribute getPostProcessingReport_Deadlock();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.postprocessing.PostProcessingReport#getReports <em>Reports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reports</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport#getReports()
	 * @see #getPostProcessingReport()
	 * @generated
	 */
	EReference getPostProcessingReport_Reports();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.PostProcessingData <em>Post Processing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Processing Data</em>'.
	 * @see turnus.model.analysis.postprocessing.PostProcessingData
	 * @generated
	 */
	EClass getPostProcessingData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport <em>Actor Statistics Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Statistics Report</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport
	 * @generated
	 */
	EClass getActorStatisticsReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getNetwork()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Time</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getExecutionTime()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EAttribute getActorStatisticsReport_ExecutionTime();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getPartitions()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_Partitions();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getIdleTimes <em>Idle Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Idle Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getIdleTimes()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_IdleTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getBlockedReadingTimes <em>Blocked Reading Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Reading Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getBlockedReadingTimes()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_BlockedReadingTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getBlockedWritingTimes <em>Blocked Writing Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Writing Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getBlockedWritingTimes()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_BlockedWritingTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getProcessingTimes <em>Processing Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Processing Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getProcessingTimes()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EReference getActorStatisticsReport_ProcessingTimes();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getAverageOccupancy <em>Average Occupancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Occupancy</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getAverageOccupancy()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EAttribute getActorStatisticsReport_AverageOccupancy();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport#getOccupancyDeviation <em>Occupancy Deviation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occupancy Deviation</em>'.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport#getOccupancyDeviation()
	 * @see #getActorStatisticsReport()
	 * @generated
	 */
	EAttribute getActorStatisticsReport_OccupancyDeviation();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition <em>Statistical Actor Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statistical Actor Partition</em>'.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition
	 * @generated
	 */
	EClass getStatisticalActorPartition();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Actors</em>'.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition#getActors()
	 * @see #getStatisticalActorPartition()
	 * @generated
	 */
	EAttribute getStatisticalActorPartition_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getOccupancy <em>Occupancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occupancy</em>'.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition#getOccupancy()
	 * @see #getStatisticalActorPartition()
	 * @generated
	 */
	EAttribute getStatisticalActorPartition_Occupancy();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getSchedulingPolicy <em>Scheduling Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduling Policy</em>'.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition#getSchedulingPolicy()
	 * @see #getStatisticalActorPartition()
	 * @generated
	 */
	EAttribute getStatisticalActorPartition_SchedulingPolicy();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getPartitionId <em>Partition Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Id</em>'.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition#getPartitionId()
	 * @see #getStatisticalActorPartition()
	 * @generated
	 */
	EAttribute getStatisticalActorPartition_PartitionId();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport <em>Action Statistics Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Statistics Report</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport
	 * @generated
	 */
	EClass getActionStatisticsReport();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getActors()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_Actors();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleTimes <em>Idle Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Idle Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_IdleTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMinTimes <em>Idle Min Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Idle Min Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMinTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_IdleMinTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMaxTimes <em>Idle Max Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Idle Max Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMaxTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_IdleMaxTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingTimes <em>Blocked Reading Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Reading Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedReadingTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMinTimes <em>Blocked Reading Min Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Reading Min Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMinTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedReadingMinTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMaxTimes <em>Blocked Reading Max Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Reading Max Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMaxTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedReadingMaxTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingTimes <em>Blocked Writing Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Writing Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedWritingTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMinTimes <em>Blocked Writing Min Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Writing Min Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMinTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedWritingMinTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMaxTimes <em>Blocked Writing Max Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocked Writing Max Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMaxTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_BlockedWritingMaxTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getProcessingTimes <em>Processing Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Processing Times</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getProcessingTimes()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_ProcessingTimes();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getExecutionCounts <em>Execution Counts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Execution Counts</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getExecutionCounts()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_ExecutionCounts();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport#getNetwork()
	 * @see #getActionStatisticsReport()
	 * @generated
	 */
	EReference getActionStatisticsReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.SchedulerChecksReport <em>Scheduler Checks Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler Checks Report</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksReport
	 * @generated
	 */
	EClass getSchedulerChecksReport();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.postprocessing.SchedulerChecksReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksReport#getPartitions()
	 * @see #getSchedulerChecksReport()
	 * @generated
	 */
	EReference getSchedulerChecksReport_Partitions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.SchedulerChecksReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksReport#getNetwork()
	 * @see #getSchedulerChecksReport()
	 * @generated
	 */
	EReference getSchedulerChecksReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition <em>Scheduler Checks Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler Checks Partition</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition
	 * @generated
	 */
	EClass getSchedulerChecksPartition();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedCheckedData <em>Aggregated Checked Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregated Checked Data</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedCheckedData()
	 * @see #getSchedulerChecksPartition()
	 * @generated
	 */
	EReference getSchedulerChecksPartition_AggregatedCheckedData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedFailedData <em>Aggregated Failed Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregated Failed Data</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedFailedData()
	 * @see #getSchedulerChecksPartition()
	 * @generated
	 */
	EReference getSchedulerChecksPartition_AggregatedFailedData();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getCheckedConditionsMap <em>Checked Conditions Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Checked Conditions Map</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition#getCheckedConditionsMap()
	 * @see #getSchedulerChecksPartition()
	 * @generated
	 */
	EReference getSchedulerChecksPartition_CheckedConditionsMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getFailedConditionsMap <em>Failed Conditions Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Failed Conditions Map</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition#getFailedConditionsMap()
	 * @see #getSchedulerChecksPartition()
	 * @generated
	 */
	EReference getSchedulerChecksPartition_FailedConditionsMap();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getPartitionId <em>Partition Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Id</em>'.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition#getPartitionId()
	 * @see #getSchedulerChecksPartition()
	 * @generated
	 */
	EAttribute getSchedulerChecksPartition_PartitionId();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.BufferBlockingReport <em>Buffer Blocking Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Blocking Report</em>'.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport
	 * @generated
	 */
	EClass getBufferBlockingReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport#getNetwork()
	 * @see #getBufferBlockingReport()
	 * @generated
	 */
	EReference getBufferBlockingReport_Network();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Max Blocked Output Tokens</em>'.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedOutputTokens()
	 * @see #getBufferBlockingReport()
	 * @generated
	 */
	EReference getBufferBlockingReport_MaxBlockedOutputTokens();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Max Blocked Multiplication</em>'.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedMultiplication()
	 * @see #getBufferBlockingReport()
	 * @generated
	 */
	EReference getBufferBlockingReport_MaxBlockedMultiplication();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getBlockingInstances <em>Blocking Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocking Instances</em>'.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport#getBlockingInstances()
	 * @see #getBufferBlockingReport()
	 * @generated
	 */
	EReference getBufferBlockingReport_BlockingInstances();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.postprocessing.TimelineReport <em>Timeline Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timeline Report</em>'.
	 * @see turnus.model.analysis.postprocessing.TimelineReport
	 * @generated
	 */
	EClass getTimelineReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.postprocessing.TimelineReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.postprocessing.TimelineReport#getNetwork()
	 * @see #getTimelineReport()
	 * @generated
	 */
	EReference getTimelineReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.postprocessing.TimelineReport#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see turnus.model.analysis.postprocessing.TimelineReport#getFileName()
	 * @see #getTimelineReport()
	 * @generated
	 */
	EAttribute getTimelineReport_FileName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PostprocessingFactory getPostprocessingFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.PostProcessingReportImpl <em>Post Processing Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.PostProcessingReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getPostProcessingReport()
		 * @generated
		 */
		EClass POST_PROCESSING_REPORT = eINSTANCE.getPostProcessingReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_PROCESSING_REPORT__NETWORK = eINSTANCE.getPostProcessingReport_Network();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POST_PROCESSING_REPORT__TIME = eINSTANCE.getPostProcessingReport_Time();

		/**
		 * The meta object literal for the '<em><b>Deadlock</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POST_PROCESSING_REPORT__DEADLOCK = eINSTANCE.getPostProcessingReport_Deadlock();

		/**
		 * The meta object literal for the '<em><b>Reports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_PROCESSING_REPORT__REPORTS = eINSTANCE.getPostProcessingReport_Reports();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.PostProcessingDataImpl <em>Post Processing Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.PostProcessingDataImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getPostProcessingData()
		 * @generated
		 */
		EClass POST_PROCESSING_DATA = eINSTANCE.getPostProcessingData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl <em>Actor Statistics Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.ActorStatisticsReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getActorStatisticsReport()
		 * @generated
		 */
		EClass ACTOR_STATISTICS_REPORT = eINSTANCE.getActorStatisticsReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__NETWORK = eINSTANCE.getActorStatisticsReport_Network();

		/**
		 * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_STATISTICS_REPORT__EXECUTION_TIME = eINSTANCE.getActorStatisticsReport_ExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__PARTITIONS = eINSTANCE.getActorStatisticsReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Idle Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__IDLE_TIMES = eINSTANCE.getActorStatisticsReport_IdleTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Reading Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES = eINSTANCE.getActorStatisticsReport_BlockedReadingTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Writing Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES = eINSTANCE.getActorStatisticsReport_BlockedWritingTimes();

		/**
		 * The meta object literal for the '<em><b>Processing Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_STATISTICS_REPORT__PROCESSING_TIMES = eINSTANCE.getActorStatisticsReport_ProcessingTimes();

		/**
		 * The meta object literal for the '<em><b>Average Occupancy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY = eINSTANCE.getActorStatisticsReport_AverageOccupancy();

		/**
		 * The meta object literal for the '<em><b>Occupancy Deviation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION = eINSTANCE.getActorStatisticsReport_OccupancyDeviation();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl <em>Statistical Actor Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.StatisticalActorPartitionImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getStatisticalActorPartition()
		 * @generated
		 */
		EClass STATISTICAL_ACTOR_PARTITION = eINSTANCE.getStatisticalActorPartition();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_ACTOR_PARTITION__ACTORS = eINSTANCE.getStatisticalActorPartition_Actors();

		/**
		 * The meta object literal for the '<em><b>Occupancy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_ACTOR_PARTITION__OCCUPANCY = eINSTANCE.getStatisticalActorPartition_Occupancy();

		/**
		 * The meta object literal for the '<em><b>Scheduling Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY = eINSTANCE.getStatisticalActorPartition_SchedulingPolicy();

		/**
		 * The meta object literal for the '<em><b>Partition Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICAL_ACTOR_PARTITION__PARTITION_ID = eINSTANCE.getStatisticalActorPartition_PartitionId();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl <em>Action Statistics Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.ActionStatisticsReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getActionStatisticsReport()
		 * @generated
		 */
		EClass ACTION_STATISTICS_REPORT = eINSTANCE.getActionStatisticsReport();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__ACTORS = eINSTANCE.getActionStatisticsReport_Actors();

		/**
		 * The meta object literal for the '<em><b>Idle Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__IDLE_TIMES = eINSTANCE.getActionStatisticsReport_IdleTimes();

		/**
		 * The meta object literal for the '<em><b>Idle Min Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES = eINSTANCE.getActionStatisticsReport_IdleMinTimes();

		/**
		 * The meta object literal for the '<em><b>Idle Max Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES = eINSTANCE.getActionStatisticsReport_IdleMaxTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Reading Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES = eINSTANCE.getActionStatisticsReport_BlockedReadingTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Reading Min Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES = eINSTANCE.getActionStatisticsReport_BlockedReadingMinTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Reading Max Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES = eINSTANCE.getActionStatisticsReport_BlockedReadingMaxTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Writing Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES = eINSTANCE.getActionStatisticsReport_BlockedWritingTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Writing Min Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES = eINSTANCE.getActionStatisticsReport_BlockedWritingMinTimes();

		/**
		 * The meta object literal for the '<em><b>Blocked Writing Max Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES = eINSTANCE.getActionStatisticsReport_BlockedWritingMaxTimes();

		/**
		 * The meta object literal for the '<em><b>Processing Times</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__PROCESSING_TIMES = eINSTANCE.getActionStatisticsReport_ProcessingTimes();

		/**
		 * The meta object literal for the '<em><b>Execution Counts</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__EXECUTION_COUNTS = eINSTANCE.getActionStatisticsReport_ExecutionCounts();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_STATISTICS_REPORT__NETWORK = eINSTANCE.getActionStatisticsReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl <em>Scheduler Checks Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getSchedulerChecksReport()
		 * @generated
		 */
		EClass SCHEDULER_CHECKS_REPORT = eINSTANCE.getSchedulerChecksReport();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_REPORT__PARTITIONS = eINSTANCE.getSchedulerChecksReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_REPORT__NETWORK = eINSTANCE.getSchedulerChecksReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl <em>Scheduler Checks Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.SchedulerChecksPartitionImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getSchedulerChecksPartition()
		 * @generated
		 */
		EClass SCHEDULER_CHECKS_PARTITION = eINSTANCE.getSchedulerChecksPartition();

		/**
		 * The meta object literal for the '<em><b>Aggregated Checked Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA = eINSTANCE.getSchedulerChecksPartition_AggregatedCheckedData();

		/**
		 * The meta object literal for the '<em><b>Aggregated Failed Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA = eINSTANCE.getSchedulerChecksPartition_AggregatedFailedData();

		/**
		 * The meta object literal for the '<em><b>Checked Conditions Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP = eINSTANCE.getSchedulerChecksPartition_CheckedConditionsMap();

		/**
		 * The meta object literal for the '<em><b>Failed Conditions Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP = eINSTANCE.getSchedulerChecksPartition_FailedConditionsMap();

		/**
		 * The meta object literal for the '<em><b>Partition Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_CHECKS_PARTITION__PARTITION_ID = eINSTANCE.getSchedulerChecksPartition_PartitionId();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl <em>Buffer Blocking Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getBufferBlockingReport()
		 * @generated
		 */
		EClass BUFFER_BLOCKING_REPORT = eINSTANCE.getBufferBlockingReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BLOCKING_REPORT__NETWORK = eINSTANCE.getBufferBlockingReport_Network();

		/**
		 * The meta object literal for the '<em><b>Max Blocked Output Tokens</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS = eINSTANCE.getBufferBlockingReport_MaxBlockedOutputTokens();

		/**
		 * The meta object literal for the '<em><b>Max Blocked Multiplication</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION = eINSTANCE.getBufferBlockingReport_MaxBlockedMultiplication();

		/**
		 * The meta object literal for the '<em><b>Blocking Instances</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES = eINSTANCE.getBufferBlockingReport_BlockingInstances();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.postprocessing.impl.TimelineReportImpl <em>Timeline Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.postprocessing.impl.TimelineReportImpl
		 * @see turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl#getTimelineReport()
		 * @generated
		 */
		EClass TIMELINE_REPORT = eINSTANCE.getTimelineReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMELINE_REPORT__NETWORK = eINSTANCE.getTimelineReport_Network();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMELINE_REPORT__FILE_NAME = eINSTANCE.getTimelineReport_FileName();

	}

} //PostprocessingPackage

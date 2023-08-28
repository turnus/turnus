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
package turnus.model.analysis.profiling;

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
 * @see turnus.model.analysis.profiling.ProfilingFactory
 * @model kind="package"
 * @generated
 */
public interface ProfilingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profiling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/profiling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.profiling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfilingPackage eINSTANCE = turnus.model.analysis.profiling.impl.ProfilingPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationReportImpl <em>Intra Action Communication Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.IntraActionCommunicationReportImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActionCommunicationReport()
	 * @generated
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Actors Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT__ACTORS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Intra Action Communication Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Intra Action Communication Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl <em>Intra Actor Communication Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActorCommunicationData()
	 * @generated
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA = 1;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Consumed Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Produced Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS = 2;

	/**
	 * The feature id for the '<em><b>Tokens Producers Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP = 3;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA = 4;

	/**
	 * The number of structural features of the '<em>Intra Actor Communication Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Intra Actor Communication Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTOR_COMMUNICATION_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl <em>Intra Action Communication Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActionCommunicationData()
	 * @generated
	 */
	int INTRA_ACTION_COMMUNICATION_DATA = 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Consumed Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Produced Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS = 2;

	/**
	 * The feature id for the '<em><b>Tokens Producers Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP = 3;

	/**
	 * The number of structural features of the '<em>Intra Action Communication Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Intra Action Communication Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTRA_ACTION_COMMUNICATION_DATA_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.ProfilingStatsReportImpl <em>Stats Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.ProfilingStatsReportImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getProfilingStatsReport()
	 * @generated
	 */
	int PROFILING_STATS_REPORT = 3;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Actors Stats Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT__ACTORS_STATS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Network Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT__NETWORK_NAME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stats Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stats Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl <em>Stats Actor Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getProfilingStatsActorData()
	 * @generated
	 */
	int PROFILING_STATS_ACTOR_DATA = 4;

	/**
	 * The feature id for the '<em><b>Actor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA__ACTOR_NAME = 0;

	/**
	 * The feature id for the '<em><b>Actions Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Scheduler Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Actions Weight Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT = 3;

	/**
	 * The feature id for the '<em><b>Scheduler Weight Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT = 4;

	/**
	 * The number of structural features of the '<em>Stats Actor Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Stats Actor Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILING_STATS_ACTOR_DATA_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl <em>Inter Partition Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.InterPartitionDataImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getInterPartitionData()
	 * @generated
	 */
	int INTER_PARTITION_DATA = 5;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__WORKLOAD = 1;

	/**
	 * The feature id for the '<em><b>Max Incoming Bits Per Firing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING = 2;

	/**
	 * The feature id for the '<em><b>Max Outgoing Bits Per Firing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING = 3;

	/**
	 * The feature id for the '<em><b>Persistent Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__PERSISTENT_MEMORY = 4;

	/**
	 * The feature id for the '<em><b>Max Transient Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY = 5;

	/**
	 * The feature id for the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA__PARTITION_ID = 6;

	/**
	 * The number of structural features of the '<em>Inter Partition Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Inter Partition Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl <em>Inter Partition Communication And Memory Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl
	 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getInterPartitionCommunicationAndMemoryReport()
	 * @generated
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT = 6;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Partition Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inter Partition Communication And Memory Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Inter Partition Communication And Memory Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.IntraActionCommunicationReport <em>Intra Action Communication Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intra Action Communication Report</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationReport
	 * @generated
	 */
	EClass getIntraActionCommunicationReport();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiling.IntraActionCommunicationReport#getActorsData <em>Actors Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors Data</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationReport#getActorsData()
	 * @see #getIntraActionCommunicationReport()
	 * @generated
	 */
	EReference getIntraActionCommunicationReport_ActorsData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiling.IntraActionCommunicationReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationReport#getNetwork()
	 * @see #getIntraActionCommunicationReport()
	 * @generated
	 */
	EReference getIntraActionCommunicationReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.IntraActorCommunicationData <em>Intra Actor Communication Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intra Actor Communication Data</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData
	 * @generated
	 */
	EClass getIntraActorCommunicationData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiling.IntraActorCommunicationData#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData#getActor()
	 * @see #getIntraActorCommunicationData()
	 * @generated
	 */
	EReference getIntraActorCommunicationData_Actor();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiling.IntraActorCommunicationData#getConsumedTokens <em>Consumed Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consumed Tokens</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData#getConsumedTokens()
	 * @see #getIntraActorCommunicationData()
	 * @generated
	 */
	EReference getIntraActorCommunicationData_ConsumedTokens();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiling.IntraActorCommunicationData#getProducedTokens <em>Produced Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Produced Tokens</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData#getProducedTokens()
	 * @see #getIntraActorCommunicationData()
	 * @generated
	 */
	EReference getIntraActorCommunicationData_ProducedTokens();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiling.IntraActorCommunicationData#getTokensProducersMap <em>Tokens Producers Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Tokens Producers Map</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData#getTokensProducersMap()
	 * @see #getIntraActorCommunicationData()
	 * @generated
	 */
	EReference getIntraActorCommunicationData_TokensProducersMap();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiling.IntraActorCommunicationData#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.profiling.IntraActorCommunicationData#getActionsData()
	 * @see #getIntraActorCommunicationData()
	 * @generated
	 */
	EReference getIntraActorCommunicationData_ActionsData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.IntraActionCommunicationData <em>Intra Action Communication Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intra Action Communication Data</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationData
	 * @generated
	 */
	EClass getIntraActionCommunicationData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationData#getAction()
	 * @see #getIntraActionCommunicationData()
	 * @generated
	 */
	EReference getIntraActionCommunicationData_Action();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getConsumedTokens <em>Consumed Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consumed Tokens</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationData#getConsumedTokens()
	 * @see #getIntraActionCommunicationData()
	 * @generated
	 */
	EReference getIntraActionCommunicationData_ConsumedTokens();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getProducedTokens <em>Produced Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Produced Tokens</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationData#getProducedTokens()
	 * @see #getIntraActionCommunicationData()
	 * @generated
	 */
	EReference getIntraActionCommunicationData_ProducedTokens();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getTokensProducersMap <em>Tokens Producers Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Tokens Producers Map</em>'.
	 * @see turnus.model.analysis.profiling.IntraActionCommunicationData#getTokensProducersMap()
	 * @see #getIntraActionCommunicationData()
	 * @generated
	 */
	EReference getIntraActionCommunicationData_TokensProducersMap();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.ProfilingStatsReport <em>Stats Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stats Report</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsReport
	 * @generated
	 */
	EClass getProfilingStatsReport();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiling.ProfilingStatsReport#getActorsStatsData <em>Actors Stats Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors Stats Data</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsReport#getActorsStatsData()
	 * @see #getProfilingStatsReport()
	 * @generated
	 */
	EReference getProfilingStatsReport_ActorsStatsData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsReport#getNetworkName <em>Network Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Network Name</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsReport#getNetworkName()
	 * @see #getProfilingStatsReport()
	 * @generated
	 */
	EAttribute getProfilingStatsReport_NetworkName();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.ProfilingStatsActorData <em>Stats Actor Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stats Actor Data</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData
	 * @generated
	 */
	EClass getProfilingStatsActorData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsActorData#getActorName <em>Actor Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actor Name</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData#getActorName()
	 * @see #getProfilingStatsActorData()
	 * @generated
	 */
	EAttribute getProfilingStatsActorData_ActorName();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsActorData#getActionsWeight <em>Actions Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actions Weight</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData#getActionsWeight()
	 * @see #getProfilingStatsActorData()
	 * @generated
	 */
	EAttribute getProfilingStatsActorData_ActionsWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsActorData#getSchedulerWeight <em>Scheduler Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduler Weight</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData#getSchedulerWeight()
	 * @see #getProfilingStatsActorData()
	 * @generated
	 */
	EAttribute getProfilingStatsActorData_SchedulerWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsActorData#getActionsWeightPercent <em>Actions Weight Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actions Weight Percent</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData#getActionsWeightPercent()
	 * @see #getProfilingStatsActorData()
	 * @generated
	 */
	EAttribute getProfilingStatsActorData_ActionsWeightPercent();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.ProfilingStatsActorData#getSchedulerWeightPercent <em>Scheduler Weight Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduler Weight Percent</em>'.
	 * @see turnus.model.analysis.profiling.ProfilingStatsActorData#getSchedulerWeightPercent()
	 * @see #getProfilingStatsActorData()
	 * @generated
	 */
	EAttribute getProfilingStatsActorData_SchedulerWeightPercent();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.InterPartitionData <em>Inter Partition Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inter Partition Data</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData
	 * @generated
	 */
	EClass getInterPartitionData();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.profiling.InterPartitionData#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getActors()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EReference getInterPartitionData_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getWorkload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workload</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getWorkload()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_Workload();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxIncomingBitsPerFiring <em>Max Incoming Bits Per Firing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Incoming Bits Per Firing</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getMaxIncomingBitsPerFiring()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_MaxIncomingBitsPerFiring();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxOutgoingBitsPerFiring <em>Max Outgoing Bits Per Firing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Outgoing Bits Per Firing</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getMaxOutgoingBitsPerFiring()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_MaxOutgoingBitsPerFiring();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getPersistentMemory <em>Persistent Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Memory</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getPersistentMemory()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_PersistentMemory();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxTransientMemory <em>Max Transient Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Transient Memory</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getMaxTransientMemory()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_MaxTransientMemory();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiling.InterPartitionData#getPartitionId <em>Partition Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Id</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionData#getPartitionId()
	 * @see #getInterPartitionData()
	 * @generated
	 */
	EAttribute getInterPartitionData_PartitionId();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport <em>Inter Partition Communication And Memory Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inter Partition Communication And Memory Report</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport
	 * @generated
	 */
	EClass getInterPartitionCommunicationAndMemoryReport();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getPartitionData <em>Partition Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Partition Data</em>'.
	 * @see turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getPartitionData()
	 * @see #getInterPartitionCommunicationAndMemoryReport()
	 * @generated
	 */
	EReference getInterPartitionCommunicationAndMemoryReport_PartitionData();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProfilingFactory getProfilingFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationReportImpl <em>Intra Action Communication Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.IntraActionCommunicationReportImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActionCommunicationReport()
		 * @generated
		 */
		EClass INTRA_ACTION_COMMUNICATION_REPORT = eINSTANCE.getIntraActionCommunicationReport();

		/**
		 * The meta object literal for the '<em><b>Actors Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_REPORT__ACTORS_DATA = eINSTANCE.getIntraActionCommunicationReport_ActorsData();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_REPORT__NETWORK = eINSTANCE.getIntraActionCommunicationReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl <em>Intra Actor Communication Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActorCommunicationData()
		 * @generated
		 */
		EClass INTRA_ACTOR_COMMUNICATION_DATA = eINSTANCE.getIntraActorCommunicationData();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTOR_COMMUNICATION_DATA__ACTOR = eINSTANCE.getIntraActorCommunicationData_Actor();

		/**
		 * The meta object literal for the '<em><b>Consumed Tokens</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS = eINSTANCE.getIntraActorCommunicationData_ConsumedTokens();

		/**
		 * The meta object literal for the '<em><b>Produced Tokens</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS = eINSTANCE.getIntraActorCommunicationData_ProducedTokens();

		/**
		 * The meta object literal for the '<em><b>Tokens Producers Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP = eINSTANCE.getIntraActorCommunicationData_TokensProducersMap();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA = eINSTANCE.getIntraActorCommunicationData_ActionsData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl <em>Intra Action Communication Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getIntraActionCommunicationData()
		 * @generated
		 */
		EClass INTRA_ACTION_COMMUNICATION_DATA = eINSTANCE.getIntraActionCommunicationData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_DATA__ACTION = eINSTANCE.getIntraActionCommunicationData_Action();

		/**
		 * The meta object literal for the '<em><b>Consumed Tokens</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS = eINSTANCE.getIntraActionCommunicationData_ConsumedTokens();

		/**
		 * The meta object literal for the '<em><b>Produced Tokens</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS = eINSTANCE.getIntraActionCommunicationData_ProducedTokens();

		/**
		 * The meta object literal for the '<em><b>Tokens Producers Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP = eINSTANCE.getIntraActionCommunicationData_TokensProducersMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.ProfilingStatsReportImpl <em>Stats Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.ProfilingStatsReportImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getProfilingStatsReport()
		 * @generated
		 */
		EClass PROFILING_STATS_REPORT = eINSTANCE.getProfilingStatsReport();

		/**
		 * The meta object literal for the '<em><b>Actors Stats Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILING_STATS_REPORT__ACTORS_STATS_DATA = eINSTANCE.getProfilingStatsReport_ActorsStatsData();

		/**
		 * The meta object literal for the '<em><b>Network Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_REPORT__NETWORK_NAME = eINSTANCE.getProfilingStatsReport_NetworkName();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl <em>Stats Actor Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.ProfilingStatsActorDataImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getProfilingStatsActorData()
		 * @generated
		 */
		EClass PROFILING_STATS_ACTOR_DATA = eINSTANCE.getProfilingStatsActorData();

		/**
		 * The meta object literal for the '<em><b>Actor Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_ACTOR_DATA__ACTOR_NAME = eINSTANCE.getProfilingStatsActorData_ActorName();

		/**
		 * The meta object literal for the '<em><b>Actions Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT = eINSTANCE.getProfilingStatsActorData_ActionsWeight();

		/**
		 * The meta object literal for the '<em><b>Scheduler Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT = eINSTANCE.getProfilingStatsActorData_SchedulerWeight();

		/**
		 * The meta object literal for the '<em><b>Actions Weight Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT = eINSTANCE.getProfilingStatsActorData_ActionsWeightPercent();

		/**
		 * The meta object literal for the '<em><b>Scheduler Weight Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT = eINSTANCE.getProfilingStatsActorData_SchedulerWeightPercent();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl <em>Inter Partition Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.InterPartitionDataImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getInterPartitionData()
		 * @generated
		 */
		EClass INTER_PARTITION_DATA = eINSTANCE.getInterPartitionData();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTER_PARTITION_DATA__ACTORS = eINSTANCE.getInterPartitionData_Actors();

		/**
		 * The meta object literal for the '<em><b>Workload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__WORKLOAD = eINSTANCE.getInterPartitionData_Workload();

		/**
		 * The meta object literal for the '<em><b>Max Incoming Bits Per Firing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING = eINSTANCE.getInterPartitionData_MaxIncomingBitsPerFiring();

		/**
		 * The meta object literal for the '<em><b>Max Outgoing Bits Per Firing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING = eINSTANCE.getInterPartitionData_MaxOutgoingBitsPerFiring();

		/**
		 * The meta object literal for the '<em><b>Persistent Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__PERSISTENT_MEMORY = eINSTANCE.getInterPartitionData_PersistentMemory();

		/**
		 * The meta object literal for the '<em><b>Max Transient Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY = eINSTANCE.getInterPartitionData_MaxTransientMemory();

		/**
		 * The meta object literal for the '<em><b>Partition Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTER_PARTITION_DATA__PARTITION_ID = eINSTANCE.getInterPartitionData_PartitionId();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl <em>Inter Partition Communication And Memory Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl
		 * @see turnus.model.analysis.profiling.impl.ProfilingPackageImpl#getInterPartitionCommunicationAndMemoryReport()
		 * @generated
		 */
		EClass INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT = eINSTANCE.getInterPartitionCommunicationAndMemoryReport();

		/**
		 * The meta object literal for the '<em><b>Partition Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA = eINSTANCE.getInterPartitionCommunicationAndMemoryReport_PartitionData();

	}

} //ProfilingPackage

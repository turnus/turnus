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
package turnus.model.analysis.bottlenecks;

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
 * @see turnus.model.analysis.bottlenecks.BottlenecksFactory
 * @model kind="package"
 * @generated
 */
public interface BottlenecksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bottlenecks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/bottlenecks";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.bottlenecks";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BottlenecksPackage eINSTANCE = turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.BottlenecksReportImpl <em>Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksReportImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getBottlenecksReport()
	 * @generated
	 */
	int BOTTLENECKS_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__ACTIONS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__CP_WEIGHT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cp Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__CP_VARIANCE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__TOTAL_WEIGHT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Total Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__TOTAL_VARIANCE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__CP_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT__TOTAL_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl <em>Action Bottlenecks Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getActionBottlenecksData()
	 * @generated
	 */
	int ACTION_BOTTLENECKS_DATA = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Slack Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__SLACK_MIN = 1;

	/**
	 * The feature id for the '<em><b>Slack Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__SLACK_MAX = 2;

	/**
	 * The feature id for the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__CP_WEIGHT = 3;

	/**
	 * The feature id for the '<em><b>Cp Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__CP_VARIANCE = 4;

	/**
	 * The feature id for the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT = 5;

	/**
	 * The feature id for the '<em><b>Total Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE = 6;

	/**
	 * The feature id for the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__CP_FIRINGS = 7;

	/**
	 * The feature id for the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS = 8;

	/**
	 * The number of structural features of the '<em>Action Bottlenecks Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Action Bottlenecks Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_DATA_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl <em>Impact Analysis Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getImpactAnalysisReport()
	 * @generated
	 */
	int IMPACT_ANALYSIS_REPORT = 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__CLASS_LEVEL = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Impact Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__IMPACT_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initial Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Impact Analysis Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Impact Analysis Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisDataImpl <em>Impact Analysis Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ImpactAnalysisDataImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getImpactAnalysisData()
	 * @generated
	 */
	int IMPACT_ANALYSIS_DATA = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__ACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__ACTOR_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Cp Reduction Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP = 2;

	/**
	 * The feature id for the '<em><b>Reports Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__REPORTS_MAP = 3;

	/**
	 * The number of structural features of the '<em>Impact Analysis Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Impact Analysis Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksReportMapImpl <em>Double To Bottlenecks Report Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksReportMapImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getDoubleToBottlenecksReportMap()
	 * @generated
	 */
	int DOUBLE_TO_BOTTLENECKS_REPORT_MAP = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_REPORT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_REPORT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Double To Bottlenecks Report Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_REPORT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Double To Bottlenecks Report Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_REPORT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl <em>With Scheduling Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT = 5;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_WEIGHT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_WEIGHT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Cp Blocking Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_BLOCKING_TIME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Cp Partitions Blocking Time</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Deadlock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT__DEADLOCK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>With Scheduling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>With Scheduling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTLENECKS_WITH_SCHEDULING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl <em>Action Bottlenecks With Scheduling Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA = 6;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS = 3;

	/**
	 * The feature id for the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS = 4;

	/**
	 * The feature id for the '<em><b>Max Blocked Output Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS = 5;

	/**
	 * The feature id for the '<em><b>Max Blocked Multiplication</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION = 6;

	/**
	 * The feature id for the '<em><b>Blocking Instances</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES = 7;

	/**
	 * The number of structural features of the '<em>Action Bottlenecks With Scheduling Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Action Bottlenecks With Scheduling Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl <em>Scheduled Impact Analysis Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getScheduledImpactAnalysisData()
	 * @generated
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA = 7;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA__ACTOR_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Cp Reduction Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP = 2;

	/**
	 * The feature id for the '<em><b>Time Reduction Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP = 3;

	/**
	 * The feature id for the '<em><b>Reports Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP = 4;

	/**
	 * The number of structural features of the '<em>Scheduled Impact Analysis Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Scheduled Impact Analysis Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksWithSchedulingReportMapImpl <em>Double To Bottlenecks With Scheduling Report Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksWithSchedulingReportMapImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getDoubleToBottlenecksWithSchedulingReportMap()
	 * @generated
	 */
	int DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Double To Bottlenecks With Scheduling Report Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Double To Bottlenecks With Scheduling Report Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisReportImpl <em>Scheduled Impact Analysis Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisReportImpl
	 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getScheduledImpactAnalysisReport()
	 * @generated
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT = 9;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__CLASS_LEVEL = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scheduled Impact Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__SCHEDULED_IMPACT_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initial Bottlenecks With Scheduling</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS_WITH_SCHEDULING = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Scheduled Impact Analysis Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Scheduled Impact Analysis Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_IMPACT_ANALYSIS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.BottlenecksReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport
	 * @generated
	 */
	EClass getBottlenecksReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getNetwork()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EReference getBottlenecksReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getActionsData()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EReference getBottlenecksReport_ActionsData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getCpWeight <em>Cp Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getCpWeight()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_CpWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getCpVariance <em>Cp Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Variance</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getCpVariance()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_CpVariance();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalWeight <em>Total Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalWeight()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_TotalWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalVariance <em>Total Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Variance</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalVariance()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_TotalVariance();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getCpFirings <em>Cp Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getCpFirings()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_CpFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalFirings <em>Total Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksReport#getTotalFirings()
	 * @see #getBottlenecksReport()
	 * @generated
	 */
	EAttribute getBottlenecksReport_TotalFirings();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData <em>Action Bottlenecks Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Bottlenecks Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData
	 * @generated
	 */
	EClass getActionBottlenecksData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getAction()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EReference getActionBottlenecksData_Action();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpWeight <em>Cp Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpWeight()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_CpWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpVariance <em>Cp Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Variance</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpVariance()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_CpVariance();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalWeight <em>Total Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalWeight()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_TotalWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalVariance <em>Total Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Variance</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalVariance()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_TotalVariance();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpFirings <em>Cp Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpFirings()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_CpFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalFirings <em>Total Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalFirings()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_TotalFirings();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisReport <em>Impact Analysis Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Report</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisReport
	 * @generated
	 */
	EClass getImpactAnalysisReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getNetwork()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisReport#isClassLevel <em>Class Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Level</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisReport#isClassLevel()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EAttribute getImpactAnalysisReport_ClassLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getImpactData <em>Impact Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Impact Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getImpactData()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_ImpactData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getInitialBottlenecks <em>Initial Bottlenecks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Bottlenecks</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisReport#getInitialBottlenecks()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_InitialBottlenecks();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData <em>Impact Analysis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisData
	 * @generated
	 */
	EClass getImpactAnalysisData();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActions()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_Actions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActorClass()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_ActorClass();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getCpReductionMap <em>Cp Reduction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Cp Reduction Map</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisData#getCpReductionMap()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_CpReductionMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getReportsMap <em>Reports Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Reports Map</em>'.
	 * @see turnus.model.analysis.bottlenecks.ImpactAnalysisData#getReportsMap()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_ReportsMap();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Double To Bottlenecks Report Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double To Bottlenecks Report Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EDoubleObject"
	 *        valueType="turnus.model.analysis.bottlenecks.BottlenecksReport" valueContainment="true"
	 * @generated
	 */
	EClass getDoubleToBottlenecksReportMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToBottlenecksReportMap()
	 * @generated
	 */
	EAttribute getDoubleToBottlenecksReportMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToBottlenecksReportMap()
	 * @generated
	 */
	EReference getDoubleToBottlenecksReportMap_Value();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport <em>With Scheduling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Scheduling Report</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport
	 * @generated
	 */
	EClass getBottlenecksWithSchedulingReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getNetwork()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EReference getBottlenecksWithSchedulingReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getActionsData()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EReference getBottlenecksWithSchedulingReport_ActionsData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpWeight <em>Cp Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpWeight()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_CpWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalWeight <em>Total Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalWeight()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_TotalWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpFirings <em>Cp Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpFirings()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_CpFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalFirings <em>Total Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalFirings()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_TotalFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Time</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getExecutionTime()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_ExecutionTime();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpBlockingTime <em>Cp Blocking Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Blocking Time</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpBlockingTime()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_CpBlockingTime();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpPartitionsBlockingTime <em>Cp Partitions Blocking Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Cp Partitions Blocking Time</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpPartitionsBlockingTime()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EReference getBottlenecksWithSchedulingReport_CpPartitionsBlockingTime();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#isDeadlock <em>Deadlock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadlock</em>'.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#isDeadlock()
	 * @see #getBottlenecksWithSchedulingReport()
	 * @generated
	 */
	EAttribute getBottlenecksWithSchedulingReport_Deadlock();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData <em>Action Bottlenecks With Scheduling Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Bottlenecks With Scheduling Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData
	 * @generated
	 */
	EClass getActionBottlenecksWithSchedulingData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getAction()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EReference getActionBottlenecksWithSchedulingData_Action();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpWeight <em>Cp Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpWeight()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EAttribute getActionBottlenecksWithSchedulingData_CpWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalWeight <em>Total Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Weight</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalWeight()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EAttribute getActionBottlenecksWithSchedulingData_TotalWeight();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpFirings <em>Cp Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpFirings()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EAttribute getActionBottlenecksWithSchedulingData_CpFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalFirings <em>Total Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Firings</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalFirings()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EAttribute getActionBottlenecksWithSchedulingData_TotalFirings();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Max Blocked Output Tokens</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedOutputTokens()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EReference getActionBottlenecksWithSchedulingData_MaxBlockedOutputTokens();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Max Blocked Multiplication</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedMultiplication()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EReference getActionBottlenecksWithSchedulingData_MaxBlockedMultiplication();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getBlockingInstances <em>Blocking Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Blocking Instances</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getBlockingInstances()
	 * @see #getActionBottlenecksWithSchedulingData()
	 * @generated
	 */
	EReference getActionBottlenecksWithSchedulingData_BlockingInstances();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData <em>Scheduled Impact Analysis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduled Impact Analysis Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData
	 * @generated
	 */
	EClass getScheduledImpactAnalysisData();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getActions()
	 * @see #getScheduledImpactAnalysisData()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisData_Actions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getActorClass()
	 * @see #getScheduledImpactAnalysisData()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisData_ActorClass();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getCpReductionMap <em>Cp Reduction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Cp Reduction Map</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getCpReductionMap()
	 * @see #getScheduledImpactAnalysisData()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisData_CpReductionMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getTimeReductionMap <em>Time Reduction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Time Reduction Map</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getTimeReductionMap()
	 * @see #getScheduledImpactAnalysisData()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisData_TimeReductionMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getReportsMap <em>Reports Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Reports Map</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData#getReportsMap()
	 * @see #getScheduledImpactAnalysisData()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisData_ReportsMap();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Double To Bottlenecks With Scheduling Report Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double To Bottlenecks With Scheduling Report Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EDoubleObject"
	 *        valueType="turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport" valueContainment="true"
	 * @generated
	 */
	EClass getDoubleToBottlenecksWithSchedulingReportMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToBottlenecksWithSchedulingReportMap()
	 * @generated
	 */
	EAttribute getDoubleToBottlenecksWithSchedulingReportMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToBottlenecksWithSchedulingReportMap()
	 * @generated
	 */
	EReference getDoubleToBottlenecksWithSchedulingReportMap_Value();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport <em>Scheduled Impact Analysis Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduled Impact Analysis Report</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport
	 * @generated
	 */
	EClass getScheduledImpactAnalysisReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getNetwork()
	 * @see #getScheduledImpactAnalysisReport()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#isClassLevel <em>Class Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Level</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#isClassLevel()
	 * @see #getScheduledImpactAnalysisReport()
	 * @generated
	 */
	EAttribute getScheduledImpactAnalysisReport_ClassLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getScheduledImpactData <em>Scheduled Impact Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scheduled Impact Data</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getScheduledImpactData()
	 * @see #getScheduledImpactAnalysisReport()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisReport_ScheduledImpactData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getInitialBottlenecksWithScheduling <em>Initial Bottlenecks With Scheduling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Bottlenecks With Scheduling</em>'.
	 * @see turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport#getInitialBottlenecksWithScheduling()
	 * @see #getScheduledImpactAnalysisReport()
	 * @generated
	 */
	EReference getScheduledImpactAnalysisReport_InitialBottlenecksWithScheduling();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMin <em>Slack Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slack Min</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMin()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_SlackMin();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMax <em>Slack Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slack Max</em>'.
	 * @see turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMax()
	 * @see #getActionBottlenecksData()
	 * @generated
	 */
	EAttribute getActionBottlenecksData_SlackMax();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BottlenecksFactory getBottlenecksFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.BottlenecksReportImpl <em>Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksReportImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getBottlenecksReport()
		 * @generated
		 */
		EClass BOTTLENECKS_REPORT = eINSTANCE.getBottlenecksReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTLENECKS_REPORT__NETWORK = eINSTANCE.getBottlenecksReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTLENECKS_REPORT__ACTIONS_DATA = eINSTANCE.getBottlenecksReport_ActionsData();

		/**
		 * The meta object literal for the '<em><b>Cp Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__CP_WEIGHT = eINSTANCE.getBottlenecksReport_CpWeight();

		/**
		 * The meta object literal for the '<em><b>Cp Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__CP_VARIANCE = eINSTANCE.getBottlenecksReport_CpVariance();

		/**
		 * The meta object literal for the '<em><b>Total Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__TOTAL_WEIGHT = eINSTANCE.getBottlenecksReport_TotalWeight();

		/**
		 * The meta object literal for the '<em><b>Total Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__TOTAL_VARIANCE = eINSTANCE.getBottlenecksReport_TotalVariance();

		/**
		 * The meta object literal for the '<em><b>Cp Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__CP_FIRINGS = eINSTANCE.getBottlenecksReport_CpFirings();

		/**
		 * The meta object literal for the '<em><b>Total Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_REPORT__TOTAL_FIRINGS = eINSTANCE.getBottlenecksReport_TotalFirings();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl <em>Action Bottlenecks Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ActionBottlenecksDataImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getActionBottlenecksData()
		 * @generated
		 */
		EClass ACTION_BOTTLENECKS_DATA = eINSTANCE.getActionBottlenecksData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BOTTLENECKS_DATA__ACTION = eINSTANCE.getActionBottlenecksData_Action();

		/**
		 * The meta object literal for the '<em><b>Cp Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__CP_WEIGHT = eINSTANCE.getActionBottlenecksData_CpWeight();

		/**
		 * The meta object literal for the '<em><b>Cp Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__CP_VARIANCE = eINSTANCE.getActionBottlenecksData_CpVariance();

		/**
		 * The meta object literal for the '<em><b>Total Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT = eINSTANCE.getActionBottlenecksData_TotalWeight();

		/**
		 * The meta object literal for the '<em><b>Total Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE = eINSTANCE.getActionBottlenecksData_TotalVariance();

		/**
		 * The meta object literal for the '<em><b>Cp Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__CP_FIRINGS = eINSTANCE.getActionBottlenecksData_CpFirings();

		/**
		 * The meta object literal for the '<em><b>Total Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS = eINSTANCE.getActionBottlenecksData_TotalFirings();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl <em>Impact Analysis Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getImpactAnalysisReport()
		 * @generated
		 */
		EClass IMPACT_ANALYSIS_REPORT = eINSTANCE.getImpactAnalysisReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__NETWORK = eINSTANCE.getImpactAnalysisReport_Network();

		/**
		 * The meta object literal for the '<em><b>Class Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT_ANALYSIS_REPORT__CLASS_LEVEL = eINSTANCE.getImpactAnalysisReport_ClassLevel();

		/**
		 * The meta object literal for the '<em><b>Impact Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__IMPACT_DATA = eINSTANCE.getImpactAnalysisReport_ImpactData();

		/**
		 * The meta object literal for the '<em><b>Initial Bottlenecks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS = eINSTANCE.getImpactAnalysisReport_InitialBottlenecks();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisDataImpl <em>Impact Analysis Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ImpactAnalysisDataImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getImpactAnalysisData()
		 * @generated
		 */
		EClass IMPACT_ANALYSIS_DATA = eINSTANCE.getImpactAnalysisData();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_DATA__ACTIONS = eINSTANCE.getImpactAnalysisData_Actions();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_DATA__ACTOR_CLASS = eINSTANCE.getImpactAnalysisData_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Cp Reduction Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP = eINSTANCE.getImpactAnalysisData_CpReductionMap();

		/**
		 * The meta object literal for the '<em><b>Reports Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_DATA__REPORTS_MAP = eINSTANCE.getImpactAnalysisData_ReportsMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksReportMapImpl <em>Double To Bottlenecks Report Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksReportMapImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getDoubleToBottlenecksReportMap()
		 * @generated
		 */
		EClass DOUBLE_TO_BOTTLENECKS_REPORT_MAP = eINSTANCE.getDoubleToBottlenecksReportMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TO_BOTTLENECKS_REPORT_MAP__KEY = eINSTANCE.getDoubleToBottlenecksReportMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_TO_BOTTLENECKS_REPORT_MAP__VALUE = eINSTANCE.getDoubleToBottlenecksReportMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl <em>With Scheduling Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksWithSchedulingReportImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getBottlenecksWithSchedulingReport()
		 * @generated
		 */
		EClass BOTTLENECKS_WITH_SCHEDULING_REPORT = eINSTANCE.getBottlenecksWithSchedulingReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK = eINSTANCE.getBottlenecksWithSchedulingReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA = eINSTANCE.getBottlenecksWithSchedulingReport_ActionsData();

		/**
		 * The meta object literal for the '<em><b>Cp Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_WEIGHT = eINSTANCE.getBottlenecksWithSchedulingReport_CpWeight();

		/**
		 * The meta object literal for the '<em><b>Total Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_WEIGHT = eINSTANCE.getBottlenecksWithSchedulingReport_TotalWeight();

		/**
		 * The meta object literal for the '<em><b>Cp Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_FIRINGS = eINSTANCE.getBottlenecksWithSchedulingReport_CpFirings();

		/**
		 * The meta object literal for the '<em><b>Total Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_FIRINGS = eINSTANCE.getBottlenecksWithSchedulingReport_TotalFirings();

		/**
		 * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME = eINSTANCE.getBottlenecksWithSchedulingReport_ExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Cp Blocking Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_BLOCKING_TIME = eINSTANCE.getBottlenecksWithSchedulingReport_CpBlockingTime();

		/**
		 * The meta object literal for the '<em><b>Cp Partitions Blocking Time</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME = eINSTANCE.getBottlenecksWithSchedulingReport_CpPartitionsBlockingTime();

		/**
		 * The meta object literal for the '<em><b>Deadlock</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOTTLENECKS_WITH_SCHEDULING_REPORT__DEADLOCK = eINSTANCE.getBottlenecksWithSchedulingReport_Deadlock();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl <em>Action Bottlenecks With Scheduling Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ActionBottlenecksWithSchedulingDataImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getActionBottlenecksWithSchedulingData()
		 * @generated
		 */
		EClass ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA = eINSTANCE.getActionBottlenecksWithSchedulingData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION = eINSTANCE.getActionBottlenecksWithSchedulingData_Action();

		/**
		 * The meta object literal for the '<em><b>Cp Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT = eINSTANCE.getActionBottlenecksWithSchedulingData_CpWeight();

		/**
		 * The meta object literal for the '<em><b>Total Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT = eINSTANCE.getActionBottlenecksWithSchedulingData_TotalWeight();

		/**
		 * The meta object literal for the '<em><b>Cp Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS = eINSTANCE.getActionBottlenecksWithSchedulingData_CpFirings();

		/**
		 * The meta object literal for the '<em><b>Total Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS = eINSTANCE.getActionBottlenecksWithSchedulingData_TotalFirings();

		/**
		 * The meta object literal for the '<em><b>Max Blocked Output Tokens</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS = eINSTANCE.getActionBottlenecksWithSchedulingData_MaxBlockedOutputTokens();

		/**
		 * The meta object literal for the '<em><b>Max Blocked Multiplication</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION = eINSTANCE.getActionBottlenecksWithSchedulingData_MaxBlockedMultiplication();

		/**
		 * The meta object literal for the '<em><b>Blocking Instances</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES = eINSTANCE.getActionBottlenecksWithSchedulingData_BlockingInstances();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl <em>Scheduled Impact Analysis Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisDataImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getScheduledImpactAnalysisData()
		 * @generated
		 */
		EClass SCHEDULED_IMPACT_ANALYSIS_DATA = eINSTANCE.getScheduledImpactAnalysisData();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS = eINSTANCE.getScheduledImpactAnalysisData_Actions();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_DATA__ACTOR_CLASS = eINSTANCE.getScheduledImpactAnalysisData_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Cp Reduction Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP = eINSTANCE.getScheduledImpactAnalysisData_CpReductionMap();

		/**
		 * The meta object literal for the '<em><b>Time Reduction Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP = eINSTANCE.getScheduledImpactAnalysisData_TimeReductionMap();

		/**
		 * The meta object literal for the '<em><b>Reports Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP = eINSTANCE.getScheduledImpactAnalysisData_ReportsMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksWithSchedulingReportMapImpl <em>Double To Bottlenecks With Scheduling Report Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.DoubleToBottlenecksWithSchedulingReportMapImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getDoubleToBottlenecksWithSchedulingReportMap()
		 * @generated
		 */
		EClass DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP = eINSTANCE.getDoubleToBottlenecksWithSchedulingReportMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__KEY = eINSTANCE.getDoubleToBottlenecksWithSchedulingReportMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__VALUE = eINSTANCE.getDoubleToBottlenecksWithSchedulingReportMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisReportImpl <em>Scheduled Impact Analysis Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.bottlenecks.impl.ScheduledImpactAnalysisReportImpl
		 * @see turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl#getScheduledImpactAnalysisReport()
		 * @generated
		 */
		EClass SCHEDULED_IMPACT_ANALYSIS_REPORT = eINSTANCE.getScheduledImpactAnalysisReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_REPORT__NETWORK = eINSTANCE.getScheduledImpactAnalysisReport_Network();

		/**
		 * The meta object literal for the '<em><b>Class Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULED_IMPACT_ANALYSIS_REPORT__CLASS_LEVEL = eINSTANCE.getScheduledImpactAnalysisReport_ClassLevel();

		/**
		 * The meta object literal for the '<em><b>Scheduled Impact Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_REPORT__SCHEDULED_IMPACT_DATA = eINSTANCE.getScheduledImpactAnalysisReport_ScheduledImpactData();

		/**
		 * The meta object literal for the '<em><b>Initial Bottlenecks With Scheduling</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS_WITH_SCHEDULING = eINSTANCE.getScheduledImpactAnalysisReport_InitialBottlenecksWithScheduling();

		/**
		 * The meta object literal for the '<em><b>Slack Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__SLACK_MIN = eINSTANCE.getActionBottlenecksData_SlackMin();

		/**
		 * The meta object literal for the '<em><b>Slack Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_BOTTLENECKS_DATA__SLACK_MAX = eINSTANCE.getActionBottlenecksData_SlackMax();

	}

} //BottlenecksPackage

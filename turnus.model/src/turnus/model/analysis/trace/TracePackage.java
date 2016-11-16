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
package turnus.model.analysis.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see turnus.model.analysis.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = turnus.model.analysis.trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl <em>Size Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.TraceSizeReportImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getTraceSizeReport()
	 * @generated
	 */
	int TRACE_SIZE_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Actions Firings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTIONS_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Incomings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTIONS_INCOMINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions Outgoings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actors Firings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTORS_FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actors Incoming</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTORS_INCOMING = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Actors Outgoings</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__ACTORS_OUTGOINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__FIRINGS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__DEPENDENCIES = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Dependencies Kinds</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__DEPENDENCIES_KINDS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Size Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Size Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SIZE_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl <em>Compressed Trace Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedTraceReportImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedTraceReport()
	 * @generated
	 */
	int COMPRESSED_TRACE_REPORT = 1;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__STEPS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__DEPENDENCIES = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT__TRACE_FILE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Compressed Trace Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Steps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT___GET_STEPS__ACTION = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Steps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT___GET_STEPS__ACTOR = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compressed Trace Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TRACE_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedStepImpl <em>Compressed Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedStepImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedStep()
	 * @generated
	 */
	int COMPRESSED_STEP = 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__COUNT = 1;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__INCOMINGS = 2;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__OUTGOINGS = 3;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__PREDECESSORS = 4;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__SUCCESSORS = 5;

	/**
	 * The feature id for the '<em><b>Neighbors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP__NEIGHBORS = 6;

	/**
	 * The number of structural features of the '<em>Compressed Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Compressed Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedDependencyImpl <em>Compressed Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedDependency()
	 * @generated
	 */
	int COMPRESSED_DEPENDENCY = 3;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_DEPENDENCY__COUNT = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_DEPENDENCY__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_DEPENDENCY__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Compressed Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_DEPENDENCY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Compressed Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedFsmDependencyImpl <em>Compressed Fsm Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedFsmDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedFsmDependency()
	 * @generated
	 */
	int COMPRESSED_FSM_DEPENDENCY = 4;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_FSM_DEPENDENCY__COUNT = COMPRESSED_DEPENDENCY__COUNT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_FSM_DEPENDENCY__SOURCE = COMPRESSED_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_FSM_DEPENDENCY__TARGET = COMPRESSED_DEPENDENCY__TARGET;

	/**
	 * The number of structural features of the '<em>Compressed Fsm Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_FSM_DEPENDENCY_FEATURE_COUNT = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compressed Fsm Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_FSM_DEPENDENCY_OPERATION_COUNT = COMPRESSED_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl <em>Compressed Guard Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedGuardDependency()
	 * @generated
	 */
	int COMPRESSED_GUARD_DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY__COUNT = COMPRESSED_DEPENDENCY__COUNT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY__SOURCE = COMPRESSED_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY__TARGET = COMPRESSED_DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Enable Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Disable Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compressed Guard Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY_FEATURE_COUNT = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Compressed Guard Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_GUARD_DEPENDENCY_OPERATION_COUNT = COMPRESSED_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl <em>Compressed Variable Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedVariableDependency()
	 * @generated
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY = 6;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__COUNT = COMPRESSED_DEPENDENCY__COUNT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__SOURCE = COMPRESSED_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__TARGET = COMPRESSED_DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Read Read Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Read Write Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Write Read Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Write Write Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Compressed Variable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY_FEATURE_COUNT = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Compressed Variable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_VARIABLE_DEPENDENCY_OPERATION_COUNT = COMPRESSED_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedPortDependencyImpl <em>Compressed Port Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedPortDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedPortDependency()
	 * @generated
	 */
	int COMPRESSED_PORT_DEPENDENCY = 7;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY__COUNT = COMPRESSED_DEPENDENCY__COUNT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY__SOURCE = COMPRESSED_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY__TARGET = COMPRESSED_DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Read Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY__READ_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Write Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY__WRITE_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compressed Port Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY_FEATURE_COUNT = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Compressed Port Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_PORT_DEPENDENCY_OPERATION_COUNT = COMPRESSED_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl <em>Compressed Tokens Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedTokensDependency()
	 * @generated
	 */
	int COMPRESSED_TOKENS_DEPENDENCY = 8;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY__COUNT = COMPRESSED_DEPENDENCY__COUNT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY__SOURCE = COMPRESSED_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY__TARGET = COMPRESSED_DEPENDENCY__TARGET;

	/**
	 * The feature id for the '<em><b>Count Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tokens Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compressed Tokens Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY_FEATURE_COUNT = COMPRESSED_DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Compressed Tokens Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPRESSED_TOKENS_DEPENDENCY_OPERATION_COUNT = COMPRESSED_DEPENDENCY_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl <em>Comparator Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.TraceComparatorReportImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getTraceComparatorReport()
	 * @generated
	 */
	int TRACE_COMPARATOR_REPORT = 9;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT__REFERENCE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT__TRACES = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comparator Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comparator Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_COMPARATOR_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.ComparedTraceImpl <em>Compared Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.ComparedTraceImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getComparedTrace()
	 * @generated
	 */
	int COMPARED_TRACE = 10;

	/**
	 * The feature id for the '<em><b>Compressed Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__COMPRESSED_TRACE = 0;

	/**
	 * The feature id for the '<em><b>DSteps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__DSTEPS = 1;

	/**
	 * The feature id for the '<em><b>DDependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__DDEPENDENCIES = 2;

	/**
	 * The feature id for the '<em><b>Contained Reference Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__ACTIONS = 4;

	/**
	 * The feature id for the '<em><b>Equal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE__EQUAL = 5;

	/**
	 * The number of structural features of the '<em>Compared Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Compared Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.ComparedActionImpl <em>Compared Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.ComparedActionImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getComparedAction()
	 * @generated
	 */
	int COMPARED_ACTION = 11;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Found</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION__FOUND = 1;

	/**
	 * The feature id for the '<em><b>DSteps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION__DSTEPS = 2;

	/**
	 * The feature id for the '<em><b>DIncomings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION__DINCOMINGS = 3;

	/**
	 * The feature id for the '<em><b>DOutgoings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION__DOUTGOINGS = 4;

	/**
	 * The number of structural features of the '<em>Compared Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Compared Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARED_ACTION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl <em>Markow Model Trace Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getMarkowModelTraceReport()
	 * @generated
	 */
	int MARKOW_MODEL_TRACE_REPORT = 12;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Markow Model Trace Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTOR = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTION = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Markow Model Trace Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOW_MODEL_TRACE_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl <em>Markov Model Action Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.trace.impl.MarkovModelActionDataImpl
	 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getMarkovModelActionData()
	 * @generated
	 */
	int MARKOV_MODEL_ACTION_DATA = 13;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA__ACTION = 0;

	/**
	 * The feature id for the '<em><b>First</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA__FIRST = 1;

	/**
	 * The feature id for the '<em><b>Successors Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP = 2;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA__SUCCESSORS = 3;

	/**
	 * The number of structural features of the '<em>Markov Model Action Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Markov Model Action Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_MODEL_ACTION_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.TraceSizeReport <em>Size Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Size Report</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport
	 * @generated
	 */
	EClass getTraceSizeReport();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActionsFirings <em>Actions Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actions Firings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActionsFirings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActionsFirings();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActionsIncomings <em>Actions Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actions Incomings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActionsIncomings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActionsIncomings();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActionsOutgoings <em>Actions Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actions Outgoings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActionsOutgoings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActionsOutgoings();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActorsFirings <em>Actors Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actors Firings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActorsFirings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActorsFirings();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActorsIncoming <em>Actors Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actors Incoming</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActorsIncoming()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActorsIncoming();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getActorsOutgoings <em>Actors Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Actors Outgoings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getActorsOutgoings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_ActorsOutgoings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.TraceSizeReport#getFirings <em>Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firings</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getFirings()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EAttribute getTraceSizeReport_Firings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.TraceSizeReport#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependencies</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getDependencies()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EAttribute getTraceSizeReport_Dependencies();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.TraceSizeReport#getDependenciesKinds <em>Dependencies Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Dependencies Kinds</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getDependenciesKinds()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_DependenciesKinds();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.TraceSizeReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.trace.TraceSizeReport#getNetwork()
	 * @see #getTraceSizeReport()
	 * @generated
	 */
	EReference getTraceSizeReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedTraceReport <em>Compressed Trace Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Trace Report</em>'.
	 * @see turnus.model.analysis.trace.CompressedTraceReport
	 * @generated
	 */
	EClass getCompressedTraceReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.CompressedTraceReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getNetwork()
	 * @see #getCompressedTraceReport()
	 * @generated
	 */
	EReference getCompressedTraceReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.trace.CompressedTraceReport#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getSteps()
	 * @see #getCompressedTraceReport()
	 * @generated
	 */
	EReference getCompressedTraceReport_Steps();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.trace.CompressedTraceReport#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getDependencies()
	 * @see #getCompressedTraceReport()
	 * @generated
	 */
	EReference getCompressedTraceReport_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.CompressedTraceReport#getTraceFile <em>Trace File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace File</em>'.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getTraceFile()
	 * @see #getCompressedTraceReport()
	 * @generated
	 */
	EAttribute getCompressedTraceReport_TraceFile();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.trace.CompressedTraceReport#getSteps(turnus.model.dataflow.Action) <em>Get Steps</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Steps</em>' operation.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getSteps(turnus.model.dataflow.Action)
	 * @generated
	 */
	EOperation getCompressedTraceReport__GetSteps__Action();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.trace.CompressedTraceReport#getSteps(turnus.model.dataflow.Actor) <em>Get Steps</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Steps</em>' operation.
	 * @see turnus.model.analysis.trace.CompressedTraceReport#getSteps(turnus.model.dataflow.Actor)
	 * @generated
	 */
	EOperation getCompressedTraceReport__GetSteps__Actor();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedStep <em>Compressed Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Step</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep
	 * @generated
	 */
	EClass getCompressedStep();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.CompressedStep#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getAction()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Action();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.CompressedStep#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getCount()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EAttribute getCompressedStep_Count();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.CompressedStep#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getIncomings()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.CompressedStep#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getOutgoings()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Outgoings();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.CompressedStep#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predecessors</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getPredecessors()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Predecessors();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.CompressedStep#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Successors</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getSuccessors()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Successors();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.CompressedStep#getNeighbors <em>Neighbors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Neighbors</em>'.
	 * @see turnus.model.analysis.trace.CompressedStep#getNeighbors()
	 * @see #getCompressedStep()
	 * @generated
	 */
	EReference getCompressedStep_Neighbors();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedDependency <em>Compressed Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedDependency
	 * @generated
	 */
	EClass getCompressedDependency();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.CompressedDependency#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see turnus.model.analysis.trace.CompressedDependency#getCount()
	 * @see #getCompressedDependency()
	 * @generated
	 */
	EAttribute getCompressedDependency_Count();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.CompressedDependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see turnus.model.analysis.trace.CompressedDependency#getSource()
	 * @see #getCompressedDependency()
	 * @generated
	 */
	EReference getCompressedDependency_Source();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.CompressedDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see turnus.model.analysis.trace.CompressedDependency#getTarget()
	 * @see #getCompressedDependency()
	 * @generated
	 */
	EReference getCompressedDependency_Target();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedFsmDependency <em>Compressed Fsm Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Fsm Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedFsmDependency
	 * @generated
	 */
	EClass getCompressedFsmDependency();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedGuardDependency <em>Compressed Guard Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Guard Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedGuardDependency
	 * @generated
	 */
	EClass getCompressedGuardDependency();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedGuardDependency#getEnableMap <em>Enable Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Enable Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedGuardDependency#getEnableMap()
	 * @see #getCompressedGuardDependency()
	 * @generated
	 */
	EReference getCompressedGuardDependency_EnableMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedGuardDependency#getDisableMap <em>Disable Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Disable Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedGuardDependency#getDisableMap()
	 * @see #getCompressedGuardDependency()
	 * @generated
	 */
	EReference getCompressedGuardDependency_DisableMap();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedVariableDependency <em>Compressed Variable Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Variable Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedVariableDependency
	 * @generated
	 */
	EClass getCompressedVariableDependency();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedVariableDependency#getReadReadMap <em>Read Read Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Read Read Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedVariableDependency#getReadReadMap()
	 * @see #getCompressedVariableDependency()
	 * @generated
	 */
	EReference getCompressedVariableDependency_ReadReadMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedVariableDependency#getReadWriteMap <em>Read Write Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Read Write Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedVariableDependency#getReadWriteMap()
	 * @see #getCompressedVariableDependency()
	 * @generated
	 */
	EReference getCompressedVariableDependency_ReadWriteMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedVariableDependency#getWriteReadMap <em>Write Read Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Write Read Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedVariableDependency#getWriteReadMap()
	 * @see #getCompressedVariableDependency()
	 * @generated
	 */
	EReference getCompressedVariableDependency_WriteReadMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedVariableDependency#getWriteWriteMap <em>Write Write Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Write Write Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedVariableDependency#getWriteWriteMap()
	 * @see #getCompressedVariableDependency()
	 * @generated
	 */
	EReference getCompressedVariableDependency_WriteWriteMap();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedPortDependency <em>Compressed Port Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Port Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedPortDependency
	 * @generated
	 */
	EClass getCompressedPortDependency();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedPortDependency#getReadMap <em>Read Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Read Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedPortDependency#getReadMap()
	 * @see #getCompressedPortDependency()
	 * @generated
	 */
	EReference getCompressedPortDependency_ReadMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedPortDependency#getWriteMap <em>Write Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Write Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedPortDependency#getWriteMap()
	 * @see #getCompressedPortDependency()
	 * @generated
	 */
	EReference getCompressedPortDependency_WriteMap();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.CompressedTokensDependency <em>Compressed Tokens Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compressed Tokens Dependency</em>'.
	 * @see turnus.model.analysis.trace.CompressedTokensDependency
	 * @generated
	 */
	EClass getCompressedTokensDependency();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedTokensDependency#getCountMap <em>Count Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Count Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedTokensDependency#getCountMap()
	 * @see #getCompressedTokensDependency()
	 * @generated
	 */
	EReference getCompressedTokensDependency_CountMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.CompressedTokensDependency#getTokensMap <em>Tokens Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Tokens Map</em>'.
	 * @see turnus.model.analysis.trace.CompressedTokensDependency#getTokensMap()
	 * @see #getCompressedTokensDependency()
	 * @generated
	 */
	EReference getCompressedTokensDependency_TokensMap();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.TraceComparatorReport <em>Comparator Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparator Report</em>'.
	 * @see turnus.model.analysis.trace.TraceComparatorReport
	 * @generated
	 */
	EClass getTraceComparatorReport();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.trace.TraceComparatorReport#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see turnus.model.analysis.trace.TraceComparatorReport#getReference()
	 * @see #getTraceComparatorReport()
	 * @generated
	 */
	EReference getTraceComparatorReport_Reference();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.trace.TraceComparatorReport#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see turnus.model.analysis.trace.TraceComparatorReport#getTraces()
	 * @see #getTraceComparatorReport()
	 * @generated
	 */
	EReference getTraceComparatorReport_Traces();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.ComparedTrace <em>Compared Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compared Trace</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace
	 * @generated
	 */
	EClass getComparedTrace();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.trace.ComparedTrace#getCompressedTrace <em>Compressed Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compressed Trace</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#getCompressedTrace()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EReference getComparedTrace_CompressedTrace();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedTrace#getDSteps <em>DSteps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DSteps</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#getDSteps()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EAttribute getComparedTrace_DSteps();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedTrace#getDDependencies <em>DDependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DDependencies</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#getDDependencies()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EAttribute getComparedTrace_DDependencies();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.trace.ComparedTrace#getContainedReferenceActions <em>Contained Reference Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contained Reference Actions</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#getContainedReferenceActions()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EReference getComparedTrace_ContainedReferenceActions();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.trace.ComparedTrace#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#getActions()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EReference getComparedTrace_Actions();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedTrace#isEqual <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Equal</em>'.
	 * @see turnus.model.analysis.trace.ComparedTrace#isEqual()
	 * @see #getComparedTrace()
	 * @generated
	 */
	EAttribute getComparedTrace_Equal();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.ComparedAction <em>Compared Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compared Action</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction
	 * @generated
	 */
	EClass getComparedAction();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.ComparedAction#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction#getAction()
	 * @see #getComparedAction()
	 * @generated
	 */
	EReference getComparedAction_Action();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedAction#isFound <em>Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Found</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction#isFound()
	 * @see #getComparedAction()
	 * @generated
	 */
	EAttribute getComparedAction_Found();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedAction#getDSteps <em>DSteps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DSteps</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction#getDSteps()
	 * @see #getComparedAction()
	 * @generated
	 */
	EAttribute getComparedAction_DSteps();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedAction#getDIncomings <em>DIncomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DIncomings</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction#getDIncomings()
	 * @see #getComparedAction()
	 * @generated
	 */
	EAttribute getComparedAction_DIncomings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.ComparedAction#getDOutgoings <em>DOutgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DOutgoings</em>'.
	 * @see turnus.model.analysis.trace.ComparedAction#getDOutgoings()
	 * @see #getComparedAction()
	 * @generated
	 */
	EAttribute getComparedAction_DOutgoings();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.MarkowModelTraceReport <em>Markow Model Trace Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markow Model Trace Report</em>'.
	 * @see turnus.model.analysis.trace.MarkowModelTraceReport
	 * @generated
	 */
	EClass getMarkowModelTraceReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.MarkowModelTraceReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.trace.MarkowModelTraceReport#getNetwork()
	 * @see #getMarkowModelTraceReport()
	 * @generated
	 */
	EReference getMarkowModelTraceReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.trace.MarkowModelTraceReport#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.trace.MarkowModelTraceReport#getActionsData()
	 * @see #getMarkowModelTraceReport()
	 * @generated
	 */
	EReference getMarkowModelTraceReport_ActionsData();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.trace.MarkowModelTraceReport#getData(turnus.model.dataflow.Actor) <em>Get Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data</em>' operation.
	 * @see turnus.model.analysis.trace.MarkowModelTraceReport#getData(turnus.model.dataflow.Actor)
	 * @generated
	 */
	EOperation getMarkowModelTraceReport__GetData__Actor();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.trace.MarkowModelTraceReport#getData(turnus.model.dataflow.Action) <em>Get Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Data</em>' operation.
	 * @see turnus.model.analysis.trace.MarkowModelTraceReport#getData(turnus.model.dataflow.Action)
	 * @generated
	 */
	EOperation getMarkowModelTraceReport__GetData__Action();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.trace.MarkovModelActionData <em>Markov Model Action Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markov Model Action Data</em>'.
	 * @see turnus.model.analysis.trace.MarkovModelActionData
	 * @generated
	 */
	EClass getMarkovModelActionData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.trace.MarkovModelActionData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.trace.MarkovModelActionData#getAction()
	 * @see #getMarkovModelActionData()
	 * @generated
	 */
	EReference getMarkovModelActionData_Action();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.MarkovModelActionData#isFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First</em>'.
	 * @see turnus.model.analysis.trace.MarkovModelActionData#isFirst()
	 * @see #getMarkovModelActionData()
	 * @generated
	 */
	EAttribute getMarkovModelActionData_First();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.trace.MarkovModelActionData#getSuccessorsMap <em>Successors Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Successors Map</em>'.
	 * @see turnus.model.analysis.trace.MarkovModelActionData#getSuccessorsMap()
	 * @see #getMarkovModelActionData()
	 * @generated
	 */
	EReference getMarkovModelActionData_SuccessorsMap();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.trace.MarkovModelActionData#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Successors</em>'.
	 * @see turnus.model.analysis.trace.MarkovModelActionData#getSuccessors()
	 * @see #getMarkovModelActionData()
	 * @generated
	 */
	EAttribute getMarkovModelActionData_Successors();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl <em>Size Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.TraceSizeReportImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getTraceSizeReport()
		 * @generated
		 */
		EClass TRACE_SIZE_REPORT = eINSTANCE.getTraceSizeReport();

		/**
		 * The meta object literal for the '<em><b>Actions Firings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTIONS_FIRINGS = eINSTANCE.getTraceSizeReport_ActionsFirings();

		/**
		 * The meta object literal for the '<em><b>Actions Incomings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTIONS_INCOMINGS = eINSTANCE.getTraceSizeReport_ActionsIncomings();

		/**
		 * The meta object literal for the '<em><b>Actions Outgoings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS = eINSTANCE.getTraceSizeReport_ActionsOutgoings();

		/**
		 * The meta object literal for the '<em><b>Actors Firings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTORS_FIRINGS = eINSTANCE.getTraceSizeReport_ActorsFirings();

		/**
		 * The meta object literal for the '<em><b>Actors Incoming</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTORS_INCOMING = eINSTANCE.getTraceSizeReport_ActorsIncoming();

		/**
		 * The meta object literal for the '<em><b>Actors Outgoings</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__ACTORS_OUTGOINGS = eINSTANCE.getTraceSizeReport_ActorsOutgoings();

		/**
		 * The meta object literal for the '<em><b>Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_SIZE_REPORT__FIRINGS = eINSTANCE.getTraceSizeReport_Firings();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_SIZE_REPORT__DEPENDENCIES = eINSTANCE.getTraceSizeReport_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependencies Kinds</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__DEPENDENCIES_KINDS = eINSTANCE.getTraceSizeReport_DependenciesKinds();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SIZE_REPORT__NETWORK = eINSTANCE.getTraceSizeReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl <em>Compressed Trace Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedTraceReportImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedTraceReport()
		 * @generated
		 */
		EClass COMPRESSED_TRACE_REPORT = eINSTANCE.getCompressedTraceReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_TRACE_REPORT__NETWORK = eINSTANCE.getCompressedTraceReport_Network();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_TRACE_REPORT__STEPS = eINSTANCE.getCompressedTraceReport_Steps();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_TRACE_REPORT__DEPENDENCIES = eINSTANCE.getCompressedTraceReport_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Trace File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPRESSED_TRACE_REPORT__TRACE_FILE = eINSTANCE.getCompressedTraceReport_TraceFile();

		/**
		 * The meta object literal for the '<em><b>Get Steps</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPRESSED_TRACE_REPORT___GET_STEPS__ACTION = eINSTANCE.getCompressedTraceReport__GetSteps__Action();

		/**
		 * The meta object literal for the '<em><b>Get Steps</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPRESSED_TRACE_REPORT___GET_STEPS__ACTOR = eINSTANCE.getCompressedTraceReport__GetSteps__Actor();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedStepImpl <em>Compressed Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedStepImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedStep()
		 * @generated
		 */
		EClass COMPRESSED_STEP = eINSTANCE.getCompressedStep();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__ACTION = eINSTANCE.getCompressedStep_Action();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPRESSED_STEP__COUNT = eINSTANCE.getCompressedStep_Count();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__INCOMINGS = eINSTANCE.getCompressedStep_Incomings();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__OUTGOINGS = eINSTANCE.getCompressedStep_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Predecessors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__PREDECESSORS = eINSTANCE.getCompressedStep_Predecessors();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__SUCCESSORS = eINSTANCE.getCompressedStep_Successors();

		/**
		 * The meta object literal for the '<em><b>Neighbors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_STEP__NEIGHBORS = eINSTANCE.getCompressedStep_Neighbors();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedDependencyImpl <em>Compressed Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedDependency()
		 * @generated
		 */
		EClass COMPRESSED_DEPENDENCY = eINSTANCE.getCompressedDependency();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPRESSED_DEPENDENCY__COUNT = eINSTANCE.getCompressedDependency_Count();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_DEPENDENCY__SOURCE = eINSTANCE.getCompressedDependency_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_DEPENDENCY__TARGET = eINSTANCE.getCompressedDependency_Target();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedFsmDependencyImpl <em>Compressed Fsm Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedFsmDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedFsmDependency()
		 * @generated
		 */
		EClass COMPRESSED_FSM_DEPENDENCY = eINSTANCE.getCompressedFsmDependency();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl <em>Compressed Guard Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedGuardDependency()
		 * @generated
		 */
		EClass COMPRESSED_GUARD_DEPENDENCY = eINSTANCE.getCompressedGuardDependency();

		/**
		 * The meta object literal for the '<em><b>Enable Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP = eINSTANCE.getCompressedGuardDependency_EnableMap();

		/**
		 * The meta object literal for the '<em><b>Disable Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP = eINSTANCE.getCompressedGuardDependency_DisableMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl <em>Compressed Variable Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedVariableDependency()
		 * @generated
		 */
		EClass COMPRESSED_VARIABLE_DEPENDENCY = eINSTANCE.getCompressedVariableDependency();

		/**
		 * The meta object literal for the '<em><b>Read Read Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP = eINSTANCE.getCompressedVariableDependency_ReadReadMap();

		/**
		 * The meta object literal for the '<em><b>Read Write Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP = eINSTANCE.getCompressedVariableDependency_ReadWriteMap();

		/**
		 * The meta object literal for the '<em><b>Write Read Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP = eINSTANCE.getCompressedVariableDependency_WriteReadMap();

		/**
		 * The meta object literal for the '<em><b>Write Write Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP = eINSTANCE.getCompressedVariableDependency_WriteWriteMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedPortDependencyImpl <em>Compressed Port Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedPortDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedPortDependency()
		 * @generated
		 */
		EClass COMPRESSED_PORT_DEPENDENCY = eINSTANCE.getCompressedPortDependency();

		/**
		 * The meta object literal for the '<em><b>Read Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_PORT_DEPENDENCY__READ_MAP = eINSTANCE.getCompressedPortDependency_ReadMap();

		/**
		 * The meta object literal for the '<em><b>Write Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_PORT_DEPENDENCY__WRITE_MAP = eINSTANCE.getCompressedPortDependency_WriteMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl <em>Compressed Tokens Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getCompressedTokensDependency()
		 * @generated
		 */
		EClass COMPRESSED_TOKENS_DEPENDENCY = eINSTANCE.getCompressedTokensDependency();

		/**
		 * The meta object literal for the '<em><b>Count Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP = eINSTANCE.getCompressedTokensDependency_CountMap();

		/**
		 * The meta object literal for the '<em><b>Tokens Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP = eINSTANCE.getCompressedTokensDependency_TokensMap();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl <em>Comparator Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.TraceComparatorReportImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getTraceComparatorReport()
		 * @generated
		 */
		EClass TRACE_COMPARATOR_REPORT = eINSTANCE.getTraceComparatorReport();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_COMPARATOR_REPORT__REFERENCE = eINSTANCE.getTraceComparatorReport_Reference();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_COMPARATOR_REPORT__TRACES = eINSTANCE.getTraceComparatorReport_Traces();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.ComparedTraceImpl <em>Compared Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.ComparedTraceImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getComparedTrace()
		 * @generated
		 */
		EClass COMPARED_TRACE = eINSTANCE.getComparedTrace();

		/**
		 * The meta object literal for the '<em><b>Compressed Trace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARED_TRACE__COMPRESSED_TRACE = eINSTANCE.getComparedTrace_CompressedTrace();

		/**
		 * The meta object literal for the '<em><b>DSteps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_TRACE__DSTEPS = eINSTANCE.getComparedTrace_DSteps();

		/**
		 * The meta object literal for the '<em><b>DDependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_TRACE__DDEPENDENCIES = eINSTANCE.getComparedTrace_DDependencies();

		/**
		 * The meta object literal for the '<em><b>Contained Reference Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS = eINSTANCE.getComparedTrace_ContainedReferenceActions();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARED_TRACE__ACTIONS = eINSTANCE.getComparedTrace_Actions();

		/**
		 * The meta object literal for the '<em><b>Equal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_TRACE__EQUAL = eINSTANCE.getComparedTrace_Equal();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.ComparedActionImpl <em>Compared Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.ComparedActionImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getComparedAction()
		 * @generated
		 */
		EClass COMPARED_ACTION = eINSTANCE.getComparedAction();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARED_ACTION__ACTION = eINSTANCE.getComparedAction_Action();

		/**
		 * The meta object literal for the '<em><b>Found</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_ACTION__FOUND = eINSTANCE.getComparedAction_Found();

		/**
		 * The meta object literal for the '<em><b>DSteps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_ACTION__DSTEPS = eINSTANCE.getComparedAction_DSteps();

		/**
		 * The meta object literal for the '<em><b>DIncomings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_ACTION__DINCOMINGS = eINSTANCE.getComparedAction_DIncomings();

		/**
		 * The meta object literal for the '<em><b>DOutgoings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARED_ACTION__DOUTGOINGS = eINSTANCE.getComparedAction_DOutgoings();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl <em>Markow Model Trace Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getMarkowModelTraceReport()
		 * @generated
		 */
		EClass MARKOW_MODEL_TRACE_REPORT = eINSTANCE.getMarkowModelTraceReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOW_MODEL_TRACE_REPORT__NETWORK = eINSTANCE.getMarkowModelTraceReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA = eINSTANCE.getMarkowModelTraceReport_ActionsData();

		/**
		 * The meta object literal for the '<em><b>Get Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTOR = eINSTANCE.getMarkowModelTraceReport__GetData__Actor();

		/**
		 * The meta object literal for the '<em><b>Get Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTION = eINSTANCE.getMarkowModelTraceReport__GetData__Action();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.trace.impl.MarkovModelActionDataImpl <em>Markov Model Action Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.trace.impl.MarkovModelActionDataImpl
		 * @see turnus.model.analysis.trace.impl.TracePackageImpl#getMarkovModelActionData()
		 * @generated
		 */
		EClass MARKOV_MODEL_ACTION_DATA = eINSTANCE.getMarkovModelActionData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_MODEL_ACTION_DATA__ACTION = eINSTANCE.getMarkovModelActionData_Action();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_MODEL_ACTION_DATA__FIRST = eINSTANCE.getMarkovModelActionData_First();

		/**
		 * The meta object literal for the '<em><b>Successors Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP = eINSTANCE.getMarkovModelActionData_SuccessorsMap();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_MODEL_ACTION_DATA__SUCCESSORS = eINSTANCE.getMarkovModelActionData_Successors();

	}

} //TracePackage

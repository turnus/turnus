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
package turnus.model.analysis.profiler;

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
 * @see turnus.model.analysis.profiler.ProfilerFactory
 * @model kind="package"
 * @generated
 */
public interface ProfilerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profiler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/profiler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.profiler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfilerPackage eINSTANCE = turnus.model.analysis.profiler.impl.ProfilerPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.CodeProfilingReportImpl <em>Code Profiling Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.CodeProfilingReportImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getCodeProfilingReport()
	 * @generated
	 */
	int CODE_PROFILING_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actor Classes Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT__ACTOR_CLASSES_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Network Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT__NETWORK_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Code Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Actor Class Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT___GET_ACTOR_CLASS_DATA__STRING = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Code Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_PROFILING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.CodeDataImpl <em>Code Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.CodeDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getCodeData()
	 * @generated
	 */
	int CODE_DATA = 1;

	/**
	 * The feature id for the '<em><b>Operators Count</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA__OPERATORS_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Operands Count</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA__OPERANDS_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Block Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA__BLOCK_NAME = 2;

	/**
	 * The feature id for the '<em><b>Nol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA__NOL = 3;

	/**
	 * The number of structural features of the '<em>Code Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Code Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ComplexCodeDataImpl <em>Complex Code Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ComplexCodeDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getComplexCodeData()
	 * @generated
	 */
	int COMPLEX_CODE_DATA = 2;

	/**
	 * The feature id for the '<em><b>Operators Count</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__OPERATORS_COUNT = CODE_DATA__OPERATORS_COUNT;

	/**
	 * The feature id for the '<em><b>Operands Count</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__OPERANDS_COUNT = CODE_DATA__OPERANDS_COUNT;

	/**
	 * The feature id for the '<em><b>Block Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__BLOCK_NAME = CODE_DATA__BLOCK_NAME;

	/**
	 * The feature id for the '<em><b>Nol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__NOL = CODE_DATA__NOL;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__ACTIONS_DATA = CODE_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Procedures Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA__PROCEDURES_DATA = CODE_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complex Code Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA_FEATURE_COUNT = CODE_DATA_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Action Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA___GET_ACTION_DATA__STRING = CODE_DATA_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Procedure Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA___GET_PROCEDURE_DATA__STRING = CODE_DATA_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Code Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_CODE_DATA_OPERATION_COUNT = CODE_DATA_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl <em>Dynamic Profiling Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getDynamicProfilingReport()
	 * @generated
	 */
	int DYNAMIC_PROFILING_REPORT = 3;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actors Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT__ACTORS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Buffers Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT__BUFFERS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dynamic Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dynamic Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PROFILING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl <em>Complex Dynamic Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getComplexDynamicData()
	 * @generated
	 */
	int COMPLEX_DYNAMIC_DATA = 7;

	/**
	 * The feature id for the '<em><b>Operands Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS = 0;

	/**
	 * The feature id for the '<em><b>Procedures Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS = 1;

	/**
	 * The feature id for the '<em><b>Variables Stores</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__VARIABLES_STORES = 2;

	/**
	 * The feature id for the '<em><b>Variables Loads</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS = 3;

	/**
	 * The feature id for the '<em><b>Procedures Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA = 4;

	/**
	 * The feature id for the '<em><b>Read Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__READ_TOKENS = 5;

	/**
	 * The feature id for the '<em><b>Write Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA__WRITE_TOKENS = 6;

	/**
	 * The number of structural features of the '<em>Complex Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Complex Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_DYNAMIC_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ActorDynamicDataImpl <em>Actor Dynamic Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ActorDynamicDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActorDynamicData()
	 * @generated
	 */
	int ACTOR_DYNAMIC_DATA = 4;

	/**
	 * The feature id for the '<em><b>Operands Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__OPERANDS_CALLS = COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS;

	/**
	 * The feature id for the '<em><b>Procedures Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__PROCEDURES_CALLS = COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS;

	/**
	 * The feature id for the '<em><b>Variables Stores</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__VARIABLES_STORES = COMPLEX_DYNAMIC_DATA__VARIABLES_STORES;

	/**
	 * The feature id for the '<em><b>Variables Loads</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__VARIABLES_LOADS = COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS;

	/**
	 * The feature id for the '<em><b>Procedures Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__PROCEDURES_DATA = COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA;

	/**
	 * The feature id for the '<em><b>Read Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__READ_TOKENS = COMPLEX_DYNAMIC_DATA__READ_TOKENS;

	/**
	 * The feature id for the '<em><b>Write Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__WRITE_TOKENS = COMPLEX_DYNAMIC_DATA__WRITE_TOKENS;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__ACTOR = COMPLEX_DYNAMIC_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA__ACTIONS_DATA = COMPLEX_DYNAMIC_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actor Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA_FEATURE_COUNT = COMPLEX_DYNAMIC_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Actor Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_DYNAMIC_DATA_OPERATION_COUNT = COMPLEX_DYNAMIC_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ActionDynamicDataImpl <em>Action Dynamic Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ActionDynamicDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActionDynamicData()
	 * @generated
	 */
	int ACTION_DYNAMIC_DATA = 5;

	/**
	 * The feature id for the '<em><b>Operands Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__OPERANDS_CALLS = COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS;

	/**
	 * The feature id for the '<em><b>Procedures Calls</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__PROCEDURES_CALLS = COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS;

	/**
	 * The feature id for the '<em><b>Variables Stores</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__VARIABLES_STORES = COMPLEX_DYNAMIC_DATA__VARIABLES_STORES;

	/**
	 * The feature id for the '<em><b>Variables Loads</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__VARIABLES_LOADS = COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS;

	/**
	 * The feature id for the '<em><b>Procedures Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__PROCEDURES_DATA = COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA;

	/**
	 * The feature id for the '<em><b>Read Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__READ_TOKENS = COMPLEX_DYNAMIC_DATA__READ_TOKENS;

	/**
	 * The feature id for the '<em><b>Write Tokens</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__WRITE_TOKENS = COMPLEX_DYNAMIC_DATA__WRITE_TOKENS;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA__ACTION = COMPLEX_DYNAMIC_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA_FEATURE_COUNT = COMPLEX_DYNAMIC_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Action Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DYNAMIC_DATA_OPERATION_COUNT = COMPLEX_DYNAMIC_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl <em>Buffer Dynamic Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.BufferDynamicDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getBufferDynamicData()
	 * @generated
	 */
	int BUFFER_DYNAMIC_DATA = 6;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__BUFFER = 0;

	/**
	 * The feature id for the '<em><b>Reads</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__READS = 1;

	/**
	 * The feature id for the '<em><b>Writes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__WRITES = 2;

	/**
	 * The feature id for the '<em><b>Occupancy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__OCCUPANCY = 3;

	/**
	 * The feature id for the '<em><b>Action Reads</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__ACTION_READS = 4;

	/**
	 * The feature id for the '<em><b>Action Writes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__ACTION_WRITES = 5;

	/**
	 * The feature id for the '<em><b>Action Peeks</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__ACTION_PEEKS = 6;

	/**
	 * The feature id for the '<em><b>Action Read Misses</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES = 7;

	/**
	 * The feature id for the '<em><b>Action Write Misses</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES = 8;

	/**
	 * The feature id for the '<em><b>Unconsumed Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS = 9;

	/**
	 * The number of structural features of the '<em>Buffer Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Buffer Dynamic Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DYNAMIC_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ProcedureToComplexDynamicDataMapImpl <em>Procedure To Complex Dynamic Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ProcedureToComplexDynamicDataMapImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getProcedureToComplexDynamicDataMap()
	 * @generated
	 */
	int PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Procedure To Complex Dynamic Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Procedure To Complex Dynamic Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.MemoryProfilingReportImpl <em>Memory Profiling Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.MemoryProfilingReportImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getMemoryProfilingReport()
	 * @generated
	 */
	int MEMORY_PROFILING_REPORT = 9;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT__NETWORK_NAME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT__ACTIONS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Memory Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Action Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT___GET_ACTION_DATA__STRING_STRING = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Profiling Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PROFILING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl <em>Action Memory Profiling Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActionMemoryProfilingData()
	 * @generated
	 */
	int ACTION_MEMORY_PROFILING_DATA = 10;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA__ACTION = 1;

	/**
	 * The feature id for the '<em><b>Reads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA__READS = 2;

	/**
	 * The feature id for the '<em><b>Writes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA__WRITES = 3;

	/**
	 * The number of structural features of the '<em>Action Memory Profiling Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Read Buffer Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_READ_BUFFER_DATA__STRING_STRING_STRING_STRING = 0;

	/**
	 * The operation id for the '<em>Get Write Buffer Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_WRITE_BUFFER_DATA__STRING_STRING_STRING_STRING = 1;

	/**
	 * The operation id for the '<em>Get Read State Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_READ_STATE_VARIABLE_DATA__STRING = 2;

	/**
	 * The operation id for the '<em>Get Write State Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_WRITE_STATE_VARIABLE_DATA__STRING = 3;

	/**
	 * The operation id for the '<em>Get Read Local Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_READ_LOCAL_VARIABLE_DATA__STRING = 4;

	/**
	 * The operation id for the '<em>Get Write Local Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_WRITE_LOCAL_VARIABLE_DATA__STRING = 5;

	/**
	 * The operation id for the '<em>Get Read Shared Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_READ_SHARED_VARIABLE_DATA__STRING = 6;

	/**
	 * The operation id for the '<em>Get Write Shared Variable Data</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA___GET_WRITE_SHARED_VARIABLE_DATA__STRING = 7;

	/**
	 * The number of operations of the '<em>Action Memory Profiling Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_MEMORY_PROFILING_DATA_OPERATION_COUNT = 8;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.MemoryAccessDataImpl <em>Memory Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.MemoryAccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getMemoryAccessData()
	 * @generated
	 */
	int MEMORY_ACCESS_DATA = 11;

	/**
	 * The feature id for the '<em><b>Accesses Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ACCESS_DATA__ACCESSES_DATA = 0;

	/**
	 * The number of structural features of the '<em>Memory Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ACCESS_DATA_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Memory Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ACCESS_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl <em>Buffer Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.BufferAccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getBufferAccessData()
	 * @generated
	 */
	int BUFFER_ACCESS_DATA = 12;

	/**
	 * The feature id for the '<em><b>Accesses Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA__ACCESSES_DATA = MEMORY_ACCESS_DATA__ACCESSES_DATA;

	/**
	 * The feature id for the '<em><b>Source Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA__SOURCE_ACTOR = MEMORY_ACCESS_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA__SOURCE_PORT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA__TARGET_ACTOR = MEMORY_ACCESS_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA__TARGET_PORT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA_FEATURE_COUNT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_ACCESS_DATA_OPERATION_COUNT = MEMORY_ACCESS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.StateVariableAccessDataImpl <em>State Variable Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.StateVariableAccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getStateVariableAccessData()
	 * @generated
	 */
	int STATE_VARIABLE_ACCESS_DATA = 13;

	/**
	 * The feature id for the '<em><b>Accesses Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_ACCESS_DATA__ACCESSES_DATA = MEMORY_ACCESS_DATA__ACCESSES_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_ACCESS_DATA__NAME = MEMORY_ACCESS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_ACCESS_DATA_FEATURE_COUNT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>State Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_ACCESS_DATA_OPERATION_COUNT = MEMORY_ACCESS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.LocalVariableAccessDataImpl <em>Local Variable Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.LocalVariableAccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getLocalVariableAccessData()
	 * @generated
	 */
	int LOCAL_VARIABLE_ACCESS_DATA = 14;

	/**
	 * The feature id for the '<em><b>Accesses Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_ACCESS_DATA__ACCESSES_DATA = MEMORY_ACCESS_DATA__ACCESSES_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_ACCESS_DATA__NAME = MEMORY_ACCESS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_ACCESS_DATA_FEATURE_COUNT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Local Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_ACCESS_DATA_OPERATION_COUNT = MEMORY_ACCESS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.SharedVariableAccessDataImpl <em>Shared Variable Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.SharedVariableAccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getSharedVariableAccessData()
	 * @generated
	 */
	int SHARED_VARIABLE_ACCESS_DATA = 15;

	/**
	 * The feature id for the '<em><b>Accesses Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_ACCESS_DATA__ACCESSES_DATA = MEMORY_ACCESS_DATA__ACCESSES_DATA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_ACCESS_DATA__NAME = MEMORY_ACCESS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shared Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_ACCESS_DATA_FEATURE_COUNT = MEMORY_ACCESS_DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Shared Variable Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_ACCESS_DATA_OPERATION_COUNT = MEMORY_ACCESS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.AccessDataImpl <em>Access Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.AccessDataImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getAccessData()
	 * @generated
	 */
	int ACCESS_DATA = 16;

	/**
	 * The feature id for the '<em><b>Accesses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA__ACCESSES = 0;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA__MIN = 1;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA__MAX = 2;

	/**
	 * The feature id for the '<em><b>Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA__AVERAGE = 3;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA__TOTAL = 4;

	/**
	 * The number of structural features of the '<em>Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Access Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.profiler.impl.StringToAccessDataMapImpl <em>String To Access Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.profiler.impl.StringToAccessDataMapImpl
	 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getStringToAccessDataMap()
	 * @generated
	 */
	int STRING_TO_ACCESS_DATA_MAP = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ACCESS_DATA_MAP__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ACCESS_DATA_MAP__KEY = 1;

	/**
	 * The number of structural features of the '<em>String To Access Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ACCESS_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Access Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ACCESS_DATA_MAP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.CodeProfilingReport <em>Code Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Profiling Report</em>'.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport
	 * @generated
	 */
	EClass getCodeProfilingReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.CodeProfilingReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport#getNetwork()
	 * @see #getCodeProfilingReport()
	 * @generated
	 */
	EReference getCodeProfilingReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.CodeProfilingReport#getActorClassesData <em>Actor Classes Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Classes Data</em>'.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport#getActorClassesData()
	 * @see #getCodeProfilingReport()
	 * @generated
	 */
	EReference getCodeProfilingReport_ActorClassesData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.CodeProfilingReport#getNetworkData <em>Network Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network Data</em>'.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport#getNetworkData()
	 * @see #getCodeProfilingReport()
	 * @generated
	 */
	EReference getCodeProfilingReport_NetworkData();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.CodeProfilingReport#getActorClassData(java.lang.String) <em>Get Actor Class Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actor Class Data</em>' operation.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport#getActorClassData(java.lang.String)
	 * @generated
	 */
	EOperation getCodeProfilingReport__GetActorClassData__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.CodeData <em>Code Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Data</em>'.
	 * @see turnus.model.analysis.profiler.CodeData
	 * @generated
	 */
	EClass getCodeData();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.CodeData#getOperatorsCount <em>Operators Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Operators Count</em>'.
	 * @see turnus.model.analysis.profiler.CodeData#getOperatorsCount()
	 * @see #getCodeData()
	 * @generated
	 */
	EReference getCodeData_OperatorsCount();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.CodeData#getOperandsCount <em>Operands Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Operands Count</em>'.
	 * @see turnus.model.analysis.profiler.CodeData#getOperandsCount()
	 * @see #getCodeData()
	 * @generated
	 */
	EReference getCodeData_OperandsCount();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.CodeData#getBlockName <em>Block Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block Name</em>'.
	 * @see turnus.model.analysis.profiler.CodeData#getBlockName()
	 * @see #getCodeData()
	 * @generated
	 */
	EAttribute getCodeData_BlockName();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.CodeData#getNol <em>Nol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nol</em>'.
	 * @see turnus.model.analysis.profiler.CodeData#getNol()
	 * @see #getCodeData()
	 * @generated
	 */
	EAttribute getCodeData_Nol();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.ComplexCodeData <em>Complex Code Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Code Data</em>'.
	 * @see turnus.model.analysis.profiler.ComplexCodeData
	 * @generated
	 */
	EClass getComplexCodeData();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.ComplexCodeData#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.profiler.ComplexCodeData#getActionsData()
	 * @see #getComplexCodeData()
	 * @generated
	 */
	EReference getComplexCodeData_ActionsData();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.profiler.ComplexCodeData#getProceduresData <em>Procedures Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Procedures Data</em>'.
	 * @see turnus.model.analysis.profiler.ComplexCodeData#getProceduresData()
	 * @see #getComplexCodeData()
	 * @generated
	 */
	EReference getComplexCodeData_ProceduresData();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ComplexCodeData#getActionData(java.lang.String) <em>Get Action Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ComplexCodeData#getActionData(java.lang.String)
	 * @generated
	 */
	EOperation getComplexCodeData__GetActionData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ComplexCodeData#getProcedureData(java.lang.String) <em>Get Procedure Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Procedure Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ComplexCodeData#getProcedureData(java.lang.String)
	 * @generated
	 */
	EOperation getComplexCodeData__GetProcedureData__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.DynamicProfilingReport <em>Dynamic Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Profiling Report</em>'.
	 * @see turnus.model.analysis.profiler.DynamicProfilingReport
	 * @generated
	 */
	EClass getDynamicProfilingReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.DynamicProfilingReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.profiler.DynamicProfilingReport#getNetwork()
	 * @see #getDynamicProfilingReport()
	 * @generated
	 */
	EReference getDynamicProfilingReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.DynamicProfilingReport#getActorsData <em>Actors Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors Data</em>'.
	 * @see turnus.model.analysis.profiler.DynamicProfilingReport#getActorsData()
	 * @see #getDynamicProfilingReport()
	 * @generated
	 */
	EReference getDynamicProfilingReport_ActorsData();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.DynamicProfilingReport#getBuffersData <em>Buffers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers Data</em>'.
	 * @see turnus.model.analysis.profiler.DynamicProfilingReport#getBuffersData()
	 * @see #getDynamicProfilingReport()
	 * @generated
	 */
	EReference getDynamicProfilingReport_BuffersData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.ActorDynamicData <em>Actor Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Dynamic Data</em>'.
	 * @see turnus.model.analysis.profiler.ActorDynamicData
	 * @generated
	 */
	EClass getActorDynamicData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.ActorDynamicData#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see turnus.model.analysis.profiler.ActorDynamicData#getActor()
	 * @see #getActorDynamicData()
	 * @generated
	 */
	EReference getActorDynamicData_Actor();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.ActorDynamicData#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.profiler.ActorDynamicData#getActionsData()
	 * @see #getActorDynamicData()
	 * @generated
	 */
	EReference getActorDynamicData_ActionsData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.ActionDynamicData <em>Action Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Dynamic Data</em>'.
	 * @see turnus.model.analysis.profiler.ActionDynamicData
	 * @generated
	 */
	EClass getActionDynamicData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.ActionDynamicData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.profiler.ActionDynamicData#getAction()
	 * @see #getActionDynamicData()
	 * @generated
	 */
	EReference getActionDynamicData_Action();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.BufferDynamicData <em>Buffer Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Dynamic Data</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData
	 * @generated
	 */
	EClass getBufferDynamicData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.profiler.BufferDynamicData#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getBuffer()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_Buffer();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiler.BufferDynamicData#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reads</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getReads()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_Reads();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiler.BufferDynamicData#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Writes</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getWrites()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_Writes();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.profiler.BufferDynamicData#getOccupancy <em>Occupancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Occupancy</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getOccupancy()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_Occupancy();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.BufferDynamicData#getActionReads <em>Action Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Action Reads</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getActionReads()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_ActionReads();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.BufferDynamicData#getActionWrites <em>Action Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Action Writes</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getActionWrites()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_ActionWrites();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.BufferDynamicData#getActionPeeks <em>Action Peeks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Action Peeks</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getActionPeeks()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_ActionPeeks();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.BufferDynamicData#getActionReadMisses <em>Action Read Misses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Action Read Misses</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getActionReadMisses()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_ActionReadMisses();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.BufferDynamicData#getActionWriteMisses <em>Action Write Misses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Action Write Misses</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getActionWriteMisses()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EReference getBufferDynamicData_ActionWriteMisses();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.BufferDynamicData#getUnconsumedTokens <em>Unconsumed Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unconsumed Tokens</em>'.
	 * @see turnus.model.analysis.profiler.BufferDynamicData#getUnconsumedTokens()
	 * @see #getBufferDynamicData()
	 * @generated
	 */
	EAttribute getBufferDynamicData_UnconsumedTokens();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.ComplexDynamicData <em>Complex Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Dynamic Data</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData
	 * @generated
	 */
	EClass getComplexDynamicData();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getOperandsCalls <em>Operands Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Operands Calls</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getOperandsCalls()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_OperandsCalls();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getProceduresCalls <em>Procedures Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Procedures Calls</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getProceduresCalls()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_ProceduresCalls();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getVariablesStores <em>Variables Stores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variables Stores</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getVariablesStores()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_VariablesStores();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getVariablesLoads <em>Variables Loads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variables Loads</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getVariablesLoads()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_VariablesLoads();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getProceduresData <em>Procedures Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Procedures Data</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getProceduresData()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_ProceduresData();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getReadTokens <em>Read Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Read Tokens</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getReadTokens()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_ReadTokens();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.ComplexDynamicData#getWriteTokens <em>Write Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Write Tokens</em>'.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData#getWriteTokens()
	 * @see #getComplexDynamicData()
	 * @generated
	 */
	EReference getComplexDynamicData_WriteTokens();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Procedure To Complex Dynamic Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure To Complex Dynamic Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Procedure"
	 *        valueType="turnus.model.analysis.profiler.ComplexDynamicData" valueContainment="true"
	 * @generated
	 */
	EClass getProcedureToComplexDynamicDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProcedureToComplexDynamicDataMap()
	 * @generated
	 */
	EReference getProcedureToComplexDynamicDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProcedureToComplexDynamicDataMap()
	 * @generated
	 */
	EReference getProcedureToComplexDynamicDataMap_Value();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.MemoryProfilingReport <em>Memory Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Profiling Report</em>'.
	 * @see turnus.model.analysis.profiler.MemoryProfilingReport
	 * @generated
	 */
	EClass getMemoryProfilingReport();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.MemoryProfilingReport#getNetworkName <em>Network Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Network Name</em>'.
	 * @see turnus.model.analysis.profiler.MemoryProfilingReport#getNetworkName()
	 * @see #getMemoryProfilingReport()
	 * @generated
	 */
	EAttribute getMemoryProfilingReport_NetworkName();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.MemoryProfilingReport#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.profiler.MemoryProfilingReport#getActionsData()
	 * @see #getMemoryProfilingReport()
	 * @generated
	 */
	EReference getMemoryProfilingReport_ActionsData();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.MemoryProfilingReport#getActionData(java.lang.String, java.lang.String) <em>Get Action Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action Data</em>' operation.
	 * @see turnus.model.analysis.profiler.MemoryProfilingReport#getActionData(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getMemoryProfilingReport__GetActionData__String_String();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData <em>Action Memory Profiling Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Memory Profiling Data</em>'.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData
	 * @generated
	 */
	EClass getActionMemoryProfilingData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actor</em>'.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getActor()
	 * @see #getActionMemoryProfilingData()
	 * @generated
	 */
	EAttribute getActionMemoryProfilingData_Actor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getAction()
	 * @see #getActionMemoryProfilingData()
	 * @generated
	 */
	EAttribute getActionMemoryProfilingData_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reads</em>'.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getReads()
	 * @see #getActionMemoryProfilingData()
	 * @generated
	 */
	EReference getActionMemoryProfilingData_Reads();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWrites <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Writes</em>'.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getWrites()
	 * @see #getActionMemoryProfilingData()
	 * @generated
	 */
	EReference getActionMemoryProfilingData_Writes();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadBufferData(java.lang.String, java.lang.String, java.lang.String, java.lang.String) <em>Get Read Buffer Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Read Buffer Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadBufferData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetReadBufferData__String_String_String_String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteBufferData(java.lang.String, java.lang.String, java.lang.String, java.lang.String) <em>Get Write Buffer Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Write Buffer Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteBufferData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetWriteBufferData__String_String_String_String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadStateVariableData(java.lang.String) <em>Get Read State Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Read State Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadStateVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetReadStateVariableData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteStateVariableData(java.lang.String) <em>Get Write State Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Write State Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteStateVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetWriteStateVariableData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadLocalVariableData(java.lang.String) <em>Get Read Local Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Read Local Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadLocalVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetReadLocalVariableData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteLocalVariableData(java.lang.String) <em>Get Write Local Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Write Local Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteLocalVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetWriteLocalVariableData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadSharedVariableData(java.lang.String) <em>Get Read Shared Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Read Shared Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getReadSharedVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetReadSharedVariableData__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteSharedVariableData(java.lang.String) <em>Get Write Shared Variable Data</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Write Shared Variable Data</em>' operation.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData#getWriteSharedVariableData(java.lang.String)
	 * @generated
	 */
	EOperation getActionMemoryProfilingData__GetWriteSharedVariableData__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.MemoryAccessData <em>Memory Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Access Data</em>'.
	 * @see turnus.model.analysis.profiler.MemoryAccessData
	 * @generated
	 */
	EClass getMemoryAccessData();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.profiler.MemoryAccessData#getAccessesData <em>Accesses Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Accesses Data</em>'.
	 * @see turnus.model.analysis.profiler.MemoryAccessData#getAccessesData()
	 * @see #getMemoryAccessData()
	 * @generated
	 */
	EReference getMemoryAccessData_AccessesData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.BufferAccessData <em>Buffer Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Access Data</em>'.
	 * @see turnus.model.analysis.profiler.BufferAccessData
	 * @generated
	 */
	EClass getBufferAccessData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.BufferAccessData#getSourceActor <em>Source Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Actor</em>'.
	 * @see turnus.model.analysis.profiler.BufferAccessData#getSourceActor()
	 * @see #getBufferAccessData()
	 * @generated
	 */
	EAttribute getBufferAccessData_SourceActor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.BufferAccessData#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Port</em>'.
	 * @see turnus.model.analysis.profiler.BufferAccessData#getSourcePort()
	 * @see #getBufferAccessData()
	 * @generated
	 */
	EAttribute getBufferAccessData_SourcePort();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.BufferAccessData#getTargetActor <em>Target Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Actor</em>'.
	 * @see turnus.model.analysis.profiler.BufferAccessData#getTargetActor()
	 * @see #getBufferAccessData()
	 * @generated
	 */
	EAttribute getBufferAccessData_TargetActor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.BufferAccessData#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Port</em>'.
	 * @see turnus.model.analysis.profiler.BufferAccessData#getTargetPort()
	 * @see #getBufferAccessData()
	 * @generated
	 */
	EAttribute getBufferAccessData_TargetPort();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.StateVariableAccessData <em>State Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Variable Access Data</em>'.
	 * @see turnus.model.analysis.profiler.StateVariableAccessData
	 * @generated
	 */
	EClass getStateVariableAccessData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.StateVariableAccessData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.profiler.StateVariableAccessData#getName()
	 * @see #getStateVariableAccessData()
	 * @generated
	 */
	EAttribute getStateVariableAccessData_Name();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.LocalVariableAccessData <em>Local Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable Access Data</em>'.
	 * @see turnus.model.analysis.profiler.LocalVariableAccessData
	 * @generated
	 */
	EClass getLocalVariableAccessData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.LocalVariableAccessData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.profiler.LocalVariableAccessData#getName()
	 * @see #getLocalVariableAccessData()
	 * @generated
	 */
	EAttribute getLocalVariableAccessData_Name();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.SharedVariableAccessData <em>Shared Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Variable Access Data</em>'.
	 * @see turnus.model.analysis.profiler.SharedVariableAccessData
	 * @generated
	 */
	EClass getSharedVariableAccessData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.SharedVariableAccessData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.profiler.SharedVariableAccessData#getName()
	 * @see #getSharedVariableAccessData()
	 * @generated
	 */
	EAttribute getSharedVariableAccessData_Name();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.profiler.AccessData <em>Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Data</em>'.
	 * @see turnus.model.analysis.profiler.AccessData
	 * @generated
	 */
	EClass getAccessData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.AccessData#getAccesses <em>Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accesses</em>'.
	 * @see turnus.model.analysis.profiler.AccessData#getAccesses()
	 * @see #getAccessData()
	 * @generated
	 */
	EAttribute getAccessData_Accesses();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.AccessData#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see turnus.model.analysis.profiler.AccessData#getMin()
	 * @see #getAccessData()
	 * @generated
	 */
	EAttribute getAccessData_Min();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.AccessData#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see turnus.model.analysis.profiler.AccessData#getMax()
	 * @see #getAccessData()
	 * @generated
	 */
	EAttribute getAccessData_Max();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.AccessData#getAverage <em>Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average</em>'.
	 * @see turnus.model.analysis.profiler.AccessData#getAverage()
	 * @see #getAccessData()
	 * @generated
	 */
	EAttribute getAccessData_Average();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.profiler.AccessData#getTotal <em>Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total</em>'.
	 * @see turnus.model.analysis.profiler.AccessData#getTotal()
	 * @see #getAccessData()
	 * @generated
	 */
	EAttribute getAccessData_Total();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Access Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Access Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model features="value key" 
	 *        valueType="turnus.model.analysis.profiler.AccessData" valueContainment="true"
	 *        keyDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getStringToAccessDataMap();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToAccessDataMap()
	 * @generated
	 */
	EReference getStringToAccessDataMap_Value();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToAccessDataMap()
	 * @generated
	 */
	EAttribute getStringToAccessDataMap_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProfilerFactory getProfilerFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.CodeProfilingReportImpl <em>Code Profiling Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.CodeProfilingReportImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getCodeProfilingReport()
		 * @generated
		 */
		EClass CODE_PROFILING_REPORT = eINSTANCE.getCodeProfilingReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_PROFILING_REPORT__NETWORK = eINSTANCE.getCodeProfilingReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actor Classes Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_PROFILING_REPORT__ACTOR_CLASSES_DATA = eINSTANCE.getCodeProfilingReport_ActorClassesData();

		/**
		 * The meta object literal for the '<em><b>Network Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_PROFILING_REPORT__NETWORK_DATA = eINSTANCE.getCodeProfilingReport_NetworkData();

		/**
		 * The meta object literal for the '<em><b>Get Actor Class Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODE_PROFILING_REPORT___GET_ACTOR_CLASS_DATA__STRING = eINSTANCE.getCodeProfilingReport__GetActorClassData__String();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.CodeDataImpl <em>Code Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.CodeDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getCodeData()
		 * @generated
		 */
		EClass CODE_DATA = eINSTANCE.getCodeData();

		/**
		 * The meta object literal for the '<em><b>Operators Count</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_DATA__OPERATORS_COUNT = eINSTANCE.getCodeData_OperatorsCount();

		/**
		 * The meta object literal for the '<em><b>Operands Count</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_DATA__OPERANDS_COUNT = eINSTANCE.getCodeData_OperandsCount();

		/**
		 * The meta object literal for the '<em><b>Block Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_DATA__BLOCK_NAME = eINSTANCE.getCodeData_BlockName();

		/**
		 * The meta object literal for the '<em><b>Nol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_DATA__NOL = eINSTANCE.getCodeData_Nol();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ComplexCodeDataImpl <em>Complex Code Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ComplexCodeDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getComplexCodeData()
		 * @generated
		 */
		EClass COMPLEX_CODE_DATA = eINSTANCE.getComplexCodeData();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_CODE_DATA__ACTIONS_DATA = eINSTANCE.getComplexCodeData_ActionsData();

		/**
		 * The meta object literal for the '<em><b>Procedures Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_CODE_DATA__PROCEDURES_DATA = eINSTANCE.getComplexCodeData_ProceduresData();

		/**
		 * The meta object literal for the '<em><b>Get Action Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CODE_DATA___GET_ACTION_DATA__STRING = eINSTANCE.getComplexCodeData__GetActionData__String();

		/**
		 * The meta object literal for the '<em><b>Get Procedure Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPLEX_CODE_DATA___GET_PROCEDURE_DATA__STRING = eINSTANCE.getComplexCodeData__GetProcedureData__String();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl <em>Dynamic Profiling Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.DynamicProfilingReportImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getDynamicProfilingReport()
		 * @generated
		 */
		EClass DYNAMIC_PROFILING_REPORT = eINSTANCE.getDynamicProfilingReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_PROFILING_REPORT__NETWORK = eINSTANCE.getDynamicProfilingReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actors Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_PROFILING_REPORT__ACTORS_DATA = eINSTANCE.getDynamicProfilingReport_ActorsData();

		/**
		 * The meta object literal for the '<em><b>Buffers Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_PROFILING_REPORT__BUFFERS_DATA = eINSTANCE.getDynamicProfilingReport_BuffersData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ActorDynamicDataImpl <em>Actor Dynamic Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ActorDynamicDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActorDynamicData()
		 * @generated
		 */
		EClass ACTOR_DYNAMIC_DATA = eINSTANCE.getActorDynamicData();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_DYNAMIC_DATA__ACTOR = eINSTANCE.getActorDynamicData_Actor();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_DYNAMIC_DATA__ACTIONS_DATA = eINSTANCE.getActorDynamicData_ActionsData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ActionDynamicDataImpl <em>Action Dynamic Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ActionDynamicDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActionDynamicData()
		 * @generated
		 */
		EClass ACTION_DYNAMIC_DATA = eINSTANCE.getActionDynamicData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_DYNAMIC_DATA__ACTION = eINSTANCE.getActionDynamicData_Action();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl <em>Buffer Dynamic Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.BufferDynamicDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getBufferDynamicData()
		 * @generated
		 */
		EClass BUFFER_DYNAMIC_DATA = eINSTANCE.getBufferDynamicData();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__BUFFER = eINSTANCE.getBufferDynamicData_Buffer();

		/**
		 * The meta object literal for the '<em><b>Reads</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__READS = eINSTANCE.getBufferDynamicData_Reads();

		/**
		 * The meta object literal for the '<em><b>Writes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__WRITES = eINSTANCE.getBufferDynamicData_Writes();

		/**
		 * The meta object literal for the '<em><b>Occupancy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__OCCUPANCY = eINSTANCE.getBufferDynamicData_Occupancy();

		/**
		 * The meta object literal for the '<em><b>Action Reads</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__ACTION_READS = eINSTANCE.getBufferDynamicData_ActionReads();

		/**
		 * The meta object literal for the '<em><b>Action Writes</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__ACTION_WRITES = eINSTANCE.getBufferDynamicData_ActionWrites();

		/**
		 * The meta object literal for the '<em><b>Action Peeks</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__ACTION_PEEKS = eINSTANCE.getBufferDynamicData_ActionPeeks();

		/**
		 * The meta object literal for the '<em><b>Action Read Misses</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES = eINSTANCE.getBufferDynamicData_ActionReadMisses();

		/**
		 * The meta object literal for the '<em><b>Action Write Misses</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES = eINSTANCE.getBufferDynamicData_ActionWriteMisses();

		/**
		 * The meta object literal for the '<em><b>Unconsumed Tokens</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS = eINSTANCE.getBufferDynamicData_UnconsumedTokens();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl <em>Complex Dynamic Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getComplexDynamicData()
		 * @generated
		 */
		EClass COMPLEX_DYNAMIC_DATA = eINSTANCE.getComplexDynamicData();

		/**
		 * The meta object literal for the '<em><b>Operands Calls</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS = eINSTANCE.getComplexDynamicData_OperandsCalls();

		/**
		 * The meta object literal for the '<em><b>Procedures Calls</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS = eINSTANCE.getComplexDynamicData_ProceduresCalls();

		/**
		 * The meta object literal for the '<em><b>Variables Stores</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__VARIABLES_STORES = eINSTANCE.getComplexDynamicData_VariablesStores();

		/**
		 * The meta object literal for the '<em><b>Variables Loads</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS = eINSTANCE.getComplexDynamicData_VariablesLoads();

		/**
		 * The meta object literal for the '<em><b>Procedures Data</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA = eINSTANCE.getComplexDynamicData_ProceduresData();

		/**
		 * The meta object literal for the '<em><b>Read Tokens</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__READ_TOKENS = eINSTANCE.getComplexDynamicData_ReadTokens();

		/**
		 * The meta object literal for the '<em><b>Write Tokens</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_DYNAMIC_DATA__WRITE_TOKENS = eINSTANCE.getComplexDynamicData_WriteTokens();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ProcedureToComplexDynamicDataMapImpl <em>Procedure To Complex Dynamic Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ProcedureToComplexDynamicDataMapImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getProcedureToComplexDynamicDataMap()
		 * @generated
		 */
		EClass PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP = eINSTANCE.getProcedureToComplexDynamicDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__KEY = eINSTANCE.getProcedureToComplexDynamicDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__VALUE = eINSTANCE.getProcedureToComplexDynamicDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.MemoryProfilingReportImpl <em>Memory Profiling Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.MemoryProfilingReportImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getMemoryProfilingReport()
		 * @generated
		 */
		EClass MEMORY_PROFILING_REPORT = eINSTANCE.getMemoryProfilingReport();

		/**
		 * The meta object literal for the '<em><b>Network Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_PROFILING_REPORT__NETWORK_NAME = eINSTANCE.getMemoryProfilingReport_NetworkName();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PROFILING_REPORT__ACTIONS_DATA = eINSTANCE.getMemoryProfilingReport_ActionsData();

		/**
		 * The meta object literal for the '<em><b>Get Action Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMORY_PROFILING_REPORT___GET_ACTION_DATA__STRING_STRING = eINSTANCE.getMemoryProfilingReport__GetActionData__String_String();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl <em>Action Memory Profiling Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getActionMemoryProfilingData()
		 * @generated
		 */
		EClass ACTION_MEMORY_PROFILING_DATA = eINSTANCE.getActionMemoryProfilingData();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MEMORY_PROFILING_DATA__ACTOR = eINSTANCE.getActionMemoryProfilingData_Actor();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_MEMORY_PROFILING_DATA__ACTION = eINSTANCE.getActionMemoryProfilingData_Action();

		/**
		 * The meta object literal for the '<em><b>Reads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_MEMORY_PROFILING_DATA__READS = eINSTANCE.getActionMemoryProfilingData_Reads();

		/**
		 * The meta object literal for the '<em><b>Writes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_MEMORY_PROFILING_DATA__WRITES = eINSTANCE.getActionMemoryProfilingData_Writes();

		/**
		 * The meta object literal for the '<em><b>Get Read Buffer Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_READ_BUFFER_DATA__STRING_STRING_STRING_STRING = eINSTANCE.getActionMemoryProfilingData__GetReadBufferData__String_String_String_String();

		/**
		 * The meta object literal for the '<em><b>Get Write Buffer Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_WRITE_BUFFER_DATA__STRING_STRING_STRING_STRING = eINSTANCE.getActionMemoryProfilingData__GetWriteBufferData__String_String_String_String();

		/**
		 * The meta object literal for the '<em><b>Get Read State Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_READ_STATE_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetReadStateVariableData__String();

		/**
		 * The meta object literal for the '<em><b>Get Write State Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_WRITE_STATE_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetWriteStateVariableData__String();

		/**
		 * The meta object literal for the '<em><b>Get Read Local Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_READ_LOCAL_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetReadLocalVariableData__String();

		/**
		 * The meta object literal for the '<em><b>Get Write Local Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_WRITE_LOCAL_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetWriteLocalVariableData__String();

		/**
		 * The meta object literal for the '<em><b>Get Read Shared Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_READ_SHARED_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetReadSharedVariableData__String();

		/**
		 * The meta object literal for the '<em><b>Get Write Shared Variable Data</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION_MEMORY_PROFILING_DATA___GET_WRITE_SHARED_VARIABLE_DATA__STRING = eINSTANCE.getActionMemoryProfilingData__GetWriteSharedVariableData__String();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.MemoryAccessDataImpl <em>Memory Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.MemoryAccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getMemoryAccessData()
		 * @generated
		 */
		EClass MEMORY_ACCESS_DATA = eINSTANCE.getMemoryAccessData();

		/**
		 * The meta object literal for the '<em><b>Accesses Data</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_ACCESS_DATA__ACCESSES_DATA = eINSTANCE.getMemoryAccessData_AccessesData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl <em>Buffer Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.BufferAccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getBufferAccessData()
		 * @generated
		 */
		EClass BUFFER_ACCESS_DATA = eINSTANCE.getBufferAccessData();

		/**
		 * The meta object literal for the '<em><b>Source Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_ACCESS_DATA__SOURCE_ACTOR = eINSTANCE.getBufferAccessData_SourceActor();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_ACCESS_DATA__SOURCE_PORT = eINSTANCE.getBufferAccessData_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Target Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_ACCESS_DATA__TARGET_ACTOR = eINSTANCE.getBufferAccessData_TargetActor();

		/**
		 * The meta object literal for the '<em><b>Target Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_ACCESS_DATA__TARGET_PORT = eINSTANCE.getBufferAccessData_TargetPort();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.StateVariableAccessDataImpl <em>State Variable Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.StateVariableAccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getStateVariableAccessData()
		 * @generated
		 */
		EClass STATE_VARIABLE_ACCESS_DATA = eINSTANCE.getStateVariableAccessData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_VARIABLE_ACCESS_DATA__NAME = eINSTANCE.getStateVariableAccessData_Name();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.LocalVariableAccessDataImpl <em>Local Variable Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.LocalVariableAccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getLocalVariableAccessData()
		 * @generated
		 */
		EClass LOCAL_VARIABLE_ACCESS_DATA = eINSTANCE.getLocalVariableAccessData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_VARIABLE_ACCESS_DATA__NAME = eINSTANCE.getLocalVariableAccessData_Name();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.SharedVariableAccessDataImpl <em>Shared Variable Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.SharedVariableAccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getSharedVariableAccessData()
		 * @generated
		 */
		EClass SHARED_VARIABLE_ACCESS_DATA = eINSTANCE.getSharedVariableAccessData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHARED_VARIABLE_ACCESS_DATA__NAME = eINSTANCE.getSharedVariableAccessData_Name();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.AccessDataImpl <em>Access Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.AccessDataImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getAccessData()
		 * @generated
		 */
		EClass ACCESS_DATA = eINSTANCE.getAccessData();

		/**
		 * The meta object literal for the '<em><b>Accesses</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_DATA__ACCESSES = eINSTANCE.getAccessData_Accesses();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_DATA__MIN = eINSTANCE.getAccessData_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_DATA__MAX = eINSTANCE.getAccessData_Max();

		/**
		 * The meta object literal for the '<em><b>Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_DATA__AVERAGE = eINSTANCE.getAccessData_Average();

		/**
		 * The meta object literal for the '<em><b>Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_DATA__TOTAL = eINSTANCE.getAccessData_Total();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.profiler.impl.StringToAccessDataMapImpl <em>String To Access Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.profiler.impl.StringToAccessDataMapImpl
		 * @see turnus.model.analysis.profiler.impl.ProfilerPackageImpl#getStringToAccessDataMap()
		 * @generated
		 */
		EClass STRING_TO_ACCESS_DATA_MAP = eINSTANCE.getStringToAccessDataMap();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_ACCESS_DATA_MAP__VALUE = eINSTANCE.getStringToAccessDataMap_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_ACCESS_DATA_MAP__KEY = eINSTANCE.getStringToAccessDataMap_Key();

	}

} //ProfilerPackage

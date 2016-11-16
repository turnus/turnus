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
package turnus.model.analysis.buffers;

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
 * @see turnus.model.analysis.buffers.BuffersFactory
 * @model kind="package"
 * @generated
 */
public interface BuffersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "buffers";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/buffers";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.buffers";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuffersPackage eINSTANCE = turnus.model.analysis.buffers.impl.BuffersPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl <em>Bounded Buffers Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl
	 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getBoundedBuffersReport()
	 * @generated
	 */
	int BOUNDED_BUFFERS_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pow2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__POW2 = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bit Accurate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__BIT_ACCURATE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Buffers Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__BUFFERS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Token Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__TOKEN_SIZE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT__BIT_SIZE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Bounded Buffers Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Bounded Buffers Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFERS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.buffers.impl.BoundedBufferDataImpl <em>Bounded Buffer Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.buffers.impl.BoundedBufferDataImpl
	 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getBoundedBufferData()
	 * @generated
	 */
	int BOUNDED_BUFFER_DATA = 1;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFER_DATA__BUFFER = 0;

	/**
	 * The feature id for the '<em><b>Token Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFER_DATA__TOKEN_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFER_DATA__BIT_SIZE = 2;

	/**
	 * The number of structural features of the '<em>Bounded Buffer Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFER_DATA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Bounded Buffer Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_BUFFER_DATA_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl <em>Optimal Buffers Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl
	 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getOptimalBuffersReport()
	 * @generated
	 */
	int OPTIMAL_BUFFERS_REPORT = 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pow2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__POW2 = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bit Accurate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Buffers Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Buffer Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Optimal Buffers Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Optimal Buffers Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFERS_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.buffers.impl.OptimalBufferDataImpl <em>Optimal Buffer Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.buffers.impl.OptimalBufferDataImpl
	 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getOptimalBufferData()
	 * @generated
	 */
	int OPTIMAL_BUFFER_DATA = 3;

	/**
	 * The feature id for the '<em><b>Buffer Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFER_DATA__BUFFER_DATA = 0;

	/**
	 * The feature id for the '<em><b>Bottlenecks Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA = 1;

	/**
	 * The number of structural features of the '<em>Optimal Buffer Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFER_DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Optimal Buffer Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMAL_BUFFER_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.buffers.BoundedBuffersReport <em>Bounded Buffers Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Buffers Report</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport
	 * @generated
	 */
	EClass getBoundedBuffersReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.buffers.BoundedBuffersReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#getNetwork()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EReference getBoundedBuffersReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBuffersReport#isPow2 <em>Pow2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pow2</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#isPow2()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EAttribute getBoundedBuffersReport_Pow2();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBuffersReport#isBitAccurate <em>Bit Accurate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Accurate</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#isBitAccurate()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EAttribute getBoundedBuffersReport_BitAccurate();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.buffers.BoundedBuffersReport#getBuffersData <em>Buffers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers Data</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#getBuffersData()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EReference getBoundedBuffersReport_BuffersData();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBuffersReport#getTokenSize <em>Token Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Size</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#getTokenSize()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EAttribute getBoundedBuffersReport_TokenSize();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBuffersReport#getBitSize <em>Bit Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Size</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBuffersReport#getBitSize()
	 * @see #getBoundedBuffersReport()
	 * @generated
	 */
	EAttribute getBoundedBuffersReport_BitSize();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.buffers.BoundedBufferData <em>Bounded Buffer Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Buffer Data</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBufferData
	 * @generated
	 */
	EClass getBoundedBufferData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.buffers.BoundedBufferData#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBufferData#getBuffer()
	 * @see #getBoundedBufferData()
	 * @generated
	 */
	EReference getBoundedBufferData_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBufferData#getTokenSize <em>Token Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Size</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBufferData#getTokenSize()
	 * @see #getBoundedBufferData()
	 * @generated
	 */
	EAttribute getBoundedBufferData_TokenSize();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.BoundedBufferData#getBitSize <em>Bit Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Size</em>'.
	 * @see turnus.model.analysis.buffers.BoundedBufferData#getBitSize()
	 * @see #getBoundedBufferData()
	 * @generated
	 */
	EAttribute getBoundedBufferData_BitSize();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.buffers.OptimalBuffersReport <em>Optimal Buffers Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimal Buffers Report</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport
	 * @generated
	 */
	EClass getOptimalBuffersReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#getNetwork()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EReference getOptimalBuffersReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.OptimalBuffersReport#isPow2 <em>Pow2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pow2</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#isPow2()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EAttribute getOptimalBuffersReport_Pow2();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.buffers.OptimalBuffersReport#isBitAccurate <em>Bit Accurate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Accurate</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#isBitAccurate()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EAttribute getOptimalBuffersReport_BitAccurate();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getBuffersData <em>Buffers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers Data</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#getBuffersData()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EReference getOptimalBuffersReport_BuffersData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBufferConfiguration <em>Initial Buffer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Buffer Configuration</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBufferConfiguration()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EReference getOptimalBuffersReport_InitialBufferConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBottlenecks <em>Initial Bottlenecks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Bottlenecks</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBottlenecks()
	 * @see #getOptimalBuffersReport()
	 * @generated
	 */
	EReference getOptimalBuffersReport_InitialBottlenecks();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.buffers.OptimalBufferData <em>Optimal Buffer Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimal Buffer Data</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBufferData
	 * @generated
	 */
	EClass getOptimalBufferData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.buffers.OptimalBufferData#getBufferData <em>Buffer Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Data</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBufferData#getBufferData()
	 * @see #getOptimalBufferData()
	 * @generated
	 */
	EReference getOptimalBufferData_BufferData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.buffers.OptimalBufferData#getBottlenecksData <em>Bottlenecks Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottlenecks Data</em>'.
	 * @see turnus.model.analysis.buffers.OptimalBufferData#getBottlenecksData()
	 * @see #getOptimalBufferData()
	 * @generated
	 */
	EReference getOptimalBufferData_BottlenecksData();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BuffersFactory getBuffersFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl <em>Bounded Buffers Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl
		 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getBoundedBuffersReport()
		 * @generated
		 */
		EClass BOUNDED_BUFFERS_REPORT = eINSTANCE.getBoundedBuffersReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_BUFFERS_REPORT__NETWORK = eINSTANCE.getBoundedBuffersReport_Network();

		/**
		 * The meta object literal for the '<em><b>Pow2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFERS_REPORT__POW2 = eINSTANCE.getBoundedBuffersReport_Pow2();

		/**
		 * The meta object literal for the '<em><b>Bit Accurate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFERS_REPORT__BIT_ACCURATE = eINSTANCE.getBoundedBuffersReport_BitAccurate();

		/**
		 * The meta object literal for the '<em><b>Buffers Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_BUFFERS_REPORT__BUFFERS_DATA = eINSTANCE.getBoundedBuffersReport_BuffersData();

		/**
		 * The meta object literal for the '<em><b>Token Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFERS_REPORT__TOKEN_SIZE = eINSTANCE.getBoundedBuffersReport_TokenSize();

		/**
		 * The meta object literal for the '<em><b>Bit Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFERS_REPORT__BIT_SIZE = eINSTANCE.getBoundedBuffersReport_BitSize();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.buffers.impl.BoundedBufferDataImpl <em>Bounded Buffer Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.buffers.impl.BoundedBufferDataImpl
		 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getBoundedBufferData()
		 * @generated
		 */
		EClass BOUNDED_BUFFER_DATA = eINSTANCE.getBoundedBufferData();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_BUFFER_DATA__BUFFER = eINSTANCE.getBoundedBufferData_Buffer();

		/**
		 * The meta object literal for the '<em><b>Token Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFER_DATA__TOKEN_SIZE = eINSTANCE.getBoundedBufferData_TokenSize();

		/**
		 * The meta object literal for the '<em><b>Bit Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_BUFFER_DATA__BIT_SIZE = eINSTANCE.getBoundedBufferData_BitSize();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl <em>Optimal Buffers Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl
		 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getOptimalBuffersReport()
		 * @generated
		 */
		EClass OPTIMAL_BUFFERS_REPORT = eINSTANCE.getOptimalBuffersReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFERS_REPORT__NETWORK = eINSTANCE.getOptimalBuffersReport_Network();

		/**
		 * The meta object literal for the '<em><b>Pow2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMAL_BUFFERS_REPORT__POW2 = eINSTANCE.getOptimalBuffersReport_Pow2();

		/**
		 * The meta object literal for the '<em><b>Bit Accurate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE = eINSTANCE.getOptimalBuffersReport_BitAccurate();

		/**
		 * The meta object literal for the '<em><b>Buffers Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA = eINSTANCE.getOptimalBuffersReport_BuffersData();

		/**
		 * The meta object literal for the '<em><b>Initial Buffer Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION = eINSTANCE.getOptimalBuffersReport_InitialBufferConfiguration();

		/**
		 * The meta object literal for the '<em><b>Initial Bottlenecks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS = eINSTANCE.getOptimalBuffersReport_InitialBottlenecks();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.buffers.impl.OptimalBufferDataImpl <em>Optimal Buffer Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.buffers.impl.OptimalBufferDataImpl
		 * @see turnus.model.analysis.buffers.impl.BuffersPackageImpl#getOptimalBufferData()
		 * @generated
		 */
		EClass OPTIMAL_BUFFER_DATA = eINSTANCE.getOptimalBufferData();

		/**
		 * The meta object literal for the '<em><b>Buffer Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFER_DATA__BUFFER_DATA = eINSTANCE.getOptimalBufferData_BufferData();

		/**
		 * The meta object literal for the '<em><b>Bottlenecks Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA = eINSTANCE.getOptimalBufferData_BottlenecksData();

	}

} //BuffersPackage

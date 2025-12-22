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
package turnus.model.analysis.communication;

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
 * @see turnus.model.analysis.communication.CommunicationFactory
 * @model kind="package"
 * @generated
 */
public interface CommunicationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "communication";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/communication";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.communication";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommunicationPackage eINSTANCE = turnus.model.analysis.communication.impl.CommunicationPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.communication.impl.CommunicationWeigthReportImpl <em>Weigth Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.communication.impl.CommunicationWeigthReportImpl
	 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getCommunicationWeigthReport()
	 * @generated
	 */
	int COMMUNICATION_WEIGTH_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT__MODEL = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Buffer Latency</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT__BUFFER_LATENCY = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Weigth Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Weigth Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_WEIGTH_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.communication.impl.CommunicationModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.communication.impl.CommunicationModelImpl
	 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getCommunicationModel()
	 * @generated
	 */
	int COMMUNICATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MODEL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.communication.impl.LinearCommunicationModelImpl <em>Linear Communication Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.communication.impl.LinearCommunicationModelImpl
	 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getLinearCommunicationModel()
	 * @generated
	 */
	int LINEAR_COMMUNICATION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_COMMUNICATION_MODEL__NAME = COMMUNICATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Constant Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH = COMMUNICATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fixed Overhead Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY = COMMUNICATION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Linear Communication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_COMMUNICATION_MODEL_FEATURE_COUNT = COMMUNICATION_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Linear Communication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_COMMUNICATION_MODEL_OPERATION_COUNT = COMMUNICATION_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl <em>Sigmoid Communication Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl
	 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getSigmoidCommunicationModel()
	 * @generated
	 */
	int SIGMOID_COMMUNICATION_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL__NAME = COMMUNICATION_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Carrying Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY = COMMUNICATION_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Growth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE = COMMUNICATION_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Midpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL__MIDPOINT = COMMUNICATION_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sigmoid Communication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL_FEATURE_COUNT = COMMUNICATION_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Sigmoid Communication Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGMOID_COMMUNICATION_MODEL_OPERATION_COUNT = COMMUNICATION_MODEL_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.communication.CommunicationWeigthReport <em>Weigth Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weigth Report</em>'.
	 * @see turnus.model.analysis.communication.CommunicationWeigthReport
	 * @generated
	 */
	EClass getCommunicationWeigthReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.communication.CommunicationWeigthReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.communication.CommunicationWeigthReport#getNetwork()
	 * @see #getCommunicationWeigthReport()
	 * @generated
	 */
	EReference getCommunicationWeigthReport_Network();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.communication.CommunicationWeigthReport#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see turnus.model.analysis.communication.CommunicationWeigthReport#getModel()
	 * @see #getCommunicationWeigthReport()
	 * @generated
	 */
	EReference getCommunicationWeigthReport_Model();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.communication.CommunicationWeigthReport#getBufferLatency <em>Buffer Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Buffer Latency</em>'.
	 * @see turnus.model.analysis.communication.CommunicationWeigthReport#getBufferLatency()
	 * @see #getCommunicationWeigthReport()
	 * @generated
	 */
	EReference getCommunicationWeigthReport_BufferLatency();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.communication.CommunicationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see turnus.model.analysis.communication.CommunicationModel
	 * @generated
	 */
	EClass getCommunicationModel();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.CommunicationModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.communication.CommunicationModel#getName()
	 * @see #getCommunicationModel()
	 * @generated
	 */
	EAttribute getCommunicationModel_Name();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.communication.LinearCommunicationModel <em>Linear Communication Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Communication Model</em>'.
	 * @see turnus.model.analysis.communication.LinearCommunicationModel
	 * @generated
	 */
	EClass getLinearCommunicationModel();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.LinearCommunicationModel#getConstantBandwidth <em>Constant Bandwidth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant Bandwidth</em>'.
	 * @see turnus.model.analysis.communication.LinearCommunicationModel#getConstantBandwidth()
	 * @see #getLinearCommunicationModel()
	 * @generated
	 */
	EAttribute getLinearCommunicationModel_ConstantBandwidth();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.LinearCommunicationModel#getFixedOverheadLatency <em>Fixed Overhead Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Overhead Latency</em>'.
	 * @see turnus.model.analysis.communication.LinearCommunicationModel#getFixedOverheadLatency()
	 * @see #getLinearCommunicationModel()
	 * @generated
	 */
	EAttribute getLinearCommunicationModel_FixedOverheadLatency();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.communication.SigmoidCommunicationModel <em>Sigmoid Communication Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sigmoid Communication Model</em>'.
	 * @see turnus.model.analysis.communication.SigmoidCommunicationModel
	 * @generated
	 */
	EClass getSigmoidCommunicationModel();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getCarryingCapacity <em>Carrying Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Carrying Capacity</em>'.
	 * @see turnus.model.analysis.communication.SigmoidCommunicationModel#getCarryingCapacity()
	 * @see #getSigmoidCommunicationModel()
	 * @generated
	 */
	EAttribute getSigmoidCommunicationModel_CarryingCapacity();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getGrowthRate <em>Growth Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Growth Rate</em>'.
	 * @see turnus.model.analysis.communication.SigmoidCommunicationModel#getGrowthRate()
	 * @see #getSigmoidCommunicationModel()
	 * @generated
	 */
	EAttribute getSigmoidCommunicationModel_GrowthRate();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getMidpoint <em>Midpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Midpoint</em>'.
	 * @see turnus.model.analysis.communication.SigmoidCommunicationModel#getMidpoint()
	 * @see #getSigmoidCommunicationModel()
	 * @generated
	 */
	EAttribute getSigmoidCommunicationModel_Midpoint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommunicationFactory getCommunicationFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.communication.impl.CommunicationWeigthReportImpl <em>Weigth Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.communication.impl.CommunicationWeigthReportImpl
		 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getCommunicationWeigthReport()
		 * @generated
		 */
		EClass COMMUNICATION_WEIGTH_REPORT = eINSTANCE.getCommunicationWeigthReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_WEIGTH_REPORT__NETWORK = eINSTANCE.getCommunicationWeigthReport_Network();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_WEIGTH_REPORT__MODEL = eINSTANCE.getCommunicationWeigthReport_Model();

		/**
		 * The meta object literal for the '<em><b>Buffer Latency</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_WEIGTH_REPORT__BUFFER_LATENCY = eINSTANCE.getCommunicationWeigthReport_BufferLatency();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.communication.impl.CommunicationModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.communication.impl.CommunicationModelImpl
		 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getCommunicationModel()
		 * @generated
		 */
		EClass COMMUNICATION_MODEL = eINSTANCE.getCommunicationModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MODEL__NAME = eINSTANCE.getCommunicationModel_Name();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.communication.impl.LinearCommunicationModelImpl <em>Linear Communication Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.communication.impl.LinearCommunicationModelImpl
		 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getLinearCommunicationModel()
		 * @generated
		 */
		EClass LINEAR_COMMUNICATION_MODEL = eINSTANCE.getLinearCommunicationModel();

		/**
		 * The meta object literal for the '<em><b>Constant Bandwidth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH = eINSTANCE.getLinearCommunicationModel_ConstantBandwidth();

		/**
		 * The meta object literal for the '<em><b>Fixed Overhead Latency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY = eINSTANCE.getLinearCommunicationModel_FixedOverheadLatency();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl <em>Sigmoid Communication Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl
		 * @see turnus.model.analysis.communication.impl.CommunicationPackageImpl#getSigmoidCommunicationModel()
		 * @generated
		 */
		EClass SIGMOID_COMMUNICATION_MODEL = eINSTANCE.getSigmoidCommunicationModel();

		/**
		 * The meta object literal for the '<em><b>Carrying Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY = eINSTANCE.getSigmoidCommunicationModel_CarryingCapacity();

		/**
		 * The meta object literal for the '<em><b>Growth Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE = eINSTANCE.getSigmoidCommunicationModel_GrowthRate();

		/**
		 * The meta object literal for the '<em><b>Midpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGMOID_COMMUNICATION_MODEL__MIDPOINT = eINSTANCE.getSigmoidCommunicationModel_Midpoint();

	}

} //CommunicationPackage

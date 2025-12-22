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
package turnus.model.analysis.pipelining;

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
 * @see turnus.model.analysis.pipelining.PipeliningFactory
 * @model kind="package"
 * @generated
 */
public interface PipeliningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pipelining";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/pipelining";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.pipelining";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PipeliningPackage eINSTANCE = turnus.model.analysis.pipelining.impl.PipeliningPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.pipelining.impl.ActionsVariablePipeliningReportImpl <em>Actions Variable Pipelining Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.pipelining.impl.ActionsVariablePipeliningReportImpl
	 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getActionsVariablePipeliningReport()
	 * @generated
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT__ACTIONS_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actions Variable Pipelining Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Actions Variable Pipelining Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIONS_VARIABLE_PIPELINING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl <em>Action Variable Pipelining Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl
	 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getActionVariablePipeliningData()
	 * @generated
	 */
	int ACTION_VARIABLE_PIPELINING_DATA = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Consecutive Firings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS = 1;

	/**
	 * The feature id for the '<em><b>Pipelinable Firings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS = 2;

	/**
	 * The feature id for the '<em><b>Pipelinable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE = 3;

	/**
	 * The number of structural features of the '<em>Action Variable Pipelining Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Action Variable Pipelining Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VARIABLE_PIPELINING_DATA_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisReportImpl <em>Impact Analysis Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.pipelining.impl.ImpactAnalysisReportImpl
	 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getImpactAnalysisReport()
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
	 * The feature id for the '<em><b>Initial Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Piplenables Actions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__PIPLENABLES_ACTIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Impact Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_REPORT__IMPACT_DATA = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl <em>Impact Analysis Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl
	 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getImpactAnalysisData()
	 * @generated
	 */
	int IMPACT_ANALYSIS_DATA = 3;

	/**
	 * The feature id for the '<em><b>Estimated Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS = 0;

	/**
	 * The feature id for the '<em><b>Cp Reduction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__CP_REDUCTION = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__ACTIONS = 2;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_DATA__ACTOR_CLASS = 3;

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
	 * Returns the meta object for class '{@link turnus.model.analysis.pipelining.ActionsVariablePipeliningReport <em>Actions Variable Pipelining Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actions Variable Pipelining Report</em>'.
	 * @see turnus.model.analysis.pipelining.ActionsVariablePipeliningReport
	 * @generated
	 */
	EClass getActionsVariablePipeliningReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.pipelining.ActionsVariablePipeliningReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.pipelining.ActionsVariablePipeliningReport#getNetwork()
	 * @see #getActionsVariablePipeliningReport()
	 * @generated
	 */
	EReference getActionsVariablePipeliningReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.pipelining.ActionsVariablePipeliningReport#getActionsData <em>Actions Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions Data</em>'.
	 * @see turnus.model.analysis.pipelining.ActionsVariablePipeliningReport#getActionsData()
	 * @see #getActionsVariablePipeliningReport()
	 * @generated
	 */
	EReference getActionsVariablePipeliningReport_ActionsData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData <em>Action Variable Pipelining Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Variable Pipelining Data</em>'.
	 * @see turnus.model.analysis.pipelining.ActionVariablePipeliningData
	 * @generated
	 */
	EClass getActionVariablePipeliningData();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see turnus.model.analysis.pipelining.ActionVariablePipeliningData#getAction()
	 * @see #getActionVariablePipeliningData()
	 * @generated
	 */
	EReference getActionVariablePipeliningData_Action();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getConsecutiveFirings <em>Consecutive Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consecutive Firings</em>'.
	 * @see turnus.model.analysis.pipelining.ActionVariablePipeliningData#getConsecutiveFirings()
	 * @see #getActionVariablePipeliningData()
	 * @generated
	 */
	EReference getActionVariablePipeliningData_ConsecutiveFirings();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getPipelinableFirings <em>Pipelinable Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pipelinable Firings</em>'.
	 * @see turnus.model.analysis.pipelining.ActionVariablePipeliningData#getPipelinableFirings()
	 * @see #getActionVariablePipeliningData()
	 * @generated
	 */
	EReference getActionVariablePipeliningData_PipelinableFirings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#isPipelinable <em>Pipelinable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pipelinable</em>'.
	 * @see turnus.model.analysis.pipelining.ActionVariablePipeliningData#isPipelinable()
	 * @see #getActionVariablePipeliningData()
	 * @generated
	 */
	EAttribute getActionVariablePipeliningData_Pipelinable();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.pipelining.ImpactAnalysisReport <em>Impact Analysis Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Report</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisReport
	 * @generated
	 */
	EClass getImpactAnalysisReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.pipelining.ImpactAnalysisReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisReport#getNetwork()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_Network();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.pipelining.ImpactAnalysisReport#getInitialBottlenecks <em>Initial Bottlenecks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Bottlenecks</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisReport#getInitialBottlenecks()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_InitialBottlenecks();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.pipelining.ImpactAnalysisReport#getPiplenablesActions <em>Piplenables Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Piplenables Actions</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisReport#getPiplenablesActions()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_PiplenablesActions();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.pipelining.ImpactAnalysisReport#getImpactData <em>Impact Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Impact Data</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisReport#getImpactData()
	 * @see #getImpactAnalysisReport()
	 * @generated
	 */
	EReference getImpactAnalysisReport_ImpactData();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.pipelining.ImpactAnalysisData <em>Impact Analysis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Data</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisData
	 * @generated
	 */
	EClass getImpactAnalysisData();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getEstimatedBottlenecks <em>Estimated Bottlenecks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Estimated Bottlenecks</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisData#getEstimatedBottlenecks()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_EstimatedBottlenecks();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getCpReduction <em>Cp Reduction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cp Reduction</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisData#getCpReduction()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EAttribute getImpactAnalysisData_CpReduction();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisData#getActions()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_Actions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see turnus.model.analysis.pipelining.ImpactAnalysisData#getActorClass()
	 * @see #getImpactAnalysisData()
	 * @generated
	 */
	EReference getImpactAnalysisData_ActorClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PipeliningFactory getPipeliningFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.pipelining.impl.ActionsVariablePipeliningReportImpl <em>Actions Variable Pipelining Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.pipelining.impl.ActionsVariablePipeliningReportImpl
		 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getActionsVariablePipeliningReport()
		 * @generated
		 */
		EClass ACTIONS_VARIABLE_PIPELINING_REPORT = eINSTANCE.getActionsVariablePipeliningReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIONS_VARIABLE_PIPELINING_REPORT__NETWORK = eINSTANCE.getActionsVariablePipeliningReport_Network();

		/**
		 * The meta object literal for the '<em><b>Actions Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIONS_VARIABLE_PIPELINING_REPORT__ACTIONS_DATA = eINSTANCE.getActionsVariablePipeliningReport_ActionsData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl <em>Action Variable Pipelining Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.pipelining.impl.ActionVariablePipeliningDataImpl
		 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getActionVariablePipeliningData()
		 * @generated
		 */
		EClass ACTION_VARIABLE_PIPELINING_DATA = eINSTANCE.getActionVariablePipeliningData();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_VARIABLE_PIPELINING_DATA__ACTION = eINSTANCE.getActionVariablePipeliningData_Action();

		/**
		 * The meta object literal for the '<em><b>Consecutive Firings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS = eINSTANCE.getActionVariablePipeliningData_ConsecutiveFirings();

		/**
		 * The meta object literal for the '<em><b>Pipelinable Firings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS = eINSTANCE.getActionVariablePipeliningData_PipelinableFirings();

		/**
		 * The meta object literal for the '<em><b>Pipelinable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE = eINSTANCE.getActionVariablePipeliningData_Pipelinable();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisReportImpl <em>Impact Analysis Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.pipelining.impl.ImpactAnalysisReportImpl
		 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getImpactAnalysisReport()
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
		 * The meta object literal for the '<em><b>Initial Bottlenecks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS = eINSTANCE.getImpactAnalysisReport_InitialBottlenecks();

		/**
		 * The meta object literal for the '<em><b>Piplenables Actions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__PIPLENABLES_ACTIONS = eINSTANCE.getImpactAnalysisReport_PiplenablesActions();

		/**
		 * The meta object literal for the '<em><b>Impact Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_REPORT__IMPACT_DATA = eINSTANCE.getImpactAnalysisReport_ImpactData();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl <em>Impact Analysis Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl
		 * @see turnus.model.analysis.pipelining.impl.PipeliningPackageImpl#getImpactAnalysisData()
		 * @generated
		 */
		EClass IMPACT_ANALYSIS_DATA = eINSTANCE.getImpactAnalysisData();

		/**
		 * The meta object literal for the '<em><b>Estimated Bottlenecks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS = eINSTANCE.getImpactAnalysisData_EstimatedBottlenecks();

		/**
		 * The meta object literal for the '<em><b>Cp Reduction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT_ANALYSIS_DATA__CP_REDUCTION = eINSTANCE.getImpactAnalysisData_CpReduction();

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

	}

} //PipeliningPackage

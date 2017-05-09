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
package turnus.model.analysis.scheduling;

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
 * @see turnus.model.analysis.scheduling.SchedulingFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/scheduling";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.scheduling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingPackage eINSTANCE = turnus.model.analysis.scheduling.impl.SchedulingPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl <em>Markov Simple Scheduler Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSimpleSchedulerReport()
	 * @generated
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT__PARTITIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Markov Simple Scheduler Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Markov Simple Scheduler Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl <em>Markov Partition Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovPartitionScheduler()
	 * @generated
	 */
	int MARKOV_PARTITION_SCHEDULER = 1;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER__PARTITION_ID = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER__STATES = 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER__TRANSITIONS = 3;

	/**
	 * The number of structural features of the '<em>Markov Partition Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Markov Partition Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl <em>Markov Scheduling State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSchedulingState()
	 * @generated
	 */
	int MARKOV_SCHEDULING_STATE = 2;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE__FIRINGS = 1;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE__OUTGOINGS = 2;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE__INCOMINGS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE__NAME = 4;

	/**
	 * The number of structural features of the '<em>Markov Scheduling State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Markov Scheduling State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl <em>Markov Scheduling Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSchedulingTransition()
	 * @generated
	 */
	int MARKOV_SCHEDULING_TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION__FIRINGS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION__NAME = 3;

	/**
	 * The number of structural features of the '<em>Markov Scheduling Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Markov Scheduling Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_SCHEDULING_TRANSITION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport <em>Markov Simple Scheduler Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markov Simple Scheduler Report</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport
	 * @generated
	 */
	EClass getMarkovSimpleSchedulerReport();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport#getPartitions()
	 * @see #getMarkovSimpleSchedulerReport()
	 * @generated
	 */
	EReference getMarkovSimpleSchedulerReport_Partitions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport#getNetwork()
	 * @see #getMarkovSimpleSchedulerReport()
	 * @generated
	 */
	EReference getMarkovSimpleSchedulerReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler <em>Markov Partition Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markov Partition Scheduler</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler
	 * @generated
	 */
	EClass getMarkovPartitionScheduler();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler#getActors()
	 * @see #getMarkovPartitionScheduler()
	 * @generated
	 */
	EReference getMarkovPartitionScheduler_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler#getPartitionId <em>Partition Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Id</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler#getPartitionId()
	 * @see #getMarkovPartitionScheduler()
	 * @generated
	 */
	EAttribute getMarkovPartitionScheduler_PartitionId();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler#getStates()
	 * @see #getMarkovPartitionScheduler()
	 * @generated
	 */
	EReference getMarkovPartitionScheduler_States();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler#getTransitions()
	 * @see #getMarkovPartitionScheduler()
	 * @generated
	 */
	EReference getMarkovPartitionScheduler_Transitions();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.MarkovSchedulingState <em>Markov Scheduling State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markov Scheduling State</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState
	 * @generated
	 */
	EClass getMarkovSchedulingState();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getActor()
	 * @see #getMarkovSchedulingState()
	 * @generated
	 */
	EReference getMarkovSchedulingState_Actor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getFirings <em>Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firings</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getFirings()
	 * @see #getMarkovSchedulingState()
	 * @generated
	 */
	EAttribute getMarkovSchedulingState_Firings();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getOutgoings()
	 * @see #getMarkovSchedulingState()
	 * @generated
	 */
	EReference getMarkovSchedulingState_Outgoings();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getIncomings()
	 * @see #getMarkovSchedulingState()
	 * @generated
	 */
	EReference getMarkovSchedulingState_Incomings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getName()
	 * @see #getMarkovSchedulingState()
	 * @generated
	 */
	EAttribute getMarkovSchedulingState_Name();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition <em>Markov Scheduling Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markov Scheduling Transition</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition
	 * @generated
	 */
	EClass getMarkovSchedulingTransition();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource()
	 * @see #getMarkovSchedulingTransition()
	 * @generated
	 */
	EReference getMarkovSchedulingTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget()
	 * @see #getMarkovSchedulingTransition()
	 * @generated
	 */
	EReference getMarkovSchedulingTransition_Target();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getFirings <em>Firings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firings</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getFirings()
	 * @see #getMarkovSchedulingTransition()
	 * @generated
	 */
	EAttribute getMarkovSchedulingTransition_Firings();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getName()
	 * @see #getMarkovSchedulingTransition()
	 * @generated
	 */
	EAttribute getMarkovSchedulingTransition_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulingFactory getSchedulingFactory();

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
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl <em>Markov Simple Scheduler Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSimpleSchedulerReport()
		 * @generated
		 */
		EClass MARKOV_SIMPLE_SCHEDULER_REPORT = eINSTANCE.getMarkovSimpleSchedulerReport();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SIMPLE_SCHEDULER_REPORT__PARTITIONS = eINSTANCE.getMarkovSimpleSchedulerReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SIMPLE_SCHEDULER_REPORT__NETWORK = eINSTANCE.getMarkovSimpleSchedulerReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl <em>Markov Partition Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.MarkovPartitionSchedulerImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovPartitionScheduler()
		 * @generated
		 */
		EClass MARKOV_PARTITION_SCHEDULER = eINSTANCE.getMarkovPartitionScheduler();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_PARTITION_SCHEDULER__ACTORS = eINSTANCE.getMarkovPartitionScheduler_Actors();

		/**
		 * The meta object literal for the '<em><b>Partition Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_PARTITION_SCHEDULER__PARTITION_ID = eINSTANCE.getMarkovPartitionScheduler_PartitionId();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_PARTITION_SCHEDULER__STATES = eINSTANCE.getMarkovPartitionScheduler_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_PARTITION_SCHEDULER__TRANSITIONS = eINSTANCE.getMarkovPartitionScheduler_Transitions();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl <em>Markov Scheduling State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSchedulingState()
		 * @generated
		 */
		EClass MARKOV_SCHEDULING_STATE = eINSTANCE.getMarkovSchedulingState();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SCHEDULING_STATE__ACTOR = eINSTANCE.getMarkovSchedulingState_Actor();

		/**
		 * The meta object literal for the '<em><b>Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_SCHEDULING_STATE__FIRINGS = eINSTANCE.getMarkovSchedulingState_Firings();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SCHEDULING_STATE__OUTGOINGS = eINSTANCE.getMarkovSchedulingState_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SCHEDULING_STATE__INCOMINGS = eINSTANCE.getMarkovSchedulingState_Incomings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_SCHEDULING_STATE__NAME = eINSTANCE.getMarkovSchedulingState_Name();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl <em>Markov Scheduling Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.MarkovSchedulingTransitionImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSchedulingTransition()
		 * @generated
		 */
		EClass MARKOV_SCHEDULING_TRANSITION = eINSTANCE.getMarkovSchedulingTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SCHEDULING_TRANSITION__SOURCE = eINSTANCE.getMarkovSchedulingTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKOV_SCHEDULING_TRANSITION__TARGET = eINSTANCE.getMarkovSchedulingTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Firings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_SCHEDULING_TRANSITION__FIRINGS = eINSTANCE.getMarkovSchedulingTransition_Firings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKOV_SCHEDULING_TRANSITION__NAME = eINSTANCE.getMarkovSchedulingTransition_Name();

	}

} //SchedulingPackage

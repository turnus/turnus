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
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http://turnus.co/model/2017/analysis/scheduling";

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
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.ActorSelectionScheduleImpl <em>Actor Selection Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.ActorSelectionScheduleImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getActorSelectionSchedule()
	 * @generated
	 */
	int ACTOR_SELECTION_SCHEDULE = 2;

	/**
	 * The number of structural features of the '<em>Actor Selection Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Actor Selection Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.ActorFireImpl <em>Actor Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.ActorFireImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getActorFire()
	 * @generated
	 */
	int ACTOR_FIRE = 0;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE__ACTOR = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE__TIMES = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE__PARTITION = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dependency Partitions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE__DEPENDENCY_PARTITIONS = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Actor Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE_FEATURE_COUNT = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Actor Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FIRE_OPERATION_COUNT = ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMImpl <em>FSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSM()
	 * @generated
	 */
	int FSM = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__STATES = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__VARS = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__START_STATE = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Terminal State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__TERMINAL_STATE = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FEATURE_COUNT = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION_COUNT = ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.SequenceImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ACTIONS = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = ACTOR_SELECTION_SCHEDULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_OPERATION_COUNT = ACTOR_SELECTION_SCHEDULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMVarImpl <em>FSM Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMVarImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMVar()
	 * @generated
	 */
	int FSM_VAR = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Initial Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR__INITIAL_VAL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR__TYPE = 2;

	/**
	 * The number of structural features of the '<em>FSM Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>FSM Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl <em>FSM Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMTransitionImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMTransition()
	 * @generated
	 */
	int FSM_TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION__COND = 0;

	/**
	 * The feature id for the '<em><b>Target State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION__TARGET_STATE_ENUM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Source State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION__SOURCE_STATE_ENUM_NAME = 2;

	/**
	 * The feature id for the '<em><b>Transition Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION__TRANSITION_SCHEDULE = 3;

	/**
	 * The number of structural features of the '<em>FSM Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>FSM Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMStateImpl <em>FSM State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMStateImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMState()
	 * @generated
	 */
	int FSM_STATE = 6;

	/**
	 * The feature id for the '<em><b>Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE__ENUM_NAME = 0;

	/**
	 * The feature id for the '<em><b>Var Updates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE__VAR_UPDATES = 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE__TRANSITIONS = 2;

	/**
	 * The number of structural features of the '<em>FSM State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>FSM State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMVarUpdateImpl <em>FSM Var Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMVarUpdateImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMVarUpdate()
	 * @generated
	 */
	int FSM_VAR_UPDATE = 7;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_UPDATE__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_UPDATE__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>FSM Var Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_UPDATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>FSM Var Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_VAR_UPDATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMOperationImpl <em>FSM Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMOperationImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMOperation()
	 * @generated
	 */
	int FSM_OPERATION = 8;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION__OP = 0;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION__VAL = 1;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION__VAR = 2;

	/**
	 * The number of structural features of the '<em>FSM Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>FSM Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMCombinationImpl <em>FSM Combination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMCombinationImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCombination()
	 * @generated
	 */
	int FSM_COMBINATION = 9;

	/**
	 * The feature id for the '<em><b>Combinator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_COMBINATION__COMBINATOR = 0;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_COMBINATION__COND = 1;

	/**
	 * The number of structural features of the '<em>FSM Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_COMBINATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>FSM Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_COMBINATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl <em>FSM Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMConditionImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCondition()
	 * @generated
	 */
	int FSM_CONDITION = 10;

	/**
	 * The feature id for the '<em><b>Comp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION__COMP = 0;

	/**
	 * The feature id for the '<em><b>Compval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION__COMPVAL = 1;

	/**
	 * The feature id for the '<em><b>Combined Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION__COMBINED_COND = 2;

	/**
	 * The feature id for the '<em><b>Val Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION__VAL_NAME = 3;

	/**
	 * The number of structural features of the '<em>FSM Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>FSM Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.FSMTransitionWithStateImpl <em>FSM Transition With State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.FSMTransitionWithStateImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMTransitionWithState()
	 * @generated
	 */
	int FSM_TRANSITION_WITH_STATE = 11;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE__COND = FSM_TRANSITION__COND;

	/**
	 * The feature id for the '<em><b>Target State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE__TARGET_STATE_ENUM_NAME = FSM_TRANSITION__TARGET_STATE_ENUM_NAME;

	/**
	 * The feature id for the '<em><b>Source State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE__SOURCE_STATE_ENUM_NAME = FSM_TRANSITION__SOURCE_STATE_ENUM_NAME;

	/**
	 * The feature id for the '<em><b>Transition Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE__TRANSITION_SCHEDULE = FSM_TRANSITION__TRANSITION_SCHEDULE;

	/**
	 * The feature id for the '<em><b>Var States</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE__VAR_STATES = FSM_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FSM Transition With State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE_FEATURE_COUNT = FSM_TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>FSM Transition With State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_WITH_STATE_OPERATION_COUNT = FSM_TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.PartitionedActorFireImpl <em>Partitioned Actor Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.PartitionedActorFireImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getPartitionedActorFire()
	 * @generated
	 */
	int PARTITIONED_ACTOR_FIRE = 12;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE__ACTOR = ACTOR_FIRE__ACTOR;

	/**
	 * The feature id for the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE__TIMES = ACTOR_FIRE__TIMES;

	/**
	 * The feature id for the '<em><b>Partition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE__PARTITION = ACTOR_FIRE__PARTITION;

	/**
	 * The feature id for the '<em><b>Dependency Partitions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE__DEPENDENCY_PARTITIONS = ACTOR_FIRE__DEPENDENCY_PARTITIONS;

	/**
	 * The number of structural features of the '<em>Partitioned Actor Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE_FEATURE_COUNT = ACTOR_FIRE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Partitioned Actor Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITIONED_ACTOR_FIRE_OPERATION_COUNT = ACTOR_FIRE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl <em>Markov Simple Scheduler Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovSimpleSchedulerReportImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSimpleSchedulerReport()
	 * @generated
	 */
	int MARKOV_SIMPLE_SCHEDULER_REPORT = 13;

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
	int MARKOV_PARTITION_SCHEDULER = 14;

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
	 * The operation id for the '<em>Get Associated State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER___GET_ASSOCIATED_STATE__ACTOR = 0;

	/**
	 * The number of operations of the '<em>Markov Partition Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKOV_PARTITION_SCHEDULER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl <em>Markov Scheduling State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.impl.MarkovSchedulingStateImpl
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getMarkovSchedulingState()
	 * @generated
	 */
	int MARKOV_SCHEDULING_STATE = 15;

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
	int MARKOV_SCHEDULING_TRANSITION = 16;

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
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.FSMOp <em>FSM Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.FSMOp
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMOp()
	 * @generated
	 */
	int FSM_OP = 17;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.FSMComparator <em>FSM Comparator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.FSMComparator
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMComparator()
	 * @generated
	 */
	int FSM_COMPARATOR = 18;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.scheduling.FSMCombinator <em>FSM Combinator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.scheduling.FSMCombinator
	 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCombinator()
	 * @generated
	 */
	int FSM_COMBINATOR = 19;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.ActorFire <em>Actor Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Fire</em>'.
	 * @see turnus.model.analysis.scheduling.ActorFire
	 * @generated
	 */
	EClass getActorFire();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.ActorFire#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actor</em>'.
	 * @see turnus.model.analysis.scheduling.ActorFire#getActor()
	 * @see #getActorFire()
	 * @generated
	 */
	EAttribute getActorFire_Actor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.ActorFire#getTimes <em>Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times</em>'.
	 * @see turnus.model.analysis.scheduling.ActorFire#getTimes()
	 * @see #getActorFire()
	 * @generated
	 */
	EAttribute getActorFire_Times();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.ActorFire#getPartition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition</em>'.
	 * @see turnus.model.analysis.scheduling.ActorFire#getPartition()
	 * @see #getActorFire()
	 * @generated
	 */
	EAttribute getActorFire_Partition();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.analysis.scheduling.ActorFire#getDependencyPartitions <em>Dependency Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dependency Partitions</em>'.
	 * @see turnus.model.analysis.scheduling.ActorFire#getDependencyPartitions()
	 * @see #getActorFire()
	 * @generated
	 */
	EAttribute getActorFire_DependencyPartitions();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSM <em>FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM</em>'.
	 * @see turnus.model.analysis.scheduling.FSM
	 * @generated
	 */
	EClass getFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.FSM#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see turnus.model.analysis.scheduling.FSM#getStates()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_States();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.FSM#getVars <em>Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vars</em>'.
	 * @see turnus.model.analysis.scheduling.FSM#getVars()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_Vars();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSM#getStartState <em>Start State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start State</em>'.
	 * @see turnus.model.analysis.scheduling.FSM#getStartState()
	 * @see #getFSM()
	 * @generated
	 */
	EAttribute getFSM_StartState();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSM#getTerminalState <em>Terminal State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal State</em>'.
	 * @see turnus.model.analysis.scheduling.FSM#getTerminalState()
	 * @see #getFSM()
	 * @generated
	 */
	EAttribute getFSM_TerminalState();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.ActorSelectionSchedule <em>Actor Selection Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Selection Schedule</em>'.
	 * @see turnus.model.analysis.scheduling.ActorSelectionSchedule
	 * @generated
	 */
	EClass getActorSelectionSchedule();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see turnus.model.analysis.scheduling.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.Sequence#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see turnus.model.analysis.scheduling.Sequence#getActions()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Actions();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMVar <em>FSM Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Var</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVar
	 * @generated
	 */
	EClass getFSMVar();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMVar#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVar#getName()
	 * @see #getFSMVar()
	 * @generated
	 */
	EAttribute getFSMVar_Name();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMVar#getInitialVal <em>Initial Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Val</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVar#getInitialVal()
	 * @see #getFSMVar()
	 * @generated
	 */
	EAttribute getFSMVar_InitialVal();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMVar#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVar#getType()
	 * @see #getFSMVar()
	 * @generated
	 */
	EAttribute getFSMVar_Type();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMTransition <em>FSM Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Transition</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransition
	 * @generated
	 */
	EClass getFSMTransition();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMTransition#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransition#getCond()
	 * @see #getFSMTransition()
	 * @generated
	 */
	EReference getFSMTransition_Cond();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMTransition#getTargetStateEnumName <em>Target State Enum Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target State Enum Name</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransition#getTargetStateEnumName()
	 * @see #getFSMTransition()
	 * @generated
	 */
	EAttribute getFSMTransition_TargetStateEnumName();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMTransition#getSourceStateEnumName <em>Source State Enum Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source State Enum Name</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransition#getSourceStateEnumName()
	 * @see #getFSMTransition()
	 * @generated
	 */
	EAttribute getFSMTransition_SourceStateEnumName();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMTransition#getTransitionSchedule <em>Transition Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transition Schedule</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransition#getTransitionSchedule()
	 * @see #getFSMTransition()
	 * @generated
	 */
	EReference getFSMTransition_TransitionSchedule();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMState <em>FSM State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM State</em>'.
	 * @see turnus.model.analysis.scheduling.FSMState
	 * @generated
	 */
	EClass getFSMState();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMState#getEnumName <em>Enum Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum Name</em>'.
	 * @see turnus.model.analysis.scheduling.FSMState#getEnumName()
	 * @see #getFSMState()
	 * @generated
	 */
	EAttribute getFSMState_EnumName();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.FSMState#getVarUpdates <em>Var Updates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Updates</em>'.
	 * @see turnus.model.analysis.scheduling.FSMState#getVarUpdates()
	 * @see #getFSMState()
	 * @generated
	 */
	EReference getFSMState_VarUpdates();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.scheduling.FSMState#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see turnus.model.analysis.scheduling.FSMState#getTransitions()
	 * @see #getFSMState()
	 * @generated
	 */
	EReference getFSMState_Transitions();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMVarUpdate <em>FSM Var Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Var Update</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVarUpdate
	 * @generated
	 */
	EClass getFSMVarUpdate();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVarUpdate#getOperation()
	 * @see #getFSMVarUpdate()
	 * @generated
	 */
	EReference getFSMVarUpdate_Operation();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see turnus.model.analysis.scheduling.FSMVarUpdate#getCondition()
	 * @see #getFSMVarUpdate()
	 * @generated
	 */
	EReference getFSMVarUpdate_Condition();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMOperation <em>FSM Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Operation</em>'.
	 * @see turnus.model.analysis.scheduling.FSMOperation
	 * @generated
	 */
	EClass getFSMOperation();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMOperation#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see turnus.model.analysis.scheduling.FSMOperation#getOp()
	 * @see #getFSMOperation()
	 * @generated
	 */
	EAttribute getFSMOperation_Op();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMOperation#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see turnus.model.analysis.scheduling.FSMOperation#getVal()
	 * @see #getFSMOperation()
	 * @generated
	 */
	EAttribute getFSMOperation_Val();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMOperation#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see turnus.model.analysis.scheduling.FSMOperation#getVar()
	 * @see #getFSMOperation()
	 * @generated
	 */
	EAttribute getFSMOperation_Var();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMCombination <em>FSM Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Combination</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCombination
	 * @generated
	 */
	EClass getFSMCombination();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMCombination#getCombinator <em>Combinator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Combinator</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCombination#getCombinator()
	 * @see #getFSMCombination()
	 * @generated
	 */
	EAttribute getFSMCombination_Combinator();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMCombination#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCombination#getCond()
	 * @see #getFSMCombination()
	 * @generated
	 */
	EReference getFSMCombination_Cond();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMCondition <em>FSM Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Condition</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCondition
	 * @generated
	 */
	EClass getFSMCondition();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMCondition#getComp <em>Comp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comp</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCondition#getComp()
	 * @see #getFSMCondition()
	 * @generated
	 */
	EAttribute getFSMCondition_Comp();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMCondition#getCompval <em>Compval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compval</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCondition#getCompval()
	 * @see #getFSMCondition()
	 * @generated
	 */
	EAttribute getFSMCondition_Compval();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.analysis.scheduling.FSMCondition#getCombinedCond <em>Combined Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Combined Cond</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCondition#getCombinedCond()
	 * @see #getFSMCondition()
	 * @generated
	 */
	EReference getFSMCondition_CombinedCond();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.scheduling.FSMCondition#getValName <em>Val Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val Name</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCondition#getValName()
	 * @see #getFSMCondition()
	 * @generated
	 */
	EAttribute getFSMCondition_ValName();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.FSMTransitionWithState <em>FSM Transition With State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Transition With State</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransitionWithState
	 * @generated
	 */
	EClass getFSMTransitionWithState();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.scheduling.FSMTransitionWithState#getVarStates <em>Var States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Var States</em>'.
	 * @see turnus.model.analysis.scheduling.FSMTransitionWithState#getVarStates()
	 * @see #getFSMTransitionWithState()
	 * @generated
	 */
	EReference getFSMTransitionWithState_VarStates();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.scheduling.PartitionedActorFire <em>Partitioned Actor Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partitioned Actor Fire</em>'.
	 * @see turnus.model.analysis.scheduling.PartitionedActorFire
	 * @generated
	 */
	EClass getPartitionedActorFire();

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
	 * Returns the meta object for the '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler#getAssociatedState(turnus.model.dataflow.Actor) <em>Get Associated State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Associated State</em>' operation.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler#getAssociatedState(turnus.model.dataflow.Actor)
	 * @generated
	 */
	EOperation getMarkovPartitionScheduler__GetAssociatedState__Actor();

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
	 * Returns the meta object for enum '{@link turnus.model.analysis.scheduling.FSMOp <em>FSM Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>FSM Op</em>'.
	 * @see turnus.model.analysis.scheduling.FSMOp
	 * @generated
	 */
	EEnum getFSMOp();

	/**
	 * Returns the meta object for enum '{@link turnus.model.analysis.scheduling.FSMComparator <em>FSM Comparator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>FSM Comparator</em>'.
	 * @see turnus.model.analysis.scheduling.FSMComparator
	 * @generated
	 */
	EEnum getFSMComparator();

	/**
	 * Returns the meta object for enum '{@link turnus.model.analysis.scheduling.FSMCombinator <em>FSM Combinator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>FSM Combinator</em>'.
	 * @see turnus.model.analysis.scheduling.FSMCombinator
	 * @generated
	 */
	EEnum getFSMCombinator();

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
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.ActorFireImpl <em>Actor Fire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.ActorFireImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getActorFire()
		 * @generated
		 */
		EClass ACTOR_FIRE = eINSTANCE.getActorFire();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_FIRE__ACTOR = eINSTANCE.getActorFire_Actor();

		/**
		 * The meta object literal for the '<em><b>Times</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_FIRE__TIMES = eINSTANCE.getActorFire_Times();

		/**
		 * The meta object literal for the '<em><b>Partition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_FIRE__PARTITION = eINSTANCE.getActorFire_Partition();

		/**
		 * The meta object literal for the '<em><b>Dependency Partitions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_FIRE__DEPENDENCY_PARTITIONS = eINSTANCE.getActorFire_DependencyPartitions();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMImpl <em>FSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSM()
		 * @generated
		 */
		EClass FSM = eINSTANCE.getFSM();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM__STATES = eINSTANCE.getFSM_States();

		/**
		 * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM__VARS = eINSTANCE.getFSM_Vars();

		/**
		 * The meta object literal for the '<em><b>Start State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM__START_STATE = eINSTANCE.getFSM_StartState();

		/**
		 * The meta object literal for the '<em><b>Terminal State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM__TERMINAL_STATE = eINSTANCE.getFSM_TerminalState();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.ActorSelectionScheduleImpl <em>Actor Selection Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.ActorSelectionScheduleImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getActorSelectionSchedule()
		 * @generated
		 */
		EClass ACTOR_SELECTION_SCHEDULE = eINSTANCE.getActorSelectionSchedule();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.SequenceImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__ACTIONS = eINSTANCE.getSequence_Actions();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMVarImpl <em>FSM Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMVarImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMVar()
		 * @generated
		 */
		EClass FSM_VAR = eINSTANCE.getFSMVar();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_VAR__NAME = eINSTANCE.getFSMVar_Name();

		/**
		 * The meta object literal for the '<em><b>Initial Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_VAR__INITIAL_VAL = eINSTANCE.getFSMVar_InitialVal();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_VAR__TYPE = eINSTANCE.getFSMVar_Type();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMTransitionImpl <em>FSM Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMTransitionImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMTransition()
		 * @generated
		 */
		EClass FSM_TRANSITION = eINSTANCE.getFSMTransition();

		/**
		 * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_TRANSITION__COND = eINSTANCE.getFSMTransition_Cond();

		/**
		 * The meta object literal for the '<em><b>Target State Enum Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_TRANSITION__TARGET_STATE_ENUM_NAME = eINSTANCE.getFSMTransition_TargetStateEnumName();

		/**
		 * The meta object literal for the '<em><b>Source State Enum Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_TRANSITION__SOURCE_STATE_ENUM_NAME = eINSTANCE.getFSMTransition_SourceStateEnumName();

		/**
		 * The meta object literal for the '<em><b>Transition Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_TRANSITION__TRANSITION_SCHEDULE = eINSTANCE.getFSMTransition_TransitionSchedule();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMStateImpl <em>FSM State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMStateImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMState()
		 * @generated
		 */
		EClass FSM_STATE = eINSTANCE.getFSMState();

		/**
		 * The meta object literal for the '<em><b>Enum Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_STATE__ENUM_NAME = eINSTANCE.getFSMState_EnumName();

		/**
		 * The meta object literal for the '<em><b>Var Updates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_STATE__VAR_UPDATES = eINSTANCE.getFSMState_VarUpdates();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_STATE__TRANSITIONS = eINSTANCE.getFSMState_Transitions();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMVarUpdateImpl <em>FSM Var Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMVarUpdateImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMVarUpdate()
		 * @generated
		 */
		EClass FSM_VAR_UPDATE = eINSTANCE.getFSMVarUpdate();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_VAR_UPDATE__OPERATION = eINSTANCE.getFSMVarUpdate_Operation();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_VAR_UPDATE__CONDITION = eINSTANCE.getFSMVarUpdate_Condition();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMOperationImpl <em>FSM Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMOperationImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMOperation()
		 * @generated
		 */
		EClass FSM_OPERATION = eINSTANCE.getFSMOperation();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_OPERATION__OP = eINSTANCE.getFSMOperation_Op();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_OPERATION__VAL = eINSTANCE.getFSMOperation_Val();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_OPERATION__VAR = eINSTANCE.getFSMOperation_Var();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMCombinationImpl <em>FSM Combination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMCombinationImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCombination()
		 * @generated
		 */
		EClass FSM_COMBINATION = eINSTANCE.getFSMCombination();

		/**
		 * The meta object literal for the '<em><b>Combinator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_COMBINATION__COMBINATOR = eINSTANCE.getFSMCombination_Combinator();

		/**
		 * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_COMBINATION__COND = eINSTANCE.getFSMCombination_Cond();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMConditionImpl <em>FSM Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMConditionImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCondition()
		 * @generated
		 */
		EClass FSM_CONDITION = eINSTANCE.getFSMCondition();

		/**
		 * The meta object literal for the '<em><b>Comp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_CONDITION__COMP = eINSTANCE.getFSMCondition_Comp();

		/**
		 * The meta object literal for the '<em><b>Compval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_CONDITION__COMPVAL = eINSTANCE.getFSMCondition_Compval();

		/**
		 * The meta object literal for the '<em><b>Combined Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_CONDITION__COMBINED_COND = eINSTANCE.getFSMCondition_CombinedCond();

		/**
		 * The meta object literal for the '<em><b>Val Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_CONDITION__VAL_NAME = eINSTANCE.getFSMCondition_ValName();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.FSMTransitionWithStateImpl <em>FSM Transition With State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.FSMTransitionWithStateImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMTransitionWithState()
		 * @generated
		 */
		EClass FSM_TRANSITION_WITH_STATE = eINSTANCE.getFSMTransitionWithState();

		/**
		 * The meta object literal for the '<em><b>Var States</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_TRANSITION_WITH_STATE__VAR_STATES = eINSTANCE.getFSMTransitionWithState_VarStates();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.impl.PartitionedActorFireImpl <em>Partitioned Actor Fire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.impl.PartitionedActorFireImpl
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getPartitionedActorFire()
		 * @generated
		 */
		EClass PARTITIONED_ACTOR_FIRE = eINSTANCE.getPartitionedActorFire();

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
		 * The meta object literal for the '<em><b>Get Associated State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MARKOV_PARTITION_SCHEDULER___GET_ASSOCIATED_STATE__ACTOR = eINSTANCE.getMarkovPartitionScheduler__GetAssociatedState__Actor();

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

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.FSMOp <em>FSM Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.FSMOp
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMOp()
		 * @generated
		 */
		EEnum FSM_OP = eINSTANCE.getFSMOp();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.FSMComparator <em>FSM Comparator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.FSMComparator
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMComparator()
		 * @generated
		 */
		EEnum FSM_COMPARATOR = eINSTANCE.getFSMComparator();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.scheduling.FSMCombinator <em>FSM Combinator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.scheduling.FSMCombinator
		 * @see turnus.model.analysis.scheduling.impl.SchedulingPackageImpl#getFSMCombinator()
		 * @generated
		 */
		EEnum FSM_COMBINATOR = eINSTANCE.getFSMCombinator();

	}

} //SchedulingPackage

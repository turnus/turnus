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
package turnus.model.analysis.scheduling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.scheduling.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingFactoryImpl extends EFactoryImpl implements SchedulingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulingFactory init() {
		try {
			SchedulingFactory theSchedulingFactory = (SchedulingFactory)EPackage.Registry.INSTANCE.getEFactory(SchedulingPackage.eNS_URI);
			if (theSchedulingFactory != null) {
				return theSchedulingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SchedulingPackage.ACTOR_FIRE: return createActorFire();
			case SchedulingPackage.FSM: return createFSM();
			case SchedulingPackage.SEQUENCE: return createSequence();
			case SchedulingPackage.FSM_VAR: return createFSMVar();
			case SchedulingPackage.FSM_TRANSITION: return createFSMTransition();
			case SchedulingPackage.FSM_STATE: return createFSMState();
			case SchedulingPackage.FSM_VAR_UPDATE: return createFSMVarUpdate();
			case SchedulingPackage.FSM_OPERATION: return createFSMOperation();
			case SchedulingPackage.FSM_COMBINATION: return createFSMCombination();
			case SchedulingPackage.FSM_CONDITION: return createFSMCondition();
			case SchedulingPackage.FSM_TRANSITION_WITH_STATE: return createFSMTransitionWithState();
			case SchedulingPackage.PARTITIONED_ACTOR_FIRE: return createPartitionedActorFire();
			case SchedulingPackage.MARKOV_SIMPLE_SCHEDULER_REPORT: return createMarkovSimpleSchedulerReport();
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER: return createMarkovPartitionScheduler();
			case SchedulingPackage.MARKOV_SCHEDULING_STATE: return createMarkovSchedulingState();
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION: return createMarkovSchedulingTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulingPackage.FSM_OP:
				return createFSMOpFromString(eDataType, initialValue);
			case SchedulingPackage.FSM_COMPARATOR:
				return createFSMComparatorFromString(eDataType, initialValue);
			case SchedulingPackage.FSM_COMBINATOR:
				return createFSMCombinatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulingPackage.FSM_OP:
				return convertFSMOpToString(eDataType, instanceValue);
			case SchedulingPackage.FSM_COMPARATOR:
				return convertFSMComparatorToString(eDataType, instanceValue);
			case SchedulingPackage.FSM_COMBINATOR:
				return convertFSMCombinatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorFire createActorFire() {
		ActorFireImpl actorFire = new ActorFireImpl();
		return actorFire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM createFSM() {
		FSMImpl fsm = new FSMImpl();
		return fsm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMVar createFSMVar() {
		FSMVarImpl fsmVar = new FSMVarImpl();
		return fsmVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMTransition createFSMTransition() {
		FSMTransitionImpl fsmTransition = new FSMTransitionImpl();
		return fsmTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMState createFSMState() {
		FSMStateImpl fsmState = new FSMStateImpl();
		return fsmState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMVarUpdate createFSMVarUpdate() {
		FSMVarUpdateImpl fsmVarUpdate = new FSMVarUpdateImpl();
		return fsmVarUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMOperation createFSMOperation() {
		FSMOperationImpl fsmOperation = new FSMOperationImpl();
		return fsmOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMCombination createFSMCombination() {
		FSMCombinationImpl fsmCombination = new FSMCombinationImpl();
		return fsmCombination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMCondition createFSMCondition() {
		FSMConditionImpl fsmCondition = new FSMConditionImpl();
		return fsmCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMTransitionWithState createFSMTransitionWithState() {
		FSMTransitionWithStateImpl fsmTransitionWithState = new FSMTransitionWithStateImpl();
		return fsmTransitionWithState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitionedActorFire createPartitionedActorFire() {
		PartitionedActorFireImpl partitionedActorFire = new PartitionedActorFireImpl();
		return partitionedActorFire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSimpleSchedulerReport createMarkovSimpleSchedulerReport() {
		MarkovSimpleSchedulerReportImpl markovSimpleSchedulerReport = new MarkovSimpleSchedulerReportImpl();
		return markovSimpleSchedulerReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovPartitionScheduler createMarkovPartitionScheduler() {
		MarkovPartitionSchedulerImpl markovPartitionScheduler = new MarkovPartitionSchedulerImpl();
		return markovPartitionScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingState createMarkovSchedulingState() {
		MarkovSchedulingStateImpl markovSchedulingState = new MarkovSchedulingStateImpl();
		return markovSchedulingState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovSchedulingTransition createMarkovSchedulingTransition() {
		MarkovSchedulingTransitionImpl markovSchedulingTransition = new MarkovSchedulingTransitionImpl();
		return markovSchedulingTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMOp createFSMOpFromString(EDataType eDataType, String initialValue) {
		FSMOp result = FSMOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFSMOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMComparator createFSMComparatorFromString(EDataType eDataType, String initialValue) {
		FSMComparator result = FSMComparator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFSMComparatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMCombinator createFSMCombinatorFromString(EDataType eDataType, String initialValue) {
		FSMCombinator result = FSMCombinator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFSMCombinatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPackage getSchedulingPackage() {
		return (SchedulingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulingPackage getPackage() {
		return SchedulingPackage.eINSTANCE;
	}

} //SchedulingFactoryImpl

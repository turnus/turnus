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
package turnus.model.analysis.scheduling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.postprocessing.PostProcessingData;

import turnus.model.analysis.scheduling.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.scheduling.SchedulingPackage
 * @generated
 */
public class SchedulingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SchedulingPackage.ACTOR_FIRE: {
				ActorFire actorFire = (ActorFire)theEObject;
				T result = caseActorFire(actorFire);
				if (result == null) result = caseActorSelectionSchedule(actorFire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM: {
				FSM fsm = (FSM)theEObject;
				T result = caseFSM(fsm);
				if (result == null) result = caseActorSelectionSchedule(fsm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.ACTOR_SELECTION_SCHEDULE: {
				ActorSelectionSchedule actorSelectionSchedule = (ActorSelectionSchedule)theEObject;
				T result = caseActorSelectionSchedule(actorSelectionSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseActorSelectionSchedule(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_VAR: {
				FSMVar fsmVar = (FSMVar)theEObject;
				T result = caseFSMVar(fsmVar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_TRANSITION: {
				FSMTransition fsmTransition = (FSMTransition)theEObject;
				T result = caseFSMTransition(fsmTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_STATE: {
				FSMState fsmState = (FSMState)theEObject;
				T result = caseFSMState(fsmState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_VAR_UPDATE: {
				FSMVarUpdate fsmVarUpdate = (FSMVarUpdate)theEObject;
				T result = caseFSMVarUpdate(fsmVarUpdate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_OPERATION: {
				FSMOperation fsmOperation = (FSMOperation)theEObject;
				T result = caseFSMOperation(fsmOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_COMBINATION: {
				FSMCombination fsmCombination = (FSMCombination)theEObject;
				T result = caseFSMCombination(fsmCombination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_CONDITION: {
				FSMCondition fsmCondition = (FSMCondition)theEObject;
				T result = caseFSMCondition(fsmCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.FSM_TRANSITION_WITH_STATE: {
				FSMTransitionWithState fsmTransitionWithState = (FSMTransitionWithState)theEObject;
				T result = caseFSMTransitionWithState(fsmTransitionWithState);
				if (result == null) result = caseFSMTransition(fsmTransitionWithState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.PARTITIONED_ACTOR_FIRE: {
				PartitionedActorFire partitionedActorFire = (PartitionedActorFire)theEObject;
				T result = casePartitionedActorFire(partitionedActorFire);
				if (result == null) result = caseActorFire(partitionedActorFire);
				if (result == null) result = caseActorSelectionSchedule(partitionedActorFire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.MARKOV_SIMPLE_SCHEDULER_REPORT: {
				MarkovSimpleSchedulerReport markovSimpleSchedulerReport = (MarkovSimpleSchedulerReport)theEObject;
				T result = caseMarkovSimpleSchedulerReport(markovSimpleSchedulerReport);
				if (result == null) result = caseAnalysisReport(markovSimpleSchedulerReport);
				if (result == null) result = casePostProcessingData(markovSimpleSchedulerReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.MARKOV_PARTITION_SCHEDULER: {
				MarkovPartitionScheduler markovPartitionScheduler = (MarkovPartitionScheduler)theEObject;
				T result = caseMarkovPartitionScheduler(markovPartitionScheduler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.MARKOV_SCHEDULING_STATE: {
				MarkovSchedulingState markovSchedulingState = (MarkovSchedulingState)theEObject;
				T result = caseMarkovSchedulingState(markovSchedulingState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulingPackage.MARKOV_SCHEDULING_TRANSITION: {
				MarkovSchedulingTransition markovSchedulingTransition = (MarkovSchedulingTransition)theEObject;
				T result = caseMarkovSchedulingTransition(markovSchedulingTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Fire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Fire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorFire(ActorFire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSM(FSM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Selection Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Selection Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorSelectionSchedule(ActorSelectionSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMVar(FSMVar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMTransition(FSMTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMState(FSMState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Var Update</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Var Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMVarUpdate(FSMVarUpdate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMOperation(FSMOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Combination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Combination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMCombination(FSMCombination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMCondition(FSMCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Transition With State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Transition With State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMTransitionWithState(FSMTransitionWithState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partitioned Actor Fire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partitioned Actor Fire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartitionedActorFire(PartitionedActorFire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markov Simple Scheduler Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markov Simple Scheduler Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkovSimpleSchedulerReport(MarkovSimpleSchedulerReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markov Partition Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markov Partition Scheduler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkovPartitionScheduler(MarkovPartitionScheduler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markov Scheduling State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markov Scheduling State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkovSchedulingState(MarkovSchedulingState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markov Scheduling Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markov Scheduling Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkovSchedulingTransition(MarkovSchedulingTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisReport(AnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostProcessingData(PostProcessingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SchedulingSwitch

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.scheduling.SchedulingPackage
 * @generated
 */
public interface SchedulingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulingFactory eINSTANCE = turnus.model.analysis.scheduling.impl.SchedulingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Actor Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Fire</em>'.
	 * @generated
	 */
	ActorFire createActorFire();

	/**
	 * Returns a new object of class '<em>FSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM</em>'.
	 * @generated
	 */
	FSM createFSM();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>FSM Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Var</em>'.
	 * @generated
	 */
	FSMVar createFSMVar();

	/**
	 * Returns a new object of class '<em>FSM Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Transition</em>'.
	 * @generated
	 */
	FSMTransition createFSMTransition();

	/**
	 * Returns a new object of class '<em>FSM State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM State</em>'.
	 * @generated
	 */
	FSMState createFSMState();

	/**
	 * Returns a new object of class '<em>FSM Var Update</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Var Update</em>'.
	 * @generated
	 */
	FSMVarUpdate createFSMVarUpdate();

	/**
	 * Returns a new object of class '<em>FSM Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Operation</em>'.
	 * @generated
	 */
	FSMOperation createFSMOperation();

	/**
	 * Returns a new object of class '<em>FSM Combination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Combination</em>'.
	 * @generated
	 */
	FSMCombination createFSMCombination();

	/**
	 * Returns a new object of class '<em>FSM Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Condition</em>'.
	 * @generated
	 */
	FSMCondition createFSMCondition();

	/**
	 * Returns a new object of class '<em>FSM Transition With State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Transition With State</em>'.
	 * @generated
	 */
	FSMTransitionWithState createFSMTransitionWithState();

	/**
	 * Returns a new object of class '<em>Partitioned Actor Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partitioned Actor Fire</em>'.
	 * @generated
	 */
	PartitionedActorFire createPartitionedActorFire();

	/**
	 * Returns a new object of class '<em>Markov Simple Scheduler Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markov Simple Scheduler Report</em>'.
	 * @generated
	 */
	MarkovSimpleSchedulerReport createMarkovSimpleSchedulerReport();

	/**
	 * Returns a new object of class '<em>Markov Partition Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markov Partition Scheduler</em>'.
	 * @generated
	 */
	MarkovPartitionScheduler createMarkovPartitionScheduler();

	/**
	 * Returns a new object of class '<em>Markov Scheduling State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markov Scheduling State</em>'.
	 * @generated
	 */
	MarkovSchedulingState createMarkovSchedulingState();

	/**
	 * Returns a new object of class '<em>Markov Scheduling Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markov Scheduling Transition</em>'.
	 * @generated
	 */
	MarkovSchedulingTransition createMarkovSchedulingTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulingPackage getSchedulingPackage();

} //SchedulingFactory

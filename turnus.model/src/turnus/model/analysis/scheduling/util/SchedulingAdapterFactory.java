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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.postprocessing.PostProcessingData;

import turnus.model.analysis.scheduling.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.scheduling.SchedulingPackage
 * @generated
 */
public class SchedulingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SchedulingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingSwitch<Adapter> modelSwitch =
		new SchedulingSwitch<Adapter>() {
			@Override
			public Adapter caseActorFire(ActorFire object) {
				return createActorFireAdapter();
			}
			@Override
			public Adapter caseFSM(FSM object) {
				return createFSMAdapter();
			}
			@Override
			public Adapter caseActorSelectionSchedule(ActorSelectionSchedule object) {
				return createActorSelectionScheduleAdapter();
			}
			@Override
			public Adapter caseSequence(Sequence object) {
				return createSequenceAdapter();
			}
			@Override
			public Adapter caseFSMVar(FSMVar object) {
				return createFSMVarAdapter();
			}
			@Override
			public Adapter caseFSMTransition(FSMTransition object) {
				return createFSMTransitionAdapter();
			}
			@Override
			public Adapter caseFSMState(FSMState object) {
				return createFSMStateAdapter();
			}
			@Override
			public Adapter caseFSMVarUpdate(FSMVarUpdate object) {
				return createFSMVarUpdateAdapter();
			}
			@Override
			public Adapter caseFSMOperation(FSMOperation object) {
				return createFSMOperationAdapter();
			}
			@Override
			public Adapter caseFSMCombination(FSMCombination object) {
				return createFSMCombinationAdapter();
			}
			@Override
			public Adapter caseFSMCondition(FSMCondition object) {
				return createFSMConditionAdapter();
			}
			@Override
			public Adapter caseFSMTransitionWithState(FSMTransitionWithState object) {
				return createFSMTransitionWithStateAdapter();
			}
			@Override
			public Adapter casePartitionedActorFire(PartitionedActorFire object) {
				return createPartitionedActorFireAdapter();
			}
			@Override
			public Adapter caseMarkovSimpleSchedulerReport(MarkovSimpleSchedulerReport object) {
				return createMarkovSimpleSchedulerReportAdapter();
			}
			@Override
			public Adapter caseMarkovPartitionScheduler(MarkovPartitionScheduler object) {
				return createMarkovPartitionSchedulerAdapter();
			}
			@Override
			public Adapter caseMarkovSchedulingState(MarkovSchedulingState object) {
				return createMarkovSchedulingStateAdapter();
			}
			@Override
			public Adapter caseMarkovSchedulingTransition(MarkovSchedulingTransition object) {
				return createMarkovSchedulingTransitionAdapter();
			}
			@Override
			public Adapter caseAnalysisReport(AnalysisReport object) {
				return createAnalysisReportAdapter();
			}
			@Override
			public Adapter casePostProcessingData(PostProcessingData object) {
				return createPostProcessingDataAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.ActorFire <em>Actor Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.ActorFire
	 * @generated
	 */
	public Adapter createActorFireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSM <em>FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSM
	 * @generated
	 */
	public Adapter createFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.ActorSelectionSchedule <em>Actor Selection Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.ActorSelectionSchedule
	 * @generated
	 */
	public Adapter createActorSelectionScheduleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMVar <em>FSM Var</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMVar
	 * @generated
	 */
	public Adapter createFSMVarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMTransition <em>FSM Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMTransition
	 * @generated
	 */
	public Adapter createFSMTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMState <em>FSM State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMState
	 * @generated
	 */
	public Adapter createFSMStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMVarUpdate <em>FSM Var Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMVarUpdate
	 * @generated
	 */
	public Adapter createFSMVarUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMOperation <em>FSM Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMOperation
	 * @generated
	 */
	public Adapter createFSMOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMCombination <em>FSM Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMCombination
	 * @generated
	 */
	public Adapter createFSMCombinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMCondition <em>FSM Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMCondition
	 * @generated
	 */
	public Adapter createFSMConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.FSMTransitionWithState <em>FSM Transition With State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.FSMTransitionWithState
	 * @generated
	 */
	public Adapter createFSMTransitionWithStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.PartitionedActorFire <em>Partitioned Actor Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.PartitionedActorFire
	 * @generated
	 */
	public Adapter createPartitionedActorFireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport <em>Markov Simple Scheduler Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport
	 * @generated
	 */
	public Adapter createMarkovSimpleSchedulerReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.MarkovPartitionScheduler <em>Markov Partition Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.MarkovPartitionScheduler
	 * @generated
	 */
	public Adapter createMarkovPartitionSchedulerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.MarkovSchedulingState <em>Markov Scheduling State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState
	 * @generated
	 */
	public Adapter createMarkovSchedulingStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition <em>Markov Scheduling Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition
	 * @generated
	 */
	public Adapter createMarkovSchedulingTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.AnalysisReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.AnalysisReport
	 * @generated
	 */
	public Adapter createAnalysisReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.PostProcessingData <em>Post Processing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.PostProcessingData
	 * @generated
	 */
	public Adapter createPostProcessingDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SchedulingAdapterFactory

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import turnus.model.analysis.AnalysisPackage;

import turnus.model.analysis.bottlenecks.BottlenecksPackage;

import turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl;

import turnus.model.analysis.buffers.BuffersPackage;

import turnus.model.analysis.buffers.impl.BuffersPackageImpl;

import turnus.model.analysis.impl.AnalysisPackageImpl;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.MapPackageImpl;

import turnus.model.analysis.partitioning.PartitioningPackage;

import turnus.model.analysis.partitioning.impl.PartitioningPackageImpl;

import turnus.model.analysis.pipelining.PipeliningPackage;

import turnus.model.analysis.pipelining.impl.PipeliningPackageImpl;

import turnus.model.analysis.postprocessing.PostprocessingPackage;

import turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl;

import turnus.model.analysis.profiler.ProfilerPackage;

import turnus.model.analysis.profiler.impl.ProfilerPackageImpl;

import turnus.model.analysis.profiling.ProfilingPackage;

import turnus.model.analysis.profiling.impl.ProfilingPackageImpl;

import turnus.model.analysis.scheduling.ActorFire;
import turnus.model.analysis.scheduling.ActorSelectionSchedule;
import turnus.model.analysis.scheduling.FSMCombination;
import turnus.model.analysis.scheduling.FSMCombinator;
import turnus.model.analysis.scheduling.FSMComparator;
import turnus.model.analysis.scheduling.FSMCondition;
import turnus.model.analysis.scheduling.FSMOp;
import turnus.model.analysis.scheduling.FSMOperation;
import turnus.model.analysis.scheduling.FSMState;
import turnus.model.analysis.scheduling.FSMTransition;
import turnus.model.analysis.scheduling.FSMTransitionWithState;
import turnus.model.analysis.scheduling.FSMVar;
import turnus.model.analysis.scheduling.FSMVarUpdate;
import turnus.model.analysis.scheduling.MarkovPartitionScheduler;
import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;
import turnus.model.analysis.scheduling.PartitionedActorFire;
import turnus.model.analysis.scheduling.SchedulingFactory;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.analysis.scheduling.Sequence;

import turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage;

import turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl;

import turnus.model.analysis.trace.TracePackage;

import turnus.model.analysis.trace.impl.TracePackageImpl;

import turnus.model.dataflow.DataflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulingPackageImpl extends EPackageImpl implements SchedulingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorFireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorSelectionScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmVarUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmCombinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmTransitionWithStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionedActorFireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markovSimpleSchedulerReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markovPartitionSchedulerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markovSchedulingStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markovSchedulingTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fsmOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fsmComparatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fsmCombinatorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulingPackageImpl() {
		super(eNS_URI, SchedulingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SchedulingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulingPackage init() {
		if (isInited) return (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);

		// Obtain or create and register package
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DataflowPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnalysisPackageImpl theAnalysisPackage = (AnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI) instanceof AnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI) : AnalysisPackage.eINSTANCE);
		ProfilerPackageImpl theProfilerPackage = (ProfilerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI) instanceof ProfilerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI) : ProfilerPackage.eINSTANCE);
		MapPackageImpl theMapPackage = (MapPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI) instanceof MapPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI) : MapPackage.eINSTANCE);
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) : TracePackage.eINSTANCE);
		BottlenecksPackageImpl theBottlenecksPackage = (BottlenecksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI) instanceof BottlenecksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI) : BottlenecksPackage.eINSTANCE);
		BuffersPackageImpl theBuffersPackage = (BuffersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BuffersPackage.eNS_URI) instanceof BuffersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BuffersPackage.eNS_URI) : BuffersPackage.eINSTANCE);
		PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI) instanceof PartitioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI) : PartitioningPackage.eINSTANCE);
		PipeliningPackageImpl thePipeliningPackage = (PipeliningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI) instanceof PipeliningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI) : PipeliningPackage.eINSTANCE);
		PostprocessingPackageImpl thePostprocessingPackage = (PostprocessingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) instanceof PostprocessingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) : PostprocessingPackage.eINSTANCE);
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) instanceof ProfilingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) : ProfilingPackage.eINSTANCE);
		CaseoptimalPackageImpl theCaseoptimalPackage = (CaseoptimalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CaseoptimalPackage.eNS_URI) instanceof CaseoptimalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CaseoptimalPackage.eNS_URI) : CaseoptimalPackage.eINSTANCE);

		// Create package meta-data objects
		theSchedulingPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theCaseoptimalPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulingPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theCaseoptimalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulingPackage.eNS_URI, theSchedulingPackage);
		return theSchedulingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorFire() {
		return actorFireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorFire_Actor() {
		return (EAttribute)actorFireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorFire_Times() {
		return (EAttribute)actorFireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorFire_Partition() {
		return (EAttribute)actorFireEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorFire_DependencyPartitions() {
		return (EAttribute)actorFireEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSM() {
		return fsmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSM_States() {
		return (EReference)fsmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSM_Vars() {
		return (EReference)fsmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSM_StartState() {
		return (EAttribute)fsmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSM_TerminalState() {
		return (EAttribute)fsmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorSelectionSchedule() {
		return actorSelectionScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_Actions() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMVar() {
		return fsmVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMVar_Name() {
		return (EAttribute)fsmVarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMVar_InitialVal() {
		return (EAttribute)fsmVarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMVar_Type() {
		return (EAttribute)fsmVarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMTransition() {
		return fsmTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMTransition_Cond() {
		return (EReference)fsmTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMTransition_TargetStateEnumName() {
		return (EAttribute)fsmTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMTransition_SourceStateEnumName() {
		return (EAttribute)fsmTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMTransition_TransitionSchedule() {
		return (EReference)fsmTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMState() {
		return fsmStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMState_EnumName() {
		return (EAttribute)fsmStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMState_VarUpdates() {
		return (EReference)fsmStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMState_Transitions() {
		return (EReference)fsmStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMVarUpdate() {
		return fsmVarUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMVarUpdate_Operation() {
		return (EReference)fsmVarUpdateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMVarUpdate_Condition() {
		return (EReference)fsmVarUpdateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMOperation() {
		return fsmOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMOperation_Op() {
		return (EAttribute)fsmOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMOperation_Val() {
		return (EAttribute)fsmOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMOperation_Var() {
		return (EAttribute)fsmOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMCombination() {
		return fsmCombinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMCombination_Combinator() {
		return (EAttribute)fsmCombinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMCombination_Cond() {
		return (EReference)fsmCombinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMCondition() {
		return fsmConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMCondition_Comp() {
		return (EAttribute)fsmConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMCondition_Compval() {
		return (EAttribute)fsmConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMCondition_CombinedCond() {
		return (EReference)fsmConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMCondition_ValName() {
		return (EAttribute)fsmConditionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMTransitionWithState() {
		return fsmTransitionWithStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMTransitionWithState_VarStates() {
		return (EReference)fsmTransitionWithStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartitionedActorFire() {
		return partitionedActorFireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkovSimpleSchedulerReport() {
		return markovSimpleSchedulerReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSimpleSchedulerReport_Partitions() {
		return (EReference)markovSimpleSchedulerReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSimpleSchedulerReport_Network() {
		return (EReference)markovSimpleSchedulerReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkovPartitionScheduler() {
		return markovPartitionSchedulerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovPartitionScheduler_Actors() {
		return (EReference)markovPartitionSchedulerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkovPartitionScheduler_PartitionId() {
		return (EAttribute)markovPartitionSchedulerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovPartitionScheduler_States() {
		return (EReference)markovPartitionSchedulerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovPartitionScheduler_Transitions() {
		return (EReference)markovPartitionSchedulerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMarkovPartitionScheduler__GetAssociatedState__Actor() {
		return markovPartitionSchedulerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkovSchedulingState() {
		return markovSchedulingStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSchedulingState_Actor() {
		return (EReference)markovSchedulingStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkovSchedulingState_Firings() {
		return (EAttribute)markovSchedulingStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSchedulingState_Outgoings() {
		return (EReference)markovSchedulingStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSchedulingState_Incomings() {
		return (EReference)markovSchedulingStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkovSchedulingState_Name() {
		return (EAttribute)markovSchedulingStateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkovSchedulingTransition() {
		return markovSchedulingTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSchedulingTransition_Source() {
		return (EReference)markovSchedulingTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkovSchedulingTransition_Target() {
		return (EReference)markovSchedulingTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkovSchedulingTransition_Firings() {
		return (EAttribute)markovSchedulingTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarkovSchedulingTransition_Name() {
		return (EAttribute)markovSchedulingTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFSMOp() {
		return fsmOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFSMComparator() {
		return fsmComparatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFSMCombinator() {
		return fsmCombinatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingFactory getSchedulingFactory() {
		return (SchedulingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		actorFireEClass = createEClass(ACTOR_FIRE);
		createEAttribute(actorFireEClass, ACTOR_FIRE__ACTOR);
		createEAttribute(actorFireEClass, ACTOR_FIRE__TIMES);
		createEAttribute(actorFireEClass, ACTOR_FIRE__PARTITION);
		createEAttribute(actorFireEClass, ACTOR_FIRE__DEPENDENCY_PARTITIONS);

		fsmEClass = createEClass(FSM);
		createEReference(fsmEClass, FSM__STATES);
		createEReference(fsmEClass, FSM__VARS);
		createEAttribute(fsmEClass, FSM__START_STATE);
		createEAttribute(fsmEClass, FSM__TERMINAL_STATE);

		actorSelectionScheduleEClass = createEClass(ACTOR_SELECTION_SCHEDULE);

		sequenceEClass = createEClass(SEQUENCE);
		createEReference(sequenceEClass, SEQUENCE__ACTIONS);

		fsmVarEClass = createEClass(FSM_VAR);
		createEAttribute(fsmVarEClass, FSM_VAR__NAME);
		createEAttribute(fsmVarEClass, FSM_VAR__INITIAL_VAL);
		createEAttribute(fsmVarEClass, FSM_VAR__TYPE);

		fsmTransitionEClass = createEClass(FSM_TRANSITION);
		createEReference(fsmTransitionEClass, FSM_TRANSITION__COND);
		createEAttribute(fsmTransitionEClass, FSM_TRANSITION__TARGET_STATE_ENUM_NAME);
		createEAttribute(fsmTransitionEClass, FSM_TRANSITION__SOURCE_STATE_ENUM_NAME);
		createEReference(fsmTransitionEClass, FSM_TRANSITION__TRANSITION_SCHEDULE);

		fsmStateEClass = createEClass(FSM_STATE);
		createEAttribute(fsmStateEClass, FSM_STATE__ENUM_NAME);
		createEReference(fsmStateEClass, FSM_STATE__VAR_UPDATES);
		createEReference(fsmStateEClass, FSM_STATE__TRANSITIONS);

		fsmVarUpdateEClass = createEClass(FSM_VAR_UPDATE);
		createEReference(fsmVarUpdateEClass, FSM_VAR_UPDATE__OPERATION);
		createEReference(fsmVarUpdateEClass, FSM_VAR_UPDATE__CONDITION);

		fsmOperationEClass = createEClass(FSM_OPERATION);
		createEAttribute(fsmOperationEClass, FSM_OPERATION__OP);
		createEAttribute(fsmOperationEClass, FSM_OPERATION__VAL);
		createEAttribute(fsmOperationEClass, FSM_OPERATION__VAR);

		fsmCombinationEClass = createEClass(FSM_COMBINATION);
		createEAttribute(fsmCombinationEClass, FSM_COMBINATION__COMBINATOR);
		createEReference(fsmCombinationEClass, FSM_COMBINATION__COND);

		fsmConditionEClass = createEClass(FSM_CONDITION);
		createEAttribute(fsmConditionEClass, FSM_CONDITION__COMP);
		createEAttribute(fsmConditionEClass, FSM_CONDITION__COMPVAL);
		createEReference(fsmConditionEClass, FSM_CONDITION__COMBINED_COND);
		createEAttribute(fsmConditionEClass, FSM_CONDITION__VAL_NAME);

		fsmTransitionWithStateEClass = createEClass(FSM_TRANSITION_WITH_STATE);
		createEReference(fsmTransitionWithStateEClass, FSM_TRANSITION_WITH_STATE__VAR_STATES);

		partitionedActorFireEClass = createEClass(PARTITIONED_ACTOR_FIRE);

		markovSimpleSchedulerReportEClass = createEClass(MARKOV_SIMPLE_SCHEDULER_REPORT);
		createEReference(markovSimpleSchedulerReportEClass, MARKOV_SIMPLE_SCHEDULER_REPORT__PARTITIONS);
		createEReference(markovSimpleSchedulerReportEClass, MARKOV_SIMPLE_SCHEDULER_REPORT__NETWORK);

		markovPartitionSchedulerEClass = createEClass(MARKOV_PARTITION_SCHEDULER);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__ACTORS);
		createEAttribute(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__PARTITION_ID);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__STATES);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__TRANSITIONS);
		createEOperation(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER___GET_ASSOCIATED_STATE__ACTOR);

		markovSchedulingStateEClass = createEClass(MARKOV_SCHEDULING_STATE);
		createEReference(markovSchedulingStateEClass, MARKOV_SCHEDULING_STATE__ACTOR);
		createEAttribute(markovSchedulingStateEClass, MARKOV_SCHEDULING_STATE__FIRINGS);
		createEReference(markovSchedulingStateEClass, MARKOV_SCHEDULING_STATE__OUTGOINGS);
		createEReference(markovSchedulingStateEClass, MARKOV_SCHEDULING_STATE__INCOMINGS);
		createEAttribute(markovSchedulingStateEClass, MARKOV_SCHEDULING_STATE__NAME);

		markovSchedulingTransitionEClass = createEClass(MARKOV_SCHEDULING_TRANSITION);
		createEReference(markovSchedulingTransitionEClass, MARKOV_SCHEDULING_TRANSITION__SOURCE);
		createEReference(markovSchedulingTransitionEClass, MARKOV_SCHEDULING_TRANSITION__TARGET);
		createEAttribute(markovSchedulingTransitionEClass, MARKOV_SCHEDULING_TRANSITION__FIRINGS);
		createEAttribute(markovSchedulingTransitionEClass, MARKOV_SCHEDULING_TRANSITION__NAME);

		// Create enums
		fsmOpEEnum = createEEnum(FSM_OP);
		fsmComparatorEEnum = createEEnum(FSM_COMPARATOR);
		fsmCombinatorEEnum = createEEnum(FSM_COMBINATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CaseoptimalPackage theCaseoptimalPackage = (CaseoptimalPackage)EPackage.Registry.INSTANCE.getEPackage(CaseoptimalPackage.eNS_URI);
		MapPackage theMapPackage = (MapPackage)EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);
		AnalysisPackage theAnalysisPackage = (AnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);
		PostprocessingPackage thePostprocessingPackage = (PostprocessingPackage)EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);
		DataflowPackage theDataflowPackage = (DataflowPackage)EPackage.Registry.INSTANCE.getEPackage(DataflowPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCaseoptimalPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actorFireEClass.getESuperTypes().add(this.getActorSelectionSchedule());
		fsmEClass.getESuperTypes().add(this.getActorSelectionSchedule());
		sequenceEClass.getESuperTypes().add(this.getActorSelectionSchedule());
		fsmTransitionWithStateEClass.getESuperTypes().add(this.getFSMTransition());
		partitionedActorFireEClass.getESuperTypes().add(this.getActorFire());
		markovSimpleSchedulerReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		markovSimpleSchedulerReportEClass.getESuperTypes().add(thePostprocessingPackage.getPostProcessingData());

		// Initialize classes, features, and operations; add parameters
		initEClass(actorFireEClass, ActorFire.class, "ActorFire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActorFire_Actor(), ecorePackage.getEString(), "Actor", null, 0, 1, ActorFire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorFire_Times(), ecorePackage.getEInt(), "Times", null, 0, 1, ActorFire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorFire_Partition(), ecorePackage.getEIntegerObject(), "partition", null, 0, 1, ActorFire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorFire_DependencyPartitions(), ecorePackage.getEIntegerObject(), "dependencyPartitions", null, 0, -1, ActorFire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmEClass, turnus.model.analysis.scheduling.FSM.class, "FSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFSM_States(), this.getFSMState(), null, "states", null, 0, -1, turnus.model.analysis.scheduling.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSM_Vars(), this.getFSMVar(), null, "vars", null, 0, -1, turnus.model.analysis.scheduling.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSM_StartState(), ecorePackage.getEString(), "startState", null, 0, 1, turnus.model.analysis.scheduling.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSM_TerminalState(), ecorePackage.getEString(), "terminalState", null, 0, 1, turnus.model.analysis.scheduling.FSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorSelectionScheduleEClass, ActorSelectionSchedule.class, "ActorSelectionSchedule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequence_Actions(), this.getActorFire(), null, "actions", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmVarEClass, FSMVar.class, "FSMVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMVar_Name(), ecorePackage.getEString(), "name", null, 1, 1, FSMVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMVar_InitialVal(), ecorePackage.getEString(), "initialVal", null, 1, 1, FSMVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMVar_Type(), ecorePackage.getEString(), "type", null, 1, 1, FSMVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmTransitionEClass, FSMTransition.class, "FSMTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFSMTransition_Cond(), this.getFSMCondition(), null, "cond", null, 0, 1, FSMTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMTransition_TargetStateEnumName(), ecorePackage.getEString(), "targetStateEnumName", null, 0, 1, FSMTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMTransition_SourceStateEnumName(), ecorePackage.getEString(), "sourceStateEnumName", null, 0, 1, FSMTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMTransition_TransitionSchedule(), this.getSequence(), null, "transitionSchedule", null, 0, 1, FSMTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmStateEClass, FSMState.class, "FSMState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMState_EnumName(), ecorePackage.getEString(), "enumName", null, 0, 1, FSMState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMState_VarUpdates(), this.getFSMVarUpdate(), null, "varUpdates", null, 0, -1, FSMState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMState_Transitions(), this.getFSMTransition(), null, "transitions", null, 0, -1, FSMState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmVarUpdateEClass, FSMVarUpdate.class, "FSMVarUpdate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFSMVarUpdate_Operation(), this.getFSMOperation(), null, "operation", null, 0, 1, FSMVarUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMVarUpdate_Condition(), this.getFSMCondition(), null, "condition", null, 0, 1, FSMVarUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmOperationEClass, FSMOperation.class, "FSMOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMOperation_Op(), this.getFSMOp(), "op", null, 0, 1, FSMOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMOperation_Val(), ecorePackage.getEIntegerObject(), "val", null, 0, 1, FSMOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMOperation_Var(), ecorePackage.getEString(), "var", null, 0, 1, FSMOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmCombinationEClass, FSMCombination.class, "FSMCombination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMCombination_Combinator(), this.getFSMCombinator(), "combinator", null, 0, 1, FSMCombination.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMCombination_Cond(), this.getFSMCondition(), null, "cond", null, 0, 1, FSMCombination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmConditionEClass, FSMCondition.class, "FSMCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMCondition_Comp(), this.getFSMComparator(), "comp", "EQ", 0, 1, FSMCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMCondition_Compval(), ecorePackage.getEIntegerObject(), "compval", "0", 0, 1, FSMCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMCondition_CombinedCond(), this.getFSMCombination(), null, "combinedCond", null, 0, 1, FSMCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFSMCondition_ValName(), ecorePackage.getEString(), "valName", null, 0, 1, FSMCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmTransitionWithStateEClass, FSMTransitionWithState.class, "FSMTransitionWithState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFSMTransitionWithState_VarStates(), theMapPackage.getStringToIntegerMap(), null, "varStates", null, 0, -1, FSMTransitionWithState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partitionedActorFireEClass, PartitionedActorFire.class, "PartitionedActorFire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(markovSimpleSchedulerReportEClass, MarkovSimpleSchedulerReport.class, "MarkovSimpleSchedulerReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovSimpleSchedulerReport_Partitions(), this.getMarkovPartitionScheduler(), null, "partitions", null, 0, -1, MarkovSimpleSchedulerReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovSimpleSchedulerReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, MarkovSimpleSchedulerReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markovPartitionSchedulerEClass, MarkovPartitionScheduler.class, "MarkovPartitionScheduler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovPartitionScheduler_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovPartitionScheduler_PartitionId(), ecorePackage.getEString(), "partitionId", null, 0, 1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovPartitionScheduler_States(), this.getMarkovSchedulingState(), null, "states", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovPartitionScheduler_Transitions(), this.getMarkovSchedulingTransition(), null, "transitions", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMarkovPartitionScheduler__GetAssociatedState__Actor(), this.getMarkovSchedulingState(), "getAssociatedState", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataflowPackage.getActor(), "actor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(markovSchedulingStateEClass, MarkovSchedulingState.class, "MarkovSchedulingState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovSchedulingState_Actor(), theDataflowPackage.getActor(), null, "actor", null, 1, 1, MarkovSchedulingState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovSchedulingState_Firings(), ecorePackage.getELong(), "firings", null, 0, 1, MarkovSchedulingState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovSchedulingState_Outgoings(), this.getMarkovSchedulingTransition(), this.getMarkovSchedulingTransition_Source(), "outgoings", null, 0, -1, MarkovSchedulingState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovSchedulingState_Incomings(), this.getMarkovSchedulingTransition(), this.getMarkovSchedulingTransition_Target(), "incomings", null, 0, -1, MarkovSchedulingState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovSchedulingState_Name(), ecorePackage.getEString(), "name", null, 0, 1, MarkovSchedulingState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markovSchedulingTransitionEClass, MarkovSchedulingTransition.class, "MarkovSchedulingTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovSchedulingTransition_Source(), this.getMarkovSchedulingState(), this.getMarkovSchedulingState_Outgoings(), "source", null, 1, 1, MarkovSchedulingTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovSchedulingTransition_Target(), this.getMarkovSchedulingState(), this.getMarkovSchedulingState_Incomings(), "target", null, 1, 1, MarkovSchedulingTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovSchedulingTransition_Firings(), ecorePackage.getELong(), "firings", null, 0, 1, MarkovSchedulingTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovSchedulingTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1, MarkovSchedulingTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(fsmOpEEnum, FSMOp.class, "FSMOp");
		addEEnumLiteral(fsmOpEEnum, FSMOp.ADD);
		addEEnumLiteral(fsmOpEEnum, FSMOp.SET);

		initEEnum(fsmComparatorEEnum, FSMComparator.class, "FSMComparator");
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.EQ);
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.NEQ);
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.GREATER);
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.SMALLER);
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.GREQ);
		addEEnumLiteral(fsmComparatorEEnum, FSMComparator.SMEQ);

		initEEnum(fsmCombinatorEEnum, FSMCombinator.class, "FSMCombinator");
		addEEnumLiteral(fsmCombinatorEEnum, FSMCombinator.AND);
		addEEnumLiteral(fsmCombinatorEEnum, FSMCombinator.OR);
		addEEnumLiteral(fsmCombinatorEEnum, FSMCombinator.NAND);
		addEEnumLiteral(fsmCombinatorEEnum, FSMCombinator.NOR);
		addEEnumLiteral(fsmCombinatorEEnum, FSMCombinator.NOT);
	}

} //SchedulingPackageImpl

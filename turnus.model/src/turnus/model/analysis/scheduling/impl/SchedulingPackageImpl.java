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

import turnus.model.analysis.scheduling.MarkovPartitionScheduler;
import turnus.model.analysis.scheduling.MarkovSchedulingState;
import turnus.model.analysis.scheduling.MarkovSchedulingTransition;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;
import turnus.model.analysis.scheduling.SchedulingFactory;
import turnus.model.analysis.scheduling.SchedulingPackage;

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
		markovSimpleSchedulerReportEClass = createEClass(MARKOV_SIMPLE_SCHEDULER_REPORT);
		createEReference(markovSimpleSchedulerReportEClass, MARKOV_SIMPLE_SCHEDULER_REPORT__PARTITIONS);
		createEReference(markovSimpleSchedulerReportEClass, MARKOV_SIMPLE_SCHEDULER_REPORT__NETWORK);

		markovPartitionSchedulerEClass = createEClass(MARKOV_PARTITION_SCHEDULER);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__ACTORS);
		createEAttribute(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__PARTITION_ID);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__STATES);
		createEReference(markovPartitionSchedulerEClass, MARKOV_PARTITION_SCHEDULER__TRANSITIONS);

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
		AnalysisPackage theAnalysisPackage = (AnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);
		PostprocessingPackage thePostprocessingPackage = (PostprocessingPackage)EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);
		DataflowPackage theDataflowPackage = (DataflowPackage)EPackage.Registry.INSTANCE.getEPackage(DataflowPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		markovSimpleSchedulerReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		markovSimpleSchedulerReportEClass.getESuperTypes().add(thePostprocessingPackage.getPostProcessingData());

		// Initialize classes, features, and operations; add parameters
		initEClass(markovSimpleSchedulerReportEClass, MarkovSimpleSchedulerReport.class, "MarkovSimpleSchedulerReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovSimpleSchedulerReport_Partitions(), this.getMarkovPartitionScheduler(), null, "partitions", null, 0, -1, MarkovSimpleSchedulerReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovSimpleSchedulerReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, MarkovSimpleSchedulerReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markovPartitionSchedulerEClass, MarkovPartitionScheduler.class, "MarkovPartitionScheduler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovPartitionScheduler_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovPartitionScheduler_PartitionId(), ecorePackage.getEString(), "partitionId", null, 0, 1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovPartitionScheduler_States(), this.getMarkovSchedulingState(), null, "states", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovPartitionScheduler_Transitions(), this.getMarkovSchedulingTransition(), null, "transitions", null, 0, -1, MarkovPartitionScheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
	}

} //SchedulingPackageImpl

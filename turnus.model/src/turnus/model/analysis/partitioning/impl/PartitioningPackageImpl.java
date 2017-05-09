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
package turnus.model.analysis.partitioning.impl;

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

import turnus.model.analysis.partitioning.BalancedPipelinePartition;
import turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport;
import turnus.model.analysis.partitioning.ComCostPartition;
import turnus.model.analysis.partitioning.ComCostPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.analysis.partitioning.PartitioningPackage;

import turnus.model.analysis.partitioning.WorkloadBalancePartition;
import turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport;
import turnus.model.analysis.pipelining.PipeliningPackage;
import turnus.model.analysis.pipelining.impl.PipeliningPackageImpl;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl;
import turnus.model.analysis.profiler.ProfilerPackage;

import turnus.model.analysis.profiler.impl.ProfilerPackageImpl;

import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.analysis.profiling.impl.ProfilingPackageImpl;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.analysis.scheduling.impl.SchedulingPackageImpl;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.analysis.trace.impl.TracePackageImpl;

import turnus.model.dataflow.DataflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartitioningPackageImpl extends EPackageImpl implements PartitioningPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comCostPartitioningReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comCostPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workloadBalancePartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workloadBalancePartitioningReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass balancedPipelinePartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass balancedPipelinePartitioningReportEClass = null;

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
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PartitioningPackageImpl() {
		super(eNS_URI, PartitioningFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PartitioningPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PartitioningPackage init() {
		if (isInited) return (PartitioningPackage)EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);

		// Obtain or create and register package
		PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PartitioningPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PartitioningPackageImpl());

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
		PipeliningPackageImpl thePipeliningPackage = (PipeliningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI) instanceof PipeliningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI) : PipeliningPackage.eINSTANCE);
		PostprocessingPackageImpl thePostprocessingPackage = (PostprocessingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) instanceof PostprocessingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) : PostprocessingPackage.eINSTANCE);
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) instanceof ProfilingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) : ProfilingPackage.eINSTANCE);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);

		// Create package meta-data objects
		thePartitioningPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		thePartitioningPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePartitioningPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PartitioningPackage.eNS_URI, thePartitioningPackage);
		return thePartitioningPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComCostPartitioningReport() {
		return comCostPartitioningReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCostPartitioningReport_Network() {
		return (EReference)comCostPartitioningReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComCostPartitioningReport_BitAccurate() {
		return (EAttribute)comCostPartitioningReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCostPartitioningReport_Partitions() {
		return (EReference)comCostPartitioningReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComCostPartition() {
		return comCostPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCostPartition_Actors() {
		return (EReference)comCostPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCostPartition_InternalCostMap() {
		return (EReference)comCostPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComCostPartition_ExternalCostMap() {
		return (EReference)comCostPartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComCostPartition_InternalCost() {
		return (EAttribute)comCostPartitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComCostPartition_ExternalCost() {
		return (EAttribute)comCostPartitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkloadBalancePartition() {
		return workloadBalancePartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkloadBalancePartition_Actors() {
		return (EReference)workloadBalancePartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkloadBalancePartition_Workload() {
		return (EAttribute)workloadBalancePartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkloadBalancePartitioningReport() {
		return workloadBalancePartitioningReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkloadBalancePartitioningReport_Network() {
		return (EReference)workloadBalancePartitioningReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkloadBalancePartitioningReport_Partitions() {
		return (EReference)workloadBalancePartitioningReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBalancedPipelinePartition() {
		return balancedPipelinePartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBalancedPipelinePartition_Actors() {
		return (EReference)balancedPipelinePartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancedPipelinePartition_Workload() {
		return (EAttribute)balancedPipelinePartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancedPipelinePartition_PreWorkload() {
		return (EAttribute)balancedPipelinePartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBalancedPipelinePartition_CommonPredAvg() {
		return (EAttribute)balancedPipelinePartitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBalancedPipelinePartitioningReport() {
		return balancedPipelinePartitioningReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBalancedPipelinePartitioningReport_Partitions() {
		return (EReference)balancedPipelinePartitioningReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBalancedPipelinePartitioningReport_Network() {
		return (EReference)balancedPipelinePartitioningReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningFactory getPartitioningFactory() {
		return (PartitioningFactory)getEFactoryInstance();
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
		comCostPartitioningReportEClass = createEClass(COM_COST_PARTITIONING_REPORT);
		createEReference(comCostPartitioningReportEClass, COM_COST_PARTITIONING_REPORT__NETWORK);
		createEAttribute(comCostPartitioningReportEClass, COM_COST_PARTITIONING_REPORT__BIT_ACCURATE);
		createEReference(comCostPartitioningReportEClass, COM_COST_PARTITIONING_REPORT__PARTITIONS);

		comCostPartitionEClass = createEClass(COM_COST_PARTITION);
		createEReference(comCostPartitionEClass, COM_COST_PARTITION__ACTORS);
		createEReference(comCostPartitionEClass, COM_COST_PARTITION__INTERNAL_COST_MAP);
		createEReference(comCostPartitionEClass, COM_COST_PARTITION__EXTERNAL_COST_MAP);
		createEAttribute(comCostPartitionEClass, COM_COST_PARTITION__INTERNAL_COST);
		createEAttribute(comCostPartitionEClass, COM_COST_PARTITION__EXTERNAL_COST);

		workloadBalancePartitionEClass = createEClass(WORKLOAD_BALANCE_PARTITION);
		createEReference(workloadBalancePartitionEClass, WORKLOAD_BALANCE_PARTITION__ACTORS);
		createEAttribute(workloadBalancePartitionEClass, WORKLOAD_BALANCE_PARTITION__WORKLOAD);

		workloadBalancePartitioningReportEClass = createEClass(WORKLOAD_BALANCE_PARTITIONING_REPORT);
		createEReference(workloadBalancePartitioningReportEClass, WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK);
		createEReference(workloadBalancePartitioningReportEClass, WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS);

		balancedPipelinePartitionEClass = createEClass(BALANCED_PIPELINE_PARTITION);
		createEReference(balancedPipelinePartitionEClass, BALANCED_PIPELINE_PARTITION__ACTORS);
		createEAttribute(balancedPipelinePartitionEClass, BALANCED_PIPELINE_PARTITION__WORKLOAD);
		createEAttribute(balancedPipelinePartitionEClass, BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD);
		createEAttribute(balancedPipelinePartitionEClass, BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG);

		balancedPipelinePartitioningReportEClass = createEClass(BALANCED_PIPELINE_PARTITIONING_REPORT);
		createEReference(balancedPipelinePartitioningReportEClass, BALANCED_PIPELINE_PARTITIONING_REPORT__PARTITIONS);
		createEReference(balancedPipelinePartitioningReportEClass, BALANCED_PIPELINE_PARTITIONING_REPORT__NETWORK);
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
		DataflowPackage theDataflowPackage = (DataflowPackage)EPackage.Registry.INSTANCE.getEPackage(DataflowPackage.eNS_URI);
		MapPackage theMapPackage = (MapPackage)EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		comCostPartitioningReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		workloadBalancePartitioningReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		balancedPipelinePartitioningReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(comCostPartitioningReportEClass, ComCostPartitioningReport.class, "ComCostPartitioningReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComCostPartitioningReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ComCostPartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComCostPartitioningReport_BitAccurate(), ecorePackage.getEBoolean(), "bitAccurate", null, 0, 1, ComCostPartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComCostPartitioningReport_Partitions(), this.getComCostPartition(), null, "partitions", null, 0, -1, ComCostPartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comCostPartitionEClass, ComCostPartition.class, "ComCostPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComCostPartition_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, ComCostPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComCostPartition_InternalCostMap(), theMapPackage.getActorToLongMap(), null, "internalCostMap", null, 0, -1, ComCostPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComCostPartition_ExternalCostMap(), theMapPackage.getActorToLongMap(), null, "externalCostMap", null, 0, -1, ComCostPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComCostPartition_InternalCost(), ecorePackage.getELong(), "internalCost", null, 0, 1, ComCostPartition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getComCostPartition_ExternalCost(), ecorePackage.getELong(), "externalCost", null, 0, 1, ComCostPartition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(workloadBalancePartitionEClass, WorkloadBalancePartition.class, "WorkloadBalancePartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkloadBalancePartition_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, WorkloadBalancePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkloadBalancePartition_Workload(), ecorePackage.getEDouble(), "workload", null, 0, 1, WorkloadBalancePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workloadBalancePartitioningReportEClass, WorkloadBalancePartitioningReport.class, "WorkloadBalancePartitioningReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkloadBalancePartitioningReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, WorkloadBalancePartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkloadBalancePartitioningReport_Partitions(), this.getWorkloadBalancePartition(), null, "partitions", null, 0, -1, WorkloadBalancePartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(balancedPipelinePartitionEClass, BalancedPipelinePartition.class, "BalancedPipelinePartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBalancedPipelinePartition_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, BalancedPipelinePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBalancedPipelinePartition_Workload(), ecorePackage.getEDouble(), "workload", null, 0, 1, BalancedPipelinePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBalancedPipelinePartition_PreWorkload(), ecorePackage.getEDouble(), "preWorkload", null, 0, 1, BalancedPipelinePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBalancedPipelinePartition_CommonPredAvg(), ecorePackage.getEDouble(), "commonPredAvg", null, 0, 1, BalancedPipelinePartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(balancedPipelinePartitioningReportEClass, BalancedPipelinePartitioningReport.class, "BalancedPipelinePartitioningReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBalancedPipelinePartitioningReport_Partitions(), this.getBalancedPipelinePartition(), null, "partitions", null, 0, -1, BalancedPipelinePartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBalancedPipelinePartitioningReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, BalancedPipelinePartitioningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PartitioningPackageImpl

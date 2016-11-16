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
package turnus.model.analysis.pipelining.impl;

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

import turnus.model.analysis.pipelining.ActionVariablePipeliningData;
import turnus.model.analysis.pipelining.ActionsVariablePipeliningReport;
import turnus.model.analysis.pipelining.ImpactAnalysisData;
import turnus.model.analysis.pipelining.ImpactAnalysisReport;
import turnus.model.analysis.pipelining.PipeliningFactory;
import turnus.model.analysis.pipelining.PipeliningPackage;

import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.impl.PostprocessingPackageImpl;
import turnus.model.analysis.profiler.ProfilerPackage;

import turnus.model.analysis.profiler.impl.ProfilerPackageImpl;

import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.analysis.profiling.impl.ProfilingPackageImpl;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.analysis.trace.impl.TracePackageImpl;

import turnus.model.common.CommonPackage;

import turnus.model.dataflow.DataflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeliningPackageImpl extends EPackageImpl implements PipeliningPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionsVariablePipeliningReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionVariablePipeliningDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactAnalysisReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactAnalysisDataEClass = null;

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
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PipeliningPackageImpl() {
		super(eNS_URI, PipeliningFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PipeliningPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PipeliningPackage init() {
		if (isInited) return (PipeliningPackage)EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI);

		// Obtain or create and register package
		PipeliningPackageImpl thePipeliningPackage = (PipeliningPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PipeliningPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PipeliningPackageImpl());

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
		PostprocessingPackageImpl thePostprocessingPackage = (PostprocessingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) instanceof PostprocessingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI) : PostprocessingPackage.eINSTANCE);
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) instanceof ProfilingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) : ProfilingPackage.eINSTANCE);

		// Create package meta-data objects
		thePipeliningPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();

		// Initialize created meta-data
		thePipeliningPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePipeliningPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PipeliningPackage.eNS_URI, thePipeliningPackage);
		return thePipeliningPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionsVariablePipeliningReport() {
		return actionsVariablePipeliningReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionsVariablePipeliningReport_Network() {
		return (EReference)actionsVariablePipeliningReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionsVariablePipeliningReport_ActionsData() {
		return (EReference)actionsVariablePipeliningReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionVariablePipeliningData() {
		return actionVariablePipeliningDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionVariablePipeliningData_Action() {
		return (EReference)actionVariablePipeliningDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionVariablePipeliningData_ConsecutiveFirings() {
		return (EReference)actionVariablePipeliningDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionVariablePipeliningData_PipelinableFirings() {
		return (EReference)actionVariablePipeliningDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionVariablePipeliningData_Pipelinable() {
		return (EAttribute)actionVariablePipeliningDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpactAnalysisReport() {
		return impactAnalysisReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisReport_Network() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisReport_InitialBottlenecks() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisReport_PiplenablesActions() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisReport_ImpactData() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpactAnalysisData() {
		return impactAnalysisDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisData_EstimatedBottlenecks() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpactAnalysisData_CpReduction() {
		return (EAttribute)impactAnalysisDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisData_Actions() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpactAnalysisData_ActorClass() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeliningFactory getPipeliningFactory() {
		return (PipeliningFactory)getEFactoryInstance();
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
		actionsVariablePipeliningReportEClass = createEClass(ACTIONS_VARIABLE_PIPELINING_REPORT);
		createEReference(actionsVariablePipeliningReportEClass, ACTIONS_VARIABLE_PIPELINING_REPORT__NETWORK);
		createEReference(actionsVariablePipeliningReportEClass, ACTIONS_VARIABLE_PIPELINING_REPORT__ACTIONS_DATA);

		actionVariablePipeliningDataEClass = createEClass(ACTION_VARIABLE_PIPELINING_DATA);
		createEReference(actionVariablePipeliningDataEClass, ACTION_VARIABLE_PIPELINING_DATA__ACTION);
		createEReference(actionVariablePipeliningDataEClass, ACTION_VARIABLE_PIPELINING_DATA__CONSECUTIVE_FIRINGS);
		createEReference(actionVariablePipeliningDataEClass, ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE_FIRINGS);
		createEAttribute(actionVariablePipeliningDataEClass, ACTION_VARIABLE_PIPELINING_DATA__PIPELINABLE);

		impactAnalysisReportEClass = createEClass(IMPACT_ANALYSIS_REPORT);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__NETWORK);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__PIPLENABLES_ACTIONS);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__IMPACT_DATA);

		impactAnalysisDataEClass = createEClass(IMPACT_ANALYSIS_DATA);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS);
		createEAttribute(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__CP_REDUCTION);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__ACTIONS);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__ACTOR_CLASS);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
		BottlenecksPackage theBottlenecksPackage = (BottlenecksPackage)EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actionsVariablePipeliningReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		impactAnalysisReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(actionsVariablePipeliningReportEClass, ActionsVariablePipeliningReport.class, "ActionsVariablePipeliningReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionsVariablePipeliningReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ActionsVariablePipeliningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionsVariablePipeliningReport_ActionsData(), this.getActionVariablePipeliningData(), null, "actionsData", null, 0, -1, ActionsVariablePipeliningReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionVariablePipeliningDataEClass, ActionVariablePipeliningData.class, "ActionVariablePipeliningData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionVariablePipeliningData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, ActionVariablePipeliningData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionVariablePipeliningData_ConsecutiveFirings(), theCommonPackage.getStatisticalData(), null, "consecutiveFirings", null, 1, 1, ActionVariablePipeliningData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionVariablePipeliningData_PipelinableFirings(), theCommonPackage.getStatisticalData(), null, "pipelinableFirings", null, 1, 1, ActionVariablePipeliningData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionVariablePipeliningData_Pipelinable(), ecorePackage.getEBoolean(), "pipelinable", "false", 0, 1, ActionVariablePipeliningData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(impactAnalysisReportEClass, ImpactAnalysisReport.class, "ImpactAnalysisReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalysisReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisReport_InitialBottlenecks(), theBottlenecksPackage.getBottlenecksReport(), null, "initialBottlenecks", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisReport_PiplenablesActions(), this.getActionsVariablePipeliningReport(), null, "piplenablesActions", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisReport_ImpactData(), this.getImpactAnalysisData(), null, "impactData", null, 0, -1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactAnalysisDataEClass, ImpactAnalysisData.class, "ImpactAnalysisData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalysisData_EstimatedBottlenecks(), theBottlenecksPackage.getBottlenecksReport(), null, "estimatedBottlenecks", null, 0, 1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpactAnalysisData_CpReduction(), ecorePackage.getEDouble(), "cpReduction", null, 0, 1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisData_Actions(), theDataflowPackage.getAction(), null, "actions", null, 1, -1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisData_ActorClass(), theDataflowPackage.getActorClass(), null, "actorClass", null, 0, 1, ImpactAnalysisData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
	}

} //PipeliningPackageImpl

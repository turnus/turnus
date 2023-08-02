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
package turnus.model.analysis.trace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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

import turnus.model.analysis.scheduling.SchedulingPackage;

import turnus.model.analysis.scheduling.caseoptimal.CaseoptimalPackage;

import turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalPackageImpl;

import turnus.model.analysis.scheduling.impl.SchedulingPackageImpl;

import turnus.model.analysis.trace.ComparedAction;
import turnus.model.analysis.trace.ComparedTrace;
import turnus.model.analysis.trace.CompressedDependency;
import turnus.model.analysis.trace.CompressedFsmDependency;
import turnus.model.analysis.trace.CompressedGuardDependency;
import turnus.model.analysis.trace.CompressedPortDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.CompressedTokensDependency;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.CompressedVariableDependency;
import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.analysis.trace.TraceComparatorReport;
import turnus.model.analysis.trace.TraceFactory;
import turnus.model.analysis.trace.TracePackage;
import turnus.model.analysis.trace.TraceSizeReport;

import turnus.model.common.CommonPackage;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TracePackageImpl extends EPackageImpl implements TracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceSizeReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedTraceReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedFsmDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedGuardDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedVariableDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedPortDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compressedTokensDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceComparatorReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparedTraceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comparedActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markowModelTraceReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markovModelActionDataEClass = null;

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
	 * @see turnus.model.analysis.trace.TracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TracePackageImpl() {
		super(eNS_URI, TraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TracePackage init() {
		if (isInited) return (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTracePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TracePackageImpl theTracePackage = registeredTracePackage instanceof TracePackageImpl ? (TracePackageImpl)registeredTracePackage : new TracePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		DataflowPackage.eINSTANCE.eClass();
		VersioningPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);
		AnalysisPackageImpl theAnalysisPackage = (AnalysisPackageImpl)(registeredPackage instanceof AnalysisPackageImpl ? registeredPackage : AnalysisPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI);
		ProfilerPackageImpl theProfilerPackage = (ProfilerPackageImpl)(registeredPackage instanceof ProfilerPackageImpl ? registeredPackage : ProfilerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);
		MapPackageImpl theMapPackage = (MapPackageImpl)(registeredPackage instanceof MapPackageImpl ? registeredPackage : MapPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI);
		BottlenecksPackageImpl theBottlenecksPackage = (BottlenecksPackageImpl)(registeredPackage instanceof BottlenecksPackageImpl ? registeredPackage : BottlenecksPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BuffersPackage.eNS_URI);
		BuffersPackageImpl theBuffersPackage = (BuffersPackageImpl)(registeredPackage instanceof BuffersPackageImpl ? registeredPackage : BuffersPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);
		PartitioningPackageImpl thePartitioningPackage = (PartitioningPackageImpl)(registeredPackage instanceof PartitioningPackageImpl ? registeredPackage : PartitioningPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI);
		PipeliningPackageImpl thePipeliningPackage = (PipeliningPackageImpl)(registeredPackage instanceof PipeliningPackageImpl ? registeredPackage : PipeliningPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);
		PostprocessingPackageImpl thePostprocessingPackage = (PostprocessingPackageImpl)(registeredPackage instanceof PostprocessingPackageImpl ? registeredPackage : PostprocessingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI);
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(registeredPackage instanceof ProfilingPackageImpl ? registeredPackage : ProfilingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(registeredPackage instanceof SchedulingPackageImpl ? registeredPackage : SchedulingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CaseoptimalPackage.eNS_URI);
		CaseoptimalPackageImpl theCaseoptimalPackage = (CaseoptimalPackageImpl)(registeredPackage instanceof CaseoptimalPackageImpl ? registeredPackage : CaseoptimalPackage.eINSTANCE);

		// Create package meta-data objects
		theTracePackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theCaseoptimalPackage.createPackageContents();

		// Initialize created meta-data
		theTracePackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theCaseoptimalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTracePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TracePackage.eNS_URI, theTracePackage);
		return theTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTraceSizeReport() {
		return traceSizeReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActionsFirings() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActionsIncomings() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActionsOutgoings() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActorsFirings() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActorsIncoming() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_ActorsOutgoings() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTraceSizeReport_Firings() {
		return (EAttribute)traceSizeReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTraceSizeReport_Dependencies() {
		return (EAttribute)traceSizeReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_DependenciesKinds() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceSizeReport_Network() {
		return (EReference)traceSizeReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedTraceReport() {
		return compressedTraceReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedTraceReport_Network() {
		return (EReference)compressedTraceReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedTraceReport_Steps() {
		return (EReference)compressedTraceReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedTraceReport_Dependencies() {
		return (EReference)compressedTraceReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompressedTraceReport_TraceFile() {
		return (EAttribute)compressedTraceReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCompressedTraceReport__GetSteps__Action() {
		return compressedTraceReportEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCompressedTraceReport__GetSteps__Actor() {
		return compressedTraceReportEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedStep() {
		return compressedStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Action() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompressedStep_Count() {
		return (EAttribute)compressedStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Incomings() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Outgoings() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Predecessors() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Successors() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedStep_Neighbors() {
		return (EReference)compressedStepEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedDependency() {
		return compressedDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompressedDependency_Count() {
		return (EAttribute)compressedDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedDependency_Source() {
		return (EReference)compressedDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedDependency_Target() {
		return (EReference)compressedDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedFsmDependency() {
		return compressedFsmDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedGuardDependency() {
		return compressedGuardDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedGuardDependency_EnableMap() {
		return (EReference)compressedGuardDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedGuardDependency_DisableMap() {
		return (EReference)compressedGuardDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedVariableDependency() {
		return compressedVariableDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedVariableDependency_ReadReadMap() {
		return (EReference)compressedVariableDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedVariableDependency_ReadWriteMap() {
		return (EReference)compressedVariableDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedVariableDependency_WriteReadMap() {
		return (EReference)compressedVariableDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedVariableDependency_WriteWriteMap() {
		return (EReference)compressedVariableDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedPortDependency() {
		return compressedPortDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedPortDependency_ReadMap() {
		return (EReference)compressedPortDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedPortDependency_WriteMap() {
		return (EReference)compressedPortDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompressedTokensDependency() {
		return compressedTokensDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedTokensDependency_CountMap() {
		return (EReference)compressedTokensDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompressedTokensDependency_TokensMap() {
		return (EReference)compressedTokensDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTraceComparatorReport() {
		return traceComparatorReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceComparatorReport_Reference() {
		return (EReference)traceComparatorReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceComparatorReport_Traces() {
		return (EReference)traceComparatorReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComparedTrace() {
		return comparedTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparedTrace_CompressedTrace() {
		return (EReference)comparedTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedTrace_DSteps() {
		return (EAttribute)comparedTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedTrace_DDependencies() {
		return (EAttribute)comparedTraceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparedTrace_ContainedReferenceActions() {
		return (EReference)comparedTraceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparedTrace_Actions() {
		return (EReference)comparedTraceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedTrace_Equal() {
		return (EAttribute)comparedTraceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComparedAction() {
		return comparedActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComparedAction_Action() {
		return (EReference)comparedActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedAction_Found() {
		return (EAttribute)comparedActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedAction_DSteps() {
		return (EAttribute)comparedActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedAction_DIncomings() {
		return (EAttribute)comparedActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComparedAction_DOutgoings() {
		return (EAttribute)comparedActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMarkowModelTraceReport() {
		return markowModelTraceReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMarkowModelTraceReport_Network() {
		return (EReference)markowModelTraceReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMarkowModelTraceReport_ActionsData() {
		return (EReference)markowModelTraceReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMarkowModelTraceReport__GetData__Actor() {
		return markowModelTraceReportEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMarkowModelTraceReport__GetData__Action() {
		return markowModelTraceReportEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMarkovModelActionData() {
		return markovModelActionDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMarkovModelActionData_Action() {
		return (EReference)markovModelActionDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMarkovModelActionData_First() {
		return (EAttribute)markovModelActionDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMarkovModelActionData_SuccessorsMap() {
		return (EReference)markovModelActionDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMarkovModelActionData_Successors() {
		return (EAttribute)markovModelActionDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceFactory getTraceFactory() {
		return (TraceFactory)getEFactoryInstance();
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
		traceSizeReportEClass = createEClass(TRACE_SIZE_REPORT);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTIONS_FIRINGS);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTIONS_INCOMINGS);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTORS_FIRINGS);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTORS_INCOMING);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__ACTORS_OUTGOINGS);
		createEAttribute(traceSizeReportEClass, TRACE_SIZE_REPORT__FIRINGS);
		createEAttribute(traceSizeReportEClass, TRACE_SIZE_REPORT__DEPENDENCIES);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__DEPENDENCIES_KINDS);
		createEReference(traceSizeReportEClass, TRACE_SIZE_REPORT__NETWORK);

		compressedTraceReportEClass = createEClass(COMPRESSED_TRACE_REPORT);
		createEReference(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT__NETWORK);
		createEReference(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT__STEPS);
		createEReference(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT__DEPENDENCIES);
		createEAttribute(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT__TRACE_FILE);
		createEOperation(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT___GET_STEPS__ACTION);
		createEOperation(compressedTraceReportEClass, COMPRESSED_TRACE_REPORT___GET_STEPS__ACTOR);

		compressedStepEClass = createEClass(COMPRESSED_STEP);
		createEReference(compressedStepEClass, COMPRESSED_STEP__ACTION);
		createEAttribute(compressedStepEClass, COMPRESSED_STEP__COUNT);
		createEReference(compressedStepEClass, COMPRESSED_STEP__INCOMINGS);
		createEReference(compressedStepEClass, COMPRESSED_STEP__OUTGOINGS);
		createEReference(compressedStepEClass, COMPRESSED_STEP__PREDECESSORS);
		createEReference(compressedStepEClass, COMPRESSED_STEP__SUCCESSORS);
		createEReference(compressedStepEClass, COMPRESSED_STEP__NEIGHBORS);

		compressedDependencyEClass = createEClass(COMPRESSED_DEPENDENCY);
		createEAttribute(compressedDependencyEClass, COMPRESSED_DEPENDENCY__COUNT);
		createEReference(compressedDependencyEClass, COMPRESSED_DEPENDENCY__SOURCE);
		createEReference(compressedDependencyEClass, COMPRESSED_DEPENDENCY__TARGET);

		compressedFsmDependencyEClass = createEClass(COMPRESSED_FSM_DEPENDENCY);

		compressedGuardDependencyEClass = createEClass(COMPRESSED_GUARD_DEPENDENCY);
		createEReference(compressedGuardDependencyEClass, COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP);
		createEReference(compressedGuardDependencyEClass, COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP);

		compressedVariableDependencyEClass = createEClass(COMPRESSED_VARIABLE_DEPENDENCY);
		createEReference(compressedVariableDependencyEClass, COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP);
		createEReference(compressedVariableDependencyEClass, COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP);
		createEReference(compressedVariableDependencyEClass, COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP);
		createEReference(compressedVariableDependencyEClass, COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP);

		compressedPortDependencyEClass = createEClass(COMPRESSED_PORT_DEPENDENCY);
		createEReference(compressedPortDependencyEClass, COMPRESSED_PORT_DEPENDENCY__READ_MAP);
		createEReference(compressedPortDependencyEClass, COMPRESSED_PORT_DEPENDENCY__WRITE_MAP);

		compressedTokensDependencyEClass = createEClass(COMPRESSED_TOKENS_DEPENDENCY);
		createEReference(compressedTokensDependencyEClass, COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP);
		createEReference(compressedTokensDependencyEClass, COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP);

		traceComparatorReportEClass = createEClass(TRACE_COMPARATOR_REPORT);
		createEReference(traceComparatorReportEClass, TRACE_COMPARATOR_REPORT__REFERENCE);
		createEReference(traceComparatorReportEClass, TRACE_COMPARATOR_REPORT__TRACES);

		comparedTraceEClass = createEClass(COMPARED_TRACE);
		createEReference(comparedTraceEClass, COMPARED_TRACE__COMPRESSED_TRACE);
		createEAttribute(comparedTraceEClass, COMPARED_TRACE__DSTEPS);
		createEAttribute(comparedTraceEClass, COMPARED_TRACE__DDEPENDENCIES);
		createEReference(comparedTraceEClass, COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS);
		createEReference(comparedTraceEClass, COMPARED_TRACE__ACTIONS);
		createEAttribute(comparedTraceEClass, COMPARED_TRACE__EQUAL);

		comparedActionEClass = createEClass(COMPARED_ACTION);
		createEReference(comparedActionEClass, COMPARED_ACTION__ACTION);
		createEAttribute(comparedActionEClass, COMPARED_ACTION__FOUND);
		createEAttribute(comparedActionEClass, COMPARED_ACTION__DSTEPS);
		createEAttribute(comparedActionEClass, COMPARED_ACTION__DINCOMINGS);
		createEAttribute(comparedActionEClass, COMPARED_ACTION__DOUTGOINGS);

		markowModelTraceReportEClass = createEClass(MARKOW_MODEL_TRACE_REPORT);
		createEReference(markowModelTraceReportEClass, MARKOW_MODEL_TRACE_REPORT__NETWORK);
		createEReference(markowModelTraceReportEClass, MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA);
		createEOperation(markowModelTraceReportEClass, MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTOR);
		createEOperation(markowModelTraceReportEClass, MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTION);

		markovModelActionDataEClass = createEClass(MARKOV_MODEL_ACTION_DATA);
		createEReference(markovModelActionDataEClass, MARKOV_MODEL_ACTION_DATA__ACTION);
		createEAttribute(markovModelActionDataEClass, MARKOV_MODEL_ACTION_DATA__FIRST);
		createEReference(markovModelActionDataEClass, MARKOV_MODEL_ACTION_DATA__SUCCESSORS_MAP);
		createEAttribute(markovModelActionDataEClass, MARKOV_MODEL_ACTION_DATA__SUCCESSORS);
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
		MapPackage theMapPackage = (MapPackage)EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);
		DataflowPackage theDataflowPackage = (DataflowPackage)EPackage.Registry.INSTANCE.getEPackage(DataflowPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		traceSizeReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		compressedTraceReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		compressedFsmDependencyEClass.getESuperTypes().add(this.getCompressedDependency());
		compressedGuardDependencyEClass.getESuperTypes().add(this.getCompressedDependency());
		compressedVariableDependencyEClass.getESuperTypes().add(this.getCompressedDependency());
		compressedPortDependencyEClass.getESuperTypes().add(this.getCompressedDependency());
		compressedTokensDependencyEClass.getESuperTypes().add(this.getCompressedDependency());
		traceComparatorReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		markowModelTraceReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(traceSizeReportEClass, TraceSizeReport.class, "TraceSizeReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceSizeReport_ActionsFirings(), theMapPackage.getActionToLongMap(), null, "actionsFirings", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_ActionsIncomings(), theMapPackage.getActionToLongMap(), null, "actionsIncomings", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_ActionsOutgoings(), theMapPackage.getActionToLongMap(), null, "actionsOutgoings", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_ActorsFirings(), theMapPackage.getActorToLongMap(), null, "actorsFirings", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_ActorsIncoming(), theMapPackage.getActorToLongMap(), null, "actorsIncoming", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_ActorsOutgoings(), theMapPackage.getActorToLongMap(), null, "actorsOutgoings", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceSizeReport_Firings(), ecorePackage.getELong(), "firings", null, 0, 1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceSizeReport_Dependencies(), ecorePackage.getELong(), "dependencies", null, 0, 1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_DependenciesKinds(), theMapPackage.getStringToLongMap(), null, "dependenciesKinds", null, 0, -1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceSizeReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, TraceSizeReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compressedTraceReportEClass, CompressedTraceReport.class, "CompressedTraceReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedTraceReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, CompressedTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedTraceReport_Steps(), this.getCompressedStep(), null, "steps", null, 0, -1, CompressedTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedTraceReport_Dependencies(), this.getCompressedDependency(), null, "dependencies", null, 0, -1, CompressedTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompressedTraceReport_TraceFile(), ecorePackage.getEString(), "traceFile", null, 0, 1, CompressedTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getCompressedTraceReport__GetSteps__Action(), this.getCompressedStep(), "getSteps", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataflowPackage.getAction(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCompressedTraceReport__GetSteps__Actor(), this.getCompressedStep(), "getSteps", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataflowPackage.getActor(), "actor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compressedStepEClass, CompressedStep.class, "CompressedStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedStep_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, CompressedStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompressedStep_Count(), ecorePackage.getELong(), "count", null, 0, 1, CompressedStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedStep_Incomings(), this.getCompressedDependency(), this.getCompressedDependency_Target(), "incomings", null, 0, -1, CompressedStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedStep_Outgoings(), this.getCompressedDependency(), this.getCompressedDependency_Source(), "outgoings", null, 0, -1, CompressedStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedStep_Predecessors(), this.getCompressedStep(), null, "predecessors", null, 0, -1, CompressedStep.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedStep_Successors(), this.getCompressedStep(), null, "successors", null, 0, -1, CompressedStep.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedStep_Neighbors(), this.getCompressedStep(), null, "neighbors", null, 0, -1, CompressedStep.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(compressedDependencyEClass, CompressedDependency.class, "CompressedDependency", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompressedDependency_Count(), ecorePackage.getELong(), "count", null, 0, 1, CompressedDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedDependency_Source(), this.getCompressedStep(), this.getCompressedStep_Outgoings(), "source", null, 0, 1, CompressedDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedDependency_Target(), this.getCompressedStep(), this.getCompressedStep_Incomings(), "target", null, 0, 1, CompressedDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compressedFsmDependencyEClass, CompressedFsmDependency.class, "CompressedFsmDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compressedGuardDependencyEClass, CompressedGuardDependency.class, "CompressedGuardDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedGuardDependency_EnableMap(), theMapPackage.getGuardToLongMap(), null, "enableMap", null, 0, -1, CompressedGuardDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedGuardDependency_DisableMap(), theMapPackage.getGuardToLongMap(), null, "disableMap", null, 0, -1, CompressedGuardDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compressedVariableDependencyEClass, CompressedVariableDependency.class, "CompressedVariableDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedVariableDependency_ReadReadMap(), theMapPackage.getVariableToLongMap(), null, "readReadMap", null, 0, -1, CompressedVariableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedVariableDependency_ReadWriteMap(), theMapPackage.getVariableToLongMap(), null, "readWriteMap", null, 0, -1, CompressedVariableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedVariableDependency_WriteReadMap(), theMapPackage.getVariableToLongMap(), null, "writeReadMap", null, 0, -1, CompressedVariableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedVariableDependency_WriteWriteMap(), theMapPackage.getVariableToLongMap(), null, "writeWriteMap", null, 0, -1, CompressedVariableDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compressedPortDependencyEClass, CompressedPortDependency.class, "CompressedPortDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedPortDependency_ReadMap(), theMapPackage.getPortToLongMap(), null, "readMap", null, 0, -1, CompressedPortDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedPortDependency_WriteMap(), theMapPackage.getPortToLongMap(), null, "writeMap", null, 0, -1, CompressedPortDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compressedTokensDependencyEClass, CompressedTokensDependency.class, "CompressedTokensDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedTokensDependency_CountMap(), theMapPackage.getBufferToLongMap(), null, "countMap", null, 0, -1, CompressedTokensDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompressedTokensDependency_TokensMap(), theMapPackage.getBufferToStatisticalDataMap(), null, "tokensMap", null, 0, -1, CompressedTokensDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceComparatorReportEClass, TraceComparatorReport.class, "TraceComparatorReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceComparatorReport_Reference(), this.getCompressedTraceReport(), null, "reference", null, 0, 1, TraceComparatorReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceComparatorReport_Traces(), this.getComparedTrace(), null, "traces", null, 0, -1, TraceComparatorReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comparedTraceEClass, ComparedTrace.class, "ComparedTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComparedTrace_CompressedTrace(), this.getCompressedTraceReport(), null, "compressedTrace", null, 0, 1, ComparedTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedTrace_DSteps(), ecorePackage.getELong(), "dSteps", null, 0, 1, ComparedTrace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedTrace_DDependencies(), ecorePackage.getELong(), "dDependencies", null, 0, 1, ComparedTrace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComparedTrace_ContainedReferenceActions(), theDataflowPackage.getAction(), null, "containedReferenceActions", null, 0, -1, ComparedTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComparedTrace_Actions(), this.getComparedAction(), null, "actions", null, 0, -1, ComparedTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedTrace_Equal(), ecorePackage.getEBoolean(), "equal", "false", 0, 1, ComparedTrace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(comparedActionEClass, ComparedAction.class, "ComparedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComparedAction_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, ComparedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedAction_Found(), ecorePackage.getEBoolean(), "found", null, 0, 1, ComparedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedAction_DSteps(), ecorePackage.getELong(), "dSteps", null, 0, 1, ComparedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedAction_DIncomings(), ecorePackage.getELong(), "dIncomings", null, 0, 1, ComparedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComparedAction_DOutgoings(), ecorePackage.getELong(), "dOutgoings", null, 0, 1, ComparedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markowModelTraceReportEClass, MarkowModelTraceReport.class, "MarkowModelTraceReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkowModelTraceReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, MarkowModelTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkowModelTraceReport_ActionsData(), this.getMarkovModelActionData(), null, "actionsData", null, 0, -1, MarkowModelTraceReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMarkowModelTraceReport__GetData__Actor(), this.getMarkovModelActionData(), "getData", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataflowPackage.getActor(), "actor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMarkowModelTraceReport__GetData__Action(), this.getMarkovModelActionData(), "getData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataflowPackage.getAction(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(markovModelActionDataEClass, MarkovModelActionData.class, "MarkovModelActionData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkovModelActionData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, MarkovModelActionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovModelActionData_First(), ecorePackage.getEBoolean(), "first", null, 0, 1, MarkovModelActionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarkovModelActionData_SuccessorsMap(), theMapPackage.getActionToLongMap(), null, "successorsMap", null, 0, -1, MarkovModelActionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarkovModelActionData_Successors(), ecorePackage.getELong(), "successors", null, 0, 1, MarkovModelActionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //TracePackageImpl

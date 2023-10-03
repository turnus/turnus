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
package turnus.model.analysis.bottlenecks.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import turnus.model.analysis.AnalysisPackage;

import turnus.model.analysis.bottlenecks.ActionBottlenecksData;
import turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData;
import turnus.model.analysis.bottlenecks.BottlenecksFactory;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.bottlenecks.ImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ScheduledImpactAnalysisReport;

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
import turnus.model.analysis.scheduling.impl.SchedulingPackageImpl;

import turnus.model.analysis.trace.TracePackage;

import turnus.model.analysis.trace.impl.TracePackageImpl;

import turnus.model.common.CommonPackage;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BottlenecksPackageImpl extends EPackageImpl implements BottlenecksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bottlenecksReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionBottlenecksDataEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleToBottlenecksReportMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bottlenecksWithSchedulingReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionBottlenecksWithSchedulingDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduledImpactAnalysisDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleToBottlenecksWithSchedulingReportMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduledImpactAnalysisReportEClass = null;

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
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BottlenecksPackageImpl() {
		super(eNS_URI, BottlenecksFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BottlenecksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BottlenecksPackage init() {
		if (isInited) return (BottlenecksPackage)EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBottlenecksPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BottlenecksPackageImpl theBottlenecksPackage = registeredBottlenecksPackage instanceof BottlenecksPackageImpl ? (BottlenecksPackageImpl)registeredBottlenecksPackage : new BottlenecksPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		TracePackageImpl theTracePackage = (TracePackageImpl)(registeredPackage instanceof TracePackageImpl ? registeredPackage : TracePackage.eINSTANCE);
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

		// Create package meta-data objects
		theBottlenecksPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		theBottlenecksPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBottlenecksPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BottlenecksPackage.eNS_URI, theBottlenecksPackage);
		return theBottlenecksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBottlenecksReport() {
		return bottlenecksReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottlenecksReport_Network() {
		return (EReference)bottlenecksReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottlenecksReport_ActionsData() {
		return (EReference)bottlenecksReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_CpWeight() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_CpVariance() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_TotalWeight() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_TotalVariance() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_CpFirings() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksReport_TotalFirings() {
		return (EAttribute)bottlenecksReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionBottlenecksData() {
		return actionBottlenecksDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionBottlenecksData_Action() {
		return (EReference)actionBottlenecksDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_SlackMin() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_SlackMax() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_CpWeight() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_CpVariance() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_TotalWeight() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_TotalVariance() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_CpFirings() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksData_TotalFirings() {
		return (EAttribute)actionBottlenecksDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImpactAnalysisReport() {
		return impactAnalysisReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisReport_Network() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImpactAnalysisReport_ClassLevel() {
		return (EAttribute)impactAnalysisReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisReport_ImpactData() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisReport_InitialBottlenecks() {
		return (EReference)impactAnalysisReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImpactAnalysisData() {
		return impactAnalysisDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisData_Actions() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisData_ActorClass() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisData_CpReductionMap() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImpactAnalysisData_ReportsMap() {
		return (EReference)impactAnalysisDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoubleToBottlenecksReportMap() {
		return doubleToBottlenecksReportMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDoubleToBottlenecksReportMap_Key() {
		return (EAttribute)doubleToBottlenecksReportMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDoubleToBottlenecksReportMap_Value() {
		return (EReference)doubleToBottlenecksReportMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBottlenecksWithSchedulingReport() {
		return bottlenecksWithSchedulingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottlenecksWithSchedulingReport_Network() {
		return (EReference)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottlenecksWithSchedulingReport_ActionsData() {
		return (EReference)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_CpWeight() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_TotalWeight() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_CpFirings() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_TotalFirings() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_ExecutionTime() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_CpBlockingTime() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottlenecksWithSchedulingReport_CpPartitionsBlockingTime() {
		return (EReference)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBottlenecksWithSchedulingReport_Deadlock() {
		return (EAttribute)bottlenecksWithSchedulingReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionBottlenecksWithSchedulingData() {
		return actionBottlenecksWithSchedulingDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionBottlenecksWithSchedulingData_Action() {
		return (EReference)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksWithSchedulingData_CpWeight() {
		return (EAttribute)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksWithSchedulingData_TotalWeight() {
		return (EAttribute)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksWithSchedulingData_CpFirings() {
		return (EAttribute)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionBottlenecksWithSchedulingData_TotalFirings() {
		return (EAttribute)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionBottlenecksWithSchedulingData_MaxBlockedOutputTokens() {
		return (EReference)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionBottlenecksWithSchedulingData_MaxBlockedMultiplication() {
		return (EReference)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionBottlenecksWithSchedulingData_BlockingInstances() {
		return (EReference)actionBottlenecksWithSchedulingDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScheduledImpactAnalysisData() {
		return scheduledImpactAnalysisDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisData_Actions() {
		return (EReference)scheduledImpactAnalysisDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisData_ActorClass() {
		return (EReference)scheduledImpactAnalysisDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisData_CpReductionMap() {
		return (EReference)scheduledImpactAnalysisDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisData_TimeReductionMap() {
		return (EReference)scheduledImpactAnalysisDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisData_ReportsMap() {
		return (EReference)scheduledImpactAnalysisDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoubleToBottlenecksWithSchedulingReportMap() {
		return doubleToBottlenecksWithSchedulingReportMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDoubleToBottlenecksWithSchedulingReportMap_Key() {
		return (EAttribute)doubleToBottlenecksWithSchedulingReportMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDoubleToBottlenecksWithSchedulingReportMap_Value() {
		return (EReference)doubleToBottlenecksWithSchedulingReportMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScheduledImpactAnalysisReport() {
		return scheduledImpactAnalysisReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisReport_Network() {
		return (EReference)scheduledImpactAnalysisReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScheduledImpactAnalysisReport_ClassLevel() {
		return (EAttribute)scheduledImpactAnalysisReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisReport_ScheduledImpactData() {
		return (EReference)scheduledImpactAnalysisReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScheduledImpactAnalysisReport_InitialBottlenecksWithScheduling() {
		return (EReference)scheduledImpactAnalysisReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksFactory getBottlenecksFactory() {
		return (BottlenecksFactory)getEFactoryInstance();
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
		bottlenecksReportEClass = createEClass(BOTTLENECKS_REPORT);
		createEReference(bottlenecksReportEClass, BOTTLENECKS_REPORT__NETWORK);
		createEReference(bottlenecksReportEClass, BOTTLENECKS_REPORT__ACTIONS_DATA);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__CP_WEIGHT);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__CP_VARIANCE);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__TOTAL_WEIGHT);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__TOTAL_VARIANCE);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__CP_FIRINGS);
		createEAttribute(bottlenecksReportEClass, BOTTLENECKS_REPORT__TOTAL_FIRINGS);

		actionBottlenecksDataEClass = createEClass(ACTION_BOTTLENECKS_DATA);
		createEReference(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__ACTION);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__SLACK_MIN);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__SLACK_MAX);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__CP_WEIGHT);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__CP_VARIANCE);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__TOTAL_WEIGHT);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__TOTAL_VARIANCE);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__CP_FIRINGS);
		createEAttribute(actionBottlenecksDataEClass, ACTION_BOTTLENECKS_DATA__TOTAL_FIRINGS);

		impactAnalysisReportEClass = createEClass(IMPACT_ANALYSIS_REPORT);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__NETWORK);
		createEAttribute(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__CLASS_LEVEL);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__IMPACT_DATA);
		createEReference(impactAnalysisReportEClass, IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS);

		impactAnalysisDataEClass = createEClass(IMPACT_ANALYSIS_DATA);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__ACTIONS);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__ACTOR_CLASS);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP);
		createEReference(impactAnalysisDataEClass, IMPACT_ANALYSIS_DATA__REPORTS_MAP);

		doubleToBottlenecksReportMapEClass = createEClass(DOUBLE_TO_BOTTLENECKS_REPORT_MAP);
		createEAttribute(doubleToBottlenecksReportMapEClass, DOUBLE_TO_BOTTLENECKS_REPORT_MAP__KEY);
		createEReference(doubleToBottlenecksReportMapEClass, DOUBLE_TO_BOTTLENECKS_REPORT_MAP__VALUE);

		bottlenecksWithSchedulingReportEClass = createEClass(BOTTLENECKS_WITH_SCHEDULING_REPORT);
		createEReference(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__NETWORK);
		createEReference(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__ACTIONS_DATA);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_WEIGHT);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_WEIGHT);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_FIRINGS);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__TOTAL_FIRINGS);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__EXECUTION_TIME);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_BLOCKING_TIME);
		createEReference(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__CP_PARTITIONS_BLOCKING_TIME);
		createEAttribute(bottlenecksWithSchedulingReportEClass, BOTTLENECKS_WITH_SCHEDULING_REPORT__DEADLOCK);

		actionBottlenecksWithSchedulingDataEClass = createEClass(ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA);
		createEReference(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__ACTION);
		createEAttribute(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_WEIGHT);
		createEAttribute(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_WEIGHT);
		createEAttribute(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__CP_FIRINGS);
		createEAttribute(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__TOTAL_FIRINGS);
		createEReference(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_OUTPUT_TOKENS);
		createEReference(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__MAX_BLOCKED_MULTIPLICATION);
		createEReference(actionBottlenecksWithSchedulingDataEClass, ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA__BLOCKING_INSTANCES);

		scheduledImpactAnalysisDataEClass = createEClass(SCHEDULED_IMPACT_ANALYSIS_DATA);
		createEReference(scheduledImpactAnalysisDataEClass, SCHEDULED_IMPACT_ANALYSIS_DATA__ACTIONS);
		createEReference(scheduledImpactAnalysisDataEClass, SCHEDULED_IMPACT_ANALYSIS_DATA__ACTOR_CLASS);
		createEReference(scheduledImpactAnalysisDataEClass, SCHEDULED_IMPACT_ANALYSIS_DATA__CP_REDUCTION_MAP);
		createEReference(scheduledImpactAnalysisDataEClass, SCHEDULED_IMPACT_ANALYSIS_DATA__TIME_REDUCTION_MAP);
		createEReference(scheduledImpactAnalysisDataEClass, SCHEDULED_IMPACT_ANALYSIS_DATA__REPORTS_MAP);

		doubleToBottlenecksWithSchedulingReportMapEClass = createEClass(DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP);
		createEAttribute(doubleToBottlenecksWithSchedulingReportMapEClass, DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__KEY);
		createEReference(doubleToBottlenecksWithSchedulingReportMapEClass, DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP__VALUE);

		scheduledImpactAnalysisReportEClass = createEClass(SCHEDULED_IMPACT_ANALYSIS_REPORT);
		createEReference(scheduledImpactAnalysisReportEClass, SCHEDULED_IMPACT_ANALYSIS_REPORT__NETWORK);
		createEAttribute(scheduledImpactAnalysisReportEClass, SCHEDULED_IMPACT_ANALYSIS_REPORT__CLASS_LEVEL);
		createEReference(scheduledImpactAnalysisReportEClass, SCHEDULED_IMPACT_ANALYSIS_REPORT__SCHEDULED_IMPACT_DATA);
		createEReference(scheduledImpactAnalysisReportEClass, SCHEDULED_IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS_WITH_SCHEDULING);
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
		PostprocessingPackage thePostprocessingPackage = (PostprocessingPackage)EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bottlenecksReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		impactAnalysisReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		bottlenecksWithSchedulingReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		bottlenecksWithSchedulingReportEClass.getESuperTypes().add(thePostprocessingPackage.getPostProcessingData());
		scheduledImpactAnalysisReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(bottlenecksReportEClass, BottlenecksReport.class, "BottlenecksReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBottlenecksReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, BottlenecksReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBottlenecksReport_ActionsData(), this.getActionBottlenecksData(), null, "actionsData", null, 0, -1, BottlenecksReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_CpWeight(), ecorePackage.getEDouble(), "cpWeight", null, 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_CpVariance(), ecorePackage.getEDouble(), "cpVariance", null, 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_TotalWeight(), ecorePackage.getEDouble(), "totalWeight", null, 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_TotalVariance(), ecorePackage.getEDouble(), "totalVariance", null, 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_CpFirings(), ecorePackage.getELong(), "cpFirings", "0", 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksReport_TotalFirings(), ecorePackage.getELong(), "totalFirings", "0", 1, 1, BottlenecksReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(actionBottlenecksDataEClass, ActionBottlenecksData.class, "ActionBottlenecksData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionBottlenecksData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_SlackMin(), ecorePackage.getEDouble(), "slackMin", null, 0, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_SlackMax(), ecorePackage.getEDouble(), "slackMax", null, 0, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_CpWeight(), ecorePackage.getEDouble(), "cpWeight", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_CpVariance(), ecorePackage.getEDouble(), "cpVariance", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_TotalWeight(), ecorePackage.getEDouble(), "totalWeight", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_TotalVariance(), ecorePackage.getEDouble(), "totalVariance", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_CpFirings(), ecorePackage.getELong(), "cpFirings", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksData_TotalFirings(), ecorePackage.getELong(), "totalFirings", null, 1, 1, ActionBottlenecksData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactAnalysisReportEClass, ImpactAnalysisReport.class, "ImpactAnalysisReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalysisReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpactAnalysisReport_ClassLevel(), ecorePackage.getEBoolean(), "classLevel", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisReport_ImpactData(), this.getImpactAnalysisData(), null, "impactData", null, 0, -1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisReport_InitialBottlenecks(), this.getBottlenecksReport(), null, "initialBottlenecks", null, 0, 1, ImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactAnalysisDataEClass, ImpactAnalysisData.class, "ImpactAnalysisData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpactAnalysisData_Actions(), theDataflowPackage.getAction(), null, "actions", null, 1, -1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisData_ActorClass(), theDataflowPackage.getActorClass(), null, "actorClass", null, 0, 1, ImpactAnalysisData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisData_CpReductionMap(), theMapPackage.getDoubleToDoubleMap(), null, "cpReductionMap", null, 0, -1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpactAnalysisData_ReportsMap(), this.getDoubleToBottlenecksReportMap(), null, "reportsMap", null, 0, -1, ImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleToBottlenecksReportMapEClass, Map.Entry.class, "DoubleToBottlenecksReportMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleToBottlenecksReportMap_Key(), ecorePackage.getEDoubleObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoubleToBottlenecksReportMap_Value(), this.getBottlenecksReport(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bottlenecksWithSchedulingReportEClass, BottlenecksWithSchedulingReport.class, "BottlenecksWithSchedulingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBottlenecksWithSchedulingReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, BottlenecksWithSchedulingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBottlenecksWithSchedulingReport_ActionsData(), this.getActionBottlenecksWithSchedulingData(), null, "actionsData", null, 0, -1, BottlenecksWithSchedulingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_CpWeight(), ecorePackage.getEDouble(), "cpWeight", null, 1, 1, BottlenecksWithSchedulingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_TotalWeight(), ecorePackage.getEDouble(), "totalWeight", null, 1, 1, BottlenecksWithSchedulingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_CpFirings(), ecorePackage.getELong(), "cpFirings", "0", 1, 1, BottlenecksWithSchedulingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_TotalFirings(), ecorePackage.getELong(), "totalFirings", "0", 1, 1, BottlenecksWithSchedulingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_ExecutionTime(), ecorePackage.getEDouble(), "executionTime", null, 1, 1, BottlenecksWithSchedulingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_CpBlockingTime(), ecorePackage.getEDouble(), "cpBlockingTime", null, 1, 1, BottlenecksWithSchedulingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBottlenecksWithSchedulingReport_CpPartitionsBlockingTime(), theMapPackage.getStringToDoubleMap(), null, "cpPartitionsBlockingTime", null, 0, -1, BottlenecksWithSchedulingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBottlenecksWithSchedulingReport_Deadlock(), ecorePackage.getEBoolean(), "deadlock", null, 0, 1, BottlenecksWithSchedulingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionBottlenecksWithSchedulingDataEClass, ActionBottlenecksWithSchedulingData.class, "ActionBottlenecksWithSchedulingData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionBottlenecksWithSchedulingData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksWithSchedulingData_CpWeight(), ecorePackage.getEDouble(), "cpWeight", null, 1, 1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksWithSchedulingData_TotalWeight(), ecorePackage.getEDouble(), "totalWeight", null, 1, 1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksWithSchedulingData_CpFirings(), ecorePackage.getELong(), "cpFirings", null, 1, 1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionBottlenecksWithSchedulingData_TotalFirings(), ecorePackage.getELong(), "totalFirings", null, 1, 1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionBottlenecksWithSchedulingData_MaxBlockedOutputTokens(), theMapPackage.getBufferToIntegerMap(), null, "maxBlockedOutputTokens", null, 0, -1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionBottlenecksWithSchedulingData_MaxBlockedMultiplication(), theMapPackage.getBufferToDoubleMap(), null, "maxBlockedMultiplication", null, 0, -1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionBottlenecksWithSchedulingData_BlockingInstances(), theMapPackage.getBufferToIntegerMap(), null, "blockingInstances", null, 0, -1, ActionBottlenecksWithSchedulingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduledImpactAnalysisDataEClass, ScheduledImpactAnalysisData.class, "ScheduledImpactAnalysisData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduledImpactAnalysisData_Actions(), theDataflowPackage.getAction(), null, "actions", null, 1, -1, ScheduledImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisData_ActorClass(), theDataflowPackage.getActorClass(), null, "actorClass", null, 0, 1, ScheduledImpactAnalysisData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisData_CpReductionMap(), theMapPackage.getDoubleToDoubleMap(), null, "cpReductionMap", null, 0, -1, ScheduledImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisData_TimeReductionMap(), theMapPackage.getDoubleToDoubleMap(), null, "timeReductionMap", null, 0, -1, ScheduledImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisData_ReportsMap(), this.getDoubleToBottlenecksWithSchedulingReportMap(), null, "reportsMap", null, 0, -1, ScheduledImpactAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleToBottlenecksWithSchedulingReportMapEClass, Map.Entry.class, "DoubleToBottlenecksWithSchedulingReportMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleToBottlenecksWithSchedulingReportMap_Key(), ecorePackage.getEDoubleObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoubleToBottlenecksWithSchedulingReportMap_Value(), this.getBottlenecksWithSchedulingReport(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduledImpactAnalysisReportEClass, ScheduledImpactAnalysisReport.class, "ScheduledImpactAnalysisReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduledImpactAnalysisReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ScheduledImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduledImpactAnalysisReport_ClassLevel(), ecorePackage.getEBoolean(), "classLevel", null, 0, 1, ScheduledImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisReport_ScheduledImpactData(), this.getScheduledImpactAnalysisData(), null, "scheduledImpactData", null, 0, -1, ScheduledImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduledImpactAnalysisReport_InitialBottlenecksWithScheduling(), this.getBottlenecksWithSchedulingReport(), null, "initialBottlenecksWithScheduling", null, 0, 1, ScheduledImpactAnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //BottlenecksPackageImpl

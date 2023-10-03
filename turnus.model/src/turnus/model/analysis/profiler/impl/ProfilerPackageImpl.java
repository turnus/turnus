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
package turnus.model.analysis.profiler.impl;

import java.util.Map;

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

import turnus.model.analysis.profiler.AccessData;
import turnus.model.analysis.profiler.ActionDynamicData;
import turnus.model.analysis.profiler.ActionMemoryProfilingData;
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.BenchmarkReport;
import turnus.model.analysis.profiler.BufferAccessData;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.CodeProfilingReport;
import turnus.model.analysis.profiler.ComplexCodeData;
import turnus.model.analysis.profiler.ComplexDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.analysis.profiler.LocalVariableAccessData;
import turnus.model.analysis.profiler.MemoryAccessData;
import turnus.model.analysis.profiler.MemoryProfilingReport;
import turnus.model.analysis.profiler.ProfilerFactory;
import turnus.model.analysis.profiler.ProfilerPackage;
import turnus.model.analysis.profiler.SharedVariableAccessData;
import turnus.model.analysis.profiler.StateVariableAccessData;

import turnus.model.analysis.profiler.TableRow;
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
public class ProfilerPackageImpl extends EPackageImpl implements ProfilerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeProfilingReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexCodeDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicProfilingReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorDynamicDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionDynamicDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferDynamicDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexDynamicDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureToComplexDynamicDataMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryProfilingReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionMemoryProfilingDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryAccessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferAccessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateVariableAccessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableAccessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedVariableAccessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToAccessDataMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass benchmarkReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableRowEClass = null;

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
	 * @see turnus.model.analysis.profiler.ProfilerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProfilerPackageImpl() {
		super(eNS_URI, ProfilerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProfilerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProfilerPackage init() {
		if (isInited) return (ProfilerPackage)EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProfilerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProfilerPackageImpl theProfilerPackage = registeredProfilerPackage instanceof ProfilerPackageImpl ? (ProfilerPackageImpl)registeredProfilerPackage : new ProfilerPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		DataflowPackage.eINSTANCE.eClass();
		VersioningPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);
		AnalysisPackageImpl theAnalysisPackage = (AnalysisPackageImpl)(registeredPackage instanceof AnalysisPackageImpl ? registeredPackage : AnalysisPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);
		MapPackageImpl theMapPackage = (MapPackageImpl)(registeredPackage instanceof MapPackageImpl ? registeredPackage : MapPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		TracePackageImpl theTracePackage = (TracePackageImpl)(registeredPackage instanceof TracePackageImpl ? registeredPackage : TracePackage.eINSTANCE);
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

		// Create package meta-data objects
		theProfilerPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		theProfilerPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProfilerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProfilerPackage.eNS_URI, theProfilerPackage);
		return theProfilerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodeProfilingReport() {
		return codeProfilingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodeProfilingReport_Network() {
		return (EReference)codeProfilingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodeProfilingReport_ActorClassesData() {
		return (EReference)codeProfilingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodeProfilingReport_NetworkData() {
		return (EReference)codeProfilingReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCodeProfilingReport__GetActorClassData__String() {
		return codeProfilingReportEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodeData() {
		return codeDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodeData_OperatorsCount() {
		return (EReference)codeDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCodeData_OperandsCount() {
		return (EReference)codeDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCodeData_BlockName() {
		return (EAttribute)codeDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCodeData_Nol() {
		return (EAttribute)codeDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComplexCodeData() {
		return complexCodeDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexCodeData_ActionsData() {
		return (EReference)complexCodeDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexCodeData_ProceduresData() {
		return (EReference)complexCodeDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getComplexCodeData__GetActionData__String() {
		return complexCodeDataEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getComplexCodeData__GetProcedureData__String() {
		return complexCodeDataEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDynamicProfilingReport() {
		return dynamicProfilingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDynamicProfilingReport_Network() {
		return (EReference)dynamicProfilingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDynamicProfilingReport_ActorsData() {
		return (EReference)dynamicProfilingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDynamicProfilingReport_BuffersData() {
		return (EReference)dynamicProfilingReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActorDynamicData() {
		return actorDynamicDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorDynamicData_Actor() {
		return (EReference)actorDynamicDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorDynamicData_ActionsData() {
		return (EReference)actorDynamicDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionDynamicData() {
		return actionDynamicDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionDynamicData_Action() {
		return (EReference)actionDynamicDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferDynamicData() {
		return bufferDynamicDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_Buffer() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_Reads() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_Writes() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_Occupancy() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_ActionReads() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_ActionWrites() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_ActionPeeks() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_ActionReadMisses() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDynamicData_ActionWriteMisses() {
		return (EReference)bufferDynamicDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDynamicData_UnconsumedTokens() {
		return (EAttribute)bufferDynamicDataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComplexDynamicData() {
		return complexDynamicDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_OperandsCalls() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_ProceduresCalls() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_VariablesStores() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_VariablesLoads() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_ProceduresData() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_ReadTokens() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComplexDynamicData_WriteTokens() {
		return (EReference)complexDynamicDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcedureToComplexDynamicDataMap() {
		return procedureToComplexDynamicDataMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcedureToComplexDynamicDataMap_Key() {
		return (EReference)procedureToComplexDynamicDataMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcedureToComplexDynamicDataMap_Value() {
		return (EReference)procedureToComplexDynamicDataMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMemoryProfilingReport() {
		return memoryProfilingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMemoryProfilingReport_NetworkName() {
		return (EAttribute)memoryProfilingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemoryProfilingReport_ActionsData() {
		return (EReference)memoryProfilingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMemoryProfilingReport__GetActionData__String_String() {
		return memoryProfilingReportEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionMemoryProfilingData() {
		return actionMemoryProfilingDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionMemoryProfilingData_Actor() {
		return (EAttribute)actionMemoryProfilingDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionMemoryProfilingData_Action() {
		return (EAttribute)actionMemoryProfilingDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionMemoryProfilingData_Reads() {
		return (EReference)actionMemoryProfilingDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActionMemoryProfilingData_Writes() {
		return (EReference)actionMemoryProfilingDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetReadBufferData__String_String_String_String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetWriteBufferData__String_String_String_String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetReadStateVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetWriteStateVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetReadLocalVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetWriteLocalVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetReadSharedVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getActionMemoryProfilingData__GetWriteSharedVariableData__String() {
		return actionMemoryProfilingDataEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMemoryAccessData() {
		return memoryAccessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemoryAccessData_AccessesData() {
		return (EReference)memoryAccessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferAccessData() {
		return bufferAccessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferAccessData_SourceActor() {
		return (EAttribute)bufferAccessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferAccessData_SourcePort() {
		return (EAttribute)bufferAccessDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferAccessData_TargetActor() {
		return (EAttribute)bufferAccessDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferAccessData_TargetPort() {
		return (EAttribute)bufferAccessDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateVariableAccessData() {
		return stateVariableAccessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStateVariableAccessData_Name() {
		return (EAttribute)stateVariableAccessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLocalVariableAccessData() {
		return localVariableAccessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLocalVariableAccessData_Name() {
		return (EAttribute)localVariableAccessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSharedVariableAccessData() {
		return sharedVariableAccessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSharedVariableAccessData_Name() {
		return (EAttribute)sharedVariableAccessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessData() {
		return accessDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccessData_Accesses() {
		return (EAttribute)accessDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccessData_Min() {
		return (EAttribute)accessDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccessData_Max() {
		return (EAttribute)accessDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccessData_Average() {
		return (EAttribute)accessDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccessData_Total() {
		return (EAttribute)accessDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringToAccessDataMap() {
		return stringToAccessDataMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStringToAccessDataMap_Value() {
		return (EReference)stringToAccessDataMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringToAccessDataMap_Key() {
		return (EAttribute)stringToAccessDataMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBenchmarkReport() {
		return benchmarkReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBenchmarkReport_Column_names() {
		return (EAttribute)benchmarkReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBenchmarkReport_Rows() {
		return (EReference)benchmarkReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTableRow() {
		return tableRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTableRow_Cells() {
		return (EReference)tableRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfilerFactory getProfilerFactory() {
		return (ProfilerFactory)getEFactoryInstance();
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
		codeProfilingReportEClass = createEClass(CODE_PROFILING_REPORT);
		createEReference(codeProfilingReportEClass, CODE_PROFILING_REPORT__NETWORK);
		createEReference(codeProfilingReportEClass, CODE_PROFILING_REPORT__ACTOR_CLASSES_DATA);
		createEReference(codeProfilingReportEClass, CODE_PROFILING_REPORT__NETWORK_DATA);
		createEOperation(codeProfilingReportEClass, CODE_PROFILING_REPORT___GET_ACTOR_CLASS_DATA__STRING);

		codeDataEClass = createEClass(CODE_DATA);
		createEReference(codeDataEClass, CODE_DATA__OPERATORS_COUNT);
		createEReference(codeDataEClass, CODE_DATA__OPERANDS_COUNT);
		createEAttribute(codeDataEClass, CODE_DATA__BLOCK_NAME);
		createEAttribute(codeDataEClass, CODE_DATA__NOL);

		complexCodeDataEClass = createEClass(COMPLEX_CODE_DATA);
		createEReference(complexCodeDataEClass, COMPLEX_CODE_DATA__ACTIONS_DATA);
		createEReference(complexCodeDataEClass, COMPLEX_CODE_DATA__PROCEDURES_DATA);
		createEOperation(complexCodeDataEClass, COMPLEX_CODE_DATA___GET_ACTION_DATA__STRING);
		createEOperation(complexCodeDataEClass, COMPLEX_CODE_DATA___GET_PROCEDURE_DATA__STRING);

		dynamicProfilingReportEClass = createEClass(DYNAMIC_PROFILING_REPORT);
		createEReference(dynamicProfilingReportEClass, DYNAMIC_PROFILING_REPORT__NETWORK);
		createEReference(dynamicProfilingReportEClass, DYNAMIC_PROFILING_REPORT__ACTORS_DATA);
		createEReference(dynamicProfilingReportEClass, DYNAMIC_PROFILING_REPORT__BUFFERS_DATA);

		actorDynamicDataEClass = createEClass(ACTOR_DYNAMIC_DATA);
		createEReference(actorDynamicDataEClass, ACTOR_DYNAMIC_DATA__ACTOR);
		createEReference(actorDynamicDataEClass, ACTOR_DYNAMIC_DATA__ACTIONS_DATA);

		actionDynamicDataEClass = createEClass(ACTION_DYNAMIC_DATA);
		createEReference(actionDynamicDataEClass, ACTION_DYNAMIC_DATA__ACTION);

		bufferDynamicDataEClass = createEClass(BUFFER_DYNAMIC_DATA);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__BUFFER);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__READS);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__WRITES);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__OCCUPANCY);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__ACTION_READS);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__ACTION_WRITES);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__ACTION_PEEKS);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES);
		createEReference(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES);
		createEAttribute(bufferDynamicDataEClass, BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS);

		complexDynamicDataEClass = createEClass(COMPLEX_DYNAMIC_DATA);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__VARIABLES_STORES);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__READ_TOKENS);
		createEReference(complexDynamicDataEClass, COMPLEX_DYNAMIC_DATA__WRITE_TOKENS);

		procedureToComplexDynamicDataMapEClass = createEClass(PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP);
		createEReference(procedureToComplexDynamicDataMapEClass, PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__KEY);
		createEReference(procedureToComplexDynamicDataMapEClass, PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP__VALUE);

		memoryProfilingReportEClass = createEClass(MEMORY_PROFILING_REPORT);
		createEAttribute(memoryProfilingReportEClass, MEMORY_PROFILING_REPORT__NETWORK_NAME);
		createEReference(memoryProfilingReportEClass, MEMORY_PROFILING_REPORT__ACTIONS_DATA);
		createEOperation(memoryProfilingReportEClass, MEMORY_PROFILING_REPORT___GET_ACTION_DATA__STRING_STRING);

		actionMemoryProfilingDataEClass = createEClass(ACTION_MEMORY_PROFILING_DATA);
		createEAttribute(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA__ACTOR);
		createEAttribute(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA__ACTION);
		createEReference(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA__READS);
		createEReference(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA__WRITES);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_READ_BUFFER_DATA__STRING_STRING_STRING_STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_WRITE_BUFFER_DATA__STRING_STRING_STRING_STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_READ_STATE_VARIABLE_DATA__STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_WRITE_STATE_VARIABLE_DATA__STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_READ_LOCAL_VARIABLE_DATA__STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_WRITE_LOCAL_VARIABLE_DATA__STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_READ_SHARED_VARIABLE_DATA__STRING);
		createEOperation(actionMemoryProfilingDataEClass, ACTION_MEMORY_PROFILING_DATA___GET_WRITE_SHARED_VARIABLE_DATA__STRING);

		memoryAccessDataEClass = createEClass(MEMORY_ACCESS_DATA);
		createEReference(memoryAccessDataEClass, MEMORY_ACCESS_DATA__ACCESSES_DATA);

		bufferAccessDataEClass = createEClass(BUFFER_ACCESS_DATA);
		createEAttribute(bufferAccessDataEClass, BUFFER_ACCESS_DATA__SOURCE_ACTOR);
		createEAttribute(bufferAccessDataEClass, BUFFER_ACCESS_DATA__SOURCE_PORT);
		createEAttribute(bufferAccessDataEClass, BUFFER_ACCESS_DATA__TARGET_ACTOR);
		createEAttribute(bufferAccessDataEClass, BUFFER_ACCESS_DATA__TARGET_PORT);

		stateVariableAccessDataEClass = createEClass(STATE_VARIABLE_ACCESS_DATA);
		createEAttribute(stateVariableAccessDataEClass, STATE_VARIABLE_ACCESS_DATA__NAME);

		localVariableAccessDataEClass = createEClass(LOCAL_VARIABLE_ACCESS_DATA);
		createEAttribute(localVariableAccessDataEClass, LOCAL_VARIABLE_ACCESS_DATA__NAME);

		sharedVariableAccessDataEClass = createEClass(SHARED_VARIABLE_ACCESS_DATA);
		createEAttribute(sharedVariableAccessDataEClass, SHARED_VARIABLE_ACCESS_DATA__NAME);

		accessDataEClass = createEClass(ACCESS_DATA);
		createEAttribute(accessDataEClass, ACCESS_DATA__ACCESSES);
		createEAttribute(accessDataEClass, ACCESS_DATA__MIN);
		createEAttribute(accessDataEClass, ACCESS_DATA__MAX);
		createEAttribute(accessDataEClass, ACCESS_DATA__AVERAGE);
		createEAttribute(accessDataEClass, ACCESS_DATA__TOTAL);

		stringToAccessDataMapEClass = createEClass(STRING_TO_ACCESS_DATA_MAP);
		createEReference(stringToAccessDataMapEClass, STRING_TO_ACCESS_DATA_MAP__VALUE);
		createEAttribute(stringToAccessDataMapEClass, STRING_TO_ACCESS_DATA_MAP__KEY);

		benchmarkReportEClass = createEClass(BENCHMARK_REPORT);
		createEAttribute(benchmarkReportEClass, BENCHMARK_REPORT__COLUMN_NAMES);
		createEReference(benchmarkReportEClass, BENCHMARK_REPORT__ROWS);

		tableRowEClass = createEClass(TABLE_ROW);
		createEReference(tableRowEClass, TABLE_ROW__CELLS);
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
		CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		codeProfilingReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		complexCodeDataEClass.getESuperTypes().add(this.getCodeData());
		dynamicProfilingReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		actorDynamicDataEClass.getESuperTypes().add(this.getComplexDynamicData());
		actionDynamicDataEClass.getESuperTypes().add(this.getComplexDynamicData());
		memoryProfilingReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		bufferAccessDataEClass.getESuperTypes().add(this.getMemoryAccessData());
		stateVariableAccessDataEClass.getESuperTypes().add(this.getMemoryAccessData());
		localVariableAccessDataEClass.getESuperTypes().add(this.getMemoryAccessData());
		sharedVariableAccessDataEClass.getESuperTypes().add(this.getMemoryAccessData());
		benchmarkReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(codeProfilingReportEClass, CodeProfilingReport.class, "CodeProfilingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeProfilingReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, CodeProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeProfilingReport_ActorClassesData(), this.getComplexCodeData(), null, "actorClassesData", null, 0, -1, CodeProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeProfilingReport_NetworkData(), this.getComplexCodeData(), null, "networkData", null, 1, 1, CodeProfilingReport.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getCodeProfilingReport__GetActorClassData__String(), this.getComplexCodeData(), "getActorClassData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "actorClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(codeDataEClass, CodeData.class, "CodeData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeData_OperatorsCount(), theMapPackage.getStringToIntegerMap(), null, "operatorsCount", null, 0, -1, CodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeData_OperandsCount(), theMapPackage.getStringToIntegerMap(), null, "operandsCount", null, 0, -1, CodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeData_BlockName(), ecorePackage.getEString(), "blockName", null, 1, 1, CodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeData_Nol(), ecorePackage.getELong(), "nol", null, 0, 1, CodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexCodeDataEClass, ComplexCodeData.class, "ComplexCodeData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexCodeData_ActionsData(), this.getCodeData(), null, "actionsData", null, 0, -1, ComplexCodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexCodeData_ProceduresData(), this.getCodeData(), null, "proceduresData", null, 0, -1, ComplexCodeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getComplexCodeData__GetActionData__String(), this.getCodeData(), "getActionData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComplexCodeData__GetProcedureData__String(), this.getCodeData(), "getProcedureData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "procedure", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dynamicProfilingReportEClass, DynamicProfilingReport.class, "DynamicProfilingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDynamicProfilingReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, DynamicProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicProfilingReport_ActorsData(), this.getActorDynamicData(), null, "actorsData", null, 0, -1, DynamicProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicProfilingReport_BuffersData(), this.getBufferDynamicData(), null, "buffersData", null, 0, -1, DynamicProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorDynamicDataEClass, ActorDynamicData.class, "ActorDynamicData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorDynamicData_Actor(), theDataflowPackage.getActor(), null, "actor", null, 0, 1, ActorDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorDynamicData_ActionsData(), this.getActionDynamicData(), null, "actionsData", null, 0, -1, ActorDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionDynamicDataEClass, ActionDynamicData.class, "ActionDynamicData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionDynamicData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, ActionDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDynamicDataEClass, BufferDynamicData.class, "BufferDynamicData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferDynamicData_Buffer(), theDataflowPackage.getBuffer(), null, "buffer", null, 0, 1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_Reads(), theCommonPackage.getStatisticalData(), null, "reads", null, 0, 1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_Writes(), theCommonPackage.getStatisticalData(), null, "writes", null, 0, 1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_Occupancy(), theCommonPackage.getStatisticalData(), null, "occupancy", null, 0, 1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_ActionReads(), theMapPackage.getActionToStatisticalDataMap(), null, "actionReads", null, 0, -1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_ActionWrites(), theMapPackage.getActionToStatisticalDataMap(), null, "actionWrites", null, 0, -1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_ActionPeeks(), theMapPackage.getActionToLongMap(), null, "actionPeeks", null, 0, -1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_ActionReadMisses(), theMapPackage.getActionToLongMap(), null, "actionReadMisses", null, 0, -1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferDynamicData_ActionWriteMisses(), theMapPackage.getActionToLongMap(), null, "actionWriteMisses", null, 0, -1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDynamicData_UnconsumedTokens(), ecorePackage.getEInt(), "unconsumedTokens", null, 0, 1, BufferDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexDynamicDataEClass, ComplexDynamicData.class, "ComplexDynamicData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexDynamicData_OperandsCalls(), theMapPackage.getEOperatorToStatisticalDataMap(), null, "operandsCalls", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_ProceduresCalls(), theMapPackage.getProcedureToStatisticalDataMap(), null, "proceduresCalls", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_VariablesStores(), theMapPackage.getVariableToStatisticalDataMap(), null, "variablesStores", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_VariablesLoads(), theMapPackage.getVariableToStatisticalDataMap(), null, "variablesLoads", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_ProceduresData(), this.getProcedureToComplexDynamicDataMap(), null, "proceduresData", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_ReadTokens(), theMapPackage.getBufferToStatisticalDataMap(), null, "readTokens", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexDynamicData_WriteTokens(), theMapPackage.getBufferToStatisticalDataMap(), null, "writeTokens", null, 0, -1, ComplexDynamicData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procedureToComplexDynamicDataMapEClass, Map.Entry.class, "ProcedureToComplexDynamicDataMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedureToComplexDynamicDataMap_Key(), theDataflowPackage.getProcedure(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcedureToComplexDynamicDataMap_Value(), this.getComplexDynamicData(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryProfilingReportEClass, MemoryProfilingReport.class, "MemoryProfilingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemoryProfilingReport_NetworkName(), ecorePackage.getEString(), "networkName", null, 0, 1, MemoryProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemoryProfilingReport_ActionsData(), this.getActionMemoryProfilingData(), null, "actionsData", null, 0, -1, MemoryProfilingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMemoryProfilingReport__GetActionData__String_String(), this.getActionMemoryProfilingData(), "getActionData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "actor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(actionMemoryProfilingDataEClass, ActionMemoryProfilingData.class, "ActionMemoryProfilingData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionMemoryProfilingData_Actor(), ecorePackage.getEString(), "actor", null, 1, 1, ActionMemoryProfilingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionMemoryProfilingData_Action(), ecorePackage.getEString(), "action", null, 1, 1, ActionMemoryProfilingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionMemoryProfilingData_Reads(), this.getMemoryAccessData(), null, "reads", null, 0, -1, ActionMemoryProfilingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionMemoryProfilingData_Writes(), this.getMemoryAccessData(), null, "writes", null, 0, -1, ActionMemoryProfilingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetReadBufferData__String_String_String_String(), this.getBufferAccessData(), "getReadBufferData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sourceActor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sourcePort", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "targetActor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "targetPort", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetWriteBufferData__String_String_String_String(), this.getBufferAccessData(), "getWriteBufferData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sourceActor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sourcePort", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "targetActor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "targetPort", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetReadStateVariableData__String(), this.getStateVariableAccessData(), "getReadStateVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetWriteStateVariableData__String(), this.getStateVariableAccessData(), "getWriteStateVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetReadLocalVariableData__String(), this.getLocalVariableAccessData(), "getReadLocalVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetWriteLocalVariableData__String(), this.getLocalVariableAccessData(), "getWriteLocalVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetReadSharedVariableData__String(), this.getSharedVariableAccessData(), "getReadSharedVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getActionMemoryProfilingData__GetWriteSharedVariableData__String(), this.getSharedVariableAccessData(), "getWriteSharedVariableData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(memoryAccessDataEClass, MemoryAccessData.class, "MemoryAccessData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemoryAccessData_AccessesData(), this.getStringToAccessDataMap(), null, "accessesData", null, 0, -1, MemoryAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferAccessDataEClass, BufferAccessData.class, "BufferAccessData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBufferAccessData_SourceActor(), ecorePackage.getEString(), "sourceActor", null, 1, 1, BufferAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferAccessData_SourcePort(), ecorePackage.getEString(), "sourcePort", null, 1, 1, BufferAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferAccessData_TargetActor(), ecorePackage.getEString(), "targetActor", null, 1, 1, BufferAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferAccessData_TargetPort(), ecorePackage.getEString(), "targetPort", null, 1, 1, BufferAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateVariableAccessDataEClass, StateVariableAccessData.class, "StateVariableAccessData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateVariableAccessData_Name(), ecorePackage.getEString(), "name", null, 1, 1, StateVariableAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localVariableAccessDataEClass, LocalVariableAccessData.class, "LocalVariableAccessData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalVariableAccessData_Name(), ecorePackage.getEString(), "name", null, 1, 1, LocalVariableAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sharedVariableAccessDataEClass, SharedVariableAccessData.class, "SharedVariableAccessData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSharedVariableAccessData_Name(), ecorePackage.getEString(), "name", null, 1, 1, SharedVariableAccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessDataEClass, AccessData.class, "AccessData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccessData_Accesses(), ecorePackage.getEDouble(), "accesses", null, 0, 1, AccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessData_Min(), ecorePackage.getEDouble(), "min", null, 0, 1, AccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessData_Max(), ecorePackage.getEDouble(), "max", null, 0, 1, AccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessData_Average(), ecorePackage.getEDouble(), "average", "0", 0, 1, AccessData.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAccessData_Total(), ecorePackage.getEDouble(), "total", null, 0, 1, AccessData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToAccessDataMapEClass, Map.Entry.class, "StringToAccessDataMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringToAccessDataMap_Value(), this.getAccessData(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToAccessDataMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(benchmarkReportEClass, BenchmarkReport.class, "BenchmarkReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBenchmarkReport_Column_names(), ecorePackage.getEString(), "column_names", null, 0, -1, BenchmarkReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBenchmarkReport_Rows(), this.getTableRow(), null, "rows", null, 0, -1, BenchmarkReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableRowEClass, TableRow.class, "TableRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTableRow_Cells(), theMapPackage.getStringToStringMap(), null, "cells", null, 0, -1, TableRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ProfilerPackageImpl

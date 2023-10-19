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
package turnus.model.analysis.profiling.impl;

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

import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.IntraActionCommunicationData;
import turnus.model.analysis.profiling.IntraActionCommunicationReport;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.analysis.profiling.ProfilingStatsActorData;
import turnus.model.analysis.profiling.ProfilingStatsReport;

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
public class ProfilingPackageImpl extends EPackageImpl implements ProfilingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intraActionCommunicationReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intraActorCommunicationDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intraActionCommunicationDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profilingStatsReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profilingStatsActorDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interPartitionDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interPartitionCommunicationAndMemoryReportEClass = null;

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
	 * @see turnus.model.analysis.profiling.ProfilingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProfilingPackageImpl() {
		super(eNS_URI, ProfilingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProfilingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProfilingPackage init() {
		if (isInited) return (ProfilingPackage)EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProfilingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProfilingPackageImpl theProfilingPackage = registeredProfilingPackage instanceof ProfilingPackageImpl ? (ProfilingPackageImpl)registeredProfilingPackage : new ProfilingPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(registeredPackage instanceof SchedulingPackageImpl ? registeredPackage : SchedulingPackage.eINSTANCE);

		// Create package meta-data objects
		theProfilingPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		thePostprocessingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		theProfilingPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		thePostprocessingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProfilingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProfilingPackage.eNS_URI, theProfilingPackage);
		return theProfilingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntraActionCommunicationReport() {
		return intraActionCommunicationReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationReport_ActorsData() {
		return (EReference)intraActionCommunicationReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationReport_Network() {
		return (EReference)intraActionCommunicationReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntraActorCommunicationData() {
		return intraActorCommunicationDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActorCommunicationData_Actor() {
		return (EReference)intraActorCommunicationDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActorCommunicationData_ConsumedTokens() {
		return (EReference)intraActorCommunicationDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActorCommunicationData_ProducedTokens() {
		return (EReference)intraActorCommunicationDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActorCommunicationData_TokensProducersMap() {
		return (EReference)intraActorCommunicationDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActorCommunicationData_ActionsData() {
		return (EReference)intraActorCommunicationDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntraActionCommunicationData() {
		return intraActionCommunicationDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationData_Action() {
		return (EReference)intraActionCommunicationDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationData_ConsumedTokens() {
		return (EReference)intraActionCommunicationDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationData_ProducedTokens() {
		return (EReference)intraActionCommunicationDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIntraActionCommunicationData_TokensProducersMap() {
		return (EReference)intraActionCommunicationDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProfilingStatsReport() {
		return profilingStatsReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProfilingStatsReport_ActorsStatsData() {
		return (EReference)profilingStatsReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsReport_NetworkName() {
		return (EAttribute)profilingStatsReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProfilingStatsActorData() {
		return profilingStatsActorDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsActorData_ActorName() {
		return (EAttribute)profilingStatsActorDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsActorData_ActionsWeight() {
		return (EAttribute)profilingStatsActorDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsActorData_SchedulerWeight() {
		return (EAttribute)profilingStatsActorDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsActorData_ActionsWeightPercent() {
		return (EAttribute)profilingStatsActorDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfilingStatsActorData_SchedulerWeightPercent() {
		return (EAttribute)profilingStatsActorDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterPartitionData() {
		return interPartitionDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionData_Actors() {
		return (EReference)interPartitionDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_Workload() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_MaxIncomingBitsPerFiring() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_MaxOutgoingBitsPerFiring() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_PersistentMemory() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_MaxTransientMemory() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_PartitionId() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionData_PersistentBuffers() {
		return (EAttribute)interPartitionDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionData_InternalBuffers() {
		return (EReference)interPartitionDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionData_IncomingBuffers() {
		return (EReference)interPartitionDataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionData_OutgoingBuffers() {
		return (EReference)interPartitionDataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterPartitionCommunicationAndMemoryReport() {
		return interPartitionCommunicationAndMemoryReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionCommunicationAndMemoryReport_PartitionData() {
		return (EReference)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionCommunicationAndMemoryReport_Network() {
		return (EReference)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_OutgoingBufferOwnedBySource() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionCommunicationAndMemoryReport_BufferDepthMap() {
		return (EReference)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterPartitionCommunicationAndMemoryReport_ActorPartitionMap() {
		return (EReference)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_CpWeight() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_Time() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_Deadlock() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_CpWeightScheduled() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_MappingFile() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInterPartitionCommunicationAndMemoryReport_BufferFile() {
		return (EAttribute)interPartitionCommunicationAndMemoryReportEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfilingFactory getProfilingFactory() {
		return (ProfilingFactory)getEFactoryInstance();
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
		intraActionCommunicationReportEClass = createEClass(INTRA_ACTION_COMMUNICATION_REPORT);
		createEReference(intraActionCommunicationReportEClass, INTRA_ACTION_COMMUNICATION_REPORT__ACTORS_DATA);
		createEReference(intraActionCommunicationReportEClass, INTRA_ACTION_COMMUNICATION_REPORT__NETWORK);

		intraActorCommunicationDataEClass = createEClass(INTRA_ACTOR_COMMUNICATION_DATA);
		createEReference(intraActorCommunicationDataEClass, INTRA_ACTOR_COMMUNICATION_DATA__ACTOR);
		createEReference(intraActorCommunicationDataEClass, INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS);
		createEReference(intraActorCommunicationDataEClass, INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS);
		createEReference(intraActorCommunicationDataEClass, INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP);
		createEReference(intraActorCommunicationDataEClass, INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA);

		intraActionCommunicationDataEClass = createEClass(INTRA_ACTION_COMMUNICATION_DATA);
		createEReference(intraActionCommunicationDataEClass, INTRA_ACTION_COMMUNICATION_DATA__ACTION);
		createEReference(intraActionCommunicationDataEClass, INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS);
		createEReference(intraActionCommunicationDataEClass, INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS);
		createEReference(intraActionCommunicationDataEClass, INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP);

		profilingStatsReportEClass = createEClass(PROFILING_STATS_REPORT);
		createEReference(profilingStatsReportEClass, PROFILING_STATS_REPORT__ACTORS_STATS_DATA);
		createEAttribute(profilingStatsReportEClass, PROFILING_STATS_REPORT__NETWORK_NAME);

		profilingStatsActorDataEClass = createEClass(PROFILING_STATS_ACTOR_DATA);
		createEAttribute(profilingStatsActorDataEClass, PROFILING_STATS_ACTOR_DATA__ACTOR_NAME);
		createEAttribute(profilingStatsActorDataEClass, PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT);
		createEAttribute(profilingStatsActorDataEClass, PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT);
		createEAttribute(profilingStatsActorDataEClass, PROFILING_STATS_ACTOR_DATA__ACTIONS_WEIGHT_PERCENT);
		createEAttribute(profilingStatsActorDataEClass, PROFILING_STATS_ACTOR_DATA__SCHEDULER_WEIGHT_PERCENT);

		interPartitionDataEClass = createEClass(INTER_PARTITION_DATA);
		createEReference(interPartitionDataEClass, INTER_PARTITION_DATA__ACTORS);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__WORKLOAD);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__PERSISTENT_MEMORY);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__PARTITION_ID);
		createEAttribute(interPartitionDataEClass, INTER_PARTITION_DATA__PERSISTENT_BUFFERS);
		createEReference(interPartitionDataEClass, INTER_PARTITION_DATA__INTERNAL_BUFFERS);
		createEReference(interPartitionDataEClass, INTER_PARTITION_DATA__INCOMING_BUFFERS);
		createEReference(interPartitionDataEClass, INTER_PARTITION_DATA__OUTGOING_BUFFERS);

		interPartitionCommunicationAndMemoryReportEClass = createEClass(INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT);
		createEReference(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA);
		createEReference(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__NETWORK);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__OUTGOING_BUFFER_OWNED_BY_SOURCE);
		createEReference(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_DEPTH_MAP);
		createEReference(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ACTOR_PARTITION_MAP);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__TIME);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DEADLOCK);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__CP_WEIGHT_SCHEDULED);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__MAPPING_FILE);
		createEAttribute(interPartitionCommunicationAndMemoryReportEClass, INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__BUFFER_FILE);
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
		MapPackage theMapPackage = (MapPackage)EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		intraActionCommunicationReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		profilingStatsReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		interPartitionCommunicationAndMemoryReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());

		// Initialize classes, features, and operations; add parameters
		initEClass(intraActionCommunicationReportEClass, IntraActionCommunicationReport.class, "IntraActionCommunicationReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntraActionCommunicationReport_ActorsData(), this.getIntraActorCommunicationData(), null, "actorsData", null, 0, -1, IntraActionCommunicationReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActionCommunicationReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, IntraActionCommunicationReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intraActorCommunicationDataEClass, IntraActorCommunicationData.class, "IntraActorCommunicationData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntraActorCommunicationData_Actor(), theDataflowPackage.getActor(), null, "actor", null, 0, 1, IntraActorCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActorCommunicationData_ConsumedTokens(), theCommonPackage.getStatisticalData(), null, "consumedTokens", null, 0, 1, IntraActorCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActorCommunicationData_ProducedTokens(), theCommonPackage.getStatisticalData(), null, "producedTokens", null, 0, 1, IntraActorCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActorCommunicationData_TokensProducersMap(), theMapPackage.getActorToStatisticalDataMap(), null, "tokensProducersMap", null, 0, -1, IntraActorCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActorCommunicationData_ActionsData(), this.getIntraActionCommunicationData(), null, "actionsData", null, 0, -1, IntraActorCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intraActionCommunicationDataEClass, IntraActionCommunicationData.class, "IntraActionCommunicationData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntraActionCommunicationData_Action(), theDataflowPackage.getAction(), null, "action", null, 0, 1, IntraActionCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActionCommunicationData_ConsumedTokens(), theCommonPackage.getStatisticalData(), null, "consumedTokens", null, 0, 1, IntraActionCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActionCommunicationData_ProducedTokens(), theCommonPackage.getStatisticalData(), null, "producedTokens", null, 0, 1, IntraActionCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntraActionCommunicationData_TokensProducersMap(), theMapPackage.getActionToStatisticalDataMap(), null, "tokensProducersMap", null, 0, -1, IntraActionCommunicationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(profilingStatsReportEClass, ProfilingStatsReport.class, "ProfilingStatsReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfilingStatsReport_ActorsStatsData(), this.getProfilingStatsActorData(), null, "actorsStatsData", null, 0, -1, ProfilingStatsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfilingStatsReport_NetworkName(), ecorePackage.getEString(), "networkName", null, 0, 1, ProfilingStatsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(profilingStatsActorDataEClass, ProfilingStatsActorData.class, "ProfilingStatsActorData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProfilingStatsActorData_ActorName(), ecorePackage.getEString(), "actorName", null, 0, 1, ProfilingStatsActorData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfilingStatsActorData_ActionsWeight(), ecorePackage.getEDouble(), "actionsWeight", null, 0, 1, ProfilingStatsActorData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfilingStatsActorData_SchedulerWeight(), ecorePackage.getEDouble(), "schedulerWeight", null, 0, 1, ProfilingStatsActorData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfilingStatsActorData_ActionsWeightPercent(), ecorePackage.getEDouble(), "actionsWeightPercent", null, 0, 1, ProfilingStatsActorData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfilingStatsActorData_SchedulerWeightPercent(), ecorePackage.getEDouble(), "schedulerWeightPercent", null, 0, 1, ProfilingStatsActorData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interPartitionDataEClass, InterPartitionData.class, "InterPartitionData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterPartitionData_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_Workload(), ecorePackage.getEDouble(), "workload", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_MaxIncomingBitsPerFiring(), ecorePackage.getELong(), "maxIncomingBitsPerFiring", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_MaxOutgoingBitsPerFiring(), ecorePackage.getELong(), "maxOutgoingBitsPerFiring", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_PersistentMemory(), ecorePackage.getELong(), "persistentMemory", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_MaxTransientMemory(), ecorePackage.getELong(), "maxTransientMemory", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_PartitionId(), ecorePackage.getEString(), "partitionId", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionData_PersistentBuffers(), ecorePackage.getELong(), "persistentBuffers", null, 0, 1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionData_InternalBuffers(), theDataflowPackage.getBuffer(), null, "internalBuffers", null, 0, -1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionData_IncomingBuffers(), theDataflowPackage.getBuffer(), null, "incomingBuffers", null, 0, -1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionData_OutgoingBuffers(), theDataflowPackage.getBuffer(), null, "outgoingBuffers", null, 0, -1, InterPartitionData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interPartitionCommunicationAndMemoryReportEClass, InterPartitionCommunicationAndMemoryReport.class, "InterPartitionCommunicationAndMemoryReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterPartitionCommunicationAndMemoryReport_PartitionData(), this.getInterPartitionData(), null, "partitionData", null, 0, -1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionCommunicationAndMemoryReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_OutgoingBufferOwnedBySource(), ecorePackage.getEBoolean(), "outgoingBufferOwnedBySource", "false", 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionCommunicationAndMemoryReport_BufferDepthMap(), theMapPackage.getBufferToIntegerMap(), null, "bufferDepthMap", null, 0, -1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterPartitionCommunicationAndMemoryReport_ActorPartitionMap(), theMapPackage.getActorToStringMap(), null, "actorPartitionMap", null, 0, -1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_CpWeight(), ecorePackage.getEDouble(), "cpWeight", null, 1, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_Time(), ecorePackage.getEDouble(), "time", null, 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_Deadlock(), ecorePackage.getEBoolean(), "deadlock", null, 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_CpWeightScheduled(), ecorePackage.getEDouble(), "cpWeightScheduled", null, 1, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_MappingFile(), ecorePackage.getEString(), "mappingFile", null, 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterPartitionCommunicationAndMemoryReport_BufferFile(), ecorePackage.getEString(), "bufferFile", null, 0, 1, InterPartitionCommunicationAndMemoryReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ProfilingPackageImpl

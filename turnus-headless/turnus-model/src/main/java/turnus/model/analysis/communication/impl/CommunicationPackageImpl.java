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
package turnus.model.analysis.communication.impl;

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

import turnus.model.analysis.communication.CommunicationFactory;
import turnus.model.analysis.communication.CommunicationModel;
import turnus.model.analysis.communication.CommunicationPackage;
import turnus.model.analysis.communication.CommunicationWeigthReport;
import turnus.model.analysis.communication.LinearCommunicationModel;
import turnus.model.analysis.communication.SigmoidCommunicationModel;

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
public class CommunicationPackageImpl extends EPackageImpl implements CommunicationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationWeigthReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearCommunicationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sigmoidCommunicationModelEClass = null;

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
	 * @see turnus.model.analysis.communication.CommunicationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommunicationPackageImpl() {
		super(eNS_URI, CommunicationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CommunicationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommunicationPackage init() {
		if (isInited) return (CommunicationPackage)EPackage.Registry.INSTANCE.getEPackage(CommunicationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCommunicationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CommunicationPackageImpl theCommunicationPackage = registeredCommunicationPackage instanceof CommunicationPackageImpl ? (CommunicationPackageImpl)registeredCommunicationPackage : new CommunicationPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI);
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(registeredPackage instanceof ProfilingPackageImpl ? registeredPackage : ProfilingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(registeredPackage instanceof SchedulingPackageImpl ? registeredPackage : SchedulingPackage.eINSTANCE);

		// Create package meta-data objects
		theCommunicationPackage.createPackageContents();
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
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		theCommunicationPackage.initializePackageContents();
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
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommunicationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommunicationPackage.eNS_URI, theCommunicationPackage);
		return theCommunicationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCommunicationWeigthReport() {
		return communicationWeigthReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCommunicationWeigthReport_Network() {
		return (EReference)communicationWeigthReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCommunicationWeigthReport_Model() {
		return (EReference)communicationWeigthReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCommunicationWeigthReport_BufferLatency() {
		return (EReference)communicationWeigthReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCommunicationModel() {
		return communicationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCommunicationModel_Name() {
		return (EAttribute)communicationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLinearCommunicationModel() {
		return linearCommunicationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLinearCommunicationModel_ConstantBandwidth() {
		return (EAttribute)linearCommunicationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLinearCommunicationModel_FixedOverheadLatency() {
		return (EAttribute)linearCommunicationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSigmoidCommunicationModel() {
		return sigmoidCommunicationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSigmoidCommunicationModel_CarryingCapacity() {
		return (EAttribute)sigmoidCommunicationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSigmoidCommunicationModel_GrowthRate() {
		return (EAttribute)sigmoidCommunicationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSigmoidCommunicationModel_Midpoint() {
		return (EAttribute)sigmoidCommunicationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommunicationFactory getCommunicationFactory() {
		return (CommunicationFactory)getEFactoryInstance();
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
		communicationWeigthReportEClass = createEClass(COMMUNICATION_WEIGTH_REPORT);
		createEReference(communicationWeigthReportEClass, COMMUNICATION_WEIGTH_REPORT__NETWORK);
		createEReference(communicationWeigthReportEClass, COMMUNICATION_WEIGTH_REPORT__MODEL);
		createEReference(communicationWeigthReportEClass, COMMUNICATION_WEIGTH_REPORT__BUFFER_LATENCY);

		communicationModelEClass = createEClass(COMMUNICATION_MODEL);
		createEAttribute(communicationModelEClass, COMMUNICATION_MODEL__NAME);

		linearCommunicationModelEClass = createEClass(LINEAR_COMMUNICATION_MODEL);
		createEAttribute(linearCommunicationModelEClass, LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH);
		createEAttribute(linearCommunicationModelEClass, LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY);

		sigmoidCommunicationModelEClass = createEClass(SIGMOID_COMMUNICATION_MODEL);
		createEAttribute(sigmoidCommunicationModelEClass, SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY);
		createEAttribute(sigmoidCommunicationModelEClass, SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE);
		createEAttribute(sigmoidCommunicationModelEClass, SIGMOID_COMMUNICATION_MODEL__MIDPOINT);
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
		communicationWeigthReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		linearCommunicationModelEClass.getESuperTypes().add(this.getCommunicationModel());
		sigmoidCommunicationModelEClass.getESuperTypes().add(this.getCommunicationModel());

		// Initialize classes, features, and operations; add parameters
		initEClass(communicationWeigthReportEClass, CommunicationWeigthReport.class, "CommunicationWeigthReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunicationWeigthReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, CommunicationWeigthReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommunicationWeigthReport_Model(), this.getCommunicationModel(), null, "model", null, 0, 1, CommunicationWeigthReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommunicationWeigthReport_BufferLatency(), theMapPackage.getBufferToDoubleMap(), null, "bufferLatency", null, 0, -1, CommunicationWeigthReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(communicationModelEClass, CommunicationModel.class, "CommunicationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommunicationModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, CommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linearCommunicationModelEClass, LinearCommunicationModel.class, "LinearCommunicationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearCommunicationModel_ConstantBandwidth(), ecorePackage.getEDouble(), "constantBandwidth", null, 0, 1, LinearCommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearCommunicationModel_FixedOverheadLatency(), ecorePackage.getEDouble(), "fixedOverheadLatency", null, 0, 1, LinearCommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sigmoidCommunicationModelEClass, SigmoidCommunicationModel.class, "SigmoidCommunicationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSigmoidCommunicationModel_CarryingCapacity(), ecorePackage.getEDouble(), "carryingCapacity", null, 0, 1, SigmoidCommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSigmoidCommunicationModel_GrowthRate(), ecorePackage.getEDouble(), "growthRate", null, 0, 1, SigmoidCommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSigmoidCommunicationModel_Midpoint(), ecorePackage.getEDouble(), "midpoint", null, 0, 1, SigmoidCommunicationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CommunicationPackageImpl

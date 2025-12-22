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
package turnus.model.analysis.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import turnus.model.analysis.AnalysisFactory;
import turnus.model.analysis.AnalysisPackage;
import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.bottlenecks.BottlenecksPackage;

import turnus.model.analysis.bottlenecks.impl.BottlenecksPackageImpl;

import turnus.model.analysis.buffers.BuffersPackage;

import turnus.model.analysis.buffers.impl.BuffersPackageImpl;

import turnus.model.analysis.communication.CommunicationPackage;
import turnus.model.analysis.communication.impl.CommunicationPackageImpl;
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
public class AnalysisPackageImpl extends EPackageImpl implements AnalysisPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analysisReportEClass = null;

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
	 * @see turnus.model.analysis.AnalysisPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnalysisPackageImpl() {
		super(eNS_URI, AnalysisFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AnalysisPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnalysisPackage init() {
		if (isInited) return (AnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAnalysisPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AnalysisPackageImpl theAnalysisPackage = registeredAnalysisPackage instanceof AnalysisPackageImpl ? (AnalysisPackageImpl)registeredAnalysisPackage : new AnalysisPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CommonPackage.eINSTANCE.eClass();
		DataflowPackage.eINSTANCE.eClass();
		VersioningPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI);
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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CommunicationPackage.eNS_URI);
		CommunicationPackageImpl theCommunicationPackage = (CommunicationPackageImpl)(registeredPackage instanceof CommunicationPackageImpl ? registeredPackage : CommunicationPackage.eINSTANCE);

		// Create package meta-data objects
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
		theCommunicationPackage.createPackageContents();

		// Initialize created meta-data
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
		theCommunicationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnalysisPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnalysisPackage.eNS_URI, theAnalysisPackage);
		return theAnalysisPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnalysisReport() {
		return analysisReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalysisReport_Algorithm() {
		return (EAttribute)analysisReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalysisReport_Date() {
		return (EAttribute)analysisReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnalysisFactory getAnalysisFactory() {
		return (AnalysisFactory)getEFactoryInstance();
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
		analysisReportEClass = createEClass(ANALYSIS_REPORT);
		createEAttribute(analysisReportEClass, ANALYSIS_REPORT__ALGORITHM);
		createEAttribute(analysisReportEClass, ANALYSIS_REPORT__DATE);
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
		ProfilerPackage theProfilerPackage = (ProfilerPackage)EPackage.Registry.INSTANCE.getEPackage(ProfilerPackage.eNS_URI);
		MapPackage theMapPackage = (MapPackage)EPackage.Registry.INSTANCE.getEPackage(MapPackage.eNS_URI);
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		BottlenecksPackage theBottlenecksPackage = (BottlenecksPackage)EPackage.Registry.INSTANCE.getEPackage(BottlenecksPackage.eNS_URI);
		BuffersPackage theBuffersPackage = (BuffersPackage)EPackage.Registry.INSTANCE.getEPackage(BuffersPackage.eNS_URI);
		PartitioningPackage thePartitioningPackage = (PartitioningPackage)EPackage.Registry.INSTANCE.getEPackage(PartitioningPackage.eNS_URI);
		PipeliningPackage thePipeliningPackage = (PipeliningPackage)EPackage.Registry.INSTANCE.getEPackage(PipeliningPackage.eNS_URI);
		PostprocessingPackage thePostprocessingPackage = (PostprocessingPackage)EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);
		ProfilingPackage theProfilingPackage = (ProfilingPackage)EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI);
		SchedulingPackage theSchedulingPackage = (SchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI);
		CommunicationPackage theCommunicationPackage = (CommunicationPackage)EPackage.Registry.INSTANCE.getEPackage(CommunicationPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theProfilerPackage);
		getESubpackages().add(theMapPackage);
		getESubpackages().add(theTracePackage);
		getESubpackages().add(theBottlenecksPackage);
		getESubpackages().add(theBuffersPackage);
		getESubpackages().add(thePartitioningPackage);
		getESubpackages().add(thePipeliningPackage);
		getESubpackages().add(thePostprocessingPackage);
		getESubpackages().add(theProfilingPackage);
		getESubpackages().add(theSchedulingPackage);
		getESubpackages().add(theCommunicationPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(analysisReportEClass, AnalysisReport.class, "AnalysisReport", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnalysisReport_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, AnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisReport_Date(), ecorePackage.getEDate(), "date", null, 0, 1, AnalysisReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AnalysisPackageImpl

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
package turnus.model.analysis.postprocessing.impl;

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
import turnus.model.analysis.postprocessing.ActionStatisticsReport;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.analysis.postprocessing.PostprocessingPackage;

import turnus.model.analysis.postprocessing.SchedulerChecksPartition;
import turnus.model.analysis.postprocessing.SchedulerChecksReport;
import turnus.model.analysis.postprocessing.StatisticalActorPartition;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PostprocessingPackageImpl extends EPackageImpl implements PostprocessingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postProcessingReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postProcessingDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorStatisticsReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statisticalActorPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionStatisticsReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerChecksReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerChecksPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferBlockingReportEClass = null;

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
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PostprocessingPackageImpl() {
		super(eNS_URI, PostprocessingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PostprocessingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PostprocessingPackage init() {
		if (isInited) return (PostprocessingPackage)EPackage.Registry.INSTANCE.getEPackage(PostprocessingPackage.eNS_URI);

		// Obtain or create and register package
		PostprocessingPackageImpl thePostprocessingPackage = (PostprocessingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PostprocessingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PostprocessingPackageImpl());

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
		ProfilingPackageImpl theProfilingPackage = (ProfilingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) instanceof ProfilingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProfilingPackage.eNS_URI) : ProfilingPackage.eINSTANCE);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);

		// Create package meta-data objects
		thePostprocessingPackage.createPackageContents();
		theAnalysisPackage.createPackageContents();
		theProfilerPackage.createPackageContents();
		theMapPackage.createPackageContents();
		theTracePackage.createPackageContents();
		theBottlenecksPackage.createPackageContents();
		theBuffersPackage.createPackageContents();
		thePartitioningPackage.createPackageContents();
		thePipeliningPackage.createPackageContents();
		theProfilingPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		thePostprocessingPackage.initializePackageContents();
		theAnalysisPackage.initializePackageContents();
		theProfilerPackage.initializePackageContents();
		theMapPackage.initializePackageContents();
		theTracePackage.initializePackageContents();
		theBottlenecksPackage.initializePackageContents();
		theBuffersPackage.initializePackageContents();
		thePartitioningPackage.initializePackageContents();
		thePipeliningPackage.initializePackageContents();
		theProfilingPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePostprocessingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PostprocessingPackage.eNS_URI, thePostprocessingPackage);
		return thePostprocessingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostProcessingReport() {
		return postProcessingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostProcessingReport_Network() {
		return (EReference)postProcessingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostProcessingReport_Time() {
		return (EAttribute)postProcessingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostProcessingReport_Deadlock() {
		return (EAttribute)postProcessingReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostProcessingReport_Reports() {
		return (EReference)postProcessingReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostProcessingData() {
		return postProcessingDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorStatisticsReport() {
		return actorStatisticsReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_Network() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorStatisticsReport_ExecutionTime() {
		return (EAttribute)actorStatisticsReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_Partitions() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_IdleTimes() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_BlockedReadingTimes() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_BlockedWritingTimes() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorStatisticsReport_ProcessingTimes() {
		return (EReference)actorStatisticsReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorStatisticsReport_AverageOccupancy() {
		return (EAttribute)actorStatisticsReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorStatisticsReport_OccupancyDeviation() {
		return (EAttribute)actorStatisticsReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatisticalActorPartition() {
		return statisticalActorPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalActorPartition_Actors() {
		return (EAttribute)statisticalActorPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalActorPartition_Occupancy() {
		return (EAttribute)statisticalActorPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticalActorPartition_SchedulingPolicy() {
		return (EAttribute)statisticalActorPartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionStatisticsReport() {
		return actionStatisticsReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_Actors() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_IdleTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_IdleMinTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_IdleMaxTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedReadingTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedReadingMinTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedReadingMaxTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedWritingTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedWritingMinTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_BlockedWritingMaxTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_ProcessingTimes() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionStatisticsReport_ExecutionCounts() {
		return (EReference)actionStatisticsReportEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulerChecksReport() {
		return schedulerChecksReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerChecksReport_Partitions() {
		return (EReference)schedulerChecksReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulerChecksPartition() {
		return schedulerChecksPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerChecksPartition_AggregatedCheckedData() {
		return (EReference)schedulerChecksPartitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerChecksPartition_AggregatedFailedData() {
		return (EReference)schedulerChecksPartitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerChecksPartition_CheckedConditionsMap() {
		return (EReference)schedulerChecksPartitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerChecksPartition_FailedConditionsMap() {
		return (EReference)schedulerChecksPartitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBufferBlockingReport() {
		return bufferBlockingReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferBlockingReport_Network() {
		return (EReference)bufferBlockingReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferBlockingReport_MaxBlockedOutputTokens() {
		return (EReference)bufferBlockingReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferBlockingReport_MaxBlockedMultiplication() {
		return (EReference)bufferBlockingReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferBlockingReport_BlockingInstances() {
		return (EReference)bufferBlockingReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostprocessingFactory getPostprocessingFactory() {
		return (PostprocessingFactory)getEFactoryInstance();
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
		postProcessingReportEClass = createEClass(POST_PROCESSING_REPORT);
		createEReference(postProcessingReportEClass, POST_PROCESSING_REPORT__NETWORK);
		createEAttribute(postProcessingReportEClass, POST_PROCESSING_REPORT__TIME);
		createEAttribute(postProcessingReportEClass, POST_PROCESSING_REPORT__DEADLOCK);
		createEReference(postProcessingReportEClass, POST_PROCESSING_REPORT__REPORTS);

		postProcessingDataEClass = createEClass(POST_PROCESSING_DATA);

		actorStatisticsReportEClass = createEClass(ACTOR_STATISTICS_REPORT);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__NETWORK);
		createEAttribute(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__EXECUTION_TIME);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__PARTITIONS);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__IDLE_TIMES);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__BLOCKED_READING_TIMES);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__BLOCKED_WRITING_TIMES);
		createEReference(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__PROCESSING_TIMES);
		createEAttribute(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__AVERAGE_OCCUPANCY);
		createEAttribute(actorStatisticsReportEClass, ACTOR_STATISTICS_REPORT__OCCUPANCY_DEVIATION);

		statisticalActorPartitionEClass = createEClass(STATISTICAL_ACTOR_PARTITION);
		createEAttribute(statisticalActorPartitionEClass, STATISTICAL_ACTOR_PARTITION__ACTORS);
		createEAttribute(statisticalActorPartitionEClass, STATISTICAL_ACTOR_PARTITION__OCCUPANCY);
		createEAttribute(statisticalActorPartitionEClass, STATISTICAL_ACTOR_PARTITION__SCHEDULING_POLICY);

		actionStatisticsReportEClass = createEClass(ACTION_STATISTICS_REPORT);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__ACTORS);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__IDLE_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__IDLE_MIN_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__IDLE_MAX_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_READING_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_READING_MIN_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_READING_MAX_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_WRITING_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MIN_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__BLOCKED_WRITING_MAX_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__PROCESSING_TIMES);
		createEReference(actionStatisticsReportEClass, ACTION_STATISTICS_REPORT__EXECUTION_COUNTS);

		schedulerChecksReportEClass = createEClass(SCHEDULER_CHECKS_REPORT);
		createEReference(schedulerChecksReportEClass, SCHEDULER_CHECKS_REPORT__PARTITIONS);

		schedulerChecksPartitionEClass = createEClass(SCHEDULER_CHECKS_PARTITION);
		createEReference(schedulerChecksPartitionEClass, SCHEDULER_CHECKS_PARTITION__AGGREGATED_CHECKED_DATA);
		createEReference(schedulerChecksPartitionEClass, SCHEDULER_CHECKS_PARTITION__AGGREGATED_FAILED_DATA);
		createEReference(schedulerChecksPartitionEClass, SCHEDULER_CHECKS_PARTITION__CHECKED_CONDITIONS_MAP);
		createEReference(schedulerChecksPartitionEClass, SCHEDULER_CHECKS_PARTITION__FAILED_CONDITIONS_MAP);

		bufferBlockingReportEClass = createEClass(BUFFER_BLOCKING_REPORT);
		createEReference(bufferBlockingReportEClass, BUFFER_BLOCKING_REPORT__NETWORK);
		createEReference(bufferBlockingReportEClass, BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS);
		createEReference(bufferBlockingReportEClass, BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION);
		createEReference(bufferBlockingReportEClass, BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES);
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
		postProcessingReportEClass.getESuperTypes().add(theAnalysisPackage.getAnalysisReport());
		actorStatisticsReportEClass.getESuperTypes().add(this.getPostProcessingData());
		actionStatisticsReportEClass.getESuperTypes().add(this.getPostProcessingData());
		schedulerChecksReportEClass.getESuperTypes().add(this.getPostProcessingData());
		bufferBlockingReportEClass.getESuperTypes().add(this.getPostProcessingData());

		// Initialize classes, features, and operations; add parameters
		initEClass(postProcessingReportEClass, PostProcessingReport.class, "PostProcessingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPostProcessingReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, PostProcessingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostProcessingReport_Time(), ecorePackage.getEDouble(), "time", null, 0, 1, PostProcessingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostProcessingReport_Deadlock(), ecorePackage.getEBoolean(), "deadlock", null, 0, 1, PostProcessingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostProcessingReport_Reports(), this.getPostProcessingData(), null, "reports", null, 0, -1, PostProcessingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postProcessingDataEClass, PostProcessingData.class, "PostProcessingData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actorStatisticsReportEClass, ActorStatisticsReport.class, "ActorStatisticsReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorStatisticsReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorStatisticsReport_ExecutionTime(), ecorePackage.getEDouble(), "executionTime", null, 0, 1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorStatisticsReport_Partitions(), this.getStatisticalActorPartition(), null, "partitions", null, 0, -1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorStatisticsReport_IdleTimes(), theMapPackage.getStringToDoubleMap(), null, "idleTimes", null, 0, -1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorStatisticsReport_BlockedReadingTimes(), theMapPackage.getStringToDoubleMap(), null, "blockedReadingTimes", null, 0, -1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorStatisticsReport_BlockedWritingTimes(), theMapPackage.getStringToDoubleMap(), null, "blockedWritingTimes", null, 0, -1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorStatisticsReport_ProcessingTimes(), theMapPackage.getStringToDoubleMap(), null, "processingTimes", null, 0, -1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorStatisticsReport_AverageOccupancy(), ecorePackage.getEDouble(), "averageOccupancy", null, 0, 1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorStatisticsReport_OccupancyDeviation(), ecorePackage.getEDouble(), "occupancyDeviation", null, 0, 1, ActorStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statisticalActorPartitionEClass, StatisticalActorPartition.class, "StatisticalActorPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatisticalActorPartition_Actors(), ecorePackage.getEString(), "actors", null, 0, -1, StatisticalActorPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalActorPartition_Occupancy(), ecorePackage.getEDouble(), "occupancy", null, 0, 1, StatisticalActorPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalActorPartition_SchedulingPolicy(), ecorePackage.getEString(), "schedulingPolicy", null, 0, 1, StatisticalActorPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionStatisticsReportEClass, ActionStatisticsReport.class, "ActionStatisticsReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionStatisticsReport_Actors(), theDataflowPackage.getActor(), null, "actors", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_IdleTimes(), theMapPackage.getActionToDoubleMap(), null, "idleTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_IdleMinTimes(), theMapPackage.getActionToDoubleMap(), null, "idleMinTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_IdleMaxTimes(), theMapPackage.getActionToDoubleMap(), null, "idleMaxTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedReadingTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedReadingTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedReadingMinTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedReadingMinTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedReadingMaxTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedReadingMaxTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedWritingTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedWritingTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedWritingMinTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedWritingMinTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_BlockedWritingMaxTimes(), theMapPackage.getActionToDoubleMap(), null, "blockedWritingMaxTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_ProcessingTimes(), theMapPackage.getActionToDoubleMap(), null, "processingTimes", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionStatisticsReport_ExecutionCounts(), theMapPackage.getActionToLongMap(), null, "executionCounts", null, 0, -1, ActionStatisticsReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulerChecksReportEClass, SchedulerChecksReport.class, "SchedulerChecksReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulerChecksReport_Partitions(), this.getSchedulerChecksPartition(), null, "partitions", null, 0, -1, SchedulerChecksReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulerChecksPartitionEClass, SchedulerChecksPartition.class, "SchedulerChecksPartition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulerChecksPartition_AggregatedCheckedData(), theCommonPackage.getStatisticalData(), null, "aggregatedCheckedData", null, 0, 1, SchedulerChecksPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerChecksPartition_AggregatedFailedData(), theCommonPackage.getStatisticalData(), null, "aggregatedFailedData", null, 0, 1, SchedulerChecksPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerChecksPartition_CheckedConditionsMap(), theMapPackage.getActorToStatisticalDataMap(), null, "checkedConditionsMap", null, 0, -1, SchedulerChecksPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerChecksPartition_FailedConditionsMap(), theMapPackage.getActorToStatisticalDataMap(), null, "failedConditionsMap", null, 0, -1, SchedulerChecksPartition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferBlockingReportEClass, BufferBlockingReport.class, "BufferBlockingReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferBlockingReport_Network(), theDataflowPackage.getNetwork(), null, "network", null, 0, 1, BufferBlockingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferBlockingReport_MaxBlockedOutputTokens(), theMapPackage.getBufferToIntegerMap(), null, "maxBlockedOutputTokens", null, 0, -1, BufferBlockingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferBlockingReport_MaxBlockedMultiplication(), theMapPackage.getBufferToDoubleMap(), null, "maxBlockedMultiplication", null, 0, -1, BufferBlockingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBufferBlockingReport_BlockingInstances(), theMapPackage.getBufferToIntegerMap(), null, "blockingInstances", null, 0, -1, BufferBlockingReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //PostprocessingPackageImpl

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.postprocessing.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PostprocessingFactoryImpl extends EFactoryImpl implements PostprocessingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PostprocessingFactory init() {
		try {
			PostprocessingFactory thePostprocessingFactory = (PostprocessingFactory)EPackage.Registry.INSTANCE.getEFactory(PostprocessingPackage.eNS_URI);
			if (thePostprocessingFactory != null) {
				return thePostprocessingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PostprocessingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostprocessingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PostprocessingPackage.POST_PROCESSING_REPORT: return createPostProcessingReport();
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT: return createActorStatisticsReport();
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION: return createStatisticalActorPartition();
			case PostprocessingPackage.ACTION_STATISTICS_REPORT: return createActionStatisticsReport();
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT: return createSchedulerChecksReport();
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION: return createSchedulerChecksPartition();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT: return createBufferBlockingReport();
			case PostprocessingPackage.TIMELINE_REPORT: return createTimelineReport();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostProcessingReport createPostProcessingReport() {
		PostProcessingReportImpl postProcessingReport = new PostProcessingReportImpl();
		return postProcessingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActorStatisticsReport createActorStatisticsReport() {
		ActorStatisticsReportImpl actorStatisticsReport = new ActorStatisticsReportImpl();
		return actorStatisticsReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticalActorPartition createStatisticalActorPartition() {
		StatisticalActorPartitionImpl statisticalActorPartition = new StatisticalActorPartitionImpl();
		return statisticalActorPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionStatisticsReport createActionStatisticsReport() {
		ActionStatisticsReportImpl actionStatisticsReport = new ActionStatisticsReportImpl();
		return actionStatisticsReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SchedulerChecksReport createSchedulerChecksReport() {
		SchedulerChecksReportImpl schedulerChecksReport = new SchedulerChecksReportImpl();
		return schedulerChecksReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SchedulerChecksPartition createSchedulerChecksPartition() {
		SchedulerChecksPartitionImpl schedulerChecksPartition = new SchedulerChecksPartitionImpl();
		return schedulerChecksPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferBlockingReport createBufferBlockingReport() {
		BufferBlockingReportImpl bufferBlockingReport = new BufferBlockingReportImpl();
		return bufferBlockingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TimelineReport createTimelineReport() {
		TimelineReportImpl timelineReport = new TimelineReportImpl();
		return timelineReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostprocessingPackage getPostprocessingPackage() {
		return (PostprocessingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PostprocessingPackage getPackage() {
		return PostprocessingPackage.eINSTANCE;
	}

} //PostprocessingFactoryImpl

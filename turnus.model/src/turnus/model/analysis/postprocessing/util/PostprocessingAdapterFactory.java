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
package turnus.model.analysis.postprocessing.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.postprocessing.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage
 * @generated
 */
public class PostprocessingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PostprocessingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostprocessingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PostprocessingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostprocessingSwitch<Adapter> modelSwitch =
		new PostprocessingSwitch<Adapter>() {
			@Override
			public Adapter casePostProcessingReport(PostProcessingReport object) {
				return createPostProcessingReportAdapter();
			}
			@Override
			public Adapter casePostProcessingData(PostProcessingData object) {
				return createPostProcessingDataAdapter();
			}
			@Override
			public Adapter caseActorStatisticsReport(ActorStatisticsReport object) {
				return createActorStatisticsReportAdapter();
			}
			@Override
			public Adapter caseStatisticalActorPartition(StatisticalActorPartition object) {
				return createStatisticalActorPartitionAdapter();
			}
			@Override
			public Adapter caseActionStatisticsReport(ActionStatisticsReport object) {
				return createActionStatisticsReportAdapter();
			}
			@Override
			public Adapter caseSchedulerChecksReport(SchedulerChecksReport object) {
				return createSchedulerChecksReportAdapter();
			}
			@Override
			public Adapter caseSchedulerChecksPartition(SchedulerChecksPartition object) {
				return createSchedulerChecksPartitionAdapter();
			}
			@Override
			public Adapter caseBufferBlockingReport(BufferBlockingReport object) {
				return createBufferBlockingReportAdapter();
			}
			@Override
			public Adapter caseTimelineReport(TimelineReport object) {
				return createTimelineReportAdapter();
			}
			@Override
			public Adapter caseAnalysisReport(AnalysisReport object) {
				return createAnalysisReportAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.PostProcessingReport <em>Post Processing Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.PostProcessingReport
	 * @generated
	 */
	public Adapter createPostProcessingReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.PostProcessingData <em>Post Processing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.PostProcessingData
	 * @generated
	 */
	public Adapter createPostProcessingDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.ActorStatisticsReport <em>Actor Statistics Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.ActorStatisticsReport
	 * @generated
	 */
	public Adapter createActorStatisticsReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition <em>Statistical Actor Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.StatisticalActorPartition
	 * @generated
	 */
	public Adapter createStatisticalActorPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport <em>Action Statistics Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.ActionStatisticsReport
	 * @generated
	 */
	public Adapter createActionStatisticsReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.SchedulerChecksReport <em>Scheduler Checks Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksReport
	 * @generated
	 */
	public Adapter createSchedulerChecksReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition <em>Scheduler Checks Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.SchedulerChecksPartition
	 * @generated
	 */
	public Adapter createSchedulerChecksPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.BufferBlockingReport <em>Buffer Blocking Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.BufferBlockingReport
	 * @generated
	 */
	public Adapter createBufferBlockingReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.postprocessing.TimelineReport <em>Timeline Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.postprocessing.TimelineReport
	 * @generated
	 */
	public Adapter createTimelineReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.AnalysisReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.AnalysisReport
	 * @generated
	 */
	public Adapter createAnalysisReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PostprocessingAdapterFactory

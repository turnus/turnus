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

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.postprocessing.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage
 * @generated
 */
public class PostprocessingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PostprocessingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostprocessingSwitch() {
		if (modelPackage == null) {
			modelPackage = PostprocessingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PostprocessingPackage.POST_PROCESSING_REPORT: {
				PostProcessingReport postProcessingReport = (PostProcessingReport)theEObject;
				T result = casePostProcessingReport(postProcessingReport);
				if (result == null) result = caseAnalysisReport(postProcessingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.POST_PROCESSING_DATA: {
				PostProcessingData postProcessingData = (PostProcessingData)theEObject;
				T result = casePostProcessingData(postProcessingData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.ACTOR_STATISTICS_REPORT: {
				ActorStatisticsReport actorStatisticsReport = (ActorStatisticsReport)theEObject;
				T result = caseActorStatisticsReport(actorStatisticsReport);
				if (result == null) result = casePostProcessingData(actorStatisticsReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.STATISTICAL_ACTOR_PARTITION: {
				StatisticalActorPartition statisticalActorPartition = (StatisticalActorPartition)theEObject;
				T result = caseStatisticalActorPartition(statisticalActorPartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.ACTION_STATISTICS_REPORT: {
				ActionStatisticsReport actionStatisticsReport = (ActionStatisticsReport)theEObject;
				T result = caseActionStatisticsReport(actionStatisticsReport);
				if (result == null) result = casePostProcessingData(actionStatisticsReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT: {
				SchedulerChecksReport schedulerChecksReport = (SchedulerChecksReport)theEObject;
				T result = caseSchedulerChecksReport(schedulerChecksReport);
				if (result == null) result = casePostProcessingData(schedulerChecksReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.SCHEDULER_CHECKS_PARTITION: {
				SchedulerChecksPartition schedulerChecksPartition = (SchedulerChecksPartition)theEObject;
				T result = caseSchedulerChecksPartition(schedulerChecksPartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT: {
				BufferBlockingReport bufferBlockingReport = (BufferBlockingReport)theEObject;
				T result = caseBufferBlockingReport(bufferBlockingReport);
				if (result == null) result = casePostProcessingData(bufferBlockingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.TIMELINE_REPORT: {
				TimelineReport timelineReport = (TimelineReport)theEObject;
				T result = caseTimelineReport(timelineReport);
				if (result == null) result = casePostProcessingData(timelineReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PostprocessingPackage.PARTITION_TO_ACTOR_STATISTICAL_ACTOR_PARTITION: {
				@SuppressWarnings("unchecked") Map.Entry<String, StatisticalActorPartition> partitionToActorStatisticalActorPartition = (Map.Entry<String, StatisticalActorPartition>)theEObject;
				T result = casePartitionToActorStatisticalActorPartition(partitionToActorStatisticalActorPartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Processing Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Processing Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostProcessingReport(PostProcessingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostProcessingData(PostProcessingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Statistics Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Statistics Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorStatisticsReport(ActorStatisticsReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statistical Actor Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statistical Actor Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatisticalActorPartition(StatisticalActorPartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Statistics Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Statistics Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionStatisticsReport(ActionStatisticsReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler Checks Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler Checks Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulerChecksReport(SchedulerChecksReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler Checks Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler Checks Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulerChecksPartition(SchedulerChecksPartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Blocking Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Blocking Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferBlockingReport(BufferBlockingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timeline Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timeline Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimelineReport(TimelineReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partition To Actor Statistical Actor Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partition To Actor Statistical Actor Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartitionToActorStatisticalActorPartition(Map.Entry<String, StatisticalActorPartition> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisReport(AnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PostprocessingSwitch

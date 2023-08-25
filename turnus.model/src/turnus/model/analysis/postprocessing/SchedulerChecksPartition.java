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
package turnus.model.analysis.postprocessing;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler Checks Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedCheckedData <em>Aggregated Checked Data</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedFailedData <em>Aggregated Failed Data</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getCheckedConditionsMap <em>Checked Conditions Map</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getFailedConditionsMap <em>Failed Conditions Map</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getPartitionId <em>Partition Id</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition()
 * @model
 * @generated
 */
public interface SchedulerChecksPartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Aggregated Checked Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Checked Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Checked Data</em>' containment reference.
	 * @see #setAggregatedCheckedData(StatisticalData)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition_AggregatedCheckedData()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getAggregatedCheckedData();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedCheckedData <em>Aggregated Checked Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Checked Data</em>' containment reference.
	 * @see #getAggregatedCheckedData()
	 * @generated
	 */
	void setAggregatedCheckedData(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Aggregated Failed Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Failed Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Failed Data</em>' containment reference.
	 * @see #setAggregatedFailedData(StatisticalData)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition_AggregatedFailedData()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getAggregatedFailedData();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getAggregatedFailedData <em>Aggregated Failed Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated Failed Data</em>' containment reference.
	 * @see #getAggregatedFailedData()
	 * @generated
	 */
	void setAggregatedFailedData(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Checked Conditions Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checked Conditions Map</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checked Conditions Map</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition_CheckedConditionsMap()
	 * @model mapType="turnus.model.analysis.map.ActorToStatisticalDataMap&lt;turnus.model.dataflow.Actor, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Actor, StatisticalData> getCheckedConditionsMap();

	/**
	 * Returns the value of the '<em><b>Failed Conditions Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failed Conditions Map</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failed Conditions Map</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition_FailedConditionsMap()
	 * @model mapType="turnus.model.analysis.map.ActorToStatisticalDataMap&lt;turnus.model.dataflow.Actor, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Actor, StatisticalData> getFailedConditionsMap();

	/**
	 * Returns the value of the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Id</em>' attribute.
	 * @see #setPartitionId(String)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getSchedulerChecksPartition_PartitionId()
	 * @model
	 * @generated
	 */
	String getPartitionId();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.SchedulerChecksPartition#getPartitionId <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition Id</em>' attribute.
	 * @see #getPartitionId()
	 * @generated
	 */
	void setPartitionId(String value);

} // SchedulerChecksPartition

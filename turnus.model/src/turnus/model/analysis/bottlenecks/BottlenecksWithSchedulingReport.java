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
package turnus.model.analysis.bottlenecks;

import java.util.List;

import java.util.Map;
import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.postprocessing.PostProcessingData;

import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Scheduling Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getActionsData <em>Actions Data</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getTotalFirings <em>Total Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpBlockingTime <em>Cp Blocking Time</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getCpPartitionsBlockingTime <em>Cp Partitions Blocking Time</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport()
 * @model
 * @generated
 */
public interface BottlenecksWithSchedulingReport extends AnalysisReport, PostProcessingData {
	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Actions Data</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Data</em>' containment reference list.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_ActionsData()
	 * @model containment="true"
	 * @generated
	 */
	List<ActionBottlenecksWithSchedulingData> getActionsData();

	/**
	 * Returns the value of the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Weight</em>' attribute.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_CpWeight()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getCpWeight();

	/**
	 * Returns the value of the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Weight</em>' attribute.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_TotalWeight()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getTotalWeight();

	/**
	 * Returns the value of the '<em><b>Cp Firings</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Firings</em>' attribute.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_CpFirings()
	 * @model default="0" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getCpFirings();

	/**
	 * Returns the value of the '<em><b>Total Firings</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Firings</em>' attribute.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_TotalFirings()
	 * @model default="0" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getTotalFirings();

	/**
	 * Returns the value of the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Time</em>' attribute.
	 * @see #setExecutionTime(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_ExecutionTime()
	 * @model required="true"
	 * @generated
	 */
	double getExecutionTime();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport#getExecutionTime <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Time</em>' attribute.
	 * @see #getExecutionTime()
	 * @generated
	 */
	void setExecutionTime(double value);

	/**
	 * Returns the value of the '<em><b>Cp Blocking Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Blocking Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Blocking Time</em>' attribute.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_CpBlockingTime()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	double getCpBlockingTime();

	/**
	 * Returns the value of the '<em><b>Cp Partitions Blocking Time</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Partitions Blocking Time</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Partitions Blocking Time</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getBottlenecksWithSchedulingReport_CpPartitionsBlockingTime()
	 * @model mapType="turnus.model.analysis.map.StringToDoubleMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EDoubleObject>"
	 * @generated
	 */
	Map<String, Double> getCpPartitionsBlockingTime();

} // BottlenecksWithSchedulingReport

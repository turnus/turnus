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

import java.util.List;
import java.util.Map;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Statistics Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleTimes <em>Idle Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMinTimes <em>Idle Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getIdleMaxTimes <em>Idle Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingTimes <em>Blocked Reading Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMinTimes <em>Blocked Reading Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedReadingMaxTimes <em>Blocked Reading Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingTimes <em>Blocked Writing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMinTimes <em>Blocked Writing Min Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getBlockedWritingMaxTimes <em>Blocked Writing Max Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getProcessingTimes <em>Processing Times</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getExecutionCounts <em>Execution Counts</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getNetwork <em>Network</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport()
 * @model
 * @generated
 */
public interface ActionStatisticsReport extends PostProcessingData {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_Actors()
	 * @model
	 * @generated
	 */
	List<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Idle Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idle Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idle Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_IdleTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getIdleTimes();

	/**
	 * Returns the value of the '<em><b>Idle Min Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idle Min Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idle Min Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_IdleMinTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getIdleMinTimes();

	/**
	 * Returns the value of the '<em><b>Idle Max Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idle Max Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idle Max Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_IdleMaxTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getIdleMaxTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Reading Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Reading Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Reading Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedReadingTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedReadingTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Reading Min Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Reading Min Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Reading Min Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedReadingMinTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedReadingMinTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Reading Max Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Reading Max Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Reading Max Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedReadingMaxTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedReadingMaxTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Writing Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Writing Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Writing Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedWritingTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedWritingTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Writing Min Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Writing Min Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Writing Min Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedWritingMinTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedWritingMinTimes();

	/**
	 * Returns the value of the '<em><b>Blocked Writing Max Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocked Writing Max Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocked Writing Max Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_BlockedWritingMaxTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getBlockedWritingMaxTimes();

	/**
	 * Returns the value of the '<em><b>Processing Times</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Times</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Times</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_ProcessingTimes()
	 * @model mapType="turnus.model.analysis.map.ActionToDoubleMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Action, Double> getProcessingTimes();

	/**
	 * Returns the value of the '<em><b>Execution Counts</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Counts</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Counts</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_ExecutionCounts()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Action, Long> getExecutionCounts();

	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getActionStatisticsReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.ActionStatisticsReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

} // ActionStatisticsReport

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
package turnus.model.analysis.trace;

import java.util.List;

import turnus.model.analysis.AnalysisReport;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compressed Trace Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.CompressedTraceReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedTraceReport#getSteps <em>Steps</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedTraceReport#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedTraceReport#getTraceFile <em>Trace File</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getCompressedTraceReport()
 * @model
 * @generated
 */
public interface CompressedTraceReport extends AnalysisReport {
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
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTraceReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.CompressedTraceReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTraceReport_Steps()
	 * @model containment="true"
	 * @generated
	 */
	List<CompressedStep> getSteps();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTraceReport_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	List<CompressedDependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace File</em>' attribute.
	 * @see #setTraceFile(String)
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTraceReport_TraceFile()
	 * @model
	 * @generated
	 */
	String getTraceFile();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.CompressedTraceReport#getTraceFile <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace File</em>' attribute.
	 * @see #getTraceFile()
	 * @generated
	 */
	void setTraceFile(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	CompressedStep getSteps(Action action);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	List<CompressedStep> getSteps(Actor actor);

} // CompressedTraceReport

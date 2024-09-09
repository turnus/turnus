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
package turnus.model.analysis.communication;

import java.util.List;
import java.util.Map;

import turnus.model.analysis.AnalysisReport;

import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weigth Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.communication.CommunicationWeigthReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.CommunicationWeigthReport#getModel <em>Model</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.CommunicationWeigthReport#getBufferLatency <em>Buffer Latency</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.communication.CommunicationPackage#getCommunicationWeigthReport()
 * @model
 * @generated
 */
public interface CommunicationWeigthReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getCommunicationWeigthReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.CommunicationWeigthReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(CommunicationModel)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getCommunicationWeigthReport_Model()
	 * @model containment="true"
	 * @generated
	 */
	CommunicationModel getModel();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.CommunicationWeigthReport#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(CommunicationModel value);

	/**
	 * Returns the value of the '<em><b>Buffer Latency</b></em>' reference list.
	 * The list contents are of type {@link java.util.Map.Entry}<code>&lt;turnus.model.dataflow.Buffer, java.lang.Double&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Latency</em>' reference list.
	 * @see turnus.model.analysis.communication.CommunicationPackage#getCommunicationWeigthReport_BufferLatency()
	 * @model mapType="turnus.model.analysis.map.BufferToDoubleMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	List<Map.Entry<Buffer, Double>> getBufferLatency();

} // CommunicationWeigthReport

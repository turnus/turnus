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

import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Blocking Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getBlockingInstances <em>Blocking Instances</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getBufferBlockingReport()
 * @model
 * @generated
 */
public interface BufferBlockingReport extends PostProcessingData {
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
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getBufferBlockingReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.BufferBlockingReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Max Blocked Output Tokens</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Blocked Output Tokens</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Blocked Output Tokens</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getBufferBlockingReport_MaxBlockedOutputTokens()
	 * @model mapType="turnus.model.analysis.map.BufferToIntegerMap<turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	Map<Buffer, Integer> getMaxBlockedOutputTokens();

	/**
	 * Returns the value of the '<em><b>Max Blocked Multiplication</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Blocked Multiplication</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Blocked Multiplication</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getBufferBlockingReport_MaxBlockedMultiplication()
	 * @model mapType="turnus.model.analysis.map.BufferToDoubleMap<turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EDoubleObject>"
	 * @generated
	 */
	Map<Buffer, Double> getMaxBlockedMultiplication();

	/**
	 * Returns the value of the '<em><b>Blocking Instances</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocking Instances</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocking Instances</em>' map.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getBufferBlockingReport_BlockingInstances()
	 * @model mapType="turnus.model.analysis.map.BufferToIntegerMap<turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	Map<Buffer, Integer> getBlockingInstances();

} // BufferBlockingReport

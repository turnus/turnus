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
package turnus.model.analysis.buffers;

import java.util.List;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;

import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimal Buffers Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#isPow2 <em>Pow2</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#isBitAccurate <em>Bit Accurate</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#getBuffersData <em>Buffers Data</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBufferConfiguration <em>Initial Buffer Configuration</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBottlenecks <em>Initial Bottlenecks</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport()
 * @model
 * @generated
 */
public interface OptimalBuffersReport extends AnalysisReport {
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
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Pow2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pow2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pow2</em>' attribute.
	 * @see #setPow2(boolean)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_Pow2()
	 * @model
	 * @generated
	 */
	boolean isPow2();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.OptimalBuffersReport#isPow2 <em>Pow2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pow2</em>' attribute.
	 * @see #isPow2()
	 * @generated
	 */
	void setPow2(boolean value);

	/**
	 * Returns the value of the '<em><b>Bit Accurate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bit Accurate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bit Accurate</em>' attribute.
	 * @see #setBitAccurate(boolean)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_BitAccurate()
	 * @model
	 * @generated
	 */
	boolean isBitAccurate();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.OptimalBuffersReport#isBitAccurate <em>Bit Accurate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bit Accurate</em>' attribute.
	 * @see #isBitAccurate()
	 * @generated
	 */
	void setBitAccurate(boolean value);

	/**
	 * Returns the value of the '<em><b>Buffers Data</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.buffers.OptimalBufferData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffers Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers Data</em>' containment reference list.
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_BuffersData()
	 * @model containment="true"
	 * @generated
	 */
	List<OptimalBufferData> getBuffersData();

	/**
	 * Returns the value of the '<em><b>Initial Buffer Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Buffer Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Buffer Configuration</em>' containment reference.
	 * @see #setInitialBufferConfiguration(BoundedBuffersReport)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_InitialBufferConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BoundedBuffersReport getInitialBufferConfiguration();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBufferConfiguration <em>Initial Buffer Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Buffer Configuration</em>' containment reference.
	 * @see #getInitialBufferConfiguration()
	 * @generated
	 */
	void setInitialBufferConfiguration(BoundedBuffersReport value);

	/**
	 * Returns the value of the '<em><b>Initial Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Bottlenecks</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Bottlenecks</em>' containment reference.
	 * @see #setInitialBottlenecks(BottlenecksWithSchedulingReport)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getOptimalBuffersReport_InitialBottlenecks()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BottlenecksWithSchedulingReport getInitialBottlenecks();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.OptimalBuffersReport#getInitialBottlenecks <em>Initial Bottlenecks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Bottlenecks</em>' containment reference.
	 * @see #getInitialBottlenecks()
	 * @generated
	 */
	void setInitialBottlenecks(BottlenecksWithSchedulingReport value);

} // OptimalBuffersReport

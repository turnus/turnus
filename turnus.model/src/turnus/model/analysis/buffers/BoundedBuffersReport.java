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
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Bounded Buffers Report</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#isPow2 <em>Pow2</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#isBitAccurate <em>Bit Accurate</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#getBuffersData <em>Buffers Data</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#getTokenSize <em>Token Size</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBuffersReport#getBitSize <em>Bit Size</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport()
 * @model
 * @generated
 */
public interface BoundedBuffersReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.analysis.buffers.BoundedBuffersReport#getNetwork
	 * <em>Network</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Pow2</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pow2</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pow2</em>' attribute.
	 * @see #setPow2(boolean)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_Pow2()
	 * @model
	 * @generated
	 */
	boolean isPow2();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.BoundedBuffersReport#isPow2 <em>Pow2</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pow2</em>' attribute.
	 * @see #isPow2()
	 * @generated
	 */
	void setPow2(boolean value);

	/**
	 * Returns the value of the '<em><b>Bit Accurate</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bit Accurate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bit Accurate</em>' attribute.
	 * @see #setBitAccurate(boolean)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_BitAccurate()
	 * @model
	 * @generated
	 */
	boolean isBitAccurate();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.BoundedBuffersReport#isBitAccurate <em>Bit Accurate</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Bit Accurate</em>' attribute.
	 * @see #isBitAccurate()
	 * @generated
	 */
	void setBitAccurate(boolean value);

	/**
	 * Returns the value of the '<em><b>Buffers Data</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link turnus.model.analysis.buffers.BoundedBufferData}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffers Data</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Buffers Data</em>' containment reference
	 *         list.
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_BuffersData()
	 * @model containment="true"
	 * @generated
	 */
	List<BoundedBufferData> getBuffersData();

	/**
	 * Returns the value of the '<em><b>Token Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Size</em>' attribute.
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_TokenSize()
	 * @model default="0" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getTokenSize();

	/**
	 * Returns the value of the '<em><b>Bit Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bit Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bit Size</em>' attribute.
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBuffersReport_BitSize()
	 * @model default="0" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getBitSize();

	/**
	 * Return the buffer size configuration contained in this report
	 * 
	 * @return
	 */
	BufferSize asBufferSize();

} // BoundedBuffersReport

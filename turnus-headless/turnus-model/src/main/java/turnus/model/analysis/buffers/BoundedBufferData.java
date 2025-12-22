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

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Buffer Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBufferData#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBufferData#getTokenSize <em>Token Size</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.BoundedBufferData#getBitSize <em>Bit Size</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBufferData()
 * @model
 * @generated
 */
public interface BoundedBufferData extends EObject {
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(Buffer)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBufferData_Buffer()
	 * @model
	 * @generated
	 */
	Buffer getBuffer();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.BoundedBufferData#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Token Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Size</em>' attribute.
	 * @see #setTokenSize(int)
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBufferData_TokenSize()
	 * @model
	 * @generated
	 */
	int getTokenSize();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.buffers.BoundedBufferData#getTokenSize <em>Token Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Size</em>' attribute.
	 * @see #getTokenSize()
	 * @generated
	 */
	void setTokenSize(int value);

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
	 * @see turnus.model.analysis.buffers.BuffersPackage#getBoundedBufferData_BitSize()
	 * @model default="0" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getBitSize();

} // BoundedBufferData

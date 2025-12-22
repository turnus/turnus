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
package turnus.model.analysis.profiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Access Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.BufferAccessData#getSourceActor <em>Source Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferAccessData#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferAccessData#getTargetActor <em>Target Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferAccessData#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferAccessData()
 * @model
 * @generated
 */
public interface BufferAccessData extends MemoryAccessData {
	/**
	 * Returns the value of the '<em><b>Source Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Actor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Actor</em>' attribute.
	 * @see #setSourceActor(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferAccessData_SourceActor()
	 * @model required="true"
	 * @generated
	 */
	String getSourceActor();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferAccessData#getSourceActor <em>Source Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Actor</em>' attribute.
	 * @see #getSourceActor()
	 * @generated
	 */
	void setSourceActor(String value);

	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' attribute.
	 * @see #setSourcePort(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferAccessData_SourcePort()
	 * @model required="true"
	 * @generated
	 */
	String getSourcePort();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferAccessData#getSourcePort <em>Source Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' attribute.
	 * @see #getSourcePort()
	 * @generated
	 */
	void setSourcePort(String value);

	/**
	 * Returns the value of the '<em><b>Target Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Actor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Actor</em>' attribute.
	 * @see #setTargetActor(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferAccessData_TargetActor()
	 * @model required="true"
	 * @generated
	 */
	String getTargetActor();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferAccessData#getTargetActor <em>Target Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Actor</em>' attribute.
	 * @see #getTargetActor()
	 * @generated
	 */
	void setTargetActor(String value);

	/**
	 * Returns the value of the '<em><b>Target Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port</em>' attribute.
	 * @see #setTargetPort(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferAccessData_TargetPort()
	 * @model required="true"
	 * @generated
	 */
	String getTargetPort();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferAccessData#getTargetPort <em>Target Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port</em>' attribute.
	 * @see #getTargetPort()
	 * @generated
	 */
	void setTargetPort(String value);

} // BufferAccessData

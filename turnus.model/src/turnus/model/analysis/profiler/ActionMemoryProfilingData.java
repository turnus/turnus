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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Memory Profiling Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getReads <em>Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiler.ProfilerPackage#getActionMemoryProfilingData()
 * @model
 * @generated
 */
public interface ActionMemoryProfilingData extends EObject {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' attribute.
	 * @see #setActor(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getActionMemoryProfilingData_Actor()
	 * @model required="true"
	 * @generated
	 */
	String getActor();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getActor <em>Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' attribute.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getActionMemoryProfilingData_Action()
	 * @model required="true"
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

	/**
	 * Returns the value of the '<em><b>Reads</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.profiler.MemoryAccessData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reads</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reads</em>' containment reference list.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getActionMemoryProfilingData_Reads()
	 * @model containment="true"
	 * @generated
	 */
	List<MemoryAccessData> getReads();

	/**
	 * Returns the value of the '<em><b>Writes</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.profiler.MemoryAccessData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writes</em>' containment reference list.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getActionMemoryProfilingData_Writes()
	 * @model containment="true"
	 * @generated
	 */
	List<MemoryAccessData> getWrites();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	BufferAccessData getReadBufferData(String sourceActor, String sourcePort, String targetActor, String targetPort);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	BufferAccessData getWriteBufferData(String sourceActor, String sourcePort, String targetActor, String targetPort);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	StateVariableAccessData getReadStateVariableData(String variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	StateVariableAccessData getWriteStateVariableData(String variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	LocalVariableAccessData getReadLocalVariableData(String variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	LocalVariableAccessData getWriteLocalVariableData(String variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SharedVariableAccessData getReadSharedVariableData(String variable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SharedVariableAccessData getWriteSharedVariableData(String variable);

} // ActionMemoryProfilingData

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
package turnus.model.dataflow;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.common.Attributable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.Port#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.Port#getWriters <em>Writers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Port#getReaders <em>Readers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Port#getInput <em>Input</em>}</li>
 *   <li>{@link turnus.model.dataflow.Port#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link turnus.model.dataflow.Port#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see turnus.model.dataflow.DataflowPackage#getPort()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Port extends EObject, Attributable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Writers</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Action}.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Action#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writers</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Writers()
	 * @see turnus.model.dataflow.Action#getOutputPorts
	 * @model opposite="outputPorts"
	 * @generated
	 */
	List<Action> getWriters();

	/**
	 * Returns the value of the '<em><b>Readers</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Action}.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Action#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readers</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Readers()
	 * @see turnus.model.dataflow.Action#getInputPorts
	 * @model opposite="inputPorts"
	 * @generated
	 */
	List<Action> getReaders();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Buffer#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference.
	 * @see #setInput(Buffer)
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Input()
	 * @see turnus.model.dataflow.Buffer#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	Buffer getInput();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Port#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Buffer value);

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Buffer}.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Buffer#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Outputs()
	 * @see turnus.model.dataflow.Buffer#getSource
	 * @model opposite="source"
	 * @generated
	 */
	List<Buffer> getOutputs();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see turnus.model.dataflow.DataflowPackage#getPort_Owner()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Actor getOwner();

} // Port

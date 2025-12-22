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

import java.util.Map;
import org.eclipse.emf.ecore.EObject;

import turnus.common.Attributable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.Action#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getGuards <em>Guards</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getOwner <em>Owner</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getProduction <em>Production</em>}</li>
 *   <li>{@link turnus.model.dataflow.Action#getConsumption <em>Consumption</em>}</li>
 * </ul>
 *
 * @see turnus.model.dataflow.DataflowPackage#getAction()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Action extends EObject, Attributable {
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
	 * @see turnus.model.dataflow.DataflowPackage#getAction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Action#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Input Ports</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Port}.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Port#getReaders <em>Readers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Ports</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_InputPorts()
	 * @see turnus.model.dataflow.Port#getReaders
	 * @model opposite="readers"
	 * @generated
	 */
	List<Port> getInputPorts();

	/**
	 * Returns the value of the '<em><b>Output Ports</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Port}.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.Port#getWriters <em>Writers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Ports</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_OutputPorts()
	 * @see turnus.model.dataflow.Port#getWriters
	 * @model opposite="writers"
	 * @generated
	 */
	List<Port> getOutputPorts();

	/**
	 * Returns the value of the '<em><b>Guards</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Guard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guards</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_Guards()
	 * @model containment="true"
	 * @generated
	 */
	List<Guard> getGuards();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_Owner()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Actor getOwner();

	/**
	 * Returns the value of the '<em><b>Production</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Port},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Production</em>' map.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_Production()
	 * @model mapType="turnus.model.dataflow.map.PortsToLongMap&lt;turnus.model.dataflow.Port, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Port, Long> getProduction();

	/**
	 * Returns the value of the '<em><b>Consumption</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Port},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumption</em>' map.
	 * @see turnus.model.dataflow.DataflowPackage#getAction_Consumption()
	 * @model mapType="turnus.model.dataflow.map.PortsToLongMap&lt;turnus.model.dataflow.Port, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Port, Long> getConsumption();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Guard getGuard(String tag);

} // Action

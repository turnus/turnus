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
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.Actor#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getVariables <em>Variables</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getOwner <em>Owner</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getBuffers <em>Buffers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getIncomingBuffers <em>Incoming Buffers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getOutgoingBuffers <em>Outgoing Buffers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link turnus.model.dataflow.Actor#getSuccessors <em>Successors</em>}</li>
 * </ul>
 *
 * @see turnus.model.dataflow.DataflowPackage#getActor()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Actor extends EObject, Attributable {
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
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Actor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Input Ports</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Ports</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_InputPorts()
	 * @model containment="true"
	 * @generated
	 */
	List<Port> getInputPorts();

	/**
	 * Returns the value of the '<em><b>Output Ports</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Ports</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_OutputPorts()
	 * @model containment="true"
	 * @generated
	 */
	List<Port> getOutputPorts();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Variables()
	 * @model containment="true"
	 * @generated
	 */
	List<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.dataflow.ActorClass#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see #setActorClass(ActorClass)
	 * @see turnus.model.dataflow.DataflowPackage#getActor_ActorClass()
	 * @see turnus.model.dataflow.ActorClass#getActors
	 * @model opposite="actors" required="true"
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Actor#getActorClass <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Class</em>' reference.
	 * @see #getActorClass()
	 * @generated
	 */
	void setActorClass(ActorClass value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Actions()
	 * @model containment="true"
	 * @generated
	 */
	List<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Procedures</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Procedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedures</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Procedures()
	 * @model containment="true"
	 * @generated
	 */
	List<Procedure> getProcedures();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Owner()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Network getOwner();

	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Buffers()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<Buffer> getBuffers();

	/**
	 * Returns the value of the '<em><b>Incoming Buffers</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Buffers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Buffers</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_IncomingBuffers()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<Buffer> getIncomingBuffers();

	/**
	 * Returns the value of the '<em><b>Outgoing Buffers</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Buffers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Buffers</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_OutgoingBuffers()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<Buffer> getOutgoingBuffers();

	/**
	 * Returns the value of the '<em><b>Predecessors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessors</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Predecessors()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<Actor> getPredecessors();

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getActor_Successors()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<Actor> getSuccessors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Action getAction(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Port getInputPort(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Port getOutputPort(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Variable getVariable(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Procedure getProcedure(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SharedVariable getSharedVariable(String tag);

} // Actor

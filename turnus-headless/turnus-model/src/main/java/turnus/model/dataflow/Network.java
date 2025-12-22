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
import turnus.model.versioning.Version;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.Network#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getProject <em>Project</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getActorClasses <em>Actor Classes</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getBuffers <em>Buffers</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getSharedVariables <em>Shared Variables</em>}</li>
 *   <li>{@link turnus.model.dataflow.Network#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see turnus.model.dataflow.DataflowPackage#getNetwork()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Network extends EObject, Attributable {
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
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Network#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source File</em>' attribute.
	 * @see #setSourceFile(String)
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_SourceFile()
	 * @model required="true"
	 * @generated
	 */
	String getSourceFile();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Network#getSourceFile <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File</em>' attribute.
	 * @see #getSourceFile()
	 * @generated
	 */
	void setSourceFile(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(String)
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_Project()
	 * @model required="true"
	 * @generated
	 */
	String getProject();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Network#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(String value);

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_Actors()
	 * @model containment="true"
	 * @generated
	 */
	List<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Actor Classes</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.ActorClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Classes</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_ActorClasses()
	 * @model containment="true"
	 * @generated
	 */
	List<ActorClass> getActorClasses();

	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' containment reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_Buffers()
	 * @model containment="true"
	 * @generated
	 */
	List<Buffer> getBuffers();

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
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_InputPorts()
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
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_OutputPorts()
	 * @model containment="true"
	 * @generated
	 */
	List<Port> getOutputPorts();

	/**
	 * Returns the value of the '<em><b>Shared Variables</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.SharedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Variables</em>' reference list.
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_SharedVariables()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<SharedVariable> getSharedVariables();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference.
	 * @see #setVersion(Version)
	 * @see turnus.model.dataflow.DataflowPackage#getNetwork_Version()
	 * @model containment="true"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link turnus.model.dataflow.Network#getVersion <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' containment reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Actor getActor(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ActorClass getActorClass(String name);

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
	List<SharedVariable> getSharedVariables(String tag);

} // Network

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
package turnus.model.analysis.trace;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compressed Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getCount <em>Count</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedStep#getNeighbors <em>Neighbors</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep()
 * @model
 * @generated
 */
public interface CompressedStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.CompressedStep#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(long)
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Count()
	 * @model
	 * @generated
	 */
	long getCount();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.CompressedStep#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(long value);

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedDependency}.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.trace.CompressedDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Incomings()
	 * @see turnus.model.analysis.trace.CompressedDependency#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	List<CompressedDependency> getIncomings();

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedDependency}.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.trace.CompressedDependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Outgoings()
	 * @see turnus.model.analysis.trace.CompressedDependency#getSource
	 * @model opposite="source"
	 * @generated
	 */
	List<CompressedDependency> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Predecessors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessors</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Predecessors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<CompressedStep> getPredecessors();

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Successors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<CompressedStep> getSuccessors();

	/**
	 * Returns the value of the '<em><b>Neighbors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.CompressedStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighbors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighbors</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedStep_Neighbors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	List<CompressedStep> getNeighbors();

} // CompressedStep

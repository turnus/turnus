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
 * A representation of the model object '<em><b>Compared Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#getCompressedTrace <em>Compressed Trace</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#getDSteps <em>DSteps</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#getDDependencies <em>DDependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#getContainedReferenceActions <em>Contained Reference Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.ComparedTrace#isEqual <em>Equal</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace()
 * @model
 * @generated
 */
public interface ComparedTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Compressed Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compressed Trace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compressed Trace</em>' containment reference.
	 * @see #setCompressedTrace(CompressedTraceReport)
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_CompressedTrace()
	 * @model containment="true"
	 * @generated
	 */
	CompressedTraceReport getCompressedTrace();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.ComparedTrace#getCompressedTrace <em>Compressed Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compressed Trace</em>' containment reference.
	 * @see #getCompressedTrace()
	 * @generated
	 */
	void setCompressedTrace(CompressedTraceReport value);

	/**
	 * Returns the value of the '<em><b>DSteps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSteps</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSteps</em>' attribute.
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_DSteps()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getDSteps();

	/**
	 * Returns the value of the '<em><b>DDependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DDependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DDependencies</em>' attribute.
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_DDependencies()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getDDependencies();

	/**
	 * Returns the value of the '<em><b>Contained Reference Actions</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Reference Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Reference Actions</em>' reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_ContainedReferenceActions()
	 * @model
	 * @generated
	 */
	List<Action> getContainedReferenceActions();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.trace.ComparedAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_Actions()
	 * @model containment="true"
	 * @generated
	 */
	List<ComparedAction> getActions();

	/**
	 * Returns the value of the '<em><b>Equal</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equal</em>' attribute.
	 * @see turnus.model.analysis.trace.TracePackage#getComparedTrace_Equal()
	 * @model default="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isEqual();

} // ComparedTrace

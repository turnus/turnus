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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Markov Model Action Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.MarkovModelActionData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.MarkovModelActionData#isFirst <em>First</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.MarkovModelActionData#getSuccessorsMap <em>Successors Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.MarkovModelActionData#getSuccessors <em>Successors</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getMarkovModelActionData()
 * @model
 * @generated
 */
public interface MarkovModelActionData extends EObject {
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
	 * @see turnus.model.analysis.trace.TracePackage#getMarkovModelActionData_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.MarkovModelActionData#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>First</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' attribute.
	 * @see #setFirst(boolean)
	 * @see turnus.model.analysis.trace.TracePackage#getMarkovModelActionData_First()
	 * @model
	 * @generated
	 */
	boolean isFirst();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.MarkovModelActionData#isFirst <em>First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' attribute.
	 * @see #isFirst()
	 * @generated
	 */
	void setFirst(boolean value);

	/**
	 * Returns the value of the '<em><b>Successors Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getMarkovModelActionData_SuccessorsMap()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap<turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Action, Long> getSuccessorsMap();

	/**
	 * Returns the value of the '<em><b>Successors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successors</em>' attribute.
	 * @see #setSuccessors(long)
	 * @see turnus.model.analysis.trace.TracePackage#getMarkovModelActionData_Successors()
	 * @model
	 * @generated
	 */
	long getSuccessors();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.MarkovModelActionData#getSuccessors <em>Successors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successors</em>' attribute.
	 * @see #getSuccessors()
	 * @generated
	 */
	void setSuccessors(long value);

} // MarkovModelActionData

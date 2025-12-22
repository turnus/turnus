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
package turnus.model.analysis.pipelining;

import org.eclipse.emf.ecore.EObject;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Variable Pipelining Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getConsecutiveFirings <em>Consecutive Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getPipelinableFirings <em>Pipelinable Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#isPipelinable <em>Pipelinable</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.pipelining.PipeliningPackage#getActionVariablePipeliningData()
 * @model
 * @generated
 */
public interface ActionVariablePipeliningData extends EObject {
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
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getActionVariablePipeliningData_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Consecutive Firings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consecutive Firings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consecutive Firings</em>' containment reference.
	 * @see #setConsecutiveFirings(StatisticalData)
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getActionVariablePipeliningData_ConsecutiveFirings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StatisticalData getConsecutiveFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getConsecutiveFirings <em>Consecutive Firings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consecutive Firings</em>' containment reference.
	 * @see #getConsecutiveFirings()
	 * @generated
	 */
	void setConsecutiveFirings(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Pipelinable Firings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipelinable Firings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelinable Firings</em>' containment reference.
	 * @see #setPipelinableFirings(StatisticalData)
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getActionVariablePipeliningData_PipelinableFirings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StatisticalData getPipelinableFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.pipelining.ActionVariablePipeliningData#getPipelinableFirings <em>Pipelinable Firings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pipelinable Firings</em>' containment reference.
	 * @see #getPipelinableFirings()
	 * @generated
	 */
	void setPipelinableFirings(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Pipelinable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipelinable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelinable</em>' attribute.
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getActionVariablePipeliningData_Pipelinable()
	 * @model default="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isPipelinable();

} // ActionVariablePipeliningData

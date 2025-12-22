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
package turnus.model.analysis.scheduling;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Markov Scheduling Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource <em>Source</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget <em>Target</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingTransition()
 * @model
 * @generated
 */
public interface MarkovSchedulingTransition extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(MarkovSchedulingState)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingTransition_Source()
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getOutgoings
	 * @model opposite="outgoings" required="true"
	 * @generated
	 */
	MarkovSchedulingState getSource();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(MarkovSchedulingState value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(MarkovSchedulingState)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingTransition_Target()
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingState#getIncomings
	 * @model opposite="incomings" required="true"
	 * @generated
	 */
	MarkovSchedulingState getTarget();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(MarkovSchedulingState value);

	/**
	 * Returns the value of the '<em><b>Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Firings</em>' attribute.
	 * @see #setFirings(long)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingTransition_Firings()
	 * @model
	 * @generated
	 */
	long getFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getFirings <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firings</em>' attribute.
	 * @see #getFirings()
	 * @generated
	 */
	void setFirings(long value);

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
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingTransition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MarkovSchedulingTransition

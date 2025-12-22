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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Markov Scheduling State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState()
 * @model
 * @generated
 */
public interface MarkovSchedulingState extends EObject {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(Actor)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState_Actor()
	 * @model required="true"
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(Actor value);

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
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState_Firings()
	 * @model
	 * @generated
	 */
	long getFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getFirings <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firings</em>' attribute.
	 * @see #getFirings()
	 * @generated
	 */
	void setFirings(long value);

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.scheduling.MarkovSchedulingTransition}.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState_Outgoings()
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	List<MarkovSchedulingTransition> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.analysis.scheduling.MarkovSchedulingTransition}.
	 * It is bidirectional and its opposite is '{@link turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState_Incomings()
	 * @see turnus.model.analysis.scheduling.MarkovSchedulingTransition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	List<MarkovSchedulingTransition> getIncomings();

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
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getMarkovSchedulingState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.MarkovSchedulingState#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MarkovSchedulingState

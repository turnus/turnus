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
 * A representation of the model object '<em><b>FSM Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.FSMTransition#getCond <em>Cond</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMTransition#getTargetStateEnumName <em>Target State Enum Name</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMTransition#getSourceStateEnumName <em>Source State Enum Name</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMTransition#getTransitionSchedule <em>Transition Schedule</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMTransition()
 * @model
 * @generated
 */
public interface FSMTransition extends EObject {

	/**
	 * Returns the value of the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond</em>' containment reference.
	 * @see #setCond(FSMCondition)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMTransition_Cond()
	 * @model containment="true"
	 * @generated
	 */
	FSMCondition getCond();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMTransition#getCond <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond</em>' containment reference.
	 * @see #getCond()
	 * @generated
	 */
	void setCond(FSMCondition value);

	/**
	 * Returns the value of the '<em><b>Target State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target State Enum Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target State Enum Name</em>' attribute.
	 * @see #setTargetStateEnumName(String)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMTransition_TargetStateEnumName()
	 * @model
	 * @generated
	 */
	String getTargetStateEnumName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMTransition#getTargetStateEnumName <em>Target State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target State Enum Name</em>' attribute.
	 * @see #getTargetStateEnumName()
	 * @generated
	 */
	void setTargetStateEnumName(String value);

	/**
	 * Returns the value of the '<em><b>Source State Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source State Enum Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source State Enum Name</em>' attribute.
	 * @see #setSourceStateEnumName(String)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMTransition_SourceStateEnumName()
	 * @model
	 * @generated
	 */
	String getSourceStateEnumName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMTransition#getSourceStateEnumName <em>Source State Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source State Enum Name</em>' attribute.
	 * @see #getSourceStateEnumName()
	 * @generated
	 */
	void setSourceStateEnumName(String value);

	/**
	 * Returns the value of the '<em><b>Transition Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Schedule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Schedule</em>' containment reference.
	 * @see #setTransitionSchedule(Sequence)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMTransition_TransitionSchedule()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getTransitionSchedule();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMTransition#getTransitionSchedule <em>Transition Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Schedule</em>' containment reference.
	 * @see #getTransitionSchedule()
	 * @generated
	 */
	void setTransitionSchedule(Sequence value);
} // FSMTransition

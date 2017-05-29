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
 * A representation of the model object '<em><b>FSM Combination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCombination#getCombinator <em>Combinator</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCombination#getCond <em>Cond</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCombination()
 * @model
 * @generated
 */
public interface FSMCombination extends EObject {
	/**
	 * Returns the value of the '<em><b>Combinator</b></em>' attribute.
	 * The literals are from the enumeration {@link turnus.model.analysis.scheduling.FSMCombinator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combinator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combinator</em>' attribute.
	 * @see turnus.model.analysis.scheduling.FSMCombinator
	 * @see #isSetCombinator()
	 * @see #unsetCombinator()
	 * @see #setCombinator(FSMCombinator)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCombination_Combinator()
	 * @model unsettable="true" transient="true"
	 * @generated
	 */
	FSMCombinator getCombinator();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCombination#getCombinator <em>Combinator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combinator</em>' attribute.
	 * @see turnus.model.analysis.scheduling.FSMCombinator
	 * @see #isSetCombinator()
	 * @see #unsetCombinator()
	 * @see #getCombinator()
	 * @generated
	 */
	void setCombinator(FSMCombinator value);

	/**
	 * Unsets the value of the '{@link turnus.model.analysis.scheduling.FSMCombination#getCombinator <em>Combinator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCombinator()
	 * @see #getCombinator()
	 * @see #setCombinator(FSMCombinator)
	 * @generated
	 */
	void unsetCombinator();

	/**
	 * Returns whether the value of the '{@link turnus.model.analysis.scheduling.FSMCombination#getCombinator <em>Combinator</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Combinator</em>' attribute is set.
	 * @see #unsetCombinator()
	 * @see #getCombinator()
	 * @see #setCombinator(FSMCombinator)
	 * @generated
	 */
	boolean isSetCombinator();

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
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCombination_Cond()
	 * @model containment="true"
	 * @generated
	 */
	FSMCondition getCond();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCombination#getCond <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond</em>' containment reference.
	 * @see #getCond()
	 * @generated
	 */
	void setCond(FSMCondition value);

} // FSMCombination

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
 * A representation of the model object '<em><b>FSM Var Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.FSMVarUpdate#getOperation <em>Operation</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMVarUpdate#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMVarUpdate()
 * @model
 * @generated
 */
public interface FSMVarUpdate extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference.
	 * @see #isSetOperation()
	 * @see #unsetOperation()
	 * @see #setOperation(FSMOperation)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMVarUpdate_Operation()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	FSMOperation getOperation();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' containment reference.
	 * @see #isSetOperation()
	 * @see #unsetOperation()
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(FSMOperation value);

	/**
	 * Unsets the value of the '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getOperation <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOperation()
	 * @see #getOperation()
	 * @see #setOperation(FSMOperation)
	 * @generated
	 */
	void unsetOperation();

	/**
	 * Returns whether the value of the '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getOperation <em>Operation</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Operation</em>' containment reference is set.
	 * @see #unsetOperation()
	 * @see #getOperation()
	 * @see #setOperation(FSMOperation)
	 * @generated
	 */
	boolean isSetOperation();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(FSMCondition)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMVarUpdate_Condition()
	 * @model containment="true"
	 * @generated
	 */
	FSMCondition getCondition();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMVarUpdate#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(FSMCondition value);

} // FSMVarUpdate

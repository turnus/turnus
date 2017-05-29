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
 * A representation of the model object '<em><b>FSM Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCondition#getComp <em>Comp</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCondition#getCompval <em>Compval</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCondition#getCombinedCond <em>Combined Cond</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.FSMCondition#getValName <em>Val Name</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCondition()
 * @model
 * @generated
 */
public interface FSMCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Comp</b></em>' attribute.
	 * The default value is <code>"EQ"</code>.
	 * The literals are from the enumeration {@link turnus.model.analysis.scheduling.FSMComparator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comp</em>' attribute.
	 * @see turnus.model.analysis.scheduling.FSMComparator
	 * @see #isSetComp()
	 * @see #unsetComp()
	 * @see #setComp(FSMComparator)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCondition_Comp()
	 * @model default="EQ" unsettable="true"
	 * @generated
	 */
	FSMComparator getComp();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getComp <em>Comp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comp</em>' attribute.
	 * @see turnus.model.analysis.scheduling.FSMComparator
	 * @see #isSetComp()
	 * @see #unsetComp()
	 * @see #getComp()
	 * @generated
	 */
	void setComp(FSMComparator value);

	/**
	 * Unsets the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getComp <em>Comp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetComp()
	 * @see #getComp()
	 * @see #setComp(FSMComparator)
	 * @generated
	 */
	void unsetComp();

	/**
	 * Returns whether the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getComp <em>Comp</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Comp</em>' attribute is set.
	 * @see #unsetComp()
	 * @see #getComp()
	 * @see #setComp(FSMComparator)
	 * @generated
	 */
	boolean isSetComp();

	/**
	 * Returns the value of the '<em><b>Compval</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compval</em>' attribute.
	 * @see #setCompval(Integer)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCondition_Compval()
	 * @model default="0"
	 * @generated
	 */
	Integer getCompval();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getCompval <em>Compval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compval</em>' attribute.
	 * @see #getCompval()
	 * @generated
	 */
	void setCompval(Integer value);

	/**
	 * Returns the value of the '<em><b>Combined Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combined Cond</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combined Cond</em>' containment reference.
	 * @see #setCombinedCond(FSMCombination)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCondition_CombinedCond()
	 * @model containment="true"
	 * @generated
	 */
	FSMCombination getCombinedCond();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getCombinedCond <em>Combined Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combined Cond</em>' containment reference.
	 * @see #getCombinedCond()
	 * @generated
	 */
	void setCombinedCond(FSMCombination value);

	/**
	 * Returns the value of the '<em><b>Val Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Val Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Val Name</em>' attribute.
	 * @see #setValName(String)
	 * @see turnus.model.analysis.scheduling.SchedulingPackage#getFSMCondition_ValName()
	 * @model
	 * @generated
	 */
	String getValName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.scheduling.FSMCondition#getValName <em>Val Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Val Name</em>' attribute.
	 * @see #getValName()
	 * @generated
	 */
	void setValName(String value);

} // FSMCondition

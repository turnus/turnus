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
package turnus.model.architecture;

import org.eclipse.emf.ecore.EObject;

import turnus.common.Attributable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.Link#getProcessingUnit <em>Processing Unit</em>}</li>
 *   <li>{@link turnus.model.architecture.Link#getMedium <em>Medium</em>}</li>
 * </ul>
 *
 * @see turnus.model.architecture.ArchitecturePackage#getLink()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Link extends EObject, Attributable {
	/**
	 * Returns the value of the '<em><b>Processing Unit</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.architecture.ProcessingUnit#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Unit</em>' reference.
	 * @see #setProcessingUnit(ProcessingUnit)
	 * @see turnus.model.architecture.ArchitecturePackage#getLink_ProcessingUnit()
	 * @see turnus.model.architecture.ProcessingUnit#getLinks
	 * @model opposite="links" required="true"
	 * @generated
	 */
	ProcessingUnit getProcessingUnit();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Link#getProcessingUnit <em>Processing Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Unit</em>' reference.
	 * @see #getProcessingUnit()
	 * @generated
	 */
	void setProcessingUnit(ProcessingUnit value);

	/**
	 * Returns the value of the '<em><b>Medium</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link turnus.model.architecture.Medium#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Medium</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Medium</em>' reference.
	 * @see #setMedium(Medium)
	 * @see turnus.model.architecture.ArchitecturePackage#getLink_Medium()
	 * @see turnus.model.architecture.Medium#getLinks
	 * @model opposite="links" required="true"
	 * @generated
	 */
	Medium getMedium();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Link#getMedium <em>Medium</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Medium</em>' reference.
	 * @see #getMedium()
	 * @generated
	 */
	void setMedium(Medium value);

} // Link

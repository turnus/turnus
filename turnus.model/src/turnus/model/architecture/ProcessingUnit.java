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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.common.Attributable;

import turnus.model.common.EOperator;
import turnus.model.common.EType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getLinks <em>Links</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getTypes <em>Types</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getOperators <em>Operators</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getFamily <em>Family</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getClockPeriod <em>Clock Period</em>}</li>
 *   <li>{@link turnus.model.architecture.ProcessingUnit#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit()
 * @model abstract="true" superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface ProcessingUnit extends EObject, Attributable {
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
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.ProcessingUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.architecture.Link}.
	 * It is bidirectional and its opposite is '{@link turnus.model.architecture.Link#getProcessingUnit <em>Processing Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_Links()
	 * @see turnus.model.architecture.Link#getProcessingUnit
	 * @model opposite="processingUnit"
	 * @generated
	 */
	List<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' attribute list.
	 * The list contents are of type {@link turnus.model.common.EType}.
	 * The literals are from the enumeration {@link turnus.model.common.EType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' attribute list.
	 * @see turnus.model.common.EType
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_Types()
	 * @model required="true"
	 * @generated
	 */
	List<EType> getTypes();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link turnus.model.common.EOperator}.
	 * The literals are from the enumeration {@link turnus.model.common.EOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see turnus.model.common.EOperator
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_Operators()
	 * @model required="true"
	 * @generated
	 */
	List<EOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family</em>' attribute.
	 * @see #setFamily(String)
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_Family()
	 * @model
	 * @generated
	 */
	String getFamily();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.ProcessingUnit#getFamily <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' attribute.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(String value);

	/**
	 * Returns the value of the '<em><b>Clock Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Period</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Period</em>' attribute.
	 * @see #setClockPeriod(double)
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_ClockPeriod()
	 * @model
	 * @generated
	 */
	double getClockPeriod();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.ProcessingUnit#getClockPeriod <em>Clock Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock Period</em>' attribute.
	 * @see #getClockPeriod()
	 * @generated
	 */
	void setClockPeriod(double value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see turnus.model.architecture.ArchitecturePackage#getProcessingUnit_ClassName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getClassName();

} // ProcessingUnit

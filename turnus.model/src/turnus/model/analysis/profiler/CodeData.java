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
package turnus.model.analysis.profiler;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.CodeData#getOperatorsCount <em>Operators Count</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.CodeData#getOperandsCount <em>Operands Count</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.CodeData#getBlockName <em>Block Name</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.CodeData#getNol <em>Nol</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiler.ProfilerPackage#getCodeData()
 * @model
 * @generated
 */
public interface CodeData extends EObject {
	/**
	 * Returns the value of the '<em><b>Operators Count</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators Count</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators Count</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getCodeData_OperatorsCount()
	 * @model mapType="turnus.model.analysis.map.StringToIntegerMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	Map<String, Integer> getOperatorsCount();

	/**
	 * Returns the value of the '<em><b>Operands Count</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands Count</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands Count</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getCodeData_OperandsCount()
	 * @model mapType="turnus.model.analysis.map.StringToIntegerMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EIntegerObject>"
	 * @generated
	 */
	Map<String, Integer> getOperandsCount();

	/**
	 * Returns the value of the '<em><b>Block Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Name</em>' attribute.
	 * @see #setBlockName(String)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getCodeData_BlockName()
	 * @model required="true"
	 * @generated
	 */
	String getBlockName();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.CodeData#getBlockName <em>Block Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Name</em>' attribute.
	 * @see #getBlockName()
	 * @generated
	 */
	void setBlockName(String value);

	/**
	 * Returns the value of the '<em><b>Nol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nol</em>' attribute.
	 * @see #setNol(long)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getCodeData_Nol()
	 * @model
	 * @generated
	 */
	long getNol();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.CodeData#getNol <em>Nol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nol</em>' attribute.
	 * @see #getNol()
	 * @generated
	 */
	void setNol(long value);

} // CodeData

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
package turnus.model.analysis.trace;

import java.util.Map;

import turnus.model.dataflow.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compressed Variable Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.CompressedVariableDependency#getReadReadMap <em>Read Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedVariableDependency#getReadWriteMap <em>Read Write Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedVariableDependency#getWriteReadMap <em>Write Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedVariableDependency#getWriteWriteMap <em>Write Write Map</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getCompressedVariableDependency()
 * @model
 * @generated
 */
public interface CompressedVariableDependency extends CompressedDependency {
	/**
	 * Returns the value of the '<em><b>Read Read Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Read Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Read Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedVariableDependency_ReadReadMap()
	 * @model mapType="turnus.model.analysis.map.VariableToLongMap<turnus.model.dataflow.Variable, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Variable, Long> getReadReadMap();

	/**
	 * Returns the value of the '<em><b>Read Write Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Write Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Write Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedVariableDependency_ReadWriteMap()
	 * @model mapType="turnus.model.analysis.map.VariableToLongMap<turnus.model.dataflow.Variable, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Variable, Long> getReadWriteMap();

	/**
	 * Returns the value of the '<em><b>Write Read Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Read Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Read Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedVariableDependency_WriteReadMap()
	 * @model mapType="turnus.model.analysis.map.VariableToLongMap<turnus.model.dataflow.Variable, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Variable, Long> getWriteReadMap();

	/**
	 * Returns the value of the '<em><b>Write Write Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Write Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Write Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedVariableDependency_WriteWriteMap()
	 * @model mapType="turnus.model.analysis.map.VariableToLongMap<turnus.model.dataflow.Variable, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Variable, Long> getWriteWriteMap();

} // CompressedVariableDependency

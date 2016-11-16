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

import turnus.model.dataflow.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compressed Port Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.CompressedPortDependency#getReadMap <em>Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedPortDependency#getWriteMap <em>Write Map</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getCompressedPortDependency()
 * @model
 * @generated
 */
public interface CompressedPortDependency extends CompressedDependency {
	/**
	 * Returns the value of the '<em><b>Read Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Port},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedPortDependency_ReadMap()
	 * @model mapType="turnus.model.analysis.map.PortToLongMap<turnus.model.dataflow.Port, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Port, Long> getReadMap();

	/**
	 * Returns the value of the '<em><b>Write Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Port},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedPortDependency_WriteMap()
	 * @model mapType="turnus.model.analysis.map.PortToLongMap<turnus.model.dataflow.Port, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Port, Long> getWriteMap();

} // CompressedPortDependency

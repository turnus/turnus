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

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compressed Tokens Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.CompressedTokensDependency#getCountMap <em>Count Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.CompressedTokensDependency#getTokensMap <em>Tokens Map</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getCompressedTokensDependency()
 * @model
 * @generated
 */
public interface CompressedTokensDependency extends CompressedDependency {
	/**
	 * Returns the value of the '<em><b>Count Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTokensDependency_CountMap()
	 * @model mapType="turnus.model.analysis.map.BufferToLongMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Buffer, Long> getCountMap();

	/**
	 * Returns the value of the '<em><b>Tokens Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens Map</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getCompressedTokensDependency_TokensMap()
	 * @model mapType="turnus.model.analysis.map.BufferToStatisticalDataMap&lt;turnus.model.dataflow.Buffer, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Buffer, StatisticalData> getTokensMap();

} // CompressedTokensDependency

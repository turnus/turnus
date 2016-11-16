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

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Dynamic Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getReads <em>Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getWrites <em>Writes</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getOccupancy <em>Occupancy</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getActionReads <em>Action Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getActionWrites <em>Action Writes</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getActionPeeks <em>Action Peeks</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getActionReadMisses <em>Action Read Misses</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getActionWriteMisses <em>Action Write Misses</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.BufferDynamicData#getUnconsumedTokens <em>Unconsumed Tokens</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData()
 * @model
 * @generated
 */
public interface BufferDynamicData extends EObject {
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(Buffer)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_Buffer()
	 * @model
	 * @generated
	 */
	Buffer getBuffer();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferDynamicData#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Reads</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reads</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reads</em>' containment reference.
	 * @see #setReads(StatisticalData)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_Reads()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getReads();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferDynamicData#getReads <em>Reads</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reads</em>' containment reference.
	 * @see #getReads()
	 * @generated
	 */
	void setReads(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Writes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writes</em>' containment reference.
	 * @see #setWrites(StatisticalData)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_Writes()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getWrites();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferDynamicData#getWrites <em>Writes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Writes</em>' containment reference.
	 * @see #getWrites()
	 * @generated
	 */
	void setWrites(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Occupancy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occupancy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occupancy</em>' containment reference.
	 * @see #setOccupancy(StatisticalData)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_Occupancy()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getOccupancy();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferDynamicData#getOccupancy <em>Occupancy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occupancy</em>' containment reference.
	 * @see #getOccupancy()
	 * @generated
	 */
	void setOccupancy(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Action Reads</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Reads</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Reads</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_ActionReads()
	 * @model mapType="turnus.model.analysis.map.ActionToStatisticalDataMap<turnus.model.dataflow.Action, turnus.model.common.StatisticalData>"
	 * @generated
	 */
	Map<Action, StatisticalData> getActionReads();

	/**
	 * Returns the value of the '<em><b>Action Writes</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Writes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Writes</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_ActionWrites()
	 * @model mapType="turnus.model.analysis.map.ActionToStatisticalDataMap<turnus.model.dataflow.Action, turnus.model.common.StatisticalData>"
	 * @generated
	 */
	Map<Action, StatisticalData> getActionWrites();

	/**
	 * Returns the value of the '<em><b>Action Peeks</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Peeks</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Peeks</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_ActionPeeks()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap<turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Action, Long> getActionPeeks();

	/**
	 * Returns the value of the '<em><b>Action Read Misses</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Read Misses</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Read Misses</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_ActionReadMisses()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap<turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Action, Long> getActionReadMisses();

	/**
	 * Returns the value of the '<em><b>Action Write Misses</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Write Misses</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Write Misses</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_ActionWriteMisses()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap<turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject>"
	 * @generated
	 */
	Map<Action, Long> getActionWriteMisses();

	/**
	 * Returns the value of the '<em><b>Unconsumed Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unconsumed Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unconsumed Tokens</em>' attribute.
	 * @see #setUnconsumedTokens(int)
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getBufferDynamicData_UnconsumedTokens()
	 * @model
	 * @generated
	 */
	int getUnconsumedTokens();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiler.BufferDynamicData#getUnconsumedTokens <em>Unconsumed Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unconsumed Tokens</em>' attribute.
	 * @see #getUnconsumedTokens()
	 * @generated
	 */
	void setUnconsumedTokens(int value);

} // BufferDynamicData

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
package turnus.model.analysis.bottlenecks;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Bottlenecks With Scheduling Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalFirings <em>Total Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getBlockingInstances <em>Blocking Instances</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData()
 * @model
 * @generated
 */
public interface ActionBottlenecksWithSchedulingData extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Weight</em>' attribute.
	 * @see #setCpWeight(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_CpWeight()
	 * @model required="true"
	 * @generated
	 */
	double getCpWeight();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpWeight <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Weight</em>' attribute.
	 * @see #getCpWeight()
	 * @generated
	 */
	void setCpWeight(double value);

	/**
	 * Returns the value of the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Weight</em>' attribute.
	 * @see #setTotalWeight(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_TotalWeight()
	 * @model required="true"
	 * @generated
	 */
	double getTotalWeight();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalWeight <em>Total Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Weight</em>' attribute.
	 * @see #getTotalWeight()
	 * @generated
	 */
	void setTotalWeight(double value);

	/**
	 * Returns the value of the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Firings</em>' attribute.
	 * @see #setCpFirings(long)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_CpFirings()
	 * @model required="true"
	 * @generated
	 */
	long getCpFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getCpFirings <em>Cp Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Firings</em>' attribute.
	 * @see #getCpFirings()
	 * @generated
	 */
	void setCpFirings(long value);

	/**
	 * Returns the value of the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Firings</em>' attribute.
	 * @see #setTotalFirings(long)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_TotalFirings()
	 * @model required="true"
	 * @generated
	 */
	long getTotalFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksWithSchedulingData#getTotalFirings <em>Total Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Firings</em>' attribute.
	 * @see #getTotalFirings()
	 * @generated
	 */
	void setTotalFirings(long value);

	/**
	 * Returns the value of the '<em><b>Max Blocked Output Tokens</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Blocked Output Tokens</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Blocked Output Tokens</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_MaxBlockedOutputTokens()
	 * @model mapType="turnus.model.analysis.map.BufferToIntegerMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EIntegerObject&gt;"
	 * @generated
	 */
	Map<Buffer, Integer> getMaxBlockedOutputTokens();

	/**
	 * Returns the value of the '<em><b>Max Blocked Multiplication</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Blocked Multiplication</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Blocked Multiplication</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_MaxBlockedMultiplication()
	 * @model mapType="turnus.model.analysis.map.BufferToDoubleMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Buffer, Double> getMaxBlockedMultiplication();

	/**
	 * Returns the value of the '<em><b>Blocking Instances</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocking Instances</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocking Instances</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksWithSchedulingData_BlockingInstances()
	 * @model mapType="turnus.model.analysis.map.BufferToIntegerMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EIntegerObject&gt;"
	 * @generated
	 */
	Map<Buffer, Integer> getBlockingInstances();

} // ActionBottlenecksWithSchedulingData

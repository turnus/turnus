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

import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Dynamic Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getOperandsCalls <em>Operands Calls</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getProceduresCalls <em>Procedures Calls</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getVariablesStores <em>Variables Stores</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getVariablesLoads <em>Variables Loads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getProceduresData <em>Procedures Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getReadTokens <em>Read Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.ComplexDynamicData#getWriteTokens <em>Write Tokens</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData()
 * @model
 * @generated
 */
public interface ComplexDynamicData extends EObject {
	/**
	 * Returns the value of the '<em><b>Operands Calls</b></em>' map.
	 * The key is of type {@link turnus.model.common.EOperator},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands Calls</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands Calls</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_OperandsCalls()
	 * @model mapType="turnus.model.analysis.map.EOperatorToStatisticalDataMap&lt;turnus.model.common.EOperator, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<EOperator, StatisticalData> getOperandsCalls();

	/**
	 * Returns the value of the '<em><b>Procedures Calls</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Procedure},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedures Calls</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedures Calls</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_ProceduresCalls()
	 * @model mapType="turnus.model.analysis.map.ProcedureToStatisticalDataMap&lt;turnus.model.dataflow.Procedure, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Procedure, StatisticalData> getProceduresCalls();

	/**
	 * Returns the value of the '<em><b>Variables Stores</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables Stores</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables Stores</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_VariablesStores()
	 * @model mapType="turnus.model.analysis.map.VariableToStatisticalDataMap&lt;turnus.model.dataflow.Variable, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Variable, StatisticalData> getVariablesStores();

	/**
	 * Returns the value of the '<em><b>Variables Loads</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Variable},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables Loads</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables Loads</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_VariablesLoads()
	 * @model mapType="turnus.model.analysis.map.VariableToStatisticalDataMap&lt;turnus.model.dataflow.Variable, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Variable, StatisticalData> getVariablesLoads();

	/**
	 * Returns the value of the '<em><b>Procedures Data</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Procedure},
	 * and the value is of type {@link turnus.model.analysis.profiler.ComplexDynamicData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedures Data</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedures Data</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_ProceduresData()
	 * @model mapType="turnus.model.analysis.profiler.ProcedureToComplexDynamicDataMap&lt;turnus.model.dataflow.Procedure, turnus.model.analysis.profiler.ComplexDynamicData&gt;"
	 * @generated
	 */
	Map<Procedure, ComplexDynamicData> getProceduresData();

	/**
	 * Returns the value of the '<em><b>Read Tokens</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Tokens</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Tokens</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_ReadTokens()
	 * @model mapType="turnus.model.analysis.map.BufferToStatisticalDataMap&lt;turnus.model.dataflow.Buffer, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Buffer, StatisticalData> getReadTokens();

	/**
	 * Returns the value of the '<em><b>Write Tokens</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Tokens</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Tokens</em>' map.
	 * @see turnus.model.analysis.profiler.ProfilerPackage#getComplexDynamicData_WriteTokens()
	 * @model mapType="turnus.model.analysis.map.BufferToStatisticalDataMap&lt;turnus.model.dataflow.Buffer, turnus.model.common.StatisticalData&gt;"
	 * @generated
	 */
	Map<Buffer, StatisticalData> getWriteTokens();

} // ComplexDynamicData

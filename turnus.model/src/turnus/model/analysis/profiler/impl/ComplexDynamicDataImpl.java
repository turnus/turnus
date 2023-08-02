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
package turnus.model.analysis.profiler.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl;
import turnus.model.analysis.map.impl.EOperatorToStatisticalDataMapImpl;
import turnus.model.analysis.map.impl.ProcedureToStatisticalDataMapImpl;
import turnus.model.analysis.map.impl.VariableToStatisticalDataMapImpl;

import turnus.model.analysis.profiler.ComplexDynamicData;
import turnus.model.analysis.profiler.ProfilerPackage;

import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Dynamic Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getOperandsCalls <em>Operands Calls</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getProceduresCalls <em>Procedures Calls</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getVariablesStores <em>Variables Stores</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getVariablesLoads <em>Variables Loads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getProceduresData <em>Procedures Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getReadTokens <em>Read Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexDynamicDataImpl#getWriteTokens <em>Write Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexDynamicDataImpl extends MinimalEObjectImpl.Container implements ComplexDynamicData {
	/**
	 * The cached value of the '{@link #getOperandsCalls() <em>Operands Calls</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandsCalls()
	 * @generated
	 * @ordered
	 */
	protected EMap<EOperator, StatisticalData> operandsCalls;

	/**
	 * The cached value of the '{@link #getProceduresCalls() <em>Procedures Calls</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProceduresCalls()
	 * @generated
	 * @ordered
	 */
	protected EMap<Procedure, StatisticalData> proceduresCalls;

	/**
	 * The cached value of the '{@link #getVariablesStores() <em>Variables Stores</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariablesStores()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, StatisticalData> variablesStores;

	/**
	 * The cached value of the '{@link #getVariablesLoads() <em>Variables Loads</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariablesLoads()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, StatisticalData> variablesLoads;

	/**
	 * The cached value of the '{@link #getProceduresData() <em>Procedures Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProceduresData()
	 * @generated
	 * @ordered
	 */
	protected EMap<Procedure, ComplexDynamicData> proceduresData;

	/**
	 * The cached value of the '{@link #getReadTokens() <em>Read Tokens</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadTokens()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, StatisticalData> readTokens;

	/**
	 * The cached value of the '{@link #getWriteTokens() <em>Write Tokens</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteTokens()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, StatisticalData> writeTokens;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexDynamicDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.COMPLEX_DYNAMIC_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<EOperator, StatisticalData> getOperandsCalls() {
		if (operandsCalls == null) {
			operandsCalls = new EcoreEMap<EOperator,StatisticalData>(MapPackage.Literals.EOPERATOR_TO_STATISTICAL_DATA_MAP, EOperatorToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS);
		}
		return operandsCalls.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Procedure, StatisticalData> getProceduresCalls() {
		if (proceduresCalls == null) {
			proceduresCalls = new EcoreEMap<Procedure,StatisticalData>(MapPackage.Literals.PROCEDURE_TO_STATISTICAL_DATA_MAP, ProcedureToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS);
		}
		return proceduresCalls.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Variable, StatisticalData> getVariablesStores() {
		if (variablesStores == null) {
			variablesStores = new EcoreEMap<Variable,StatisticalData>(MapPackage.Literals.VARIABLE_TO_STATISTICAL_DATA_MAP, VariableToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES);
		}
		return variablesStores.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Variable, StatisticalData> getVariablesLoads() {
		if (variablesLoads == null) {
			variablesLoads = new EcoreEMap<Variable,StatisticalData>(MapPackage.Literals.VARIABLE_TO_STATISTICAL_DATA_MAP, VariableToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS);
		}
		return variablesLoads.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Procedure, ComplexDynamicData> getProceduresData() {
		if (proceduresData == null) {
			proceduresData = new EcoreEMap<Procedure,ComplexDynamicData>(ProfilerPackage.Literals.PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP, ProcedureToComplexDynamicDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA);
		}
		return proceduresData.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, StatisticalData> getReadTokens() {
		if (readTokens == null) {
			readTokens = new EcoreEMap<Buffer,StatisticalData>(MapPackage.Literals.BUFFER_TO_STATISTICAL_DATA_MAP, BufferToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS);
		}
		return readTokens.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, StatisticalData> getWriteTokens() {
		if (writeTokens == null) {
			writeTokens = new EcoreEMap<Buffer,StatisticalData>(MapPackage.Literals.BUFFER_TO_STATISTICAL_DATA_MAP, BufferToStatisticalDataMapImpl.class, this, ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS);
		}
		return writeTokens.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS:
				return ((InternalEList<?>)((EMap.InternalMapView<EOperator, StatisticalData>)getOperandsCalls()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS:
				return ((InternalEList<?>)((EMap.InternalMapView<Procedure, StatisticalData>)getProceduresCalls()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, StatisticalData>)getVariablesStores()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, StatisticalData>)getVariablesLoads()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA:
				return ((InternalEList<?>)((EMap.InternalMapView<Procedure, ComplexDynamicData>)getProceduresData()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, StatisticalData>)getReadTokens()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, StatisticalData>)getWriteTokens()).eMap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS:
				if (coreType) return ((EMap.InternalMapView<EOperator, StatisticalData>)getOperandsCalls()).eMap();
				else return getOperandsCalls();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS:
				if (coreType) return ((EMap.InternalMapView<Procedure, StatisticalData>)getProceduresCalls()).eMap();
				else return getProceduresCalls();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES:
				if (coreType) return ((EMap.InternalMapView<Variable, StatisticalData>)getVariablesStores()).eMap();
				else return getVariablesStores();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS:
				if (coreType) return ((EMap.InternalMapView<Variable, StatisticalData>)getVariablesLoads()).eMap();
				else return getVariablesLoads();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA:
				if (coreType) return ((EMap.InternalMapView<Procedure, ComplexDynamicData>)getProceduresData()).eMap();
				else return getProceduresData();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS:
				if (coreType) return ((EMap.InternalMapView<Buffer, StatisticalData>)getReadTokens()).eMap();
				else return getReadTokens();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS:
				if (coreType) return ((EMap.InternalMapView<Buffer, StatisticalData>)getWriteTokens()).eMap();
				else return getWriteTokens();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<EOperator, StatisticalData>)getOperandsCalls()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Procedure, StatisticalData>)getProceduresCalls()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, StatisticalData>)getVariablesStores()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, StatisticalData>)getVariablesLoads()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Procedure, ComplexDynamicData>)getProceduresData()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, StatisticalData>)getReadTokens()).eMap()).set(newValue);
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, StatisticalData>)getWriteTokens()).eMap()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS:
				getOperandsCalls().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS:
				getProceduresCalls().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES:
				getVariablesStores().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS:
				getVariablesLoads().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA:
				getProceduresData().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS:
				getReadTokens().clear();
				return;
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS:
				getWriteTokens().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__OPERANDS_CALLS:
				return operandsCalls != null && !operandsCalls.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_CALLS:
				return proceduresCalls != null && !proceduresCalls.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_STORES:
				return variablesStores != null && !variablesStores.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__VARIABLES_LOADS:
				return variablesLoads != null && !variablesLoads.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__PROCEDURES_DATA:
				return proceduresData != null && !proceduresData.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__READ_TOKENS:
				return readTokens != null && !readTokens.isEmpty();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA__WRITE_TOKENS:
				return writeTokens != null && !writeTokens.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexDynamicDataImpl

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
package turnus.model.analysis.profiler.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;
import turnus.model.analysis.profiler.*;

import turnus.model.dataflow.Procedure;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.profiler.ProfilerPackage
 * @generated
 */
public class ProfilerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProfilerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilerSwitch() {
		if (modelPackage == null) {
			modelPackage = ProfilerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ProfilerPackage.CODE_PROFILING_REPORT: {
				CodeProfilingReport codeProfilingReport = (CodeProfilingReport)theEObject;
				T result = caseCodeProfilingReport(codeProfilingReport);
				if (result == null) result = caseAnalysisReport(codeProfilingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.CODE_DATA: {
				CodeData codeData = (CodeData)theEObject;
				T result = caseCodeData(codeData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.COMPLEX_CODE_DATA: {
				ComplexCodeData complexCodeData = (ComplexCodeData)theEObject;
				T result = caseComplexCodeData(complexCodeData);
				if (result == null) result = caseCodeData(complexCodeData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT: {
				DynamicProfilingReport dynamicProfilingReport = (DynamicProfilingReport)theEObject;
				T result = caseDynamicProfilingReport(dynamicProfilingReport);
				if (result == null) result = caseAnalysisReport(dynamicProfilingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.ACTOR_DYNAMIC_DATA: {
				ActorDynamicData actorDynamicData = (ActorDynamicData)theEObject;
				T result = caseActorDynamicData(actorDynamicData);
				if (result == null) result = caseComplexDynamicData(actorDynamicData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.ACTION_DYNAMIC_DATA: {
				ActionDynamicData actionDynamicData = (ActionDynamicData)theEObject;
				T result = caseActionDynamicData(actionDynamicData);
				if (result == null) result = caseComplexDynamicData(actionDynamicData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.BUFFER_DYNAMIC_DATA: {
				BufferDynamicData bufferDynamicData = (BufferDynamicData)theEObject;
				T result = caseBufferDynamicData(bufferDynamicData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA: {
				ComplexDynamicData complexDynamicData = (ComplexDynamicData)theEObject;
				T result = caseComplexDynamicData(complexDynamicData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Procedure, ComplexDynamicData> procedureToComplexDynamicDataMap = (Map.Entry<Procedure, ComplexDynamicData>)theEObject;
				T result = caseProcedureToComplexDynamicDataMap(procedureToComplexDynamicDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.MEMORY_PROFILING_REPORT: {
				MemoryProfilingReport memoryProfilingReport = (MemoryProfilingReport)theEObject;
				T result = caseMemoryProfilingReport(memoryProfilingReport);
				if (result == null) result = caseAnalysisReport(memoryProfilingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA: {
				ActionMemoryProfilingData actionMemoryProfilingData = (ActionMemoryProfilingData)theEObject;
				T result = caseActionMemoryProfilingData(actionMemoryProfilingData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.MEMORY_ACCESS_DATA: {
				MemoryAccessData memoryAccessData = (MemoryAccessData)theEObject;
				T result = caseMemoryAccessData(memoryAccessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.BUFFER_ACCESS_DATA: {
				BufferAccessData bufferAccessData = (BufferAccessData)theEObject;
				T result = caseBufferAccessData(bufferAccessData);
				if (result == null) result = caseMemoryAccessData(bufferAccessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.STATE_VARIABLE_ACCESS_DATA: {
				StateVariableAccessData stateVariableAccessData = (StateVariableAccessData)theEObject;
				T result = caseStateVariableAccessData(stateVariableAccessData);
				if (result == null) result = caseMemoryAccessData(stateVariableAccessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.LOCAL_VARIABLE_ACCESS_DATA: {
				LocalVariableAccessData localVariableAccessData = (LocalVariableAccessData)theEObject;
				T result = caseLocalVariableAccessData(localVariableAccessData);
				if (result == null) result = caseMemoryAccessData(localVariableAccessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.SHARED_VARIABLE_ACCESS_DATA: {
				SharedVariableAccessData sharedVariableAccessData = (SharedVariableAccessData)theEObject;
				T result = caseSharedVariableAccessData(sharedVariableAccessData);
				if (result == null) result = caseMemoryAccessData(sharedVariableAccessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.ACCESS_DATA: {
				AccessData accessData = (AccessData)theEObject;
				T result = caseAccessData(accessData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilerPackage.STRING_TO_ACCESS_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, AccessData> stringToAccessDataMap = (Map.Entry<String, AccessData>)theEObject;
				T result = caseStringToAccessDataMap(stringToAccessDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Profiling Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeProfilingReport(CodeProfilingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeData(CodeData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Code Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Code Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexCodeData(ComplexCodeData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Profiling Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicProfilingReport(DynamicProfilingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Dynamic Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorDynamicData(ActorDynamicData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Dynamic Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionDynamicData(ActionDynamicData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Dynamic Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferDynamicData(BufferDynamicData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Dynamic Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexDynamicData(ComplexDynamicData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure To Complex Dynamic Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure To Complex Dynamic Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedureToComplexDynamicDataMap(Map.Entry<Procedure, ComplexDynamicData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Profiling Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryProfilingReport(MemoryProfilingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Memory Profiling Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Memory Profiling Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionMemoryProfilingData(ActionMemoryProfilingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryAccessData(MemoryAccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferAccessData(BufferAccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Variable Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVariableAccessData(StateVariableAccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariableAccessData(LocalVariableAccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Variable Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSharedVariableAccessData(SharedVariableAccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessData(AccessData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Access Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Access Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToAccessDataMap(Map.Entry<String, AccessData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisReport(AnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ProfilerSwitch

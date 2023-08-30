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
package turnus.model.analysis.map.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.map.*;

import turnus.model.analysis.scheduling.ActorSelectionSchedule;
import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.Variable;

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
 * @see turnus.model.analysis.map.MapPackage
 * @generated
 */
public class MapSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MapPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapSwitch() {
		if (modelPackage == null) {
			modelPackage = MapPackage.eINSTANCE;
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
			case MapPackage.STRING_TO_INTEGER_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Integer> stringToIntegerMap = (Map.Entry<String, Integer>)theEObject;
				T result = caseStringToIntegerMap(stringToIntegerMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTOR_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Actor, StatisticalData> actorToStatisticalDataMap = (Map.Entry<Actor, StatisticalData>)theEObject;
				T result = caseActorToStatisticalDataMap(actorToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTION_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Action, StatisticalData> actionToStatisticalDataMap = (Map.Entry<Action, StatisticalData>)theEObject;
				T result = caseActionToStatisticalDataMap(actionToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.BUFFER_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Buffer, StatisticalData> bufferToStatisticalDataMap = (Map.Entry<Buffer, StatisticalData>)theEObject;
				T result = caseBufferToStatisticalDataMap(bufferToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.PROCEDURE_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Procedure, StatisticalData> procedureToStatisticalDataMap = (Map.Entry<Procedure, StatisticalData>)theEObject;
				T result = caseProcedureToStatisticalDataMap(procedureToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.VARIABLE_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Variable, StatisticalData> variableToStatisticalDataMap = (Map.Entry<Variable, StatisticalData>)theEObject;
				T result = caseVariableToStatisticalDataMap(variableToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTOR_CLASS_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<ActorClass, StatisticalData> actorClassToStatisticalDataMap = (Map.Entry<ActorClass, StatisticalData>)theEObject;
				T result = caseActorClassToStatisticalDataMap(actorClassToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.EOPERATOR_TO_STATISTICAL_DATA_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<EOperator, StatisticalData> eOperatorToStatisticalDataMap = (Map.Entry<EOperator, StatisticalData>)theEObject;
				T result = caseEOperatorToStatisticalDataMap(eOperatorToStatisticalDataMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTION_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Action, Long> actionToLongMap = (Map.Entry<Action, Long>)theEObject;
				T result = caseActionToLongMap(actionToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTOR_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Actor, Long> actorToLongMap = (Map.Entry<Actor, Long>)theEObject;
				T result = caseActorToLongMap(actorToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.BUFFER_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Buffer, Long> bufferToLongMap = (Map.Entry<Buffer, Long>)theEObject;
				T result = caseBufferToLongMap(bufferToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.STRING_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Long> stringToLongMap = (Map.Entry<String, Long>)theEObject;
				T result = caseStringToLongMap(stringToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.DOUBLE_TO_DOUBLE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Double, Double> doubleToDoubleMap = (Map.Entry<Double, Double>)theEObject;
				T result = caseDoubleToDoubleMap(doubleToDoubleMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.VARIABLE_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Variable, Long> variableToLongMap = (Map.Entry<Variable, Long>)theEObject;
				T result = caseVariableToLongMap(variableToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.GUARD_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Guard, Long> guardToLongMap = (Map.Entry<Guard, Long>)theEObject;
				T result = caseGuardToLongMap(guardToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.PORT_TO_LONG_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Port, Long> portToLongMap = (Map.Entry<Port, Long>)theEObject;
				T result = casePortToLongMap(portToLongMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.STRING_TO_DOUBLE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Double> stringToDoubleMap = (Map.Entry<String, Double>)theEObject;
				T result = caseStringToDoubleMap(stringToDoubleMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTION_TO_DOUBLE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Action, Double> actionToDoubleMap = (Map.Entry<Action, Double>)theEObject;
				T result = caseActionToDoubleMap(actionToDoubleMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.BUFFER_TO_INTEGER_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Buffer, Integer> bufferToIntegerMap = (Map.Entry<Buffer, Integer>)theEObject;
				T result = caseBufferToIntegerMap(bufferToIntegerMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.BUFFER_TO_DOUBLE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Buffer, Double> bufferToDoubleMap = (Map.Entry<Buffer, Double>)theEObject;
				T result = caseBufferToDoubleMap(bufferToDoubleMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, ActorSelectionSchedule> partitionToActorSelectionScheduleMap = (Map.Entry<String, ActorSelectionSchedule>)theEObject;
				T result = casePartitionToActorSelectionScheduleMap(partitionToActorSelectionScheduleMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.STRING_TO_STRING_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> stringToStringMap = (Map.Entry<String, String>)theEObject;
				T result = caseStringToStringMap(stringToStringMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MapPackage.ACTOR_TO_STRING_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Actor, String> actorToStringMap = (Map.Entry<Actor, String>)theEObject;
				T result = caseActorToStringMap(actorToStringMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Integer Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Integer Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToIntegerMap(Map.Entry<String, Integer> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorToStatisticalDataMap(Map.Entry<Actor, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionToStatisticalDataMap(Map.Entry<Action, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferToStatisticalDataMap(Map.Entry<Buffer, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedureToStatisticalDataMap(Map.Entry<Procedure, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableToStatisticalDataMap(Map.Entry<Variable, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Class To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Class To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorClassToStatisticalDataMap(Map.Entry<ActorClass, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOperator To Statistical Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOperator To Statistical Data Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEOperatorToStatisticalDataMap(Map.Entry<EOperator, StatisticalData> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionToLongMap(Map.Entry<Action, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorToLongMap(Map.Entry<Actor, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferToLongMap(Map.Entry<Buffer, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToLongMap(Map.Entry<String, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double To Double Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double To Double Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleToDoubleMap(Map.Entry<Double, Double> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableToLongMap(Map.Entry<Variable, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardToLongMap(Map.Entry<Guard, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port To Long Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port To Long Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortToLongMap(Map.Entry<Port, Long> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Double Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Double Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToDoubleMap(Map.Entry<String, Double> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action To Double Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action To Double Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionToDoubleMap(Map.Entry<Action, Double> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer To Integer Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer To Integer Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferToIntegerMap(Map.Entry<Buffer, Integer> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer To Double Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer To Double Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferToDoubleMap(Map.Entry<Buffer, Double> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partition To Actor Selection Schedule Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partition To Actor Selection Schedule Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartitionToActorSelectionScheduleMap(Map.Entry<String, ActorSelectionSchedule> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To String Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To String Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToStringMap(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor To String Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor To String Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorToStringMap(Map.Entry<Actor, String> object) {
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

} //MapSwitch

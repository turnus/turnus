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
package turnus.model.analysis.map.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MapFactoryImpl extends EFactoryImpl implements MapFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MapFactory init() {
		try {
			MapFactory theMapFactory = (MapFactory)EPackage.Registry.INSTANCE.getEFactory(MapPackage.eNS_URI);
			if (theMapFactory != null) {
				return theMapFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MapFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MapPackage.STRING_TO_INTEGER_MAP: return (EObject)createStringToIntegerMap();
			case MapPackage.ACTOR_TO_STATISTICAL_DATA_MAP: return (EObject)createActorToStatisticalDataMap();
			case MapPackage.ACTION_TO_STATISTICAL_DATA_MAP: return (EObject)createActionToStatisticalDataMap();
			case MapPackage.BUFFER_TO_STATISTICAL_DATA_MAP: return (EObject)createBufferToStatisticalDataMap();
			case MapPackage.PROCEDURE_TO_STATISTICAL_DATA_MAP: return (EObject)createProcedureToStatisticalDataMap();
			case MapPackage.VARIABLE_TO_STATISTICAL_DATA_MAP: return (EObject)createVariableToStatisticalDataMap();
			case MapPackage.ACTOR_CLASS_TO_STATISTICAL_DATA_MAP: return (EObject)createActorClassToStatisticalDataMap();
			case MapPackage.EOPERATOR_TO_STATISTICAL_DATA_MAP: return (EObject)createEOperatorToStatisticalDataMap();
			case MapPackage.ACTION_TO_LONG_MAP: return (EObject)createActionToLongMap();
			case MapPackage.ACTOR_TO_LONG_MAP: return (EObject)createActorToLongMap();
			case MapPackage.BUFFER_TO_LONG_MAP: return (EObject)createBufferToLongMap();
			case MapPackage.STRING_TO_LONG_MAP: return (EObject)createStringToLongMap();
			case MapPackage.DOUBLE_TO_DOUBLE_MAP: return (EObject)createDoubleToDoubleMap();
			case MapPackage.VARIABLE_TO_LONG_MAP: return (EObject)createVariableToLongMap();
			case MapPackage.GUARD_TO_LONG_MAP: return (EObject)createGuardToLongMap();
			case MapPackage.PORT_TO_LONG_MAP: return (EObject)createPortToLongMap();
			case MapPackage.STRING_TO_DOUBLE_MAP: return (EObject)createStringToDoubleMap();
			case MapPackage.ACTION_TO_DOUBLE_MAP: return (EObject)createActionToDoubleMap();
			case MapPackage.BUFFER_TO_INTEGER_MAP: return (EObject)createBufferToIntegerMap();
			case MapPackage.BUFFER_TO_DOUBLE_MAP: return (EObject)createBufferToDoubleMap();
			case MapPackage.PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP: return (EObject)createPartitionToActorSelectionScheduleMap();
			case MapPackage.STRING_TO_STRING_MAP: return (EObject)createStringToStringMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Integer> createStringToIntegerMap() {
		StringToIntegerMapImpl stringToIntegerMap = new StringToIntegerMapImpl();
		return stringToIntegerMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Actor, StatisticalData> createActorToStatisticalDataMap() {
		ActorToStatisticalDataMapImpl actorToStatisticalDataMap = new ActorToStatisticalDataMapImpl();
		return actorToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Action, StatisticalData> createActionToStatisticalDataMap() {
		ActionToStatisticalDataMapImpl actionToStatisticalDataMap = new ActionToStatisticalDataMapImpl();
		return actionToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Buffer, StatisticalData> createBufferToStatisticalDataMap() {
		BufferToStatisticalDataMapImpl bufferToStatisticalDataMap = new BufferToStatisticalDataMapImpl();
		return bufferToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Procedure, StatisticalData> createProcedureToStatisticalDataMap() {
		ProcedureToStatisticalDataMapImpl procedureToStatisticalDataMap = new ProcedureToStatisticalDataMapImpl();
		return procedureToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Variable, StatisticalData> createVariableToStatisticalDataMap() {
		VariableToStatisticalDataMapImpl variableToStatisticalDataMap = new VariableToStatisticalDataMapImpl();
		return variableToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<ActorClass, StatisticalData> createActorClassToStatisticalDataMap() {
		ActorClassToStatisticalDataMapImpl actorClassToStatisticalDataMap = new ActorClassToStatisticalDataMapImpl();
		return actorClassToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EOperator, StatisticalData> createEOperatorToStatisticalDataMap() {
		EOperatorToStatisticalDataMapImpl eOperatorToStatisticalDataMap = new EOperatorToStatisticalDataMapImpl();
		return eOperatorToStatisticalDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Action, Long> createActionToLongMap() {
		ActionToLongMapImpl actionToLongMap = new ActionToLongMapImpl();
		return actionToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Actor, Long> createActorToLongMap() {
		ActorToLongMapImpl actorToLongMap = new ActorToLongMapImpl();
		return actorToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Buffer, Long> createBufferToLongMap() {
		BufferToLongMapImpl bufferToLongMap = new BufferToLongMapImpl();
		return bufferToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Long> createStringToLongMap() {
		StringToLongMapImpl stringToLongMap = new StringToLongMapImpl();
		return stringToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Double, Double> createDoubleToDoubleMap() {
		DoubleToDoubleMapImpl doubleToDoubleMap = new DoubleToDoubleMapImpl();
		return doubleToDoubleMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Variable, Long> createVariableToLongMap() {
		VariableToLongMapImpl variableToLongMap = new VariableToLongMapImpl();
		return variableToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Guard, Long> createGuardToLongMap() {
		GuardToLongMapImpl guardToLongMap = new GuardToLongMapImpl();
		return guardToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Port, Long> createPortToLongMap() {
		PortToLongMapImpl portToLongMap = new PortToLongMapImpl();
		return portToLongMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Double> createStringToDoubleMap() {
		StringToDoubleMapImpl stringToDoubleMap = new StringToDoubleMapImpl();
		return stringToDoubleMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Action, Double> createActionToDoubleMap() {
		ActionToDoubleMapImpl actionToDoubleMap = new ActionToDoubleMapImpl();
		return actionToDoubleMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Buffer, Integer> createBufferToIntegerMap() {
		BufferToIntegerMapImpl bufferToIntegerMap = new BufferToIntegerMapImpl();
		return bufferToIntegerMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Buffer, Double> createBufferToDoubleMap() {
		BufferToDoubleMapImpl bufferToDoubleMap = new BufferToDoubleMapImpl();
		return bufferToDoubleMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ActorSelectionSchedule> createPartitionToActorSelectionScheduleMap() {
		PartitionToActorSelectionScheduleMapImpl partitionToActorSelectionScheduleMap = new PartitionToActorSelectionScheduleMapImpl();
		return partitionToActorSelectionScheduleMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createStringToStringMap() {
		StringToStringMapImpl stringToStringMap = new StringToStringMapImpl();
		return stringToStringMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MapPackage getMapPackage() {
		return (MapPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MapPackage getPackage() {
		return MapPackage.eINSTANCE;
	}

} //MapFactoryImpl

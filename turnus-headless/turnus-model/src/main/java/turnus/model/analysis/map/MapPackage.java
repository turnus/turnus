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
package turnus.model.analysis.map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.map.MapFactory
 * @model kind="package"
 * @generated
 */
public interface MapPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "map";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/map";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.map";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MapPackage eINSTANCE = turnus.model.analysis.map.impl.MapPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.StringToIntegerMapImpl <em>String To Integer Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.StringToIntegerMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToIntegerMap()
	 * @generated
	 */
	int STRING_TO_INTEGER_MAP = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_INTEGER_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_INTEGER_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Integer Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_INTEGER_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Integer Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_INTEGER_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl <em>Actor To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToStatisticalDataMap()
	 * @generated
	 */
	int ACTOR_TO_STATISTICAL_DATA_MAP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Actor To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Actor To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl <em>Action To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToStatisticalDataMap()
	 * @generated
	 */
	int ACTION_TO_STATISTICAL_DATA_MAP = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Action To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Action To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl <em>Buffer To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToStatisticalDataMap()
	 * @generated
	 */
	int BUFFER_TO_STATISTICAL_DATA_MAP = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Buffer To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Buffer To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ProcedureToStatisticalDataMapImpl <em>Procedure To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ProcedureToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getProcedureToStatisticalDataMap()
	 * @generated
	 */
	int PROCEDURE_TO_STATISTICAL_DATA_MAP = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Procedure To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Procedure To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.VariableToStatisticalDataMapImpl <em>Variable To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.VariableToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getVariableToStatisticalDataMap()
	 * @generated
	 */
	int VARIABLE_TO_STATISTICAL_DATA_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Variable To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActorClassToStatisticalDataMapImpl <em>Actor Class To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActorClassToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorClassToStatisticalDataMap()
	 * @generated
	 */
	int ACTOR_CLASS_TO_STATISTICAL_DATA_MAP = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Actor Class To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Actor Class To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.EOperatorToStatisticalDataMapImpl <em>EOperator To Statistical Data Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.EOperatorToStatisticalDataMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getEOperatorToStatisticalDataMap()
	 * @generated
	 */
	int EOPERATOR_TO_STATISTICAL_DATA_MAP = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATOR_TO_STATISTICAL_DATA_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATOR_TO_STATISTICAL_DATA_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EOperator To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATOR_TO_STATISTICAL_DATA_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EOperator To Statistical Data Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOPERATOR_TO_STATISTICAL_DATA_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActionToLongMapImpl <em>Action To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActionToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToLongMap()
	 * @generated
	 */
	int ACTION_TO_LONG_MAP = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Action To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Action To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_LONG_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActorToLongMapImpl <em>Actor To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActorToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToLongMap()
	 * @generated
	 */
	int ACTOR_TO_LONG_MAP = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Actor To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Actor To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_LONG_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.BufferToLongMapImpl <em>Buffer To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.BufferToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToLongMap()
	 * @generated
	 */
	int BUFFER_TO_LONG_MAP = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Buffer To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Buffer To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_LONG_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.StringToLongMapImpl <em>String To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.StringToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToLongMap()
	 * @generated
	 */
	int STRING_TO_LONG_MAP = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_LONG_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.DoubleToDoubleMapImpl <em>Double To Double Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.DoubleToDoubleMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getDoubleToDoubleMap()
	 * @generated
	 */
	int DOUBLE_TO_DOUBLE_MAP = 12;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_DOUBLE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_DOUBLE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Double To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_DOUBLE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Double To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TO_DOUBLE_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.VariableToLongMapImpl <em>Variable To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.VariableToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getVariableToLongMap()
	 * @generated
	 */
	int VARIABLE_TO_LONG_MAP = 13;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Variable To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TO_LONG_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.GuardToLongMapImpl <em>Guard To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.GuardToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getGuardToLongMap()
	 * @generated
	 */
	int GUARD_TO_LONG_MAP = 14;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Guard To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Guard To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_TO_LONG_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.PortToLongMapImpl <em>Port To Long Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.PortToLongMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getPortToLongMap()
	 * @generated
	 */
	int PORT_TO_LONG_MAP = 15;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_LONG_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_LONG_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Port To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_LONG_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Port To Long Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_LONG_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.StringToDoubleMapImpl <em>String To Double Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.StringToDoubleMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToDoubleMap()
	 * @generated
	 */
	int STRING_TO_DOUBLE_MAP = 16;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_DOUBLE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_DOUBLE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_DOUBLE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_DOUBLE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActionToDoubleMapImpl <em>Action To Double Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActionToDoubleMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToDoubleMap()
	 * @generated
	 */
	int ACTION_TO_DOUBLE_MAP = 17;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_DOUBLE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_DOUBLE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Action To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_DOUBLE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Action To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TO_DOUBLE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.BufferToIntegerMapImpl <em>Buffer To Integer Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.BufferToIntegerMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToIntegerMap()
	 * @generated
	 */
	int BUFFER_TO_INTEGER_MAP = 18;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_INTEGER_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_INTEGER_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Buffer To Integer Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_INTEGER_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Buffer To Integer Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_INTEGER_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.BufferToDoubleMapImpl <em>Buffer To Double Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.BufferToDoubleMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToDoubleMap()
	 * @generated
	 */
	int BUFFER_TO_DOUBLE_MAP = 19;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_DOUBLE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_DOUBLE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Buffer To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_DOUBLE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Buffer To Double Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_TO_DOUBLE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.PartitionToActorSelectionScheduleMapImpl <em>Partition To Actor Selection Schedule Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.PartitionToActorSelectionScheduleMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getPartitionToActorSelectionScheduleMap()
	 * @generated
	 */
	int PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP = 20;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Partition To Actor Selection Schedule Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Partition To Actor Selection Schedule Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.StringToStringMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToStringMap()
	 * @generated
	 */
	int STRING_TO_STRING_MAP = 21;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.map.impl.ActorToStringMapImpl <em>Actor To String Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.map.impl.ActorToStringMapImpl
	 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToStringMap()
	 * @generated
	 */
	int ACTOR_TO_STRING_MAP = 22;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Actor To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Actor To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TO_STRING_MAP_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Integer Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Integer Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getStringToIntegerMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToIntegerMap()
	 * @generated
	 */
	EAttribute getStringToIntegerMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToIntegerMap()
	 * @generated
	 */
	EAttribute getStringToIntegerMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Actor To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Actor"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getActorToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToStatisticalDataMap()
	 * @generated
	 */
	EReference getActorToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToStatisticalDataMap()
	 * @generated
	 */
	EReference getActorToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Action To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Action"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getActionToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToStatisticalDataMap()
	 * @generated
	 */
	EReference getActionToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToStatisticalDataMap()
	 * @generated
	 */
	EReference getActionToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Buffer To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Buffer"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getBufferToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToStatisticalDataMap()
	 * @generated
	 */
	EReference getBufferToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToStatisticalDataMap()
	 * @generated
	 */
	EReference getBufferToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Procedure To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Procedure"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getProcedureToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProcedureToStatisticalDataMap()
	 * @generated
	 */
	EReference getProcedureToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProcedureToStatisticalDataMap()
	 * @generated
	 */
	EReference getProcedureToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Variable To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Variable"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getVariableToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableToStatisticalDataMap()
	 * @generated
	 */
	EReference getVariableToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableToStatisticalDataMap()
	 * @generated
	 */
	EReference getVariableToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Actor Class To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Class To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.ActorClass"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getActorClassToStatisticalDataMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorClassToStatisticalDataMap()
	 * @generated
	 */
	EReference getActorClassToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorClassToStatisticalDataMap()
	 * @generated
	 */
	EReference getActorClassToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EOperator To Statistical Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOperator To Statistical Data Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="turnus.model.common.EOperator"
	 *        valueType="turnus.model.common.StatisticalData" valueContainment="true"
	 * @generated
	 */
	EClass getEOperatorToStatisticalDataMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEOperatorToStatisticalDataMap()
	 * @generated
	 */
	EAttribute getEOperatorToStatisticalDataMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEOperatorToStatisticalDataMap()
	 * @generated
	 */
	EReference getEOperatorToStatisticalDataMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Action To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Action"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getActionToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToLongMap()
	 * @generated
	 */
	EReference getActionToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToLongMap()
	 * @generated
	 */
	EAttribute getActionToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Actor To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Actor"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getActorToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToLongMap()
	 * @generated
	 */
	EReference getActorToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToLongMap()
	 * @generated
	 */
	EAttribute getActorToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Buffer To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Buffer"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getBufferToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToLongMap()
	 * @generated
	 */
	EReference getBufferToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToLongMap()
	 * @generated
	 */
	EAttribute getBufferToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getStringToLongMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToLongMap()
	 * @generated
	 */
	EAttribute getStringToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToLongMap()
	 * @generated
	 */
	EAttribute getStringToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Double To Double Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double To Double Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EDoubleObject"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject"
	 * @generated
	 */
	EClass getDoubleToDoubleMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToDoubleMap()
	 * @generated
	 */
	EAttribute getDoubleToDoubleMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDoubleToDoubleMap()
	 * @generated
	 */
	EAttribute getDoubleToDoubleMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Variable To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Variable"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getVariableToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableToLongMap()
	 * @generated
	 */
	EReference getVariableToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableToLongMap()
	 * @generated
	 */
	EAttribute getVariableToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Guard To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Guard"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getGuardToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getGuardToLongMap()
	 * @generated
	 */
	EReference getGuardToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getGuardToLongMap()
	 * @generated
	 */
	EAttribute getGuardToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Port To Long Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port To Long Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Port"
	 *        valueDataType="org.eclipse.emf.ecore.ELongObject"
	 * @generated
	 */
	EClass getPortToLongMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToLongMap()
	 * @generated
	 */
	EReference getPortToLongMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToLongMap()
	 * @generated
	 */
	EAttribute getPortToLongMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Double Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Double Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject"
	 * @generated
	 */
	EClass getStringToDoubleMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToDoubleMap()
	 * @generated
	 */
	EAttribute getStringToDoubleMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToDoubleMap()
	 * @generated
	 */
	EAttribute getStringToDoubleMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Action To Double Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action To Double Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Action"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject"
	 * @generated
	 */
	EClass getActionToDoubleMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToDoubleMap()
	 * @generated
	 */
	EReference getActionToDoubleMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionToDoubleMap()
	 * @generated
	 */
	EAttribute getActionToDoubleMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Buffer To Integer Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer To Integer Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Buffer"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getBufferToIntegerMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToIntegerMap()
	 * @generated
	 */
	EReference getBufferToIntegerMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToIntegerMap()
	 * @generated
	 */
	EAttribute getBufferToIntegerMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Buffer To Double Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer To Double Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Buffer"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject"
	 * @generated
	 */
	EClass getBufferToDoubleMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToDoubleMap()
	 * @generated
	 */
	EReference getBufferToDoubleMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getBufferToDoubleMap()
	 * @generated
	 */
	EAttribute getBufferToDoubleMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Partition To Actor Selection Schedule Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partition To Actor Selection Schedule Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="turnus.model.analysis.scheduling.ActorSelectionSchedule" valueContainment="true"
	 * @generated
	 */
	EClass getPartitionToActorSelectionScheduleMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPartitionToActorSelectionScheduleMap()
	 * @generated
	 */
	EAttribute getPartitionToActorSelectionScheduleMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPartitionToActorSelectionScheduleMap()
	 * @generated
	 */
	EReference getPartitionToActorSelectionScheduleMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To String Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getStringToStringMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMap()
	 * @generated
	 */
	EAttribute getStringToStringMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMap()
	 * @generated
	 */
	EAttribute getStringToStringMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Actor To String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor To String Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="turnus.model.dataflow.Actor"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getActorToStringMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToStringMap()
	 * @generated
	 */
	EReference getActorToStringMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActorToStringMap()
	 * @generated
	 */
	EAttribute getActorToStringMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MapFactory getMapFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.StringToIntegerMapImpl <em>String To Integer Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.StringToIntegerMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToIntegerMap()
		 * @generated
		 */
		EClass STRING_TO_INTEGER_MAP = eINSTANCE.getStringToIntegerMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_INTEGER_MAP__KEY = eINSTANCE.getStringToIntegerMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_INTEGER_MAP__VALUE = eINSTANCE.getStringToIntegerMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl <em>Actor To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToStatisticalDataMap()
		 * @generated
		 */
		EClass ACTOR_TO_STATISTICAL_DATA_MAP = eINSTANCE.getActorToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getActorToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getActorToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl <em>Action To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToStatisticalDataMap()
		 * @generated
		 */
		EClass ACTION_TO_STATISTICAL_DATA_MAP = eINSTANCE.getActionToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getActionToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getActionToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl <em>Buffer To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToStatisticalDataMap()
		 * @generated
		 */
		EClass BUFFER_TO_STATISTICAL_DATA_MAP = eINSTANCE.getBufferToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getBufferToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getBufferToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ProcedureToStatisticalDataMapImpl <em>Procedure To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ProcedureToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getProcedureToStatisticalDataMap()
		 * @generated
		 */
		EClass PROCEDURE_TO_STATISTICAL_DATA_MAP = eINSTANCE.getProcedureToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getProcedureToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getProcedureToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.VariableToStatisticalDataMapImpl <em>Variable To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.VariableToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getVariableToStatisticalDataMap()
		 * @generated
		 */
		EClass VARIABLE_TO_STATISTICAL_DATA_MAP = eINSTANCE.getVariableToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getVariableToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getVariableToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActorClassToStatisticalDataMapImpl <em>Actor Class To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActorClassToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorClassToStatisticalDataMap()
		 * @generated
		 */
		EClass ACTOR_CLASS_TO_STATISTICAL_DATA_MAP = eINSTANCE.getActorClassToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CLASS_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getActorClassToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CLASS_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getActorClassToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.EOperatorToStatisticalDataMapImpl <em>EOperator To Statistical Data Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.EOperatorToStatisticalDataMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getEOperatorToStatisticalDataMap()
		 * @generated
		 */
		EClass EOPERATOR_TO_STATISTICAL_DATA_MAP = eINSTANCE.getEOperatorToStatisticalDataMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOPERATOR_TO_STATISTICAL_DATA_MAP__KEY = eINSTANCE.getEOperatorToStatisticalDataMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOPERATOR_TO_STATISTICAL_DATA_MAP__VALUE = eINSTANCE.getEOperatorToStatisticalDataMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActionToLongMapImpl <em>Action To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActionToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToLongMap()
		 * @generated
		 */
		EClass ACTION_TO_LONG_MAP = eINSTANCE.getActionToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TO_LONG_MAP__KEY = eINSTANCE.getActionToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TO_LONG_MAP__VALUE = eINSTANCE.getActionToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActorToLongMapImpl <em>Actor To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActorToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToLongMap()
		 * @generated
		 */
		EClass ACTOR_TO_LONG_MAP = eINSTANCE.getActorToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TO_LONG_MAP__KEY = eINSTANCE.getActorToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_TO_LONG_MAP__VALUE = eINSTANCE.getActorToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.BufferToLongMapImpl <em>Buffer To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.BufferToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToLongMap()
		 * @generated
		 */
		EClass BUFFER_TO_LONG_MAP = eINSTANCE.getBufferToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_TO_LONG_MAP__KEY = eINSTANCE.getBufferToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_TO_LONG_MAP__VALUE = eINSTANCE.getBufferToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.StringToLongMapImpl <em>String To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.StringToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToLongMap()
		 * @generated
		 */
		EClass STRING_TO_LONG_MAP = eINSTANCE.getStringToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_LONG_MAP__KEY = eINSTANCE.getStringToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_LONG_MAP__VALUE = eINSTANCE.getStringToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.DoubleToDoubleMapImpl <em>Double To Double Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.DoubleToDoubleMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getDoubleToDoubleMap()
		 * @generated
		 */
		EClass DOUBLE_TO_DOUBLE_MAP = eINSTANCE.getDoubleToDoubleMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TO_DOUBLE_MAP__KEY = eINSTANCE.getDoubleToDoubleMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TO_DOUBLE_MAP__VALUE = eINSTANCE.getDoubleToDoubleMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.VariableToLongMapImpl <em>Variable To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.VariableToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getVariableToLongMap()
		 * @generated
		 */
		EClass VARIABLE_TO_LONG_MAP = eINSTANCE.getVariableToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TO_LONG_MAP__KEY = eINSTANCE.getVariableToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_TO_LONG_MAP__VALUE = eINSTANCE.getVariableToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.GuardToLongMapImpl <em>Guard To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.GuardToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getGuardToLongMap()
		 * @generated
		 */
		EClass GUARD_TO_LONG_MAP = eINSTANCE.getGuardToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_TO_LONG_MAP__KEY = eINSTANCE.getGuardToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD_TO_LONG_MAP__VALUE = eINSTANCE.getGuardToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.PortToLongMapImpl <em>Port To Long Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.PortToLongMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getPortToLongMap()
		 * @generated
		 */
		EClass PORT_TO_LONG_MAP = eINSTANCE.getPortToLongMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TO_LONG_MAP__KEY = eINSTANCE.getPortToLongMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TO_LONG_MAP__VALUE = eINSTANCE.getPortToLongMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.StringToDoubleMapImpl <em>String To Double Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.StringToDoubleMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToDoubleMap()
		 * @generated
		 */
		EClass STRING_TO_DOUBLE_MAP = eINSTANCE.getStringToDoubleMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_DOUBLE_MAP__KEY = eINSTANCE.getStringToDoubleMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_DOUBLE_MAP__VALUE = eINSTANCE.getStringToDoubleMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActionToDoubleMapImpl <em>Action To Double Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActionToDoubleMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActionToDoubleMap()
		 * @generated
		 */
		EClass ACTION_TO_DOUBLE_MAP = eINSTANCE.getActionToDoubleMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TO_DOUBLE_MAP__KEY = eINSTANCE.getActionToDoubleMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TO_DOUBLE_MAP__VALUE = eINSTANCE.getActionToDoubleMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.BufferToIntegerMapImpl <em>Buffer To Integer Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.BufferToIntegerMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToIntegerMap()
		 * @generated
		 */
		EClass BUFFER_TO_INTEGER_MAP = eINSTANCE.getBufferToIntegerMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_TO_INTEGER_MAP__KEY = eINSTANCE.getBufferToIntegerMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_TO_INTEGER_MAP__VALUE = eINSTANCE.getBufferToIntegerMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.BufferToDoubleMapImpl <em>Buffer To Double Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.BufferToDoubleMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getBufferToDoubleMap()
		 * @generated
		 */
		EClass BUFFER_TO_DOUBLE_MAP = eINSTANCE.getBufferToDoubleMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_TO_DOUBLE_MAP__KEY = eINSTANCE.getBufferToDoubleMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_TO_DOUBLE_MAP__VALUE = eINSTANCE.getBufferToDoubleMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.PartitionToActorSelectionScheduleMapImpl <em>Partition To Actor Selection Schedule Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.PartitionToActorSelectionScheduleMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getPartitionToActorSelectionScheduleMap()
		 * @generated
		 */
		EClass PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP = eINSTANCE.getPartitionToActorSelectionScheduleMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP__KEY = eINSTANCE.getPartitionToActorSelectionScheduleMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTITION_TO_ACTOR_SELECTION_SCHEDULE_MAP__VALUE = eINSTANCE.getPartitionToActorSelectionScheduleMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.StringToStringMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getStringToStringMap()
		 * @generated
		 */
		EClass STRING_TO_STRING_MAP = eINSTANCE.getStringToStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP__KEY = eINSTANCE.getStringToStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP__VALUE = eINSTANCE.getStringToStringMap_Value();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.map.impl.ActorToStringMapImpl <em>Actor To String Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.map.impl.ActorToStringMapImpl
		 * @see turnus.model.analysis.map.impl.MapPackageImpl#getActorToStringMap()
		 * @generated
		 */
		EClass ACTOR_TO_STRING_MAP = eINSTANCE.getActorToStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TO_STRING_MAP__KEY = eINSTANCE.getActorToStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_TO_STRING_MAP__VALUE = eINSTANCE.getActorToStringMap_Value();

	}

} //MapPackage

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
package turnus.model.dataflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import turnus.model.common.CommonPackage;

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
 * @see turnus.model.dataflow.DataflowFactory
 * @model kind="package"
 * @generated
 */
public interface DataflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/dataflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.dataflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataflowPackage eINSTANCE = turnus.model.dataflow.impl.DataflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.NetworkImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 0;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SOURCE_FILE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__PROJECT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ACTORS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actor Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ACTOR_CLASSES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Buffers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__BUFFERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__INPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__OUTPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Shared Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SHARED_VARIABLES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__VERSION = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Actor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK___GET_ACTOR__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Actor Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK___GET_ACTOR_CLASS__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Input Port</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK___GET_INPUT_PORT__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Output Port</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK___GET_OUTPUT_PORT__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Shared Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK___GET_SHARED_VARIABLES__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.ActorClassImpl <em>Actor Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.ActorClassImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getActorClass()
	 * @generated
	 */
	int ACTOR_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__SOURCE_FILE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__NAME_SPACE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__ACTORS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__VERSION = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS__SOURCE_CODE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Actor Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Actor Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CLASS_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.ActorImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OUTPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__VARIABLES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ACTOR_CLASS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ACTIONS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Procedures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PROCEDURES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Buffers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__BUFFERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Incoming Buffers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INCOMING_BUFFERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Outgoing Buffers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OUTGOING_BUFFERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PREDECESSORS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SUCCESSORS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 13;

	/**
	 * The operation id for the '<em>Get Action</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_ACTION__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Input Port</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_INPUT_PORT__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Output Port</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_OUTPUT_PORT__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_VARIABLE__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Procedure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_PROCEDURE__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Shared Variable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR___GET_SHARED_VARIABLE__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.ActionImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__INPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUTPUT_PORTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__GUARDS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___GET_GUARD__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.ProcedureImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 4;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__VARIABLES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.VariableImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__SHARED = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.SharedVariableImpl <em>Shared Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.SharedVariableImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getSharedVariable()
	 * @generated
	 */
	int SHARED_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__ATTRIBUTES_TABLE = VARIABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__SHARED = VARIABLE__SHARED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__TYPE = VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__OWNER = VARIABLE__OWNER;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__TAG = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shared Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Shared Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.PortImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 7;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Writers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__WRITERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Readers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__READERS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INPUT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OUTPUTS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.BufferImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 8;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SOURCE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__TARGET = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__TYPE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.GuardImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 9;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__TAG = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__OWNER = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.dataflow.Type <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.Type
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 10;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ETYPE = 0;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__BITS = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeUintImpl <em>Type Uint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeUintImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeUint()
	 * @generated
	 */
	int TYPE_UINT = 11;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Uint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Uint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeIntImpl <em>Type Int</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeIntImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeInt()
	 * @generated
	 */
	int TYPE_INT = 12;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INT__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INT__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INT__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INT_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeStringImpl <em>Type String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeStringImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeString()
	 * @generated
	 */
	int TYPE_STRING = 13;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeListImpl <em>Type List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeListImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeList()
	 * @generated
	 */
	int TYPE_LIST = 14;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__ELEMENTS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>List Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__LIST_TYPE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeBooleanImpl <em>Type Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeBooleanImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeBoolean()
	 * @generated
	 */
	int TYPE_BOOLEAN = 15;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOLEAN__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOLEAN__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOLEAN__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOLEAN_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOLEAN_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeDoubleImpl <em>Type Double</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeDoubleImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeDouble()
	 * @generated
	 */
	int TYPE_DOUBLE = 16;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DOUBLE__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DOUBLE__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DOUBLE__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DOUBLE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DOUBLE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.dataflow.impl.TypeUndefinedImpl <em>Type Undefined</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.dataflow.impl.TypeUndefinedImpl
	 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeUndefined()
	 * @generated
	 */
	int TYPE_UNDEFINED = 17;

	/**
	 * The feature id for the '<em><b>Etype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UNDEFINED__ETYPE = TYPE__ETYPE;

	/**
	 * The feature id for the '<em><b>Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UNDEFINED__BITS = TYPE__BITS;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UNDEFINED__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Undefined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UNDEFINED_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Undefined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_UNDEFINED_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see turnus.model.dataflow.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Network#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Network#getName()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Name();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Network#getSourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File</em>'.
	 * @see turnus.model.dataflow.Network#getSourceFile()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_SourceFile();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Network#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see turnus.model.dataflow.Network#getProject()
	 * @see #getNetwork()
	 * @generated
	 */
	EAttribute getNetwork_Project();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Network#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actors</em>'.
	 * @see turnus.model.dataflow.Network#getActors()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Actors();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Network#getActorClasses <em>Actor Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Classes</em>'.
	 * @see turnus.model.dataflow.Network#getActorClasses()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_ActorClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Network#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers</em>'.
	 * @see turnus.model.dataflow.Network#getBuffers()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Buffers();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Network#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Ports</em>'.
	 * @see turnus.model.dataflow.Network#getInputPorts()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_InputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Network#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Ports</em>'.
	 * @see turnus.model.dataflow.Network#getOutputPorts()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_OutputPorts();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Network#getSharedVariables <em>Shared Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shared Variables</em>'.
	 * @see turnus.model.dataflow.Network#getSharedVariables()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_SharedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.dataflow.Network#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see turnus.model.dataflow.Network#getVersion()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Version();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Network#getActor(java.lang.String) <em>Get Actor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actor</em>' operation.
	 * @see turnus.model.dataflow.Network#getActor(java.lang.String)
	 * @generated
	 */
	EOperation getNetwork__GetActor__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Network#getActorClass(java.lang.String) <em>Get Actor Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actor Class</em>' operation.
	 * @see turnus.model.dataflow.Network#getActorClass(java.lang.String)
	 * @generated
	 */
	EOperation getNetwork__GetActorClass__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Network#getInputPort(java.lang.String) <em>Get Input Port</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Port</em>' operation.
	 * @see turnus.model.dataflow.Network#getInputPort(java.lang.String)
	 * @generated
	 */
	EOperation getNetwork__GetInputPort__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Network#getOutputPort(java.lang.String) <em>Get Output Port</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Output Port</em>' operation.
	 * @see turnus.model.dataflow.Network#getOutputPort(java.lang.String)
	 * @generated
	 */
	EOperation getNetwork__GetOutputPort__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Network#getSharedVariables(java.lang.String) <em>Get Shared Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Shared Variables</em>' operation.
	 * @see turnus.model.dataflow.Network#getSharedVariables(java.lang.String)
	 * @generated
	 */
	EOperation getNetwork__GetSharedVariables__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.ActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Class</em>'.
	 * @see turnus.model.dataflow.ActorClass
	 * @generated
	 */
	EClass getActorClass();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.ActorClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.ActorClass#getName()
	 * @see #getActorClass()
	 * @generated
	 */
	EAttribute getActorClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.ActorClass#getSourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File</em>'.
	 * @see turnus.model.dataflow.ActorClass#getSourceFile()
	 * @see #getActorClass()
	 * @generated
	 */
	EAttribute getActorClass_SourceFile();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.ActorClass#getNameSpace <em>Name Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Space</em>'.
	 * @see turnus.model.dataflow.ActorClass#getNameSpace()
	 * @see #getActorClass()
	 * @generated
	 */
	EAttribute getActorClass_NameSpace();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.ActorClass#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.dataflow.ActorClass#getActors()
	 * @see #getActorClass()
	 * @generated
	 */
	EReference getActorClass_Actors();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.dataflow.ActorClass#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see turnus.model.dataflow.ActorClass#getVersion()
	 * @see #getActorClass()
	 * @generated
	 */
	EReference getActorClass_Version();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.ActorClass#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.ActorClass#getOwner()
	 * @see #getActorClass()
	 * @generated
	 */
	EReference getActorClass_Owner();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.ActorClass#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see turnus.model.dataflow.ActorClass#getSourceCode()
	 * @see #getActorClass()
	 * @generated
	 */
	EAttribute getActorClass_SourceCode();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see turnus.model.dataflow.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Actor#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Ports</em>'.
	 * @see turnus.model.dataflow.Actor#getInputPorts()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_InputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Actor#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Ports</em>'.
	 * @see turnus.model.dataflow.Actor#getOutputPorts()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_OutputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Actor#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see turnus.model.dataflow.Actor#getVariables()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Variables();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Actor#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see turnus.model.dataflow.Actor#getActorClass()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ActorClass();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Actor#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see turnus.model.dataflow.Actor#getActions()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Actor#getProcedures <em>Procedures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedures</em>'.
	 * @see turnus.model.dataflow.Actor#getProcedures()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Procedures();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Actor#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Actor#getOwner()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Owner();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Actor#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Buffers</em>'.
	 * @see turnus.model.dataflow.Actor#getBuffers()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Buffers();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Actor#getIncomingBuffers <em>Incoming Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Buffers</em>'.
	 * @see turnus.model.dataflow.Actor#getIncomingBuffers()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_IncomingBuffers();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Actor#getOutgoingBuffers <em>Outgoing Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Buffers</em>'.
	 * @see turnus.model.dataflow.Actor#getOutgoingBuffers()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_OutgoingBuffers();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Actor#getPredecessors <em>Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Predecessors</em>'.
	 * @see turnus.model.dataflow.Actor#getPredecessors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Predecessors();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Actor#getSuccessors <em>Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Successors</em>'.
	 * @see turnus.model.dataflow.Actor#getSuccessors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Successors();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getAction(java.lang.String) <em>Get Action</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Action</em>' operation.
	 * @see turnus.model.dataflow.Actor#getAction(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetAction__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getInputPort(java.lang.String) <em>Get Input Port</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Input Port</em>' operation.
	 * @see turnus.model.dataflow.Actor#getInputPort(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetInputPort__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getOutputPort(java.lang.String) <em>Get Output Port</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Output Port</em>' operation.
	 * @see turnus.model.dataflow.Actor#getOutputPort(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetOutputPort__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getVariable(java.lang.String) <em>Get Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Variable</em>' operation.
	 * @see turnus.model.dataflow.Actor#getVariable(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetVariable__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getProcedure(java.lang.String) <em>Get Procedure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Procedure</em>' operation.
	 * @see turnus.model.dataflow.Actor#getProcedure(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetProcedure__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Actor#getSharedVariable(java.lang.String) <em>Get Shared Variable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Shared Variable</em>' operation.
	 * @see turnus.model.dataflow.Actor#getSharedVariable(java.lang.String)
	 * @generated
	 */
	EOperation getActor__GetSharedVariable__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see turnus.model.dataflow.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Action#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Ports</em>'.
	 * @see turnus.model.dataflow.Action#getInputPorts()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_InputPorts();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Action#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Ports</em>'.
	 * @see turnus.model.dataflow.Action#getOutputPorts()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_OutputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.dataflow.Action#getGuards <em>Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Guards</em>'.
	 * @see turnus.model.dataflow.Action#getGuards()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Guards();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Action#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Action#getOwner()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Owner();

	/**
	 * Returns the meta object for the '{@link turnus.model.dataflow.Action#getGuard(java.lang.String) <em>Get Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Guard</em>' operation.
	 * @see turnus.model.dataflow.Action#getGuard(java.lang.String)
	 * @generated
	 */
	EOperation getAction__GetGuard__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see turnus.model.dataflow.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Procedure#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Procedure#getName()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Name();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Procedure#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see turnus.model.dataflow.Procedure#getVariables()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Variables();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Procedure#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Procedure#getOwner()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Owner();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see turnus.model.dataflow.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Variable#isShared <em>Shared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared</em>'.
	 * @see turnus.model.dataflow.Variable#isShared()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Shared();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.dataflow.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see turnus.model.dataflow.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Type();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Variable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Variable#getOwner()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Owner();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.SharedVariable <em>Shared Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Variable</em>'.
	 * @see turnus.model.dataflow.SharedVariable
	 * @generated
	 */
	EClass getSharedVariable();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.SharedVariable#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see turnus.model.dataflow.SharedVariable#getTag()
	 * @see #getSharedVariable()
	 * @generated
	 */
	EAttribute getSharedVariable_Tag();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see turnus.model.dataflow.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.dataflow.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Port#getWriters <em>Writers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Writers</em>'.
	 * @see turnus.model.dataflow.Port#getWriters()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Writers();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Port#getReaders <em>Readers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Readers</em>'.
	 * @see turnus.model.dataflow.Port#getReaders()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Readers();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Port#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see turnus.model.dataflow.Port#getInput()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Input();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.dataflow.Port#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see turnus.model.dataflow.Port#getOutputs()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Outputs();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Owner();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see turnus.model.dataflow.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Buffer#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see turnus.model.dataflow.Buffer#getSource()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Source();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Buffer#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see turnus.model.dataflow.Buffer#getTarget()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Target();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.dataflow.Buffer#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see turnus.model.dataflow.Buffer#getType()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Type();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Buffer#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Buffer#getOwner()
	 * @see #getBuffer()
	 * @generated
	 */
	EReference getBuffer_Owner();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see turnus.model.dataflow.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Guard#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see turnus.model.dataflow.Guard#getTag()
	 * @see #getGuard()
	 * @generated
	 */
	EAttribute getGuard_Tag();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.dataflow.Guard#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see turnus.model.dataflow.Guard#getOwner()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Owner();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see turnus.model.dataflow.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Type#getEtype <em>Etype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Etype</em>'.
	 * @see turnus.model.dataflow.Type#getEtype()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Etype();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.Type#getBits <em>Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bits</em>'.
	 * @see turnus.model.dataflow.Type#getBits()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Bits();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeUint <em>Type Uint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Uint</em>'.
	 * @see turnus.model.dataflow.TypeUint
	 * @generated
	 */
	EClass getTypeUint();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeUint#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeUint#getSize()
	 * @see #getTypeUint()
	 * @generated
	 */
	EAttribute getTypeUint_Size();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeInt <em>Type Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Int</em>'.
	 * @see turnus.model.dataflow.TypeInt
	 * @generated
	 */
	EClass getTypeInt();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeInt#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeInt#getSize()
	 * @see #getTypeInt()
	 * @generated
	 */
	EAttribute getTypeInt_Size();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeString <em>Type String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type String</em>'.
	 * @see turnus.model.dataflow.TypeString
	 * @generated
	 */
	EClass getTypeString();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeString#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeString#getSize()
	 * @see #getTypeString()
	 * @generated
	 */
	EAttribute getTypeString_Size();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeList <em>Type List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type List</em>'.
	 * @see turnus.model.dataflow.TypeList
	 * @generated
	 */
	EClass getTypeList();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeList#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Elements</em>'.
	 * @see turnus.model.dataflow.TypeList#getElements()
	 * @see #getTypeList()
	 * @generated
	 */
	EAttribute getTypeList_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link turnus.model.dataflow.TypeList#getListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>List Type</em>'.
	 * @see turnus.model.dataflow.TypeList#getListType()
	 * @see #getTypeList()
	 * @generated
	 */
	EReference getTypeList_ListType();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeBoolean <em>Type Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Boolean</em>'.
	 * @see turnus.model.dataflow.TypeBoolean
	 * @generated
	 */
	EClass getTypeBoolean();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeBoolean#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeBoolean#getSize()
	 * @see #getTypeBoolean()
	 * @generated
	 */
	EAttribute getTypeBoolean_Size();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeDouble <em>Type Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Double</em>'.
	 * @see turnus.model.dataflow.TypeDouble
	 * @generated
	 */
	EClass getTypeDouble();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeDouble#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeDouble#getSize()
	 * @see #getTypeDouble()
	 * @generated
	 */
	EAttribute getTypeDouble_Size();

	/**
	 * Returns the meta object for class '{@link turnus.model.dataflow.TypeUndefined <em>Type Undefined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Undefined</em>'.
	 * @see turnus.model.dataflow.TypeUndefined
	 * @generated
	 */
	EClass getTypeUndefined();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.dataflow.TypeUndefined#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see turnus.model.dataflow.TypeUndefined#getSize()
	 * @see #getTypeUndefined()
	 * @generated
	 */
	EAttribute getTypeUndefined_Size();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataflowFactory getDataflowFactory();

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
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.NetworkImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__NAME = eINSTANCE.getNetwork_Name();

		/**
		 * The meta object literal for the '<em><b>Source File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__SOURCE_FILE = eINSTANCE.getNetwork_SourceFile();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NETWORK__PROJECT = eINSTANCE.getNetwork_Project();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__ACTORS = eINSTANCE.getNetwork_Actors();

		/**
		 * The meta object literal for the '<em><b>Actor Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__ACTOR_CLASSES = eINSTANCE.getNetwork_ActorClasses();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__BUFFERS = eINSTANCE.getNetwork_Buffers();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__INPUT_PORTS = eINSTANCE.getNetwork_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__OUTPUT_PORTS = eINSTANCE.getNetwork_OutputPorts();

		/**
		 * The meta object literal for the '<em><b>Shared Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__SHARED_VARIABLES = eINSTANCE.getNetwork_SharedVariables();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__VERSION = eINSTANCE.getNetwork_Version();

		/**
		 * The meta object literal for the '<em><b>Get Actor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NETWORK___GET_ACTOR__STRING = eINSTANCE.getNetwork__GetActor__String();

		/**
		 * The meta object literal for the '<em><b>Get Actor Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NETWORK___GET_ACTOR_CLASS__STRING = eINSTANCE.getNetwork__GetActorClass__String();

		/**
		 * The meta object literal for the '<em><b>Get Input Port</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NETWORK___GET_INPUT_PORT__STRING = eINSTANCE.getNetwork__GetInputPort__String();

		/**
		 * The meta object literal for the '<em><b>Get Output Port</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NETWORK___GET_OUTPUT_PORT__STRING = eINSTANCE.getNetwork__GetOutputPort__String();

		/**
		 * The meta object literal for the '<em><b>Get Shared Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NETWORK___GET_SHARED_VARIABLES__STRING = eINSTANCE.getNetwork__GetSharedVariables__String();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.ActorClassImpl <em>Actor Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.ActorClassImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getActorClass()
		 * @generated
		 */
		EClass ACTOR_CLASS = eINSTANCE.getActorClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_CLASS__NAME = eINSTANCE.getActorClass_Name();

		/**
		 * The meta object literal for the '<em><b>Source File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_CLASS__SOURCE_FILE = eINSTANCE.getActorClass_SourceFile();

		/**
		 * The meta object literal for the '<em><b>Name Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_CLASS__NAME_SPACE = eINSTANCE.getActorClass_NameSpace();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CLASS__ACTORS = eINSTANCE.getActorClass_Actors();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CLASS__VERSION = eINSTANCE.getActorClass_Version();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CLASS__OWNER = eINSTANCE.getActorClass_Owner();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_CLASS__SOURCE_CODE = eINSTANCE.getActorClass_SourceCode();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.ActorImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NAME = eINSTANCE.getActor_Name();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INPUT_PORTS = eINSTANCE.getActor_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OUTPUT_PORTS = eINSTANCE.getActor_OutputPorts();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__VARIABLES = eINSTANCE.getActor_Variables();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ACTOR_CLASS = eINSTANCE.getActor_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ACTIONS = eINSTANCE.getActor_Actions();

		/**
		 * The meta object literal for the '<em><b>Procedures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PROCEDURES = eINSTANCE.getActor_Procedures();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OWNER = eINSTANCE.getActor_Owner();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__BUFFERS = eINSTANCE.getActor_Buffers();

		/**
		 * The meta object literal for the '<em><b>Incoming Buffers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INCOMING_BUFFERS = eINSTANCE.getActor_IncomingBuffers();

		/**
		 * The meta object literal for the '<em><b>Outgoing Buffers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OUTGOING_BUFFERS = eINSTANCE.getActor_OutgoingBuffers();

		/**
		 * The meta object literal for the '<em><b>Predecessors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PREDECESSORS = eINSTANCE.getActor_Predecessors();

		/**
		 * The meta object literal for the '<em><b>Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__SUCCESSORS = eINSTANCE.getActor_Successors();

		/**
		 * The meta object literal for the '<em><b>Get Action</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_ACTION__STRING = eINSTANCE.getActor__GetAction__String();

		/**
		 * The meta object literal for the '<em><b>Get Input Port</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_INPUT_PORT__STRING = eINSTANCE.getActor__GetInputPort__String();

		/**
		 * The meta object literal for the '<em><b>Get Output Port</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_OUTPUT_PORT__STRING = eINSTANCE.getActor__GetOutputPort__String();

		/**
		 * The meta object literal for the '<em><b>Get Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_VARIABLE__STRING = eINSTANCE.getActor__GetVariable__String();

		/**
		 * The meta object literal for the '<em><b>Get Procedure</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_PROCEDURE__STRING = eINSTANCE.getActor__GetProcedure__String();

		/**
		 * The meta object literal for the '<em><b>Get Shared Variable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTOR___GET_SHARED_VARIABLE__STRING = eINSTANCE.getActor__GetSharedVariable__String();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.ActionImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__INPUT_PORTS = eINSTANCE.getAction_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OUTPUT_PORTS = eINSTANCE.getAction_OutputPorts();

		/**
		 * The meta object literal for the '<em><b>Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__GUARDS = eINSTANCE.getAction_Guards();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OWNER = eINSTANCE.getAction_Owner();

		/**
		 * The meta object literal for the '<em><b>Get Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___GET_GUARD__STRING = eINSTANCE.getAction__GetGuard__String();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.ProcedureImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__NAME = eINSTANCE.getProcedure_Name();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__VARIABLES = eINSTANCE.getProcedure_Variables();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__OWNER = eINSTANCE.getProcedure_Owner();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.VariableImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Shared</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__SHARED = eINSTANCE.getVariable_Shared();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__OWNER = eINSTANCE.getVariable_Owner();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.SharedVariableImpl <em>Shared Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.SharedVariableImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getSharedVariable()
		 * @generated
		 */
		EClass SHARED_VARIABLE = eINSTANCE.getSharedVariable();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHARED_VARIABLE__TAG = eINSTANCE.getSharedVariable_Tag();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.PortImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Writers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__WRITERS = eINSTANCE.getPort_Writers();

		/**
		 * The meta object literal for the '<em><b>Readers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__READERS = eINSTANCE.getPort_Readers();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__INPUT = eINSTANCE.getPort_Input();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OUTPUTS = eINSTANCE.getPort_Outputs();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.BufferImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__SOURCE = eINSTANCE.getBuffer_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__TARGET = eINSTANCE.getBuffer_Target();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__TYPE = eINSTANCE.getBuffer_Type();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER__OWNER = eINSTANCE.getBuffer_Owner();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.GuardImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD__TAG = eINSTANCE.getGuard_Tag();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__OWNER = eINSTANCE.getGuard_Owner();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.Type <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.Type
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Etype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__ETYPE = eINSTANCE.getType_Etype();

		/**
		 * The meta object literal for the '<em><b>Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__BITS = eINSTANCE.getType_Bits();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeUintImpl <em>Type Uint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeUintImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeUint()
		 * @generated
		 */
		EClass TYPE_UINT = eINSTANCE.getTypeUint();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_UINT__SIZE = eINSTANCE.getTypeUint_Size();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeIntImpl <em>Type Int</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeIntImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeInt()
		 * @generated
		 */
		EClass TYPE_INT = eINSTANCE.getTypeInt();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_INT__SIZE = eINSTANCE.getTypeInt_Size();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeStringImpl <em>Type String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeStringImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeString()
		 * @generated
		 */
		EClass TYPE_STRING = eINSTANCE.getTypeString();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_STRING__SIZE = eINSTANCE.getTypeString_Size();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeListImpl <em>Type List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeListImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeList()
		 * @generated
		 */
		EClass TYPE_LIST = eINSTANCE.getTypeList();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_LIST__ELEMENTS = eINSTANCE.getTypeList_Elements();

		/**
		 * The meta object literal for the '<em><b>List Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LIST__LIST_TYPE = eINSTANCE.getTypeList_ListType();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeBooleanImpl <em>Type Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeBooleanImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeBoolean()
		 * @generated
		 */
		EClass TYPE_BOOLEAN = eINSTANCE.getTypeBoolean();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_BOOLEAN__SIZE = eINSTANCE.getTypeBoolean_Size();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeDoubleImpl <em>Type Double</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeDoubleImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeDouble()
		 * @generated
		 */
		EClass TYPE_DOUBLE = eINSTANCE.getTypeDouble();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DOUBLE__SIZE = eINSTANCE.getTypeDouble_Size();

		/**
		 * The meta object literal for the '{@link turnus.model.dataflow.impl.TypeUndefinedImpl <em>Type Undefined</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.dataflow.impl.TypeUndefinedImpl
		 * @see turnus.model.dataflow.impl.DataflowPackageImpl#getTypeUndefined()
		 * @generated
		 */
		EClass TYPE_UNDEFINED = eINSTANCE.getTypeUndefined();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_UNDEFINED__SIZE = eINSTANCE.getTypeUndefined_Size();

	}

} //DataflowPackage

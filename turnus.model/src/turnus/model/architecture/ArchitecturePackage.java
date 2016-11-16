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
package turnus.model.architecture;

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
 * @see turnus.model.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/architecture";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = turnus.model.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.ArchitectureImpl <em>Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.ArchitectureImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getArchitecture()
	 * @generated
	 */
	int ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Media</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__MEDIA = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__PROCESSING_UNITS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE__LINKS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Processing Unit</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE___GET_PROCESSING_UNIT__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Medium</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE___GET_MEDIUM__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Processing Units</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE___GET_PROCESSING_UNITS__STRING = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.ProcessingUnitImpl <em>Processing Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.ProcessingUnitImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getProcessingUnit()
	 * @generated
	 */
	int PROCESSING_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__LINKS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__TYPES = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__OPERATORS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__FAMILY = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Clock Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__CLOCK_PERIOD = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT__CLASS_NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Processing Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Processing Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_UNIT_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.MediumImpl <em>Medium</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.MediumImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getMedium()
	 * @generated
	 */
	int MEDIUM = 2;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__NAME = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__LINKS = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Clock Period In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__CLOCK_PERIOD_IN = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Clock Period Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__CLOCK_PERIOD_OUT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Bit Pop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__MAX_BIT_POP = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Bit Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__MAX_BIT_PUSH = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM__MAX_BIT_SIZE = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Medium</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Medium</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEDIUM_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.LinkImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getLink()
	 * @generated
	 */
	int LINK = 3;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ATTRIBUTES_TABLE = CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Processing Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__PROCESSING_UNIT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Medium</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__MEDIUM = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = CommonPackage.ATTRIBUTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = CommonPackage.ATTRIBUTABLE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.CPUImpl <em>CPU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.CPUImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getCPU()
	 * @generated
	 */
	int CPU = 4;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__ATTRIBUTES_TABLE = PROCESSING_UNIT__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__NAME = PROCESSING_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__LINKS = PROCESSING_UNIT__LINKS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__TYPES = PROCESSING_UNIT__TYPES;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__OPERATORS = PROCESSING_UNIT__OPERATORS;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__FAMILY = PROCESSING_UNIT__FAMILY;

	/**
	 * The feature id for the '<em><b>Clock Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__CLOCK_PERIOD = PROCESSING_UNIT__CLOCK_PERIOD;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__CLASS_NAME = PROCESSING_UNIT__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__CORES = PROCESSING_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Schedulers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__SCHEDULERS = PROCESSING_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CPU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_FEATURE_COUNT = PROCESSING_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CPU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_OPERATION_COUNT = PROCESSING_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.FPGAImpl <em>FPGA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.FPGAImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getFPGA()
	 * @generated
	 */
	int FPGA = 5;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__ATTRIBUTES_TABLE = PROCESSING_UNIT__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__NAME = PROCESSING_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__LINKS = PROCESSING_UNIT__LINKS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__TYPES = PROCESSING_UNIT__TYPES;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__OPERATORS = PROCESSING_UNIT__OPERATORS;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__FAMILY = PROCESSING_UNIT__FAMILY;

	/**
	 * The feature id for the '<em><b>Clock Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__CLOCK_PERIOD = PROCESSING_UNIT__CLOCK_PERIOD;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__CLASS_NAME = PROCESSING_UNIT__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Clock Regions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA__CLOCK_REGIONS = PROCESSING_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FPGA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA_FEATURE_COUNT = PROCESSING_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>FPGA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FPGA_OPERATION_COUNT = PROCESSING_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.architecture.impl.DSPImpl <em>DSP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.architecture.impl.DSPImpl
	 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getDSP()
	 * @generated
	 */
	int DSP = 6;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__ATTRIBUTES_TABLE = PROCESSING_UNIT__ATTRIBUTES_TABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__NAME = PROCESSING_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__LINKS = PROCESSING_UNIT__LINKS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__TYPES = PROCESSING_UNIT__TYPES;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__OPERATORS = PROCESSING_UNIT__OPERATORS;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__FAMILY = PROCESSING_UNIT__FAMILY;

	/**
	 * The feature id for the '<em><b>Clock Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__CLOCK_PERIOD = PROCESSING_UNIT__CLOCK_PERIOD;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__CLASS_NAME = PROCESSING_UNIT__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__CORES = PROCESSING_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Schedulers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP__SCHEDULERS = PROCESSING_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP_FEATURE_COUNT = PROCESSING_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>DSP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSP_OPERATION_COUNT = PROCESSING_UNIT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architecture</em>'.
	 * @see turnus.model.architecture.Architecture
	 * @generated
	 */
	EClass getArchitecture();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Architecture#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.architecture.Architecture#getName()
	 * @see #getArchitecture()
	 * @generated
	 */
	EAttribute getArchitecture_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.architecture.Architecture#getMedia <em>Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Media</em>'.
	 * @see turnus.model.architecture.Architecture#getMedia()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_Media();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.architecture.Architecture#getProcessingUnits <em>Processing Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processing Units</em>'.
	 * @see turnus.model.architecture.Architecture#getProcessingUnits()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_ProcessingUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.architecture.Architecture#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see turnus.model.architecture.Architecture#getLinks()
	 * @see #getArchitecture()
	 * @generated
	 */
	EReference getArchitecture_Links();

	/**
	 * Returns the meta object for the '{@link turnus.model.architecture.Architecture#getProcessingUnit(java.lang.String) <em>Get Processing Unit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Processing Unit</em>' operation.
	 * @see turnus.model.architecture.Architecture#getProcessingUnit(java.lang.String)
	 * @generated
	 */
	EOperation getArchitecture__GetProcessingUnit__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.architecture.Architecture#getMedium(java.lang.String) <em>Get Medium</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Medium</em>' operation.
	 * @see turnus.model.architecture.Architecture#getMedium(java.lang.String)
	 * @generated
	 */
	EOperation getArchitecture__GetMedium__String();

	/**
	 * Returns the meta object for the '{@link turnus.model.architecture.Architecture#getProcessingUnits(java.lang.String) <em>Get Processing Units</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Processing Units</em>' operation.
	 * @see turnus.model.architecture.Architecture#getProcessingUnits(java.lang.String)
	 * @generated
	 */
	EOperation getArchitecture__GetProcessingUnits__String();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.ProcessingUnit <em>Processing Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Unit</em>'.
	 * @see turnus.model.architecture.ProcessingUnit
	 * @generated
	 */
	EClass getProcessingUnit();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.ProcessingUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getName()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_Name();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.architecture.ProcessingUnit#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getLinks()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EReference getProcessingUnit_Links();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.architecture.ProcessingUnit#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Types</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getTypes()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_Types();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.architecture.ProcessingUnit#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getOperators()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_Operators();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.ProcessingUnit#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getFamily()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_Family();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.ProcessingUnit#getClockPeriod <em>Clock Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Period</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getClockPeriod()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_ClockPeriod();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.ProcessingUnit#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see turnus.model.architecture.ProcessingUnit#getClassName()
	 * @see #getProcessingUnit()
	 * @generated
	 */
	EAttribute getProcessingUnit_ClassName();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.Medium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Medium</em>'.
	 * @see turnus.model.architecture.Medium
	 * @generated
	 */
	EClass getMedium();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see turnus.model.architecture.Medium#getName()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_Name();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.architecture.Medium#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see turnus.model.architecture.Medium#getLinks()
	 * @see #getMedium()
	 * @generated
	 */
	EReference getMedium_Links();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getClockPeriodIn <em>Clock Period In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Period In</em>'.
	 * @see turnus.model.architecture.Medium#getClockPeriodIn()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_ClockPeriodIn();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getClockPeriodOut <em>Clock Period Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Period Out</em>'.
	 * @see turnus.model.architecture.Medium#getClockPeriodOut()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_ClockPeriodOut();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getMaxBitPop <em>Max Bit Pop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Bit Pop</em>'.
	 * @see turnus.model.architecture.Medium#getMaxBitPop()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_MaxBitPop();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getMaxBitPush <em>Max Bit Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Bit Push</em>'.
	 * @see turnus.model.architecture.Medium#getMaxBitPush()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_MaxBitPush();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.Medium#getMaxBitSize <em>Max Bit Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Bit Size</em>'.
	 * @see turnus.model.architecture.Medium#getMaxBitSize()
	 * @see #getMedium()
	 * @generated
	 */
	EAttribute getMedium_MaxBitSize();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see turnus.model.architecture.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.architecture.Link#getProcessingUnit <em>Processing Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processing Unit</em>'.
	 * @see turnus.model.architecture.Link#getProcessingUnit()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_ProcessingUnit();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.architecture.Link#getMedium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Medium</em>'.
	 * @see turnus.model.architecture.Link#getMedium()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Medium();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.CPU <em>CPU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPU</em>'.
	 * @see turnus.model.architecture.CPU
	 * @generated
	 */
	EClass getCPU();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.CPU#getCores <em>Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cores</em>'.
	 * @see turnus.model.architecture.CPU#getCores()
	 * @see #getCPU()
	 * @generated
	 */
	EAttribute getCPU_Cores();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.architecture.CPU#getSchedulers <em>Schedulers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Schedulers</em>'.
	 * @see turnus.model.architecture.CPU#getSchedulers()
	 * @see #getCPU()
	 * @generated
	 */
	EAttribute getCPU_Schedulers();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.FPGA <em>FPGA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FPGA</em>'.
	 * @see turnus.model.architecture.FPGA
	 * @generated
	 */
	EClass getFPGA();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.FPGA#getClockRegions <em>Clock Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clock Regions</em>'.
	 * @see turnus.model.architecture.FPGA#getClockRegions()
	 * @see #getFPGA()
	 * @generated
	 */
	EAttribute getFPGA_ClockRegions();

	/**
	 * Returns the meta object for class '{@link turnus.model.architecture.DSP <em>DSP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSP</em>'.
	 * @see turnus.model.architecture.DSP
	 * @generated
	 */
	EClass getDSP();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.architecture.DSP#getCores <em>Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cores</em>'.
	 * @see turnus.model.architecture.DSP#getCores()
	 * @see #getDSP()
	 * @generated
	 */
	EAttribute getDSP_Cores();

	/**
	 * Returns the meta object for the attribute list '{@link turnus.model.architecture.DSP#getSchedulers <em>Schedulers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Schedulers</em>'.
	 * @see turnus.model.architecture.DSP#getSchedulers()
	 * @see #getDSP()
	 * @generated
	 */
	EAttribute getDSP_Schedulers();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

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
		 * The meta object literal for the '{@link turnus.model.architecture.impl.ArchitectureImpl <em>Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.ArchitectureImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getArchitecture()
		 * @generated
		 */
		EClass ARCHITECTURE = eINSTANCE.getArchitecture();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE__NAME = eINSTANCE.getArchitecture_Name();

		/**
		 * The meta object literal for the '<em><b>Media</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__MEDIA = eINSTANCE.getArchitecture_Media();

		/**
		 * The meta object literal for the '<em><b>Processing Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__PROCESSING_UNITS = eINSTANCE.getArchitecture_ProcessingUnits();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE__LINKS = eINSTANCE.getArchitecture_Links();

		/**
		 * The meta object literal for the '<em><b>Get Processing Unit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARCHITECTURE___GET_PROCESSING_UNIT__STRING = eINSTANCE.getArchitecture__GetProcessingUnit__String();

		/**
		 * The meta object literal for the '<em><b>Get Medium</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARCHITECTURE___GET_MEDIUM__STRING = eINSTANCE.getArchitecture__GetMedium__String();

		/**
		 * The meta object literal for the '<em><b>Get Processing Units</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARCHITECTURE___GET_PROCESSING_UNITS__STRING = eINSTANCE.getArchitecture__GetProcessingUnits__String();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.ProcessingUnitImpl <em>Processing Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.ProcessingUnitImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getProcessingUnit()
		 * @generated
		 */
		EClass PROCESSING_UNIT = eINSTANCE.getProcessingUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__NAME = eINSTANCE.getProcessingUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_UNIT__LINKS = eINSTANCE.getProcessingUnit_Links();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__TYPES = eINSTANCE.getProcessingUnit_Types();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__OPERATORS = eINSTANCE.getProcessingUnit_Operators();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__FAMILY = eINSTANCE.getProcessingUnit_Family();

		/**
		 * The meta object literal for the '<em><b>Clock Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__CLOCK_PERIOD = eINSTANCE.getProcessingUnit_ClockPeriod();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_UNIT__CLASS_NAME = eINSTANCE.getProcessingUnit_ClassName();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.MediumImpl <em>Medium</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.MediumImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getMedium()
		 * @generated
		 */
		EClass MEDIUM = eINSTANCE.getMedium();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__NAME = eINSTANCE.getMedium_Name();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEDIUM__LINKS = eINSTANCE.getMedium_Links();

		/**
		 * The meta object literal for the '<em><b>Clock Period In</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__CLOCK_PERIOD_IN = eINSTANCE.getMedium_ClockPeriodIn();

		/**
		 * The meta object literal for the '<em><b>Clock Period Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__CLOCK_PERIOD_OUT = eINSTANCE.getMedium_ClockPeriodOut();

		/**
		 * The meta object literal for the '<em><b>Max Bit Pop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__MAX_BIT_POP = eINSTANCE.getMedium_MaxBitPop();

		/**
		 * The meta object literal for the '<em><b>Max Bit Push</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__MAX_BIT_PUSH = eINSTANCE.getMedium_MaxBitPush();

		/**
		 * The meta object literal for the '<em><b>Max Bit Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEDIUM__MAX_BIT_SIZE = eINSTANCE.getMedium_MaxBitSize();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.LinkImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Processing Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__PROCESSING_UNIT = eINSTANCE.getLink_ProcessingUnit();

		/**
		 * The meta object literal for the '<em><b>Medium</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__MEDIUM = eINSTANCE.getLink_Medium();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.CPUImpl <em>CPU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.CPUImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getCPU()
		 * @generated
		 */
		EClass CPU = eINSTANCE.getCPU();

		/**
		 * The meta object literal for the '<em><b>Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__CORES = eINSTANCE.getCPU_Cores();

		/**
		 * The meta object literal for the '<em><b>Schedulers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__SCHEDULERS = eINSTANCE.getCPU_Schedulers();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.FPGAImpl <em>FPGA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.FPGAImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getFPGA()
		 * @generated
		 */
		EClass FPGA = eINSTANCE.getFPGA();

		/**
		 * The meta object literal for the '<em><b>Clock Regions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FPGA__CLOCK_REGIONS = eINSTANCE.getFPGA_ClockRegions();

		/**
		 * The meta object literal for the '{@link turnus.model.architecture.impl.DSPImpl <em>DSP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.architecture.impl.DSPImpl
		 * @see turnus.model.architecture.impl.ArchitecturePackageImpl#getDSP()
		 * @generated
		 */
		EClass DSP = eINSTANCE.getDSP();

		/**
		 * The meta object literal for the '<em><b>Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSP__CORES = eINSTANCE.getDSP_Cores();

		/**
		 * The meta object literal for the '<em><b>Schedulers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSP__SCHEDULERS = eINSTANCE.getDSP_Schedulers();

	}

} //ArchitecturePackage

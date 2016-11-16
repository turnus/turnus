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
package turnus.model.common.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import turnus.common.Attributable;

import turnus.model.common.CommonFactory;
import turnus.model.common.CommonPackage;
import turnus.model.common.EOperator;
import turnus.model.common.EScheduler;
import turnus.model.common.EType;
import turnus.model.common.StatisticalData;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToObjectMapEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass statisticalDataEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum eOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum eSchedulerEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum eTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see turnus.model.common.CommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommonPackageImpl() {
		super(eNS_URI, CommonFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link CommonPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommonPackage init() {
		if (isInited)
			return (CommonPackage) EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);

		// Obtain or create and register package
		CommonPackageImpl theCommonPackage = (CommonPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new CommonPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCommonPackage.createPackageContents();

		// Initialize created meta-data
		theCommonPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonPackage.eNS_URI, theCommonPackage);
		return theCommonPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getAttributable() {
		return attributableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getAttributable_AttributesTable() {
		return (EReference) attributableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToObjectMap() {
		return stringToObjectMapEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToObjectMap_Key() {
		return (EAttribute) stringToObjectMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToObjectMap_Value() {
		return (EAttribute) stringToObjectMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStatisticalData() {
		return statisticalDataEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Min() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Max() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Mean() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Variance() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Sum() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_Samples() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_SumOfLogs() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_SumOfSquares() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_GeometricMean() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_SecondMoment() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStatisticalData_StandardDeviation() {
		return (EAttribute) statisticalDataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getEOperator() {
		return eOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getEScheduler() {
		return eSchedulerEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getEType() {
		return eTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CommonFactory getCommonFactory() {
		return (CommonFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		attributableEClass = createEClass(ATTRIBUTABLE);
		createEReference(attributableEClass, ATTRIBUTABLE__ATTRIBUTES_TABLE);

		stringToObjectMapEClass = createEClass(STRING_TO_OBJECT_MAP);
		createEAttribute(stringToObjectMapEClass, STRING_TO_OBJECT_MAP__KEY);
		createEAttribute(stringToObjectMapEClass, STRING_TO_OBJECT_MAP__VALUE);

		statisticalDataEClass = createEClass(STATISTICAL_DATA);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__MIN);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__MAX);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__MEAN);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__VARIANCE);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__SUM);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__SAMPLES);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__SUM_OF_LOGS);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__SUM_OF_SQUARES);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__GEOMETRIC_MEAN);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__SECOND_MOMENT);
		createEAttribute(statisticalDataEClass, STATISTICAL_DATA__STANDARD_DEVIATION);

		// Create enums
		eOperatorEEnum = createEEnum(EOPERATOR);
		eSchedulerEEnum = createEEnum(ESCHEDULER);
		eTypeEEnum = createEEnum(ETYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(attributableEClass, Attributable.class, "Attributable", !IS_ABSTRACT, !IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributable_AttributesTable(), this.getStringToObjectMap(), null, "attributesTable", null, 0,
				-1, Attributable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToObjectMapEClass, Map.Entry.class, "StringToObjectMap", !IS_ABSTRACT, !IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToObjectMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToObjectMap_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(statisticalDataEClass, StatisticalData.class, "StatisticalData", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatisticalData_Min(), ecorePackage.getEDouble(), "min", null, 0, 1, StatisticalData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_Max(), ecorePackage.getEDouble(), "max", null, 0, 1, StatisticalData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_Mean(), ecorePackage.getEDouble(), "mean", null, 0, 1, StatisticalData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_Variance(), ecorePackage.getEDouble(), "variance", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_Sum(), ecorePackage.getEDouble(), "sum", null, 0, 1, StatisticalData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_Samples(), ecorePackage.getELong(), "samples", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_SumOfLogs(), ecorePackage.getEDouble(), "sumOfLogs", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_SumOfSquares(), ecorePackage.getEDouble(), "sumOfSquares", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_GeometricMean(), ecorePackage.getEDouble(), "geometricMean", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_SecondMoment(), ecorePackage.getEDouble(), "secondMoment", null, 0, 1,
				StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticalData_StandardDeviation(), ecorePackage.getEDouble(), "standardDeviation", null, 0,
				1, StatisticalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eOperatorEEnum, EOperator.class, "EOperator");
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_BIT_AND);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_BIT_OR);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_BIT_XOR);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_DIV);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_DIV_INT);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_EQ);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_EXP);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_GT);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_GE);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_LT);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_LE);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_LOGIC_OR);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_LOGIC_AND);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_MINUS);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_PLUS);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_MOD);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_TIMES);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_NE);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_SHIFT_LEFT);
		addEEnumLiteral(eOperatorEEnum, EOperator.BINARY_SHIFT_RIGHT);
		addEEnumLiteral(eOperatorEEnum, EOperator.UNARY_BIT_NOT);
		addEEnumLiteral(eOperatorEEnum, EOperator.UNARY_LOGIC_NOT);
		addEEnumLiteral(eOperatorEEnum, EOperator.UNARY_MINUS);
		addEEnumLiteral(eOperatorEEnum, EOperator.UNARY_NUM_ELTS);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_STORE);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_ASSIGN);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_CALL);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_LOAD);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_LIST_LOAD);
		addEEnumLiteral(eOperatorEEnum, EOperator.DATAHANDLING_LIST_STORE);
		addEEnumLiteral(eOperatorEEnum, EOperator.FLOWCONTROL_IF);
		addEEnumLiteral(eOperatorEEnum, EOperator.FLOWCONTROL_WHILE);

		initEEnum(eSchedulerEEnum, EScheduler.class, "EScheduler");
		addEEnumLiteral(eSchedulerEEnum, EScheduler.FULL_PARALLEL);
		addEEnumLiteral(eSchedulerEEnum, EScheduler.ROUND_ROBIN);
		addEEnumLiteral(eSchedulerEEnum, EScheduler.NON_PREEMPTIVE);
		addEEnumLiteral(eSchedulerEEnum, EScheduler.STATIC);

		initEEnum(eTypeEEnum, EType.class, "EType");
		addEEnumLiteral(eTypeEEnum, EType.INT);
		addEEnumLiteral(eTypeEEnum, EType.UINT);
		addEEnumLiteral(eTypeEEnum, EType.DOUBLE);
		addEEnumLiteral(eTypeEEnum, EType.BOOLEAN);
		addEEnumLiteral(eTypeEEnum, EType.STRING);
		addEEnumLiteral(eTypeEEnum, EType.LIST);
		addEEnumLiteral(eTypeEEnum, EType.UNDEFINED);

		// Create resource
		createResource(eNS_URI);
	}

} // CommonPackageImpl

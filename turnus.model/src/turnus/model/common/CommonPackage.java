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
package turnus.model.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see turnus.model.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/common";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.common";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	CommonPackage eINSTANCE = turnus.model.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link turnus.model.common.impl.AttributableImpl <em>Attributable</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see turnus.model.common.impl.AttributableImpl
	 * @see turnus.model.common.impl.CommonPackageImpl#getAttributable()
	 * @generated
	 */
	int ATTRIBUTABLE = 0;

	/**
	 * The feature id for the '<em><b>Attributes Table</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTABLE__ATTRIBUTES_TABLE = 0;

	/**
	 * The number of structural features of the '<em>Attributable</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Attributable</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link turnus.model.common.impl.StringToObjectMapImpl
	 * <em>String To Object Map</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see turnus.model.common.impl.StringToObjectMapImpl
	 * @see turnus.model.common.impl.CommonPackageImpl#getStringToObjectMap()
	 * @generated
	 */
	int STRING_TO_OBJECT_MAP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Object Map</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Object Map</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link turnus.model.common.impl.StatisticalDataImpl
	 * <em>Statistical Data</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see turnus.model.common.impl.StatisticalDataImpl
	 * @see turnus.model.common.impl.CommonPackageImpl#getStatisticalData()
	 * @generated
	 */
	int STATISTICAL_DATA = 2;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__MIN = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__MAX = 1;

	/**
	 * The feature id for the '<em><b>Mean</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__MEAN = 2;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__VARIANCE = 3;

	/**
	 * The feature id for the '<em><b>Sum</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__SUM = 4;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__SAMPLES = 5;

	/**
	 * The feature id for the '<em><b>Sum Of Logs</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__SUM_OF_LOGS = 6;

	/**
	 * The feature id for the '<em><b>Sum Of Squares</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__SUM_OF_SQUARES = 7;

	/**
	 * The feature id for the '<em><b>Geometric Mean</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__GEOMETRIC_MEAN = 8;

	/**
	 * The feature id for the '<em><b>Second Moment</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__SECOND_MOMENT = 9;

	/**
	 * The feature id for the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA__STANDARD_DEVIATION = 10;

	/**
	 * The number of structural features of the '<em>Statistical Data</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Statistical Data</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATISTICAL_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.common.EOperator
	 * <em>EOperator</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see turnus.model.common.EOperator
	 * @see turnus.model.common.impl.CommonPackageImpl#getEOperator()
	 * @generated
	 */
	int EOPERATOR = 3;

	/**
	 * The meta object id for the '{@link turnus.model.common.EScheduler
	 * <em>EScheduler</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see turnus.model.common.EScheduler
	 * @see turnus.model.common.impl.CommonPackageImpl#getEScheduler()
	 * @generated
	 */
	int ESCHEDULER = 4;

	/**
	 * The meta object id for the '{@link turnus.model.common.EType
	 * <em>EType</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see turnus.model.common.EType
	 * @see turnus.model.common.impl.CommonPackageImpl#getEType()
	 * @generated
	 */
	int ETYPE = 5;

	/**
	 * Returns the meta object for class '{@link turnus.common.Attributable
	 * <em>Attributable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attributable</em>'.
	 * @see turnus.common.Attributable
	 * @model instanceClass="turnus.common.Attributable"
	 * @generated
	 */
	EClass getAttributable();

	/**
	 * Returns the meta object for the map '
	 * {@link turnus.common.Attributable#getAttributesTable
	 * <em>Attributes Table</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the map '<em>Attributes Table</em>'.
	 * @see turnus.common.Attributable#getAttributesTable()
	 * @see #getAttributable()
	 * @generated
	 */
	EReference getAttributable_AttributesTable();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Object Map</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To Object Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EJavaObject"
	 * @generated
	 */
	EClass getStringToObjectMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry
	 * <em>Key</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObjectMap()
	 * @generated
	 */
	EAttribute getStringToObjectMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry
	 * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObjectMap()
	 * @generated
	 */
	EAttribute getStringToObjectMap_Value();

	/**
	 * Returns the meta object for class '
	 * {@link turnus.model.common.StatisticalData <em>Statistical Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Statistical Data</em>'.
	 * @see turnus.model.common.StatisticalData
	 * @generated
	 */
	EClass getStatisticalData();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getMin <em>Min</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see turnus.model.common.StatisticalData#getMin()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Min();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getMax <em>Max</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see turnus.model.common.StatisticalData#getMax()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Max();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getMean <em>Mean</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Mean</em>'.
	 * @see turnus.model.common.StatisticalData#getMean()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Mean();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getVariance <em>Variance</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see turnus.model.common.StatisticalData#getVariance()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Variance();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getSum <em>Sum</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sum</em>'.
	 * @see turnus.model.common.StatisticalData#getSum()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Sum();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Samples</em>'.
	 * @see turnus.model.common.StatisticalData#getSamples()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_Samples();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getSumOfLogs
	 * <em>Sum Of Logs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sum Of Logs</em>'.
	 * @see turnus.model.common.StatisticalData#getSumOfLogs()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_SumOfLogs();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getSumOfSquares
	 * <em>Sum Of Squares</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sum Of Squares</em>'.
	 * @see turnus.model.common.StatisticalData#getSumOfSquares()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_SumOfSquares();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getGeometricMean
	 * <em>Geometric Mean</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Geometric Mean</em>'.
	 * @see turnus.model.common.StatisticalData#getGeometricMean()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_GeometricMean();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getSecondMoment
	 * <em>Second Moment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Second Moment</em>'.
	 * @see turnus.model.common.StatisticalData#getSecondMoment()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_SecondMoment();

	/**
	 * Returns the meta object for the attribute '
	 * {@link turnus.model.common.StatisticalData#getStandardDeviation
	 * <em>Standard Deviation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Standard Deviation</em>'.
	 * @see turnus.model.common.StatisticalData#getStandardDeviation()
	 * @see #getStatisticalData()
	 * @generated
	 */
	EAttribute getStatisticalData_StandardDeviation();

	/**
	 * Returns the meta object for enum '{@link turnus.model.common.EOperator
	 * <em>EOperator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>EOperator</em>'.
	 * @see turnus.model.common.EOperator
	 * @generated
	 */
	EEnum getEOperator();

	/**
	 * Returns the meta object for enum '{@link turnus.model.common.EScheduler
	 * <em>EScheduler</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>EScheduler</em>'.
	 * @see turnus.model.common.EScheduler
	 * @generated
	 */
	EEnum getEScheduler();

	/**
	 * Returns the meta object for enum '{@link turnus.model.common.EType
	 * <em>EType</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>EType</em>'.
	 * @see turnus.model.common.EType
	 * @generated
	 */
	EEnum getEType();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link turnus.model.common.impl.AttributableImpl
		 * <em>Attributable</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see turnus.model.common.impl.AttributableImpl
		 * @see turnus.model.common.impl.CommonPackageImpl#getAttributable()
		 * @generated
		 */
		EClass ATTRIBUTABLE = eINSTANCE.getAttributable();

		/**
		 * The meta object literal for the '<em><b>Attributes Table</b></em>'
		 * map feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ATTRIBUTABLE__ATTRIBUTES_TABLE = eINSTANCE.getAttributable_AttributesTable();

		/**
		 * The meta object literal for the '
		 * {@link turnus.model.common.impl.StringToObjectMapImpl
		 * <em>String To Object Map</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see turnus.model.common.impl.StringToObjectMapImpl
		 * @see turnus.model.common.impl.CommonPackageImpl#getStringToObjectMap()
		 * @generated
		 */
		EClass STRING_TO_OBJECT_MAP = eINSTANCE.getStringToObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT_MAP__KEY = eINSTANCE.getStringToObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT_MAP__VALUE = eINSTANCE.getStringToObjectMap_Value();

		/**
		 * The meta object literal for the '
		 * {@link turnus.model.common.impl.StatisticalDataImpl
		 * <em>Statistical Data</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see turnus.model.common.impl.StatisticalDataImpl
		 * @see turnus.model.common.impl.CommonPackageImpl#getStatisticalData()
		 * @generated
		 */
		EClass STATISTICAL_DATA = eINSTANCE.getStatisticalData();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__MIN = eINSTANCE.getStatisticalData_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__MAX = eINSTANCE.getStatisticalData_Max();

		/**
		 * The meta object literal for the '<em><b>Mean</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__MEAN = eINSTANCE.getStatisticalData_Mean();

		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__VARIANCE = eINSTANCE.getStatisticalData_Variance();

		/**
		 * The meta object literal for the '<em><b>Sum</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__SUM = eINSTANCE.getStatisticalData_Sum();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__SAMPLES = eINSTANCE.getStatisticalData_Samples();

		/**
		 * The meta object literal for the '<em><b>Sum Of Logs</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__SUM_OF_LOGS = eINSTANCE.getStatisticalData_SumOfLogs();

		/**
		 * The meta object literal for the '<em><b>Sum Of Squares</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__SUM_OF_SQUARES = eINSTANCE.getStatisticalData_SumOfSquares();

		/**
		 * The meta object literal for the '<em><b>Geometric Mean</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__GEOMETRIC_MEAN = eINSTANCE.getStatisticalData_GeometricMean();

		/**
		 * The meta object literal for the '<em><b>Second Moment</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__SECOND_MOMENT = eINSTANCE.getStatisticalData_SecondMoment();

		/**
		 * The meta object literal for the '<em><b>Standard Deviation</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STATISTICAL_DATA__STANDARD_DEVIATION = eINSTANCE.getStatisticalData_StandardDeviation();

		/**
		 * The meta object literal for the '
		 * {@link turnus.model.common.EOperator <em>EOperator</em>}' enum. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see turnus.model.common.EOperator
		 * @see turnus.model.common.impl.CommonPackageImpl#getEOperator()
		 * @generated
		 */
		EEnum EOPERATOR = eINSTANCE.getEOperator();

		/**
		 * The meta object literal for the '
		 * {@link turnus.model.common.EScheduler <em>EScheduler</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see turnus.model.common.EScheduler
		 * @see turnus.model.common.impl.CommonPackageImpl#getEScheduler()
		 * @generated
		 */
		EEnum ESCHEDULER = eINSTANCE.getEScheduler();

		/**
		 * The meta object literal for the '{@link turnus.model.common.EType
		 * <em>EType</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see turnus.model.common.EType
		 * @see turnus.model.common.impl.CommonPackageImpl#getEType()
		 * @generated
		 */
		EEnum ETYPE = eINSTANCE.getEType();

	}

} // CommonPackage

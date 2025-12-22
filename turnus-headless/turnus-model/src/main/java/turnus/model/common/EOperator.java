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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>EOperator</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 *
 * @see turnus.model.common.CommonPackage#getEOperator()
 * @model
 * @generated
 */
public enum EOperator implements Enumerator {
	/**
	 * The '<em><b>BINARY BIT AND</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_AND_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_BIT_AND(0, "BINARY_BIT_AND", "BINARY_BIT_AND"),

	/**
	 * The '<em><b>BINARY BIT OR</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_OR_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_BIT_OR(1, "BINARY_BIT_OR", "BINARY_BIT_OR"),

	/**
	 * The '<em><b>BINARY BIT XOR</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_XOR_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_BIT_XOR(2, "BINARY_BIT_XOR", "BINARY_BIT_XOR"),

	/**
	 * The '<em><b>BINARY DIV</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_DIV_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_DIV(3, "BINARY_DIV", "BINARY_DIV"),

	/**
	 * The '<em><b>BINARY DIV INT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_DIV_INT_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_DIV_INT(4, "BINARY_DIV_INT", "BINARY_DIV_INT"),

	/**
	 * The '<em><b>BINARY EQ</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_EQ_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_EQ(5, "BINARY_EQ", "BINARY_EQ"),

	/**
	 * The '<em><b>BINARY EXP</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_EXP_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_EXP(6, "BINARY_EXP", "BINARY_EXP"),

	/**
	 * The '<em><b>BINARY GT</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_GT_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_GT(7, "BINARY_GT", "BINARY_GT"),

	/**
	 * The '<em><b>BINARY GE</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_GE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_GE(8, "BINARY_GE", "BINARY_GE"),

	/**
	 * The '<em><b>BINARY LT</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_LT_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LT(9, "BINARY_LT", "BINARY_LT"),

	/**
	 * The '<em><b>BINARY LE</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_LE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LE(10, "BINARY_LE", "BINARY_LE"),

	/**
	 * The '<em><b>BINARY LOGIC OR</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_LOGIC_OR_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LOGIC_OR(11, "BINARY_LOGIC_OR", "BINARY_LOGIC_OR"),

	/**
	 * The '<em><b>BINARY LOGIC AND</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #BINARY_LOGIC_AND_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LOGIC_AND(12, "BINARY_LOGIC_AND", "BINARY_LOGIC_AND"),

	/**
	 * The '<em><b>BINARY MINUS</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_MINUS_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_MINUS(13, "BINARY_MINUS", "BINARY_MINUS"),

	/**
	 * The '<em><b>BINARY PLUS</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_PLUS_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_PLUS(14, "BINARY_PLUS", "BINARY_PLUS"),

	/**
	 * The '<em><b>BINARY MOD</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_MOD_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_MOD(15, "BINARY_MOD", "BINARY_MOD"),

	/**
	 * The '<em><b>BINARY TIMES</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_TIMES_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_TIMES(16, "BINARY_TIMES", "BINARY_TIMES"),

	/**
	 * The '<em><b>BINARY NE</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #BINARY_NE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_NE(17, "BINARY_NE", "BINARY_NE"),

	/**
	 * The '<em><b>BINARY SHIFT LEFT</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #BINARY_SHIFT_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_SHIFT_LEFT(18, "BINARY_SHIFT_LEFT", "BINARY_SHIFT_LEFT"),

	/**
	 * The '<em><b>BINARY SHIFT RIGHT</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #BINARY_SHIFT_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_SHIFT_RIGHT(19, "BINARY_SHIFT_RIGHT", "BINARY_SHIFT_RIGHT"),

	/**
	 * The '<em><b>UNARY BIT NOT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_BIT_NOT_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_BIT_NOT(100, "UNARY_BIT_NOT", "UNARY_BIT_NOT"),

	/**
	 * The '<em><b>UNARY LOGIC NOT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_LOGIC_NOT_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_LOGIC_NOT(101, "UNARY_LOGIC_NOT", "UNARY_LOGIC_NOT"),

	/**
	 * The '<em><b>UNARY MINUS</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_MINUS_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_MINUS(102, "UNARY_MINUS", "UNARY_MINUS"),

	/**
	 * The '<em><b>UNARY NUM ELTS</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_NUM_ELTS_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_NUM_ELTS(103, "UNARY_NUM_ELTS", "UNARY_NUM_ELTS"),

	/**
	 * The '<em><b>DATAHANDLING STORE</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_STORE_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_STORE(200, "DATAHANDLING_STORE", "DATAHANDLING_STORE"),

	/**
	 * The '<em><b>DATAHANDLING ASSIGN</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_ASSIGN_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_ASSIGN(201, "DATAHANDLING_ASSIGN", "DATAHANDLING_ASSIGN"),

	/**
	 * The '<em><b>DATAHANDLING CALL</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_CALL_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_CALL(202, "DATAHANDLING_CALL", "DATAHANDLING_CALL"),

	/**
	 * The '<em><b>DATAHANDLING LOAD</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_LOAD(203, "DATAHANDLING_LOAD", "DATAHANDLING_LOAD"),

	/**
	 * The '<em><b>DATAHANDLING LIST LOAD</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LIST_LOAD_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_LIST_LOAD(204, "DATAHANDLING_LIST_LOAD", "DATAHANDLING_LIST_LOAD"),

	/**
	 * The '<em><b>DATAHANDLING LIST STORE</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LIST_STORE_VALUE
	 * @generated
	 * @ordered
	 */
	DATAHANDLING_LIST_STORE(205, "DATAHANDLING_LIST_STORE", "DATAHANDLING_LIST_STORE"),

	/**
	 * The '<em><b>FLOWCONTROL IF</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #FLOWCONTROL_IF_VALUE
	 * @generated
	 * @ordered
	 */
	FLOWCONTROL_IF(300, "FLOWCONTROL_IF", "FLOWCONTROL_IF"),

	/**
	 * The '<em><b>FLOWCONTROL WHILE</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #FLOWCONTROL_WHILE_VALUE
	 * @generated
	 * @ordered
	 */
	FLOWCONTROL_WHILE(301, "FLOWCONTROL_WHILE", "FLOWCONTROL_WHILE");

	/**
	 * The '<em><b>BINARY BIT AND</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY BIT AND</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_AND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_BIT_AND_VALUE = 0;

	/**
	 * The '<em><b>BINARY BIT OR</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY BIT OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_OR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_BIT_OR_VALUE = 1;

	/**
	 * The '<em><b>BINARY BIT XOR</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY BIT XOR</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_BIT_XOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_BIT_XOR_VALUE = 2;

	/**
	 * The '<em><b>BINARY DIV</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY DIV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_DIV
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_DIV_VALUE = 3;

	/**
	 * The '<em><b>BINARY DIV INT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY DIV INT</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_DIV_INT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_DIV_INT_VALUE = 4;

	/**
	 * The '<em><b>BINARY EQ</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY EQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_EQ
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_EQ_VALUE = 5;

	/**
	 * The '<em><b>BINARY EXP</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY EXP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_EXP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_EXP_VALUE = 6;

	/**
	 * The '<em><b>BINARY GT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY GT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_GT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_GT_VALUE = 7;

	/**
	 * The '<em><b>BINARY GE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY GE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_GE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_GE_VALUE = 8;

	/**
	 * The '<em><b>BINARY LT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY LT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_LT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LT_VALUE = 9;

	/**
	 * The '<em><b>BINARY LE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY LE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_LE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LE_VALUE = 10;

	/**
	 * The '<em><b>BINARY LOGIC OR</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY LOGIC OR</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_LOGIC_OR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LOGIC_OR_VALUE = 11;

	/**
	 * The '<em><b>BINARY LOGIC AND</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY LOGIC AND</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_LOGIC_AND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LOGIC_AND_VALUE = 12;

	/**
	 * The '<em><b>BINARY MINUS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY MINUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_MINUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_MINUS_VALUE = 13;

	/**
	 * The '<em><b>BINARY PLUS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY PLUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_PLUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_PLUS_VALUE = 14;

	/**
	 * The '<em><b>BINARY MOD</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY MOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_MOD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_MOD_VALUE = 15;

	/**
	 * The '<em><b>BINARY TIMES</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY TIMES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_TIMES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_TIMES_VALUE = 16;

	/**
	 * The '<em><b>BINARY NE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BINARY NE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_NE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_NE_VALUE = 17;

	/**
	 * The '<em><b>BINARY SHIFT LEFT</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>BINARY SHIFT LEFT</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_SHIFT_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_SHIFT_LEFT_VALUE = 18;

	/**
	 * The '<em><b>BINARY SHIFT RIGHT</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>BINARY SHIFT RIGHT</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #BINARY_SHIFT_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_SHIFT_RIGHT_VALUE = 19;

	/**
	 * The '<em><b>UNARY BIT NOT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNARY BIT NOT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_BIT_NOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_BIT_NOT_VALUE = 100;

	/**
	 * The '<em><b>UNARY LOGIC NOT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNARY LOGIC NOT</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_LOGIC_NOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_LOGIC_NOT_VALUE = 101;

	/**
	 * The '<em><b>UNARY MINUS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNARY MINUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_MINUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_MINUS_VALUE = 102;

	/**
	 * The '<em><b>UNARY NUM ELTS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNARY NUM ELTS</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #UNARY_NUM_ELTS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_NUM_ELTS_VALUE = 103;

	/**
	 * The '<em><b>DATAHANDLING STORE</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING STORE</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_STORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_STORE_VALUE = 200;

	/**
	 * The '<em><b>DATAHANDLING ASSIGN</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING ASSIGN</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_ASSIGN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_ASSIGN_VALUE = 201;

	/**
	 * The '<em><b>DATAHANDLING CALL</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING CALL</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_CALL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_CALL_VALUE = 202;

	/**
	 * The '<em><b>DATAHANDLING LOAD</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING LOAD</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_LOAD_VALUE = 203;

	/**
	 * The '<em><b>DATAHANDLING LIST LOAD</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING LIST LOAD</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LIST_LOAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_LIST_LOAD_VALUE = 204;

	/**
	 * The '<em><b>DATAHANDLING LIST STORE</b></em>' literal value. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATAHANDLING LIST STORE</b></em>' literal object
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #DATAHANDLING_LIST_STORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATAHANDLING_LIST_STORE_VALUE = 205;

	/**
	 * The '<em><b>FLOWCONTROL IF</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOWCONTROL IF</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #FLOWCONTROL_IF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOWCONTROL_IF_VALUE = 300;

	/**
	 * The '<em><b>FLOWCONTROL WHILE</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>FLOWCONTROL WHILE</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #FLOWCONTROL_WHILE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOWCONTROL_WHILE_VALUE = 301;

	/**
	 * An array of all the '<em><b>EOperator</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final EOperator[] VALUES_ARRAY = new EOperator[] { BINARY_BIT_AND, BINARY_BIT_OR, BINARY_BIT_XOR,
			BINARY_DIV, BINARY_DIV_INT, BINARY_EQ, BINARY_EXP, BINARY_GT, BINARY_GE, BINARY_LT, BINARY_LE,
			BINARY_LOGIC_OR, BINARY_LOGIC_AND, BINARY_MINUS, BINARY_PLUS, BINARY_MOD, BINARY_TIMES, BINARY_NE,
			BINARY_SHIFT_LEFT, BINARY_SHIFT_RIGHT, UNARY_BIT_NOT, UNARY_LOGIC_NOT, UNARY_MINUS, UNARY_NUM_ELTS,
			DATAHANDLING_STORE, DATAHANDLING_ASSIGN, DATAHANDLING_CALL, DATAHANDLING_LOAD, DATAHANDLING_LIST_LOAD,
			DATAHANDLING_LIST_STORE, FLOWCONTROL_IF, FLOWCONTROL_WHILE, };

	/**
	 * A public read-only list of all the '<em><b>EOperator</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<EOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EOperator</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperator get(String literal) {
		for (EOperator result : VALUES_ARRAY) {
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOperator</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperator getByName(String name) {
		for (EOperator result : VALUES_ARRAY) {
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOperator</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOperator get(int value) {
		switch (value) {
		case BINARY_BIT_AND_VALUE:
			return BINARY_BIT_AND;
		case BINARY_BIT_OR_VALUE:
			return BINARY_BIT_OR;
		case BINARY_BIT_XOR_VALUE:
			return BINARY_BIT_XOR;
		case BINARY_DIV_VALUE:
			return BINARY_DIV;
		case BINARY_DIV_INT_VALUE:
			return BINARY_DIV_INT;
		case BINARY_EQ_VALUE:
			return BINARY_EQ;
		case BINARY_EXP_VALUE:
			return BINARY_EXP;
		case BINARY_GT_VALUE:
			return BINARY_GT;
		case BINARY_GE_VALUE:
			return BINARY_GE;
		case BINARY_LT_VALUE:
			return BINARY_LT;
		case BINARY_LE_VALUE:
			return BINARY_LE;
		case BINARY_LOGIC_OR_VALUE:
			return BINARY_LOGIC_OR;
		case BINARY_LOGIC_AND_VALUE:
			return BINARY_LOGIC_AND;
		case BINARY_MINUS_VALUE:
			return BINARY_MINUS;
		case BINARY_PLUS_VALUE:
			return BINARY_PLUS;
		case BINARY_MOD_VALUE:
			return BINARY_MOD;
		case BINARY_TIMES_VALUE:
			return BINARY_TIMES;
		case BINARY_NE_VALUE:
			return BINARY_NE;
		case BINARY_SHIFT_LEFT_VALUE:
			return BINARY_SHIFT_LEFT;
		case BINARY_SHIFT_RIGHT_VALUE:
			return BINARY_SHIFT_RIGHT;
		case UNARY_BIT_NOT_VALUE:
			return UNARY_BIT_NOT;
		case UNARY_LOGIC_NOT_VALUE:
			return UNARY_LOGIC_NOT;
		case UNARY_MINUS_VALUE:
			return UNARY_MINUS;
		case UNARY_NUM_ELTS_VALUE:
			return UNARY_NUM_ELTS;
		case DATAHANDLING_STORE_VALUE:
			return DATAHANDLING_STORE;
		case DATAHANDLING_ASSIGN_VALUE:
			return DATAHANDLING_ASSIGN;
		case DATAHANDLING_CALL_VALUE:
			return DATAHANDLING_CALL;
		case DATAHANDLING_LOAD_VALUE:
			return DATAHANDLING_LOAD;
		case DATAHANDLING_LIST_LOAD_VALUE:
			return DATAHANDLING_LIST_LOAD;
		case DATAHANDLING_LIST_STORE_VALUE:
			return DATAHANDLING_LIST_STORE;
		case FLOWCONTROL_IF_VALUE:
			return FLOWCONTROL_IF;
		case FLOWCONTROL_WHILE_VALUE:
			return FLOWCONTROL_WHILE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	private EOperator(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // EOperator

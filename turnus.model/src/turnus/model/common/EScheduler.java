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
 * <em><b>EScheduler</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 *
 * @see turnus.model.common.CommonPackage#getEScheduler()
 * @model
 * @generated
 */
public enum EScheduler implements Enumerator {
	/**
	 * The '<em><b>FULL PARALLEL</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #FULL_PARALLEL_VALUE
	 * @generated
	 * @ordered
	 */
	FULL_PARALLEL(0, "FULL_PARALLEL", "FULL_PARALLEL"),

	/**
	 * The '<em><b>ROUND ROBIN</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #ROUND_ROBIN_VALUE
	 * @generated
	 * @ordered
	 */
	ROUND_ROBIN(1, "ROUND_ROBIN", "ROUND_ROBIN"),

	/**
	 * The '<em><b>NON PREEMPTIVE</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #NON_PREEMPTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	NON_PREEMPTIVE(2, "NON_PREEMPTIVE", "NON_PREEMPTIVE"),

	/**
	 * The '<em><b>DATA DEMAND DRIVEN</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATA_DEMAND_DRIVEN_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_DEMAND_DRIVEN(3, "DATA_DEMAND_DRIVEN", "DATA_DEMAND_DRIVEN"),
	/**
	 * The '<em><b>RANDOM</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #RANDOM_VALUE
	 * @generated
	 * @ordered
	 */
	RANDOM(4, "RANDOM", "RANDOM");

	/**
	 * The '<em><b>FULL PARALLEL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FULL PARALLEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #FULL_PARALLEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FULL_PARALLEL_VALUE = 0;

	/**
	 * The '<em><b>ROUND ROBIN</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROUND ROBIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #ROUND_ROBIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROUND_ROBIN_VALUE = 1;

	/**
	 * The '<em><b>NON PREEMPTIVE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NON PREEMPTIVE</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #NON_PREEMPTIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_PREEMPTIVE_VALUE = 2;

	/**
	 * The '<em><b>DATA DEMAND DRIVEN</b></em>' literal value. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #DATA_DEMAND_DRIVEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATA_DEMAND_DRIVEN_VALUE = 3;

	/**
	 * The '<em><b>RANDOM</b></em>' literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #RANDOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RANDOM_VALUE = 4;

	/**
	 * An array of all the '<em><b>EScheduler</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final EScheduler[] VALUES_ARRAY = new EScheduler[] { FULL_PARALLEL, ROUND_ROBIN, NON_PREEMPTIVE,
			DATA_DEMAND_DRIVEN, RANDOM, };

	/**
	 * A public read-only list of all the '<em><b>EScheduler</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<EScheduler> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EScheduler</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EScheduler get(String literal) {
		for (EScheduler result : VALUES_ARRAY) {
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EScheduler</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EScheduler getByName(String name) {
		for (EScheduler result : VALUES_ARRAY) {
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EScheduler</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EScheduler get(int value) {
		switch (value) {
		case FULL_PARALLEL_VALUE:
			return FULL_PARALLEL;
		case ROUND_ROBIN_VALUE:
			return ROUND_ROBIN;
		case NON_PREEMPTIVE_VALUE:
			return NON_PREEMPTIVE;
		case DATA_DEMAND_DRIVEN_VALUE:
			return DATA_DEMAND_DRIVEN;
		case RANDOM_VALUE:
			return RANDOM;
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
	private EScheduler(int value, String name, String literal) {
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

} // EScheduler

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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.common.Attributable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Medium</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.Medium#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getLinks <em>Links</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getClockPeriodIn <em>Clock Period In</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getClockPeriodOut <em>Clock Period Out</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getMaxBitPop <em>Max Bit Pop</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getMaxBitPush <em>Max Bit Push</em>}</li>
 *   <li>{@link turnus.model.architecture.Medium#getMaxBitSize <em>Max Bit Size</em>}</li>
 * </ul>
 *
 * @see turnus.model.architecture.ArchitecturePackage#getMedium()
 * @model superTypes="turnus.model.common.Attributable"
 * @generated
 */
public interface Medium extends EObject, Attributable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.architecture.Link}.
	 * It is bidirectional and its opposite is '{@link turnus.model.architecture.Link#getMedium <em>Medium</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_Links()
	 * @see turnus.model.architecture.Link#getMedium
	 * @model opposite="medium"
	 * @generated
	 */
	List<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Clock Period In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Period In</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Period In</em>' attribute.
	 * @see #setClockPeriodIn(double)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_ClockPeriodIn()
	 * @model
	 * @generated
	 */
	double getClockPeriodIn();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getClockPeriodIn <em>Clock Period In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock Period In</em>' attribute.
	 * @see #getClockPeriodIn()
	 * @generated
	 */
	void setClockPeriodIn(double value);

	/**
	 * Returns the value of the '<em><b>Clock Period Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Period Out</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Period Out</em>' attribute.
	 * @see #setClockPeriodOut(double)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_ClockPeriodOut()
	 * @model
	 * @generated
	 */
	double getClockPeriodOut();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getClockPeriodOut <em>Clock Period Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock Period Out</em>' attribute.
	 * @see #getClockPeriodOut()
	 * @generated
	 */
	void setClockPeriodOut(double value);

	/**
	 * Returns the value of the '<em><b>Max Bit Pop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Bit Pop</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Bit Pop</em>' attribute.
	 * @see #setMaxBitPop(int)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_MaxBitPop()
	 * @model
	 * @generated
	 */
	int getMaxBitPop();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getMaxBitPop <em>Max Bit Pop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Bit Pop</em>' attribute.
	 * @see #getMaxBitPop()
	 * @generated
	 */
	void setMaxBitPop(int value);

	/**
	 * Returns the value of the '<em><b>Max Bit Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Bit Push</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Bit Push</em>' attribute.
	 * @see #setMaxBitPush(int)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_MaxBitPush()
	 * @model
	 * @generated
	 */
	int getMaxBitPush();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getMaxBitPush <em>Max Bit Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Bit Push</em>' attribute.
	 * @see #getMaxBitPush()
	 * @generated
	 */
	void setMaxBitPush(int value);

	/**
	 * Returns the value of the '<em><b>Max Bit Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Bit Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Bit Size</em>' attribute.
	 * @see #setMaxBitSize(int)
	 * @see turnus.model.architecture.ArchitecturePackage#getMedium_MaxBitSize()
	 * @model
	 * @generated
	 */
	int getMaxBitSize();

	/**
	 * Sets the value of the '{@link turnus.model.architecture.Medium#getMaxBitSize <em>Max Bit Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Bit Size</em>' attribute.
	 * @see #getMaxBitSize()
	 * @generated
	 */
	void setMaxBitSize(int value);

} // Medium

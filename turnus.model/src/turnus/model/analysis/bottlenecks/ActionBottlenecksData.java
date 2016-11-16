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
package turnus.model.analysis.bottlenecks;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Bottlenecks Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMin <em>Slack Min</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMax <em>Slack Max</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpVariance <em>Cp Variance</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalWeight <em>Total Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalVariance <em>Total Variance</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpFirings <em>Cp Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalFirings <em>Total Firings</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData()
 * @model
 * @generated
 */
public interface ActionBottlenecksData extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Weight</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Weight</em>' attribute.
	 * @see #setCpWeight(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_CpWeight()
	 * @model required="true"
	 * @generated
	 */
	double getCpWeight();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpWeight <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Weight</em>' attribute.
	 * @see #getCpWeight()
	 * @generated
	 */
	void setCpWeight(double value);

	/**
	 * Returns the value of the '<em><b>Cp Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Variance</em>' attribute.
	 * @see #setCpVariance(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_CpVariance()
	 * @model required="true"
	 * @generated
	 */
	double getCpVariance();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpVariance <em>Cp Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Variance</em>' attribute.
	 * @see #getCpVariance()
	 * @generated
	 */
	void setCpVariance(double value);

	/**
	 * Returns the value of the '<em><b>Total Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Weight</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Weight</em>' attribute.
	 * @see #setTotalWeight(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_TotalWeight()
	 * @model required="true"
	 * @generated
	 */
	double getTotalWeight();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalWeight <em>Total Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Weight</em>' attribute.
	 * @see #getTotalWeight()
	 * @generated
	 */
	void setTotalWeight(double value);

	/**
	 * Returns the value of the '<em><b>Total Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Variance</em>' attribute.
	 * @see #setTotalVariance(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_TotalVariance()
	 * @model required="true"
	 * @generated
	 */
	double getTotalVariance();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalVariance <em>Total Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Variance</em>' attribute.
	 * @see #getTotalVariance()
	 * @generated
	 */
	void setTotalVariance(double value);

	/**
	 * Returns the value of the '<em><b>Cp Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Firings</em>' attribute.
	 * @see #setCpFirings(long)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_CpFirings()
	 * @model required="true"
	 * @generated
	 */
	long getCpFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getCpFirings <em>Cp Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Firings</em>' attribute.
	 * @see #getCpFirings()
	 * @generated
	 */
	void setCpFirings(long value);

	/**
	 * Returns the value of the '<em><b>Total Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Firings</em>' attribute.
	 * @see #setTotalFirings(long)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_TotalFirings()
	 * @model required="true"
	 * @generated
	 */
	long getTotalFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getTotalFirings <em>Total Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Firings</em>' attribute.
	 * @see #getTotalFirings()
	 * @generated
	 */
	void setTotalFirings(long value);

	/**
	 * Returns the value of the '<em><b>Slack Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slack Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slack Min</em>' attribute.
	 * @see #setSlackMin(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_SlackMin()
	 * @model
	 * @generated
	 */
	double getSlackMin();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMin <em>Slack Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slack Min</em>' attribute.
	 * @see #getSlackMin()
	 * @generated
	 */
	void setSlackMin(double value);

	/**
	 * Returns the value of the '<em><b>Slack Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slack Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slack Max</em>' attribute.
	 * @see #setSlackMax(double)
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getActionBottlenecksData_SlackMax()
	 * @model
	 * @generated
	 */
	double getSlackMax();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.bottlenecks.ActionBottlenecksData#getSlackMax <em>Slack Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slack Max</em>' attribute.
	 * @see #getSlackMax()
	 * @generated
	 */
	void setSlackMax(double value);

} // ActionBottlenecksData

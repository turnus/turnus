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
package turnus.model.analysis.communication;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Communication Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.communication.LinearCommunicationModel#getConstantBandwidth <em>Constant Bandwidth</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.LinearCommunicationModel#getFixedOverheadLatency <em>Fixed Overhead Latency</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.communication.CommunicationPackage#getLinearCommunicationModel()
 * @model
 * @generated
 */
public interface LinearCommunicationModel extends CommunicationModel {
	/**
	 * Returns the value of the '<em><b>Constant Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Bandwidth</em>' attribute.
	 * @see #setConstantBandwidth(double)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getLinearCommunicationModel_ConstantBandwidth()
	 * @model
	 * @generated
	 */
	double getConstantBandwidth();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.LinearCommunicationModel#getConstantBandwidth <em>Constant Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Bandwidth</em>' attribute.
	 * @see #getConstantBandwidth()
	 * @generated
	 */
	void setConstantBandwidth(double value);

	/**
	 * Returns the value of the '<em><b>Fixed Overhead Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Overhead Latency</em>' attribute.
	 * @see #setFixedOverheadLatency(double)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getLinearCommunicationModel_FixedOverheadLatency()
	 * @model
	 * @generated
	 */
	double getFixedOverheadLatency();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.LinearCommunicationModel#getFixedOverheadLatency <em>Fixed Overhead Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Overhead Latency</em>' attribute.
	 * @see #getFixedOverheadLatency()
	 * @generated
	 */
	void setFixedOverheadLatency(double value);

} // LinearCommunicationModel

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
 * A representation of the model object '<em><b>Sigmoid Communication Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getCarryingCapacity <em>Carrying Capacity</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getGrowthRate <em>Growth Rate</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getMidpoint <em>Midpoint</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.communication.CommunicationPackage#getSigmoidCommunicationModel()
 * @model
 * @generated
 */
public interface SigmoidCommunicationModel extends CommunicationModel {
	/**
	 * Returns the value of the '<em><b>Carrying Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Carrying Capacity</em>' attribute.
	 * @see #setCarryingCapacity(double)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getSigmoidCommunicationModel_CarryingCapacity()
	 * @model
	 * @generated
	 */
	double getCarryingCapacity();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getCarryingCapacity <em>Carrying Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Carrying Capacity</em>' attribute.
	 * @see #getCarryingCapacity()
	 * @generated
	 */
	void setCarryingCapacity(double value);

	/**
	 * Returns the value of the '<em><b>Growth Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Growth Rate</em>' attribute.
	 * @see #setGrowthRate(double)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getSigmoidCommunicationModel_GrowthRate()
	 * @model
	 * @generated
	 */
	double getGrowthRate();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getGrowthRate <em>Growth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Growth Rate</em>' attribute.
	 * @see #getGrowthRate()
	 * @generated
	 */
	void setGrowthRate(double value);

	/**
	 * Returns the value of the '<em><b>Midpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Midpoint</em>' attribute.
	 * @see #setMidpoint(double)
	 * @see turnus.model.analysis.communication.CommunicationPackage#getSigmoidCommunicationModel_Midpoint()
	 * @model
	 * @generated
	 */
	double getMidpoint();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.communication.SigmoidCommunicationModel#getMidpoint <em>Midpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Midpoint</em>' attribute.
	 * @see #getMidpoint()
	 * @generated
	 */
	void setMidpoint(double value);

} // SigmoidCommunicationModel

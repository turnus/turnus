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
package turnus.model.analysis.communication.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import turnus.model.analysis.communication.CommunicationPackage;
import turnus.model.analysis.communication.SigmoidCommunicationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sigmoid Communication Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl#getCarryingCapacity <em>Carrying Capacity</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl#getGrowthRate <em>Growth Rate</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.impl.SigmoidCommunicationModelImpl#getMidpoint <em>Midpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SigmoidCommunicationModelImpl extends CommunicationModelImpl implements SigmoidCommunicationModel {
	/**
	 * The default value of the '{@link #getCarryingCapacity() <em>Carrying Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCarryingCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final double CARRYING_CAPACITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCarryingCapacity() <em>Carrying Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCarryingCapacity()
	 * @generated
	 * @ordered
	 */
	protected double carryingCapacity = CARRYING_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrowthRate() <em>Growth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowthRate()
	 * @generated
	 * @ordered
	 */
	protected static final double GROWTH_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGrowthRate() <em>Growth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowthRate()
	 * @generated
	 * @ordered
	 */
	protected double growthRate = GROWTH_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMidpoint() <em>Midpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidpoint()
	 * @generated
	 * @ordered
	 */
	protected static final double MIDPOINT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMidpoint() <em>Midpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidpoint()
	 * @generated
	 * @ordered
	 */
	protected double midpoint = MIDPOINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SigmoidCommunicationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommunicationPackage.Literals.SIGMOID_COMMUNICATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCarryingCapacity() {
		return carryingCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCarryingCapacity(double newCarryingCapacity) {
		double oldCarryingCapacity = carryingCapacity;
		carryingCapacity = newCarryingCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY, oldCarryingCapacity, carryingCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGrowthRate() {
		return growthRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrowthRate(double newGrowthRate) {
		double oldGrowthRate = growthRate;
		growthRate = newGrowthRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE, oldGrowthRate, growthRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMidpoint() {
		return midpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMidpoint(double newMidpoint) {
		double oldMidpoint = midpoint;
		midpoint = newMidpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__MIDPOINT, oldMidpoint, midpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY:
				return getCarryingCapacity();
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE:
				return getGrowthRate();
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__MIDPOINT:
				return getMidpoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY:
				setCarryingCapacity((Double)newValue);
				return;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE:
				setGrowthRate((Double)newValue);
				return;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__MIDPOINT:
				setMidpoint((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY:
				setCarryingCapacity(CARRYING_CAPACITY_EDEFAULT);
				return;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE:
				setGrowthRate(GROWTH_RATE_EDEFAULT);
				return;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__MIDPOINT:
				setMidpoint(MIDPOINT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__CARRYING_CAPACITY:
				return carryingCapacity != CARRYING_CAPACITY_EDEFAULT;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__GROWTH_RATE:
				return growthRate != GROWTH_RATE_EDEFAULT;
			case CommunicationPackage.SIGMOID_COMMUNICATION_MODEL__MIDPOINT:
				return midpoint != MIDPOINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (carryingCapacity: ");
		result.append(carryingCapacity);
		result.append(", growthRate: ");
		result.append(growthRate);
		result.append(", midpoint: ");
		result.append(midpoint);
		result.append(')');
		return result.toString();
	}

} //SigmoidCommunicationModelImpl

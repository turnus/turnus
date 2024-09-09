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
import turnus.model.analysis.communication.LinearCommunicationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Communication Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.communication.impl.LinearCommunicationModelImpl#getConstantBandwidth <em>Constant Bandwidth</em>}</li>
 *   <li>{@link turnus.model.analysis.communication.impl.LinearCommunicationModelImpl#getFixedOverheadLatency <em>Fixed Overhead Latency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinearCommunicationModelImpl extends CommunicationModelImpl implements LinearCommunicationModel {
	/**
	 * The default value of the '{@link #getConstantBandwidth() <em>Constant Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantBandwidth()
	 * @generated
	 * @ordered
	 */
	protected static final double CONSTANT_BANDWIDTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getConstantBandwidth() <em>Constant Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantBandwidth()
	 * @generated
	 * @ordered
	 */
	protected double constantBandwidth = CONSTANT_BANDWIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedOverheadLatency() <em>Fixed Overhead Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOverheadLatency()
	 * @generated
	 * @ordered
	 */
	protected static final double FIXED_OVERHEAD_LATENCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFixedOverheadLatency() <em>Fixed Overhead Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOverheadLatency()
	 * @generated
	 * @ordered
	 */
	protected double fixedOverheadLatency = FIXED_OVERHEAD_LATENCY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearCommunicationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommunicationPackage.Literals.LINEAR_COMMUNICATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConstantBandwidth() {
		return constantBandwidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantBandwidth(double newConstantBandwidth) {
		double oldConstantBandwidth = constantBandwidth;
		constantBandwidth = newConstantBandwidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommunicationPackage.LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH, oldConstantBandwidth, constantBandwidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFixedOverheadLatency() {
		return fixedOverheadLatency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFixedOverheadLatency(double newFixedOverheadLatency) {
		double oldFixedOverheadLatency = fixedOverheadLatency;
		fixedOverheadLatency = newFixedOverheadLatency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommunicationPackage.LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY, oldFixedOverheadLatency, fixedOverheadLatency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH:
				return getConstantBandwidth();
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY:
				return getFixedOverheadLatency();
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
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH:
				setConstantBandwidth((Double)newValue);
				return;
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY:
				setFixedOverheadLatency((Double)newValue);
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
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH:
				setConstantBandwidth(CONSTANT_BANDWIDTH_EDEFAULT);
				return;
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY:
				setFixedOverheadLatency(FIXED_OVERHEAD_LATENCY_EDEFAULT);
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
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__CONSTANT_BANDWIDTH:
				return constantBandwidth != CONSTANT_BANDWIDTH_EDEFAULT;
			case CommunicationPackage.LINEAR_COMMUNICATION_MODEL__FIXED_OVERHEAD_LATENCY:
				return fixedOverheadLatency != FIXED_OVERHEAD_LATENCY_EDEFAULT;
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
		result.append(" (constantBandwidth: ");
		result.append(constantBandwidth);
		result.append(", fixedOverheadLatency: ");
		result.append(fixedOverheadLatency);
		result.append(')');
		return result.toString();
	}

} //LinearCommunicationModelImpl

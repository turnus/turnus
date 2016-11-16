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
package turnus.model.analysis.buffers.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;

import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersPackage;
import turnus.model.analysis.buffers.OptimalBufferData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optimal Buffer Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBufferDataImpl#getBufferData <em>Buffer Data</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBufferDataImpl#getBottlenecksData <em>Bottlenecks Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptimalBufferDataImpl extends MinimalEObjectImpl.Container implements OptimalBufferData {
	/**
	 * The cached value of the '{@link #getBufferData() <em>Buffer Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferData()
	 * @generated
	 * @ordered
	 */
	protected BoundedBuffersReport bufferData;

	/**
	 * The cached value of the '{@link #getBottlenecksData() <em>Bottlenecks Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottlenecksData()
	 * @generated
	 * @ordered
	 */
	protected BottlenecksWithSchedulingReport bottlenecksData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimalBufferDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuffersPackage.Literals.OPTIMAL_BUFFER_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundedBuffersReport getBufferData() {
		return bufferData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferData(BoundedBuffersReport newBufferData, NotificationChain msgs) {
		BoundedBuffersReport oldBufferData = bufferData;
		bufferData = newBufferData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA, oldBufferData, newBufferData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferData(BoundedBuffersReport newBufferData) {
		if (newBufferData != bufferData) {
			NotificationChain msgs = null;
			if (bufferData != null)
				msgs = ((InternalEObject)bufferData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA, null, msgs);
			if (newBufferData != null)
				msgs = ((InternalEObject)newBufferData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA, null, msgs);
			msgs = basicSetBufferData(newBufferData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA, newBufferData, newBufferData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottlenecksWithSchedulingReport getBottlenecksData() {
		return bottlenecksData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottlenecksData(BottlenecksWithSchedulingReport newBottlenecksData, NotificationChain msgs) {
		BottlenecksWithSchedulingReport oldBottlenecksData = bottlenecksData;
		bottlenecksData = newBottlenecksData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA, oldBottlenecksData, newBottlenecksData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottlenecksData(BottlenecksWithSchedulingReport newBottlenecksData) {
		if (newBottlenecksData != bottlenecksData) {
			NotificationChain msgs = null;
			if (bottlenecksData != null)
				msgs = ((InternalEObject)bottlenecksData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA, null, msgs);
			if (newBottlenecksData != null)
				msgs = ((InternalEObject)newBottlenecksData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA, null, msgs);
			msgs = basicSetBottlenecksData(newBottlenecksData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA, newBottlenecksData, newBottlenecksData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA:
				return basicSetBufferData(null, msgs);
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA:
				return basicSetBottlenecksData(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA:
				return getBufferData();
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA:
				return getBottlenecksData();
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
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA:
				setBufferData((BoundedBuffersReport)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA:
				setBottlenecksData((BottlenecksWithSchedulingReport)newValue);
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
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA:
				setBufferData((BoundedBuffersReport)null);
				return;
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA:
				setBottlenecksData((BottlenecksWithSchedulingReport)null);
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
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BUFFER_DATA:
				return bufferData != null;
			case BuffersPackage.OPTIMAL_BUFFER_DATA__BOTTLENECKS_DATA:
				return bottlenecksData != null;
		}
		return super.eIsSet(featureID);
	}

} //OptimalBufferDataImpl

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BuffersPackage;

import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bounded Buffer Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBufferDataImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBufferDataImpl#getTokenSize <em>Token Size</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBufferDataImpl#getBitSize <em>Bit Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundedBufferDataImpl extends MinimalEObjectImpl.Container implements BoundedBufferData {
	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected Buffer buffer;

	/**
	 * The default value of the '{@link #getTokenSize() <em>Token Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTokenSize()
	 * @generated
	 * @ordered
	 */
	protected static final int TOKEN_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTokenSize() <em>Token Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTokenSize()
	 * @generated
	 * @ordered
	 */
	protected int tokenSize = TOKEN_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBitSize() <em>Bit Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBitSize()
	 * @generated
	 * @ordered
	 */
	protected static final int BIT_SIZE_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedBufferDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuffersPackage.Literals.BOUNDED_BUFFER_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer getBuffer() {
		if (buffer != null && buffer.eIsProxy()) {
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (Buffer)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetBuffer() {
		return buffer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffer(Buffer newBuffer) {
		Buffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER, oldBuffer, buffer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getTokenSize() {
		return tokenSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTokenSize(int newTokenSize) {
		int oldTokenSize = tokenSize;
		tokenSize = newTokenSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFER_DATA__TOKEN_SIZE, oldTokenSize, tokenSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getBitSize() {
		Buffer buffer = getBuffer();
		return buffer != null ? getTokenSize() * buffer.getType().getBits() : 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER:
				if (resolve) return getBuffer();
				return basicGetBuffer();
			case BuffersPackage.BOUNDED_BUFFER_DATA__TOKEN_SIZE:
				return getTokenSize();
			case BuffersPackage.BOUNDED_BUFFER_DATA__BIT_SIZE:
				return getBitSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER:
				setBuffer((Buffer)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFER_DATA__TOKEN_SIZE:
				setTokenSize((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER:
				setBuffer((Buffer)null);
				return;
			case BuffersPackage.BOUNDED_BUFFER_DATA__TOKEN_SIZE:
				setTokenSize(TOKEN_SIZE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BuffersPackage.BOUNDED_BUFFER_DATA__BUFFER:
				return buffer != null;
			case BuffersPackage.BOUNDED_BUFFER_DATA__TOKEN_SIZE:
				return tokenSize != TOKEN_SIZE_EDEFAULT;
			case BuffersPackage.BOUNDED_BUFFER_DATA__BIT_SIZE:
				return getBitSize() != BIT_SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tokenSize: ");
		result.append(tokenSize);
		result.append(')');
		return result.toString();
	}

} // BoundedBufferDataImpl

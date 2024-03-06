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
package turnus.model.dataflow.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import turnus.model.common.EType;

import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Type;
import turnus.model.dataflow.TypeTensor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type
 * Tensor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link turnus.model.dataflow.impl.TypeTensorImpl#getEtype
 * <em>Etype</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.TypeTensorImpl#getBits
 * <em>Bits</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.TypeTensorImpl#getTensorType <em>Tensor
 * Type</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.TypeTensorImpl#getShape
 * <em>Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeTensorImpl extends MinimalEObjectImpl.Container implements TypeTensor {
	/**
	 * The default value of the '{@link #getEtype() <em>Etype</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEtype()
	 * @generated
	 * @ordered
	 */
	protected static final EType ETYPE_EDEFAULT = EType.INT;

	/**
	 * The default value of the '{@link #getBits() <em>Bits</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected static final long BITS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTensorType() <em>Tensor Type</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTensorType()
	 * @generated
	 * @ordered
	 */
	protected Type tensorType;

	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> shape;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypeTensorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.TYPE_TENSOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EType getEtype() {
		// TODO: implement this method to return the 'Etype' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public long getBits() {
		// TODO: implement this method to return the 'Bits' attribute
		// Ensure that you remove @generated or mark it @generated NOT

		long mShape = getShape().stream().reduce(1L, (a, b) -> a * b);

		return mShape * getTensorType().getBits();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Type getTensorType() {
		return tensorType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTensorType(Type newTensorType, NotificationChain msgs) {
		Type oldTensorType = tensorType;
		tensorType = newTensorType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DataflowPackage.TYPE_TENSOR__TENSOR_TYPE, oldTensorType, newTensorType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTensorType(Type newTensorType) {
		if (newTensorType != tensorType) {
			NotificationChain msgs = null;
			if (tensorType != null)
				msgs = ((InternalEObject) tensorType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - DataflowPackage.TYPE_TENSOR__TENSOR_TYPE, null, msgs);
			if (newTensorType != null)
				msgs = ((InternalEObject) newTensorType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - DataflowPackage.TYPE_TENSOR__TENSOR_TYPE, null, msgs);
			msgs = basicSetTensorType(newTensorType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.TYPE_TENSOR__TENSOR_TYPE,
					newTensorType, newTensorType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<Long> getShape() {
		if (shape == null) {
			shape = new EDataTypeUniqueEList<Long>(Long.class, this, DataflowPackage.TYPE_TENSOR__SHAPE);
		}
		return shape;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DataflowPackage.TYPE_TENSOR__TENSOR_TYPE:
			return basicSetTensorType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DataflowPackage.TYPE_TENSOR__ETYPE:
			return getEtype();
		case DataflowPackage.TYPE_TENSOR__BITS:
			return getBits();
		case DataflowPackage.TYPE_TENSOR__TENSOR_TYPE:
			return getTensorType();
		case DataflowPackage.TYPE_TENSOR__SHAPE:
			return getShape();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DataflowPackage.TYPE_TENSOR__TENSOR_TYPE:
			setTensorType((Type) newValue);
			return;
		case DataflowPackage.TYPE_TENSOR__SHAPE:
			getShape().clear();
			getShape().addAll((Collection<? extends Long>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DataflowPackage.TYPE_TENSOR__TENSOR_TYPE:
			setTensorType((Type) null);
			return;
		case DataflowPackage.TYPE_TENSOR__SHAPE:
			getShape().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DataflowPackage.TYPE_TENSOR__ETYPE:
			return getEtype() != ETYPE_EDEFAULT;
		case DataflowPackage.TYPE_TENSOR__BITS:
			return getBits() != BITS_EDEFAULT;
		case DataflowPackage.TYPE_TENSOR__TENSOR_TYPE:
			return tensorType != null;
		case DataflowPackage.TYPE_TENSOR__SHAPE:
			return shape != null && !shape.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (shape: ");
		result.append(shape);
		result.append(')');
		return result.toString();
	}

} // TypeTensorImpl

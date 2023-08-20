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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.common.EType;

import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Type;
import turnus.model.dataflow.TypeList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.impl.TypeListImpl#getEtype <em>Etype</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.TypeListImpl#getBits <em>Bits</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.TypeListImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.TypeListImpl#getListType <em>List Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeListImpl extends MinimalEObjectImpl.Container implements TypeList {
	/**
	 * The default value of the '{@link #getEtype() <em>Etype</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEtype()
	 * @generated
	 * @ordered
	 */
	protected static final EType ETYPE_EDEFAULT = EType.INT;

	/**
	 * The default value of the '{@link #getBits() <em>Bits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected static final int BITS_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getElements() <em>Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected static final int ELEMENTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected int elements = ELEMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getListType() <em>List Type</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getListType()
	 * @generated
	 * @ordered
	 */
	protected Type listType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.TYPE_LIST;
	}

	@Override
	public EType getEtype() {
		return EType.LIST;
	}

	@Override
	public int getBits() {
		return getElements() * getListType().getBits();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getElements() {
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElements(int newElements) {
		int oldElements = elements;
		elements = newElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.TYPE_LIST__ELEMENTS, oldElements, elements));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getListType() {
		return listType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetListType(Type newListType, NotificationChain msgs) {
		Type oldListType = listType;
		listType = newListType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataflowPackage.TYPE_LIST__LIST_TYPE, oldListType, newListType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setListType(Type newListType) {
		if (newListType != listType) {
			NotificationChain msgs = null;
			if (listType != null)
				msgs = ((InternalEObject)listType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.TYPE_LIST__LIST_TYPE, null, msgs);
			if (newListType != null)
				msgs = ((InternalEObject)newListType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.TYPE_LIST__LIST_TYPE, null, msgs);
			msgs = basicSetListType(newListType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.TYPE_LIST__LIST_TYPE, newListType, newListType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.TYPE_LIST__LIST_TYPE:
				return basicSetListType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataflowPackage.TYPE_LIST__ETYPE:
				return getEtype();
			case DataflowPackage.TYPE_LIST__BITS:
				return getBits();
			case DataflowPackage.TYPE_LIST__ELEMENTS:
				return getElements();
			case DataflowPackage.TYPE_LIST__LIST_TYPE:
				return getListType();
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
			case DataflowPackage.TYPE_LIST__ELEMENTS:
				setElements((Integer)newValue);
				return;
			case DataflowPackage.TYPE_LIST__LIST_TYPE:
				setListType((Type)newValue);
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
			case DataflowPackage.TYPE_LIST__ELEMENTS:
				setElements(ELEMENTS_EDEFAULT);
				return;
			case DataflowPackage.TYPE_LIST__LIST_TYPE:
				setListType((Type)null);
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
			case DataflowPackage.TYPE_LIST__ETYPE:
				return getEtype() != ETYPE_EDEFAULT;
			case DataflowPackage.TYPE_LIST__BITS:
				return getBits() != BITS_EDEFAULT;
			case DataflowPackage.TYPE_LIST__ELEMENTS:
				return elements != ELEMENTS_EDEFAULT;
			case DataflowPackage.TYPE_LIST__LIST_TYPE:
				return listType != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("list");
		b.append(" (elements: ");
		b.append(elements);
		b.append(", ");
		b.append("type: ");
		b.append(getListType().toString());
		b.append(")");
		return b.toString();
	}

} // TypeListImpl

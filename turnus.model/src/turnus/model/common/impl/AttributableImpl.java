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
package turnus.model.common.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.Attributable;
import turnus.model.common.CommonPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Attributable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link turnus.model.common.impl.AttributableImpl#getAttributesTable
 * <em>Attributes Table</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("unchecked")
public class AttributableImpl extends MinimalEObjectImpl.Container implements Attributable {

	/**
	 * The cached value of the '{@link #getAttributesTable() <em>Attributes
	 * Table</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getAttributesTable()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> attributesTable;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AttributableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE:
			if (coreType)
				return ((EMap.InternalMapView<String, Object>) getAttributesTable()).eMap();
			else
				return getAttributesTable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE:
			return ((InternalEList<?>) ((EMap.InternalMapView<String, Object>) getAttributesTable()).eMap())
					.basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE:
			return attributesTable != null && !attributesTable.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE:
			((EStructuralFeature.Setting) ((EMap.InternalMapView<String, Object>) getAttributesTable()).eMap())
					.set(newValue);
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
	protected EClass eStaticClass() {
		return CommonPackage.Literals.ATTRIBUTABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE:
			getAttributesTable().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Map<String, Object> getAttributesTable() {
		if (attributesTable == null) {
			attributesTable = new EcoreEMap<>(CommonPackage.Literals.STRING_TO_OBJECT_MAP,
					StringToObjectMapImpl.class, this, CommonPackage.ATTRIBUTABLE__ATTRIBUTES_TABLE);
		}
		return attributesTable.map();
	}

	@Override
	public <T> T getAttribute(String name) {
		return (T) getAttributesTable().get(name);
	}

	@Override
	public <T> T getAttribute(String name, T defaultValue) {
		T obj = getAttribute(name);
		return obj != null ? obj : defaultValue;
	}

	@Override
	public Iterable<String> getAttributeNames() {
		return Collections.unmodifiableSet(getAttributesTable().keySet());
	}

	@Override
	public boolean hasAttribute(String name) {
		return getAttributesTable().containsKey(name);
	}

	@Override
	public void removeAttributes() {
		getAttributesTable().clear();
	}

	@Override
	public boolean removeAttribute(String name) {
		return getAttributesTable().remove(name) != null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		getAttributesTable().put(name, value);
	}

	@Override
	public boolean hasAttributes() {
		return !getAttributesTable().isEmpty();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return new HashMap<>(getAttributes());
	}

} // AttributableImpl

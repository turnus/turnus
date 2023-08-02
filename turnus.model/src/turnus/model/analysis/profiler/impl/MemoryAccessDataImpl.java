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
package turnus.model.analysis.profiler.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.profiler.AccessData;
import turnus.model.analysis.profiler.MemoryAccessData;
import turnus.model.analysis.profiler.ProfilerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Access Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.MemoryAccessDataImpl#getAccessesData <em>Accesses Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MemoryAccessDataImpl extends MinimalEObjectImpl.Container implements MemoryAccessData {
	/**
	 * The cached value of the '{@link #getAccessesData() <em>Accesses Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessesData()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, AccessData> accessesData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryAccessDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.MEMORY_ACCESS_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, AccessData> getAccessesData() {
		if (accessesData == null) {
			accessesData = new EcoreEMap<String,AccessData>(ProfilerPackage.Literals.STRING_TO_ACCESS_DATA_MAP, StringToAccessDataMapImpl.class, this, ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA);
		}
		return accessesData.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA:
				return ((InternalEList<?>)((EMap.InternalMapView<String, AccessData>)getAccessesData()).eMap()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA:
				if (coreType) return ((EMap.InternalMapView<String, AccessData>)getAccessesData()).eMap();
				else return getAccessesData();
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
			case ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, AccessData>)getAccessesData()).eMap()).set(newValue);
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
			case ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA:
				getAccessesData().clear();
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
			case ProfilerPackage.MEMORY_ACCESS_DATA__ACCESSES_DATA:
				return accessesData != null && !accessesData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MemoryAccessDataImpl

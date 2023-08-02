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
package turnus.model.analysis.trace.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.util.MathUtils;
import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.GuardToLongMapImpl;
import turnus.model.analysis.trace.CompressedGuardDependency;
import turnus.model.analysis.trace.TracePackage;
import turnus.model.dataflow.Guard;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compressed Guard Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl#getEnableMap <em>Enable Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedGuardDependencyImpl#getDisableMap <em>Disable Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedGuardDependencyImpl extends CompressedDependencyImpl implements CompressedGuardDependency {
	/**
	 * The cached value of the '{@link #getEnableMap() <em>Enable Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEnableMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Guard, Long> enableMap;

	/**
	 * The cached value of the '{@link #getDisableMap() <em>Disable Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDisableMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Guard, Long> disableMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedGuardDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_GUARD_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Guard, Long> getEnableMap() {
		if (enableMap == null) {
			enableMap = new EcoreEMap<Guard,Long>(MapPackage.Literals.GUARD_TO_LONG_MAP, GuardToLongMapImpl.class, this, TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP);
		}
		return enableMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Guard, Long> getDisableMap() {
		if (disableMap == null) {
			disableMap = new EcoreEMap<Guard,Long>(MapPackage.Literals.GUARD_TO_LONG_MAP, GuardToLongMapImpl.class, this, TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP);
		}
		return disableMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Guard, Long>)getEnableMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Guard, Long>)getDisableMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP:
				if (coreType) return ((EMap.InternalMapView<Guard, Long>)getEnableMap()).eMap();
				else return getEnableMap();
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP:
				if (coreType) return ((EMap.InternalMapView<Guard, Long>)getDisableMap()).eMap();
				else return getDisableMap();
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
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Guard, Long>)getEnableMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Guard, Long>)getDisableMap()).eMap()).set(newValue);
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
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP:
				getEnableMap().clear();
				return;
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP:
				getDisableMap().clear();
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
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__ENABLE_MAP:
				return enableMap != null && !enableMap.isEmpty();
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY__DISABLE_MAP:
				return disableMap != null && !disableMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getCount() {
		long count = 0;
		count += MathUtils.sumLong(getDisableMap());
		count += MathUtils.sumLong(getEnableMap());
		return count;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setCount(long newCount) {

	}

} // CompressedGuardDependencyImpl

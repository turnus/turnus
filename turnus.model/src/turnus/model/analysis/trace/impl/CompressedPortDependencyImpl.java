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

import turnus.model.analysis.map.impl.PortToLongMapImpl;

import turnus.model.analysis.trace.CompressedPortDependency;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compressed Port Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedPortDependencyImpl#getReadMap <em>Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedPortDependencyImpl#getWriteMap <em>Write Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedPortDependencyImpl extends CompressedDependencyImpl implements CompressedPortDependency {
	/**
	 * The cached value of the '{@link #getReadMap() <em>Read Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Port, Long> readMap;

	/**
	 * The cached value of the '{@link #getWriteMap() <em>Write Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Port, Long> writeMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedPortDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_PORT_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Port, Long> getReadMap() {
		if (readMap == null) {
			readMap = new EcoreEMap<Port,Long>(MapPackage.Literals.PORT_TO_LONG_MAP, PortToLongMapImpl.class, this, TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP);
		}
		return readMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Port, Long> getWriteMap() {
		if (writeMap == null) {
			writeMap = new EcoreEMap<Port,Long>(MapPackage.Literals.PORT_TO_LONG_MAP, PortToLongMapImpl.class, this, TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP);
		}
		return writeMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Port, Long>)getReadMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Port, Long>)getWriteMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP:
				if (coreType) return ((EMap.InternalMapView<Port, Long>)getReadMap()).eMap();
				else return getReadMap();
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP:
				if (coreType) return ((EMap.InternalMapView<Port, Long>)getWriteMap()).eMap();
				else return getWriteMap();
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
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Port, Long>)getReadMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Port, Long>)getWriteMap()).eMap()).set(newValue);
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
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP:
				getReadMap().clear();
				return;
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP:
				getWriteMap().clear();
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
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__READ_MAP:
				return readMap != null && !readMap.isEmpty();
			case TracePackage.COMPRESSED_PORT_DEPENDENCY__WRITE_MAP:
				return writeMap != null && !writeMap.isEmpty();
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
		count += MathUtils.sumLong(getReadMap());
		count += MathUtils.sumLong(getWriteMap());
		return count;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setCount(long newCount) {

	}

} //CompressedPortDependencyImpl

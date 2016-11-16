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

import turnus.model.analysis.map.impl.VariableToLongMapImpl;

import turnus.model.analysis.trace.CompressedVariableDependency;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Variable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compressed Variable Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl#getReadReadMap <em>Read Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl#getReadWriteMap <em>Read Write Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl#getWriteReadMap <em>Write Read Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedVariableDependencyImpl#getWriteWriteMap <em>Write Write Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedVariableDependencyImpl extends CompressedDependencyImpl implements CompressedVariableDependency {
	/**
	 * The cached value of the '{@link #getReadReadMap() <em>Read Read Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReadReadMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, Long> readReadMap;

	/**
	 * The cached value of the '{@link #getReadWriteMap()
	 * <em>Read Write Map</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getReadWriteMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, Long> readWriteMap;

	/**
	 * The cached value of the '{@link #getWriteReadMap()
	 * <em>Write Read Map</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getWriteReadMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, Long> writeReadMap;

	/**
	 * The cached value of the '{@link #getWriteWriteMap()
	 * <em>Write Write Map</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getWriteWriteMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, Long> writeWriteMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedVariableDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_VARIABLE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Variable, Long> getReadReadMap() {
		if (readReadMap == null) {
			readReadMap = new EcoreEMap<Variable,Long>(MapPackage.Literals.VARIABLE_TO_LONG_MAP, VariableToLongMapImpl.class, this, TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP);
		}
		return readReadMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Variable, Long> getReadWriteMap() {
		if (readWriteMap == null) {
			readWriteMap = new EcoreEMap<Variable,Long>(MapPackage.Literals.VARIABLE_TO_LONG_MAP, VariableToLongMapImpl.class, this, TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP);
		}
		return readWriteMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Variable, Long> getWriteReadMap() {
		if (writeReadMap == null) {
			writeReadMap = new EcoreEMap<Variable,Long>(MapPackage.Literals.VARIABLE_TO_LONG_MAP, VariableToLongMapImpl.class, this, TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP);
		}
		return writeReadMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Variable, Long> getWriteWriteMap() {
		if (writeWriteMap == null) {
			writeWriteMap = new EcoreEMap<Variable,Long>(MapPackage.Literals.VARIABLE_TO_LONG_MAP, VariableToLongMapImpl.class, this, TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP);
		}
		return writeWriteMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, Long>)getReadReadMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, Long>)getReadWriteMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, Long>)getWriteReadMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Variable, Long>)getWriteWriteMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP:
				if (coreType) return ((EMap.InternalMapView<Variable, Long>)getReadReadMap()).eMap();
				else return getReadReadMap();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP:
				if (coreType) return ((EMap.InternalMapView<Variable, Long>)getReadWriteMap()).eMap();
				else return getReadWriteMap();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP:
				if (coreType) return ((EMap.InternalMapView<Variable, Long>)getWriteReadMap()).eMap();
				else return getWriteReadMap();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP:
				if (coreType) return ((EMap.InternalMapView<Variable, Long>)getWriteWriteMap()).eMap();
				else return getWriteWriteMap();
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
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, Long>)getReadReadMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, Long>)getReadWriteMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, Long>)getWriteReadMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Variable, Long>)getWriteWriteMap()).eMap()).set(newValue);
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
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP:
				getReadReadMap().clear();
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP:
				getReadWriteMap().clear();
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP:
				getWriteReadMap().clear();
				return;
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP:
				getWriteWriteMap().clear();
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
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_READ_MAP:
				return readReadMap != null && !readReadMap.isEmpty();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__READ_WRITE_MAP:
				return readWriteMap != null && !readWriteMap.isEmpty();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_READ_MAP:
				return writeReadMap != null && !writeReadMap.isEmpty();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY__WRITE_WRITE_MAP:
				return writeWriteMap != null && !writeWriteMap.isEmpty();
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
		count += MathUtils.sumLong(getReadReadMap());
		count += MathUtils.sumLong(getReadWriteMap());
		count += MathUtils.sumLong(getWriteReadMap());
		count += MathUtils.sumLong(getWriteWriteMap());
		return count;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setCount(long newCount) {

	}

} // CompressedVariableDependencyImpl

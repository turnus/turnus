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

import turnus.model.analysis.map.impl.BufferToLongMapImpl;
import turnus.model.analysis.map.impl.BufferToStatisticalDataMapImpl;

import turnus.model.analysis.trace.CompressedTokensDependency;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compressed Tokens Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl#getCountMap <em>Count Map</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTokensDependencyImpl#getTokensMap <em>Tokens Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedTokensDependencyImpl extends CompressedDependencyImpl implements CompressedTokensDependency {
	/**
	 * The cached value of the '{@link #getCountMap() <em>Count Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCountMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Long> countMap;

	/**
	 * The cached value of the '{@link #getTokensMap() <em>Tokens Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTokensMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, StatisticalData> tokensMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedTokensDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_TOKENS_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Buffer, Long> getCountMap() {
		if (countMap == null) {
			countMap = new EcoreEMap<Buffer,Long>(MapPackage.Literals.BUFFER_TO_LONG_MAP, BufferToLongMapImpl.class, this, TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP);
		}
		return countMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Buffer, StatisticalData> getTokensMap() {
		if (tokensMap == null) {
			tokensMap = new EcoreEMap<Buffer,StatisticalData>(MapPackage.Literals.BUFFER_TO_STATISTICAL_DATA_MAP, BufferToStatisticalDataMapImpl.class, this, TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP);
		}
		return tokensMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Long>)getCountMap()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, StatisticalData>)getTokensMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP:
				if (coreType) return ((EMap.InternalMapView<Buffer, Long>)getCountMap()).eMap();
				else return getCountMap();
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP:
				if (coreType) return ((EMap.InternalMapView<Buffer, StatisticalData>)getTokensMap()).eMap();
				else return getTokensMap();
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
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Long>)getCountMap()).eMap()).set(newValue);
				return;
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, StatisticalData>)getTokensMap()).eMap()).set(newValue);
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
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP:
				getCountMap().clear();
				return;
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP:
				getTokensMap().clear();
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
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__COUNT_MAP:
				return countMap != null && !countMap.isEmpty();
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY__TOKENS_MAP:
				return tokensMap != null && !tokensMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getCount() {
		return MathUtils.sumLong(getCountMap());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setCount(long newCount) {

	}

} // CompressedTokensDependencyImpl

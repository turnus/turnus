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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.StringToIntegerMapImpl;

import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.ProfilerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.CodeDataImpl#getOperatorsCount <em>Operators Count</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.CodeDataImpl#getOperandsCount <em>Operands Count</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.CodeDataImpl#getBlockName <em>Block Name</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.CodeDataImpl#getNol <em>Nol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeDataImpl extends MinimalEObjectImpl.Container implements CodeData {
	/**
	 * The cached value of the '{@link #getOperatorsCount() <em>Operators Count</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorsCount()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Integer> operatorsCount;

	/**
	 * The cached value of the '{@link #getOperandsCount() <em>Operands Count</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperandsCount()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Integer> operandsCount;

	/**
	 * The default value of the '{@link #getBlockName() <em>Block Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockName()
	 * @generated
	 * @ordered
	 */
	protected static final String BLOCK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBlockName() <em>Block Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockName()
	 * @generated
	 * @ordered
	 */
	protected String blockName = BLOCK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNol() <em>Nol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNol()
	 * @generated
	 * @ordered
	 */
	protected static final long NOL_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getNol() <em>Nol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNol()
	 * @generated
	 * @ordered
	 */
	protected long nol = NOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.CODE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Integer> getOperatorsCount() {
		if (operatorsCount == null) {
			operatorsCount = new EcoreEMap<String,Integer>(MapPackage.Literals.STRING_TO_INTEGER_MAP, StringToIntegerMapImpl.class, this, ProfilerPackage.CODE_DATA__OPERATORS_COUNT);
		}
		return operatorsCount.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<String, Integer> getOperandsCount() {
		if (operandsCount == null) {
			operandsCount = new EcoreEMap<String,Integer>(MapPackage.Literals.STRING_TO_INTEGER_MAP, StringToIntegerMapImpl.class, this, ProfilerPackage.CODE_DATA__OPERANDS_COUNT);
		}
		return operandsCount.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBlockName() {
		return blockName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlockName(String newBlockName) {
		String oldBlockName = blockName;
		blockName = newBlockName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.CODE_DATA__BLOCK_NAME, oldBlockName, blockName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNol() {
		return nol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNol(long newNol) {
		long oldNol = nol;
		nol = newNol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.CODE_DATA__NOL, oldNol, nol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.CODE_DATA__OPERATORS_COUNT:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Integer>)getOperatorsCount()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.CODE_DATA__OPERANDS_COUNT:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Integer>)getOperandsCount()).eMap()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.CODE_DATA__OPERATORS_COUNT:
				if (coreType) return ((EMap.InternalMapView<String, Integer>)getOperatorsCount()).eMap();
				else return getOperatorsCount();
			case ProfilerPackage.CODE_DATA__OPERANDS_COUNT:
				if (coreType) return ((EMap.InternalMapView<String, Integer>)getOperandsCount()).eMap();
				else return getOperandsCount();
			case ProfilerPackage.CODE_DATA__BLOCK_NAME:
				return getBlockName();
			case ProfilerPackage.CODE_DATA__NOL:
				return getNol();
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
			case ProfilerPackage.CODE_DATA__OPERATORS_COUNT:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Integer>)getOperatorsCount()).eMap()).set(newValue);
				return;
			case ProfilerPackage.CODE_DATA__OPERANDS_COUNT:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Integer>)getOperandsCount()).eMap()).set(newValue);
				return;
			case ProfilerPackage.CODE_DATA__BLOCK_NAME:
				setBlockName((String)newValue);
				return;
			case ProfilerPackage.CODE_DATA__NOL:
				setNol((Long)newValue);
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
			case ProfilerPackage.CODE_DATA__OPERATORS_COUNT:
				getOperatorsCount().clear();
				return;
			case ProfilerPackage.CODE_DATA__OPERANDS_COUNT:
				getOperandsCount().clear();
				return;
			case ProfilerPackage.CODE_DATA__BLOCK_NAME:
				setBlockName(BLOCK_NAME_EDEFAULT);
				return;
			case ProfilerPackage.CODE_DATA__NOL:
				setNol(NOL_EDEFAULT);
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
			case ProfilerPackage.CODE_DATA__OPERATORS_COUNT:
				return operatorsCount != null && !operatorsCount.isEmpty();
			case ProfilerPackage.CODE_DATA__OPERANDS_COUNT:
				return operandsCount != null && !operandsCount.isEmpty();
			case ProfilerPackage.CODE_DATA__BLOCK_NAME:
				return BLOCK_NAME_EDEFAULT == null ? blockName != null : !BLOCK_NAME_EDEFAULT.equals(blockName);
			case ProfilerPackage.CODE_DATA__NOL:
				return nol != NOL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (blockName: ");
		result.append(blockName);
		result.append(", nol: ");
		result.append(nol);
		result.append(')');
		return result.toString();
	}

} //CodeDataImpl

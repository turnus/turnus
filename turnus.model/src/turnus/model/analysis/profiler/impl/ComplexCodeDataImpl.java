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

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.ComplexCodeData;
import turnus.model.analysis.profiler.ProfilerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Complex Code Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexCodeDataImpl#getActionsData <em>Actions Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ComplexCodeDataImpl#getProceduresData <em>Procedures Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexCodeDataImpl extends CodeDataImpl implements ComplexCodeData {
	/**
	 * The cached value of the '{@link #getActionsData() <em>Actions Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionsData()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeData> actionsData;

	/**
	 * The cached value of the '{@link #getProceduresData() <em>Procedures Data</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProceduresData()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeData> proceduresData;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexCodeDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.COMPLEX_CODE_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CodeData> getActionsData() {
		if (actionsData == null) {
			actionsData = new EObjectContainmentEList<CodeData>(CodeData.class, this, ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA);
		}
		return actionsData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CodeData> getProceduresData() {
		if (proceduresData == null) {
			proceduresData = new EObjectResolvingEList<CodeData>(CodeData.class, this, ProfilerPackage.COMPLEX_CODE_DATA__PROCEDURES_DATA);
		}
		return proceduresData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CodeData getActionData(String action) {
		for (CodeData data : getActionsData()) {
			if (action.equals(data.getBlockName())) {
				return data;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CodeData getProcedureData(String procedure) {
		for (CodeData data : getProceduresData()) {
			if (procedure.equals(data.getBlockName())) {
				return data;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA:
				return ((InternalEList<?>)getActionsData()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA:
				return getActionsData();
			case ProfilerPackage.COMPLEX_CODE_DATA__PROCEDURES_DATA:
				return getProceduresData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA:
				getActionsData().clear();
				getActionsData().addAll((Collection<? extends CodeData>)newValue);
				return;
			case ProfilerPackage.COMPLEX_CODE_DATA__PROCEDURES_DATA:
				getProceduresData().clear();
				getProceduresData().addAll((Collection<? extends CodeData>)newValue);
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
			case ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA:
				getActionsData().clear();
				return;
			case ProfilerPackage.COMPLEX_CODE_DATA__PROCEDURES_DATA:
				getProceduresData().clear();
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
			case ProfilerPackage.COMPLEX_CODE_DATA__ACTIONS_DATA:
				return actionsData != null && !actionsData.isEmpty();
			case ProfilerPackage.COMPLEX_CODE_DATA__PROCEDURES_DATA:
				return proceduresData != null && !proceduresData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ProfilerPackage.COMPLEX_CODE_DATA___GET_ACTION_DATA__STRING:
				return getActionData((String)arguments.get(0));
			case ProfilerPackage.COMPLEX_CODE_DATA___GET_PROCEDURE_DATA__STRING:
				return getProcedureData((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ComplexCodeDataImpl

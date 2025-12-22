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
package turnus.model.architecture.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.architecture.ArchitecturePackage;
import turnus.model.architecture.Link;
import turnus.model.architecture.ProcessingUnit;

import turnus.model.common.EOperator;
import turnus.model.common.EType;

import turnus.model.common.impl.AttributableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getFamily <em>Family</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getClockPeriod <em>Clock Period</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ProcessingUnitImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProcessingUnitImpl extends AttributableImpl implements ProcessingUnit {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EType> types;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<EOperator> operators;

	/**
	 * The default value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFamily() <em>Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected String family = FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClockPeriod() <em>Clock Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final double CLOCK_PERIOD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getClockPeriod() <em>Clock Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriod()
	 * @generated
	 * @ordered
	 */
	protected double clockPeriod = CLOCK_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.PROCESSING_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.PROCESSING_UNIT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Link> getLinks() {
		if (links == null) {
			links = new EObjectWithInverseResolvingEList<Link>(Link.class, this, ArchitecturePackage.PROCESSING_UNIT__LINKS, ArchitecturePackage.LINK__PROCESSING_UNIT);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<EType> getTypes() {
		if (types == null) {
			types = new EDataTypeUniqueEList<EType>(EType.class, this, ArchitecturePackage.PROCESSING_UNIT__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<EOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeUniqueEList<EOperator>(EOperator.class, this, ArchitecturePackage.PROCESSING_UNIT__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamily(String newFamily) {
		String oldFamily = family;
		family = newFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.PROCESSING_UNIT__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClockPeriod() {
		return clockPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockPeriod(double newClockPeriod) {
		double oldClockPeriod = clockPeriod;
		clockPeriod = newClockPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.PROCESSING_UNIT__CLOCK_PERIOD, oldClockPeriod, clockPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		// TODO: implement this method to return the 'Class Name' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case ArchitecturePackage.PROCESSING_UNIT__NAME:
				return getName();
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				return getLinks();
			case ArchitecturePackage.PROCESSING_UNIT__TYPES:
				return getTypes();
			case ArchitecturePackage.PROCESSING_UNIT__OPERATORS:
				return getOperators();
			case ArchitecturePackage.PROCESSING_UNIT__FAMILY:
				return getFamily();
			case ArchitecturePackage.PROCESSING_UNIT__CLOCK_PERIOD:
				return getClockPeriod();
			case ArchitecturePackage.PROCESSING_UNIT__CLASS_NAME:
				return getClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturePackage.PROCESSING_UNIT__NAME:
				setName((String)newValue);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends EType>)newValue);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends EOperator>)newValue);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__FAMILY:
				setFamily((String)newValue);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__CLOCK_PERIOD:
				setClockPeriod((Double)newValue);
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
			case ArchitecturePackage.PROCESSING_UNIT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				getLinks().clear();
				return;
			case ArchitecturePackage.PROCESSING_UNIT__TYPES:
				getTypes().clear();
				return;
			case ArchitecturePackage.PROCESSING_UNIT__OPERATORS:
				getOperators().clear();
				return;
			case ArchitecturePackage.PROCESSING_UNIT__FAMILY:
				setFamily(FAMILY_EDEFAULT);
				return;
			case ArchitecturePackage.PROCESSING_UNIT__CLOCK_PERIOD:
				setClockPeriod(CLOCK_PERIOD_EDEFAULT);
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
			case ArchitecturePackage.PROCESSING_UNIT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturePackage.PROCESSING_UNIT__LINKS:
				return links != null && !links.isEmpty();
			case ArchitecturePackage.PROCESSING_UNIT__TYPES:
				return types != null && !types.isEmpty();
			case ArchitecturePackage.PROCESSING_UNIT__OPERATORS:
				return operators != null && !operators.isEmpty();
			case ArchitecturePackage.PROCESSING_UNIT__FAMILY:
				return FAMILY_EDEFAULT == null ? family != null : !FAMILY_EDEFAULT.equals(family);
			case ArchitecturePackage.PROCESSING_UNIT__CLOCK_PERIOD:
				return clockPeriod != CLOCK_PERIOD_EDEFAULT;
			case ArchitecturePackage.PROCESSING_UNIT__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? getClassName() != null : !CLASS_NAME_EDEFAULT.equals(getClassName());
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", types: ");
		result.append(types);
		result.append(", operators: ");
		result.append(operators);
		result.append(", family: ");
		result.append(family);
		result.append(", clockPeriod: ");
		result.append(clockPeriod);
		result.append(')');
		return result.toString();
	}

} //ProcessingUnitImpl

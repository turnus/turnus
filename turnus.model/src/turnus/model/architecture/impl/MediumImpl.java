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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.architecture.ArchitecturePackage;
import turnus.model.architecture.Link;
import turnus.model.architecture.Medium;

import turnus.model.common.impl.AttributableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Medium</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getClockPeriodIn <em>Clock Period In</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getClockPeriodOut <em>Clock Period Out</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getMaxBitPop <em>Max Bit Pop</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getMaxBitPush <em>Max Bit Push</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.MediumImpl#getMaxBitSize <em>Max Bit Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MediumImpl extends AttributableImpl implements Medium {
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
	 * The default value of the '{@link #getClockPeriodIn() <em>Clock Period In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriodIn()
	 * @generated
	 * @ordered
	 */
	protected static final double CLOCK_PERIOD_IN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getClockPeriodIn() <em>Clock Period In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriodIn()
	 * @generated
	 * @ordered
	 */
	protected double clockPeriodIn = CLOCK_PERIOD_IN_EDEFAULT;

	/**
	 * The default value of the '{@link #getClockPeriodOut() <em>Clock Period Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriodOut()
	 * @generated
	 * @ordered
	 */
	protected static final double CLOCK_PERIOD_OUT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getClockPeriodOut() <em>Clock Period Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockPeriodOut()
	 * @generated
	 * @ordered
	 */
	protected double clockPeriodOut = CLOCK_PERIOD_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBitPop() <em>Max Bit Pop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitPop()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BIT_POP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBitPop() <em>Max Bit Pop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitPop()
	 * @generated
	 * @ordered
	 */
	protected int maxBitPop = MAX_BIT_POP_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBitPush() <em>Max Bit Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitPush()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BIT_PUSH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBitPush() <em>Max Bit Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitPush()
	 * @generated
	 * @ordered
	 */
	protected int maxBitPush = MAX_BIT_PUSH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBitSize() <em>Max Bit Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitSize()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BIT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBitSize() <em>Max Bit Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBitSize()
	 * @generated
	 * @ordered
	 */
	protected int maxBitSize = MAX_BIT_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.MEDIUM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Link> getLinks() {
		if (links == null) {
			links = new EObjectWithInverseResolvingEList<Link>(Link.class, this, ArchitecturePackage.MEDIUM__LINKS, ArchitecturePackage.LINK__MEDIUM);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClockPeriodIn() {
		return clockPeriodIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockPeriodIn(double newClockPeriodIn) {
		double oldClockPeriodIn = clockPeriodIn;
		clockPeriodIn = newClockPeriodIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__CLOCK_PERIOD_IN, oldClockPeriodIn, clockPeriodIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClockPeriodOut() {
		return clockPeriodOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClockPeriodOut(double newClockPeriodOut) {
		double oldClockPeriodOut = clockPeriodOut;
		clockPeriodOut = newClockPeriodOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__CLOCK_PERIOD_OUT, oldClockPeriodOut, clockPeriodOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBitPop() {
		return maxBitPop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBitPop(int newMaxBitPop) {
		int oldMaxBitPop = maxBitPop;
		maxBitPop = newMaxBitPop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__MAX_BIT_POP, oldMaxBitPop, maxBitPop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBitPush() {
		return maxBitPush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBitPush(int newMaxBitPush) {
		int oldMaxBitPush = maxBitPush;
		maxBitPush = newMaxBitPush;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__MAX_BIT_PUSH, oldMaxBitPush, maxBitPush));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBitSize() {
		return maxBitSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBitSize(int newMaxBitSize) {
		int oldMaxBitSize = maxBitSize;
		maxBitSize = newMaxBitSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.MEDIUM__MAX_BIT_SIZE, oldMaxBitSize, maxBitSize));
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
			case ArchitecturePackage.MEDIUM__LINKS:
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
			case ArchitecturePackage.MEDIUM__LINKS:
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
			case ArchitecturePackage.MEDIUM__NAME:
				return getName();
			case ArchitecturePackage.MEDIUM__LINKS:
				return getLinks();
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_IN:
				return getClockPeriodIn();
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_OUT:
				return getClockPeriodOut();
			case ArchitecturePackage.MEDIUM__MAX_BIT_POP:
				return getMaxBitPop();
			case ArchitecturePackage.MEDIUM__MAX_BIT_PUSH:
				return getMaxBitPush();
			case ArchitecturePackage.MEDIUM__MAX_BIT_SIZE:
				return getMaxBitSize();
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
			case ArchitecturePackage.MEDIUM__NAME:
				setName((String)newValue);
				return;
			case ArchitecturePackage.MEDIUM__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_IN:
				setClockPeriodIn((Double)newValue);
				return;
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_OUT:
				setClockPeriodOut((Double)newValue);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_POP:
				setMaxBitPop((Integer)newValue);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_PUSH:
				setMaxBitPush((Integer)newValue);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_SIZE:
				setMaxBitSize((Integer)newValue);
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
			case ArchitecturePackage.MEDIUM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturePackage.MEDIUM__LINKS:
				getLinks().clear();
				return;
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_IN:
				setClockPeriodIn(CLOCK_PERIOD_IN_EDEFAULT);
				return;
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_OUT:
				setClockPeriodOut(CLOCK_PERIOD_OUT_EDEFAULT);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_POP:
				setMaxBitPop(MAX_BIT_POP_EDEFAULT);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_PUSH:
				setMaxBitPush(MAX_BIT_PUSH_EDEFAULT);
				return;
			case ArchitecturePackage.MEDIUM__MAX_BIT_SIZE:
				setMaxBitSize(MAX_BIT_SIZE_EDEFAULT);
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
			case ArchitecturePackage.MEDIUM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturePackage.MEDIUM__LINKS:
				return links != null && !links.isEmpty();
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_IN:
				return clockPeriodIn != CLOCK_PERIOD_IN_EDEFAULT;
			case ArchitecturePackage.MEDIUM__CLOCK_PERIOD_OUT:
				return clockPeriodOut != CLOCK_PERIOD_OUT_EDEFAULT;
			case ArchitecturePackage.MEDIUM__MAX_BIT_POP:
				return maxBitPop != MAX_BIT_POP_EDEFAULT;
			case ArchitecturePackage.MEDIUM__MAX_BIT_PUSH:
				return maxBitPush != MAX_BIT_PUSH_EDEFAULT;
			case ArchitecturePackage.MEDIUM__MAX_BIT_SIZE:
				return maxBitSize != MAX_BIT_SIZE_EDEFAULT;
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
		result.append(", clockPeriodIn: ");
		result.append(clockPeriodIn);
		result.append(", clockPeriodOut: ");
		result.append(clockPeriodOut);
		result.append(", maxBitPop: ");
		result.append(maxBitPop);
		result.append(", maxBitPush: ");
		result.append(maxBitPush);
		result.append(", maxBitSize: ");
		result.append(maxBitSize);
		result.append(')');
		return result.toString();
	}

} //MediumImpl

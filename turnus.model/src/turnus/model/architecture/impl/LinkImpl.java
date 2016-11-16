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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import turnus.model.architecture.ArchitecturePackage;
import turnus.model.architecture.Link;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;

import turnus.model.common.impl.AttributableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.impl.LinkImpl#getProcessingUnit <em>Processing Unit</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.LinkImpl#getMedium <em>Medium</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkImpl extends AttributableImpl implements Link {
	/**
	 * The cached value of the '{@link #getProcessingUnit() <em>Processing Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingUnit()
	 * @generated
	 * @ordered
	 */
	protected ProcessingUnit processingUnit;

	/**
	 * The cached value of the '{@link #getMedium() <em>Medium</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMedium()
	 * @generated
	 * @ordered
	 */
	protected Medium medium;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingUnit getProcessingUnit() {
		if (processingUnit != null && processingUnit.eIsProxy()) {
			InternalEObject oldProcessingUnit = (InternalEObject)processingUnit;
			processingUnit = (ProcessingUnit)eResolveProxy(oldProcessingUnit);
			if (processingUnit != oldProcessingUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.LINK__PROCESSING_UNIT, oldProcessingUnit, processingUnit));
			}
		}
		return processingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingUnit basicGetProcessingUnit() {
		return processingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingUnit(ProcessingUnit newProcessingUnit, NotificationChain msgs) {
		ProcessingUnit oldProcessingUnit = processingUnit;
		processingUnit = newProcessingUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LINK__PROCESSING_UNIT, oldProcessingUnit, newProcessingUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingUnit(ProcessingUnit newProcessingUnit) {
		if (newProcessingUnit != processingUnit) {
			NotificationChain msgs = null;
			if (processingUnit != null)
				msgs = ((InternalEObject)processingUnit).eInverseRemove(this, ArchitecturePackage.PROCESSING_UNIT__LINKS, ProcessingUnit.class, msgs);
			if (newProcessingUnit != null)
				msgs = ((InternalEObject)newProcessingUnit).eInverseAdd(this, ArchitecturePackage.PROCESSING_UNIT__LINKS, ProcessingUnit.class, msgs);
			msgs = basicSetProcessingUnit(newProcessingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LINK__PROCESSING_UNIT, newProcessingUnit, newProcessingUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Medium getMedium() {
		if (medium != null && medium.eIsProxy()) {
			InternalEObject oldMedium = (InternalEObject)medium;
			medium = (Medium)eResolveProxy(oldMedium);
			if (medium != oldMedium) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.LINK__MEDIUM, oldMedium, medium));
			}
		}
		return medium;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Medium basicGetMedium() {
		return medium;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMedium(Medium newMedium, NotificationChain msgs) {
		Medium oldMedium = medium;
		medium = newMedium;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LINK__MEDIUM, oldMedium, newMedium);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMedium(Medium newMedium) {
		if (newMedium != medium) {
			NotificationChain msgs = null;
			if (medium != null)
				msgs = ((InternalEObject)medium).eInverseRemove(this, ArchitecturePackage.MEDIUM__LINKS, Medium.class, msgs);
			if (newMedium != null)
				msgs = ((InternalEObject)newMedium).eInverseAdd(this, ArchitecturePackage.MEDIUM__LINKS, Medium.class, msgs);
			msgs = basicSetMedium(newMedium, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LINK__MEDIUM, newMedium, newMedium));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				if (processingUnit != null)
					msgs = ((InternalEObject)processingUnit).eInverseRemove(this, ArchitecturePackage.PROCESSING_UNIT__LINKS, ProcessingUnit.class, msgs);
				return basicSetProcessingUnit((ProcessingUnit)otherEnd, msgs);
			case ArchitecturePackage.LINK__MEDIUM:
				if (medium != null)
					msgs = ((InternalEObject)medium).eInverseRemove(this, ArchitecturePackage.MEDIUM__LINKS, Medium.class, msgs);
				return basicSetMedium((Medium)otherEnd, msgs);
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
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				return basicSetProcessingUnit(null, msgs);
			case ArchitecturePackage.LINK__MEDIUM:
				return basicSetMedium(null, msgs);
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
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				if (resolve) return getProcessingUnit();
				return basicGetProcessingUnit();
			case ArchitecturePackage.LINK__MEDIUM:
				if (resolve) return getMedium();
				return basicGetMedium();
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
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				setProcessingUnit((ProcessingUnit)newValue);
				return;
			case ArchitecturePackage.LINK__MEDIUM:
				setMedium((Medium)newValue);
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
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				setProcessingUnit((ProcessingUnit)null);
				return;
			case ArchitecturePackage.LINK__MEDIUM:
				setMedium((Medium)null);
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
			case ArchitecturePackage.LINK__PROCESSING_UNIT:
				return processingUnit != null;
			case ArchitecturePackage.LINK__MEDIUM:
				return medium != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkImpl

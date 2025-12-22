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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.architecture.Architecture;
import turnus.model.architecture.ArchitecturePackage;
import turnus.model.architecture.Link;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;
import turnus.model.architecture.util.ArchitectureAdapter;
import turnus.model.common.impl.AttributableImpl;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Architecture</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.architecture.impl.ArchitectureImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ArchitectureImpl#getMedia <em>Media</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ArchitectureImpl#getProcessingUnits <em>Processing Units</em>}</li>
 *   <li>{@link turnus.model.architecture.impl.ArchitectureImpl#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchitectureImpl extends AttributableImpl implements Architecture {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMedia() <em>Media</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMedia()
	 * @generated
	 * @ordered
	 */
	protected EList<Medium> media;

	/**
	 * The cached value of the '{@link #getProcessingUnits()
	 * <em>Processing Units</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProcessingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingUnit> processingUnits;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The map of processing-units and names
	 * 
	 * @see getProcessingUnit(String)
	 */
	private BiMap<String, ProcessingUnit> pusMap;

	/**
	 * The map of media and names
	 * 
	 * @see getMedia()
	 */
	private BiMap<String, Medium> mediumsMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ArchitectureImpl() {
		super();

		pusMap = HashBiMap.create();
		mediumsMap = HashBiMap.create();

		eAdapters().add(new ArchitectureAdapter(pusMap, mediumsMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Medium> getMedia() {
		if (media == null) {
			media = new EObjectContainmentEList<Medium>(Medium.class, this, ArchitecturePackage.ARCHITECTURE__MEDIA);
		}
		return media;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<ProcessingUnit> getProcessingUnits() {
		if (processingUnits == null) {
			processingUnits = new EObjectContainmentEList<ProcessingUnit>(ProcessingUnit.class, this, ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS);
		}
		return processingUnits;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, ArchitecturePackage.ARCHITECTURE__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ProcessingUnit getProcessingUnit(String name) {
		return pusMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Medium getMedium(String name) {
		return mediumsMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<ProcessingUnit> getProcessingUnits(String family) {
		List<ProcessingUnit> pus = new EObjectEList<ProcessingUnit>(
				ProcessingUnit.class, this,
				ArchitecturePackage.ARCHITECTURE___GET_PROCESSING_UNITS__STRING);

		for (ProcessingUnit pu : getProcessingUnits()) {
			if (family.equals(pu.getName())) {
				pus.add(pu);
			}
		}

		return pus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE__MEDIA:
				return ((InternalEList<?>)getMedia()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS:
				return ((InternalEList<?>)getProcessingUnits()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case ArchitecturePackage.ARCHITECTURE__NAME:
				return getName();
			case ArchitecturePackage.ARCHITECTURE__MEDIA:
				return getMedia();
			case ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS:
				return getProcessingUnits();
			case ArchitecturePackage.ARCHITECTURE__LINKS:
				return getLinks();
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
			case ArchitecturePackage.ARCHITECTURE__NAME:
				setName((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE__MEDIA:
				getMedia().clear();
				getMedia().addAll((Collection<? extends Medium>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS:
				getProcessingUnits().clear();
				getProcessingUnits().addAll((Collection<? extends ProcessingUnit>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
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
			case ArchitecturePackage.ARCHITECTURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE__MEDIA:
				getMedia().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS:
				getProcessingUnits().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE__LINKS:
				getLinks().clear();
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
			case ArchitecturePackage.ARCHITECTURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturePackage.ARCHITECTURE__MEDIA:
				return media != null && !media.isEmpty();
			case ArchitecturePackage.ARCHITECTURE__PROCESSING_UNITS:
				return processingUnits != null && !processingUnits.isEmpty();
			case ArchitecturePackage.ARCHITECTURE__LINKS:
				return links != null && !links.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case ArchitecturePackage.ARCHITECTURE___GET_PROCESSING_UNIT__STRING:
				return getProcessingUnit((String)arguments.get(0));
			case ArchitecturePackage.ARCHITECTURE___GET_MEDIUM__STRING:
				return getMedium((String)arguments.get(0));
			case ArchitecturePackage.ARCHITECTURE___GET_PROCESSING_UNITS__STRING:
				return getProcessingUnits((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ArchitectureImpl

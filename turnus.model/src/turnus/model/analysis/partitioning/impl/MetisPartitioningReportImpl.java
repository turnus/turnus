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
package turnus.model.analysis.partitioning.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.partitioning.MetisPartitioning;
import turnus.model.analysis.partitioning.MetisPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningPackage;

import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metis Partitioning Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getEdgeCut <em>Edge Cut</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getCommVolume <em>Comm Volume</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getObjtype <em>Objtype</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#getPtype <em>Ptype</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl#isContig <em>Contig</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetisPartitioningReportImpl extends MinimalEObjectImpl.Container implements MetisPartitioningReport {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The cached value of the '{@link #getPartitions() <em>Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<MetisPartitioning> partitions;

	/**
	 * The default value of the '{@link #getEdgeCut() <em>Edge Cut</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeCut()
	 * @generated
	 * @ordered
	 */
	protected static final int EDGE_CUT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getCommVolume() <em>Comm Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommVolume()
	 * @generated
	 * @ordered
	 */
	protected static final int COMM_VOLUME_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getObjtype() <em>Objtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjtype()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJTYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPtype() <em>Ptype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPtype()
	 * @generated
	 * @ordered
	 */
	protected static final String PTYPE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isContig() <em>Contig</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContig()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTIG_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetisPartitioningReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.METIS_PARTITIONING_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.METIS_PARTITIONING_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.METIS_PARTITIONING_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MetisPartitioning> getPartitions() {
		if (partitions == null) {
			partitions = new EObjectContainmentEList<MetisPartitioning>(MetisPartitioning.class, this, PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS);
		}
		return partitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEdgeCut() {
		// TODO: implement this method to return the 'Edge Cut' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCommVolume() {
		// TODO: implement this method to return the 'Comm Volume' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getObjtype() {
		// TODO: implement this method to return the 'Objtype' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPtype() {
		// TODO: implement this method to return the 'Ptype' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContig() {
		// TODO: implement this method to return the 'Contig' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS:
				return ((InternalEList<?>)getPartitions()).basicRemove(otherEnd, msgs);
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
			case PartitioningPackage.METIS_PARTITIONING_REPORT__ALGORITHM:
				return getAlgorithm();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__DATE:
				return getDate();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS:
				return getPartitions();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__EDGE_CUT:
				return getEdgeCut();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__COMM_VOLUME:
				return getCommVolume();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__OBJTYPE:
				return getObjtype();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PTYPE:
				return getPtype();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__CONTIG:
				return isContig();
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
			case PartitioningPackage.METIS_PARTITIONING_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS:
				getPartitions().clear();
				getPartitions().addAll((Collection<? extends MetisPartitioning>)newValue);
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
			case PartitioningPackage.METIS_PARTITIONING_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS:
				getPartitions().clear();
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
			case PartitioningPackage.METIS_PARTITIONING_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case PartitioningPackage.METIS_PARTITIONING_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case PartitioningPackage.METIS_PARTITIONING_REPORT__NETWORK:
				return network != null;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PARTITIONS:
				return partitions != null && !partitions.isEmpty();
			case PartitioningPackage.METIS_PARTITIONING_REPORT__EDGE_CUT:
				return getEdgeCut() != EDGE_CUT_EDEFAULT;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__COMM_VOLUME:
				return getCommVolume() != COMM_VOLUME_EDEFAULT;
			case PartitioningPackage.METIS_PARTITIONING_REPORT__OBJTYPE:
				return OBJTYPE_EDEFAULT == null ? getObjtype() != null : !OBJTYPE_EDEFAULT.equals(getObjtype());
			case PartitioningPackage.METIS_PARTITIONING_REPORT__PTYPE:
				return PTYPE_EDEFAULT == null ? getPtype() != null : !PTYPE_EDEFAULT.equals(getPtype());
			case PartitioningPackage.METIS_PARTITIONING_REPORT__CONTIG:
				return isContig() != CONTIG_EDEFAULT;
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
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //MetisPartitioningReportImpl

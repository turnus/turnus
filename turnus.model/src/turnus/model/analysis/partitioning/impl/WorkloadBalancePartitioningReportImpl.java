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
import turnus.model.analysis.partitioning.PartitioningPackage;
import turnus.model.analysis.partitioning.WorkloadBalancePartition;
import turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workload Balance Partitioning Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl#getPartitions <em>Partitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkloadBalancePartitioningReportImpl extends MinimalEObjectImpl.Container implements WorkloadBalancePartitioningReport {
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
	protected EList<WorkloadBalancePartition> partitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkloadBalancePartitioningReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.WORKLOAD_BALANCE_PARTITIONING_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE, oldDate, date));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<WorkloadBalancePartition> getPartitions() {
		if (partitions == null) {
			partitions = new EObjectContainmentEList<WorkloadBalancePartition>(WorkloadBalancePartition.class, this, PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS);
		}
		return partitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS:
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
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM:
				return getAlgorithm();
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE:
				return getDate();
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS:
				return getPartitions();
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
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS:
				getPartitions().clear();
				getPartitions().addAll((Collection<? extends WorkloadBalancePartition>)newValue);
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
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS:
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
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK:
				return network != null;
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS:
				return partitions != null && !partitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("\n[WORKLOAD BALANCE PARTITIONING REPORT]");
		b.append(String.format("\n Network.....: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithm..: %s", getAlgorithm()));
		b.append(String.format("\n Units.......: %s", getPartitions().size()));

		int partition = 1;
		for (WorkloadBalancePartition data : getPartitions()) {
			b.append(String.format("\n\nPartition (%d)", partition++));
			b.append("\n Actors:");
			StringBuffer actors = new StringBuffer();
			for (Actor actor : data.getActors()) {
				actors.append(", ").append(actor.getName());
			}
			b.append(actors.toString().replaceFirst(",", ""));
			b.append("\n Total workload: ").append(data.getWorkload());
		}

		b.append("\n\n");

		return b.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public NetworkPartitioning asNetworkPartitioning() {
		NetworkPartitioning partitioning = new NetworkPartitioning(getNetwork());
		int partition = 1;
		for (WorkloadBalancePartition data : getPartitions()) {
			String component = "p" + (partition++);
			for (Actor actor : data.getActors()) {
				partitioning.setPartition(actor, component);
			}
		}
		return partitioning;
	}

} //WorkloadBalancePartitioningReportImpl

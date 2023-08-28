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
package turnus.model.analysis.profiling.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.ProfilingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inter Partition Communication And Memory Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionCommunicationAndMemoryReportImpl#getPartitionData <em>Partition Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterPartitionCommunicationAndMemoryReportImpl extends MinimalEObjectImpl.Container implements InterPartitionCommunicationAndMemoryReport {
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
	 * The cached value of the '{@link #getPartitionData() <em>Partition Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionData()
	 * @generated
	 * @ordered
	 */
	protected InterPartitionData partitionData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterPartitionCommunicationAndMemoryReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterPartitionData getPartitionData() {
		return partitionData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPartitionData(InterPartitionData newPartitionData, NotificationChain msgs) {
		InterPartitionData oldPartitionData = partitionData;
		partitionData = newPartitionData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA, oldPartitionData, newPartitionData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitionData(InterPartitionData newPartitionData) {
		if (newPartitionData != partitionData) {
			NotificationChain msgs = null;
			if (partitionData != null)
				msgs = ((InternalEObject)partitionData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA, null, msgs);
			if (newPartitionData != null)
				msgs = ((InternalEObject)newPartitionData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA, null, msgs);
			msgs = basicSetPartitionData(newPartitionData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA, newPartitionData, newPartitionData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return basicSetPartitionData(null, msgs);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				return getAlgorithm();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				return getDate();
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return getPartitionData();
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				setPartitionData((InterPartitionData)newValue);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				setPartitionData((InterPartitionData)null);
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
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT__PARTITION_DATA:
				return partitionData != null;
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

} //InterPartitionCommunicationAndMemoryReportImpl

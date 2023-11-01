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

import turnus.model.analysis.profiling.LatencyData;
import turnus.model.analysis.profiling.LatencyReport;
import turnus.model.analysis.profiling.ProfilingPackage;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Latency Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getTime <em>Time</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getMappingFile <em>Mapping File</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getBufferFile <em>Buffer File</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getSource <em>Source</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.LatencyReportImpl#getNetwork <em>Network</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LatencyReportImpl extends MinimalEObjectImpl.Container implements LatencyReport {
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
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected double time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMappingFile() <em>Mapping File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPING_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappingFile() <em>Mapping File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingFile()
	 * @generated
	 * @ordered
	 */
	protected String mappingFile = MAPPING_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBufferFile() <em>Buffer File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferFile()
	 * @generated
	 * @ordered
	 */
	protected static final String BUFFER_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBufferFile() <em>Buffer File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferFile()
	 * @generated
	 * @ordered
	 */
	protected String bufferFile = BUFFER_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected LatencyData source;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<LatencyData> targets;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatencyReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.LATENCY_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTime(double newTime) {
		double oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMappingFile() {
		return mappingFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingFile(String newMappingFile) {
		String oldMappingFile = mappingFile;
		mappingFile = newMappingFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__MAPPING_FILE, oldMappingFile, mappingFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBufferFile() {
		return bufferFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBufferFile(String newBufferFile) {
		String oldBufferFile = bufferFile;
		bufferFile = newBufferFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__BUFFER_FILE, oldBufferFile, bufferFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LatencyData getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(LatencyData newSource, NotificationChain msgs) {
		LatencyData oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__SOURCE, oldSource, newSource);
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
	public void setSource(LatencyData newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.LATENCY_REPORT__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.LATENCY_REPORT__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<LatencyData> getTargets() {
		if (targets == null) {
			targets = new EObjectContainmentEList<LatencyData>(LatencyData.class, this, ProfilingPackage.LATENCY_REPORT__TARGETS);
		}
		return targets;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilingPackage.LATENCY_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.LATENCY_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilingPackage.LATENCY_REPORT__SOURCE:
				return basicSetSource(null, msgs);
			case ProfilingPackage.LATENCY_REPORT__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
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
			case ProfilingPackage.LATENCY_REPORT__ALGORITHM:
				return getAlgorithm();
			case ProfilingPackage.LATENCY_REPORT__DATE:
				return getDate();
			case ProfilingPackage.LATENCY_REPORT__TIME:
				return getTime();
			case ProfilingPackage.LATENCY_REPORT__MAPPING_FILE:
				return getMappingFile();
			case ProfilingPackage.LATENCY_REPORT__BUFFER_FILE:
				return getBufferFile();
			case ProfilingPackage.LATENCY_REPORT__SOURCE:
				return getSource();
			case ProfilingPackage.LATENCY_REPORT__TARGETS:
				return getTargets();
			case ProfilingPackage.LATENCY_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
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
			case ProfilingPackage.LATENCY_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__TIME:
				setTime((Double)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__MAPPING_FILE:
				setMappingFile((String)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__BUFFER_FILE:
				setBufferFile((String)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__SOURCE:
				setSource((LatencyData)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends LatencyData>)newValue);
				return;
			case ProfilingPackage.LATENCY_REPORT__NETWORK:
				setNetwork((Network)newValue);
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
			case ProfilingPackage.LATENCY_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case ProfilingPackage.LATENCY_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ProfilingPackage.LATENCY_REPORT__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case ProfilingPackage.LATENCY_REPORT__MAPPING_FILE:
				setMappingFile(MAPPING_FILE_EDEFAULT);
				return;
			case ProfilingPackage.LATENCY_REPORT__BUFFER_FILE:
				setBufferFile(BUFFER_FILE_EDEFAULT);
				return;
			case ProfilingPackage.LATENCY_REPORT__SOURCE:
				setSource((LatencyData)null);
				return;
			case ProfilingPackage.LATENCY_REPORT__TARGETS:
				getTargets().clear();
				return;
			case ProfilingPackage.LATENCY_REPORT__NETWORK:
				setNetwork((Network)null);
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
			case ProfilingPackage.LATENCY_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case ProfilingPackage.LATENCY_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ProfilingPackage.LATENCY_REPORT__TIME:
				return time != TIME_EDEFAULT;
			case ProfilingPackage.LATENCY_REPORT__MAPPING_FILE:
				return MAPPING_FILE_EDEFAULT == null ? mappingFile != null : !MAPPING_FILE_EDEFAULT.equals(mappingFile);
			case ProfilingPackage.LATENCY_REPORT__BUFFER_FILE:
				return BUFFER_FILE_EDEFAULT == null ? bufferFile != null : !BUFFER_FILE_EDEFAULT.equals(bufferFile);
			case ProfilingPackage.LATENCY_REPORT__SOURCE:
				return source != null;
			case ProfilingPackage.LATENCY_REPORT__TARGETS:
				return targets != null && !targets.isEmpty();
			case ProfilingPackage.LATENCY_REPORT__NETWORK:
				return network != null;
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
		result.append(", time: ");
		result.append(time);
		result.append(", mappingFile: ");
		result.append(mappingFile);
		result.append(", bufferFile: ");
		result.append(bufferFile);
		result.append(')');
		return result.toString();
	}

} //LatencyReportImpl

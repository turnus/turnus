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
package turnus.model.analysis.trace.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import turnus.model.analysis.trace.CompressedDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compressed Trace Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedTraceReportImpl#getTraceFile <em>Trace File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedTraceReportImpl extends MinimalEObjectImpl.Container implements CompressedTraceReport {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<CompressedStep> steps;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<CompressedDependency> dependencies;

	/**
	 * The default value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTraceFile() <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceFile()
	 * @generated
	 * @ordered
	 */
	protected String traceFile = TRACE_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedTraceReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_TRACE_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_TRACE_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_TRACE_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.COMPRESSED_TRACE_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_TRACE_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CompressedStep> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList<CompressedStep>(CompressedStep.class, this, TracePackage.COMPRESSED_TRACE_REPORT__STEPS);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CompressedDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<CompressedDependency>(CompressedDependency.class, this, TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTraceFile() {
		return traceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceFile(String newTraceFile) {
		String oldTraceFile = traceFile;
		traceFile = newTraceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_TRACE_REPORT__TRACE_FILE, oldTraceFile, traceFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CompressedStep getSteps(Action action) {
		CompressedStep step = null;
		for (CompressedStep s : getSteps()) {
			if (s.getAction() == action) {
				step = s;
				break;
			}
		}
		return step;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<CompressedStep> getSteps(Actor actor) {
		List<CompressedStep> steps = new ArrayList<>();
		for (CompressedStep s : getSteps()) {
			if (s.getAction().getOwner() == actor) {
				steps.add(s);
			}
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_TRACE_REPORT__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_TRACE_REPORT__ALGORITHM:
				return getAlgorithm();
			case TracePackage.COMPRESSED_TRACE_REPORT__DATE:
				return getDate();
			case TracePackage.COMPRESSED_TRACE_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case TracePackage.COMPRESSED_TRACE_REPORT__STEPS:
				return getSteps();
			case TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES:
				return getDependencies();
			case TracePackage.COMPRESSED_TRACE_REPORT__TRACE_FILE:
				return getTraceFile();
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
			case TracePackage.COMPRESSED_TRACE_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends CompressedStep>)newValue);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends CompressedDependency>)newValue);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__TRACE_FILE:
				setTraceFile((String)newValue);
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
			case TracePackage.COMPRESSED_TRACE_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__STEPS:
				getSteps().clear();
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES:
				getDependencies().clear();
				return;
			case TracePackage.COMPRESSED_TRACE_REPORT__TRACE_FILE:
				setTraceFile(TRACE_FILE_EDEFAULT);
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
			case TracePackage.COMPRESSED_TRACE_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case TracePackage.COMPRESSED_TRACE_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TracePackage.COMPRESSED_TRACE_REPORT__NETWORK:
				return network != null;
			case TracePackage.COMPRESSED_TRACE_REPORT__STEPS:
				return steps != null && !steps.isEmpty();
			case TracePackage.COMPRESSED_TRACE_REPORT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case TracePackage.COMPRESSED_TRACE_REPORT__TRACE_FILE:
				return TRACE_FILE_EDEFAULT == null ? traceFile != null : !TRACE_FILE_EDEFAULT.equals(traceFile);
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
			case TracePackage.COMPRESSED_TRACE_REPORT___GET_STEPS__ACTION:
				return getSteps((Action)arguments.get(0));
			case TracePackage.COMPRESSED_TRACE_REPORT___GET_STEPS__ACTOR:
				return getSteps((Actor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("\n[TRACE COMPRESSION ANALYSIS REPORT]\n");
		b.append(String.format("\n Network..........: %s", getNetwork().getName()));
		b.append(String.format("\n New graph size...: nodes=%d, edges=%d", getSteps().size(), getDependencies().size()));
		b.append("\n\n");
		return b.toString();
	}

} // CompressedTraceReportImpl

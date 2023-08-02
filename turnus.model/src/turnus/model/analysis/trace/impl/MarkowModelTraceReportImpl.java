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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.util.StringUtils;
import turnus.model.analysis.trace.MarkovModelActionData;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Markow Model Trace Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.MarkowModelTraceReportImpl#getActionsData <em>Actions Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkowModelTraceReportImpl extends MinimalEObjectImpl.Container implements MarkowModelTraceReport {
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
	 * The cached value of the '{@link #getActionsData() <em>Actions Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActionsData()
	 * @generated
	 * @ordered
	 */
	protected EList<MarkovModelActionData> actionsData;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkowModelTraceReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.MARKOW_MODEL_TRACE_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOW_MODEL_TRACE_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOW_MODEL_TRACE_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK, oldNetwork, network));
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
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MarkovModelActionData> getActionsData() {
		if (actionsData == null) {
			actionsData = new EObjectContainmentEList<MarkovModelActionData>(MarkovModelActionData.class, this, TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA);
		}
		return actionsData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<MarkovModelActionData> getData(Actor actor) {
		ArrayList<MarkovModelActionData> list = new ArrayList<>();
		for (MarkovModelActionData data : getActionsData()) {
			if (data.getAction().getOwner() == actor) {
				list.add(data);
			}
		}

		Collections.sort(list, new Comparator<MarkovModelActionData>() {

			@Override
			public int compare(MarkovModelActionData o1, MarkovModelActionData o2) {
				if (o1.isFirst()) {
					return -1;
				} else if (o2.isFirst()) {
					return 1;
				}
				return o1.getAction().getName().compareTo(o2.getAction().getName());
			}
		});

		return list;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public MarkovModelActionData getData(Action action) {
		for (MarkovModelActionData data : getActionsData()) {
			if (data.getAction() == action) {
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA:
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ALGORITHM:
				return getAlgorithm();
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__DATE:
				return getDate();
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA:
				return getActionsData();
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA:
				getActionsData().clear();
				getActionsData().addAll((Collection<? extends MarkovModelActionData>)newValue);
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA:
				getActionsData().clear();
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__NETWORK:
				return network != null;
			case TracePackage.MARKOW_MODEL_TRACE_REPORT__ACTIONS_DATA:
				return actionsData != null && !actionsData.isEmpty();
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
			case TracePackage.MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTOR:
				return getData((Actor)arguments.get(0));
			case TracePackage.MARKOW_MODEL_TRACE_REPORT___GET_DATA__ACTION:
				return getData((Action)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("\n[MARKOV MODEL TRACE ANALYSIS REPORT]");
		Network network = getNetwork();
		b.append(String.format("Network..........: %s\n", network.getName()));
		for (Actor actor : network.getActors()) {
			b.append(String.format("\n# Actor=%s", actor.getName()));
			for (MarkovModelActionData data : getData(actor)) {
				b.append(String.format("\n* Acion=%s", data.getAction().getName()));
				b.append(String.format("\n - first=%b", data.isFirst()));
				long successors = data.getSuccessors();
				b.append(String.format("\n - successors=%d", successors));
				if (successors > 0) {
					for (Entry<Action, Long> e : data.getSuccessorsMap().entrySet()) {
						long num = e.getValue();
						double p = ((double) num) / successors;
						b.append(String.format("\n --> action=%s (%d, %s)", e.getKey().getName(), num,
								StringUtils.format(p)));
					}
				}
			}
		}
		b.append("\n\n");
		return b.toString();
	}

} // MarkowModelTraceReportImpl

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

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.ActionToLongMapImpl;
import turnus.model.analysis.map.impl.ActorToLongMapImpl;
import turnus.model.analysis.map.impl.StringToLongMapImpl;
import turnus.model.analysis.trace.TracePackage;
import turnus.model.analysis.trace.TraceSizeReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Size Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActionsFirings <em>Actions Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActionsIncomings <em>Actions Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActionsOutgoings <em>Actions Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActorsFirings <em>Actors Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActorsIncoming <em>Actors Incoming</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getActorsOutgoings <em>Actors Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getDependenciesKinds <em>Dependencies Kinds</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceSizeReportImpl#getNetwork <em>Network</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceSizeReportImpl extends MinimalEObjectImpl.Container implements TraceSizeReport {
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
	 * The cached value of the '{@link #getActionsFirings()
	 * <em>Actions Firings</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getActionsFirings()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionsFirings;

	/**
	 * The cached value of the '{@link #getActionsIncomings() <em>Actions Incomings</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActionsIncomings()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionsIncomings;

	/**
	 * The cached value of the '{@link #getActionsOutgoings() <em>Actions Outgoings</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActionsOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionsOutgoings;

	/**
	 * The cached value of the '{@link #getActorsFirings()
	 * <em>Actors Firings</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getActorsFirings()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, Long> actorsFirings;

	/**
	 * The cached value of the '{@link #getActorsIncoming()
	 * <em>Actors Incoming</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getActorsIncoming()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, Long> actorsIncoming;

	/**
	 * The cached value of the '{@link #getActorsOutgoings() <em>Actors Outgoings</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActorsOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, Long> actorsOutgoings;

	/**
	 * The default value of the '{@link #getFirings() <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFirings()
	 * @generated
	 * @ordered
	 */
	protected static final long FIRINGS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFirings() <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFirings()
	 * @generated
	 * @ordered
	 */
	protected long firings = FIRINGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final long DEPENDENCIES_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected long dependencies = DEPENDENCIES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependenciesKinds() <em>Dependencies Kinds</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDependenciesKinds()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Long> dependenciesKinds;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceSizeReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_SIZE_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_SIZE_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_SIZE_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionsFirings() {
		if (actionsFirings == null) {
			actionsFirings = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS);
		}
		return actionsFirings.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionsIncomings() {
		if (actionsIncomings == null) {
			actionsIncomings = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS);
		}
		return actionsIncomings.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionsOutgoings() {
		if (actionsOutgoings == null) {
			actionsOutgoings = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS);
		}
		return actionsOutgoings.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Actor, Long> getActorsFirings() {
		if (actorsFirings == null) {
			actorsFirings = new EcoreEMap<Actor,Long>(MapPackage.Literals.ACTOR_TO_LONG_MAP, ActorToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS);
		}
		return actorsFirings.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Actor, Long> getActorsIncoming() {
		if (actorsIncoming == null) {
			actorsIncoming = new EcoreEMap<Actor,Long>(MapPackage.Literals.ACTOR_TO_LONG_MAP, ActorToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING);
		}
		return actorsIncoming.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Actor, Long> getActorsOutgoings() {
		if (actorsOutgoings == null) {
			actorsOutgoings = new EcoreEMap<Actor,Long>(MapPackage.Literals.ACTOR_TO_LONG_MAP, ActorToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS);
		}
		return actorsOutgoings.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getFirings() {
		return firings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirings(long newFirings) {
		long oldFirings = firings;
		firings = newFirings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_SIZE_REPORT__FIRINGS, oldFirings, firings));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(long newDependencies) {
		long oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES, oldDependencies, dependencies));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Long> getDependenciesKinds() {
		if (dependenciesKinds == null) {
			dependenciesKinds = new EcoreEMap<String,Long>(MapPackage.Literals.STRING_TO_LONG_MAP, StringToLongMapImpl.class, this, TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS);
		}
		return dependenciesKinds.map();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TRACE_SIZE_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_SIZE_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionsFirings()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionsIncomings()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionsOutgoings()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, Long>)getActorsFirings()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, Long>)getActorsIncoming()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, Long>)getActorsOutgoings()).eMap()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS:
				return ((InternalEList<?>)((EMap.InternalMapView<String, Long>)getDependenciesKinds()).eMap()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRACE_SIZE_REPORT__ALGORITHM:
				return getAlgorithm();
			case TracePackage.TRACE_SIZE_REPORT__DATE:
				return getDate();
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionsFirings()).eMap();
				else return getActionsFirings();
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionsIncomings()).eMap();
				else return getActionsIncomings();
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionsOutgoings()).eMap();
				else return getActionsOutgoings();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS:
				if (coreType) return ((EMap.InternalMapView<Actor, Long>)getActorsFirings()).eMap();
				else return getActorsFirings();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING:
				if (coreType) return ((EMap.InternalMapView<Actor, Long>)getActorsIncoming()).eMap();
				else return getActorsIncoming();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS:
				if (coreType) return ((EMap.InternalMapView<Actor, Long>)getActorsOutgoings()).eMap();
				else return getActorsOutgoings();
			case TracePackage.TRACE_SIZE_REPORT__FIRINGS:
				return getFirings();
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES:
				return getDependencies();
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS:
				if (coreType) return ((EMap.InternalMapView<String, Long>)getDependenciesKinds()).eMap();
				else return getDependenciesKinds();
			case TracePackage.TRACE_SIZE_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRACE_SIZE_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionsFirings()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionsIncomings()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionsOutgoings()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, Long>)getActorsFirings()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, Long>)getActorsIncoming()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, Long>)getActorsOutgoings()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__FIRINGS:
				setFirings((Long)newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES:
				setDependencies((Long)newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, Long>)getDependenciesKinds()).eMap()).set(newValue);
				return;
			case TracePackage.TRACE_SIZE_REPORT__NETWORK:
				setNetwork((Network)newValue);
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
			case TracePackage.TRACE_SIZE_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS:
				getActionsFirings().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS:
				getActionsIncomings().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS:
				getActionsOutgoings().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS:
				getActorsFirings().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING:
				getActorsIncoming().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS:
				getActorsOutgoings().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__FIRINGS:
				setFirings(FIRINGS_EDEFAULT);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES:
				setDependencies(DEPENDENCIES_EDEFAULT);
				return;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS:
				getDependenciesKinds().clear();
				return;
			case TracePackage.TRACE_SIZE_REPORT__NETWORK:
				setNetwork((Network)null);
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
			case TracePackage.TRACE_SIZE_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case TracePackage.TRACE_SIZE_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_FIRINGS:
				return actionsFirings != null && !actionsFirings.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_INCOMINGS:
				return actionsIncomings != null && !actionsIncomings.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__ACTIONS_OUTGOINGS:
				return actionsOutgoings != null && !actionsOutgoings.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_FIRINGS:
				return actorsFirings != null && !actorsFirings.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_INCOMING:
				return actorsIncoming != null && !actorsIncoming.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__ACTORS_OUTGOINGS:
				return actorsOutgoings != null && !actorsOutgoings.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__FIRINGS:
				return firings != FIRINGS_EDEFAULT;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES:
				return dependencies != DEPENDENCIES_EDEFAULT;
			case TracePackage.TRACE_SIZE_REPORT__DEPENDENCIES_KINDS:
				return dependenciesKinds != null && !dependenciesKinds.isEmpty();
			case TracePackage.TRACE_SIZE_REPORT__NETWORK:
				return network != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", date: ");
		result.append(date);
		result.append(", firings: ");
		result.append(firings);
		result.append(", dependencies: ");
		result.append(dependencies);
		result.append(')');
		return result.toString();
	}

} // TraceSizeReportImpl

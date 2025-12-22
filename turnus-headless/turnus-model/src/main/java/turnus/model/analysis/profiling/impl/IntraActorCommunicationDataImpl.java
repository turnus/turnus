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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.ActorToStatisticalDataMapImpl;

import turnus.model.analysis.profiling.IntraActionCommunicationData;
import turnus.model.analysis.profiling.IntraActorCommunicationData;
import turnus.model.analysis.profiling.ProfilingPackage;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intra Actor Communication Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl#getConsumedTokens <em>Consumed Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl#getProducedTokens <em>Produced Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl#getTokensProducersMap <em>Tokens Producers Map</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActorCommunicationDataImpl#getActionsData <em>Actions Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntraActorCommunicationDataImpl extends MinimalEObjectImpl.Container implements IntraActorCommunicationData {
	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected Actor actor;

	/**
	 * The cached value of the '{@link #getConsumedTokens() <em>Consumed Tokens</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumedTokens()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData consumedTokens;

	/**
	 * The cached value of the '{@link #getProducedTokens() <em>Produced Tokens</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedTokens()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData producedTokens;

	/**
	 * The cached value of the '{@link #getTokensProducersMap() <em>Tokens Producers Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokensProducersMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, StatisticalData> tokensProducersMap;

	/**
	 * The cached value of the '{@link #getActionsData() <em>Actions Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsData()
	 * @generated
	 * @ordered
	 */
	protected EList<IntraActionCommunicationData> actionsData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntraActorCommunicationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.INTRA_ACTOR_COMMUNICATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Actor getActor() {
		if (actor != null && actor.eIsProxy()) {
			InternalEObject oldActor = (InternalEObject)actor;
			actor = (Actor)eResolveProxy(oldActor);
			if (actor != oldActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR, oldActor, actor));
			}
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActor(Actor newActor) {
		Actor oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticalData getConsumedTokens() {
		return consumedTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsumedTokens(StatisticalData newConsumedTokens, NotificationChain msgs) {
		StatisticalData oldConsumedTokens = consumedTokens;
		consumedTokens = newConsumedTokens;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS, oldConsumedTokens, newConsumedTokens);
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
	public void setConsumedTokens(StatisticalData newConsumedTokens) {
		if (newConsumedTokens != consumedTokens) {
			NotificationChain msgs = null;
			if (consumedTokens != null)
				msgs = ((InternalEObject)consumedTokens).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS, null, msgs);
			if (newConsumedTokens != null)
				msgs = ((InternalEObject)newConsumedTokens).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS, null, msgs);
			msgs = basicSetConsumedTokens(newConsumedTokens, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS, newConsumedTokens, newConsumedTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticalData getProducedTokens() {
		return producedTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProducedTokens(StatisticalData newProducedTokens, NotificationChain msgs) {
		StatisticalData oldProducedTokens = producedTokens;
		producedTokens = newProducedTokens;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS, oldProducedTokens, newProducedTokens);
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
	public void setProducedTokens(StatisticalData newProducedTokens) {
		if (newProducedTokens != producedTokens) {
			NotificationChain msgs = null;
			if (producedTokens != null)
				msgs = ((InternalEObject)producedTokens).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS, null, msgs);
			if (newProducedTokens != null)
				msgs = ((InternalEObject)newProducedTokens).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS, null, msgs);
			msgs = basicSetProducedTokens(newProducedTokens, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS, newProducedTokens, newProducedTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Actor, StatisticalData> getTokensProducersMap() {
		if (tokensProducersMap == null) {
			tokensProducersMap = new EcoreEMap<Actor,StatisticalData>(MapPackage.Literals.ACTOR_TO_STATISTICAL_DATA_MAP, ActorToStatisticalDataMapImpl.class, this, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP);
		}
		return tokensProducersMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IntraActionCommunicationData> getActionsData() {
		if (actionsData == null) {
			actionsData = new EObjectContainmentEList<IntraActionCommunicationData>(IntraActionCommunicationData.class, this, ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA);
		}
		return actionsData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return basicSetConsumedTokens(null, msgs);
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return basicSetProducedTokens(null, msgs);
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, StatisticalData>)getTokensProducersMap()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA:
				return ((InternalEList<?>)getActionsData()).basicRemove(otherEnd, msgs);
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
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return getConsumedTokens();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return getProducedTokens();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, StatisticalData>)getTokensProducersMap()).eMap();
				else return getTokensProducersMap();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA:
				return getActionsData();
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
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR:
				setActor((Actor)newValue);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS:
				setConsumedTokens((StatisticalData)newValue);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS:
				setProducedTokens((StatisticalData)newValue);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, StatisticalData>)getTokensProducersMap()).eMap()).set(newValue);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA:
				getActionsData().clear();
				getActionsData().addAll((Collection<? extends IntraActionCommunicationData>)newValue);
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
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR:
				setActor((Actor)null);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS:
				setConsumedTokens((StatisticalData)null);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS:
				setProducedTokens((StatisticalData)null);
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				getTokensProducersMap().clear();
				return;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA:
				getActionsData().clear();
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
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTOR:
				return actor != null;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return consumedTokens != null;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return producedTokens != null;
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				return tokensProducersMap != null && !tokensProducersMap.isEmpty();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA__ACTIONS_DATA:
				return actionsData != null && !actionsData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IntraActorCommunicationDataImpl

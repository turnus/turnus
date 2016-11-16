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

import turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl;

import turnus.model.analysis.profiling.IntraActionCommunicationData;
import turnus.model.analysis.profiling.ProfilingPackage;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intra Action Communication Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl#getConsumedTokens <em>Consumed Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl#getProducedTokens <em>Produced Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.IntraActionCommunicationDataImpl#getTokensProducersMap <em>Tokens Producers Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntraActionCommunicationDataImpl extends MinimalEObjectImpl.Container implements IntraActionCommunicationData {
	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

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
	protected EMap<Action, StatisticalData> tokensProducersMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntraActionCommunicationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.INTRA_ACTION_COMMUNICATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS, oldConsumedTokens, newConsumedTokens);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsumedTokens(StatisticalData newConsumedTokens) {
		if (newConsumedTokens != consumedTokens) {
			NotificationChain msgs = null;
			if (consumedTokens != null)
				msgs = ((InternalEObject)consumedTokens).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS, null, msgs);
			if (newConsumedTokens != null)
				msgs = ((InternalEObject)newConsumedTokens).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS, null, msgs);
			msgs = basicSetConsumedTokens(newConsumedTokens, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS, newConsumedTokens, newConsumedTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS, oldProducedTokens, newProducedTokens);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProducedTokens(StatisticalData newProducedTokens) {
		if (newProducedTokens != producedTokens) {
			NotificationChain msgs = null;
			if (producedTokens != null)
				msgs = ((InternalEObject)producedTokens).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS, null, msgs);
			if (newProducedTokens != null)
				msgs = ((InternalEObject)newProducedTokens).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS, null, msgs);
			msgs = basicSetProducedTokens(newProducedTokens, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS, newProducedTokens, newProducedTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, StatisticalData> getTokensProducersMap() {
		if (tokensProducersMap == null) {
			tokensProducersMap = new EcoreEMap<Action,StatisticalData>(MapPackage.Literals.ACTION_TO_STATISTICAL_DATA_MAP, ActionToStatisticalDataMapImpl.class, this, ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP);
		}
		return tokensProducersMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return basicSetConsumedTokens(null, msgs);
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return basicSetProducedTokens(null, msgs);
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, StatisticalData>)getTokensProducersMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return getConsumedTokens();
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return getProducedTokens();
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				if (coreType) return ((EMap.InternalMapView<Action, StatisticalData>)getTokensProducersMap()).eMap();
				else return getTokensProducersMap();
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION:
				setAction((Action)newValue);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS:
				setConsumedTokens((StatisticalData)newValue);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS:
				setProducedTokens((StatisticalData)newValue);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, StatisticalData>)getTokensProducersMap()).eMap()).set(newValue);
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION:
				setAction((Action)null);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS:
				setConsumedTokens((StatisticalData)null);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS:
				setProducedTokens((StatisticalData)null);
				return;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				getTokensProducersMap().clear();
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__ACTION:
				return action != null;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__CONSUMED_TOKENS:
				return consumedTokens != null;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__PRODUCED_TOKENS:
				return producedTokens != null;
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA__TOKENS_PRODUCERS_MAP:
				return tokensProducersMap != null && !tokensProducersMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IntraActionCommunicationDataImpl

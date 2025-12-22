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
package turnus.model.analysis.postprocessing.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;
import turnus.model.analysis.map.impl.BufferToDoubleMapImpl;
import turnus.model.analysis.map.impl.BufferToIntegerMapImpl;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Blocking Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl#getMaxBlockedOutputTokens <em>Max Blocked Output Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl#getMaxBlockedMultiplication <em>Max Blocked Multiplication</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.BufferBlockingReportImpl#getBlockingInstances <em>Blocking Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferBlockingReportImpl extends PostProcessingDataImpl implements BufferBlockingReport {
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
	 * The cached value of the '{@link #getMaxBlockedOutputTokens() <em>Max Blocked Output Tokens</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBlockedOutputTokens()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Integer> maxBlockedOutputTokens;

	/**
	 * The cached value of the '{@link #getMaxBlockedMultiplication() <em>Max Blocked Multiplication</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBlockedMultiplication()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Double> maxBlockedMultiplication;

	/**
	 * The cached value of the '{@link #getBlockingInstances() <em>Blocking Instances</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockingInstances()
	 * @generated
	 * @ordered
	 */
	protected EMap<Buffer, Integer> blockingInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferBlockingReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.BUFFER_BLOCKING_REPORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, Integer> getMaxBlockedOutputTokens() {
		if (maxBlockedOutputTokens == null) {
			maxBlockedOutputTokens = new EcoreEMap<Buffer,Integer>(MapPackage.Literals.BUFFER_TO_INTEGER_MAP, BufferToIntegerMapImpl.class, this, PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS);
		}
		return maxBlockedOutputTokens.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, Double> getMaxBlockedMultiplication() {
		if (maxBlockedMultiplication == null) {
			maxBlockedMultiplication = new EcoreEMap<Buffer,Double>(MapPackage.Literals.BUFFER_TO_DOUBLE_MAP, BufferToDoubleMapImpl.class, this, PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION);
		}
		return maxBlockedMultiplication.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Buffer, Integer> getBlockingInstances() {
		if (blockingInstances == null) {
			blockingInstances = new EcoreEMap<Buffer,Integer>(MapPackage.Literals.BUFFER_TO_INTEGER_MAP, BufferToIntegerMapImpl.class, this, PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES);
		}
		return blockingInstances.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap()).basicRemove(otherEnd, msgs);
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES:
				return ((InternalEList<?>)((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap()).basicRemove(otherEnd, msgs);
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
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS:
				if (coreType) return ((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap();
				else return getMaxBlockedOutputTokens();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION:
				if (coreType) return ((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap();
				else return getMaxBlockedMultiplication();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES:
				if (coreType) return ((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap();
				else return getBlockingInstances();
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
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Integer>)getMaxBlockedOutputTokens()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Double>)getMaxBlockedMultiplication()).eMap()).set(newValue);
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Buffer, Integer>)getBlockingInstances()).eMap()).set(newValue);
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
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS:
				getMaxBlockedOutputTokens().clear();
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION:
				getMaxBlockedMultiplication().clear();
				return;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES:
				getBlockingInstances().clear();
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
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__NETWORK:
				return network != null;
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_OUTPUT_TOKENS:
				return maxBlockedOutputTokens != null && !maxBlockedOutputTokens.isEmpty();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__MAX_BLOCKED_MULTIPLICATION:
				return maxBlockedMultiplication != null && !maxBlockedMultiplication.isEmpty();
			case PostprocessingPackage.BUFFER_BLOCKING_REPORT__BLOCKING_INSTANCES:
				return blockingInstances != null && !blockingInstances.isEmpty();
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
		b.append("\n[BUFFER BLOCKING REPORT]");
		b.append("\n");
	
		b.append(" Buffers:\n");
		for (Buffer buffer : getMaxBlockedOutputTokens().keySet()) {
			b.append("\t " + buffer + "\n");
			b.append("\t\t max blocked tokens: " + getMaxBlockedOutputTokens().get(buffer) + "\n");
			b.append("\t\t max blocked tokens * time: " + getMaxBlockedMultiplication().get(buffer) + "\n");
			b.append("\t\t number of blockings: " + getBlockingInstances().get(buffer) + "\n");
		}
	
		b.append("\n\n");

		return b.toString();
	}

} //BufferBlockingReportImpl

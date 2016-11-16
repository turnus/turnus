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
package turnus.model.analysis.profiler.impl;

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
import turnus.model.analysis.map.impl.ActionToStatisticalDataMapImpl;

import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.ProfilerPackage;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Dynamic Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getReads <em>Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getWrites <em>Writes</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getOccupancy <em>Occupancy</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getActionReads <em>Action Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getActionWrites <em>Action Writes</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getActionPeeks <em>Action Peeks</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getActionReadMisses <em>Action Read Misses</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getActionWriteMisses <em>Action Write Misses</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferDynamicDataImpl#getUnconsumedTokens <em>Unconsumed Tokens</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferDynamicDataImpl extends MinimalEObjectImpl.Container implements BufferDynamicData {
	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected Buffer buffer;

	/**
	 * The cached value of the '{@link #getReads() <em>Reads</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReads()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData reads;

	/**
	 * The cached value of the '{@link #getWrites() <em>Writes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrites()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData writes;

	/**
	 * The cached value of the '{@link #getOccupancy() <em>Occupancy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupancy()
	 * @generated
	 * @ordered
	 */
	protected StatisticalData occupancy;

	/**
	 * The cached value of the '{@link #getActionReads() <em>Action Reads</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionReads()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, StatisticalData> actionReads;

	/**
	 * The cached value of the '{@link #getActionWrites() <em>Action Writes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionWrites()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, StatisticalData> actionWrites;

	/**
	 * The cached value of the '{@link #getActionPeeks() <em>Action Peeks</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionPeeks()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionPeeks;

	/**
	 * The cached value of the '{@link #getActionReadMisses() <em>Action Read Misses</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionReadMisses()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionReadMisses;

	/**
	 * The cached value of the '{@link #getActionWriteMisses() <em>Action Write Misses</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionWriteMisses()
	 * @generated
	 * @ordered
	 */
	protected EMap<Action, Long> actionWriteMisses;

	/**
	 * The default value of the '{@link #getUnconsumedTokens() <em>Unconsumed Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnconsumedTokens()
	 * @generated
	 * @ordered
	 */
	protected static final int UNCONSUMED_TOKENS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUnconsumedTokens() <em>Unconsumed Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnconsumedTokens()
	 * @generated
	 * @ordered
	 */
	protected int unconsumedTokens = UNCONSUMED_TOKENS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferDynamicDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.BUFFER_DYNAMIC_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer getBuffer() {
		if (buffer != null && buffer.eIsProxy()) {
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (Buffer)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetBuffer() {
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffer(Buffer newBuffer) {
		Buffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER, oldBuffer, buffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalData getReads() {
		return reads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReads(StatisticalData newReads, NotificationChain msgs) {
		StatisticalData oldReads = reads;
		reads = newReads;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__READS, oldReads, newReads);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReads(StatisticalData newReads) {
		if (newReads != reads) {
			NotificationChain msgs = null;
			if (reads != null)
				msgs = ((InternalEObject)reads).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__READS, null, msgs);
			if (newReads != null)
				msgs = ((InternalEObject)newReads).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__READS, null, msgs);
			msgs = basicSetReads(newReads, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__READS, newReads, newReads));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalData getWrites() {
		return writes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWrites(StatisticalData newWrites, NotificationChain msgs) {
		StatisticalData oldWrites = writes;
		writes = newWrites;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES, oldWrites, newWrites);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrites(StatisticalData newWrites) {
		if (newWrites != writes) {
			NotificationChain msgs = null;
			if (writes != null)
				msgs = ((InternalEObject)writes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES, null, msgs);
			if (newWrites != null)
				msgs = ((InternalEObject)newWrites).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES, null, msgs);
			msgs = basicSetWrites(newWrites, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES, newWrites, newWrites));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalData getOccupancy() {
		return occupancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOccupancy(StatisticalData newOccupancy, NotificationChain msgs) {
		StatisticalData oldOccupancy = occupancy;
		occupancy = newOccupancy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY, oldOccupancy, newOccupancy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccupancy(StatisticalData newOccupancy) {
		if (newOccupancy != occupancy) {
			NotificationChain msgs = null;
			if (occupancy != null)
				msgs = ((InternalEObject)occupancy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY, null, msgs);
			if (newOccupancy != null)
				msgs = ((InternalEObject)newOccupancy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY, null, msgs);
			msgs = basicSetOccupancy(newOccupancy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY, newOccupancy, newOccupancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, StatisticalData> getActionReads() {
		if (actionReads == null) {
			actionReads = new EcoreEMap<Action,StatisticalData>(MapPackage.Literals.ACTION_TO_STATISTICAL_DATA_MAP, ActionToStatisticalDataMapImpl.class, this, ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS);
		}
		return actionReads.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, StatisticalData> getActionWrites() {
		if (actionWrites == null) {
			actionWrites = new EcoreEMap<Action,StatisticalData>(MapPackage.Literals.ACTION_TO_STATISTICAL_DATA_MAP, ActionToStatisticalDataMapImpl.class, this, ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES);
		}
		return actionWrites.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionPeeks() {
		if (actionPeeks == null) {
			actionPeeks = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS);
		}
		return actionPeeks.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionReadMisses() {
		if (actionReadMisses == null) {
			actionReadMisses = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES);
		}
		return actionReadMisses.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Action, Long> getActionWriteMisses() {
		if (actionWriteMisses == null) {
			actionWriteMisses = new EcoreEMap<Action,Long>(MapPackage.Literals.ACTION_TO_LONG_MAP, ActionToLongMapImpl.class, this, ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES);
		}
		return actionWriteMisses.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUnconsumedTokens() {
		return unconsumedTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnconsumedTokens(int newUnconsumedTokens) {
		int oldUnconsumedTokens = unconsumedTokens;
		unconsumedTokens = newUnconsumedTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS, oldUnconsumedTokens, unconsumedTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__READS:
				return basicSetReads(null, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES:
				return basicSetWrites(null, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY:
				return basicSetOccupancy(null, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, StatisticalData>)getActionReads()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, StatisticalData>)getActionWrites()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionPeeks()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionReadMisses()).eMap()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES:
				return ((InternalEList<?>)((EMap.InternalMapView<Action, Long>)getActionWriteMisses()).eMap()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER:
				if (resolve) return getBuffer();
				return basicGetBuffer();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__READS:
				return getReads();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES:
				return getWrites();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY:
				return getOccupancy();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS:
				if (coreType) return ((EMap.InternalMapView<Action, StatisticalData>)getActionReads()).eMap();
				else return getActionReads();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES:
				if (coreType) return ((EMap.InternalMapView<Action, StatisticalData>)getActionWrites()).eMap();
				else return getActionWrites();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionPeeks()).eMap();
				else return getActionPeeks();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionReadMisses()).eMap();
				else return getActionReadMisses();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES:
				if (coreType) return ((EMap.InternalMapView<Action, Long>)getActionWriteMisses()).eMap();
				else return getActionWriteMisses();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS:
				return getUnconsumedTokens();
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
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER:
				setBuffer((Buffer)newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__READS:
				setReads((StatisticalData)newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES:
				setWrites((StatisticalData)newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY:
				setOccupancy((StatisticalData)newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, StatisticalData>)getActionReads()).eMap()).set(newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, StatisticalData>)getActionWrites()).eMap()).set(newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionPeeks()).eMap()).set(newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionReadMisses()).eMap()).set(newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Action, Long>)getActionWriteMisses()).eMap()).set(newValue);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS:
				setUnconsumedTokens((Integer)newValue);
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
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER:
				setBuffer((Buffer)null);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__READS:
				setReads((StatisticalData)null);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES:
				setWrites((StatisticalData)null);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY:
				setOccupancy((StatisticalData)null);
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS:
				getActionReads().clear();
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES:
				getActionWrites().clear();
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS:
				getActionPeeks().clear();
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES:
				getActionReadMisses().clear();
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES:
				getActionWriteMisses().clear();
				return;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS:
				setUnconsumedTokens(UNCONSUMED_TOKENS_EDEFAULT);
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
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__BUFFER:
				return buffer != null;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__READS:
				return reads != null;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__WRITES:
				return writes != null;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__OCCUPANCY:
				return occupancy != null;
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READS:
				return actionReads != null && !actionReads.isEmpty();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITES:
				return actionWrites != null && !actionWrites.isEmpty();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_PEEKS:
				return actionPeeks != null && !actionPeeks.isEmpty();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_READ_MISSES:
				return actionReadMisses != null && !actionReadMisses.isEmpty();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__ACTION_WRITE_MISSES:
				return actionWriteMisses != null && !actionWriteMisses.isEmpty();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA__UNCONSUMED_TOKENS:
				return unconsumedTokens != UNCONSUMED_TOKENS_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unconsumedTokens: ");
		result.append(unconsumedTokens);
		result.append(')');
		return result.toString();
	}

} //BufferDynamicDataImpl

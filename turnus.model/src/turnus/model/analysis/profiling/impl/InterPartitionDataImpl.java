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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.ProfilingPackage;

import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inter Partition Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getWorkload <em>Workload</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getMaxIncomingBitsPerFiring <em>Max Incoming Bits Per Firing</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getMaxOutgoingBitsPerFiring <em>Max Outgoing Bits Per Firing</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getPersistentMemory <em>Persistent Memory</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getMaxTransientMemory <em>Max Transient Memory</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getPartitionId <em>Partition Id</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getPersistentBuffers <em>Persistent Buffers</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getInternalBuffers <em>Internal Buffers</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.impl.InterPartitionDataImpl#getExternalBuffers <em>External Buffers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterPartitionDataImpl extends MinimalEObjectImpl.Container implements InterPartitionData {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The default value of the '{@link #getWorkload() <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload()
	 * @generated
	 * @ordered
	 */
	protected static final double WORKLOAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWorkload() <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkload()
	 * @generated
	 * @ordered
	 */
	protected double workload = WORKLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxIncomingBitsPerFiring() <em>Max Incoming Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIncomingBitsPerFiring()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_INCOMING_BITS_PER_FIRING_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxIncomingBitsPerFiring() <em>Max Incoming Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIncomingBitsPerFiring()
	 * @generated
	 * @ordered
	 */
	protected long maxIncomingBitsPerFiring = MAX_INCOMING_BITS_PER_FIRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOutgoingBitsPerFiring() <em>Max Outgoing Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutgoingBitsPerFiring()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_OUTGOING_BITS_PER_FIRING_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxOutgoingBitsPerFiring() <em>Max Outgoing Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOutgoingBitsPerFiring()
	 * @generated
	 * @ordered
	 */
	protected long maxOutgoingBitsPerFiring = MAX_OUTGOING_BITS_PER_FIRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistentMemory() <em>Persistent Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long PERSISTENT_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPersistentMemory() <em>Persistent Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentMemory()
	 * @generated
	 * @ordered
	 */
	protected long persistentMemory = PERSISTENT_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxTransientMemory() <em>Max Transient Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTransientMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_TRANSIENT_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxTransientMemory() <em>Max Transient Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTransientMemory()
	 * @generated
	 * @ordered
	 */
	protected long maxTransientMemory = MAX_TRANSIENT_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTITION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartitionId() <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionId()
	 * @generated
	 * @ordered
	 */
	protected String partitionId = PARTITION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistentBuffers() <em>Persistent Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentBuffers()
	 * @generated
	 * @ordered
	 */
	protected static final long PERSISTENT_BUFFERS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPersistentBuffers() <em>Persistent Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentBuffers()
	 * @generated
	 * @ordered
	 */
	protected long persistentBuffers = PERSISTENT_BUFFERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInternalBuffers() <em>Internal Buffers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> internalBuffers;

	/**
	 * The cached value of the '{@link #getExternalBuffers() <em>External Buffers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> externalBuffers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterPartitionDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilingPackage.Literals.INTER_PARTITION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, ProfilingPackage.INTER_PARTITION_DATA__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWorkload() {
		return workload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkload(double newWorkload) {
		double oldWorkload = workload;
		workload = newWorkload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__WORKLOAD, oldWorkload, workload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMaxIncomingBitsPerFiring() {
		return maxIncomingBitsPerFiring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxIncomingBitsPerFiring(long newMaxIncomingBitsPerFiring) {
		long oldMaxIncomingBitsPerFiring = maxIncomingBitsPerFiring;
		maxIncomingBitsPerFiring = newMaxIncomingBitsPerFiring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING, oldMaxIncomingBitsPerFiring, maxIncomingBitsPerFiring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMaxOutgoingBitsPerFiring() {
		return maxOutgoingBitsPerFiring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxOutgoingBitsPerFiring(long newMaxOutgoingBitsPerFiring) {
		long oldMaxOutgoingBitsPerFiring = maxOutgoingBitsPerFiring;
		maxOutgoingBitsPerFiring = newMaxOutgoingBitsPerFiring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING, oldMaxOutgoingBitsPerFiring, maxOutgoingBitsPerFiring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPersistentMemory() {
		return persistentMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPersistentMemory(long newPersistentMemory) {
		long oldPersistentMemory = persistentMemory;
		persistentMemory = newPersistentMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_MEMORY, oldPersistentMemory, persistentMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMaxTransientMemory() {
		return maxTransientMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxTransientMemory(long newMaxTransientMemory) {
		long oldMaxTransientMemory = maxTransientMemory;
		maxTransientMemory = newMaxTransientMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY, oldMaxTransientMemory, maxTransientMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPartitionId() {
		return partitionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitionId(String newPartitionId) {
		String oldPartitionId = partitionId;
		partitionId = newPartitionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__PARTITION_ID, oldPartitionId, partitionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPersistentBuffers() {
		return persistentBuffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPersistentBuffers(long newPersistentBuffers) {
		long oldPersistentBuffers = persistentBuffers;
		persistentBuffers = newPersistentBuffers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_BUFFERS, oldPersistentBuffers, persistentBuffers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Buffer> getInternalBuffers() {
		if (internalBuffers == null) {
			internalBuffers = new EObjectResolvingEList<Buffer>(Buffer.class, this, ProfilingPackage.INTER_PARTITION_DATA__INTERNAL_BUFFERS);
		}
		return internalBuffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Buffer> getExternalBuffers() {
		if (externalBuffers == null) {
			externalBuffers = new EObjectResolvingEList<Buffer>(Buffer.class, this, ProfilingPackage.INTER_PARTITION_DATA__EXTERNAL_BUFFERS);
		}
		return externalBuffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfilingPackage.INTER_PARTITION_DATA__ACTORS:
				return getActors();
			case ProfilingPackage.INTER_PARTITION_DATA__WORKLOAD:
				return getWorkload();
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING:
				return getMaxIncomingBitsPerFiring();
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING:
				return getMaxOutgoingBitsPerFiring();
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_MEMORY:
				return getPersistentMemory();
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY:
				return getMaxTransientMemory();
			case ProfilingPackage.INTER_PARTITION_DATA__PARTITION_ID:
				return getPartitionId();
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_BUFFERS:
				return getPersistentBuffers();
			case ProfilingPackage.INTER_PARTITION_DATA__INTERNAL_BUFFERS:
				return getInternalBuffers();
			case ProfilingPackage.INTER_PARTITION_DATA__EXTERNAL_BUFFERS:
				return getExternalBuffers();
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
			case ProfilingPackage.INTER_PARTITION_DATA__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__WORKLOAD:
				setWorkload((Double)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING:
				setMaxIncomingBitsPerFiring((Long)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING:
				setMaxOutgoingBitsPerFiring((Long)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_MEMORY:
				setPersistentMemory((Long)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY:
				setMaxTransientMemory((Long)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PARTITION_ID:
				setPartitionId((String)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_BUFFERS:
				setPersistentBuffers((Long)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__INTERNAL_BUFFERS:
				getInternalBuffers().clear();
				getInternalBuffers().addAll((Collection<? extends Buffer>)newValue);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__EXTERNAL_BUFFERS:
				getExternalBuffers().clear();
				getExternalBuffers().addAll((Collection<? extends Buffer>)newValue);
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
			case ProfilingPackage.INTER_PARTITION_DATA__ACTORS:
				getActors().clear();
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__WORKLOAD:
				setWorkload(WORKLOAD_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING:
				setMaxIncomingBitsPerFiring(MAX_INCOMING_BITS_PER_FIRING_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING:
				setMaxOutgoingBitsPerFiring(MAX_OUTGOING_BITS_PER_FIRING_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_MEMORY:
				setPersistentMemory(PERSISTENT_MEMORY_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY:
				setMaxTransientMemory(MAX_TRANSIENT_MEMORY_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PARTITION_ID:
				setPartitionId(PARTITION_ID_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_BUFFERS:
				setPersistentBuffers(PERSISTENT_BUFFERS_EDEFAULT);
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__INTERNAL_BUFFERS:
				getInternalBuffers().clear();
				return;
			case ProfilingPackage.INTER_PARTITION_DATA__EXTERNAL_BUFFERS:
				getExternalBuffers().clear();
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
			case ProfilingPackage.INTER_PARTITION_DATA__ACTORS:
				return actors != null && !actors.isEmpty();
			case ProfilingPackage.INTER_PARTITION_DATA__WORKLOAD:
				return workload != WORKLOAD_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_INCOMING_BITS_PER_FIRING:
				return maxIncomingBitsPerFiring != MAX_INCOMING_BITS_PER_FIRING_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_OUTGOING_BITS_PER_FIRING:
				return maxOutgoingBitsPerFiring != MAX_OUTGOING_BITS_PER_FIRING_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_MEMORY:
				return persistentMemory != PERSISTENT_MEMORY_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__MAX_TRANSIENT_MEMORY:
				return maxTransientMemory != MAX_TRANSIENT_MEMORY_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__PARTITION_ID:
				return PARTITION_ID_EDEFAULT == null ? partitionId != null : !PARTITION_ID_EDEFAULT.equals(partitionId);
			case ProfilingPackage.INTER_PARTITION_DATA__PERSISTENT_BUFFERS:
				return persistentBuffers != PERSISTENT_BUFFERS_EDEFAULT;
			case ProfilingPackage.INTER_PARTITION_DATA__INTERNAL_BUFFERS:
				return internalBuffers != null && !internalBuffers.isEmpty();
			case ProfilingPackage.INTER_PARTITION_DATA__EXTERNAL_BUFFERS:
				return externalBuffers != null && !externalBuffers.isEmpty();
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
		result.append(" (workload: ");
		result.append(workload);
		result.append(", maxIncomingBitsPerFiring: ");
		result.append(maxIncomingBitsPerFiring);
		result.append(", maxOutgoingBitsPerFiring: ");
		result.append(maxOutgoingBitsPerFiring);
		result.append(", persistentMemory: ");
		result.append(persistentMemory);
		result.append(", maxTransientMemory: ");
		result.append(maxTransientMemory);
		result.append(", partitionId: ");
		result.append(partitionId);
		result.append(", persistentBuffers: ");
		result.append(persistentBuffers);
		result.append(')');
		return result.toString();
	}

} //InterPartitionDataImpl

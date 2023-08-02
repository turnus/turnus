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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
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

import turnus.model.analysis.profiler.ActionMemoryProfilingData;
import turnus.model.analysis.profiler.BufferAccessData;
import turnus.model.analysis.profiler.LocalVariableAccessData;
import turnus.model.analysis.profiler.MemoryAccessData;
import turnus.model.analysis.profiler.ProfilerPackage;
import turnus.model.analysis.profiler.SharedVariableAccessData;
import turnus.model.analysis.profiler.StateVariableAccessData;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action Memory Profiling Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl#getReads <em>Reads</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.ActionMemoryProfilingDataImpl#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionMemoryProfilingDataImpl extends MinimalEObjectImpl.Container implements ActionMemoryProfilingData {
	/**
	 * The default value of the '{@link #getActor() <em>Actor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected String actor = ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReads() <em>Reads</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReads()
	 * @generated
	 * @ordered
	 */
	protected EList<MemoryAccessData> reads;

	/**
	 * The cached value of the '{@link #getWrites() <em>Writes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWrites()
	 * @generated
	 * @ordered
	 */
	protected EList<MemoryAccessData> writes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionMemoryProfilingDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.ACTION_MEMORY_PROFILING_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActor(String newActor) {
		String oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MemoryAccessData> getReads() {
		if (reads == null) {
			reads = new EObjectContainmentEList<MemoryAccessData>(MemoryAccessData.class, this, ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS);
		}
		return reads;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MemoryAccessData> getWrites() {
		if (writes == null) {
			writes = new EObjectContainmentEList<MemoryAccessData>(MemoryAccessData.class, this, ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES);
		}
		return writes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public BufferAccessData getReadBufferData(String sourceActor, String sourcePort, String targetActor,
			String targetPort) {
		for (MemoryAccessData data : getReads()) {
			if (data instanceof BufferAccessData) {
				BufferAccessData bd = (BufferAccessData) data;
				if (sourceActor.equals(bd.getSourceActor()) && sourcePort.equals(bd.getSourcePort())
						&& targetActor.equals(bd.getTargetActor()) && targetPort.equals(bd.getTargetPort())) {
					return bd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public BufferAccessData getWriteBufferData(String sourceActor, String sourcePort, String targetActor,
			String targetPort) {
		for (MemoryAccessData data : getWrites()) {
			if (data instanceof BufferAccessData) {
				BufferAccessData bd = (BufferAccessData) data;
				if (sourceActor.equals(bd.getSourceActor()) && sourcePort.equals(bd.getSourcePort())
						&& targetActor.equals(bd.getTargetActor()) && targetPort.equals(bd.getTargetPort())) {
					return bd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public StateVariableAccessData getReadStateVariableData(String variable) {
		for (MemoryAccessData data : getReads()) {
			if (data instanceof StateVariableAccessData) {
				StateVariableAccessData vd = (StateVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public StateVariableAccessData getWriteStateVariableData(String variable) {
		for (MemoryAccessData data : getWrites()) {
			if (data instanceof StateVariableAccessData) {
				StateVariableAccessData vd = (StateVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public LocalVariableAccessData getReadLocalVariableData(String variable) {
		for (MemoryAccessData data : getReads()) {
			if (data instanceof LocalVariableAccessData) {
				LocalVariableAccessData vd = (LocalVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public LocalVariableAccessData getWriteLocalVariableData(String variable) {
		for (MemoryAccessData data : getWrites()) {
			if (data instanceof LocalVariableAccessData) {
				LocalVariableAccessData vd = (LocalVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SharedVariableAccessData getReadSharedVariableData(String variable) {
		for (MemoryAccessData data : getReads()) {
			if (data instanceof SharedVariableAccessData) {
				SharedVariableAccessData vd = (SharedVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SharedVariableAccessData getWriteSharedVariableData(String variable) {
		for (MemoryAccessData data : getWrites()) {
			if (data instanceof SharedVariableAccessData) {
				SharedVariableAccessData vd = (SharedVariableAccessData) data;
				if (variable.equals(vd.getName())) {
					return vd;
				}
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS:
				return ((InternalEList<?>)getReads()).basicRemove(otherEnd, msgs);
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES:
				return ((InternalEList<?>)getWrites()).basicRemove(otherEnd, msgs);
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTOR:
				return getActor();
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTION:
				return getAction();
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS:
				return getReads();
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES:
				return getWrites();
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTOR:
				setActor((String)newValue);
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTION:
				setAction((String)newValue);
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS:
				getReads().clear();
				getReads().addAll((Collection<? extends MemoryAccessData>)newValue);
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES:
				getWrites().clear();
				getWrites().addAll((Collection<? extends MemoryAccessData>)newValue);
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTOR:
				setActor(ACTOR_EDEFAULT);
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS:
				getReads().clear();
				return;
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES:
				getWrites().clear();
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTOR:
				return ACTOR_EDEFAULT == null ? actor != null : !ACTOR_EDEFAULT.equals(actor);
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__READS:
				return reads != null && !reads.isEmpty();
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA__WRITES:
				return writes != null && !writes.isEmpty();
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
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_READ_BUFFER_DATA__STRING_STRING_STRING_STRING:
				return getReadBufferData((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_WRITE_BUFFER_DATA__STRING_STRING_STRING_STRING:
				return getWriteBufferData((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_READ_STATE_VARIABLE_DATA__STRING:
				return getReadStateVariableData((String)arguments.get(0));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_WRITE_STATE_VARIABLE_DATA__STRING:
				return getWriteStateVariableData((String)arguments.get(0));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_READ_LOCAL_VARIABLE_DATA__STRING:
				return getReadLocalVariableData((String)arguments.get(0));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_WRITE_LOCAL_VARIABLE_DATA__STRING:
				return getWriteLocalVariableData((String)arguments.get(0));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_READ_SHARED_VARIABLE_DATA__STRING:
				return getReadSharedVariableData((String)arguments.get(0));
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA___GET_WRITE_SHARED_VARIABLE_DATA__STRING:
				return getWriteSharedVariableData((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (actor: ");
		result.append(actor);
		result.append(", action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} // ActionMemoryProfilingDataImpl

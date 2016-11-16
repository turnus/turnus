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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import turnus.model.analysis.profiler.BufferAccessData;
import turnus.model.analysis.profiler.ProfilerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Access Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl#getSourceActor <em>Source Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl#getTargetActor <em>Target Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.BufferAccessDataImpl#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferAccessDataImpl extends MemoryAccessDataImpl implements BufferAccessData {
	/**
	 * The default value of the '{@link #getSourceActor() <em>Source Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceActor()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_ACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceActor() <em>Source Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceActor()
	 * @generated
	 * @ordered
	 */
	protected String sourceActor = SOURCE_ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourcePort() <em>Source Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePort()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourcePort() <em>Source Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePort()
	 * @generated
	 * @ordered
	 */
	protected String sourcePort = SOURCE_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetActor() <em>Target Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetActor()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetActor() <em>Target Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetActor()
	 * @generated
	 * @ordered
	 */
	protected String targetActor = TARGET_ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetPort() <em>Target Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPort()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetPort() <em>Target Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPort()
	 * @generated
	 * @ordered
	 */
	protected String targetPort = TARGET_PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferAccessDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.BUFFER_ACCESS_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceActor() {
		return sourceActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceActor(String newSourceActor) {
		String oldSourceActor = sourceActor;
		sourceActor = newSourceActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_ACTOR, oldSourceActor, sourceActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourcePort() {
		return sourcePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePort(String newSourcePort) {
		String oldSourcePort = sourcePort;
		sourcePort = newSourcePort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_PORT, oldSourcePort, sourcePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetActor() {
		return targetActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetActor(String newTargetActor) {
		String oldTargetActor = targetActor;
		targetActor = newTargetActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_ACTOR, oldTargetActor, targetActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetPort() {
		return targetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPort(String newTargetPort) {
		String oldTargetPort = targetPort;
		targetPort = newTargetPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_PORT, oldTargetPort, targetPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_ACTOR:
				return getSourceActor();
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_PORT:
				return getSourcePort();
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_ACTOR:
				return getTargetActor();
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_PORT:
				return getTargetPort();
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
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_ACTOR:
				setSourceActor((String)newValue);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_PORT:
				setSourcePort((String)newValue);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_ACTOR:
				setTargetActor((String)newValue);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_PORT:
				setTargetPort((String)newValue);
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
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_ACTOR:
				setSourceActor(SOURCE_ACTOR_EDEFAULT);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_PORT:
				setSourcePort(SOURCE_PORT_EDEFAULT);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_ACTOR:
				setTargetActor(TARGET_ACTOR_EDEFAULT);
				return;
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_PORT:
				setTargetPort(TARGET_PORT_EDEFAULT);
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
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_ACTOR:
				return SOURCE_ACTOR_EDEFAULT == null ? sourceActor != null : !SOURCE_ACTOR_EDEFAULT.equals(sourceActor);
			case ProfilerPackage.BUFFER_ACCESS_DATA__SOURCE_PORT:
				return SOURCE_PORT_EDEFAULT == null ? sourcePort != null : !SOURCE_PORT_EDEFAULT.equals(sourcePort);
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_ACTOR:
				return TARGET_ACTOR_EDEFAULT == null ? targetActor != null : !TARGET_ACTOR_EDEFAULT.equals(targetActor);
			case ProfilerPackage.BUFFER_ACCESS_DATA__TARGET_PORT:
				return TARGET_PORT_EDEFAULT == null ? targetPort != null : !TARGET_PORT_EDEFAULT.equals(targetPort);
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
		result.append(" (sourceActor: ");
		result.append(sourceActor);
		result.append(", sourcePort: ");
		result.append(sourcePort);
		result.append(", targetActor: ");
		result.append(targetActor);
		result.append(", targetPort: ");
		result.append(targetPort);
		result.append(')');
		return result.toString();
	}

} //BufferAccessDataImpl

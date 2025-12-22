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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.InternalEList;
import turnus.model.analysis.trace.ComparedAction;
import turnus.model.analysis.trace.ComparedTrace;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compared Trace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#getCompressedTrace <em>Compressed Trace</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#getDSteps <em>DSteps</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#getDDependencies <em>DDependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#getContainedReferenceActions <em>Contained Reference Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.ComparedTraceImpl#isEqual <em>Equal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComparedTraceImpl extends MinimalEObjectImpl.Container implements ComparedTrace {
	/**
	 * The cached value of the '{@link #getCompressedTrace() <em>Compressed Trace</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getCompressedTrace()
	 * @generated
	 * @ordered
	 */
	protected CompressedTraceReport compressedTrace;

	/**
	 * The default value of the '{@link #getDSteps() <em>DSteps</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDSteps()
	 * @generated
	 * @ordered
	 */
	protected static final long DSTEPS_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getDDependencies() <em>DDependencies</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDDependencies()
	 * @generated
	 * @ordered
	 */
	protected static final long DDEPENDENCIES_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getContainedReferenceActions()
	 * <em>Contained Reference Actions</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContainedReferenceActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> containedReferenceActions;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ComparedAction> actions;

	/**
	 * The default value of the '{@link #isEqual() <em>Equal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEqual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EQUAL_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComparedTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPARED_TRACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompressedTraceReport getCompressedTrace() {
		return compressedTrace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompressedTrace(CompressedTraceReport newCompressedTrace, NotificationChain msgs) {
		CompressedTraceReport oldCompressedTrace = compressedTrace;
		compressedTrace = newCompressedTrace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_TRACE__COMPRESSED_TRACE, oldCompressedTrace, newCompressedTrace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompressedTrace(CompressedTraceReport newCompressedTrace) {
		if (newCompressedTrace != compressedTrace) {
			NotificationChain msgs = null;
			if (compressedTrace != null)
				msgs = ((InternalEObject)compressedTrace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.COMPARED_TRACE__COMPRESSED_TRACE, null, msgs);
			if (newCompressedTrace != null)
				msgs = ((InternalEObject)newCompressedTrace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.COMPARED_TRACE__COMPRESSED_TRACE, null, msgs);
			msgs = basicSetCompressedTrace(newCompressedTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPARED_TRACE__COMPRESSED_TRACE, newCompressedTrace, newCompressedTrace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT;
	 */
	public long getDSteps() {
		long counter = 0;
		for (ComparedAction action : getActions()) {
			counter += action.getDSteps();
		}
		return counter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getDDependencies() {
		long counter = 0;
		for (ComparedAction action : getActions()) {
			counter += action.getDIncomings();
		}
		return counter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Action> getContainedReferenceActions() {
		if (containedReferenceActions == null) {
			containedReferenceActions = new EObjectResolvingEList<Action>(Action.class, this, TracePackage.COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS);
		}
		return containedReferenceActions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ComparedAction> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ComparedAction>(ComparedAction.class, this, TracePackage.COMPARED_TRACE__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isEqual() {
		if (getContainedReferenceActions().size() != getActions().size()) {
			return false;
		}
		
		if (getDSteps() != 0) {
			return false;
		}
		
		if (getDDependencies() != 0) {
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPARED_TRACE__COMPRESSED_TRACE:
				return basicSetCompressedTrace(null, msgs);
			case TracePackage.COMPARED_TRACE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPARED_TRACE__COMPRESSED_TRACE:
				return getCompressedTrace();
			case TracePackage.COMPARED_TRACE__DSTEPS:
				return getDSteps();
			case TracePackage.COMPARED_TRACE__DDEPENDENCIES:
				return getDDependencies();
			case TracePackage.COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS:
				return getContainedReferenceActions();
			case TracePackage.COMPARED_TRACE__ACTIONS:
				return getActions();
			case TracePackage.COMPARED_TRACE__EQUAL:
				return isEqual();
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
			case TracePackage.COMPARED_TRACE__COMPRESSED_TRACE:
				setCompressedTrace((CompressedTraceReport)newValue);
				return;
			case TracePackage.COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS:
				getContainedReferenceActions().clear();
				getContainedReferenceActions().addAll((Collection<? extends Action>)newValue);
				return;
			case TracePackage.COMPARED_TRACE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ComparedAction>)newValue);
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
			case TracePackage.COMPARED_TRACE__COMPRESSED_TRACE:
				setCompressedTrace((CompressedTraceReport)null);
				return;
			case TracePackage.COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS:
				getContainedReferenceActions().clear();
				return;
			case TracePackage.COMPARED_TRACE__ACTIONS:
				getActions().clear();
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
			case TracePackage.COMPARED_TRACE__COMPRESSED_TRACE:
				return compressedTrace != null;
			case TracePackage.COMPARED_TRACE__DSTEPS:
				return getDSteps() != DSTEPS_EDEFAULT;
			case TracePackage.COMPARED_TRACE__DDEPENDENCIES:
				return getDDependencies() != DDEPENDENCIES_EDEFAULT;
			case TracePackage.COMPARED_TRACE__CONTAINED_REFERENCE_ACTIONS:
				return containedReferenceActions != null && !containedReferenceActions.isEmpty();
			case TracePackage.COMPARED_TRACE__ACTIONS:
				return actions != null && !actions.isEmpty();
			case TracePackage.COMPARED_TRACE__EQUAL:
				return isEqual() != EQUAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // ComparedTraceImpl

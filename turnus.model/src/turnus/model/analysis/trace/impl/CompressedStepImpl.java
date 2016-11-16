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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.trace.CompressedDependency;
import turnus.model.analysis.trace.CompressedStep;
import turnus.model.analysis.trace.TracePackage;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Compressed Step</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getCount <em>Count</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.CompressedStepImpl#getNeighbors <em>Neighbors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompressedStepImpl extends MinimalEObjectImpl.Container implements CompressedStep {
	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final long COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected long count = COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<CompressedDependency> incomings;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<CompressedDependency> outgoings;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompressedStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.COMPRESSED_STEP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.COMPRESSED_STEP__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_STEP__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(long newCount) {
		long oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.COMPRESSED_STEP__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CompressedDependency> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<CompressedDependency>(CompressedDependency.class, this, TracePackage.COMPRESSED_STEP__INCOMINGS, TracePackage.COMPRESSED_DEPENDENCY__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<CompressedDependency> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<CompressedDependency>(CompressedDependency.class, this, TracePackage.COMPRESSED_STEP__OUTGOINGS, TracePackage.COMPRESSED_DEPENDENCY__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<CompressedStep> getPredecessors() {
		List<CompressedStep> steps = new ArrayList<>();
		for (CompressedDependency in : getIncomings()) {
			CompressedStep src = in.getSource();
			if (!steps.contains(src)) {
				steps.add(src);
			}
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<CompressedStep> getSuccessors() {
		List<CompressedStep> steps = new ArrayList<>();
		for (CompressedDependency out : getOutgoings()) {
			CompressedStep tgt = out.getTarget();
			if (!steps.contains(tgt)) {
				steps.add(tgt);
			}
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<CompressedStep> getNeighbors() {
		List<CompressedStep> steps = getPredecessors();
		for (CompressedStep succ : getSuccessors()) {
			if (!steps.contains(succ)) {
				steps.add(succ);
			}
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
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
			case TracePackage.COMPRESSED_STEP__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case TracePackage.COMPRESSED_STEP__COUNT:
				return getCount();
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				return getIncomings();
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				return getOutgoings();
			case TracePackage.COMPRESSED_STEP__PREDECESSORS:
				return getPredecessors();
			case TracePackage.COMPRESSED_STEP__SUCCESSORS:
				return getSuccessors();
			case TracePackage.COMPRESSED_STEP__NEIGHBORS:
				return getNeighbors();
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
			case TracePackage.COMPRESSED_STEP__ACTION:
				setAction((Action)newValue);
				return;
			case TracePackage.COMPRESSED_STEP__COUNT:
				setCount((Long)newValue);
				return;
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends CompressedDependency>)newValue);
				return;
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends CompressedDependency>)newValue);
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
			case TracePackage.COMPRESSED_STEP__ACTION:
				setAction((Action)null);
				return;
			case TracePackage.COMPRESSED_STEP__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				getIncomings().clear();
				return;
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				getOutgoings().clear();
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
			case TracePackage.COMPRESSED_STEP__ACTION:
				return action != null;
			case TracePackage.COMPRESSED_STEP__COUNT:
				return count != COUNT_EDEFAULT;
			case TracePackage.COMPRESSED_STEP__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case TracePackage.COMPRESSED_STEP__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case TracePackage.COMPRESSED_STEP__PREDECESSORS:
				return !getPredecessors().isEmpty();
			case TracePackage.COMPRESSED_STEP__SUCCESSORS:
				return !getSuccessors().isEmpty();
			case TracePackage.COMPRESSED_STEP__NEIGHBORS:
				return !getNeighbors().isEmpty();
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
		result.append(" (count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} // CompressedStepImpl

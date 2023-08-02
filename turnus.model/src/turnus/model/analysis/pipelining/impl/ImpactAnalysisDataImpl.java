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
package turnus.model.analysis.pipelining.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import turnus.model.analysis.bottlenecks.BottlenecksReport;

import turnus.model.analysis.pipelining.ImpactAnalysisData;
import turnus.model.analysis.pipelining.PipeliningPackage;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.ActorClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Impact Analysis Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl#getEstimatedBottlenecks <em>Estimated Bottlenecks</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl#getCpReduction <em>Cp Reduction</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.impl.ImpactAnalysisDataImpl#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpactAnalysisDataImpl extends MinimalEObjectImpl.Container implements ImpactAnalysisData {
	/**
	 * The cached value of the '{@link #getEstimatedBottlenecks()
	 * <em>Estimated Bottlenecks</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEstimatedBottlenecks()
	 * @generated
	 * @ordered
	 */
	protected BottlenecksReport estimatedBottlenecks;

	/**
	 * The default value of the '{@link #getCpReduction() <em>Cp Reduction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCpReduction()
	 * @generated
	 * @ordered
	 */
	protected static final double CP_REDUCTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCpReduction() <em>Cp Reduction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCpReduction()
	 * @generated
	 * @ordered
	 */
	protected double cpReduction = CP_REDUCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactAnalysisDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PipeliningPackage.Literals.IMPACT_ANALYSIS_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksReport getEstimatedBottlenecks() {
		return estimatedBottlenecks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEstimatedBottlenecks(BottlenecksReport newEstimatedBottlenecks,
			NotificationChain msgs) {
		BottlenecksReport oldEstimatedBottlenecks = estimatedBottlenecks;
		estimatedBottlenecks = newEstimatedBottlenecks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS, oldEstimatedBottlenecks, newEstimatedBottlenecks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEstimatedBottlenecks(BottlenecksReport newEstimatedBottlenecks) {
		if (newEstimatedBottlenecks != estimatedBottlenecks) {
			NotificationChain msgs = null;
			if (estimatedBottlenecks != null)
				msgs = ((InternalEObject)estimatedBottlenecks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS, null, msgs);
			if (newEstimatedBottlenecks != null)
				msgs = ((InternalEObject)newEstimatedBottlenecks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS, null, msgs);
			msgs = basicSetEstimatedBottlenecks(newEstimatedBottlenecks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS, newEstimatedBottlenecks, newEstimatedBottlenecks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCpReduction() {
		return cpReduction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCpReduction(double newCpReduction) {
		double oldCpReduction = cpReduction;
		cpReduction = newCpReduction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipeliningPackage.IMPACT_ANALYSIS_DATA__CP_REDUCTION, oldCpReduction, cpReduction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ActorClass getActorClass() {
		for (Action action : getActions()) {
			return action.getOwner().getActorClass();
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
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS:
				return basicSetEstimatedBottlenecks(null, msgs);
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
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS:
				return getEstimatedBottlenecks();
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__CP_REDUCTION:
				return getCpReduction();
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTIONS:
				return getActions();
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTOR_CLASS:
				return getActorClass();
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
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS:
				setEstimatedBottlenecks((BottlenecksReport)newValue);
				return;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__CP_REDUCTION:
				setCpReduction((Double)newValue);
				return;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
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
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS:
				setEstimatedBottlenecks((BottlenecksReport)null);
				return;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__CP_REDUCTION:
				setCpReduction(CP_REDUCTION_EDEFAULT);
				return;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTIONS:
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
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ESTIMATED_BOTTLENECKS:
				return estimatedBottlenecks != null;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__CP_REDUCTION:
				return cpReduction != CP_REDUCTION_EDEFAULT;
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTIONS:
				return actions != null && !actions.isEmpty();
			case PipeliningPackage.IMPACT_ANALYSIS_DATA__ACTOR_CLASS:
				return getActorClass() != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (cpReduction: ");
		result.append(cpReduction);
		result.append(')');
		return result.toString();
	}

} // ImpactAnalysisDataImpl

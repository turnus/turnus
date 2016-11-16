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
package turnus.model.analysis.partitioning.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.map.MapPackage;

import turnus.model.analysis.map.impl.ActorToLongMapImpl;

import turnus.model.analysis.partitioning.ComCostPartition;
import turnus.model.analysis.partitioning.PartitioningPackage;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Com Cost Partition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl#getInternalCostMap <em>Internal Cost Map</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl#getExternalCostMap <em>External Cost Map</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl#getInternalCost <em>Internal Cost</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl#getExternalCost <em>External Cost</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComCostPartitionImpl extends MinimalEObjectImpl.Container implements ComCostPartition {
	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getInternalCostMap() <em>Internal Cost Map</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInternalCostMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, Long> internalCostMap;

	/**
	 * The cached value of the '{@link #getExternalCostMap() <em>External Cost Map</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExternalCostMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<Actor, Long> externalCostMap;

	/**
	 * The default value of the '{@link #getInternalCost() <em>Internal Cost</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInternalCost()
	 * @generated
	 * @ordered
	 */
	protected static final long INTERNAL_COST_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getExternalCost() <em>External Cost</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExternalCost()
	 * @generated
	 * @ordered
	 */
	protected static final long EXTERNAL_COST_EDEFAULT = 0L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComCostPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartitioningPackage.Literals.COM_COST_PARTITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectResolvingEList<Actor>(Actor.class, this, PartitioningPackage.COM_COST_PARTITION__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Actor, Long> getInternalCostMap() {
		if (internalCostMap == null) {
			internalCostMap = new EcoreEMap<Actor,Long>(MapPackage.Literals.ACTOR_TO_LONG_MAP, ActorToLongMapImpl.class, this, PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP);
		}
		return internalCostMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<Actor, Long> getExternalCostMap() {
		if (externalCostMap == null) {
			externalCostMap = new EcoreEMap<Actor,Long>(MapPackage.Literals.ACTOR_TO_LONG_MAP, ActorToLongMapImpl.class, this, PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP);
		}
		return externalCostMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getInternalCost() {
		long sum = 0;
		for (double value : getInternalCostMap().values()) {
			sum += value;
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getExternalCost() {
		long sum = 0;
		for (double value : getExternalCostMap().values()) {
			sum += value;
		}
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, Long>)getInternalCostMap()).eMap()).basicRemove(otherEnd, msgs);
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<Actor, Long>)getExternalCostMap()).eMap()).basicRemove(otherEnd, msgs);
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
			case PartitioningPackage.COM_COST_PARTITION__ACTORS:
				return getActors();
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, Long>)getInternalCostMap()).eMap();
				else return getInternalCostMap();
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP:
				if (coreType) return ((EMap.InternalMapView<Actor, Long>)getExternalCostMap()).eMap();
				else return getExternalCostMap();
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST:
				return getInternalCost();
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST:
				return getExternalCost();
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
			case PartitioningPackage.COM_COST_PARTITION__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, Long>)getInternalCostMap()).eMap()).set(newValue);
				return;
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Actor, Long>)getExternalCostMap()).eMap()).set(newValue);
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
			case PartitioningPackage.COM_COST_PARTITION__ACTORS:
				getActors().clear();
				return;
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP:
				getInternalCostMap().clear();
				return;
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP:
				getExternalCostMap().clear();
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
			case PartitioningPackage.COM_COST_PARTITION__ACTORS:
				return actors != null && !actors.isEmpty();
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST_MAP:
				return internalCostMap != null && !internalCostMap.isEmpty();
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST_MAP:
				return externalCostMap != null && !externalCostMap.isEmpty();
			case PartitioningPackage.COM_COST_PARTITION__INTERNAL_COST:
				return getInternalCost() != INTERNAL_COST_EDEFAULT;
			case PartitioningPackage.COM_COST_PARTITION__EXTERNAL_COST:
				return getExternalCost() != EXTERNAL_COST_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} // ComCostPartitionImpl

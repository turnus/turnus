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
package turnus.model.analysis.scheduling.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import turnus.model.analysis.scheduling.ActorFire;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.Dependency;
import turnus.model.trace.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Fire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.ActorFireImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.ActorFireImpl#getTimes <em>Times</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.ActorFireImpl#getPartition <em>Partition</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.ActorFireImpl#getDependencyPartitions <em>Dependency Partitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorFireImpl extends ActorSelectionScheduleImpl implements ActorFire {
	/**
	 * The default value of the '{@link #getActor() <em>Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected String actor = ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected int times = TIMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartition() <em>Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartition()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PARTITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartition() <em>Partition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartition()
	 * @generated
	 * @ordered
	 */
	protected Integer partition = PARTITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencyPartitions() <em>Dependency Partitions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> dependencyPartitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorFireImpl() {
		super();
	}
	
	public ActorFireImpl(Step step) {
		super();
		actor=step.getActor();
		times=1;
		setPartition(0);
		getDependencyPartitions().add(0);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.ACTOR_FIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActor() {
		return actor;
	}
	

	
	@Override
	public int hashCode(){
		int hash=getTimes();
		for(byte b:getActor().getBytes()){
			hash=hash^b;
		}
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if(o!=null && hashCode() == o.hashCode() && o instanceof ActorFireImpl){
			final ActorFireImpl o_c=(ActorFireImpl)o;
			if(o_c.getTimes()==times){
				if( o_c.getActor().equals(actor)){
					return true;
				}
			}
		}
		return false;
	}
	public ActorFireImpl(Step step, NetworkPartitioning partitioning, Map<String,Integer> partition_ids) {
		setActor(step.getActor());
		setTimes(1);
		for(Dependency d:step.getIncomings()){
			if(d.getKind().equals(turnus.model.trace.Dependency.Kind.TOKENS)){
				final String p=partitioning.getPartition(d.getSourceActor());
				final String act = step.getActor();
				final Integer part=partition_ids.get(p);
				setPartition(part);
				getDependencyPartitions().add(partition_ids.get(p));
			}
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActor(String newActor) {
		String oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.ACTOR_FIRE__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTimes() {
		return times;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimes(int newTimes) {
		int oldTimes = times;
		times = newTimes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.ACTOR_FIRE__TIMES, oldTimes, times));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getPartition() {
		return partition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartition(Integer newPartition) {
		Integer oldPartition = partition;
		partition = newPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.ACTOR_FIRE__PARTITION, oldPartition, partition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Integer> getDependencyPartitions() {
		if (dependencyPartitions == null) {
			dependencyPartitions = new EDataTypeUniqueEList<Integer>(Integer.class, this, SchedulingPackage.ACTOR_FIRE__DEPENDENCY_PARTITIONS);
		}
		return dependencyPartitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.ACTOR_FIRE__ACTOR:
				return getActor();
			case SchedulingPackage.ACTOR_FIRE__TIMES:
				return getTimes();
			case SchedulingPackage.ACTOR_FIRE__PARTITION:
				return getPartition();
			case SchedulingPackage.ACTOR_FIRE__DEPENDENCY_PARTITIONS:
				return getDependencyPartitions();
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
			case SchedulingPackage.ACTOR_FIRE__ACTOR:
				setActor((String)newValue);
				return;
			case SchedulingPackage.ACTOR_FIRE__TIMES:
				setTimes((Integer)newValue);
				return;
			case SchedulingPackage.ACTOR_FIRE__PARTITION:
				setPartition((Integer)newValue);
				return;
			case SchedulingPackage.ACTOR_FIRE__DEPENDENCY_PARTITIONS:
				getDependencyPartitions().clear();
				getDependencyPartitions().addAll((Collection<? extends Integer>)newValue);
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
			case SchedulingPackage.ACTOR_FIRE__ACTOR:
				setActor(ACTOR_EDEFAULT);
				return;
			case SchedulingPackage.ACTOR_FIRE__TIMES:
				setTimes(TIMES_EDEFAULT);
				return;
			case SchedulingPackage.ACTOR_FIRE__PARTITION:
				setPartition(PARTITION_EDEFAULT);
				return;
			case SchedulingPackage.ACTOR_FIRE__DEPENDENCY_PARTITIONS:
				getDependencyPartitions().clear();
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
			case SchedulingPackage.ACTOR_FIRE__ACTOR:
				return ACTOR_EDEFAULT == null ? actor != null : !ACTOR_EDEFAULT.equals(actor);
			case SchedulingPackage.ACTOR_FIRE__TIMES:
				return times != TIMES_EDEFAULT;
			case SchedulingPackage.ACTOR_FIRE__PARTITION:
				return PARTITION_EDEFAULT == null ? partition != null : !PARTITION_EDEFAULT.equals(partition);
			case SchedulingPackage.ACTOR_FIRE__DEPENDENCY_PARTITIONS:
				return dependencyPartitions != null && !dependencyPartitions.isEmpty();
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
		result.append(" (Actor: ");
		result.append(actor);
		result.append(", Times: ");
		result.append(times);
		result.append(", partition: ");
		result.append(partition);
		result.append(", dependencyPartitions: ");
		result.append(dependencyPartitions);
		result.append(')');
		return result.toString();
	}

} //ActorFireImpl

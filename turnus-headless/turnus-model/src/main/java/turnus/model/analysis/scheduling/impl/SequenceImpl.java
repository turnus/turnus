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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.io.Logger;
import turnus.model.analysis.scheduling.ActorFire;
import turnus.model.analysis.scheduling.ActorSelectionSchedule;
import turnus.model.analysis.scheduling.SchedulingPackage;
import turnus.model.analysis.scheduling.Sequence;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.mapping.NetworkPartitioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.SequenceImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceImpl extends ActorSelectionScheduleImpl implements Sequence {
	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorFire> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}
	

	public static Sequence combine(ActorSelectionSchedule schedule1, ActorSelectionSchedule schedule2){
		boolean seq1=schedule1 instanceof Sequence;
		boolean seq2=schedule2 instanceof Sequence;
		Sequence retval;
		try{
		if(seq1 && seq2){
			Sequence s1 = (Sequence)schedule1 ;
			Sequence s2 = (Sequence)schedule2 ;
			s1.getActions().addAll(s2.getActions());
			retval=s1;
		}else if(seq1){
			Sequence s1 = (Sequence)schedule1 ;
			s1.getActions().add((ActorFire)schedule2 );
			retval=s1;
		}else if(seq2){
			Sequence s2 = (Sequence)schedule2 ;
			s2.getActions().add(0,(ActorFire)schedule1);
			retval=s2;
		}else{
			Sequence newSeq=new SequenceImpl();
			newSeq.getActions().add((ActorFire)schedule1);
			newSeq.getActions().add((ActorFire)schedule2);
			retval=newSeq;
		}
		return retval;
		}catch(ClassCastException e){
			Logger.error("While combining two Schedules into a sequence, a cast error occured. Make sure neither of the two is FSM, which doesn't support the combine operation");
			throw e;
		}
	}
	public String actionString(){
		StringBuilder sb=new StringBuilder();
		for(ActorSelectionSchedule a:getActions()){
			if(a instanceof SequenceImpl){
				sb.append(((SequenceImpl) a).actionString());
			}else if(a instanceof ActorFireImpl){
				sb.append(((ActorFireImpl)a).getActor());
			}
			sb.append(",");
		}
		return sb.toString();
	}
	public SequenceImpl(Trace trace) {
		super();
//TODO, HACK increasing id is a valid topological order ONLY for single partition, fixed buffer size..change this later
		for (Step step : trace.getSteps(Order.INCREASING_ID)) {
			getActions().add(new ActorFireImpl(step));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ActorFire> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ActorFire>(ActorFire.class, this, SchedulingPackage.SEQUENCE__ACTIONS);
		}
		return actions;
	}
	
	private Boolean sameAs(Sequence other){
		return equals(other);
	}
	@Override
	public int hashCode(){
		int hash=1;
		for(ActorSelectionSchedule a:getActions()){
			hash=hash^a.hashCode();
		}
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if(o!=null && hashCode() == o.hashCode() && o instanceof SequenceImpl){
			final SequenceImpl o_c=(SequenceImpl)o;
				List<ActorFire> oa=o_c.getActions();
				List<ActorFire> a=getActions();
				if(oa.size()==a.size()){
					for(int i=0;i<oa.size();++i){
						if(! oa.get(i).equals(a.get(i))){
							return false;
						}
					}
					return true;
				}else{
					return false;
				}
			}
		
		return false;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.SEQUENCE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case SchedulingPackage.SEQUENCE__ACTIONS:
				return getActions();
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
			case SchedulingPackage.SEQUENCE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ActorFire>)newValue);
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
			case SchedulingPackage.SEQUENCE__ACTIONS:
				getActions().clear();
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
			case SchedulingPackage.SEQUENCE__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	public static LinkedHashMap<String, SequenceImpl> fromTraceWithPartition(Trace trace, NetworkPartitioning partitioning, Map<String,Integer> partition_ids) {
		LinkedHashMap<String, SequenceImpl> scheds=new LinkedHashMap<String,SequenceImpl>();
		for(String k:partitioning.getPartitions()){
			scheds.put(k, new SequenceImpl());
		}
		for(Step step:trace.getSteps(Order.INCREASING_ID)){
			final String p=partitioning.getPartition(step.getActor());
			//TODO: add new class, which keeps track of "has cross partition dependency". based on that, add the wait loop
			//TODO: also: can try different strategies here
			scheds.get(p).getActions().add(new ActorFireImpl(step,partitioning,partition_ids));
		}
		return scheds;
	}



} //SequenceImpl

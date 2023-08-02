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
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import turnus.model.analysis.scheduling.FSM;
import turnus.model.analysis.scheduling.FSMState;
import turnus.model.analysis.scheduling.FSMVar;
import turnus.model.analysis.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMImpl#getStates <em>States</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMImpl#getVars <em>Vars</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMImpl#getStartState <em>Start State</em>}</li>
 *   <li>{@link turnus.model.analysis.scheduling.impl.FSMImpl#getTerminalState <em>Terminal State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMImpl extends ActorSelectionScheduleImpl implements FSM {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMState> states;

	/**
	 * The cached value of the '{@link #getVars() <em>Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVars()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMVar> vars;

	/**
	 * The default value of the '{@link #getStartState() <em>Start State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartState()
	 * @generated
	 * @ordered
	 */
	protected static final String START_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartState() <em>Start State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartState()
	 * @generated
	 * @ordered
	 */
	protected String startState = START_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTerminalState() <em>Terminal State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminalState()
	 * @generated
	 * @ordered
	 */
	protected static final String TERMINAL_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTerminalState() <em>Terminal State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminalState()
	 * @generated
	 * @ordered
	 */
	protected String terminalState = TERMINAL_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMImpl() {
		super();
	}
	private Boolean sameAs(FSM other){
		throw new NotImplementedException("FSM sameAs not yet implemented");
		/*
		if (true){
			return true;
		}else{
		return false;
		}*/
	}
	

	
	@Override
	public int hashCode(){
		int hash=1;
		for(FSMState s:getStates()){
			hash = hash ^ s.hashCode();
		}
		
		hash=hash ^ getVars().hashCode();
		hash = hash ^ startState.hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if(o!=null && o instanceof FSMImpl && hashCode() == o.hashCode()){
			final FSMImpl o_c=(FSMImpl)o;
			if(o_c.startState.equals(startState) && vars.equals(o_c.getVars())){
				if(getStates().size()==o_c.getStates().size()){
					for(int i=0;i<getStates().size();++i){
						if(!(getStates().get(i).equals(o_c.getStates().get(i)))){
							return false;
						}
					}
				}
				
			}
			return true;
			}else{
				return false;
			}
	}
	



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.FSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<FSMState> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<FSMState>(FSMState.class, this, SchedulingPackage.FSM__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<FSMVar> getVars() {
		if (vars == null) {
			vars = new EObjectContainmentEList<FSMVar>(FSMVar.class, this, SchedulingPackage.FSM__VARS);
		}
		return vars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartState() {
		return startState;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartState(String newStartState) {
		String oldStartState = startState;
		startState = newStartState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM__START_STATE, oldStartState, startState));
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTerminalState() {
		return terminalState;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTerminalState(String newTerminalState) {
		String oldTerminalState = terminalState;
		terminalState = newTerminalState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.FSM__TERMINAL_STATE, oldTerminalState, terminalState));
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.FSM__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case SchedulingPackage.FSM__VARS:
				return ((InternalEList<?>)getVars()).basicRemove(otherEnd, msgs);
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
			case SchedulingPackage.FSM__STATES:
				return getStates();
			case SchedulingPackage.FSM__VARS:
				return getVars();
			case SchedulingPackage.FSM__START_STATE:
				return getStartState();
			case SchedulingPackage.FSM__TERMINAL_STATE:
				return getTerminalState();
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
			case SchedulingPackage.FSM__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends FSMState>)newValue);
				return;
			case SchedulingPackage.FSM__VARS:
				getVars().clear();
				getVars().addAll((Collection<? extends FSMVar>)newValue);
				return;
			case SchedulingPackage.FSM__START_STATE:
				setStartState((String)newValue);
				return;
			case SchedulingPackage.FSM__TERMINAL_STATE:
				setTerminalState((String)newValue);
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
			case SchedulingPackage.FSM__STATES:
				getStates().clear();
				return;
			case SchedulingPackage.FSM__VARS:
				getVars().clear();
				return;
			case SchedulingPackage.FSM__START_STATE:
				setStartState(START_STATE_EDEFAULT);
				return;
			case SchedulingPackage.FSM__TERMINAL_STATE:
				setTerminalState(TERMINAL_STATE_EDEFAULT);
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
			case SchedulingPackage.FSM__STATES:
				return states != null && !states.isEmpty();
			case SchedulingPackage.FSM__VARS:
				return vars != null && !vars.isEmpty();
			case SchedulingPackage.FSM__START_STATE:
				return START_STATE_EDEFAULT == null ? startState != null : !START_STATE_EDEFAULT.equals(startState);
			case SchedulingPackage.FSM__TERMINAL_STATE:
				return TERMINAL_STATE_EDEFAULT == null ? terminalState != null : !TERMINAL_STATE_EDEFAULT.equals(terminalState);
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
		result.append(" (startState: ");
		result.append(startState);
		result.append(", terminalState: ");
		result.append(terminalState);
		result.append(')');
		return result.toString();
	}

} //FSMImpl

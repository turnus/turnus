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
package turnus.model.dataflow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.common.impl.AttributableImpl;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Procedure;
import turnus.model.dataflow.SharedVariable;
import turnus.model.dataflow.Variable;
import turnus.model.dataflow.util.ActorAdapter;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Actor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getName <em>Name</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getInputPorts
 * <em>Input Ports</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getOutputPorts
 * <em>Output Ports</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getVariables
 * <em>Variables</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getActorClass
 * <em>Actor Class</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getActions <em>Actions</em>}
 * </li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getProcedures
 * <em>Procedures</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getOwner <em>Owner</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getBuffers <em>Buffers</em>}
 * </li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getIncomingBuffers
 * <em>Incoming Buffers</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getOutgoingBuffers
 * <em>Outgoing Buffers</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getPredecessors
 * <em>Predecessors</em>}</li>
 * <li>{@link turnus.model.dataflow.impl.ActorImpl#getSuccessors
 * <em>Successors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorImpl extends AttributableImpl implements Actor {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputPorts() <em>Input Ports</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputPorts;

	/**
	 * The cached value of the '{@link #getOutputPorts() <em>Output Ports</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputPorts;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * The cached value of the '{@link #getActorClass() <em>Actor Class</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActorClass()
	 * @generated
	 * @ordered
	 */
	protected ActorClass actorClass;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getProcedures() <em>Procedures</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProcedures()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedures;

	/**
	 * The map of actions and names
	 * 
	 * @see #getAction(String)
	 */
	private BiMap<String, Action> actionsMap;

	/**
	 * The map of variables and names
	 * 
	 * @see #getVariable(String)
	 */
	private BiMap<String, Variable> variablesMap;

	/**
	 * The map of procedures and names
	 * 
	 * @see #getProcedure(String)
	 */
	private BiMap<String, Procedure> proceduresMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ActorImpl() {
		super();

		actionsMap = HashBiMap.create();
		variablesMap = HashBiMap.create();
		proceduresMap = HashBiMap.create();

		eAdapters().add(new ActorAdapter(actionsMap, variablesMap, proceduresMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.ACTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<Port> getInputPorts() {
		if (inputPorts == null) {
			inputPorts = new EObjectContainmentEList<Port>(Port.class, this, DataflowPackage.ACTOR__INPUT_PORTS);
		}
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<Port> getOutputPorts() {
		if (outputPorts == null) {
			outputPorts = new EObjectContainmentEList<Port>(Port.class, this, DataflowPackage.ACTOR__OUTPUT_PORTS);
		}
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, DataflowPackage.ACTOR__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActorClass getActorClass() {
		if (actorClass != null && actorClass.eIsProxy()) {
			InternalEObject oldActorClass = (InternalEObject) actorClass;
			actorClass = (ActorClass) eResolveProxy(oldActorClass);
			if (actorClass != oldActorClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataflowPackage.ACTOR__ACTOR_CLASS,
							oldActorClass, actorClass));
			}
		}
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActorClass basicGetActorClass() {
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetActorClass(ActorClass newActorClass, NotificationChain msgs) {
		ActorClass oldActorClass = actorClass;
		actorClass = newActorClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DataflowPackage.ACTOR__ACTOR_CLASS, oldActorClass, newActorClass);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActorClass(ActorClass newActorClass) {
		if (newActorClass != actorClass) {
			NotificationChain msgs = null;
			if (actorClass != null)
				msgs = ((InternalEObject) actorClass).eInverseRemove(this, DataflowPackage.ACTOR_CLASS__ACTORS,
						ActorClass.class, msgs);
			if (newActorClass != null)
				msgs = ((InternalEObject) newActorClass).eInverseAdd(this, DataflowPackage.ACTOR_CLASS__ACTORS,
						ActorClass.class, msgs);
			msgs = basicSetActorClass(newActorClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.ACTOR__ACTOR_CLASS, newActorClass,
					newActorClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, DataflowPackage.ACTOR__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List<Procedure> getProcedures() {
		if (procedures == null) {
			procedures = new EObjectContainmentEList<Procedure>(Procedure.class, this,
					DataflowPackage.ACTOR__PROCEDURES);
		}
		return procedures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Network getOwner() {
		return (Network) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Buffer> getBuffers() {
		EList<Buffer> buffers = new EObjectEList<Buffer>(Buffer.class, this, DataflowPackage.ACTOR__BUFFERS);
		for (Buffer buffer : getIncomingBuffers()) {
			if (!buffers.contains(buffer))
				buffers.add(buffer);
		}
		for (Buffer buffer : getOutgoingBuffers()) {
			if (!buffers.contains(buffer))
				buffers.add(buffer);
		}

		return buffers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Buffer> getIncomingBuffers() {
		EList<Buffer> buffers = new EObjectEList<Buffer>(Buffer.class, this, DataflowPackage.ACTOR__INCOMING_BUFFERS);
		for (Port port : getInputPorts()) {
			Buffer buffer = port.getInput();
			if (buffer != null && !buffers.contains(buffer)) {
				buffers.add(buffer);
			}
		}
		return buffers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Buffer> getOutgoingBuffers() {
		EList<Buffer> buffers = new EObjectEList<Buffer>(Buffer.class, this, DataflowPackage.ACTOR__OUTGOING_BUFFERS);
		for (Port port : getOutputPorts()) {
			for (Buffer buffer : port.getOutputs()) {
				if (!buffers.contains(buffer)) {
					buffers.add(buffer);
				}
			}
		}
		return buffers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Actor> getPredecessors() {
		List<Actor> predecessors = new ArrayList<>();
		for (Port port : getInputPorts()) {
			Buffer buffer = port.getInput();
			if (buffer != null) {
				Actor source = buffer.getSource().getOwner();
				if (!predecessors.contains(source)) {
					predecessors.add(source);
				}
			}
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Actor> getSuccessors() {
		List<Actor> successors = new ArrayList<>();
		for (Port port : getOutputPorts()) {
			for (Buffer buffer : port.getOutputs()) {
				Actor target = buffer.getTarget().getOwner();
				if (!successors.contains(target)) {
					successors.add(target);
				}
			}
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Action getAction(String name) {
		return actionsMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Port getInputPort(String name) {
		for (Port port : getInputPorts()) {
			if (name.equals(port.getName())) {
				return port;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Port getOutputPort(String name) {
		for (Port port : getOutputPorts()) {
			if (name.equals(port.getName())) {
				return port;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Variable getVariable(String name) {
		return variablesMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Procedure getProcedure(String name) {
		return proceduresMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SharedVariable getSharedVariable(String tag) {
		for (Variable variable : getVariables()) {
			if (variable instanceof SharedVariable) {
				SharedVariable sv = (SharedVariable) variable;
				if (tag.equals(sv.getTag())) {
					return sv;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			if (actorClass != null)
				msgs = ((InternalEObject) actorClass).eInverseRemove(this, DataflowPackage.ACTOR_CLASS__ACTORS,
						ActorClass.class, msgs);
			return basicSetActorClass((ActorClass) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DataflowPackage.ACTOR__INPUT_PORTS:
			return ((InternalEList<?>) getInputPorts()).basicRemove(otherEnd, msgs);
		case DataflowPackage.ACTOR__OUTPUT_PORTS:
			return ((InternalEList<?>) getOutputPorts()).basicRemove(otherEnd, msgs);
		case DataflowPackage.ACTOR__VARIABLES:
			return ((InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			return basicSetActorClass(null, msgs);
		case DataflowPackage.ACTOR__ACTIONS:
			return ((InternalEList<?>) getActions()).basicRemove(otherEnd, msgs);
		case DataflowPackage.ACTOR__PROCEDURES:
			return ((InternalEList<?>) getProcedures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DataflowPackage.ACTOR__NAME:
			return getName();
		case DataflowPackage.ACTOR__INPUT_PORTS:
			return getInputPorts();
		case DataflowPackage.ACTOR__OUTPUT_PORTS:
			return getOutputPorts();
		case DataflowPackage.ACTOR__VARIABLES:
			return getVariables();
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			if (resolve)
				return getActorClass();
			return basicGetActorClass();
		case DataflowPackage.ACTOR__ACTIONS:
			return getActions();
		case DataflowPackage.ACTOR__PROCEDURES:
			return getProcedures();
		case DataflowPackage.ACTOR__OWNER:
			return getOwner();
		case DataflowPackage.ACTOR__BUFFERS:
			return getBuffers();
		case DataflowPackage.ACTOR__INCOMING_BUFFERS:
			return getIncomingBuffers();
		case DataflowPackage.ACTOR__OUTGOING_BUFFERS:
			return getOutgoingBuffers();
		case DataflowPackage.ACTOR__PREDECESSORS:
			return getPredecessors();
		case DataflowPackage.ACTOR__SUCCESSORS:
			return getSuccessors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DataflowPackage.ACTOR__NAME:
			setName((String) newValue);
			return;
		case DataflowPackage.ACTOR__INPUT_PORTS:
			getInputPorts().clear();
			getInputPorts().addAll((Collection<? extends Port>) newValue);
			return;
		case DataflowPackage.ACTOR__OUTPUT_PORTS:
			getOutputPorts().clear();
			getOutputPorts().addAll((Collection<? extends Port>) newValue);
			return;
		case DataflowPackage.ACTOR__VARIABLES:
			getVariables().clear();
			getVariables().addAll((Collection<? extends Variable>) newValue);
			return;
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			setActorClass((ActorClass) newValue);
			return;
		case DataflowPackage.ACTOR__ACTIONS:
			getActions().clear();
			getActions().addAll((Collection<? extends Action>) newValue);
			return;
		case DataflowPackage.ACTOR__PROCEDURES:
			getProcedures().clear();
			getProcedures().addAll((Collection<? extends Procedure>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DataflowPackage.ACTOR__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DataflowPackage.ACTOR__INPUT_PORTS:
			getInputPorts().clear();
			return;
		case DataflowPackage.ACTOR__OUTPUT_PORTS:
			getOutputPorts().clear();
			return;
		case DataflowPackage.ACTOR__VARIABLES:
			getVariables().clear();
			return;
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			setActorClass((ActorClass) null);
			return;
		case DataflowPackage.ACTOR__ACTIONS:
			getActions().clear();
			return;
		case DataflowPackage.ACTOR__PROCEDURES:
			getProcedures().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DataflowPackage.ACTOR__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DataflowPackage.ACTOR__INPUT_PORTS:
			return inputPorts != null && !inputPorts.isEmpty();
		case DataflowPackage.ACTOR__OUTPUT_PORTS:
			return outputPorts != null && !outputPorts.isEmpty();
		case DataflowPackage.ACTOR__VARIABLES:
			return variables != null && !variables.isEmpty();
		case DataflowPackage.ACTOR__ACTOR_CLASS:
			return actorClass != null;
		case DataflowPackage.ACTOR__ACTIONS:
			return actions != null && !actions.isEmpty();
		case DataflowPackage.ACTOR__PROCEDURES:
			return procedures != null && !procedures.isEmpty();
		case DataflowPackage.ACTOR__OWNER:
			return getOwner() != null;
		case DataflowPackage.ACTOR__BUFFERS:
			return !getBuffers().isEmpty();
		case DataflowPackage.ACTOR__INCOMING_BUFFERS:
			return !getIncomingBuffers().isEmpty();
		case DataflowPackage.ACTOR__OUTGOING_BUFFERS:
			return !getOutgoingBuffers().isEmpty();
		case DataflowPackage.ACTOR__PREDECESSORS:
			return !getPredecessors().isEmpty();
		case DataflowPackage.ACTOR__SUCCESSORS:
			return !getSuccessors().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case DataflowPackage.ACTOR___GET_ACTION__STRING:
			return getAction((String) arguments.get(0));
		case DataflowPackage.ACTOR___GET_INPUT_PORT__STRING:
			return getInputPort((String) arguments.get(0));
		case DataflowPackage.ACTOR___GET_OUTPUT_PORT__STRING:
			return getOutputPort((String) arguments.get(0));
		case DataflowPackage.ACTOR___GET_VARIABLE__STRING:
			return getVariable((String) arguments.get(0));
		case DataflowPackage.ACTOR___GET_PROCEDURE__STRING:
			return getProcedure((String) arguments.get(0));
		case DataflowPackage.ACTOR___GET_SHARED_VARIABLE__STRING:
			return getSharedVariable((String) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[actor]");
		b.append(" name=").append(getName());
		return b.toString();
	}

} // ActorImpl

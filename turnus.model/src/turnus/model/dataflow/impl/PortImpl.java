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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.common.impl.AttributableImpl;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getWriters <em>Writers</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getReaders <em>Readers</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getInput <em>Input</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.PortImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortImpl extends AttributableImpl implements Port {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWriters() <em>Writers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriters()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> writers;

	/**
	 * The cached value of the '{@link #getReaders() <em>Readers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReaders()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> readers;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Buffer input;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> outputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.PORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Action> getWriters() {
		if (writers == null) {
			writers = new EObjectWithInverseResolvingEList.ManyInverse<Action>(Action.class, this, DataflowPackage.PORT__WRITERS, DataflowPackage.ACTION__OUTPUT_PORTS);
		}
		return writers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Action> getReaders() {
		if (readers == null) {
			readers = new EObjectWithInverseResolvingEList.ManyInverse<Action>(Action.class, this, DataflowPackage.PORT__READERS, DataflowPackage.ACTION__INPUT_PORTS);
		}
		return readers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer getInput() {
		if (input != null && input.eIsProxy()) {
			InternalEObject oldInput = (InternalEObject)input;
			input = (Buffer)eResolveProxy(oldInput);
			if (input != oldInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataflowPackage.PORT__INPUT, oldInput, input));
			}
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(Buffer newInput, NotificationChain msgs) {
		Buffer oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataflowPackage.PORT__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Buffer newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, DataflowPackage.BUFFER__TARGET, Buffer.class, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, DataflowPackage.BUFFER__TARGET, Buffer.class, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.PORT__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Buffer> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectWithInverseResolvingEList<Buffer>(Buffer.class, this, DataflowPackage.PORT__OUTPUTS, DataflowPackage.BUFFER__SOURCE);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Actor getOwner() {
		return (Actor) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.PORT__WRITERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWriters()).basicAdd(otherEnd, msgs);
			case DataflowPackage.PORT__READERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReaders()).basicAdd(otherEnd, msgs);
			case DataflowPackage.PORT__INPUT:
				if (input != null)
					msgs = ((InternalEObject)input).eInverseRemove(this, DataflowPackage.BUFFER__TARGET, Buffer.class, msgs);
				return basicSetInput((Buffer)otherEnd, msgs);
			case DataflowPackage.PORT__OUTPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.PORT__WRITERS:
				return ((InternalEList<?>)getWriters()).basicRemove(otherEnd, msgs);
			case DataflowPackage.PORT__READERS:
				return ((InternalEList<?>)getReaders()).basicRemove(otherEnd, msgs);
			case DataflowPackage.PORT__INPUT:
				return basicSetInput(null, msgs);
			case DataflowPackage.PORT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
			case DataflowPackage.PORT__NAME:
				return getName();
			case DataflowPackage.PORT__WRITERS:
				return getWriters();
			case DataflowPackage.PORT__READERS:
				return getReaders();
			case DataflowPackage.PORT__INPUT:
				if (resolve) return getInput();
				return basicGetInput();
			case DataflowPackage.PORT__OUTPUTS:
				return getOutputs();
			case DataflowPackage.PORT__OWNER:
				return getOwner();
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
			case DataflowPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case DataflowPackage.PORT__WRITERS:
				getWriters().clear();
				getWriters().addAll((Collection<? extends Action>)newValue);
				return;
			case DataflowPackage.PORT__READERS:
				getReaders().clear();
				getReaders().addAll((Collection<? extends Action>)newValue);
				return;
			case DataflowPackage.PORT__INPUT:
				setInput((Buffer)newValue);
				return;
			case DataflowPackage.PORT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Buffer>)newValue);
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
			case DataflowPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataflowPackage.PORT__WRITERS:
				getWriters().clear();
				return;
			case DataflowPackage.PORT__READERS:
				getReaders().clear();
				return;
			case DataflowPackage.PORT__INPUT:
				setInput((Buffer)null);
				return;
			case DataflowPackage.PORT__OUTPUTS:
				getOutputs().clear();
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
			case DataflowPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataflowPackage.PORT__WRITERS:
				return writers != null && !writers.isEmpty();
			case DataflowPackage.PORT__READERS:
				return readers != null && !readers.isEmpty();
			case DataflowPackage.PORT__INPUT:
				return input != null;
			case DataflowPackage.PORT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case DataflowPackage.PORT__OWNER:
				return getOwner() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PortImpl

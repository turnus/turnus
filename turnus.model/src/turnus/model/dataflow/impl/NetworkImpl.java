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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.common.impl.AttributableImpl;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.ActorClass;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.SharedVariable;
import turnus.model.dataflow.Variable;
import turnus.model.dataflow.util.NetworkAdapter;
import turnus.model.versioning.Version;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Network</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getProject <em>Project</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getActorClasses <em>Actor Classes</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getBuffers <em>Buffers</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getSharedVariables <em>Shared Variables</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.NetworkImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetworkImpl extends AttributableImpl implements Network {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected String sourceFile = SOURCE_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected String project = PROJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> actors;

	/**
	 * The cached value of the '{@link #getActorClasses() <em>Actor Classes</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getActorClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorClass> actorClasses;

	/**
	 * The cached value of the '{@link #getBuffers() <em>Buffers</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> buffers;

	/**
	 * The cached value of the '{@link #getInputPorts() <em>Input Ports</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputPorts;

	/**
	 * The cached value of the '{@link #getOutputPorts() <em>Output Ports</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputPorts;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version;

	/**
	 * The map of actors and names
	 * 
	 * @see #getActor(String)
	 */
	private BiMap<String, Actor> actorsMap;

	/**
	 * The map of actor-classes and names
	 * 
	 * @see #getActorClass(String)
	 */
	private BiMap<String, ActorClass> actorClassesMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected NetworkImpl() {
		super();

		actorsMap = HashBiMap.create();
		actorClassesMap = HashBiMap.create();

		eAdapters().add(new NetworkAdapter(actorsMap, actorClassesMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.NETWORK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.NETWORK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFile() {
		return sourceFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFile(String newSourceFile) {
		String oldSourceFile = sourceFile;
		sourceFile = newSourceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.NETWORK__SOURCE_FILE, oldSourceFile, sourceFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(String newProject) {
		String oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.NETWORK__PROJECT, oldProject, project));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Actor> getActors() {
		if (actors == null) {
			actors = new EObjectContainmentEList<Actor>(Actor.class, this, DataflowPackage.NETWORK__ACTORS);
		}
		return actors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<ActorClass> getActorClasses() {
		if (actorClasses == null) {
			actorClasses = new EObjectContainmentEList<ActorClass>(ActorClass.class, this, DataflowPackage.NETWORK__ACTOR_CLASSES);
		}
		return actorClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Buffer> getBuffers() {
		if (buffers == null) {
			buffers = new EObjectContainmentEList<Buffer>(Buffer.class, this, DataflowPackage.NETWORK__BUFFERS);
		}
		return buffers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Port> getInputPorts() {
		if (inputPorts == null) {
			inputPorts = new EObjectContainmentEList<Port>(Port.class, this, DataflowPackage.NETWORK__INPUT_PORTS);
		}
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<Port> getOutputPorts() {
		if (outputPorts == null) {
			outputPorts = new EObjectContainmentEList<Port>(Port.class, this, DataflowPackage.NETWORK__OUTPUT_PORTS);
		}
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<SharedVariable> getSharedVariables() {
		List<SharedVariable> sharedVars = new EObjectEList<SharedVariable>(
				SharedVariable.class, this,
				DataflowPackage.NETWORK__SHARED_VARIABLES);

		for (Actor actor : getActors()) {
			for (Variable variable : actor.getVariables()) {
				if (variable instanceof SharedVariable) {
					sharedVars.add((SharedVariable) variable);
				}
			}
		}

		return sharedVars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(Version newVersion,
			NotificationChain msgs) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataflowPackage.NETWORK__VERSION, oldVersion, newVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Version newVersion) {
		if (newVersion != version) {
			NotificationChain msgs = null;
			if (version != null)
				msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.NETWORK__VERSION, null, msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataflowPackage.NETWORK__VERSION, null, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.NETWORK__VERSION, newVersion, newVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Actor getActor(String name) {
		return actorsMap.get(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ActorClass getActorClass(String name) {
		return actorClassesMap.get(name);
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
	public List<SharedVariable> getSharedVariables(String tag) {
		List<SharedVariable> sharedVars = new BasicInternalEList<SharedVariable>(
				SharedVariable.class);
		for (SharedVariable variable : getSharedVariables()) {
			if (tag.equals(variable.getTag()))
				sharedVars.add(variable);
		}
		return sharedVars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.NETWORK__ACTORS:
				return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
			case DataflowPackage.NETWORK__ACTOR_CLASSES:
				return ((InternalEList<?>)getActorClasses()).basicRemove(otherEnd, msgs);
			case DataflowPackage.NETWORK__BUFFERS:
				return ((InternalEList<?>)getBuffers()).basicRemove(otherEnd, msgs);
			case DataflowPackage.NETWORK__INPUT_PORTS:
				return ((InternalEList<?>)getInputPorts()).basicRemove(otherEnd, msgs);
			case DataflowPackage.NETWORK__OUTPUT_PORTS:
				return ((InternalEList<?>)getOutputPorts()).basicRemove(otherEnd, msgs);
			case DataflowPackage.NETWORK__VERSION:
				return basicSetVersion(null, msgs);
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
			case DataflowPackage.NETWORK__NAME:
				return getName();
			case DataflowPackage.NETWORK__SOURCE_FILE:
				return getSourceFile();
			case DataflowPackage.NETWORK__PROJECT:
				return getProject();
			case DataflowPackage.NETWORK__ACTORS:
				return getActors();
			case DataflowPackage.NETWORK__ACTOR_CLASSES:
				return getActorClasses();
			case DataflowPackage.NETWORK__BUFFERS:
				return getBuffers();
			case DataflowPackage.NETWORK__INPUT_PORTS:
				return getInputPorts();
			case DataflowPackage.NETWORK__OUTPUT_PORTS:
				return getOutputPorts();
			case DataflowPackage.NETWORK__SHARED_VARIABLES:
				return getSharedVariables();
			case DataflowPackage.NETWORK__VERSION:
				return getVersion();
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
			case DataflowPackage.NETWORK__NAME:
				setName((String)newValue);
				return;
			case DataflowPackage.NETWORK__SOURCE_FILE:
				setSourceFile((String)newValue);
				return;
			case DataflowPackage.NETWORK__PROJECT:
				setProject((String)newValue);
				return;
			case DataflowPackage.NETWORK__ACTORS:
				getActors().clear();
				getActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case DataflowPackage.NETWORK__ACTOR_CLASSES:
				getActorClasses().clear();
				getActorClasses().addAll((Collection<? extends ActorClass>)newValue);
				return;
			case DataflowPackage.NETWORK__BUFFERS:
				getBuffers().clear();
				getBuffers().addAll((Collection<? extends Buffer>)newValue);
				return;
			case DataflowPackage.NETWORK__INPUT_PORTS:
				getInputPorts().clear();
				getInputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case DataflowPackage.NETWORK__OUTPUT_PORTS:
				getOutputPorts().clear();
				getOutputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case DataflowPackage.NETWORK__VERSION:
				setVersion((Version)newValue);
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
			case DataflowPackage.NETWORK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataflowPackage.NETWORK__SOURCE_FILE:
				setSourceFile(SOURCE_FILE_EDEFAULT);
				return;
			case DataflowPackage.NETWORK__PROJECT:
				setProject(PROJECT_EDEFAULT);
				return;
			case DataflowPackage.NETWORK__ACTORS:
				getActors().clear();
				return;
			case DataflowPackage.NETWORK__ACTOR_CLASSES:
				getActorClasses().clear();
				return;
			case DataflowPackage.NETWORK__BUFFERS:
				getBuffers().clear();
				return;
			case DataflowPackage.NETWORK__INPUT_PORTS:
				getInputPorts().clear();
				return;
			case DataflowPackage.NETWORK__OUTPUT_PORTS:
				getOutputPorts().clear();
				return;
			case DataflowPackage.NETWORK__VERSION:
				setVersion((Version)null);
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
			case DataflowPackage.NETWORK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataflowPackage.NETWORK__SOURCE_FILE:
				return SOURCE_FILE_EDEFAULT == null ? sourceFile != null : !SOURCE_FILE_EDEFAULT.equals(sourceFile);
			case DataflowPackage.NETWORK__PROJECT:
				return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
			case DataflowPackage.NETWORK__ACTORS:
				return actors != null && !actors.isEmpty();
			case DataflowPackage.NETWORK__ACTOR_CLASSES:
				return actorClasses != null && !actorClasses.isEmpty();
			case DataflowPackage.NETWORK__BUFFERS:
				return buffers != null && !buffers.isEmpty();
			case DataflowPackage.NETWORK__INPUT_PORTS:
				return inputPorts != null && !inputPorts.isEmpty();
			case DataflowPackage.NETWORK__OUTPUT_PORTS:
				return outputPorts != null && !outputPorts.isEmpty();
			case DataflowPackage.NETWORK__SHARED_VARIABLES:
				return !getSharedVariables().isEmpty();
			case DataflowPackage.NETWORK__VERSION:
				return version != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case DataflowPackage.NETWORK___GET_ACTOR__STRING:
				return getActor((String)arguments.get(0));
			case DataflowPackage.NETWORK___GET_ACTOR_CLASS__STRING:
				return getActorClass((String)arguments.get(0));
			case DataflowPackage.NETWORK___GET_INPUT_PORT__STRING:
				return getInputPort((String)arguments.get(0));
			case DataflowPackage.NETWORK___GET_OUTPUT_PORT__STRING:
				return getOutputPort((String)arguments.get(0));
			case DataflowPackage.NETWORK___GET_SHARED_VARIABLES__STRING:
				return getSharedVariables((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", sourceFile: ");
		result.append(sourceFile);
		result.append(", project: ");
		result.append(project);
		result.append(')');
		return result.toString();
	}

} // NetworkImpl

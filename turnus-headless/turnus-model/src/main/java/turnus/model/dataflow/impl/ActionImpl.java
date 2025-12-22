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
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import turnus.model.common.impl.AttributableImpl;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.DataflowPackage;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.map.MapPackage;
import turnus.model.dataflow.map.impl.PortsToLongMapImpl;
import turnus.model.dataflow.util.ActionAdapter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getGuards <em>Guards</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getProduction <em>Production</em>}</li>
 *   <li>{@link turnus.model.dataflow.impl.ActionImpl#getConsumption <em>Consumption</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends AttributableImpl implements Action {
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
	 * The cached value of the '{@link #getInputPorts() <em>Input Ports</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputPorts;

	/**
	 * The cached value of the '{@link #getOutputPorts() <em>Output Ports</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutputPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputPorts;

	/**
	 * The cached value of the '{@link #getGuards() <em>Guards</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<Guard> guards;

	/**
	 * The cached value of the '{@link #getProduction() <em>Production</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduction()
	 * @generated
	 * @ordered
	 */
	protected EMap<Port, Long> production;

	/**
	 * The cached value of the '{@link #getConsumption() <em>Consumption</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumption()
	 * @generated
	 * @ordered
	 */
	protected EMap<Port, Long> consumption;

	/**
	 * The map of guard and tags
	 * 
	 * @see #getGuard(String)
	 */
	private BiMap<String, Guard> guardsMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ActionImpl() {
		super();

		guardsMap = HashBiMap.create();

		eAdapters().add(new ActionAdapter(guardsMap));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataflowPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataflowPackage.ACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Port> getInputPorts() {
		if (inputPorts == null) {
			inputPorts = new EObjectWithInverseResolvingEList.ManyInverse<Port>(Port.class, this, DataflowPackage.ACTION__INPUT_PORTS, DataflowPackage.PORT__READERS);
		}
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Port> getOutputPorts() {
		if (outputPorts == null) {
			outputPorts = new EObjectWithInverseResolvingEList.ManyInverse<Port>(Port.class, this, DataflowPackage.ACTION__OUTPUT_PORTS, DataflowPackage.PORT__WRITERS);
		}
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Guard> getGuards() {
		if (guards == null) {
			guards = new EObjectContainmentEList<Guard>(Guard.class, this, DataflowPackage.ACTION__GUARDS);
		}
		return guards;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	@Override
	public Map<Port, Long> getProduction() {
		if (production == null) {
			production = new EcoreEMap<Port,Long>(MapPackage.Literals.PORTS_TO_LONG_MAP, PortsToLongMapImpl.class, this, DataflowPackage.ACTION__PRODUCTION);
		}
		return production.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map<Port, Long> getConsumption() {
		if (consumption == null) {
			consumption = new EcoreEMap<Port,Long>(MapPackage.Literals.PORTS_TO_LONG_MAP, PortsToLongMapImpl.class, this, DataflowPackage.ACTION__CONSUMPTION);
		}
		return consumption.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Guard getGuard(String tag) {
		return guardsMap.get(tag);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataflowPackage.ACTION__INPUT_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputPorts()).basicAdd(otherEnd, msgs);
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputPorts()).basicAdd(otherEnd, msgs);
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
			case DataflowPackage.ACTION__INPUT_PORTS:
				return ((InternalEList<?>)getInputPorts()).basicRemove(otherEnd, msgs);
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				return ((InternalEList<?>)getOutputPorts()).basicRemove(otherEnd, msgs);
			case DataflowPackage.ACTION__GUARDS:
				return ((InternalEList<?>)getGuards()).basicRemove(otherEnd, msgs);
			case DataflowPackage.ACTION__PRODUCTION:
				return ((InternalEList<?>)((EMap.InternalMapView<Port, Long>)getProduction()).eMap()).basicRemove(otherEnd, msgs);
			case DataflowPackage.ACTION__CONSUMPTION:
				return ((InternalEList<?>)((EMap.InternalMapView<Port, Long>)getConsumption()).eMap()).basicRemove(otherEnd, msgs);
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
			case DataflowPackage.ACTION__NAME:
				return getName();
			case DataflowPackage.ACTION__INPUT_PORTS:
				return getInputPorts();
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				return getOutputPorts();
			case DataflowPackage.ACTION__GUARDS:
				return getGuards();
			case DataflowPackage.ACTION__OWNER:
				return getOwner();
			case DataflowPackage.ACTION__PRODUCTION:
				if (coreType) return ((EMap.InternalMapView<Port, Long>)getProduction()).eMap();
				else return getProduction();
			case DataflowPackage.ACTION__CONSUMPTION:
				if (coreType) return ((EMap.InternalMapView<Port, Long>)getConsumption()).eMap();
				else return getConsumption();
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
			case DataflowPackage.ACTION__NAME:
				setName((String)newValue);
				return;
			case DataflowPackage.ACTION__INPUT_PORTS:
				getInputPorts().clear();
				getInputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				getOutputPorts().clear();
				getOutputPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case DataflowPackage.ACTION__GUARDS:
				getGuards().clear();
				getGuards().addAll((Collection<? extends Guard>)newValue);
				return;
			case DataflowPackage.ACTION__PRODUCTION:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Port, Long>)getProduction()).eMap()).set(newValue);
				return;
			case DataflowPackage.ACTION__CONSUMPTION:
				((EStructuralFeature.Setting)((EMap.InternalMapView<Port, Long>)getConsumption()).eMap()).set(newValue);
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
			case DataflowPackage.ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataflowPackage.ACTION__INPUT_PORTS:
				getInputPorts().clear();
				return;
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				getOutputPorts().clear();
				return;
			case DataflowPackage.ACTION__GUARDS:
				getGuards().clear();
				return;
			case DataflowPackage.ACTION__PRODUCTION:
				getProduction().clear();
				return;
			case DataflowPackage.ACTION__CONSUMPTION:
				getConsumption().clear();
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
			case DataflowPackage.ACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataflowPackage.ACTION__INPUT_PORTS:
				return inputPorts != null && !inputPorts.isEmpty();
			case DataflowPackage.ACTION__OUTPUT_PORTS:
				return outputPorts != null && !outputPorts.isEmpty();
			case DataflowPackage.ACTION__GUARDS:
				return guards != null && !guards.isEmpty();
			case DataflowPackage.ACTION__OWNER:
				return getOwner() != null;
			case DataflowPackage.ACTION__PRODUCTION:
				return production != null && !production.isEmpty();
			case DataflowPackage.ACTION__CONSUMPTION:
				return consumption != null && !consumption.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DataflowPackage.ACTION___GET_GUARD__STRING:
				return getGuard((String)arguments.get(0));
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
		b.append("[action]");
		b.append(" name=").append(getName());
		b.append(" actor=").append(getOwner().getName());
		return b.toString();
	}

} // ActionImpl

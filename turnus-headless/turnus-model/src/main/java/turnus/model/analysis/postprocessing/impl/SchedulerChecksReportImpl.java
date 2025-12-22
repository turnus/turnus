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
package turnus.model.analysis.postprocessing.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import turnus.model.analysis.postprocessing.PostprocessingPackage;
import turnus.model.analysis.postprocessing.SchedulerChecksPartition;
import turnus.model.analysis.postprocessing.SchedulerChecksReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Checks Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.impl.SchedulerChecksReportImpl#getNetwork <em>Network</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulerChecksReportImpl extends PostProcessingDataImpl implements SchedulerChecksReport {
	/**
	 * The cached value of the '{@link #getPartitions() <em>Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulerChecksPartition> partitions;
	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerChecksReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PostprocessingPackage.Literals.SCHEDULER_CHECKS_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<SchedulerChecksPartition> getPartitions() {
		if (partitions == null) {
			partitions = new EObjectContainmentEList<SchedulerChecksPartition>(SchedulerChecksPartition.class, this, PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS);
		}
		return partitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS:
				return ((InternalEList<?>)getPartitions()).basicRemove(otherEnd, msgs);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS:
				return getPartitions();
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
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
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS:
				getPartitions().clear();
				getPartitions().addAll((Collection<? extends SchedulerChecksPartition>)newValue);
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK:
				setNetwork((Network)newValue);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS:
				getPartitions().clear();
				return;
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK:
				setNetwork((Network)null);
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
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__PARTITIONS:
				return partitions != null && !partitions.isEmpty();
			case PostprocessingPackage.SCHEDULER_CHECKS_REPORT__NETWORK:
				return network != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("\n[SCHEDULER CHECKS REPORT]");
		int partition = 1;
		for (SchedulerChecksPartition data : getPartitions()) {
			b.append(String.format("\n Partition (%d):\n", partition++));
			b.append("\t checked conditions: \n");
			b.append(String.format("\t\t total: %.2f \n", data.getAggregatedCheckedData().getSum()));
			b.append(String.format("\t\t average: %.2f \n", data.getAggregatedCheckedData().getMean()));
			b.append(String.format("\t\t max: %.2f \n", data.getAggregatedCheckedData().getMax()));
			b.append(String.format("\t\t min: %.2f \n", data.getAggregatedCheckedData().getMin()));
			b.append("\t failed conditions: \n");
			b.append(String.format("\t\t total: %.2f \n", data.getAggregatedFailedData().getSum()));
			b.append(String.format("\t\t average: %.2f \n", data.getAggregatedFailedData().getMean()));
			b.append(String.format("\t\t max: %.2f \n", data.getAggregatedFailedData().getMax()));
			b.append(String.format("\t\t min: %.2f \n", data.getAggregatedFailedData().getMin()));
			b.append("\n\n\t Actors:\n");
			for (Actor actor : data.getCheckedConditionsMap().keySet()) {
				b.append("\t\t " + actor.getName() + ": \n");
				b.append("\t\t\t total conditions checked: " + data.getCheckedConditionsMap().get(actor).getSum() + "\n");
				b.append("\t\t\t total conditions failed: " + data.getFailedConditionsMap().get(actor).getSum() + "\n");
			}
		}

		b.append("\n\n");

		return b.toString();
	}

} //SchedulerChecksReportImpl

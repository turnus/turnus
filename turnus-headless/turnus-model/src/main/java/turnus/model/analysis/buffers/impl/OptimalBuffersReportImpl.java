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
package turnus.model.analysis.buffers.impl;

import static turnus.common.util.StringUtils.format;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;

import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersPackage;
import turnus.model.analysis.buffers.OptimalBufferData;
import turnus.model.analysis.buffers.OptimalBuffersReport;

import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Optimal Buffers Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#isPow2 <em>Pow2</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#isBitAccurate <em>Bit Accurate</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getBuffersData <em>Buffers Data</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getInitialBufferConfiguration <em>Initial Buffer Configuration</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.OptimalBuffersReportImpl#getInitialBottlenecks <em>Initial Bottlenecks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptimalBuffersReportImpl extends MinimalEObjectImpl.Container implements OptimalBuffersReport {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNetwork() <em>Network</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNetwork()
	 * @generated
	 * @ordered
	 */
	protected Network network;

	/**
	 * The default value of the '{@link #isPow2() <em>Pow2</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPow2()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POW2_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPow2() <em>Pow2</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isPow2()
	 * @generated
	 * @ordered
	 */
	protected boolean pow2 = POW2_EDEFAULT;

	/**
	 * The default value of the '{@link #isBitAccurate() <em>Bit Accurate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isBitAccurate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIT_ACCURATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBitAccurate() <em>Bit Accurate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isBitAccurate()
	 * @generated
	 * @ordered
	 */
	protected boolean bitAccurate = BIT_ACCURATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBuffersData() <em>Buffers Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBuffersData()
	 * @generated
	 * @ordered
	 */
	protected EList<OptimalBufferData> buffersData;

	/**
	 * The cached value of the '{@link #getInitialBufferConfiguration()
	 * <em>Initial Buffer Configuration</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitialBufferConfiguration()
	 * @generated
	 * @ordered
	 */
	protected BoundedBuffersReport initialBufferConfiguration;

	/**
	 * The cached value of the '{@link #getInitialBottlenecks() <em>Initial Bottlenecks</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getInitialBottlenecks()
	 * @generated
	 * @ordered
	 */
	protected BottlenecksWithSchedulingReport initialBottlenecks;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimalBuffersReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuffersPackage.Literals.OPTIMAL_BUFFERS_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK, oldNetwork, network));
			}
		}
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Network basicGetNetwork() {
		return network;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPow2() {
		return pow2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPow2(boolean newPow2) {
		boolean oldPow2 = pow2;
		pow2 = newPow2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__POW2, oldPow2, pow2));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBitAccurate() {
		return bitAccurate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBitAccurate(boolean newBitAccurate) {
		boolean oldBitAccurate = bitAccurate;
		bitAccurate = newBitAccurate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE, oldBitAccurate, bitAccurate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<OptimalBufferData> getBuffersData() {
		if (buffersData == null) {
			buffersData = new EObjectContainmentEList<OptimalBufferData>(OptimalBufferData.class, this, BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA);
		}
		return buffersData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoundedBuffersReport getInitialBufferConfiguration() {
		return initialBufferConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialBufferConfiguration(BoundedBuffersReport newInitialBufferConfiguration,
			NotificationChain msgs) {
		BoundedBuffersReport oldInitialBufferConfiguration = initialBufferConfiguration;
		initialBufferConfiguration = newInitialBufferConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION, oldInitialBufferConfiguration, newInitialBufferConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialBufferConfiguration(BoundedBuffersReport newInitialBufferConfiguration) {
		if (newInitialBufferConfiguration != initialBufferConfiguration) {
			NotificationChain msgs = null;
			if (initialBufferConfiguration != null)
				msgs = ((InternalEObject)initialBufferConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION, null, msgs);
			if (newInitialBufferConfiguration != null)
				msgs = ((InternalEObject)newInitialBufferConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION, null, msgs);
			msgs = basicSetInitialBufferConfiguration(newInitialBufferConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION, newInitialBufferConfiguration, newInitialBufferConfiguration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksWithSchedulingReport getInitialBottlenecks() {
		return initialBottlenecks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialBottlenecks(BottlenecksWithSchedulingReport newInitialBottlenecks,
			NotificationChain msgs) {
		BottlenecksWithSchedulingReport oldInitialBottlenecks = initialBottlenecks;
		initialBottlenecks = newInitialBottlenecks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS, oldInitialBottlenecks, newInitialBottlenecks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialBottlenecks(BottlenecksWithSchedulingReport newInitialBottlenecks) {
		if (newInitialBottlenecks != initialBottlenecks) {
			NotificationChain msgs = null;
			if (initialBottlenecks != null)
				msgs = ((InternalEObject)initialBottlenecks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS, null, msgs);
			if (newInitialBottlenecks != null)
				msgs = ((InternalEObject)newInitialBottlenecks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS, null, msgs);
			msgs = basicSetInitialBottlenecks(newInitialBottlenecks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS, newInitialBottlenecks, newInitialBottlenecks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA:
				return ((InternalEList<?>)getBuffersData()).basicRemove(otherEnd, msgs);
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION:
				return basicSetInitialBufferConfiguration(null, msgs);
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS:
				return basicSetInitialBottlenecks(null, msgs);
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
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__ALGORITHM:
				return getAlgorithm();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__DATE:
				return getDate();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__POW2:
				return isPow2();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE:
				return isBitAccurate();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA:
				return getBuffersData();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION:
				return getInitialBufferConfiguration();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS:
				return getInitialBottlenecks();
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
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__POW2:
				setPow2((Boolean)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE:
				setBitAccurate((Boolean)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
				getBuffersData().addAll((Collection<? extends OptimalBufferData>)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION:
				setInitialBufferConfiguration((BoundedBuffersReport)newValue);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS:
				setInitialBottlenecks((BottlenecksWithSchedulingReport)newValue);
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
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__POW2:
				setPow2(POW2_EDEFAULT);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE:
				setBitAccurate(BIT_ACCURATE_EDEFAULT);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION:
				setInitialBufferConfiguration((BoundedBuffersReport)null);
				return;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS:
				setInitialBottlenecks((BottlenecksWithSchedulingReport)null);
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
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__NETWORK:
				return network != null;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__POW2:
				return pow2 != POW2_EDEFAULT;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BIT_ACCURATE:
				return bitAccurate != BIT_ACCURATE_EDEFAULT;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__BUFFERS_DATA:
				return buffersData != null && !buffersData.isEmpty();
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BUFFER_CONFIGURATION:
				return initialBufferConfiguration != null;
			case BuffersPackage.OPTIMAL_BUFFERS_REPORT__INITIAL_BOTTLENECKS:
				return initialBottlenecks != null;
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
		b.append("\n[OPTIMAL BUFFER SIZE REPORT]");
		b.append(String.format("\n Network.....: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithms..: %s", getAlgorithm()));
		b.append(String.format("\n Bit accurate: %s", isBitAccurate()));
		b.append(String.format("\n Power of 2..: %s", isPow2()));

		double nominal_execution_time = getInitialBottlenecks().getExecutionTime();
		double nominal_cp = getInitialBottlenecks().getCpWeight();
		int nominal_tokens = getInitialBufferConfiguration().getTokenSize();
		long nominal_bit = getInitialBufferConfiguration().getBitSize();

		List<OptimalBufferData> dataList = getBuffersData();
		if (dataList.isEmpty()) {
			b.append("\n No possible optimization found!");
		} else {
			b.append("\n\n");
			b.append("-------------------------------------------------------------------------\n");
			b.append("| conf \t| time \t\t| cp workload \t| tokens \t| bit \t\t| \n");
			b.append("-------------------------------------------------------------------------\n");
			
			int iteration = 1;
			for (OptimalBufferData o : dataList) {
				double execution_time = o.getBottlenecksData().getExecutionTime();
				double cp = o.getBottlenecksData().getCpWeight();
				int tokens = o.getBufferData().getTokenSize();
				long bit = o.getBufferData().getBitSize();

				double execution_time_reduction = ((nominal_execution_time - execution_time) / nominal_execution_time) * 100.0;
				double cp_reduction = 0;
				if (nominal_cp != 0 && cp != 0) {
					cp_reduction = (1.0 - cp / nominal_cp) * 100.0;
				}
				
				double bit_increase, tokens_increase;
				if (tokens > nominal_tokens) {
					bit_increase = (((double) bit) / nominal_bit - 1) * 100.0;
					tokens_increase = (((double) tokens) / nominal_tokens - 1) * 100.0;
				}
				else {
					bit_increase = (1 - ((double) nominal_bit) / bit) * 100.0;
					tokens_increase = (1 - ((double) nominal_tokens) / tokens) * 100.0;
				}
				
				if (cp_reduction != 0) {
					b.append("| " + iteration + " \t| " + format(-1 * execution_time_reduction) + "% \t| " + format(-1 * cp_reduction) + "% \t| " 
						+ format(tokens_increase) + "% \t| " + format(bit_increase) + "% \t| \n");
				}
				else {
					b.append("| " + iteration + " \t| " + format(-1 * execution_time_reduction) + "% \t| -------- \t| " 
							+ format(tokens_increase) + "% \t| " + format(bit_increase) + "% \t| \n");
				}
				
				iteration++;
			}
			b.append("-------------------------------------------------------------------------\n");
		}

		b.append("\n\n");

		return b.toString();
	}

} // OptimalBuffersReportImpl

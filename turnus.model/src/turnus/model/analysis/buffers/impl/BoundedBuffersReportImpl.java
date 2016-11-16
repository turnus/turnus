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

import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.BuffersPackage;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bounded Buffers Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#isPow2 <em>Pow2</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#isBitAccurate <em>Bit Accurate</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getBuffersData <em>Buffers Data</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getTokenSize <em>Token Size</em>}</li>
 *   <li>{@link turnus.model.analysis.buffers.impl.BoundedBuffersReportImpl#getBitSize <em>Bit Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundedBuffersReportImpl extends MinimalEObjectImpl.Container implements BoundedBuffersReport {
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
	protected EList<BoundedBufferData> buffersData;

	/**
	 * The default value of the '{@link #getTokenSize() <em>Token Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTokenSize()
	 * @generated
	 * @ordered
	 */
	protected static final int TOKEN_SIZE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getBitSize() <em>Bit Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBitSize()
	 * @generated
	 * @ordered
	 */
	protected static final int BIT_SIZE_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedBuffersReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BuffersPackage.Literals.BOUNDED_BUFFERS_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFERS_REPORT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFERS_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Network getNetwork() {
		if (network != null && network.eIsProxy()) {
			InternalEObject oldNetwork = (InternalEObject)network;
			network = (Network)eResolveProxy(oldNetwork);
			if (network != oldNetwork) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK, oldNetwork, network));
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
	public void setNetwork(Network newNetwork) {
		Network oldNetwork = network;
		network = newNetwork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPow2() {
		return pow2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPow2(boolean newPow2) {
		boolean oldPow2 = pow2;
		pow2 = newPow2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFERS_REPORT__POW2, oldPow2, pow2));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBitAccurate() {
		return bitAccurate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitAccurate(boolean newBitAccurate) {
		boolean oldBitAccurate = bitAccurate;
		bitAccurate = newBitAccurate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_ACCURATE, oldBitAccurate, bitAccurate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List<BoundedBufferData> getBuffersData() {
		if (buffersData == null) {
			buffersData = new EObjectContainmentEList<BoundedBufferData>(BoundedBufferData.class, this, BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA);
		}
		return buffersData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getTokenSize() {
		int sum = 0;

		for (BoundedBufferData data : getBuffersData()) {
			sum += data.getTokenSize();
		}

		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getBitSize() {
		int sum = 0;

		for (BoundedBufferData data : getBuffersData()) {
			sum += data.getBitSize();
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
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA:
				return ((InternalEList<?>)getBuffersData()).basicRemove(otherEnd, msgs);
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
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__ALGORITHM:
				return getAlgorithm();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__DATE:
				return getDate();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__POW2:
				return isPow2();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_ACCURATE:
				return isBitAccurate();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA:
				return getBuffersData();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__TOKEN_SIZE:
				return getTokenSize();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_SIZE:
				return getBitSize();
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
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__POW2:
				setPow2((Boolean)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_ACCURATE:
				setBitAccurate((Boolean)newValue);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
				getBuffersData().addAll((Collection<? extends BoundedBufferData>)newValue);
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
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__POW2:
				setPow2(POW2_EDEFAULT);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_ACCURATE:
				setBitAccurate(BIT_ACCURATE_EDEFAULT);
				return;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA:
				getBuffersData().clear();
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
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__NETWORK:
				return network != null;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__POW2:
				return pow2 != POW2_EDEFAULT;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_ACCURATE:
				return bitAccurate != BIT_ACCURATE_EDEFAULT;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BUFFERS_DATA:
				return buffersData != null && !buffersData.isEmpty();
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__TOKEN_SIZE:
				return getTokenSize() != TOKEN_SIZE_EDEFAULT;
			case BuffersPackage.BOUNDED_BUFFERS_REPORT__BIT_SIZE:
				return getBitSize() != BIT_SIZE_EDEFAULT;
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
		b.append("\n[BOUNDED BUFFER SIZE REPORT]");
		b.append(String.format("\n Network.....: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithms..: %s", getAlgorithm()));
		b.append(String.format("\n Bit accurate: %s", isBitAccurate()));
		b.append(String.format("\n Power of 2..: %s", isPow2()));
		b.append(String.format("\n Tokens size.: %d", getTokenSize()));
		b.append(String.format("\n Bit size....: %d", getBitSize()));
		b.append("\n\n");

		return b.toString();
	}

	@Override
	public BufferSize asBufferSize() {
		BufferSize bs = new BufferSize(getNetwork());
		for (BoundedBufferData data : getBuffersData()) {
			bs.setSize(data.getBuffer(), data.getTokenSize());
		}
		return bs;
	}

} // BoundedBuffersReportImpl

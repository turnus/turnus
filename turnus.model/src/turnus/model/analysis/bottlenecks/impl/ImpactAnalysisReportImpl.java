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
package turnus.model.analysis.bottlenecks.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import turnus.common.util.StringUtils;
import turnus.model.analysis.bottlenecks.BottlenecksPackage;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.ImpactAnalysisData;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Impact Analysis Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#isClassLevel <em>Class Level</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#getImpactData <em>Impact Data</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.impl.ImpactAnalysisReportImpl#getInitialBottlenecks <em>Initial Bottlenecks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpactAnalysisReportImpl extends MinimalEObjectImpl.Container implements ImpactAnalysisReport {
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
	 * The default value of the '{@link #isClassLevel() <em>Class Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isClassLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLASS_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClassLevel() <em>Class Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isClassLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean classLevel = CLASS_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImpactData() <em>Impact Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImpactData()
	 * @generated
	 * @ordered
	 */
	protected EList<ImpactAnalysisData> impactData;

	/**
	 * The cached value of the '{@link #getInitialBottlenecks() <em>Initial Bottlenecks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialBottlenecks()
	 * @generated
	 * @ordered
	 */
	protected BottlenecksReport initialBottlenecks;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactAnalysisReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BottlenecksPackage.Literals.IMPACT_ANALYSIS_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__DATE, oldDate, date));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK, oldNetwork, network));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK, oldNetwork, network));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClassLevel() {
		return classLevel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassLevel(boolean newClassLevel) {
		boolean oldClassLevel = classLevel;
		classLevel = newClassLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__CLASS_LEVEL, oldClassLevel, classLevel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ImpactAnalysisData> getImpactData() {
		if (impactData == null) {
			impactData = new EObjectContainmentEList<ImpactAnalysisData>(ImpactAnalysisData.class, this, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA);
		}
		return impactData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksReport getInitialBottlenecks() {
		return initialBottlenecks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialBottlenecks(BottlenecksReport newInitialBottlenecks, NotificationChain msgs) {
		BottlenecksReport oldInitialBottlenecks = initialBottlenecks;
		initialBottlenecks = newInitialBottlenecks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS, oldInitialBottlenecks, newInitialBottlenecks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialBottlenecks(BottlenecksReport newInitialBottlenecks) {
		if (newInitialBottlenecks != initialBottlenecks) {
			NotificationChain msgs = null;
			if (initialBottlenecks != null)
				msgs = ((InternalEObject)initialBottlenecks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS, null, msgs);
			if (newInitialBottlenecks != null)
				msgs = ((InternalEObject)newInitialBottlenecks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS, null, msgs);
			msgs = basicSetInitialBottlenecks(newInitialBottlenecks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS, newInitialBottlenecks, newInitialBottlenecks));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA:
				return ((InternalEList<?>)getImpactData()).basicRemove(otherEnd, msgs);
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS:
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
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__ALGORITHM:
				return getAlgorithm();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__DATE:
				return getDate();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK:
				if (resolve) return getNetwork();
				return basicGetNetwork();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__CLASS_LEVEL:
				return isClassLevel();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA:
				return getImpactData();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS:
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
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK:
				setNetwork((Network)newValue);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__CLASS_LEVEL:
				setClassLevel((Boolean)newValue);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA:
				getImpactData().clear();
				getImpactData().addAll((Collection<? extends ImpactAnalysisData>)newValue);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS:
				setInitialBottlenecks((BottlenecksReport)newValue);
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
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK:
				setNetwork((Network)null);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__CLASS_LEVEL:
				setClassLevel(CLASS_LEVEL_EDEFAULT);
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA:
				getImpactData().clear();
				return;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS:
				setInitialBottlenecks((BottlenecksReport)null);
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
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__NETWORK:
				return network != null;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__CLASS_LEVEL:
				return classLevel != CLASS_LEVEL_EDEFAULT;
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__IMPACT_DATA:
				return impactData != null && !impactData.isEmpty();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT__INITIAL_BOTTLENECKS:
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
		b.append("\n[IMPACT ANALYSIS REPORT]");
		b.append(String.format("\n Network..........: %s", getNetwork().getName()));
		b.append(String.format("\n Algorithms.......: %s", getAlgorithm()));
		b.append(String.format("\n Actor-class level: %s", isClassLevel()));

		int analysisNumber = 0;
		for (ImpactAnalysisData data : getImpactData()) {
			analysisNumber++;
			b.append(String.format("\n\nAnalysis number %d. Actions: ", analysisNumber));
			for (Action action : data.getActions()) {
				String name = action.getOwner().getName() + "," + action.getName();
				b.append("(").append(name).append(") ");
			}

			b.append("\n");
			b.append("\n |-----------------------------------|");
			b.append("\n | weightReduction | cpReduction     |");
			b.append("\n |-----------------------------------|");
			Map<Double, Double> map = data.getCpReductionMap();
			List<Double> ratios = new ArrayList<>(map.keySet());
			Collections.sort(ratios);
			for (Double ratio : ratios) {
				b.append(String.format("\n | %-15s | %-15s |", StringUtils.format(ratio),
						StringUtils.format(map.get(ratio))));
			}
			b.append("\n |-----------------------------------|");
			b.append("\n\n");
		}

		return b.toString();
	}

} // ImpactAnalysisReportImpl

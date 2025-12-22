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
package turnus.model.analysis.trace.impl;

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
import turnus.model.analysis.trace.ComparedTrace;
import turnus.model.analysis.trace.CompressedTraceReport;
import turnus.model.analysis.trace.TraceComparatorReport;
import turnus.model.analysis.trace.TracePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Comparator Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.impl.TraceComparatorReportImpl#getTraces <em>Traces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceComparatorReportImpl extends MinimalEObjectImpl.Container implements TraceComparatorReport {
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
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected CompressedTraceReport reference;

	/**
	 * The cached value of the '{@link #getTraces() <em>Traces</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<ComparedTrace> traces;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceComparatorReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_COMPARATOR_REPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_COMPARATOR_REPORT__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_COMPARATOR_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompressedTraceReport getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReference(CompressedTraceReport newReference, NotificationChain msgs) {
		CompressedTraceReport oldReference = reference;
		reference = newReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE, oldReference, newReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReference(CompressedTraceReport newReference) {
		if (newReference != reference) {
			NotificationChain msgs = null;
			if (reference != null)
				msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE, null, msgs);
			if (newReference != null)
				msgs = ((InternalEObject)newReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE, null, msgs);
			msgs = basicSetReference(newReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE, newReference, newReference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ComparedTrace> getTraces() {
		if (traces == null) {
			traces = new EObjectContainmentEList<ComparedTrace>(ComparedTrace.class, this, TracePackage.TRACE_COMPARATOR_REPORT__TRACES);
		}
		return traces;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE:
				return basicSetReference(null, msgs);
			case TracePackage.TRACE_COMPARATOR_REPORT__TRACES:
				return ((InternalEList<?>)getTraces()).basicRemove(otherEnd, msgs);
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
			case TracePackage.TRACE_COMPARATOR_REPORT__ALGORITHM:
				return getAlgorithm();
			case TracePackage.TRACE_COMPARATOR_REPORT__DATE:
				return getDate();
			case TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE:
				return getReference();
			case TracePackage.TRACE_COMPARATOR_REPORT__TRACES:
				return getTraces();
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
			case TracePackage.TRACE_COMPARATOR_REPORT__ALGORITHM:
				setAlgorithm((String)newValue);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__DATE:
				setDate((Date)newValue);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE:
				setReference((CompressedTraceReport)newValue);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends ComparedTrace>)newValue);
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
			case TracePackage.TRACE_COMPARATOR_REPORT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE:
				setReference((CompressedTraceReport)null);
				return;
			case TracePackage.TRACE_COMPARATOR_REPORT__TRACES:
				getTraces().clear();
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
			case TracePackage.TRACE_COMPARATOR_REPORT__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
			case TracePackage.TRACE_COMPARATOR_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case TracePackage.TRACE_COMPARATOR_REPORT__REFERENCE:
				return reference != null;
			case TracePackage.TRACE_COMPARATOR_REPORT__TRACES:
				return traces != null && !traces.isEmpty();
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
		b.append("\n[TRACE COMPARATOR REPORT]\n");
		b.append("Reference: ").append(getReference().getTraceFile()).append("\n");

		List<ComparedTrace> traces = getTraces();
		for (ComparedTrace trace : traces) {
			b.append("Trace (").append(traces.indexOf(trace)).append("): ");
			b.append(trace.getCompressedTrace().getTraceFile());
			b.append(" equal=").append(trace.isEqual()).append("\n");
		}
		b.append("\n");

		return b.toString();
	}

} // TraceComparatorReportImpl

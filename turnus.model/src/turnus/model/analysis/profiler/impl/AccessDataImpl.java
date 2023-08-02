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
package turnus.model.analysis.profiler.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.analysis.profiler.AccessData;
import turnus.model.analysis.profiler.ProfilerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Access Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiler.impl.AccessDataImpl#getAccesses <em>Accesses</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.AccessDataImpl#getMin <em>Min</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.AccessDataImpl#getMax <em>Max</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.AccessDataImpl#getAverage <em>Average</em>}</li>
 *   <li>{@link turnus.model.analysis.profiler.impl.AccessDataImpl#getTotal <em>Total</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccessDataImpl extends MinimalEObjectImpl.Container implements AccessData {
	/**
	 * The default value of the '{@link #getAccesses() <em>Accesses</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccesses()
	 * @generated
	 * @ordered
	 */
	protected static final double ACCESSES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAccesses() <em>Accesses</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAccesses()
	 * @generated
	 * @ordered
	 */
	protected double accesses = ACCESSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected double min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected double max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverage() <em>Average</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAverage()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_EDEFAULT = 0.0;

	/**
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected double total = TOTAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilerPackage.Literals.ACCESS_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getAccesses() {
		return accesses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccesses(double newAccesses) {
		double oldAccesses = accesses;
		accesses = newAccesses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACCESS_DATA__ACCESSES, oldAccesses, accesses));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMin(double newMin) {
		double oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACCESS_DATA__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax(double newMax) {
		double oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACCESS_DATA__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public double getAverage() {
		return getAccesses() > 0 ? getTotal() / getAccesses() : 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotal(double newTotal) {
		double oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfilerPackage.ACCESS_DATA__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfilerPackage.ACCESS_DATA__ACCESSES:
				return getAccesses();
			case ProfilerPackage.ACCESS_DATA__MIN:
				return getMin();
			case ProfilerPackage.ACCESS_DATA__MAX:
				return getMax();
			case ProfilerPackage.ACCESS_DATA__AVERAGE:
				return getAverage();
			case ProfilerPackage.ACCESS_DATA__TOTAL:
				return getTotal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProfilerPackage.ACCESS_DATA__ACCESSES:
				setAccesses((Double)newValue);
				return;
			case ProfilerPackage.ACCESS_DATA__MIN:
				setMin((Double)newValue);
				return;
			case ProfilerPackage.ACCESS_DATA__MAX:
				setMax((Double)newValue);
				return;
			case ProfilerPackage.ACCESS_DATA__TOTAL:
				setTotal((Double)newValue);
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
			case ProfilerPackage.ACCESS_DATA__ACCESSES:
				setAccesses(ACCESSES_EDEFAULT);
				return;
			case ProfilerPackage.ACCESS_DATA__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case ProfilerPackage.ACCESS_DATA__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case ProfilerPackage.ACCESS_DATA__TOTAL:
				setTotal(TOTAL_EDEFAULT);
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
			case ProfilerPackage.ACCESS_DATA__ACCESSES:
				return accesses != ACCESSES_EDEFAULT;
			case ProfilerPackage.ACCESS_DATA__MIN:
				return min != MIN_EDEFAULT;
			case ProfilerPackage.ACCESS_DATA__MAX:
				return max != MAX_EDEFAULT;
			case ProfilerPackage.ACCESS_DATA__AVERAGE:
				return getAverage() != AVERAGE_EDEFAULT;
			case ProfilerPackage.ACCESS_DATA__TOTAL:
				return total != TOTAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (accesses: ");
		result.append(accesses);
		result.append(", min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(", total: ");
		result.append(total);
		result.append(')');
		return result.toString();
	}

} // AccessDataImpl

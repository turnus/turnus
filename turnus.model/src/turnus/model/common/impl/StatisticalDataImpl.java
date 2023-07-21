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
package turnus.model.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import turnus.model.common.CommonPackage;
import turnus.model.common.StatisticalData;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Statistical Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getMin
 * <em>Min</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getMax
 * <em>Max</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getMean
 * <em>Mean</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getVariance
 * <em>Variance</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getSum
 * <em>Sum</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getSamples
 * <em>Samples</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getSumOfLogs <em>Sum
 * Of Logs</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getSumOfSquares
 * <em>Sum Of Squares</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getGeometricMean
 * <em>Geometric Mean</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getSecondMoment
 * <em>Second Moment</em>}</li>
 * <li>{@link turnus.model.common.impl.StatisticalDataImpl#getStandardDeviation
 * <em>Standard Deviation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatisticalDataImpl extends MinimalEObjectImpl.Container implements StatisticalData {
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
	 * The default value of the '{@link #getMean() <em>Mean</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMean() <em>Mean</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMean()
	 * @generated
	 * @ordered
	 */
	protected double mean = MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariance() <em>Variance</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected static final double VARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected double variance = VARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSum() <em>Sum</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected static final double SUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSum() <em>Sum</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected double sum = SUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSamples() <em>Samples</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSamples()
	 * @generated
	 * @ordered
	 */
	protected static final long SAMPLES_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSamples() <em>Samples</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSamples()
	 * @generated
	 * @ordered
	 */
	protected long samples = SAMPLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSumOfLogs() <em>Sum Of Logs</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSumOfLogs()
	 * @generated
	 * @ordered
	 */
	protected static final double SUM_OF_LOGS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSumOfLogs() <em>Sum Of Logs</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSumOfLogs()
	 * @generated
	 * @ordered
	 */
	protected double sumOfLogs = SUM_OF_LOGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSumOfSquares() <em>Sum Of Squares</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSumOfSquares()
	 * @generated
	 * @ordered
	 */
	protected static final double SUM_OF_SQUARES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSumOfSquares() <em>Sum Of Squares</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSumOfSquares()
	 * @generated
	 * @ordered
	 */
	protected double sumOfSquares = SUM_OF_SQUARES_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeometricMean() <em>Geometric
	 * Mean</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected static final double GEOMETRIC_MEAN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected double geometricMean = GEOMETRIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondMoment() <em>Second Moment</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSecondMoment()
	 * @generated
	 * @ordered
	 */
	protected static final double SECOND_MOMENT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSecondMoment() <em>Second Moment</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSecondMoment()
	 * @generated
	 * @ordered
	 */
	protected double secondMoment = SECOND_MOMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardDeviation() <em>Standard
	 * Deviation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final double STANDARD_DEVIATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStandardDeviation() <em>Standard
	 * Deviation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected double standardDeviation = STANDARD_DEVIATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected StatisticalDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.STATISTICAL_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMin(double newMin) {
		double oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMax(double newMax) {
		double oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getMean() {
		return mean;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMean(double newMean) {
		double oldMean = mean;
		mean = newMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__MEAN, oldMean, mean));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getVariance() {
		return variance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setVariance(double newVariance) {
		double oldVariance = variance;
		variance = newVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__VARIANCE, oldVariance,
					variance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getSum() {
		return sum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSum(double newSum) {
		double oldSum = sum;
		sum = newSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__SUM, oldSum, sum));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public long getSamples() {
		return samples;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSamples(long newSamples) {
		long oldSamples = samples;
		samples = newSamples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__SAMPLES, oldSamples,
					samples));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getSumOfLogs() {
		return sumOfLogs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSumOfLogs(double newSumOfLogs) {
		double oldSumOfLogs = sumOfLogs;
		sumOfLogs = newSumOfLogs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__SUM_OF_LOGS,
					oldSumOfLogs, sumOfLogs));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getSumOfSquares() {
		return sumOfSquares;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSumOfSquares(double newSumOfSquares) {
		double oldSumOfSquares = sumOfSquares;
		sumOfSquares = newSumOfSquares;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__SUM_OF_SQUARES,
					oldSumOfSquares, sumOfSquares));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getGeometricMean() {
		return geometricMean;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setGeometricMean(double newGeometricMean) {
		double oldGeometricMean = geometricMean;
		geometricMean = newGeometricMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__GEOMETRIC_MEAN,
					oldGeometricMean, geometricMean));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getSecondMoment() {
		return secondMoment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSecondMoment(double newSecondMoment) {
		double oldSecondMoment = secondMoment;
		secondMoment = newSecondMoment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__SECOND_MOMENT,
					oldSecondMoment, secondMoment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setStandardDeviation(double newStandardDeviation) {
		double oldStandardDeviation = standardDeviation;
		standardDeviation = newStandardDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.STATISTICAL_DATA__STANDARD_DEVIATION,
					oldStandardDeviation, standardDeviation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CommonPackage.STATISTICAL_DATA__MIN:
			return getMin();
		case CommonPackage.STATISTICAL_DATA__MAX:
			return getMax();
		case CommonPackage.STATISTICAL_DATA__MEAN:
			return getMean();
		case CommonPackage.STATISTICAL_DATA__VARIANCE:
			return getVariance();
		case CommonPackage.STATISTICAL_DATA__SUM:
			return getSum();
		case CommonPackage.STATISTICAL_DATA__SAMPLES:
			return getSamples();
		case CommonPackage.STATISTICAL_DATA__SUM_OF_LOGS:
			return getSumOfLogs();
		case CommonPackage.STATISTICAL_DATA__SUM_OF_SQUARES:
			return getSumOfSquares();
		case CommonPackage.STATISTICAL_DATA__GEOMETRIC_MEAN:
			return getGeometricMean();
		case CommonPackage.STATISTICAL_DATA__SECOND_MOMENT:
			return getSecondMoment();
		case CommonPackage.STATISTICAL_DATA__STANDARD_DEVIATION:
			return getStandardDeviation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CommonPackage.STATISTICAL_DATA__MIN:
			setMin((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__MAX:
			setMax((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__MEAN:
			setMean((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__VARIANCE:
			setVariance((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM:
			setSum((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__SAMPLES:
			setSamples((Long) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_LOGS:
			setSumOfLogs((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_SQUARES:
			setSumOfSquares((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__GEOMETRIC_MEAN:
			setGeometricMean((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__SECOND_MOMENT:
			setSecondMoment((Double) newValue);
			return;
		case CommonPackage.STATISTICAL_DATA__STANDARD_DEVIATION:
			setStandardDeviation((Double) newValue);
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
		case CommonPackage.STATISTICAL_DATA__MIN:
			setMin(MIN_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__MAX:
			setMax(MAX_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__MEAN:
			setMean(MEAN_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__VARIANCE:
			setVariance(VARIANCE_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM:
			setSum(SUM_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__SAMPLES:
			setSamples(SAMPLES_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_LOGS:
			setSumOfLogs(SUM_OF_LOGS_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_SQUARES:
			setSumOfSquares(SUM_OF_SQUARES_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__GEOMETRIC_MEAN:
			setGeometricMean(GEOMETRIC_MEAN_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__SECOND_MOMENT:
			setSecondMoment(SECOND_MOMENT_EDEFAULT);
			return;
		case CommonPackage.STATISTICAL_DATA__STANDARD_DEVIATION:
			setStandardDeviation(STANDARD_DEVIATION_EDEFAULT);
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
		case CommonPackage.STATISTICAL_DATA__MIN:
			return min != MIN_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__MAX:
			return max != MAX_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__MEAN:
			return mean != MEAN_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__VARIANCE:
			return variance != VARIANCE_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__SUM:
			return sum != SUM_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__SAMPLES:
			return samples != SAMPLES_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_LOGS:
			return sumOfLogs != SUM_OF_LOGS_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__SUM_OF_SQUARES:
			return sumOfSquares != SUM_OF_SQUARES_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__GEOMETRIC_MEAN:
			return geometricMean != GEOMETRIC_MEAN_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__SECOND_MOMENT:
			return secondMoment != SECOND_MOMENT_EDEFAULT;
		case CommonPackage.STATISTICAL_DATA__STANDARD_DEVIATION:
			return standardDeviation != STANDARD_DEVIATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(", mean: ");
		result.append(mean);
		result.append(", variance: ");
		result.append(variance);
		result.append(", sum: ");
		result.append(sum);
		result.append(", samples: ");
		result.append(samples);
		result.append(", sumOfLogs: ");
		result.append(sumOfLogs);
		result.append(", sumOfSquares: ");
		result.append(sumOfSquares);
		result.append(", geometricMean: ");
		result.append(geometricMean);
		result.append(", secondMoment: ");
		result.append(secondMoment);
		result.append(", standardDeviation: ");
		result.append(standardDeviation);
		result.append(')');
		return result.toString();
	}

} // StatisticalDataImpl

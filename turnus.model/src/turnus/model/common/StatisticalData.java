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
package turnus.model.common;

import java.util.Collection;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Statistical Data</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link turnus.model.common.StatisticalData#getMin <em>Min</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getMax <em>Max</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getMean <em>Mean</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getVariance <em>Variance</em>}
 * </li>
 * <li>{@link turnus.model.common.StatisticalData#getSum <em>Sum</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getSamples <em>Samples</em>}
 * </li>
 * <li>{@link turnus.model.common.StatisticalData#getSumOfLogs
 * <em>Sum Of Logs</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getSumOfSquares
 * <em>Sum Of Squares</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getGeometricMean
 * <em>Geometric Mean</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getSecondMoment
 * <em>Second Moment</em>}</li>
 * <li>{@link turnus.model.common.StatisticalData#getStandardDeviation
 * <em>Standard Deviation</em>}</li>
 * </ul>
 *
 * @see turnus.model.common.CommonPackage#getStatisticalData()
 * @model
 * @generated
 */
public interface StatisticalData extends EObject {
	
	public static class Util{
		
		/**
		 * Sum a collection of {@link StatisticalData} collection. The results
		 * contains the {@link StatisticalData#getMean()},
		 * {@link StatisticalData#getMin()}, {@link StatisticalData#getMax()},
		 * {@link StatisticalData#getSum()}, {@link StatisticalData#getSamples()()}.
		 * The others values are set as {@link Double#NaN}
		 * 
		 * @param data
		 * @return
		 */
		public static StatisticalData sum(Collection<StatisticalData> data) {
			StatisticalData result = CommonFactory.eINSTANCE.createStatisticalData();
			result.setGeometricMean(Double.NaN);
			result.setSecondMoment(Double.NaN);
			result.setStandardDeviation(Double.NaN);
			result.setSumOfLogs(Double.NaN);
			result.setSumOfSquares(Double.NaN);
			result.setVariance(Double.NaN);

			double sum = 0;
			long count = 0;
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;

			for (StatisticalData e : data) {
				sum += e.getSum();
				count += e.getSamples();
				min = Math.min(min, e.getMin());
				max = Math.max(max, e.getMax());
			}

			result.setMean(sum / count);
			result.setMin(min);
			result.setMax(max);
			result.setSum(sum);
			result.setSamples(count);

			return result;
		}
		
		public static StatisticalData asStatisticalData(SummaryStatistics value){
			StatisticalData d = CommonFactory.eINSTANCE.createStatisticalData();

			long samples = value.getN();
			d.setSamples(samples);

			if (samples > 0) {
				d.setMean(value.getMean());
				d.setMin(value.getMin());
				d.setMax(value.getMax());
				d.setVariance(value.getVariance());
				d.setGeometricMean(value.getGeometricMean());
				d.setSum(value.getSum());
				d.setSumOfLogs(value.getSumOfLogs());
				d.setSumOfSquares(value.getSumsq());
				d.setStandardDeviation(value.getStandardDeviation());
				d.setSecondMoment(value.getSecondMoment());
			} else {
				d.setMean(0);
				d.setMin(0);
				d.setMax(0);
				d.setVariance(0);
				d.setGeometricMean(0);
				d.setSum(0);
				d.setSumOfLogs(0);
				d.setSumOfSquares(0);
				d.setStandardDeviation(0);
				d.setSecondMoment(0);
			}

			return d;
		}
		
		public static StatisticalData asAggregatedStatisticalData(StatisticalSummary value){
			StatisticalData d = CommonFactory.eINSTANCE.createStatisticalData();

			long samples = value.getN();
			d.setSamples(samples);

			if (samples > 0) {
				d.setMean(value.getMean());
				d.setMin(value.getMin());
				d.setMax(value.getMax());
				d.setVariance(value.getVariance());
				d.setSum(value.getSum());
				d.setStandardDeviation(value.getStandardDeviation());
			} else {
				d.setMean(0);
				d.setMin(0);
				d.setMax(0);
				d.setVariance(0);
				d.setGeometricMean(0);
				d.setSum(0);
				d.setSumOfLogs(0);
				d.setSumOfSquares(0);
				d.setStandardDeviation(0);
				d.setSecondMoment(0);
			}

			return d;
		}
		
	}
	
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Min()
	 * @model
	 * @generated
	 */
	double getMin();

	/**
	 * Sets the value of the '{@link turnus.model.common.StatisticalData#getMin
	 * <em>Min</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(double value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Max()
	 * @model
	 * @generated
	 */
	double getMax();

	/**
	 * Sets the value of the '{@link turnus.model.common.StatisticalData#getMax
	 * <em>Max</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(double value);

	/**
	 * Returns the value of the '<em><b>Mean</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mean</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mean</em>' attribute.
	 * @see #setMean(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Mean()
	 * @model
	 * @generated
	 */
	double getMean();

	/**
	 * Sets the value of the '{@link turnus.model.common.StatisticalData#getMean
	 * <em>Mean</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Mean</em>' attribute.
	 * @see #getMean()
	 * @generated
	 */
	void setMean(double value);

	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Variance()
	 * @model
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getVariance <em>Variance</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

	/**
	 * Returns the value of the '<em><b>Sum</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sum</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sum</em>' attribute.
	 * @see #setSum(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Sum()
	 * @model
	 * @generated
	 */
	double getSum();

	/**
	 * Sets the value of the '{@link turnus.model.common.StatisticalData#getSum
	 * <em>Sum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Sum</em>' attribute.
	 * @see #getSum()
	 * @generated
	 */
	void setSum(double value);

	/**
	 * Returns the value of the '<em><b>Samples</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Samples</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Samples</em>' attribute.
	 * @see #setSamples(long)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_Samples()
	 * @model
	 * @generated
	 */
	long getSamples();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getSamples <em>Samples</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Samples</em>' attribute.
	 * @see #getSamples()
	 * @generated
	 */
	void setSamples(long value);

	/**
	 * Returns the value of the '<em><b>Sum Of Logs</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sum Of Logs</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sum Of Logs</em>' attribute.
	 * @see #setSumOfLogs(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_SumOfLogs()
	 * @model
	 * @generated
	 */
	double getSumOfLogs();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getSumOfLogs
	 * <em>Sum Of Logs</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Sum Of Logs</em>' attribute.
	 * @see #getSumOfLogs()
	 * @generated
	 */
	void setSumOfLogs(double value);

	/**
	 * Returns the value of the '<em><b>Sum Of Squares</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sum Of Squares</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sum Of Squares</em>' attribute.
	 * @see #setSumOfSquares(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_SumOfSquares()
	 * @model
	 * @generated
	 */
	double getSumOfSquares();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getSumOfSquares
	 * <em>Sum Of Squares</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Sum Of Squares</em>' attribute.
	 * @see #getSumOfSquares()
	 * @generated
	 */
	void setSumOfSquares(double value);

	/**
	 * Returns the value of the '<em><b>Geometric Mean</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geometric Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Geometric Mean</em>' attribute.
	 * @see #setGeometricMean(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_GeometricMean()
	 * @model
	 * @generated
	 */
	double getGeometricMean();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getGeometricMean
	 * <em>Geometric Mean</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Geometric Mean</em>' attribute.
	 * @see #getGeometricMean()
	 * @generated
	 */
	void setGeometricMean(double value);

	/**
	 * Returns the value of the '<em><b>Second Moment</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Moment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Second Moment</em>' attribute.
	 * @see #setSecondMoment(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_SecondMoment()
	 * @model
	 * @generated
	 */
	double getSecondMoment();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getSecondMoment
	 * <em>Second Moment</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Second Moment</em>' attribute.
	 * @see #getSecondMoment()
	 * @generated
	 */
	void setSecondMoment(double value);

	/**
	 * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Deviation</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Standard Deviation</em>' attribute.
	 * @see #setStandardDeviation(double)
	 * @see turnus.model.common.CommonPackage#getStatisticalData_StandardDeviation()
	 * @model
	 * @generated
	 */
	double getStandardDeviation();

	/**
	 * Sets the value of the '
	 * {@link turnus.model.common.StatisticalData#getStandardDeviation
	 * <em>Standard Deviation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(double value);

} // StatisticalData

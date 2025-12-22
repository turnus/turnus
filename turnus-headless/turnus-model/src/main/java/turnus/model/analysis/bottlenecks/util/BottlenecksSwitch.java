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
package turnus.model.analysis.bottlenecks.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;
import turnus.model.analysis.bottlenecks.*;
import turnus.model.analysis.postprocessing.PostProcessingData;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage
 * @generated
 */
public class BottlenecksSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BottlenecksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottlenecksSwitch() {
		if (modelPackage == null) {
			modelPackage = BottlenecksPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BottlenecksPackage.BOTTLENECKS_REPORT: {
				BottlenecksReport bottlenecksReport = (BottlenecksReport)theEObject;
				T result = caseBottlenecksReport(bottlenecksReport);
				if (result == null) result = caseAnalysisReport(bottlenecksReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA: {
				ActionBottlenecksData actionBottlenecksData = (ActionBottlenecksData)theEObject;
				T result = caseActionBottlenecksData(actionBottlenecksData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT: {
				ImpactAnalysisReport impactAnalysisReport = (ImpactAnalysisReport)theEObject;
				T result = caseImpactAnalysisReport(impactAnalysisReport);
				if (result == null) result = caseAnalysisReport(impactAnalysisReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.IMPACT_ANALYSIS_DATA: {
				ImpactAnalysisData impactAnalysisData = (ImpactAnalysisData)theEObject;
				T result = caseImpactAnalysisData(impactAnalysisData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.DOUBLE_TO_BOTTLENECKS_REPORT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Double, BottlenecksReport> doubleToBottlenecksReportMap = (Map.Entry<Double, BottlenecksReport>)theEObject;
				T result = caseDoubleToBottlenecksReportMap(doubleToBottlenecksReportMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT: {
				BottlenecksWithSchedulingReport bottlenecksWithSchedulingReport = (BottlenecksWithSchedulingReport)theEObject;
				T result = caseBottlenecksWithSchedulingReport(bottlenecksWithSchedulingReport);
				if (result == null) result = caseAnalysisReport(bottlenecksWithSchedulingReport);
				if (result == null) result = casePostProcessingData(bottlenecksWithSchedulingReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA: {
				ActionBottlenecksWithSchedulingData actionBottlenecksWithSchedulingData = (ActionBottlenecksWithSchedulingData)theEObject;
				T result = caseActionBottlenecksWithSchedulingData(actionBottlenecksWithSchedulingData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA: {
				ScheduledImpactAnalysisData scheduledImpactAnalysisData = (ScheduledImpactAnalysisData)theEObject;
				T result = caseScheduledImpactAnalysisData(scheduledImpactAnalysisData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Double, BottlenecksWithSchedulingReport> doubleToBottlenecksWithSchedulingReportMap = (Map.Entry<Double, BottlenecksWithSchedulingReport>)theEObject;
				T result = caseDoubleToBottlenecksWithSchedulingReportMap(doubleToBottlenecksWithSchedulingReportMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_REPORT: {
				ScheduledImpactAnalysisReport scheduledImpactAnalysisReport = (ScheduledImpactAnalysisReport)theEObject;
				T result = caseScheduledImpactAnalysisReport(scheduledImpactAnalysisReport);
				if (result == null) result = caseAnalysisReport(scheduledImpactAnalysisReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBottlenecksReport(BottlenecksReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Bottlenecks Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Bottlenecks Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionBottlenecksData(ActionBottlenecksData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Impact Analysis Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Impact Analysis Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImpactAnalysisReport(ImpactAnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Impact Analysis Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Impact Analysis Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImpactAnalysisData(ImpactAnalysisData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double To Bottlenecks Report Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double To Bottlenecks Report Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleToBottlenecksReportMap(Map.Entry<Double, BottlenecksReport> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>With Scheduling Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With Scheduling Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBottlenecksWithSchedulingReport(BottlenecksWithSchedulingReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Bottlenecks With Scheduling Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Bottlenecks With Scheduling Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionBottlenecksWithSchedulingData(ActionBottlenecksWithSchedulingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduled Impact Analysis Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduled Impact Analysis Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduledImpactAnalysisData(ScheduledImpactAnalysisData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double To Bottlenecks With Scheduling Report Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double To Bottlenecks With Scheduling Report Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleToBottlenecksWithSchedulingReportMap(Map.Entry<Double, BottlenecksWithSchedulingReport> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduled Impact Analysis Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduled Impact Analysis Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduledImpactAnalysisReport(ScheduledImpactAnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysisReport(AnalysisReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Processing Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostProcessingData(PostProcessingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BottlenecksSwitch

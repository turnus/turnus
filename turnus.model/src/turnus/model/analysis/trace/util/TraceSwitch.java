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
package turnus.model.analysis.trace.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;
import turnus.model.analysis.trace.*;

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
 * @see turnus.model.analysis.trace.TracePackage
 * @generated
 */
public class TraceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TracePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSwitch() {
		if (modelPackage == null) {
			modelPackage = TracePackage.eINSTANCE;
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
			case TracePackage.TRACE_SIZE_REPORT: {
				TraceSizeReport traceSizeReport = (TraceSizeReport)theEObject;
				T result = caseTraceSizeReport(traceSizeReport);
				if (result == null) result = caseAnalysisReport(traceSizeReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_TRACE_REPORT: {
				CompressedTraceReport compressedTraceReport = (CompressedTraceReport)theEObject;
				T result = caseCompressedTraceReport(compressedTraceReport);
				if (result == null) result = caseAnalysisReport(compressedTraceReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_STEP: {
				CompressedStep compressedStep = (CompressedStep)theEObject;
				T result = caseCompressedStep(compressedStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_DEPENDENCY: {
				CompressedDependency compressedDependency = (CompressedDependency)theEObject;
				T result = caseCompressedDependency(compressedDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_FSM_DEPENDENCY: {
				CompressedFsmDependency compressedFsmDependency = (CompressedFsmDependency)theEObject;
				T result = caseCompressedFsmDependency(compressedFsmDependency);
				if (result == null) result = caseCompressedDependency(compressedFsmDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY: {
				CompressedGuardDependency compressedGuardDependency = (CompressedGuardDependency)theEObject;
				T result = caseCompressedGuardDependency(compressedGuardDependency);
				if (result == null) result = caseCompressedDependency(compressedGuardDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY: {
				CompressedVariableDependency compressedVariableDependency = (CompressedVariableDependency)theEObject;
				T result = caseCompressedVariableDependency(compressedVariableDependency);
				if (result == null) result = caseCompressedDependency(compressedVariableDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_PORT_DEPENDENCY: {
				CompressedPortDependency compressedPortDependency = (CompressedPortDependency)theEObject;
				T result = caseCompressedPortDependency(compressedPortDependency);
				if (result == null) result = caseCompressedDependency(compressedPortDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY: {
				CompressedTokensDependency compressedTokensDependency = (CompressedTokensDependency)theEObject;
				T result = caseCompressedTokensDependency(compressedTokensDependency);
				if (result == null) result = caseCompressedDependency(compressedTokensDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.TRACE_COMPARATOR_REPORT: {
				TraceComparatorReport traceComparatorReport = (TraceComparatorReport)theEObject;
				T result = caseTraceComparatorReport(traceComparatorReport);
				if (result == null) result = caseAnalysisReport(traceComparatorReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPARED_TRACE: {
				ComparedTrace comparedTrace = (ComparedTrace)theEObject;
				T result = caseComparedTrace(comparedTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.COMPARED_ACTION: {
				ComparedAction comparedAction = (ComparedAction)theEObject;
				T result = caseComparedAction(comparedAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.MARKOW_MODEL_TRACE_REPORT: {
				MarkowModelTraceReport markowModelTraceReport = (MarkowModelTraceReport)theEObject;
				T result = caseMarkowModelTraceReport(markowModelTraceReport);
				if (result == null) result = caseAnalysisReport(markowModelTraceReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.MARKOV_MODEL_ACTION_DATA: {
				MarkovModelActionData markovModelActionData = (MarkovModelActionData)theEObject;
				T result = caseMarkovModelActionData(markovModelActionData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Size Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Size Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceSizeReport(TraceSizeReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Trace Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Trace Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedTraceReport(CompressedTraceReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedStep(CompressedStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedDependency(CompressedDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Fsm Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Fsm Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedFsmDependency(CompressedFsmDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Guard Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Guard Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedGuardDependency(CompressedGuardDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Variable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Variable Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedVariableDependency(CompressedVariableDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Port Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Port Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedPortDependency(CompressedPortDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Tokens Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Tokens Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedTokensDependency(CompressedTokensDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparator Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparator Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceComparatorReport(TraceComparatorReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compared Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compared Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComparedTrace(ComparedTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compared Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compared Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComparedAction(ComparedAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markow Model Trace Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markow Model Trace Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkowModelTraceReport(MarkowModelTraceReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markov Model Action Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markov Model Action Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkovModelActionData(MarkovModelActionData object) {
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

} //TraceSwitch

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
package turnus.model.analysis.profiling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;

import turnus.model.analysis.profiling.*;

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
 * @see turnus.model.analysis.profiling.ProfilingPackage
 * @generated
 */
public class ProfilingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProfilingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingSwitch() {
		if (modelPackage == null) {
			modelPackage = ProfilingPackage.eINSTANCE;
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_REPORT: {
				IntraActionCommunicationReport intraActionCommunicationReport = (IntraActionCommunicationReport)theEObject;
				T result = caseIntraActionCommunicationReport(intraActionCommunicationReport);
				if (result == null) result = caseAnalysisReport(intraActionCommunicationReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA: {
				IntraActorCommunicationData intraActorCommunicationData = (IntraActorCommunicationData)theEObject;
				T result = caseIntraActorCommunicationData(intraActorCommunicationData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA: {
				IntraActionCommunicationData intraActionCommunicationData = (IntraActionCommunicationData)theEObject;
				T result = caseIntraActionCommunicationData(intraActionCommunicationData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.PROFILING_STATS_REPORT: {
				ProfilingStatsReport profilingStatsReport = (ProfilingStatsReport)theEObject;
				T result = caseProfilingStatsReport(profilingStatsReport);
				if (result == null) result = caseAnalysisReport(profilingStatsReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA: {
				ProfilingStatsActorData profilingStatsActorData = (ProfilingStatsActorData)theEObject;
				T result = caseProfilingStatsActorData(profilingStatsActorData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.INTER_PARTITION_DATA: {
				InterPartitionData interPartitionData = (InterPartitionData)theEObject;
				T result = caseInterPartitionData(interPartitionData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProfilingPackage.INTER_PARTITION_COMMUNICATION_AND_MEMORY_REPORT: {
				InterPartitionCommunicationAndMemoryReport interPartitionCommunicationAndMemoryReport = (InterPartitionCommunicationAndMemoryReport)theEObject;
				T result = caseInterPartitionCommunicationAndMemoryReport(interPartitionCommunicationAndMemoryReport);
				if (result == null) result = caseAnalysisReport(interPartitionCommunicationAndMemoryReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intra Action Communication Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intra Action Communication Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntraActionCommunicationReport(IntraActionCommunicationReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intra Actor Communication Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intra Actor Communication Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntraActorCommunicationData(IntraActorCommunicationData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intra Action Communication Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intra Action Communication Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntraActionCommunicationData(IntraActionCommunicationData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stats Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stats Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfilingStatsReport(ProfilingStatsReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stats Actor Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stats Actor Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfilingStatsActorData(ProfilingStatsActorData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inter Partition Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inter Partition Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterPartitionData(InterPartitionData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inter Partition Communication And Memory Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inter Partition Communication And Memory Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterPartitionCommunicationAndMemoryReport(InterPartitionCommunicationAndMemoryReport object) {
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

} //ProfilingSwitch

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
package turnus.model.analysis.partitioning.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import turnus.model.analysis.AnalysisReport;
import turnus.model.analysis.partitioning.*;

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
 * @see turnus.model.analysis.partitioning.PartitioningPackage
 * @generated
 */
public class PartitioningSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PartitioningPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningSwitch() {
		if (modelPackage == null) {
			modelPackage = PartitioningPackage.eINSTANCE;
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
			case PartitioningPackage.COM_COST_PARTITIONING_REPORT: {
				ComCostPartitioningReport comCostPartitioningReport = (ComCostPartitioningReport)theEObject;
				T result = caseComCostPartitioningReport(comCostPartitioningReport);
				if (result == null) result = caseAnalysisReport(comCostPartitioningReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PartitioningPackage.COM_COST_PARTITION: {
				ComCostPartition comCostPartition = (ComCostPartition)theEObject;
				T result = caseComCostPartition(comCostPartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITION: {
				WorkloadBalancePartition workloadBalancePartition = (WorkloadBalancePartition)theEObject;
				T result = caseWorkloadBalancePartition(workloadBalancePartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT: {
				WorkloadBalancePartitioningReport workloadBalancePartitioningReport = (WorkloadBalancePartitioningReport)theEObject;
				T result = caseWorkloadBalancePartitioningReport(workloadBalancePartitioningReport);
				if (result == null) result = caseAnalysisReport(workloadBalancePartitioningReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION: {
				BalancedPipelinePartition balancedPipelinePartition = (BalancedPipelinePartition)theEObject;
				T result = caseBalancedPipelinePartition(balancedPipelinePartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PartitioningPackage.BALANCED_PIPELINE_PARTITIONING_REPORT: {
				BalancedPipelinePartitioningReport balancedPipelinePartitioningReport = (BalancedPipelinePartitioningReport)theEObject;
				T result = caseBalancedPipelinePartitioningReport(balancedPipelinePartitioningReport);
				if (result == null) result = caseAnalysisReport(balancedPipelinePartitioningReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Com Cost Partitioning Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Com Cost Partitioning Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComCostPartitioningReport(ComCostPartitioningReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Com Cost Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Com Cost Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComCostPartition(ComCostPartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workload Balance Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workload Balance Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkloadBalancePartition(WorkloadBalancePartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workload Balance Partitioning Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workload Balance Partitioning Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkloadBalancePartitioningReport(WorkloadBalancePartitioningReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Balanced Pipeline Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Balanced Pipeline Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBalancedPipelinePartition(BalancedPipelinePartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Balanced Pipeline Partitioning Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Balanced Pipeline Partitioning Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBalancedPipelinePartitioningReport(BalancedPipelinePartitioningReport object) {
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

} //PartitioningSwitch

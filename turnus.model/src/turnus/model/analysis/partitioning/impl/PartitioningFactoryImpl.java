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
package turnus.model.analysis.partitioning.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.partitioning.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartitioningFactoryImpl extends EFactoryImpl implements PartitioningFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PartitioningFactory init() {
		try {
			PartitioningFactory thePartitioningFactory = (PartitioningFactory)EPackage.Registry.INSTANCE.getEFactory(PartitioningPackage.eNS_URI);
			if (thePartitioningFactory != null) {
				return thePartitioningFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PartitioningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PartitioningPackage.COM_COST_PARTITIONING_REPORT: return createComCostPartitioningReport();
			case PartitioningPackage.COM_COST_PARTITION: return createComCostPartition();
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITION: return createWorkloadBalancePartition();
			case PartitioningPackage.WORKLOAD_BALANCE_PARTITIONING_REPORT: return createWorkloadBalancePartitioningReport();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITION: return createBalancedPipelinePartition();
			case PartitioningPackage.BALANCED_PIPELINE_PARTITIONING_REPORT: return createBalancedPipelinePartitioningReport();
			case PartitioningPackage.METIS_PARTITIONING: return createMetisPartitioning();
			case PartitioningPackage.METIS_PARTITIONING_REPORT: return createMetisPartitioningReport();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComCostPartitioningReport createComCostPartitioningReport() {
		ComCostPartitioningReportImpl comCostPartitioningReport = new ComCostPartitioningReportImpl();
		return comCostPartitioningReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComCostPartition createComCostPartition() {
		ComCostPartitionImpl comCostPartition = new ComCostPartitionImpl();
		return comCostPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkloadBalancePartition createWorkloadBalancePartition() {
		WorkloadBalancePartitionImpl workloadBalancePartition = new WorkloadBalancePartitionImpl();
		return workloadBalancePartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkloadBalancePartitioningReport createWorkloadBalancePartitioningReport() {
		WorkloadBalancePartitioningReportImpl workloadBalancePartitioningReport = new WorkloadBalancePartitioningReportImpl();
		return workloadBalancePartitioningReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BalancedPipelinePartition createBalancedPipelinePartition() {
		BalancedPipelinePartitionImpl balancedPipelinePartition = new BalancedPipelinePartitionImpl();
		return balancedPipelinePartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BalancedPipelinePartitioningReport createBalancedPipelinePartitioningReport() {
		BalancedPipelinePartitioningReportImpl balancedPipelinePartitioningReport = new BalancedPipelinePartitioningReportImpl();
		return balancedPipelinePartitioningReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetisPartitioning createMetisPartitioning() {
		MetisPartitioningImpl metisPartitioning = new MetisPartitioningImpl();
		return metisPartitioning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetisPartitioningReport createMetisPartitioningReport() {
		MetisPartitioningReportImpl metisPartitioningReport = new MetisPartitioningReportImpl();
		return metisPartitioningReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartitioningPackage getPartitioningPackage() {
		return (PartitioningPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PartitioningPackage getPackage() {
		return PartitioningPackage.eINSTANCE;
	}

} //PartitioningFactoryImpl

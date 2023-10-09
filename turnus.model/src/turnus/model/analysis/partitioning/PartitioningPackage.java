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
package turnus.model.analysis.partitioning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import turnus.model.analysis.AnalysisPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.partitioning.PartitioningFactory
 * @model kind="package"
 * @generated
 */
public interface PartitioningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "partitioning";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://turnus.co/model/2015/analysis/partitioning";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "turnus.model.analysis.partitioning";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PartitioningPackage eINSTANCE = turnus.model.analysis.partitioning.impl.PartitioningPackageImpl.init();

	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.ComCostPartitioningReportImpl <em>Com Cost Partitioning Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.ComCostPartitioningReportImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getComCostPartitioningReport()
	 * @generated
	 */
	int COM_COST_PARTITIONING_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bit Accurate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT__BIT_ACCURATE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT__PARTITIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Com Cost Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Com Cost Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITIONING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl <em>Com Cost Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.ComCostPartitionImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getComCostPartition()
	 * @generated
	 */
	int COM_COST_PARTITION = 1;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Internal Cost Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION__INTERNAL_COST_MAP = 1;

	/**
	 * The feature id for the '<em><b>External Cost Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION__EXTERNAL_COST_MAP = 2;

	/**
	 * The feature id for the '<em><b>Internal Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION__INTERNAL_COST = 3;

	/**
	 * The feature id for the '<em><b>External Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION__EXTERNAL_COST = 4;

	/**
	 * The number of structural features of the '<em>Com Cost Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Com Cost Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_COST_PARTITION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitionImpl <em>Workload Balance Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.WorkloadBalancePartitionImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getWorkloadBalancePartition()
	 * @generated
	 */
	int WORKLOAD_BALANCE_PARTITION = 2;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITION__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITION__WORKLOAD = 1;

	/**
	 * The number of structural features of the '<em>Workload Balance Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Workload Balance Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl <em>Workload Balance Partitioning Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getWorkloadBalancePartitioningReport()
	 * @generated
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT = 3;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schedulin Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT__SCHEDULIN_POLICY = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Workload Balance Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Workload Balance Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKLOAD_BALANCE_PARTITIONING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl <em>Balanced Pipeline Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getBalancedPipelinePartition()
	 * @generated
	 */
	int BALANCED_PIPELINE_PARTITION = 4;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION__WORKLOAD = 1;

	/**
	 * The feature id for the '<em><b>Pre Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD = 2;

	/**
	 * The feature id for the '<em><b>Common Pred Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG = 3;

	/**
	 * The number of structural features of the '<em>Balanced Pipeline Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Balanced Pipeline Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitioningReportImpl <em>Balanced Pipeline Partitioning Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.BalancedPipelinePartitioningReportImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getBalancedPipelinePartitioningReport()
	 * @generated
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT = 5;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT__PARTITIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Balanced Pipeline Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Balanced Pipeline Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BALANCED_PIPELINE_PARTITIONING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.MetisPartitioningImpl <em>Metis Partitioning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.MetisPartitioningImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getMetisPartitioning()
	 * @generated
	 */
	int METIS_PARTITIONING = 6;

	/**
	 * The feature id for the '<em><b>Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING__ACTORS = 0;

	/**
	 * The feature id for the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING__WORKLOAD = 1;

	/**
	 * The feature id for the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING__PARTITION_ID = 2;

	/**
	 * The number of structural features of the '<em>Metis Partitioning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Metis Partitioning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl <em>Metis Partitioning Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl
	 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getMetisPartitioningReport()
	 * @generated
	 */
	int METIS_PARTITIONING_REPORT = 7;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__ALGORITHM = AnalysisPackage.ANALYSIS_REPORT__ALGORITHM;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__DATE = AnalysisPackage.ANALYSIS_REPORT__DATE;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__NETWORK = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Partitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__PARTITIONS = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Edge Cut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__EDGE_CUT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comm Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__COMM_VOLUME = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Objtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__OBJTYPE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ptype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__PTYPE = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Contig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__CONTIG = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Schedulin Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT__SCHEDULIN_POLICY = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Metis Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT_FEATURE_COUNT = AnalysisPackage.ANALYSIS_REPORT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Metis Partitioning Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METIS_PARTITIONING_REPORT_OPERATION_COUNT = AnalysisPackage.ANALYSIS_REPORT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.ComCostPartitioningReport <em>Com Cost Partitioning Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Com Cost Partitioning Report</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartitioningReport
	 * @generated
	 */
	EClass getComCostPartitioningReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.partitioning.ComCostPartitioningReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartitioningReport#getNetwork()
	 * @see #getComCostPartitioningReport()
	 * @generated
	 */
	EReference getComCostPartitioningReport_Network();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.ComCostPartitioningReport#isBitAccurate <em>Bit Accurate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bit Accurate</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartitioningReport#isBitAccurate()
	 * @see #getComCostPartitioningReport()
	 * @generated
	 */
	EAttribute getComCostPartitioningReport_BitAccurate();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.partitioning.ComCostPartitioningReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartitioningReport#getPartitions()
	 * @see #getComCostPartitioningReport()
	 * @generated
	 */
	EReference getComCostPartitioningReport_Partitions();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.ComCostPartition <em>Com Cost Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Com Cost Partition</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition
	 * @generated
	 */
	EClass getComCostPartition();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.partitioning.ComCostPartition#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition#getActors()
	 * @see #getComCostPartition()
	 * @generated
	 */
	EReference getComCostPartition_Actors();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.partitioning.ComCostPartition#getInternalCostMap <em>Internal Cost Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Internal Cost Map</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition#getInternalCostMap()
	 * @see #getComCostPartition()
	 * @generated
	 */
	EReference getComCostPartition_InternalCostMap();

	/**
	 * Returns the meta object for the map '{@link turnus.model.analysis.partitioning.ComCostPartition#getExternalCostMap <em>External Cost Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>External Cost Map</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition#getExternalCostMap()
	 * @see #getComCostPartition()
	 * @generated
	 */
	EReference getComCostPartition_ExternalCostMap();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.ComCostPartition#getInternalCost <em>Internal Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Cost</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition#getInternalCost()
	 * @see #getComCostPartition()
	 * @generated
	 */
	EAttribute getComCostPartition_InternalCost();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.ComCostPartition#getExternalCost <em>External Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Cost</em>'.
	 * @see turnus.model.analysis.partitioning.ComCostPartition#getExternalCost()
	 * @see #getComCostPartition()
	 * @generated
	 */
	EAttribute getComCostPartition_ExternalCost();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.WorkloadBalancePartition <em>Workload Balance Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workload Balance Partition</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartition
	 * @generated
	 */
	EClass getWorkloadBalancePartition();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.partitioning.WorkloadBalancePartition#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartition#getActors()
	 * @see #getWorkloadBalancePartition()
	 * @generated
	 */
	EReference getWorkloadBalancePartition_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.WorkloadBalancePartition#getWorkload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workload</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartition#getWorkload()
	 * @see #getWorkloadBalancePartition()
	 * @generated
	 */
	EAttribute getWorkloadBalancePartition_Workload();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport <em>Workload Balance Partitioning Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workload Balance Partitioning Report</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport
	 * @generated
	 */
	EClass getWorkloadBalancePartitioningReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getNetwork()
	 * @see #getWorkloadBalancePartitioningReport()
	 * @generated
	 */
	EReference getWorkloadBalancePartitioningReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getPartitions()
	 * @see #getWorkloadBalancePartitioningReport()
	 * @generated
	 */
	EReference getWorkloadBalancePartitioningReport_Partitions();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getSchedulinPolicy <em>Schedulin Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedulin Policy</em>'.
	 * @see turnus.model.analysis.partitioning.WorkloadBalancePartitioningReport#getSchedulinPolicy()
	 * @see #getWorkloadBalancePartitioningReport()
	 * @generated
	 */
	EAttribute getWorkloadBalancePartitioningReport_SchedulinPolicy();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.BalancedPipelinePartition <em>Balanced Pipeline Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Balanced Pipeline Partition</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartition
	 * @generated
	 */
	EClass getBalancedPipelinePartition();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.partitioning.BalancedPipelinePartition#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartition#getActors()
	 * @see #getBalancedPipelinePartition()
	 * @generated
	 */
	EReference getBalancedPipelinePartition_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.BalancedPipelinePartition#getWorkload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workload</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartition#getWorkload()
	 * @see #getBalancedPipelinePartition()
	 * @generated
	 */
	EAttribute getBalancedPipelinePartition_Workload();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.BalancedPipelinePartition#getPreWorkload <em>Pre Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre Workload</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartition#getPreWorkload()
	 * @see #getBalancedPipelinePartition()
	 * @generated
	 */
	EAttribute getBalancedPipelinePartition_PreWorkload();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.BalancedPipelinePartition#getCommonPredAvg <em>Common Pred Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Common Pred Avg</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartition#getCommonPredAvg()
	 * @see #getBalancedPipelinePartition()
	 * @generated
	 */
	EAttribute getBalancedPipelinePartition_CommonPredAvg();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport <em>Balanced Pipeline Partitioning Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Balanced Pipeline Partitioning Report</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport
	 * @generated
	 */
	EClass getBalancedPipelinePartitioningReport();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport#getPartitions()
	 * @see #getBalancedPipelinePartitioningReport()
	 * @generated
	 */
	EReference getBalancedPipelinePartitioningReport_Partitions();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.partitioning.BalancedPipelinePartitioningReport#getNetwork()
	 * @see #getBalancedPipelinePartitioningReport()
	 * @generated
	 */
	EReference getBalancedPipelinePartitioningReport_Network();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.MetisPartitioning <em>Metis Partitioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metis Partitioning</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioning
	 * @generated
	 */
	EClass getMetisPartitioning();

	/**
	 * Returns the meta object for the reference list '{@link turnus.model.analysis.partitioning.MetisPartitioning#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actors</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioning#getActors()
	 * @see #getMetisPartitioning()
	 * @generated
	 */
	EReference getMetisPartitioning_Actors();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioning#getWorkload <em>Workload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workload</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioning#getWorkload()
	 * @see #getMetisPartitioning()
	 * @generated
	 */
	EAttribute getMetisPartitioning_Workload();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioning#getPartitionId <em>Partition Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partition Id</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioning#getPartitionId()
	 * @see #getMetisPartitioning()
	 * @generated
	 */
	EAttribute getMetisPartitioning_PartitionId();

	/**
	 * Returns the meta object for class '{@link turnus.model.analysis.partitioning.MetisPartitioningReport <em>Metis Partitioning Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metis Partitioning Report</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport
	 * @generated
	 */
	EClass getMetisPartitioningReport();

	/**
	 * Returns the meta object for the reference '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getNetwork()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EReference getMetisPartitioningReport_Network();

	/**
	 * Returns the meta object for the containment reference list '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getPartitions <em>Partitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partitions</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getPartitions()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EReference getMetisPartitioningReport_Partitions();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getEdgeCut <em>Edge Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Cut</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getEdgeCut()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_EdgeCut();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getCommVolume <em>Comm Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comm Volume</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getCommVolume()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_CommVolume();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getObjtype <em>Objtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Objtype</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getObjtype()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_Objtype();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getPtype <em>Ptype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ptype</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getPtype()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_Ptype();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#isContig <em>Contig</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contig</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#isContig()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_Contig();

	/**
	 * Returns the meta object for the attribute '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getSchedulinPolicy <em>Schedulin Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedulin Policy</em>'.
	 * @see turnus.model.analysis.partitioning.MetisPartitioningReport#getSchedulinPolicy()
	 * @see #getMetisPartitioningReport()
	 * @generated
	 */
	EAttribute getMetisPartitioningReport_SchedulinPolicy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PartitioningFactory getPartitioningFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.ComCostPartitioningReportImpl <em>Com Cost Partitioning Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.ComCostPartitioningReportImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getComCostPartitioningReport()
		 * @generated
		 */
		EClass COM_COST_PARTITIONING_REPORT = eINSTANCE.getComCostPartitioningReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_COST_PARTITIONING_REPORT__NETWORK = eINSTANCE.getComCostPartitioningReport_Network();

		/**
		 * The meta object literal for the '<em><b>Bit Accurate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_COST_PARTITIONING_REPORT__BIT_ACCURATE = eINSTANCE.getComCostPartitioningReport_BitAccurate();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_COST_PARTITIONING_REPORT__PARTITIONS = eINSTANCE.getComCostPartitioningReport_Partitions();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.ComCostPartitionImpl <em>Com Cost Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.ComCostPartitionImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getComCostPartition()
		 * @generated
		 */
		EClass COM_COST_PARTITION = eINSTANCE.getComCostPartition();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_COST_PARTITION__ACTORS = eINSTANCE.getComCostPartition_Actors();

		/**
		 * The meta object literal for the '<em><b>Internal Cost Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_COST_PARTITION__INTERNAL_COST_MAP = eINSTANCE.getComCostPartition_InternalCostMap();

		/**
		 * The meta object literal for the '<em><b>External Cost Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COM_COST_PARTITION__EXTERNAL_COST_MAP = eINSTANCE.getComCostPartition_ExternalCostMap();

		/**
		 * The meta object literal for the '<em><b>Internal Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_COST_PARTITION__INTERNAL_COST = eINSTANCE.getComCostPartition_InternalCost();

		/**
		 * The meta object literal for the '<em><b>External Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM_COST_PARTITION__EXTERNAL_COST = eINSTANCE.getComCostPartition_ExternalCost();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitionImpl <em>Workload Balance Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.WorkloadBalancePartitionImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getWorkloadBalancePartition()
		 * @generated
		 */
		EClass WORKLOAD_BALANCE_PARTITION = eINSTANCE.getWorkloadBalancePartition();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKLOAD_BALANCE_PARTITION__ACTORS = eINSTANCE.getWorkloadBalancePartition_Actors();

		/**
		 * The meta object literal for the '<em><b>Workload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKLOAD_BALANCE_PARTITION__WORKLOAD = eINSTANCE.getWorkloadBalancePartition_Workload();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl <em>Workload Balance Partitioning Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.WorkloadBalancePartitioningReportImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getWorkloadBalancePartitioningReport()
		 * @generated
		 */
		EClass WORKLOAD_BALANCE_PARTITIONING_REPORT = eINSTANCE.getWorkloadBalancePartitioningReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKLOAD_BALANCE_PARTITIONING_REPORT__NETWORK = eINSTANCE.getWorkloadBalancePartitioningReport_Network();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKLOAD_BALANCE_PARTITIONING_REPORT__PARTITIONS = eINSTANCE.getWorkloadBalancePartitioningReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Schedulin Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKLOAD_BALANCE_PARTITIONING_REPORT__SCHEDULIN_POLICY = eINSTANCE.getWorkloadBalancePartitioningReport_SchedulinPolicy();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl <em>Balanced Pipeline Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.BalancedPipelinePartitionImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getBalancedPipelinePartition()
		 * @generated
		 */
		EClass BALANCED_PIPELINE_PARTITION = eINSTANCE.getBalancedPipelinePartition();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCED_PIPELINE_PARTITION__ACTORS = eINSTANCE.getBalancedPipelinePartition_Actors();

		/**
		 * The meta object literal for the '<em><b>Workload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCED_PIPELINE_PARTITION__WORKLOAD = eINSTANCE.getBalancedPipelinePartition_Workload();

		/**
		 * The meta object literal for the '<em><b>Pre Workload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCED_PIPELINE_PARTITION__PRE_WORKLOAD = eINSTANCE.getBalancedPipelinePartition_PreWorkload();

		/**
		 * The meta object literal for the '<em><b>Common Pred Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BALANCED_PIPELINE_PARTITION__COMMON_PRED_AVG = eINSTANCE.getBalancedPipelinePartition_CommonPredAvg();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.BalancedPipelinePartitioningReportImpl <em>Balanced Pipeline Partitioning Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.BalancedPipelinePartitioningReportImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getBalancedPipelinePartitioningReport()
		 * @generated
		 */
		EClass BALANCED_PIPELINE_PARTITIONING_REPORT = eINSTANCE.getBalancedPipelinePartitioningReport();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCED_PIPELINE_PARTITIONING_REPORT__PARTITIONS = eINSTANCE.getBalancedPipelinePartitioningReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BALANCED_PIPELINE_PARTITIONING_REPORT__NETWORK = eINSTANCE.getBalancedPipelinePartitioningReport_Network();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.MetisPartitioningImpl <em>Metis Partitioning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.MetisPartitioningImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getMetisPartitioning()
		 * @generated
		 */
		EClass METIS_PARTITIONING = eINSTANCE.getMetisPartitioning();

		/**
		 * The meta object literal for the '<em><b>Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METIS_PARTITIONING__ACTORS = eINSTANCE.getMetisPartitioning_Actors();

		/**
		 * The meta object literal for the '<em><b>Workload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING__WORKLOAD = eINSTANCE.getMetisPartitioning_Workload();

		/**
		 * The meta object literal for the '<em><b>Partition Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING__PARTITION_ID = eINSTANCE.getMetisPartitioning_PartitionId();

		/**
		 * The meta object literal for the '{@link turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl <em>Metis Partitioning Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see turnus.model.analysis.partitioning.impl.MetisPartitioningReportImpl
		 * @see turnus.model.analysis.partitioning.impl.PartitioningPackageImpl#getMetisPartitioningReport()
		 * @generated
		 */
		EClass METIS_PARTITIONING_REPORT = eINSTANCE.getMetisPartitioningReport();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METIS_PARTITIONING_REPORT__NETWORK = eINSTANCE.getMetisPartitioningReport_Network();

		/**
		 * The meta object literal for the '<em><b>Partitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METIS_PARTITIONING_REPORT__PARTITIONS = eINSTANCE.getMetisPartitioningReport_Partitions();

		/**
		 * The meta object literal for the '<em><b>Edge Cut</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__EDGE_CUT = eINSTANCE.getMetisPartitioningReport_EdgeCut();

		/**
		 * The meta object literal for the '<em><b>Comm Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__COMM_VOLUME = eINSTANCE.getMetisPartitioningReport_CommVolume();

		/**
		 * The meta object literal for the '<em><b>Objtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__OBJTYPE = eINSTANCE.getMetisPartitioningReport_Objtype();

		/**
		 * The meta object literal for the '<em><b>Ptype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__PTYPE = eINSTANCE.getMetisPartitioningReport_Ptype();

		/**
		 * The meta object literal for the '<em><b>Contig</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__CONTIG = eINSTANCE.getMetisPartitioningReport_Contig();

		/**
		 * The meta object literal for the '<em><b>Schedulin Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METIS_PARTITIONING_REPORT__SCHEDULIN_POLICY = eINSTANCE.getMetisPartitioningReport_SchedulinPolicy();

	}

} //PartitioningPackage

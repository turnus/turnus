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

import java.util.List;

import turnus.model.analysis.AnalysisReport;

import turnus.model.common.EScheduler;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metis Partitioning Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getEdgeCut <em>Edge Cut</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getCommVolume <em>Comm Volume</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getObjtype <em>Objtype</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getPtype <em>Ptype</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#isContig <em>Contig</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getSchedulinPolicy <em>Schedulin Policy</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport()
 * @model
 * @generated
 */
public interface MetisPartitioningReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Partitions</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.partitioning.MetisPartitioning}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partitions</em>' containment reference list.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_Partitions()
	 * @model containment="true"
	 * @generated
	 */
	List<MetisPartitioning> getPartitions();

	/**
	 * Returns the value of the '<em><b>Edge Cut</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Cut</em>' attribute.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_EdgeCut()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getEdgeCut();

	/**
	 * Returns the value of the '<em><b>Comm Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comm Volume</em>' attribute.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_CommVolume()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getCommVolume();

	/**
	 * Returns the value of the '<em><b>Objtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objtype</em>' attribute.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_Objtype()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getObjtype();

	/**
	 * Returns the value of the '<em><b>Ptype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ptype</em>' attribute.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_Ptype()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getPtype();

	/**
	 * Returns the value of the '<em><b>Contig</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contig</em>' attribute.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_Contig()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isContig();

	/**
	 * Returns the value of the '<em><b>Schedulin Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link turnus.model.common.EScheduler}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedulin Policy</em>' attribute.
	 * @see turnus.model.common.EScheduler
	 * @see #setSchedulinPolicy(EScheduler)
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getMetisPartitioningReport_SchedulinPolicy()
	 * @model
	 * @generated
	 */
	EScheduler getSchedulinPolicy();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.partitioning.MetisPartitioningReport#getSchedulinPolicy <em>Schedulin Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedulin Policy</em>' attribute.
	 * @see turnus.model.common.EScheduler
	 * @see #getSchedulinPolicy()
	 * @generated
	 */
	void setSchedulinPolicy(EScheduler value);

} // MetisPartitioningReport

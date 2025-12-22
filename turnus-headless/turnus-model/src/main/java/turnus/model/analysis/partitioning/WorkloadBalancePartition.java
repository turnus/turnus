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

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workload Balance Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.partitioning.WorkloadBalancePartition#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.partitioning.WorkloadBalancePartition#getWorkload <em>Workload</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.partitioning.PartitioningPackage#getWorkloadBalancePartition()
 * @model
 * @generated
 */
public interface WorkloadBalancePartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getWorkloadBalancePartition_Actors()
	 * @model
	 * @generated
	 */
	List<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workload</em>' attribute.
	 * @see #setWorkload(double)
	 * @see turnus.model.analysis.partitioning.PartitioningPackage#getWorkloadBalancePartition_Workload()
	 * @model
	 * @generated
	 */
	double getWorkload();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.partitioning.WorkloadBalancePartition#getWorkload <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workload</em>' attribute.
	 * @see #getWorkload()
	 * @generated
	 */
	void setWorkload(double value);

} // WorkloadBalancePartition

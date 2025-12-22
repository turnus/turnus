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
package turnus.model.analysis.postprocessing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistical Actor Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getOccupancy <em>Occupancy</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getPartitionId <em>Partition Id</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getStatisticalActorPartition()
 * @model
 * @generated
 */
public interface StatisticalActorPartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' attribute list.
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getStatisticalActorPartition_Actors()
	 * @model
	 * @generated
	 */
	List<String> getActors();

	/**
	 * Returns the value of the '<em><b>Occupancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occupancy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occupancy</em>' attribute.
	 * @see #setOccupancy(double)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getStatisticalActorPartition_Occupancy()
	 * @model
	 * @generated
	 */
	double getOccupancy();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getOccupancy <em>Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occupancy</em>' attribute.
	 * @see #getOccupancy()
	 * @generated
	 */
	void setOccupancy(double value);

	/**
	 * Returns the value of the '<em><b>Scheduling Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Policy</em>' attribute.
	 * @see #setSchedulingPolicy(String)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getStatisticalActorPartition_SchedulingPolicy()
	 * @model
	 * @generated
	 */
	String getSchedulingPolicy();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getSchedulingPolicy <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Policy</em>' attribute.
	 * @see #getSchedulingPolicy()
	 * @generated
	 */
	void setSchedulingPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Id</em>' attribute.
	 * @see #setPartitionId(String)
	 * @see turnus.model.analysis.postprocessing.PostprocessingPackage#getStatisticalActorPartition_PartitionId()
	 * @model
	 * @generated
	 */
	String getPartitionId();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.postprocessing.StatisticalActorPartition#getPartitionId <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition Id</em>' attribute.
	 * @see #getPartitionId()
	 * @generated
	 */
	void setPartitionId(String value);

} // StatisticalActorPartition

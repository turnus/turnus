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
package turnus.model.analysis.profiling;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inter Partition Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getActors <em>Actors</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getWorkload <em>Workload</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getMaxIncomingBitsPerFiring <em>Max Incoming Bits Per Firing</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getMaxOutgoingBitsPerFiring <em>Max Outgoing Bits Per Firing</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getPersistentMemory <em>Persistent Memory</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getMaxTransientMemory <em>Max Transient Memory</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#getPartitionId <em>Partition Id</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionData#isOutgoingBufferOwnedBySource <em>Outgoing Buffer Owned By Source</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData()
 * @model
 * @generated
 */
public interface InterPartitionData extends EObject {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Actor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_Actors()
	 * @model
	 * @generated
	 */
	List<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Workload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workload</em>' attribute.
	 * @see #setWorkload(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_Workload()
	 * @model
	 * @generated
	 */
	double getWorkload();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getWorkload <em>Workload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workload</em>' attribute.
	 * @see #getWorkload()
	 * @generated
	 */
	void setWorkload(double value);

	/**
	 * Returns the value of the '<em><b>Max Incoming Bits Per Firing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Incoming Bits Per Firing</em>' attribute.
	 * @see #setMaxIncomingBitsPerFiring(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_MaxIncomingBitsPerFiring()
	 * @model
	 * @generated
	 */
	double getMaxIncomingBitsPerFiring();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxIncomingBitsPerFiring <em>Max Incoming Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Incoming Bits Per Firing</em>' attribute.
	 * @see #getMaxIncomingBitsPerFiring()
	 * @generated
	 */
	void setMaxIncomingBitsPerFiring(double value);

	/**
	 * Returns the value of the '<em><b>Max Outgoing Bits Per Firing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Outgoing Bits Per Firing</em>' attribute.
	 * @see #setMaxOutgoingBitsPerFiring(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_MaxOutgoingBitsPerFiring()
	 * @model
	 * @generated
	 */
	double getMaxOutgoingBitsPerFiring();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxOutgoingBitsPerFiring <em>Max Outgoing Bits Per Firing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Outgoing Bits Per Firing</em>' attribute.
	 * @see #getMaxOutgoingBitsPerFiring()
	 * @generated
	 */
	void setMaxOutgoingBitsPerFiring(double value);

	/**
	 * Returns the value of the '<em><b>Persistent Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Memory</em>' attribute.
	 * @see #setPersistentMemory(long)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_PersistentMemory()
	 * @model
	 * @generated
	 */
	long getPersistentMemory();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getPersistentMemory <em>Persistent Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistent Memory</em>' attribute.
	 * @see #getPersistentMemory()
	 * @generated
	 */
	void setPersistentMemory(long value);

	/**
	 * Returns the value of the '<em><b>Max Transient Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Transient Memory</em>' attribute.
	 * @see #setMaxTransientMemory(long)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_MaxTransientMemory()
	 * @model
	 * @generated
	 */
	long getMaxTransientMemory();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getMaxTransientMemory <em>Max Transient Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Transient Memory</em>' attribute.
	 * @see #getMaxTransientMemory()
	 * @generated
	 */
	void setMaxTransientMemory(long value);

	/**
	 * Returns the value of the '<em><b>Partition Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Id</em>' attribute.
	 * @see #setPartitionId(String)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_PartitionId()
	 * @model
	 * @generated
	 */
	String getPartitionId();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#getPartitionId <em>Partition Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition Id</em>' attribute.
	 * @see #getPartitionId()
	 * @generated
	 */
	void setPartitionId(String value);

	/**
	 * Returns the value of the '<em><b>Outgoing Buffer Owned By Source</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Buffer Owned By Source</em>' attribute.
	 * @see #setOutgoingBufferOwnedBySource(boolean)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionData_OutgoingBufferOwnedBySource()
	 * @model default="false"
	 * @generated
	 */
	boolean isOutgoingBufferOwnedBySource();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionData#isOutgoingBufferOwnedBySource <em>Outgoing Buffer Owned By Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Buffer Owned By Source</em>' attribute.
	 * @see #isOutgoingBufferOwnedBySource()
	 * @generated
	 */
	void setOutgoingBufferOwnedBySource(boolean value);

} // InterPartitionData

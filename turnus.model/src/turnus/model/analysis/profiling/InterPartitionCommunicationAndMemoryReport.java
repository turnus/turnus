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
import java.util.Map;
import turnus.model.analysis.AnalysisReport;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inter Partition Communication And Memory Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getPartitionData <em>Partition Data</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getNetwork <em>Network</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#isOutgoingBufferOwnedBySource <em>Outgoing Buffer Owned By Source</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getBufferDepthMap <em>Buffer Depth Map</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getActorPartitionMap <em>Actor Partition Map</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getCpWeight <em>Cp Weight</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getTime <em>Time</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#isDeadlock <em>Deadlock</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getCpWeightScheduled <em>Cp Weight Scheduled</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getMappingFile <em>Mapping File</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getBufferFile <em>Buffer File</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport()
 * @model
 * @generated
 */
public interface InterPartitionCommunicationAndMemoryReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Partition Data</b></em>' containment reference list.
	 * The list contents are of type {@link turnus.model.analysis.profiling.InterPartitionData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition Data</em>' containment reference list.
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_PartitionData()
	 * @model containment="true"
	 * @generated
	 */
	List<InterPartitionData> getPartitionData();

	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

	/**
	 * Returns the value of the '<em><b>Outgoing Buffer Owned By Source</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Buffer Owned By Source</em>' attribute.
	 * @see #setOutgoingBufferOwnedBySource(boolean)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_OutgoingBufferOwnedBySource()
	 * @model default="false"
	 * @generated
	 */
	boolean isOutgoingBufferOwnedBySource();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#isOutgoingBufferOwnedBySource <em>Outgoing Buffer Owned By Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Buffer Owned By Source</em>' attribute.
	 * @see #isOutgoingBufferOwnedBySource()
	 * @generated
	 */
	void setOutgoingBufferOwnedBySource(boolean value);

	/**
	 * Returns the value of the '<em><b>Buffer Depth Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Buffer},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Depth Map</em>' map.
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_BufferDepthMap()
	 * @model mapType="turnus.model.analysis.map.BufferToIntegerMap&lt;turnus.model.dataflow.Buffer, org.eclipse.emf.ecore.EIntegerObject&gt;"
	 * @generated
	 */
	Map<Buffer, Integer> getBufferDepthMap();

	/**
	 * Returns the value of the '<em><b>Actor Partition Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Partition Map</em>' map.
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_ActorPartitionMap()
	 * @model mapType="turnus.model.analysis.map.ActorToStringMap&lt;turnus.model.dataflow.Actor, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	Map<Actor, String> getActorPartitionMap();

	/**
	 * Returns the value of the '<em><b>Cp Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Weight</em>' attribute.
	 * @see #setCpWeight(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_CpWeight()
	 * @model required="true"
	 * @generated
	 */
	double getCpWeight();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getCpWeight <em>Cp Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Weight</em>' attribute.
	 * @see #getCpWeight()
	 * @generated
	 */
	void setCpWeight(double value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_Time()
	 * @model
	 * @generated
	 */
	double getTime();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(double value);

	/**
	 * Returns the value of the '<em><b>Deadlock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadlock</em>' attribute.
	 * @see #setDeadlock(boolean)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_Deadlock()
	 * @model
	 * @generated
	 */
	boolean isDeadlock();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#isDeadlock <em>Deadlock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadlock</em>' attribute.
	 * @see #isDeadlock()
	 * @generated
	 */
	void setDeadlock(boolean value);

	/**
	 * Returns the value of the '<em><b>Cp Weight Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Weight Scheduled</em>' attribute.
	 * @see #setCpWeightScheduled(double)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_CpWeightScheduled()
	 * @model required="true"
	 * @generated
	 */
	double getCpWeightScheduled();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getCpWeightScheduled <em>Cp Weight Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Weight Scheduled</em>' attribute.
	 * @see #getCpWeightScheduled()
	 * @generated
	 */
	void setCpWeightScheduled(double value);

	/**
	 * Returns the value of the '<em><b>Mapping File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping File</em>' attribute.
	 * @see #setMappingFile(String)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_MappingFile()
	 * @model
	 * @generated
	 */
	String getMappingFile();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getMappingFile <em>Mapping File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping File</em>' attribute.
	 * @see #getMappingFile()
	 * @generated
	 */
	void setMappingFile(String value);

	/**
	 * Returns the value of the '<em><b>Buffer File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer File</em>' attribute.
	 * @see #setBufferFile(String)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getInterPartitionCommunicationAndMemoryReport_BufferFile()
	 * @model
	 * @generated
	 */
	String getBufferFile();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport#getBufferFile <em>Buffer File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer File</em>' attribute.
	 * @see #getBufferFile()
	 * @generated
	 */
	void setBufferFile(String value);

} // InterPartitionCommunicationAndMemoryReport

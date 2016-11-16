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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import turnus.model.common.StatisticalData;

import turnus.model.dataflow.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intra Action Communication Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getAction <em>Action</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getConsumedTokens <em>Consumed Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getProducedTokens <em>Produced Tokens</em>}</li>
 *   <li>{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getTokensProducersMap <em>Tokens Producers Map</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.profiling.ProfilingPackage#getIntraActionCommunicationData()
 * @model
 * @generated
 */
public interface IntraActionCommunicationData extends EObject {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getIntraActionCommunicationData_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Consumed Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consumed Tokens</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumed Tokens</em>' containment reference.
	 * @see #setConsumedTokens(StatisticalData)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getIntraActionCommunicationData_ConsumedTokens()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getConsumedTokens();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getConsumedTokens <em>Consumed Tokens</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consumed Tokens</em>' containment reference.
	 * @see #getConsumedTokens()
	 * @generated
	 */
	void setConsumedTokens(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Produced Tokens</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced Tokens</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced Tokens</em>' containment reference.
	 * @see #setProducedTokens(StatisticalData)
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getIntraActionCommunicationData_ProducedTokens()
	 * @model containment="true"
	 * @generated
	 */
	StatisticalData getProducedTokens();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.profiling.IntraActionCommunicationData#getProducedTokens <em>Produced Tokens</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Produced Tokens</em>' containment reference.
	 * @see #getProducedTokens()
	 * @generated
	 */
	void setProducedTokens(StatisticalData value);

	/**
	 * Returns the value of the '<em><b>Tokens Producers Map</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link turnus.model.common.StatisticalData},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens Producers Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens Producers Map</em>' map.
	 * @see turnus.model.analysis.profiling.ProfilingPackage#getIntraActionCommunicationData_TokensProducersMap()
	 * @model mapType="turnus.model.analysis.map.ActionToStatisticalDataMap<turnus.model.dataflow.Action, turnus.model.common.StatisticalData>"
	 * @generated
	 */
	Map<Action, StatisticalData> getTokensProducersMap();

} // IntraActionCommunicationData

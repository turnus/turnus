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
package turnus.model.analysis.bottlenecks;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import turnus.model.dataflow.Action;
import turnus.model.dataflow.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Analysis Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getCpReductionMap <em>Cp Reduction Map</em>}</li>
 *   <li>{@link turnus.model.analysis.bottlenecks.ImpactAnalysisData#getReportsMap <em>Reports Map</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getImpactAnalysisData()
 * @model
 * @generated
 */
public interface ImpactAnalysisData extends EObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link turnus.model.dataflow.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getImpactAnalysisData_Actions()
	 * @model required="true"
	 * @generated
	 */
	List<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getImpactAnalysisData_ActorClass()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Returns the value of the '<em><b>Cp Reduction Map</b></em>' map.
	 * The key is of type {@link java.lang.Double},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Reduction Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Reduction Map</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getImpactAnalysisData_CpReductionMap()
	 * @model mapType="turnus.model.analysis.map.DoubleToDoubleMap&lt;org.eclipse.emf.ecore.EDoubleObject, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	Map<Double, Double> getCpReductionMap();

	/**
	 * Returns the value of the '<em><b>Reports Map</b></em>' map.
	 * The key is of type {@link java.lang.Double},
	 * and the value is of type {@link turnus.model.analysis.bottlenecks.BottlenecksReport},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reports Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reports Map</em>' map.
	 * @see turnus.model.analysis.bottlenecks.BottlenecksPackage#getImpactAnalysisData_ReportsMap()
	 * @model mapType="turnus.model.analysis.bottlenecks.DoubleToBottlenecksReportMap&lt;org.eclipse.emf.ecore.EDoubleObject, turnus.model.analysis.bottlenecks.BottlenecksReport&gt;"
	 * @generated
	 */
	Map<Double, BottlenecksReport> getReportsMap();

} // ImpactAnalysisData

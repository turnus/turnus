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
package turnus.model.analysis.pipelining;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import turnus.model.analysis.bottlenecks.BottlenecksReport;

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
 *   <li>{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getEstimatedBottlenecks <em>Estimated Bottlenecks</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getCpReduction <em>Cp Reduction</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getActions <em>Actions</em>}</li>
 *   <li>{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.pipelining.PipeliningPackage#getImpactAnalysisData()
 * @model
 * @generated
 */
public interface ImpactAnalysisData extends EObject {
	/**
	 * Returns the value of the '<em><b>Estimated Bottlenecks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimated Bottlenecks</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimated Bottlenecks</em>' containment reference.
	 * @see #setEstimatedBottlenecks(BottlenecksReport)
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getImpactAnalysisData_EstimatedBottlenecks()
	 * @model containment="true"
	 * @generated
	 */
	BottlenecksReport getEstimatedBottlenecks();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getEstimatedBottlenecks <em>Estimated Bottlenecks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimated Bottlenecks</em>' containment reference.
	 * @see #getEstimatedBottlenecks()
	 * @generated
	 */
	void setEstimatedBottlenecks(BottlenecksReport value);

	/**
	 * Returns the value of the '<em><b>Cp Reduction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cp Reduction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cp Reduction</em>' attribute.
	 * @see #setCpReduction(double)
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getImpactAnalysisData_CpReduction()
	 * @model
	 * @generated
	 */
	double getCpReduction();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.pipelining.ImpactAnalysisData#getCpReduction <em>Cp Reduction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cp Reduction</em>' attribute.
	 * @see #getCpReduction()
	 * @generated
	 */
	void setCpReduction(double value);

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
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getImpactAnalysisData_Actions()
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
	 * @see turnus.model.analysis.pipelining.PipeliningPackage#getImpactAnalysisData_ActorClass()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ActorClass getActorClass();

} // ImpactAnalysisData

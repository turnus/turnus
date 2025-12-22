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
package turnus.model.analysis.trace;

import java.util.Map;
import turnus.model.analysis.AnalysisReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Size Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActionsFirings <em>Actions Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActionsIncomings <em>Actions Incomings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActionsOutgoings <em>Actions Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActorsFirings <em>Actors Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActorsIncoming <em>Actors Incoming</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getActorsOutgoings <em>Actors Outgoings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getFirings <em>Firings</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getDependenciesKinds <em>Dependencies Kinds</em>}</li>
 *   <li>{@link turnus.model.analysis.trace.TraceSizeReport#getNetwork <em>Network</em>}</li>
 * </ul>
 *
 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport()
 * @model
 * @generated
 */
public interface TraceSizeReport extends AnalysisReport {
	/**
	 * Returns the value of the '<em><b>Actions Firings</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Firings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Firings</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActionsFirings()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Action, Long> getActionsFirings();

	/**
	 * Returns the value of the '<em><b>Actions Incomings</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Incomings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Incomings</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActionsIncomings()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Action, Long> getActionsIncomings();

	/**
	 * Returns the value of the '<em><b>Actions Outgoings</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Action},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Outgoings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Outgoings</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActionsOutgoings()
	 * @model mapType="turnus.model.analysis.map.ActionToLongMap&lt;turnus.model.dataflow.Action, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Action, Long> getActionsOutgoings();

	/**
	 * Returns the value of the '<em><b>Actors Firings</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors Firings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors Firings</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActorsFirings()
	 * @model mapType="turnus.model.analysis.map.ActorToLongMap&lt;turnus.model.dataflow.Actor, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Actor, Long> getActorsFirings();

	/**
	 * Returns the value of the '<em><b>Actors Incoming</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors Incoming</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors Incoming</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActorsIncoming()
	 * @model mapType="turnus.model.analysis.map.ActorToLongMap&lt;turnus.model.dataflow.Actor, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Actor, Long> getActorsIncoming();

	/**
	 * Returns the value of the '<em><b>Actors Outgoings</b></em>' map.
	 * The key is of type {@link turnus.model.dataflow.Actor},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors Outgoings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors Outgoings</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_ActorsOutgoings()
	 * @model mapType="turnus.model.analysis.map.ActorToLongMap&lt;turnus.model.dataflow.Actor, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<Actor, Long> getActorsOutgoings();

	/**
	 * Returns the value of the '<em><b>Firings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Firings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Firings</em>' attribute.
	 * @see #setFirings(long)
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_Firings()
	 * @model
	 * @generated
	 */
	long getFirings();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.TraceSizeReport#getFirings <em>Firings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firings</em>' attribute.
	 * @see #getFirings()
	 * @generated
	 */
	void setFirings(long value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' attribute.
	 * @see #setDependencies(long)
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_Dependencies()
	 * @model
	 * @generated
	 */
	long getDependencies();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.TraceSizeReport#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(long value);

	/**
	 * Returns the value of the '<em><b>Dependencies Kinds</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Long},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies Kinds</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies Kinds</em>' map.
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_DependenciesKinds()
	 * @model mapType="turnus.model.analysis.map.StringToLongMap&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.ELongObject&gt;"
	 * @generated
	 */
	Map<String, Long> getDependenciesKinds();

	/**
	 * Returns the value of the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Network</em>' reference.
	 * @see #setNetwork(Network)
	 * @see turnus.model.analysis.trace.TracePackage#getTraceSizeReport_Network()
	 * @model
	 * @generated
	 */
	Network getNetwork();

	/**
	 * Sets the value of the '{@link turnus.model.analysis.trace.TraceSizeReport#getNetwork <em>Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network</em>' reference.
	 * @see #getNetwork()
	 * @generated
	 */
	void setNetwork(Network value);

} // TraceSizeReport

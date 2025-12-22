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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = turnus.model.analysis.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Size Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size Report</em>'.
	 * @generated
	 */
	TraceSizeReport createTraceSizeReport();

	/**
	 * Returns a new object of class '<em>Compressed Trace Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Trace Report</em>'.
	 * @generated
	 */
	CompressedTraceReport createCompressedTraceReport();

	/**
	 * Returns a new object of class '<em>Compressed Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Step</em>'.
	 * @generated
	 */
	CompressedStep createCompressedStep();

	/**
	 * Returns a new object of class '<em>Compressed Fsm Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Fsm Dependency</em>'.
	 * @generated
	 */
	CompressedFsmDependency createCompressedFsmDependency();

	/**
	 * Returns a new object of class '<em>Compressed Guard Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Guard Dependency</em>'.
	 * @generated
	 */
	CompressedGuardDependency createCompressedGuardDependency();

	/**
	 * Returns a new object of class '<em>Compressed Variable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Variable Dependency</em>'.
	 * @generated
	 */
	CompressedVariableDependency createCompressedVariableDependency();

	/**
	 * Returns a new object of class '<em>Compressed Port Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Port Dependency</em>'.
	 * @generated
	 */
	CompressedPortDependency createCompressedPortDependency();

	/**
	 * Returns a new object of class '<em>Compressed Tokens Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compressed Tokens Dependency</em>'.
	 * @generated
	 */
	CompressedTokensDependency createCompressedTokensDependency();

	/**
	 * Returns a new object of class '<em>Comparator Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comparator Report</em>'.
	 * @generated
	 */
	TraceComparatorReport createTraceComparatorReport();

	/**
	 * Returns a new object of class '<em>Compared Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compared Trace</em>'.
	 * @generated
	 */
	ComparedTrace createComparedTrace();

	/**
	 * Returns a new object of class '<em>Compared Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compared Action</em>'.
	 * @generated
	 */
	ComparedAction createComparedAction();

	/**
	 * Returns a new object of class '<em>Markow Model Trace Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markow Model Trace Report</em>'.
	 * @generated
	 */
	MarkowModelTraceReport createMarkowModelTraceReport();

	/**
	 * Returns a new object of class '<em>Markov Model Action Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markov Model Action Data</em>'.
	 * @generated
	 */
	MarkovModelActionData createMarkovModelActionData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceLoader

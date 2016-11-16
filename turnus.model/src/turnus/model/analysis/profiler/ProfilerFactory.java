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
package turnus.model.analysis.profiler;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.profiler.ProfilerPackage
 * @generated
 */
public interface ProfilerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfilerFactory eINSTANCE = turnus.model.analysis.profiler.impl.ProfilerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Code Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Profiling Report</em>'.
	 * @generated
	 */
	CodeProfilingReport createCodeProfilingReport();

	/**
	 * Returns a new object of class '<em>Code Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Data</em>'.
	 * @generated
	 */
	CodeData createCodeData();

	/**
	 * Returns a new object of class '<em>Complex Code Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Code Data</em>'.
	 * @generated
	 */
	ComplexCodeData createComplexCodeData();

	/**
	 * Returns a new object of class '<em>Dynamic Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Profiling Report</em>'.
	 * @generated
	 */
	DynamicProfilingReport createDynamicProfilingReport();

	/**
	 * Returns a new object of class '<em>Actor Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Dynamic Data</em>'.
	 * @generated
	 */
	ActorDynamicData createActorDynamicData();

	/**
	 * Returns a new object of class '<em>Action Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Dynamic Data</em>'.
	 * @generated
	 */
	ActionDynamicData createActionDynamicData();

	/**
	 * Returns a new object of class '<em>Buffer Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Dynamic Data</em>'.
	 * @generated
	 */
	BufferDynamicData createBufferDynamicData();

	/**
	 * Returns a new object of class '<em>Complex Dynamic Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Dynamic Data</em>'.
	 * @generated
	 */
	ComplexDynamicData createComplexDynamicData();

	/**
	 * Returns a new object of class '<em>Memory Profiling Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Profiling Report</em>'.
	 * @generated
	 */
	MemoryProfilingReport createMemoryProfilingReport();

	/**
	 * Returns a new object of class '<em>Action Memory Profiling Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Memory Profiling Data</em>'.
	 * @generated
	 */
	ActionMemoryProfilingData createActionMemoryProfilingData();

	/**
	 * Returns a new object of class '<em>Buffer Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Access Data</em>'.
	 * @generated
	 */
	BufferAccessData createBufferAccessData();

	/**
	 * Returns a new object of class '<em>State Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable Access Data</em>'.
	 * @generated
	 */
	StateVariableAccessData createStateVariableAccessData();

	/**
	 * Returns a new object of class '<em>Local Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Variable Access Data</em>'.
	 * @generated
	 */
	LocalVariableAccessData createLocalVariableAccessData();

	/**
	 * Returns a new object of class '<em>Shared Variable Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Variable Access Data</em>'.
	 * @generated
	 */
	SharedVariableAccessData createSharedVariableAccessData();

	/**
	 * Returns a new object of class '<em>Access Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Data</em>'.
	 * @generated
	 */
	AccessData createAccessData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProfilerPackage getProfilerPackage();

} //ProfilerFactory

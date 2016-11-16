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
package turnus.model.analysis.profiler.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import turnus.model.analysis.AnalysisReport;
import turnus.model.analysis.profiler.*;

import turnus.model.dataflow.Procedure;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.profiler.ProfilerPackage
 * @generated
 */
public class ProfilerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProfilerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProfilerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfilerSwitch<Adapter> modelSwitch =
		new ProfilerSwitch<Adapter>() {
			@Override
			public Adapter caseCodeProfilingReport(CodeProfilingReport object) {
				return createCodeProfilingReportAdapter();
			}
			@Override
			public Adapter caseCodeData(CodeData object) {
				return createCodeDataAdapter();
			}
			@Override
			public Adapter caseComplexCodeData(ComplexCodeData object) {
				return createComplexCodeDataAdapter();
			}
			@Override
			public Adapter caseDynamicProfilingReport(DynamicProfilingReport object) {
				return createDynamicProfilingReportAdapter();
			}
			@Override
			public Adapter caseActorDynamicData(ActorDynamicData object) {
				return createActorDynamicDataAdapter();
			}
			@Override
			public Adapter caseActionDynamicData(ActionDynamicData object) {
				return createActionDynamicDataAdapter();
			}
			@Override
			public Adapter caseBufferDynamicData(BufferDynamicData object) {
				return createBufferDynamicDataAdapter();
			}
			@Override
			public Adapter caseComplexDynamicData(ComplexDynamicData object) {
				return createComplexDynamicDataAdapter();
			}
			@Override
			public Adapter caseProcedureToComplexDynamicDataMap(Map.Entry<Procedure, ComplexDynamicData> object) {
				return createProcedureToComplexDynamicDataMapAdapter();
			}
			@Override
			public Adapter caseMemoryProfilingReport(MemoryProfilingReport object) {
				return createMemoryProfilingReportAdapter();
			}
			@Override
			public Adapter caseActionMemoryProfilingData(ActionMemoryProfilingData object) {
				return createActionMemoryProfilingDataAdapter();
			}
			@Override
			public Adapter caseMemoryAccessData(MemoryAccessData object) {
				return createMemoryAccessDataAdapter();
			}
			@Override
			public Adapter caseBufferAccessData(BufferAccessData object) {
				return createBufferAccessDataAdapter();
			}
			@Override
			public Adapter caseStateVariableAccessData(StateVariableAccessData object) {
				return createStateVariableAccessDataAdapter();
			}
			@Override
			public Adapter caseLocalVariableAccessData(LocalVariableAccessData object) {
				return createLocalVariableAccessDataAdapter();
			}
			@Override
			public Adapter caseSharedVariableAccessData(SharedVariableAccessData object) {
				return createSharedVariableAccessDataAdapter();
			}
			@Override
			public Adapter caseAccessData(AccessData object) {
				return createAccessDataAdapter();
			}
			@Override
			public Adapter caseStringToAccessDataMap(Map.Entry<String, AccessData> object) {
				return createStringToAccessDataMapAdapter();
			}
			@Override
			public Adapter caseAnalysisReport(AnalysisReport object) {
				return createAnalysisReportAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.CodeProfilingReport <em>Code Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.CodeProfilingReport
	 * @generated
	 */
	public Adapter createCodeProfilingReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.CodeData <em>Code Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.CodeData
	 * @generated
	 */
	public Adapter createCodeDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.ComplexCodeData <em>Complex Code Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.ComplexCodeData
	 * @generated
	 */
	public Adapter createComplexCodeDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.DynamicProfilingReport <em>Dynamic Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.DynamicProfilingReport
	 * @generated
	 */
	public Adapter createDynamicProfilingReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.ActorDynamicData <em>Actor Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.ActorDynamicData
	 * @generated
	 */
	public Adapter createActorDynamicDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.ActionDynamicData <em>Action Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.ActionDynamicData
	 * @generated
	 */
	public Adapter createActionDynamicDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.BufferDynamicData <em>Buffer Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.BufferDynamicData
	 * @generated
	 */
	public Adapter createBufferDynamicDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.ComplexDynamicData <em>Complex Dynamic Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.ComplexDynamicData
	 * @generated
	 */
	public Adapter createComplexDynamicDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Procedure To Complex Dynamic Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createProcedureToComplexDynamicDataMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.MemoryProfilingReport <em>Memory Profiling Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.MemoryProfilingReport
	 * @generated
	 */
	public Adapter createMemoryProfilingReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.ActionMemoryProfilingData <em>Action Memory Profiling Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.ActionMemoryProfilingData
	 * @generated
	 */
	public Adapter createActionMemoryProfilingDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.MemoryAccessData <em>Memory Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.MemoryAccessData
	 * @generated
	 */
	public Adapter createMemoryAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.BufferAccessData <em>Buffer Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.BufferAccessData
	 * @generated
	 */
	public Adapter createBufferAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.StateVariableAccessData <em>State Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.StateVariableAccessData
	 * @generated
	 */
	public Adapter createStateVariableAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.LocalVariableAccessData <em>Local Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.LocalVariableAccessData
	 * @generated
	 */
	public Adapter createLocalVariableAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.SharedVariableAccessData <em>Shared Variable Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.SharedVariableAccessData
	 * @generated
	 */
	public Adapter createSharedVariableAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.profiler.AccessData <em>Access Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.profiler.AccessData
	 * @generated
	 */
	public Adapter createAccessDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Access Data Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToAccessDataMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link turnus.model.analysis.AnalysisReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see turnus.model.analysis.AnalysisReport
	 * @generated
	 */
	public Adapter createAnalysisReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ProfilerAdapterFactory

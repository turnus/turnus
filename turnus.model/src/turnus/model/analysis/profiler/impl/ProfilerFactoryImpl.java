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
package turnus.model.analysis.profiler.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.profiler.*;

import turnus.model.dataflow.Procedure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfilerFactoryImpl extends EFactoryImpl implements ProfilerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfilerFactory init() {
		try {
			ProfilerFactory theProfilerFactory = (ProfilerFactory)EPackage.Registry.INSTANCE.getEFactory(ProfilerPackage.eNS_URI);
			if (theProfilerFactory != null) {
				return theProfilerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfilerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProfilerPackage.CODE_PROFILING_REPORT: return createCodeProfilingReport();
			case ProfilerPackage.CODE_DATA: return createCodeData();
			case ProfilerPackage.COMPLEX_CODE_DATA: return createComplexCodeData();
			case ProfilerPackage.DYNAMIC_PROFILING_REPORT: return createDynamicProfilingReport();
			case ProfilerPackage.ACTOR_DYNAMIC_DATA: return createActorDynamicData();
			case ProfilerPackage.ACTION_DYNAMIC_DATA: return createActionDynamicData();
			case ProfilerPackage.BUFFER_DYNAMIC_DATA: return createBufferDynamicData();
			case ProfilerPackage.COMPLEX_DYNAMIC_DATA: return createComplexDynamicData();
			case ProfilerPackage.PROCEDURE_TO_COMPLEX_DYNAMIC_DATA_MAP: return (EObject)createProcedureToComplexDynamicDataMap();
			case ProfilerPackage.MEMORY_PROFILING_REPORT: return createMemoryProfilingReport();
			case ProfilerPackage.ACTION_MEMORY_PROFILING_DATA: return createActionMemoryProfilingData();
			case ProfilerPackage.BUFFER_ACCESS_DATA: return createBufferAccessData();
			case ProfilerPackage.STATE_VARIABLE_ACCESS_DATA: return createStateVariableAccessData();
			case ProfilerPackage.LOCAL_VARIABLE_ACCESS_DATA: return createLocalVariableAccessData();
			case ProfilerPackage.SHARED_VARIABLE_ACCESS_DATA: return createSharedVariableAccessData();
			case ProfilerPackage.ACCESS_DATA: return createAccessData();
			case ProfilerPackage.STRING_TO_ACCESS_DATA_MAP: return (EObject)createStringToAccessDataMap();
			case ProfilerPackage.BENCHMARK_REPORT: return createBenchmarkReport();
			case ProfilerPackage.TABLE_ROW: return createTableRow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeProfilingReport createCodeProfilingReport() {
		CodeProfilingReportImpl codeProfilingReport = new CodeProfilingReportImpl();
		return codeProfilingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeData createCodeData() {
		CodeDataImpl codeData = new CodeDataImpl();
		return codeData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexCodeData createComplexCodeData() {
		ComplexCodeDataImpl complexCodeData = new ComplexCodeDataImpl();
		return complexCodeData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicProfilingReport createDynamicProfilingReport() {
		DynamicProfilingReportImpl dynamicProfilingReport = new DynamicProfilingReportImpl();
		return dynamicProfilingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorDynamicData createActorDynamicData() {
		ActorDynamicDataImpl actorDynamicData = new ActorDynamicDataImpl();
		return actorDynamicData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionDynamicData createActionDynamicData() {
		ActionDynamicDataImpl actionDynamicData = new ActionDynamicDataImpl();
		return actionDynamicData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferDynamicData createBufferDynamicData() {
		BufferDynamicDataImpl bufferDynamicData = new BufferDynamicDataImpl();
		return bufferDynamicData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexDynamicData createComplexDynamicData() {
		ComplexDynamicDataImpl complexDynamicData = new ComplexDynamicDataImpl();
		return complexDynamicData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Procedure, ComplexDynamicData> createProcedureToComplexDynamicDataMap() {
		ProcedureToComplexDynamicDataMapImpl procedureToComplexDynamicDataMap = new ProcedureToComplexDynamicDataMapImpl();
		return procedureToComplexDynamicDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryProfilingReport createMemoryProfilingReport() {
		MemoryProfilingReportImpl memoryProfilingReport = new MemoryProfilingReportImpl();
		return memoryProfilingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionMemoryProfilingData createActionMemoryProfilingData() {
		ActionMemoryProfilingDataImpl actionMemoryProfilingData = new ActionMemoryProfilingDataImpl();
		return actionMemoryProfilingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferAccessData createBufferAccessData() {
		BufferAccessDataImpl bufferAccessData = new BufferAccessDataImpl();
		return bufferAccessData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariableAccessData createStateVariableAccessData() {
		StateVariableAccessDataImpl stateVariableAccessData = new StateVariableAccessDataImpl();
		return stateVariableAccessData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableAccessData createLocalVariableAccessData() {
		LocalVariableAccessDataImpl localVariableAccessData = new LocalVariableAccessDataImpl();
		return localVariableAccessData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SharedVariableAccessData createSharedVariableAccessData() {
		SharedVariableAccessDataImpl sharedVariableAccessData = new SharedVariableAccessDataImpl();
		return sharedVariableAccessData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessData createAccessData() {
		AccessDataImpl accessData = new AccessDataImpl();
		return accessData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, AccessData> createStringToAccessDataMap() {
		StringToAccessDataMapImpl stringToAccessDataMap = new StringToAccessDataMapImpl();
		return stringToAccessDataMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenchmarkReport createBenchmarkReport() {
		BenchmarkReportImpl benchmarkReport = new BenchmarkReportImpl();
		return benchmarkReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableRow createTableRow() {
		TableRowImpl tableRow = new TableRowImpl();
		return tableRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilerPackage getProfilerPackage() {
		return (ProfilerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfilerPackage getPackage() {
		return ProfilerPackage.eINSTANCE;
	}

} //ProfilerFactoryImpl

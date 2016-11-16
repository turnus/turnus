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
package turnus.model.analysis.trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.trace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceFactoryImpl extends EFactoryImpl implements TraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceFactory init() {
		try {
			TraceFactory theTraceFactory = (TraceFactory)EPackage.Registry.INSTANCE.getEFactory(TracePackage.eNS_URI);
			if (theTraceFactory != null) {
				return theTraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFactoryImpl() {
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
			case TracePackage.TRACE_SIZE_REPORT: return createTraceSizeReport();
			case TracePackage.COMPRESSED_TRACE_REPORT: return createCompressedTraceReport();
			case TracePackage.COMPRESSED_STEP: return createCompressedStep();
			case TracePackage.COMPRESSED_FSM_DEPENDENCY: return createCompressedFsmDependency();
			case TracePackage.COMPRESSED_GUARD_DEPENDENCY: return createCompressedGuardDependency();
			case TracePackage.COMPRESSED_VARIABLE_DEPENDENCY: return createCompressedVariableDependency();
			case TracePackage.COMPRESSED_PORT_DEPENDENCY: return createCompressedPortDependency();
			case TracePackage.COMPRESSED_TOKENS_DEPENDENCY: return createCompressedTokensDependency();
			case TracePackage.TRACE_COMPARATOR_REPORT: return createTraceComparatorReport();
			case TracePackage.COMPARED_TRACE: return createComparedTrace();
			case TracePackage.COMPARED_ACTION: return createComparedAction();
			case TracePackage.MARKOW_MODEL_TRACE_REPORT: return createMarkowModelTraceReport();
			case TracePackage.MARKOV_MODEL_ACTION_DATA: return createMarkovModelActionData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSizeReport createTraceSizeReport() {
		TraceSizeReportImpl traceSizeReport = new TraceSizeReportImpl();
		return traceSizeReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedTraceReport createCompressedTraceReport() {
		CompressedTraceReportImpl compressedTraceReport = new CompressedTraceReportImpl();
		return compressedTraceReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedStep createCompressedStep() {
		CompressedStepImpl compressedStep = new CompressedStepImpl();
		return compressedStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedFsmDependency createCompressedFsmDependency() {
		CompressedFsmDependencyImpl compressedFsmDependency = new CompressedFsmDependencyImpl();
		return compressedFsmDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedGuardDependency createCompressedGuardDependency() {
		CompressedGuardDependencyImpl compressedGuardDependency = new CompressedGuardDependencyImpl();
		return compressedGuardDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedVariableDependency createCompressedVariableDependency() {
		CompressedVariableDependencyImpl compressedVariableDependency = new CompressedVariableDependencyImpl();
		return compressedVariableDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedPortDependency createCompressedPortDependency() {
		CompressedPortDependencyImpl compressedPortDependency = new CompressedPortDependencyImpl();
		return compressedPortDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedTokensDependency createCompressedTokensDependency() {
		CompressedTokensDependencyImpl compressedTokensDependency = new CompressedTokensDependencyImpl();
		return compressedTokensDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceComparatorReport createTraceComparatorReport() {
		TraceComparatorReportImpl traceComparatorReport = new TraceComparatorReportImpl();
		return traceComparatorReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparedTrace createComparedTrace() {
		ComparedTraceImpl comparedTrace = new ComparedTraceImpl();
		return comparedTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparedAction createComparedAction() {
		ComparedActionImpl comparedAction = new ComparedActionImpl();
		return comparedAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkowModelTraceReport createMarkowModelTraceReport() {
		MarkowModelTraceReportImpl markowModelTraceReport = new MarkowModelTraceReportImpl();
		return markowModelTraceReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkovModelActionData createMarkovModelActionData() {
		MarkovModelActionDataImpl markovModelActionData = new MarkovModelActionDataImpl();
		return markovModelActionData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracePackage getTracePackage() {
		return (TracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TracePackage getPackage() {
		return TracePackage.eINSTANCE;
	}

} //TraceFactoryImpl

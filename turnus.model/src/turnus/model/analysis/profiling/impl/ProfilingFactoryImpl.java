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
package turnus.model.analysis.profiling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.profiling.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfilingFactoryImpl extends EFactoryImpl implements ProfilingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfilingFactory init() {
		try {
			ProfilingFactory theProfilingFactory = (ProfilingFactory)EPackage.Registry.INSTANCE.getEFactory(ProfilingPackage.eNS_URI);
			if (theProfilingFactory != null) {
				return theProfilingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfilingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilingFactoryImpl() {
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
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_REPORT: return createIntraActionCommunicationReport();
			case ProfilingPackage.INTRA_ACTOR_COMMUNICATION_DATA: return createIntraActorCommunicationData();
			case ProfilingPackage.INTRA_ACTION_COMMUNICATION_DATA: return createIntraActionCommunicationData();
			case ProfilingPackage.PROFILING_STATS_REPORT: return createProfilingStatsReport();
			case ProfilingPackage.PROFILING_STATS_ACTOR_DATA: return createProfilingStatsActorData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntraActionCommunicationReport createIntraActionCommunicationReport() {
		IntraActionCommunicationReportImpl intraActionCommunicationReport = new IntraActionCommunicationReportImpl();
		return intraActionCommunicationReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntraActorCommunicationData createIntraActorCommunicationData() {
		IntraActorCommunicationDataImpl intraActorCommunicationData = new IntraActorCommunicationDataImpl();
		return intraActorCommunicationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntraActionCommunicationData createIntraActionCommunicationData() {
		IntraActionCommunicationDataImpl intraActionCommunicationData = new IntraActionCommunicationDataImpl();
		return intraActionCommunicationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfilingStatsReport createProfilingStatsReport() {
		ProfilingStatsReportImpl profilingStatsReport = new ProfilingStatsReportImpl();
		return profilingStatsReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfilingStatsActorData createProfilingStatsActorData() {
		ProfilingStatsActorDataImpl profilingStatsActorData = new ProfilingStatsActorDataImpl();
		return profilingStatsActorData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfilingPackage getProfilingPackage() {
		return (ProfilingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfilingPackage getPackage() {
		return ProfilingPackage.eINSTANCE;
	}

} //ProfilingFactoryImpl

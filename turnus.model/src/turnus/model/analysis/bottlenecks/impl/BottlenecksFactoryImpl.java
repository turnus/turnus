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
package turnus.model.analysis.bottlenecks.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.bottlenecks.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BottlenecksFactoryImpl extends EFactoryImpl implements BottlenecksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BottlenecksFactory init() {
		try {
			BottlenecksFactory theBottlenecksFactory = (BottlenecksFactory)EPackage.Registry.INSTANCE.getEFactory(BottlenecksPackage.eNS_URI);
			if (theBottlenecksFactory != null) {
				return theBottlenecksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BottlenecksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottlenecksFactoryImpl() {
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
			case BottlenecksPackage.BOTTLENECKS_REPORT: return createBottlenecksReport();
			case BottlenecksPackage.ACTION_BOTTLENECKS_DATA: return createActionBottlenecksData();
			case BottlenecksPackage.IMPACT_ANALYSIS_REPORT: return createImpactAnalysisReport();
			case BottlenecksPackage.IMPACT_ANALYSIS_DATA: return createImpactAnalysisData();
			case BottlenecksPackage.DOUBLE_TO_BOTTLENECKS_REPORT_MAP: return (EObject)createDoubleToBottlenecksReportMap();
			case BottlenecksPackage.BOTTLENECKS_WITH_SCHEDULING_REPORT: return createBottlenecksWithSchedulingReport();
			case BottlenecksPackage.ACTION_BOTTLENECKS_WITH_SCHEDULING_DATA: return createActionBottlenecksWithSchedulingData();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_DATA: return createScheduledImpactAnalysisData();
			case BottlenecksPackage.DOUBLE_TO_BOTTLENECKS_WITH_SCHEDULING_REPORT_MAP: return (EObject)createDoubleToBottlenecksWithSchedulingReportMap();
			case BottlenecksPackage.SCHEDULED_IMPACT_ANALYSIS_REPORT: return createScheduledImpactAnalysisReport();
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
	public BottlenecksReport createBottlenecksReport() {
		BottlenecksReportImpl bottlenecksReport = new BottlenecksReportImpl();
		return bottlenecksReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionBottlenecksData createActionBottlenecksData() {
		ActionBottlenecksDataImpl actionBottlenecksData = new ActionBottlenecksDataImpl();
		return actionBottlenecksData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImpactAnalysisReport createImpactAnalysisReport() {
		ImpactAnalysisReportImpl impactAnalysisReport = new ImpactAnalysisReportImpl();
		return impactAnalysisReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImpactAnalysisData createImpactAnalysisData() {
		ImpactAnalysisDataImpl impactAnalysisData = new ImpactAnalysisDataImpl();
		return impactAnalysisData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Double, BottlenecksReport> createDoubleToBottlenecksReportMap() {
		DoubleToBottlenecksReportMapImpl doubleToBottlenecksReportMap = new DoubleToBottlenecksReportMapImpl();
		return doubleToBottlenecksReportMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksWithSchedulingReport createBottlenecksWithSchedulingReport() {
		BottlenecksWithSchedulingReportImpl bottlenecksWithSchedulingReport = new BottlenecksWithSchedulingReportImpl();
		return bottlenecksWithSchedulingReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionBottlenecksWithSchedulingData createActionBottlenecksWithSchedulingData() {
		ActionBottlenecksWithSchedulingDataImpl actionBottlenecksWithSchedulingData = new ActionBottlenecksWithSchedulingDataImpl();
		return actionBottlenecksWithSchedulingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledImpactAnalysisData createScheduledImpactAnalysisData() {
		ScheduledImpactAnalysisDataImpl scheduledImpactAnalysisData = new ScheduledImpactAnalysisDataImpl();
		return scheduledImpactAnalysisData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Double, BottlenecksWithSchedulingReport> createDoubleToBottlenecksWithSchedulingReportMap() {
		DoubleToBottlenecksWithSchedulingReportMapImpl doubleToBottlenecksWithSchedulingReportMap = new DoubleToBottlenecksWithSchedulingReportMapImpl();
		return doubleToBottlenecksWithSchedulingReportMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledImpactAnalysisReport createScheduledImpactAnalysisReport() {
		ScheduledImpactAnalysisReportImpl scheduledImpactAnalysisReport = new ScheduledImpactAnalysisReportImpl();
		return scheduledImpactAnalysisReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottlenecksPackage getBottlenecksPackage() {
		return (BottlenecksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BottlenecksPackage getPackage() {
		return BottlenecksPackage.eINSTANCE;
	}

} //BottlenecksFactoryImpl

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
package turnus.model.analysis.pipelining.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.model.analysis.pipelining.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeliningFactoryImpl extends EFactoryImpl implements PipeliningFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PipeliningFactory init() {
		try {
			PipeliningFactory thePipeliningFactory = (PipeliningFactory)EPackage.Registry.INSTANCE.getEFactory(PipeliningPackage.eNS_URI);
			if (thePipeliningFactory != null) {
				return thePipeliningFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PipeliningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeliningFactoryImpl() {
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
			case PipeliningPackage.ACTIONS_VARIABLE_PIPELINING_REPORT: return createActionsVariablePipeliningReport();
			case PipeliningPackage.ACTION_VARIABLE_PIPELINING_DATA: return createActionVariablePipeliningData();
			case PipeliningPackage.IMPACT_ANALYSIS_REPORT: return createImpactAnalysisReport();
			case PipeliningPackage.IMPACT_ANALYSIS_DATA: return createImpactAnalysisData();
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
	public ActionsVariablePipeliningReport createActionsVariablePipeliningReport() {
		ActionsVariablePipeliningReportImpl actionsVariablePipeliningReport = new ActionsVariablePipeliningReportImpl();
		return actionsVariablePipeliningReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionVariablePipeliningData createActionVariablePipeliningData() {
		ActionVariablePipeliningDataImpl actionVariablePipeliningData = new ActionVariablePipeliningDataImpl();
		return actionVariablePipeliningData;
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
	@Override
	public PipeliningPackage getPipeliningPackage() {
		return (PipeliningPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PipeliningPackage getPackage() {
		return PipeliningPackage.eINSTANCE;
	}

} //PipeliningFactoryImpl

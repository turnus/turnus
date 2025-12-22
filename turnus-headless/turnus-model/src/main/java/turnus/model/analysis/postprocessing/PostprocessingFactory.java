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
package turnus.model.analysis.postprocessing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see turnus.model.analysis.postprocessing.PostprocessingPackage
 * @generated
 */
public interface PostprocessingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PostprocessingFactory eINSTANCE = turnus.model.analysis.postprocessing.impl.PostprocessingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Post Processing Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Post Processing Report</em>'.
	 * @generated
	 */
	PostProcessingReport createPostProcessingReport();

	/**
	 * Returns a new object of class '<em>Actor Statistics Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Statistics Report</em>'.
	 * @generated
	 */
	ActorStatisticsReport createActorStatisticsReport();

	/**
	 * Returns a new object of class '<em>Statistical Actor Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statistical Actor Partition</em>'.
	 * @generated
	 */
	StatisticalActorPartition createStatisticalActorPartition();

	/**
	 * Returns a new object of class '<em>Action Statistics Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Statistics Report</em>'.
	 * @generated
	 */
	ActionStatisticsReport createActionStatisticsReport();

	/**
	 * Returns a new object of class '<em>Scheduler Checks Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler Checks Report</em>'.
	 * @generated
	 */
	SchedulerChecksReport createSchedulerChecksReport();

	/**
	 * Returns a new object of class '<em>Scheduler Checks Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler Checks Partition</em>'.
	 * @generated
	 */
	SchedulerChecksPartition createSchedulerChecksPartition();

	/**
	 * Returns a new object of class '<em>Buffer Blocking Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Blocking Report</em>'.
	 * @generated
	 */
	BufferBlockingReport createBufferBlockingReport();

	/**
	 * Returns a new object of class '<em>Timeline Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timeline Report</em>'.
	 * @generated
	 */
	TimelineReport createTimelineReport();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PostprocessingPackage getPostprocessingPackage();

} //PostprocessingFactory

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
package turnus.adevs.simulation.Heter;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import adevs.Simulator;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.adevs.logging.DataCollector;
import turnus.adevs.model.AdevsModel;
import turnus.adevs.model.AdevsModelBuilder;
import turnus.adevs.model.AtomicActor;
import turnus.adevs.model.AtomicActor.Status;
import turnus.adevs.model.AtomicActorPartition;
import turnus.adevs.model.AtomicBuffer;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.MathUtils;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class SimEngineGPUMeasured extends SimEngineGPU {

	public SimEngineGPUMeasured() {
		
	}
}

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
package turnus.analysis.partitioning.util;

import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turnus.analysis.partitioning.BalancedPipelinePartitioning;
import turnus.analysis.partitioning.CommunicationCostPartitioning;
import turnus.analysis.partitioning.WorkloadBalancePartitioning;
import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.model.dataflow.Actor;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Malgorzata Michalska
 * 
 */
public class PartitioningGenerator {
	
	public enum PartitioningAlgorithm {
		KL, // KerninghanLin
		WB, // WorkloadBalance
		BP  // BalancedPipeline
	}
	
	TraceProject project;
	TraceWeighter weighter;
	int units;
	
	public static final int DEFAULT_UNITS = 2;
	
	public PartitioningGenerator(TraceProject project, TraceWeighter weighter) {
		this.project = project;
		this.weighter = weighter;
	}

	public NetworkPartitioning generateRandomSolution(Configuration configuration) {
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		
		NetworkPartitioning partitioning = new NetworkPartitioning(project.getNetwork());
		List<Actor> actors = new ArrayList<Actor>(project.getNetwork().getActors());
		List<String> components = new ArrayList<String>();
		int actorId, componentId;
		
		Random randomGenerator = new Random(System.currentTimeMillis());
		
		// initialize an array of components and assign one actor to each (to prevent having an empty component)
		for (int i = 1; i <= units; i++) {
			components.add("" + i);
			actorId = randomGenerator.nextInt(actors.size());
			partitioning.setPartition(actors.get(actorId), components.get(i - 1));
			actors.remove(actorId);
		}
		
		// choose random actor and random component and map
		while (actors.size() > 0) {
			actorId = randomGenerator.nextInt(actors.size());
			componentId = randomGenerator.nextInt(components.size());
			partitioning.setPartition(actors.get(actorId), components.get(componentId));
			actors.remove(actorId);
		}
		
		return partitioning;
	}
	
	public NetworkPartitioning generateSolution(Configuration configuration, String algorithm) {
		NetworkPartitioning partitioning = null;
		
		if (algorithm.equals("KL")) {
			CommunicationCostPartitioning ccp = new CommunicationCostPartitioning(project);
			ccp.setConfiguration(configuration);
			try {
				partitioning = ccp.run().asNetworkPartitioning();
			} catch (TurnusException e) {
				e.printStackTrace();
			}
		} else if (algorithm.equals("WB")) {
			WorkloadBalancePartitioning wbp = new WorkloadBalancePartitioning(project, weighter);
			wbp.setConfiguration(configuration);
			partitioning = wbp.run().asNetworkPartitioning();
		} else if (algorithm.equals("BP")) {
			BalancedPipelinePartitioning bpp = new BalancedPipelinePartitioning(project, weighter);
			bpp.setConfiguration(configuration);
			partitioning = bpp.run().asNetworkPartitioning();
		} else {
			Logger.warning("Partitioning algorithm \"%s\" not recognized. Random configuration is generated instead.", algorithm);
			partitioning = generateRandomSolution(configuration);
		}
		
		return partitioning;
	}
}

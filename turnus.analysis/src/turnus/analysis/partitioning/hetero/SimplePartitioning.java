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
 
package turnus.analysis.partitioning.hetero;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.trace.TraceProject;

import turnus.model.trace.weighter.TraceWeighter;
import turnus.model.trace.weighter.impl.CombinedTraceWeighter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.NetworkWeight;

/**  
 * 
 * @author Mahyar Emami
 *
 */
 
public class SimplePartitioning extends Analysis<ActorStatisticsReport> {

	public static String ACCEL_PARTITION = "accel";
	public static String CORE_PARTITION(Integer i) { return "core_" + i.toString(); } 
	public static String SOFTWARE_ONLY_PARTITION = "software_native";
	public static String FREE_PARTITION = "free";
	
	private final NetworkWeight hardwareWeight; // hardware weights
	private final Double hardwareClock;
    
	private final NetworkWeight softwareWeight; // software weights
    private final Double softwareClock;
    
    private TraceWeighter partitionedWeighter;
    private NetworkPartitioning bestPartitioning;
    
    
    private final Integer numCores;
    
    private final TraceProject project;
    
    private PartitionVector bestPartition;
    private PartitionVector currentPartition;
    
    private Map<String, Double> clocks;
    private Map<String, NetworkWeight> weightsMap;
    public SimplePartitioning(TraceProject tProject, NetworkWeight tHwWeight, Double hwClock, 
    		NetworkWeight tSwWeight, Double swClock, Integer numCores, NetworkPartitioning partitionConstraint) {
	    super(tProject);
	    
	    this.hardwareWeight = tHwWeight;
	    this.softwareWeight = tSwWeight;
	    this.hardwareClock = hwClock;
	    this.softwareClock = swClock;
	    this.numCores = numCores;
	    this.project = tProject;
	    this.currentPartition = new PartitionVector(partitionConstraint, numCores, project);
	    
	    this.weightsMap = new HashMap<>();
	    this.clocks = new HashMap<>();
	    for (Integer coreId = 0; coreId < numCores; coreId ++) {
	    	this.weightsMap.put(CORE_PARTITION(coreId), tSwWeight);
	    	this.clocks.put(CORE_PARTITION(coreId), swClock);
	    }
	    
	    this.weightsMap.put(ACCEL_PARTITION, tHwWeight);
	    this.clocks.put(ACCEL_PARTITION,  hwClock);
	    
	    this.bestPartitioning = null;
	
    }
    
    
    public TraceWeighter getAdjustedWeights(NetworkPartitioning partitioning) {
    	
    	return new CombinedTraceWeighter(this.weightsMap, this.clocks, partitioning);
    }

	@Override
	public ActorStatisticsReport run() throws TurnusException {
		
		
		
		Double bestExecution = Double.MAX_VALUE;
		
		
		long startTime = System.currentTimeMillis();
		
		
		PostProcessingReport report;
		do {
			
			Logger.info("Starting the simulation with partitions " + this.currentPartition.toString() + ".");
			
			NetworkPartitioning partitioning = this.currentPartition.asNetworkPartitioning(); 
			TraceWeighter weights = this.getAdjustedWeights(partitioning);
			
			SimEngine simulator = new SimEngine();
			
			simulator.setTraceProject(this.project);
			simulator.setTraceWeighter(weights);
			BufferSize bufferSize = new BufferSize(this.project.getNetwork());
			bufferSize.setDefaultSize(4096);
			simulator.setBufferSize(bufferSize);
			simulator.setNetworkPartitioning(partitioning);
			
			report = simulator.run();			
			Double executionTime = report.getTime();
			
			Logger.info("Simulation time " + executionTime.toString() + " ns");
			this.currentPartition = this.currentPartition.nextParittioning();
			
		} while (System.currentTimeMillis() - startTime < 100000);

		
		
		return report.getReport(ActorStatisticsReport.class);
		

	}
	
	
	
    private class PartitionVector {
    	
    	private class PartitionId {
    		
    		private final Integer numCores;
    		private Integer value;
    		private final boolean softwareOnly;
    		public PartitionId(Integer numCores, boolean softwareOnly) {
    			this.numCores = numCores;
    			this.softwareOnly = softwareOnly;
    			this.value = Integer.valueOf(0);
    		}
    		private PartitionId(Integer numCores, boolean softwareOnly, Integer value) {
    			this.value = value;
    			this.softwareOnly = softwareOnly;
    			this.numCores = numCores;
    		}
    		
    		public PartitionId nextPartitionId() {
    			if (this.isSaturated())
    				return new PartitionId(this.numCores, this.softwareOnly);
    			else  // wrap around
    				return new PartitionId(this.numCores, this.softwareOnly, this.value + 1);
    		}
    		
    		public boolean isSaturated() {
    			if (this.softwareOnly)
    				return this.value == numCores - 1;
    			else 
    				return this.value == numCores;
    		}
    		
    		public String getPartition() {
    			if (this.value < this.numCores)
    				return CORE_PARTITION(this.value);
    			else 
    				return ACCEL_PARTITION;
    		}
    		
    	}
    	

    	List<PartitionId> parts;
    	List<String> actors;
    	private final TraceProject project;

    	
    	public PartitionVector(NetworkPartitioning partitioningConstraint, Integer numCores, TraceProject tProject) {
    		
    		this.actors = new ArrayList<>();
    		this.parts = new ArrayList<>();
    		this.project = tProject;
    	
    		
    		Map<String, String> actorsConstraints= partitioningConstraint.asActorPartitionMap();
    		for (String actor : actorsConstraints.keySet()) {
    			
    			String part = actorsConstraints.get(actor);
    			boolean softwareOnly = part.equals(SOFTWARE_ONLY_PARTITION);
    			
    			this.parts.add(new PartitionId(numCores, softwareOnly));
    			this.actors.add(actor);
    		}
    		
    	}
    	
    	private PartitionVector(List<PartitionId> parts, List<String> actors, TraceProject project) {
    		
    		this.actors = actors;
    		this.parts = parts;
    		this.project = project;
    		
    	}
    	public NetworkPartitioning asNetworkPartitioning() {
    		
    		NetworkPartitioning partitioning = new NetworkPartitioning(this.project.getNetwork());
    		for (String actor : this.actors) { 
    			
    			Integer actorId = this.actors.indexOf(actor);
    			String partition = this.parts.get(actorId).getPartition();
    			partitioning.setPartition(actor, partition);
    		}
    		
    		return partitioning;
    		
    	}
    	
    	public PartitionVector nextParittioning() {
    		
    		List<PartitionId> newParts = new ArrayList<>();
    		
    		boolean hasCarry = true;
    		for (PartitionId p : this.parts) {
    			
    			if (hasCarry) {
    				PartitionId incr = p.nextPartitionId();
    				newParts.add(incr);
    				if (p.isSaturated())
    					hasCarry = true;
    				else 
    					hasCarry = false;
    				
    			} else {
    				newParts.add(p);
    			}
    			
    		}
    		
    		return new PartitionVector(newParts, this.actors, this.project);
    		
    	}
    }
    
    
	  
	 
}
  
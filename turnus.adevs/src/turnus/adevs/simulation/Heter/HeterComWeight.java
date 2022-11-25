package turnus.adevs.simulation.Heter;

import java.util.HashMap;
import java.util.Map;

import turnus.adevs.simulation.Heter.SimEngineGPUStaticCli.FifoType;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;

public class HeterComWeight {
	
	Network network;
	NetworkPartitioning partitioning;
	CommunicationWeight communicationCPU;
	CommunicationWeight communicationGPU;
	CommunicationWeight communicationCPUHostFifo; 
	CommunicationWeight communicationGPUHostFifo;
	
	Map<Actor, Map<Port, FifoType>> mapHostFifo;
	
	HeterComWeight(Network network,
				   NetworkPartitioning partitioning,
				   CommunicationWeight communicationCPU, 
				   CommunicationWeight communicationGPU, 
				   CommunicationWeight communicationCPUHostFifo, 
				   CommunicationWeight communicationGPUHostFifo) {
		this.partitioning = partitioning;
		this.network = network;
		this.communicationCPU = communicationCPU;
		this.communicationGPU = communicationGPU;
		this.communicationCPUHostFifo = communicationCPUHostFifo;
		this.communicationGPUHostFifo = communicationGPUHostFifo;
		generateMapping();
	}

	private void generateMapping() {
		mapHostFifo = new HashMap<Actor, Map<Port, FifoType> >();
		
		for (Actor actor : network.getActors()) {
			Map<Port, FifoType> entry = new HashMap<Port, FifoType>();
			for (Port port : actor.getOutputPorts() ) {
				FifoType sTpe = (partitioning.getPartition(actor.getName()).equals("PG"))? FifoType.GPU : FifoType.CPU;
				for (Actor oActor : port.getOutputs().stream().map((b) -> b.getTarget().getOwner()).toArray(Actor[]::new)) {
					FifoType oTpe = (partitioning.getPartition(oActor.getName()).equals("PG"))? FifoType.GPU : FifoType.CPU;
					if(sTpe != oTpe) {
						sTpe = FifoType.HOSTFIFO;
						break;
					}
				}
				entry.put(port, sTpe);
			}
			mapHostFifo.put(actor, entry);
		}
	}

	public double getWriteLatency(Actor actor, Port port) {
		if(port.getOutputs().isEmpty()) { return 0; } 
		switch(mapHostFifo.get(actor).get(port)) {
			case CPU:
				return communicationCPU.getWriteWeights(port.getOutputs().get(0)).get(0).getLatency();
			case GPU:
				return communicationGPU.getWriteWeights(port.getOutputs().get(0)).get(0).getLatency();
			case HOSTFIFO:
				if (partitioning.getPartition(actor.getName()).equals("PG")) {
					return communicationGPUHostFifo.getWriteWeights(port.getOutputs().get(0)).get(0).getLatency();
				} else {
					return communicationCPUHostFifo.getWriteWeights(port.getOutputs().get(0)).get(0).getLatency();
				}
		}
		return 0;
	}

	public double getReadLatency(Actor actor, Port port) {
		Port sPort = port.getInput().getSource();
		Actor sActor = sPort.getOwner();
		switch(mapHostFifo.get(sActor).get(sPort)) {
			case CPU:
				return communicationCPU.getReadWeights(port.getInput()).get(0).getLatency();
			case GPU:
				return communicationGPU.getReadWeights(port.getInput()).get(0).getLatency();
			case HOSTFIFO:
				if (partitioning.getPartition(actor.getName()).equals("PG")) {
					return communicationGPUHostFifo.getReadWeights(port.getInput()).get(0).getLatency();
				} else {
					return communicationCPUHostFifo.getReadWeights(port.getInput()).get(0).getLatency();
				}
		}
		return 0;
	}
}
package turnus.analysis.timeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import turnus.adevs.logging.ActorDataCollector;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.analysis.postprocessing.TimelineReport;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.util.ActorsSorter;
import turnus.model.mapping.NetworkPartitioning;

public class TimelineCollector implements ActorDataCollector {

	Network network;
	NetworkPartitioning partitioning;
	JsonArrayBuilder traceEvents;
	double endSimulation;
	List<Actor> actorsTopologicalSorted;

	Map<Actor, Boolean> scheduledActors;

	Map<Action, Double> actionStartTime;
	Map<Action, Double> actionEnableTime;
	Map<Buffer, Double> bufferStartProducingTime;

	List<Buffer> outgoingBuffers;

	public TimelineCollector(Network network, NetworkPartitioning partitioning) {
		this.network = network;
		this.partitioning = partitioning;
		this.endSimulation = 0.0;

		actorsTopologicalSorted = ActorsSorter.topologicalOrder(network.getActors());

		scheduledActors = new HashMap<>();

		for (Actor actor : network.getActors()) {
			scheduledActors.put(actor, true);
		}

		actionStartTime = new HashMap<>();
		actionEnableTime = new HashMap<>();

		bufferStartProducingTime = new HashMap<>();

		this.outgoingBuffers = new ArrayList<>();

		Map<String, List<String>> pMap = partitioning.asPartitionActorsMap();
		for (String partId : pMap.keySet()) {
			List<String> actorNames = pMap.get(partId);
			List<Actor> actorsInPartition = actorNames.stream().map(network::getActor).collect(Collectors.toList());
			outgoingBuffers.addAll(MemoryAndBuffers.getIncomingBuffersOfPartition(actorsInPartition));
		}

	}

	public JsonObject getJsonObject(String fileName) {
		JsonObjectBuilder trace = Json.createObjectBuilder();

		trace.add("schemaVersion", 1);
		trace.add("record_shapes", 1);

		// -- Actor process labels
		for (Actor actor : actorsTopologicalSorted) {
			traceEvents.add(Json.createObjectBuilder()//
					.add("name", "process_name")//
					.add("ph", "M")//
					.add("ts", endSimulation)//
					.add("pid", actorsTopologicalSorted.indexOf(actor))//
					.add("tid", actorsTopologicalSorted.indexOf(actor))//
					.add("args", Json.createObjectBuilder().add("name", actor.getName())));
			traceEvents.add(Json.createObjectBuilder()//
					.add("name", "thread_name")//
					.add("ph", "M")//
					.add("ts", endSimulation)//
					.add("pid", actorsTopologicalSorted.indexOf(actor))//
					.add("tid", actorsTopologicalSorted.indexOf(actor))//
					.add("args", Json.createObjectBuilder().add("name", "firing")));
		}

		// -- Sort index
		for (Actor actor : actorsTopologicalSorted) {
			traceEvents.add(Json.createObjectBuilder()//
					.add("name", "process_sort_index")//
					.add("ph", "M")//
					.add("ts", endSimulation)//
					.add("pid", actorsTopologicalSorted.indexOf(actor))//
					.add("tid", actorsTopologicalSorted.indexOf(actor))//
					.add("args",
							Json.createObjectBuilder().add("sort_index", actorsTopologicalSorted.indexOf(actor) + 1)));

		}

		trace.add("traceEvents", traceEvents);
		trace.add("traceName", fileName);

		return trace.build();
	}

	@Override
	public void init() {
		traceEvents = Json.createArrayBuilder();

	}

	@Override
	public void logEndSimulation(double time) {
		endSimulation = time;
	}

	@Override
	public PostProcessingData generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		TimelineReport report = f.createTimelineReport();
		report.setNetwork(network);

		return report;
	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		actionEnableTime.put(action, time);

	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
		/*
		 * Actor actor = action.getOwner(); int pid =
		 * actorsTopologicalSorted.indexOf(actor); long ss = stepId; String actionName =
		 * action.getName(); traceEvents.add(Json.createObjectBuilder()// .add("name",
		 * actionName)// .add("cat", "action")// .add("ph", "B")// .add("ts", time)//
		 * .add("pid", pid)// .add("tid", pid)// .add("args",
		 * Json.createObjectBuilder().add("stepId", ss)));
		 * 
		 * String partition = partitioning.getPartition(actor);
		 * traceEvents.add(Json.createObjectBuilder()// .add("name", actionName)//
		 * .add("ph", "B")// .add("ts", time)// .add("pid", "partitioning")//
		 * .add("tid", partition)// .add("args",
		 * Json.createObjectBuilder().add("stepId", ss)));
		 */
		actionStartTime.put(action, time);
	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {

	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {

	}

	@Override
	public void logEndFiring(Action action, long stepId, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logBlockedReading(Action action, long stepId, double time, Buffer emptyBuffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logBlockedWriting(Action action, long stepId, double time, Buffer fullBuffer, int tokens) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logConsumeTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
//		if (this.outgoingBuffers.contains(buffer)) {
//			String outgoingPartition = partitioning.getPartition(buffer.getSource().getOwner());
//			String incomingPartition = partitioning.getPartition(buffer.getTarget().getOwner());
//
//			double duration = time - actionEnableTime.get(action);
//
//			traceEvents.add(Json.createObjectBuilder()//
//					.add("name", buffer.getSource().getOwner().getName() + "." + buffer.getSource().getName() + " -> "
//							+ buffer.getTarget().getOwner().getName() + "." + buffer.getTarget().getName())//
//					.add("ph", "X")//
//					.add("ts", actionEnableTime.get(action))//
//					.add("dur", duration)//
//					.add("pid", "communication, " + outgoingPartition + " --> " + incomingPartition)//
//					.add("tid", network.getBuffers().indexOf(buffer)));//
//			// .add("args", Json.createObjectBuilder().add("stepId", ss)));
//		}

	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		if (this.outgoingBuffers.contains(buffer)) {
			bufferStartProducingTime.put(buffer, time);
		}

	}

	@Override
	public void logEndProcessingWithCore(Action action, long stepId, int core, double time) {
		Actor actor = action.getOwner();
		int pid = actorsTopologicalSorted.indexOf(actor);
		long ss = stepId;
		String actionName = action.getName();
		double duration = time - actionStartTime.get(action);

		traceEvents.add(Json.createObjectBuilder()//
				.add("name", actionName)//
				.add("cat", "action")//
				.add("ph", "X")//
				.add("ts", actionStartTime.get(action))//
				.add("dur", duration)//
				.add("pid", pid)//
				.add("tid", pid)//
				.add("args", Json.createObjectBuilder().add("stepId", ss)));

		String partition = partitioning.getPartition(actor);
		traceEvents.add(Json.createObjectBuilder()//
				.add("name", actor.getName())//
				.add("ph", "X")//
				.add("ts", actionStartTime.get(action))//
				.add("dur", duration)//
				.add("pid", "partitioning")//
				.add("tid", partition + ":" + core)//
				.add("args", Json.createObjectBuilder().add("stepId", ss)));

	}

	@Override
	public void logEndProduceTokens(Action action, long stepId, Buffer buffer, double time) {

		if (this.outgoingBuffers.contains(buffer)) {
			String outgoingPartition = partitioning.getPartition(buffer.getSource().getOwner());
			String incomingPartition = partitioning.getPartition(buffer.getTarget().getOwner());

			double duration = time - bufferStartProducingTime.get(buffer);

			traceEvents.add(Json.createObjectBuilder()//
					.add("name",
							buffer.getSource().getOwner().getName() + "." + buffer.getSource().getName() + " -> "
									+ buffer.getTarget().getOwner().getName() + "." + buffer.getTarget().getName())//
					.add("ph", "X")//
					.add("ts", bufferStartProducingTime.get(buffer))//
					.add("dur", duration)//
					.add("pid", "communication, " + outgoingPartition + " --> " + incomingPartition)//
					.add("tid", network.getBuffers().indexOf(buffer)));//
			// .add("args", Json.createObjectBuilder().add("stepId", ss)));
		}

	}

}

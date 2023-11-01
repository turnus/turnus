package turnus.analysis.timeline;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import turnus.adevs.logging.ActorDataCollector;
import turnus.adevs.logging.ActorPartitionDataCollector;
import turnus.model.analysis.postprocessing.PostProcessingData;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.analysis.postprocessing.TimelineReport;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.util.ActorsSorter;
import turnus.model.mapping.NetworkPartitioning;

public class TimelineCollector implements ActorDataCollector, ActorPartitionDataCollector {

	Network network;
	NetworkPartitioning partitioning;
	JsonArrayBuilder traceEvents;
	double endSimulation;
	List<Actor> actorsTopologicalSorted;

	public TimelineCollector(Network network, NetworkPartitioning partitioning) {
		this.network = network;
		this.partitioning = partitioning;
		this.endSimulation = 0.0;
		
		actorsTopologicalSorted = ActorsSorter.topologicalOrder(network.getActors());
	}

	public JsonObject getJsonObject(String fileName) {
		JsonObjectBuilder trace = Json.createObjectBuilder();

		trace.add("schemaVersion", 1);
		trace.add("record_shapes", 1);
		
		// -- Actor process labels
		for(Actor actor : actorsTopologicalSorted) {
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
		for(Actor actor : actorsTopologicalSorted) {
			traceEvents.add(Json.createObjectBuilder()//
					.add("name", "process_sort_index")//
					.add("ph", "M")//
					.add("ts", endSimulation)//
					.add("pid", actorsTopologicalSorted.indexOf(actor))//
					.add("tid", actorsTopologicalSorted.indexOf(actor))//
					.add("args", Json.createObjectBuilder().add("sort_index", actorsTopologicalSorted.indexOf(actor))));
			
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
	public void logActorTerminated(String partitionId, Actor actor, double time) {
		traceEvents.add(Json.createObjectBuilder()//
				.add("name", actor.getName())//
				.add("ph", "E")//
				.add("ts", time)//
				.add("pid", "Partitioning")//
				.add("tid", partitionId));

	}

	@Override
	public void logScheduleActor(String partitionId, Actor actor, double time) {
		

	}

	@Override
	public void logCheckActor(String partitionId, Actor actor, double time) {
		/*traceEvents.add(Json.createObjectBuilder()//
				.add("name", actor.getName())//
				.add("ph", "B")//
				.add("ts", time)//
				.add("pid", "Partitioning")//
				.add("tid", partitionId));*/

	}

	@Override
	public void logCheckedConditions(Actor actor, int conditionsChecked, boolean isInput, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logFailedConditions(Actor actor, int conditionsFailed, boolean isInput, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logIsSchedulable(Action action, long stepId, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logIsEnabled(Action action, long stepId, double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logStartProcessing(Action action, long stepId, double time) {
		Actor actor = action.getOwner();
		int pid = actorsTopologicalSorted.indexOf(actor);

		traceEvents.add(Json.createObjectBuilder()//
				.add("name", action.getName())//
				.add("cat", "action")//
				.add("ph", "B")//
				.add("ts", time)//
				.add("pid", pid)//
				.add("tid", pid)//
				.add("args", Json.createObjectBuilder().add("stepId", stepId)));

	}

	@Override
	public void logEndProcessing(Action action, long stepId, double time) {
		Actor actor = action.getOwner();
		int pid = actorsTopologicalSorted.indexOf(actor);
		traceEvents.add(Json.createObjectBuilder()//
				.add("name", action.getName())//
				.add("cat", "action")//
				.add("ph", "E")//
				.add("ts", time)//
				.add("pid", pid)//
				.add("tid", pid)//
				.add("args", Json.createObjectBuilder().add("stepId", stepId)));

	}

	@Override
	public void logStartProducing(Action action, long stepId, double time) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void logProduceTokens(Action action, long stepId, Buffer buffer, int tokens, double time) {
		// TODO Auto-generated method stub

	}

}

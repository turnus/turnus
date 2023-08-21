package turnus.analysis.scheduling.caseoptimal

import java.io.File
import java.util.ArrayList
import java.util.LinkedHashMap
import java.util.Map
import org.apache.poi.ss.formula.eval.NotImplementedException
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import turnus.analysis.Analysis
import turnus.analysis.scheduling.caseoptimal.ktail.KTailOptimizer
import turnus.analysis.scheduling.caseoptimal.ktail.RunLengthOptimizer
import turnus.common.TurnusException
import turnus.common.io.Logger
import turnus.common.util.EcoreUtils
import turnus.model.analysis.scheduling.ActorSelectionSchedule
import turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport
import turnus.model.analysis.scheduling.caseoptimal.Optimizer
import turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalFactoryImpl
import turnus.model.analysis.scheduling.impl.SequenceImpl
import turnus.model.dataflow.Network
import turnus.model.mapping.io.XmlNetworkPartitioningReader
import turnus.model.trace.Trace
import turnus.model.trace.TraceDecorator
import turnus.model.trace.TraceProject
import turnus.model.trace.impl.inmemory.InMemoryTraceLoader

import static turnus.common.TurnusOptions.ASSCHED_PATH
import static turnus.common.TurnusOptions.MAPPING_FILE
import static turnus.common.TurnusOptions.SCHEDULE_OPTIMISATION_PIPELINE_STRING
import static turnus.common.TurnusOptions.TRACE_FILE

class CaseOptimalActorSelectionAnalysis extends Analysis<CaseOptimalScheduleReport> {
	Trace trace
	Network network
	TraceDecorator decorator
	String tracefile
	Boolean continuation = false;

	new(TraceProject project) {
		super(project)
	}

	def getInitialSchedFromTrace(Trace trace, File mappingFile) {
		val partitioning = if (mappingFile !== null) {
				val part_reader = new XmlNetworkPartitioningReader;
				part_reader.load(mappingFile)
			};
		val scheds = new LinkedHashMap<String, ActorSelectionSchedule>;
		if (partitioning === null) {
			scheds.put("main", new SequenceImpl(trace));
			return scheds;
		} else {
			val partition_ids = new LinkedHashMap;
			var i = 0;
			for (p : partitioning.partitions) {
				partition_ids.put(p, i);
				i += 1;
			}
			for (e : SequenceImpl.fromTraceWithPartition(trace, partitioning, partition_ids).entrySet) {
				scheds.put(e.key, e.value);
			}
			return scheds;
		}

	}

	def getInitialSchedFromOldSched(Map<String, ActorSelectionSchedule> oldScheds, File mappingFile) {
		val partitioning = if (mappingFile !== null) {
				val part_reader = new XmlNetworkPartitioningReader;
				part_reader.load(mappingFile)
			};
		val scheds = new LinkedHashMap<String, ActorSelectionSchedule>;

		if (partitioning === null) {
			if (oldScheds.keySet.size == 1 && oldScheds.keySet.last.equals("main")) {
				scheds.put("main", oldScheds.get("main"));
				return scheds;
			}
		} else {
			for (k : oldScheds.keySet) {
				if (partitioning.partitions.contains(k)) {
					scheds.put(k, oldScheds.get(k));
				}
			}

			if (oldScheds.keySet.size == scheds.keySet.size) {
				return scheds;
			}
		}
	// TODO throw proper exception on error, catch it...
	}

	def optimize_partition(ActorSelectionSchedule oldSched, ArrayList<Optimizer> pipeline) {
		var newSched = oldSched;
		// TODO: possible implementations: add a   flag for "partitioned schedule" to the scheduler, simply check if was able to run at every step
		// More advanced:annotate the trace with "partition crossing data dependency" information, check which actors actually need that,
		// even more advanced: auomatically add sync blocks? but add the check to those only the actors that have cross partition data dependency
		// add "schedulability" mapping to the partition algorithm...keep data dependencies within a partition to make scheduling easier
		// check and compare "schedulewithout checks
		for (Optimizer o : pipeline) {

			switch (o) {
				case RLE: /* FIXME unsupported fall-through */ {
					newSched = new RunLengthOptimizer().optimize(newSched)
				}
				case KTAIL: /* FIXME unsupported fall-through */ {
					newSched = new KTailOptimizer(2).optimize(newSched)
				}
				default: {
					throw new NotImplementedException('''The optimizer «o.toString()» has not been implemented yet''');
				}
			}
		}

		return newSched;
	}

	override CaseOptimalScheduleReport run() throws TurnusException {
		Logger.info("Case Optimal Schedule generation [STARTED]")
		val CaseOptimalScheduleReport case_opt = new CaseoptimalFactoryImpl().createCaseOptimalScheduleReport()
		val mapFile = configuration.getValue(MAPPING_FILE);
		val LinkedHashMap<String, ActorSelectionSchedule> scheds = if (project !== null) {
				if (!project.isTraceLoaded()) {
					project.loadTrace(new InMemoryTraceLoader(), configuration)
				}
				network = project.getNetwork()
				trace = project.getTrace()
				decorator = project.getTraceDecorator()
				continuation = false;
				case_opt.setTraceFile(configuration.getValue(TRACE_FILE).getAbsolutePath());
				getInitialSchedFromTrace(trace, mapFile)
			} else {
				val String ascched_parth = configuration.getValue(ASSCHED_PATH)
				continuation = true;
				val CaseOptimalScheduleReport oldReport = EcoreUtils.loadEObject(new ResourceSetImpl(),
					new File(ascched_parth))
				case_opt.setTraceFile(oldReport.getTraceFile())
				case_opt.getPipeline().addAll(oldReport.getPipeline())
				getInitialSchedFromOldSched(oldReport.getPartitionSchedules(), mapFile)
			}

		val String pipelineString = configuration.getValue(SCHEDULE_OPTIMISATION_PIPELINE_STRING)
		var ArrayList<Optimizer> pipeline = new ArrayList<Optimizer>()
		for (String p : pipelineString.split(",")) {

			switch (p.trim()) {
				case "RLE": /* FIXME unsupported fall-through */ {
					pipeline.add(Optimizer.RLE)
				}
				case "KTAIL": /* FIXME unsupported fall-through */ {
					pipeline.add(Optimizer.KTAIL)
				}
				default: {
					throw new NotImplementedException('''No optimizers implemented for: «p»''');
				}
			}
		}
		for (k : scheds.keySet) {
			case_opt.getPartitionSchedules().put(k, optimize_partition(scheds.get(k), pipeline))
		}
		case_opt.getPipeline().addAll(pipeline)
		return case_opt

	}

}

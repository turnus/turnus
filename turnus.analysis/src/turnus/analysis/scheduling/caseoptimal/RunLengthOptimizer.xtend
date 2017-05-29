package turnus.analysis.scheduling.caseoptimal

import java.rmi.UnexpectedException
import turnus.model.analysis.scheduling.ActorSelectionSchedule
import turnus.model.analysis.scheduling.Sequence
import turnus.model.analysis.scheduling.impl.SequenceImpl
import turnus.common.io.Logger;
import turnus.model.analysis.scheduling.caseoptimal.impl.CaseoptimalFactoryImpl
import turnus.model.analysis.scheduling.impl.SchedulingFactoryImpl
import org.eclipse.emf.ecore.util.EcoreUtil

class RunLengthOptimizer implements Optimizer {
	final boolean preemptiveActors;
	new(boolean preemptiveActors){
		this.preemptiveActors=preemptiveActors;
	}
	new(){
		this.preemptiveActors=false;
	}

	override def ActorSelectionSchedule optimize(ActorSelectionSchedule input) {
		val a_it = switch input {
			case input instanceof Sequence: (input as Sequence).getActions().iterator()
			default: return input // RLE only makes sense in sequences
		}

		var out = new SchedulingFactoryImpl().createSequence();
		if (a_it.hasNext()) {
			var oldsched = a_it.next();
			var times = oldsched.getTimes();
			var same=false;
			while (a_it.hasNext()) {
				
				val newsched = a_it.next();
				same=oldsched.equals(newsched);
				if (same) {
					times += 1;
					Logger.debug("Same Schedule");
				} else {
					var insert_sched = EcoreUtil.copy(oldsched);
					if(preemptiveActors){
					insert_sched.setTimes(times);
					}else{
						insert_sched.setTimes(1);//if we have nonpreemptive actors, the run needs to scheduled only once in order to be completed
					}
					out.getActions().add(insert_sched);
					oldsched = newsched;
					times = newsched.getTimes();
					
					Logger.debug("Different Schedule");
				}

			}
			if (same) { // the last action was not an insert
				var insert_sched = EcoreUtil.copy(oldsched);
				insert_sched.setTimes(times);
				out.getActions().add(insert_sched);
			}

			return out;
		} else {
			throw new UnexpectedException("Expected there to be at least one element in input");
		}
	}

}

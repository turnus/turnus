package turnus.analysis.scheduling.caseoptimal

import java.rmi.UnexpectedException
import turnus.model.analysis.scheduling.ActorSelectionSchedule

/** 
 * @author Igor Krawczuk
 * The basic interface if the Optimizers in a pipeline.
 */
interface Optimizer {
	def ActorSelectionSchedule optimize(ActorSelectionSchedule input) throws UnexpectedException

}

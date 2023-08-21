package turnus.model.analysis.scheduling.impl

import java.io.File
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import turnus.common.TurnusException
import turnus.common.configuration.Configuration
import turnus.common.util.EcoreUtils
import turnus.model.analysis.scheduling.ActorSelectionScheduleReportLoader
import turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport

class ActorSelectionScheduleLoaderImpl implements ActorSelectionScheduleReportLoader {
	
	override load(File schedFile) throws TurnusException{
		 var schedrep= EcoreUtils.loadEObject(new ResourceSetImpl(),schedFile) as CaseOptimalScheduleReport;
		  return schedrep;
			}
			
			override load(File schedFile, Configuration configuration) throws TurnusException {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
			}
			
			override load() {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
			}
			

	
}
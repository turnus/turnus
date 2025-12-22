package turnus.model.analysis.scheduling;

import java.io.File;

import turnus.common.TurnusException;
import turnus.common.configuration.Configuration;
import turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport;

public interface ActorSelectionScheduleReportLoader {

	CaseOptimalScheduleReport load(File schedFile, Configuration configuration) throws TurnusException;
	CaseOptimalScheduleReport load(File schedFile) throws TurnusException;
	CaseOptimalScheduleReport load() throws TurnusException;
}

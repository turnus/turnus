package turnus.analysis.scheduling;

import static turnus.common.TurnusOptions.MARKOV_SCHEDULER_REPORTS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;
import turnus.model.trace.TraceProject;

public class MarkovSimpleSchedulerMerger extends Analysis<MarkovSimpleSchedulerReport>{
	
	 
	

	public MarkovSimpleSchedulerMerger(TraceProject project) {
		super(project);
	}

	@Override
	public MarkovSimpleSchedulerReport run() throws TurnusException {
		List<MarkovSimpleSchedulerReport> reports = new ArrayList<>();
		List<String> files = configuration.getValue(MARKOV_SCHEDULER_REPORTS);
		for(String path : files){
			File file = new File(path);
			MarkovSimpleSchedulerReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), file);
			if(report==null){
				throw new TurnusException("Report from \""+file + "\" can not be loaded");
			}
			reports.add(report);
		}
		
		
		
		
		return null;
	}

}

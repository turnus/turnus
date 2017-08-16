package turnus.analysis.scheduling;

import static turnus.common.TurnusOptions.MARKOV_SCHEDULER_REPORTS;
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.ModelsRegister;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;
import turnus.model.trace.TraceProject;

public class MarkovSimpleSchedulerMergerCli implements IApplication{
	
	private Configuration configuration;

	private IProgressMonitor monitor = new NullProgressMonitor();

	private MarkovSimpleSchedulerMerger analysis;
	
	public static void main(String[] args) {
		ModelsRegister.init();

		MarkovSimpleSchedulerMergerCli cliApp = null;

		try {
			cliApp = new MarkovSimpleSchedulerMergerCli();
			cliApp.parse(args);
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
	}
	
	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser()//
				.setOption(TRACE_FILE, true)//
				.setOption(MARKOV_SCHEDULER_REPORTS, true);
		configuration = cliParser.parse(args);
	}
 

	public void start(Configuration configuration, IProgressMonitor monitor) throws TurnusException {
		this.configuration = configuration;
		this.monitor = monitor;
		run();
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		try {
			parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS));
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help");
			return IApplication.EXIT_RELAUNCH;
		}

		try {
			run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
			return IApplication.EXIT_RELAUNCH;
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		if (analysis != null) {
			analysis.cancel();
		}
	}
	
	private void run() throws TurnusException {
		monitor.beginTask("Scheduled Impact Analysis", IProgressMonitor.UNKNOWN);

		TraceProject project = null;
		MarkovSimpleSchedulerReport report = null;

		{ // STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration");
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
			} catch (Exception e) {
				throw new TurnusException("Trace file is not valid", e);
			}
		}

		{ // STEP 2 : Run the analysis
			monitor.subTask("Running the analysis");
			try {
				analysis = new MarkovSimpleSchedulerMerger(project);
				analysis.setConfiguration(configuration);
				report = analysis.run();
				Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e);
			}
		}

		{ // STEP 3 : Store the results
			monitor.subTask("Storing the results");
			try {
				
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("scheduling", configuration);
				}

				File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.MARKOV_SCHEDULER);
				EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile);
				Logger.info("Simple Markov scheduling analysis report stored in \"%s\"", reportFile);

			} catch (Exception e) {
				Logger.error("The report file cannot be stored");
				String message = e.getLocalizedMessage();
				if (message != null) {
					Logger.error(" cause: %s", message);
				}
			}
			
		}

		monitor.done();
	}

}

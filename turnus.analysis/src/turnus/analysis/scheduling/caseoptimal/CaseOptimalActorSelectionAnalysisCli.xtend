package turnus.analysis.scheduling.caseoptimal

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.equinox.app.IApplication
import org.eclipse.equinox.app.IApplicationContext
import turnus.common.TurnusException
import turnus.common.TurnusExtensions
import turnus.common.configuration.Configuration
import turnus.common.configuration.Configuration.CliParser
import turnus.common.io.Logger
import turnus.common.util.EcoreUtils
import turnus.model.ModelsRegister
import turnus.model.analysis.scheduling.caseoptimal.CaseOptimalScheduleReport
import turnus.model.trace.TraceProject

import static turnus.common.TurnusOptions.ASSCHED_PATH
import static turnus.common.TurnusOptions.MAPPING_FILE
import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY
import static turnus.common.TurnusOptions.SCHEDULE_OPTIMISATION_PIPELINE_STRING
import static turnus.common.TurnusOptions.TRACE_FILE
import static turnus.common.util.FileUtils.createDirectory
import static turnus.common.util.FileUtils.createFileWithTimeStamp
import static turnus.common.util.FileUtils.createOutputDirectory

class CaseOptimalActorSelectionAnalysisCli implements IApplication {
	Configuration configuration
	IProgressMonitor monitor = new NullProgressMonitor()
	CaseOptimalActorSelectionAnalysis analysis

	def static void main(String[] args) {
		ModelsRegister.init()
		var CaseOptimalActorSelectionAnalysisCli cliApp = null
		try {
			cliApp = new CaseOptimalActorSelectionAnalysisCli()
			cliApp.parse(args)
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help")
			return;
		}

		try {
			cliApp.run()
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage())
		}

	}

	def private void parse(String[] args) throws TurnusException {
		var CliParser cliParser = new CliParser()
		.setOption(TRACE_FILE, true)
		.setOption(SCHEDULE_OPTIMISATION_PIPELINE_STRING, true)
		.setOption(ASSCHED_PATH, false)
		.setOption(OUTPUT_DIRECTORY, false)
		.setOption(MAPPING_FILE,false)
		configuration = cliParser.parse(args)
	}

	def private void run() throws Exception {
		monitor.beginTask("Case optimal schedule generation", IProgressMonitor.UNKNOWN)
		var TraceProject project = null
		var CaseOptimalScheduleReport report = null
		{
			// STEP 1 : parse the configuration
			monitor.subTask("Parsing the configuration")
			try {
				var File traceFile = configuration.getValue(TRACE_FILE)
				if (traceFile.getName().endsWith("assched")) {
					configuration.setValue(ASSCHED_PATH, traceFile.getAbsolutePath())
					project = null
				} else {
					project = TraceProject.open(traceFile)
				}
			} catch (Exception e) {
				throw new TurnusException("Trace file is not valid", e)
			}

		}
		{
			// STEP 2 : Run the analysis
			monitor.subTask("Running the analysis")
			try {
				analysis = new CaseOptimalActorSelectionAnalysis(project)
				analysis.setConfiguration(configuration)
				report = analysis.run() // FIXME add toString method
				// Logger.infoRaw(report.toString());
			} catch (Exception e) {
				throw new TurnusException("The analysis cannot be completed", e)
			}

		}
		{
			// STEP 3 : Store the results
			monitor.subTask("Storing the results")
			try {
				var File outputPath = null
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY)
					createDirectory(outputPath)
				} else if (configuration.hasValue(ASSCHED_PATH)) {
					var Path asched_path = Paths.get(configuration.getValue(ASSCHED_PATH))
					outputPath = asched_path.getParent().toAbsolutePath().toFile()
				} else {
					outputPath = createOutputDirectory("scheduling", configuration)
				}
				var File reportFile = createFileWithTimeStamp(outputPath, TurnusExtensions.ACTOR_SELECTION_SCHEDULE)
				if (project !== null) {
					EcoreUtils.storeEObject(report, project.getResourceSet(), reportFile)
				} else {
					EcoreUtils.storeEObject(report, new ResourceSetImpl(), reportFile)
				}
				Logger.info("Case optimal schedule stored in \"%s\"", reportFile)
			} catch (Exception e) {
				Logger.error("The schedule file cannot be stored")
				var String message = e.getLocalizedMessage()
				if (message !== null) {
					Logger.error(" cause: %s", message)
				}
			}

		}
		monitor.done()
	}

	def void start(Configuration configuration, IProgressMonitor monitor) throws Exception {
		this.configuration = configuration
		this.monitor = monitor
		run()
	}

	override Object start(IApplicationContext context) throws Exception {
		try {
			parse((context.getArguments().get(IApplicationContext.APPLICATION_ARGS) as String[]))
		} catch (TurnusException e) {
			Logger.error("Command line argument parsing error: see the help")
			return IApplication.EXIT_RELAUNCH
		}

		try {
			run()
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage())
			return IApplication.EXIT_RELAUNCH
		}

		return IApplication.EXIT_OK
	}

	override void stop() {
		if (analysis !== null) {
			analysis.cancel()
		}
	}
}

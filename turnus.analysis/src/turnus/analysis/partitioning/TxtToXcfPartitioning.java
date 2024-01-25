package turnus.analysis.partitioning;

import static turnus.common.TurnusOptions.OUTPUT_DIRECTORY;
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;
import static turnus.common.TurnusOptions.TRACE_FILE;
import static turnus.common.TurnusOptions.TXT_PARTITION;
import static turnus.common.util.FileUtils.changeExtension;
import static turnus.common.util.FileUtils.createDirectory;
import static turnus.common.util.FileUtils.createFileWithTimeStamp;
import static turnus.common.util.FileUtils.createOutputDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.Scanner;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import turnus.analysis.dot.PartitionedNetworkToDot;
import turnus.common.TurnusException;
import turnus.common.TurnusExtensions;
import turnus.common.configuration.Configuration;
import turnus.common.configuration.Configuration.CliParser;
import turnus.common.io.Logger;
import turnus.model.ModelsRegister;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;
import turnus.model.trace.TraceProject;
import turnus.model.trace.impl.splitted.SplittedTraceLoader;

public class TxtToXcfPartitioning implements IApplication {
	private static final String DEFAULT_SCHEDULING_POLICY = "ROUND_ROBIN";

	private Configuration configuration;
	private IProgressMonitor monitor = new NullProgressMonitor();

	public static void main(String[] args) {
		ModelsRegister.init();

		TxtToXcfPartitioning cliApp = null;

		try {
			cliApp = new TxtToXcfPartitioning();
			cliApp.parse(args);
		} catch (TurnusException e) {
			return;
		}

		try {
			cliApp.run();
		} catch (Exception e) {
			Logger.error("Application error: %s", e.getMessage());
		}
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

	}

	private NetworkPartitioning readPartitionFile(TraceProject project, File file) {
		NetworkPartitioning partitioning = new NetworkPartitioning(project.getNetwork());

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// Ignore lines starting with %
				if (!line.trim().startsWith("%")) {
					// Split the line into id and number using space as a delimiter
					String[] parts = line.split("\\s+");

					// Ensure there are at least two parts (id and number)
					if (parts.length >= 2) {
						String actor = parts[0];
						String partition = parts[1];

						partitioning.setPartition(actor, partition);
					} else {
						System.out.println("Invalid line format: " + line);
					}
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.getAbsolutePath());
		}

		return partitioning;
	}

	private void run() throws TurnusException {
		monitor.beginTask("Metis partitioning analysis", IProgressMonitor.UNKNOWN);
		TraceProject project = null;
		String scheduling = null;
		NetworkPartitioning partitioning = null;
		// -- STEP 1 : parse the configuration
		{
			monitor.subTask("Parsing the configuration");
			try {
				File traceFile = configuration.getValue(TRACE_FILE);
				project = TraceProject.open(traceFile);
				project.loadTrace(new SplittedTraceLoader(), configuration);
			} catch (Exception e) {
				throw new TurnusException("The trace project cannot be loaded", e);
			}
			try {
				File txtPartition = configuration.getValue(TXT_PARTITION);
				partitioning = readPartitionFile(project, txtPartition);
			} catch (Exception e) {
				throw new TurnusException("The text partition file cannot be loaded", e);
			}
			if (configuration.hasValue(SCHEDULING_POLICY)) {
				scheduling = configuration.getValue(SCHEDULING_POLICY);
			} else {
				scheduling = DEFAULT_SCHEDULING_POLICY;
			}
		}

		// -- STEP 2 : Store the results
		{
			monitor.subTask("Storing the results");
			try {
				File outputPath = null;
				if (configuration.hasValue(OUTPUT_DIRECTORY)) {
					outputPath = configuration.getValue(OUTPUT_DIRECTORY);
					createDirectory(outputPath);
				} else {
					outputPath = createOutputDirectory("partitioning", configuration);
				}

				// -- Set the scheduling policy
				partitioning.setSchedulerToAll(scheduling);

				File xcfFile = createFileWithTimeStamp(outputPath, TurnusExtensions.NETWORK_PARTITIONING);
				File dotFile = changeExtension(xcfFile, TurnusExtensions.DOT);
				new XmlNetworkPartitioningWriter().write(partitioning, xcfFile);
				new PartitionedNetworkToDot(project.getNetwork(), partitioning)
						.emit(FileSystems.getDefault().getPath(dotFile.getAbsolutePath()));
				Logger.info("Network partitioning configuration stored in \"%s\"", xcfFile);
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

	private void parse(String[] args) throws TurnusException {
		CliParser cliParser = new CliParser().setOption(TRACE_FILE, true).setOption(TXT_PARTITION, true)
				.setOption(SCHEDULING_POLICY, false).setOption(OUTPUT_DIRECTORY, false);

		configuration = cliParser.parse(args);
	}

}

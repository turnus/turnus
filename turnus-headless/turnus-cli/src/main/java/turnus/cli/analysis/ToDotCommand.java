package turnus.cli.analysis;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.Callable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.analysis.dot.BottleneckNetworkToDot;
import turnus.analysis.dot.NetworkToDot;
import turnus.analysis.dot.PartitionedNetworkToDot;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.trace.TraceProject;

@Command(
		name = "to-dot",
		description = "Export DOT graphs (Graphviz)",
		mixinStandardHelpOptions = true,
		subcommands = { ToDotCommand.NetworkCmd.class, ToDotCommand.PartitionedCmd.class,
				ToDotCommand.BottlenecksCmd.class })
public class ToDotCommand implements Runnable {
	@Override
	public void run() {
		CommandLine.usage(this, System.out);
	}

	@Command(name = "network", description = "Export a network to DOT", mixinStandardHelpOptions = true)
	static class NetworkCmd implements Callable<Integer> {
		@Parameters(index = "0", description = "Input trace project (.tracez) or network model file")
		private File inputFile;

		@Option(names = { "-o", "--output" }, description = "Output DOT file", required = true)
		private File outputFile;

		@Override
		public Integer call() {
			try {
				Network network = loadNetwork(inputFile);
				Path outPath = outputFile.toPath();
				new NetworkToDot(network).emit(outPath);
				Logger.info("DOT saved to %s", outputFile.getAbsolutePath());
				return 0;
			} catch (Exception e) {
				Logger.error("DOT export failed: %s", e.getMessage());
				return 1;
			}
		}
	}

	@Command(name = "partitioned", description = "Export a partition-colored network to DOT", mixinStandardHelpOptions = true)
	static class PartitionedCmd implements Callable<Integer> {
		@Parameters(index = "0", description = "Input trace project (.tracez)")
		private File traceFile;

		@Option(names = { "-p", "--partitioning" }, description = "Partitioning mapping file (.xml)", required = true)
		private File partitioningFile;

		@Option(names = { "-o", "--output" }, description = "Output DOT file", required = true)
		private File outputFile;

		@Override
		public Integer call() {
			try {
				TraceProject project = TraceProject.open(traceFile);
				Network network = project.getNetwork();
				NetworkPartitioning partitioning = new XmlNetworkPartitioningReader().load(partitioningFile);

				new PartitionedNetworkToDot(network, partitioning).emit(outputFile.toPath());
				Logger.info("DOT saved to %s", outputFile.getAbsolutePath());
				return 0;
			} catch (Exception e) {
				Logger.error("DOT export failed: %s", e.getMessage());
				return 1;
			}
		}
	}

	@Command(name = "bottlenecks", description = "Export a bottleneck heatmap network to DOT", mixinStandardHelpOptions = true)
	static class BottlenecksCmd implements Callable<Integer> {
		@Parameters(index = "0", description = "Input bottlenecks report file (.bottlenecks or .sbottlenecks)")
		private File reportFile;

		@Option(names = { "-p", "--partitioning" }, description = "Partitioning mapping file (.xml), required for scheduled bottlenecks")
		private File partitioningFile;

		@Option(names = { "-o", "--output" }, description = "Output DOT file", required = true)
		private File outputFile;

		@Override
		public Integer call() {
			try {
				EObject obj = EcoreUtils.loadEObject(new ResourceSetImpl(), reportFile);
				if (obj == null) {
					throw new TurnusException("The input file \"" + reportFile + "\" is not a valid report");
				}

				if (obj instanceof BottlenecksWithSchedulingReport) {
					if (partitioningFile == null) {
						throw new TurnusException(
								"A partitioning file is required when exporting scheduled bottlenecks (.sbottlenecks)");
					}
					BottlenecksWithSchedulingReport report = (BottlenecksWithSchedulingReport) obj;
					NetworkPartitioning partitioning = new XmlNetworkPartitioningReader().load(partitioningFile);
					new BottleneckNetworkToDot(report.getNetwork(), report, partitioning).emit(outputFile.toPath());
				} else if (obj instanceof BottlenecksReport) {
					BottlenecksReport report = (BottlenecksReport) obj;
					new BottleneckNetworkToDot(report.getNetwork(), report).emit(outputFile.toPath());
				} else {
					throw new TurnusException("Unsupported report type: " + obj.getClass().getName());
				}

				Logger.info("DOT saved to %s", outputFile.getAbsolutePath());
				return 0;
			} catch (Exception e) {
				Logger.error("DOT export failed: %s", e.getMessage());
				return 1;
			}
		}
	}

	private static Network loadNetwork(File inputFile) throws TurnusException {
		if (inputFile == null || !inputFile.exists()) {
			throw new TurnusException("Input file not found: " + inputFile);
		}

		String name = inputFile.getName().toLowerCase();
		if (name.endsWith(".trace") || name.endsWith(".tracez")) {
			try {
				TraceProject project = TraceProject.open(inputFile);
				return project.getNetwork();
			} catch (Exception e) {
				throw new TurnusException("Failed to open trace project: " + inputFile, e);
			}
		}

		EObject obj = EcoreUtils.loadEObject(new ResourceSetImpl(), inputFile);
		if (obj instanceof Network) {
			return (Network) obj;
		}
		throw new TurnusException("Unsupported network input file: " + inputFile);
	}
}

package turnus.cli.analysis;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiler.io.Dprof2HtmlExporter;
import turnus.model.analysis.profiler.io.Dprof2MdExporter;

@Command(
		name = "dprof",
		description = "Export a dynamic profiling report (.dprof) to Markdown/HTML",
		mixinStandardHelpOptions = true)
public class DprofCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The dynamic profiling report file (.dprof)")
	private File inputFile;

	@Option(names = { "-o", "--output" }, description = "Output directory")
	private File outputDir;

	@Override
	public Integer call() {
		try {
			if (inputFile == null || !inputFile.exists()) {
				Logger.error("Input file not found: %s", inputFile);
				return 1;
			}

			File outDir = outputDir != null ? outputDir : new File(".");
			FileUtils.createDirectory(outDir);

			File mdFile = new File(outDir, inputFile.getName() + ".md");
			File htmlFile = new File(outDir, inputFile.getName() + ".html");

			new Dprof2MdExporter().export(inputFile, mdFile);
			new Dprof2HtmlExporter().export(inputFile, htmlFile);

			Logger.info("Markdown saved to %s", mdFile.getAbsolutePath());
			Logger.info("HTML saved to %s", htmlFile.getAbsolutePath());
			return 0;
		} catch (TurnusException e) {
			Logger.error("DPROF export failed: %s", e.getMessage());
			return 1;
		}
	}
}

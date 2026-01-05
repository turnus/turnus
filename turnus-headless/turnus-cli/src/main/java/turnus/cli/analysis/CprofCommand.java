package turnus.cli.analysis;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiler.io.Cprof2HtmlExporter;
import turnus.model.analysis.profiler.io.Cprof2MdExporter;

@Command(
		name = "cprof",
		description = "Export a code profiling report (.cprof) to Markdown/HTML",
		mixinStandardHelpOptions = true)
public class CprofCommand implements Callable<Integer> {

	@Parameters(index = "0", description = "The code profiling report file (.cprof)")
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

			new Cprof2MdExporter().export(inputFile, mdFile);
			new Cprof2HtmlExporter().export(inputFile, htmlFile);

			Logger.info("Markdown saved to %s", mdFile.getAbsolutePath());
			Logger.info("HTML saved to %s", htmlFile.getAbsolutePath());
			return 0;
		} catch (TurnusException e) {
			Logger.error("CPROF export failed: %s", e.getMessage());
			return 1;
		}
	}
}

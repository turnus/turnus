package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.profiling.LatencyReport;
import turnus.model.utils.HtmlUtils;

/**
 * Latency profiling HTML exporter
 */
public class Lprof2HtmlExporter extends Lprof2MdExporter {
	@Override
	public void export(LatencyReport data, File output) throws TurnusException {
		try {
			String mdContent = content(data).toString();

			String html = HtmlUtils.markdown2Html(mdContent);
			html = HtmlUtils.appendStyleMedia(html, "(prefers-color-scheme: dark)", "darkmode.css");
			html = HtmlUtils.appendStyle(html, "basic.css");
			html = HtmlUtils.appendJs(html, "basic.js");

			FileWriter writer = new FileWriter(output);
			writer.write(html);
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}
}

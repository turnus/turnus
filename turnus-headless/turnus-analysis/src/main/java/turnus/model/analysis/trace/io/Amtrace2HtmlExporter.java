package turnus.model.analysis.trace.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.trace.MarkowModelTraceReport;
import turnus.model.utils.HtmlUtils;

/**
 * Actions Markov model trace HTML exporter
 */
public class Amtrace2HtmlExporter extends Amtrace2MdExporter {
	@Override
	public void export(MarkowModelTraceReport data, File output) throws TurnusException {
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

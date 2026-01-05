package turnus.model.analysis.profiler.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.utils.HtmlUtils;

public class Dprof2HtmlExporter extends Dprof2MdExporter {
	@Override
	public void export(DynamicProfilingReport data, File output) throws TurnusException {
		try {
			StringBuffer b = content(data);
			String mdContent = b.toString();

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

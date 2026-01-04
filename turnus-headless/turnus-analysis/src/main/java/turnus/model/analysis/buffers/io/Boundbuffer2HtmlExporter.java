package turnus.model.analysis.buffers.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.utils.HtmlUtils;

/**
 * Bounded buffer analysis HTML exporter
 *
 * @author Endri Bezati
 */
public class Boundbuffer2HtmlExporter extends Boundbuffer2MdExporter {

	@Override
	public void export(BoundedBuffersReport data, File output) throws TurnusException {
		try {
			StringBuffer b = content(data);
			String mdContent = b.toString();

			String mdToHtml = HtmlUtils.markdown2Html(mdContent);
			mdToHtml = HtmlUtils.appendStyleMedia(mdToHtml, "(prefers-color-scheme: dark)", "darkmode.css");
			mdToHtml = HtmlUtils.appendStyle(mdToHtml, "basic.css");
			mdToHtml = HtmlUtils.appendJs(mdToHtml, "basic.js");

			FileWriter writer = new FileWriter(output);
			writer.write(mdToHtml);
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}
}

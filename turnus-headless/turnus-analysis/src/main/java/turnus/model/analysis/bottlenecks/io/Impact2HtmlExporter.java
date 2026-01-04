package turnus.model.analysis.bottlenecks.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;
import turnus.model.utils.HtmlUtils;

/**
 * Impact analysis HTML exporter
 *
 * @author Endri Bezati
 */
public class Impact2HtmlExporter extends Impact2MdExporter {

	@Override
	public void export(ImpactAnalysisReport data, File output) throws TurnusException {
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

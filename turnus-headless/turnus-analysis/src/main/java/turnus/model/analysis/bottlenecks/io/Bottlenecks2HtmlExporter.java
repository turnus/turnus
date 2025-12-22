package turnus.model.analysis.bottlenecks.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.utils.HtmlUtils;


/**
 * Bottlenecks HTML exporter
 * 
 * 
 * @author Endri Bezati
 */
public class Bottlenecks2HtmlExporter extends Bottlenecks2MdExporter {

	@Override
	public void export(BottlenecksReport data, File output) throws TurnusException {
		try {

			StringBuffer b = content(data);
			String mdContent = b.toString();
			
			String mdToHtml = HtmlUtils.markdown2Html(mdContent);
			mdToHtml = HtmlUtils.appendJs(mdToHtml, "basic.js");
		    mdToHtml = HtmlUtils.appendStyle(mdToHtml, "basic.css");
			
			
			FileWriter writer = new FileWriter(output);
			
			writer.write(mdToHtml);
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	

}

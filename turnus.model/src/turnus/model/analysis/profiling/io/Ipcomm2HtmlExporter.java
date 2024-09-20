package turnus.model.analysis.profiling.io;

import java.io.File;
import java.io.FileWriter;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.utils.HtmlUtils;

public class Ipcomm2HtmlExporter extends Ipcomm2MdExporter {
	@Override
	public void export(InterPartitionCommunicationAndMemoryReport data, File output) throws TurnusException {
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

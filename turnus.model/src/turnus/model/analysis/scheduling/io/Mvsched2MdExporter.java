package turnus.model.analysis.scheduling.io;

import java.io.File;
import java.io.FileWriter;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.scheduling.MarkovSimpleSchedulerReport;

public class Mvsched2MdExporter  implements FileExporter<MarkovSimpleSchedulerReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		MarkovSimpleSchedulerReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

	@Override
	public void export(MarkovSimpleSchedulerReport object, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = new StringBuffer();
			
			
			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
		
	}

}

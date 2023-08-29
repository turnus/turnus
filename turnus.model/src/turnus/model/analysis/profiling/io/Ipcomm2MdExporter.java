package turnus.model.analysis.profiling.io;

import java.io.File;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;

/**
 * The {@link InterPartitionCommunicationAndMemoryReport} MD File exporter
 * 
 * @author Endri Bezati
 */
public class Ipcomm2MdExporter implements FileExporter<InterPartitionCommunicationAndMemoryReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		InterPartitionCommunicationAndMemoryReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(InterPartitionCommunicationAndMemoryReport object, File output) throws TurnusException {
		// TODO Auto-generated method stub

	}

}

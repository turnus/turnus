package turnus.model.analysis.postprocessing.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.postprocessing.BufferBlockingReport;
import turnus.model.dataflow.Buffer;

public class BufferBlocking2MdExporter implements FileExporter<BufferBlockingReport>{

	@Override
	public void export(File input, File output) throws TurnusException {
		BufferBlockingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
		
	}

	@Override
	public void export(BufferBlockingReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = new StringBuffer();
			
			// -- Title
			b.append("# Post Processing - Buffer Blocking report");
			b.append("\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append("\n");
			
			b.append("## Blocked Buffers \n");
			
			
			b.append("| Source || Target || Max Blocked Tokens | Max Blocked Time | Number of Blockings\n");
			b.append("| Actor | Port | Actor | Port | -  |  - |  - |  \n");
			b.append("|:------|:------|:----|:-----|:----|:----|:----\n");
			
			for (Buffer buffer : data.getMaxBlockedOutputTokens().keySet()) {
				b.append(String.format("| %s | %s | %s | %s |  %d | %.2f | %d  \n",
						buffer.getSource().getOwner().getName(), 
						buffer.getSource().getName(),
						buffer.getTarget().getOwner().getName(), 
						buffer.getTarget().getName(),
						data.getMaxBlockedOutputTokens().get(buffer),
						data.getMaxBlockedMultiplication().get(buffer),
						data.getBlockingInstances().get(buffer))
						);
				
			}
			
			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
		
	}

}

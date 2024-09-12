package turnus.model.analysis.postprocessing.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.postprocessing.SchedulerChecksPartition;
import turnus.model.analysis.postprocessing.SchedulerChecksReport;
import turnus.model.dataflow.Actor;

public class SchedulerChecks2MdExporter implements FileExporter<SchedulerChecksReport, StringBuffer> {

	@Override
	public void export(File input, File output) throws TurnusException {
		SchedulerChecksReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	@Override
	public void export(SchedulerChecksReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);
			StringBuffer b = content(data);

			writer.write(b.toString());
			writer.close();
		} catch (IOException e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}
	}

	/**
	 * Return the {@link SchedulerChecksReport} as a {@link StringBuffer}
	 * 
	 * @param data
	 * @param isParent
	 * @return
	 */
	public static StringBuffer report(SchedulerChecksReport data, boolean isParent) {
		StringBuffer b = new StringBuffer();
		// -- Title
		if (isParent) {
			b.append("# Post Processing - Scheduler Checks report");
			b.append("\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));

		} else {
			b.append("## Scheduler Checks");
		}

		b.append("\n");
		int partition = 1;
		for (SchedulerChecksPartition part : data.getPartitions()) {
			if (isParent) {
				b.append(String.format("## Partition - %d\n", partition++));
			} else {
				b.append(String.format("### Partition - %d\n", partition++));
			}

			if (isParent) {
				b.append(String.format("### Overview \n"));
			} else {
				b.append(String.format("#### Overview \n"));
			}

			b.append("\n");

			b.append("| Conditions | Total | Average | Max | Min \n");
			b.append("|:--         | --:   | --:     | --: | --:\n");
			b.append(String.format("| Hit | %.2f | %.2f | %.2f |  %.2f \n", part.getAggregatedCheckedData().getSum(),
					part.getAggregatedCheckedData().getMean(), part.getAggregatedCheckedData().getMax(),
					part.getAggregatedCheckedData().getMin()));
			b.append(String.format("| Miss | %.2f | %.2f | %.2f |  %.2f \n", part.getAggregatedFailedData().getSum(),
					part.getAggregatedFailedData().getMean(), part.getAggregatedFailedData().getMax(),
					part.getAggregatedFailedData().getMin()));

			if (isParent) {
				b.append(String.format("### Conditions Hit \n"));
			} else {
				b.append(String.format("#### Conditions Hit \n"));
			}
			b.append("\n");

			b.append("| Actor | Total | Average | Max | Min \n");
			b.append("| :--   | --:   | --:     | --: | --: \n");

			for (Actor actor : part.getCheckedConditionsMap().keySet()) {
				b.append(String.format("| %s | %.2f | %.2f | %.2f |  %.2f \n", actor.getName(),
						part.getCheckedConditionsMap().get(actor).getSum(),
						part.getCheckedConditionsMap().get(actor).getMean(),
						part.getCheckedConditionsMap().get(actor).getMax(),
						part.getCheckedConditionsMap().get(actor).getMin()));

			}

			if (isParent) {
				b.append(String.format("### Conditions Miss \n"));
			} else {
				b.append(String.format("#### Conditions Miss \n"));
			}
			b.append("\n");

			b.append("| Actor | Total | Average | Max | Min \n");
			b.append("| :--   | --:   | --:     | --: | --: \n");
			for (Actor actor : part.getFailedConditionsMap().keySet()) {
				b.append(String.format("| %s | %.2f | %.2f | %.2f |  %.2f \n", actor.getName(),
						part.getFailedConditionsMap().get(actor).getSum(),
						part.getFailedConditionsMap().get(actor).getMean(),
						part.getFailedConditionsMap().get(actor).getMax(),
						part.getFailedConditionsMap().get(actor).getMin()));

			}
		}

		return b;
	}

	@Override
	public StringBuffer content(SchedulerChecksReport data) {
		StringBuffer b = new StringBuffer();
		b.append(report(data, true));
		return b;
	}

}

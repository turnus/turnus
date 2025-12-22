/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse (or a modified version of Eclipse or an Eclipse plugin or 
 * an Eclipse library), containing parts covered by the terms of the 
 * Eclipse Public License (EPL), the licensors of this Program grant you 
 * additional permission to convey the resulting work.  Corresponding Source 
 * for a non-source form of such a combination shall include the source code 
 * for the parts of Eclipse libraries used as well as that of the  covered work.
 * 
 */
package turnus.model.analysis.profiler.io;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.common.StatisticalData;
import turnus.model.dataflow.Buffer;

/**
 * The {@link DynamicProfilingReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 *
 */
public class Dprof2MdExporter implements FileExporter<DynamicProfilingReport, StringBuffer> {

	@Override
	public void export(DynamicProfilingReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = content(data);

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	@Override
	public void export(File input, File output) throws TurnusException {
		DynamicProfilingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

	@Override
	public StringBuffer content(DynamicProfilingReport data) {
		StringBuffer b = new StringBuffer();
		b.append("# Dynamic profiling analysis report\n");
		b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));

		b.append("## Actors operator calls\n");
		b.append("| Actor | Class | Sum | Mean | Min | Max\n");
		b.append("|:------|:------|:----|:-----|:----|:----\n");

		List<ActorDynamicData> actorsData = new ArrayList<>(data.getActorsData());
		for (ActorDynamicData d : actorsData) {
			StatisticalData sum = StatisticalData.Util.sum(d.getOperandsCalls().values());
			b.append(String.format("| %s | %s| %d | %s | %d | %d\n", d.getActor().getName(),
					d.getActor().getActorClass().getName(), (long) sum.getSum(), StringUtils.format(sum.getMean()),
					(long) sum.getMin(), (long) sum.getMax()));
		}

		b.append("## Buffers utilization\n");
		List<BufferDynamicData> buffersData = new ArrayList<>(data.getBuffersData());

		b.append("| Source || Target || Write  ||  Read || Unconsumed \n");
		b.append("| Actor | Port | Actor | Port |  Sum |  Mean |  Sum | Mean | . \n");
		b.append("|:------|:------|:----|:-----|:----|:----|:----|:----|:----\n");
		for (BufferDynamicData buff : buffersData) {
			Buffer buffer = buff.getBuffer();
			b.append(String.format("| %s | %s | %s | %s |  %d | %s  | %d  | %s | %d \n",
					buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
					buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
					(long) buff.getWrites().getSum(), StringUtils.format(buff.getWrites().getMean()),
					(long) buff.getReads().getSum(), StringUtils.format(buff.getReads().getMean()),
					buff.getUnconsumedTokens()));

		}
		b.append("\n");
		return b;
	}

}

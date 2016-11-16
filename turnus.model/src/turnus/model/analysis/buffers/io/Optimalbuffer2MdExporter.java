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
package turnus.model.analysis.buffers.io;

import static turnus.common.util.StringUtils.format;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.buffers.OptimalBufferData;
import turnus.model.analysis.buffers.OptimalBuffersReport;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class Optimalbuffer2MdExporter implements FileExporter<OptimalBuffersReport> {

	@Override
	public void export(File input, File output) throws TurnusException {
		OptimalBuffersReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);

	}

	private static double getKb(int bit) {
		return ((double) bit) / 1024.0 / 8.0;
	}

	@Override
	public void export(OptimalBuffersReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Optimal buffer size analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Bit accurate**: %s\n", data.isBitAccurate()));
			b.append(String.format("* **Power of 2**: %s\n", data.isPow2()));
			b.append("\n");

			List<OptimalBufferData> bdata = new ArrayList<>(data.getBuffersData());
			BottlenecksWithSchedulingReport initialCp = data.getInitialBottlenecks();
			BoundedBuffersReport initialBuffer = data.getInitialBufferConfiguration();

			double nominal_cp = initialCp.getCpWeight();
			int nominal_tokens = initialBuffer.getTokenSize();
			int nominal_bit = initialBuffer.getBitSize();

			b.append("| iteration | cp reduction | tokens || bit|| \n");
			b.append("|:----|:----|:----|:----|:----|:----|:----\n");
			b.append(String.format("| nominal |   |  %d |  | %d (%s kB) | |\n", nominal_tokens, nominal_bit,
					format(getKb(nominal_bit))));
			int i = 1;
			for (OptimalBufferData o : bdata) {
				double cp = o.getBottlenecksData().getCpWeight();
				int tokens = o.getBufferData().getTokenSize();
				int bit = o.getBufferData().getBitSize();
				double kbit = getKb(bit);

				double cp_reduction = (1.0 - cp / nominal_cp) * 100.0;
				double bit_increase = (((double) bit) / nominal_bit - 1) * 100.0;
				double tokens_increase = (((double) tokens) / nominal_tokens - 1) * 100.0;
				b.append(String.format("| %d | -%s  | %d  | %s |  %d (%s kB) | %s \n", i++, format(cp_reduction) + "%",
						tokens, format(tokens_increase) + "%", bit, format(kbit), format(bit_increase) + "%"));
			}
			b.append("[Summary]\n");
			b.append("\n\n");

			// create a table
			Network network = data.getNetwork();
			Table<Integer, Buffer, Integer> resultsTable = HashBasedTable.create();
			BufferSize bsize = initialBuffer.asBufferSize();
			for (Buffer buffer : network.getBuffers()) {
				resultsTable.put(0, buffer, bsize.getSize(buffer));
			}

			int iteration = 1;
			for (OptimalBufferData o : bdata) {
				bsize = o.getBufferData().asBufferSize();
				for (Buffer buffer : network.getBuffers()) {
					resultsTable.put(iteration, buffer, bsize.getSize(buffer));
				}
				iteration++;
			}

			b.append("| Source-Actor | Source-Port | Target-Actor | Target-Port  | Nominal ");
			for (i = 1; i < iteration; i++) {
				b.append("| Conf. " + i);
			}
			b.append("\n");
			b.append("|:----|:----|:----|:----");
			for (i = 0; i < iteration; i++) {
				b.append("|:----");
			}
			b.append("\n");

			List<Buffer> buffers = new ArrayList<>(network.getBuffers());
			Collections.sort(buffers, new Comparator<Buffer>() {

				@Override
				public int compare(Buffer o1, Buffer o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			
			for (Buffer buffer : buffers) {
				b.append(buffer.getSource().getOwner().getName() + " | " + buffer.getSource().getName() + "|");
				b.append(buffer.getTarget().getOwner().getName() + " | " + buffer.getTarget().getName());

				int oldSize = 0;
				for (i = 0; i < iteration; i++) {
					int tokens = resultsTable.get(i, buffer);
					int bit = tokens * buffer.getType().getBits();
					if (i > 0 && tokens != oldSize) {
						b.append("| **" + tokens + "** **(" + bit + "bit)**");
					}else{
						b.append("| " + tokens + " (" + bit + "bit)");
					}
					oldSize = tokens;
				}
				b.append("\n");
			}

			b.append("\n\n");
			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

}

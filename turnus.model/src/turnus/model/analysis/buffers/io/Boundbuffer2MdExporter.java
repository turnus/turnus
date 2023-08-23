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

import static turnus.common.util.StringUtils.formatBits;
import static turnus.common.util.StringUtils.formatBytes;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.model.analysis.buffers.BoundedBufferData;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.dataflow.Buffer;



/**
 * The {@link BoundedBuffersReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 *
 */
public class Boundbuffer2MdExporter implements FileExporter<BoundedBuffersReport> {

	
	
	@Override
	public void export(BoundedBuffersReport data, File output) throws TurnusException {
		try {
			FileWriter writer = new FileWriter(output);

			StringBuffer b = new StringBuffer();
			b.append("# Bounded buffer size analysis report\n");
			b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
			b.append(String.format("* **Algorithms**: %s\n", data.getAlgorithm()));
			b.append(String.format("* **Bit accurate**: %s\n", data.isBitAccurate()));
			b.append(String.format("* **Power of 2**: %s\n", data.isPow2()));

			List<BoundedBufferData> bdata = new ArrayList<>(data.getBuffersData());
			Collections.sort(bdata, new Comparator<BoundedBufferData>() {
				@Override
				public int compare(BoundedBufferData o1, BoundedBufferData o2) {
					String b1 = o1.getBuffer().toString();
					String b2 = o2.getBuffer().toString();
					return b1.compareTo(b2);
				}
			});
			b.append("\n");

			b.append("| tokens | bit \n");
			b.append("|:----|:----\n");
			b.append(String.format("|%d | %s (%s) \n", data.getTokenSize(), formatBits(data.getBitSize()), formatBytes(data.getBitSize(), true)));
			b.append("[overall buffer size]\n");

			b.append("\n");

			b.append("| source | source-port | target | target-port | type | tokens | bits\n");
			b.append("|:----|:----|:----|:----|:----|:----|:----\n");
			for (BoundedBufferData bd : bdata) {
				Buffer buffer = bd.getBuffer();
				b.append(String.format("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",
						buffer.getSource().getOwner().getName(), buffer.getSource().getName(),
						buffer.getTarget().getOwner().getName(), buffer.getTarget().getName(),
						buffer.getType().toString(), Integer.toString(bd.getTokenSize()),
						formatBits(bd.getTokenSize() * buffer.getType().getBits())));
			}
			b.append("[buffer size configuration]\n");

			b.append("\n\n");

			writer.write(b.toString());
			writer.close();
		} catch (Exception e) {
			Logger.warning("The \"" + output + "\" output file has not been correctly written");
		}

	}

	@Override
	public void export(File input, File output) throws TurnusException {
		BoundedBuffersReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

}

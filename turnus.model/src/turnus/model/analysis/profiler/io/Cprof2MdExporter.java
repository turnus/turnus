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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.TurnusException;
import turnus.common.io.FileExporter;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.StringUtils;
import turnus.model.analysis.profiler.CodeProfilingReport;
import turnus.model.analysis.profiler.util.HalsteadCodeAnalysis;
import turnus.model.analysis.profiler.util.HalsteadCodeAnalysis.HalsteadAnalysis;
import turnus.model.dataflow.Network;

/**
 * The {@link CodeProfilingReport} MD file exporter
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class Cprof2MdExporter implements FileExporter<CodeProfilingReport, StringBuffer> {

	@Override
	public void export(CodeProfilingReport data, File output) throws TurnusException {
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
		CodeProfilingReport data = EcoreUtils.loadEObject(new ResourceSetImpl(), input);
		if (data == null) {
			throw new TurnusException("The input file \"" + input + "\" is not a valid analysis file");
		}
		export(data, output);
	}

	@Override
	public StringBuffer content(CodeProfilingReport data) {
		HalsteadCodeAnalysis a = new HalsteadCodeAnalysis(data);
		HalsteadAnalysis dN = a.getNetworkAnalysis();
		StringBuffer b = new StringBuffer();

		b.append("# Halstead complexity analysis report\n");
		b.append(String.format("* **Network**: %s\n", data.getNetwork().getName()));
		b.append("\n");

		b.append("| Actors | Classes | Buffers \n");
		b.append("|:--- |:--- |:--- \n");
		Network net = data.getNetwork();
		b.append(String.format("| %d | %d | %d \n", net.getActors().size(), net.getActorClasses().size(),
				net.getBuffers().size()));
		b.append("\n");

		b.append("| NoL | n | n1 | n2 | N | N1 | N2 | D | V | B \n");
		b.append("|:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- \n");
		b.append(String.format("| %d | %d | %d | %d | %d | %d | %d | %s | %s | %s \n", dN.NoL(), dN.n(), dN.n1(),
				dN.n2(), dN.N(), dN.N1(), dN.N2(), StringUtils.format(dN.D()), StringUtils.format(dN.V()),
				StringUtils.format(dN.B())));
		b.append("\n");

		b.append("## Actor classes\n");
		List<HalsteadAnalysis> classData = new ArrayList<>(a.getActorClassesAnalysis());
		Collections.sort(classData, new Comparator<HalsteadAnalysis>() {
			@Override
			public int compare(HalsteadAnalysis o1, HalsteadAnalysis o2) {
				return o1.blockName().compareTo(o2.blockName());
			}
		});

		b.append("| Actor-Class | NoL | n | n1 | n2 | N | N1 | N2 | D | V | B \n");
		b.append("|:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- |:--- \n");
		for (HalsteadAnalysis d : classData) {
			b.append(String.format("| %s | %d | %d | %d | %d | %d | %d | %d | %s | %s | %s \n", d.blockName(), d.NoL(),
					d.n(), d.n1(), d.n2(), d.N(), d.N1(), d.N2(), StringUtils.format(d.D()), StringUtils.format(d.V()),
					StringUtils.format(d.B())));
		}
		return b;
	}

}

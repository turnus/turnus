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
package turnus.adevs.simulation.Heter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import turnus.common.TurnusException;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.postprocessing.PostprocessingFactory;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;

public class SimEngineGPUMeasured extends SimEngineGPU {

	private File tmpF;
	private String cmd;
	private double time;

	public SimEngineGPUMeasured(String cmd) {
		this.cmd = cmd;
	}

	// currently only compatible on Linux
	private void generateWeights() {
		try {
			// create mapping file
			tmpF = new File(Files.createTempFile("m", ".xcf").toString());
			new XmlNetworkPartitioningWriter().write(getNetworkPartitioning(), tmpF);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TurnusException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setNetworkPartitioning(NetworkPartitioning partitioning) {
		super.setNetworkPartitioning(partitioning);
		generateWeights();
	}

	private PostProcessingReport generateReport() {
		PostprocessingFactory f = PostprocessingFactory.eINSTANCE;
		PostProcessingReport finalReport = f.createPostProcessingReport();
		finalReport.setTime(time);
		return finalReport;
	}

	// only work on linux at the moment
	@Override
	public PostProcessingReport run() throws TurnusException {
		try {
			// execute code
			String cmd_tmp = " /usr/bin/time -f %e " + cmd + " " + tmpF.getAbsolutePath() + " > /dev/null ; ";
			System.out.println(cmd_tmp);
			Process process;
			process = Runtime.getRuntime().exec(cmd_tmp);
			process.waitFor();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			String sTime = reader.readLine();
			time = Double.parseDouble(sTime);

			tmpF.delete();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return generateReport();
	}
}

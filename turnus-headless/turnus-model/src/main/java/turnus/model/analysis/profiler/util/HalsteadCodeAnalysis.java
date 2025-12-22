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
package turnus.model.analysis.profiler.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.CodeProfilingReport;
import turnus.model.analysis.profiler.ComplexCodeData;

/**
 * This class defines the static code analysis based on the
 * {@link CodeProfilingReport} data.
 * 
 * @author Simone Casale Brunet
 *
 */
public class HalsteadCodeAnalysis {

	/**
	 * This class contains the Halstead metrics analysis
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public class HalsteadAnalysis {
		// delivered bugs
		private double B;
		// the block name
		private String blockName;
		// calculated program length
		private double cN;
		// difficulty
		private double D;
		// effort
		private double E;
		// intelligent content
		private double I;
		// program vocabulary
		private int n;
		// program length
		private int N;
		// number of operators
		private int n1;
		// number of total operators
		private int N1;
		// number of operands
		private int n2;
		// number of total operands
		private int N2;
		// number of lines
		private long NoL;
		// operands count map
		private Map<String, Integer> operandsMap;
		// operators count map
		private Map<String, Integer> operatorsMap;
		// time
		private double T;
		// program volume
		private double V;

		/**
		 * Create a new Halstead analyzer for the given {@link CodeData}
		 * obtained through a static code analysis
		 * 
		 * @param data
		 */
		private HalsteadAnalysis(CodeData data) {

			blockName = data.getBlockName();

			n1 = 0;
			N1 = 0;
			operatorsMap = new HashMap<>();
			for (Entry<String, Integer> e : data.getOperatorsCount().entrySet()) {
				String key = e.getKey();
				Integer value = e.getValue();
				operatorsMap.put(key, value);

				N1 += value;
				n1++;
			}

			n2 = 0;
			N2 = 0;
			operandsMap = new HashMap<>();
			for (Entry<String, Integer> e : data.getOperandsCount().entrySet()) {
				String key = e.getKey();
				Integer value = e.getValue();
				operandsMap.put(key, value);

				N2 += value;
				n2++;
			}

			// evaluate metrics
			n = n1 + n2;
			N = N1 + N2;
			cN = (n1 * Math.log(n1) / Math.log(2)) + (n2 * Math.log(n2) / Math.log(2));
			V = N * Math.log(n) / Math.log(2);
			D = (n1 / 2) * (N2 / n2);
			E = D * V;
			T = E / 18;
			B = Math.pow(E, 2.0 / 3) / 3000;
			I = V / D;

			NoL = data.getNol();

		}

		/**
		 * Number of delivered bugs
		 * 
		 * @return
		 */
		public double B() {
			return B;
		}

		/**
		 * The block name
		 * 
		 * @return
		 */
		public String blockName() {
			return blockName;
		}

		/**
		 * Calculated program length
		 * 
		 * @return
		 */
		public double cN() {
			return cN;
		}

		/**
		 * Difficulty
		 * 
		 * @return
		 */
		public double D() {
			return D;
		}

		/**
		 * Effort (in seconds)
		 * 
		 * @return
		 */
		public double E() {
			return E;
		}

		/**
		 * Intelligent content
		 * 
		 * @return
		 */
		public double I() {
			return I;
		}

		/**
		 * Program vocabulary
		 * 
		 * @return
		 */
		public int n() {
			return n;
		}

		/**
		 * Program length
		 * 
		 * @return
		 */
		public int N() {
			return N;
		}

		/**
		 * The number of distinct operators
		 * 
		 * @return
		 */
		public int n1() {
			return n1;
		}

		/**
		 * The total number of operators
		 * 
		 * @return
		 */
		public int N1() {
			return N1;
		}

		/**
		 * The number of distinct operands
		 * 
		 * @return
		 */
		public int n2() {
			return n2;
		}

		/**
		 * The total number of operands
		 * 
		 * @return
		 */
		public int N2() {
			return N2;
		}

		/**
		 * Number of lines
		 * 
		 * @return
		 */
		public long NoL() {
			return NoL;
		}

		/**
		 * Get the operands map: <code>operand, occurrences</code>
		 * 
		 * @return
		 */
		public Map<String, Integer> operandsMap() {
			return new TreeMap<>(operandsMap);
		}

		/**
		 * Get the operators map: <code>operator, occurrences</code>
		 * 
		 * @return
		 */
		public Map<String, Integer> operatorsMap() {
			return new TreeMap<>(operatorsMap);
		}

		/**
		 * Time required to program (in seconds)
		 * 
		 * @return
		 */
		public double T() {
			return T;
		}

		public String toString() {
			StringBuffer result = new StringBuffer();
			result.append("n1: ");
			result.append(n1);
			result.append(", n2: ");
			result.append(n2);
			result.append(", n: ");
			result.append(n);
			result.append(", N1: ");
			result.append(N1);
			result.append(", N2: ");
			result.append(N2);
			result.append(", N: ");
			result.append(N);
			result.append(", cN: ");
			result.append(cN);
			result.append(", V: ");
			result.append(V);
			result.append(", D: ");
			result.append(D);
			result.append(", E: ");
			result.append(E);
			result.append(", T: ");
			result.append(T);
			result.append(", B: ");
			result.append(B);
			result.append(", I: ");
			result.append(I);
			return result.toString();
		}

		/**
		 * Volume
		 * 
		 * @return
		 */
		public double V() {
			return V;
		}
	}

	/** the analyzed network */
	private String network;
	/** the network analysis data */
	private HalsteadAnalysis networkAnalysis;
	/** the actor classes analysis data */
	private List<HalsteadAnalysis> actorClassesAnalysis;

	/**
	 * Create a new code analysis
	 * 
	 * @param report
	 */
	public HalsteadCodeAnalysis(CodeProfilingReport report) {
		this.network = report.getNetwork().getName();
		networkAnalysis = new HalsteadAnalysis(report.getNetworkData());

		actorClassesAnalysis = new ArrayList<>();
		for (ComplexCodeData data : report.getActorClassesData()) {
			actorClassesAnalysis.add(new HalsteadAnalysis(data));
		}

		// sort the list
		Collections.sort(actorClassesAnalysis, new Comparator<HalsteadAnalysis>() {
			@Override
			public int compare(HalsteadAnalysis o1, HalsteadAnalysis o2) {

				return o1.blockName.compareTo(o2.blockName);
			}
		});

	}

	/**
	 * Get the analyzed network
	 * 
	 * @return
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * Get the network analysis result
	 * 
	 * @return
	 */
	public HalsteadAnalysis getNetworkAnalysis() {
		return networkAnalysis;
	}

	/**
	 * Get the actor classes analysis result
	 * 
	 * @return
	 */
	public List<HalsteadAnalysis> getActorClassesAnalysis() {
		return Collections.unmodifiableList(actorClassesAnalysis);
	}

}

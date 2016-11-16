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
package turnus.analysis.ui.profiler;

import static turnus.common.util.StringUtils.format;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.common.util.EcoreUtils;
import turnus.model.analysis.profiler.ActorDynamicData;
import turnus.model.analysis.profiler.BufferDynamicData;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.common.EOperator;
import turnus.model.common.StatisticalData;
import turnus.model.dataflow.Buffer;
import turnus.ui.editor.AbstractBrowserEditor;

/**
 * This class contains the editor for the {@link DynamicProfilingReport} data
 * 
 * @author Simone Casale Brunet
 *
 */
public class DynamicAnalysisReportEditor extends AbstractBrowserEditor {

	private class HtmlWriter {
		private DynamicProfilingReport report;

		private HtmlWriter(DynamicProfilingReport report) {
			this.report = report;
		}

		public String toHtml() {
			String network = report.getNetwork().getName();
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>\"").append(network).append("\" dynamic code analysis summary</h1>");

			appendActorsResults(sb, report.getActorsData());
			appendBuffersData(sb, report.getBuffersData());

			return sb.toString();
		}

		private void appendBuffersData(StringBuilder sb, List<BufferDynamicData> buffersData) {
			sb.append("<h2>Buffers comunication data</h2>");

			sb.append("<div class=\"container\">");
			sb.append("<table>");

			sb.append("<thead>");
			sb.append("<tr>");
			sb.append("<th rowspan=\"2\"> </th>");
			sb.append("<th colspan=\"2\">Source</th>");
			sb.append("<th colspan=\"2\">Target</th>");
			sb.append("<th rowspan=\"2\">Sum</th>");
			sb.append("<th rowspan=\"2\">Mean</th>");
			sb.append("<th rowspan=\"2\">Min</th>");
			sb.append("<th rowspan=\"2\">Max</th>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<th>Actor</th>");
			sb.append("<th>Port</th>");
			sb.append("<th>Actor</th>");
			sb.append("<th>Port</th>");
			sb.append("</tr>");
			sb.append("</thead>");

			sb.append("<tbody>");

			// reads
			boolean printCellName = true;
			for (BufferDynamicData bufferData : buffersData) {
				Buffer b = bufferData.getBuffer();
				sb.append("<tr>");
				if (printCellName) {
					sb.append("<td rowspan=\"" + buffersData.size() + "\">").append("Reads</td>");
					printCellName = false;
				}
				sb.append("<td>").append(b.getSource().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getSource().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getName()).append("</td>");

				StatisticalData s = bufferData.getReads();
				sb.append("<td>").append((long) s.getSum()).append("</td>");
				sb.append("<td>").append(format(s.getMean())).append("</td>");
				sb.append("<td>").append(format(s.getMin())).append("</td>");
				sb.append("<td>").append(format(s.getMax())).append("</td>");
				sb.append("</tr>");
			}

			// writes
			printCellName = true;
			for (BufferDynamicData bufferData : buffersData) {
				Buffer b = bufferData.getBuffer();
				sb.append("<tr>");
				if (printCellName) {
					sb.append("<td rowspan=\"" + buffersData.size() + "\">").append("Writes</td>");
					printCellName = false;
				}
				sb.append("<td>").append(b.getSource().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getSource().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getName()).append("</td>");

				StatisticalData s = bufferData.getWrites();
				sb.append("<td>").append((long) s.getSum()).append("</td>");
				sb.append("<td>").append(format(s.getMean())).append("</td>");
				sb.append("<td>").append(format(s.getMin())).append("</td>");
				sb.append("<td>").append(format(s.getMax())).append("</td>");
				sb.append("</tr>");
			}

			// occupancy
			printCellName = true;
			for (BufferDynamicData bufferData : buffersData) {
				Buffer b = bufferData.getBuffer();
				sb.append("<tr>");
				if (printCellName) {
					sb.append("<td rowspan=\"" + buffersData.size() + "\">").append("Occupancy</td>");
					printCellName = false;
				}
				sb.append("<td>").append(b.getSource().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getSource().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getOwner().getName()).append("</td>");
				sb.append("<td>").append(b.getTarget().getName()).append("</td>");

				StatisticalData s = bufferData.getOccupancy();
				sb.append("<td>").append((long) s.getSum()).append("</td>");
				sb.append("<td>").append(format(s.getMean())).append("</td>");
				sb.append("<td>").append(format(s.getMin())).append("</td>");
				sb.append("<td>").append(format(s.getMax())).append("</td>");
				sb.append("</tr>");
			}

			sb.append("</tbody>");

			sb.append("</table>");
			sb.append("</div>");
		}

		private void appendActorsResults(StringBuilder sb, List<ActorDynamicData> actorsData) {
			sb.append("<h2>Actors execution data</h2>");

			{// operators calls
				sb.append("<div class=\"container\">");
				sb.append("<table>");
				sb.append("<h3>Operator calls</h2>");
				sb.append("<thead>");
				sb.append("<tr>");
				sb.append("<th>Actor</th>");
				sb.append("<th>Sum</th>");
				sb.append("<th>Mean</th>");
				sb.append("<th>Min</th>");
				sb.append("<th>Max</th>");
				sb.append("</tr>");
				sb.append("</thead>");

				sb.append("<tbody>");
				for (ActorDynamicData actorData : actorsData) {
					Map<EOperator, StatisticalData> opsMap = new HashMap<>(actorData.getOperandsCalls());
					// clean the map
					for (EOperator op : EOperator.values()) {
						if (opsMap.containsKey(op) && opsMap.get(op).getSum() == 0.0) {
							opsMap.remove(op);
						}
					}
					Set<Entry<EOperator, StatisticalData>> es = opsMap.entrySet();
					boolean printActor = true;
					for (Entry<EOperator, StatisticalData> e : es) {
						EOperator op = e.getKey();
						StatisticalData s = e.getValue();
						sb.append("<tr>");
						if (printActor) {
							String actor = actorData.getActor().getName();
							sb.append("<td rowspan=\"" + es.size() + "\">").append(actor).append("</td>");
							printActor = false;
						}
						sb.append("<td>").append(op.getLiteral()).append("</td>");
						sb.append("<td>").append((long) s.getSum()).append("</td>");
						sb.append("<td>").append(format(s.getMean())).append("</td>");
						sb.append("<td>").append(format(s.getMin())).append("</td>");
						sb.append("<td>").append(format(s.getMax())).append("</td>");
						sb.append("</tr>");

					}

				}
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div>");
			}
		}
	}

	public DynamicAnalysisReportEditor() {
		super();
		addStyle("basic.css");
		addJs("basic.js");

	}

	@Override
	protected String toHtml(IFile file) {
		DynamicProfilingReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), file);
		return new HtmlWriter(report).toHtml();
	}

}

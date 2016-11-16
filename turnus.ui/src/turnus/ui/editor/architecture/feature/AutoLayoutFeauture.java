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
package turnus.ui.editor.architecture.feature;

import static turnus.ui.editor.architecture.util.StyleUtils.SHAPE_HEIGHT;
import static turnus.ui.editor.architecture.util.StyleUtils.SHAPE_WIDTH;

import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.CompoundDirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class AutoLayoutFeauture extends AbstractCustomFeature {

	private boolean hasDoneChanges;

	public AutoLayoutFeauture(IFeatureProvider fp) {
		super(fp);
		hasDoneChanges = false;
	}

	@Override
	public String getDescription() {
		return "Layout the diagram";
	}

	@Override
	public String getName() {
		return "Layout diagram";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void execute(ICustomContext context) {

		Diagram diagram = getDiagram();
		CompoundDirectedGraph draw2dGrap = new CompoundDirectedGraph();
		BiMap<PictogramElement, Node> draw2dGraphMap = HashBiMap.create();
		for (Shape shape : diagram.getChildren()) {
			final EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
			if (eObject instanceof ProcessingUnit || eObject instanceof Medium) {
				Node node = new Node();
				draw2dGrap.nodes.add(node);
				node.setSize(new Dimension(SHAPE_WIDTH, SHAPE_HEIGHT));
				draw2dGraphMap.put(shape, node);
			}
		}

		for (Connection connection : diagram.getConnections()) {
			Node start = draw2dGraphMap.get(connection.getEnd().getParent());
			Node end = draw2dGraphMap.get(connection.getStart().getParent());
			Edge edge = new Edge(start, end);
			draw2dGrap.edges.add(edge);
		}

		new CompoundDirectedGraphLayout().visit(draw2dGrap);

		for (Entry<PictogramElement, Node> e : draw2dGraphMap.entrySet()) {
			PictogramElement pe = e.getKey();
			Node n = e.getValue();
			Graphiti.getGaService().setLocation(pe.getGraphicsAlgorithm(), n.x, n.y);
		}

		hasDoneChanges = true;

	}

}

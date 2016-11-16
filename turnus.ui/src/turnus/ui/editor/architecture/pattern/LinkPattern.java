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
package turnus.ui.editor.architecture.pattern;

import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import turnus.model.architecture.Architecture;
import turnus.model.architecture.ArchitectureFactory;
import turnus.model.architecture.Link;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;
import turnus.ui.editor.architecture.util.StyleUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class LinkPattern extends AbstractConnectionPattern {

	@Override
	public String getCreateName() {
		return "Link";
	}

	@Override
	public String getCreateDescription() {
		return "Add a link between a processing unit and a medium";
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		final Anchor anchor = context.getSourceAnchor();
		Object obj = getBusinessObjectForPictogramElement(anchor.getParent());
		return obj != null && (obj instanceof ProcessingUnit || obj instanceof Medium);
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Anchor srcAnchor = context.getSourceAnchor();
		Anchor tgtAnchor = context.getTargetAnchor();
		if (srcAnchor == null || tgtAnchor == null) {
			return false;
		}

		Object src = getBusinessObjectForPictogramElement(srcAnchor.getParent());
		Object tgt = getBusinessObjectForPictogramElement(tgtAnchor.getParent());

		if (src == null || tgt == null || src == tgt) {
			return false;
		} else if (src instanceof ProcessingUnit && tgt instanceof Medium) {
			return !areAlreadyLinked((ProcessingUnit) src, (Medium) tgt);
		} else if (tgt instanceof ProcessingUnit && src instanceof Medium) {
			return !areAlreadyLinked((ProcessingUnit) tgt, (Medium) src);
		} else {
			return false;
		}

	}

	private boolean areAlreadyLinked(ProcessingUnit pu, Medium m) {
		for (Link link : pu.getLinks()) {
			if (link.getMedium() == m) {
				return true;
			}
		}
		return false;

	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Anchor srcAnchor = context.getSourceAnchor();
		Anchor tgtAnchor = context.getTargetAnchor();

		Object src = getBusinessObjectForPictogramElement(srcAnchor.getParent());
		Object tgt = getBusinessObjectForPictogramElement(tgtAnchor.getParent());
		Medium medium = null;
		ProcessingUnit pu = null;
		if (src instanceof ProcessingUnit) {
			pu = (ProcessingUnit) src;
		} else if (src instanceof Medium) {
			medium = (Medium) src;
		} else {
			// error
		}

		if (tgt instanceof ProcessingUnit) {
			pu = (ProcessingUnit) tgt;
		} else if (tgt instanceof Medium) {
			medium = (Medium) tgt;
		} else {
			// error
		}
		if (pu == null || medium == null) {
			// error
		}

		AddConnectionContext addContext = new AddConnectionContext(srcAnchor, tgtAnchor);
		Link link = ArchitectureFactory.eINSTANCE.createLink();
		link.setMedium(medium);
		link.setProcessingUnit(pu);

		Architecture architecture = (Architecture) getBusinessObjectForPictogramElement(getDiagram());
		architecture.getLinks().add(link);

		addContext.setTargetContainer(getDiagram());
		addContext.setNewObject(link);

		return (Connection) getFeatureProvider().addIfPossible(addContext);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext) {
			if (context.getNewObject() instanceof Link) {
				return true;
			}
		}
		return super.canAdd(context);
	}

	@Override
	public PictogramElement add(IAddContext context) {
		final IAddConnectionContext addConContext = (IAddConnectionContext) context;
		final Link addedConnection = (Link) context.getNewObject();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();

		// Create the connection
		final FreeFormConnection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		// Create the line corresponding to the connection
		final Polyline polyline = gaService.createPolyline(connection);
		// final ConnectionDecorator cd =
		// peCreateService.createConnectionDecorator(connection, false, 1.0,
		// true);
		// Draw the arrow on the target side of the connection

		// Setup styles
		polyline.setStyle(StyleUtils.linkShape(getDiagram()));

		// create link and wire it
		link(connection, addedConnection);
		return connection;
	}

}

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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultUpdateDiagramFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.algorithms.styles.StylesPackage;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.dialogs.MessageDialog;

import turnus.common.TurnusExtensions;
import turnus.common.io.Logger;
import turnus.model.architecture.Architecture;
import turnus.model.architecture.CPU;
import turnus.model.architecture.DSP;
import turnus.model.architecture.FPGA;
import turnus.model.architecture.Link;
import turnus.model.architecture.Medium;
import turnus.model.architecture.ProcessingUnit;
import turnus.ui.editor.architecture.diagram.ArchitectureDiagramFeatureProvider;
import turnus.ui.editor.architecture.util.PropertiesUtils;
import turnus.ui.util.EclipseUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class UpdateDiagramFeature extends DefaultUpdateDiagramFeature {

	private static String GLOBAL_VERSION_KEY = "xaf_diagram_version";
	private static int VERSION_1 = 1;
	private static int CURRENT_EDITOR_VERSION = 2;

	private boolean hasDoneChanges = false;

	public UpdateDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}

	@Override 
	public boolean update(IUpdateContext context) {
		if (!(context.getPictogramElement() instanceof Diagram)) {
			Logger.warning("UpdateDiagramFeature has been used with a non Diagram parameter: %s",
					context.getPictogramElement().getClass().toString());
			return false;
		}

		final EditingDomain editingDomain = getDiagramBehavior().getEditingDomain();
		final ResourceSet resourceSet = editingDomain.getResourceSet();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		final Diagram diagram = (Diagram) context.getPictogramElement();
		final Object linkedBo = getBusinessObjectForPictogramElement(diagram);

		final URI diagramUri = diagram.eResource().getURI();
		final URI archUri = diagramUri.trimFileExtension().appendFileExtension(TurnusExtensions.ARCHITECTURE);

		final Architecture architecture;
		if (linkedBo == null || !(linkedBo instanceof Architecture)) {
			if (root.exists(new Path(archUri.toPlatformString(true)))) {
				architecture = (Architecture) resourceSet.getResource(archUri, true).getContents().get(0);
				link(diagram, architecture);
			} else {
				MessageDialog.openWarning(EclipseUtils.getDefaultShell(), "Warning",
						"This diagram has no architecture attached. It should not be used.");
				return false;
			}
		} else {
			architecture = (Architecture) linkedBo;

			final Resource linkedRes = architecture.eResource();
			if (linkedRes == null || !linkedRes.getURI().equals(archUri)) {
				// Particular case. The existing network is not contained in a
				// resource, or its resource has a wrong URI. It can happen if
				// the diagram has been moved or duplicated without the
				// corresponding xaf. The Move/Rename participant should take
				// care of that.

				final Resource res = editingDomain.createResource(archUri.toString());
				res.getContents().add(EcoreUtil.copy(architecture));
				hasDoneChanges = true;
			}
		}

		// Check network validity / initialize diagram.
		if (diagram.getChildren().size() == 0 && architecture.getProcessingUnits().size() > 0) {
			// Diagram is new / empty. We check network validity
			final List<String> updatedNetworkWarnings = new ArrayList<String>();

			// hasDoneChanges |= fixNetwork(network, updatedNetworkWarnings);

			// Initialize the new diagram
			hasDoneChanges |= initializeDiagramFromNetwork(architecture, diagram);

			// Display a synthesis message to user, to tell him what have been
			// automatically modified in the diagram/network he just opened
			if (updatedNetworkWarnings.size() > 0) {
				final StringBuilder message = new StringBuilder(
						"The architecture diagram has been automatically updated:");
				message.append('\n');

				for (final String msg : updatedNetworkWarnings) {
					message.append(msg).append('\n');
				}
				MessageDialog.openInformation(EclipseUtils.getDefaultShell(), "Architecture diagram update",
						message.toString());
			}
		} else {
			checkDiagramValidity(getDiagram());
		}

		updateVersion(diagram);

		return hasDoneChanges;
	}

	/**
	 * Check the given network validity. If errors are detected, an error dialog
	 * is shown with details about issues and how to resolve it
	 */
	private void checkDiagramValidity(final Diagram diagram) {
		int missing = 0, badlinks = 0;
		// Diagram already exists. We check for compatibility between
		// network and diagram
		for (final Shape shape : diagram.getChildren()) {
			final Object bo = getBusinessObjectForPictogramElement(shape);
			if (bo == null) {
				missing++;
			} else if (PropertiesUtils.isExpectedPc(shape, CPU.class)) {
				if (!(bo instanceof CPU)) {
					badlinks++;
				}
			} else if (PropertiesUtils.isExpectedPc(shape, FPGA.class)) {
				if (!(bo instanceof FPGA)) {
					badlinks++;
				}
			} else if (PropertiesUtils.isExpectedPc(shape, DSP.class)) {
				if (!(bo instanceof DSP)) {
					badlinks++;
				}
			} else if (PropertiesUtils.isExpectedPc(shape, Medium.class)) {
				if (!(bo instanceof Medium)) {
					badlinks++;
				}
			}

		}

		if (missing + badlinks != 0) {
			final StringBuilder errorMsg = new StringBuilder("There is error in the diagram:");
			errorMsg.append(System.getProperty("line.separator"));
			if (missing != 0) {
				errorMsg.append(missing);
				errorMsg.append(" shape(s) have no business object linked");
				errorMsg.append(System.getProperty("line.separator"));
			}
			if (badlinks != 0) {
				errorMsg.append(badlinks);
				errorMsg.append(" shape(s) are linked to a business object with the wrong type");
				errorMsg.append(System.getProperty("line.separator"));
			}
			errorMsg.append("Please re-generate the diagram (delete it and re-open the network).");

			MessageDialog.openError(EclipseUtils.getDefaultShell(), "Issues in diagram", errorMsg.toString());
		}
	}

	/**
	 * Add the given business object to the given diagram if the diagram has at
	 * least a feature supporting the type of bo.
	 * 
	 * @param diagram
	 * @param bo
	 * @return
	 */
	private PictogramElement addBoToDiagram(final Diagram diagram, final EObject bo) {
		final AddContext addContext = new AddContext();
		addContext.setTargetContainer(diagram);
		addContext.setNewObject(bo);
		addContext.setLocation(10, 10);

		return getFeatureProvider().addIfPossible(addContext);
	}

	/**
	 * Read the given network, create corresponding graphical representation of
	 * Instance/Port/etc. and append them to the given diagram.
	 * 
	 * @param network
	 * @param diagram
	 * @return
	 */
	private boolean initializeDiagramFromNetwork(final Architecture network, final Diagram diagram) {

		ArchitectureDiagramFeatureProvider featureProvider = (ArchitectureDiagramFeatureProvider) getFeatureProvider();

		for (ProcessingUnit vertex : network.getProcessingUnits()) {
			addBoToDiagram(diagram, vertex);
		}

		for (Medium vertex : network.getMedia()) {
			addBoToDiagram(diagram, vertex);
		}

		ILinkService linkServ = Graphiti.getLinkService();
		for (Link link : network.getLinks()) {
			List<PictogramElement> sourcesPE = linkServ.getPictogramElements(diagram, link.getMedium());
			List<PictogramElement> targetsPE = linkServ.getPictogramElements(diagram, link.getProcessingUnit());

			PictogramElement sourcePe = sourcesPE.get(0);
			PictogramElement targetPe = targetsPE.get(0);

			Anchor srcAncor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) sourcePe);
			Anchor tgtAncor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) targetPe);
			AddConnectionContext ctx = new AddConnectionContext(srcAncor, tgtAncor);
			ctx.setTargetContainer(diagram);
			ctx.setNewObject(link);
			getFeatureProvider().addIfPossible(ctx);
		}

		// Layout the diagram
		final IContext context = new CustomContext();
		final ICustomFeature layoutFeature = featureProvider.getDefaultLayoutFeature();
		if (layoutFeature.canExecute(context)) {
			layoutFeature.execute(context);
		}

		// Reset the buffered selection. Without this, the last object of the
		// diagram will be selected at the first layout() call on any object
		((DiagramBehavior) getDiagramBehavior()).setPictogramElementForSelection(null);

		return true;
	}

	/**
	 * Check if this diagram is outdated and update it according to the version
	 * number stored in its properties.
	 * 
	 * @param diagram
	 */
	private void updateVersion(final Diagram diagram) {
		final Property property = Graphiti.getPeService().getProperty(diagram, GLOBAL_VERSION_KEY);
		if (property == null || property.getValue() == null) {
			// The Diagram has just been created: set version to "current"
			Graphiti.getPeService().setPropertyValue(diagram, GLOBAL_VERSION_KEY,
					String.valueOf(CURRENT_EDITOR_VERSION));
			return;
		}

		final int version = Integer.parseInt(property.getValue());
		if (CURRENT_EDITOR_VERSION == version) {
			// The diagram is up-to-date, nothing to do
			return;
		}

		/*
		 * Eclipse Luna comes with Graphiti 0.11. This new Graphiti version
		 * replaces 'angle' feature with 'rotation' equivalent. Unfortunately,
		 * 'rotation' is not defined in Graphiti model before 0.11. If a xdfdiag
		 * contains an 'angle' value, it will be converted by newer versions to
		 * 'rotation'. As a result, the diagram will become invalid for all
		 * older versions of Orcc. To fix the issue, we force to remove all
		 * usage of 'angle' property. They are not used and were in the default
		 * "COMMON_TEXT" style only because of a copy/paste from Graphiti doc.
		 */
		if (version <= VERSION_1) {
			for (Style style : diagram.getStyles()) {
				if (style.eIsSet(StylesPackage.eINSTANCE.getStyle_Angle())) {
					style.eUnset(StylesPackage.eINSTANCE.getStyle_Angle());
				}
			}
		}

		property.setValue(String.valueOf(CURRENT_EDITOR_VERSION));
	}

}

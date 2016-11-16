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

import static turnus.ui.editor.architecture.util.StyleUtils.LABEL_HEIGHT;
import static turnus.ui.editor.architecture.util.StyleUtils.SHAPE_HEIGHT;
import static turnus.ui.editor.architecture.util.StyleUtils.SHAPE_SEPARATOR;
import static turnus.ui.editor.architecture.util.StyleUtils.SHAPE_WIDTH;

import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import turnus.model.architecture.Architecture;
import turnus.model.architecture.ArchitectureFactory;
import turnus.model.architecture.Medium;
import turnus.ui.editor.architecture.util.ArchitectureUtils;
import turnus.ui.editor.architecture.util.PropertiesUtils;
import turnus.ui.editor.architecture.util.StyleUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class MediumPattern extends AbstractPattern {

	private static final String LABEL_ID = "MEDIUM_LABEL";
	private static final String SEP_ID = "MEDIUM_SEPARATOR";

	public MediumPattern() {
		super(null);
	}

	@Override
	public String getCreateName() {
		return "MEDIUM";
	}

	@Override
	public void preDelete(IDeleteContext context) {
		final PictogramElement pe = context.getPictogramElement();
		if (pe instanceof AnchorContainer) {
			ArchitectureUtils.deleteLinks(getFeatureProvider(), (AnchorContainer) pe);
		}
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean isText = context.getGraphicsAlgorithm() instanceof Text;
		boolean isLabel = PropertiesUtils.isExpectedPc(context.getGraphicsAlgorithm(), LABEL_ID);
		return isText && isLabel;
	}

	@Override
	public String getCreateDescription() {
		return "Create a new medium";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object object) {
		return object instanceof Architecture || object instanceof Medium;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pe) {
		if (isPatternRoot(pe)) {
			return true;
		} else if (PropertiesUtils.isExpectedPc(pe, Medium.class)) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pe) {
		return PropertiesUtils.isExpectedPc(pe, Medium.class);
	}

	@Override
	public int getEditingType() {
		return IDirectEditing.TYPE_TEXT;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		final Medium obj = (Medium) getBusinessObjectForPictogramElement(context.getPictogramElement());
		String name = obj.getName() != null ? obj.getName() : "MEDIUM";
		return name;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Medium obj = (Medium) getBusinessObjectForPictogramElement(pe);
		obj.setName(value);

		updatePictogramElement(pe);
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		final Medium medium = (Medium) getBusinessObjectForPictogramElement(context.getPictogramElement());
		return checkValueValid(value, medium);
	}

	private String checkValueValid(final String value, final Medium medium) {
		if (value.length() < 1) {
			return "Please enter a text to name the MEDIUM.";
		}
		if (!value.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
			return "MEDIUM name must start with a letter, and contains only alphanumeric characters";
		}
		final Architecture network = (Architecture) getBusinessObjectForPictogramElement(getDiagram());
		for (final Medium vertex : network.getMedia()) {
			if (vertex.getName().equals(value) && vertex != medium) {
				return "The architecture already contains a medium of the same name (" + value + ")";
			}
		}

		// null -> value is valid
		return null;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		// We create the instance in a diagram
		if (context.getTargetContainer() instanceof Diagram) {
			// A network is associated to this diagram
			if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Architecture) {
				return true;
			}
		}
		return true;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Architecture architecture = (Architecture) getBusinessObjectForPictogramElement(getDiagram());

		Medium object = ArchitectureFactory.eINSTANCE.createMedium();
		object.setName(ArchitectureUtils.uniqueMediumName(architecture, "MEDIUM"));

		// Request adding the shape to the diagram
		addGraphicalRepresentation(context, object);

		// Activate direct editing on creation. A label input appear to allow
		// user to type a name for the instance
		getFeatureProvider().getDirectEditingInfo().setActive(true);

		return new Object[] { object };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			return isMainBusinessObjectApplicable(context.getNewObject());
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		final Diagram targetDiagram = (Diagram) context.getTargetContainer();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();

		final Medium addedDomainObject = (Medium) context.getNewObject();

		// Add the new Instance to the current Network
		final Architecture architecture = (Architecture) getBusinessObjectForPictogramElement(getDiagram());
		architecture.getMedia().add(addedDomainObject);

		// Create the container shape
		final ContainerShape topLevelShape = peCreateService.createContainerShape(targetDiagram, true);
		PropertiesUtils.setPeIdentifier(topLevelShape, Medium.class);

		// Create the container graphic
		final Ellipse roundedRectangle = gaService.createPlainEllipse(topLevelShape);
		roundedRectangle.setStyle(StyleUtils.mediumShape(getDiagram()));
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), SHAPE_WIDTH, SHAPE_HEIGHT);

		// The text label for Instance name
		final Text text = gaService.createPlainText(roundedRectangle);
		PropertiesUtils.setPeIdentifier(text, LABEL_ID);
		// Set properties on instance label
		text.setStyle(StyleUtils.mediumText(getDiagram()));
		gaService.setLocationAndSize(text, 0, 0, SHAPE_WIDTH, LABEL_HEIGHT);

		if (addedDomainObject.getName() != null) {
			text.setValue(addedDomainObject.getName());
		}

		// The line separator
		final int[] xy = { 0, LABEL_HEIGHT, SHAPE_WIDTH, LABEL_HEIGHT };
		final Polyline line = gaService.createPlainPolyline(roundedRectangle, xy);
		PropertiesUtils.setPeIdentifier(line, SEP_ID);
		line.setLineWidth(SHAPE_SEPARATOR);

		// Configure direct editing
		IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
		directEditingInfo.setPictogramElement(topLevelShape);
		directEditingInfo.setGraphicsAlgorithm(text);
		directEditingInfo.setMainPictogramElement(topLevelShape);

		// We link graphical representation and domain model object
		link(topLevelShape, addedDomainObject);

		// Create anchor
		peCreateService.createChopboxAnchor(topLevelShape);

		// create an additional box relative anchor at middle-right
		BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor(topLevelShape);
		boxAnchor.setRelativeWidth(0.5);
		boxAnchor.setRelativeHeight(0.0);
		boxAnchor.setReferencedGraphicsAlgorithm(roundedRectangle);

		// assign a rectangle graphics algorithm for the box relative anchor
		gaService.createPlainRectangle(boxAnchor);

		return topLevelShape;
	}

	@Override
	public boolean update(IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();

		if (PropertiesUtils.isExpectedPc(pe, Medium.class)) {
			final Text text = (Text) PropertiesUtils.findPcFromIdentifier(pe, LABEL_ID);
			if (text == null) {
				return false;
			}

			final Medium medium = (Medium) getBusinessObjectForPictogramElement(pe);
			if (!medium.getName().equals(text.getValue())) {
				text.setValue(medium.getName());
				// Do not force refinement update in case of simply renaming
				return true;
			}

			return true;
		}

		return super.update(context);
	}

}

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
package turnus.ui.widget.graphiti;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import turnus.ui.editor.architecture.diagram.ArchitectureDiagramFeatureProvider;

/**
 * This is a base class for all property sections in a graphiti diagram editor. It
 * configure some member variables and set the current PictogramElement and
 * business object for all subclasses.
 * 
 * @author Antoine Lorence
 * 
 */
abstract public class AbstractDiagramSection extends GFPropertySection implements ITabbedPropertyConstants {

	protected TabbedPropertySheetWidgetFactory widgetFactory;

	private EObject businessObject;
	private PictogramElement pictogramElement;
	private ArchitectureDiagramFeatureProvider featureProvider;

	protected Composite formBody;

	protected final Color disabledFieldBGColor;
	protected final Color errorColor;

	public AbstractDiagramSection() {
		disabledFieldBGColor = new Color(Display.getCurrent(), new RGB(230, 230, 230));
		errorColor = new Color(Display.getCurrent(), new RGB(242, 152, 152));
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		widgetFactory = getWidgetFactory();

		final Form form = widgetFactory.createForm(parent);
		form.setText(getFormText());
		widgetFactory.decorateFormHeading(form);
		formBody = form.getBody();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		pictogramElement = getSelectedPictogramElement();
		businessObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		featureProvider = (ArchitectureDiagramFeatureProvider) getDiagramTypeProvider().getFeatureProvider();
	}

	// =============
	// Getters
	// =============
	protected EObject getSelectedBusinessObject() {
		return businessObject;
	}

	protected ArchitectureDiagramFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	protected <T extends IPattern> T getPattern(final PictogramElement pe, final Class<T> patternType) {
		final IPattern pattern = getFeatureProvider().getPatternForPictogramElement(pe);
		if (patternType.isInstance(pattern)) {
			return patternType.cast(pattern);
		}
		return null;
	}

	@Override
	public void refresh() {
		readValuesFromModels();
	}

	/**
	 * Executes {@link #writeValuesToModel()} inside a Command suitable for
	 * transactional edition of domain models
	 */
	final protected void writeValuesInTransaction(final Widget widget) {

		// Execute the method in a write transaction, because it will modify the
		// models
		final TransactionalEditingDomain editingDomain = getDiagramContainer().getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				writeValuesToModel(widget);
			}
		});
	}

	/**
	 * Read values from EMF models and write it to the corresponding widget.
	 */
	protected abstract void readValuesFromModels();

	/**
	 * Read value from the given widget and write it to the corresponding EMF
	 * model.
	 * 
	 * @param widget
	 */
	protected abstract void writeValuesToModel(final Widget widget);

	/**
	 * Check if the value in the given widget is valid. If not, returns a
	 * message explaining why. If it is valid, this method must return null
	 * 
	 * @param widget
	 * @return null if given widget value is valid, an error message instead
	 */
	protected String checkValueValid(final Widget widget) {
		return null;
	}

	protected abstract String getFormText();
}

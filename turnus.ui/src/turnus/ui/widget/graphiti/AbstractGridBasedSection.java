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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * This is a base class for property sections which need to display a list of
 * label/input. It configure the main layout in GridLayout.
 * 
 * @author Antoine Lorence
 * 
 */
public abstract class AbstractGridBasedSection extends AbstractDiagramSection {

	protected GridData fillHorizontalData;

	private boolean listenerSet = false;

	private final Map<Widget, Object> initialialValues = new HashMap<Widget, Object>();

	/**
	 * See {@link #addHiddenTextFieldToForm(Composite)} javadoc for information
	 */
	private Text fake;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final GridLayout gridLayout = new GridLayout(2, false);
		fillHorizontalData = new GridData(SWT.FILL, SWT.BEGINNING, true, true);

		// Set GridLayout as default for a properties section
		formBody.setLayout(gridLayout);

		addHiddenTextFieldToForm(formBody);
	}

	@Override
	public void refresh() {
		super.refresh();

		final Control[] widgetList = formBody.getChildren();

		// Update initial values
		for (final Control widget : widgetList) {
			initialialValues.put(widget, getValue(widget));
		}

		// Fix related to a bug. See addHiddenTextFieldToForm() javadoc
		if (fake != null && !fake.isDisposed()) {
			fake.setFocus();
		}

		// Set listeners if not already set
		if (listenerSet)
			return;
		for (final Control widget : widgetList) {

			widget.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					final Widget widget = e.widget;
					if (checkValueValid(e.widget) == null && !getValue(widget).equals(initialialValues.get(widget))) {
						writeValuesInTransaction(widget);
						initialialValues.put(widget, getValue(widget));
					}
				}
			});

			widget.addTraverseListener(new TraverseListener() {
				@Override
				public void keyTraversed(TraverseEvent e) {
					// User press the RETURN key
					if (e.detail == SWT.TRAVERSE_RETURN && checkValueValid(e.widget) == null) {
						final Widget widget = e.widget;
						writeValuesInTransaction(widget);
						initialialValues.put(widget, getValue(widget));
					}
				}
			});

			if (widget instanceof Text) {
				widget.addKeyListener(new KeyListener() {

					@Override
					public void keyReleased(KeyEvent e) {
						final String validMsg = checkValueValid(e.widget);
						if (validMsg != null) {
							widget.setBackground(errorColor);
							widget.setToolTipText(validMsg);
						} else {
							widget.setBackground(null);
							widget.setToolTipText(null);
						}
					}

					@Override
					public void keyPressed(KeyEvent e) {
					}
				});
			}
		}

		listenerSet = true;
	}

	@Override
	public void dispose() {
		super.dispose();
		listenerSet = false;
	}

	/**
	 * Return the value contained by a given widget. This method must be able to
	 * read value from all widgets used across properties pages.
	 * 
	 * @param widget
	 * @return The value
	 */
	protected Object getValue(Widget widget) {
		if (widget instanceof Text) {
			return ((Text) widget).getText();
		} else if (widget instanceof Button) {
			return ((Button) widget).getSelection();
		}
		// Implements this getter for other kind of widgets
		return null;
	}

	/**
	 * I need to apologies for that... Because of the Orcc issue #68 related to
	 * the eclipse/SWT bug 383750, Mac OS users had problems when focusing on a
	 * Text field different from the first on the page.
	 * 
	 * To avoid that, we create a hidden Text, and we ensure this text is
	 * focused when refresh() method is called. With that trick, before user
	 * click the first time on a field, this one has take the (wrong) value set
	 * by SWT on first focus.
	 * 
	 * This awful workaround should be deleted if the bug 383750 on
	 * bugs.eclipse.org is fixed.
	 * 
	 * @param formBody
	 * @see <a href="https://github.com/orcc/orcc/issues/68">https://github.com/
	 *      orcc/orcc/issues/68</a>
	 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=383750">https
	 *      ://bugs.eclipse.org/bugs/show_bug.cgi?id=383750</a>
	 */
	private void addHiddenTextFieldToForm(final Composite formBody) {
		// This fix applies only on Mac OS systems
		if (!Platform.getOS().equals(Platform.OS_MACOSX)) {
			return;
		}

		// The grid data used to reduce space of the fake Text field
		final GridData hiddenData = new GridData(0, 0);
		// It takes 2 columns spaces in the table
		hiddenData.horizontalSpan = 2;

		// The fake Text field
		fake = widgetFactory.createText(formBody, "");
		fake.setLayoutData(hiddenData);

		// Here is the trick. To hide the fake Text field, we change top margin
		// value to move the content up, and bottom margin to prevent from
		// cropping the end of the table content. This is very bad, but it
		// works.
		((GridLayout) formBody.getLayout()).marginHeight = -5; // default was 5
		((GridLayout) formBody.getLayout()).marginBottom = 10; // default was 0
	}
}

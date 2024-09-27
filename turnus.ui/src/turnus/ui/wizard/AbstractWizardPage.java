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
package turnus.ui.wizard;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import turnus.ui.widget.Widget;

/**
 * This class defines an abstract WizardPage that makes use of the Widget
 * 
 * @author Simone Casale Brunet
 *
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractWizardPage extends WizardPage {

	private class Listener implements ModifyListener {

		@Override
		public void modifyText(ModifyEvent e) {
			setPageComplete(isPageComplete());
		}

	}

	/**
	 * Create a new wizard page
	 * 
	 * @param pageName
	 *            the page name
	 */
	protected AbstractWizardPage(String pageName) {
		super(pageName);
	}

	/** the collection of registered widgets */
	private Collection<Widget> widgets = new HashSet<>();
	private final Listener listener = new Listener();

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;

		createWidgets(container);

		setControl(container);
	}

	/**
	 * Register a new widget on this page
	 * 
	 * @param widget
	 *            the widget
	 */
	protected void addWidget(Widget widget) {
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	    widget.setLayoutData(gridData);
		widget.addModifyListener(listener);
		widgets.add(widget);
	}

	/**
	 * Create the widget on this page
	 * 
	 * @param container
	 *            the parent composite where widgets can be added
	 */
	protected abstract void createWidgets(Composite container);

	public boolean isPageComplete() {
		boolean complete = true;
		setErrorMessage(null);
		for (Widget w : widgets) {
			if (w.isEnabled() && !w.isValid()) {
				setErrorMessage(w.getErrorMessage());
				complete = false;
			}
		}

		return complete;
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		if (errorMessage != null) {
			String actualError = super.getErrorMessage();
			errorMessage = actualError != null ? actualError.concat("; ").concat(errorMessage) : errorMessage;
		}
		super.setErrorMessage(errorMessage);
	}

}

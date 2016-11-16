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
package turnus.ui.widget.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import turnus.ui.Icon;
import turnus.ui.widget.Widget;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class AbstractTitleDialog extends TitleAreaDialog {

	private Button runButton;
	private List<Widget<?>> widgets = new ArrayList<>();
	private InternalListener listener = new InternalListener();
	private final String title;
	private final String subTitle;

	private class InternalListener implements ModifyListener {

		@Override
		public void modifyText(ModifyEvent e) {
			updateRunButtonStatus();
		}

	}

	public boolean isHelpAvailable() {
		return false;
	}

	private void updateRunButtonStatus() {
		boolean valid = isValid();
		runButton.setEnabled(valid);
		setErrorMessage(getErrorMessage());
	}

	public String getErrorMessage() {
		String mex = "";
		for (Widget<?> w : widgets) {
			if (!w.isValid()) {
				String error = w.getErrorMessage();
				if (error != null && !error.isEmpty()) {
					mex += "; " + error;
				}
			}
		}
		if (mex.isEmpty()) {
			return null;
		}
		return mex.replaceFirst("; ", "");
	}

	protected boolean isValid() {
		for (Widget<?> w : widgets) {
			if (!w.isValid()) {
				return false;
			}
		}
		return true;
	}

	protected void addWidget(Widget<?> widget) {
		widgets.add(widget);
		widget.addModifyListener(listener);
	}
	
	private final String runButtonName;
	
	public AbstractTitleDialog(Shell parentShell, String runButtonName, String title, String subTitle) {
		super(parentShell);
		this.title = title;
		this.subTitle = subTitle;
		this.runButtonName = runButtonName;
	}

	public AbstractTitleDialog(Shell parentShell, String title, String subTitle) {
		this(parentShell, "Run", title, subTitle);
	}

	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		Button button = super.createButton(parent, id, label, defaultButton);
		if (id == IDialogConstants.OK_ID) {
			runButton = button;
			runButton.setText(runButtonName);
			runButton.setImage(Icon.getImage(Icon.TICK));
			updateRunButtonStatus();
		} else if (id == IDialogConstants.CANCEL_ID) {
			button.setImage(Icon.getImage(Icon.CROSS));
		}
		return button;
	}

	@Override
	public void create() {
		super.create();
		setTitle(title);
		setMessage(subTitle, IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(1, false);
		container.setLayout(layout);

		createOptionWidgets(container);

		return area;
	}

	/**
	 * Create the option widgets
	 * 
	 * @param composite
	 *            the parent composite to store the widgets
	 */
	protected abstract void createOptionWidgets(Composite composite);

	@Override
	protected boolean isResizable() {
		return true;
	}

	protected abstract void performRun();

	@Override
	protected void okPressed() {
		super.okPressed();
		performRun();
	}

}

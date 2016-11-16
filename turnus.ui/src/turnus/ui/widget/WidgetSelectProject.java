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
package turnus.ui.widget;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import turnus.common.configuration.Option;
import turnus.common.util.EcoreUtils;
import turnus.ui.Activator;
import turnus.ui.Icon;
import turnus.ui.util.WorkbenchContentProvider;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetSelectProject extends Widget<String> {

	/** the project nature id */
	private final String natureId;

	private Label lbl;
	/** the widget text */
	private Text wtext;
	/** the widget error icon */
	private Label errorIcon;
	/** the browse button */
	private Button browse;

	public WidgetSelectProject(Option<String> option, String natureId, String initialValue, Composite parent) {
		this(option.name(), option.description(), natureId, initialValue, parent);
	}

	public WidgetSelectProject(String text, String toolTip, String natureId, String initialValue, Composite parent) {
		super(text, toolTip, initialValue, 4, parent);
		this.natureId = natureId;
		setValue(initialValue, true);
	}

	@Override
	protected void createWidgets(final String text, final String toolTip, String initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setText(text.concat(":"));
		lbl.setToolTipText(toolTip);

		wtext = new Text(this, SWT.BORDER | SWT.SINGLE);
		wtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		wtext.setEnabled(false);
		wtext.setEditable(false);

		browse = new Button(this, SWT.PUSH);
		browse.setText("&Browse...");
		browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ElementTreeSelectionDialog tree = new ElementTreeSelectionDialog(getShell(),
						WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(), new WorkbenchContentProvider());
				tree.setAllowMultiple(false);
				tree.setInput(ResourcesPlugin.getWorkspace().getRoot());

				// filter the projects by the nature (if given)
				tree.addFilter(new ViewerFilter() {

					@Override
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (natureId == null) {
							return true;
						} else if (element instanceof IProject) {
							try {
								return ((IProject) element).getNature(natureId) != null;
							} catch (CoreException e) {
							}
						}

						return false;
					}
				});

				IProject project = getIProject();
				if (project != null) {
					tree.setInitialSelection(project);
				}

				tree.setMessage(text);
				tree.setTitle("Choose a project");
				tree.setValidator(new ISelectionStatusValidator() {

					@Override
					public IStatus validate(Object[] selection) {
						if (selection.length == 1) {
							if (selection[0] instanceof IProject) {
								return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
							} else {
								return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Only projects can be selected");
							}
						}
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No project selected.");
					}
				});

				// opens the dialog
				if (tree.open() == Window.OK) {
					project = (IProject) tree.getFirstResult();
					setValue(project.getName(), true);
				}
			}
		});

		errorIcon = new Label(this, SWT.NONE);
		errorIcon.setImage(Icon.getImage(Icon.EXCLAMATION_RED));
		errorIcon.setVisible(false);

	}

	/**
	 * Get the project
	 * 
	 * @return the project if it exists, <code>null</code> otherwise
	 */
	public IProject getIProject() {
		return EcoreUtils.getProject(getValue());
	}

	@Override
	public String getValueAsString() {
		return getValue();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		browse.setEnabled(enabled);
		errorIcon.setVisible(enabled && !isValid());
	}

	@Override
	public void setRawValue(String value) {
		setValue(value);
	}

	@Override
	public void setText(String text) {
		lbl.setText(text);
		super.setText(text);
	}

	@Override
	public void setTooltip(String text) {
		lbl.setToolTipText(text);
		wtext.setToolTipText(text);
		super.setTooltip(text);
	}

	@Override
	public void setValue(String value, boolean redraw) {
		IProject pojo = null;
		if (value != null && !value.isEmpty()) {
			pojo = EcoreUtils.getProject(value);
		}

		if (pojo == null) {
			wtext.setText("");
			String error = "\"" + text + "\" does not contains a project";
			errorIcon.setVisible(true);
			errorIcon.setToolTipText(error);
			setErrorMessage(error);
			value = null;
		} else {
			wtext.setText(pojo.getName());
			try {
				if (!pojo.hasNature(natureId)) {
					String error = "\"" + text + "\" contains an invalid project";
					errorIcon.setVisible(true);
					errorIcon.setToolTipText(error);
					setErrorMessage(error);
					value = null;
				} else {
					errorIcon.setVisible(false);
					errorIcon.setToolTipText("");
					setErrorMessage(null);
				}
			} catch (Exception e) {
				String error = "\"" + text + "\" contains an invalid project";
				errorIcon.setVisible(true);
				errorIcon.setToolTipText(error);
				setErrorMessage(error);
				value = null;
			}
		}

		super.setValue(value, redraw);
	}

}

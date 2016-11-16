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

import java.util.Comparator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;

import turnus.common.configuration.Option;
import turnus.common.util.EcoreUtils;
import turnus.ui.Activator;
import turnus.ui.Icon;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetSelectResource extends Widget<String> {

	/**
	 * Create a Filtered Project Resource Dialog. Resources that match the given
	 * file extension pattern are listed.
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	public class FilteredRefinementDialog extends FilteredItemsSelectionDialog {

		/**
		 * Object Comparator class
		 * 
		 * @author Simone Casale Brunet
		 * 
		 */
		private class ResourceComparator implements Comparator<Object> {

			@Override
			public int compare(Object o1, Object o2) {
				return getElementName(o1).compareTo(getElementName(o2));
			}

		}

		/**
		 * Resource Filter class
		 * 
		 * @author Simone Casale Brunet
		 * 
		 */
		private class ResourceFilter extends ItemsFilter {

			public ResourceFilter() {
				super(new SearchPattern(SearchPattern.RULE_PATTERN_MATCH));
				String pattern = "*" + patternMatcher.getPattern() + "*";
				patternMatcher.setPattern(pattern);
			}

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}

			@Override
			public boolean matchItem(Object item) {
				String name = getElementName(item);
				return matches(name);
			}
		}

		private static final String DIALOG_SETTINGS = "co.turnus.widgets.util.FilteredRefinementDialog"; //$NON-NLS-1$

		private ResourceComparator comparator;

		private String fileExt;

		private IProject project;

		/**
		 * Creates a new filtered refinement dialog for project resources.
		 * 
		 * @param project
		 * @param shell
		 */
		public FilteredRefinementDialog(IProject project, Shell shell, String fileExt) {
			super(shell);
			this.project = project;
			this.fileExt = fileExt.startsWith(".") ? fileExt.substring(1) : fileExt;
			comparator = new ResourceComparator();
		}

		protected void addChildren(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, String path,
				IResource resource) throws CoreException {
			if (resource.getType() == IResource.FOLDER) {
				IFolder folder = (IFolder) resource;
				path = path + resource.getName() + '/';
				for (IResource member : folder.members()) {
					addChildren(contentProvider, itemsFilter, path, member);
				}
			} else if (fileExt.equals(resource.getFileExtension())) {
				String resourceName = resource.getFullPath().lastSegment();
				contentProvider.add(path + resourceName, itemsFilter);
			}
		}

		@Override
		protected Control createExtendedContentArea(Composite parent) {
			return null;
		}

		@Override
		protected ItemsFilter createFilter() {
			return new ResourceFilter();
		}

		@Override
		protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
				IProgressMonitor progressMonitor) throws CoreException {

			for (IResource resource : getProject().members()) {
				addChildren(contentProvider, itemsFilter, "", resource);
			}

		}

		@Override
		protected IDialogSettings getDialogSettings() {
			IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);

			if (settings == null) {
				settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
			}

			return settings;
		}

		@Override
		public String getElementName(Object item) {
			return String.valueOf(item);
		}

		@Override
		protected Comparator<?> getItemsComparator() {
			return comparator;
		}

		protected IProject getProject() {
			return project;
		}

		@Override
		protected IStatus validateItem(Object item) {
			return Status.OK_STATUS;
		}
	}

	/** the project */
	private IProject project;
	/** the resource (i.e. file) extension without "." (e.g. "txt") */
	private final String fileExtesion;

	private Label lbl;
	/** the widget text */
	private Text wtext;
	/** the widget button */
	private Button browse;
	/** the widget error icon */
	private Label errorIcon;

	public WidgetSelectResource(Option<String> option, String fileExtesion, String initialValue, Composite parent) {
		this(option.name(), option.description(), fileExtesion, initialValue, parent);
	}

	public WidgetSelectResource(String text, String toolTip, String fileExtesion, String initialValue,
			Composite parent) {
		super(text, toolTip, initialValue, 4, parent);
		this.fileExtesion = fileExtesion;
		setValue(initialValue, true);
	}

	@Override
	protected void createWidgets(final String text, final String toolTip, String initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setFont(getFont());
		lbl.setText(text.concat(":"));
		lbl.setToolTipText(toolTip);

		wtext = new Text(this, SWT.BORDER | SWT.SINGLE);
		wtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		wtext.setToolTipText(toolTip);
		wtext.setEnabled(false);
		wtext.setEditable(false);

		browse = new Button(this, SWT.PUSH);
		browse.setText("&Browse...");
		browse.setEnabled(false);
		browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setValue(selectResource(), true);
			}
		});

		errorIcon = new Label(this, SWT.NONE);
		errorIcon.setImage(Icon.getImage(Icon.EXCLAMATION_RED));
		errorIcon.setVisible(false);
	}

	@Override
	public String getValueAsString() {
		return getValue();
	}

	/**
	 * Select a resource dialog window
	 * 
	 * @return the resource name, <code>null</code> otherwise
	 */
	private String selectResource() {
		if (project != null && project.exists()) {
			FilteredRefinementDialog dialog = new FilteredRefinementDialog(project, getShell(), fileExtesion);
			dialog.setTitle("Select a project resource");
			dialog.setMessage("&Select an existing resource:");
			String refinement = wtext.getText();
			if (refinement != null) {
				dialog.setInitialPattern(refinement);
			}
			int result = dialog.open();
			if (result == Window.OK) {
				return (String) dialog.getFirstResult();
			}
		}
		return null;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		browse.setEnabled(enabled && project != null);
		errorIcon.setVisible(enabled && !isValid());
	}

	/**
	 * Set the project where resources are located
	 * 
	 * @param project
	 *            the project
	 */
	public void setIProject(IProject project) {
		project = project != null && project.isAccessible() ? project : null;
		boolean notify = this.project != project;
		this.project = project;
		browse.setEnabled(isEnabled() && project != null);

		String value = getValue();
		if (project == null || value.isEmpty()) {
			String error = "\"" + text + "\" contains an invalid resource file";
			errorIcon.setVisible(true);
			errorIcon.setToolTipText(error);
			setErrorMessage(error);
		} else {
			if (!project.getFile(value).exists()) {
				String error = "\"" + text + "\" contains an invalid resource file for the given project";
				errorIcon.setVisible(true);
				errorIcon.setToolTipText(error);
				setErrorMessage(error);
			} else {
				errorIcon.setVisible(false);
				errorIcon.setToolTipText("");
				setErrorMessage(null);
			}
		}

		if (notify) {
			notifyListeners();
		}
	}

	/**
	 * Set the project where resources are located
	 * 
	 * @param projectName
	 *            the project name
	 */
	protected void setProject(String projectName) {
		if (projectName == null || projectName.isEmpty()) {
			setIProject(null);
		} else {
			setIProject(EcoreUtils.getProject(projectName));
		}
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

	public void setValue(String value, boolean redraw) {
		if (value == null) {
			wtext.setText("");
		} else {
			wtext.setText(value);
		}

		if (value != null) {
			if (project == null || !project.getFile(value).exists()) {
				String error = "\"" + text + "\" contains an invalid resource file";
				errorIcon.setVisible(true);
				errorIcon.setToolTipText(error);
				setErrorMessage(error);
			} else {
				setErrorMessage(null);
				errorIcon.setVisible(false);
				errorIcon.setToolTipText("");
			}
		} else {
			String error = "\"" + text + "\" contains an invalid resource file";
			errorIcon.setVisible(true);
			errorIcon.setToolTipText(error);
			setErrorMessage(error);
		}

		super.setValue(value, redraw);
	}

	public IFile getIFile() {
		if (project != null && value != null) {
			return project.getFile(value);
		}
		return null;
	}

}

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
package turnus.ui.widget.launch;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import turnus.common.TurnusRuntimeException;
import turnus.common.configuration.Option;
import turnus.ui.Icon;
import turnus.ui.widget.launch.ILaunchWidget;
import turnus.ui.widget.launch.LaunchWidgetSelectProject;
import turnus.ui.widget.launch.LaunchWidgetSelectResource;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class AbstractLaunchTab extends AbstractLaunchConfigurationTab {

	/** the icon identifier */
	private String icon;
	/** the tab name */
	private String name;

	Map<String, ILaunchWidget<?>> widgetsMap = new HashMap<>();

	private final ModifyListener listener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	};

	public AbstractLaunchTab(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	protected void addWidget(ILaunchWidget<?> widget) {
		String id = widget.getId();
		if (widgetsMap.containsKey(id)) {
			throw new TurnusRuntimeException("A widget with id \"" + id + "\" is already registered in " + this);
		}
		widgetsMap.put(id, widget);
		widget.addModifyListener(listener);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);

		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 0;
		composite.setLayout(layout);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		composite.setLayoutData(data);

		createOptionWidgets(composite);

	}

	/**
	 * Create the option widgets
	 * 
	 * @param composite
	 *            the parent composite to store the widgets
	 */
	protected abstract void createOptionWidgets(Composite composite);

	@Override
	public Image getImage() {
		return Icon.getImage(icon);
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Get the widget associated to the given option
	 * 
	 * @param option
	 *            the option
	 * @return the widget, <code>null</code> if it does not exist
	 */
	public ILaunchWidget<?> getWidget(Option<?> option) {
		return getWidget(option.longName());
	}

	public ILaunchWidget<?> getWidget(String identifier) {
		return widgetsMap.get(identifier);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			for (ILaunchWidget<?> widget : widgetsMap.values()) {
				widget.initializeFrom(configuration);
			}
			updateComposableOptions();
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean valid = true;
		setErrorMessage(null);

		for (ILaunchWidget<?> widget : widgetsMap.values()) {
			if (!widget.isValid()) {
				valid = false;
				setErrorMessage(widget.getErrorMessage());
			}
		}
		return valid;

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		for (ILaunchWidget<?> widget : widgetsMap.values()) {
			try {
				widget.performApply(configuration);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		updateComposableOptions();

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/**
	 * If {@code errorMessage != null} append an error message, otherwise reset
	 */
	@Override
	public void setErrorMessage(String errorMessage) {
		if (errorMessage != null) {
			String actualError = super.getErrorMessage();
			errorMessage = actualError != null ? actualError.concat("; ").concat(errorMessage) : errorMessage;
		}
		super.setErrorMessage(errorMessage);
	}

	@Override
	public String toString() {
		return "[LAUNCH CONFIGURATION TAB] " + name;
	}

	/**
	 * Update the options composable after a {@link #performAplly} or
	 * {@link #initializeFrom}
	 */
	protected abstract void updateComposableOptions();

	@Override
	public void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog();

		// update project and resources
		for (ILaunchWidget<?> widget : widgetsMap.values()) {
			if (widget instanceof LaunchWidgetSelectResource) {
				LaunchWidgetSelectResource resWidget = (LaunchWidgetSelectResource) widget;
				String projectWidgetId = resWidget.getProjectWidgetId();
				if (widgetsMap.containsKey(projectWidgetId)) {
					LaunchWidgetSelectProject projWidget = (LaunchWidgetSelectProject) getWidget(projectWidgetId);
					resWidget.setIProject(projWidget.getIProject());
				}
			}
		}
	}

}

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

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

import turnus.common.configuration.Option;
import turnus.ui.widget.WidgetSelectPath;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class LaunchWidgetSelectPath extends WidgetSelectPath implements ILaunchWidget<File> {

	private final String id;

	public LaunchWidgetSelectPath(Option<File> option, boolean forceEmpty, File initialValue, Composite parent) {
		super(option, forceEmpty, initialValue, parent);
		id = option.longName();
	}

	public LaunchWidgetSelectPath(Option<File> option, File initialValue, Composite parent) {
		this(option, DEFAULT_FORCE_EMPTY, initialValue, parent);
	}

	public LaunchWidgetSelectPath(String id, String text, String toolTip, boolean forceEmpty, File initialValue,
			Composite parent) {
		super(text, toolTip, forceEmpty, initialValue, parent);
		this.id = id;
	}

	public LaunchWidgetSelectPath(String id, String text, String toolTip, File initialValue, Composite parent) {
		this(id, text, toolTip, DEFAULT_FORCE_EMPTY, initialValue, parent);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		Util.initializeFrom(this, configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) throws CoreException {
		Util.performApply(this, configuration);
	}

}

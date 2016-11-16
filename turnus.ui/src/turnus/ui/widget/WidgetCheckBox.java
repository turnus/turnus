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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import turnus.common.configuration.Option;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetCheckBox extends Widget<Boolean> {

	/** the button check box **/
	private Button checkBox;

	public WidgetCheckBox(Option<Boolean> option, Boolean initialValue, Composite parent) {
		this(option.name(), option.description(), initialValue, parent);
	}

	public WidgetCheckBox(String text, String toolTip, Boolean initialValue, Composite parent) {
		super(text, toolTip, initialValue, 1, parent);
		setValue(initialValue, true);
	}

	@Override
	protected void createWidgets(String text, String toolTip, Boolean initialValue) {
		checkBox = new Button(this, SWT.CHECK);
		checkBox.setText(text);
		checkBox.setToolTipText(toolTip);
		checkBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setValue(checkBox.getSelection(), false);
			}
		});
	}

	@Override
	public String getValueAsString() {
		return Boolean.toString(getValue());
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
		checkBox.setEnabled(enabled);
		super.setEnabled(enabled);
	}

	@Override
	public void setErrorMessage(String message) {
		super.setErrorMessage(null);
	}

	@Override
	public void setRawValue(String value) {
		if (value == null || value.isEmpty()) {
			setValue(false, true);
		} else {
			try {
				Boolean v = Boolean.parseBoolean(value);
				setValue(v, true);
			} catch (Exception e) {
				setValue(false, true);
			}
		}
	}

	@Override
	public void setText(String text) {
		checkBox.setText(text);
		super.setText(text);
	}

	@Override
	public void setTooltip(String text) {
		checkBox.setToolTipText(text);
		super.setTooltip(text);
	}

	@Override
	public void setValue(Boolean value, boolean redraw) {
		checkBox.setSelection(value);
		super.setValue(value, redraw);
	}

}

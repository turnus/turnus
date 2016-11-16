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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import turnus.common.configuration.Option;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetText extends Widget<String> {

	private Label lbl;
	private Text textw;
	private String[] unvalidText;

	public WidgetText(Option<String> option, String initialValue, Composite parent) {
		this(option.name(), option.description(), initialValue, parent);
	}

	public WidgetText(Option<String> option, String initialValue, String[] unvalidText, Composite parent) {
		this(option.name(), option.description(), initialValue, unvalidText, parent);
	}

	public WidgetText(String text, String toolTip, String initialValue, Composite parent) {
		this(text, toolTip, initialValue, new String[0], parent);
	}

	public WidgetText(String text, String toolTip, String initialValue, String[] unvalidText, Composite parent) {
		super(text, toolTip, initialValue, 3, parent);
		this.unvalidText = unvalidText;
		setValue(value != null ? value : initialValue, true);
	}

	@Override
	protected void createWidgets(String text, String toolTip, String initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setText(text.concat(":"));
		lbl.setToolTipText(toolTip);

		textw = new Text(this, SWT.MULTI);
		textw.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textw.setToolTipText(toolTip);
		textw.setEditable(true);
		textw.setText(initialValue);

		textw.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String text = textw.getText();
				if (!text.equals(getValueAsString())) {
					setValue(text, true);
				}
			}
		});
	}

	@Override
	public String getValueAsString() {
		return value != null ? value : "";
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		textw.setEnabled(enabled);
	}

	@Override
	public void setRawValue(String value) {
		if (value == null) {
			textw.setText("");
		} else {
			textw.setText(value);
		}
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
		textw.setToolTipText(text);
		super.setTooltip(text);
	}

	public void setUnvalidText(String... text) {
		unvalidText = text.clone();
	}

	@Override
	public void setValue(String value, boolean redraw) {
		if (value == null || value.isEmpty()) {
			String error = "Widget \"" + text + "\" has an empty value";
			setErrorMessage(error);
			value = null;
		} else {
			setErrorMessage(null);
			for (String t : unvalidText) {
				if (value.equals(t)) {
					String error = "Widget \"" + text + "\" has a unvalid value";
					setErrorMessage(error);
					value = null;
					break;
				}
			}
		}

		super.setValue(value, redraw);
	}

}

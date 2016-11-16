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

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import turnus.common.configuration.Option;
import turnus.ui.Icon;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetComboBox extends Widget<String> {

	/** the set of choices */
	protected String[] choices;

	private Label lbl;
	/** the combo-box composite */
	private Combo comboBox;
	/** the error icon */
	private Label errorIcon;

	public WidgetComboBox(Option<String> option, String[] choices, Composite parent) {
		this(option.name(), option.description(), choices, parent);
	}

	public WidgetComboBox(Option<String> option, String[] choices, String initialValue, Composite parent) {
		this(option.name(), option.description(), choices, initialValue, parent);
	}

	public WidgetComboBox(String text, String toolTip, String[] choices, Composite parent) {
		this(text, toolTip, choices, choices[0], parent);
	}

	public WidgetComboBox(String text, String toolTip, String[] choices, String initialValue, Composite parent) {
		super(text, toolTip, initialValue, 3, parent);
		this.choices = choices;
		comboBox.setItems(choices);

		setValue(initialValue, true);
	}

	@Override
	protected void createWidgets(String text, String toolTip, String initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setText(text.concat(":"));
		lbl.setToolTipText(toolTip);

		comboBox = new Combo(this, SWT.READ_ONLY);
		comboBox.setToolTipText(toolTip);

		errorIcon = new Label(this, SWT.NONE);
		errorIcon.setImage(Icon.getImage(Icon.EXCLAMATION_RED));
		errorIcon.setVisible(false);
		comboBox.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String value = comboBox.getText();
				if (value != getValue()) {
					setValue(comboBox.getText(), true);
				}
			}
		});
	}

	@Override
	public String getValueAsString() {
		return getValue();
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
		comboBox.setItems(choices);
		comboBox.setText(choices[0]);
		setValue(choices[0], true);
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		comboBox.setEnabled(enabled);
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
		comboBox.setToolTipText(text);
		super.setTooltip(text);
	}

	@Override
	public void setValue(String value, boolean redraw) {
		comboBox.setText(value);

		if (Arrays.asList(choices).contains(value)) {
			setErrorMessage(null);
			errorIcon.setVisible(false);
			errorIcon.setToolTipText("");
		} else {
			String error = "Widget \"" + text + "\" does not contain a valid choice";
			errorIcon.setVisible(true);
			errorIcon.setToolTipText(error);
			setErrorMessage(error);
		}

		super.setValue(value, redraw);
	}

}

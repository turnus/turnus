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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

import turnus.common.configuration.Option;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetSpinnerInteger extends Widget<Integer> {

	/** the maximal value */
	private final int max;
	/** the minimal value */
	private final int min;

	private Label lbl;
	/** the spinner widget */
	private Spinner spinner;

	public WidgetSpinnerInteger(Option<Integer> option, int min, int max, int increment, int initialValue,
			Composite parent) {
		this(option.name(), option.description(), min, max, increment, initialValue, parent);
	}

	public WidgetSpinnerInteger(String text, String toolTip, int min, int max, int increment, int initialValue,
			Composite parent) {
		super(text, toolTip, initialValue, 3, parent);

		this.max = max;
		this.min = min;

		spinner.setDigits(0);
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setIncrement(increment);

		setValue(initialValue, true);
	}

	@Override
	protected void createWidgets(String text, String toolTip, Integer initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setText(text);

		spinner = new Spinner(this, SWT.CHECK);
		spinner.setToolTipText(toolTip);
		spinner.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				Integer value = spinner.getSelection();
				if (value != getValue()) {
					setValue(value, false);
				}
			}
		});
	}

	@Override
	public String getValueAsString() {
		return Integer.toString(getValue());
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		spinner.setEnabled(enabled);
	}

	@Override
	public void setErrorMessage(String message) {
		super.setErrorMessage(null);
	}

	@Override
	public void setRawValue(String value) {
		setValue(Integer.parseInt(value));
	}

	@Override
	public void setText(String text) {
		lbl.setText(text);
		super.setText(text);
	}

	@Override
	public void setTooltip(String text) {
		lbl.setToolTipText(text);
		spinner.setToolTipText(text);
		super.setTooltip(text);
	}

	@Override
	protected void setValue(Integer value, boolean redraw) {
		value = Math.max(value, min);
		value = Math.min(value, max);
		spinner.setSelection(value);
		super.setValue(value, redraw);
	}

}

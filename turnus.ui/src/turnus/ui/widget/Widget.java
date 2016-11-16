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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;

import turnus.common.configuration.Option;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class Widget<T> extends Composite implements IWidget<T> {

	/** the widget value */
	protected T value;
	/** the widget initial value */
	private final T initialValue;
	/** the widget text */
	protected String text;
	/** the widget tooltip */
	protected String toolTip;
	/** the widget error message */
	private String errorMessage = null;

	private boolean enabled = true;

	private List<ModifyListener> listeners = new ArrayList<>();

	public Widget(Option<T> option, T initialValue, int gridPlaces, Composite parent) {
		this(option.name(), option.description(), initialValue, gridPlaces, parent);
	}

	public Widget(String text, String toolTip, T initialValue, int gridPlaces, Composite parent) {
		super(parent, SWT.NONE);
		this.text = text;
		this.toolTip = toolTip;
		this.initialValue = initialValue;

		GridLayout layout = new GridLayout(gridPlaces, false);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		super.setLayout(layout);
		super.setLayoutData(data);

		createWidgets(text, toolTip, initialValue);
	}

	@Override
	public void addModifyListener(ModifyListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * Create and initialize the widget. This method should be used by
	 * super-classes in order to build the effective widget.
	 * 
	 * @param text
	 *            the widget text
	 * @param toolTip
	 *            the widget too-tip
	 * @param initialValue
	 *            the widget initial value
	 * @param composite
	 *            the composite reserved for building the widget
	 */
	protected abstract void createWidgets(String text, String toolTip, T initialValue);

	public String getErrorMessage() {
		return errorMessage;
	}

	protected String getText() {
		return text;
	}

	protected String getToolTip() {
		return toolTip;
	}

	public T getValue() {
		return value;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public boolean isValid() {
		return isEnabled() ? errorMessage == null || errorMessage.isEmpty() : true;
	}

	protected void notifyListeners() {
		Event e = new Event();
		e.widget = this;
		for (ModifyListener l : listeners) {
			l.modifyText(new ModifyEvent(e));
		}
	}

	@Override
	public void removeModifyListener(ModifyListener listener) {
		listeners.remove(listener);
	}

	public void reset() {
		setValue(initialValue, true);
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	protected void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public void setLayout(Layout layout) {

	}

	public void setLayoutData(Object layoutData) {

	}

	public void setText(String text) {
		this.text = text != null ? text : "";
	}

	@Override
	public void setTooltip(String text) {
		this.toolTip = text != null ? text : "";
	}

	@Override
	public void setValue(T value) {
		setValue(value, true);
	}

	protected void setValue(T value, boolean redraw) {
		boolean notify = this.value != value;
		this.value = value;

		if (redraw) {
			redraw();
		}

		if (notify) {
			notifyListeners();
		}

		getParent().pack();
	}

	@Override
	public void setVisible(boolean show) {
		super.setVisible(show);
		((GridData) getLayoutData()).exclude = !show;
		getParent().pack();
	}

	protected T getInitialValue() {
		return initialValue;
	}

}

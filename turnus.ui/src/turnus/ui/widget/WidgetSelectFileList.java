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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

import turnus.common.configuration.Option;
import turnus.common.util.ListUtil;
import turnus.ui.Icon;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class WidgetSelectFileList extends Widget<List<String>> {

	private List<WidgetSelectFile> fileWidgets = new ArrayList<>();
	Composite composite;
	private final int min;
	private final int max;
	private int actives;
	private ModifyListener listener;
	/** the widget error icon */
	private Label errorIcon;

	public WidgetSelectFileList(Option<List<String>> option, String[] fileExtensions, final int min, final int max,
			List<String> initialValue, Composite parent) {
		super(option, initialValue, 1, parent);
		this.min = min;
		this.max = max;

		createFileList(fileExtensions);

	}

	public WidgetSelectFileList(String text, String description, String[] fileExtensions, int min, int max,
			List<String> initialValue, Composite parent) {
		super(text, description, initialValue, 1, parent);
		this.min = min;
		this.max = max;

		createFileList(fileExtensions);
	}

	private void createFileList(String[] fileExtensions) {
		listener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				List<String> values = new ArrayList<>();
				for (int i = 0; i < actives; i++) {
					String value = "";
					try {
						File file = fileWidgets.get(i).getValue();
						if (file != null) {
							value = file.getAbsolutePath();
						}
					} catch (Exception ex) {
						value = "";
					}
					values.add(value);
				}

				setValue(values, true);
			}
		};

		for (int i = 1; i <= max; i++) {
			// get the initial value if possible
			File init = null;
			List<String> initialValue = getInitialValue();
			if (initialValue != null) {
				try {
					String path = initialValue.get(i);
					init = new File(path);
				} catch (Exception e) {
					init = null;
				}
			}

			WidgetSelectFile w = new WidgetSelectFile("File " + i, "Select the file", fileExtensions, init, composite);
			w.addModifyListener(listener);

			fileWidgets.add(w);
			if (i > min) {
				w.setEnabled(false);
				w.setVisible(false);
			} else {
				actives++;
			}
		}

		Layout layout = new GridLayout(3, false);
		GridData data = new GridData(SWT.LEFT, SWT.DEFAULT, true, false);
		Composite bcomposite = new Composite(composite, SWT.SHADOW_NONE);
		bcomposite.setLayout(layout);
		bcomposite.setLayoutData(data);

		final Button add = new Button(bcomposite, SWT.PUSH);
		add.setImage(Icon.getImage(Icon.PLUS));

		final Button remove = new Button(bcomposite, SWT.PUSH);
		remove.setImage(Icon.getImage(Icon.MINUS));

		add.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				WidgetSelectFile w = fileWidgets.get(actives);
				w.setEnabled(true);
				w.setVisible(true);
				actives++;

				remove.setEnabled(actives > min);
				add.setEnabled(actives < max);

				 
				pack();

			}
		});

		remove.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				actives--;
				WidgetSelectFile w = fileWidgets.get(actives);
				w.setEnabled(false);
				w.setVisible(false);

				remove.setEnabled(actives > min);
				add.setEnabled(actives < max);

				pack();
			}
		});

		remove.setEnabled(actives > min);
		add.setEnabled(actives < max);

		errorIcon = new Label(bcomposite, SWT.NONE);
		errorIcon.setImage(Icon.getImage(Icon.EXCLAMATION_RED));
		errorIcon.setVisible(false);

	}

	@Override
	public String getValueAsString() {
		return ListUtil.asString(getValue());
	}

	public void setValue(List<String> value) {
		super.setValue(value);
		if (min > 0 && (value == null || value.isEmpty())) {
			setErrorMessage("No value defined");
			errorIcon.setVisible(true);
		} else {
			String error = "";
			for (WidgetSelectFile w : fileWidgets) {
				if (!w.isValid()) {
					error += "; " + w.getErrorMessage();
				}
			}
			error = error.replaceFirst("; ", error);
			if (!error.isEmpty()) {
				setErrorMessage(error);
				errorIcon.setVisible(true);
			} else {
				setErrorMessage(null);
				errorIcon.setVisible(false);
			}
		}

	}

	@Override
	public void setRawValue(String value) {
		setValue(ListUtil.asList(value));
	}

	@Override
	protected void createWidgets(String text, String toolTip, List<String> initialValue) {
		Layout layout = new GridLayout(1, false);
		GridData data = new GridData(SWT.FILL, SWT.DEFAULT, true, true);
		composite = new Composite(this, SWT.SHADOW_NONE);
		composite.setLayout(layout);
		composite.setLayoutData(data);
	}

}

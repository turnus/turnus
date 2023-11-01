/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) Endri Bezati
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

import turnus.common.configuration.Option;
import turnus.common.util.FileUtils;
import turnus.ui.Icon;

/**
 * 
 * @author Endri Bezati
 *
 */
public class WidgetSelectFileCombo extends Widget<File> {

	/** the filtered file extensions */
	protected final String[] fileExtensions;

	private Label lbl;
	/** the combo-box composite */
	private Combo comboBox;
	
	/** the set of choices */
	protected String[] choices;

	
	/** the widget error icon */	
	private Label errorIcon;
	/** the browse button */
	private Button browse;

	public WidgetSelectFileCombo(Option<File> option, String fileExtension, File initialValues, Composite parent) {
		this(option.name(), option.description(), fileExtension, initialValues, parent);
	}

	public WidgetSelectFileCombo(Option<File> option, String[] fileExtensions, File initialValues, Composite parent) {
		this(option.name(), option.description(), fileExtensions, initialValues, parent);
	}

	public WidgetSelectFileCombo(String text, String toolTip, String fileExtension, File initialValues, Composite parent) {
		this(text, toolTip, new String[] { fileExtension }, initialValues, parent);
	}

	public WidgetSelectFileCombo(String text, String toolTip, String[] fileExtensions, File initialValues, Composite parent) {
		super(text, toolTip, initialValues, 4, parent);
		this.fileExtensions = FileUtils.formatFileExtension(fileExtensions);
		setValue(initialValues, true);
	}

	@Override
	protected void createWidgets(final String text, final String toolTip, File initialValue) {
		lbl = new Label(this, SWT.NONE);
		lbl.setText(text.concat(":"));
		
		comboBox = new Combo(this, SWT.READ_ONLY);
		comboBox.setToolTipText(toolTip);
		
		comboBox.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String value = comboBox.getText();
				File path = new File(value);
				if (path != getValue()) {
					setValue(new File(comboBox.getText()), true);
				}
			}
		});
		
		browse = new Button(this, SWT.PUSH);
		browse.setFont(getFont());
		browse.setText("&Browse...");
		browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(getShell(), SWT.SINGLE);
				dialog.setText(getText().concat(": ").concat(getToolTip()));

				String extensions[] = new String[fileExtensions.length + 1];
				String names[] = new String[fileExtensions.length + 1];

				String all = "";
				for (String ext : fileExtensions) {
					all = all + ";" + ext;
				}
				extensions[0] = all.replaceFirst(";", "");
				names[0] = "*.*";

				for (int i = 0; i < fileExtensions.length; i++) {
					extensions[i + 1] = fileExtensions[i];
					names[i + 1] = fileExtensions[i];
				}

				dialog.setFilterExtensions(extensions);
				dialog.setFilterNames(names);

				String path = dialog.open();
				if (path != null) {
					setChoices(new String[] {path});
					setValue(new File(path), true);
				}
			}
		});

		errorIcon = new Label(this, SWT.NONE);
		errorIcon.setImage(Icon.getImage(Icon.EXCLAMATION_RED));
		errorIcon.setVisible(false);
	}

	@Override
	public String getValueAsString() {
		File value = getValue();
		return value != null ? value.getAbsolutePath() : null;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
		comboBox.setItems(choices);
		comboBox.setText(choices[0]);
		setValue(new File(choices[0]), true);
		comboBox.redraw();
	}
	
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		comboBox.setEnabled(enabled);
		browse.setEnabled(enabled);
		errorIcon.setVisible(enabled && !isValid());
	}

	@Override
	public void setRawValue(String value) {
		if (value == null || value.isEmpty()) {
			setValue(null);
		} else {
			setValue(new File(value));
		}
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
	public void setValue(File value, boolean redraw) {
		if (value != null) {
			comboBox.setText(value.getAbsolutePath());
		} else {
			comboBox.setText("");
		}

		if (value != null && value.isFile() && value.exists()) {
			setErrorMessage(null);
			errorIcon.setVisible(false);
			errorIcon.setToolTipText("");
		} else {
			String error = "\"" + text + "\" contains an invalid file";
			errorIcon.setVisible(true);
			errorIcon.setToolTipText(error);
			setErrorMessage(error);
			value = null;
		}

		super.setValue(value, redraw);
	}

}

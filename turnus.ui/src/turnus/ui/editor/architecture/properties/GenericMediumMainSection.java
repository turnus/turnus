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
package turnus.ui.editor.architecture.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import turnus.model.architecture.Medium;
import turnus.ui.widget.graphiti.AbstractGridBasedSection;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class GenericMediumMainSection extends AbstractGridBasedSection {

	//private Text mName;
	private Text ckPeriodRead;
	private Text ckPeriodWrite;
	private Text maxBitPop;
	private Text maxBitPush;
	private Text maxBitSize;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		/*
		widgetFactory.createCLabel(formBody, "Name:");
		mName = widgetFactory.createText(formBody, "", SWT.BORDER);
		mName.setLayoutData(fillHorizontalData);
		mName.setEditable(false);
		mName.setBackground(disabledFieldBGColor);*/
		
		widgetFactory.createCLabel(formBody, "Clock-Period, read (ns):");
		ckPeriodRead = widgetFactory.createText(formBody, "", SWT.BORDER);
		ckPeriodRead.setLayoutData(fillHorizontalData);
		ckPeriodRead.setEditable(true);
		ckPeriodRead.setBackground(disabledFieldBGColor);
		
		widgetFactory.createCLabel(formBody, "Clock-Period, write (ns):");
		ckPeriodWrite = widgetFactory.createText(formBody, "", SWT.BORDER);
		ckPeriodWrite.setLayoutData(fillHorizontalData);
		ckPeriodWrite.setEditable(true);
		ckPeriodWrite.setBackground(disabledFieldBGColor);
		
		widgetFactory.createCLabel(formBody, "Max POP (bit):");
		maxBitPop = widgetFactory.createText(formBody, "", SWT.BORDER);
		maxBitPop.setLayoutData(fillHorizontalData);
		maxBitPop.setEditable(true);
		maxBitPop.setBackground(disabledFieldBGColor);
		
		widgetFactory.createCLabel(formBody, "Max PUSH (bit):");
		maxBitPush = widgetFactory.createText(formBody, "", SWT.BORDER);
		maxBitPush.setLayoutData(fillHorizontalData);
		maxBitPush.setEditable(true);
		maxBitPush.setBackground(disabledFieldBGColor);
		
		widgetFactory.createCLabel(formBody, "Max size (bit):");
		maxBitSize = widgetFactory.createText(formBody, "", SWT.BORDER);
		maxBitSize.setLayoutData(fillHorizontalData);
		maxBitSize.setEditable(true);
		maxBitSize.setBackground(disabledFieldBGColor);
		
	}
	

	@Override
	protected void readValuesFromModels() {
		Medium medium = (Medium) getSelectedBusinessObject();

		setValue(ckPeriodRead, medium.getClockPeriodIn());
		setValue(ckPeriodWrite, medium.getClockPeriodOut());
		setValue(maxBitPop, medium.getMaxBitPop());
		setValue(maxBitPush, medium.getMaxBitPush());
		setValue(maxBitSize, medium.getMaxBitSize());

		//mName.setText(medium.getName());
	}

	@Override
	protected void writeValuesToModel(Widget widget) {
		Medium medium = (Medium) getSelectedBusinessObject();
		if (widget == ckPeriodRead) {
			double value = parseDouble(ckPeriodRead);
			medium.setClockPeriodIn(value);
		} else if (widget == ckPeriodWrite) {
			double value = parseDouble(ckPeriodWrite);
			medium.setClockPeriodOut(value);
		} else if (widget == maxBitPop) {
			int value = parseInteger(maxBitPop);
			medium.setMaxBitPop(value);
		} else if (widget == maxBitPush) {
			int value = parseInteger(maxBitPush);
			medium.setMaxBitPush(value);
		} else if (widget == maxBitSize) {
			int value = parseInteger(maxBitSize);
			medium.setMaxBitSize(value);
		}
	}

	protected String checkValueValid(final Widget widget) {
		if (widget == ckPeriodRead) {
			String error = checkDoubleValid(ckPeriodRead);
			if (error != null) {
				return "The write clock period " + error;
			} else {
				return null;
			}
		} else if (widget == ckPeriodWrite) {
			String error = checkDoubleValid(ckPeriodWrite);
			if (error != null) {
				return "The read clock period " + error;
			} else {
				return null;
			}
		} else if (widget == maxBitPop) {
			String error = checkIntegerValid(maxBitPop);
			if (error != null) {
				return "The max bit pop " + error;
			} else {
				return null;
			}
		} else if (widget == maxBitPush) {
			String error = checkIntegerValid(maxBitPush);
			if (error != null) {
				return "The max bit push " + error;
			} else {
				return null;
			}
		} else if (widget == maxBitSize) {
			String error = checkIntegerValid(maxBitSize);
			if (error != null) {
				return "The max bit size " + error;
			} else {
				return null;
			}
		}

		return super.checkValueValid(widget);
	}

	private void setValue(Text text, int value) {
		text.setText(Integer.toString(value));
	}

	private void setValue(Text text, double value) {
		text.setText(Double.toString(value));
	}

	private int parseInteger(Text text) {
		return Integer.parseInt(text.getText());
	}

	private double parseDouble(Text text) {
		return Double.parseDouble(text.getText());
	}

	private String checkDoubleValid(Text text) {
		try {
			double value = Double.parseDouble(text.getText());
			if (value < 0.0) {
				return "must be a positive value";
			}
		} catch (Exception e) {
			return "must be a valid decimal value";
		}
		return null;
	}

	private String checkIntegerValid(Text text) {
		try {
			int value = Integer.parseInt(text.getText());
			if (value < 0) {
				return "must be a positive value";
			}
		} catch (Exception e) {
			return "must be a valid integer value";
		}
		return null;
	}

	@Override
	protected String getFormText() {
		return "Medium properties";
	}

}

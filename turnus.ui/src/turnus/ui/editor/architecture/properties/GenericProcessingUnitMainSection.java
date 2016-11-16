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

import turnus.model.architecture.ProcessingUnit;
import turnus.ui.widget.graphiti.AbstractGridBasedSection;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class GenericProcessingUnitMainSection extends AbstractGridBasedSection {

	//private Text puName;
	private Text puType;
	private Text puFamily;
	private Text puClockPeriod;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		/*widgetFactory.createCLabel(formBody, "Name:");
		puName = widgetFactory.createText(formBody, "", SWT.BORDER);
		puName.setLayoutData(fillHorizontalData);
		puName.setEditable(false);
		puName.setBackground(disabledFieldBGColor);*/

		widgetFactory.createCLabel(formBody, "Type:");
		puType = widgetFactory.createText(formBody, "", SWT.BORDER);
		puType.setLayoutData(fillHorizontalData);
		puType.setEditable(false);
		puType.setBackground(disabledFieldBGColor);

		widgetFactory.createCLabel(formBody, "Family:");
		puFamily = widgetFactory.createText(formBody, "", SWT.BORDER);
		puFamily.setLayoutData(fillHorizontalData);
		puFamily.setEditable(true);
		puFamily.setBackground(disabledFieldBGColor);

		widgetFactory.createCLabel(formBody, "Clock-Period (ns):");
		puClockPeriod = widgetFactory.createText(formBody, "", SWT.BORDER);
		puClockPeriod.setLayoutData(fillHorizontalData);
		puClockPeriod.setEditable(true);
		puClockPeriod.setBackground(disabledFieldBGColor);
	}

	@Override
	protected void readValuesFromModels() {
		ProcessingUnit pu = (ProcessingUnit) getSelectedBusinessObject();
		//puName.setText(pu.getName());
		puType.setText(pu.getClassName());

		String family = pu.getFamily() != null ? pu.getFamily() : "";
		puFamily.setText(family);

		Double clockPeriod = pu.getClockPeriod();
		puClockPeriod.setText(Double.toString(clockPeriod));
	}

	@Override
	protected void writeValuesToModel(Widget widget) {
		ProcessingUnit pu = (ProcessingUnit) getSelectedBusinessObject();

		if (widget == puFamily) {
			pu.setFamily(puFamily.getText());
		} else if (widget == puClockPeriod) {
			double value = Double.parseDouble(puClockPeriod.getText());
			pu.setClockPeriod(value);
		}

	}

	protected String checkValueValid(final Widget widget) {
		if (widget == puClockPeriod) {
			String txt = puClockPeriod.getText();
			try {
				double value = Double.parseDouble(txt);
				if (value < 0.0) {
					return "The clock period should be a positive value";
				} else {
					return null;
				}
			} catch (Exception e) {
				return "The clock period should be a valid decimal number";
			}
		}

		return super.checkValueValid(widget);
	}

	@Override
	protected String getFormText() {
		return "Processing Unit Properties";
	}

}

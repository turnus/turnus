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

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import turnus.model.architecture.ProcessingUnit;
import turnus.model.common.EOperator;
import turnus.ui.widget.graphiti.AbstractGridBasedSection;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class OperatorsSection extends AbstractGridBasedSection {

	private final BiMap<EOperator, Button> operatorsWidget = HashBiMap.create();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		GridLayout gridLayout = new GridLayout(1, false);
		formBody.setLayout(gridLayout);

		for (EOperator op : EOperator.values()) {
			Button widget = widgetFactory.createButton(formBody, op.getLiteral(), SWT.CHECK);
			widget.setEnabled(true);
			widget.setLayoutData(fillHorizontalData);
			operatorsWidget.put(op, widget);
		}

	}

	@Override
	protected void readValuesFromModels() {
		ProcessingUnit pu = (ProcessingUnit) getSelectedBusinessObject();
		List<EOperator> operators = pu.getOperators();
		for (Entry<EOperator, Button> et : operatorsWidget.entrySet()) {
			Button widget = et.getValue();
			EOperator op = et.getKey();
			widget.setSelection(operators.contains(op));
		}

	}

	@Override
	protected void writeValuesToModel(Widget widget) {
		ProcessingUnit pu = (ProcessingUnit) getSelectedBusinessObject();
		Button button = (Button) widget;
		EOperator op = operatorsWidget.inverse().get(button);
		if (button.getSelection() && !pu.getOperators().contains(op)) {
			pu.getOperators().add(op);
		} else {
			pu.getOperators().remove(op);
		}

	}

	@Override
	protected String getFormText() {
		return "Supported Operators";
	}

}

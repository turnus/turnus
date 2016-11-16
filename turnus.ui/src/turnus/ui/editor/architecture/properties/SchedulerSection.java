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

import java.util.ArrayList;
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

import turnus.model.architecture.CPU;
import turnus.model.architecture.DSP;
import turnus.model.common.EScheduler;
import turnus.ui.widget.graphiti.AbstractGridBasedSection;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class SchedulerSection extends AbstractGridBasedSection {

	private BiMap<EScheduler, Button> schedulersWidget = HashBiMap.create();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		GridLayout gridLayout = new GridLayout(1, false);
		formBody.setLayout(gridLayout);

		for (EScheduler scheduler : EScheduler.values()) {
			Button widget = widgetFactory.createButton(formBody, scheduler.getLiteral(), SWT.CHECK);
			widget.setEnabled(true);
			widget.setLayoutData(fillHorizontalData);
			schedulersWidget.put(scheduler, widget);
		}

	}

	@Override
	protected void readValuesFromModels() {

		List<EScheduler> schedulers = null;
		Object obj = getSelectedBusinessObject();
		if (obj instanceof CPU) {
			schedulers = ((CPU) obj).getSchedulers();
		} else if (obj instanceof DSP) {
			schedulers = ((DSP) obj).getSchedulers();
		} else {
			schedulers = new ArrayList<>();
		}

		for (Entry<EScheduler, Button> et : schedulersWidget.entrySet()) {
			Button widget = et.getValue();
			EScheduler scheduler = et.getKey();
			widget.setSelection(schedulers.contains(scheduler));
		}
	}

	@Override
	protected void writeValuesToModel(Widget widget) {
		Object obj = getSelectedBusinessObject();
		if (widget instanceof Button) {
			if (obj instanceof CPU) {
				writeSchedulers((Button) widget, (CPU) obj);
			} else if (obj instanceof DSP) {
				writeSchedulers((Button) widget, (DSP) obj);
			}
		}
	}

	private void writeSchedulers(Button widget, CPU obj) {
		List<EScheduler> schedulers = obj.getSchedulers();
		EScheduler scheduler = schedulersWidget.inverse().get(widget);
		if (widget.getSelection() && !schedulers.contains(scheduler)) {
			obj.getSchedulers().add(scheduler);
		} else {
			obj.getSchedulers().remove(obj);
		}
	}

	private void writeSchedulers(Button widget, DSP obj) {
		List<EScheduler> schedulers = obj.getSchedulers();
		EScheduler scheduler = schedulersWidget.inverse().get(widget);
		if (widget.getSelection() && !schedulers.contains(scheduler)) {
			obj.getSchedulers().add(scheduler);
		} else {
			obj.getSchedulers().remove(obj);
		}

	}

	@Override
	protected String getFormText() {
		return "Supported Scheduling Policies";
	}

}

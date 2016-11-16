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
package turnus.analysis.ui.profiler;

import static turnus.common.TurnusExtensions.OPERATORS_COSTS;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.common.EOperator;
import turnus.model.mapping.io.XmlOperatorsCostReader;
import turnus.model.mapping.io.XmlOperatorsCostWriter;

/**
 * This class contains the {@link EditorPart} for the {@link EOperator} cost
 * file.
 * 
 * @author Simone Casale Brunet
 *
 */
public class OperatorsCostEditor extends EditorPart {

	/**
	 * This class defines the cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class CellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			return property.equals(columnNames[COST]);
		}

		@Override
		@SuppressWarnings("unchecked")
		public Object getValue(Object element, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);

			Object result = "";
			Entry<EOperator, Double> oc = (Entry<EOperator, Double>) element;

			switch (columnIndex) {
			case OPERATOR:
				result = oc.getKey().getName();
				break;
			case COST:
				result = Double.toString(oc.getValue());
				break;
			default:
				break;

			}

			return result;
		}

		@Override
		@SuppressWarnings("unchecked")
		public void modify(Object element, String property, Object value) {
			if (property.equals(columnNames[COST])) {
				String intString = (String) value;
				if (intString.matches("[+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")) {
					TableItem item = (TableItem) element;
					Entry<EOperator, Double> oc = (Entry<EOperator, Double>) item.getData();
					Double newCost = Double.parseDouble(intString);
					if (oc.getValue() != newCost) {
						oc.setValue(newCost);
						setDirty(true);
					}
					viewer.refresh();
				}
			}
		}
	}

	/**
	 * This class defines the label provider for the Instances Mapping Tab
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		@SuppressWarnings("unchecked")
		public String getColumnText(Object element, int columnIndex) {
			String result = "";
			Entry<EOperator, Double> oc = (Entry<EOperator, Double>) element;
			switch (columnIndex) {
			case OPERATOR:
				result = oc.getKey().getName();
				break;
			case COST:
				result = Double.toString(oc.getValue());
				break;
			default:
				break;
			}
			return result;
		}
	}

	/**
	 * This class defines the content provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class ContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object input) {
			try {
				Map<EOperator, Double> map = (Map<EOperator, Double>) input;
				return map.entrySet().toArray();
			} catch (Exception e) {
				return new Object[0];
			}
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * This class defines a content comparator for sorting instances by the
	 * selected column values.
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class ContentComparator extends ViewerComparator {
		private int propertyIndex;
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public ContentComparator() {
			this.propertyIndex = 0;
			direction = DESCENDING;
		}

		@Override
		@SuppressWarnings("unchecked")
		public int compare(Viewer viewer, Object e1, Object e2) {
			Entry<EOperator, Double> oc1 = (Entry<EOperator, Double>) e1;
			Entry<EOperator, Double> oc2 = (Entry<EOperator, Double>) e2;
			int rc = 0;
			switch (propertyIndex) {
			case OPERATOR:
				rc = oc1.getKey().getName().compareTo(oc2.getKey().getName());
				break;
			case COST:
				rc = Double.compare(oc1.getValue(), oc2.getValue());
				break;
			default:
				rc = 0;
			}
			// If descending order, flip the direction
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		}

		public int getDirection() {
			return direction == 1 ? SWT.DOWN : SWT.UP;
		}

		public void setColumn(int column) {
			if (column == this.propertyIndex) {
				// Same sorting column: toggle the direction
				direction = 1 - direction;
			} else {
				// New sorting column: ascending sort
				this.propertyIndex = column;
				direction = DESCENDING;
			}
		}
	}

	private final int OPERATOR = 0;
	private final int COST = 1;
	private final String[] columnNames = new String[] { "Operator", "Cost" };

	private Table table;
	private TableViewer viewer;
	private ContentComparator comparator;

	private Map<EOperator, Double> operatorCosts;

	private boolean isDirty;

	public OperatorsCostEditor() {
		// create the operators
		operatorCosts = new HashMap<>();
		for (EOperator o : EOperator.values()) {
			operatorCosts.put(o, 0.0);
		}
	}

	public void createPartControl(Composite parent) {

		final Composite tContainer = new Composite(parent, SWT.NONE);
		tContainer.setLayout(new GridLayout());

		// build the table and its accessories
		table = new Table(tContainer, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer = new TableViewer(table);
		comparator = new ContentComparator();
		viewer.setComparator(comparator);

		// set table layout
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// add table column: operator
		final TableColumn column1 = new TableColumn(table, SWT.LEFT, OPERATOR);
		column1.setText(columnNames[OPERATOR]);
		column1.setWidth(400);
		column1.addSelectionListener(getSelectionAdapter(column1, OPERATOR));
		column1.setResizable(false);

		// add table column: cost
		final TableColumn column2 = new TableColumn(table, SWT.LEFT, COST);
		column2.setText(columnNames[COST]);
		column2.setWidth(200);
		column2.addSelectionListener(getSelectionAdapter(column2, COST));
		column2.setResizable(false);

		// create the table viewer
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[COST] = new TextCellEditor(table);
		// set the editors
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new CellModifier());
		viewer.setInput(operatorCosts);

	}

	/**
	 * Create a new {@link SelectionAdapter} for adding the sorting facility to
	 * the column
	 * 
	 * @param column
	 *            the table column
	 * @param index
	 *            the column number index
	 * @return
	 */
	private SelectionAdapter getSelectionAdapter(final TableColumn column, final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				viewer.getTable().setSortDirection(dir);
				viewer.getTable().setSortColumn(column);
				viewer.refresh();
			}
		};
		return selectionAdapter;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(OPERATORS_COSTS)) {
					new XmlOperatorsCostWriter().write(operatorCosts, file);
					setDirty(false);
				}
			}
		} catch (Exception e) {
			Logger.debug("Operator cost editor save error: %s", e.getMessage());
		}

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		isDirty = false;
		try {
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(OPERATORS_COSTS)) {
					try {
						Map<EOperator, Double> map = new XmlOperatorsCostReader().load(file);

						for (Entry<EOperator, Double> e : operatorCosts.entrySet()) {
							EOperator op = e.getKey();
							double value = map.containsKey(op) ? map.get(op) : 0;
							e.setValue(value);
						}
						setPartName(file.getName());
					} catch (Exception e) {
						throw new PartInitException("Input file is corrupted");
					}
				} else {
					throw new Exception("Invalid input");
				}
			}
		} catch (Exception e) {

		}
		setSite(site);
		setInput(input);

	}

	@Override
	public boolean isDirty() {
		return isDirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
		if (table != null) {
			table.setFocus();
		}
	}

	private void setDirty(boolean value) {
		isDirty = value;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

}

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
package turnus.ui.editor.configuration;

import static turnus.common.TurnusExtensions.CONFIGURATION;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import turnus.common.configuration.Configuration;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ConfigurationEditor extends EditorPart {
	
	/**
	 * This class defines the cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class CellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			return property.equals(columnNames[VALUE]);
		}

		@Override
		public Object getValue(Object o, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);

			Object result = "";
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> e = (Map.Entry<String, String>) o;

			switch (columnIndex) {
			case KEY:
				result = e.getKey();
				break;
			case VALUE:
				result = e.getValue();
				break;
			default:
				break;

			}

			return result;
		}

		@Override
		public void modify(Object o, String property, Object value) {
			// int columnIndex = Arrays.asList(columnNames).indexOf(property);
			if (property.equals(columnNames[VALUE])) {
				String intString = (String) value;
				if (!intString.isEmpty()) {
					TableItem item = (TableItem) o;
					@SuppressWarnings("unchecked")
					Map.Entry<String, String> e = (Map.Entry<String, String>) item.getData();
					String oldValue = e.getValue();
					if (!intString.equals(oldValue)) {
						String option = e.getKey();
						configuration.setRawValue(option, intString);
						setDirty(true);
					}
					viewer.refresh();

				}
			}

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
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Configuration) {
				return configuration.asRawMap().entrySet().toArray();
			} else {
				return new Object[0];
			}
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
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
		public String getColumnText(Object o, int columnIndex) {
			String result = "";
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> e = (Map.Entry<String, String>) o;

			switch (columnIndex) {
			case KEY:
				result = e.getKey();
				break;
			case VALUE:
				result = e.getValue();
				break;
			default:
				break;

			}
			return result;
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
		public int compare(Viewer viewer, Object o1, Object o2) {
			Map.Entry<String, String> e1 = (Map.Entry<String, String>) o1;
			Map.Entry<String, String> e2 = (Map.Entry<String, String>) o2;

			int rc = 0;
			switch (propertyIndex) {
			case KEY:
				rc = e1.getKey().compareTo(e2.getKey());
				break;
			case VALUE:
				rc = e1.getValue().compareTo(e2.getValue());
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

	private boolean isDirty;
	private Configuration configuration;

	private Table table;
	private TableViewer viewer;
	private ContentComparator comparator;

	private final int KEY = 0;
	private final int VALUE = 1;

	/** the columns names */
	private final String[] columnNames = new String[] { "Option", "Value" };

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(CONFIGURATION)) {
					configuration.store(file);
					setDirty(false);
				}
			}
		} catch (Exception e) {
			Logger.debug("Configuration file size save error: %s", e.getMessage());
			setDirty(true);
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
				if (FileUtils.getExtension(file).equals(CONFIGURATION)) {
					configuration = Configuration.load(file);
					setPartName(file.getName());
				} else {
					throw new Exception("Invalid input");
				}
			}
		} catch (Exception e) {
			throw new PartInitException("Input file is corrupted or not valid");
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
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);

		Label lbl = new Label(parent, SWT.NONE);
		lbl.setFont(parent.getFont());
		String name = configuration != null ? configuration.getName() : "";
		lbl.setText("Configuration: \"" + name + "\"");
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		table = new Table(parent, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer = new TableViewer(table);
		comparator = new ContentComparator();
		viewer.setComparator(comparator);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		gridData.heightHint = 300;
		table.setLayoutData(gridData);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// column: key
		TableColumn column = new TableColumn(table, SWT.LEFT, KEY);
		column.setText(columnNames[KEY]);
		column.setWidth(400);
		column.addSelectionListener(getSelectionAdapter(column, KEY));

		// column: value
		column = new TableColumn(table, SWT.LEFT, VALUE);
		column.setText(columnNames[VALUE]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, VALUE));

		// create the table viewer
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[VALUE] = new TextCellEditor(table);
		// set the editors
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new CellModifier());

		viewer.setInput(configuration);

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
	public void setFocus() {

	}

	private void setDirty(boolean value) {
		isDirty = value;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

}

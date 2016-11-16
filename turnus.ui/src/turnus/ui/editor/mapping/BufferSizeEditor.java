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
package turnus.ui.editor.mapping;

import static turnus.common.TurnusExtensions.BUFFER_SIZE;

import java.io.File;
import java.util.Arrays;

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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import com.google.common.collect.Table.Cell;

import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.common.util.Pair;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.io.XmlBufferSizeReader;
import turnus.model.mapping.io.XmlBufferSizeWriter;

/**
 * This class contains the {@link EditorPart} for the {@link BufferSize} file.
 * 
 * @author Simone Casale Brunet
 *
 */
public class BufferSizeEditor extends EditorPart {

	/**
	 * This class defines the cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class CellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			return property.equals(columnNames[SIZE]);
		}

		@Override
		public Object getValue(Object o, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);

			Object result = "";
			@SuppressWarnings("unchecked")
			Cell<Pair<String, String>, Pair<String, String>, Integer> element = (Cell<Pair<String, String>, Pair<String, String>, Integer>) o;

			switch (columnIndex) {
			case SRC_ACTOR:
				result = element.getRowKey().v1;
				break;
			case SRC_PORT:
				result = element.getRowKey().v2;
				break;
			case TGT_ACTOR:
				result = element.getColumnKey().v1;
				break;
			case TGT_PORT:
				result = element.getColumnKey().v2;
				break;
			case SIZE:
				result = Integer.toString(element.getValue());
				break;
			default:
				break;

			}

			return result;
		}

		@Override
		public void modify(Object o, String property, Object value) {
			// int columnIndex = Arrays.asList(columnNames).indexOf(property);
			if (property.equals(columnNames[SIZE])) {
				String intString = (String) value;
				if (intString.matches("[+]?\\d+")) {
					TableItem item = (TableItem) o;
					@SuppressWarnings("unchecked")
					Cell<Pair<String, String>, Pair<String, String>, Integer> element = (Cell<Pair<String, String>, Pair<String, String>, Integer>) item
							.getData();
					int oldValue = element.getValue();
					int newValue = Integer.parseInt(intString);
					if (oldValue != newValue) {
						Pair<String, String> src = element.getRowKey();
						Pair<String, String> tgt = element.getColumnKey();
						bufferSize.setSize(src.v1, src.v2, tgt.v1, tgt.v2, newValue);
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
			if (inputElement instanceof BufferSize) {
				return bufferSize.asTable().cellSet().toArray();
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
			Cell<Pair<String, String>, Pair<String, String>, Integer> element = (Cell<Pair<String, String>, Pair<String, String>, Integer>) o;

			switch (columnIndex) {
			case SRC_ACTOR:
				result = element.getRowKey().v1;
				break;
			case SRC_PORT:
				result = element.getRowKey().v2;
				break;
			case TGT_ACTOR:
				result = element.getColumnKey().v1;
				break;
			case TGT_PORT:
				result = element.getColumnKey().v2;
				break;
			case SIZE:
				result = Integer.toString(element.getValue());
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
			Cell<Pair<String, String>, Pair<String, String>, Integer> e1 = (Cell<Pair<String, String>, Pair<String, String>, Integer>) o1;
			Cell<Pair<String, String>, Pair<String, String>, Integer> e2 = (Cell<Pair<String, String>, Pair<String, String>, Integer>) o2;

			int rc = 0;
			switch (propertyIndex) {
			case SRC_ACTOR:
				rc = e1.getRowKey().v1.compareTo(e2.getRowKey().v1);
				break;
			case SRC_PORT:
				rc = e1.getRowKey().v2.compareTo(e2.getRowKey().v2);
				break;
			case TGT_ACTOR:
				rc = e1.getColumnKey().v1.compareTo(e2.getColumnKey().v1);
				break;
			case TGT_PORT:
				rc = e1.getColumnKey().v2.compareTo(e2.getColumnKey().v2);
				break;
			case SIZE:
				rc = Integer.compare(e1.getValue(), e2.getValue());
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
	private BufferSize bufferSize;

	private Table table;
	private TableViewer viewer;
	private ContentComparator comparator;
	private Spinner defaultSize;

	private final int SRC_ACTOR = 0;
	private final int SRC_PORT = 1;
	private final int TGT_ACTOR = 2;
	private final int TGT_PORT = 3;
	private final int SIZE = 4;

	/** the columns names */
	private final String[] columnNames = new String[] { "Src Actor", "Port", "Tgt Actor", "Port", "Size (tokens)" };

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(BUFFER_SIZE)) {
					new XmlBufferSizeWriter().write(bufferSize, file);
					setDirty(false);
				}
			}
		} catch (Exception e) {
			Logger.debug("Buffer size save error: %s", e.getMessage());
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
				if (FileUtils.getExtension(file).equals(BUFFER_SIZE)) {
					bufferSize = new XmlBufferSizeReader().load(file);
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
		String network = bufferSize != null ? bufferSize.getNetwork() : "";
		lbl.setText("Network: \"" + network + "\"");
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		lbl = new Label(composite, SWT.NONE);
		lbl.setFont(parent.getFont());
		lbl.setText("Default buffer size: ");
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		int size = bufferSize != null ? bufferSize.getDefaultSize() : 0;
		defaultSize = new Spinner(composite, SWT.NONE);
		defaultSize.setMinimum(0);
		defaultSize.setMaximum(Integer.MAX_VALUE);
		defaultSize.setIncrement(1);
		defaultSize.setSelection(size);
		defaultSize.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (bufferSize != null) {
					try {
						int newSize = Integer.parseInt(defaultSize.getText());
						bufferSize.setDefaultSize(newSize);
						setDirty(true);
					} catch (Exception exc) {
					}
				}
			}
		});

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

		// column: source actor
		TableColumn column = new TableColumn(table, SWT.LEFT, SRC_ACTOR);
		column.setText(columnNames[SRC_ACTOR]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, SRC_ACTOR));

		// column: source port
		column = new TableColumn(table, SWT.LEFT, SRC_PORT);
		column.setText(columnNames[SRC_PORT]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, SRC_PORT));

		// column: target actor
		column = new TableColumn(table, SWT.LEFT, TGT_ACTOR);
		column.setText(columnNames[TGT_ACTOR]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, TGT_ACTOR));

		// column: target port
		column = new TableColumn(table, SWT.LEFT, TGT_PORT);
		column.setText(columnNames[TGT_PORT]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, TGT_PORT));

		// column: size
		column = new TableColumn(table, SWT.LEFT, SIZE);
		column.setText(columnNames[SIZE]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, SIZE));

		// create the table viewer
		viewer.setUseHashlookup(true);
		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[SIZE] = new TextCellEditor(table);
		// set the editors
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new CellModifier());

		viewer.setInput(bufferSize);

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

	private void setDirty(boolean value) {
		isDirty = value;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public void setFocus() {
		if (table != null) {
			table.setFocus();
		}
	}

}

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

import static turnus.common.TurnusExtensions.NETWORK_PARTITIONING;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
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

import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.common.util.Triplet;
import turnus.model.common.EScheduler;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.io.XmlNetworkPartitioningReader;
import turnus.model.mapping.io.XmlNetworkPartitioningWriter;

/**
 * 
 * @author Simone Casale Brunet
 * @authir Endri Bezati
 *
 */
public class NetworkPartitioningEditor extends EditorPart {

	/**
	 * This class defines the mapping cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class MappingCellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			return property.equals(mappingColumnNames[M_COMPONENT]);
		}

		@Override
		public Object getValue(Object o, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(mappingColumnNames).indexOf(property);

			Object result = "";
			@SuppressWarnings("unchecked")
			Map.Entry<String, String> e = (Map.Entry<String, String>) o;

			switch (columnIndex) {
			case M_ACTOR:
				result = e.getKey();
				break;
			case M_COMPONENT:
				result = e.getValue();
				break;
			default:
				break;

			}

			return result;
		}

		@Override
		public void modify(Object o, String property, Object value) {
			// int columnIndex =
			// Arrays.asList(mappingColumnNames).indexOf(property);
			if (property.equals(mappingColumnNames[M_COMPONENT])) {
				String intString = (String) value;
				if (!intString.isEmpty()) {
					TableItem item = (TableItem) o;
					@SuppressWarnings("unchecked")
					Map.Entry<String, String> e = (Map.Entry<String, String>) item.getData();
					String oldValue = e.getValue();
					if (!intString.equals(oldValue)) {
						String actor = e.getKey();
						partitioning.setPartition(actor, intString);
						setDirty(true);
					}
					schedulingViewer.refresh();
					mappingViewer.refresh();

				}
			}

		}

	}

	/**
	 * This class defines the scheduling cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class SchedulingCellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			int colIndex = Arrays.asList(schedulerColumnNames).indexOf(property);
			switch (colIndex) {
			case S_POLICY:
				return true;
			case S_PE:
				return true;
			default: 
				return false;

			}
		}

		@Override
		public Object getValue(Object o, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(schedulerColumnNames).indexOf(property);

			Object result = "";
			@SuppressWarnings("unchecked")
			// Map.Entry<String, String> e = (Map.Entry<String, String>) o;
			Triplet<String, String, Integer> e = (Triplet<String, String, Integer>) o;

			switch (columnIndex) {
			case S_COMPONENT:
				result = e.v1;
				break;
			case S_POLICY:
				result = Arrays.asList(schedulingPolicies).indexOf(e.v2);
				break;
			case S_PE:
				result = String.valueOf(e.v3);
				break;
			default:
				break;

			}

			return result;
		}

		@Override
		public void modify(Object o, String property, Object value) {
			if (property.equals(schedulerColumnNames[S_POLICY])) {
				int choice = (int) value;
				String intString = schedulingPolicies[choice];

				TableItem item = (TableItem) o;
				@SuppressWarnings("unchecked")
				Triplet<String, String, Integer> e = (Triplet<String, String, Integer>) item.getData();

				String oldValue = e.v2;
				if (!intString.equals(oldValue)) {
					String partition = e.v1;
					partitioning.setScheduler(partition, intString);
					setDirty(true);
				}
				schedulingViewer.refresh();
			} else if (property.equals(schedulerColumnNames[S_PE])) {

				Integer intString;
				try {
					String choice = (String) value;
					intString = Integer.valueOf(choice);
				} catch (NumberFormatException ex) {
					intString = 1;
				}
				
				TableItem item = (TableItem) o;
				@SuppressWarnings("unchecked")
				Triplet<String, String, Integer> e = (Triplet<String, String, Integer>) item.getData();
				Integer oldValue = e.v3;
				if (!intString.equals(oldValue)) {
					String partition = e.v1;
					partitioning.setProcessingElements(partition, intString);
					setDirty(true);
				}
				schedulingViewer.refresh();
			}

		}

	}

	/**
	 * This class defines the scheduling content provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class SchedulingContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof NetworkPartitioning) {
				return partitioning.asPartitionSchedulerPeList().toArray();
			} else {
				return new Object[0];
			}
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * This class defines the mapping content provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class MappingContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof NetworkPartitioning) {
				return partitioning.asActorPartitionMap().entrySet().toArray();
			} else {
				return new Object[0];
			}
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * This class defines the mapping label provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class MappingTableLabelProvider extends LabelProvider implements ITableLabelProvider {

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
			case M_ACTOR:
				result = e.getKey();
				break;
			case M_COMPONENT:
				result = e.getValue();
				break;
			default:
				break;

			}
			return result;
		}
	}

	/**
	 * This class defines the scheduling label provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class SchedulingTableLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object o, int columnIndex) {
			String result = "";
			@SuppressWarnings("unchecked")
			Triplet<String, String, Integer> e = (Triplet<String, String, Integer>) o;

			switch (columnIndex) {
			case S_COMPONENT:
				result = e.v1;
				break;
			case S_POLICY:
				result = e.v2;
				break;
			case S_PE:
				result = String.valueOf(e.v3);
				break;
			default:
				break;

			}
			return result;
		}
	}

	/**
	 * This class defines the mapping content mappingComparator
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class MappingContentComparator extends ViewerComparator {
		private int propertyIndex;
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public MappingContentComparator() {
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
			case M_ACTOR:
				rc = e1.getKey().compareTo(e2.getKey());
				break;
			case M_COMPONENT:
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

	/**
	 * This class defines the mapping content mappingComparator
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class SchedulingContentComparator extends ViewerComparator {
		private int propertyIndex;
		private static final int DESCENDING = 1;
		private int direction = DESCENDING;

		public SchedulingContentComparator() {
			this.propertyIndex = 0;
			direction = DESCENDING;
		}

		@Override
		@SuppressWarnings("unchecked")
		public int compare(Viewer viewer, Object o1, Object o2) {

			Triplet<String, String, Integer> e1 = (Triplet<String, String, Integer>) o1;
			Triplet<String, String, Integer> e2 = (Triplet<String, String, Integer>) o2;

			int rc = 0;
			switch (propertyIndex) {
			case S_COMPONENT:
				rc = e1.v1.compareTo(e2.v1);
				break;
			case S_POLICY:
				rc = e1.v2.compareTo(e2.v2);
				break;
			case S_PE:
				rc = e1.v3.compareTo(e2.v3);
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
	private NetworkPartitioning partitioning;

	private Table mappingTable;
	private TableViewer mappingViewer;
	private MappingContentComparator mappingComparator;

	private Table schedulingTable;
	private TableViewer schedulingViewer;
	private SchedulingContentComparator schedulingComparator;

	private final int M_ACTOR = 0;
	private final int M_COMPONENT = 1;

	private final int S_PE = 2;
	private final int S_POLICY = 1;
	private final int S_COMPONENT = 0;

	/** the columns names */
	private final String[] mappingColumnNames = new String[] { "Actor", "Component" };
	private final String[] schedulerColumnNames = new String[] { "Partition", "Scheduling-Policy",
			"Processing Elements" };
	private final static String[] schedulingPolicies;

	static {
		schedulingPolicies = new String[EScheduler.values().length];
		int i = 0;
		for (EScheduler s : EScheduler.values()) {
			schedulingPolicies[i++] = s.getLiteral();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(NETWORK_PARTITIONING)) {
					new XmlNetworkPartitioningWriter().write(partitioning, file);
					setDirty(false);
				}
			}
		} catch (Exception e) {
			Logger.debug("Partitiong file size save error: %s", e.getMessage());
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
				if (FileUtils.getExtension(file).equals(NETWORK_PARTITIONING)) {
					partitioning = new XmlNetworkPartitioningReader().load(file);
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
		String network = partitioning != null ? partitioning.getNetwork() : "";
		lbl.setText("Network: \"" + network + "\"");
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		{ // the mapping table
			mappingTable = new Table(parent, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
			mappingViewer = new TableViewer(mappingTable);
			mappingComparator = new MappingContentComparator();
			mappingViewer.setComparator(mappingComparator);

			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalSpan = 3;
			gridData.heightHint = 300;
			mappingTable.setLayoutData(gridData);

			mappingTable.setLinesVisible(true);
			mappingTable.setHeaderVisible(true);

			// column: actor
			TableColumn column = new TableColumn(mappingTable, SWT.LEFT, M_ACTOR);
			column.setText(mappingColumnNames[M_ACTOR]);
			column.setWidth(400);
			column.addSelectionListener(getMappingSelectionAdapter(column, M_ACTOR));

			// column: component
			column = new TableColumn(mappingTable, SWT.LEFT, M_COMPONENT);
			column.setText(mappingColumnNames[M_COMPONENT]);
			column.setWidth(100);
			column.addSelectionListener(getMappingSelectionAdapter(column, M_COMPONENT));

			// create the mapping viewer
			mappingViewer.setUseHashlookup(true);
			mappingViewer.setColumnProperties(mappingColumnNames);
			mappingViewer.setContentProvider(new MappingContentProvider());
			mappingViewer.setLabelProvider(new MappingTableLabelProvider());

			// Create the cell editors
			CellEditor[] editors = new CellEditor[mappingColumnNames.length];
			editors[M_COMPONENT] = new TextCellEditor(mappingTable);
			// set the editors
			mappingViewer.setCellEditors(editors);
			mappingViewer.setCellModifier(new MappingCellModifier());

			mappingViewer.setInput(partitioning);
		}

		{// the scheduling table

			schedulingTable = new Table(parent, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
			schedulingViewer = new TableViewer(schedulingTable);
			schedulingComparator = new SchedulingContentComparator();
			schedulingViewer.setComparator(schedulingComparator);

			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalSpan = 3;
			gridData.heightHint = 300;
			schedulingTable.setLayoutData(gridData);

			schedulingTable.setLinesVisible(true);
			schedulingTable.setHeaderVisible(true);

			// column: actor
			TableColumn column = new TableColumn(schedulingTable, SWT.LEFT, S_COMPONENT);
			column.setText(schedulerColumnNames[S_COMPONENT]);
			column.setWidth(200);
			column.addSelectionListener(getSchedulingSelectionAdapter(column, S_COMPONENT));

			// column: component
			column = new TableColumn(schedulingTable, SWT.LEFT, S_POLICY);
			column.setText(schedulerColumnNames[S_POLICY]);
			column.setWidth(300);
			column.addSelectionListener(getSchedulingSelectionAdapter(column, S_POLICY));

			// column: processing elements
			column = new TableColumn(schedulingTable, SWT.LEFT, S_PE);
			column.setText(schedulerColumnNames[S_PE]);
			column.setWidth(150);
			column.addSelectionListener(getSchedulingSelectionAdapter(column, S_PE));

			// create the scheduling viewer
			schedulingViewer.setUseHashlookup(true);
			schedulingViewer.setColumnProperties(schedulerColumnNames);
			schedulingViewer.setContentProvider(new SchedulingContentProvider());
			schedulingViewer.setLabelProvider(new SchedulingTableLabelProvider());

			// Create the cell editors
			CellEditor[] editors = new CellEditor[schedulerColumnNames.length];
			editors[S_POLICY] = new ComboBoxCellEditor(schedulingTable, schedulingPolicies);
			editors[S_PE] = new TextCellEditor(schedulingTable);

			// set the editors
			schedulingViewer.setCellEditors(editors);
			schedulingViewer.setCellModifier(new SchedulingCellModifier());

			schedulingViewer.setInput(partitioning);

		}

	}

	/**
	 * Create a new {@link SelectionAdapter} for adding the sorting facility to the
	 * column
	 * 
	 * @param column the mappingTable column
	 * @param index  the column number index
	 * @return
	 */
	private SelectionAdapter getMappingSelectionAdapter(final TableColumn column, final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mappingComparator.setColumn(index);
				int dir = mappingComparator.getDirection();
				mappingViewer.getTable().setSortDirection(dir);
				mappingViewer.getTable().setSortColumn(column);
				mappingViewer.refresh();
			}
		};
		return selectionAdapter;
	}

	/**
	 * Create a new {@link SelectionAdapter} for adding the sorting facility to the
	 * column
	 * 
	 * @param column the mappingTable column
	 * @param index  the column number index
	 * @return
	 */
	private SelectionAdapter getSchedulingSelectionAdapter(final TableColumn column, final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				schedulingComparator.setColumn(index);
				int dir = schedulingComparator.getDirection();
				schedulingViewer.getTable().setSortDirection(dir);
				schedulingViewer.getTable().setSortColumn(column);
				schedulingViewer.refresh();
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

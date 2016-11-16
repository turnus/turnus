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

import static turnus.common.TurnusExtensions.NETWORK_WEIGHT;
import static turnus.common.TurnusExtensions.OPERATORS_COSTS;
import static turnus.common.TurnusExtensions.PROFILING_DYNAMIC;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import turnus.analysis.profiler.dynamic.util.NetworkAbstractWeightBuilder;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.model.analysis.profiler.DynamicProfilingReport;
import turnus.model.common.EOperator;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.io.XmlNetworkWeightWriter;
import turnus.model.mapping.io.XmlOperatorsCostReader;
import turnus.model.mapping.io.XmlOperatorsCostWriter;
import turnus.ui.Icon;
import turnus.ui.util.EclipseUtils;
import turnus.ui.widget.WidgetCreateFile;
import turnus.ui.widget.WidgetSelectFile;
import turnus.ui.wizard.AbstractWizardPage;

/**
 * This class contains the {@link Wizard} for the {@link NetworkWeight} obtained
 * with the {@link NetworkAbstractWeightBuilder}
 * 
 * @author Simone Casale Brunet
 *
 */
public class NetworkAbstractWeightWizard extends Wizard implements IWorkbenchWizard {

	private class StoreOperatorsDialog extends TitleAreaDialog implements ModifyListener {

		private WidgetCreateFile fileChooser;
		private Map<EOperator, Double> map;
		private File file;

		public StoreOperatorsDialog(Map<EOperator, Double> map, Shell parentShell) {
			super(parentShell);
			this.map = map;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			GridLayout layout = new GridLayout(1, false);
			container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			container.setLayout(layout);

			GridData dataFirstName = new GridData();
			dataFirstName.grabExcessHorizontalSpace = true;
			dataFirstName.horizontalAlignment = GridData.FILL;

			String[] inputs = { OPERATORS_COSTS };
			fileChooser = new WidgetCreateFile("File", "Select the operator cost file", inputs, null, container);
			fileChooser.addModifyListener(this);

			setErrorMessage("no output file selected");

			return container;
		}

		@Override
		public void create() {
			super.create();
			setTitle("Store the opartors costs configuration from an XML file");
			setMessage("Select an XML from where the configuration will be stored", IMessageProvider.INFORMATION);
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

		@Override
		protected boolean isResizable() {
			return true;
		}

		@Override
		protected void okPressed() {
			storeFile();
			super.okPressed();
		}

		private void storeFile() {

			try {
				new XmlOperatorsCostWriter().write(map, file);
				Logger.info("Operator cost files stored in \"%s\"", file);
			} catch (TurnusException e) {
				Logger.error(e.getMessage());
			}

		}

		@Override
		public void modifyText(ModifyEvent e) {
			file = fileChooser.getValue();
			if (file != null) {
				// reset the error message
				setErrorMessage(null);
				getButton(IDialogConstants.OK_ID).setEnabled(true);
				return;
			}

			file = null;
			setErrorMessage("no output file selected");
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

	}

	private class LoadOperatorsDialog extends TitleAreaDialog implements ModifyListener {

		private WidgetSelectFile fileChooser;
		private Map<EOperator, Double> operatorCostsMap;
		private File file;

		@Override
		public void create() {
			super.create();
			setTitle("Load the operators costs configuration from an XML file");
			setMessage("Select an XML from where the configuration will be loaded", IMessageProvider.INFORMATION);
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			GridLayout layout = new GridLayout(1, false);
			container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			container.setLayout(layout);

			GridData dataFirstName = new GridData();
			dataFirstName.grabExcessHorizontalSpace = true;
			dataFirstName.horizontalAlignment = GridData.FILL;

			String[] inputs = { OPERATORS_COSTS };
			fileChooser = new WidgetSelectFile("File", "Select the operator cost file", inputs, null, container);
			fileChooser.addModifyListener(this);

			setErrorMessage("no input file selected");

			return container;
		}

		@Override
		protected boolean isResizable() {
			return true;
		}

		private void loadFile() {
			EclipseUtils.openDefaultConsole();

			try {
				operatorCostsMap = new XmlOperatorsCostReader().load(file);
				Logger.info("Operator cost files loaded from \"%s\"", file);
			} catch (Exception e) {
				Logger.error(e.getMessage());
				operatorCostsMap = null;
			}

		}

		@Override
		protected void okPressed() {
			loadFile();
			super.okPressed();
		}

		public LoadOperatorsDialog(Shell parentShell) {
			super(parentShell);
		}

		@Override
		public void modifyText(ModifyEvent e) {
			file = fileChooser.getValue();
			if (file != null && file.exists()) {
				// reset the error message
				setErrorMessage(null);
				getButton(IDialogConstants.OK_ID).setEnabled(true);
				return;
			}

			file = null;
			setErrorMessage("no input file selected");
			getButton(IDialogConstants.OK_ID).setEnabled(false);

		}

		public Map<EOperator, Double> getOperatorCostsMap() {
			return operatorCostsMap;
		}

	}

	/**
	 * The unique file page which contains the input and output file widgets
	 * 
	 * @author scb
	 *
	 */
	private class FilesPage extends AbstractWizardPage {

		private WidgetSelectFile wInputFile;
		private WidgetCreateFile wOutputFile;

		private FilesPage() {
			super("Network Abstract weight generator");
			setTitle("Network Abstract weight generator");
			setDescription("Generate a network weight file based on the dynamic profiling data");
		}

		@Override
		protected void createWidgets(Composite container) {

			String[] inputs = { PROFILING_DYNAMIC };
			wInputFile = new WidgetSelectFile("File", "Input file to be exported", inputs, inputFile, container);
			addWidget(wInputFile);

			String[] output = { NETWORK_WEIGHT };
			wOutputFile = new WidgetCreateFile("Output", "Output file", output, null, container);
			addWidget(wOutputFile);

		}

		/**
		 * Get the input file
		 * 
		 * @return
		 */
		public File getInput() {
			return wInputFile.getValue();
		}

		/**
		 * Get the output file
		 * 
		 * @return
		 */
		public File getOutput() {
			return wOutputFile.getValue();
		}

	}

	private class OperatorCostPage extends AbstractWizardPage {

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
						Double newValue = Double.parseDouble(intString);
						oc.setValue(newValue);
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

		private Map<EOperator, Double> operatorCosts;

		private Table table;
		private TableViewer viewer;
		private ContentComparator comparator;

		private OperatorCostPage() {
			super("Operator costs");
			setTitle("Operator costs");
			setDescription("Configure the cost value of each operator");

			// create the operators
			operatorCosts = new HashMap<>();
			for (EOperator o : EOperator.values()) {
				operatorCosts.put(o, 1.0);
			}
		}

		private void loadOperatorsCost(Map<EOperator, Double> map) {
			for (EOperator o : EOperator.values()) {
				if (map.containsKey(o)) {
					operatorCosts.put(o, map.get(o));
				} else {
					operatorCosts.put(o, 0.0);
				}
			}
		}

		private void resetOperatorsCost() {
			for (Entry<EOperator, Double> e : operatorCosts.entrySet()) {
				e.setValue(1.0);
			}
		}

		@Override
		protected void createWidgets(Composite container) {
			final Composite tContainer = new Composite(container, SWT.NONE);
			GridLayout layout = new GridLayout();
			tContainer.setLayout(layout);
			layout.numColumns = 1;

			// build the table and its accessories
			table = new Table(tContainer, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
			viewer = new TableViewer(table);
			comparator = new ContentComparator();
			viewer.setComparator(comparator);

			// set table layout
			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.grabExcessVerticalSpace = true;
			gridData.horizontalSpan = 3;
			gridData.heightHint = 300;
			table.setLayoutData(gridData);
			table.setLinesVisible(true);
			table.setHeaderVisible(true);

			// add table column: operator
			TableColumn column = new TableColumn(table, SWT.LEFT, OPERATOR);
			column.setText(columnNames[OPERATOR]);
			column.setWidth(300);
			column.addSelectionListener(getSelectionAdapter(column, OPERATOR));

			// add table column: cost
			column = new TableColumn(table, SWT.LEFT, COST);
			column.setText(columnNames[COST]);
			column.setWidth(100);
			column.addSelectionListener(getSelectionAdapter(column, COST));

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

			GridData gdata = new GridData(SWT.BORDER, SWT.CENTER, false, false);

			final Composite bContainer = new Composite(tContainer, SWT.NONE);
			layout = new GridLayout();
			bContainer.setLayout(layout);
			layout.numColumns = 3;

			Button button = new Button(bContainer, SWT.PUSH);
			button.setFont(getFont());
			button.setLayoutData(gdata);
			button.setText("Load costs");
			button.setImage(Icon.getImage(Icon.ARROW_090));
			button.addSelectionListener(new LoadButtonListener());

			button = new Button(bContainer, SWT.PUSH);
			button.setFont(getFont());
			button.setLayoutData(gdata);
			button.setText("Save costs");
			button.setImage(Icon.getImage(Icon.ARROW_270));
			button.addSelectionListener(new StoreButtonListener());

			button = new Button(bContainer, SWT.PUSH);
			button.setFont(getFont());
			button.setLayoutData(gdata);
			button.setText("Reset costs");
			button.setImage(Icon.getImage(Icon.ARROW_CIRCLE));
			button.addSelectionListener(new ClearButtonListener());

			// Pack the columns
			for (int i = 0, n = table.getColumnCount(); i < n; i++) {
				table.getColumn(i).pack();
			}

			// finally, set the container
			setControl(tContainer);
		}

		public Map<EOperator, Double> getOperatorsCost() {
			return operatorCosts;
		}

		public boolean isPageComplete() {
			return true;
		}

		private class StoreButtonListener implements SelectionListener {

			@Override
			public void widgetSelected(SelectionEvent e) {
				new StoreOperatorsDialog(operatorCosts, getShell()).open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		}

		private class LoadButtonListener implements SelectionListener {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LoadOperatorsDialog page = new LoadOperatorsDialog(getShell());
				page.open();

				Map<EOperator, Double> map = page.getOperatorCostsMap();
				if (map != null) {
					loadOperatorsCost(map);
					viewer.refresh();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		}

		private class ClearButtonListener implements SelectionListener {

			@Override
			public void widgetSelected(SelectionEvent e) {
				resetOperatorsCost();
				viewer.refresh();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		}

		/**
		 * Create a new {@link SelectionAdapter} for adding the sorting facility
		 * to the column
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

	}

	private FilesPage filesPage;
	private OperatorCostPage operatorsPage;
	private File inputFile;

	public NetworkAbstractWeightWizard() {
		super();

		filesPage = new FilesPage();
		operatorsPage = new OperatorCostPage();

		setNeedsProgressMonitor(true);

		EclipseUtils.openDefaultConsole();
	}

	@Override
	public void addPages() {
		addPage(filesPage);
		addPage(operatorsPage);
	}

	public void configure(File inputFile) {
		this.inputFile = null;
		try {
			String extension = FileUtils.getExtension(inputFile);
			if (PROFILING_DYNAMIC.equals(extension)) {
				this.inputFile = inputFile;
			}
		} catch (Exception e) {
		}

	}

	@Override
	public boolean performFinish() {
		try {

			File inputFile = filesPage.getInput();
			File outputFile = filesPage.getOutput();
			Map<EOperator, Double> costMap = operatorsPage.getOperatorsCost();

			DynamicProfilingReport report = EcoreUtils.loadEObject(new ResourceSetImpl(), inputFile);
			if (report == null) {
				Logger.error("File \"%s\" is not a valied dnymic data report file", inputFile);
				return false;
			}

			NetworkWeight weight = new NetworkAbstractWeightBuilder(report, costMap).getWeights();
			new XmlNetworkWeightWriter().write(weight, outputFile);

			Logger.info("File exported in \"%s\"", outputFile);
			EclipseUtils.refreshWorkspace(new NullProgressMonitor());

			return true;
		} catch (Exception e) {
			Logger.error("Abstract weights cannot be exported. Error: \"%s\"", e.getMessage());
		}

		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IFile) {
			try {
				configure(FileUtils.getFile((IFile) selection.getFirstElement()));
			} catch (TurnusException e) {
				e.printStackTrace();
			}
		}
	}

}

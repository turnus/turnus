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

import static turnus.common.TurnusExtensions.NETWORK;
import static turnus.common.TurnusExtensions.NETWORK_WEIGHT;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import turnus.common.io.Logger;
import turnus.common.util.EcoreUtils;
import turnus.common.util.FileUtils;
import turnus.common.util.Pair;
import turnus.model.dataflow.Network;
import turnus.model.mapping.NetworkWeight;
import turnus.model.mapping.data.ClockCycles;
import turnus.model.mapping.io.XmlNetworkWeightReader;
import turnus.model.mapping.io.XmlNetworkWeightWriter;
import turnus.ui.Icon;
import turnus.ui.widget.WidgetSelectFile;

/**
 * This class contains the {@link EditorPart} for the {@link NetworkWeight}
 * file.
 * 
 * @author Simone Casale Brunet
 *
 */
public class NetworkWeightEditor extends EditorPart {

	public class TestDialog extends Dialog implements ModifyListener {

		private WidgetSelectFile widget;

		public TestDialog(Shell parentShell) {
			super(parentShell);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite container = (Composite) super.createDialogArea(parent);
			widget = new WidgetSelectFile("Network file", "The network file", NETWORK, null, container);
			widget.addModifyListener(this);

			return container;
		}

		@Override
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			// set the title of the dialog
			newShell.setText("Network file test");
		}

		@Override
		protected Point getInitialSize() {
			return new Point(400, 200);
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (weights != null) {
				File file = widget.getValue();
				if (file != null && file.exists()) {
					Network network = EcoreUtils.loadEObject(new ResourceSetImpl(), file);
					if (weights.isValid(network)) {
						MessageDialog.openInformation(getShell(), "Ok",
								"This weight file can be used for this network");
					} else {
						MessageDialog.openError(getShell(), "Error",
								"This weight file cannot be used for this network");
					}
				}
			} else {
				MessageDialog.openError(getShell(), "Error", "Weight file not loaded");
			}
		}
	}

	/**
	 * This class defines the cell modifier
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class CellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object obj, String property) {
			return obj instanceof Pair && !property.equals(columnNames[ACTOR_ACTION]);
		}

		@Override
		@SuppressWarnings("unchecked")
		public Object getValue(Object obj, String property) {

			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);
			String result = "";
			if (obj instanceof String) {
				if (columnIndex == ACTOR_ACTION) {
					result = (String) obj;
				}
			} else if (obj instanceof Pair) {
				Pair<String, String> pair = (Pair<String, String>) obj;
				switch (columnIndex) {
				case ACTOR_ACTION: {
					result = pair.v2;
					break;
				}
				case CLOCK_MEAN: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMeanClockCycles());
				}
				case CLOCK_MIN: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMinClockCycles());
				}
				case CLOCK_MAX: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMaxClockCycles());
				}
				default:
					break;
				}
			}

			return result;
		}

		@Override
		public void modify(Object element, String property, Object value) {
			int columnIndex = Arrays.asList(columnNames).indexOf(property);

			if (columnIndex != ACTOR_ACTION) {
				String intString = (String) value;
				if (intString.matches("[+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")) {
					TreeItem item = (TreeItem) element;
					@SuppressWarnings("unchecked")
					Pair<String, String> pair = (Pair<String, String>) item.getData();
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					Double newCost = Double.parseDouble(intString);

					switch (columnIndex) {
					case CLOCK_MEAN: {

						if (w.getMeanClockCycles() != newCost) {
							w.setMeanClockCycles(newCost);

							// check consistency and update accordingly
							double min = w.getMinClockCycles();
							double max = w.getMaxClockCycles();
							if (newCost < min) {
								w.setMinClockCycles(newCost);
							} else if (newCost > max) {
								w.setMaxClockCycles(newCost);
							}

							setDirty(true);
						}
						break;

					}
					case CLOCK_MIN: {
						if (w.getMinClockCycles() != newCost) {
							w.setMinClockCycles(newCost);

							// check consistency and update accordingly
							double mean = w.getMeanClockCycles();
							double max = w.getMaxClockCycles();
							if (newCost > mean) {
								w.setMeanClockCycles(newCost);
							}
							if (newCost > max) {
								w.setMaxClockCycles(newCost);
							}

							setDirty(true);
						}
						break;
					}
					case CLOCK_MAX: {
						if (w.getMaxClockCycles() != newCost) {
							w.setMaxClockCycles(newCost);

							// check consistency and update accordingly
							double mean = w.getMeanClockCycles();
							double min = w.getMinClockCycles();
							if (newCost < mean) {
								w.setMeanClockCycles(newCost);
							}
							if (newCost < min) {
								w.setMinClockCycles(newCost);
							}

							setDirty(true);
						}
						break;
					}
					default:
						break;
					}

					viewer.refresh();
				}
			}
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
		public int compare(Viewer viewer, Object o1, Object o2) {

			int rc = 0;

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
	 * This class defines the content provider
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class ContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getChildren(Object obj) {
			if (obj instanceof NetworkWeight) {
				return weights.asTable().rowKeySet().toArray();

			} else if (obj instanceof String) {
				List<Pair<String, String>> pairs = new ArrayList<>();
				String actor = (String) obj;
				for (String action : weights.asTable().row(actor).keySet()) {
					pairs.add(Pair.create(actor, action));
				}
				return pairs.toArray();
			}
			return new Object[0];
		}

		@Override
		@SuppressWarnings("unchecked")
		public Object getParent(Object obj) {
			if (obj instanceof String) {
				return weights;
			} else if (obj instanceof Pair) {
				return ((Pair<String, String>) obj).v1;
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object obj) {
			if (obj instanceof NetworkWeight) {
				return true;
			} else if (obj instanceof String) {
				return true;
			}
			return false;
		}

		@Override
		public Object[] getElements(Object input) {
			if (input instanceof NetworkWeight) {
				return weights.asTable().rowKeySet().toArray();
			} else if (input instanceof String) {
				List<Pair<String, String>> pairs = new ArrayList<>();
				String actor = (String) input;
				for (String action : weights.asTable().row(actor).keySet()) {
					pairs.add(Pair.create(actor, action));
				}
				return pairs.toArray();
			}
			return new Object[0];
		}
	}

	/**
	 * This class defines the label provider for the Instances Mapping Tab
	 * 
	 * @author Simone Casale Brunet
	 * 
	 */
	private class TreeLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {

			return null;
		}

		@Override
		@SuppressWarnings("unchecked")
		public String getColumnText(Object obj, int columnIndex) {
			String result = "";
			if (obj instanceof String) {
				if (columnIndex == ACTOR_ACTION) {
					result = (String) obj;
				}
			} else if (obj instanceof Pair) {
				Pair<String, String> pair = (Pair<String, String>) obj;
				switch (columnIndex) {
				case ACTOR_ACTION: {
					result = pair.v2;
					break;
				}
				case CLOCK_MEAN: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMeanClockCycles());
				}
				case CLOCK_MIN: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMinClockCycles());
				}
				case CLOCK_MAX: {
					ClockCycles w = weights.getWeight(pair.v1, pair.v2);
					return Double.toString(w.getMaxClockCycles());
				}
				default:
					break;
				}
			}

			return result;
		}
	}

	private NetworkWeight weights;
	private boolean isDirty = false;

	private final int ACTOR_ACTION = 0;
	private final int CLOCK_MEAN = 1;
	private final int CLOCK_MIN = 2;
	private final int CLOCK_MAX = 3;

	private final String[] columnNames = new String[] { "Actor, Action", "CC (mean)", "CC (min)", "CC (max)" };

	private Tree tree;
	private TreeViewer viewer;
	private ContentComparator comparator;

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			IEditorInput input = getEditorInput();
			if (input instanceof FileEditorInput) {
				File file = FileUtils.getFile(((FileEditorInput) input).getFile());
				if (FileUtils.getExtension(file).equals(NETWORK_WEIGHT)) {
					new XmlNetworkWeightWriter().write(weights, file);
					setDirty(false);
				}
			}
		} catch (Exception e) {
			Logger.debug("Network weight save error: %s", e.getMessage());
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
				if (FileUtils.getExtension(file).equals(NETWORK_WEIGHT)) {
					weights = new XmlNetworkWeightReader().load(file);
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

		String network = weights != null ? weights.getNetwork() : "";

		Label lbl = new Label(parent, SWT.NONE);
		lbl.setFont(parent.getFont());
		lbl.setText("Network: \"" + network + "\"");
		lbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		tree = new Tree(parent, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		gridData.heightHint = 300;
		tree.setLayoutData(gridData);

		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		viewer = new TreeViewer(tree);
		comparator = new ContentComparator();
		viewer.setComparator(comparator);

		// Actor, Action
		TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		column.setText(columnNames[ACTOR_ACTION]);
		column.setWidth(200);
		column.addSelectionListener(getSelectionAdapter(column, ACTOR_ACTION));

		// Clock Cycles
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText(columnNames[CLOCK_MEAN]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, CLOCK_MEAN));
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText(columnNames[CLOCK_MIN]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, CLOCK_MIN));
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText(columnNames[CLOCK_MAX]);
		column.setWidth(100);
		column.addSelectionListener(getSelectionAdapter(column, CLOCK_MAX));

		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setCellModifier(new CellModifier());

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[CLOCK_MEAN] = new TextCellEditor(tree);
		editors[CLOCK_MIN] = new TextCellEditor(tree);
		editors[CLOCK_MAX] = new TextCellEditor(tree);
		// set the editors
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new CellModifier());

		// finally set the input
		viewer.setInput(weights);

		final Menu menu = new Menu(tree);
		tree.setMenu(menu);
		menu.addMenuListener(new MenuAdapter() {
			public void menuShown(MenuEvent e) {
				MenuItem[] items = menu.getItems();
				for (int i = 0; i < items.length; i++) {
					items[i].dispose();
				}
				MenuItem testNetwork = new MenuItem(menu, SWT.NONE);
				testNetwork.setText("Test with a newtork file");
				testNetwork.setImage(Icon.getImage(Icon.DOCUMENT_CONVERT));
				testNetwork.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						new TestDialog(getSite().getShell()).open();

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
			}
		});

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
	private SelectionAdapter getSelectionAdapter(final TreeColumn column, final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				viewer.getTree().setSortDirection(dir);
				viewer.getTree().setSortColumn(column);
				viewer.refresh();
			}
		};
		return selectionAdapter;
	}

	@Override
	public void setFocus() {
		if (tree != null) {
			tree.setFocus();
		}

	}

	private void setDirty(boolean value) {
		isDirty = value;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

}

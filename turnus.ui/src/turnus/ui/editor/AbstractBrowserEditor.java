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
package turnus.ui.editor;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import turnus.common.TurnusException;
import turnus.ui.util.HtmlUtils;

/**
 * This class defines an extensible browser editor.
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class AbstractBrowserEditor extends EditorPart {

	/** The text widget */
	private Browser browser;
	/** The html text */
	private String htmlText = "";
	/** The input file */
	private IFile file;
	/** the collection of css styles to be added */
	private Set<String> css = new HashSet<String>();
	/** the collection of java-scripts to be added */
	private Set<String> js = new HashSet<String>();
	/** the browser menu */
	private Menu menu;

	public AbstractBrowserEditor() {
		super();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
		setSite(site);
		setInput(editorInput);
		setPartName(editorInput.getName());

		try {
			IFile file = ((FileEditorInput) editorInput).getFile();
			htmlText = toHtml(file);
			htmlText = HtmlUtils.appendStyle(htmlText, css.toArray(new String[0]));
			htmlText = HtmlUtils.appendJs(htmlText, js.toArray(new String[0]));
		} catch (Exception e) {
			htmlText = "<p>Error processing the file</p>";
			file = null;
		}
	}

	/**
	 * Parse the IFile and return an HTML string representation
	 * 
	 * @param file
	 * @return
	 */
	protected abstract String toHtml(IFile file) throws TurnusException;

	/**
	 * Add a css file as style
	 * 
	 * @param css
	 */
	protected void addStyle(String... css) {
		for (String c : css) {
			this.css.add(c);
		}
	}

	/**
	 * Add a java-script
	 * 
	 * @param js
	 */
	protected void addJs(String... js) {
		for (String j : js) {
			this.js.add(j);
		}
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		FillLayout layout = new FillLayout();
		composite.setLayout(layout);
		browser = new Browser(composite, SWT.NONE);
		browser.setText(htmlText);
		menu = new Menu(browser);
		addMenuItems(menu);
		menu.setVisible(true);
		browser.setMenu(menu);
		
	}

	/**
	 * Populate the browser menu
	 * 
	 * @param menu
	 */
	protected void addMenuItems(Menu menu) {
	}

	@Override
	public void setFocus() {
	}

	/**
	 * Get the current IFile
	 * 
	 * @return
	 */
	protected IFile getFile() {
		return file;
	}

}

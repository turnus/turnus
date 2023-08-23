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
package turnus.ui.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.ide.IDE;

import turnus.common.TurnusConstants;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.ui.TurnusUiConstants;

/**
 * This class contains some utilities methods for the Eclipse user interface
 * 
 * @author Simone Casale Brunet
 *
 */
public class EclipseUtils {

	private static ResourceSet resourceSet = new ResourceSetImpl();

	/**
	 * Create a resource from the given URI and append a new Diagram instance to
	 * its contents. The resourceSet used must be authorized to write on the
	 * disk. This means that the default EditingDomain's resourceSet must be
	 * used in a write transaction (for example). If it is not possible, do not
	 * provide a resourceSet, the default one will be used.
	 * 
	 * @param resourceSet
	 * @param uri
	 * @param diagramType
	 * @return The Diagram created
	 * @throws IOException
	 */
	public static Diagram createDiagramResource(String diagramType, final ResourceSet resourceSet, final URI uri)
			throws IOException {
		// Compute the new diagram name
		final String name = uri.trimFileExtension().lastSegment();

		// Create the diagram
		final Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramType, name, true);

		// Create the resource
		Resource res = resourceSet.createResource(uri);
		res.getContents().add(diagram);
		res.setTrackingModification(true);
		res.save(Collections.EMPTY_MAP);

		return diagram;
	}

	/**
	 * Create a resource from the given URI and append a new Diagram instance to
	 * its contents. The default internal resourceSet is used.
	 * 
	 * @param uri
	 * @return
	 * @throws IOException
	 * @see {@link #createDiagramResource(ResourceSet, URI)}
	 */
	public static Diagram createDiagramResource(String diagramType, final URI uri) throws IOException {
		return createDiagramResource(diagramType, resourceSet, uri);
	}

	/**
	 * Get the console with the given name. If the console does not exist, then
	 * a new one is created.
	 * 
	 * @param name
	 * @return
	 */
	public static MessageConsole getConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}

		// no console found, so create a new one
		MessageConsole console = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { console });

		// create a new logger handler
		Logger.addHandler(new EclipseConsoleHandler(console));

		return console;
	}

	/**
	 * Get the default TURNUS console
	 * 
	 * @return
	 */
	public static MessageConsole getDefaultConsole() {
		return getConsole(TurnusUiConstants.DEFAULT_CONSOLE_NAME);
	}

	/**
	 * Get the default shell
	 * 
	 * @return
	 */
	public static Shell getDefaultShell() {
		return PlatformUI.getWorkbench().getDisplay().getActiveShell();
	}

	/**
	 * Import a project to the workspace
	 * 
	 * @param path
	 * @param monitor
	 * @throws Exception
	 */
	public static void importProjectToWorkspace(File path, IProgressMonitor monitor) throws Exception {
		IPath projectPath = Path.fromOSString(path.getAbsolutePath()).append(".project");
		IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(projectPath);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
		project.create(description, monitor);
		project.open(monitor);
	}

	/**
	 * Open the default console
	 */
	public static void openDefaultConsole() {
		try {
			// open a new console in the active workbench window
			MessageConsole console = getDefaultConsole();
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IConsoleView view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
			view.display(console);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open an editor given a file
	 * 
	 * @param file
	 * @throws TurnusException
	 */
	public static void openFileEditor(File file) throws TurnusException {
		if (file.exists() && file.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(file.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (Exception e) {
				throw new TurnusException("The editor cannot be opened for the file \"" + file + "\"", e);
			}
		} else {
			throw new TurnusException("The file \"" + file + "\" does not exist or is not a file");
		}
	}

	/**
	 * Open an editor given a file
	 * 
	 * @param file
	 * @throws TurnusException
	 */
	public static void openFileEditor(IFile file) throws TurnusException {
		openFileEditor(FileUtils.getFile(file));
	}

	/**
	 * Refresh the Eclipse workspace
	 * 
	 * @param monitor
	 */
	public static void refreshWorkspace(IProgressMonitor monitor) {
		try {
			if (monitor == null || monitor.isCanceled()) {
				monitor = new NullProgressMonitor();
			}
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (Exception e) {
			Logger.warning("The workspace cannot be refreshed");
		}
	}
	
	
	/**
	 * Get Current Eclipse project if an editor is open
	 * @return
	 */
	public static IProject getCurrentProject() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage activePage = window.getActivePage();

		IEditorPart activeEditor = activePage.getActiveEditor();
		
		IProject project = null;
		if (activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();

			project = input.getAdapter(IProject.class);
			if (project == null) {
				IResource resource = input.getAdapter(IResource.class);
				if (resource != null) {
					project = resource.getProject();
				}
			}
		}
		return project;
	}

	public static List<String> getPathsFromContainer(IContainer container, String[] extensions) {
		List<String> files = new ArrayList<>();
		IResource[] members;
		try {
			members = container.members();
			for (IResource member : members) {
				if (member instanceof IContainer) {
					String name = member.getName();
					if (!name.contains(TurnusConstants.SPLIT_TRACE_PATH_NAME))
						files.addAll(getPathsFromContainer((IContainer) member, extensions));
				} else if (member instanceof IFile) {
					IFile iFile = (IFile) member;
					String extension = iFile.getFileExtension();
					if (ArrayUtils.contains(extensions, extension)) {
						File file = iFile.getLocation().toFile();
						String path = file.getAbsolutePath();
						files.add(path);
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;

	}
	
	

}

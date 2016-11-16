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
package turnus.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;

import turnus.common.io.Logger;

/**
 * This class contains some utilities methods for the Eclipse framework.
 * 
 * @author Simone Casale Brunet
 *
 */
public class EcoreUtils {

	/**
	 * Get the project with the given name that is registered in the current
	 * working directory. No exceptions are thrown: if the project cannot be
	 * loaded then a <code>null</code> value is returned.
	 * 
	 * @param name
	 *            the project name
	 * @return the project if exists, <code>null</code> otherwise
	 */
	public static IProject getProject(String name) {
		IProject project = null;
		try {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			if (root.getFullPath().isValidSegment(name)) {
				project = root.getProject(name);
			}
		} catch (Exception e) {
		}
		return project;
	}

	/**
	 * Returns the list of source folders of the given project as a list of
	 * absolute workspace paths.
	 * 
	 * @param project
	 *            a project
	 * @return a list of absolute workspace paths
	 */
	public static List<IFolder> getSourceFolders(IProject project) {
		List<IFolder> srcFolders = new ArrayList<IFolder>();

		try {
			IJavaProject javaProject = JavaCore.create(project);
			if (!javaProject.exists()) {
				return srcFolders;
			}

			// iterate over package roots
			for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots()) {
				IResource resource = root.getCorrespondingResource();
				if (resource != null && resource.getType() == IResource.FOLDER) {
					srcFolders.add((IFolder) resource);
				}
			}
		} catch (CoreException e) {
			Logger.debug("Get source folder exception: %s", e);
		}

		return srcFolders;
	}

	/**
	 * Load an {@link EObject} given a {@link ResourceSet} and a {@link File}.
	 * If the object cannot be loaded, <code>null</code> is returned without
	 * throwing any exceptions.
	 * 
	 * @param set
	 *            the resource set
	 * @param file
	 *            the file
	 * @return the object if it has been loaded, <code>null</code> otherwise
	 */
	public static <T extends EObject> T loadEObject(ResourceSet set, File file) {
		try {
			URI uri = FileUtils.createFileURI(file);
			return loadEObject(set, uri);
		} catch (Exception e) {
			Logger.debug("LoadEObject from file \"%s\" exception: %s", file, e);
			return null;
		}
	}

	/**
	 * Load an {@link EObject} given a {@link ResourceSet} and a {@link IFile}.
	 * If the object cannot be loaded, <code>null</code> is returned without
	 * throwing any exceptions.
	 * 
	 * @param set
	 *            the resource set
	 * @param file
	 *            the file
	 * @return the object if it has been loaded, <code>null</code> otherwise
	 */
	public static <T extends EObject> T loadEObject(ResourceSet set, IFile file) {
		try {
			URI uri = FileUtils.createFileURI(file);
			return loadEObject(set, uri);
		} catch (Exception e) {
			Logger.debug("LoadEObject from IFile \"%s\" exception: %s", file, e);
			return null;
		}
	}

	/**
	 * Load an {@link EObject} given a {@link ResourceSet} and a {@link URI}. If
	 * the object cannot be loaded, <code>null</code> is returned without
	 * throwing any exceptions.
	 * 
	 * @param set
	 *            the resource set
	 * @param uri
	 *            the resource uri
	 * @return the object if it has been loaded, <code>null</code> otherwise
	 */
	public static <T extends EObject> T loadEObject(ResourceSet set, URI uri) {
		try {
			Resource resource = set.getResource(uri, true);
			EList<EObject> contents = resource.getContents();
			if (contents.isEmpty()) {
				return null;
			}
			@SuppressWarnings("unchecked")
			T object = (T) contents.get(0);
			EcoreUtil.resolveAll(set);
			return object;
		} catch (RuntimeException e) {
			Logger.debug("LoadEObject from URI \"%s\" exception: %s", uri, e);
			return null;
		}

	}

	/**
	 * Store an {@link EObject} using the given {@link ResourceSet} and
	 * {@link File}. If the object cannot be store, <code>false</code> is
	 * returned without throwing any exceptions.
	 * 
	 * @param object
	 *            the object
	 * @param set
	 *            the resource set
	 * @param file
	 *            the file
	 * @return <code>true</code> if the object has been stored,
	 *         <code>false</code> otherwise
	 */
	public static boolean storeEObject(EObject object, ResourceSet set, File file) {
		try {
			URI uri = FileUtils.createFileURI(file);
			return storeEObject(object, set, uri);
		} catch (Exception e) {
			Logger.debug("Store Object to file \"%s\" exception: %s", file, e);
			return false;
		}
	}

	/**
	 * Store an {@link EObject} using the given {@link ResourceSet} and
	 * {@link IFile}. If the object cannot be store, <code>false</code> is
	 * returned without throwing any exceptions.
	 * 
	 * @param object
	 *            the object
	 * @param set
	 *            the resource set
	 * @param file
	 *            the file
	 * @return <code>true</code> if the object has been stored,
	 *         <code>false</code> otherwise
	 */
	public static boolean storeEObject(EObject object, ResourceSet set, IFile file) {
		try {
			URI uri = FileUtils.createFileURI(file);
			return storeEObject(object, set, uri);
		} catch (Exception e) {
			Logger.debug("StoreObject to IFile \"%s\" exception: %s", file, e);
			return false;
		}
	}

	/**
	 * Store an {@link EObject} using the given {@link ResourceSet} and
	 * {@link URI}. If the object cannot be store, <code>false</code> is
	 * returned without throwing any exceptions.
	 * 
	 * @param object
	 *            the object
	 * @param set
	 *            the resource set
	 * @param uri
	 *            the resource uri
	 * @return <code>true</code> if the object has been stored,
	 *         <code>false</code> otherwise
	 */
	public static boolean storeEObject(EObject object, ResourceSet set, URI uri) {
		try {
			Resource resource = set.createResource(uri);
			resource.getContents().add(object);
			resource.save(Collections.EMPTY_MAP);
			return true;
		} catch (Exception e) {
			Logger.debug("StoreObject to URI \"%s\" exception: %s", uri, e);
			return false;
		}
	}

}

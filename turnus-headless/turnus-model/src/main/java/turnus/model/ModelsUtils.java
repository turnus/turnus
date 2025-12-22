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
package turnus.model;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import turnus.model.architecture.Architecture;
import turnus.model.architecture.ArchitectureFactory;

public class ModelsUtils {
	
private static ResourceSet resourceSet = new ResourceSetImpl();
	
	/**
	 * Create a resource from the given URI and append a new Architecture instance to
	 * its contents. The default internal resourceSet is used.
	 * 
	 * @param uri
	 * @return the created architecture
	 * @throws IOException
	 * @see {@link #createArchitectureResource(ResourceSet, URI)}
	 */
	public static Architecture createArchitectureResource(final URI uri) throws IOException {
		return createArchitectureResource(resourceSet, uri);
	}
	
	/**
	 * Create a resource from the given URI and append a new Architecture instance to
	 * its contents. The resourceSet used must be authorized to write on the
	 * disk. This means that the default EditingDomain's resourceSet must be
	 * used in a write transaction (for example). If it is not possible, do not
	 * provide a resourceSet, the default one will be used.
	 * 
	 * @param resourceSet
	 * @param uri
	 * @return the created architecture
	 * @throws IOException
	 */
	public static Architecture createArchitectureResource(final ResourceSet resourceSet, final URI uri) throws IOException {
		// Create the architecture
		final Architecture architecture = ArchitectureFactory.eINSTANCE.createArchitecture();

		// Compute the new architecture name
		final Path networkPath = new Path(uri.trimFileExtension().path());
		// 3 first segments are resource/<PROJECT>/src
		architecture.setName(networkPath.removeFirstSegments(3).toString()
				.replace('/', '.'));

		// Create the resource
		Resource res = resourceSet.createResource(uri);
		res.getContents().add(architecture);
		res.save(Collections.EMPTY_MAP);

		return architecture;
	}

}

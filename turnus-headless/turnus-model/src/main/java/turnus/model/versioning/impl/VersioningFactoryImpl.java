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
package turnus.model.versioning.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.common.io.Logger;
import turnus.model.Activator;
import turnus.model.versioning.Version;
import turnus.model.versioning.Versioner;
import turnus.model.versioning.VersioningFactory;
import turnus.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class VersioningFactoryImpl extends EFactoryImpl implements VersioningFactory {

	/** the set of names of the registered versioners */
	private List<String> versioners;

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static VersioningFactory init() {
		try {
			VersioningFactory theVersioningFactory = (VersioningFactory) EPackage.Registry.INSTANCE
					.getEFactory(VersioningPackage.eNS_URI);
			if (theVersioningFactory != null) {
				return theVersioningFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VersioningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public VersioningFactoryImpl() {
		super();

		versioners = new ArrayList<>();
		try {
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] elements = registry.getConfigurationElementsFor(Activator.PLUGIN_ID + ".versioner");
			for (IConfigurationElement element : elements) {
				try {
					String name = element.getAttribute("name");
					if (name == null) {
						Logger.error("There is a versioner without name. It cannot be registered");
					} else if (versioners.contains(name)) {
						Logger.error("There is already a versioner named \"%s\"", name);
					} else {
						versioners.add(name);
						Logger.debug("Versioner \"%s\" has been registered", name);
					}

				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			Logger.debug("Error while initializing the versioning factory. No versioners can be registered");
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case VersioningPackage.VERSION:
			return createVersion();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VersioningPackage getVersioningPackage() {
		return (VersioningPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VersioningPackage getPackage() {
		return VersioningPackage.eINSTANCE;
	}

	@Override
	public String[] getRegisteredVersioners() {
		return versioners.toArray(new String[0]);
	}

	@Override
	public Versioner getVersioner(String name) {
		if (versioners.contains(name)) {
			try {
				IExtensionRegistry registry = Platform.getExtensionRegistry();
				IConfigurationElement[] elements = registry
						.getConfigurationElementsFor(Activator.PLUGIN_ID + ".versioner");
				for (IConfigurationElement element : elements) {
					try {
						if (name.equals(element.getAttribute("name"))) {
							Versioner v = (Versioner) element.createExecutableExtension("class");
							return v;
						}
					} catch (CoreException e) {
						Logger.warning("Versioning factory: " + e.getMessage());
					}
				}
			} catch (Exception e) {
				Logger.error("Error while loading the versioning factory: " + e.getMessage());
			}
		} else {
			Logger.error("No versioner with name \"%s\" is registered. The git versioner will be used", name);
		}

		return new GitVersioner();
	}

} // VersioningFactoryImpl

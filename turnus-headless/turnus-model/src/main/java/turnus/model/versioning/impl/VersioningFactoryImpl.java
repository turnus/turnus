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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import turnus.common.io.Logger;
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

	/** Versioner name constants */
	public static final String VERSIONER_GIT = "Git versioner";
	public static final String VERSIONER_FILE_PROPERTIES = "File properties versioner";

	/** Map of versioner names to their factory suppliers */
	private Map<String, Supplier<Versioner>> versioners;

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

		versioners = new LinkedHashMap<>();
		
		// Register built-in versioners
		registerVersioner(VERSIONER_GIT, GitVersioner::new);
		registerVersioner(VERSIONER_FILE_PROPERTIES, FilePropertiesVersioner::new);
		
		Logger.debug("Versioning factory initialized with %d versioners", versioners.size());
	}

	/**
	 * Register a versioner
	 * 
	 * @param name the versioner name
	 * @param supplier a supplier that creates new versioner instances
	 */
	public void registerVersioner(String name, Supplier<Versioner> supplier) {
		if (name == null) {
			Logger.error("Cannot register versioner without name");
			return;
		}
		if (versioners.containsKey(name)) {
			Logger.warning("Overwriting existing versioner named \"%s\"", name);
		}
		versioners.put(name, supplier);
		Logger.debug("Versioner \"%s\" has been registered", name);
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
		return versioners.keySet().toArray(new String[0]);
	}

	@Override
	public Versioner getVersioner(String name) {
		Supplier<Versioner> supplier = versioners.get(name);
		if (supplier != null) {
			try {
				return supplier.get();
			} catch (Exception e) {
				Logger.error("Error creating versioner \"%s\": %s", name, e.getMessage());
			}
		}
		
		Logger.warning("No versioner found with name \"%s\". Using Git versioner as default.", name);
		return new GitVersioner();
	}

} // VersioningFactoryImpl

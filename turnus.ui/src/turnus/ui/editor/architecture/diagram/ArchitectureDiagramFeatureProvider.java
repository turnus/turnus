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
package turnus.ui.editor.architecture.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import turnus.ui.editor.architecture.feature.AutoLayoutFeauture;
import turnus.ui.editor.architecture.feature.UpdateDiagramFeature;
import turnus.ui.editor.architecture.pattern.CpuPattern;
import turnus.ui.editor.architecture.pattern.DspPattern;
import turnus.ui.editor.architecture.pattern.FpgaPattern;
import turnus.ui.editor.architecture.pattern.LinkPattern;
import turnus.ui.editor.architecture.pattern.MediumPattern;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class ArchitectureDiagramFeatureProvider extends DefaultFeatureProviderWithPatterns {

	private final UpdateDiagramFeature updateFeature;
	private final ICustomFeature layoutFeatures;

	public ArchitectureDiagramFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new CpuPattern());
		addPattern(new DspPattern());
		addPattern(new FpgaPattern());
		addPattern(new MediumPattern());
		addConnectionPattern(new LinkPattern());

		updateFeature = new UpdateDiagramFeature(this);
		layoutFeatures = new AutoLayoutFeauture(this);
	}

	@Override
	protected IUpdateFeature getUpdateFeatureAdditional(IUpdateContext context) {
		return updateFeature;
	}

	/**
	 * Return the default layout feature
	 * 
	 * @return
	 */
	public ICustomFeature getDefaultLayoutFeature() {
		return layoutFeatures;
	}

	/**
	 * We never want to remove elements from the diagram. We always want to
	 * delete them. So it is useless to display the menu entry, the button in
	 * the contextual palette. This feature is globally disabled
	 */
	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return new DefaultRemoveFeature(this) {
			@Override
			public boolean isAvailable(IContext context) {
				return false;
			}
		};
	}

}

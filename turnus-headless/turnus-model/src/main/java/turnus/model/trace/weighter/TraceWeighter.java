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
package turnus.model.trace.weighter;

import turnus.model.trace.Dependency;
import turnus.model.trace.Step;

/**
 * This interface defines a trace weighter. A trace weighter is used to assign a
 * weight for each step and dependency. Furthermore, it provides the variance of
 * each weight.
 * 
 * @author Simone Casale Brunet
 *
 */
public interface TraceWeighter extends Cloneable {

	/**
	 * Clone the weighter
	 * 
	 * @return
	 */
	TraceWeighter clone();

	/**
	 * Get the variance value for the given dependency
	 * 
	 * @param step
	 * @return
	 */
	double getVariance(Dependency dependency);

	/**
	 * Get the variance value for the given step
	 * 
	 * @param step
	 * @return
	 */
	double getVariance(Step step);

	/**
	 * Get the weight value for the given dependency
	 * 
	 * @param step
	 * @return
	 */
	double getWeight(Dependency dependency);

	/**
	 * Get the weight value for the given step
	 * 
	 * @param step
	 * @return
	 */
	double getWeight(Step step);

	/**
	 * Modify the weight values for all the steps of the given action. The scale
	 * factor defines how much the weight are scaled. As an example if the
	 * weight of a step is 1.4 and the ratio is 0.2, hence the resulting weight
	 * is 1.4*0.2=0.28
	 * 
	 * @param actor
	 *            the actor name
	 * @param action
	 *            the action name
	 * @param scale
	 *            the ratio value
	 */
	public void setRatio(String actor, String action, double scale);

}

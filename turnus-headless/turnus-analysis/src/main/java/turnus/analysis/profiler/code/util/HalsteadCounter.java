/* 
 * TURNUS, the co-exploration framework
 * 
 * Copyright (C) 2015 EPFL SCI STI MM
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
package turnus.analysis.profiler.code.util;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

import turnus.common.io.Logger;
import turnus.model.analysis.profiler.CodeData;
import turnus.model.analysis.profiler.ComplexCodeData;
import turnus.model.analysis.profiler.ProfilerFactory;

/**
 * This class defines an Halstead Counter class. It is used to keep track of the
 * number of of operands and operators defined in a given block (e.g. Actor
 * class, action, or procedure)
 * 
 * @author Simone Casale-Brunet
 *
 */
public class HalsteadCounter {

	private String blockName;
	private Multiset<String> operatorsMap = HashMultiset.create();
	private Multiset<String> operandsMap = HashMultiset.create();

	/**
	 * Create a new Halstead counter
	 * 
	 * @param blockName
	 *            the block name
	 */
	public HalsteadCounter(String blockName) {
		this.blockName = blockName;
	}

	/**
	 * Add all the operand and operator counters of a given HalsteadCounter
	 * 
	 * @param hc
	 *            the Halstead Counter from which operator and operand counter
	 *            are added incrementally
	 */
	public void addAll(HalsteadCounter hc) {
		for (Entry<String> e : hc.operandsMap.entrySet()) {
			operandsMap.add(e.getElement(), e.getCount());
		}

		for (Entry<String> e : hc.operatorsMap.entrySet()) {
			operatorsMap.add(e.getElement(), e.getCount());
		}
	}

	/**
	 * Add an operand
	 * 
	 * @param operand
	 *            the operand name
	 */
	public void addOperand(String operand) {
		operandsMap.add(operand);
	}

	/**
	 * Add an operator
	 * 
	 * @param operator
	 *            the operator name
	 */
	public void addOperator(String operator) {
		operatorsMap.add(operator);
	}

	/**
	 * Transform the HalsteadCounter data as a {@link CodeData}
	 * 
	 * @param clazz
	 *            the output class ({@link CodeData} or {@link ComplexCodeData})
	 * @return the code data object
	 */
	@SuppressWarnings("unchecked")
	public <T extends CodeData> T asCodeData(Class<T> clazz) {
		T data = null;
		if (clazz == ComplexCodeData.class) {
			data = (T) ProfilerFactory.eINSTANCE.createComplexCodeData();
		} else {
			data = (T) ProfilerFactory.eINSTANCE.createCodeData();
		}

		data.setBlockName(blockName);

		for (Entry<String> e : operandsMap.entrySet()) {
			data.getOperandsCount().put(e.getElement(), e.getCount());
		}
		for (Entry<String> e : operatorsMap.entrySet()) {
			data.getOperatorsCount().put(e.getElement(), e.getCount());
		}
		return data;
	}

	/**
	 * Print the values contained in this counter
	 */
	public void print() {
		Logger.info("Halstead counter value for \"%s\"", blockName);
		Logger.info("OPERATORS:");
		for (Entry<String> e : operatorsMap.entrySet()) {
			Logger.info(" " + e.getElement() + ": " + e.getCount());
		}

		Logger.info("OPERANDS:");
		for (Entry<String> e : operandsMap.entrySet()) {
			Logger.info(" " + e.getElement() + ": " + e.getCount());
		}

	}

}

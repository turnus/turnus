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
package turnus.model.trace;

import java.util.HashMap;
import java.util.Map;

import turnus.common.Attributable;
import turnus.model.dataflow.Guard;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;

/**
 * A dependency of the ETG. A dependency is a directed arc between two
 * {@link Step}s which defines an execution constraints. For each dependency the
 * following information is always defined:
 * <ul>
 * <li>Source id: the step identifier of the source step</li>
 * <li>Source actor: the source actor name</li>
 * <li>Source action: the source action name</li>
 * <li>Target id: the step identifier of the target step</li>
 * <li>Target actor: the target actor name</li>
 * <li>Target action: the target action name</li>
 * <li>Kind: the dependency kind</li>
 * </ul>
 * 
 * Different dependency {@link Kind} are modeled. These are:
 * <ul>
 * <li>FSM</li>
 * <li>Guard</li>
 * <li>Port</li>
 * <li>Scheduler</li>
 * <li>Tokens</li>
 * <li>Variable</li>
 * <li>Unknown</li>
 * <li>Merged</li>
 * </ul>
 *
 * @author Simone Casale Brunet
 *
 */
public interface Dependency extends Attributable {

	/**
	 * The direction of a dependency
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public enum Direction {
		/** for state variable dependency */
		READ_READ("read-read"), //
		/** for state variable dependency */
		READ_WRITE("read-write"), //
		/** for state variable dependency */
		WRITE_READ("write-read"), //
		/** for state variable dependency */
		WRITE_WRITE("write-write"), //
		/** for port dependency */
		READ("read"), //
		/** for port dependency */
		WRITE("write"), //
		/** for guard dependency */
		DISABLE("disable"), //
		/** for guard dependency */
		ENABLE("enable"), //
		/** if not supported by the dependency */
		UNKNOWN("unknown");

		/** the literal map */
		private static final Map<String, Direction> literalsMap = new HashMap<String, Direction>();

		static {
			for (Direction type : values()) {
				literalsMap.put(type.literal, type);
			}
		}

		/**
		 * Get the direction from the literal value. This method is case
		 * insensitive
		 * 
		 * @see #literal()
		 * @param literal
		 *            the literal representation
		 * 
		 * @return the corresponding direction if it exists,
		 *         {@link Direction#NONE} otherwise
		 */
		public static Direction getDirection(String literal) {
			if (literal == null)
				return UNKNOWN;

			Direction value = literalsMap.get(literal.toLowerCase());
			return value != null ? value : UNKNOWN;
		}

		/**
		 * The direction literal value
		 */
		private final String literal;

		/**
		 * Private constructor for the enumerator
		 * 
		 * @param literal
		 */
		private Direction(String literal) {
			this.literal = literal.toLowerCase();
		}

		/**
		 * The string representation of this direction
		 * 
		 * @return the literal representation
		 */
		public String literal() {
			return literal;
		}

		@Override
		public String toString() {
			return literal;
		}
	}

	/**
	 * The kind of a dependency
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public enum Kind {
		FSM("fsm"), //
		GUARD("guard"), //
		PORT("port"), //
		SCHEDULER("scheduler"), //
		TOKENS("tokens"), //
		UNKNOWN("unknown"), //
		VARIABLE("variable"), //
		MERGED("merged");

		/** the literal map */
		private static final Map<String, Kind> literalsMap = new HashMap<String, Kind>();

		static {
			for (Kind type : values()) {
				literalsMap.put(type.literal, type);
			}
		}

		/**
		 * Get the kind from the literal value. This method is case insensitive
		 * 
		 * @see #literal()
		 * @param literal
		 *            the literal representation
		 * 
		 * @return the corresponding direction if it exists,
		 *         {@link Kind#UNKNOWN} otherwise
		 */
		public static Kind getKind(String literal) {
			if (literal == null)
				return UNKNOWN;

			Kind value = literalsMap.get(literal.toLowerCase());
			return value != null ? value : UNKNOWN;
		}

		/**
		 * The kind literal value
		 */
		private final String literal;

		/**
		 * Private constructor for the enumerator
		 * 
		 * @param literal
		 */
		private Kind(String literal) {
			this.literal = literal.toLowerCase();
		}

		/**
		 * The string representation of this kind
		 * 
		 * @return the literal representation
		 */
		public String literal() {
			return literal;
		}

		@Override
		public String toString() {
			return literal;
		}
	}

	/**
	 * Get the number of tokens. <code>0</code> if this is not a
	 * {@link Kind#TOKENS} dependency
	 * 
	 * @return the number of tokens
	 */
	int getCount();

	/**
	 * Get the direction of this dependency
	 * 
	 * @return the direction
	 */
	Direction getDirection();

	/**
	 * Get the guard tag. <code>null</code> if this is not a {@link Kind#GUARD}
	 * dependency
	 * 
	 * @return the guard tag (see {@link Guard#getTag()})
	 */
	String getGuard();

	/**
	 * Get the kind of this dependency
	 * 
	 * @return the kind
	 */
	Kind getKind();

	/**
	 * Get the port name. <code>null</code> if this is not a {@link Kind#PORT}
	 * dependency
	 * 
	 * @return the port name (see {@link Port#getName()})
	 */
	String getPort();

	/**
	 * Get the source step of this dependency. Not all the trace implementations
	 * implements this method: only trace that support the graph based
	 * representation return a value, otherwise <code>null</code>. In order to
	 * know which is the source step identifier make use of the
	 * {@link #getSourceId()} method
	 * 
	 * @return the source step, <code>null</code> if the trace is not graph
	 *         based
	 */
	Step getSource();

	/**
	 * The action of the source step
	 * 
	 * @return the action name of the source step
	 */
	String getSourceAction();

	/**
	 * The actor of the source step
	 * 
	 * @return the actor name of the source step
	 */
	String getSourceActor();

	/**
	 * The source step identifier
	 * 
	 * @return the identifier
	 */
	long getSourceId();

	/**
	 * Get the source port name. <code>null</code> if this is not a
	 * {@link Kind#TOKENS} dependency
	 * 
	 * @return the source port name (see {@link Port#getName()})
	 */
	String getSourcePort();

	/**
	 * Get the target step of this dependency. Not all the trace implementations
	 * implements this method: only trace that support the graph based
	 * representation return a value, otherwise <code>null</code>. In order to
	 * know which is the target step identifier make use of the
	 * {@link #getTargetId()} method
	 * 
	 * @return the target step, <code>null</code> if the trace is not graph
	 *         based
	 */
	Step getTarget();

	/**
	 * The action of the target step
	 * 
	 * @return the action name of the source step
	 */
	String getTargetAction();

	/**
	 * The actor of the target step
	 * 
	 * @return the actor name of the target step
	 */
	String getTargetActor();

	/**
	 * The target step identifier
	 * 
	 * @return the identifier
	 */
	long getTargetId();

	/**
	 * Get the target port name. <code>null</code> if this is not a
	 * {@link Kind#TOKENS} dependency
	 * 
	 * @return the target port name (see {@link Port#getName()})
	 */
	String getTargetPort();

	/**
	 * Get the variable name. <code>null</code> if this is not a
	 * {@link Kind#VARIABLE} dependency
	 * 
	 * @return the variable name (see {@link Variable#getName()})
	 */
	String getVariable();

}

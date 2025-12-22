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
package turnus.model.trace.io;

/**
 * This class contains the XML-Markup constants of the execution trace file
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlTraceMarkup {

	public static final String TRACE = "trace";

	public static final String ATTRIBUTE = "attribute";
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_KIND = "kind";
	public static final String ATTRIBUTE_VALUE = "value";

	public static final String ATTRIBUTE_KIND_STRING = "string";
	public static final String ATTRIBUTE_KIND_BOOLEAN = "boolean";
	public static final String ATTRIBUTE_KIND_LONG = "long";
	public static final String ATTRIBUTE_KIND_INTEGER = "integer";
	public static final String ATTRIBUTE_KIND_FLOAT = "float";
	public static final String ATTRIBUTE_KIND_OBJECT = "object";

	public static final String STEP = "step";
	public static final String STEP_FIRING = "firing";
	public static final String STEP_ACTOR = "actor";
	public static final String STEP_ACTION = "action";
	public static final String STEP_ACTOR_CLASS = "actor-class";

	public static final String STEP_TOKENS = "tokens";
	public static final String STEP_TOKENS_PORT = "port";
	public static final String STEP_TOKENS_COUNT = "count";

	public static final String STEP_VARIABLE = "variable";
	public static final String STEP_VARIABLE_NAME = "name";

	public static final String STEP_DIRECTION = "direction";
	public static final String STEP_DIRECTION_READ = "read";
	public static final String STEP_DIRECTION_WRITE = "write";

	public static final String DEPENDENCY = "dependency";
	public static final String DEPENDENCY_SOURCE_ID = "source";
	public static final String DEPENDENCY_TARGET_ID = "target";
	public static final String DEPENDENCY_SOURCE_ACTOR = "source-actor";
	public static final String DEPENDENCY_TARGET_ACTOR = "target-actor";
	public static final String DEPENDENCY_SOURCE_ACTION = "source-action";
	public static final String DEPENDENCY_TARGET_ACTION = "target-action";
	public static final String DEPENDENCY_KIND = "kind";

	public static final String DIRECTION = "direction";
	public static final String VARIABLE = "variable";
	public static final String PORT = "port";
	public static final String SOURCE_PORT = "source-port";
	public static final String TARGET_PORT = "target-port";
	public static final String GUARD = "guard";
	public static final String COUNT = "count";

	public static final String TYPE_STRING = "string";
	public static final String TYPE_INTEGER = "int";
	public static final String TYPE_BOOLEAN = "boolean";
	public static final String TYPE_REAL = "real";
	public static final String TYPE_MAP = "map";
	public static final String TYPE_LIST = "list";
	public static final String TYPE_SET = "set";
	public static final String TYPE_SERIALIZED = "serialized";
	public static final String VALUE = "value";
	public static final String NULL = "null";
	public static final String MAP = "map";
	public static final String ENTRY = "entry";
	public static final String LENGTH = "length";

	private XmlTraceMarkup() {
	}
}

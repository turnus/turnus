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
package turnus.common.configuration;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.common.TurnusRuntimeException;

/**
 * This class defines a Turnus option. Supported option-types are:
 * <ul>
 * <li><code>Boolean</code></li>
 * <li><code>Integer</code></li>
 * <li><code>String</code></li>
 * <li><code>Double</code></li>
 * <li><code>File</code></li>
 * <li><code>Map(String,String)</code></li>
 * </ul>
 * 
 * @author Simone Casale Brunet
 *
 */
public class Option<T> {

	@Retention(RetentionPolicy.SOURCE)
	@Target(ElementType.FIELD)
	public @interface Description {

		String value();

	}

	public static class OptionBuilder {

		/** The option description */
		private String _description;
		/** The option long name */
		private String _longName;
		/** The option short name */
		private String _name;
		/** The option-type */
		private Class<?> _type;

		private OptionBuilder() {

		}
 
		public synchronized <T> Option<T> build() {

			if (_type == null) {
				throw new TurnusRuntimeException("option should have a type");
			} else if (!isSupported(_type)) {
				throw new TurnusRuntimeException("option type not supported");
			}

			if (_name == null) {
				throw new TurnusRuntimeException("option should have a name");
			}

			if (_description == null) {
				_description = "";
			}

			if (_longName == null) {
				_longName = "turnus.option";
			}

			if (optionsRegisterMap.containsKey(_longName)) {
				throw new TurnusRuntimeException(
						"An option with longName " + _longName + " has been already registered");
			}

			@SuppressWarnings({ "unchecked", "rawtypes" })
			Option<T> option = new Option(_name, _longName, _description, _type);
			optionsRegisterMap.put(_longName, option);
			return option;
		}

		public OptionBuilder setDescription(String description) {
			_description = description;
			return this;
		}

		public OptionBuilder setLongName(String longName) {
			_longName = longName;
			return this;
		}

		public OptionBuilder setName(String name) {
			_name = name;
			return this;
		}

		public OptionBuilder setType(Class<?> type) {
			_type = type;
			return this;
		}

	}

	private final static Map<String, Option<?>> optionsRegisterMap = new HashMap<>();

	/**
	 * Create a new {@link OptionBuilder} for creating a new option
	 * 
	 * @return
	 */
	public synchronized static OptionBuilder create() {
		return new OptionBuilder();
	}

	/**
	 * Crate a new {@link Option} with a default value
	 * 
	 * @param name
	 *            the option (short) name
	 * @param longName
	 *            the option long name
	 * @param description
	 *            the description
	 * @param type
	 *            the type (i.e. see {@link #isSupported(Class)})
	 * @param defaultValue
	 *            the default value (must match the type). <code>null</code> if
	 *            the option has not any default value
	 * @return the option object
	 * 
	 */
	public synchronized static <T> Option<T> create(String name, String longName, String description, Class<T> type) {
		return new OptionBuilder().//
				setName(name).//
				setLongName(longName).//
				setDescription(description).//
				setType(type).//
				build();
	}

	/**
	 * Get a registered option given its long name
	 * 
	 * @param longName
	 * @return
	 */
	public static Option<?> getOption(String longName) {
		return optionsRegisterMap.get(longName);
	}

	/**
	 * Check if a Class is supported. Supported option-types are:
	 * <ul>
	 * <li><code>Boolean</code></li>
	 * <li><code>Integer</code></li>
	 * <li><code>String</code></li>
	 * <li><code>Double</code></li>
	 * <li><code>File</code></li>
	 * <li><code>List(String)</code></li>
	 * <li><code>Map(String,String)</code></li>
	 * </ul>
	 * 
	 * @param type
	 *            the class type
	 * @return <code>true</code> if the class is a supported option-type
	 */
	public static boolean isSupported(Class<?> type) {
		if (type == String.class) {
			return true;
		} else if (type == Boolean.class) {
			return true;
		} else if (type == Integer.class) {
			return true;
		} else if (type == Double.class) {
			return true;
		} else if (type == File.class) {
			return true;
		} else if (type == Map.class) {
			return true;
		}else if (type == List.class){
			return true;
		}
		return false;
	}

	/** The option description */
	private final String description;
	/** The option long name */
	private final String longName;
	/** The option short name */
	private final String name;
	/** The option-type */
	private final Class<?> type;

	/**
	 * Create a new option object
	 * 
	 * @param name
	 *            the option (short) name
	 * @param longName
	 *            the option long name
	 * @param description
	 *            the description
	 * @param type
	 *            the type (i.e. see {@link #isSupported(Class)})
	 * @param defaultValue
	 *            the default value (must match the type). <code>null</code> if
	 *            the option has not any default value
	 * @param required
	 *            <code>true</code> if this option value is required in a
	 *            {@link Configuration}
	 */
	private Option(String name, String longName, String description, Class<T> type) {
		this.name = name;
		this.longName = longName;
		this.description = description;
		this.type = type;
	}

	/**
	 * Get the option description
	 * 
	 * @return
	 */
	public String description() {
		return description;
	}
	
	/**
	 * Return <code>true</code> if the options is a List (of string)
	 * 
	 * @return
	 */
	public boolean isList(){
		return type == List.class;
	}

	/**
	 * Return <code>true</code> if the options is a Boolean
	 * 
	 * @return
	 */
	public boolean isBoolean() {
		return type == Boolean.class;
	}

	/**
	 * Return <code>true</code> if the options is a Double
	 * 
	 * @return
	 */
	public boolean isDouble() {
		return type == Double.class;
	}

	/**
	 * Return <code>true</code> if the options is a File
	 * 
	 * @return
	 */
	public boolean isFile() {
		return type == File.class;
	}

	/**
	 * Return <code>true</code> if the options is an Integer
	 * 
	 * @return
	 */
	public boolean isInteger() {
		return type == Integer.class;
	}

	/**
	 * Return <code>true</code> if the options is a Map
	 * 
	 * @return
	 */
	public boolean isMap() {
		return type == Map.class;
	}

	/**
	 * Return <code>true</code> if the options is a String
	 * 
	 * @return
	 */
	public boolean isString() {
		return type == String.class;
	}

	/**
	 * Get the option long name
	 * 
	 * @return
	 */
	public String longName() {
		return longName;
	}

	/**
	 * Get the option short name
	 * 
	 * @return
	 */
	public String name() {
		return name;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(" -").append(name);
		b.append(" --").append(longName);
		b.append(" \"" + description + "\"");
		return b.toString();
	}

	/**
	 * Get the option type
	 * 
	 * @return
	 */
	public Class<?> type() {
		return type;
	}
}

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

import static turnus.common.TurnusConstants.CONFIGURATION_UNDEFINED_OPTION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.eclipse.debug.core.ILaunchConfiguration;

import turnus.common.TurnusException;
import turnus.common.TurnusOptions;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.common.util.CollectionUtils;
import turnus.common.util.DateUtil;
import turnus.common.util.MapUtils;

/**
 * This class defines a Turnus configuration.
 * 
 * @author Simone Casale Brunet
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Configuration {

	/**
	 * This class contains the utilities methods for parsing the command line
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	public static class CliParser {

		/** option // required map */
		private Map<Option<?>, Boolean> options;

		/**
		 * Create a new Cli parser
		 */
		public CliParser() {
			options = new HashMap<>();
		}

		/**
		 * Return a {@link org.apache.commons.cli.Option} version of the given
		 * option
		 * 
		 * @param option
		 * @return
		 */
		private org.apache.commons.cli.Option asCliOption(Option<?> option, boolean required) {
			org.apache.commons.cli.Option copt = new org.apache.commons.cli.Option(option.name(), option.longName(),
					!option.isBoolean(), option.description());
			copt.setRequired(required);
			copt.setType(option.type());
			return copt;
		}

		/**
		 * Parse the command line
		 * 
		 * @param args
		 *            command line argument
		 * @return the parsed configuration
		 * @throws TurnusException
		 *             raised if the configuration cannot be parsed
		 */
		public Configuration parse(String[] args) throws TurnusException {
			Configuration conf = new Configuration();
			conf.setName("Command line configuration " + DateUtil.now());

			try {

				// create the equivalent CLI options
				Map<Option<?>, org.apache.commons.cli.Option> optionsMap = new HashMap<>();
				Options cliOptions = new Options();
				for (Entry<Option<?>, Boolean> eo : options.entrySet()) {
					Option<?> option = eo.getKey();
					boolean required = eo.getValue();
					org.apache.commons.cli.Option cop = asCliOption(option, required);
					cliOptions.addOption(cop);
					optionsMap.put(option, cop);
				}
				CommandLineParser parser = new GnuParser();
				CommandLine cl = parser.parse(cliOptions, args);

				for (Entry<Option<?>, org.apache.commons.cli.Option> entry : optionsMap.entrySet()) {

					Boolean hasEntry = cl.hasOption(entry.getValue().getOpt());
					if (entry.getKey().isBoolean()) {
						conf.setValue(entry.getKey(), hasEntry);
					} else if (hasEntry) {
						String str = cl.getOptionValue(entry.getValue().getOpt());
						conf.setStringValue(entry.getKey(), str);
					}

				}

			} catch (Exception e) {
				Logger.error("The command line cannot be parsed. See the help:");
				printHelp();
				throw new TurnusException("Command line parsing error", e);
			}

			return conf;
		}

		/**
		 * Print the help for the given options configuration
		 */
		public void printHelp() {
			// create a list of options
			List<Option<?>> optionsList = new ArrayList<>(options.keySet());
			Collections.sort(optionsList, new Comparator<Option<?>>() {

				@Override
				public int compare(Option<?> o1, Option<?> o2) {
					boolean r1 = options.get(o1);
					boolean r2 = options.get(o2);
					if (r1 != r2) {
						return -Boolean.compare(r1, r2);
					} else {
						return o1.name().compareTo(o2.name());
					}
				}
			});

			Logger.infoRaw("-------------------------------------------------------");
			Logger.infoRaw("-----------------------------------------------------\n");
			Logger.infoRaw("Command line parameters:\n");
			for (Option<?> option : optionsList) {
				String required = options.get(option) ? "[required]" : "[optional]";
				Logger.infoRaw(" -%-20s %s %s \n", option.name(), required, option.description());
			}
			Logger.infoRaw("-------------------------------------------------------");
			Logger.infoRaw("-----------------------------------------------------\n");
		}

		public CliParser setOption(Option<?> option, boolean required) {
			options.put(option, required);
			return this;
		}

	}

	/**
	 * This class contains the utilities methods for parsing a launch
	 * configuration
	 * 
	 * @author scb
	 *
	 */
	public static class LaunchConfigurationParser {
		/**
		 * Parse the launch configuration. If the method is "debug" then the
		 * {@link TurnusOptions.CONFIG_VERBOSE} is set to true
		 * 
		 * @param lconf
		 *            the launch configuration
		 * @param mode
		 *            the mode name (e.g. "run", "debug")
		 * @return the parsed configuration
		 * @throws TurnusException
		 *             raised if the configuration cannot be parsed
		 */
		public static Configuration parse(ILaunchConfiguration launcgConfiguration, String mode)
				throws TurnusException {
			Configuration conf = new Configuration();

			// set the configuration name
			String name = launcgConfiguration.getName();
			name = name == null || name.isEmpty() ? "Launch configuration " + DateUtil.now() : name;
			conf.setName(name);
			try {
				// parse the launch configuration
				for (Entry<String, Object> entry : launcgConfiguration.getAttributes().entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue().toString();
					if (!key.startsWith(CONFIGURATION_UNDEFINED_OPTION) && value != null)
						conf.setRawValue(key, value);
				}

				if ("debug".equals(mode)) {
					conf.setValue(TurnusOptions.CONFIG_VERBOSE, true);
				}

			} catch (Exception e) {
				throw new TurnusException("Error parsing the launch configuration \"" + name + "\"", e);
			}
			return conf;
		}
	}

	/**
	 * Load the configuration from a text
	 * 
	 * @param file
	 *            the input file
	 * @return the parsed configuration
	 */
	public static Configuration load(File file) throws TurnusException {
		Configuration conf = new Configuration();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				String line = br.readLine();
				while (line != null) {
					line.trim();
					if (line.startsWith("#")) {
						if (!line.startsWith("##")) {
							line = line.replaceFirst("#", "").trim();
							conf.setName(line);
						}
					} else if (!line.isEmpty()) {
						if (line.contains("=")) {
							String[] parts = line.split("=");
							String name = parts[0];
							String value = parts[1];
							conf.rawOptionsMap.put(name, value);
						} else {
							throw new IllegalArgumentException(
									"Option " + line + " has an invalid format. " + " (ie: [longName]=<value> )");
						}
					}

					line = br.readLine();
				}
			} finally {
				br.close();
			}
		} catch (Exception e) {
			throw new TurnusException("Error loading the configuration file \"" + file + "\"", e);
		}
		return conf;
	}

	/** the default name (i.e. a date) */
	private String name = DateUtil.now();

	/** the raw options map */
	private Map<String, String> rawOptionsMap = new HashMap<>();

	/**
	 * Return a view of the configuration as a raw map where the key are the
	 * options long name and the value is the option string value
	 * 
	 * @return
	 */
	public HashMap<String, String> asRawMap() {
		return new HashMap<String, String>(rawOptionsMap);
	}

	/**
	 * Get the configuration name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the string value of the given option. If the option value is not set,
	 * the default value (if defined) is returned.
	 * 
	 * @param option
	 *            the option
	 * @return the option value as a {@link String}
	 */
	public String getStringValue(Option option) {
		return rawOptionsMap.get(option.longName());
	}

	/**
	 * Get the option value
	 * 
	 * @param option
	 *            the option
	 * @return the option value
	 */
	public <T> T getValue(Option<T> option) {
		String value = rawOptionsMap.get(option.longName());
		if (value == null) {
			return null;
		}

		Class<?> type = option.type();
		Object obj = null;
		if (type == String.class) {
			obj = value;
		} else if (type == Boolean.class) {
			obj = Boolean.parseBoolean(value);
		} else if (type == Integer.class) {
			obj = Integer.parseInt(value);
		} else if (type == Double.class) {
			obj = Double.parseDouble(value);
		} else if (type == File.class) {
			obj = new File(value);
		} else if (type == List.class) {
			obj = CollectionUtils.asList(value);
		} else if (type == Map.class) {
			obj = MapUtils.asMap(value);
		} else {
			throw new TurnusRuntimeException(
					"Option \"" + option.name() + "\" type not supported in configuration \"" + name + "\"");
		}
		return (T) obj;

	}

	public <T> T getValue(Option<T> option, T defaultValue) {
		T obj = getValue(option);
		return obj != null ? obj : defaultValue;
	}

	/**
	 * Return <code>true</code> if the configuration contains a value for the
	 * given option
	 * 
	 * @param option
	 *            the option
	 * @return <code>true</code> if a value is set, <code>false</code> otherwise
	 */
	public boolean hasValue(Option option) {
		return rawOptionsMap.containsKey(option.longName());
	}

	/**
	 * Set the configuration name
	 * 
	 * @param name
	 *            the configuration name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the option value with its raw long-key name (i.e. see
	 * {@link Option#longName()}) and the string value. No validation checking
	 * is made.
	 * 
	 * @param longOptionKey
	 *            the raw long-key name
	 * @param value
	 *            the string value
	 */
	public void setRawValue(String longOptionKey, String value) {
		if (value == null || value.isEmpty()) {
			rawOptionsMap.remove(longOptionKey);
		} else {
			rawOptionsMap.put(longOptionKey, value);
		}
	}

	/**
	 * Set the option value as a sting
	 * 
	 * @param option
	 *            the option value
	 * @param value
	 *            the {@link String} value. A <code>null</code> or emptty string
	 *            (i.e. <code>""</code>) for unsetting the option is also
	 *            supported
	 */
	public void setStringValue(Option option, String value) {
		if (value == null || value.isEmpty()) {
			unsetValue(option);
		} else {
			// try parsing the value
			try {
				Class<?> type = option.type();
				if (type == String.class) {
					// do nothing
				} else if (type == Boolean.class) {
					Boolean.parseBoolean(value);
				} else if (type == Integer.class) {
					Integer.parseInt(value);
				} else if (type == Double.class) {
					Double.parseDouble(value);
				} else if (type == File.class) {
					// do nothing
				} else if (type == Map.class) {
					MapUtils.asMap(value);
				} else if (type == List.class) {
					CollectionUtils.asList(value);
				}

				rawOptionsMap.put(option.longName(), value);
			} catch (Exception e) {
				throw new TurnusRuntimeException("Option \"" + option.name() + "\" string value cannot be parsed "
						+ "in configuration \"" + name + "\"", e);
			}
		}
	}

	/**
	 * Set the option value
	 * 
	 * @param option
	 *            the option
	 * @param value
	 *            the object value. A <code>null</code> value for unsetting the
	 *            option is also supported
	 */
	public void setValue(Option option, Object value) {
		if (value == null) {
			unsetValue(option);
			return;
		} else {
			// check consistency
			if (value.getClass().isInstance(option.type())) {
				throw new TurnusRuntimeException("Option \"" + option.name()
						+ "\" value has not the same type in configuration \"" + name + "\"");
			}
		}

		// try to save as string
		try {
			Class<?> type = option.type();
			String key = option.longName();
			String str = null;
			if (type == String.class) {
				str = (String) value;
			} else if (type == Boolean.class) {
				str = Boolean.toString((Boolean) value);
			} else if (type == Integer.class) {
				str = Integer.toString((Integer) value);
			} else if (type == Double.class) {
				str = Double.toString((Double) value);
			} else if (type == File.class) {
				str = ((File) value).getAbsolutePath().toString();
			} else if (type == Map.class) {
				str = MapUtils.asString((Map<String, String>) value);
			} else if (type == List.class) {
				str = CollectionUtils.asString((List<String>) value);
			} else {
				throw new TurnusException(
						"Option \"" + option.name() + "\" value-type not supported in configuration \"" + name + "\"");
			}
			rawOptionsMap.put(key, str);
		} catch (Exception e) {
			throw new TurnusRuntimeException(
					"Option \"" + option.name() + "\" cannot be stored in configuration \"" + name + "\"", e);
		}

	}

	/**
	 * Store the configuration to an output file
	 * 
	 * @param file
	 *            the output file
	 */
	public void store(File file) throws TurnusException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			try {
				writer.write("#" + name);
				writer.newLine();
				for (Entry<String, String> entry : new TreeMap<String, String>(rawOptionsMap).entrySet()) {
					writer.write(entry.getKey() + "=" + entry.getValue());
					writer.newLine();
				}
			} finally {
				writer.close();
			}
		} catch (Exception e) {
			throw new TurnusException("Error writing configuration \"" + name + "\" to file \"" + file + "\"", e);
		}
	}

	@Override
	public String toString() {
		return "Exelixi-Configuration \"" + name + "\"";
	}

	/**
	 * Unset an option value
	 * 
	 * @param option
	 *            the option to remove from the configuration
	 */
	public void unsetValue(Option option) {
		rawOptionsMap.remove(option.longName());
	}
}

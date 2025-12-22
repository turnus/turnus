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
package turnus.common.io;

import java.io.File;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import turnus.common.util.DateUtil;

/**
 * The Turnus logger.
 * 
 * @author Simone Casale Brunet
 *
 */
public class Logger {

	/**
	 * This class defines a default console handler that make use of the
	 * {@link System#out} and {@link System#err} streams
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private static class BlackConsoleHandler extends ConsoleHandler {

		@Override
		public void publish(LogRecord record) {
			if (record.getLevel() == Level.SEVERE) {
				System.err.print(getFormatter().format(record));
			} else {
				System.out.print(getFormatter().format(record));
			}
		}
	}

	/**
	 * This class defines the default Exelixi console formatter
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private static class DefaultFormatter extends Formatter {

		/**
		 * Format the given log level and return the formatted string.
		 * 
		 * @param level
		 * @return
		 */
		private static String formatLevel(Level level) {
			if (level == Level.SEVERE) {
				return "ERROR";
			} else if (level == Level.FINER) {
				return "DEBUG";
			} else if (level == Level.WARNING) {
				return "WARNING";
			} else if (level == Level.INFO) {
				return "INFO";
			} else {
				return level.toString();
			}
		}

		@Override
		public String format(LogRecord record) {
			StringBuilder builder = new StringBuilder(1000);

			if (hasRawFlag(record)) {
				builder.append(formatMessage(record));
			} else {
				builder.append("[");
				builder.append(formatLevel(record.getLevel()));
				builder.append("] ");
				builder.append(DateUtil.now());
				builder.append(" : ");
				builder.append(formatMessage(record));
				builder.append(System.getProperty("line.separator"));
			}

			return builder.toString();
		}

		@Override
		public String getHead(Handler h) {
			return super.getHead(h);
		}

		@Override
		public String getTail(Handler h) {
			return super.getTail(h);
		}

		/**
		 * Check if the log record has the raw flag (i.e. see
		 * {@link Logger#RAW_LOG_FLAG})
		 * 
		 * @param record
		 * @return
		 */
		private boolean hasRawFlag(LogRecord record) {
			final Object[] params = record.getParameters();
			if (params == null) {
				return false;
			}

			for (Object param : params) {
				if (RAW_LOG_FLAG.equals(param)) {
					return true;
				}
			}
			return false;
		}
	}

	/** the encapsulated logger */
	private static java.util.logging.Logger logger;
	/** the console formatter */
	private static Formatter formatter = new DefaultFormatter();
	/** the raw log flag */
	private static final String RAW_LOG_FLAG = "exelixi_raw_record";

	static { // init the logger
		init();
	}

	/**
	 * Set the output file where the log information are stored. If the file
	 * cannot be created a simple log error message is printed in all the
	 * already attached handlers
	 * 
	 * @param file
	 *            the output log file
	 */
	public static void addFile(File file) {
		try {
			FileHandler fh = new FileHandler(file.getAbsolutePath().toString());
			addHandler(fh);
		} catch (Exception e) {
			warning("Log file \"%s\" cannot be created", file);
			debug("Error stack trace: %s", e);
		}
	}

	/**
	 * Add a new log {@link Handler}
	 * 
	 * @param handler
	 */
	public static void addHandler(Handler handler) {
		logger.addHandler(handler);
		handler.setFormatter(formatter);
	}

	/**
	 * Print a debug message
	 * 
	 * @param message
	 *            the message
	 */
	public static void debug(String message) {
		logger.log(Level.FINER, message);
	}

	/**
	 * Print a debug message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void debug(String message, Object... objects) {
		debug(String.format(message, objects));
	}

	/**
	 * Print a raw debug message
	 * 
	 * @param message
	 *            the message
	 */
	public static void debugRaw(String message) {
		LogRecord record = new LogRecord(Level.FINER, message);
		record.setParameters(new Object[] { RAW_LOG_FLAG });
		logger.log(record);
	}

	/**
	 * Print a raw debug message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void debugRaw(String message, Object... objects) {
		debugRaw(String.format(message, objects));
	}

	/**
	 * Print an error message
	 * 
	 * @param message
	 *            the message
	 */
	public static void error(String message) {
		logger.log(Level.SEVERE, message);
	}

	/**
	 * Print an error message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void error(String message, Object... objects) {
		error(String.format(message, objects));
	}

	/**
	 * Print a raw error message
	 * 
	 * @param message
	 *            the message
	 */
	public static void errorRaw(String message) {
		LogRecord record = new LogRecord(Level.SEVERE, message);
		record.setParameters(new Object[] { RAW_LOG_FLAG });
		logger.log(record);
	}

	/**
	 * Print a raw error message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void errorRaw(String message, Object... objects) {
		errorRaw(String.format(message, objects));
	}

	/**
	 * Print an info message
	 * 
	 * @param message
	 *            the message
	 */
	public static void info(String message) {
		logger.log(Level.INFO, message);
	}

	/**
	 * Print an info message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void info(String message, Object... objects) {
		info(String.format(message, objects));
	}

	/**
	 * Print a raw info message
	 * 
	 * @param message
	 *            the message
	 */
	public static void infoRaw(String message) {
		LogRecord record = new LogRecord(Level.INFO, message);
		record.setParameters(new Object[] { RAW_LOG_FLAG });
		logger.log(record);
	}

	/**
	 * Print a raw info message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void infoRaw(String message, Object... objects) {
		infoRaw(String.format(message, objects));
	}

	/**
	 * Initialize the logger. All the attached appenders are closed and the log
	 * level is initialized to {@link Level#INFO}
	 */
	public static void init() {
		if (logger != null) {
			for (Handler h : Arrays.asList(logger.getHandlers())) {
				logger.removeHandler(h);
				h.close();
			}
		}

		ConsoleHandler handler = new BlackConsoleHandler();
		handler.setFormatter(new DefaultFormatter());

		logger = java.util.logging.Logger.getLogger("exelixi logger");
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		setVerbose(false);
	}

	/**
	 * Set verbose
	 * 
	 * @param verbose
	 *            <code>true</code> to log all the debug information
	 */
	public static void setVerbose(boolean verbose) {
		Level level = verbose ? Level.ALL : Level.INFO;
		logger.setLevel(level);
		for (Handler handler : logger.getHandlers()) {
			handler.setLevel(level);
		}
	}

	/**
	 * Print a warning message
	 * 
	 * @param message
	 *            the message
	 */
	public static void warning(String message) {
		logger.log(Level.WARNING, message);
	}

	/**
	 * Print a warning message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void warning(String message, Object... objects) {
		warning(String.format(message, objects));
	}

	/**
	 * Print a raw warning message
	 * 
	 * @param message
	 *            the message
	 */
	public static void warningRaw(String message) {
		LogRecord record = new LogRecord(Level.WARNING, message);
		record.setParameters(new Object[] { RAW_LOG_FLAG });
		logger.log(record);
	}

	/**
	 * Print a raw warning message with parameters
	 * 
	 * @param message
	 *            the formatted message (i.e. see
	 *            {@link String#format(String, Object...)}
	 * @param objects
	 *            the objects referenced by the format specifiers in the
	 *            formatted message string
	 */
	public static void warningRaw(String message, Object... objects) {
		warningRaw(String.format(message, objects));
	}

	/**
	 * Private constructor
	 */
	private Logger() {
	}

}

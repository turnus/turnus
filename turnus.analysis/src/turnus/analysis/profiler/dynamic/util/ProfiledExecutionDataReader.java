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
package turnus.analysis.profiler.dynamic.util;

import static turnus.common.TurnusConstants.*;
import static turnus.common.TurnusExtensions.ETRACEZ;
import static turnus.common.TurnusExtensions.ETRACE_INFO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.GZIPInputStream;

import javax.json.Json;
import javax.json.JsonArray; 
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import turnus.analysis.profiler.dynamic.DynamicProfiler;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.io.NullProgressPrinter;
import turnus.common.io.ProgressPrinter;
import turnus.common.util.FileUtils;
import turnus.model.common.EOperator;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.Variable;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ProfiledExecutionDataReader {

	private class StepDataLogger {

		private final Network network;

		StepDataLogger() {
			network = profiler.getNetwork();
		}

		void log(String json) throws TurnusException {
			JsonReader jsonReader = Json.createReader(new StringReader(json));
			JsonObject obj = jsonReader.readObject();

			Actor actor = network.getActor(obj.getString("actor"));
			if (actor == null) {
				throw new TurnusException("JSON parsing: actor not found");
			}

			Action action = actor.getAction(obj.getString("action"));
			if (action == null) {
				throw new TurnusException("JSON parsing: action not found");
			}

			long firing = Long.parseLong(obj.getString("firing"));
			boolean fsm = obj.getBoolean("fsm");

			long pFiring = profiler.startFiring(action, fsm);
			if (pFiring != firing) {
				Logger.debug("Firing id mismatch: %d instead of %d", firing, pFiring);
			}

			// parse consumed tokens
			JsonArray array = obj.getJsonArray("consume");
			if (array != null && obj.containsKey("consume")) {
				if (!array.isEmpty()) {
					Iterator<JsonValue> ia = array.iterator();
					while (ia.hasNext()) {
						JsonObject va = (JsonObject) ia.next();
						Port port = actor.getInputPort(va.getString("port"));
						if (port != null) {
							int count = va.getInt("count");
							profiler.logRead(port.getInput(), count, (Object[]) null);
						} else {
							Logger.debug("consumed tokens error: port %s cannot be found", va.getString("port"));
						}
					}
				}
			}

			// parse produced tokens
			array = obj.getJsonArray("produce");
			if (array != null && obj.containsKey("produce")) {
				Iterator<JsonValue> ia = array.iterator();
				while (ia.hasNext()) {
					JsonObject va = (JsonObject) ia.next();
					Port port = actor.getOutputPort(va.getString("port"));
					if (port != null) {
						int count = va.getInt("count");
						for (Buffer buffer : port.getOutputs()) {
							profiler.logWrite(buffer, count, (Object[]) null);
						}
					} else {
						Logger.debug("produced tokens error: port %s cannot be found", va.getString("port"));
					}
				}
			}

			// parse read variables
			array = obj.getJsonArray("read");
			if (array != null && obj.containsKey("read")) {
				if (!array.isEmpty()) {
					Iterator<JsonValue> ia = array.iterator();
					while (ia.hasNext()) {
						JsonObject va = (JsonObject) ia.next();
						Variable var = actor.getVariable(va.getString("var"));
						if (var != null) {
							int count = va.getInt("count");
							profiler.logRead(var, count, (Object[]) null);
						} else {
							Logger.debug("read variable error: variable %s cannot be found", va.getString("var"));
						}

					}
				}
			}

			// parse write variables
			array = obj.getJsonArray("write");
			if (array != null && obj.containsKey("write")) {
				if (!array.isEmpty()) {
					Iterator<JsonValue> ia = array.iterator();
					while (ia.hasNext()) {
						JsonObject va = (JsonObject) ia.next();
						Variable var = actor.getVariable(va.getString("var"));
						if (var != null) {
							int count = va.getInt("count");
							profiler.logWrite(var, count, (Object[]) null);
						} else {
							Logger.debug("write variable error: variable %s cannot be found", va.getString("var"));
						}
					}
				}
			}

			// parse executed operands
			array = obj.getJsonArray("op");
			if (array != null && !array.isEmpty()) {
				Iterator<JsonValue> ia = array.iterator();
				while (ia.hasNext()) {
					JsonObject va = (JsonObject) ia.next();
					EOperator op = EOperator.get(va.getString("name"));
					if (op != null) {
						int count = va.getInt("count");
						profiler.logExecute(op, count);
					} else {
						Logger.debug("execute operator error: operator %s cannot be found", va.getString("name"));
					}
				}
			}

			profiler.endFiring();

			jsonReader.close();
		}

	}

	final private BlockingQueue<String> queue = new LinkedBlockingQueue<>(DEFAULT_QUEUE_SIZE);

	private Thread reader;
	private Thread parser;
	private boolean forceStop = false;

	private class Reader implements Runnable {

		final BufferedReader br;
		ProgressPrinter progress;

		Reader(File file, long firings) throws TurnusException {
			String extension = FileUtils.getExtension(file);
			if (!extension.equals(ETRACEZ)) {
				throw new TurnusException("Execution data reader: unsupported extension");
			}
			try {
				br = new BufferedReader(
						new InputStreamReader(
								new GZIPInputStream(new FileInputStream(file), DEFAULT_STREAM_BUFFER_SIZE)),
						DEFAULT_STREAM_BUFFER_SIZE);
			} catch (Exception e) {
				throw new TurnusException("The input \"" + file + "\" file cannot be opened");
			}

			if (firings > 0) {
				progress = new ProgressPrinter("Profiling file loading", firings);
			} else {
				progress = new NullProgressPrinter("Profiling file loading");
			}

		}

		@Override
		public void run() {
			try {
				for (String line; (line = br.readLine()) != null;) {
					queue.put(line);
					progress.increment();
					if (forceStop) {
						Logger.info("Reader stopped");
						break;
					}
				}
				queue.put("");
			} catch (Exception e) {
				forceStop = true;
				Logger.error("The reader has stopped: %s", e.getMessage());
			}

			progress.finish();
		}
	}

	private class Parser implements Runnable {
		final StepDataLogger parser;
		ProgressPrinter progress;

		Parser(DynamicProfiler profiler, long firings) {
			parser = new StepDataLogger();

			if (firings > 0) {
				progress = new ProgressPrinter("Profiling data parsing", firings);
			} else {
				progress = new NullProgressPrinter("Profiling data parsing");
			}
		}

		@Override
		public void run() {
			try {
				for (String json; !(json = queue.take()).isEmpty();) {
					parser.log(json);
					progress.increment();
					if (forceStop) {
						Logger.info("Parser stopped");
						break;
					}
				}
			} catch (Exception e) {
				forceStop = true;
				Logger.error("The parser has stopped: %s", e.getMessage());
			}
			progress.finish();
		}

	}

	private final DynamicProfiler profiler;

	public ProfiledExecutionDataReader(DynamicProfiler profiler, File jsonFile) throws TurnusException {
		this.profiler = profiler;

		long firings = getFirings(jsonFile);

		final Reader rReader = new Reader(jsonFile, firings);
		reader = new Thread(rReader, "Json Reader");

		final Parser rParser = new Parser(profiler, firings);
		parser = new Thread(rParser, "Json parser");

		UncaughtExceptionHandler exceptionHandler = new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				Logger.error("\"%s\" error: %s", t.getName(), e.toString());
				forceStop = true;
				try {
					queue.put("");
				} catch (Exception e2) {
					Logger.debug("Insert empty elemement to the queue failed: %s", t.getName(), e2.toString());
				}
			}
		};

		reader.setUncaughtExceptionHandler(exceptionHandler);
		parser.setUncaughtExceptionHandler(exceptionHandler);
	}

	private long getFirings(File jsonFile) {
		long firings = -1;
		try {
			// try to find the information data file
			File infoFile = FileUtils.changeExtension(jsonFile, ETRACE_INFO);
			Scanner scanner = new Scanner(FileUtils.toString(infoFile));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.startsWith("firings=")) {
					String str = line.replaceFirst("firings=", "").trim();
					firings = Long.parseLong(str);
					break;
				}
			}
			scanner.close();
		} catch (Exception e) {
			Logger.debug("Information file reading error: %s", e.toString());
		}

		if (firings <= 0) {
			Logger.warning("It is not possible to retrieve how many firings will be parsed");
		}

		return firings;

	}

	public void start() {
		reader.start();
		parser.start();
	}

	public void join() {
		try {
			reader.join();
			parser.join();
		} catch (Exception e) {
			Logger.debug("Join error %s", e.getMessage());
		}

		try {
			profiler.stop();
		} catch (Exception e) {
			Logger.warning("Profiler stop error %s", e.getMessage());
		}
	}

}

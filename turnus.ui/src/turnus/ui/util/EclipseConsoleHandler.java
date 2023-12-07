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
package turnus.ui.util;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import turnus.common.TurnusRuntimeException;

/**
 * This class defines an implementation of the Ecliple {@link Handler}
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class EclipseConsoleHandler extends Handler {

	class PublishProcess implements Runnable {

		LogRecord record;

		/**
		 * 
		 */
		public PublishProcess(LogRecord record) {
			this.record = record;
		}

		@Override
		public void run() {
			String message = getFormatter().format(record);
			IOConsoleOutputStream outStream = console.newOutputStream();
			if (!Display.isSystemDarkTheme()) {
				if (record.getLevel() == Level.SEVERE) {
					outStream.setColor(new Color(null, 255, 0, 0));
				} else if (record.getLevel() == Level.WARNING) {
					outStream.setColor(new Color(null, 250, 133, 50));
				} else if (record.getLevel() == Level.FINER) {
					outStream.setColor(new Color(null, 133, 200, 62));
				} else {
					outStream.setColor(new Color(null, 0, 0, 156));
				}
			}

			try {
				outStream.write(message);
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private IOConsole console = null;

	/**
	 * Build the Eclipse console handler
	 * 
	 * @param currentConsole the current eclipse process console
	 * 
	 */
	public EclipseConsoleHandler(IConsole console) {
		super();
		if (console instanceof IOConsole) {
			this.console = (IOConsole) console;
			this.console.activate();
		} else {
			throw new TurnusRuntimeException("Invalid console passed as parameter");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Handler#close()
	 */
	@Override
	public void close() throws SecurityException {
		console.destroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Handler#flush()
	 */
	@Override
	public void flush() {
		console.clearConsole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public void publish(LogRecord record) {

		if (!isLoggable(record)) {
			return;
		}

		Display.getDefault().syncExec(new PublishProcess(record));
	}

}

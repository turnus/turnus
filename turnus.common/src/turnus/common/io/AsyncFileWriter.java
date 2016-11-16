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

import static turnus.common.TurnusConstants.DEFAULT_QUEUE_SIZE;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import turnus.common.TurnusException;
import turnus.common.TurnusRuntimeException;

/**
 * This class defines an a generic runnable for an asyncronous writer. The
 * writer is placed in the parallel thread. The caller uses the method
 * {@link AsyncFileWriter#write(Object)} in order to write an object. The object
 * is placed in an internal FIFO queue which is used by the internal writer to
 * collect received data and store it in the output file.
 * 
 * @author Simone Casale Brunet
 *
 */
public abstract class AsyncFileWriter implements Runnable {

	/** the writer name. Associated also to the parallel thread */
	private final String name;

	/**
	 * Create a new asyncronous file writer
	 * 
	 * @param name
	 *            the writer name, used also as the parallel thread name
	 */
	public AsyncFileWriter(String name) {
		this.name = name;
	}

	/**
	 * the internal queue used to exchange information between the called and
	 * the file writer
	 */
	private final BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(DEFAULT_QUEUE_SIZE);

	/** the parallel thread used to run the writer */
	private Thread thread;

	/**
	 * This is an in internal object used when the
	 * {@link AsyncFileWriter#stop()} method is called
	 * 
	 * @author Simone Casale Brunet
	 *
	 */
	private class Terminator {
	}

	/**
	 * Write an object. (Called by the client who want to write an object)
	 * 
	 * @param object
	 * @return
	 */
	public final void write(Object object) {
		try {
			queue.put(object);
		} catch (Exception e) {
			Logger.warning("Object \"%s\" cannot be written in the \"%s\" writer", object, name);
		}
	}

	/**
	 * Start the writer. (Called by the client who want to start the writer)
	 */
	public final void start() {
		thread = new Thread(this, name);
		thread.start();
	}

	/**
	 * Stop the writer. (Called by the client who want to stop the writer)
	 */
	public final void stop() {
		write(new Terminator());
		try {
			thread.join();
		} catch (InterruptedException e) {
			throw new TurnusRuntimeException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void run() {
		try {
			init();
			while (true) {
				try {
					Object value = queue.take();
					if (value instanceof Terminator) {
						break;
					} else {
						export(value);
					}
				} catch (Exception e) {
					Logger.warning("\"%s\" writing error", name);
				}
			}
			close();

		} catch (TurnusException e) {

		}

	}

	/**
	 * This method should be implemented by the writer. Is it is called before
	 * that the first object is written.
	 * 
	 * @throws TurnusException
	 */
	protected abstract void init() throws TurnusException;

	/**
	 * This method should be implemented by the writer. Is it is called when the
	 * given object should be written
	 * 
	 * @param value
	 * @throws TurnusException
	 */
	protected abstract void export(Object value) throws TurnusException;

	/**
	 * This method should be implemented by the writer. Is it is called when the
	 * {@link #stop()} method has been called.
	 * 
	 * @throws TurnusException
	 */
	protected abstract void close() throws TurnusException;

}

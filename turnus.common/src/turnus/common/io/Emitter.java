/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 Endri Bezati
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

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import turnus.common.TurnusException;

/**
 * A Code emitter class
 * 
 * @author Endri Bezati
 */
public class Emitter {
	private int indentation;
	private PrintWriter writer;

	public Emitter() {
	}

	public void open(Path file) throws TurnusException {
		if (writer != null)
			throw new IllegalStateException("Must close previous file before opening a new.");
		try {
			writer = new PrintWriter(Files.newBufferedWriter(file));
		} catch (IOException e) {
			throw new TurnusException("Emitter error :" + e);
		}
		indentation = 0;
	}

	public void close() {
		writer.flush();
		writer.close();
		writer = null;
	}

	public void increaseIndentation() {
		indentation++;
	}

	public void decreaseIndentation() {
		indentation--;
	}

	public void emit(String format, Object... values) {
		if (writer == null) {
			throw new IllegalStateException("No output file is currently open.");
		}
		if (!format.isEmpty()) {
			int indentation = this.indentation;
			while (indentation > 0) {
				writer.print('\t');
				indentation--;
			}
			writer.printf(format, values);
		}
		writer.println();
	}

	public void emitRawLine(CharSequence text) {
		if (writer == null) {
			throw new IllegalStateException("No output file is currently open.");
		}
		writer.println(text);
	}

	public void emitSharpBlockComment(String text) {
		emit("# -- --------------------------------------------------------------------------");
		emit("# -- %s", text);
		emit("# -- --------------------------------------------------------------------------");
	}

	public void emitSharpBlockCommentStart() {
		emit("# -- --------------------------------------------------------------------------");
	}

	public void emitSharpComment(String text) {
		emit("# -- %s", text);
	}

	public void emitSharpBlockCommentEnd() {
		emit("# --");
		emit("# -- --------------------------------------------------------------------------");
	}

	public void emitClikeBlockComment(String text) {
		emit("// -- --------------------------------------------------------------------------");
		emit("// -- %s", text);
		emit("// -- --------------------------------------------------------------------------");
	}

	public void emitNewLine() {
		emit("");
	}
}

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
package turnus.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import turnus.common.TurnusException;

/**
 * This class contains some utility methods for {@link String}.
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class StringUtils {

	/** a decimal formatter with 2 digits */
	private static final DecimalFormat df = new DecimalFormat("#0.00");

	/**
	 * Compress a string using GZIP. The resulting string is in ISO_8859_1 charset
	 * 
	 * @param str the input string
	 * @return the compressed output stream
	 * @throws TurnusException thrown if the string cannot be compressed
	 */
	public static String compress(String str) throws TurnusException {
		if (str == null || str.length() == 0) {
			return str;
		}

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(str.getBytes());
			gzip.close();
			return out.toString(StandardCharsets.ISO_8859_1.name());
		} catch (Exception e) {
			throw new TurnusException("Error while compressing the string");
		}

	}

	/**
	 * Generate a string key from a collection of objects. Contrary to
	 * {@link StringUtils#createKey(Object...)}, this method add to the end of the
	 * key the current time and a random double value
	 * 
	 * @param objects
	 * @return
	 */
	public static String createKey(Object... objects) {
		StringBuffer b = new StringBuffer();
		for (Object o : objects) {
			b.append(o);
			b.append(":");
		}
		return b.toString();
	}

	/**
	 * Generate a string key from a collection of objects
	 * 
	 * @param objects
	 * @return
	 */
	public static String createRandomKey(Object... objects) {
		StringBuffer b = new StringBuffer();
		for (Object o : objects) {
			b.append(o);
			b.append(":");
		}
		b.append(System.currentTimeMillis());
		b.append(new Random().nextDouble());
		return b.toString();
	}

	/**
	 * Decompress a compressed string
	 * 
	 * @param str the compressed string
	 * @return the decompressed string
	 * @see #compress(String)
	 * @throws TurnusException thrown if the string cannot be decompressed
	 */
	public static String decompress(String str) throws TurnusException {
		if (str == null || str.length() == 0) {
			return str;
		}

		try {
			GZIPInputStream gis = new GZIPInputStream(
					new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1.name())));
			return FileUtils.toString(gis, StandardCharsets.ISO_8859_1);
		} catch (Exception e) {
			throw new TurnusException("Error while decompressing the string");
		}
	}

	/**
	 * Format the double value with 2 digits. Example: 1.234567 -> "1.23"
	 * 
	 * @param value
	 * @return
	 */
	public static String format(double value) {
		return df.format(value);
	}

	/**
	 * Format the number of bits to Kb, Mb, Gb or Tb depending the size
	 * 
	 * @param size
	 * @return
	 */
	public static String formatBits(long size) {
		String hrSize = null;

		double b = size;
		double k = size / 1024.0;
		double m = ((size / 1024.0) / 1024.0);
		double g = (((size / 1024.0) / 1024.0) / 1024.0);
		double t = ((((size / 1024.0) / 1024.0) / 1024.0) / 1024.0);

		DecimalFormat dec = new DecimalFormat("0.00");

		if (t > 1) {
			hrSize = dec.format(t).concat(" Tb");
		} else if (g > 1) {
			hrSize = dec.format(g).concat(" Gb");
		} else if (m > 1) {
			hrSize = dec.format(m).concat(" Mb");
		} else if (k > 1) {
			hrSize = dec.format(k).concat(" Kb");
		} else {
			hrSize = dec.format(b).concat(" b");
		}

		return hrSize;
	}

	/**
	 * Format the number of bytes to KB, MB, GG or TB depending the size
	 * 
	 * @param size
	 * @return
	 */
	public static String formatBytes(long size) {
		return formatBytes(size, true);
	}

	/**
	 * Format the number of bytes to KB, MB, GG or TB depending the size
	 * 
	 * @param size
	 * @param isBits if the input is in bits converted to bytes
	 * @return
	 */
	public static String formatBytes(long size, boolean isBits) {
		String hrSize = null;

		if (isBits) {
			size = size / 8;
		}
		double b = size;
		double k = size / 1024.0;
		double m = ((size / 1024.0) / 1024.0);
		double g = (((size / 1024.0) / 1024.0) / 1024.0);
		double t = ((((size / 1024.0) / 1024.0) / 1024.0) / 1024.0);

		DecimalFormat dec = new DecimalFormat("0.00");

		if (t > 1) {
			hrSize = dec.format(t).concat(" TB");
		} else if (g > 1) {
			hrSize = dec.format(g).concat(" GB");
		} else if (m > 1) {
			hrSize = dec.format(m).concat(" MB");
		} else if (k > 1) {
			hrSize = dec.format(k).concat(" KB");
		} else {
			hrSize = dec.format(b).concat(" Bytes");
		}

		return hrSize;
	}

}

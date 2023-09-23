package turnus.common.util;

/*
NaturalOrderComparator.java -- Perform 'natural order' comparisons of strings in Java.
Copyright (C) 2003 by Pierre-Luc Paour <natorder@paour.com>

Based on the C version by Martin Pool, of which this is more or less a straight conversion.
Copyright (C) 2000 by Martin Pool <mbp@humbug.org.au>

This software is provided 'as-is', without any express or implied
warranty.  In no event will the authors be held liable for any damages
arising from the use of this software.

Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not
claim that you wrote the original software. If you use this software
in a product, an acknowledgment in the product documentation would be
appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be
misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.
 */

//CHANGES: KD - added case sensitive ordering capability
// Made comparison so it doesn't treat spaces as special characters

//CHANGES:
//   set package to "org.cougaar.util"
//   replaced "import java.util.*" with explicit imports,
//   added "main" file reader support

import java.util.Comparator;

/**
 * A sorting comparator to sort strings numerically, ie [1, 2, 10], as opposed
 * to [1, 10, 2].
 */
public class NaturalOrderComparator<T> implements Comparator<T> {

	public static final Comparator<String> NUMERICAL_ORDER = new NaturalOrderComparator<String>(false);
	public static final Comparator<String> CASEINSENSITIVE_NUMERICAL_ORDER = new NaturalOrderComparator<String>(true);

	private final boolean caseInsensitive;

	private NaturalOrderComparator(boolean caseInsensitive) {
		this.caseInsensitive = caseInsensitive;
	}

	int compareRight(String a, String b) {
		int bias = 0;
		int ia = 0;
		int ib = 0;

		// The longest run of digits wins. That aside, the greatest
		// value wins, but we can't know that it will until we've scanned
		// both numbers to know that they have the same magnitude, so we
		// remember it in BIAS.
		for (;; ia++, ib++) {
			char ca = charAt(a, ia);
			char cb = charAt(b, ib);

			if (!Character.isDigit(ca) && !Character.isDigit(cb)) {
				return bias;
			} else if (!Character.isDigit(ca)) {
				return -1;
			} else if (!Character.isDigit(cb)) {
				return +1;
			} else if (ca < cb) {
				if (bias == 0) {
					bias = -1;
				}
			} else if (ca > cb) {
				if (bias == 0)
					bias = +1;
			} else if (ca == 0 && cb == 0) {
				return bias;
			}
		}
	}
	
	@Override
	public int compare(T o1, T o2) {
		String a = o1.toString();
		String b = o2.toString();

		int ia = 0, ib = 0;
		int nza = 0, nzb = 0;
		char ca, cb;
		int result;

		while (true) {
			// only count the number of zeroes leading the last number compared
			nza = nzb = 0;

			ca = charAt(a, ia);
			cb = charAt(b, ib);

			// skip over leading zeros
			while (ca == '0') {
				if (ca == '0') {
					nza++;
				} else {
					// only count consecutive zeroes
					nza = 0;
				}

				// if the next character isn't a digit, then we've had a run of only zeros
				// we still need to treat this as a 0 for comparison purposes
				if (!Character.isDigit(charAt(a, ia + 1)))
					break;

				ca = charAt(a, ++ia);
			}

			while (cb == '0') {
				if (cb == '0') {
					nzb++;
				} else {
					// only count consecutive zeroes
					nzb = 0;
				}

				// if the next character isn't a digit, then we've had a run of only zeros
				// we still need to treat this as a 0 for comparison purposes
				if (!Character.isDigit(charAt(b, ib + 1)))
					break;

				cb = charAt(b, ++ib);
			}

			// process run of digits
			if (Character.isDigit(ca) && Character.isDigit(cb)) {
				if ((result = compareRight(a.substring(ia), b.substring(ib))) != 0) {
					return result;
				}
			}

			if (ca == 0 && cb == 0) {
				// The strings compare the same. Perhaps the caller
				// will want to call strcmp to break the tie.
				return nza - nzb;
			}

			if (ca < cb) {
				return -1;
			} else if (ca > cb) {
				return +1;
			}

			++ia;
			++ib;
		}
	}

	private char charAt(String s, int i) {
		if (i >= s.length()) {
			return 0;
		} else {
			return caseInsensitive ? Character.toUpperCase(s.charAt(i)) : s.charAt(i);
		}
	}

}
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
package turnus.model.mapping.io;

import static turnus.model.mapping.io.XmlSchedulingWeightMarkup.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.mapping.data.ClockCycles;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class XmlSchedulingWeightReader {
	
	boolean parseVarianceAttr = false;
	boolean parseFiringAttr = false;
	
	public XmlSchedulingWeightReader() {
		this.parseVarianceAttr = false;
		this.parseFiringAttr = false;
	}
	
	public XmlSchedulingWeightReader(Boolean parseVarianceAttr, Boolean parseFiringAttr) {
		this.parseVarianceAttr = parseVarianceAttr;
		this.parseFiringAttr = parseFiringAttr;
	}	

	public SchedulingWeight load(File file) throws TurnusException {
		XMLStreamReader reader = null;
		try {
			InputStream stream = new BufferedInputStream(new FileInputStream(file));
			reader = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be opened");
		}

		SchedulingWeight weights = null;
		String actor = null;
		try {
			while (reader.hasNext()) {
				reader.next();
				switch (reader.getEventType()) {
				case XMLEvent.START_ELEMENT: {
					String xmlElement = reader.getName().toString();
					if (xmlElement.equals(NETWORK)) {
						String network = reader.getAttributeValue("", NETWORK_NAME);
						if (network == null) {
							throw new TurnusException(
									"Parsing error in \"" + file.getAbsolutePath() + "\": network name not specified");
						}
						weights = new SchedulingWeight(network);
					} else if (xmlElement.equals(ACTOR)) {
						actor = reader.getAttributeValue("", ACTOR_ID);
						if (actor == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": actor name not specified. Line " + reader.getLocation().getLineNumber());
						}
					} else if (xmlElement.equals(SCHEDULING)) {
						String source = reader.getAttributeValue("", SCHEDULING_SOURCE);
						if (source == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": action source not specified. Line " + reader.getLocation().getLineNumber());
						}
						String target = reader.getAttributeValue("", SCHEDULING_TARGET);
						if (target == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": action target not specified. Line " + reader.getLocation().getLineNumber());
						}
						String meanStr = reader.getAttributeValue("", CLOCK_MEAN);
						String minStr = reader.getAttributeValue("", CLOCK_MIN);
						String maxStr = reader.getAttributeValue("", CLOCK_MAX);

						String varStr = null;
						if(parseVarianceAttr) {
							try {
								varStr = reader.getAttributeValue("", CLOCK_VAR);
							} catch (Exception e) {
								Logger.error("Variance of <%s,%s> is not defined.");
							}
						}
						String firingsStr = null;
						if(parseFiringAttr) {
							try {
								firingsStr = reader.getAttributeValue("", FIRINGS);
							} catch (Exception e) {
								Logger.error("Firings of <%s,%s> is not defined.");
							}							
						}

						if (meanStr == null) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": action weight not specified. Line " + reader.getLocation().getLineNumber());
						}

						double mean = Double.parseDouble(meanStr);

						double min = 0.0;
						try {
							min = Double.parseDouble(minStr);
						} catch (Exception e) {
							Logger.warning("Min weight in Line %d is not defined. Set to %f", reader.getLocation().getLineNumber(), mean);
							min = mean;
						}

						double max = 0.0;
						try {
							max = Double.parseDouble(maxStr);
						} catch (Exception e) {
							Logger.warning("Max weight in Line %d is not defined. Set to %f", reader.getLocation().getLineNumber(), mean);
							max = mean;
						}

						// check consistency
						if (min > mean || max < mean || max < min) {
							throw new TurnusException("Parsing error in \"" + file.getAbsolutePath()
									+ "\": weight not consistent. Line " + reader.getLocation().getLineNumber());
						}

						ClockCycles w = weights.getWeight(actor, source, target);
						w.setMeanClockCycles(mean);
						w.setMinClockCycles(min);
						w.setMaxClockCycles(max);

						if(parseVarianceAttr) {
							double var = 0.0;
							try {
								var = Double.parseDouble(varStr);
							} catch (Exception e) {
								Logger.warning("Variance in Line %d is not defined. Set to %f", reader.getLocation().getLineNumber(), 0.0);
							}
							w.setVarClockCycles(var);
						}
						
						if(parseFiringAttr) {
							int firings = 0;
							try {
								firings = Integer.parseInt(firingsStr);
							} catch (Exception e) {
								Logger.warning("Firings in Line %d is not defined. Set to %f", reader.getLocation().getLineNumber(), 0);
							}
							w.setNumFirings(firings);
						}
					}
				}
				}
			}
			try {
				reader.close();
			} catch (Exception e) {
				Logger.warning("File \"%s\" has not been properly closed", file);
			}
		} catch (TurnusException e) {
			throw e;

		} catch (Exception e) {
			throw new TurnusException("File \"" + file.getAbsolutePath() + "\" cannot be parsed");
		}

		return weights;

	}

}

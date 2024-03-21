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
package turnus.adevs.model;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import adevs.Atomic;
import adevs.Digraph.PortValue;
import turnus.common.TurnusRuntimeException;
import turnus.common.io.Logger;
import turnus.model.dataflow.Buffer;
import turnus.model.mapping.data.MemoryAccess;

/**
 * This is the implementation of an {@link Atomic} {@link Buffer}. 
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 */
public class AtomicBuffer extends Atomic<PortValue> {
	
	// ----- THE RX INTERFACE PORTS ID ----------
	public static final int PORT_RX_ENABLE = 0;
	public static final int PORT_RX_RECEIVE_HAS_SPACE = 1;
	public static final int PORT_RX_SEND_HAS_SPACE = 2;
	public static final int PORT_RX_RECEIVE_TOKENS = 3;
	public static final int PORT_RX_SEND_TOKENS_RECEIVED = 4;
	
	// ----- THE TX INTERFACE PORTS ID ----------
	public static final int PORT_TX_ENABLE = 10;
	public static final int PORT_TX_RECEIVE_HAS_TOKENS = 11;
	public static final int PORT_TX_SEND_HAS_TOKENS = 12;
	public static final int PORT_TX_RECEIVE_ASK_TOKENS = 13;
	public static final int PORT_TX_SEND_TOKENS = 14;
	public static final int PORT_TX_RECEIVE_RELEASE_BUFFER = 15;

	
	public enum RxStatus {
		DISABLED, IDLE, SEND_HAS_SPACE, RECEIVING, END_RECEIVING;
	}

	public enum TxStatus {
		DISABLED, IDLE, SEND_HAS_TOKENS, SENDING, END_SENDING;
	}

	/** buffer object in the network*/
	private final Buffer buffer;
	/** the buffer size */
	private int size;
	
	///** the buffer local time */
	private double localTime = 0;
	
	/** true if the receive (in) interface is enabled */
	private boolean rxEnabled;
	/** true if the transmission (out) interface is enabled */
	private boolean txEnabled;
	
	private RxStatus rxStatus;
	private TxStatus txStatus;
	
	private int maxTokensInFifo;
	private int tokensInFifo;
	private int rxTokens;
	private int txTokens;
	private int tokensToRelease;
	
	private int requestedSpace;
	private int requestedTokensNumber;
	Random random = new Random();
	
	private boolean hasTokens; //FIXME: int missingTokens, like for missingSpace
	private int missingSpace;
	
	/**
	 * values of communication cost (latency and percentage) from profiling 
	 * (if not specified, the default values of ckIn and ckOut will be taken)
	 */
	private List<MemoryAccess> readCommunicationCost;
	private List<MemoryAccess> writeCommunicationCost;
	/**
	 * constant latencies for hit or miss for writes (write latencies are not reported by numap!)
	 * considered only if the communication costs are specified
	 */
	private int writeHitLatency;
	private int writeMissLatency;
	
	/** the input clock */
	private double ckIn = 0;
	/** the output clock */
	private double ckOut = 0;
	
	/**
	 * the maximum number of tokens that can be consumed (retrieved from the
	 * actor producer) during ckIn - architecture related property
	 */
	private int maxPopTokens = Integer.MAX_VALUE;
	/**
	 * the maximum number of tokens that can be produced (made available to the
	 * actor consumer) during ckOut - architecture related property
	 */
	private int maxPushTokens = Integer.MAX_VALUE;
	
	public AtomicBuffer(Buffer buffer, int size) {
		this.buffer = buffer;
		this.size = size;
		
		rxStatus = RxStatus.IDLE;
		txStatus = TxStatus.IDLE;
		rxEnabled = true;
		txEnabled = true;
		
		requestedSpace = 0;
		requestedTokensNumber = 0;
		
		hasTokens = false;
		missingSpace = 0;
		
		maxTokensInFifo = 0;
		tokensInFifo = 0;
		rxTokens = 0;
		txTokens = 0;
		tokensToRelease = 0;
		
		localTime = 0.0;
	}
	
	@Override
	public void delta_conf(Collection<PortValue> xb) {
		//Logger.debug("delta_conf at %f : buffer=%s", localTime, buffer.toString());
		delta_int();
		delta_ext(0.0, xb);
	}

	@Override
	public void delta_int() {
		//Logger.debug("delta_int at %f : buffer=%s", localTime, buffer.toString());
		//localTime += ta();
		
		switch (rxStatus) {
			case RECEIVING:
				// store in the internal memory the max number of tokens that this fifo allows
				int maxPush = Math.min(rxTokens, maxPushTokens);
				tokensInFifo += maxPush;
				rxTokens -= maxPush;
				if (tokensInFifo > maxTokensInFifo) {
					maxTokensInFifo = tokensInFifo;
				}
				if (rxTokens == 0) {
					rxStatus = RxStatus.END_RECEIVING;
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void delta_ext(double e, Collection<PortValue> xb) {
		//Logger.info("delta_ext at %f e=%f: buffer=%s", localTime, e, buffer.toString());
		localTime += e;
		
		for (PortValue inPortValue : xb) {
			switch (inPortValue.getPort()) {
				case PORT_RX_ENABLE: {
					rxEnabled = (boolean) inPortValue.getValue();
					if (rxStatus == RxStatus.DISABLED && rxEnabled) {
						rxStatus = RxStatus.IDLE;
					}
					break;
				}
				
				case PORT_TX_ENABLE: {
					txEnabled = (boolean) inPortValue.getValue();
					if (txStatus == TxStatus.DISABLED && txEnabled) {
						txStatus = TxStatus.IDLE;
					}
					break;
				}
				
				case PORT_TX_RECEIVE_HAS_TOKENS: {
					requestedTokensNumber = (Integer) inPortValue.getValue();
					hasTokens = hasTokens(requestedTokensNumber);
					txStatus = TxStatus.SEND_HAS_TOKENS;
					break;
				}
				
				case PORT_RX_RECEIVE_HAS_SPACE: {
					requestedSpace = (Integer) inPortValue.getValue();
					missingSpace = hasSpace(requestedSpace);
					rxStatus = RxStatus.SEND_HAS_SPACE;
					break;
				}
				
				case PORT_TX_RECEIVE_ASK_TOKENS: {
					txTokens += (int)inPortValue.getValue();
					if (tokensInFifo < txTokens) {
						throw new TurnusRuntimeException(buffer + " underflow");
					}
					if (txStatus == TxStatus.IDLE) {
						txStatus = TxStatus.SENDING;
					}
					break;
				}
				
				case PORT_RX_RECEIVE_TOKENS: {
					rxTokens += (int)inPortValue.getValue();
					if (rxTokens + tokensInFifo > size) {
						throw new TurnusRuntimeException(buffer + " max size overflow");
					}
					if (rxStatus == RxStatus.IDLE) {
						rxStatus = RxStatus.RECEIVING;
					}
					break;
				}
				
				//tokens can be released after reading or after processing of the actor
				case PORT_TX_RECEIVE_RELEASE_BUFFER: {
					tokensInFifo -= tokensToRelease;
					txTokens -= tokensToRelease;
					tokensToRelease = 0;
					break;
				}
				
				default:
					break;
			}
		}
	}

	@Override
	public void output_func(Collection<PortValue> yb) {
		//Logger.debug("output_func at %f : buffer=%s", localTime, buffer.toString());
		
		switch (rxStatus) {
			case SEND_HAS_SPACE:
				yb.add(new PortValue(PORT_RX_SEND_HAS_SPACE, missingSpace));
				rxStatus = RxStatus.IDLE;
				break;
			case END_RECEIVING:
				yb.add(new PortValue(PORT_RX_SEND_TOKENS_RECEIVED, true));
				rxStatus = RxStatus.IDLE;
				break;
			default:
				break;
		}
		
		switch (txStatus) {
			case SEND_HAS_TOKENS:
				yb.add(new PortValue(PORT_TX_SEND_HAS_TOKENS, hasTokens));
				txStatus = TxStatus.IDLE;
				break;
			case SENDING:
				// send the max number of tokens that this fifo allows
				int maxPop = Math.min(txTokens, maxPopTokens);
				
				tokensToRelease += maxPop;
				if (txTokens == tokensToRelease) {
					txStatus = TxStatus.IDLE;
				}
				
				yb.add(new PortValue(PORT_TX_SEND_TOKENS, maxPop));
				break;
			default:
				break;	
		}
	}

	@Override
	public double ta() {
		//Logger.debug("ta at %f : buffer=%s", localTime, buffer.toString());

		if (rxStatus == RxStatus.IDLE && txStatus == TxStatus.IDLE) {
			return Double.MAX_VALUE;
		}
		
		if (rxStatus == RxStatus.SEND_HAS_SPACE || txStatus == TxStatus.SEND_HAS_TOKENS) {
			return 0;
		}

		if (rxStatus == RxStatus.RECEIVING && txStatus == TxStatus.SENDING) {
			return Math.min(getCkIn(), getCkOut());
		}

		if (rxStatus == RxStatus.RECEIVING) {
			return 0.1 + (0.5 - 0.1) * random.nextDouble();//getCkIn();
		}

		if (txStatus == TxStatus.SENDING) {
			return 0.1 + (0.5 - 0.1) * random.nextDouble();//getCkOut();
		}
		
		if (rxStatus == RxStatus.END_RECEIVING || txStatus == TxStatus.END_SENDING) {
			return 0;
		}

		return Double.MAX_VALUE;
	}
	
	private int hasSpace(int numTokens) {
		// if > 0 -> number of tokens that didn't fit
		if (tokensInFifo + rxTokens + numTokens > maxTokensInFifo) {
			maxTokensInFifo = tokensInFifo + rxTokens + numTokens;
		}
		int missingSpace = tokensInFifo + rxTokens + numTokens - size;
		return missingSpace;
	}

	private boolean hasTokens(int numTokens) {
		return tokensInFifo >= numTokens;
	}
	
	private double getCkIn() {
		return ckIn;
	}
	
	private double getCkOut() {
		return ckOut;
	}

	public Buffer getBuffer() {
		return buffer;
	}
	
	/*
	 * Calculate a weighted average for all latencies profiled
	 */
	public void setReadCommunicationCost(List<MemoryAccess> rcc) {
		this.readCommunicationCost = rcc;
		if (readCommunicationCost != null) {
			for (MemoryAccess ma : rcc) {
				if (ma.getMode().equals("read")) {
					ckIn += ma.getPercentage() * ma.getLatency();
				}
			}
		}
	}
	
	public void setWriteConstants(int writeHit, int writeMiss) {
		this.writeHitLatency = writeHit;
		this.writeMissLatency = writeMiss;
	}
	
	/*
	 * Calculate a weighted average for hits and misses and constants defined
	 */
	public void setWriteCommunicationCost(List<MemoryAccess> wcc) {
		this.writeCommunicationCost = wcc;
		if (writeCommunicationCost != null) {
			for (MemoryAccess ma : wcc) {
				if (ma.getMode().equals("write")) {
					if (ma.getType().equals("hit"))
						ckOut += ma.getPercentage() * writeHitLatency;
					else if (ma.getType().equals("miss"))
						ckOut += ma.getPercentage() * writeMissLatency;
				}
			}
		}
	}
	
	public int getMaxTokensInFifo() {
		return maxTokensInFifo;
	}
}

package turnus.adevs.model;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import adevs.Atomic;
import adevs.Digraph.PortValue;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.model.dataflow.Buffer;
import turnus.model.mapping.data.MemoryAccess;

public class AtomicSingleBufferPartition extends Atomic<PortValue> {
	
	public static final int PORT_OUT_SEND_ENABLE_RX = 24;
	public static final int PORT_OUT_SEND_ENABLE_TX = 25;
	
	public static final int PORT_IN_RECEIVE_RX = 26;
	public static final int PORT_IN_RECEIVE_TX = 27;
	
	public enum RxStatus {
		IDLE, SEND_ENABLE, SEND_DISABLE, WAIT;
	}

	public enum TxStatus {
		IDLE, SEND_ENABLE, SEND_DISABLE, WAIT;
	}
	
	private RxStatus rxStatus;
	private TxStatus txStatus;

	@SuppressWarnings("unused")
	private double localTime;
	
	
	/** the data logger */
	@SuppressWarnings("unused")
	private AdevsDataLogger dataLogger;
	
	/**
	 * values of communication cost (latency and percentage) from profiling (if not
	 * specified, the default values of ckIn and ckOut will be taken)
	 */
	private List<MemoryAccess> readCommunicationCost;
	private List<MemoryAccess> writeCommunicationCost;
	/**
	 * constant latencies for hit or miss for writes (write latencies are not
	 * reported by numap!) considered only if the communication costs are specified
	 */
	@SuppressWarnings("unused")
	private int writeHitLatency;
	@SuppressWarnings("unused")
	private int writeMissLatency;

	/** the input clock */
	private double ckIn = 0;
	/** the output clock */
	private double ckOut = 0;

	/** the buffer */
	private Buffer buffer;
	
	private Random random;
	
	
	
	public AtomicSingleBufferPartition(Buffer buffer) {
		this.buffer = buffer;
		rxStatus = RxStatus.SEND_ENABLE;
		txStatus = TxStatus.SEND_DISABLE;
		
		
		random = new Random();
		localTime = 0.0;
	}
	
	
	@Override
	public void delta_conf(Collection<PortValue> xb) {
		delta_int();
		delta_ext(0.0, xb);
	}
	
	
	@Override
	public void delta_int() {
		switch (rxStatus) {
		case SEND_ENABLE:
			rxStatus = RxStatus.IDLE;
			break;
		default:
			break;
		}

		switch (txStatus) {
		case WAIT:
			txStatus = TxStatus.SEND_ENABLE;
			break;
		default:
			break;
		}
		
	}

	@Override
	public void delta_ext(double e, Collection<PortValue> xb) {
		localTime += e;
		
		for (PortValue inPortValue : xb) {
			switch (inPortValue.getPort()) {
			case PORT_IN_RECEIVE_RX:
				txStatus = TxStatus.WAIT;
				break;
			
			case PORT_IN_RECEIVE_TX:
				txStatus = TxStatus.SEND_DISABLE;
                break;
            }
		}
	}

	@Override
	public void output_func(Collection<PortValue> yb) {
		switch (rxStatus) {
		case SEND_ENABLE:
			yb.add(new PortValue(PORT_OUT_SEND_ENABLE_RX, true));
			break;
		default:
			break;
		}

		switch (txStatus) {
		case SEND_DISABLE:
			yb.add(new PortValue(PORT_OUT_SEND_ENABLE_TX, false));
			
			txStatus = TxStatus.IDLE;
			break;
		case SEND_ENABLE:
			yb.add(new PortValue(PORT_OUT_SEND_ENABLE_TX, true));
			txStatus = TxStatus.IDLE;
			break;
		default:
			break;
		}
		
	}

	@Override
	public double ta() {
		if (rxStatus == RxStatus.IDLE && txStatus == TxStatus.IDLE) {
			return Double.MAX_VALUE;
		}

		if (rxStatus == RxStatus.SEND_ENABLE) {
			return 0;
		}

		if (txStatus == TxStatus.SEND_ENABLE) {
			return 0;
		}

		if (rxStatus == RxStatus.WAIT) {
			return getCkIn();
		}	
		
		if (txStatus == TxStatus.WAIT) {
			return getCkOut();
		}	
		
		return Double.MAX_VALUE;
	}

	private double getCkIn() {
		if (ckIn == 0.0)
			return 0.1 + (0.5 - 0.1) * random.nextDouble();
		return ckIn;
	}

	private double getCkOut() {
		if (ckOut == 0.0)
			return 0.1 + (0.5 - 0.1) * random.nextDouble();
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
					ckOut += ma.getPercentage() * ma.getLatency();
					/*
					 * if (ma.getType().equals("hit")) ckOut += ma.getPercentage() *
					 * writeHitLatency; else if (ma.getType().equals("miss")) ckOut +=
					 * ma.getPercentage() * writeMissLatency;
					 */
				}
			}
		}
	}
	
	
	public void setDataLogger(AdevsDataLogger dataLogger) {
		this.dataLogger = dataLogger;
	}

	public RxStatus getRxStatus() {
		return rxStatus;
	}

	public TxStatus getTxStatus() {
		return txStatus;
	}
	
}

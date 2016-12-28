package jcip.chap7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducer extends Thread{
	private final BlockingQueue<BigInteger> queue;
	private volatile boolean cancelled = false;
	
	public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try{
			BigInteger p = BigInteger.ONE;
			while(!cancelled){
				queue.put(p = p.nextProbablePrime());
			}
		}catch(InterruptedException e){
			
		}
	}

	public void cancel(){ this.cancelled = true;}
}

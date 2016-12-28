package jcip.chap7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread{
	private final BlockingQueue<BigInteger> queue;

	public PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try{
			BigInteger p = BigInteger.ONE;
			while(!Thread.currentThread().isInterrupted()){
				queue.put(p.nextProbablePrime());
			}
		}catch(InterruptedException e){
			//TODO: 允许线程退出
		}
	}
	
	public void cancel(){
		interrupt();
	}
}

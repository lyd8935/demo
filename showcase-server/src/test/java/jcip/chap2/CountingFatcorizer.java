package jcip.chap2;

import java.util.concurrent.atomic.AtomicLong;

import jcip.ThreadSafe;

@ThreadSafe
public class CountingFatcorizer {
	private final AtomicLong count = new AtomicLong(0);
	
	public long getCount(){ 
		return count.get();
	}
	
	public void addCount(){
		count.incrementAndGet();
	}
}

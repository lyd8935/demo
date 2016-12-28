package jcip.chap1;

import jcip.GuardedBy;
import jcip.ThreadSafe;

@ThreadSafe
public class Sequence {
	@GuardedBy("this") 
	private int value;
	
	public synchronized int getValue(){
		return value++;
	}
}

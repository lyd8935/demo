package jcip.chap1;

import jcip.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
	private int value;
	
	/** 返回一个唯一的数值 */
	public int getNext(){
		return value++;
	}
}

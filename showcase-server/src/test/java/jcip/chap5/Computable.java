package jcip.chap5;

public interface Computable<A, V>{
	
	public V compute(A arg) throws InterruptedException;
}
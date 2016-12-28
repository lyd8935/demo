package jcip.chap2;

public class Widget {
	public synchronized void doSomething(){
		System.out.println("Widget.doSomething");
	}
}

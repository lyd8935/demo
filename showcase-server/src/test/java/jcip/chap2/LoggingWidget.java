package jcip.chap2;

public class LoggingWidget extends Widget{
	@Override
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
	
	public static void main(String[] args) {
		LoggingWidget widget = new LoggingWidget();
		widget.doSomething();
	}
}

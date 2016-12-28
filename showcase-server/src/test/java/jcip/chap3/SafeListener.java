package jcip.chap3;


public class SafeListener {
	private final EventListener listener;
	
	private SafeListener(){
		listener = new EventListener() {
			@Override
			public void onEvent(Event e) {
				doSomething(e);
			}
		};
	}
	
	public static SafeListener newInstance(EventSource source){
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}
	
	
	public void doSomething(Event e){
	}
	
	private interface EventSource{
		public void registerListener(EventListener e);
	}
	
	private interface EventListener {
		public void onEvent(Event e);
	}
	
	private interface Event{
	}
}

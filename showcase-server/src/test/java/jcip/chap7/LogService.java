package jcip.chap7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import jcip.GuardedBy;

public class LogService {
	private final BlockingQueue<String> queue;
	private final LoggerThread loggerThread;
	private final PrintWriter writer;
	@GuardedBy("this") 
	private boolean isShutdown;
    @GuardedBy("this") 
    private int reservations;
	
	public LogService(PrintWriter writer) {
		this.queue = new LinkedBlockingQueue<>();
		this.loggerThread = new LoggerThread();
		this.writer = writer;
	}
	
	public void log(String msg) throws InterruptedException{
		synchronized (this) {
			if(isShutdown){
				throw new IllegalStateException(/* ... */);
			}
			
			++reservations;
		}
	}
	
	public void start(){
		loggerThread.start();
	}
	
	public void stop(){
		synchronized (this) {
			isShutdown = true;
		}
		
		loggerThread.interrupt();
	}

	private class LoggerThread extends Thread{
		@Override
		public void run() {
			try{
				while(true){
					try{
						synchronized (LogService.this) {
							if(isShutdown && reservations == 0){
								break;
							}
						}
						
						String msg = queue.take();
						synchronized (LogService.this) {
							--reservations;
						}
						
						writer.println(msg);
					}catch(InterruptedException e){
						//TODO: retry
					}
				}
			}finally{
				writer.close();
			}
		}
	}
}
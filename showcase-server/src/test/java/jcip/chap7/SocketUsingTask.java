package jcip.chap7;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import jcip.GuardedBy;

public abstract class SocketUsingTask<T> implements CancellableTask<T>{
	@GuardedBy("this")
	private Socket socket;
	
	protected synchronized void setSocket(Socket s){
		socket = s;
	}
	
	public synchronized void cancel(){
		try{
			if(socket != null){
				socket.close();
			}
		}catch(IOException e){
			
		}
	}
		
	public RunnableFuture<T> newTask(){
		return new FutureTask<T>(this){
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				try{
					SocketUsingTask.this.cancel();
				}finally{
					return super.cancel(mayInterruptIfRunning);
				}
			}
		};
	}
}

interface CancellableTask<T> extends Callable<T>{
	void cancel();
	RunnableFuture<T> newTask();
}
package jcip.chap5;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer<A, V> implements Computable<A, V>{

	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;
	
	public Memoizer(Computable<A, V> c) {
		super();
		this.c = c;
	}

	@Override
	public V compute(A arg) throws InterruptedException {
		while(true){
			Future<V> f = cache.get(arg);
			if(f == null){
				Callable<V> eval = new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				
				FutureTask<V> ft = new FutureTask<>(eval);
				f = cache.putIfAbsent(arg, ft);
				if(f == null){
					f = ft;
					ft.run();
				}
			}
			
			try {
				return f.get();
			}catch(CancellationException e){
				cache.remove(arg, f);
			}catch(ExecutionException e) {
				throw LaunderThrowable.launderThrowable(e.getCause());
			}
		}
	}
	
}

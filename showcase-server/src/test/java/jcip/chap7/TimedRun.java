package jcip.chap7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimedRun {
	private static final ExecutorService taskExec = Executors.newCachedThreadPool();
	
	public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException{
		Future<?> task = taskExec.submit(r);
		
		try {
			task.get(timeout, unit);
		} catch (TimeoutException e) {
				// TODO 接下来任务被取消
		} catch (ExecutionException e) {
			// TODO 如果在任务中抛出了异常，那么重新抛出该异常
		} finally {
			//如果任务正在运行，那么将被中断
			task.cancel(true);
		}
	}
	
}
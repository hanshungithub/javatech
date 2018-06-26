package cn.hassan.thread.concurrent.t0511.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/11 8:24
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory();
		ExecutorService executorService = Executors.newCachedThreadPool(factory);

		executorService.execute(() -> System.out.println("Running ... " + System.currentTimeMillis() + " Thread Name is " + Thread.currentThread().getName()));
	}
}

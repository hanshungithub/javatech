package cn.hassan.thread.concurrent.t0515.t2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/16 8:11
 * Description:
 */
public class RunTwo {
	public static void main(String[] args) throws Exception {
		//线程工程
		ExecutorService executorService = Executors.newCachedThreadPool();
		//completion 获取线程的返回值
		ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);

		for (int i = 0; i < 10; i++) {
			completionService.submit(() -> {
				long sleepValue = (long) (Math.random() * 1000);
				System.out.println("sleep = " + sleepValue + " " + Thread.currentThread().getName());
				Thread.sleep(sleepValue);
				return "completion ---> " + sleepValue + " " + Thread.currentThread().getName();
			});
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(completionService.take().get());
		}
	}
}

package cn.hassan.thread.concurrent.t0515.t2;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/16 8:26
 * Description:
 */
public class RunThree {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);

		completionService.submit(() -> {
			Thread.sleep(3000);
			System.out.println("after 3 seconds");
			return "completion 3s";
		});

		for (int i = 0; i < 1; i++) {
			System.out.println(completionService.poll());
		}
	}
}

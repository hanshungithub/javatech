package cn.hassan.thread.concurrent.t0515.t2;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/16 8:34
 * Description:
 */
public class RunFour {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);

		completionService.submit(() -> {
			System.out.println("CallableA begin --->" + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println("CallableA end --->" + System.currentTimeMillis());
			return "returnA";
		});

		completionService.submit(() -> {
			System.out.println("CallableB begin --->" + System.currentTimeMillis());
			Thread.sleep(5000);
			int i = 0;
			if (i == 0) {
				throw new Exception("CallableB throw a execption");
			}
			System.out.println("CallableB end --->" + System.currentTimeMillis());
			return "ReturnB";
		});

		for (int i = 0; i < 2; i++) {
			System.out.println(completionService.take().get());
		}
	}
}

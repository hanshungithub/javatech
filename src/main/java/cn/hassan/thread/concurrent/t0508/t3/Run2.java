package cn.hassan.thread.concurrent.t0508.t3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/11 7:43
 * Description:
 */
public class Run2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++) {
			executorService.execute(() -> System.out.println("Run ..."));
		}
	}
}

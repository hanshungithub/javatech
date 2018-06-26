package cn.hassan.thread.concurrent.t0515.t3;

import java.util.concurrent.ForkJoinPool;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/17 7:23
 * Description:
 */
public class Run {
	public static void main(String[] args) throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(new MyRecursiveAction(1,10));
		Thread.sleep(5000);
	}
}

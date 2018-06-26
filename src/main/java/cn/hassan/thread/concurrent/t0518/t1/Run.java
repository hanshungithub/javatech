package cn.hassan.thread.concurrent.t0518.t1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/18 7:43
 * Description:
 */
public class Run {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		MyRecursiveTask task = new MyRecursiveTask(1, 20);
		ForkJoinTask<String> submit = pool.submit(task);
		System.out.println(submit.get());
	}
}

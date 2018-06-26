package cn.hassan.thread.concurrent.t0518.t2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/18 8:25
 * Description:
 */
public class Run {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		MyRecursiveTask task = new MyRecursiveTask(1, 10);
		ForkJoinTask<Integer> submit = pool.submit(task);
		System.out.println(submit.get());
	}


}

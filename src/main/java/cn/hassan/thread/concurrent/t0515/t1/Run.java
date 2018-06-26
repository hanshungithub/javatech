package cn.hassan.thread.concurrent.t0515.t1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/15 7:31
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		executor.execute(() ->{
			System.out.println("打印了! begin --->" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				System.out.println("打印了! end --->" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("A=" + executor.isShutdown());
		executor.shutdown();
		System.out.println("B=" + executor.isShutdown());
	}
}

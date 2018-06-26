package cn.hassan.thread.concurrent.t0508.t3;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/10 7:42
 * Description:
 */
public class Run {

	public static void main(String[] args) {
		Executor executor = Executors.newCachedThreadPool();

		executor.execute(() -> {
			try {
				System.out.println("Runnable begin" + System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("A");
				System.out.println("Runnable end" + System.currentTimeMillis());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		executor.execute(() ->{
			try {
				System.out.println("Runnable2 begin" + System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("B");
				System.out.println("Runnable2 end" + System.currentTimeMillis());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

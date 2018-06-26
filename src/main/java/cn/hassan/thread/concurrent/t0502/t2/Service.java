package cn.hassan.thread.concurrent.t0502.t2;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/2 8:18
 * Description:
 */
public class Service {

	private Semaphore semaphore = new Semaphore(1);

	public void testMethod() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "begin time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "end time = " + System.currentTimeMillis());
			semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

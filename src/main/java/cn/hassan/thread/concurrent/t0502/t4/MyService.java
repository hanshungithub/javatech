package cn.hassan.thread.concurrent.t0502.t4;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/4 7:38
 * Description:
 */
public class MyService {

	private CountDownLatch down = new CountDownLatch(1);

	public void testMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + "ready!");
			down.await();
			System.out.println(Thread.currentThread().getName() + "finish!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downMehtod() {
		System.out.println("start!");
		down.countDown();
	}
}

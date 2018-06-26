package cn.hassan.thread.concurrent.t0507.t1;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/7 8:38
 * Description:
 */
public class MyThread extends Thread {

	private CyclicBarrier barrier;

	public MyThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 10000));
			System.out.println(Thread.currentThread().getName() + "到了" + System.currentTimeMillis());
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

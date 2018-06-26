package cn.hassan.thread.concurrent.t0507.t1;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/7 8:43
 * Description:
 */
public class Run {
	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(5,() -> {
			System.out.println("全部到了！");
		});

		MyThread[] threads = new MyThread[5];
		for (int i = 0; i < 5; i++) {
			threads[i] = new MyThread(barrier);
		}
		for (int i = 0; i < 5; i++) {
			threads[i].start();
		}
	}
}

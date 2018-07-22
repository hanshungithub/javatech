package cn.hassan.thread.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with idea
 * Author: hss
 * Date: 7/20/2018 9:42 AM
 * Description:
 */
public class CyclicBarrierTest2 {

	private static CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println(3));

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				barrier.await();
				System.out.println(1);
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}).start();

		try {
			barrier.await();
			System.out.println(2);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

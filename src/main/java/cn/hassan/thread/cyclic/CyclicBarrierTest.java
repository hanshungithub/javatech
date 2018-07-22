package cn.hassan.thread.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with idea
 * Author: hss
 * Date: 7/20/2018 9:32 AM
 * Description:
 */
public class CyclicBarrierTest {
	private static CyclicBarrier barrier = new CyclicBarrier(2);

	public static void main(String[] args) {

		new Thread(() -> {
			try {
				barrier.await();
				System.out.println(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

		try {
			barrier.await();
			System.out.println(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

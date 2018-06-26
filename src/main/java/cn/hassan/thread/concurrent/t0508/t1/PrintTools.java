package cn.hassan.thread.concurrent.t0508.t1;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/8 8:25
 * Description:
 */
public class PrintTools {
	public static Phaser phaser;

	public static void methodA() {
		System.out.println(Thread.currentThread().getName() + "A1 begin = " + System.currentTimeMillis());
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + "A1 end = " + System.currentTimeMillis());
		System.out.println(Thread.currentThread().getName() + "A2 begin = " + System.currentTimeMillis());
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + "A2 end = " + System.currentTimeMillis());
	}

	public static void methodB() {
		try {
			System.out.println(Thread.currentThread().getName() + "A1 begin = " + System.currentTimeMillis());
			Thread.sleep(5000);
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName() + "A1 end = " + System.currentTimeMillis());
			System.out.println(Thread.currentThread().getName() + "A2 begin = " + System.currentTimeMillis());
			Thread.sleep(5000);
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName() + "A2 end = " + System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

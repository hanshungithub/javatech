package cn.hassan.thread.synchron.t1;


/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/5 7:29
 * Description: Junit单元测试不支持多线程
 */
public class SynchronizedTest3 {

	public static void main(String[] args) {
		/**
		 *  同一个锁的同步代码块同一时刻只能被一个线程访问
		 *  当同，步代码块都是同一个锁时方法可以被所有线程访问，但同一个锁的同步代码块同一时刻只能被一个线程访问
		 */
		SynchronizedDemo synDemo = new SynchronizedDemo();

		Thread thread1 = new Thread(() -> {
			synDemo.chunkMethod();
			synDemo.synMethod2();
		});

		Thread thread2 = new Thread(() -> {
			//调用同步块方法
			synDemo.chunkMethod();
			synDemo.synMethod2();
		});
		thread1.start();
		thread2.start();
	}
}

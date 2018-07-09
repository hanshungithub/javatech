package cn.hassan.thread.reentrantLock.t1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/6 8:31
 * Description:
 */
public class ReetrantLockDemo {

	public static void main(String[] args) {

		MyService servie = new MyService();

		Thread thread = new Thread(servie::testMethod);
		Thread thread1 = new Thread(servie::testMethod);

		thread.start();
		thread1.start();
	}

	private static class MyService {
		private Lock lock = new ReentrantLock();
		void testMethod() {
			lock.lock();
			for (int i = 0; i < 5; i++) {
				System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
			}
			lock.unlock();
		}
	}
}

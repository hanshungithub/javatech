package cn.hassan.thread.concurrent.t0423.t2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 7:44
 * Description:
 */
public class MyService {
	private static Lock lock = new ReentrantLock();

	public void testMethod() {
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("ThreadName --->" + Thread.currentThread().getName() + ("---" + (i + 1)));
		}
		lock.unlock();
	}
}

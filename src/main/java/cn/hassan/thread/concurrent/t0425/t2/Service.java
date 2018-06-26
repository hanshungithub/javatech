package cn.hassan.thread.concurrent.t0425.t2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/25 7:45
 * Description:
 */
public class Service {
	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethodOne() {
		try {
			lock.lock();
			System.out.println("serviceMethodTwo getHoldCount = " + lock.getHoldCount());
			serviceMethodTwo();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	private void serviceMethodTwo() {
		try {
			lock.lock();
			System.out.println("serviceMethodTwo getHoldCount = " + lock.getHoldCount());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

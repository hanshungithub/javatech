package cn.hassan.thread.concurrent.t0427.t1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/27 7:46
 * Description:
 */
public class Service {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void read() {
		try {
			try {
				lock.readLock().lock();
				System.out.println("get lock --->" +Thread.currentThread().getName() + " : " + System.currentTimeMillis());
				Thread.sleep(10000);
			}finally {
				lock.readLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

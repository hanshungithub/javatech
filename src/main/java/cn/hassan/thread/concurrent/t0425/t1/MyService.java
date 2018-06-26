package cn.hassan.thread.concurrent.t0425.t1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/25 7:24
 * Description:
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;

	public void set() {
		try {
			lock.lock();
			while (hasValue) {
				condition.await();
			}
			System.out.println("set print ***");
			hasValue = true;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void get() {
		try {
			lock.lock();
			while (!hasValue) {
				condition.await();
			}
			System.out.println("get print ***");
			hasValue = false;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

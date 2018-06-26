package cn.hassan.thread.concurrent.t0423.t3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 8:37
 * Description:
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("---enter---");
			System.out.println("await time --->" + System.currentTimeMillis());
			condition.await();
			System.out.println("---exit---");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("releaes lock");
		}
	}

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal time --->" + System.currentTimeMillis());
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

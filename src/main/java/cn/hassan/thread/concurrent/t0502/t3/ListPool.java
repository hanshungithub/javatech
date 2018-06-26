package cn.hassan.thread.concurrent.t0502.t3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/3 7:32
 * Description:
 */
public class ListPool {

	private int poolMaxSize = 3;
	private int semaphorePermits = 5;
	private List<String> list = new ArrayList<>();
	private Semaphore semaphore = new Semaphore(semaphorePermits);
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public ListPool() {
		super();
		for (int i = 0; i < poolMaxSize; i++) {
			list.add("semaphore" + (i + 1));
		}
	}

	public String get() {
		String getString = null;
		try {
			semaphore.acquire();
			lock.lock();
			while (list.size() == 0) {
				condition.await();
			}
			getString = list.remove(0);
			lock.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getString;
	}

	public void set(String value) {
		lock.lock();
		list.add(value);
		condition.signalAll();
		lock.unlock();
		semaphore.release();
	}
}

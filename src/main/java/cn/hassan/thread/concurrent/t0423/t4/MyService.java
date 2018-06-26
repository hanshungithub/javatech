package cn.hassan.thread.concurrent.t0423.t4;

import java.awt.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/24 7:49
 * Description:
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	public Condition conditionA = lock.newCondition();
	public Condition conditionB = lock.newCondition();

	public void awaitA() {
		try {
			lock.lock();
			System.out.println("begin awaitA time is --->" + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA time is --->" + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void awaitB() {
		try {
			lock.lock();
			System.out.println("begin awaitB time is --->" + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
			conditionB.await();
			System.out.println("end awaitB time is --->" + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void signalA() {
		try {
			lock.lock();
			System.out.println("signal all A time is ---> " + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
			conditionA.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void signalB() {
		try {
			lock.lock();
			System.out.println("signal all B time is ---> " + System.currentTimeMillis() + " ; " + "ThreadName = " + Thread.currentThread().getName());
			conditionB.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

package cn.hassan.thread.concurrent.t0416.t1;

public class ThreadA extends Thread {

	private Object lock;

	public ThreadA(Object object) {
		this.lock = object;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				if (Mylist.size() != 5) {
					System.out.println("wait begin " + System.currentTimeMillis());
					lock.wait();
					System.out.println("wait end" + System.currentTimeMillis());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

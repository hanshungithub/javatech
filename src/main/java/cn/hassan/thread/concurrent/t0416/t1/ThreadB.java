package cn.hassan.thread.concurrent.t0416.t1;

public class ThreadB extends Thread {
	private Object lock;

	public ThreadB(Object object) {
		this.lock = object;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					Mylist.add();
					if (Mylist.size() == 5) {
						lock.notify();
						System.out.println("already notify");
					}
					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

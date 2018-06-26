package cn.hassan.thread.concurrent.t0417.t2;

public class ThreadA extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				Tools.local.set("ThreadA ---> " + (i + 1));
				System.out.println("ThreadA get value ---> " + Tools.local.get());
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

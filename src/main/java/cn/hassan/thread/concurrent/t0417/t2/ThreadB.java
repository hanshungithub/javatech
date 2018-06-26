package cn.hassan.thread.concurrent.t0417.t2;

public class ThreadB extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				Tools.local.set("ThreadB ---> " + (i + 1));
				System.out.println("ThreadB get value ---> " + Tools.local.get());
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

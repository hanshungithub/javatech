package cn.hassan.thread.concurrent.t1;

public class ThreadTwo extends Thread {
	private int count = 5;

	@Override
	synchronized public void run() {
		super.run();
		count--;
		System.out.println("由"+Thread.currentThread().getName()+"计算 count --->" + count);
	}
}

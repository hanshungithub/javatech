package cn.hassan.thread.concurrent.t1;

public class ThreadOne extends Thread {

	@Override
	synchronized public void run() {
		int count = 5;
		super.run();
		count--;
		System.out.println("由"+Thread.currentThread().getName()+"计算count ---> " + count);
	}
}

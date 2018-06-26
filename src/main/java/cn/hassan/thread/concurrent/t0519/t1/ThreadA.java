package cn.hassan.thread.concurrent.t0519.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/19 10:05
 * Description:
 */
public class ThreadA extends Thread {

	private MyServiceOne serviceOne;

	public ThreadA(MyServiceOne serviceOne) {
		this.serviceOne = serviceOne;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50000; i++) {
			serviceOne.map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
			System.out.println("ThreadA" + (i + 1));
		}
	}
}

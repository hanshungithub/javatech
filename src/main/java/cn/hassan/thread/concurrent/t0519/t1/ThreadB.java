package cn.hassan.thread.concurrent.t0519.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/19 10:07
 * Description:
 */
public class ThreadB extends Thread {

	private MyServiceOne serviceOne;

	public ThreadB(MyServiceOne serviceOne) {
		this.serviceOne = serviceOne;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50000; i++) {
			serviceOne.map.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
			System.out.println("ThreadB" + (i + 1));
		}
	}
}

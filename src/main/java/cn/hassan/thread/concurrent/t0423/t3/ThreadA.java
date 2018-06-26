package cn.hassan.thread.concurrent.t0423.t3;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/24 7:29
 * Description:
 */
public class ThreadA extends Thread {
	private MyService myService;

	public ThreadA(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.await();
	}
}
